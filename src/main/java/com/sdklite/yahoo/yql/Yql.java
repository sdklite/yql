package com.sdklite.yahoo.yql;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class Yql {

    private static final String API = "https://query.yahooapis.com/v1/public/yql";

    public class Result<T extends Serializable> implements Serializable {

        private static final long serialVersionUID = -4546670868947595721L;

        @SerializedName("query")
        private Query<T> query;

        public Query<T> getQuery() {
            return this.query;
        }

    }

    public class Query<T extends Serializable> implements Serializable {

        private static final long serialVersionUID = -7243607601508149397L;

        @SerializedName("results")
        private T results;

        @SerializedName("lang")
        private String language;

        public T getResults() {
            return this.results;
        }

        public String getLanguage() {
            return language;
        }

    }

    public static abstract class Callback<T extends Result<? extends Serializable>> {

        final Type type;

        public Callback() {
            final Type superclass = getClass().getGenericSuperclass();
            if (superclass instanceof Class) {
              throw new RuntimeException("Missing type parameter.");
            }

            this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        }

        public Type getType() {
            return this.type;
        }

        public abstract void onSuccess(T result);
        
        public abstract void onFailure(final YqlException e);

    }

    private static final class SingletonHolder {
        private static final Yql INSTANCE = new Yql() {};
    }

    public static Yql getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final OkHttpClient client = new OkHttpClient();

    private final Gson gson = new GsonBuilder().create();

    private Yql() {
    }

    public <T extends Serializable> void query(final String yql, final Callback<Result<T>> callback) {
        final HttpUrl url = HttpUrl.parse(API).newBuilder().addQueryParameter("q", yql).addQueryParameter("format", "json").build();
        System.out.println(url);
        final Request request = new Request.Builder().url(url).build();
        this.client.newCall(request).enqueue(new okhttp3.Callback() {
            public void onFailure(final Call call, final IOException e) {
                if (null != callback) {
                    callback.onFailure(new YqlException(e));
                }
            }

            public void onResponse(final Call call, final Response resp) throws IOException {
                if (null != callback) {
                    final Result<T> result = gson.fromJson(resp.body().charStream(), callback.getType());
                    callback.onSuccess(result);
                }
            }
        });
    }
}

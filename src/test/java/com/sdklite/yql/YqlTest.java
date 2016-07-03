package com.sdklite.yql;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.sdklite.yahoo.yql.Weather;
import com.sdklite.yahoo.yql.Weather.Forecast;
import com.sdklite.yahoo.yql.Yql;
import com.sdklite.yahoo.yql.YqlException;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 21)
public class YqlTest {

    private static final String YQL = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"北京\") and u=\"c\"";

    @Test
    public void query() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);
        Yql.getInstance().query(YQL, new Yql.Callback<Yql.Result<Weather.Forecast>>() {

            public void onSuccess(final Yql.Result<Forecast> result) {
                assertNotNull(result);

                final Yql.Query<Weather.Forecast> query = result.getQuery();
                assertNotNull(query);

                final Weather.Forecast forecast = query.getResults();
                assertNotNull(forecast);

                final Weather.Channel channel = forecast.getChannel();
                assertNotNull(channel);

                final Weather.Conditions conditions = channel.getConditions();
                assertNotNull(conditions);

                final Weather.Condition condition = conditions.getCondition();
                assertNotNull(condition);

                System.out.println(condition.getDate());
                System.out.println(condition.getTemperature());
                System.out.println(condition.getCode());
                System.out.println(condition.getText());

                final List<Weather.Condition> forecasts = conditions.getForecasts();
                assertNotNull(forecasts);
                assertTrue(forecasts.size() > 0);
                signal.countDown();
            }

            public void onFailure(final YqlException e) {
                fail(e.getMessage());
                signal.countDown();
            }
        });

        signal.await();
    }
}

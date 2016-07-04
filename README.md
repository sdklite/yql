## YQL

YQL SDK is a useful library to access YaHoo public services via YQL (Yahoo Query Language)

## Usage

### Maven

```xml
<dependency>
    <groupId>com.sdklite.yql</groupId>
    <artifactId>yql</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Gradle

```gradle
compile 'com.sdklite.yql:yql:0.0.1'
```

### Example

```java
final String YQL = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"北京\") and u=\"c\"";

Yql.getInstance().query(YQL, new Yql.Callback<Yql.Result<Weather.Forecast>>() {

    public void onSuccess(final Yql.Result<Forecast> result) {
        final Yql.Query<Weather.Forecast> query = result.getQuery().getResults().getChannel().getConditions().getCondition();

        System.out.println(condition.getDate());
        System.out.println(condition.getTemperature());
        System.out.println(condition.getCode());
        System.out.println(condition.getText());
    }

    public void onFailure(final YqlException e) {
        e.printStackTrace();
    }

});
```

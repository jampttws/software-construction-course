package lec10observer.weatherorama.ver1;

public class Main {

    public static void main(String[] args) {
        // subject
        WeatherData data = new WeatherData();

        // observers
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        HumidityAverageDisplay humaidityAverageDisplay = new HumidityAverageDisplay();

        // connect subject and observers
        data.registerObserver(currentConditionDisplay);
        data.registerObserver(statisticsDisplay);
        data.registerObserver(humaidityAverageDisplay);
        data.registerObserver(forecastDisplay);

        // input receives new data from a user via System.in
        // whenever a user inputs new data, all observers are
        // updated
        InputUI inputUI = new InputUI();
        inputUI.receive(data);
    }
}

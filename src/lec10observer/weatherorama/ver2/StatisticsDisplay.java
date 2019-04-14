package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

    private double prevTemp;
    private double prevWave;

    private JFrame frame;
    private JTextArea landArea;
    private JTextArea oceanArea;

    public StatisticsDisplay() {

        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Average Condition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        landArea = new JTextArea(200, 200);
        frame.add(landArea);
        landArea.setBackground(Color.ORANGE);
        landArea.setText("Weather Condition:\n");

        oceanArea = new JTextArea(200, 200);
        frame.add(oceanArea);
        oceanArea.setBackground(Color.pink);
        oceanArea.setText("Ocean Wave Condition:\n");


    }

    @Override
    public void update(Subject data) {
        if (data instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) data;

            if (prevTemp == 0)
                prevTemp = weatherData.getTemperature();
            double avgTemp = (prevTemp + weatherData.getTemperature()) / 2;
            prevTemp = avgTemp;

            landArea.setBackground(Color.ORANGE);
            landArea.setText("Average Condition:\n");
            landArea.append("Temperature = " + avgTemp);
        }
        if (data instanceof OceanData) {
            OceanData oceanData = (OceanData) data;

            if (prevWave == 0)
                prevWave = oceanData.getWaveHeight();
            double avgWave = (prevWave + oceanData.getWaveHeight()) / 2;
            prevWave = avgWave;

            landArea.setBackground(Color.pink);
            landArea.setText("Average Wave Condition:\n");
            landArea.append("Wave Height = " + avgWave);
        }
    }
}

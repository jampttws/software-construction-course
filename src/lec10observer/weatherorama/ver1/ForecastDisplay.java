package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class ForecastDisplay implements Observer{

    private JFrame frame;
    private JTextArea area;

    private double pTemp;
    private int count = 1;

    public ForecastDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Forecast Temperature");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.yellow);
        area.setText("Forecast Temperature:\n\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        double avg = 0;
        if (pTemp == 0) avg = temp;
        else {
            avg = (pTemp + temp) / count;
        }
        pTemp += temp;
        count++;
        area.setBackground(Color.yellow);
        area.setText("Forecast Temperature: \n");
        area.append("Temperature: " + avg);
    }
}

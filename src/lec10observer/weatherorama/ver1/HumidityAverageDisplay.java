package lec10observer.weatherorama.ver1;

import javax.swing.*;
import java.awt.*;

public class HumidityAverageDisplay implements Observer {

    private JFrame frame;
    private JTextArea area;

    private double pHumid;
    private int count = 1;

    public HumidityAverageDisplay() {
        frame = new JFrame();
        frame.setSize(200, 200);
        frame.setTitle("Humidity Average");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        area = new JTextArea(150, 150);
        frame.add(area);
        area.setBackground(Color.cyan);
        area.setText("Humidity Average:\n\n");
    }

    @Override
    public void update(double temp, double humid, double pressure) {
        double avg = 0;
        if (pHumid == 0) avg = humid;
        else {
            avg = (pHumid + humid) / count;
        }
        pHumid += humid;
        count++;
        area.setBackground(Color.cyan);
        area.setText("Humidity Average: \n");
        area.append("Humidity: " + avg);

    }

}

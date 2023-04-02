import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class lab3_GUI extends JFrame {
    public lab3_GUI() {
        create();
    }

    public void create()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel arrayInput = new JLabel("Введите целочисленный массив (через пробел):");
        panel.add(arrayInput);

        JTextField array = new JTextField();
        array.setColumns(23);
        panel.add(array);

        JButton calculation = new JButton("Отсортировать");
        panel.add(calculation);

        JLabel sortInput = new JLabel("Отсортированный массив:");
        panel.add(sortInput);

        JLabel output = new JLabel("[массив] ");
        panel.add(output);

        calculation.addActionListener(new Action() {public void actionPerformed(ActionEvent e)
        {
            String[] st = array.getText().split(" ");
            int[] arrayInt = new int[st.length];

            for (int i = 0; i < arrayInt.length; i++)
                arrayInt[i] = Integer.parseInt(st[i]);

            Main main = new Main();
            main.sortByCount(arrayInt);

            output.setText(Arrays.toString(arrayInt));

        }});

        getContentPane().add(panel);
        setPreferredSize(new Dimension(700, 300));
    }

    public class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }
    private JButton calculation;
    private JLabel arrayInput;
    private JLabel sortArray;
    private JTextField array;
    private JLabel output;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                lab3_GUI fr = new lab3_GUI();
                fr.pack();
                fr.setLocationRelativeTo(null);
                fr.setVisible(true);
            }
        });
    }
}
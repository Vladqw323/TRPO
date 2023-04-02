import javax.swing.*;
import javax.swing.event.ChangeEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class lab1_GUI extends JFrame  {
    ArrayList<Houseplants> houseplants = new ArrayList();
    Repos_lab5 repos = new Repos_lab5(houseplants);
    public lab1_GUI() {
        create();
    }

    public void create() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel nameText = new JLabel("Название");
        panel.add(nameText);

        JTextField nameInput = new JTextField();
        nameInput.setColumns(23);
        panel.add(nameInput);

        JLabel heightText = new JLabel("Высота");
        panel.add(heightText);

        JTextField heightInput = new JTextField();
        heightInput.setColumns(23);
        panel.add(heightInput);

        JLabel lifeTimeText = new JLabel("Время жизни");
        panel.add(lifeTimeText);

        JTextField lifeTimeInput = new JTextField();
        lifeTimeInput.setColumns(23);
        panel.add(lifeTimeInput);

        JLabel typeText = new JLabel("Тип");
        panel.add(typeText);

        String[] items = { "Beautiful Blooming", "Ferns", "Succulents"};
        JComboBox typeInput = new JComboBox(items);
        panel.add(typeInput);

        JLabel prNameText = new JLabel("Новое имя");
        panel.add(prNameText);

        JTextField prNameInput = new JTextField();
        prNameInput.setColumns(23);
        panel.add(prNameInput);

        JLabel indexText = new JLabel();
        panel.add(indexText);

        JSpinner indexInput = new JSpinner();
        panel.add(indexInput);

        JButton addButton = new JButton("Добавить");
        panel.add(addButton);

        JButton editButton = new JButton("Изменить");
        panel.add(editButton);

        JButton deleteButton = new JButton("Удалить");
        panel.add(deleteButton);

        JLabel allObject = new JLabel("Список объектов");
        panel.add(allObject);

        JComboBox comboData = new JComboBox();
        panel.add(comboData);

        JLabel centerInfo= new JLabel("Информация");
        panel.add(centerInfo);

        addButton.addActionListener(new Action() {
            public void actionPerformed(ActionEvent e)
            {
                if(nameInput.getText().replaceAll(" ","").length() > 0 && lifeTimeInput.getText().replaceAll(" ","").length() > 0 && heightInput.getText().replaceAll(" ","").length() > 0) {
                    if (typeInput.getSelectedItem() == "Beautiful Blooming")
                        repos.addPlant(nameInput.getText(), Double.parseDouble(heightInput.getText()), Integer.parseInt(lifeTimeInput.getText()));
                    else if (typeInput.getSelectedItem() == "Ferns")
                        repos.addPlant(nameInput.getText(), Double.parseDouble(heightInput.getText()), Integer.parseInt(lifeTimeInput.getText()));
                    else if (typeInput.getSelectedItem() == "Succulents")
                        repos.addPlant(nameInput.getText(), Double.parseDouble(heightInput.getText()), Integer.parseInt(lifeTimeInput.getText()));

                    centerInfo.setText("Была добавлена запись: " +nameInput.getText()+ " "+heightInput.getText()+" "+lifeTimeInput.getText()+" типа "+typeInput.getSelectedItem());

                    comboData.removeAllItems();
/*                    houseplants.removeAll(houseplants);
                    houseplants.addAll(repos.getArray());*/

                    for (Houseplants houseplant : houseplants)
                        comboData.addItem(houseplant.name + " " + houseplant.height + " " + houseplant.lifeTime);

                }
                else
                    centerInfo.setText("Не удалось добавить запись, проверьте введенные поля");
            }
        });

        editButton.addActionListener(new Action() {
            public void actionPerformed(ActionEvent e) {
                if(nameInput.getText().replaceAll(" ","").length() > 0 && prNameInput.getText().replaceAll(" ","").length() > 0){
                    if (typeInput.getSelectedItem() == "Beautiful Blooming")
                        repos.changePlant(nameInput.getText(), prNameInput.getText(), (int)indexInput.getValue());
                    else if (typeInput.getSelectedItem() == "Ferns")
                        repos.changePlant(nameInput.getText(), prNameInput.getText(), (int)indexInput.getValue());
                    else if (typeInput.getSelectedItem() == "Succulents")
                        repos.changePlant(nameInput.getText(), prNameInput.getText(), (int)indexInput.getValue());

                    centerInfo.setText("Изменение на запись: " +prNameInput.getText()+ " "+heightInput.getText()+" "+lifeTimeInput.getText()+" типа "+typeInput.getSelectedItem());
                    comboData.removeAllItems();
/*                    houseplants.removeAll(houseplants);
                    houseplants.addAll(repos.getArray());*/

                    for (Houseplants houseplant : houseplants)
                        comboData.addItem(houseplant.name + " " + houseplant.height + " " + houseplant.lifeTime);
                } else
                    centerInfo.setText("Не удалось добавить запись, проверьте введенные поля");
            }
        });
        deleteButton.addActionListener(new Action() {public void actionPerformed(ActionEvent e) {

            repos.deletePlant((int) indexInput.getValue());

            comboData.removeAllItems();
/*            houseplants.removeAll(houseplants);
            houseplants.addAll(repos.getArray());*/

            for (Houseplants houseplant : houseplants)
                comboData.addItem(houseplant.name + " " + houseplant.height + " " + houseplant.lifeTime);
        }});
        comboData.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // проверяем, изменился ли выбранный элемент
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // код, который будет выполнен при изменении выбранного элемента JComboBox
                    int count = comboData.getSelectedIndex();
                    nameInput.setText(houseplants.get(count).name);
                    heightInput.setText(houseplants.get(count).height.toString());
                    lifeTimeInput.setText(houseplants.get(count).lifeTime.toString());
                    indexInput.setValue(count);
                }
            }
        });

        getContentPane().add(panel);
        setPreferredSize(new Dimension(1620, 300));

    }
    public class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField name;
    private JTextField heightInput;
    private JTextField lifeTimeInput;
    private JTextField prNameInput;
    private JSpinner indexInput;
    private JComboBox comboData;
    private JLabel centerInfo;
    private JTextField nameInput;
    private JComboBox typeInput;
    private JLabel nameText;
    private JLabel heightText;
    private JLabel lifeTimeText;
    private JLabel typeText;
    private JLabel prNameText;
    private JLabel indexText;
    private JLabel allObject;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                lab1_GUI fr = new lab1_GUI();
                fr.pack();
                fr.setLocationRelativeTo(null);
                fr.setVisible(true);
            }
        });
    }
}
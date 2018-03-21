/*
 * @Group Project: Hasibul Islam, Tashin Alam and Shakir Chowdhury
 */
//import statement
import java.awt.*;
import java.awt.Window.Type;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;

public class GameGUI {

    private JFrame frmSimulator;
    private JTextField txtDuration;
    private JTextField txtDay;
    private JTextField[] txtCount = new JTextField[3];
    private JLabel[][] grid = new JLabel[GameGrid.MAX][GameGrid.MAX];
    private JList messageList = new JList();
    GameController gc;

    public static void main(String[] args) {
        try {
            GameGUI window = new GameGUI();
            window.frmSimulator.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public GameGUI() {
        initialize();

        gc = new GameController();
        update();
    }

    private void update() {
        for(int i=0; i< 20; i++) {
            for(int j=0; j<20; j++) {
                if(gc.getGameGrid().grid[i][j].getType().equals("carnivore")) {
                    grid[i][j].setIcon(new ImageIcon("images/carnivore.png"));
                }
                else if(gc.getGameGrid().grid[i][j].getType().equals("herbivore")) {
                    grid[i][j].setIcon(new ImageIcon("images/herbivore.png"));
                }
                else if(gc.getGameGrid().grid[i][j].getType().equals("plant")) {
                    grid[i][j].setIcon(new ImageIcon("images/plant.png"));
                }

            }
        }

        txtDay.setText(Integer.toString(gc.getDuration()));
        txtCount[0].setText(Integer.toString(gc.getGameGrid().HerbivoreCount)); //Update Herbivores
        txtCount[1].setText(Integer.toString(gc.getGameGrid().CarnivoreCount)); //Update Carnivores
        txtCount[2].setText(Integer.toString(gc.getGameGrid().HerbivoreCount)); //Update Plants



    }
    private void initialize() {


        frmSimulator = new JFrame();
        frmSimulator.setTitle("Wildlife Simulator");
        frmSimulator.setType(Type.UTILITY);
        frmSimulator.setBounds(100, 100, 600, 476);
        frmSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSimulator.getContentPane().setLayout(null);

        JPanel gridPanel = new JPanel();
        gridPanel.setBackground(new Color(186,201,169));
        gridPanel.setBounds(0, 0, 400, 400);
        frmSimulator.getContentPane().add(gridPanel);
        gridPanel.setLayout(new GridLayout(20,20));



        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
        for (int i = 0; i < 20; i++){
            for (int j = 0; j <20; j++){
                grid[i][j] = new JLabel();
                grid[i][j].setBorder(border);
                grid[i][j].setOpaque(false);
                gridPanel.add(grid[i][j]);
            }
        }



        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(105,112,96));
        controlPanel.setBounds(0, 400, 400, 37);
        frmSimulator.getContentPane().add(controlPanel);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblDuration = new JLabel("Enter Duration:");
        lblDuration.setForeground(new Color(0, 0, 0));
        lblDuration.setFont(new Font("Tahoma", Font.BOLD, 11));
        controlPanel.add(lblDuration);

        txtDuration = new JTextField();
        txtDuration.setToolTipText("Enter how many days you would like to simulate.");
        txtDuration.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtDuration.setForeground(new Color(0, 0, 0));
        txtDuration.setBackground(new Color(192, 192, 192));
        txtDuration.setText("0");
        controlPanel.add(txtDuration);
        txtDuration.setColumns(3);

        JButton btnBegin = new JButton("Begin");
        btnBegin.setToolTipText("Press to begin the simulation.");
        btnBegin.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnBegin.setForeground(new Color(0, 0, 0));
        btnBegin.setBackground(new Color(192, 192, 192));
        btnBegin.addActionListener(e -> {
            try {
                gc.Begin();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        controlPanel.add(btnBegin);




        JButton btnReset = new JButton("Reset");
        btnReset.setToolTipText("Press to reset the simulation to its initial state.");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnReset.setForeground(new Color(0, 0, 0));
        btnReset.setBackground(new Color(192, 192, 192));
        btnReset.addActionListener(e -> gc.Reset());
        controlPanel.add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setToolTipText("Press to exit the simulator.");
        btnExit.addActionListener(e -> gc.Exit());

        btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnExit.setForeground(new Color(0, 0, 0));
        btnExit.setBackground(new Color(192, 192, 192));
        controlPanel.add(btnExit);


        JPanel countPanel = new JPanel();
        countPanel.setBounds(400, 324, 184, 113);
        frmSimulator.getContentPane().add(countPanel);
        countPanel.setBackground(new Color(105,112,96));
        countPanel.setLayout(null);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(10, 17, 164, 2);
        countPanel.add(sep2);

        JLabel lblHerbivore = new JLabel("Herbivores: ");
        lblHerbivore.setForeground(new Color(0, 0, 0));
        lblHerbivore.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblHerbivore.setHorizontalAlignment(SwingConstants.LEFT);
        lblHerbivore.setBounds(52, 26, 69, 14);
        countPanel.add(lblHerbivore);

        JLabel lblCarnivore = new JLabel("Carnivores:");
        lblCarnivore.setForeground(new Color(0, 0, 0));
        lblCarnivore.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCarnivore.setHorizontalAlignment(SwingConstants.LEFT);
        lblCarnivore.setBounds(52, 54, 66, 14);
        countPanel.add(lblCarnivore);

        JLabel lblPlants = new JLabel("Plants:");
        lblPlants.setForeground(new Color(0, 0, 0));
        lblPlants.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPlants.setHorizontalAlignment(SwingConstants.LEFT);
        lblPlants.setBounds(52, 83, 66, 14);
        countPanel.add(lblPlants);

        JSeparator sep5 = new JSeparator();
        sep5.setBounds(10, 102, 164, 2);
        countPanel.add(sep5);

        JSeparator sep3 = new JSeparator();
        sep3.setBounds(10, 45, 164, 2);
        countPanel.add(sep3);

        JSeparator sep4 = new JSeparator();
        sep4.setBounds(10, 73, 164, 2);
        countPanel.add(sep4);

        JLabel lblOrganismCount = new JLabel("Organism Count:");
        lblOrganismCount.setForeground(new Color(0, 0, 0));
        lblOrganismCount.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblOrganismCount.setHorizontalAlignment(SwingConstants.LEFT);
        lblOrganismCount.setBounds(10, 2, 101, 14);
        countPanel.add(lblOrganismCount);

        for(int i = 0; i<3; i++) {
            txtCount[i] = new JTextField();
            txtCount[i].setText("0");
            txtCount[i].setEditable(false);
            txtCount[i].setFont(new Font("Tahoma", Font.BOLD, 11));
            txtCount[i].setColumns(5);
            if(i==0) {
                txtCount[i].setBounds(120, 24, 25, 17);
                txtCount[i].setToolTipText("# of Herbivores on the grid.");
            }
            else if(i==1) {
                txtCount[i].setBounds(120, 51, 25, 17);
                txtCount[i].setToolTipText("# of Carnivores on the grid.");
            }

            else if(i==2) {
                txtCount[i].setBounds(120, 81, 25, 17);
                txtCount[i].setToolTipText("# of Plants on the grid.");
            }
            countPanel.add(txtCount[i]);
        }


        JLabel lblHerbIcon = new JLabel("");
        lblHerbIcon.setToolTipText("It's a cute fluffy squirrel!");
        lblHerbIcon.setIcon(new ImageIcon("images/herbivore.png"));
        lblHerbIcon.setBounds(21, 20, 24, 24);
        countPanel.add(lblHerbIcon);

        JLabel lblCarnIcon = new JLabel("");
        lblCarnIcon.setIcon(new ImageIcon("images/carnivore.png"));
        lblCarnIcon.setToolTipText("It's a big bad wolf!");
        lblCarnIcon.setBounds(21, 48, 24, 24);
        countPanel.add(lblCarnIcon);

        JLabel lblPlanIcon = new JLabel("");
        lblPlanIcon.setIcon(new ImageIcon("images/plant.png"));
        lblPlanIcon.setToolTipText("It's a nutritious plant!");
        lblPlanIcon.setBounds(21, 77, 24, 24);
        countPanel.add(lblPlanIcon);

        JPanel outputPanel = new JPanel();
        outputPanel.setBounds(400, 0, 184, 324);
        frmSimulator.getContentPane().add(outputPanel);
        outputPanel.setBackground(new Color(105,112,96));
        outputPanel.setLayout(null);

        /*
         * MessageQueue
         */



        messageList.setBackground(new Color(192, 192, 192));
        messageList.setBounds(10, 53, 164, 259);

        outputPanel.add(messageList);


        JLabel lblOutput = new JLabel("Output:");
        lblOutput.setForeground(new Color(0, 0, 0));
        lblOutput.setHorizontalAlignment(SwingConstants.LEFT);
        lblOutput.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblOutput.setBounds(10, 37, 61, 14);
        outputPanel.add(lblOutput);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(10, 321, 164, 2);
        outputPanel.add(sep1);

        JSeparator sep = new JSeparator();
        sep.setBounds(10, 32, 164, 2);
        outputPanel.add(sep);

        JLabel lblDay = new JLabel("Day: ");
        lblDay.setForeground(new Color(0, 0, 0));
        lblDay.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDay.setHorizontalAlignment(SwingConstants.LEFT);
        lblDay.setBounds(10, 7, 42, 25);
        outputPanel.add(lblDay);

        txtDay = new JTextField();
        txtDay.setHorizontalAlignment(SwingConstants.CENTER);
        txtDay.setToolTipText("# of Herbivores on the grid.");
        txtDay.setText("0");
        txtDay.setFont(new Font("Tahoma", Font.BOLD, 16));
        txtDay.setEditable(false);
        txtDay.setColumns(10);
        txtDay.setBounds(51, 7, 34, 23);
        outputPanel.add(txtDay);
    }
}

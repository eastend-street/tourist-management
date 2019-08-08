import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdminMainPage extends JFrame implements ActionListener {

    private JPanel p;
    private JButton TouristB;
    private JButton ActivityB;

    public AdminMainPage(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        this.setResizable(false);

        p = new JPanel();
        p.setBackground(Color.BLACK);
        p.setLayout(null);
        this.add(p);

        TouristB = new JButton("TouristList");
        TouristB.setBounds(150, 140, 200, 80);
        TouristB.addActionListener(this);
        p.add(TouristB);

        ActivityB = new JButton("ActivityList");
        ActivityB.setBounds(150, 230, 200, 80);
        ActivityB.addActionListener(this);

        p.add(ActivityB);



        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TouristB) {
            System.out.println("fefefe");
            p.setBackground(Color.ORANGE);
        } else if (e.getSource() == ActivityB) {
            System.out.println("GOOD");
            p.setBackground(Color.WHITE);
        }
    }
}

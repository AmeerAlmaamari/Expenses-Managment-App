import javax.swing.*;
import java.awt.*;

public class overview extends JPanel {
    public double spent = 0;   // make it = the value of the spent
    public double budget = 0; // make it = the value of the budget
    private JLabel label1 = new JLabel();//overall text
    private JLabel label2 = new JLabel();//month budget text
    private JLabel label3 = new JLabel();//spent value
    private JLabel label4 = new JLabel();//total spent text
    private JLabel label5 = new JLabel();//budget value
    private JPanel panel1 = new JPanel();//panel to hold all
    private JPanel panel2 = new JPanel();//overall text + separator
    private JPanel panel3 = new JPanel();//spent text & value + separator + month budget text & value
    private JSeparator s = new JSeparator();
    private JSeparator s1 = new JSeparator();
    public overview() {
        in();
    }

    public JPanel in(){
        panel1 = new JPanel();
        label1.setFont(new Font("Malgun Gothic Semilight", 1, 41)); // NOI18N
        label1.setText("OverAll");

        label2.setFont(new Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        //label2.setForeground(new Color(64, 191, 216));
        label2.setText("Month Budget");

        label3.setFont(new Font("Malgun Gothic Semilight", 1, 30)); // NOI18N
        label3.setForeground(new Color(64, 191, 216));
        label3.setText(Double.toString(spent));

        label4.setFont(new Font("Malgun Gothic Semilight", 1, 24)); // NOI18N
        label4.setText("Total Spent");
        //label4.setForeground(new Color(64, 191, 216));

        label5.setFont(new Font("Malgun Gothic Semilight", 1, 30)); // NOI18N
        label5.setForeground(new Color(64, 191, 216));
        label5.setText(Double.toString(budget));

        //testing
        //panel2.setLayout(new BorderLayout(0,30));
        GroupLayout group = new GroupLayout(panel3);
        panel3.setLayout(group);
        s.setOrientation(SwingConstants.HORIZONTAL);
        s1.setOrientation(SwingConstants.VERTICAL);
        s.setForeground(new Color(0,0,0));
        s1.setForeground(new Color(0,0,0));
        s.setBackground(new Color(0,0,0));
        s1.setBackground(new Color(10,10,10));
        //s.setBounds(0,479,470,40);
        panel2.add(label1);
        panel2.add(s);
        panel2.setLayout(new GridLayout(0,1,0,0));
        //label2.setBounds(150, 100, size.width, size.height);
        panel1.setLayout(new BorderLayout(0,0));
        group.setHorizontalGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(GroupLayout.Alignment.CENTER, group.createSequentialGroup()
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(group.createSequentialGroup().addGap(51, 51, 51).addComponent(label4))
                .addGroup(group.createSequentialGroup().addGap(61, 61, 61).addComponent(label3)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addComponent(s1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(label2)
                .addGroup(group.createSequentialGroup().addGap(5, 5, 5).addComponent(label5)))
                .addGap(76, 76, 76))
        );
        group.setVerticalGroup(
                group.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addGroup(GroupLayout.Alignment.TRAILING, group.createSequentialGroup().addContainerGap(94, Short.MAX_VALUE)
                  .addComponent(s1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE).addGap(70, 70, 70))
                  .addGroup(group.createSequentialGroup().addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(group.createSequentialGroup().addGap(70, 70, 70).addComponent(label2)
                  .addGap(72, 72, 72).addComponent(label5)).addGroup(group.createSequentialGroup().addGap(70, 70, 70)
                   .addComponent(label4).addGap(70, 70, 70).addComponent(label3))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        panel1.add(panel2, BorderLayout.NORTH); panel1.add(panel3,BorderLayout.CENTER);
        panel1.setPreferredSize(new Dimension(434,441));
        return panel1;
    }
}

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class overview extends JPanel {
    public double spent;   // make it = the value of the spent
    public double budget; // make it = the value of the budget
    private JLabel label1 = new JLabel();//overall text
    private JLabel label2 = new JLabel();//month budget text
    private JLabel label3 = new JLabel();//spent value
    private JLabel label4 = new JLabel();//total spent text
    private JLabel label5 = new JLabel();//budget value
    private JPanel panel2 = new JPanel();//overall text + separator
    private JPanel panel3 = new JPanel();//spent text & value + separator + month budget text & value
    private JSeparator s = new JSeparator();
    private JSeparator s1 = new JSeparator();
    overview() {
       in();
    }

    public double count(String file_Loc, int ch){
        double data = 0;
        try {
            File file = new File(file_Loc);
            Scanner reader = new Scanner(file);
            if(ch ==0){
            while (reader.hasNext()){
                String dataS = reader.nextLine();
                String [] te= dataS.split(";");
                data += Double.parseDouble(te[1]);
                }}else{
                while(reader.hasNext()){
                    reader.useDelimiter(";");
                    String in = reader.next();
                    if(in.equals(";")){
                        continue;
                    }else{
                        data += Double.parseDouble(in.replaceAll(";",""));
                        }
                }}
            reader.close();
        } catch (FileNotFoundException r) {
            System.out.println("could not open the file");
            r.printStackTrace();
        }
        return data;
    }

    public void update(){
        budget = count("ExpensisManagment\\files\\Budget.txt", 1);
        spent  = count("ExpensisManagment\\files\\spend.txt", 0);
        label3.setText(Double.toString(spent));
        label5.setText(Double.toString(budget));

        //this is only cosmetic if you don't like it just delete it
        if(spent > budget*0.85){
            label3.setForeground(new Color(200, 0, 0));
            label5.setForeground(new Color(200, 0, 0));
        }else if(spent < budget*0.50){
            label3.setForeground(new Color(64, 191, 216));
            label5.setForeground(new Color(64, 191, 216));
        }else if(spent > budget*0.55 && spent < budget*0.85){
            label3.setForeground(new Color(250, 117, 0));
            label5.setForeground(new Color(250, 117, 0));
        }
        //

    }

    public void in(){
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
        setLayout(new BorderLayout(0,0));
        group.setHorizontalGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(GroupLayout.Alignment.CENTER, group.createSequentialGroup()
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(group.createSequentialGroup().addGap(51, 51, 51).addComponent(label2))
                .addGroup(group.createSequentialGroup().addGap(61, 61, 61).addComponent(label5)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addComponent(s1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(label4)
                .addGroup(group.createSequentialGroup().addGap(5, 5, 5).addComponent(label3)))
                .addGap(76, 76, 76))
        );
        group.setVerticalGroup(
                group.createParallelGroup(GroupLayout.Alignment.LEADING)
                 .addGroup(GroupLayout.Alignment.TRAILING, group.createSequentialGroup().addContainerGap(94, Short.MAX_VALUE)
                  .addComponent(s1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE).addGap(70, 70, 70))
                  .addGroup(group.createSequentialGroup().addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(group.createSequentialGroup().addGap(70, 70, 70).addComponent(label2)
                  .addGap(70, 70, 70).addComponent(label5)).addGroup(group.createSequentialGroup().addGap(70, 70, 70)
                   .addComponent(label4).addGap(70, 70, 70).addComponent(label3))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        add(panel2, BorderLayout.NORTH); add(panel3,BorderLayout.CENTER);
        update();
        setPreferredSize(new Dimension(434,441));
    }
}

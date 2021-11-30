import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Edit  extends JPanel implements ActionListener{

    JLabel label = new JLabel("Enter amount");
    JTextField jTextField = new JTextField();
    
    JPanel Panel = new JPanel();
    JComboBox comboBox = new JComboBox<>();
    JButton addButton = new JButton("+");

    JPanel subPanel = new JPanel();
    JButton applyButton = new JButton("apply");
    JButton clearButton = new JButton("Clear");


    
    
    private void initamount_part(){
        label.setFont(new Font("Verdana", Font.PLAIN, 18));
        label.setBounds(30, 0, 130, 50);
        jTextField.setBounds(30, 50, 130, 30);
        jTextField.setBorder(null);   
        add(label);
        add(jTextField);

    }
    
    private void initComo_part(){
        Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        comboBox.setPreferredSize(new Dimension(120,29));
        items(comboBox);
        Panel.add(comboBox);
        Panel.add(addButton);
        Panel.setBounds(15, 150, 200, 40);
        add(Panel);

        addButton.addActionListener(this);


    }
    
    private void initButtons_part(){
        subPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        applyButton.setPreferredSize(new Dimension(100,35));
        clearButton.setPreferredSize(new Dimension(100,35));
        subPanel.add(applyButton);
        subPanel.add(clearButton);
        subPanel.setBounds(90, 250, 300, 40);

        add(subPanel);


        applyButton.addActionListener(this);
        clearButton.addActionListener(this);
    }
    
    
    Edit (){

        setPreferredSize(new Dimension(474,481));
        setLayout(null);

        initamount_part();

        initComo_part();

        initButtons_part();

    }


    private void items(JComboBox b ){
        try {
            b.removeAllItems();
            File myObj = new File("ExpensisManagment\\files\\item.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
            
              String [] tep = data.split(";");
            
              for (String string : tep) {
                   b.addItem(string);
              }
            
              
        }

             
        myReader.close();
            
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }


    
    private void additems(String item){
            try
                {
                    String filename= "ExpensisManagment\\files\\item.txt";
                    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                    fw.write(";"+item);
                    fw.close();
                    items(comboBox);
                    comboBox.setSelectedItem(item);

                }
            catch(IOException ioe)
                {
                    System.err.println("IOException: " + ioe.getMessage());
                }

      }
                

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == applyButton){

            try {
                double  d = Double.parseDouble(jTextField.getText());
                if (d<0){

                    JOptionPane.showMessageDialog(null, "positive only", "Erorr", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception p) {
                JOptionPane.showMessageDialog(null, "numbers only", "Erorr", JOptionPane.ERROR_MESSAGE);
                return;

             }

               

            }


       
        if(e.getSource() == addButton){

           String t = JOptionPane.showInputDialog (null, "Enter new category", "Add",JOptionPane.INFORMATION_MESSAGE);
           additems(t);

           
        }


        if(e.getSource() == clearButton){
            jTextField.setText("");
        }
    }


    
}

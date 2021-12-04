import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class input {
    
    JTextField typeText,amountText;
    JPanel panel;
   

   
    
    private void addBudget(String type , double d ){
        try
        {
            String filename= "ExpensisManagment\\files\\Budget.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(type +";"+d+"\n");
            fw.close();
           
        }
    catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    private void init(){
            typeText = new JTextField("");
            typeText.setPreferredSize(new Dimension(25,25));
            amountText = new JTextField("");
        
            panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Type:"));
            panel.add(typeText);
            panel.add(new JLabel("amount:"));
            panel.add(amountText);
          
    }
   
   
    public input()
    {
      init();
    }

    public void inputForm(String title)
    {
     
      
      int i = 0 ;
      while (i!=1){
         int result = JOptionPane.showConfirmDialog(null, panel, title,
                      JOptionPane.CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
         
         if (result == JOptionPane.OK_OPTION) {
              try{
                  double d = Double.parseDouble(amountText.getText());
                  if(d<0){
                     JOptionPane.showMessageDialog(null  , "please enter positive number ","incorret",JOptionPane.INFORMATION_MESSAGE );
                     continue;

                  }
                     
                     addBudget(typeText.getText().toString(), d);
                     int p = JOptionPane.showConfirmDialog(null,"do you want add more ",null, JOptionPane.YES_NO_OPTION);
                     init();
                   
                     if(p == JOptionPane.NO_OPTION)
                     {
                      return;
                     } 
                 
              }catch(Exception e){
                     JOptionPane.showMessageDialog(null  , "please enter number value"+ "\n\nError code : "+ e.toString(),"incorret",JOptionPane.INFORMATION_MESSAGE );}
       
       
       
             }else if(result==-1 || result ==2 )
              {
             return;
              }
         }
    }
    

      
   


}

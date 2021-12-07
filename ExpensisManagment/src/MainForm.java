import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame implements ActionListener{
    JToggleButton OvreView,add_edit,stats,export;
    JPanel ButtonContainer,leftPanel;
    Edit edit = new Edit();
    overview over = new overview();
    Stats s = new Stats();



    private void initButton() {
            OvreView = new JToggleButton("Over view");
            OvreView.setPreferredSize(new Dimension(155,40));
            OvreView.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));


            add_edit = new JToggleButton("Add/Edit");
            add_edit.setPreferredSize(new Dimension(155,40));
            add_edit.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

            stats = new JToggleButton("Statstic");
            stats.setPreferredSize(new Dimension(155,40));
            stats.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

            export = new JToggleButton("Export");
            export.setPreferredSize(new Dimension(155,40));
            export.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

            OvreView.addActionListener(this);
            add_edit.addActionListener(this);
            stats.addActionListener(this);
            export.addActionListener(this);


}

    
   private void LeftPanel_init(){
            JPanel buttons = new JPanel(new GridBagLayout());
            JPanel p = new JPanel();

            leftPanel = new JPanel(); 
            leftPanel.setBackground(new Color(64,191,216));
            leftPanel.setPreferredSize(new Dimension(250,481));
            leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            leftPanel.setLayout(new GridBagLayout());
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets=new Insets(3,3,30,3);
           
            
            p.add(OvreView);
            buttons.setBackground(new Color(64,191,216));
            buttons.add(OvreView, gbc);
            buttons.add(add_edit, gbc);
            buttons.add(stats, gbc);
            buttons.add(export, gbc);
            gbc.weighty = 10;
            leftPanel.add(buttons, gbc);

   }
    
    
    MainForm (){
       setSize(715, 481);
   
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());

       initButton();
       
       LeftPanel_init();
      
       add(leftPanel,BorderLayout.WEST);
       setLocationRelativeTo(null);
       setVisible(true);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub


        
         if(e.getSource() == OvreView) { 
             add_edit.setSelected(false);
             stats.setSelected(false);
             export.setSelected(false);

    
            edit.setVisible(false);
            over.setVisible(true);
            over.update();
            this.add(over,BorderLayout.EAST);
            SwingUtilities.updateComponentTreeUI(this);
            
             paintComponent(OvreView);
             

         }

         if(e.getSource() == add_edit) { 
            OvreView.setSelected(false);
            stats.setSelected(false);
            export.setSelected(false);
            paintComponent(add_edit);

            over.setVisible(false);
            edit.setVisible(true);

            this.add(edit,BorderLayout.EAST);
            SwingUtilities.updateComponentTreeUI(this);


            
        }

        if(e.getSource() == stats) {
            
            OvreView.setSelected(false);
            add_edit.setSelected(false);
            export.setSelected(false);

            paintComponent(stats);

            s.spend_read();
            over.setVisible(false);
            s.setVisible(true);

            this.add(s,BorderLayout.EAST);
            SwingUtilities.updateComponentTreeUI(this);


        }

        if(e.getSource() == export) { 
            add_edit.setSelected(false);
            stats.setSelected(false);
            OvreView.setSelected(false);
            paintComponent(export);
        }

        


        
    }
  

    public void paintComponent(JToggleButton but){ //use this in the actionListener(send the Button)
        Color BG,text; //initialize color for the text of the button + the background
        if(but.isSelected()){ // checks if button is pressed if so it changes the color of the text to white and the
           
            text = new Color(255,255,255);
        }else{ //default colors
            but.setBackground(UIManager.getColor("Button.background"));
            text = new Color(0,0,0);
        }
        
       
        but.setForeground(text);
    }
    
    
}

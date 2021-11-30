import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login implements ActionListener {
    JFrame login_frame = new JFrame("Login Form");
    JPanel login_panel = new JPanel();
    JLabel header_label, student_label, manage_label, system_label,username_label,
            pass_label;
    JButton login_button = new JButton("Login");
    JButton reset_button = new JButton("Reset");
    JTextField username_field = new JTextField();
    JPasswordField password_field = new JPasswordField();
    Font font = new Font("Dialog",1,25);

    Login(){

        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_frame.setSize(730,500);
        login_frame.setLayout(null);
        login_frame.setBackground(Color.WHITE);

        login_panel.setBounds(0,0,250,500);
        login_panel.setBackground(new java.awt.Color(64,191,216));

        header_label = new JLabel();
        header_label.setText("Login to the System");
        header_label.setBounds(270,-200,500,500);
        header_label.setForeground(new java.awt.Color(64,191,216));
        header_label.setFont(font);

        username_field.setBounds(270,150,280,30);
        password_field.setBounds(270,250,280,30);

        login_button.addActionListener(this);
        login_button.setFocusable(false);
        login_button.setBounds(270,350,150,40);

        reset_button.addActionListener(this);
        reset_button.setFocusable(false);
        reset_button.setBounds(430,350,120,40);

        username_label = new JLabel("Username");
        username_label.setForeground(Color.BLACK);
        username_label.setFont(font);
        username_label.setBounds(270,-125,500,500);
        username_label.setFont(font);

        pass_label = new JLabel("Password");
        pass_label.setForeground(Color.BLACK);
        pass_label.setFont(font);
        pass_label.setBounds(270,-21,500,500);
        pass_label.setFont(font);

        
        login_frame.add(login_panel);
        login_frame.add(header_label);
        login_frame.add(username_field);
        login_frame.add(password_field);
        login_frame.add(login_button);
        login_frame.add(reset_button);
        login_frame.add(username_label);
        login_frame.add(pass_label);
        login_frame.setVisible(true);


    }

    public static void main(String[]args){
        Login log = new Login();}

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reset_button){
            username_field.setText("");
            password_field.setText("");
        }
    }

}

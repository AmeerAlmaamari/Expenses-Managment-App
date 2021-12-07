import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

// button listener should be changed to stats_button
// directory of the file should be changed
public class Stats extends JPanel{
    JPanel stats_panel;
    JScrollPane ScrollPane;
    JTable stats_table;
    Object[] columns_names = {"Label","Amount"};
    
    Stats()
    {
        stats_panel = new JPanel(new BorderLayout());
        stats_table = new JTable();
        
         
        ScrollPane = new JScrollPane(stats_table);
        
        stats_panel.setPreferredSize(new Dimension(474,481));
        stats_panel.add(stats_table);
        stats_panel.add(ScrollPane, BorderLayout.CENTER);
        
        
        JTableHeader Theader = stats_table.getTableHeader();
        
        Theader.setBackground(new Color(64,191,216)); 
        Theader.setForeground(Color.WHITE); 
        Theader.setFont(new Font("Arial", Font.BOLD, 18));
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        stats_table.setFont(new Font("Arial", Font.BOLD, 15));
    }
    
    public void spend_read(){
          
         String filePath = "ExpensisManagment\\files\\spend.txt";
         File file = new File(filePath);
         
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                DefaultTableModel model = (DefaultTableModel)stats_table.getModel();
                model.setColumnIdentifiers(columns_names);
                
                
                Object[] rows = br.lines().toArray();
                for(int i = 0; i< rows.length; i++){
                String line = rows[i].toString().trim();
                String[] data = line.split(";");
                model.addRow(data);
                }
              
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
}

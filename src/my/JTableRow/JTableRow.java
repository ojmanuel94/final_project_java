/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.JTableRow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JLabel; 


/**
 *
 * @author Shortcourse
 */
public class JTableRow {
    public static void main(String[] args){
        
        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable table = new JTable(); 
        
        // create a table model and set a Column Identifiers to this model 
        Object[] columns = {"Student Id","Full Name","Course","Birthdate"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        
        // set the model to the table
        table.setModel(model);
        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        
        //create labels para sa blanks 
        JLabel lbtextId = new JLabel();
        JLabel lbtextFname = new JLabel();
        JLabel lbtextCoursename = new JLabel();
        JLabel lbtextBirthDate = new JLabel();
       
        
        // create JTextFields
        JTextField textId = new JTextField();
        JTextField textFname = new JTextField();
        JTextField textCoursename = new JTextField();
        JTextField textBirthDate = new JTextField();
        
        
        // create JButtons
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");    
        JButton btnClear = new JButton("Clear");
        JButton btnExit = new JButton("Exit");
        
        textId.setBounds(150, 220, 100, 25);
        textFname.setBounds(150, 250, 100, 25);
        textCoursename.setBounds(150, 280, 100, 25);
        textBirthDate.setBounds(150, 310, 100, 25);
        
        
        btnAdd.setBounds(450, 220, 100, 25);
        btnUpdate.setBounds(450, 265, 100, 25);
        btnDelete.setBounds(450, 310, 100, 25);
        
        // 
        btnClear.setBounds(575, 265, 100, 25);
        btnExit.setBounds(575, 310,  100, 25);
        
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        
        frame.setLayout(null);
        
        frame.add(pane);
        
        // add JTextFields to the jframe
        frame.add(textId);
        frame.add(textFname);
        frame.add(textCoursename);
        frame.add(textBirthDate);
        
    
        // add JButtons to the jframe
        frame.add(btnAdd);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnClear);
        frame.add(btnExit);
        
        // create an array of objects to set the row data
        Object[] row = new Object[4];
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textId.getText();
                row[1] = textFname.getText();
                row[2] = textCoursename.getText();
                row[3] = textBirthDate.getText();
                
                
                // add row to the model
                model.addRow(row);
                
                //Pag na kana mo na, tirahin mo naman ang clear para malinis tignan
                   textId.setText("");
                   textFname.setText("");
                   textCoursename.setText("");
                   textBirthDate.setText("");
                   
                   
                //Sabihin mo na. 
                   
                JOptionPane optionPane = new JOptionPane("Sucessfully added student to list",JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("System Notification");
                dialog.setAlwaysOnTop(true); // to show top of all other application
                dialog.setVisible(true); // to visible the dialog
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    model.removeRow(i);
                
                    
                //tapos na - tirahin mo ulit ang textfield 
                    
                textId.setText("");
                textFname.setText("");
                textCoursename.setText("");
                textBirthDate.setText("");
                 
                }
                else{
                    System.out.println("Delete Error");
                }
                
                
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textId.setText(model.getValueAt(i, 0).toString());
            textFname.setText(model.getValueAt(i, 1).toString());
            textCoursename.setText(model.getValueAt(i, 2).toString());
            textBirthDate.setText(model.getValueAt(i, 3).toString());
            
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
                public void actionPerformed(ActionEvent e) {
                
                
                
                // i = the index of the selected row
                int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textId.getText(), i, 0);
                   model.setValueAt(textFname.getText(), i, 1);
                   model.setValueAt(textCoursename.getText(), i, 2);
                   model.setValueAt(textBirthDate.getText(), i, 3);
                }
                else{
                     //Sabihin mo na. 
                   
                JOptionPane optionPane = new JOptionPane("Please choose a student first!",JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("System Notification");
                dialog.setAlwaysOnTop(true); // to show top of all other application
                dialog.setVisible(true); // to visible the dialog
                }
            }
        });
        
        
        // button clear button 
          btnClear.addActionListener(new ActionListener(){
                @Override
            public void actionPerformed(ActionEvent e) {
             
                textId.setText("");
                textFname.setText("");
                textCoursename.setText("");
                textBirthDate.setText("");
               
            }
            
            
        });
          
          btnExit.addActionListener(new ActionListener(){
                @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);          
            }
            
            
        });
        
        
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author yogi
 */
public class DNAALGO extends JFrame implements ActionListener
{
     static JButton b1,b2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
       JFrame f=new JFrame();//creating instance of JFrame        
       b1=new JButton("Decrypt");
       b2=new JButton("Encrypt");  
       b1.setBounds(160,100,100,50);
       b2.setBounds(30,100,100,50);
       f.add(b1);
       f.add(b2);
       b1.addActionListener(new DNAALGO());
       b2.addActionListener(new DNAALGO());
       f.setSize(300,300);//400 width and 500 height  
       f.setLayout(null);//using no layout managers  
       f.setVisible(true);//making the frame visible  
     }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {    
         DecryJFrame1.main(null);
        }
        if(e.getSource()==b2)
        {    
         NewJFrame.main(null);
        }
        
        
    }
    }
    



import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yogi
 */
public class server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        int number,temp;
        ServerSocket s1=new ServerSocket(1342);
        Socket ss1=s1.accept();
        Scanner sc=new Scanner(System.in);
        number=sc.nextInt();
        temp=2*number;
        PrintStream p=new PrintStream(ss1.getOutputStream());
        p.println(temp);
        
        
        
    }
    
}

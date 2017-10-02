
import java.io.IOException;
import java.io.PrintStream;
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
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        int number ,temp;
        Scanner sc=new Scanner(System.in);
        Socket s=new Socket("127.0.0.1",1342);
        Scanner sc1=new Scanner(s.getInputStream());
        System.out.println("Enter any number");
        number=sc.nextInt();
        PrintStream p=new PrintStream(s.getOutputStream());
        p.println(number);
        temp=sc1.nextInt();
        System.err.println(temp);
        
    }
    
}

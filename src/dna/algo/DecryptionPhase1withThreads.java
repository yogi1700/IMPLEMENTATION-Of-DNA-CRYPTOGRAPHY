/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yogi
 */
public class DecryptionPhase1withThreads
{
     static String  key="";
     String key2="";
     String message="";
     public static String []  DecryptMessage;
     String phase1="";
     
     
  
      
   
   
     public String calculate( String str) throws InterruptedException, FileNotFoundException, IOException
     {
         
        //System.out.println("yes am in calculate of DecryptionPhase1 with Threads\n");
        
        //reading the key1 from file key.txt and assigning the key string
        FileReader freader = new FileReader("key.txt");  
        BufferedReader br = new BufferedReader(freader);  
        String s;  
        //System.out.println("");
        while((s = br.readLine()) != null)
        {  
        //System.out.print(s);
        key=key+s;
        }  
        freader.close(); 
        
        //System.out.println(" key for phase1="+key);
        
        //reading the key2 from file key2.txt and assigning  key2 string
        FileReader freader2= new FileReader("key2.txt");  
        BufferedReader br2= new BufferedReader(freader2);  
        String s1;  
        //System.out.println("");
        while((s1= br2.readLine()) != null)
        {  
        //System.out.print(s1);
        key2=key2+s1;
        }  
        freader2.close();
        
        // for getting decimal value of binary values in key2 
        GetBackyourkey2 gb=new GetBackyourkey2();
        gb.getback(key2);
        
        /*for(int j=0;j<16;j++)
        {
      
         System.out.println(" No"+gb.key2[j]);
        } */
        
        //storing message to filename.txt file
        FileReader freader3 = new FileReader("filename.txt");  
        BufferedReader br3= new BufferedReader(freader3);  
        String s3;  
        //System.out.println();
        while((s3 = br3.readLine()) != null)
        {  
        //System.out.print(s);
        message=message+s3;
        }  
        
        //System.out.println();
        freader3.close();
        
        // threading the message for further decrytption message
        
        //System.out.println("message length="+message.length());
        DecryptMessage=new String[message.length()/4];
        int thread_size=8;
        for(int i=0;i<(int)Math.ceil(message.length()/8.0);i++)
        {    
        if(thread_size*i+thread_size<message.length())
        {    
        Decryphase1withthreads t=new Decryphase1withthreads(message,thread_size*i,thread_size*i+thread_size,i);
        t.start(); 
        //t.sleep(10);
            
        }
        else
        {
            
                Decryphase1withthreads t=new Decryphase1withthreads(message,thread_size*i,message.length()-1,i);
                t.start();
                //t.sleep(10);
            
        }
        
    }
        Thread.sleep(1000);
        
        //printing the message after phase1 decryption and assigning to phase1 string
        
        //System.out.println("DecryptMessage");
        for(int k=0;k<DecryptMessage.length;k++)
        {
            //System.out.print(DecryptMessage[k]);
            phase1=phase1+DecryptMessage[k];
        }
        
        
     
       
        
   
        return phase1;
    
}
}

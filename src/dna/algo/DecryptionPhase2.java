/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

/**
 *
 * @author yogi
 */
public class DecryptionPhase2 
{
    static String message="";
    String phase2="";
    public static String []  DecryptMessage2;
    public String  calculate(String str) throws InterruptedException
    {
        message=str;
        // System.out.println("message="+message);
        int thread_size=8;
        
        //System.out.println("\nmessage length in phase2="+message.length());
        DecryptMessage2=new String[message.length()];
        
        for(int i=0;i<(int)Math.ceil(message.length()/8.0);i++)
        {    
        if(thread_size*i+thread_size<message.length())
        {    
        DecryptionPhase2WithThreads t=new DecryptionPhase2WithThreads(message,thread_size*i,thread_size*i+thread_size,i);
        t.start(); 
        //t.sleep(10);
            
        }
        else
        {
            
                DecryptionPhase2WithThreads t=new DecryptionPhase2WithThreads(message,thread_size*i,message.length(),i);
                t.start();
                //t.sleep(10);
            
        }
        }
       Thread.sleep(10000);
       //System.out.println("\nDecryptMessage2 and length"+DecryptMessage2.length);
       
       for(int l=0;l<DecryptMessage2.length;l++)
        {
            //System.out.println(DecryptMessage2[l]);
            phase2=phase2+DecryptMessage2[l];
        }
    
    return phase2;
    }
}

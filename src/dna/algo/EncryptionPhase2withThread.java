package dna.algo;


import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yogi
 */
public class EncryptionPhase2withThread  //this class for encryption phase 2
{
    static String a="";
    static String[] string={"AA","AT","AG","AC","TA","TT","TG","TC","GA","GT","GG","GC","CA","CT","CG","CC"};
    static String[] encode=new String[16];
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static char [] global;
    
    //decimal to binary conversion
    public String binary(int product)
     { 
         int n=product;
         String x="";
         int a;
         while(n >0)
           {
            a = n % 2;
            x = a+""+x;
            n = n/2;
           }
         if(x.length()==3)
             x="0"+x;
         if(x.length()==2)
             x="00"+x;
         if(x.length()==1)
             x="000"+x;
         if(product==0)
             x="0000";
             
       return x;
     }
    
    public char[] calculate(String str)
    {
        a=str;
        global=new char[a.length()*2];
        //System.out.println(" in phase 2 a="+str);
        try
        {  
        //System.out.println(" printing global first time");
         //for(int l=0;l<global.length;l++)
        //{
           // System.out.print(global[l]);
        //}
        //System.out.print("\n");
        
        for (int i=0; i<16; i++) 
        {
            list.add(new Integer(i));
        }
        Collections.shuffle(list); // used for shuffling the list values
        
        //for (int i=0; i<16; i++) 
        //{
          //  System.out.print(" "+list.get(i));
        //}
        //System.out.print("\n");
        
        //creating instance of below class and calling its own function 
        EncryptionPhase2withThread nw=new EncryptionPhase2withThread();
        for(int i=0;i<16;i++)
        {
            encode[i]=(nw.binary(list.get(i)));
        }
        
        // for storing key2 in  text file
        keyforphase1 kp=new keyforphase1();
        kp.keyforphase2(encode);
        
        //for(int i=0;i<16;i++)
        //{
          //  System.out.println(encode[i]);
      
        //}
        int thread_size=8;
        String sum="",sumi="";
        for(int i=0;i<(int)Math.ceil(a.length()/8.0);i++)
        {    
        if(thread_size*i+thread_size<a.length())
        {    
        ThreadClassforPhase2 t=new ThreadClassforPhase2(a,thread_size*i,thread_size*i+thread_size,sum,i);
        t.start(); 
        //t.sleep(10);
            
        }
        else
        {
            
                ThreadClassforPhase2 t=new ThreadClassforPhase2(a,thread_size*i,(a.length()-1),sum,i);
                t.start();
                //t.sleep(10);
            
        }
        
    }
        
        Thread.sleep(100);
        //System.out.println(a.length()+" length of a "+global.length+" global length");
        //System.out.println(" a="+a);
        //System.out.println(" global second time ");
        if(a.length()%2!=0)
        {
            if(a.charAt(a.length()-1)=='z')
            global[(global.length-2)]='0';
            else
            global[(global.length-2)]='1';
               
        }
        //for(int l=0;l<global.length;l++)
        //{
        //    System.out.print(global[l]);
        //}
  }
    
    catch(Exception e){}
        return global;
    }
    
}

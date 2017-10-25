/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yogi
 */
public class EncpryptionPhase1withThread 
{
        static String  a="";
        static StringBuilder ab=new StringBuilder(a);
        String local="";
        String[] dna ={"A","T","G","C"};
        static public char [] bdr;
        static List<String> list ;
     
   public char [] calculate(String str) throws InterruptedException
     {
         
        /*System.out.println("yesnonononon "+dna1);
         for(int p=0,k=0;p<dna1.length();k++)
         {
         if(dna1.charAt(p)=='0')
         {
          if(dna1.charAt(p+1)=='0')
           { 
             dna[k]="A";
           }
          if(dna1.charAt(p+1)=='1')
           { 
             dna[k]="T";
           }
         }
         if(dna1.charAt(p)=='1')
         {
          if(dna1.charAt(p+1)=='0')
           { 
             dna[k]="G";
           }
          if(dna1.charAt(p+1)=='1')
           { 
             dna[k]="C";
           }
         }
         p=p+2;
      } 
        System.out.println(dna[1]);*/
        list = Arrays.asList(dna); 
        //System.out.println(" in phase 1 str value "+str);
        a=str; 
        bdr=new char [(int)Math.ceil(a.length()/2.0)];
        Collections.shuffle(list);
        String listString = "";
        for (String s : list) 
        {
         listString += s;
        }
        keyforphase1 kp=new keyforphase1();
        kp.keyforphase(listString);
        //System.out.print(" a length= "+a.length());
        int thread_size=8;
        String sum="",sumi="";
        for(int i=0;i<(int)Math.ceil(a.length()/8.0);i++)
        {    
        if(thread_size*i+thread_size<a.length())
        {    
        ThreadClassforPhase1 t=new ThreadClassforPhase1(a,thread_size*i,thread_size*i+thread_size,sum,i);
        t.start(); 
        //t.sleep(10);
        }
        else
        {
        ThreadClassforPhase1 t=new ThreadClassforPhase1(a,thread_size*i,(a.length()-1),sum,i);
        t.start(); 
        //t.sleep(10);
        }
            
        //sumi=sumi+t.su;
        }
        //Thread.sleep(10000);
        //System.out.println("yes");
        //for(int i=0;i<global.length;i++)
        //{
        Thread.sleep(100);
        EncpryptionPhase1withThread nw=new EncpryptionPhase1withThread();
        //System.out.println(a+" and length of bdr \n"+bdr.length+" value="+a.length());
        if(a.length()%2!=0)
            {  
                if(a.charAt(a.length()-1)=='0')
                bdr[bdr.length-1]='z';
                else
                bdr[bdr.length-1]='o';    
            }
        //for(int i=0;i<nw.bdr.length;i++)
        //System.out.print(nw.bdr[i]);       
        return bdr;
     }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author yogi
 */
public class NewMain2 
{
     static String a="ATTTCTCGATTTCTCATTTCTCGATTTCTCGATTTCTCGGATATTTCTCGATTTCTCGATTTCTCGTTCTCGATTTCTCGATTTCTCGATTTCTCGATTTCTCGATTTCTCGATTTCTCGo";
     static String[] string={"AA","AT","AG","AC","TA","TT","TG","TC","GA","GT","GG","GC","CA","CT","CG","CC"};
     static String[] encode=new String[16];
     static ArrayList<Integer> list = new ArrayList<Integer>();
     static char [] global=new char[a.length()*2];
        
     
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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        try
        {  
        if(a.length()%2!=0)
        {
            if(a.charAt(a.length()-1)=='z')
            global[(global.length-1)]=0;
            else
            global[(global.length-1)]=1;
               
        }
        for (int i=0; i<16; i++) 
        {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<16; i++) 
        {
            System.out.print(" "+list.get(i));
        }
        System.out.print("\n");
        NewMain nw=new NewMain();
        for(int i=0;i<16;i++)
        {
            encode[i]=(nw.binary(list.get(i)));
        }
        
        for(int i=0;i<16;i++)
        {
            System.out.println(encode[i]);
      
        }
        int thread_size=8;
        String sum="",sumi="";
        for(int i=0;i<(int)Math.ceil(a.length()/8.0);i++)
        {    
        if(thread_size*i+thread_size<a.length())
        {    
        threa2 t=new threa2(a,thread_size*i,thread_size*i+thread_size,sum,i);
        t.start(); 
        t.sleep(10);
            
        }
        else
        {
            
                threa2 t=new threa2(a,thread_size*i,(a.length()-1),sum,i);
                t.start();
                t.sleep(10);
            
        }
        
    }
        
        Thread.sleep(100);
        System.out.println(a.length()+" length of a "+global.length+" global length");
        System.out.println(a);
        for(int l=0;l<global.length;l++)
        {
            System.out.print(global[l]);
        }
  }
    
    catch(Exception e){}
    
}
}
class threa2 extends Thread
{
    String str,su="";
    int len,id,start_index;
    public threa2(String a,int start,int length,String sum,int i)
    {
        str=a;
        len=length;
        su=sum;
        id=i;
        start_index=start;
        
        
    }
    @Override
    public void run() 
    {
          
        
        System.out.println(" In thread"+id);
        NewMain2 nw=new NewMain2();
        for(int i=start_index,j=start_index*2;i<len;)
        {
             if (str.charAt(i)== 'A') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[0].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[1].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[2].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[3].charAt(s);
                }
            }
              if (str.charAt(i)== 'T') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[4].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[5].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[6].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[7].charAt(s);
                }
            }
               if (str.charAt(i)== 'G') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[8].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[9].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[10].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[11].charAt(s);
                }
            }
             if (str.charAt(i)== 'C') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[12].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[13].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[14].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[15].charAt(s);
                }
            }
              
            i=i+2;
            j=j+4;
       }
      
    }

}

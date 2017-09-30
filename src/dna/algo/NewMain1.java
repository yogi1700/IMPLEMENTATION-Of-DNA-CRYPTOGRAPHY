/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class NewMain1 
{
    
    
        static String  a="111111101010101010101010101010101010101010010101010101010101010101010101010100101"
                + "10101010101"
                + "101010101010101010111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                + "1111111111111111111111111111111111111111111111111111111111111111111111111111101011101010101010101010101010111"
                + "0010101111100001010101011001010101010100101010101010101010101010101010101010101010101010101010111111111111111"
                + "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                + "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                + "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        static StringBuilder ab=new StringBuilder(a);
        String local="";
        static String[] dna={"A","T","G","C"};
        static List<String> list = Arrays.asList(dna);
        static public String [] bdr=new String [(int)Math.ceil(a.length()/2.0)];
        

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException 
    {
        
        // TODO code application logic here
        Collections.shuffle(list);
        System.out.print(" "+a.length());
        int thread_size=8;
        String sum="",sumi="";
        for(int i=0;i<(int)Math.ceil(a.length()/8.0);i++)
        {    
        if(thread_size*i+thread_size<a.length())
        {    
        threa t=new threa(a,thread_size*i,thread_size*i+thread_size,sum,i);
        t.start(); 
        //t.sleep(10);
        }
        else
        {
        threa t=new threa(a,thread_size*i,(a.length()-1),sum,i);
        t.start(); 
        //t.sleep(10);
        }
            
        //sumi=sumi+t.su;
        }
        //Thread.sleep(10000);
        System.out.println("yes");
        //for(int i=0;i<global.length;i++)
        //{
        Thread.sleep(100);
        NewMain1 nw=new NewMain1();
        System.out.println(a+" and length of bdr \n"+bdr.length+" value="+a.length());
        if(a.length()%2!=0)
            {  
                if(a.charAt(a.length()-1)=='0')
                bdr[bdr.length-1]="z";
                else
                bdr[bdr.length-1]="o";    
            }
        for(int i=0;i<nw.bdr.length;i++)
        System.out.print(nw.bdr[i]);
        
        
    }
}
class threa extends Thread
{
    String str,su="";
    int len,id,start_index;
    public threa(String a,int start,int length,String sum,int i)
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
          
        
        System.out.println(" In threda"+id);
        NewMain1 nw=new NewMain1();
        for(int i=start_index,j=start_index/2;i<len;)
        {
         char ch1=(char)str.charAt(i);
         char ch2=(char)str.charAt(i+1);
         System.out.println("\nch1= "+ch1+" ch2 ="+ch2);
         String str2=String.valueOf(ch1)+String.valueOf(ch2);
         
         if(str2.equals("00"))
         nw.bdr[j]=nw.list.get(0);
         
         else if(str2.equals("01"))
         nw.bdr[j]=nw.list.get(1);
         
         else if(str2.equals("10"))
         nw.bdr[j]=nw.list.get(2);
         
         else if(str2.equals("11"))
         nw.bdr[j]=nw.list.get(3);
          
         i=i+2; 
         j++;
       }
      /*if(str.length()%2==1)
      {
       if(str.charAt(str.length()-1)=='0')
       nw.bdr.append("Z");
       if(str.charAt(str.length()-1)=='1')
       nw.bdr.append("O");
      }*/
      
    }

}

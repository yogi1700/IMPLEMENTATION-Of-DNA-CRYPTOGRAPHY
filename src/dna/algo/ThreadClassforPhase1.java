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
public class ThreadClassforPhase1 extends Thread
{
    String str,su="";
    int len,id,start_index;
    public ThreadClassforPhase1(String a,int start,int length,String sum,int i)
    {
        str=a;
        len=length;
        su=sum;
        id=i;
        start_index=start;
        
        
    }
    public void run() 
    {
          
        
        //System.out.println(" In threda"+id);
        EncpryptionPhase1withThread nw=new EncpryptionPhase1withThread();
        for(int i=start_index,j=start_index/2;i<len;)
        {
         char ch1=(char)str.charAt(i);
         char ch2=(char)str.charAt(i+1);
         //System.out.println("\nch1= "+ch1+" ch2 ="+ch2);
         String str2=String.valueOf(ch1)+String.valueOf(ch2);
         
         if(str2.equals("00"))
         nw.bdr[j]=nw.list.get(0).charAt(0);
         
         else if(str2.equals("01"))
         nw.bdr[j]=nw.list.get(1).charAt(0);
         
         else if(str2.equals("10"))
         nw.bdr[j]=nw.list.get(2).charAt(0);
         
         else if(str2.equals("11"))
         nw.bdr[j]=nw.list.get(3).charAt(0);
          
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


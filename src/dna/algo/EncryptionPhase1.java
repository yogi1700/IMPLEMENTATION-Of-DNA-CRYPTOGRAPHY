/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yogi
 */
public class EncryptionPhase1 {
   
     public String DNA(String str)
     {        
     //generating key value 
     String[] dna = null;
     keyforphase1 kp=new keyforphase1();
     String dna1=kp.key1;
     System.out.println(dna1);
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
     System.out.println("key1");
     System.out.println(dna[0]);
     System.out.println(dna[1]);
     System.out.println(dna[2]);
     System.out.println(dna[3]);
     List<String> list = Arrays.asList(dna);
     Collections.shuffle(list);
     System.out.println(dna[1]);
     
     //checking the length of string is even or not
     StringBuilder bdr= new StringBuilder();
     bdr.append(str);
     int i=0;
     if(bdr.length()%2==1)
         bdr.append("0");
     
     while(i<bdr.length())
     {
         
      char ch1=(char)bdr.charAt(i);
      char ch2=(char)bdr.charAt(i+1);
      System.out.println("ch1= "+ch1+" ch2 ="+ch2);
      String str2=String.valueOf(ch1)+String.valueOf(ch2);
      System.out.println("i "+i);
      System.out.println("str2= "+str2);      
      System.out.println("substring= "+bdr.substring(i, i+2)); 
      if(str2.equals("00"))
      bdr.replace(i,i+2,list.get(0));
      
      else if(str2.equals("01"))
      bdr.replace(i,i+2,list.get(1));
      
      else if(str2.equals("10"))
      bdr.replace(i,i+2,list.get(2));
      
      else if(str2.equals("11"))
      bdr.replace(i,i+2,list.get(3));
   
    System.out.println(bdr.toString()); 
   
    i++;
     }
     System.out.println(bdr.toString());
     if(str.length()%2==1)
     {
      if(str.charAt(str.length()-1)=='0')
      bdr.replace(bdr.length()-1,bdr.length(),"Z");
      if(str.charAt(str.length()-1)=='1')
      bdr.replace(bdr.length()-1,bdr.length(),"O");
      }
     System.out.println(bdr.toString());
      
     
     return bdr.toString();
     }
}



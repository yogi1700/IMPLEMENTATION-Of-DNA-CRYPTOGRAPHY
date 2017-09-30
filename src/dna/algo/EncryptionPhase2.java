
package dna.algo;
import dna.algo.NewMain;
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
public class EncryptionPhase2 
{
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
     
    public String modified(String str)
    {
        // TODO code application logic here
        /*Random rand=new Random();
        for(int i=0;i<16;i++)
        {
        int k=rand.nextInt(16);
        System.out.println(k);
        }*/
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<16; i++) 
        {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<16; i++) 
        {
            System.out.print(" "+list.get(i));
        }
        String[] string={"AA","AT","AG","AC","TA","TT","TG","AC","CA","CT","CG","CC","GA","GT","GA","GC"};
        String[] encode=new String[16];
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
        int i = 0, j = 0, l;
        StringBuilder bdr = new StringBuilder(str);
        System.out.println(bdr);
        if (str.length() % 2 == 0)
        {
            l = str.length();
        }
        else 
        {
            l = str.length() - 1;
        }
        while (i < l) {
            System.out.println(i + "th step\n");
            if (str.charAt(i) == 'A') {
                if (str.charAt(i + 1) == 'A') {
                    bdr.replace(j, j + 2, encode[i]);
                }
                if (str.charAt(i + 1) == 'T') {
                    bdr.replace(j, j + 2, encode[i + 1]);
                }
                if (str.charAt(i + 1) == 'G') {
                    bdr.replace(j, j + 2, encode[i + 2]);
                }
                if (str.charAt(i + 1) == 'C') {
                    bdr.replace(j, j + 2, encode[i + 3]);
                }
            }
            if (str.charAt(i) == 'T') {

                if (str.charAt(i + 1) == 'A') {
                    bdr.replace(j, j + 2, encode[i]);
                }
                if (str.charAt(i + 1) == 'T') {
                    bdr.replace(j, j + 2, encode[i + 1]);
                }
                if (str.charAt(i + 1) == 'G') {
                    bdr.replace(j, j + 2, encode[i + 2]);
                }
                if (str.charAt(i + 1) == 'C') {
                    bdr.replace(j, j + 2, encode[i + 3]);
                }
            }
            if (str.charAt(i) == 'G') {

                if (str.charAt(i + 1) == 'A') {
                    bdr.replace(j, j + 2, encode[i]);
                }
                if (str.charAt(i + 1) == 'T') {
                    bdr.replace(j, j + 2, encode[i + 1]);
                }
                if (str.charAt(i + 1) == 'G') {
                    bdr.replace(j, j + 2, encode[i + 2]);
                }
                if (str.charAt(i + 1) == 'C') {
                    bdr.replace(j, j + 2, encode[i + 3]);
                }
            }
            if (str.charAt(i) == 'C') {

                if (str.charAt(i + 1) == 'A') {
                    bdr.replace(j, j + 2, encode[i]);
                }
                if (str.charAt(i + 1) == 'T') {
                    bdr.replace(j, j + 2, encode[i + 1]);
                }
                if (str.charAt(i + 1) == 'G') {
                    bdr.replace(j, j + 2, encode[i + 2]);
                }
                if (str.charAt(i + 1) == 'C') {
                    bdr.replace(j, j + 2, encode[i + 3]);
                }
            }
            System.out.println(bdr);
            i = i + 2;
            j = j + 4;
        }
        if (bdr.charAt(bdr.length() - 1) == 'Z') 
        {
            bdr.replace(bdr.length() - 1, bdr.length(), "0");
        }
        if (bdr.charAt(bdr.length() - 1) == 'O') 
        {
            bdr.replace(bdr.length() - 1, bdr.length(), "1");
        }
     
        return bdr.toString();
        }
        
    
}

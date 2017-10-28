/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yogi
 */
public class keyforphase1 
{
    public static String key1="";
    public static String []key2;
    public static String message="";
    public static String str="";
    
    void keyforphase(String  list)
    {
       //System.out.print(" in keyforphase1=");
        
       // this is storing key1 as text file 
       BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter( new FileWriter("Client/key.txt"));
                writer.write(list);

            }
            catch ( IOException e)
            {
            }
            finally
            {
            try
             {
              if (writer != null)
                writer.close( );
              }
             catch (IOException e)
              {
               }
             }
        
       
    }
    
    static String binary(int i)
    {
        switch (i) {
            case 0:
                return "00";
            case 1:
                return "01";
            case 2:
                return "10";
            case 3:
                return "11";
            default:
                return "";
        }
        
    }

    void keyforphase2(String [] list) 
    {
        
     key2=new String[16];   
    //System.out.print(" in keyforphase2=");
    //for(int i=0;i<16;i++)
    //{
      //  
        //System.out.println(list[i]);
    //} 
    for(int i=0;i<16;i++)
    {
        
        //System.out.print(i+" in "+list[i]+"\n");
        key2[i]=list[i];
    }   
    for(int i=0;i<16;i++)
    {
    
        str=str+key2[i];
    }
    //System.out.println("In keyforphase1 str="+str);
    
    // this for key2 to be stored in a text file
    
    BufferedWriter writer = null;
            try
            {
                writer = new BufferedWriter( new FileWriter("Client/key2.txt"));
                writer.write(str);

            }
            catch ( IOException e)
            {
            }
            finally
            {
            try
             {
              if (writer != null)
                writer.close( );
              }
             catch (IOException e)
              {
               }
             }
        
    }

    
    
}


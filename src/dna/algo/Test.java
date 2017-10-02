/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
/**
 *
 * @author yogi
 */
public class Test 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException 
    {
        // TODO code application logic here
  
     String str="yogendra";
     //byte[] bytes = str.getBytes("US-ASCII");
     byte[] bytes = str.getBytes();
     
     for(int i=0;i<bytes.length;i++)
      {
        System.out.print(bytes[i]);
      }
        String str1=AsciiToBinary(str);
        System.out.println("\n"+str1);
    }
    public static String AsciiToBinary(String asciiString)
     {  

          byte[] bytes = asciiString.getBytes();  
          StringBuilder binary = new StringBuilder();  
          for (byte b : bytes)  
          {  
             int val = b;  
             for (int i = 0; i < 8; i++)  
             {  
                binary.append((val & 128) == 0 ? 0 : 1);  
                val <<= 1;  
             }  
            // binary.append(' ');  
          }  
          return binary.toString();  
    }
   /* private static String asciiToHex(String asciiValue)
     {
      char[] chars = asciiValue.toCharArray();
      StringBuffer hex = new StringBuffer();
       for (int i = 0; i < chars.length; i++)
       {
          hex.append(Integer.toHexString((int) chars[i]));
       }
      return hex.toString();
     } 
    static String getBits(byte b)
   {
    String result = "";
    for(int i = 0; i < 8; i++)
        result += (b & (1 << i)) == 0 ? "0" : "1";
    return result;
   }
    
static String hexToBin(String s) 
{
    String preBin = new BigInteger(s, 16).toString(2);
    Integer length = preBin.length();
    if (length < 8) {
        for (int i = 0; i < 8 - length; i++) {
            preBin = "0" + preBin;
        }
    }
    return preBin;
}*/
}
   

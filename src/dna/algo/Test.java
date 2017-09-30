/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author yogi
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO code application logic here
  
String str="yogendra";
byte[] bytes = str.getBytes("US-ASCII");
for(int i=0;i<bytes.length;i++)
{
System.out.print(bytes[i]);
}
}
}
   

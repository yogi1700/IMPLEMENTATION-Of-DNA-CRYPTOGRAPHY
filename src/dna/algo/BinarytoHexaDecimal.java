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
public class BinarytoHexaDecimal // this class is binary to hexdecimal conversion
{
static int num;	
public String calcualte(String str) 
{
//System.out.println("Binary to HexaDecimal");	
num = Integer.parseInt(str, 2);	
String hexa = Integer.toHexString(num);
//System.out.println("HexaDecimal Value is : " + hexa);
StringBuilder sb = new StringBuilder();
StringBuilder temp = new StringBuilder();

//49204c6f7665204a617661 split into two characters 49, 20, 4c...
for( int i=0; i<hexa.length()-1; i+=2 )
{

//grab the hex in pairs
String output = hexa.substring(i, (i + 2));
//convert hex to decimal
int decimal = Integer.parseInt(output, 16);
//convert the decimal to character
sb.append((char)decimal);
temp.append(decimal);
	  
}
//System.out.println("Decimal : " + temp.toString());
String str2=temp.toString();
int str3=Integer.parseInt(str2);
//System.out.println((char)(str3));

return Character.toString((char)(Integer.parseInt((temp.toString()))));
}
}


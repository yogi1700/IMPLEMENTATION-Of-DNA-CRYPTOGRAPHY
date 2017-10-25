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
public class GetBackyourkey2 
{
    public static int  [] key2=new int[16];
    public static int  [] key_main=new int[16];
    
    public void getback(String str)
    {
        
     
     for(int i=0 ,j=0;i<str.length();j++)
     {
      //taking four string of str   
      String check=Character.toString(str.charAt(i))+
              Character.toString(str.charAt(i+1))+
              Character.toString(str.charAt(i+2))+Character.toString(str.charAt(i+3));
         //System.out.println(" check="+check);
        
        int binary=Integer.parseInt(check);
        int decimal = 0;
        int power = 0;
        
        // converting to decimal value and storing in key2
        while(true)
        {
            if(binary == 0){
                //System.out.println(" decimal="+decimal);
                key2[j]=decimal;
                //System.out.println(" key2="+key2[decimal]);
                break;
            } else {
                int tmp = binary%10;
                decimal += tmp*Math.pow(2, power);
                binary = binary/10;
                power++;
            }
        }
        i=i+4;
    }
     
     //storing index value of key2 to at index value to key_main.
     for(int j=0;j<16;j++)
     {
      
         //System.out.println(" no   "+key2[j]);
         key_main[key2[j]]=j;
     }    
        //System.out.println(" Now key_main \n");
     /*for(int j=0;j<16;j++)
     {
      
         System.out.print(" "+key_main[j]);
     } */   
     
     
     
    
}
}

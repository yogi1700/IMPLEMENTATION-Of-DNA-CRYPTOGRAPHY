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
public class DecryptionPhase2WithThreads extends Thread
{
    String a="";
    int start_index;
    int length;
    int id;
    
    DecryptionPhase2WithThreads(String message, int i, int i0, int i1) 
    {
        a=message;
        start_index=i;
        length=i0;
        id=i1;
    }
    
    public void run()
    {
        DecryptionPhase1withThreads dt=new DecryptionPhase1withThreads();
        DecryptionPhase2 dp=new DecryptionPhase2();
        //System.out.print("\na="+a+"  and start_index="+start_index+"\n and length in threadss="+length+"\n");
        //System.out.println("threads"+id);
        for(int i=start_index;i<length;i++)
        {
            //System.out.println("\n condition="+a.charAt(i)+
              //      " and "+dt.key.charAt(0)+" and "+dt.key.charAt(1)+" and "+dt.key.charAt(2)+" and "+dt.key.charAt(3)+"\n");
            
            if(a.charAt(i)==dt.key.charAt(0))
            {
                dp.DecryptMessage2[i]="00";
            }
            
            if(a.charAt(i)==dt.key.charAt(1))
            {
                dp.DecryptMessage2[i]="01";
            }
            
            if(a.charAt(i)==dt.key.charAt(2))
            {
                dp.DecryptMessage2[i]="10";
            }
            
            if(a.charAt(i)==dt.key.charAt(3))
            {
                dp.DecryptMessage2[i]="11";
            }
        }
        
    }
    
    
}

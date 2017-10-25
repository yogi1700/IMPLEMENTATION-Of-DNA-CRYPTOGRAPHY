package dna.algo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yogi
 */
public class ThreadClassforPhase2 extends Thread // this class is for encrypted message for threads
{
    String str,su="";
    int len,id,start_index;
    public ThreadClassforPhase2(String a,int start,int length,String sum,int i)
    {
        str=a;
        len=length;
        su=sum;
        id=i;
        start_index=start;
        
        
    }
    public void run() 
    {
          
        
        //System.out.println(" In thread"+id);
        EncryptionPhase2withThread nw=new EncryptionPhase2withThread();
        for(int i=start_index,j=start_index*2;i<len;)
        {
             if (str.charAt(i)== 'A') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[0].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[1].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[2].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[3].charAt(s);
                }
            }
              if (str.charAt(i)== 'T') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[4].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[5].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[6].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[7].charAt(s);
                }
            }
               if (str.charAt(i)== 'G') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[8].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[9].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[10].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[11].charAt(s);
                }
            }
             if (str.charAt(i)== 'C') 
            {
                if (str.charAt(i + 1) == 'A')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[12].charAt(s);
                }
                if (str.charAt(i + 1) == 'T')
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[13].charAt(s);
                }
                if (str.charAt(i + 1) == 'G') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[14].charAt(s);
                }
                if (str.charAt(i + 1) == 'C') 
                {
                    for(int k=j,s=0;k<j+4&&s<4;k++,s++)
                       nw.global[k]=nw.encode[15].charAt(s);
                }
            }
              
            i=i+2;
            j=j+4;
       }
      
    }
    
}

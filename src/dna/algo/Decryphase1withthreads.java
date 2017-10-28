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
public class Decryphase1withthreads extends Thread
{
  static String[] string={"AA","AT","AG","AC","TA","TT","TG","TC","GA","GT","GG","GC","CA","CT","CG","CC"};
  String a="";
  int start_index;
  int length;
  int id;
  

    Decryphase1withthreads(String message, int i, int i0, int i1) 
    {
        a=message;
        start_index=i;
        length=i0;
        id=i1;        
    }
  public void run()
  {
  GetBackyourkey2 gb=new GetBackyourkey2(); 
  DecryptionPhase1withThreads dp=new DecryptionPhase1withThreads();
  for(int i=start_index,j=start_index/4;i<length;j++)
  {
       String check=Character.toString(a.charAt(i))+
              Character.toString(a.charAt(i+1))+
              Character.toString(a.charAt(i+2))+Character.toString(a.charAt(i+3));
      //System.out.println("j="+j);
      if(check.equals("0000"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[0]];
      }
      if(check.equals("0001"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[1]];
      }
      if(check.equals("0010"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[2]];
      }
      if(check.equals("0011"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[3]];
      }
      if(check.equals("0100"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[4]];
      }
      if(check.equals("0101"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[5]];
      }
      if(check.equals("0110"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[6]];
      }
      if(check.equals("0111"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[7]];
      }
      if(check.equals("1000"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[8]];
      }
      if(check.equals("1001"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[9]];
      }
      if(check.equals("1010"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[10]];
      }
      if(check.equals("1011"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[11]];
      }
      if(check.equals("1100"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[12]];
      }
      if(check.equals("1101"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[13]];
      }
      if(check.equals("1110"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[14]];
      }
      if(check.equals("1111"))
      {
          dp.DecryptMessage[j]=string[gb.key_main[15]];
      }
   i=i+4;
  }
  }
}

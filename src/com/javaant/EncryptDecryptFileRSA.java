package com.javaant;
import java.io.File;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import org.apache.commons.io.FileUtils;
class MyRSACipher 
{
  public static KeyPair getRSAKeyPair() throws NoSuchAlgorithmException 
  {
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(2048);
    KeyPair kp = kpg.generateKeyPair();
    return kp;
  }
  
  public static byte[] encryptFile(byte[] inputBytes, PublicKey key, String xform) throws Exception 
  {
    Cipher cipher = Cipher.getInstance(xform);
    cipher.init(Cipher.ENCRYPT_MODE, key);
    return cipher.doFinal(inputBytes);
  }
  public static byte[] decryptFile(byte[] inputBytes, PrivateKey key, String xform) throws Exception 
  {
    Cipher cipher = Cipher.getInstance(xform);
    cipher.init(Cipher.DECRYPT_MODE, key);
    return cipher.doFinal(inputBytes);
  }
}
public class EncryptDecryptFileRSA {
  public static void main(String[] args) throws Exception {
        
    // TODO Auto-generated method stub
    long startTime1= System.currentTimeMillis();
    
    String fileToEncrypt = "/home/yogi/Desktop/HPC_Project/encryption/aes.txt";
    String encryptedFile = "/home/yogi/Desktop/HPC_Project/encryption/file-after-encryption";
    String decryptedFile = "/home/yogi/Desktop/HPC_Project/encryption/file-after-decryption";
    
    
    
    // Generate a key-pair
    KeyPair keyPari = MyRSACipher.getRSAKeyPair();
    PublicKey publicKey = keyPari.getPublic();
    PrivateKey privatekey = keyPari.getPrivate();
    
    
    long startTime2= System.currentTimeMillis();
    
    File file = new File(fileToEncrypt);
    byte[] dataBytes = FileUtils.readFileToByteArray(file);
    // Encrypt the file
    String algo = "RSA/ECB/PKCS1Padding";
    byte[] encryptedBytes = MyRSACipher.encryptFile(dataBytes, publicKey, algo);
    
    
    
    file = new File(encryptedFile);
    FileUtils.writeByteArrayToFile(file, encryptedBytes);
    
    
    long estimatedTime1= System.currentTimeMillis() - startTime2;
    
    System.out.println("\ntime taken by encryption="+estimatedTime1);
    
    
    System.out.println("Encrypted file : " + encryptedFile);
    // Decrypt the file
    
    long startTime3= System.currentTimeMillis();
    
    byte[] decryptedBytes = MyRSACipher.decryptFile(encryptedBytes, privatekey, algo);
    file = new File(decryptedFile);
    FileUtils.writeByteArrayToFile(file, decryptedBytes);
    System.out.println("Decrypted file : " + decryptedFile);
    
    long estimatedTime = System.currentTimeMillis() - startTime3;
    System.out.println("\ntime taken by total="+estimatedTime);
    
    long estimatedTime0= System.currentTimeMillis() - startTime1;
    System.out.println("\ntime taken by total="+estimatedTime0);
    
    
    
    
  }
}
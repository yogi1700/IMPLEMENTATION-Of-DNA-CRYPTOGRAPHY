/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

/**
 *
 * @author yogi
 */
public class ReceiverRSA 
{
    String data="";
    private static final String PUBLIC_KEY_FILE = "Public_receiver.key";
    private static final String PRIVATE_KEY_FILE = "Private_receiver.key";
    
    void ReceiverRSA1() throws IOException
    {
        try {
			//System.out.println("-------GENRATE PUBLIC and PRIVATE KEY-------------");
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048); //1024 used for normal securities
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			//System.out.println("Public Key - " + publicKey);
			//System.out.println("Private Key - " + privateKey);
                        String outFile="Public_receiver_read.key";
                        Base64.Encoder encoder = Base64.getEncoder();
                        Writer out = new FileWriter("Server/"+outFile);
                        out = new FileWriter("Server/"+outFile);
                        out.write(encoder.encodeToString(publicKey.getEncoded()));
                        out.close();
			//Pullingout parameters which makes up Key
			//System.out.println("\n------- PULLING OUT PARAMETERS WHICH MAKES KEYPAIR----------\n");
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec rsaPrivKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
			//System.out.println("PubKey Modulus : " + rsaPubKeySpec.getModulus());
			//System.out.println("PubKey Exponent : " + rsaPubKeySpec.getPublicExponent());
			//System.out.println("PrivKey Modulus : " + rsaPrivKeySpec.getModulus());
			//System.out.println("PrivKey Exponent : " + rsaPrivKeySpec.getPrivateExponent());
			
			//Share public key with other so they can encrypt data and decrypt thoses using private key(Don't share with Other)
			//System.out.println("\n--------SAVING PUBLIC KEY AND PRIVATE KEY TO FILES-------\n");
			saveKeys(PUBLIC_KEY_FILE, rsaPubKeySpec.getModulus(), rsaPubKeySpec.getPublicExponent());
			saveKeys(PRIVATE_KEY_FILE, rsaPrivKeySpec.getModulus(), rsaPrivKeySpec.getPrivateExponent());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

	}
    private void saveKeys(String fileName,BigInteger mod,BigInteger exp) throws IOException{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//System.out.println("Generating "+fileName + "...");
			fos = new FileOutputStream("Server/"+fileName);
			oos = new ObjectOutputStream(new BufferedOutputStream(fos));
			
			oos.writeObject(mod);
			oos.writeObject(exp);			
			
			//System.out.println(fileName + "generated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(oos != null){
				oos.close();
				
				if(fos != null){
					fos.close();
				}
			}
		}		
	}
	
	/**
	 * Encrypt Data
	 * @param data
	 * @throws IOException
	 */
	public byte[] encryptData(String data) throws IOException 
        {
        	//System.out.println("\n----------------ENCRYPTION STARTED------------");
	        
		//System.out.println("Data Before Encryption :" + data);
		byte[] dataToEncrypt = data.getBytes();
		byte[] encryptedData = null;
		try {
			PublicKey pubKey = readPublicKeyFromFile("Server/"+PUBLIC_KEY_FILE);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			encryptedData = cipher.doFinal(dataToEncrypt);
			//System.out.println("Encryted Data: " + encryptedData);			
                        // ... do something ...
                        
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		//System.out.println("----------------ENCRYPTION COMPLETED------------");		
		return encryptedData;
	}

	/**
	 * Encrypt Data
	 * @param data
	 * @throws IOException
	 */
	public byte[] decryptData(byte[] data) throws IOException,BadPaddingException {
		//System.out.println("\n----------------DECRYPTION STARTED------------");
		byte[] descryptedData = null;
                
		try {
			PrivateKey privateKey = readPrivateKeyFromFile("Server/"+PRIVATE_KEY_FILE);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			descryptedData = cipher.doFinal(data);
			//System.out.println("Decrypted Data: " + new String(descryptedData));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		//System.out.println("----------------DECRYPTION COMPLETED------------");
                return descryptedData;
	}
	
	/**
	 * read Public Key From File
	 * @param fileName
	 * @return PublicKey
	 * @throws IOException
	 */
	public PublicKey readPublicKeyFromFile(String fileName) throws IOException{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(fileName));
			ois = new ObjectInputStream(fis);
			
			BigInteger modulus = (BigInteger) ois.readObject();
		    BigInteger exponent = (BigInteger) ois.readObject();
			
		    //Get Public Key
		    RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
		    KeyFactory fact = KeyFactory.getInstance("RSA");
		    PublicKey publicKey = fact.generatePublic(rsaPublicKeySpec);
		    		    
		    return publicKey;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(ois != null){
				ois.close();
				if(fis != null){
					fis.close();
				}
			}
		}
		return null;
	}
	
	/**
	 * read Public Key From File
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public PrivateKey readPrivateKeyFromFile(String fileName) throws IOException{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(new File(fileName));
			ois = new ObjectInputStream(fis);
			
			BigInteger modulus = (BigInteger) ois.readObject();
		    BigInteger exponent = (BigInteger) ois.readObject();
			
		    //Get Private Key
		    RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
		    KeyFactory fact = KeyFactory.getInstance("RSA");
		    PrivateKey privateKey = fact.generatePrivate(rsaPrivateKeySpec);
		    		    
		    return privateKey;
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			if(ois != null){
				ois.close();
				if(fis != null){
					fis.close();
				}
			}
		}
		return null;
	}
            
}

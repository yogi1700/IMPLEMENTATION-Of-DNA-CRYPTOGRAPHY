/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna.algo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

/**
 *
 * @author yogi
 */
public class GenerateKeyforReceiver 
{
    String data="";
    private static final String PUBLIC_KEY_FILE = "Public_receiver.key";
    private static final String PRIVATE_KEY_FILE = "Private_receiver.key";
    
    void ReceiverRSA() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        try {
			System.out.println("-------GENRATE PUBLIC and PRIVATE KEY-------------");
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048); //1024 used for normal securities
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			System.out.println("Public Key - " + publicKey);
			System.out.println("Private Key - " + privateKey);
                        String outFile="Public_receiver_read.key";
                        Base64.Encoder encoder = Base64.getEncoder();
                        Writer out = new FileWriter(outFile);
                        out = new FileWriter(outFile);
                        out.write(encoder.encodeToString(publicKey.getEncoded()));
                        out.close();
			//Pullingout parameters which makes up Key
			System.out.println("\n------- PULLING OUT PARAMETERS WHICH MAKES KEYPAIR----------\n");
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPubKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec rsaPrivKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
			System.out.println("PubKey Modulus : " + rsaPubKeySpec.getModulus());
			System.out.println("PubKey Exponent : " + rsaPubKeySpec.getPublicExponent());
			System.out.println("PrivKey Modulus : " + rsaPrivKeySpec.getModulus());
			System.out.println("PrivKey Exponent : " + rsaPrivKeySpec.getPrivateExponent());
			
			//Share public key with other so they can encrypt data and decrypt thoses using private key(Don't share with Other)
			System.out.println("\n--------SAVING PUBLIC KEY AND PRIVATE KEY TO FILES-------\n");
			//saveKeys(PUBLIC_KEY_FILE, rsaPubKeySpec.getModulus(), rsaPubKeySpec.getPublicExponent());
			//saveKeys(PRIVATE_KEY_FILE, rsaPrivKeySpec.getModulus(), rsaPrivKeySpec.getPrivateExponent());
			
		} 
                catch (NoSuchAlgorithmException e)
                {
			e.printStackTrace();
		}catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
    }
}

    


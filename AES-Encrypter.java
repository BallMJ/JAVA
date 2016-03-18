/* - CREATED BY MATT - 
*
*This is an AES Encrypter and Decrypter which reads text on the commandline and Encrypts it and Decrypts it in real time 
* THIS CODE IS STILL IN DEVELOPMENT (quite rough around the edges)
*
*/
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import java.io.*;

import sun.misc.BASE64Encoder;


class AES-Encrypter{
	
	public static void main(String[] args){
		
		String strDataToEncrypt = new String();
		String strCipherText = new String();
		String strDecryptedText = new String();
		
		try{
			//Generating an AES key using KeyGenerator 
			//Initialising keysize to 128 bits (16 bytes)
			
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			SecretKey secretKey = keyGen.generateKey();
			
			//Generating an Initialisation vector (IV)
			//Use SecureRandom to generate random bits
			//The size of the IV matches the blocksize of the ciper (128 bits for AES)
			//Construct the appropriate IvParameterSpec object for the data to pass to Cipher's init() method
			
			final int AES_KEYLENGTH = 128; //Change this as desired for whatever security level you want
			byte[] iv = new byte[AES_KEYLENGTH / 8];//Save the IV bytes or send it in plaintext with the encrypted data so you can decrypt the data for later
			SecureRandom prng = new SecureRandom();
			prng.nextBytes(iv);
			
			//Creating a Cipher by specifying the following parameters
			// Algorithm name - AES
			// Mode - CBC mode
			// Padding - PKCS5
			//...Cipher.getInstance("ALGORITHM NAME/MODE/PADDING");
			
			Cipher aesCipherForEncryption = Cipher.getInstance("AES/CBC/PKCS5PADDING"); //Specifying CBC mode explicitly as most JCE providers default to ECB mode
			
			//Initalising the Cipher for Encryption
			
			aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
			
			//ENCRYPTING THE DATABUFFER
			//Below section of code is still being reworked to encrypt specified files
			System.out.println("what do you want to encrypt? ");
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			String input = br.readLine();
			br.close();
			
			
			
			String test = "text";
			
			if (input.equals(test)){
				System.out.println("Please input text into the commandline- ");
				
				InputStreamReader inptsr = new InputStreamReader(System.in);
				BufferedReader bufr = new BufferedReader(inptsr);
				String cmdinput = bufr.readLine();
				strDataToEncrypt = cmdinput;
				bufr.close();
				
				
				
				
			}
			
			
			
			System.out.println("Message to be encrypted: "+strDataToEncrypt);
			byte[] byteDataToEncrypt = strDataToEncrypt.getBytes();
			byte[] byteCipherText = aesCipherForEncryption.doFinal(byteDataToEncrypt);
			
			strCipherText = new BASE64Encoder().encode(byteCipherText);
			System.out.println("Cipher text generated useing AES Encryption: "+strCipherText);
			
			//DECRYPTING THE DATA
			//Decrypting the cipher bytes using doFinal method
			
			Cipher aesCipherForDecryption = Cipher.getInstance("AES/CBC/PKCS5PADDING"); //Using CBC mode rather than the default ECB
			aesCipherForDecryption.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
			byte[] byteDecryptedText = aesCipherForDecryption.doFinal(byteCipherText);
			strDecryptedText = new String(byteDecryptedText);
			System.out.println("Decrypted Text is: "+strDecryptedText);
			
		//Catch statements for exception errors
		}catch (NoSuchAlgorithmException noSuchAlgo){
			System.out.println("No such algorithm exists "+noSuchAlgo);
		}catch (NoSuchPaddingException noSuchPad){
			System.out.println("No such Padding exists "+noSuchPad);
		}catch (InvalidKeyException invalKey){
			System.out.println("Invalid key "+invalKey);
		}catch (BadPaddingException badPad){
			System.out.println("Bad padding "+badPad);
		}catch (IllegalBlockSizeException illegalBlockSize){
			System.out.println("Illegal Block Size "+illegalBlockSize);
		}catch (InvalidAlgorithmParameterException invalidAlgoParam){
			System.out.println("Invalid algorithm parameters "+invalidAlgoParam);
		}catch (Exception e){
			System.out.println("Please input text");
		}
	}
}
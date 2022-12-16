/**
Crypt file input and output decorators in Java. It takes a numbered key (a long) and uses 
that to initialize a random number generator and then successively XORs each byte read/written 
with the nextInt() (next random byte). 
*/

import java.util.Scanner;
import cryptRandom.*;

/**
 * Main driver class
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  
        
        /** Sample Input Text */
        String sampleText = "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts";
        
        /** Input Long Key for crypt operations*/
        System.out.print("Crypt Handler \nEnter the Key for Operations: ");  
        long key = sc.nextLong();
        int intKey=(int)key; 

        System.out.println("1.Write a File\n2.Read a File\n3.Run Crypt on File\n\nCtrl+C To Exit");
        int choice=sc.nextInt();
        
        /** For Writing Sample text to file and printing it out*/
        if(choice==1){
            CryptInterface writertoFile= new FileReaderWriter("./output.txt");
            writertoFile.writeData(sampleText,intKey);
            System.out.println("Data written to file");
            System.out.println(writertoFile.readData(intKey));
        }

        /** To Read contents of the file */
        else if(choice==2){
            CryptInterface readerofFile = new FileReaderWriter("./output.txt");
            System.out.println("File Content:");
            System.out.println(readerofFile.readData(intKey));
        }

        /**To encrypt the file show the encrypted/decrypted data and the status of thhe file content
         * Encrypt Decorator is used on the 
        */
        else if(choice==3){
            FileIODecorator encrypter =new EncryptDecorator(new FileReaderWriter("./output.txt"));
            encrypter.writeData(sampleText,intKey);
            encrypter.randomGenerator(intKey);
            System.out.println("\nFile Content");
            CryptInterface plain = new FileReaderWriter("./output.txt");
            System.out.println(plain.readData(intKey));
        }
        sc.close();
    }
}
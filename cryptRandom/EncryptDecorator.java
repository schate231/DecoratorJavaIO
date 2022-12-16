package cryptRandom;
import java.util.Random;

/**
 * Encryption Decorator Class which extends the File decorator and,
 * Generates the random number key using the input key from user, which is used for encrypting the file content.
 */
public class EncryptDecorator extends FileIODecorator {

    public EncryptDecorator(CryptInterface source) {
        super(source);
       }

    public Integer randomGenerator(Integer key){
        Random rand = new Random(key);
        int num = rand.nextInt(); 
        return num; 
    }
    @Override
    public void writeData(String data,Integer key) {
        super.writeData(encode(data,key),key);
    }

    private String encode(String data,Integer key) {
        Integer RandomNum=randomGenerator(key);
        System.out.println("Random number generated\t"+RandomNum);
        byte[] result = data.getBytes(); /**converting the file content into bytes */

        String encryptString = "";
        for (int i = 0; i < result.length; i++) {
            encryptString = encryptString +
            Character.toString((char) (data.charAt(i) ^ RandomNum)); /** XOR operation on each byte */
        }

        System.out.println("\nencryptString");
        System.out.println("out>\n"+encryptString);
        
        String decryptString = "";
        for (int i = 0; i < encryptString.length(); i++) {
            decryptString = decryptString +
            Character.toString((char) (encryptString.charAt(i) ^ RandomNum)); /** XOR operation to decrypt the file content byte by byte */
        }
        System.out.println("\ndecryptString");
        System.out.println("out>\n"+decryptString);
        
        return encryptString;
    }
}
package cryptRandom;
import java.io.*;

/**
 * File read write operations using Java IO 
 */
public class FileReaderWriter implements CryptInterface {
    private String name;

    public FileReaderWriter(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data,Integer key) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData(Integer key) {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buffer);
    }

    @Override
    public Integer randomGenerator(Integer key) {
        return null;
    }
}
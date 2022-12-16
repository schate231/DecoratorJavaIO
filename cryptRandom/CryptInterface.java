package cryptRandom;

/*
 * Interface for Reading, Writing and generating a random number
 */
public interface CryptInterface {
    void writeData(String data,Integer key);

    String readData(Integer key);

    Integer randomGenerator(Integer key);
}
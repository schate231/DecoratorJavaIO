package cryptRandom;

/**Base Decorator for file methods  */
public class FileIODecorator implements CryptInterface {
    private CryptInterface wrapper;

    FileIODecorator(CryptInterface source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data,Integer key) {
        wrapper.writeData(data,key);
    }

    @Override
    public String readData(Integer key) {
        return wrapper.readData(key);
    }

    @Override
    public Integer randomGenerator(Integer key){
        return wrapper.randomGenerator(key);
    }

}
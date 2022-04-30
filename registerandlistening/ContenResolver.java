package registerandlistening;

public class ContenResolver {
    public ContenResolver() {}
    public void registerContentObserver(String key,  ContentObserver obs) {
        Common.getInstall().setList(key, obs);
    }
}
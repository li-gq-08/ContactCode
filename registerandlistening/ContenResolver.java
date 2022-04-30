package registerandlistening;

public class ContenResolver {
    public ContenResolver() {}
    public void registerContentObserver(String key,  ContentObserver obs) {
        Common.getInstall().addItem(key, obs);
    }
    public void unregisterContentObserver(String key, ContentObserver obs) {
        Common.getInstall().removeItem(key, obs);
    }
}
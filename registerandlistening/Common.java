package registerandlistening;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;
public class Common {
    String TAG = "funTest";
    private static Common install = null;
    private HashMap<String ,ContentObserver> ContentObservermap = new HashMap<>();
    private HashMap<String, Object> providerMap = new HashMap<>();
    public static Common getInstall() {
        try {
            if(install == null) {
                install = new Common();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return install;
    }
    public void addItem(String key,ContentObserver obs ) {
        if(key.equals("")) {
            log.d(TAG, "registerContentObserver key is null");
            return ;
        }
        ContentObservermap.put(key, obs);
    }

    public void removeItem(String key,ContentObserver obs) {
        ContentObservermap.remove(key, obs);
    }
    public void addItem(String key, Object value){
        if(key.equals("")) {
            log.d(TAG, "putString key is null");
            return ;
        }
        providerMap.put(key, value);
        for(String str : ContentObservermap.keySet()) {
            if(str.equals(key)) {
                ContentObserver obj = ContentObservermap.get(key);
                obj.change(getItem(key));
            }
        }
    }
    public Object getItem(String key) {
        return  providerMap.get(key);
    }
}

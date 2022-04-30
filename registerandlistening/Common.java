package registerandlistening;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;
public class Common {
    String TAG = "funTest";
    private static Common install = null;
    private HashMap<String ,ContentObserver> map = new HashMap<>();
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
    public void setList(String key,ContentObserver obs ) {
        map.put(key, obs);
    }

    public void setList(String key, Object value){
        providerMap.put(key, value);
        for(String str : map.keySet()) {
            if(str.equals(key)) {
                ContentObserver obj = map.get(key);
                obj.change(getList(key));
            }
        }
    }
    public Object getList(String key) {
        return  providerMap.get(key);
    }
}

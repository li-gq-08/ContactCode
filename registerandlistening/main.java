package registerandlistening;
import java.lang.String;
public class main {
    public static void main(String[] args){ 
        String TAG = "funTest";
        log.d(TAG,"start");
        settingProvider.putString("Test","1");
        settingProvider.putString("BOOL",true);
        ContenResolver resolver = new ContenResolver();
        //===================================================//
        ContentObserver stringObserver = null;
        stringObserver = new ContentObserver(){
            @Override
            public  void change(Object obj) {
                // TODO Auto-generated method stub
                log.d(TAG,(String)obj);
            }

        };
        resolver.registerContentObserver("Test", stringObserver);

        //===================================================//
        ContentObserver boolObserver = null;
        boolObserver = new ContentObserver(){
            @Override
            public void change(Object obj) {
                // TODO Auto-generated method stub
                log.d(TAG,(Boolean)obj);
            }

        };
        resolver.registerContentObserver("BOOL", boolObserver);


        settingProvider.putString("Test","liguoqiang");
        settingProvider.putString("BOOL",false);
    }
}

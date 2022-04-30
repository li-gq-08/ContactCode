package registerandlistening;
public class settingProvider<T> {

    private static settingProvider install = new settingProvider();
    // public static settingProvider getInstall() {
    //     try {
    //         if(install == null) {
    //             install = new settingProvider(); 
    //         }
    //     } catch (Exception e) {
            
    //     }
    //     return install;
    // }

    public static void putString(String key, Object value){
        Common.getInstall().setList(key, value);
    }
    public static Object getString(String key){
        return  Common.getInstall().getList(key);
    }

}
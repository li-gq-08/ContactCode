package registerandlistening;
import java.lang.String;
public class log {
    private static log install = new log();
    public static void d(String Tag, Object str) {
        System.out.println(Tag + ":" + str);
    }

}

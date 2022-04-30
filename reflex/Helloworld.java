package reflex;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Helloworld{ 

public static void main(String[] args){ 
    Class test = null;
    try{
         test =  Class.forName("testMethod");
         System.out.println("--------------");
    }catch(Throwable e){
        System.out.println("==============");
        System.out.print(e.toString());
    }

        System.out.println("==========================================================================");
        

        // 获取对象的所有公有属性。
        Field[] fields = test.getFields();

        for (Field f : fields) {
            System.out.println("==============");
            System.out.println(f);
        }
        System.out.println("---------------------");
        // 获取对象所有属性，但不包含继承的。
        Field[] declaredFields = test.getDeclaredFields();
        for (Field ff : declaredFields) {
            System.out.println("》》》》》》》》》》》》》》");
            System.out.println(ff);
        }
        System.out.println("==========================================================================");
        
        // 获取对象的所有公共方法
        Method[] methods = test.getMethods();
        for (Method m : methods) {
            System.out.println("》》》》》》》》》》》》");
            System.out.println(m);
        }
        
        // 获取对象所有方法，但不包含继承的
        Method[] declaredMethods = test.getDeclaredMethods();
        for (Method ms : declaredMethods) {
            System.out.println("---------------------------");
            System.out.println(ms);
        }

        System.out.println("==========================================================================");
        

        // 获取对象所有的公共构造方法
        Constructor[] constructors = test.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("---------------------");
        // 获取对象所有的构造方法
        Constructor[] declaredConstructors = test.getDeclaredConstructors();
        for (Constructor con : declaredConstructors) {
            System.out.println(con);
        }

        System.out.println("==========================================================================");
        
        System.out.println(test.getName());//获取对象全限定名称
        System.out.println(test.getPackage());// 获取包名
        Class[] interfaces = test.getInterfaces();//获取该类实现的所有接口
        for (Class in : interfaces) {
            System.out.println(in);
        }

        System.out.println("==========================================================================");

        try {
            //获取class对象
            Class c = Class.forName("testMethod");
            testMethod stu1 = (testMethod) c.newInstance();
 
            // 第一种方法，实例化默认构造方法，调用set赋值
            // stu1.setAddress("深圳南山");
            System.out.println(stu1);
 
            // // 第二种方法 取得全部的构造函数 使用构造函数赋值
            Constructor<testMethod> constructor = c.getConstructor(String.class, 
                     String.class, int.class);
                    testMethod stu2 = (testMethod) constructor.newInstance("李四", "nan", 18);
            System.out.println(stu2);
 
            // /**
            //  * 獲取方法并执行方法
            //  */
            Method show = c.getMethod("getBrand");//获取showInfo()方法
            Object object = show.invoke(stu2);//调用showInfo()方法
 
            System.out.println(object);
 
        } catch (Exception e) {
            
            System.out.print("error" + e.toString());
        }


    }
}
package online.stringtek.jvm.advanced.ch2;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args: -XX:PermSize=6M -XX:MaxPermSize=6M 请使用JDK6运行
 * VM Args: -Xmx6m 请使用JDK7之后的版本运行  JDK7之后把字符串常量池移动到了堆中
 * */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        short i=0;
        while(true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
/**
 * JDK 6  返回false false
 * JDK 7+ 返回true false
 * */
class RuntimeConstantPoolOOM2{
    public static void main(String[] args) {
        String str1=new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        String str2=new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}

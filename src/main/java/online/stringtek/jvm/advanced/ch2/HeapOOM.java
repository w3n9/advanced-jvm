package online.stringtek.jvm.advanced.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.4.1 Java堆溢出
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=~/HeapOOM.dump
 * */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}

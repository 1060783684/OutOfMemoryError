package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+HeapOnOutOfMemoryError
 *
 * 测试堆内存溢出异常
 *
 * @author Worry
 */
public class HeapOutOfMemory {
    public void heapLeak(){
        List list = new ArrayList();
        while(true){
            list.add(new int[100000]);
        }
    }

    public void xxx(){

    }

    public static void main(String[] args){
        HeapOutOfMemory hoom = new HeapOutOfMemory();
        hoom.heapLeak();
    }
}

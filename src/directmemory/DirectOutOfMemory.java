package directmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author Worry
 */
public class DirectOutOfMemory {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        List list = new ArrayList();
        int i = 0;
        while (i <= 30){
            list.add(unsafe.allocateMemory(_1MB));
            i++;
            System.out.println(i);
        }
    }
}

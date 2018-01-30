package perm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails
 *
 * 测试永久代OutOfMemory异常,这个方法比较简单,通过字符串常量池完成的,只适用于jdk1.6以前,因为1.7常量池移出永久代,1.8没有永久代了
 *
 * @author Worry
 */
public class PermOutOfMemory {
    public void permLeak(){
        List list = new ArrayList();
        int i = 0;
        while(true){
            list.add(String.valueOf("xxx"+i++).intern());
        }
    }

    public static void main(String[] args){
        PermOutOfMemory poom = new PermOutOfMemory();
        poom.permLeak();
    }
}

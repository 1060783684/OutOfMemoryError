package stack;

/**
 * VM Args: -Xss128M -XX:+HeapDumpOnOutOfMemoryError
 *
 * 测试栈上的OutOfMemory异常 在linux上试不出来,linux系统没有对内存的使用做限制,在windows上可以试出来
 *
 * @author Worry
 */
public class StackOutOfMemory {
    public void dontStop(){
        System.out.println(Thread.currentThread().getName() + "start!");
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args){
        StackOutOfMemory soom = new StackOutOfMemory();
        soom.stackLeakByThread();
    }
}

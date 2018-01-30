package stack;

/**
 * VM Args: -Xss256k
 *
 * 测试栈的Overflow异常
 *
 * @author Worry
 */
public class StackOverflow {
    private int length;

    public void stackLeak(){
        length ++ ;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackOverflow sof = new StackOverflow();
        try {
            sof.stackLeak();
        }catch (Throwable e) {
            System.out.println("Stack depth : " + sof.length);
            throw e;
        }
    }
}

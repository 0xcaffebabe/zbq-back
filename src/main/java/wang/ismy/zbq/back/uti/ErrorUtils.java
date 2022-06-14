package wang.ismy.zbq.back.uti;

public class ErrorUtils {

    public static void error(String s){
        throw new RuntimeException(s);
    }
}

package Commands;

/**
 *
 * @author tgeorg
 */
public class CMDUtils {
    static StringBuilder sb = new StringBuilder();

    public static boolean checkInput(String[] commands, String input){
        boolean flag = false;
        
        for (int i = 0; i < commands.length; i++) {
            if (!input.equals(commands[i])) continue;
            flag = !flag;
            break;
        }
        
        return flag;
    }

    public static void printCommands(String[] commads){
        System.out.print("\n");
        for(String command : commads){
            sb.append(command + "\n");
            System.out.print(sb.toString());
            sb.delete(0, sb.capacity());
        }
    }
}

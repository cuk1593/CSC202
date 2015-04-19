/**
 * Created by admin on 3/19/15.
 */
public class Calculate extends StackClass {
    StackClass stack = new StackClass();
    public String delOperand = "[0-9]";
    public String delOperator = "[-+*/]";
    public String input = postfixEval.outputString;
    public String inputString[] = new String[input.length()];
    public static int answer;

    public Calculate() {
        for (int i = 0; i < input.length(); i++) { //43+
            inputString[i] = Character.toString(input.charAt(i));
            if (inputString[i].matches(delOperand)) {
                stack.push(inputString[i]);
            } else if (inputString[i].matches("[+]")) {
                answer = (Integer.parseInt((String) stack.pop()) + Integer.parseInt((String) stack.pop()));
                stack.push(String.valueOf(answer));
            } else if (inputString[i].matches("[-]")) {
                answer = (Integer.parseInt((String) stack.pop()) - Integer.parseInt((String) stack.pop()));
                stack.push(String.valueOf(answer));
            } else if (inputString[i].matches("[*]")) {
                answer = (Integer.parseInt((String) stack.pop()) * Integer.parseInt((String) stack.pop()));
                stack.push(String.valueOf(answer));
            } else if (inputString[i].matches("[/]")) {
                answer = (Integer.parseInt((String) stack.pop()) / Integer.parseInt((String) stack.pop()));
                stack.push(String.valueOf(answer));
            }
        }
    }
}




/**
 * New Stack Interface
 */
public class postfixEval extends StackClass{
    private String infixString;
    public  StackClass s;
    public static String outputString;

    public postfixEval(String userInput) {
        infixString = userInput;
        s = new StackClass();
        outputString = "";
        boolean firstInput = false;
        for (int i = 0; i < infixString.length(); i++) { // infixString = 4+3
            char currentChar = infixString.charAt(i); // when i = 0, currentChar = 4; when i = 1, currentChar = +; when i = 2, currentChar = 3;
            if(!isOperator(currentChar)) { //true if operator, false if operand
                outputString += Character.toString(currentChar); //outputString = 4
                if(i == (infixString.length()-1)) { // WHEN AT HE END, SO 3
                    //while(!s.isEmpty()) { // WHEN STACK IS NOT EMPTY
                        outputString += s.pop(); // APPEND TOP OF STACK TO outputString
                    //}
                }
            } else {
                if(firstInput) {
                    if(pMin(currentChar) && pMin((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(currentChar);
                        if(i == (infixString.length()-1)) {
                            while(!s.isEmpty()) {
                                outputString += s.pop();
                            }
                        }
                    } else if(pMax(currentChar) && pMax((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(currentChar);
                        if(i == (infixString.length()-1)) {
                            while(!s.isEmpty()) {
                                outputString += s.pop();
                            }
                        }
                    } else if(pMin(currentChar) && pMax((Character)s.peek())) {
                        outputString += s.pop();
                        s.push(currentChar);
                        if(i == (infixString.length()-1)) {
                            while(!s.isEmpty()) {
                                outputString += s.pop();
                            }
                        }
                    } else if(pMax(currentChar) && pMin((Character)s.peek())) {
                        s.push(currentChar);
                        if(i == (infixString.length()-1)) {
                            while(!s.isEmpty()) {
                                outputString += s.pop();
                            }
                        }
                    } else {
                        outputString += Character.toString(currentChar);
                        if(i == (infixString.length()-1)) {
                            while(!s.isEmpty()) {
                                outputString += s.pop();
                            }
                        }
                    }
                } else {
                    s.push(currentChar);
                    firstInput = true;
                }
            }
        }
    }



    public boolean pMin(char op) {
        switch(op) {
            case '+':
                return true;
            case '-':
                return true;
            default:
                return false;
        }
    }

    public boolean pMax(char op) {
        switch(op) {
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }


    public boolean isOperator (char op) {
        switch(op) {
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }




    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        new formGUI().setVisible(true);
                    }
                }
        );
    }

}

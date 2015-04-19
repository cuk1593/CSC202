import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Stack;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

/**
 *
 * @author Han sol Shin
 */

public class formGUI extends JFrame {

    private static javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lblInfix;
    private javax.swing.JLabel lblPostfix;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTextField txtInfix;
    private javax.swing.JTextField txtPostfix;
    private javax.swing.JTextField txtResult;
    public static String userInput;
    private static final String[][] ORDER = {{"+", "0"}, {"-", "0"}, {"*", "1"}, {"/", "1"}};
    private static String operators, operands;

    public formGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        lblPostfix = new javax.swing.JLabel();
        lblInfix = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        txtInfix = new javax.swing.JTextField();
        txtPostfix = new javax.swing.JTextField();
        txtResult = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTitle.setText("RPN Calculator");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
                pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlTitleLayout.createSequentialGroup()
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
                pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addComponent(lblTitle)
                                .addContainerGap())
        );

        lblPostfix.setText("Post-fix Notation:");

        lblInfix.setText("In-fix Notation:");

        lblResult.setText("Result:");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
                pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblResult)
                                        .addComponent(lblInfix)
                                        .addComponent(lblPostfix))
                                .addGap(12, 12, 12)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtInfix, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                        .addComponent(txtResult)
                                        .addComponent(txtPostfix))
                                .addGap(54, 54, 54))
        );
        pnlMenuLayout.setVerticalGroup(
                pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPostfix)
                                        .addComponent(txtPostfix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblInfix)
                                        .addComponent(txtInfix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblResult)
                                        .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        btnExit.setText("Exit");

        btnCalculate.setText("Calculate");

        btnClear.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(btnCalculate)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnClear)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnExit)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnExit)
                                        .addComponent(btnCalculate)
                                        .addComponent(btnClear))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();

        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnExitActionPerformed(e);
            }

            private void btnExitActionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalculateActionPerformed(e);
            }

            private void btnCalculateActionPerformed(ActionEvent e) {
                userInput = txtInfix.getText();
                postfixEval pe = new postfixEval(userInput);
                txtPostfix.setText(postfixEval.outputString);
                Calculate a = new Calculate();
                txtResult.setText(Integer.toString(Calculate.answer));
            }
        });

        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnClearActionPerformed(e);
            }

            private void btnClearActionPerformed(ActionEvent e) {
                txtInfix.setText("");
                txtPostfix.setText("");
                txtResult.setText("");
            }

        });


    }
}

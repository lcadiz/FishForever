/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.loan;

import app.controller.LoanController;
import app.controller.LoanLedgerController;
import app.controller.LoanTypeController;
import app.controller.LogController;
import app.controller.PaymentModeController;
import app.global.FunctionFactory;
import static app.global.FunctionFactory.getSystemNowDateTimeString;
import app.model.ComboBoxItem;
import app.view.index.MainFrame;
import static java.awt.EventQueue.invokeLater;
import static java.lang.String.valueOf;
import static java.lang.System.exit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/**
 *
 * @author EngkoiZidac
 */
public class NewLoan extends javax.swing.JDialog {

    public static Loan frmParent;
    static String nowDate = getSystemNowDateTimeString();
    LoanTypeController LoanTypeController = new LoanTypeController();
    static int ComboBoxLoanTypeId;
    public static String nym;
    LoanController Controller = new LoanController();
    LogController LogController = new LogController();
    LoanLedgerController LLController = new LoanLedgerController();
    PaymentModeController PMController = new PaymentModeController();
    public static int Id, PMDivisor;

    public NewLoan(Loan parent, boolean modal) {
        frmParent = parent;
        this.setModal(modal);
        initComponents();
        setLocationRelativeTo(this);
        LoanTypeController.PopulateComboBoxData(ComboLoanType);
        PMController.PopulateComboBoxData(ComboPaymentMode);
        SetDate();
        // System.out.println(Id);
    }

    void AutoCalculate() {
        double InterestRate = 0;
        double Term = 0;
        double PrincipalAmount = 0;
        double TotalAmountDue = 0;
        double InterestAmount = 0;

        double AmountAmortization = 0;
        double NetLoanProceeds = 0;
        double Deduction = 0;

        double LoanBalance = 0;
        double RenewalFee = 0;
        double Penalty = 0;
        double AdvancePayment = 0;
        double ProcessingFee = 0;
        double Others = 0;

        PMController.setId(PMDivisor);
        int PayModeDivisor = PMController.GetDivisor();
        // int Multiplier =PMController.GetMultiplier();

        InterestRate = Double.valueOf(TextInterest.getText().replace(",", ""));
        Term = Double.valueOf(TextTerm.getText().replace(",", ""));
        PrincipalAmount = Double.valueOf(TextPrincipalAmount.getText().replace(",", ""));

        InterestAmount = PrincipalAmount * ((InterestRate / 100) * Term);
        TotalAmountDue = PrincipalAmount + InterestAmount;

        TextTotalAmountue.setText(FunctionFactory.amountFormat(TotalAmountDue));
        CalculateDueDate();

        AmountAmortization = (TotalAmountDue/Term) / PayModeDivisor;
        TextAmortizationAmount.setText(FunctionFactory.amountFormat(AmountAmortization));

        try {
            LoanBalance = Double.valueOf(TextLoanBalance.getText().replace(",", ""));
        } catch (Exception e) {
        }
        try {
            RenewalFee = Double.valueOf(TextRenewalFee.getText().replace(",", ""));
        } catch (Exception e) {
        }
        try {
            Penalty = Double.valueOf(TextPenalty.getText().replace(",", ""));
        } catch (Exception e) {
        }
        try {
            AdvancePayment = Double.valueOf(TextAdvancePayment.getText().replace(",", ""));
        } catch (Exception e) {
        }
        try {
            ProcessingFee = Double.valueOf(TextProcessingFee.getText().replace(",", ""));
        } catch (Exception e) {
        }
        try {
            Others = Double.valueOf(TextOthers.getText().replace(",", ""));
        } catch (Exception e) {
        }

        Deduction = LoanBalance
                + RenewalFee
                + Penalty
                + AdvancePayment
                + ProcessingFee
                + Others;

        NetLoanProceeds = PrincipalAmount - Deduction;
        TextNet.setText(FunctionFactory.amountFormat(NetLoanProceeds));

    }

    void CalculateDueDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date theDate = null;

        theDate = TextDate.getDate();

        Calendar cal = Calendar.getInstance();
        cal.setTime(theDate);
        cal.add(Calendar.MONTH, Integer.parseInt(TextTerm.getText()));

        LblDueDate.setText(sdf.format(cal.getTime()));
    }

    void SetDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date theDate = null;
        try {
            theDate = sdf.parse(nowDate);
        } catch (ParseException e) {
        }
        TextDate.setDate(theDate);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TextTerm = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        TextDate = new com.toedter.calendar.JDateChooser();
        TextInterest = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        ComboLoanType = new javax.swing.JComboBox<>();
        TextReferrence = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextTotalAmountue = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        TextPrincipalAmount = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ComboPaymentMode = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        TextAmortizationAmount = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        LblDueDate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextPenalty = new javax.swing.JFormattedTextField();
        TextRenewalFee = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TextLoanBalance = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TextAdvancePayment = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        TextProcessingFee = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        TextOthers = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        TextNet = new javax.swing.JFormattedTextField();
        cmdadd = new javax.swing.JButton();
        cmdexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Loan");

        TextTerm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        TextTerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextTermKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextTermKeyReleased(evt);
            }
        });

        jLabel7.setText("Date Granted");

        TextDate.setDateFormatString("yyyy/MM/dd ");
        TextDate.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                TextDateHierarchyChanged(evt);
            }
        });
        TextDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TextDateMouseReleased(evt);
            }
        });
        TextDate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                TextDateCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                TextDateInputMethodTextChanged(evt);
            }
        });
        TextDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TextDatePropertyChange(evt);
            }
        });
        TextDate.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                TextDateVetoableChange(evt);
            }
        });

        TextInterest.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0"))));
        TextInterest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextInterestKeyReleased(evt);
            }
        });

        jLabel2.setText("Interest Rate");

        ComboLoanType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboLoanTypeActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(51, 0, 204));
        jLabel3.setText("% Per Month");

        TextTotalAmountue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextTotalAmountue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextTotalAmountue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setText("Loan Type:");

        TextPrincipalAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextPrincipalAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextPrincipalAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextPrincipalAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextPrincipalAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextPrincipalAmountKeyReleased(evt);
            }
        });

        jLabel8.setText("Referrence");

        jLabel5.setText("Principal Amount");

        jLabel4.setText("Term");

        jLabel9.setText("Total Amount Due");

        jLabel14.setText("Payment Mode");

        ComboPaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboPaymentModeActionPerformed(evt);
            }
        });

        jLabel18.setText("Amortization Amount");

        TextAmortizationAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextAmortizationAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextAmortizationAmount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel19.setText("Due Date");

        LblDueDate.setForeground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextAmortizationAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTotalAmountue, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboPaymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPrincipalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextReferrence, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TextInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ComboLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(ComboLoanType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(TextInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextReferrence, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TextPrincipalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboPaymentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextTotalAmountue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(TextDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextAmortizationAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(LblDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("Penalty");

        TextPenalty.setForeground(new java.awt.Color(255, 0, 0));
        TextPenalty.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextPenalty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextPenalty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextPenalty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextPenaltyKeyReleased(evt);
            }
        });

        TextRenewalFee.setForeground(new java.awt.Color(255, 0, 0));
        TextRenewalFee.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextRenewalFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextRenewalFee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextRenewalFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextRenewalFeeKeyReleased(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Early Renewal Fee");

        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Loan Balance");

        TextLoanBalance.setForeground(new java.awt.Color(255, 0, 0));
        TextLoanBalance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextLoanBalance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextLoanBalance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextLoanBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextLoanBalanceKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("LESS:");

        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Advance Payment");

        TextAdvancePayment.setForeground(new java.awt.Color(255, 0, 0));
        TextAdvancePayment.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextAdvancePayment.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextAdvancePayment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextAdvancePayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextAdvancePaymentKeyReleased(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Processing Fee");

        TextProcessingFee.setForeground(new java.awt.Color(255, 0, 0));
        TextProcessingFee.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextProcessingFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextProcessingFee.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextProcessingFee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextProcessingFeeKeyReleased(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Others");

        TextOthers.setForeground(new java.awt.Color(255, 0, 0));
        TextOthers.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextOthers.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextOthers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TextOthers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextOthersKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 0));
        jLabel17.setText("NET LOAN PROCEEDS");

        TextNet.setForeground(new java.awt.Color(0, 102, 0));
        TextNet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        TextNet.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TextNet.setText("0.00");
        TextNet.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        cmdadd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        cmdadd.setMnemonic('C');
        cmdadd.setText("Create");
        cmdadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdaddActionPerformed(evt);
            }
        });

        cmdexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmdexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove.png"))); // NOI18N
        cmdexit.setMnemonic('a');
        cmdexit.setText("Cancel");
        cmdexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cmdadd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmdexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextNet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextRenewalFee, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextLoanBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextAdvancePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextProcessingFee, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextLoanBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextRenewalFee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextAdvancePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextProcessingFee, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(13, 13, 13)
                        .addComponent(TextNet, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdadd)
                            .addComponent(cmdexit))
                        .addGap(63, 63, 63))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboLoanTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboLoanTypeActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboLoanType.getSelectedItem();
            ComboBoxLoanTypeId = item.getId();

            LoanTypeController.setLoanTypeId(ComboBoxLoanTypeId);

            LoanTypeController.PopulateDataOnEdit();

            TextInterest.setText(valueOf(LoanTypeController.getInterestRate()));
            TextTerm.setText(valueOf(LoanTypeController.getTerm()));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ComboLoanTypeActionPerformed

    private void cmdaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdaddActionPerformed
        if (TextTerm.getText().isEmpty() == true || TextInterest.getText().isEmpty() == true || TextPrincipalAmount.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Please fill-up the required fields!");
        } else {

            Controller.setLoanTypeId(ComboBoxLoanTypeId);
            Controller.setInterest(Double.valueOf(TextInterest.getText().replace(",", "")));
            Controller.setTerm(Integer.parseInt(TextTerm.getText()));
            Controller.setReferrence(TextReferrence.getText());
            Controller.setPrincipalAmount(Double.valueOf(TextPrincipalAmount.getText().replace(",", "").trim()));
            Controller.setMemberId(Id);

            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String DateFormatted = DateFormat.format(TextDate.getDate());

            int Id = Controller.Add(DateFormatted);
            LLController.setReferrence("");
            LLController.setParticular("New Loan");
            LLController.setPrincipalAmount(Double.valueOf(TextPrincipalAmount.getText().replace(",", "").trim()));
            LLController.setBalance(Double.valueOf(TextPrincipalAmount.getText().replace(",", "").trim()));
            LLController.setAmountPaid(Double.valueOf("0.00"));
            LLController.setLoanId(Id);
            LLController.Add();

            LogController.setDetails("Add New Loan: " + nym + "/Loan Type:" + ComboLoanType.getSelectedItem().toString() + "/Interest: " + TextInterest.getText() + "/Term: " + TextTerm.getText() + "/ Principal Amount:" + TextPrincipalAmount.getText());
            LogController.setUserId(MainFrame.getUserID());
            LogController.Add();

            this.dispose();
            frmParent.PopulateData();
            JOptionPane.showMessageDialog(null, "Added Successfully!");

        }
    }//GEN-LAST:event_cmdaddActionPerformed

    private void cmdexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdexitActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdexitActionPerformed

    private void ComboPaymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboPaymentModeActionPerformed
        try {
            ComboBoxItem item = (ComboBoxItem) ComboPaymentMode.getSelectedItem();
            PMDivisor = item.getId();
            AutoCalculate();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_ComboPaymentModeActionPerformed

    private void TextInterestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextInterestKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextInterestKeyReleased

    private void TextTermKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextTermKeyPressed

    }//GEN-LAST:event_TextTermKeyPressed

    private void TextPrincipalAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextPrincipalAmountKeyPressed

    }//GEN-LAST:event_TextPrincipalAmountKeyPressed

    private void TextPrincipalAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextPrincipalAmountKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextPrincipalAmountKeyReleased

    private void TextTermKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextTermKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextTermKeyReleased

    private void TextDateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TextDateInputMethodTextChanged

    }//GEN-LAST:event_TextDateInputMethodTextChanged

    private void TextDateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_TextDateCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDateCaretPositionChanged

    private void TextDateVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_TextDateVetoableChange

    }//GEN-LAST:event_TextDateVetoableChange

    private void TextDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TextDatePropertyChange
        try {
            AutoCalculate();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_TextDatePropertyChange

    private void TextDateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextDateMouseReleased

    }//GEN-LAST:event_TextDateMouseReleased

    private void TextDateHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_TextDateHierarchyChanged


    }//GEN-LAST:event_TextDateHierarchyChanged

    private void TextLoanBalanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextLoanBalanceKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextLoanBalanceKeyReleased

    private void TextRenewalFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextRenewalFeeKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextRenewalFeeKeyReleased

    private void TextPenaltyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextPenaltyKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextPenaltyKeyReleased

    private void TextAdvancePaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextAdvancePaymentKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextAdvancePaymentKeyReleased

    private void TextProcessingFeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextProcessingFeeKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextProcessingFeeKeyReleased

    private void TextOthersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextOthersKeyReleased
        AutoCalculate();
    }//GEN-LAST:event_TextOthersKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            getLogger(NewLoan.class.getName()).log(SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        invokeLater(() -> {
            NewLoan dialog = new NewLoan(frmParent, true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboLoanType;
    private javax.swing.JComboBox<String> ComboPaymentMode;
    private javax.swing.JLabel LblDueDate;
    private javax.swing.JFormattedTextField TextAdvancePayment;
    private javax.swing.JFormattedTextField TextAmortizationAmount;
    private com.toedter.calendar.JDateChooser TextDate;
    private javax.swing.JFormattedTextField TextInterest;
    private javax.swing.JFormattedTextField TextLoanBalance;
    private javax.swing.JFormattedTextField TextNet;
    private javax.swing.JFormattedTextField TextOthers;
    private javax.swing.JFormattedTextField TextPenalty;
    private javax.swing.JFormattedTextField TextPrincipalAmount;
    private javax.swing.JFormattedTextField TextProcessingFee;
    private javax.swing.JTextField TextReferrence;
    private javax.swing.JFormattedTextField TextRenewalFee;
    private javax.swing.JFormattedTextField TextTerm;
    private javax.swing.JFormattedTextField TextTotalAmountue;
    private javax.swing.JButton cmdadd;
    private javax.swing.JButton cmdexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

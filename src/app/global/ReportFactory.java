package app.global;

import app.config.DBConn;
import static app.config.DBConn.getConnection;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;
import net.sf.jasperreports.engine.JasperFillManager;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import static net.sf.jasperreports.engine.JasperFillManager.fillReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportFactory {

    public static void rptBoot() throws FileNotFoundException, IOException {
        try {
            JasperReport jasperReport;

            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();

            jasperReport = compileReport("rpt/rptboot.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
            return;
        }
    }



    public static void LaborSummary(String from, String to, String caption) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("from", from);
            parameters.put("to", to);
            parameters.put("caption", caption);


            jasperReport = compileReport("rpt/LaborPayroll/Summary.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            //JasperExportManager.exportReportToPdf(jPrint);
            Viewer.setTitle("Labor Payroll Summary");
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }

    }
    
        public static void DailyCollectionSummary(String dte) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("date", dte);
            parameters.put("caption", dte);


            jasperReport = compileReport("rpt/DailyCollectionReport/Summary.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            //JasperExportManager.exportReportToPdf(jPrint);
            Viewer.setTitle("Labor Payroll Summary");
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }

    }
    
     public static void LaborDetailedSummary(String from, String to, String caption) {
        try {
            JasperReport jasperReport;
            JasperPrint jPrint;

            //parameters
            HashMap parameters = new HashMap();
            parameters.put("from", from);
            parameters.put("to", to);
            parameters.put("caption", caption);


            jasperReport = compileReport("rpt/LaborPayrollDetails/SummaryDetails.jrxml");

            jPrint = fillReport(jasperReport, parameters, getConnection());

            JasperViewer Viewer = new JasperViewer(jPrint, false);
            //JasperExportManager.exportReportToPdf(jPrint);
            Viewer.setTitle("Labor Payroll Summary");
            Viewer.setExtendedState(Viewer.getExtendedState() | MAXIMIZED_BOTH);
            Viewer.setVisible(true);
        } catch (JRException e) {
            showMessageDialog(null, e.getMessage());
        }

    }

}

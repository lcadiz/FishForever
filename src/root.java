
import static app.global.ReportFactory.rptBoot;
import app.view.user.Login;
import java.io.IOException;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.UIManager;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EngkoiZidac
 */
public class Root {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try {
            setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            for (UIManager.LookAndFeelInfo info : getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        Login frame = new Login();
        frame.setVisible(true);

  
        try {
            rptBoot();
        } catch (IOException ex) {
            Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}

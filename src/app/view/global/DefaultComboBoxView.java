/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.global;

import javax.swing.JComboBox;

/**
 *
 * @author Engkoi Zidac
 */
public class DefaultComboBoxView {

    private JComboBox ComboBoxObject;

    public void setComboBoxObject(JComboBox ComboBoxObject) {
        this.ComboBoxObject = ComboBoxObject;
    }

    public void InitializeComboBox() {
        try {
            ComboBoxObject.removeAllItems();
        } catch (Exception e) {
        }
    }
    
   
}

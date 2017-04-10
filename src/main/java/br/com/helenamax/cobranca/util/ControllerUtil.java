/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author 005712431
 */
public class ControllerUtil {
    
    
        public static boolean isPostback() {
            
        return FacesContext.getCurrentInstance().isPostback();
        
    }
}

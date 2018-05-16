/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Eu
 */
@ViewScoped
@ManagedBean(name = "bean")
public class Bean {
 
   // (...) demais propriedades
 
   private boolean opcoesAvancadas;
 
   public boolean isOpcoesAvancadas(){
      return opcoesAvancadas;
   }
     
   public void exibirOpcoesAvancadas(){
      opcoesAvancadas = !opcoesAvancadas;
   }
}

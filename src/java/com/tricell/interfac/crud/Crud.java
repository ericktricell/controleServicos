/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.interfac.crud;

/**
 *
 * @author Eu
 */
public interface Crud {
    String save();
    
    String novo();
    
    void getList();
    
    void getListFilter();
    
    String onRowSelected(Long id);
}

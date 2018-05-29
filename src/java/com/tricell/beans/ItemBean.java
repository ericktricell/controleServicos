/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.model.Item;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class ItemBean {
    
    private Item item = new Item();
    private List<Item> lsItens = new ArrayList<>();

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getLsItens() {
        return lsItens;
    }

    public void setLsItens(List<Item> lsItens) {
        this.lsItens = lsItens;
    }
    
    
}

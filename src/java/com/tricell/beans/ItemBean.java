/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Item;
import com.tricell.repository.DaoGeneric;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class ItemBean extends JPAUtil{
    
    private Item item = new Item();
    private List<Item> lsItens = new ArrayList<>();
    private DaoGeneric<Item> dao = new DaoGeneric<>(getFactory());
    
    public void pegaItens(){
        lsItens = dao.getListEntity(Item.class);
    }
    
    public String salvar(){
        dao.savemerge(item);
        item = new Item();
        
        return "utens?faces-redirect=true";
    }
    
    public String novo(){
        item = new Item();
        
        return "utens?faces-redirect=true";
    }

    public String onRowSelected(Long id) {
        for (int i = 0; i < lsItens.size(); i++) {
            if (Objects.equals(lsItens.get(i).getIdItem(), id)) {
                item = lsItens.get(i);
                break;
            }
        }
        return "";
    }
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

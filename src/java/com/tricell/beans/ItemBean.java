/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.model.Item;
import com.tricell.repository.DaoGeneric;
import java.io.Serializable;
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
public class ItemBean implements Crud, Serializable{
    
    private Item itemS = new Item();
    private List<Item> lsItens = new ArrayList<>();
    private DaoGeneric<Item> dao = new DaoGeneric<>();
    private String name;

    public ItemBean() {
        itemS = new Item();
    }
    
    
    
    @Override
    public void getList(){
        lsItens = dao.getListEntity(Item.class);
    }
    
    @Override
    public void save(){
        dao.savemerge(itemS);
        this.getList();
    }
    

    @Override
    public void getListFilter() {
        
    }
    
    @Override
    public void novo(){
        itemS = new Item();
        
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsItens.size(); i++) {
            if (Objects.equals(lsItens.get(i).getIdItem(), id)) {
                itemS = lsItens.get(i);
                break;
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItemS() {
        return itemS;
    }

    public void setItemS(Item itemS) {
        this.itemS = itemS;
    }

    public List<Item> getLsItens() {
        return lsItens;
    }

    public void setLsItens(List<Item> lsItens) {
        this.lsItens = lsItens;
    }
    
}

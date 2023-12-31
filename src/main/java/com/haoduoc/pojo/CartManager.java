package com.haoduoc.pojo;

import java.util.ArrayList;
import java.util.Iterator;

public class CartManager {
    private ArrayList cart;

    public ArrayList getCart() {
        return cart;
    }

    public void setCart(ArrayList cart) {
        this.cart = cart;
    }

    public ArrayList addToCart(HaoDuoCais haoDuoCais, int quantity){
        if(cart==null){
            cart=new ArrayList();
            ItemBean item=new ItemBean(haoDuoCais,quantity);
            cart.add(item);
        }
        else{
            Object items[]=cart.toArray();
            boolean find=false;
            for(int i=0;i<items.length;i++){
                ItemBean temp=(ItemBean)items[i];
                //判断购物车中是否存在要添加的商品
                if(temp.getHaoDuoCais().getYid()== haoDuoCais.getYid()){
                    temp.setQuantity(temp.getQuantity()+quantity);
                    find=true;
                    break;
                }
            }
            if(!find){
                //添加到购物车
                ItemBean item=new ItemBean(haoDuoCais,quantity);
                cart.add(item);
            }
        }
        return cart;
    }
    public void update(int yid, int quantity){
        //将购物车cart转为用于遍历的Iterator类型i
        Iterator i=cart.iterator();
        //遍历集合中是否存在元素
        while(i.hasNext()){
            ItemBean temp=(ItemBean)i.next();
            //看看参数中的编号为cid的商品对象是否存在。
            if(temp.getHaoDuoCais().getYid()==yid){
                //修改数量
                temp.setQuantity(quantity);
                break;
            }
        }
    }

    public void delete(int yid){
        Iterator i=cart.iterator();
        while(i.hasNext()){
            ItemBean temp=(ItemBean)i.next();
            if(temp.getHaoDuoCais().getYid()==yid){
                cart.remove(temp);
                break;
            }
        }
    }
}

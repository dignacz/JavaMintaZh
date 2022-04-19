/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mintazh;

/**
 *
 * @author Hp 2540P
 */
public class Brand {
    private int Id;
    private String BrandName;

    public Brand(int Id, String BrandName) {
        this.Id = Id;
        this.BrandName = BrandName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    @Override
    public String toString() {
        return "Id: " + Id + ", BrandName: " + BrandName;
    }
    
    
}

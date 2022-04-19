/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mintazh;

/**
 *
 * @author Hp 2540P
 */
public class Mobile {
    private String IMEI;
    private String Type;
    private double Screen;
    private int Camera;
    private int RAM;
    private int ROM;
    private String OperationSystem;
    private int Price;
    private int BrandId;

    public Mobile(String IMEI, String Type, double Screen, int Camera, int RAM, int ROM, String OperationSystem, int Price, int BrandId) {
        this.IMEI = IMEI;
        this.Type = Type;
        this.Screen = Screen;
        this.Camera = Camera;
        this.RAM = RAM;
        this.ROM = ROM;
        this.OperationSystem = OperationSystem;
        this.Price = Price;
        this.BrandId = BrandId;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public double getScreen() {
        return Screen;
    }

    public void setScreen(double Screen) {
        this.Screen = Screen;
    }

    public int getCamera() {
        return Camera;
    }

    public void setCamera(int Camera) {
        this.Camera = Camera;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    public String getOperationSystem() {
        return OperationSystem;
    }

    public void setOperationSystem(String OperationSystem) {
        this.OperationSystem = OperationSystem;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int BrandId) {
        this.BrandId = BrandId;
    }

    @Override
    public String toString() {
        return "IMEI: " + IMEI + ", Type: " + Type + ", Screen: " + Screen + ", Camera: " + Camera 
                + ", RAM: " + RAM + ", ROM: " + ROM + ", OperationSystem: " + OperationSystem 
                + ", Price: " + Price + ", BrandId: " + BrandId;
    }
    
    
}

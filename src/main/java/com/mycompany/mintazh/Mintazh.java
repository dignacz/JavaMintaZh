/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mintazh;

import java.util.List;

/**
 *
 * @author Hp 2540P
 */
public class Mintazh {

    public static void main(String[] args) {
        // TODO code application logic here
        MobileManager mm = new MobileManager();
        /*List<Brand> mobileBrands = mm.getAllBrand();
        for (Brand brand : mobileBrands) {
            System.out.println(brand.toString());
        }
        List<Mobile> mobiles = mm.getAllMobile();
        for (Mobile mobile : mobiles) {
            System.out.println(mobile.toString());
        */
        
        //3. feladat: Listázza ki az egyes telefonok összes adatát gyártóval együtt!
        List<MobileQuery> mobileQueries = mm.getAll();
        for (MobileQuery mobileQuery : mobileQueries) {
            System.out.println(mobileQuery.toString());
        }
        
        //4. feladat: Adja meg a telefonok átlagárát!
        System.out.println("Átlagár: " + mm.avgPrice());
        
        //5. feladat: Adja meg a legolcsóbb telefon összes adatát!
        MobileQuery mobileQuery = mm.pricy();
        System.out.println(mobileQuery.toString());
        
        //6. feladat: Árazzon le egy Ön által tetszőlegesen kiválasztott Apple márkájú okostelefont 10%-kal!
        boolean modified = mm.modify("Iphone 12 Pro", 10);
        if (modified) {
            System.out.println("Módosítás sikeresen megtörtént!");
        }
    }
    
}
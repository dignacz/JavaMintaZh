/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mintazh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp 2540P
 */
public class MobileManager {
    private final String URL = "jdbc:sqlite:MobileShop.db";
    
    public List<Brand> getAllBrand() {
        try {
            Statement statement = getStatement();
            List<Brand> mobileBrands = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Brands");
            
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String BrandName = resultSet.getString("BrandName");
                
                Brand brand = new Brand(Id, BrandName);
                mobileBrands.add(brand);
            }
            return mobileBrands;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Mobile> getAllMobile() {
        try {
            Statement statement = getStatement();
            List<Mobile> mobiles = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Mobiles");
            
            while (resultSet.next()) {
                String IMEI = resultSet.getString("IMEI");
                String Type = resultSet.getString("Type");
                double Screen = resultSet.getDouble("Screen");
                int Camera = resultSet.getInt("Camera");
                int RAM = resultSet.getInt("RAM");
                int ROM = resultSet.getInt("ROM");
                String OperationSystem = resultSet.getString("OperationSystem");
                int Price = resultSet.getInt("Price");
                int BrandId = resultSet.getInt("BrandId");
                
                Mobile mobile = new Mobile(IMEI, Type, Screen, Camera, RAM, ROM, OperationSystem, Price, BrandId);
                mobiles.add(mobile);
            }
            return mobiles;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    //3. feladat: Listázza ki az egyes telefonok összes adatát gyártóval együtt!
    public List<MobileQuery> getAll() {
        try {
            Statement statement = getStatement();
            String query = "SELECT m.IMEI, b.BrandName, m.Type, m.Screen, m.Camera, m.RAM, m.ROM, m.OperationSystem, m.Price \n" +
                           "FROM Mobiles as m \n" +
                           "INNER JOIN Brands as b\n" +
                           "ON m.BrandId == b.Id";
            List<MobileQuery> mobileQueries = new ArrayList<>();
            boolean isQuery = statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            
            while (resultSet.next()) {
                String IMEI = resultSet.getString("IMEI");
                String BrandName = resultSet.getString("BrandName");
                String Type = resultSet.getString("Type");
                double Screen = resultSet.getDouble("Screen");
                int Camera = resultSet.getInt("Camera");
                int RAM = resultSet.getInt("RAM");
                int ROM = resultSet.getInt("ROM");
                String OperationSystem = resultSet.getString("OperationSystem");
                int Price = resultSet.getInt("Price");
                
                mobileQueries.add(new MobileQuery(IMEI, Type, Screen, Camera, RAM, ROM, OperationSystem, Price, BrandName));
            }
            return mobileQueries;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    //4. feladat: Adja meg a telefonok átlagárát!
    public int avgPrice() {
        int avg = 0;
        try {
            Statement st = getStatement();
            ResultSet rs = st.executeQuery("SELECT AVG(Price) FROM Mobiles");
            if(rs.next()) {
                avg = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return avg;
    }
    
    //5. feladat: Adja meg a legolcsóbb telefon összes adatát! 
    public MobileQuery pricy() {
        try {
            Statement statement = getStatement();
            
            String query = "SELECT m.IMEI, b.BrandName, m.Type, m.Screen, m.Camera, m.RAM, m.ROM, m.OperationSystem, m.Price \n" +
                           "FROM Mobiles as m \n" +
                           "INNER JOIN Brands as b\n" +
                           "ON m.BrandId == b.Id";
            ResultSet resultSet = statement.executeQuery(query);
            String IMEI = "", BrandName = "", Type = "", OperationSystem = "";
            double Screen = 0;
            int minPrice = 1000000, Price = 0, Camera = 0, RAM = 0, ROM = 0;
            
            while (resultSet.next()){
                if (resultSet.getInt("Price") < minPrice) {
                    IMEI = resultSet.getString("IMEI");
                    BrandName = resultSet.getString("BrandName");
                    Type = resultSet.getString("Type");
                    Screen = resultSet.getDouble("Screen");
                    Camera = resultSet.getInt("Camera");
                    RAM = resultSet.getInt("RAM");
                    ROM = resultSet.getInt("ROM");
                    OperationSystem = resultSet.getString("OperationSystem");
                    Price = resultSet.getInt("Price");
                    
                    minPrice = Price;
                }
            }
            return new MobileQuery(IMEI, Type, Screen, Camera, RAM, ROM, OperationSystem, Price, BrandName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    //6. feladat: Árazzon le egy Ön által tetszőlegesen kiválasztott Apple márkájú okostelefont 10%-kal!
    public boolean modify(String Type, int discount) {
        try {
            Statement st = getStatement();
            int currentPrice = 0;
            ResultSet rs = st.executeQuery("SELECT Price FROM Mobiles" +
                    " WHERE Type LIKE '" + Type + "'");
            if (rs.next()) {
                currentPrice = rs.getInt("Price");
            }
            int newPrice = (int)(currentPrice - (currentPrice * (double)(discount/100.0)));
            int modified = st.executeUpdate("UPDATE Mobiles SET Price = " + newPrice + 
                    " WHERE Type LIKE '" + Type + "'");
            return modified == 1;
        } catch (SQLException e) {
            System.out.println("A módosítás nem sikerült!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    private Statement getStatement() throws SQLException {
        Connection connection = DriverManager.getConnection(URL);
        Statement statement = connection.createStatement();
        return statement;
    }
}

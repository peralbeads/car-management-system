/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carshowroom;

import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.JTextField;


/**
 *
 * @author mhfah
 */
public class CarShowFrame implements ActionListener{

    
    int d=0;
    
    private String store_company_name;
    private String store_car_name;
    private String store_engine_name;
    private String store_car_travelled;
    private String store_car_price;
    private String store_car_picture;
    private int store_car_ID;
    
    
    JFrame frame = new JFrame();
    
    JTextField company_name =new JTextField();
    JTextField car_name =new JTextField();
    JTextField engine_name =new JTextField();
    JTextField car_driven =new JTextField();
    JTextField car_price =new JTextField();
    JTextField car_picture =new JTextField();
    JButton button;
    JLayeredPane temp =new JLayeredPane();

    
    //label
        JLabel label= new JLabel();
        JLabel addcar = new JLabel("Add Car TO Showroom");
        
        
        JLabel company= new JLabel("Company Name");
        JLabel carname= new JLabel("Car Name");
        JLabel engine= new JLabel("Engine");
        JLabel driven= new JLabel("Distance Travelled");
        JLabel price= new JLabel("Price");
        JLabel carPicture= new JLabel("picture name");
        
        JLabel showroomLabel =new JLabel();
    
     public CarShowFrame(){
       
    }
    
    public CarShowFrame(int index){
        setup();
        
    }
    
    
    public void layerpane()
    {
        temp.setBounds(0, 0, 1500, 500);
        temp.setOpaque(true);
    }
    public void paneAddComponent(){
        temp.add(label);
        temp.add(addcar);
        temp.add(company);
        temp.add(carname);
        temp.add(driven);
        temp.add(price);
        temp.add(engine);
        temp.add(carPicture);
        
        //textfield
        temp.add(company_name);
        temp.add(car_name);
        temp.add(car_driven);
        temp.add(engine_name);
        temp.add(car_price);
        temp.add(car_picture);
        
        //adding button
        temp.add(button);
    
        
    }
    
    
    
    
    
public void addCarLabel()
{
    
        //image
        ImageIcon image = new ImageIcon("addcar.jpg");
        
        
        
        
        //label fonts
        addcar.setFont(new java.awt.Font("Castellar", 0, 18));
        

//        cannot be created on a label that is taking the size of screen
       
        
        addcar.setBounds(800, 0, 300, 40);
        company.setBounds(800, 50, 100, 40);
        carname.setBounds(800, 100, 100, 40);
        engine.setBounds(800, 150, 100, 40);
        driven.setBounds(800, 200, 120, 40);
        price.setBounds(800, 250, 100, 40);
        carPicture.setBounds(800, 300, 100, 40);
       
        
       //input textfields
       
       // company_name.setPreferredSize(new Dimension(250,250));
        company_name.setBounds(950, 60, 100, 25);
        car_name.setBounds(950, 110, 100, 25);
        engine_name.setBounds(950, 160, 100, 25);
        car_driven.setBounds(950, 210, 100, 25);
        car_price.setBounds(950, 260, 100, 25);
        car_picture.setBounds(950,310, 100, 25);
        
       
       
       //button start
        button =new JButton("submit");
        button.setBounds(950, 450, 100, 30);
        button.addActionListener(this);
        
        
        
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setAlignmentX(JLabel.CENTER);
        label.setAlignmentY(JLabel.CENTER);
        
        label.setForeground(new Color(0,0,0));//label color
        label.setFont(new Font("MV Boli ",Font.PLAIN,20));
        label.setBounds(0, 0, 700, 500);//set x,y coordinates and dimensions
        
    
    
}

public void newScreen()
{
    showroomLabel.setBounds(0, 0, 1500, 100);
    showroomLabel.setForeground(Color.red);
}


    
    
public void setup(){
    
    
        layerpane();
        addCarLabel();
        paneAddComponent();
        newScreen();
        temp.add(showroomLabel);
    //    paneAddComponent(); error
        
        //frame
        
        frame.setTitle("SSNF SHOWROOM may be");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1500,525);
        frame.setLayout(null);

        frame.setVisible(true);

        frame.add(temp);
       
        ImageIcon logoimage = new ImageIcon("logo.png");
        frame.setIconImage(logoimage.getImage());
        frame.getContentPane().setBackground(new Color(0xFFFFFF));
        
        //label adding
        

        
  

    }

public String getCompanyName(){return store_company_name;}
public String getCarName(){return store_car_name;}
public String getEngineName(){return store_engine_name;}
public String getDistanceTravelled(){return store_car_travelled;}
public String getCarPrice(){return store_car_price;}
public int getCarID(){return store_car_ID;}
public String getCarPicture(){return store_car_picture;}



 
    
    @Override
    public void actionPerformed(ActionEvent e )
    {
        
        if(e.getSource()== button){
            store_company_name = company_name.getText() ;
            store_car_name = car_name.getText() ;
            store_engine_name = engine_name.getText() ;
            store_car_travelled = car_driven.getText() ;
            store_car_price = car_price.getText() ;
//               store_car_ID +=1;
            store_car_picture=".\\unnamed cars\\"+car_picture.getText()+".jpg"; 
            insertCarToDatabase(store_company_name, store_car_name, store_engine_name, store_car_travelled, store_car_price , store_car_picture);
            button.setEnabled(false);
            
//            frame.dispose();
           
        }
    }
        public void insertCarToDatabase(String company, String car, String engine, String distance, String price, String picture) {
    String url = "jdbc:mysql://localhost:3306/car";
    String username = "root";
    String password = "";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        String insertQuery = "INSERT INTO addcars (company_name, car_name, engine_name, distance_travelled, price, car_picture) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(insertQuery);
        statement.setString(1, company);
        statement.setString(2, car);
        statement.setString(3, engine);
        statement.setString(4, distance);
        statement.setString(5, price);
        statement.setString(6, picture);
        statement.executeUpdate();

        // Display success message or perform any other actions

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle any errors that may occur during the database interaction
    }
}
    
    
    }
    
    


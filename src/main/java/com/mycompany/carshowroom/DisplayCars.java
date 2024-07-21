/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carshowroom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author mhfah
 */
public class DisplayCars  implements ActionListener{
    
    CircularDoublyLinkedList carlist= new CircularDoublyLinkedList();
    
    ImageIcon leftbutton =new ImageIcon("left.png");
    ImageIcon rightbutton =new ImageIcon("right.png");
    
    JFrame frame =new JFrame();
    JLabel carphoto =new JLabel();
    JButton forward = new JButton();
    JButton backward = new JButton();
    JButton purchase = new JButton();
    //JPanel bottomBorder =new JPanel(); 
    JLabel companyName = new JLabel("Company");
    JLabel carName = new JLabel("Car Name");
    JLabel engineName = new JLabel("Engine name");
    JLabel carTravelled = new JLabel("Car Travelled");
    JLabel carPrice = new JLabel("Car Price");
    //reading
    JLabel COMPANYName = new JLabel();
    JLabel CARName = new JLabel();
    JLabel ENGINEName = new JLabel();
    JLabel CARTravelled = new JLabel();
    JLabel CARPrice = new JLabel();



//constructor

    
    public DisplayCars() {
        System.out.println("display cars");
        retrieveDataFromDatabase();
        initializeFrame();
    }

    public void retrieveDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/car";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM addcars");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String company = rs.getString("company_name");
                String car = rs.getString("car_name");
                String engine = rs.getString("engine_name");
                String distance = rs.getString("distance_travelled");
                String price = rs.getString("price");
                String picture = rs.getString("car_picture");
                
                System.out.println(company);
                System.out.println(car);
                System.out.println(engine);
                System.out.println(distance);
                System.out.println(price);
                System.out.println(picture);
                
                carlist.insertFront(company, car, engine, distance, price, picture, 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    
    
    
    
    public void initializeFrame()
    {
        
         //purchase button on panel
        purchase.setBounds(900,550,75,25);
        purchase.addActionListener(this);        
        
       companyName.setFont(new java.awt.Font("Italic", 0, 18));
       carName.setFont(new java.awt.Font("Italic", 0, 18));
       engineName.setFont(new java.awt.Font("Italic", 0, 18));
       carTravelled.setFont(new java.awt.Font("Italic", 0, 18));
       carPrice.setFont(new java.awt.Font("Italic", 0, 18));
       //reading
       COMPANYName.setFont(new java.awt.Font("Italic", 0, 18));
       CARName.setFont(new java.awt.Font("Italic", 0, 18));
       ENGINEName.setFont(new java.awt.Font("Italic", 0, 18));
       CARTravelled.setFont(new java.awt.Font("Italic", 0, 18));
       CARPrice.setFont(new java.awt.Font("Italic", 0, 18));
       
       companyName.setForeground(Color.black);
       carName.setForeground(Color.black);
       engineName.setForeground(Color.black);
       carTravelled.setForeground(Color.black);
       carPrice.setForeground(Color.black);
       //reading
       COMPANYName.setForeground(Color.black);
       CARName.setForeground(Color.black);
       ENGINEName.setForeground(Color.black);
       CARTravelled.setForeground(Color.black);
       CARPrice.setForeground(Color.black);
       
       
        //labels on frame
        
        companyName.setBounds(20,510,200,25);
        carName.setBounds(20,540,200,25);
        engineName.setBounds(20,570,200,25);
        carTravelled.setBounds(20,600,200,25);
        carPrice.setBounds(20,630,200,25);
        //reading
        COMPANYName.setBounds(200,510,200,25);
        CARName.setBounds(200,540,200,25);
        ENGINEName.setBounds(200,570,200,25);
        CARTravelled.setBounds(200,600,200,25);
        CARPrice.setBounds(200,630,200,25);
        
        
        //backwardbutton
        backward.setBounds(0, 220, 100, 100);
        backward.setIcon(leftbutton);
        backward.setFocusable(false);
        backward.addActionListener(this);
        //backward.setBorderPainted(false);
//        backward.setIconImage(leftbutton.getImage());
        
        //forwardbutton
        forward.setBounds(883, 220,100, 100);
        forward.setIcon(rightbutton);
        forward.setFocusable(false);
        forward.addActionListener(this);
        //forward.setBorderPainted(false);
        

        //car picture
        carphoto.setBounds(140, 0, 700, 500);
//        ImageIcon car =new ImageIcon(getCarPicture());
//        carphoto.setIcon(car);
        
        //carphoto.setBackground(Color.red);
        carphoto.setOpaque(true);
        
        frame.add(carphoto);
        frame.add(forward);
        frame.add(backward);
    //    frame.add(bottomBorder); 
     //   frame.add(purchase);  //purchase button
        
        //label on panel
        
        frame.add(companyName); 
        frame.add(carName);
        frame.add(engineName);
        frame.add(carTravelled);
        frame.add(carPrice);
        //reading
        frame.add(COMPANYName); 
        frame.add(CARName);
        frame.add(ENGINEName);
        frame.add(CARTravelled);
        frame.add(CARPrice);
        
       
        
        
        frame.setTitle("SSNF SHOWROOM may be");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setBounds(200, 0, 1000, 700);
//        frame.setSize(1000,700);
        frame.setLayout(null);
       
        frame.setVisible(true);
        
        
        
        ImageIcon logoimage = new ImageIcon("logo.png");
        frame.setIconImage(logoimage.getImage());
        frame.getContentPane().setBackground(new Color(0xE9EBE2)); // color metallic white
    
        displayf(0);//getting the firstpic ready
    
    }
int goforward =0;
int goback;
    @Override
    public void actionPerformed(ActionEvent e) {
        //change picture and details of car
    
        
        
    
        if (e.getSource() == forward)
        {
            
            displayf(goforward);
            System.out.println("forward");
            ++goforward;
            goback=goforward;
            backward.setEnabled(true);
                
        }
        else if(e.getSource()==backward)  // can generate exception
        {   
            System.out.println("backward");
            displayf(goback);
            if(goback==0)
                backward.setEnabled(false);
            else if(goback>0){
                
                --goback;
                goforward=goback;

            }            
            
        
        }
//        else if (e.getSource()==purchase)
//        {System.out.println("purchase");
////              Node currentNode = carlist.getCurrentNode(goforward);
////        String details = "Company: " + currentNode.getCompanyName() + "\n"
////                + "Car Name: " + currentNode.getCarName() + "\n"
////                + "Engine Name: " + currentNode.getEngineName() + "\n"
////                + "Distance Travelled: " + currentNode.getDistanceTravelled() + "\n"
////                + "Car Price: " + currentNode.getCarPrice();
//
//        // Create a new PurchaseFrame and pass the details
//      
//        
//        
//        
//        }
        
        
    }
    
    public void displayf(int i)
    {
        System.out.println(carlist.getCurrentNode(i).getCarPicture());
        System.out.println(carlist.getCurrentNode(i).getCompanyName());
        System.out.println(carlist.getCurrentNode(i).getCarName());
        System.out.println(carlist.getCurrentNode(i).getEngineName());
        System.out.println(carlist.getCurrentNode(i).getDistanceTravelled());
        System.out.println(carlist.getCurrentNode(i).getCarPrice());
        
        
        
        COMPANYName.setText(carlist.getCurrentNode(i).getCompanyName());
        CARName.setText(carlist.getCurrentNode(i).getCarName());
        ENGINEName.setText(carlist.getCurrentNode(i).getEngineName());
        CARTravelled.setText(carlist.getCurrentNode(i).getDistanceTravelled());
        CARPrice.setText(carlist.getCurrentNode(i).getCarPrice());
    
       ImageIcon car =new ImageIcon(carlist.getCurrentNode(i).getCarPicture());
        carphoto.setIcon(car);

//    
    }
    
}

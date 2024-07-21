/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carshowroom;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author mhfah
 */
public class Home extends JFrame implements ActionListener {
    CarShowFrame obj =  new CarShowFrame();
    private JButton addButton;
    private JButton displayButton;

    public Home() {
        initializeDatabase();
        initializeFrame();
    }
      public void initializeDatabase()
    {
        insertCarToDatabase("Lamborghini","Aventador", "6498cc","200 km","20 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("KIA","Seltos", "1497cc","100 km","5 Million",".\\car inventory\\seltos.jpg");
        insertCarToDatabase("Toyota","Fortuner", "2755cc","0 km","8 Million",".\\car inventory\\fortuner.jpg");
        insertCarToDatabase("Porsche","Mecan", "2894cc","50 km","2 Million",".\\car inventory\\modely.jpg");
        insertCarToDatabase("BMW","Limousine", "1952cc","200 km","5 Million",".\\car inventory\\model3.jpg");
     //insert picture
        insertCarToDatabase("FORD","Ford Mustang", "6498cc","50 km","20 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("HONDA","Honda Accord", "6498cc","100 km","28 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("BENTLEY","Bentley Bentayga", "6498cc","80 km","60 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("MASERATI","Maserati Grecale.", "6498cc","90 km","30 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("AUDI","Audi RS Q8", "6498cc","20 km","23 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("CHEVROLET CORVETTE","Sting Ray", "6498cc","0 km","22 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("JAGUAR","Jaguar Land Rover", "6498cc","0 km","42 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("MAZDA","Ahura Mazda", "6498cc","500 km","10 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("NISAN","Nissan Kicks", "6498cc","900 km","5 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("BUGATTI","Bugatti Chiron", "6498cc","100 km","4 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("ROLLS ROYCE","Rolls-Royce Phantom", "6498cc","300 km","90 Million",".\\car inventory\\lambo.jpg");
        insertCarToDatabase("ASTON MARTIN","Aston Martin DBX", "6498cc","400 km","120 Million",".\\car inventory\\lambo.jpg");
    
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

    private void initializeFrame() {
        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        // Create the content panel with a background image
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw the background image
                ImageIcon backgroundImage = new ImageIcon("back.jpeg");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setLayout(new FlowLayout());

        // Create the buttons
        addButton = new JButton("Add Car");
        displayButton = new JButton("Display Cars");

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        displayButton.addActionListener(this);

        // Add the buttons to the content panel
        contentPanel.add(addButton);
        contentPanel.add(displayButton);

        // Add the content panel to the frame
        add(contentPanel, BorderLayout.CENTER);

        // Set frame properties
        setTitle("Car Showroom");
        setSize(1500, 525);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            
            obj.setup();
            // Handle Add Car button click event
            
          //  System.out.println("Add Car button clicked");
        } else if (e.getSource() == displayButton) {
            DisplayCars b =new DisplayCars();
            // Handle Display Cars button click event
            
           // System.out.println("Display Cars button clicked");
        }
    }


}



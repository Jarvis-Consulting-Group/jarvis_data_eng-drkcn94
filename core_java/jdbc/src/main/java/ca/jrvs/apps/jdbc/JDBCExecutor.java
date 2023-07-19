package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

        try {
            Connection connection = dcm.getConnection();

            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1000);
            System.out.println(order);
/*
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();
            customer.setFirstName("Eric");
            customer.setLastName("Chang");
            customer.setEmail("testmail@askjeeves.com");
            customer.setAddress("148 Yonge St");
            customer.setCity("Toronto");
            customer.setState("ON");
            customer.setPhone("905-289-4512");
            customer.setZipCode("L5R8Y3");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("e.chang@mails.com");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());*/


        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
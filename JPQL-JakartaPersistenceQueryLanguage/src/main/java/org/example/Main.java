package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //View
        Query query = session.createQuery("select c from Customer c");
        List<Customer> customers = query.list();
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        //Insert
        Query query1 = session.createQuery("insert into Customer(id,name) values(?1,?2)");
        query1.setParameter(1, "C002");
        query1.setParameter(2, "Nimsi");
        query1.executeUpdate();

        //Update
        Query query2 = session.createQuery("update Customer c set c.name = :name where c.id = :id");
        query2.setParameter("name", "Wimal");
        query2.setParameter("id", "C001");
        query2.executeUpdate();

        //Delete
        Query query3 = session.createQuery("delete from Customer c where c.id = :id");
        query3.setParameter("id", "C001");
        query3.executeUpdate();

        //Join
        Query query4 = session.createQuery("SELECT c.id, c.name, a.city, a.country FROM Customer c JOIN Address a ON c.id = a.id");
        List<Customer> customersList = query4.list();
        for (Customer customer : customersList) {
            System.out.println(Arrays.toString(new Customer[]{customer}));
        }
    }
}
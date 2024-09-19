package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //Select
        NativeQuery nativeQuery = session.createNativeQuery("select * from customer");
        nativeQuery.addEntity(Customer.class);
        List<Customer> customerList = nativeQuery.list();

        for (Customer customer : customerList) {
            System.out.println(customer.getId());
        }

        //Insert
        NativeQuery nativeQuery1 = session.createNativeQuery("insert into customer values(?1,?2)");
        nativeQuery1.setParameter(1, "C001");
        nativeQuery1.setParameter(2, "Nimsi");
        nativeQuery1.executeUpdate();

        //Update
        NativeQuery nativeQuery2 = session.createNativeQuery("update customer set name =?1 where id =?2");
        nativeQuery2.setParameter(1, "Wimal");
        nativeQuery2.setParameter(1,"C001");
        nativeQuery2.executeUpdate();

        //Delete
        NativeQuery nativeQuery3 = session.createNativeQuery("delete from customer where id=?1");
        nativeQuery3.setParameter(1,"C001");
        nativeQuery3.executeUpdate();

        //JoinQuery
        NativeQuery nativeQuery4 = session.createNativeQuery("SELECT c.id, c.name, a.city, a.country FROM customer c JOIN address a ON c.id = a.customer_id");
        List<Customer> customers = nativeQuery4.list();
        for (Customer customer : customers) {
            System.out.println(Arrays.toString(new Customer[]{customer}));
        }

        transaction.commit();
        session.close();
    }
}
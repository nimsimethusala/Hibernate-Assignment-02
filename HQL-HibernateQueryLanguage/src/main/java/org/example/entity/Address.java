package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//-------------- Owner's End -----------------

@Entity
public class Address {
    @Id
    private String Aid;
    private String no;
    private String street;
    private String city;
    private String country;

    /*@JoinColumn(name = "Customer", referencedColumnName = "Customer_Address")*/
    @ManyToOne
    private Customer customer;

    public Address(String aid, String no, String street, String city, String country, Customer customer) {
        Aid = aid;
        this.no = no;
        this.street = street;
        this.city = city;
        this.country = country;
        this.customer = customer;
    }

    public Address() {
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
//----------- Inverse End ---------------
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Address> address;

    public Customer(String id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}

package se.wigellgrp.sj23posu_wigellgrp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TBL_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "address", length = 25, nullable = false)
    private String street;
    @Column(name = "postal_Code", length = 25, nullable = false)
    private int postalCode;
    @Column(name = "city", length = 25, nullable = false)
    private String city;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    //@JoinColumn(name = "members_id")
    private List<Members> members;

    public Address() {
    }

    public Address(String street, int postalCode, String city)  {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

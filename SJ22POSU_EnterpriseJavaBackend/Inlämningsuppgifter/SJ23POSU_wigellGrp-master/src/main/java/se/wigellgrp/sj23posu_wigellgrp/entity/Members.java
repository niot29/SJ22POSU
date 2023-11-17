package se.wigellgrp.sj23posu_wigellgrp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "TBL_MEMBERS")
public class Members {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "first_Name",length = 15,nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String firstName;
    @Column(name = "last_Name",length = 15,nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String lastName;
    @Column(name = "email",length = 25,nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Email(message = "Check if input is valid email format: '${validatedValue}")
    @Size( min = 1,max = 25,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String email;
    @Column(name = "phone",length = 11)
    private String phone;
    @Column(name = "dateOf_Birth",length = 10,nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String dateOfBirth;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
   // @JoinColumn(name = "address_id")
    private Address address;

    public Members() {
    }

    public Members(String firstName, String lastName, String email, String phone, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }


    // define getter/setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address=" + address +
                '}';
    }
}


package se.wigell.wtravels.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UUID;

@Entity
@Table(name = "TBL_CUSTOMER")
public class CustomerEntity {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    //Define username
    @Column(name = "user_Name",length = 10,nullable = false)
    @NotBlank(message = "Name is mandatory")
    @Size( min = 1,max = 10,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String userName;

    @Column(name = "first_Name",length = 15,nullable = false)
    @NotBlank(message = "FirstName is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String firstName;
    @Column(name = "last_Name",length = 15,nullable = false)
    @NotBlank(message = "Lastname is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String lastName;
    @Column(name = "email",length = 25,nullable = false)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Check if input is valid email format: '${validatedValue}")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String email;
    @Column(name = "phone",length = 10,nullable = false)
    @NotBlank(message = "DateOfBirth is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String phone;
    @Column(name = "dateOf_Birth",length = 10,nullable = false)
    @NotBlank(message = "DateOfBirth is mandatory")
    @Size( min = 1,max = 15,message = "The Filed value '${validatedValue}' must be between {min} and {max} characters long")
    private String dateOfBirth;
    @Column(name = "cutomer_Status",length = 2,nullable = false)
    private int cutomerStatus;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cutomer_address_id")
    private AddressEntity  cutomer_address;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cutomer_auth_id")
    private AuthEntity authEntity;

    public CustomerEntity() {
    }


    public CustomerEntity(String userName, String firstName, String lastName, String email, String phone, String dateOfBirth, int cutomerStatus) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.cutomerStatus = cutomerStatus;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public AddressEntity getCutomer_address() {
        return cutomer_address;
    }

    public void setCutomer_address(AddressEntity cutomer_address) {
        this.cutomer_address = cutomer_address;
    }

    public int getCutomerStatus() {
        return cutomerStatus;
    }

    public void setCutomerStatus(int cutomerStatus) {
        this.cutomerStatus = cutomerStatus;
    }

    public AuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(AuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", cutomerStatus=" + cutomerStatus +
                ", cutomer_address=" + cutomer_address +
                '}';
    }
}

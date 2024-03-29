package se.wigell.wtravels.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_AUTH")
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //@OneToOne (cascade = {CascadeType. ALL})
    @Column(name = "login_Namne", length = 40, nullable = false)
    private String loginNamne;

    @Column(name = "login_Password", length = 68, nullable = false)
    private String loginPassword;

    @Column(name = "login_CreateDate")
    private String loginCreateDate;
    @Column(name = "login_LastDate")
    private String loginLastLogin;
    @Column(name = "login_Role", nullable = false)
    private Enum loginRole;
    @Column(name = "login_Status", nullable = false)
    private int loginStatus;


    public AuthEntity() {
    }

    public AuthEntity(String loginNamne, String loginPassword, String loginCreateDate, String loginLastLogin, Enum loginRole, int loginStatus) {
        this.loginNamne = loginNamne;
        this.loginPassword = loginPassword;
        this.loginCreateDate = loginCreateDate;
        this.loginLastLogin = loginLastLogin;
        this.loginRole = loginRole;
        this.loginStatus = loginStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginNamne() {
        return loginNamne;
    }

    public void setLoginNamne(String loginNamne) {
        this.loginNamne = loginNamne;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginCreateDate() {
        return loginCreateDate;
    }

    public void setLoginCreateDate(String loginreateDate) {
        this.loginCreateDate = loginreateDate;
    }

    public String getLoginLastLogin() {
        return loginLastLogin;
    }

    public void setLoginLastLogin(String loginLastLogin) {
        this.loginLastLogin = loginLastLogin;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Enum getLoginRole() {
        return loginRole;
    }

    public void setLoginRole(Enum loginRole) {
        this.loginRole = loginRole;
    }

    @Override
    public String toString() {
        return "AuthEntity{" +
                "id=" + id +
                ", loginNamne='" + loginNamne + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", loginCreateDate='" + loginCreateDate + '\'' +
                ", loginLastLogin='" + loginLastLogin + '\'' +
                ", loginRole='" + loginRole + '\'' +
                ", loginStatus=" + loginStatus +
                '}';
    }
}

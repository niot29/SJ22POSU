package se.wigell.wtravels.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_AUTH_ROLE")
public class AuthRolsEntity {
    @Id
    @Column(name = "ID")
    @NotNull
    private String id;

    @Column(name = "role")
    @NotNull
    private String role;

    public AuthRolsEntity() {
    }

    public AuthRolsEntity(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthRolsEntity{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


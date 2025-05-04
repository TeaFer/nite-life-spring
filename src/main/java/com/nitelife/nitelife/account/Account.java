package com.nitelife.nitelife.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Builder
@Entity
@Table(name="accounts")
public class Account {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String displayName;
    private String email;
    private String fullName;
    private String gender;
    private Boolean is_host;

    protected Account() {
    }

    public Account(Long id, String username, String password,
                   String displayName, String email, String fullName,
                   String gender, Boolean is_host) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.is_host = is_host;
    }

    @Override
    public String toString() {
        return "Account [id=" + id +
                ", username=" + username +
                ", displayName=" + displayName +
                ", fullName=" + fullName +
                ", gender=" + gender +
                ", is_host=" + is_host + "]";
    }
}

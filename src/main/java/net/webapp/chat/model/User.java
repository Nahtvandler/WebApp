package net.webapp.chat.model;


import org.jboss.logging.annotations.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

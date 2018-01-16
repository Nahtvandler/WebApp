package net.webapp.chat.model;

import javax.persistence.*;

@Entity(name = "chat")
@Table(name = "chat")
public class Chat {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ROOM_NAME")
    private String rname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}

package net.webapp.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class ChatOld {

    @Column(name = "USERNAME")
    private String mname;

    @Column(name = "TIME")
    private String mtime;

    @Column(name = "MESSAGE")
    private String message;

    public String getMessage() {
        return message;
    }

    public String getMname() {
        return mname;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }
}


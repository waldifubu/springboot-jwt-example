package org.example.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fb_date")
    private Date fbDate;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "comments")
    private String comments;

    public Feedback() {

    }

    public Feedback(Date fbDate, String clientName, String comments) {
        this.fbDate = fbDate;
        this.clientName = clientName;
        this.comments = comments;
    }

    public Date getFbDate() {
        return fbDate;
    }

    public void setFbDate(Date fbDate) {
        this.fbDate = fbDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }
}

package com.mariia.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Worktime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date the_date;
    private String status;
    @ManyToOne
    Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThe_date() {
        return the_date;
    }

    public void setThe_date(Date the_date) {
        this.the_date = the_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Worktime{" +
                "id=" + id +
                ", the_date=" + the_date +
                ", status='" + status + '\'' +
                '}';
    }
}

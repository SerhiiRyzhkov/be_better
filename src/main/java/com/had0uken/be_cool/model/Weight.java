package com.had0uken.be_cool.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "weights")
public class Weight implements Serializable {
    @Serial
    private static final long serialVersionUID = 8769521173479262675L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "weight_id")
    private long id;
    @Basic
    @Column(name = "user_email")
    private String userEmail;
    @Basic
    @Column(name = "date")
    private String deadline;
    @Basic
    @Column(name = "weight")
    private Double weight;

    public Weight() {
    }

    public Weight(long id, String userEmail, String deadline, Double weight) {
        this.id = id;
        this.userEmail = userEmail;
        this.deadline = deadline;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return id == weight.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Weight{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", deadline='" + deadline + '\'' +
                ", weight=" + weight +
                '}';
    }
}

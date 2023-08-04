package com.had0uken.be_cool.model;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_email")
    private String userEmail;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "score")
    private Integer score;
    @Basic
    @Column(name = "total")
    private Integer total;
    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Basic
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;
    @Basic
    @Column(name = "deadline")
    private String deadline;
    @Basic
    @Column(name = "frequency")
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    public Task() {
    }

    public Task(int id, String userEmail, String title, String description, Integer score, Integer total, Status status, Type type, String deadline, Frequency frequency) {
        this.id = id;
        this.userEmail = userEmail;
        this.title = title;
        this.description = description;
        this.score = score;
        this.total = total;
        this.status = status;
        this.type = type;
        this.deadline = deadline;
        this.frequency = frequency;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", total=" + total +
                ", status=" + status +
                ", type=" + type +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}


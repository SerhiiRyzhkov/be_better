package com.had0uken.be_cool.model;

import com.had0uken.be_cool.enums.Status;
import com.had0uken.be_cool.enums.Type;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = 2401665185463273847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "score")
    private int score;

    @Column(name = "total")
    private int total;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "deadline")
    private String deadline;

    public Task() {
    }

    public Task(long id, String title, String description, int score, int total, Status status, Type type, String deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.score = score;
        this.total = total;
        this.status = status;
        this.type = type;
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
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
        return id == task.id && score == task.score && total == task.total && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(status, task.status) && Objects.equals(type, task.type) && Objects.equals(deadline, task.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, score, total, status, type, deadline);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}

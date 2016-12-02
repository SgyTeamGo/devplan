package model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by srapion.hunanyan on 12/1/2016.
 */

@Entity
@Table(name = "events")
@Component
public class Event implements Serializable {
    long id;
    Date startDate;
    Date endDate;

    String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title=" + title +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

package com.oobss.entity;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by clarkzhao on 2017/12/30.
 *
 * @author clarkzhao
 * @date 2017/12/30
 */
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String name;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date time = new Date();
    private boolean finished;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}

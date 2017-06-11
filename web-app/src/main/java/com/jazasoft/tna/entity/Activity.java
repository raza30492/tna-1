package com.jazasoft.tna.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by mtalam on 6/10/2017.
 */
@Entity
@Table(name="activity")
public class Activity implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="lead_time", nullable = false)
    private Long leadTime;

    @ManyToOne(optional = false)
    @JoinColumn(name="activity_name_id",foreignKey = @ForeignKey(name = "activityName_activity_fk"))
    private ActivityName activityName;

    @ManyToOne(optional = false)
    @JoinColumn(name="label_id",foreignKey = @ForeignKey(name = "label_activity_fk"))
    private Label label;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_modified")
    private Date lastModified;


    public Activity() {
    }

    public Activity(Long id,  Long leadTime) {
        this.id = id;
        this.leadTime = leadTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Long leadTime) {
        this.leadTime = leadTime;
    }

    public ActivityName getActivityName() {
        return activityName;
    }

    public void setActivityName(ActivityName activityName) {
        this.activityName = activityName;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", leadTime=" + leadTime +
                ", activityName=" + activityName +
                ", label=" + label +
                ", lastModified=" + lastModified +
                '}';
    }
}
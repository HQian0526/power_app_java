package powertool.demo.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "strength_user", schema = "powerapp", catalog = "")
public class StrengthUserEntity {
    private int userId;
    private Integer strength;
    private Timestamp comsumeTime;
    private String resumeTime;

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "strength")
    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Basic
    @Column(name = "comsume_time")
    public Timestamp getComsumeTime() {
        return comsumeTime;
    }

    public void setComsumeTime(Timestamp comsumeTime) {
        this.comsumeTime = comsumeTime;
    }

    @Basic
    @Column(name = "resume_time")
    public String getResumeTime() {
        return resumeTime;
    }

    public void setResumeTime(String resumeTime) {
        this.resumeTime = resumeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrengthUserEntity that = (StrengthUserEntity) o;
        return userId == that.userId &&
                Objects.equals(strength, that.strength) &&
                Objects.equals(comsumeTime, that.comsumeTime) &&
                Objects.equals(resumeTime, that.resumeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, strength, comsumeTime, resumeTime);
    }

    public StrengthUserEntity() {
    }

    public StrengthUserEntity(int userId, Integer strength, Timestamp comsumeTime, String resumeTime) {
        this.userId = userId;
        this.strength = strength;
        this.comsumeTime = comsumeTime;
        this.resumeTime = resumeTime;
    }

    @Override
    public String toString() {
        return "StrengthUserEntity{" +
                "userId=" + userId +
                ", strength=" + strength +
                ", comsumeTime=" + comsumeTime +
                ", resumeTime='" + resumeTime + '\'' +
                '}';
    }
}

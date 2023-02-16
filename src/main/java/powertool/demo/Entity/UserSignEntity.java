package powertool.demo.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_sign", schema = "powerapp", catalog = "")
public class UserSignEntity {
    private int id;
    private Integer userId;
    private Integer seriesDays;
    private Integer continuityDays;
    private Timestamp lastSign;
    private Integer signNum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "series_days")
    public Integer getSeriesDays() {
        return seriesDays;
    }

    public void setSeriesDays(Integer seriesDays) {
        this.seriesDays = seriesDays;
    }

    @Basic
    @Column(name = "continuity_days")
    public Integer getContinuityDays() {
        return continuityDays;
    }

    public void setContinuityDays(Integer continuityDays) {
        this.continuityDays = continuityDays;
    }

    @Basic
    @Column(name = "last_sign")
    public Timestamp getLastSign() {
        return lastSign;
    }

    public void setLastSign(Timestamp lastSign) {
        this.lastSign = lastSign;
    }

    @Basic
    @Column(name = "sign_num")
    public Integer getSignNum() {
        return signNum;
    }

    public void setSignNum(Integer signNum) {
        this.signNum = signNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignEntity that = (UserSignEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(seriesDays, that.seriesDays) &&
                Objects.equals(continuityDays, that.continuityDays) &&
                Objects.equals(lastSign, that.lastSign) &&
                Objects.equals(signNum, that.signNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, seriesDays, continuityDays, lastSign, signNum);
    }

    public UserSignEntity(Integer userId, Integer seriesDays, Integer continuityDays, Timestamp lastSign, Integer signNum) {
        this.userId = userId;
        this.seriesDays = seriesDays;
        this.continuityDays = continuityDays;
        this.lastSign = lastSign;
        this.signNum = signNum;
    }

    public UserSignEntity() {
    }

    @Override
    public String toString() {
        return "UserSignEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", seriesDays=" + seriesDays +
                ", continuityDays=" + continuityDays +
                ", lastSign=" + lastSign +
                ", signNum=" + signNum +
                '}';
    }
}

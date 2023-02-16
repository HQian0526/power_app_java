package powertool.demo.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_sign_log", schema = "powerapp", catalog = "")
public class UserSignLogEntity {
    private int id;
    private Integer userId;
    private Timestamp signTime;
    private Integer signType;
    private Timestamp createTime;

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
    @Column(name = "sign_time")
    public Timestamp getSignTime() {
        return signTime;
    }

    public void setSignTime(Timestamp signTime) {
        this.signTime = signTime;
    }

    @Basic
    @Column(name = "sign_type")
    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignLogEntity that = (UserSignLogEntity) o;
        return id == that.id &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(signTime, that.signTime) &&
                Objects.equals(signType, that.signType) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, signTime, signType, createTime);
    }

    public UserSignLogEntity() {
    }

    public UserSignLogEntity(Integer userId, Timestamp signTime, Integer signType, Timestamp createTime) {
        this.userId = userId;
        this.signTime = signTime;
        this.signType = signType;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserSignLogEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", signTime=" + signTime +
                ", signType=" + signType +
                ", createTime=" + createTime +
                '}';
    }
}

package powertool.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "level_user", schema = "powerapp", catalog = "")
public class LevelUserEntity {
    private int userId;
    private Integer totalExp;

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "total_exp")
    public Integer getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(Integer totalExp) {
        this.totalExp = totalExp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelUserEntity that = (LevelUserEntity) o;
        return userId == that.userId &&
                Objects.equals(totalExp, that.totalExp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, totalExp);
    }

    public LevelUserEntity() {
    }

    public LevelUserEntity(int userId, Integer totalExp) {
        this.userId = userId;
        this.totalExp = totalExp;
    }

    @Override
    public String toString() {
        return "LevelUserEntity{" +
                "userId=" + userId +
                ", totalExp=" + totalExp +
                '}';
    }
}

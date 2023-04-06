package powertool.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "level", schema = "powerapp", catalog = "")
public class LevelEntity {
    private int lvId;
    private Integer levelNum;
    private Integer startExp;
    private Integer endExp;
    private String others;
    private LevelUserEntity levelInfo;

    @Transient
    public LevelUserEntity getLevelInfo() {
        return levelInfo;
    }

    public void setLevelInfo(LevelUserEntity levelInfo) {
        this.levelInfo = levelInfo;
    }

    @Id
    @Column(name = "lv_id")
    public int getLvId() {
        return lvId;
    }

    public void setLvId(int lvId) {
        this.lvId = lvId;
    }

    @Basic
    @Column(name = "level_num")
    public Integer getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Integer levelNum) {
        this.levelNum = levelNum;
    }

    @Basic
    @Column(name = "start_exp")
    public Integer getStartExp() {
        return startExp;
    }

    public void setStartExp(Integer startExp) {
        this.startExp = startExp;
    }

    @Basic
    @Column(name = "end_exp")
    public Integer getEndExp() {
        return endExp;
    }

    public void setEndExp(Integer endExp) {
        this.endExp = endExp;
    }

    @Basic
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelEntity that = (LevelEntity) o;
        return lvId == that.lvId &&
                Objects.equals(levelNum, that.levelNum) &&
                Objects.equals(startExp, that.startExp) &&
                Objects.equals(endExp, that.endExp) &&
                Objects.equals(others, that.others);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lvId, levelNum, startExp, endExp, others);
    }

    public LevelEntity() {
    }

    public LevelEntity(int lvId, Integer levelNum, Integer startExp, Integer endExp, String others, LevelUserEntity levelInfo) {
        this.lvId = lvId;
        this.levelNum = levelNum;
        this.startExp = startExp;
        this.endExp = endExp;
        this.others = others;
        this.levelInfo = levelInfo;
    }

    @Override
    public String toString() {
        return "LevelEntity{" +
                "lvId=" + lvId +
                ", levelNum=" + levelNum +
                ", startExp=" + startExp +
                ", endExp=" + endExp +
                ", others='" + others + '\'' +
                ", levelInfo=" + levelInfo +
                '}';
    }
}

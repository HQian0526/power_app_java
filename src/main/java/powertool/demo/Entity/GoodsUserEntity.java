package powertool.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods_user", schema = "powerapp", catalog = "")
public class GoodsUserEntity {
    private int gid;
    private Integer userId;
    private Integer goodsId;
    private Integer gNum;

    @Id
    @Column(name = "gid")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
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
    @Column(name = "goods_id")
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "g_num")
    public Integer getgNum() {
        return gNum;
    }

    public void setgNum(Integer gNum) {
        this.gNum = gNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsUserEntity that = (GoodsUserEntity) o;
        return gid == that.gid &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(goodsId, that.goodsId) &&
                Objects.equals(gNum, that.gNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, userId, goodsId, gNum);
    }

    public GoodsUserEntity() {
    }

    public GoodsUserEntity(int gid, Integer userId, Integer goodsId, Integer gNum) {
        this.gid = gid;
        this.userId = userId;
        this.goodsId = goodsId;
        this.gNum = gNum;
    }

    @Override
    public String toString() {
        return "GoodsUserEntity{" +
                "gid=" + gid +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", gNum=" + gNum +
                '}';
    }
}

package powertool.demo.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "goods_info", schema = "powerapp", catalog = "")
public class GoodsInfoEntity {
    private int goodsId;
    private Integer typeId;
    private String goodsName;
    private String goodsIntroduce;
    private Integer goodsNum;
    private String goodsUrl;
    private GoodsUserEntity goodsUserEntities;

    @Transient
    public GoodsUserEntity getGoodsUserEntities() {
        return goodsUserEntities;
    }

    public void setGoodsUserEntities(GoodsUserEntity goodsUserEntities) {
        this.goodsUserEntities = goodsUserEntities;
    }

    @Id
    @Column(name = "goods_id")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_introduce")
    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    @Basic
    @Column(name = "goods_num")
    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Basic
    @Column(name = "goods_url")
    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsInfoEntity that = (GoodsInfoEntity) o;
        return goodsId == that.goodsId &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(goodsName, that.goodsName) &&
                Objects.equals(goodsIntroduce, that.goodsIntroduce) &&
                Objects.equals(goodsNum, that.goodsNum) &&
                Objects.equals(goodsUrl, that.goodsUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, typeId, goodsName, goodsIntroduce, goodsNum, goodsUrl);
    }

    public GoodsInfoEntity() {
    }

    public GoodsInfoEntity(int goodsId, Integer typeId, String goodsName, String goodsIntroduce, Integer goodsNum, String goodsUrl, GoodsUserEntity goodsUserEntities) {
        this.goodsId = goodsId;
        this.typeId = typeId;
        this.goodsName = goodsName;
        this.goodsIntroduce = goodsIntroduce;
        this.goodsNum = goodsNum;
        this.goodsUrl = goodsUrl;
        this.goodsUserEntities = goodsUserEntities;
    }

    @Override
    public String toString() {
        return "GoodsInfoEntity{" +
                "goodsId=" + goodsId +
                ", typeId=" + typeId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", goodsNum=" + goodsNum +
                ", goodsUrl='" + goodsUrl + '\'' +
                ", goodsUserEntities=" + goodsUserEntities +
                '}';
    }
}

package powertool.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods_type", schema = "powerapp", catalog = "")
public class GoodsTypeEntity {
    private int typeId;
    private String typeName;
    private String typeIntroduce;

    @Id
    @Column(name = "type_id")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "type_introduce")
    public String getTypeIntroduce() {
        return typeIntroduce;
    }

    public void setTypeIntroduce(String typeIntroduce) {
        this.typeIntroduce = typeIntroduce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsTypeEntity that = (GoodsTypeEntity) o;
        return typeId == that.typeId &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(typeIntroduce, that.typeIntroduce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName, typeIntroduce);
    }

    public GoodsTypeEntity() {
    }

    public GoodsTypeEntity(int typeId, String typeName, String typeIntroduce) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeIntroduce = typeIntroduce;
    }

    @Override
    public String toString() {
        return "GoodsTypeEntity{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeIntroduce='" + typeIntroduce + '\'' +
                '}';
    }
}

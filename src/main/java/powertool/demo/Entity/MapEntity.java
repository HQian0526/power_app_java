package powertool.demo.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "map", schema = "powerapp", catalog = "")
public class MapEntity {
    private int mapId;
    private String mapName;
    private String mapIntroduce;
    private String mapUrl;

    @Id
    @Column(name = "mapId")
    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Basic
    @Column(name = "mapName")
    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    @Basic
    @Column(name = "mapIntroduce")
    public String getMapIntroduce() {
        return mapIntroduce;
    }

    public void setMapIntroduce(String mapIntroduce) {
        this.mapIntroduce = mapIntroduce;
    }

    @Basic
    @Column(name = "mapUrl")
    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapEntity mapEntity = (MapEntity) o;
        return mapId == mapEntity.mapId &&
                Objects.equals(mapName, mapEntity.mapName) &&
                Objects.equals(mapIntroduce, mapEntity.mapIntroduce) &&
                Objects.equals(mapUrl, mapEntity.mapUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapId, mapName, mapIntroduce, mapUrl);
    }
}

package powertool.demo.Mapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysMapper {

    //获取商品展示
    public List userLogin(String s);
}

package powertool.demo.Mapper;

import org.apache.ibatis.annotations.Mapper;
import powertool.demo.Entity.UserEntity;

@Mapper
public interface AboutUsMapper {

    //获取商品展示
    public UserEntity selectUserInfo(int s);
}

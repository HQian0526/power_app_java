package powertool.demo.Mapper;
import org.apache.ibatis.annotations.Mapper;
import powertool.demo.Entity.LevelEntity;
import powertool.demo.Entity.UserSignEntity;
import powertool.demo.Entity.UserSignLogEntity;

import java.util.List;

@Mapper
public interface HomeMapper {

    //获取最近一次签到时间
    public UserSignEntity userSign(int userId);

    //用户首次签到，往user_sign表中添加记录，之后只需要更新签到表即可
    public int addUserSign(UserSignEntity userSignEntity);

    //更新签到表user_sign的累计签到、连续签到、等数据
    public int updateUserSign(UserSignEntity userSignEntity);

    //新增一次签到记录
    public int addSignLog(UserSignLogEntity userSignLogEntity);

    //查询本月签到天数
    public List<String> selectSignDay(int userId);

    //获取用户背包-消耗品
    public List<String> selectUserBag(int userId,int typeId);

    //获取用户等级信息
    public List<LevelEntity> selectUserLevel(int userId);

}

package powertool.demo.Service;
import powertool.demo.Entity.UserSignEntity;
import powertool.demo.Util.ResultObj;
import java.util.List;

public interface HomeService {

    //签到接口
    public List<String> userSign(UserSignEntity userSignEntity);

    //查询用户背包
    public List<String> userBag(int userId,int typeId);

    //查询用户等级
    public ResultObj userLevel(int userId);
}

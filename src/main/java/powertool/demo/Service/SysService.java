package powertool.demo.Service;
import powertool.demo.Entity.UserEntity;
import powertool.demo.Util.ResultObj;

public interface SysService {

    //登录接口
    public ResultObj userLogin(UserEntity userEntity);
}

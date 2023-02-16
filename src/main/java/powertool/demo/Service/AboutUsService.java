package powertool.demo.Service;

import powertool.demo.Entity.UserEntity;

public interface AboutUsService {

    //登录接口
    public UserEntity selectUserInfo(int s);
}

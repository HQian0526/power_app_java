package powertool.demo.ServiceImpl;
import org.springframework.stereotype.Service;
import powertool.demo.Entity.UserEntity;
import powertool.demo.Mapper.AboutUsMapper;
import powertool.demo.Service.AboutUsService;

import javax.annotation.Resource;

@Service
public class AboutUsImpl implements AboutUsService {

    @Resource
    private AboutUsMapper aboutUsMapper;

    //查询用户信息
    @Override
    public UserEntity selectUserInfo(int s) {
        UserEntity userEntity1 = aboutUsMapper.selectUserInfo(s);
        return userEntity1;
    }
}

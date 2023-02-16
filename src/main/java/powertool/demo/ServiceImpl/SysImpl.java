package powertool.demo.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import powertool.demo.Entity.UserEntity;
import powertool.demo.Mapper.SysMapper;
import powertool.demo.Service.SysService;
import powertool.demo.Util.ResultObj;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static powertool.demo.Util.Tool.entityToMap;

@Service
public class SysImpl implements SysService {

    @Resource
    private SysMapper sysMapper;

    //用户登录
    @Override
    public ResultObj userLogin(UserEntity userEntity) {
        HashMap<String, Object> resHashMap = new HashMap<String, Object>();
        List<UserEntity> list = new ArrayList();
        String userName = userEntity.getUserName();
        list = sysMapper.userLogin(userName);
        if(list.size()>0){
            //加密后的字符串
            String md5str = DigestUtils.md5Hex(list.get(0).getPassWord());
            if(md5str.equals(userEntity.getPassWord())) {
                resHashMap = entityToMap(list.get(0));
                resHashMap.remove("passWord");
                resHashMap.put("isLogin",true);
                ResultObj resultObj = new ResultObj(0,"登录成功！",resHashMap);
                return resultObj;
            };
        }
        return new ResultObj(-1,"登录失败！",resHashMap);
    }
}

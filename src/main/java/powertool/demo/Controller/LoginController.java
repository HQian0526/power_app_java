package powertool.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import powertool.demo.Entity.UserEntity;
import powertool.demo.Service.SysService;
import powertool.demo.Util.ResultObj;
import java.util.Map;

@Controller
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private SysService sysService;

    //app登录
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultObj getToken(@RequestBody Map<String, String> params){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(params.get("username"));
        userEntity.setPassWord(params.get("password"));
        ResultObj resultObj = sysService.userLogin(userEntity);
        return resultObj;
    }
}

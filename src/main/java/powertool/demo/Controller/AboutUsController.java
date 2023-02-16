package powertool.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import powertool.demo.Entity.UserEntity;
import powertool.demo.Service.AboutUsService;
import powertool.demo.Util.ResultObj;
import powertool.demo.Util.Tool;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/aboutus")
public class AboutUsController {
    @Autowired
    private AboutUsService aboutUsService;
    private Tool tool;

    //app登录后查询个人页信息
    @ResponseBody
    @RequestMapping(value = "/selectUserInfo",method = RequestMethod.POST)
    public ResultObj selectUserInfo(@RequestBody Map<String, Integer> params){
        UserEntity userEntity = aboutUsService.selectUserInfo(params.get("userId"));
        if(!tool.judgeObjIsNull(userEntity)){    //若查询接口返回的对象不为空
            HashMap<String,Object> resMap = tool.entityToMap(userEntity);
            ResultObj resultObj = new ResultObj(0,"查询成功！",resMap);
            resMap.remove("passWord");
            return resultObj;
        }
        return new ResultObj(-1,"查询失败！",new HashMap<String, Object>());
    }
}

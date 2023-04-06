package powertool.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import powertool.demo.Entity.UserSignEntity;
import powertool.demo.Service.HomeService;
import powertool.demo.Util.ResultObj;
import powertool.demo.Util.Tool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;
    private Tool tool;

    //首页签到
    @ResponseBody
    @RequestMapping(value = "/userSign",method = RequestMethod.POST)
    public ResultObj userSign(@RequestBody Map<String, String> params){
        List<String> list = new ArrayList<>();
        UserSignEntity userSignEntity = new UserSignEntity();
        userSignEntity.setUserId(Integer.parseInt(params.get("userId")));
        //查询今日是否签过到 true没有 false签过
        list = homeService.userSign(userSignEntity);
        if(list.size()>0){
            HashMap<String, Object > resMap = new HashMap<String, Object>();
            resMap.put("signUp",true);
            resMap.put("list",list);
            ResultObj resultObj = new ResultObj(0,"签到成功！",resMap);
            return resultObj;
        }
        return new ResultObj(-1,"今天已经签过到了~",new HashMap<String, Object>(){{
            put("signUp",false);
        }});
    }

    //背包
    @ResponseBody
    @RequestMapping(value = "/userBag",method = RequestMethod.POST)
    public ResultObj userBag(@RequestBody Map<String, String> params){
        //将前端传入的userId,typeId进行背包查询
        List<String> list = homeService.userBag(Integer.parseInt(params.get("userId")),Integer.parseInt(params.get("typeId")));
        if(list.size()>0){
            HashMap<String, Object > resMap = new HashMap<String, Object>(){{
                put("list",list);
            }};
            ResultObj resultObj = new ResultObj(0,"success",resMap);
            return resultObj;
        }
        return new ResultObj(-1,"error",new HashMap<String, Object>(){{
            put("list",list);
        }});
    }

    //等级
    @ResponseBody
    @RequestMapping(value = "/userLevel",method = RequestMethod.POST)
    public ResultObj userLevel(@RequestBody Map<String, Integer> params){
        // 将前端传入的userId进行等级查询
        ResultObj resultObj = homeService.userLevel(params.get("userId"));
        return resultObj;
    }

    //体力
    @ResponseBody
    @RequestMapping(value = "/userStrength",method = RequestMethod.POST)
    public ResultObj userStrength(@RequestBody Map<String, Integer> params){
        // 将前端传入的userId进行体力查询
        ResultObj resultObj = homeService.userStrength(params.get("userId"));
        return resultObj;
    }
}

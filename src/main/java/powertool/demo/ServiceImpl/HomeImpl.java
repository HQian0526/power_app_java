package powertool.demo.ServiceImpl;
import org.springframework.stereotype.Service;
import powertool.demo.Entity.*;
import powertool.demo.Mapper.HomeMapper;
import powertool.demo.Service.HomeService;
import powertool.demo.Util.ResultObj;
import powertool.demo.Util.Tool;
import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static powertool.demo.Util.Tool.entityToMap;

@Service
public class HomeImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    //用户签到
    @Override
    public List<String> userSign(UserSignEntity userSignEntity) {
        List<String> list = new ArrayList<String>();//返回结构
        int userId = userSignEntity.getUserId();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        Timestamp timestamp = Timestamp.valueOf(time);
        //查询用户历史是否签到过（user_sign表中是否有该用户记录）
        UserSignEntity userSignRes = homeMapper.userSign(userId);
        //用户首次签到
        if (userSignRes==null){
            userSignEntity = new UserSignEntity(userId,1,1,timestamp, 0);
            //向user_sign表新增用户记录
            int addUserSignRes = homeMapper.addUserSign(userSignEntity);
            if(addUserSignRes!=1)return list;
        }
        //用户更新签到
        else{
            SimpleDateFormat isSignToday = new SimpleDateFormat("yyyyMMdd");
            String lastSign = isSignToday.format(userSignRes.getLastSign());
            String todayDate = isSignToday.format(date.getTime());
            //若最后一次签到时间是今天，返回签到不成功，反之签到成功
            if(lastSign.equals(todayDate))return list;
            //若本次签到和最近一次签到天数差1，则连续签到天数+1，否则重置为1
            Tool tool = new Tool();
            int days = tool.differentDays(new Date(userSignRes.getLastSign().getTime()),date);
            if(days==1){
                userSignRes.setContinuityDays(userSignRes.getContinuityDays()+1);
            }else{
                userSignRes.setContinuityDays(1);
            }
            //更新最新签到时间和连续签到天数
            userSignRes.setLastSign(timestamp);
            int updateUserSignRes = homeMapper.updateUserSign(userSignRes);
            if(updateUserSignRes!=1)return list;
        }
        //向user_sign_log表新增用户签到记录
        UserSignLogEntity userSignLogEntity = new UserSignLogEntity(userId, timestamp, 0, timestamp);
        int addSignLogRes = homeMapper.addSignLog(userSignLogEntity);
        if(addSignLogRes!=1) return list;
        List<String> signDayList = homeMapper.selectSignDay(userId);
        return signDayList;
    }

    @Override
    public List<String> userBag(int userId, int typeId) {
        List list = homeMapper.selectUserBag(userId,typeId);
        return list;
    }

    @Override
    public ResultObj userLevel(int userId) {
        HashMap<String, Object> resHashMap = new HashMap<String, Object>();
        List<LevelEntity> list = homeMapper.selectUserLevel(userId);
        if(list.size()>0){
            double startExp = list.get(0).getStartExp();//该等级初始经验
            double endExp = list.get(0).getEndExp();//该等级结束经验
            double nowExp = list.get(0).getLevelInfo().getTotalExp();//用户当前经验
            double levelProgress = (nowExp-startExp)/(endExp-startExp);
            resHashMap = entityToMap(list.get(0));
            resHashMap.remove("userEntities");
            resHashMap.put("progress",levelProgress);
            return new ResultObj(0,"success",resHashMap);
        }
        return new ResultObj(-1,"error",resHashMap);
    }

    @Override
    public ResultObj userStrength(int userId) {
        HashMap<String, Object> resHashMap = new HashMap<String, Object>();
        List<StrengthUserEntity> list = homeMapper.selectUserStrength(userId);
        if(list.size()>0){
            if(list.get(0).getStrength()==100){
                list.get(0).setComsumeTime(null);
                resHashMap = entityToMap(list.get(0));
            }else{
                //首次体力不为100时的时间 、 现在的时间 、用户恢复1点体力的时间 、用户体力值
                long timeLast = (list.get(0).getComsumeTime().getTime())/1000;
                long timeNow = new Date().getTime()/1000;
                int num = Integer.parseInt(list.get(0).getResumeTime());
                int strength = list.get(0).getStrength();
                //计算体力恢复到100时的时间
                long maxTime = ((100-strength)*num)+timeLast;
                //当现在的时间超过了体力回满的时间，说明体力满了
                if(timeNow>=maxTime){
                    list.get(0).setStrength(100);
                    list.get(0).setComsumeTime(null);
                    resHashMap = entityToMap(list.get(0));
                }
                //当现在的时间没超过了体力回满的时间，说明体力没到100
                if(timeNow<maxTime){
                    int nowStrength = (int)(100-(Math.floor((maxTime-timeNow)/num)));
                    //计算还有多久恢复1滴体力
                    long nextTime = (((nowStrength+1)-strength)*num)+timeLast;
                    int needTime = (int)(nextTime-timeNow);
                    list.get(0).setStrength(nowStrength);
                    resHashMap = entityToMap(list.get(0));
                    resHashMap.put("restTime",needTime);
                }
            }
            return new ResultObj(0,"success",resHashMap);
        }
        return new ResultObj(-1,"error",resHashMap);
    }

}

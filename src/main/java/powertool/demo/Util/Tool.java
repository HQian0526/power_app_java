package powertool.demo.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;

public class Tool {
    /**
     * 判断对象是否为空，且对象的所有属性都为空
     * ps: boolean类型会有默认值false 判断结果不会为null 会影响判断结果
     *     序列化的默认值也会影响判断结果
     * @param object
     * @return
     */
    public static boolean judgeObjIsNull(Object object){
        Class clazz = object.getClass(); // 得到类对象
        Field fields[] = clazz.getDeclaredFields(); // 利用反射得到所有属性
        boolean flag = true; //定义标志flag
        /**
         * 循环遍历反射得到的属性数组，判断每个属性值是否为空
         */
        for(Field f : fields){
            f.setAccessible(true);//由于考虑到某些私有属性直接访问肯能访问不到，此属性设置为true确保可以访问到
            Object fieldValue = null;
            try {
                fieldValue = f.get(object); //得到属性值
                Type fieldType =f.getGenericType();//得到属性类型
                String fieldName = f.getName(); // 得到属性名
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(fieldValue != null){  //只要有一个属性值不为null 就返回false 表示对象不为null
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 实体类转hashMap
     * @param object
     * @return
     */
    public static HashMap<String,Object> entityToMap(Object object){
        HashMap<String,Object> map = new HashMap<>();
        for(Field field : object.getClass().getDeclaredFields()){
            try{
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(object);
                map.put(field.getName(),o);
                field.setAccessible(flag);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 某两个日期之间相差多少天
     * @param date1 较小的时间
     * @param date2 较大的时间
     * @return
     */
    public static int differentDays(Date date1, Date date2){
        int days = (int)((date2.getTime()-date1.getTime())/(1000*3600*24));
        return days;
    }
}

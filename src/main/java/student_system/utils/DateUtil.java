package student_system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil{
    private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23,
            23, 23, 24, 23, 22 };
    private final static String[] constellationArr = new String[] { "摩羯座",
            "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座",
            "天蝎座", "射手座", "摩羯座" };

    /**
     * 根据出生日期计算属相和星座
     * 
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        int month = 10;
        int day = 12;
        System.out.println("星座为：" + getConstellation(month, day));
        System.out.println("属相为:" + getYear(1990));
        int age = getAge(new SimpleDateFormat("yyyy-MM-dd").parse("1990-10-15"));
        System.out.println("age = " + age);

    }

    public static int getAge(Date bir){
        String now = new SimpleDateFormat("yyyy").format(new Date());
        String birdate = new SimpleDateFormat("yyyy").format(bir);
        return Integer.valueOf(now)-Integer.valueOf((birdate));
    }

    /**
     * Java通过生日计算星座
     * 
     * @param month
     * @param day
     * @return
     */
    public static String getConstellation(int month, int day) {
        return day < dayArr[month - 1] ? constellationArr[month - 1]
                : constellationArr[month];
    }
    
    /**
     * 根据生日计算星座
     * @param bir
     * @return
     */
    public static String getConstellation(Date bir){
    	int month = Integer.valueOf(new SimpleDateFormat("MM").format(bir));
		int day =Integer.valueOf(new SimpleDateFormat("dd").format(bir));
		return getConstellation(month, day);
    }

    /**
     * 通过生日计算属相
     * 
     * @param year
     * @return
     */
    public static String getYear(int year) {
        if (year < 1900) {
            return "未知";
        }
        int start = 1900;
        String[] years = new String[] { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊",
                "猴", "鸡", "狗", "猪" };
        return years[(year - start) % years.length];
    }
    
    public static String getYear(Date date){
    	int year =Integer.valueOf(new SimpleDateFormat("yyyy").format(date));
		return getYear(year);
    }
    
}
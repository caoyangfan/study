package com.example.study.ali;

/**
 * @author: caoyangfan
 * @create: 2019-10-18 17:40
 **/
public class TestAA {
}


enum CityEnum{
    BeiJing('a',"北京"),HangZhou('b',"杭州");
    char pattern;
    String cityName;
    CityEnum(char pattern, String cityName){
        this.pattern = pattern;
        this.cityName = cityName;
    }

    public char getPattern() {
        return pattern;
    }

    public void setPattern(char pattern) {
        this.pattern = pattern;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public static String getPattern(char pa){
        CityEnum[] array = CityEnum.values();
        for(CityEnum cityEnum: array){
            if(cityEnum.getPattern() == pa){
                return cityEnum.getCityName();
            }
        }

        return null;
    }
}
class Solution {

    public boolean wordPattern(String pattern, String str) {
        String[] cityNameArray = str.split(" ");
        for(int i = 0;i< pattern.length();i++){
            char pa = pattern.charAt(i);
            String cityNameEnum = CityEnum.getPattern(pa);
            String cityName = cityNameArray[i];
            if(cityNameEnum != null && cityName != null && cityNameEnum.equals(cityName)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.wordPattern("abba", "北京 杭州 杭州 北京");
        System.out.println(b);
    }
}

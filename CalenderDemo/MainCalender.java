package CalenderDemo;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class MainCalender {
    //输入年份月份，输出本月日历
    public static void main(String[] args) {
        //获取输入年和月
        Scanner input=new Scanner(System.in);
        DateInfo d=  InputYearAndMonth(input);
        //计算输入的年和月对应的第一天是星期几，从1900-1-1开始
        //输入年份上一年的最后一天距离1900-1-1多少天
        int days=0;
        int monthDays=0;
        for(int i =1900;i<d.Year;i++){
            if((i%4==0&&i%100!=0)||i%400==0){
                days+=366;
            }else {
                days+=365;
            }
        }
        for(int i =1;i<d.Month;i++){
            if(i==2){
                if((d.Year%4==0&&d.Year%100!=0)||d.Year%400==0){
                    days+=29;
                } else  {
                    days+=28;
                }
            } else if (i==1||i==3||i==5||i==7||i==8||i==10||i==12) {
                days+=31;
            }else {
                days+=30;
            }
        }
        if(d.Month==2){
            if((d.Year%4==0&&d.Year%100!=0)||d.Year%400==0){
                monthDays=29;
            } else  {
                monthDays=28;
            }
        } else if (d.Month==1||d.Month==3||d.Month==5||d.Month==7||d.Month==8||d.Month==10||d.Month==12) {
            monthDays=31;
        }else {
            monthDays=30;
        }
        String outStr="";
        for(int i=1;i<=monthDays;i++){
            String weekDay=(days+i)%7==0?"日": String.valueOf((days+i)%7);
            outStr+=(d.Month+"月"+i+"日：星期"+weekDay.replace('1','一').replace('2','二').replace('3','三').replace('4','四').replace('5','五').replace('6','六')+"||");
            if(weekDay.equals("日")){
                outStr+="\n";
            }
        }
        System.out.print(outStr);
    }

    public static DateInfo InputYearAndMonth(Scanner input){
        //计算输入的年和月对应的第一天是星期几，从1970-1-1开始
        System.out.print("请输入年份：");
        int year=input.nextInt();
        System.out.print("请输入月份：");
        int month=input.nextInt();
        if(month>12||month<1){
            System.out.print("输入月份有误，请重新输入\n");
            InputYearAndMonth(input);
        }

        DateInfo dateInfo=new DateInfo();
        dateInfo.Year=year;
        dateInfo.Month=month;

        return dateInfo;
    }
}

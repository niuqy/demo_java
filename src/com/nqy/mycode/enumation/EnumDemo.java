package com.nqy.mycode.enumation;

/**
 * Created by abner on 6/2/15.
 */
public class EnumDemo {
    public static void main(String[] args) {
        for(int i=0;i<WeekDayEnum.values().length;i++){
            System.out.println(WeekDayEnum.values()[i]);
        }

        NewPaper newPaper = NewPaper.Computer;
        System.out.println("news paper "+newPaper+"'s title is "+newPaper.title);
    }
}

/**
 * simple enum
 */
enum WeekDayEnum{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}

/**
 * complex enum
 */
enum NewPaper{
    /**
     * instance of enum must be in the top
     */
    People("China"),Computer("programer");

    String title;

    /**
     * the constructor's modifier can be only private or friendly,so you can't create new instance outside of the enum
     * @param title
     */
    private NewPaper(String title){
        this.title = title;
    }
}

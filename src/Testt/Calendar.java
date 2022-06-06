package Testt;

import java.util.TreeMap;

public class Calendar {


    TreeMap<Integer,Integer> calendar;
    public Calendar()
    {
        calendar = new TreeMap<>();
    }
    public boolean checkAvailability(int startTime , int endTime)
    {
        Integer prev = calendar.floorKey(startTime),
                next = calendar.ceilingKey(startTime);
        if((prev == null || calendar.get(prev)<=startTime)&&(next==null || endTime<=next)){
            calendar.put(startTime,endTime);
            return true;
         }
         return false;

    }

}

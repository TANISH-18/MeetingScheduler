package Testt;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoom {

    int id;
    List<Meeting> meetingList;
    Calendar calendar = new Calendar();
    public MeetingRoom(int id)
    {
        this.id = id;
        meetingList= new ArrayList<>();
    }

    public boolean isFree(int startTime,int endTime)
    {
        return calendar.checkAvailability(startTime,endTime);
    }

    public Meeting bookMeeting(int id , int starTime , int endTime)
    {
        Meeting meeting = new Meeting(id, starTime,endTime);
        meetingList.add(meeting);
        return meeting;
    }


}

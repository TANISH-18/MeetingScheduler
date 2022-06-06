package Testt;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private static final int MAX_HISTORICAL_MEETING_STORAGE = 20;
       int noOfRooms;
       List<MeetingRoom> meetingRoomList;
       //List<Meeting> historyOfMeetings;
       int idCounter;
       Meeting[] history;
       int historySize;
       public Scheduler(int n)
       {
           noOfRooms = n;
           meetingRoomList = new ArrayList<>();
           idCounter=1;
           history = new Meeting[MAX_HISTORICAL_MEETING_STORAGE];
           historySize =0;
           initMeetingRooms();
       }

       private void initMeetingRooms()
       {
           for(int i =1 ; i<=noOfRooms;i++)
           {
               MeetingRoom room = new MeetingRoom(i);
               System.out.println("Room created "+i);
               meetingRoomList.add(room);
           }
       }

       private void saveHistory(Meeting meeting)
       {
           if(historySize == MAX_HISTORICAL_MEETING_STORAGE)
           {
               history[0] = null;
               for(int i=1; i< MAX_HISTORICAL_MEETING_STORAGE;i++)
               {
                   history[i-1] = history[i];
               }
           }
           history[historySize++] = meeting;
       }
       public synchronized Meeting bookMeeting(int startTime , int endTime) throws Exception{
           try {

               for (MeetingRoom room : meetingRoomList) {
                   if (room.isFree(startTime, endTime)) {
                       Meeting meeting = room.bookMeeting(idCounter++, startTime, endTime);
                       System.out.println("Meeting is Scheduled for id " + meeting.id);
                       saveHistory(meeting);
                       return meeting;
                   }
               }
               System.out.println("Meeting is not scheduled for id " + idCounter++);
           }catch (Exception e) {
               System.out.println("Rooms Unavailable");
           }
           return null;
           }

        public void getHistory(int nlastMeetings){
            System.out.println("historysize "+historySize);
         for(int i = historySize-1; i>=(historySize - nlastMeetings);i--)
         {
             System.out.println(history[i].id+" ");
         }

       }

}

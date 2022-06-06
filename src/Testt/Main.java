package Testt;

public class Main {
  public static void  main(String [] args) throws  Exception {

      Scheduler scheduler = new Scheduler(1);
      scheduler.bookMeeting(1,6);
      scheduler.bookMeeting(3,7);
      scheduler.bookMeeting(6,8);
      System.out.println("history Meetings");
      scheduler.getHistory(2);
  }

}

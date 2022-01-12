import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class CallLog{

  private String phoneNum;
  private LocalDateTime callStart;
  private int duration;
  
  /**
   * Initializes a log for a call made to the given phone number.
   * The log contains the dialed number, the date & time the call was made,
   * and the duration in minutes and seconds.  This log is not considered
   * finalized until the call has ended, hence the duration is initialized to 0 minutes
   * and 0 seconds.
   * @param phoneNum - the non-formatted phone number as a String
   * **/
  public CallLog(String phoneNum){
     this.phoneNum = phoneNum;
     callStart = LocalDateTime.now();
     duration = 0;
  }

  /**
   * finalizes this log by updating the duration of the call.
   * **/
  public void endCall(){
    LocalDateTime callEnd = LocalDateTime.now();
    duration = (int) Duration.between(callStart, callEnd).toSeconds();
  }

  /**
   * gets the duration of the call in this log
   * @return the duration in seconds as a long.
   * **/
  public long getDuration(){

    return duration;
  }
  
  /**
   * Constructs a String representation of this call log
   * **/
  @Override
  public String toString(){
    String log = "\n-----------------------------------\n\n";
    log += "Call to: " + CallUtil.formatPhoneNum(this.phoneNum) + "\n";

    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    String formatDateTime = callStart.format(formatter);
    String durationStr = Integer.toString(duration / 60) + " minutes, " + Integer.toString(duration % 60) + " seconds";
    log += "Date: " + formatDateTime + "\n" ;
    log += "Duration: " + durationStr;
    return log;
  }

  
  // You can run this main method to test the CallLog class
  public static void main(String[] args) throws InterruptedException
  {
    CallLog c = new CallLog("5555664333");

    TimeUnit.SECONDS.sleep(5);
    c.endCall();

    System.out.println(c);
    CallLog d = new CallLog("5555664115");

    TimeUnit.SECONDS.sleep(10);
    d.endCall();

    System.out.println(d);

  }

}
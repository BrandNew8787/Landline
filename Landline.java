import java.util.ArrayList;

/**
 * Public singleton class representing the land line in the Doe residence
 * **/
public class Landline {
	
   // single Landline instance
   private static Landline instance = null;
   
   // other data members of class
   private static ArrayList<CallLog> callHistory;
   private static boolean busy;
   private static CallLog currentCall;
   public static final String landPhoneNum = "5551234567";
   
   /**
    * Initializes the data members of this Landline instance.
    * Does not initialize the static Landline instance
    * This land line is interpreted to be available at its 
    * initialization.
    * **/
   private Landline( ) { 
      busy = false;
      callHistory = new ArrayList<CallLog>();
      
   }
   
   /**
    * gets the single LandLine instance
    * @return static LandLine object
    * **/
   public static Landline getInstance( ) {
     if( instance == null ) {
         instance = new Landline( );
      }
      return instance;
   }
   
   /**
    * dials the given phone number if the land line is not busy.
    * If dial is successful, a call log to the given number is initialized
    * @return true if this land line was available to make the call, false otherwise
    * **/
   public boolean dial(String num){
     if (!busy){
       currentCall = new CallLog(num);
       busy = true;
       return true;
     }
     return false;
   }

   
   /**
    * terminates the current call, if the line is busy.
    * If a call is terminated, the current call log is finalized and stored in the call history.
    * @return true, if a call is terminated, false otherwise 
    * **/
   public boolean hangUp(){
     if (busy){
      busy = false;
      currentCall.endCall();
      callHistory.add(currentCall);
      return true;
     }   
	   return false;
   }

   /**
    * gets all the logs of the calls made from this land line
    * **/
   public ArrayList<CallLog> getCallLogs(){
     return callHistory;
   }
   
   /**
    * Constructs a String representation of the logs of all calls made from 
    * this land line
    * **/
   @Override
   public String toString(){
     String logs = "------------- Call History For: " + CallUtil.formatPhoneNum(this.landPhoneNum) + "-----------------------\n";

     for(CallLog c : callHistory){
       logs += c.toString();
     }
     return logs;
   }
}
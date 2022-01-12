import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

class Main {
  public static void main(String[] args) throws InterruptedException
  {
    Landline livingRoomTel = Landline.getInstance();
    Landline bedroomTelephone = Landline.getInstance();
    Landline garageTelephone = Landline.getInstance();

    System.out.println("Tammy is dialing from the living room....");
    boolean successfulCall = livingRoomTel.dial("5551234567");

    if (successfulCall){
      System.out.println("Line was available. Tammy is now on the phone.");
      TimeUnit.SECONDS.sleep(10);
    }
    else{
      System.out.println("Tammy was unsuccessful, the line is use.");
    }
    
    System.out.println("\nMrs. Doe is trying to dial from the bedroom.");
    successfulCall = bedroomTelephone.dial("5554561234");
    if (successfulCall){
      System.out.println("Line was available. Mrs. Doe is now on the phone.");
      TimeUnit.SECONDS.sleep(10);
    }
    else{
      System.out.println("Mrs. Doe was unsuccessful.  Someone is already using the line.  Mrs. Doe will eavesdrop the current call instead...");
      TimeUnit.SECONDS.sleep(5);
    }

    boolean wasInUse = livingRoomTel.hangUp();
    if(wasInUse){
      System.out.println("\nThe phone has been hung up.");
    }

    System.out.println("\nMrs. Doe is trying to dial from the bedroom again... ");
    successfulCall = bedroomTelephone.dial("5554561234");

    if (successfulCall){
      System.out.println("Line was available.  Mrs. Doe is now on the phone.");
      TimeUnit.SECONDS.sleep(8);
    }
    else{
      System.out.println("Mrs. Doe was unsuccessful, someone is already using the line.");
      TimeUnit.SECONDS.sleep(5);
    }



    System.out.println("\nMr. Doe is trying to dial from the garage.");
    successfulCall = garageTelephone.dial("911");
    if (successfulCall){
      System.out.println("Line was available. Mr. Doe is now on the phone.");
      TimeUnit.SECONDS.sleep(10);
    }
    else{
      System.out.println("Mr. Doe was unsuccessful.  Someone is already using the line.");
      TimeUnit.SECONDS.sleep(8);
    }

    wasInUse = bedroomTelephone.hangUp();
    if(wasInUse){
      System.out.println("\nThe phone has been hung up.");
    }

    System.out.println("\nMr. Doe is trying to dial from the garage again... ");
    successfulCall = bedroomTelephone.dial("911");

    if (successfulCall){
      System.out.println("Line was available.  Mr. Doe is now on the phone.");
      TimeUnit.SECONDS.sleep(10);
    }
    else{
      System.out.println("Mr. Doe was unsuccessful, someone is already using the line.");
      TimeUnit.SECONDS.sleep(5);
    }

    wasInUse = garageTelephone.hangUp();
    if(wasInUse){
      System.out.println("\nThe phone has been hung up.");
    }

    System.out.println("\nHere is the history of this phone number:");
    System.out.println(bedroomTelephone);


  }
}
public class CallUtil{
  
  public static String formatPhoneNum(String phoneNum){

    if(phoneNum.length() == 10){
      return "(" + phoneNum.substring(0, 3) + ") " +phoneNum.substring(3, 6) + "-" + phoneNum.substring(6);
    }
    else if (phoneNum.length() == 7){
      return phoneNum.substring(0, 3) + "-" + phoneNum.substring(3);
    }
    else{
      return phoneNum;
    }
    
  }
  
  
}
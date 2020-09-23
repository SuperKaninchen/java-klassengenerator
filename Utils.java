class Utils {
  public static String boolToPString(boolean pBool) {
    if(pBool)
      return "private";
    else
      return "public";
  }
  public static String capitalize(String str){
    if(str == null || str.length() == 0)
      return "";
    if(str.length() == 1)
      return str.toUpperCase();
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}

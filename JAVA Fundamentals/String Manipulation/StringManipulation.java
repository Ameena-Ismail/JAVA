public class StringManipulation {

    public String trimAndConcat(String str1, String str2) {
        String newString = str1.trim() + str2.trim();
        return newString;
    }

    public Integer getIndexOrNull(String str, char ch) {
        Integer value = str.indexOf(ch);
if (value==-1)value=null;
        return value;
    }

    public Integer getIndexOrNull(String str, String str2) {
        Integer value = str.indexOf(str2);
if (value==-1)value=null;
        return value;
    }

    public String concatSubstring(String str1, int int1, int int2, String str2) {
        String str3 = str1.substring(int1, int2);
        String finalString = str3 + str2;
        return finalString;
    }
 

}











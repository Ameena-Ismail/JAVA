public class StringManipulator{
    
    public String trimAndConcat(String string1, String string2){
        return string1.trim()+string2.trim();
    }
    public int getIndexOrNull(String fullstring, char findstring){
        return fullstring.indexOf(findstring);
    }
    public int getIndexOrNull(String fullstring, String subString){
        return fullstring.indexOf(subString);
    }
    public String concatSubstring(String string1, int start, int end, String string2){
        return string1.substring(start,end)+string2;
    }
}
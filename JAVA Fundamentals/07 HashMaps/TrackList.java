import java.util.HashMap;
public class TrackList{
    public void trackList(){

        // create trackList of type HashMap
        HashMap<String, String> newTrack = new HashMap<String, String>();
        // Add 4 Songs
        newTrack.put("Pegasus Fantasy","The cosmos of the heart embraced Burn it high and make a miracle happen" );
        newTrack.put("Soldier Dream","Get up in the sky Sparkle of life that shines your way Shone by fate This is stars legend, Soldier Dream");
        newTrack.put("Cha-La Head-Cha-La","Fly Away penetrate the glowing clouds (Fly Away) panorama spread in the body throughout");
        newTrack.put("We Gotta Power","ハチャメチャが　押し寄せて来る 泣いてる　場合じゃない");

        //get a song by its track title
        System.out.println("get song by title : "+newTrack.get("We Gotta Power"));
        //Print all track names and lyrics in the format Track: Lyrics
        
        // Set<String> keys = newTrack.keySet();
        // for(String key : keys){
        //     System.out.println(key+" : "+newTrack.get(key));
        // }

        newTrack.forEach((title,lyrics)->System.out.println(title+" : "+lyrics));
    }
}
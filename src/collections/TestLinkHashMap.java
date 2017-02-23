package collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by PawelM on 2017-02-23.
 */
public class TestLinkHashMap {

    public static void main(String args[]){

        Map<Integer,String> hm = new LinkedHashMap<Integer,String>();

        hm.put(102,"Rafal");
        hm.put(101,"Witek");
        hm.put(100,"Anna");

        for(Map.Entry m : hm.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

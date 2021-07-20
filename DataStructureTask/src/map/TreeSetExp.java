package map;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

public class TreeSetExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        TreeMap<Integer,String> tMap = new TreeMap<>();
        tMap.put(1,"One");
        tMap.put(3,"Three");
        tMap.put(4,"Four");
        tMap.put(5,"Five");
        tMap.put(2,"Two");
        tMap.put(7,"Seven");
        System.out.println("tMap: "+tMap);
        
        //ceilingEntry(k) & ceilingKey(k)
        System.out.println("\nceilingEntry(k) & ceilingKey(k):-");
        System.out.println("Map.ceilingEntry(6): "+tMap.ceilingEntry(6));
        System.out.println("Map.ceilingEntry(4): "+tMap.ceilingEntry(4));
        System.out.println("Map.ceilingEntry(7): "+tMap.ceilingEntry(8)+"\n");
        
        System.out.println("tMap.ceilingKey(6): "+tMap.ceilingKey(6));
        System.out.println("tMap.ceilingKey(4): "+tMap.ceilingKey(4));
        System.out.println("tMap.ceilingKey(4): "+tMap.ceilingKey(8));
        
        //higherEntry(k) & higherKey(k)
        System.out.println("\nhigherEntry(k) & higherKey(k)");
        System.out.println("Map.higherEntry(6): "+tMap.higherEntry(6));
        System.out.println("Map.higherEntry(4): "+tMap.higherEntry(4));
        System.out.println("Map.higherEntry(7): "+tMap.higherEntry(7)+"\n");
        
        System.out.println("Map.higherKey(6): "+tMap.higherKey(6));
        System.out.println("Map.higherKey(4): "+tMap.higherKey(4));
        System.out.println("Map.higherKey(7): "+tMap.higherKey(7));
        
        
        //floorEntry(k) & floorKey(k)
        System.out.println("\nfloorEntry(k) & floorKey(k):-");
        System.out.println("Map.floorEntry(6): "+tMap.floorEntry(6));
        System.out.println("Map.floorEntry(4): "+tMap.floorEntry(4));
        System.out.println("Map.floorEntry(0): "+tMap.floorEntry(0)+"\n");
        
        System.out.println("tMap.floorKey(6): "+tMap.floorKey(6));
        System.out.println("tMap.floorKey(4): "+tMap.floorKey(4));
        System.out.println("tMap.floorKey(0): "+tMap.floorKey(0));
        
        //lowerEntry(k) & lowerKey(k)
        System.out.println("\nlowerEntry(k) & lowerKey(k)");
        System.out.println("Map.lowerEntry(6): "+tMap.lowerEntry(6));
        System.out.println("Map.lowerEntry(4): "+tMap.lowerEntry(4));
        System.out.println("Map.lowerEntry(1): "+tMap.lowerEntry(1)+"\n");
        
        System.out.println("Map.lowerKey(6): "+tMap.lowerKey(6));
        System.out.println("Map.lowerKey(4): "+tMap.lowerKey(4));
        System.out.println("Map.lowerKey(1): "+tMap.lowerKey(1)+"\n");
        
        //Iteration in descending manner
        System.out.println("Iteration in descending manner\n(i)Using descendingMap()");
        Iterator<Map.Entry<Integer,String>> desEntryIterator = tMap.descendingMap().entrySet().iterator();
        while(desEntryIterator.hasNext()){
            Map.Entry<Integer,String> entry = desEntryIterator.next();
            System.out.print(entry+" ");
        }
        
        System.out.println("\n(ii)Using descendingKeySet()");
        Iterator<Integer> desKeyIterator = tMap.descendingKeySet().iterator();
        while(desKeyIterator.hasNext()){
            Integer key = desKeyIterator.next();
            System.out.print(key+"="+tMap.get(key)+" ");
        }
        
        //firstEntry() & firstKey()
        System.out.println("\n\nfirstEntry() & firstKey():-");
        System.out.println("fisrtEntry(): "+tMap.firstEntry());
        System.out.println("firstKey(): "+tMap.firstKey());
        
        //lastEntry() & lastKey()
        System.out.println("\nlastEntry() & lastKey():-");
        System.out.println("lastEntry(): "+tMap.lastEntry());
        System.out.println("lastKey(): "+tMap.lastKey());
        
        //pollFirstEntry() & pollLastEntry
        System.out.println("\ntMap: "+tMap);
        System.out.println("\ntMap.pollFirstEntry(): "+tMap.pollFirstEntry()+"\ntMap: "+tMap);
        System.out.println("\ntMap.pollLastEntry(): "+tMap.pollLastEntry()+"\ntMap: "+tMap);
        
        //headMap()
        System.out.println("\ntMap.headMap(4): "+tMap.headMap(4));
        System.out.println("tMap.headMap(4): "+tMap.headMap(4, true));
        
        //tailMap()
        System.out.println("\ntMap.tailMap(4): "+tMap.tailMap(3));
        System.out.println("tMap.tailMap(4): "+tMap.tailMap(3, false));  
        
        //subMap()
        System.out.println("\ntMap.subMap(2, 4): "+tMap.subMap(2, 4));
        System.out.println("tMap.subMap(2, 4): "+tMap.subMap(2,true, 4, true));
    }
}

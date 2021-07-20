package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //creating a map
        Map<Integer,String> map = new HashMap<>();
        
        //adding key-value pairs
        System.out.println("Adding keys and values:-");
        map.put(1, "One");
        map.put(2,"Two");
        System.out.println("map.put(3,\"three\"): "+map.put(3,"three")+" <-previous value null");
        System.out.println("map: "+map);
        System.out.println("map.put(3, \"Three\"): "+map.put(3, "Three") +" <- previous value");
        System.out.println("map after put(3,\"Three\"): "+map+"\n");
        
        //null key can be present
        System.out.println("Adding null key:-");
        map.put(null, "Zero");
        System.out.println("map: "+map+"\n");
        
        //null values
        System.out.println("Adding null values:-");
        map.put(null, null);
        map.put(4, null);
        System.out.println("map: "+map+"\n");
        map.put(4, "four");
        
        //put entries from another map
        System.out.println("Adding keys and values from another map:-");
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(5,"Five");
        map2.put(4,"Four");
        map2.put(6,"Six");
        System.out.println("map2: "+map2);
        map.putAll(map2);
        System.out.println("map: "+map+"\n");
        
        //get values
        System.out.println("Get values:-");
        System.out.println("map.get(5): "+map.get(1));
        System.out.println("map.get(10): "+map.get(10)+"\n");
        
        //get values or default
        System.out.println("Get values or default:-");
        System.out.println("map.getOrDefault(5, \"No Mappings\"): "+map.getOrDefault(5, "No Mappings"));
        System.out.println("map.getOrDefault(10, \"No Mappings\"): "+map.getOrDefault(10, "No Mappings")+"\n");
        
        //containsKey()
        System.out.println("containsKey():-");
        System.out.println("map.containsKey(2): "+map.containsKey(2));
        System.out.println("map.containsKey(10): "+map.containsKey(10));
        
        //containsValue()
        System.out.println("containsValue():-");
        System.out.println("map.containsValue(\"Two\"): "+map.containsValue("Two"));
        System.out.println("map.containsValue(\"Ten\"): "+map.containsValue("Ten"));
        
        //Iterating through a map
        //(a) By Key
        //(i) Using Key iterator
        System.out.println("Iterating through a map\n(a) By Key\n(i) Using Key iterator");
        Iterator<Integer> keyIterator = map.keySet().iterator();
        while(keyIterator.hasNext()){
            Integer key = keyIterator.next();
            String value = map.get(key);
            System.out.print(key+"="+value+" ");
        }
        //(ii) Using For-each
        System.out.println("\n(ii) Using for-each loop:");
        for(Integer key:map.keySet()){
            String value = map.get(key);
            System.out.print(key+"="+value+" ");
        }
        //(b) By Values
        //(i) Using Value Iterator iterator
        System.out.println("\n(b) By Values\n(i) Using Value iterator");
        Iterator<String> valueIterator = map.values().iterator();
        while(valueIterator.hasNext()){
            String value = valueIterator.next();
            System.out.print(value+" ");
        }
        //(ii) Using For-each
        System.out.println("\n(ii) Using for-each loop:");
        for(String value: map.values()){
            System.out.print(value+" ");
        }
        //(c) By Entries
        //(i) Using Entry Iterator
        System.out.println("\n(c) By Entries\n(i) Using Entry iterator");
        Iterator<Map.Entry<Integer,String>> entryIterator = map.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<Integer,String> entry=entryIterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue()+" ");
        }
        //(ii) Using For-each
        System.out.println("\n(ii) Using for-each loop:");
        for(Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue()+" ");
        }
        
        //removing elements
        //remove(key)
        System.out.println("\nremove(key):-");
        System.out.println("map.remove(5): "+map.remove(5)+"\nmap: "+map);
        System.out.println("map.remove(5): "+map.remove(5)+"\nmap: "+map);
        //remove(key,value)
        System.out.println("\nremove(key,value):-");
        System.out.println("map.remove(6,\"Six\"): "+map.remove(6,"Six")+"\nmap: "+map);
        System.out.println("map.remove(6,\"Six\"): "+map.remove(6,"Six")+"\nmap: "+map);
        
        //replacing an entry 
        System.out.println("\nreplace an entry by replace(key,value):-");
        System.out.println("map.replace(null,\"Zero\"): "+map.replace(null,"Zero")+"\nmap: "+map);
        System.out.println("map.replace(10,\"Zero\"): "+map.replace(10,"Zero")+"\nmap: "+map);
        
        //Finding no. of entries in a map
        System.out.println("\nSixe of map: "+map.size());
        
        //Removing all entries
        map.clear();
        System.out.println("map: "+ map);
        
        //checking is a map is empty
        System.out.println("\nis map empty? "+map.isEmpty());
    }
}

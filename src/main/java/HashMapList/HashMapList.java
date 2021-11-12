package HashMapList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList <T, E>{
    private HashMap<T, ArrayList<E>> map = new HashMap<>();

    /* Key의 위치에 있는 리스트에 item을 삽입한다. */
    public void put(T key, E item){
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<E>());
        }
        map.get(key).add(item);
    }

    /* key의 위치에 items 리스트를 삽입한다 */
    public void put(T key, ArrayList<E> items){
        map.put(key, items);
    }

    /* key에 대응되는 리스트를 가져온다. */
    public ArrayList<E> get(T key){
        return map.get(key);
    }

    /* Hashmaplist에 key가 들어 있는지 확인한다. */
    public boolean containsKey(T key){
        return map.containsKey(key);
    }

    /*key에 대응되는 리스트에 value가 들어 있는지 확인한다. */
    public boolean containsKeyValue(T key, E value){
        ArrayList<E> list = get(key);
        if(list == null) return false;
        return list.contains(value);
    }

    /* key의 리스트를 가져온다. */
    public Set<T> keySet(){
        return map.keySet();
    }

    @Override
    public String toString(){
        return map.toString();
    }
}

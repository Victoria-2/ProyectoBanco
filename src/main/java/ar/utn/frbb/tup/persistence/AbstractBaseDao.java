package ar.utn.frbb.tup.persistence;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBaseDao {
    protected static Map<String, Map<Integer, Object>> tinyDataBase = new HashMap<>();
    protected abstract  String getEntityType();

    protected  Map<Integer, Object> getInMemoryDatabase(){
        if(tinyDataBase.get(getEntityType()) == null){
            tinyDataBase.put(getEntityType(), new HashMap<>());
        }
        return tinyDataBase.get(getEntityType());
    }
    
}

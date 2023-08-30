package com.example.demoscreensaver.springcontext;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalTime.now;

public class PeriodicalScopeConfigurer implements Scope {
    Map<String, AbstractMap.SimpleEntry<LocalTime, Object>> map = new HashMap<>();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(map.containsKey(name)){
            AbstractMap.SimpleEntry<LocalTime, Object> pair = map.get(name);
            int secondSinceLastRequest = now().getSecond() - pair.getKey().getSecond();
            if(secondSinceLastRequest > 3 ){
                map.put(name, new AbstractMap.SimpleEntry<>(now(), objectFactory.getObject()));
            }
        }else{
            map.put(name, new AbstractMap.SimpleEntry<>(now(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

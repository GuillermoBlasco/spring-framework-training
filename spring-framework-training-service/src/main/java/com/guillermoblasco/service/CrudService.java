package com.guillermoblasco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;

@RequiredArgsConstructor
public class CrudService<T> {

    private final int maxSize;
    private final Map<String, T> map;
    private final Class<T> clazz;

    public CrudService(int maxSize, Class<T> clazz) {
        this.maxSize = maxSize;
        this.map = new ConcurrentHashMap<>();
        this.clazz = clazz;
    }

    public T get(String id) {
        return map.get(id);
    }

    public void delete(String id) {
        map.remove(id);
    }

    public void update(String id, T data) {
        map.put(id, data);
    }
    public void insert(String id, T data) {
        if (map.size() + 1 > maxSize) {
            throw new IllegalStateException();
        }
        map.put(id, data);
    }

}

package com.myogui.ecommercejava.cache;

public interface CacheUser<T> {
    String save(String key, String value);
    String recover(String key);
}

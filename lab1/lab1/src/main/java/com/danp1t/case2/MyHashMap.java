package com.danp1t.case2;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    private static final int BUCKET_COUNT = 13;
    private final List<List<Object>> buckets;

    public MyHashMap() {
        buckets = new ArrayList<>(BUCKET_COUNT);
        for (int i = 0; i < BUCKET_COUNT; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private long hashString(String s) {
        long h = 0;
        for (char c : s.toCharArray()) {
            h = (h << 4) ^ (long) c;
        }
        return h;
    }

    private int bucketIndex(long value) {
        return (int) (value % BUCKET_COUNT);
    }

    private int bucketIndex(String str) {
        long hash = hashString(str);
        int index = (int) (hash % BUCKET_COUNT);
        if (index < 0) index += BUCKET_COUNT;
        return index;
    }

    public boolean insert(long value) {
        int index = bucketIndex(value);
        List<Object> bucket = buckets.get(index);
        for (Object obj : bucket) {
            if (obj instanceof Long && ((Long) obj) == value) {
                return false;
            }
        }
        bucket.add(value);
        return true;
    }

    public boolean insert(String str) {
        int index = bucketIndex(str);
        List<Object> bucket = buckets.get(index);
        for (Object obj : bucket) {
            if (obj instanceof String && obj.equals(str)) {
                return false;
            }
        }
        bucket.add(str);
        return true;
    }

    public boolean delete(long value) {
        int index = bucketIndex(value);
        List<Object> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            Object obj = bucket.get(i);
            if (obj instanceof Long && ((Long) obj) == value) {
                bucket.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String str) {
        int index = bucketIndex(str);
        List<Object> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            Object obj = bucket.get(i);
            if (obj instanceof String && obj.equals(str)) {
                bucket.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean find(long value) {
        int index = bucketIndex(value);
        List<Object> bucket = buckets.get(index);
        for (Object obj : bucket) {
            if (obj instanceof Long && ((Long) obj) == value) {
                return true;
            }
        }
        return false;
    }

    public boolean find(String str) {
        int index = bucketIndex(str);
        List<Object> bucket = buckets.get(index);
        for (Object obj : bucket) {
            if (obj instanceof String && obj.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
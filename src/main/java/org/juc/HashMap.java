package org.juc;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        Map<String,Object> map = new java.util.HashMap<>(2);
        map.put("a",22);
        map.put("b",33);
        map.get("a");
    }
}

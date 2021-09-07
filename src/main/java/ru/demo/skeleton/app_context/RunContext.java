package ru.demo.skeleton.app_context;

import java.util.HashMap;
import java.util.Map;

public class RunContext {
    private static RunContext instance;
    private static final Map<String, Object> context = new HashMap<>();

    public RunContext() {
    }

    public static RunContext getContext() {
        if (instance == null) {
            instance = new RunContext();
        }
        return instance;
    }

    public static void clear() {
        context.clear();
    }

    public static <T> void put(String key, T object) {
        context.put(key, object);
    }

    public static <T> T get(String key, Class<T> userClass) {
        Object object;
        try {
            object = context.get(key);
        } catch (NullPointerException e) {
            throw new AssertionError(String.format("Object with key %s doesn't exist!", key));
        }
        return userClass.cast(object);
    }
}

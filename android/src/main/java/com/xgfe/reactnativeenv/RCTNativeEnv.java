package com.xgfe.reactnativeenv;

import com.facebook.react.bridge.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Nullable;

public class RCTNativeEnv extends ReactContextBaseJavaModule implements LifecycleEventListener {

    private static HashMap<String, Object> env = new HashMap<>();
    private static boolean isInit = false;

    public static void initEnv(Class buildConfig) {
        initEnv(buildConfig, null);
    }

    public static void initEnv(Class buildConfig, Map envs) {
        //try to get info from buildConfig and others
        addEnv(NativeInfoHelper.getBuildConfigInfo(buildConfig));
        //try to get info from map
        addEnv(envs);
        isInit = true;
    }

    public static void addEnv(String key, Object value) {
        env.put(key, value);
    }

    public static void addEnv(Map<String, Object> map) {
        env.putAll(map);
    }

    public RCTNativeEnv(ReactApplicationContext reactContext) {
        super(reactContext);
        //some envs I can get these autoly;
        addEnv("APPLICATION_NAME", NativeInfoHelper.getApplicationName(getReactApplicationContext()));
    }

    @Override
    public Map<String, Object> getConstants() {
        return env;
    }

    @Override
    public String getName() {
        return "NativeEnvironment";
    }

    @ReactMethod
    public void get(String key, Callback callback) {
        dealInitEvent();
        callback.invoke(env.get(key));
    }

    @ReactMethod
    public void getAll(Callback callback) {
        dealInitEvent();
        WritableNativeMap map = new WritableNativeMap();
        for (Map.Entry<String, Object> entry : env.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                map.putInt(key, (int) value);
            } else if (value instanceof Double) {
                map.putDouble(key, (double) value);
            } else if (value instanceof Boolean) {
                map.putBoolean(key, (boolean) value);
            } else if (value instanceof String) {
                map.putString(key, (String) value);
            } else {
                map.putNull(key);
            }
        }
        callback.invoke(map);
    }

    @Override
    public void onHostResume() {

    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {

    }

    private static void dealInitEvent() {
        if (!isInit) {
            throw new RuntimeException("You should init this by BuildConfig at first.");
        }
    }
}

package com.xgfe.reactnativeenv;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoruidong on 16/7/4.
 */
class NativeInfoHelper {
    public static String getApplicationName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName = (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    public static Map<String, Object> getBuildConfigInfo(Class buildConfig) {
        HashMap<String, Object> infos = new HashMap<>();
        try {
            Field[] fields = buildConfig.getFields();
            for (Field field : fields) {
                switch (field.getName()) {
                    case "DEBUG":
                        infos.put("DEBUG", field.get(null));
                        break;
                    case "APPLICATION_ID":
                        infos.put("APPLICATION_ID", field.get(null));
                        break;
                    case "VERSION_CODE":
                        infos.put("VERSION_CODE", field.get(null));
                        break;
                    case "VERSION_NAME":
                        infos.put("VERSION_NAME", field.get(null));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return infos;
    }
}

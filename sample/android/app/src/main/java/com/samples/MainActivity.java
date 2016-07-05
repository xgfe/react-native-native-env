package com.samples;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.xgfe.reactnativeenv.RCTNativeEnv;
import com.xgfe.reactnativeenv.RCTNativeEnvPackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "samples";
    }

    /**
     * Returns whether dev mode should be enabled.
     * This enables e.g. the dev menu.
     */
    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    /**
     * A list of packages used by the app. If the app uses additional views
     * or modules besides the default ones, add more packages here.
     */
    @Override
    protected List<ReactPackage> getPackages() {
        HashMap<String, Object> envs = new HashMap();
        envs.put("testInfo", "this is a string");
        envs.put("testNumber", 23333);
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new RCTNativeEnvPackage(BuildConfig.class, envs)
        );
    }
}

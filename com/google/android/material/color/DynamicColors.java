package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import com.igexin.assist.util.AssistUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/color/DynamicColors.class */
public class DynamicColors {
    private static final Precondition ALWAYS_ALLOW;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {R.attr.dynamicColorThemeOverlay};
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.1
        @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
        public boolean isSupported() {
            return true;
        }
    };
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.2
        private Long version;

        @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
        public boolean isSupported() {
            boolean z = false;
            if (this.version == null) {
                try {
                    Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                    declaredMethod.setAccessible(true);
                    this.version = Long.valueOf(((Long) declaredMethod.invoke(null, "ro.build.version.oneui")).longValue());
                } catch (Exception e) {
                    this.version = -1L;
                }
            }
            if (this.version.longValue() >= 40100) {
                z = true;
            }
            return z;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/color/DynamicColors$DeviceSupportCondition.class */
    public interface DeviceSupportCondition {
        boolean isSupported();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/color/DynamicColors$DynamicColorsActivityLifecycleCallbacks.class */
    public static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final int dynamicColorThemeOverlay;
        private final Precondition precondition;

        DynamicColorsActivityLifecycleCallbacks(int i, Precondition precondition) {
            this.dynamicColorThemeOverlay = i;
            this.precondition = precondition;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.applyIfAvailable(activity, this.dynamicColorThemeOverlay, this.precondition);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/color/DynamicColors$Precondition.class */
    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity activity, int i);
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(AssistUtils.BRAND_OPPO, DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("realme", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("oneplus", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put(AssistUtils.BRAND_VIVO, DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put(AssistUtils.BRAND_XIAOMI, DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("motorola", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("itel", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tecno mobile limited", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("infinix mobility limited", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("hmd global", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("sharp", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("sony", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("tcl", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("lenovo", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("lge", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("google", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("robolectric", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap.put("samsung", SAMSUNG_DEVICE_SUPPORT_CONDITION);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", DEFAULT_DEVICE_SUPPORT_CONDITION);
        hashMap2.put("jio", DEFAULT_DEVICE_SUPPORT_CONDITION);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(hashMap2);
        ALWAYS_ALLOW = new Precondition() { // from class: com.google.android.material.color.DynamicColors.3
            @Override // com.google.android.material.color.DynamicColors.Precondition
            public boolean shouldApplyDynamicColors(Activity activity, int i) {
                return true;
            }
        };
    }

    private DynamicColors() {
    }

    public static void applyIfAvailable(Activity activity) {
        applyIfAvailable(activity, 0);
    }

    public static void applyIfAvailable(Activity activity, int i) {
        applyIfAvailable(activity, i, ALWAYS_ALLOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyIfAvailable(Activity activity, int i, Precondition precondition) {
        if (isDynamicColorAvailable()) {
            int i2 = i;
            if (i == 0) {
                i2 = getDefaultThemeOverlay(activity);
            }
            if (i2 == 0 || !precondition.shouldApplyDynamicColors(activity, i2)) {
                return;
            }
            activity.setTheme(i2);
        }
    }

    public static void applyIfAvailable(Activity activity, Precondition precondition) {
        applyIfAvailable(activity, 0, precondition);
    }

    public static void applyToActivitiesIfAvailable(Application application) {
        applyToActivitiesIfAvailable(application, 0);
    }

    public static void applyToActivitiesIfAvailable(Application application, int i) {
        applyToActivitiesIfAvailable(application, i, ALWAYS_ALLOW);
    }

    public static void applyToActivitiesIfAvailable(Application application, int i, Precondition precondition) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(i, precondition));
    }

    public static void applyToActivitiesIfAvailable(Application application, Precondition precondition) {
        applyToActivitiesIfAvailable(application, 0, precondition);
    }

    private static int getDefaultThemeOverlay(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        DeviceSupportCondition deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        DeviceSupportCondition deviceSupportCondition2 = deviceSupportCondition;
        if (deviceSupportCondition == null) {
            deviceSupportCondition2 = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
        }
        boolean z = false;
        if (deviceSupportCondition2 != null) {
            z = false;
            if (deviceSupportCondition2.isSupported()) {
                z = true;
            }
        }
        return z;
    }

    public static Context wrapContextIfAvailable(Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    public static Context wrapContextIfAvailable(Context context, int i) {
        if (isDynamicColorAvailable()) {
            int i2 = i;
            if (i == 0) {
                i2 = getDefaultThemeOverlay(context);
            }
            return i2 == 0 ? context : new ContextThemeWrapper(context, i2);
        }
        return context;
    }
}

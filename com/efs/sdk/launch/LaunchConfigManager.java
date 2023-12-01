package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/launch/LaunchConfigManager.class */
public class LaunchConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f8194a = "LaunchConfigManager";
    private final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private EfsReporter f8195c;
    private int d;
    private int e;
    private boolean f;
    private Context g;

    public LaunchConfigManager(Context context, EfsReporter efsReporter) {
        boolean z;
        boolean z2;
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor edit3;
        SharedPreferences.Editor edit4;
        this.d = 100;
        this.f = false;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.f8195c = efsReporter;
        SharedPreferences sharedPreferences2 = applicationContext.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences2 != null) {
            this.e = sharedPreferences2.getInt("apm_startperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences3 = this.g.getSharedPreferences("efs_launch", 0);
        int i = sharedPreferences3 != null ? sharedPreferences3.getInt("apm_startperf_sampling_rate", -1) : -1;
        this.f8195c.getAllSdkConfig(new String[]{"apm_startperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.launch.LaunchConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences4;
                SharedPreferences.Editor edit5;
                try {
                    Object obj = map.get("apm_startperf_sampling_rate");
                    if (obj == null || (sharedPreferences4 = LaunchConfigManager.this.g.getSharedPreferences("efs_launch", 0)) == null || (edit5 = sharedPreferences4.edit()) == null) {
                        return;
                    }
                    edit5.putInt("apm_startperf_sampling_rate", Integer.parseInt(obj.toString()));
                    edit5.commit();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.d = i;
        }
        SharedPreferences sharedPreferences4 = this.g.getSharedPreferences("efs_launch", 0);
        long j = sharedPreferences4 != null ? sharedPreferences4.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
        boolean z3 = sharedPreferences4 != null ? sharedPreferences4.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
        int i2 = this.d;
        if (i2 != 0) {
            boolean z4 = i2 != this.e;
            int i3 = this.d;
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Long valueOf2 = Long.valueOf(valueOf.longValue() - Long.valueOf(j).longValue());
            if (z3 && valueOf2.longValue() < 86400000 && !z4) {
                z2 = true;
                if (LaunchManager.isDebug) {
                    Log.d("LaunchConfigManager", " check in allready");
                    z2 = true;
                }
            } else if (valueOf2.longValue() >= 86400000 || z4) {
                if (i3 != 0 && (i3 == 100 || new Random().nextInt(100) <= i3)) {
                    z = true;
                    if (LaunchManager.isDebug) {
                        Log.d("LaunchConfigManager", "random check in");
                        z = true;
                    }
                } else {
                    if (LaunchManager.isDebug) {
                        Log.d("LaunchConfigManager", "random not check in!");
                    }
                    z = false;
                }
                SharedPreferences sharedPreferences5 = this.g.getSharedPreferences("efs_launch", 0);
                if (sharedPreferences5 != null && (edit = sharedPreferences5.edit()) != null) {
                    edit.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z);
                    edit.commit();
                }
                z2 = z;
                if (sharedPreferences5 != null) {
                    SharedPreferences.Editor edit5 = sharedPreferences5.edit();
                    z2 = z;
                    if (edit5 != null) {
                        edit5.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, valueOf.longValue());
                        edit5.commit();
                        z2 = z;
                    }
                }
            } else if (LaunchManager.isDebug) {
                Log.d("LaunchConfigManager", "un repeat check in 24 hour!");
            }
            this.f = z2;
            sharedPreferences = this.g.getSharedPreferences("efs_launch", 0);
            if (sharedPreferences != null || (edit2 = sharedPreferences.edit()) == null) {
            }
            edit2.putInt("apm_startperf_sampling_rate_last", this.d);
            edit2.commit();
            return;
        }
        if (z3 && sharedPreferences4 != null && (edit4 = sharedPreferences4.edit()) != null) {
            edit4.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
            edit4.commit();
        }
        if (j != 0 && sharedPreferences4 != null && (edit3 = sharedPreferences4.edit()) != null) {
            edit3.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
            edit3.commit();
        }
        z2 = false;
        this.f = z2;
        sharedPreferences = this.g.getSharedPreferences("efs_launch", 0);
        if (sharedPreferences != null) {
        }
    }

    public boolean enableTracer() {
        return this.f;
    }
}

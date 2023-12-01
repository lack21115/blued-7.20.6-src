package com.efs.sdk.base.core.config.a;

import android.content.SharedPreferences;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/a/e.class */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    volatile SharedPreferences f21756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        GlobalEnvStruct globalEnvStruct = ControllerCenter.getGlobalEnvStruct();
        File b = com.efs.sdk.base.core.util.a.b(globalEnvStruct.mAppContext, globalEnvStruct.getAppid());
        if (b.exists()) {
            com.efs.sdk.base.core.util.b.b(b);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        File a2 = com.efs.sdk.base.core.util.a.a(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (a2.exists()) {
            a2.delete();
        }
    }

    private void d() {
        if (this.f21756a == null) {
            synchronized (com.efs.sdk.base.core.c.b.class) {
                try {
                    if (this.f21756a == null) {
                        String appid = ControllerCenter.getGlobalEnvStruct().getAppid();
                        this.f21756a = SharedPreferencesUtils.getSharedPreferences(ControllerCenter.getGlobalEnvStruct().mAppContext, com.efs.sdk.base.core.util.b.b.a(("config_" + appid.toLowerCase()).getBytes()));
                        this.f21756a.registerOnSharedPreferenceChangeListener(this);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(b bVar) {
        c();
        if (this.f21756a == null) {
            return false;
        }
        SharedPreferences.Editor edit = this.f21756a.edit();
        edit.clear();
        edit.putInt("cver", bVar.f21749a);
        edit.putLong("last_refresh_time", System.currentTimeMillis());
        for (Map.Entry<String, String> entry : bVar.f.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
        }
        edit.apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        try {
            d();
        } catch (Throwable th) {
            Log.e("efs.config", "init sharedpreferences error", th);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        f fVar;
        fVar = f.a.f21744a;
        if (fVar.a()) {
            return;
        }
        c.a().b();
    }
}

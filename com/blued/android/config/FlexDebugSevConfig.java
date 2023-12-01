package com.blued.android.config;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.framework.utils.FileCache;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.utils.SenseTimeLicUtils;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/config/FlexDebugSevConfig.class */
public class FlexDebugSevConfig {
    private static volatile FlexDebugSevConfig a;
    private DebugSevConfigModel b = h();

    private FlexDebugSevConfig() {
    }

    public static FlexDebugSevConfig a() {
        if (a == null) {
            synchronized (FlexDebugSevConfig.class) {
                try {
                    if (a == null) {
                        a = new FlexDebugSevConfig();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DebugSevConfigModel debugSevConfigModel) {
        Log.v("FlexDebugSevConfig", "updateModel, " + debugSevConfigModel);
        if (debugSevConfigModel == null) {
            BluedPreferences.ab("");
            return;
        }
        this.b = debugSevConfigModel;
        g();
    }

    private void g() {
        String json = AppInfo.f().toJson(this.b);
        if (TextUtils.isEmpty(json)) {
            return;
        }
        BluedPreferences.ab(json);
    }

    private DebugSevConfigModel h() {
        String dX = BluedPreferences.dX();
        try {
            if (!TextUtils.isEmpty(dX)) {
                return (DebugSevConfigModel) AppInfo.f().fromJson(dX, DebugSevConfigModel.class);
            }
        } catch (Throwable th) {
            BluedStatistics.c().a("DEBUG_CONFIG_JSON_ERROR", 0L, -1, dX);
        }
        return new DebugSevConfigModel();
    }

    public DebugSevConfigModel b() {
        return this.b;
    }

    public void c() {
        AppHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<DebugSevConfigModel>>(null) { // from class: com.blued.android.config.FlexDebugSevConfig.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DebugSevConfigModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    DebugSevConfigModel singleData = bluedEntityA.getSingleData();
                    FlexDebugSevConfig.this.a(singleData);
                    try {
                        LiveMsgSendManager.a().c();
                        if (singleData != null && !TextUtils.isEmpty(singleData.android_external_sense_update_info)) {
                            SenseTimeLicUtils.a(singleData.android_external_sense_update_info);
                        }
                        if (singleData.android_http_cache_limit == 1) {
                            ThreadManager.a().a(new ThreadExecutor("clearHttpCache", ThreadPriority.HIGH) { // from class: com.blued.android.config.FlexDebugSevConfig.1.1
                                @Override // com.blued.android.framework.pool.ThreadExecutor
                                public void execute() {
                                    FileCache.a();
                                }
                            });
                        }
                    } catch (Throwable th) {
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                Log.e("FlexDebugSevConfig", "updateSevConfig failed");
                return true;
            }
        });
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }

    public void f() {
        a = null;
    }
}

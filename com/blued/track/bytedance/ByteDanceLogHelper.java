package com.blued.track.bytedance;

import android.app.Application;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.ILogger;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.picker.Picker;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/track/bytedance/ByteDanceLogHelper.class */
public final class ByteDanceLogHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteDanceLogHelper f20623a = new ByteDanceLogHelper();

    private ByteDanceLogHelper() {
    }

    @JvmStatic
    public static final void a() {
        AppLog.setUserUniqueID(null);
    }

    @JvmStatic
    public static final void a(Application application, String str) {
        Intrinsics.e(application, "application");
        Intrinsics.a((Object) str);
        InitConfig initConfig = new InitConfig("10000001", str);
        initConfig.setUriConfig(UriConfig.createByDomain("https://snssdk.irisdt.cn", null));
        initConfig.setAbEnable(true);
        initConfig.enableDeferredALink();
        if (AppInfo.m()) {
            initConfig.setLogger(new ILogger() { // from class: com.blued.track.bytedance.-$$Lambda$ByteDanceLogHelper$51gVOcxogLNqDR_dF29XVIZ40nU
                @Override // com.bytedance.applog.ILogger
                public final void log(String str2, Throwable th) {
                    ByteDanceLogHelper.a(str2, th);
                }
            });
        }
        initConfig.setPicker(new Picker(application, initConfig));
        initConfig.setAutoTrackEnabled(false);
        initConfig.setH5CollectEnable(false);
        AppLog.setEncryptAndCompress(!AppInfo.m());
        initConfig.setAutoStart(true);
        AppLog.addDataObserver(new IDataObserver() { // from class: com.blued.track.bytedance.ByteDanceLogHelper$init$2
            @Override // com.bytedance.applog.IDataObserver
            public void onAbVidsChange(String s, String s1) {
                Intrinsics.e(s, "s");
                Intrinsics.e(s1, "s1");
            }

            @Override // com.bytedance.applog.IDataObserver
            public void onIdLoaded(String s, String s1, String s2) {
                Intrinsics.e(s, "s");
                Intrinsics.e(s1, "s1");
                Intrinsics.e(s2, "s2");
            }

            @Override // com.bytedance.applog.IDataObserver
            public void onRemoteAbConfigGet(boolean z, JSONObject jsonObject) {
                Intrinsics.e(jsonObject, "jsonObject");
            }

            @Override // com.bytedance.applog.IDataObserver
            public void onRemoteConfigGet(boolean z, JSONObject jsonObject) {
                Intrinsics.e(jsonObject, "jsonObject");
            }

            @Override // com.bytedance.applog.IDataObserver
            public void onRemoteIdGet(boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
            }
        });
        AppLog.init(application, initConfig);
    }

    @JvmStatic
    public static final void a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, "0")) {
            a();
        } else {
            AppLog.setUserUniqueID(EncryptTool.b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String str, Throwable th) {
        Logger.c("ByteDanceLogHelper", Intrinsics.a("", (Object) str));
    }
}

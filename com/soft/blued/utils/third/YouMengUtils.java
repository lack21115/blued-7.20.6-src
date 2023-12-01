package com.soft.blued.utils.third;

import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.soft.blued.app.BluedApplicationLike;
import com.uc.crashsdk.export.CrashApi;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.umcrash.UMCrash;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/YouMengUtils.class */
public final class YouMengUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final YouMengUtils f21154a = new YouMengUtils();

    private YouMengUtils() {
    }

    @JvmStatic
    public static final void a() {
        UMConfigure.init(AppInfo.d(), BluedApplicationLike.umengAppKey, AppInfo.c, 1, null);
        UMCrash.setAppVersion("7.20.6.3", "", "");
        Bundle bundle = new Bundle();
        bundle.putBoolean("mCallNativeDefaultHandler", true);
        CrashApi.getInstance().updateCustomInfo(bundle);
        UMConfigure.setLogEnabled(false);
        MobclickAgent.setDebugMode(false);
        MobclickAgent.setCatchUncaughtExceptions(false);
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
    }

    @JvmStatic
    public static final void a(String str) {
        MobclickAgent.onProfileSignIn(EncryptTool.b(str));
    }

    @JvmStatic
    public static final void b() {
        MobclickAgent.onProfileSignOff();
    }
}

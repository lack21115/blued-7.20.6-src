package com.soft.blued.utils;

import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.module.common.user.model.UserInfo;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.soft.blued.tinker.util.TinkerTools;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/BuglyCrashRecorder.class */
public class BuglyCrashRecorder extends CrashReport.CrashHandleCallback {

    /* renamed from: a  reason: collision with root package name */
    public static String f21032a = "";

    @Override // com.tencent.bugly.BuglyStrategy.a
    public Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("TopFragment", BaseFragmentActivity.a);
        linkedHashMap.put("TopActivity", f21032a);
        linkedHashMap.put("RoutePath", BaseActivity.a);
        linkedHashMap.put("Tinker patch", TinkerTools.a());
        linkedHashMap.put("versionCode", "" + DeviceUtils.b());
        linkedHashMap.put("uid", UserInfo.getInstance().getLoginUserInfo().uid);
        linkedHashMap.put("user_name", "" + UserInfo.getInstance().getLoginUserInfo().name);
        linkedHashMap.put("bugly_page_info", AppInfo.r());
        return linkedHashMap;
    }

    @Override // com.tencent.bugly.BuglyStrategy.a
    public byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
        try {
            if (AppInfo.c()) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
                printWriter.append((CharSequence) ("\ncrashTime=" + format));
                printWriter.append((CharSequence) "\n7.20.6, 720063");
                printWriter.append((CharSequence) ("\nuid: " + UserInfo.getInstance().getLoginUserInfo().uid));
                printWriter.append((CharSequence) ("\ncrashType:" + i));
                printWriter.append((CharSequence) "\n");
                printWriter.append((CharSequence) ("errorType:" + str));
                printWriter.append((CharSequence) "\n");
                printWriter.append((CharSequence) str2);
                printWriter.append((CharSequence) str3);
                String obj = stringWriter.toString();
                printWriter.close();
                AppMethods.a(obj, AppMethods.a(CrashHianalyticsData.EVENT_ID_CRASH), "blued_crash.txt");
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

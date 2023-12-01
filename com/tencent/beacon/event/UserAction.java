package com.tencent.beacon.event;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/UserAction.class */
public class UserAction {

    /* renamed from: a  reason: collision with root package name */
    private static String f35030a;

    /* renamed from: c  reason: collision with root package name */
    private static String f35031c;
    public static Context mContext;
    private static BeaconConfig.Builder b = BeaconConfig.builder();
    private static boolean d = true;

    @Deprecated
    public static void closeUseInfoEvent() {
    }

    public static void doUploadRecords() {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
        if (eventModule != null) {
            eventModule.a(false);
        }
    }

    public static void flushObjectsToDB(boolean z) {
    }

    public static Map<String, String> getAdditionalInfo() {
        return getAdditionalInfo(null);
    }

    public static Map<String, String> getAdditionalInfo(String str) {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
        if (eventModule != null) {
            return eventModule.a(str);
        }
        return null;
    }

    public static String getAppKey() {
        return f35030a;
    }

    public static String getCloudParas(String str) {
        return "";
    }

    public static BeaconPubParams getCommonParams() {
        return BeaconReport.getInstance().getCommonParams(mContext);
    }

    public static String getEventDomain() {
        return com.tencent.beacon.base.net.b.b.f34973c;
    }

    public static String getOpenID(String str) {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
        return eventModule != null ? eventModule.b(str) : "";
    }

    public static String getQIMEI() {
        Qimei b2 = j.b();
        return b2 == null ? "" : b2.getQimei16();
    }

    public static void getQimei(IAsyncQimeiListener iAsyncQimeiListener) throws NullPointerException {
        j.a(iAsyncQimeiListener);
    }

    public static String getQimeiByKey(String str) {
        Qimei b2;
        if (TextUtils.isEmpty(str) || (b2 = j.b()) == null) {
            return "";
        }
        if (str.equals("A3")) {
            return b2.getQimei16();
        }
        return str.equals("A153") ? b2.getQimei36() : "";
    }

    public static String getQimeiNew() {
        Qimei b2 = j.b();
        return b2 == null ? "" : b2.getQimei36();
    }

    @Deprecated
    public static String getRtQIMEI(Context context) {
        Qimei a2 = j.a(context);
        return a2 == null ? "" : a2.getQimei16();
    }

    public static String getSDKVersion() {
        return BeaconReport.getInstance().getSDKVersion();
    }

    public static String getStrategyDomain() {
        return com.tencent.beacon.base.net.b.b.d;
    }

    public static String getUserID(String str) {
        EventModule eventModule = (EventModule) com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
        return eventModule != null ? eventModule.c(str) : "";
    }

    public static void initUserAction(Context context) {
        initUserAction(context, true);
    }

    public static void initUserAction(Context context, boolean z) {
        initUserAction(context, z, 0L);
    }

    public static void initUserAction(Context context, boolean z, long j) {
        initUserAction(context, z, j, null, null);
    }

    public static void initUserAction(Context context, boolean z, long j, InitHandleListener initHandleListener, UploadHandleListener uploadHandleListener) {
        if (!d) {
            Log.e("beacon", "UserAction.initUserAction is not available");
            return;
        }
        mContext = context;
        BeaconReport.getInstance().start(context, f35030a, b.build());
    }

    public static boolean loginEvent(boolean z, long j, Map<String, String> map) {
        if (mContext != null) {
            map.put("A19", com.tencent.beacon.a.c.e.l().q());
        }
        return onUserAction("rqd_wgLogin", z, j, 0L, map, true);
    }

    public static boolean onDTUserAction(Context context, String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        if (context == null) {
            return false;
        }
        if (map != null) {
            com.tencent.beacon.a.c.c.d().a(context);
            com.tencent.beacon.a.c.e l = com.tencent.beacon.a.c.e.l();
            com.tencent.beacon.a.c.f e = com.tencent.beacon.a.c.f.e();
            HashMap hashMap = new HashMap(map);
            hashMap.put("dt_imei2", "" + e.c());
            hashMap.put("dt_meid", "" + e.g());
            hashMap.put("dt_mf", "" + l.o());
            return onUserAction(str, z, j, j2, hashMap, z2, z3);
        }
        return onUserAction(str, z, j, j2, null, z2, z3);
    }

    public static boolean onDTUserActionToTunnel(Context context, String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        if (context == null) {
            return false;
        }
        if (map != null) {
            com.tencent.beacon.a.c.c.d().a(context);
            com.tencent.beacon.a.c.e l = com.tencent.beacon.a.c.e.l();
            com.tencent.beacon.a.c.f e = com.tencent.beacon.a.c.f.e();
            HashMap hashMap = new HashMap(map);
            hashMap.put("dt_imei2", "" + e.c());
            hashMap.put("dt_meid", "" + e.g());
            hashMap.put("dt_mf", "" + l.o());
            return onUserActionToTunnel(str, str2, hashMap, z, z2);
        }
        return onUserActionToTunnel(str, str2, null, z, z2);
    }

    public static void onPageIn(String str) {
        com.tencent.beacon.d.a.a(com.tencent.beacon.event.c.d.d(str));
    }

    public static void onPageOut(String str) {
        com.tencent.beacon.d.a.b(com.tencent.beacon.event.c.d.d(str));
    }

    public static boolean onUserAction(String str, Map<String, String> map, boolean z, boolean z2) {
        return onUserAction(str, true, -1L, -1L, map, z, z2);
    }

    public static boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        return onUserAction(str, z, j, j2, map, z2, false);
    }

    public static boolean onUserAction(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str).withType(z2 ? EventType.REALTIME : EventType.NORMAL).withParams(map).withAppKey(f35030a).withIsSucceed(z).build()).isSuccess();
    }

    public static boolean onUserActionToTunnel(String str, String str2, Map<String, String> map, boolean z, boolean z2) {
        return onUserActionToTunnel(str, str2, true, -1L, -1L, map, z, z2);
    }

    public static boolean onUserActionToTunnel(String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        return BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str2).withType(z2 ? EventType.REALTIME : EventType.NORMAL).withParams(map).withAppKey(str).withIsSucceed(z).build()).isSuccess();
    }

    public static void registerTunnel(TunnelInfo tunnelInfo) {
    }

    public static void setAdditionalInfo(String str, Map<String, String> map) {
        BeaconReport.getInstance().setAdditionalParams(str, map);
    }

    public static void setAdditionalInfo(Map<String, String> map) {
        setAdditionalInfo(null, map);
    }

    public static void setAppKey(String str) {
        f35030a = str;
    }

    public static void setAppVersion(String str) {
        f35031c = str;
    }

    @Deprecated
    public static void setAutoLaunchEventUsable(boolean z) {
    }

    public static void setChannelID(String str) {
        BeaconReport.getInstance().setChannelID(str);
    }

    public static void setJsClientId(String str) {
    }

    public static void setLogAble(boolean z, boolean z2) {
        com.tencent.beacon.base.util.c.a(z);
        com.tencent.beacon.base.util.c.b(z);
    }

    public static void setOAID(String str) {
        BeaconReport.getInstance().setOAID(str);
    }

    @Deprecated
    public static void setOldInitMethodEnable(boolean z) {
        d = z;
    }

    public static void setOmgId(String str) {
        BeaconReport.getInstance().setOmgID(str);
    }

    public static void setOpenID(String str) {
        BeaconReport.getInstance().setOpenID(null, str);
    }

    public static void setQQ(String str) {
        BeaconReport.getInstance().setQQ(str);
    }

    public static void setReportDomain(String str, String str2) {
        com.tencent.beacon.base.net.b.b.a(str, str2);
    }

    public static void setReportIP(String str, String str2) {
        com.tencent.beacon.base.net.b.b.b(str, str2);
    }

    public static void setScheduledService(ScheduledExecutorService scheduledExecutorService) {
        b.setExecutorService(scheduledExecutorService);
    }

    public static void setStrictMode(boolean z) {
        BeaconReport.getInstance().setStrictMode(z);
    }

    public static void setUploadMode(boolean z) {
        if (z) {
            BeaconReport.getInstance().pauseUpload(true);
        } else {
            BeaconReport.getInstance().resumeUpload();
        }
    }

    public static void setUserID(String str) {
        setUserID(null, str);
    }

    public static void setUserID(String str, String str2) {
        BeaconReport.getInstance().setUserID(str, str2);
    }
}

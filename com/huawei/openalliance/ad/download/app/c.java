package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/c.class */
public class c {
    private static final String B = "getDownloadStatus";
    private static final String C = "trafficReminderExceptionEvent";
    private static final String Code = "ApDnApi";
    private static final String D = "AutoOpenForbidden";
    private static final String F = "reportFullScreenNotify";
    private static final String I = "pauseDownloadApp";
    private static final String L = "remoteSharedPrefSet";
    private static final String S = "syncAgProtocolStatus";
    private static final String V = "startDownloadApp";
    private static final String Z = "cancelDownloadApp";

    /* renamed from: a  reason: collision with root package name */
    private static final String f22965a = "reportInstallPermission";
    private static final String b = "reserveDownloadApp";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T Code(Context context, AppInfo appInfo, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", z.V(appInfo));
            return com.huawei.openalliance.ad.ipc.b.Code(context).Code(B, jSONObject.toString(), cls, Code(appInfo)).getData();
        } catch (JSONException e) {
            ge.I(Code, "queryTask JSONException");
            return null;
        }
    }

    public static <T> void Code(Context context, int i, String str, String str2, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(at.f, i);
            jSONObject.put(at.h, str);
            jSONObject.put("ag_action_name", str2);
            com.huawei.openalliance.ad.ipc.b.Code(context).Code(S, jSONObject.toString(), cls, true);
        } catch (JSONException e) {
            ge.I(Code, "syncAgProcolAgreeStatus JSONException");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void Code(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(appDownloadTask, jSONObject);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(V, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException e) {
            Code(remoteCallResultCallback, "startDownload JSONException", V);
        }
    }

    public static <T> void Code(Context context, String str, AdContentData adContentData, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        if (adContentData != null) {
            try {
                jSONObject.put("content_id", adContentData.S());
                jSONObject.put(at.C, adContentData.az());
                jSONObject.put(at.ac, adContentData.C());
                jSONObject.put(at.S, adContentData.aA());
            } catch (JSONException e) {
                Code(remoteCallResultCallback, "reportAnalysisEvent JSONException", C);
                return;
            }
        }
        jSONObject.put(at.f22943a, str);
        com.huawei.openalliance.ad.ipc.g.V(context).Code(C, jSONObject.toString(), remoteCallResultCallback, cls);
    }

    public static <T> void Code(Context context, boolean z, int i, String str, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(at.T, z);
            jSONObject.put(at.U, i);
            jSONObject.put(at.W, str);
            com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(F, jSONObject.toString(), remoteCallResultCallback, cls);
            if (v.I()) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(F, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException e) {
            ge.I(Code, "reportFullScreenNotify JSONException");
        }
    }

    public static <T> void Code(Context context, boolean z, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(at.aa, D);
            jSONObject.put(at.ab, z);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(L, jSONObject.toString(), remoteCallResultCallback, cls);
            if (v.I()) {
                com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(L, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException e) {
            ge.I(Code, "setAutoOpenForbidden JSONException");
        }
    }

    private static void Code(AppDownloadTask appDownloadTask, JSONObject jSONObject) {
        String V2 = z.V(appDownloadTask);
        ge.Code(Code, "appdownload=%s", V2);
        jSONObject.put("content", V2);
        jSONObject.put("unique_id", (appDownloadTask == null || appDownloadTask.L() == null || appDownloadTask.L().e() == null) ? "" : appDownloadTask.L().e());
    }

    private static <T> void Code(RemoteCallResultCallback<T> remoteCallResultCallback, String str, String str2) {
        ge.I(Code, str);
        if (remoteCallResultCallback != null) {
            CallResult<T> callResult = new CallResult<>();
            callResult.setCode(-1);
            callResult.setMsg(str);
            remoteCallResultCallback.onRemoteCallResult(str2, callResult);
        }
    }

    private static boolean Code(AppDownloadTask appDownloadTask) {
        return appDownloadTask != null && appDownloadTask.m();
    }

    private static boolean Code(AppInfo appInfo) {
        return appInfo != null && appInfo.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void I(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", z.V(appDownloadTask));
            AppInfo V2 = V(appDownloadTask);
            if (V2 != null) {
                jSONObject.put(at.D, z.V(V2));
            }
            com.huawei.openalliance.ad.ipc.h.Code(context, Code(appDownloadTask)).Code(Z, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException e) {
            Code(remoteCallResultCallback, "cancelDownload JSONException", Z);
        }
    }

    private static AppInfo V(AppDownloadTask appDownloadTask) {
        if (appDownloadTask == null || appDownloadTask.L() == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.D(appDownloadTask.L().Code());
        appInfo.I(appDownloadTask.L().g());
        appInfo.a(appDownloadTask.j());
        return appInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void V(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", z.V(appDownloadTask));
            AppInfo V2 = V(appDownloadTask);
            if (V2 != null) {
                jSONObject.put(at.D, z.V(V2));
            }
            com.huawei.openalliance.ad.ipc.h.Code(context, Code(appDownloadTask)).Code(I, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException e) {
            Code(remoteCallResultCallback, "pauseDownload JSONException", I);
        }
    }

    public static <T> void V(Context context, boolean z, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(at.ai, z);
            com.huawei.openalliance.ad.ipc.h.Code(context, true).Code(f22965a, jSONObject.toString(), remoteCallResultCallback, cls);
            if (v.I()) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code(f22965a, jSONObject.toString(), remoteCallResultCallback, cls);
            }
        } catch (JSONException e) {
            ge.I(Code, "reportInstallPermission JSONException");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void Z(Context context, AppDownloadTask appDownloadTask, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(appDownloadTask, jSONObject);
            com.huawei.openalliance.ad.ipc.g.V(context).Code(b, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException e) {
            Code(remoteCallResultCallback, "reserveDownloadApp JSONException", b);
        }
    }
}

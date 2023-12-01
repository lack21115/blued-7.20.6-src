package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.i;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/framework/UMEnvelopeBuild.class */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag = false;

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        i a2 = i.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(bl.e, str2);
        contentValues.put(bl.f, a2.c(jSONObject.toString()));
        contentValues.put(bl.g, a2.c(jSONObject2.toString()));
        contentValues.put(bl.h, String.valueOf(currentTimeMillis));
        contentValues.put(bl.i, randomUUID.toString());
        contentValues.put(bl.j, str);
        contentValues.put(bl.k, str3);
        bj.a(context).a(bl.f26975c, contentValues);
        if ("i".equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if ("s".equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException e) {
            }
        } else if (!"p".equalsIgnoreCase(str2)) {
            try {
                if ("t".equalsIgnoreCase(str2)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(b.a("header"), new JSONObject());
                    jSONObject4.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(b.a("header"), new JSONObject());
                jSONObject5.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            } catch (JSONException e2) {
                return jSONObject2;
            }
        }
        return new JSONObject();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, jSONObject.has("st") ? "t" : jSONObject2.has(bh.ax) ? "i" : "a", "9.6.3");
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        if (TextUtils.isEmpty(str)) {
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException e) {
                jSONObject3 = null;
            }
            try {
                jSONObject3.put("exception", 121);
                return jSONObject3;
            } catch (JSONException e2) {
                return jSONObject3;
            }
        } else if (UMUtils.isMainProgress(context)) {
            if (UMConfigure.needSendZcfgEnv(context)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
                return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
            if (bj.a(context).c()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
                return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str, str2, str3);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
            JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
            if (!UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.t)) {
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.t, com.umeng.commonsdk.internal.b.a(context).a(), null);
            }
            return add2CacheTable;
        } else {
            try {
                jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("exception", 120);
                    return jSONObject4;
                } catch (JSONException e3) {
                    return jSONObject4;
                }
            } catch (JSONException e4) {
                jSONObject4 = null;
            }
        }
    }

    public static JSONObject buildSilentEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (UMUtils.isMainProgress(context)) {
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        JSONObject jSONObject3 = null;
        try {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (JSONException e) {
                jSONObject3 = jSONObject4;
                return jSONObject3;
            }
        } catch (JSONException e2) {
        }
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        if (UMUtils.isMainProgress(context)) {
            return new b().b(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        JSONObject jSONObject3 = null;
        try {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (JSONException e) {
                jSONObject3 = jSONObject4;
                return jSONObject3;
            }
        } catch (JSONException e2) {
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static boolean getTransmissionSendFlag() {
        boolean z;
        synchronized (UMEnvelopeBuild.class) {
            try {
                z = transmissionSendFlag;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        a.a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r3) == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r4) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRet(android.content.Context r3, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r4, boolean r5) {
        /*
            r0 = r5
            r7 = r0
            r0 = r3
            if (r0 == 0) goto L71
            r0 = r3
            android.content.Context r0 = r0.getApplicationContext()
            r9 = r0
            r0 = r9
            boolean r0 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0)
            r8 = r0
            r0 = r9
            int r0 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r0)
            r6 = r0
            r0 = r8
            if (r0 == 0) goto L5c
            r0 = r4
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r1 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            if (r0 != r1) goto L37
            r0 = r9
            r1 = r4
            boolean r0 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r1)
            if (r0 == 0) goto L32
            goto L44
        L32:
            r0 = 1
            r5 = r0
            goto L5c
        L37:
            boolean r0 = com.umeng.commonsdk.framework.a.a()
            if (r0 == 0) goto L49
            int r0 = com.umeng.commonsdk.framework.a.b()
            long r0 = (long) r0
            com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(r0)
        L44:
            r0 = 0
            r5 = r0
            goto L5c
        L49:
            r0 = r9
            r1 = r4
            boolean r0 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r1)
            if (r0 != 0) goto L44
            r0 = r3
            boolean r0 = com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r0)
            if (r0 == 0) goto L32
            goto L44
        L5c:
            r0 = r5
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L71
            r0 = r5
            r7 = r0
            r0 = r6
            if (r0 <= 0) goto L71
            com.umeng.commonsdk.framework.a.d()
            r0 = r5
            r7 = r0
        L71:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return b.a(context.getApplicationContext());
    }

    public static void registerNetReceiver(Context context) {
        a.b(context);
    }

    public static void sendProcessNextMsgOnce() {
        a.d();
    }

    public static void setTransmissionSendFlag(boolean z) {
        synchronized (UMEnvelopeBuild.class) {
            try {
                transmissionSendFlag = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

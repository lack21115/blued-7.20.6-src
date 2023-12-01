package com.blued.android.module.live_china.utils.log;

import android.text.TextUtils;
import com.amap.api.fence.GeoFence;
import com.anythink.core.common.c.g;
import com.anythink.core.common.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.model.LogData;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/log/InstantLog.class */
public class InstantLog {
    public static void a(int i, int i2, int i3) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("whitening", String.valueOf(i));
        a.put("pinky", String.valueOf(i2));
        a.put("buffing", String.valueOf(i3));
        a("filters_type_score", a);
    }

    public static void a(int i, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("from", i + "");
        a.put("uid", str);
        a.put("item_id", str2);
        if (!TextUtils.isEmpty(str3)) {
            a.put("type", str3);
        }
        a.put("status", str4);
        a.put("num", str5);
        a("live_item_show", a);
    }

    public static void a(InstantLogBody instantLogBody) {
        c(instantLogBody, null);
    }

    public static void a(InstantLogBody instantLogBody, Map<String, String> map) {
        c(instantLogBody, map);
    }

    public static void a(final LogData logData) {
        ThreadManager.a().a((Runnable) new ThreadExecutor("postLogData", ThreadPriority.LOW) { // from class: com.blued.android.module.live_china.utils.log.InstantLog.2
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                LogData logData2 = logData;
                if (logData2 == null || TextUtils.isEmpty(logData2.D)) {
                    return;
                }
                Map<String, String> a = BluedHttpTools.a();
                if (!TextUtils.isEmpty(logData.a)) {
                    a.put("num", logData.a);
                }
                if (!TextUtils.isEmpty(logData.b)) {
                    a.put("target_uid", logData.b);
                }
                if (!TextUtils.isEmpty(logData.c)) {
                    a.put("uid", logData.c);
                }
                if (!TextUtils.isEmpty(logData.d)) {
                    a.put("url", logData.d);
                }
                if (!TextUtils.isEmpty(logData.e)) {
                    a.put("platform", logData.e);
                }
                if (!TextUtils.isEmpty(logData.f)) {
                    a.put("destination", logData.f);
                }
                if (!TextUtils.isEmpty(logData.g)) {
                    a.put("from", logData.g);
                }
                if (!TextUtils.isEmpty(logData.h)) {
                    a.put("topic_category", logData.h);
                }
                if (!TextUtils.isEmpty(logData.i)) {
                    a.put("db_id", logData.i);
                }
                if (!TextUtils.isEmpty(logData.j)) {
                    a.put("document_id", logData.j);
                }
                if (!TextUtils.isEmpty(logData.k)) {
                    a.put("type", logData.k);
                }
                if (!TextUtils.isEmpty(logData.l)) {
                    a.put("position", logData.l);
                }
                if (!TextUtils.isEmpty(logData.m)) {
                    a.put(g.a.g, logData.m);
                }
                if (!TextUtils.isEmpty(logData.n)) {
                    a.put("id", logData.n);
                }
                if (!TextUtils.isEmpty(logData.o)) {
                    a.put(l.y, logData.o);
                }
                if (!TextUtils.isEmpty(logData.p)) {
                    a.put("to", logData.p);
                }
                if (!TextUtils.isEmpty(logData.q)) {
                    a.put("is_self", logData.q);
                }
                if (!TextUtils.isEmpty(logData.s)) {
                    a.put("pid", logData.s);
                }
                if (!TextUtils.isEmpty(logData.r)) {
                    a.put("item_id", logData.r);
                }
                if (!TextUtils.isEmpty(logData.t)) {
                    a.put("topic_id", logData.t);
                }
                if (!TextUtils.isEmpty(logData.u)) {
                    a.put("is_hello", logData.u);
                }
                if (!TextUtils.isEmpty(logData.v)) {
                    a.put("status", logData.v);
                }
                InstantLogBody instantLogBody = new InstantLogBody();
                instantLogBody.service = logData.D;
                InstantLog.d(instantLogBody, a);
            }
        });
    }

    public static void a(String str) {
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = str;
        c(instantLogBody, null);
    }

    public static void a(String str, int i) {
        a(str, i + "");
    }

    public static void a(String str, String str2) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("type", str2);
        a(str, a);
    }

    public static void a(String str, Map<String, String> map) {
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = str;
        c(instantLogBody, map);
    }

    public static void b(String str, int i) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("position", i + "");
        a(str, a);
    }

    public static void b(String str, String str2) {
        Map<String, String> a = BluedHttpTools.a();
        a.put("id", str2);
        a(str, a);
    }

    private static void c(final InstantLogBody instantLogBody, final Map<String, String> map) {
        ThreadManager.a().a((Runnable) new ThreadExecutor("PostLog", ThreadPriority.LOW) { // from class: com.blued.android.module.live_china.utils.log.InstantLog.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                InstantLog.d(instantLogBody, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(InstantLogBody instantLogBody, Map<String, String> map) {
        if (instantLogBody != null) {
            try {
                Map<String, String> a = BluedHttpTools.a();
                a.put("service", instantLogBody.service);
                if (!TextUtils.isEmpty(instantLogBody.from)) {
                    a.put("from", instantLogBody.from);
                }
                if (!TextUtils.isEmpty(instantLogBody.pn)) {
                    a.put("pn", instantLogBody.pn);
                }
                String json = AppInfo.f().toJson(map);
                if (!TextUtils.isEmpty(json)) {
                    a.put("event_info", json);
                }
                a.put(GeoFence.BUNDLE_KEY_FENCESTATUS, instantLogBody.event + "");
                String o = LiveRoomInfo.a().o();
                if (!TextUtils.isEmpty(o)) {
                    a.put("network", o);
                }
                if (TextUtils.isEmpty(instantLogBody.operator)) {
                    a.put("operator", LiveRoomInfo.a().p());
                } else {
                    a.put("operator", instantLogBody.operator);
                }
                HttpManager.b(LiveRoomInfo.a().k() + "/live/log", null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a)).f().h();
            } catch (Exception e) {
            }
        }
    }
}

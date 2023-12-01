package com.blued.android.module.live_china.utils.log;

import android.provider.BrowserContract;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.l;
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
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("whitening", String.valueOf(i));
        a2.put("pinky", String.valueOf(i2));
        a2.put("buffing", String.valueOf(i3));
        a("filters_type_score", a2);
    }

    public static void a(int i, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("from", i + "");
        a2.put("uid", str);
        a2.put("item_id", str2);
        if (!TextUtils.isEmpty(str3)) {
            a2.put("type", str3);
        }
        a2.put("status", str4);
        a2.put(l.d, str5);
        a("live_item_show", a2);
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
                Map<String, String> a2 = BluedHttpTools.a();
                if (!TextUtils.isEmpty(logData.f14209a)) {
                    a2.put(l.d, logData.f14209a);
                }
                if (!TextUtils.isEmpty(logData.b)) {
                    a2.put("target_uid", logData.b);
                }
                if (!TextUtils.isEmpty(logData.f14210c)) {
                    a2.put("uid", logData.f14210c);
                }
                if (!TextUtils.isEmpty(logData.d)) {
                    a2.put("url", logData.d);
                }
                if (!TextUtils.isEmpty(logData.e)) {
                    a2.put("platform", logData.e);
                }
                if (!TextUtils.isEmpty(logData.f)) {
                    a2.put("destination", logData.f);
                }
                if (!TextUtils.isEmpty(logData.g)) {
                    a2.put("from", logData.g);
                }
                if (!TextUtils.isEmpty(logData.h)) {
                    a2.put("topic_category", logData.h);
                }
                if (!TextUtils.isEmpty(logData.i)) {
                    a2.put("db_id", logData.i);
                }
                if (!TextUtils.isEmpty(logData.j)) {
                    a2.put("document_id", logData.j);
                }
                if (!TextUtils.isEmpty(logData.k)) {
                    a2.put("type", logData.k);
                }
                if (!TextUtils.isEmpty(logData.l)) {
                    a2.put(BrowserContract.Bookmarks.POSITION, logData.l);
                }
                if (!TextUtils.isEmpty(logData.m)) {
                    a2.put("time", logData.m);
                }
                if (!TextUtils.isEmpty(logData.n)) {
                    a2.put("id", logData.n);
                }
                if (!TextUtils.isEmpty(logData.o)) {
                    a2.put("content", logData.o);
                }
                if (!TextUtils.isEmpty(logData.p)) {
                    a2.put("to", logData.p);
                }
                if (!TextUtils.isEmpty(logData.q)) {
                    a2.put("is_self", logData.q);
                }
                if (!TextUtils.isEmpty(logData.s)) {
                    a2.put("pid", logData.s);
                }
                if (!TextUtils.isEmpty(logData.r)) {
                    a2.put("item_id", logData.r);
                }
                if (!TextUtils.isEmpty(logData.t)) {
                    a2.put("topic_id", logData.t);
                }
                if (!TextUtils.isEmpty(logData.u)) {
                    a2.put("is_hello", logData.u);
                }
                if (!TextUtils.isEmpty(logData.v)) {
                    a2.put("status", logData.v);
                }
                InstantLogBody instantLogBody = new InstantLogBody();
                instantLogBody.service = logData.D;
                InstantLog.d(instantLogBody, a2);
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
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("type", str2);
        a(str, a2);
    }

    public static void a(String str, Map<String, String> map) {
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = str;
        c(instantLogBody, map);
    }

    public static void b(String str, int i) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put(BrowserContract.Bookmarks.POSITION, i + "");
        a(str, a2);
    }

    public static void b(String str, String str2) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("id", str2);
        a(str, a2);
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
                Map<String, String> a2 = BluedHttpTools.a();
                a2.put("service", instantLogBody.service);
                if (!TextUtils.isEmpty(instantLogBody.from)) {
                    a2.put("from", instantLogBody.from);
                }
                if (!TextUtils.isEmpty(instantLogBody.pn)) {
                    a2.put("pn", instantLogBody.pn);
                }
                String json = AppInfo.f().toJson(map);
                if (!TextUtils.isEmpty(json)) {
                    a2.put("event_info", json);
                }
                a2.put("event", instantLogBody.event + "");
                String o = LiveRoomInfo.a().o();
                if (!TextUtils.isEmpty(o)) {
                    a2.put("network", o);
                }
                if (TextUtils.isEmpty(instantLogBody.operator)) {
                    a2.put("operator", LiveRoomInfo.a().p());
                } else {
                    a2.put("operator", instantLogBody.operator);
                }
                HttpManager.b(LiveRoomInfo.a().k() + "/live/log", null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).f().h();
            } catch (Exception e) {
            }
        }
    }
}

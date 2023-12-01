package com.soft.blued.log;

import android.provider.BrowserContract;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.log.oldtrack.InstantLogBody;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.soft.blued.utils.DeviceUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/InstantLog.class */
public class InstantLog {

    /* renamed from: a  reason: collision with root package name */
    public static long f15991a;

    public static int a(long j, long j2) {
        return (int) ((j2 - j) / 1000);
    }

    public static void a() {
        f15991a = System.currentTimeMillis();
    }

    public static void a(int i) {
        long j = f15991a;
        if (j != 0) {
            int a2 = a(j, System.currentTimeMillis());
            Map a3 = BluedHttpTools.a();
            a3.put("time", a2 + "");
            a3.put("from", i + "");
            a("shine_video_stay_time", (Map<String, String>) a3);
            f15991a = 0L;
        }
    }

    public static void a(int i, double d) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", i + "");
        a2.put(l.d, d + "");
        a("vip_buy_page_item_click", (Map<String, String>) a2);
    }

    public static void a(int i, int i2) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", i + "");
        a2.put("from", i2 + "");
        a("shine_video_list_request", (Map<String, String>) a2);
    }

    public static void a(int i, int i2, String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", i + "");
        a2.put("to", i2 + "");
        if (!TextUtils.isEmpty(str)) {
            a2.put("url", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("id", str2);
        }
        a("share_click", (Map<String, String>) a2);
    }

    public static void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        if (bluedIngSelfFeed != null) {
            Map a2 = BluedHttpTools.a();
            a2.put("from", i + "");
            a2.put("id", bluedIngSelfFeed.feed_id);
            a2.put("type", bluedIngSelfFeed.recommend_text);
            a2.put("is_super_topic", bluedIngSelfFeed.is_super_topics + "");
            if (!TextUtils.isEmpty(str)) {
                a2.put("topic_id", str);
            }
            if (i2 != -1) {
                a2.put("topic_category", i2 + "");
            }
            a("like_btn_click", (Map<String, String>) a2);
        }
    }

    public static void a(int i, String str) {
        Map a2 = BluedHttpTools.a();
        a2.put(BrowserContract.Bookmarks.POSITION, i + "");
        a2.put("url", str);
        a("game_status", (Map<String, String>) a2);
    }

    public static void a(int i, String str, int i2) {
        Map a2 = BluedHttpTools.a();
        a2.put("from", i + "");
        a2.put("url", str);
        a2.put("is_self", i2 + "");
        a("vip_icon_click", (Map<String, String>) a2);
    }

    public static void a(int i, String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", i + "");
        a2.put("url", str);
        a("msg_click", (Map<String, String>) a2);
    }

    public static void a(int i, String str, String str2, String str3) {
        Map a2 = BluedHttpTools.a();
        a2.put("from", i + "");
        a2.put("id", str);
        a2.put("type", str2);
        a2.put("target_uid", str3);
        a("feed_show", (Map<String, String>) a2);
    }

    public static void a(int i, String str, String str2, String str3, String str4, String str5) {
        Map a2 = BluedHttpTools.a();
        a2.put("from", i + "");
        a2.put("uid", str);
        a2.put("item_id", str2);
        if (!TextUtils.isEmpty(str3)) {
            a2.put("type", str3);
        }
        a2.put("status", str4);
        a2.put(l.d, str5);
        a("live_item_show", (Map<String, String>) a2);
    }

    public static void a(InstantLogBody instantLogBody, Map<String, String> map) {
        b(instantLogBody, map, "/users/upload/netlog");
    }

    public static void a(final LogData logData) {
        ThreadManager.a().a(new ThreadExecutor("postLogData", ThreadPriority.a) { // from class: com.soft.blued.log.InstantLog.3
            public void execute() {
                LogData logData2 = logData;
                if (logData2 == null || TextUtils.isEmpty(logData2.logService)) {
                    return;
                }
                Map a2 = BluedHttpTools.a();
                if (!TextUtils.isEmpty(logData.num)) {
                    a2.put(l.d, logData.num);
                }
                if (!TextUtils.isEmpty(logData.target_uid)) {
                    a2.put("target_uid", logData.target_uid);
                }
                if (!TextUtils.isEmpty(logData.uid)) {
                    a2.put("uid", logData.uid);
                }
                if (!TextUtils.isEmpty(logData.url)) {
                    a2.put("url", logData.url);
                }
                if (!TextUtils.isEmpty(logData.platform)) {
                    a2.put("platform", logData.platform);
                }
                if (!TextUtils.isEmpty(logData.destination)) {
                    a2.put("destination", logData.destination);
                }
                if (!TextUtils.isEmpty(logData.from)) {
                    a2.put("from", logData.from);
                }
                if (!TextUtils.isEmpty(logData.topic_category)) {
                    a2.put("topic_category", logData.topic_category);
                }
                if (!TextUtils.isEmpty(logData.db_id)) {
                    a2.put("db_id", logData.db_id);
                }
                if (!TextUtils.isEmpty(logData.document_id)) {
                    a2.put("document_id", logData.document_id);
                }
                if (!TextUtils.isEmpty(logData.type)) {
                    a2.put("type", logData.type);
                }
                if (!TextUtils.isEmpty(logData.position)) {
                    a2.put(BrowserContract.Bookmarks.POSITION, logData.position);
                }
                if (!TextUtils.isEmpty(logData.time)) {
                    a2.put("time", logData.time);
                }
                if (!TextUtils.isEmpty(logData.id)) {
                    a2.put("id", logData.id);
                }
                if (!TextUtils.isEmpty(logData.content)) {
                    a2.put("content", logData.content);
                }
                if (!TextUtils.isEmpty(logData.to)) {
                    a2.put("to", logData.to);
                }
                if (!TextUtils.isEmpty(logData.is_self)) {
                    a2.put("is_self", logData.is_self);
                }
                if (!TextUtils.isEmpty(logData.pid)) {
                    a2.put("pid", logData.pid);
                }
                if (!TextUtils.isEmpty(logData.item_id)) {
                    a2.put("item_id", logData.item_id);
                }
                if (!TextUtils.isEmpty(logData.topic_id)) {
                    a2.put("topic_id", logData.topic_id);
                }
                if (!TextUtils.isEmpty(logData.is_hello)) {
                    a2.put("is_hello", logData.is_hello);
                }
                if (!TextUtils.isEmpty(logData.status)) {
                    a2.put("status", logData.status);
                }
                InstantLogBody instantLogBody = new InstantLogBody();
                instantLogBody.service = logData.logService;
                InstantLog.d(instantLogBody, a2);
            }
        });
    }

    public static void a(String str) {
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = str;
        c(instantLogBody, (Map<String, String>) null);
    }

    public static void a(String str, int i) {
        g(str, i + "");
    }

    public static void a(String str, Object obj) {
        Map a2 = BluedHttpTools.a();
        a2.put("from", String.valueOf(obj));
        a(str, (Map<String, String>) a2);
    }

    public static void a(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("url", str2);
        a(str, (Map<String, String>) a2);
    }

    public static void a(String str, String str2, int i, String str3) {
        Map a2 = BluedHttpTools.a();
        a2.put("from", "4");
        a2.put("id", str);
        a2.put("topic_id", str2);
        a2.put("target_uid", str3);
        if (i == 1) {
            a2.put("topic_category", "0");
        } else {
            a2.put("topic_category", "1");
        }
        a("feed_show", (Map<String, String>) a2);
    }

    public static void a(String str, Map<String, String> map) {
        InstantLogBody instantLogBody = new InstantLogBody();
        instantLogBody.service = str;
        c(instantLogBody, map);
    }

    public static boolean a(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String str4 = str2;
        if (str2.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            str4 = str2.substring(1);
        }
        String str5 = str3;
        if (str3.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            str5 = str3.substring(1);
        }
        int i2 = i == 1 ? 5 : 20;
        if (!str4.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) || str4.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER).length < i2) {
            return false;
        }
        Map a2 = BluedHttpTools.a();
        a2.put("from", str);
        a2.put("id", str4);
        a2.put("type", i + "");
        a2.put("is_hello", str5);
        a("people_show", (Map<String, String>) a2);
        return true;
    }

    public static void b(int i, int i2, String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", i + "");
        a2.put("to", i2 + "");
        if (!TextUtils.isEmpty(str)) {
            a2.put("url", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("id", str2);
        }
        a("share_success", (Map<String, String>) a2);
    }

    public static void b(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        if (bluedIngSelfFeed != null) {
            Map a2 = BluedHttpTools.a();
            a2.put("from", i + "");
            a2.put("id", bluedIngSelfFeed.feed_id);
            a2.put("type", bluedIngSelfFeed.recommend_text);
            a2.put("is_super_topic", bluedIngSelfFeed.is_super_topics + "");
            if (!TextUtils.isEmpty(str)) {
                a2.put("topic_id", str);
            }
            if (i2 != -1) {
                a2.put("topic_category", i2 + "");
            }
            a("comment_btn_click", (Map<String, String>) a2);
        }
    }

    public static void b(int i, String str) {
        Map a2 = BluedHttpTools.a();
        a2.put("from", i + "");
        a2.put("target_uid", str);
        a("shine_video_attention_click", (Map<String, String>) a2);
    }

    private static void b(final InstantLogBody instantLogBody, final Map<String, String> map, final String str) {
        ThreadManager.a().a(new ThreadExecutor("PostLog", ThreadPriority.a) { // from class: com.soft.blued.log.InstantLog.2
            public void execute() {
                InstantLog.c(instantLogBody, map, str);
            }
        });
    }

    public static void b(String str, int i) {
        Map a2 = BluedHttpTools.a();
        a2.put(BrowserContract.Bookmarks.POSITION, i + "");
        a(str, (Map<String, String>) a2);
    }

    public static void b(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("target_uid", str2);
        a(str, (Map<String, String>) a2);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = str;
        if (str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            str2 = str.substring(1);
        }
        if (!str2.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) || str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER).length < 20) {
            return false;
        }
        Map a2 = BluedHttpTools.a();
        a2.put("uid", str2);
        a2.put(BrowserContract.Bookmarks.POSITION, "1");
        a("msg_rec_chat_show", (Map<String, String>) a2);
        return true;
    }

    public static void c(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        if (bluedIngSelfFeed != null) {
            Map a2 = BluedHttpTools.a();
            a2.put("from", i + "");
            a2.put("id", bluedIngSelfFeed.feed_id);
            a2.put("type", bluedIngSelfFeed.recommend_text);
            if (!TextUtils.isEmpty(str)) {
                a2.put("topic_id", str);
            }
            if (i2 != -1) {
                a2.put("topic_category", i2 + "");
            }
            a("feed_share_btn_click", (Map<String, String>) a2);
        }
    }

    private static void c(final InstantLogBody instantLogBody, final Map<String, String> map) {
        ThreadManager.a().a(new ThreadExecutor("PostLog", ThreadPriority.a) { // from class: com.soft.blued.log.InstantLog.1
            public void execute() {
                InstantLog.c(instantLogBody, map, "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(InstantLogBody instantLogBody, Map<String, String> map, String str) {
        if (instantLogBody != null) {
            try {
                Map a2 = BluedHttpTools.a();
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
                String d = NetworkUtils.d();
                if (!TextUtils.isEmpty(d)) {
                    a2.put("network", d);
                }
                if (TextUtils.isEmpty(instantLogBody.operator)) {
                    a2.put("operator", DeviceUtils.d());
                } else {
                    a2.put("operator", instantLogBody.operator);
                }
                String str2 = BluedHttpUrl.q() + "/live/log";
                if (!TextUtils.isEmpty(str)) {
                    str2 = BluedHttpUrl.q() + str;
                }
                if (AppInfo.m() && instantLogBody != null) {
                    Logger.c("InstantLog", new Object[]{"postlog Service:", instantLogBody.service, ";>Event info:", json});
                }
                HttpManager.b(str2, (HttpResponseHandler) null).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).f().h();
            } catch (Exception e) {
            }
        }
    }

    public static void c(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("uid", str2);
        a(str, (Map<String, String>) a2);
    }

    public static void d(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
        if (bluedIngSelfFeed != null) {
            Map a2 = BluedHttpTools.a();
            a2.put("from", i + "");
            a2.put("id", bluedIngSelfFeed.feed_id);
            a2.put("type", bluedIngSelfFeed.recommend_text);
            a2.put("is_super_topic", bluedIngSelfFeed.is_super_topics + "");
            if (!TextUtils.isEmpty(str)) {
                a2.put("topic_id", str);
            }
            if (i2 != -1) {
                a2.put("topic_category", i2 + "");
            }
            a("repost_btn_click", (Map<String, String>) a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(InstantLogBody instantLogBody, Map<String, String> map) {
        c(instantLogBody, map, "");
    }

    public static void d(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("destination", str2);
        a(str, (Map<String, String>) a2);
    }

    public static void e(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("platform", str);
        a2.put("from", str2);
        a("share_feed_success", (Map<String, String>) a2);
    }

    public static void f(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("document_id", str2);
        a(str, (Map<String, String>) a2);
    }

    public static void g(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("type", str2);
        a(str, (Map<String, String>) a2);
    }

    public static void h(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("id", str2);
        a(str, (Map<String, String>) a2);
    }

    public static void i(String str, String str2) {
        Map a2 = BluedHttpTools.a();
        a2.put("content", str2);
        a(str, (Map<String, String>) a2);
    }
}

package com.blued.android.module.live_china.manager;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveUploadTimerModel;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveUploadTimerManager.class */
public class LiveUploadTimerManager {
    private static LiveUploadTimerManager c;
    private Timer a;
    private String b;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveUploadTimerManager$UPLOAD_TYPE.class */
    public interface UPLOAD_TYPE {
        public static final String APP_TO_HOME = "4";
        public static final String HOME_TO_APP = "5";
        public static final String JOIN_LIVE = "2";
        public static final String LEAVE_LIVE = "3";
        public static final String PER_MINUTE = "1";
    }

    public static LiveUploadTimerManager a() {
        if (c == null) {
            c = new LiveUploadTimerManager();
        }
        return c;
    }

    private static void a(StringHttpResponseHandler stringHttpResponseHandler, String str, String str2) {
        Map<String, Object> b = BluedHttpTools.b();
        b.put("lid", str);
        b.put("type", str2);
        HttpManager.b(LiveRoomInfo.a().k() + "/live/time/report", stringHttpResponseHandler).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(b)).h();
    }

    public static void a(String str) {
        if (c != null) {
            return;
        }
        a();
        c.b = str;
        c("2");
        f();
    }

    public static void b() {
        if (c == null) {
            return;
        }
        c("3");
        g();
        c = null;
    }

    public static void c() {
        c("4");
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        synchronized (LiveUploadTimerManager.class) {
            try {
                if (c != null && !TextUtils.isEmpty(c.b)) {
                    if (System.currentTimeMillis() - LivePreferencesUtils.b() < 86400000) {
                        return;
                    }
                    try {
                        a(new BluedUIHttpResponse<BluedEntityA<LiveUploadTimerModel>>() { // from class: com.blued.android.module.live_china.manager.LiveUploadTimerManager.2
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.blued.android.framework.http.BluedUIHttpResponse
                            /* renamed from: a */
                            public void onUIUpdate(BluedEntityA<LiveUploadTimerModel> bluedEntityA) {
                                if (bluedEntityA.getSingleData() == null || LiveUploadTimerManager.c == null || bluedEntityA.getSingleData().is_done != 1) {
                                    return;
                                }
                                LivePreferencesUtils.a(((System.currentTimeMillis() / 86400000) * 86400000) - TimeZone.getDefault().getRawOffset());
                            }

                            @Override // com.blued.android.framework.http.BluedUIHttpResponse
                            public boolean onUIFailure(int i, String str2) {
                                return true;
                            }
                        }, c.b, str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void d() {
        c("5");
        f();
    }

    private static void f() {
        if (c == null) {
            return;
        }
        g();
        c.a = new Timer();
        c.a.schedule(new TimerTask() { // from class: com.blued.android.module.live_china.manager.LiveUploadTimerManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LiveUploadTimerManager.c("1");
            }
        }, 60000L, 60000L);
    }

    private static void g() {
        Timer timer;
        LiveUploadTimerManager liveUploadTimerManager = c;
        if (liveUploadTimerManager == null || (timer = liveUploadTimerManager.a) == null) {
            return;
        }
        timer.cancel();
        c.a = null;
    }
}

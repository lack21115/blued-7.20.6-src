package com.youzan.spiderman.cache;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.util.WebViewJsUtil;
import com.google.gson.JsonParseException;
import com.youzan.spiderman.utils.JsonUtil;
import com.youzan.spiderman.utils.Timing;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheStatistic.class */
public class CacheStatistic {

    /* renamed from: a  reason: collision with root package name */
    private int f28095a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28096c;
    private int d;
    private Timing e;
    private boolean f;
    private String g;
    private volatile long k;
    private StatisticCallback l;
    private volatile boolean m;
    private final Object n = new Object();
    private Timer h = new Timer();
    private TimerTask i = null;
    private volatile boolean j = false;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheStatistic$InjectJsCallback.class */
    public interface InjectJsCallback {
        void onInject(String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheStatistic$StatisticCallback.class */
    public interface StatisticCallback {
        void onStatistic(String str, Map<String, String> map);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/CacheStatistic$a.class */
    final class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (CacheStatistic.this.l != null) {
                if (System.currentTimeMillis() - CacheStatistic.this.k >= 2000 || CacheStatistic.this.j) {
                    if (!CacheStatistic.this.m) {
                        CacheStatistic.a(CacheStatistic.this, true);
                        CacheStatistic.this.l.onStatistic(CacheStatistic.this.g, CacheStatistic.this.getStatisticData());
                    }
                    cancel();
                    synchronized (CacheStatistic.this.n) {
                        CacheStatistic.a(CacheStatistic.this, (TimerTask) null);
                    }
                }
            }
        }
    }

    public CacheStatistic(StatisticCallback statisticCallback) {
        this.l = statisticCallback;
        reset();
    }

    static /* synthetic */ TimerTask a(CacheStatistic cacheStatistic, TimerTask timerTask) {
        cacheStatistic.i = null;
        return null;
    }

    static /* synthetic */ boolean a(CacheStatistic cacheStatistic, boolean z) {
        cacheStatistic.m = true;
        return true;
    }

    public static boolean isStatisticUrl(Uri uri) {
        return uri.getScheme().equals("spiderman");
    }

    public static boolean isStatisticUrl(String str) {
        if (TextUtils.isEmpty(str) || !str.trim().startsWith("spiderman")) {
            return false;
        }
        return isStatisticUrl(Uri.parse(str));
    }

    public void addStatisticCount(int i, boolean z) {
        if (z) {
            this.f28096c += i;
            if (this.f) {
                return;
            }
            this.f28095a += i;
            return;
        }
        this.d += i;
        if (this.f) {
            return;
        }
        this.b += i;
    }

    public void destory() {
        synchronized (this.n) {
            if (this.i != null) {
                this.j = true;
                try {
                    this.i.run();
                } catch (Exception e) {
                }
                this.i = null;
            }
        }
        this.h.cancel();
    }

    public Map<String, String> getStatisticData() {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.g);
        int i = this.f28095a;
        int i2 = this.b + i;
        if (i2 != 0) {
            hashMap.put("load_hit_rate", String.format(Locale.ENGLISH, "%.2f", Double.valueOf(i / i2)));
            hashMap.put("load_hit_count", String.valueOf(this.f28095a));
            hashMap.put("load_miss_count", String.valueOf(this.b));
        }
        int i3 = this.f28096c;
        int i4 = this.d + i3;
        if (i4 != 0) {
            hashMap.put("hit_rate", String.format(Locale.ENGLISH, "%.2f", Double.valueOf(i3 / i4)));
            hashMap.put("hit_count", String.valueOf(this.f28096c));
            hashMap.put("miss_count", String.valueOf(this.d));
        }
        Timing timing = this.e;
        if (timing != null) {
            long j = timing.responseStart;
            long j2 = this.e.navigationStart;
            long j3 = this.e.loadEventStart;
            long j4 = this.e.navigationStart;
            hashMap.put("white_time", String.valueOf(j - j2));
            hashMap.put("load_time", String.valueOf(j3 - j4));
        }
        return hashMap;
    }

    public void parseStatisticTiming(Uri uri) {
        this.f = true;
        try {
            this.e = (Timing) JsonUtil.fromJson(uri.getQueryParameter("timing"), (Class<Object>) Timing.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        }
    }

    public void parseStatisticTiming(String str) {
        parseStatisticTiming(Uri.parse(str));
    }

    public void reset() {
        synchronized (this.n) {
            if (this.i != null) {
                this.j = true;
                try {
                    this.i.run();
                } catch (Exception e) {
                }
                this.i = null;
            }
            this.j = false;
            this.f28095a = 0;
            this.b = 0;
            this.d = 0;
            this.f28096c = 0;
            this.e = null;
            this.g = null;
            this.f = false;
            this.k = 0L;
            this.m = false;
        }
    }

    public void resetStatisticTimer() {
        synchronized (this.n) {
            if (this.f && !this.m) {
                if (this.i == null) {
                    this.h = new Timer();
                    a aVar = new a();
                    this.i = aVar;
                    try {
                        this.h.schedule(aVar, 2000L, 2000L);
                    } catch (Exception e) {
                    }
                } else {
                    this.k = System.currentTimeMillis();
                }
            }
        }
    }

    public void tryInjectJs(String str, InjectJsCallback injectJsCallback) {
        if (injectJsCallback != null) {
            this.g = str;
            injectJsCallback.onInject(WebViewJsUtil.JS_URL_PREFIX);
        }
    }
}

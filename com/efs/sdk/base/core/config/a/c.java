package com.efs.sdk.base.core.config.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.anythink.expressad.video.module.a.a.m;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.c.f;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/a/c.class */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f8145a = new Random();
    public IConfigRefreshAction b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8146c;
    public b d;
    public Map<IConfigCallback, String[]> e;
    private Handler f;
    private e g;
    private long h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/a/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f8148a = new c((byte) 0);
    }

    private c() {
        this.f8146c = true;
        this.e = new HashMap();
        this.f = new Handler(com.efs.sdk.base.core.util.concurrent.a.f8189a.getLooper(), this);
        this.g = new e();
        this.d = b.a();
        this.h = ControllerCenter.getGlobalEnvStruct().configRefreshDelayMills;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c a() {
        return a.f8148a;
    }

    private boolean a(b bVar) {
        if (this.d.f8143a >= bVar.f8143a) {
            return true;
        }
        Log.i("efs.config", "current config version (" + this.d.f8143a + ") is older than another (" + bVar.f8143a + ")");
        return false;
    }

    private void e() {
        f fVar;
        fVar = f.a.f8138a;
        if (!fVar.a()) {
            Log.i("efs.config", "has no permission to refresh config from remote");
        } else if (!this.f8146c) {
            Log.i("efs.config", "disable refresh config from remote");
        } else {
            String refresh = g().refresh();
            Log.i("efs.config", "from server. efs config is ".concat(String.valueOf(refresh)));
            if (TextUtils.isEmpty(refresh)) {
                return;
            }
            a(refresh);
        }
    }

    private void f() {
        boolean z;
        try {
            z = this.g.a(this.d);
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            return;
        }
        this.f.sendEmptyMessageDelayed(3, m.ag);
    }

    private IConfigRefreshAction g() {
        IConfigRefreshAction iConfigRefreshAction = this.b;
        com.efs.sdk.base.core.config.a.a aVar = iConfigRefreshAction;
        if (iConfigRefreshAction == null) {
            aVar = com.efs.sdk.base.core.config.a.a.a();
        }
        return aVar;
    }

    private boolean h() {
        e.b();
        long j = 0;
        try {
            e eVar = this.g;
            eVar.c();
            if (eVar.f8150a != null) {
                j = eVar.f8150a.getLong("last_refresh_time", 0L);
            }
        } catch (Throwable th) {
        }
        return System.currentTimeMillis() - j >= (this.d.d * 60) * 1000;
    }

    private void i() {
        try {
            for (ValueCallback<Pair<Message, Message>> valueCallback : ControllerCenter.getGlobalEnvStruct().getCallback(1)) {
                Message obtain = Message.obtain(null, 1, new JSONObject(this.d.f).toString());
                Message obtain2 = Message.obtain();
                valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
                obtain.recycle();
                obtain2.recycle();
            }
            for (IEfsReporterObserver iEfsReporterObserver : ControllerCenter.getGlobalEnvStruct().getEfsReporterObservers()) {
                iEfsReporterObserver.onConfigChange();
            }
        } catch (Throwable th) {
            Log.e("efs.config", th);
        }
    }

    public final String a(boolean z) {
        if (z) {
            return "https://" + this.d.f8144c;
        }
        return this.d.b + this.d.f8144c;
    }

    public final void a(int i) {
        if (i <= this.d.f8143a) {
            Log.i("efs.config", "current config version is " + i + ", no need to refresh");
            return;
        }
        Message obtain = Message.obtain();
        obtain.arg1 = i;
        obtain.what = 1;
        this.f.sendMessage(obtain);
    }

    public final void a(String str) {
        b a2 = b.a();
        if (!d.a(str, a2)) {
            this.f.sendEmptyMessageDelayed(1, m.ag);
        } else if (a(a2)) {
        } else {
            this.d = a2;
            f();
            i();
            d();
        }
    }

    public final void b() {
        this.f.sendEmptyMessage(0);
        this.f.sendEmptyMessageDelayed(2, this.h);
    }

    public final Map<String, String> c() {
        return new HashMap(this.d.f);
    }

    public final void d() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.efs.sdk.base.core.config.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    for (IConfigCallback iConfigCallback : c.this.e.keySet()) {
                        String[] strArr = (String[]) c.this.e.get(iConfigCallback);
                        HashMap hashMap = new HashMap();
                        if (strArr != null && strArr.length != 0) {
                            int length = strArr.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < length) {
                                    String str = strArr[i2];
                                    if (c.this.d.f.containsKey(str)) {
                                        hashMap.put(str, c.this.c().get(str));
                                        Log.i("efs.config", "--->>> configCallback key is " + str + " ## value is " + c.this.c().get(str));
                                    }
                                    i = i2 + 1;
                                }
                            }
                        }
                        iConfigCallback.onChange(hashMap);
                    }
                    c.this.e.clear();
                } catch (Throwable th) {
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        b a2;
        f fVar;
        int i = message.what;
        if (i != 0) {
            if (i == 1) {
                int i2 = message.arg1;
                if (i2 > this.d.f8143a) {
                    e();
                    return true;
                }
                Log.i("efs.config", "current config version is " + i2 + ", no need to refresh");
                Log.i("efs.config", "current config version(" + this.d.f8143a + ") is " + i2 + ", no need to refresh");
                return true;
            } else if (i != 2) {
                if (i != 3) {
                    return true;
                }
                f();
                return true;
            } else {
                try {
                    fVar = f.a.f8138a;
                    if (fVar.a()) {
                        if (h()) {
                            e();
                            return true;
                        }
                        Log.i("efs.config", "No update is required, less than 8h since the last update");
                        return true;
                    }
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return true;
                }
            }
        }
        boolean a3 = e.a();
        Log.i("efs.config", "delete old config is ".concat(String.valueOf(a3)));
        if (a3) {
            this.f.sendEmptyMessage(1);
            return true;
        }
        e eVar = this.g;
        eVar.c();
        if (eVar.f8150a == null) {
            a2 = null;
        } else {
            a2 = b.a();
            a2.f8143a = eVar.f8150a.getInt("cver", -1);
            Set<String> keySet = eVar.f8150a.getAll().keySet();
            HashMap hashMap = new HashMap();
            for (String str : keySet) {
                String string = eVar.f8150a.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            a2.a(hashMap);
        }
        if (a2 == null) {
            Log.i("efs.config", "first load local config false.");
            return true;
        } else if (a(a2)) {
            Log.i("efs.config", "current config to same.");
            return true;
        } else {
            this.d = a2;
            String str2 = "load config from storage";
            if (-1 != a2.f8143a) {
                i();
                d();
                str2 = "load config from storage and notify observer";
            }
            Log.i("efs.config", str2);
            return true;
        }
    }
}

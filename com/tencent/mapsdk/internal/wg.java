package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wg.class */
public class wg {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24404c = "https://confinfo.map.qq.com/confinfo?";

    /* renamed from: a  reason: collision with root package name */
    private Context f24405a;
    private WeakReference<b> b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wg$b.class */
    public interface b {
        void a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wg$c.class */
    public class c extends AsyncTask<Context, Void, Void> {
        private c() {
        }

        /* JADX WARN: Finally extract failed */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Context... contextArr) {
            InputStream inputStream;
            int i;
            byte[] b;
            int a2 = tg.a();
            StringBuilder sb = new StringBuilder();
            sb.append(wg.f24404c);
            sb.append("apiKey=");
            boolean z = false;
            if (contextArr != null && contextArr.length > 0) {
                sb.append(wg.this.a(contextArr[0].getApplicationContext()));
            }
            NetResponse doStream = NetManager.getInstance().builder().url(sb.toString()).timeOut(3000).doStream();
            try {
                inputStream = doStream.dataStream;
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                b = ha.b(inputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (inputStream != null) {
                        ha.a((Closeable) inputStream);
                    }
                    if (doStream != null) {
                        ha.a((Closeable) doStream.dataStream);
                    }
                    boolean z2 = false;
                    if (a2 != tg.a()) {
                        z2 = true;
                    }
                    if (!z2 || wg.this.f24405a == null) {
                        return null;
                    }
                    i = a2;
                    tg.a(wg.this.f24405a, i);
                    ((b) wg.this.b.get()).a();
                    return null;
                } catch (Throwable th3) {
                    if (inputStream != null) {
                        ha.a((Closeable) inputStream);
                    }
                    if (doStream != null) {
                        ha.a((Closeable) doStream.dataStream);
                    }
                    boolean z3 = false;
                    if (a2 != tg.a()) {
                        z3 = true;
                    }
                    if (z3 && wg.this.f24405a != null) {
                        tg.a(wg.this.f24405a, a2);
                        ((b) wg.this.b.get()).a();
                    }
                    throw th3;
                }
            }
            if (b != null && b.length != 0) {
                int a3 = wg.this.a(new String(b), a2);
                if (inputStream != null) {
                    ha.a((Closeable) inputStream);
                }
                ha.a((Closeable) doStream.dataStream);
                if (a3 != tg.a()) {
                    z = true;
                }
                if (!z || wg.this.f24405a == null) {
                    return null;
                }
                i = a3;
                tg.a(wg.this.f24405a, i);
                ((b) wg.this.b.get()).a();
                return null;
            }
            if (inputStream != null) {
                ha.a((Closeable) inputStream);
            }
            ha.a((Closeable) doStream.dataStream);
            boolean z4 = false;
            if (a2 != tg.a()) {
                z4 = true;
            }
            if (!z4 || wg.this.f24405a == null) {
                return null;
            }
            tg.a(wg.this.f24405a, a2);
            ((b) wg.this.b.get()).a();
            return null;
        }
    }

    public wg(Context context, b bVar) {
        this.f24405a = context;
        this.b = new WeakReference<>(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int i2 = i;
        if (jSONObject.optInt("error", -1) == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            i2 = i;
            if (optJSONObject != null) {
                i2 = optJSONObject.optInt("scenic", i);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return "";
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString("TencentMapSDK");
    }

    public void a() {
        new c().execute(this.f24405a);
    }
}

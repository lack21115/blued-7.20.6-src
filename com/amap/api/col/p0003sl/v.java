package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.android.internal.widget.LockPatternUtils;
import com.anythink.core.common.c.d;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.v  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/v.class */
public final class v {
    private Context a;
    private WeakReference<IAMapDelegate> b;
    private HandlerThread c;
    private Handler d;
    private a e;
    private final Runnable f = new Runnable() { // from class: com.amap.api.col.3sl.v.1
        @Override // java.lang.Runnable
        public final void run() {
            if (v.this.e == null) {
                v vVar = v.this;
                vVar.e = new a(vVar.a, v.this);
            }
            du.a().a(v.this.e);
        }
    };
    private final Runnable g = new Runnable() { // from class: com.amap.api.col.3sl.v.2
        @Override // java.lang.Runnable
        public final void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) v.this.b.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            dc.a(v.this.a, "地形图鉴权失败，当前key没有地形图的使用权限，地形图，将不会呈现！");
        }
    };

    /* renamed from: com.amap.api.col.3sl.v$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/v$a.class */
    static final class a extends lc {
        private Context a;
        private v b;
        private b c;

        public a(Context context, v vVar) {
            this.a = context;
            this.b = vVar;
            this.c = new b(context, "");
        }

        @Override // com.amap.api.col.p0003sl.lc
        public final void runTask() {
            try {
                c d = this.c.d();
                if (d == null) {
                    this.b.a(LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS);
                } else if (d.d) {
                } else {
                    this.b.c();
                }
            } catch (hf e) {
                e.printStackTrace();
                this.b.a(LockPatternUtils.FAILED_ATTEMPT_TIMEOUT_MS);
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.v$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/v$b.class */
    static final class b extends hg<String, c> {
        private boolean j;

        public b(Context context, String str) {
            super(context, str);
            this.j = true;
            this.h = "/rest/feedback/terrain";
            this.isPostFlag = false;
            this.j = true;
        }

        private static c a(String str) throws hf {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("infocode");
                String optString3 = jSONObject.optString("status");
                c cVar = new c((byte) 0);
                cVar.a = optString;
                cVar.b = optString2;
                cVar.c = optString3;
                boolean z = false;
                if (!TextUtils.isEmpty(optString2)) {
                    z = false;
                    if (TextUtils.equals(optString2, "10000")) {
                        z = true;
                    }
                }
                cVar.d = z;
                return cVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        private static c b(byte[] bArr) throws hf {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return a(str);
        }

        @Override // com.amap.api.col.p0003sl.hg
        protected final /* synthetic */ c a(byte[] bArr) throws hf {
            return b(bArr);
        }

        @Override // com.amap.api.col.p0003sl.hg
        protected final String c() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.hg
        protected final /* synthetic */ c d(String str) throws hf {
            return a(str);
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getIPV6URL() {
            return dw.a(getURL());
        }

        @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
        public final Map<String, String> getParams() {
            Hashtable hashtable = new Hashtable(16);
            hashtable.put(d.a.b, ho.f(this.g));
            if (this.j) {
                hashtable.put("pname", "3dmap");
            }
            String a = hr.a();
            String a2 = hr.a(this.g, a, ib.b(hashtable));
            hashtable.put("ts", a);
            hashtable.put("scode", a2);
            return hashtable;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            return "http://restsdk.amap.com" + this.h;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final boolean isSupportIPV6() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.v$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/v$c.class */
    public static final class c {
        public String a;
        public String b;
        public String c;
        public boolean d;

        private c() {
            this.d = false;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public v(Context context, IAMapDelegate iAMapDelegate) {
        this.a = context.getApplicationContext();
        this.b = new WeakReference<>(iAMapDelegate);
        b();
    }

    private void b() {
        if (this.c == null) {
            HandlerThread handlerThread = new HandlerThread("terrain_auth");
            this.c = handlerThread;
            handlerThread.start();
            this.d = new Handler(this.c.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Handler handler = this.d;
        if (handler != null) {
            handler.postDelayed(this.g, 1000L);
        }
    }

    public final void a() {
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.c = null;
        }
    }

    public final void a(long j) {
        Handler handler = this.d;
        if (handler != null) {
            handler.postDelayed(this.f, j);
        }
    }
}

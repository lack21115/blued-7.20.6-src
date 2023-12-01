package com.tencent.liteav.txcvodplayer.b;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.rtmp.TXPlayInfoParams;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    TXPlayInfoParams f22829a;
    public com.tencent.liteav.txcvodplayer.b.b b;

    /* renamed from: c  reason: collision with root package name */
    public f f22830c;
    public String d;
    public String e;
    private final String f = "https://playvideo.qcloud.com/getplayinfo/v4";
    private Handler g = ThreadUtils.getUiThreadHandler();
    private String h;

    /* renamed from: com.tencent.liteav.txcvodplayer.b.c$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/c$1.class */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22831a;

        AnonymousClass1(a aVar) {
            this.f22831a = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x018d  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x025e  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x026f  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 718
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.b.c.AnonymousClass1.run():void");
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/c$a.class */
    public interface a {
        void a(int i, String str);

        void a(c cVar, TXPlayInfoParams tXPlayInfoParams);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/c$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f22838a;
        public String b;
    }

    /* renamed from: com.tencent.liteav.txcvodplayer.b.c$c  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/c$c.class */
    public static final class C0764c {

        /* renamed from: a  reason: collision with root package name */
        public String f22839a;
        public float b;

        public final String toString() {
            return "TCPlayKeyFrameDescInfo{content='" + this.f22839a + "', time=" + this.b + '}';
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/c$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f22840a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f22841c;
        public String d;
    }

    public c(TXPlayInfoParams tXPlayInfoParams) {
        this.f22829a = tXPlayInfoParams;
    }

    public final String a() {
        com.tencent.liteav.txcvodplayer.b.b bVar = this.b;
        if (bVar != null) {
            return bVar.a("SimpleAES");
        }
        f fVar = this.f22830c;
        if (fVar != null) {
            return fVar.a();
        }
        return null;
    }

    public final void a(a aVar) {
        if (this.f22829a == null) {
            return;
        }
        com.tencent.liteav.txcplayer.a.a.a().execute(new AnonymousClass1(aVar));
    }

    final void a(Runnable runnable) {
        if (ThreadUtils.runningOnUiThread()) {
            runnable.run();
        } else {
            this.g.post(runnable);
        }
    }

    final boolean a(String str, final a aVar) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e("TXCPlayInfoProtocolV4", "parseJson err, content is empty!");
            a(new Runnable() { // from class: com.tencent.liteav.txcvodplayer.b.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(-1, "request return error!");
                }
            });
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final int i = jSONObject.getInt("code");
            final String optString = jSONObject.optString("message");
            String optString2 = jSONObject.optString("warning");
            this.h = jSONObject.optString("context");
            LiteavLog.i("TXCPlayInfoProtocolV4", "context : " + this.h);
            LiteavLog.i("TXCPlayInfoProtocolV4", "message: ".concat(String.valueOf(optString)));
            LiteavLog.i("TXCPlayInfoProtocolV4", "warning: ".concat(String.valueOf(optString2)));
            if (i != 0) {
                a(new Runnable() { // from class: com.tencent.liteav.txcvodplayer.b.c.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.a(i, optString);
                    }
                });
                return false;
            }
            int i2 = jSONObject.getInt("version");
            LiteavLog.i("TXCPlayInfoProtocolV4", "version: ".concat(String.valueOf(i2)));
            if (i2 == 2) {
                this.d = null;
                this.e = null;
                this.f22830c = new f(jSONObject);
                return true;
            } else if (i2 == 4) {
                this.b = new com.tencent.liteav.txcvodplayer.b.b(jSONObject);
                return true;
            } else {
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            LiteavLog.e("TXCPlayInfoProtocolV4", "parseJson err");
            return true;
        }
    }

    public final String b() {
        com.tencent.liteav.txcvodplayer.b.b bVar = this.b;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public final int c() {
        com.tencent.liteav.txcvodplayer.b.b bVar = this.b;
        if (bVar != null) {
            return bVar.d;
        }
        f fVar = this.f22830c;
        if (fVar != null) {
            return fVar.b();
        }
        return -1;
    }

    public final String d() {
        com.tencent.liteav.txcvodplayer.b.b bVar = this.b;
        return bVar != null ? bVar.h : "";
    }
}

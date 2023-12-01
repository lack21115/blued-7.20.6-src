package com.zk_oaction.adengine.log;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/log/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f42088a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f42089c;
    private HandlerThread d;

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/log/b$a.class */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                b.this.a((C1118b) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.log.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/log/b$b.class */
    public class C1118b {

        /* renamed from: a  reason: collision with root package name */
        Map f42091a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f42092c;
        int d;
        String e;
        String f;
        String g;
        long h;
        String i;
        String j;

        private C1118b(b bVar) {
        }

        /* synthetic */ C1118b(b bVar, a aVar) {
            this(bVar);
        }
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread("postlog");
        this.d = handlerThread;
        handlerThread.start();
        this.f42089c = new a(this.d.getLooper());
    }

    public static b a() {
        if (f42088a == null) {
            f42088a = new b();
        }
        return f42088a;
    }

    private String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "no_res_id";
            }
            String str2 = str;
            if (!str.endsWith(BridgeUtil.SPLIT_MARK)) {
                str2 = str + BridgeUtil.SPLIT_MARK;
            }
            File[] listFiles = new File(str2 + "res_id_info").listFiles();
            return (listFiles == null || listFiles.length <= 0) ? "no_res_id" : listFiles[0].getName();
        } catch (Throwable th) {
            return "no_res_id";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00db -> B:9:0x00c5). Please submit an issue!!! */
    public void a(C1118b c1118b) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(c1118b.b)) {
                c1118b.b = a(c1118b.f42092c);
            }
            jSONObject.put("action_message", c1118b.i);
            jSONObject.put("res_id", c1118b.b);
            jSONObject.put("ad_id", c1118b.f);
            jSONObject.put("user_id", c1118b.e);
            jSONObject.put("action_time", c1118b.h);
            jSONObject.put("res_type", c1118b.d);
            jSONObject.put("scene", c1118b.g);
            jSONObject.put("action", c1118b.j);
            String aVar = new com.zk_oaction.adengine.log.a(this.b, 3, "hd_log_info", jSONObject.toString(), c1118b.e).toString();
            JSONObject jSONObject2 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2.put("appId", "adssdkdex");
                jSONObject2.put("timestamp", currentTimeMillis);
                jSONObject2.put("json", aVar);
            } catch (Exception e) {
            }
            ZkViewSDK.a().a(c1118b.f42091a, jSONObject2.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Context context) {
        if (this.b != null) {
            return;
        }
        if (context instanceof Application) {
            this.b = context;
        }
        if (this.b == null) {
            this.b = context.getApplicationContext();
        }
        if (this.b == null) {
            this.b = context;
        }
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5, int i, long j, String str6, String str7, Map map) {
        if (this.b == null) {
            a(context);
        }
        C1118b c1118b = new C1118b(this, null);
        c1118b.f42091a = map;
        c1118b.b = str3;
        c1118b.f42092c = str2;
        c1118b.e = str5;
        c1118b.f = str4;
        c1118b.d = i;
        c1118b.h = j;
        c1118b.i = str;
        c1118b.g = str6;
        c1118b.j = str7;
        Message obtain = Message.obtain();
        obtain.obj = c1118b;
        obtain.what = 1;
        this.f42089c.sendMessage(obtain);
    }
}

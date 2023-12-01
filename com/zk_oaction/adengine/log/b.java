package com.zk_oaction.adengine.log;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/log/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f28397a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f28398c;
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
                b.this.a((C0948b) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.log.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/log/b$b.class */
    public class C0948b {

        /* renamed from: a  reason: collision with root package name */
        Map f28400a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f28401c;
        int d;
        String e;
        String f;
        String g;
        long h;
        String i;
        String j;

        private C0948b(b bVar) {
        }

        /* synthetic */ C0948b(b bVar, a aVar) {
            this(bVar);
        }
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread("postlog");
        this.d = handlerThread;
        handlerThread.start();
        this.f28398c = new a(this.d.getLooper());
    }

    public static b a() {
        if (f28397a == null) {
            f28397a = new b();
        }
        return f28397a;
    }

    private String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "no_res_id";
            }
            String str2 = str;
            if (!str.endsWith("/")) {
                str2 = str + "/";
            }
            File[] listFiles = new File(str2 + "res_id_info").listFiles();
            return (listFiles == null || listFiles.length <= 0) ? "no_res_id" : listFiles[0].getName();
        } catch (Throwable th) {
            return "no_res_id";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00db -> B:9:0x00c5). Please submit an issue!!! */
    public void a(C0948b c0948b) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(c0948b.b)) {
                c0948b.b = a(c0948b.f28401c);
            }
            jSONObject.put("action_message", c0948b.i);
            jSONObject.put("res_id", c0948b.b);
            jSONObject.put("ad_id", c0948b.f);
            jSONObject.put(SearchIndexablesContract.RawData.COLUMN_USER_ID, c0948b.e);
            jSONObject.put("action_time", c0948b.h);
            jSONObject.put("res_type", c0948b.d);
            jSONObject.put("scene", c0948b.g);
            jSONObject.put("action", c0948b.j);
            String aVar = new com.zk_oaction.adengine.log.a(this.b, 3, "hd_log_info", jSONObject.toString(), c0948b.e).toString();
            JSONObject jSONObject2 = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject2.put("appId", "adssdkdex");
                jSONObject2.put("timestamp", currentTimeMillis);
                jSONObject2.put("json", aVar);
            } catch (Exception e) {
            }
            ZkViewSDK.a().a(c0948b.f28400a, jSONObject2.toString());
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
        C0948b c0948b = new C0948b(this, null);
        c0948b.f28400a = map;
        c0948b.b = str3;
        c0948b.f28401c = str2;
        c0948b.e = str5;
        c0948b.f = str4;
        c0948b.d = i;
        c0948b.h = j;
        c0948b.i = str;
        c0948b.g = str6;
        c0948b.j = str7;
        Message obtain = Message.obtain();
        obtain.obj = c0948b;
        obtain.what = 1;
        this.f28398c.sendMessage(obtain);
    }
}

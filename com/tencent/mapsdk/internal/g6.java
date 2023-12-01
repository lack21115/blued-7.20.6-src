package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sobot.chat.core.channel.Const;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.da;
import com.tencent.mapsdk.internal.q1;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6.class */
public class g6 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f23782a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$a.class */
    public static final class a extends ca.c<JSONObject> {
        public final /* synthetic */ e b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f23783c;
        public final /* synthetic */ SharedPreferences d;

        public a(e eVar, Context context, SharedPreferences sharedPreferences) {
            this.b = eVar;
            this.f23783c = context;
            this.d = sharedPreferences;
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.b.b = (f) JsonUtils.parseToModel(jSONObject, f.class, new Object[0]);
                g6.b(this.f23783c, this.d, this.b);
                JSONObject modelToJson = JsonUtils.modelToJson(this.b);
                if (modelToJson != null) {
                    na.c(ma.i, "保存上报文件至本地");
                    ia.a(this.d).a("reportFile", modelToJson.toString());
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$b.class */
    public static final class b extends ca.i<JSONObject> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f23784c;
        public final /* synthetic */ q1.b d;

        public b(e eVar, q1.b bVar) {
            this.f23784c = eVar;
            this.d = bVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public JSONObject call() throws Exception {
            NetResponse uploadToken = ((u2) ((g3) n2.a(g3.class)).d()).uploadToken(this.f23784c.c(), this.d.g(), this.d.h());
            na.c(ma.i, "响应状态：" + uploadToken.statusCode);
            if (uploadToken.available()) {
                String a2 = f7.a(uploadToken.data, uploadToken.charset);
                na.c(ma.i, "获取网络token数据：" + a2);
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                return new JSONObject(a2).optJSONObject("detail");
            }
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$c.class */
    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23785a;
        public final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ da.a f23786c;
        public final /* synthetic */ SharedPreferences d;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$c$a.class */
        public class a implements Callback<Boolean> {
            public a() {
            }

            @Override // com.tencent.map.tools.Callback
            /* renamed from: a */
            public void callback(Boolean bool) {
                if (!bool.booleanValue()) {
                    na.c(ma.i, "清理本地缓存");
                    ia.a(c.this.d).a("reportFile", "");
                }
                c.this.f23786c.a();
                boolean unused = g6.f23782a = false;
            }
        }

        public c(e eVar, Context context, da.a aVar, SharedPreferences sharedPreferences) {
            this.f23785a = eVar;
            this.b = context;
            this.f23786c = aVar;
            this.d = sharedPreferences;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            if (g6.f23782a || !this.f23785a.a(this.b)) {
                na.c(ma.i, "正在上传中");
                return;
            }
            this.f23786c.a("上报中", (View.OnClickListener) null);
            this.f23785a.a(new a());
            boolean unused = g6.f23782a = true;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$d.class */
    public static final class d implements Callback<Boolean> {
        public final /* synthetic */ SharedPreferences b;

        public d(SharedPreferences sharedPreferences) {
            this.b = sharedPreferences;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Boolean bool) {
            if (!bool.booleanValue()) {
                na.c(ma.i, "清理本地缓存");
                ia.a(this.b).a("reportFile", "");
            }
            boolean unused = g6.f23782a = false;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$e.class */
    public static class e extends JsonComposer {
        @Json(name = "name")

        /* renamed from: a  reason: collision with root package name */
        public String f23787a;
        @Json(name = "token")
        public f b;
        @Json(name = WBConstants.GAME_PARAMS_GAME_CREATE_TIME)

        /* renamed from: c  reason: collision with root package name */
        public long f23788c;
        @Json(ignore = true)
        public q1 d;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$e$a.class */
        public class a extends ca.c<Boolean> {
            public final /* synthetic */ Callback b;

            public a(Callback callback) {
                this.b = callback;
            }

            @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
            /* renamed from: a */
            public void callback(Boolean bool) {
                Callback callback = this.b;
                if (callback != null) {
                    callback.callback(bool);
                }
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$e$b.class */
        public class b extends ca.i<Boolean> {
            public b() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                return Boolean.valueOf(e.this.g());
            }
        }

        public e(q1 q1Var) {
            this(q1Var, "");
        }

        public e(q1 q1Var, String str) {
            this.f23787a = str;
            this.d = q1Var;
            this.f23788c = System.currentTimeMillis();
        }

        private byte[] e() {
            StringBuilder sb = new StringBuilder();
            q1.b q = this.d.q();
            sb.append(c7.a(q.j(), q.k()));
            sb.append("&engine_draw_version=");
            sb.append(this.d.p());
            sb.append("&engine_data_version=");
            sb.append(this.d.n());
            sb.append("&camera=");
            sb.append(this.d.j().getMap().getCameraPosition());
            na.c(ma.i, "日志数据:" + ((Object) sb));
            return sb.toString().getBytes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() throws Exception {
            File[] listFiles;
            if (this.d == null) {
                return false;
            }
            File file = new File(mc.b(this.d.getContext()).h());
            File a2 = ga.a(file, d());
            na.c(ma.i, "创建上传文件目录:" + a2);
            File b2 = ga.b(a2, "base-info.txt");
            ga.b(b2, e());
            na.c(ma.i, "收集日志数据至文件:" + b2);
            ga.a(new File(mc.b(this.d.getContext()).c(this.d.q().j())), new File(a2, com.igexin.push.core.b.U));
            String f = this.d.o().f();
            if (!TextUtils.isEmpty(f)) {
                File b3 = ga.b(a2, "engine-crash-info.txt");
                na.c(ma.i, "收集引擎Crash至文件:" + b3);
                ga.b(b3, f.getBytes());
            }
            String b4 = this.d.o().b();
            if (!TextUtils.isEmpty(b4)) {
                File b5 = ga.b(a2, "engine-log-info.txt");
                na.c(ma.i, "收集引擎日志至文件:" + b5);
                ga.b(b5, b4.getBytes());
            }
            File e = u.d().e();
            if (e != null && e.exists() && e.isDirectory() && (listFiles = e.listFiles()) != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = listFiles[i2];
                    if (file2 != null && file2.exists() && file2.isFile()) {
                        ga.a(file2, new File(a2, "plugin"));
                    }
                    i = i2 + 1;
                }
            }
            String a3 = na.a();
            if (!TextUtils.isEmpty(a3)) {
                File file3 = new File(a3);
                if (file3.exists() && file3.isDirectory()) {
                    File[] c2 = ga.c(file3, ".*.log.*");
                    if (c2 != null) {
                        int length2 = c2.length;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= length2) {
                                break;
                            }
                            File file4 = c2[i4];
                            if (file4 != null && file4.exists() && file4.isFile()) {
                                ga.a(file4, new File(a2, "logs"));
                            }
                            i3 = i4 + 1;
                        }
                    }
                    File[] c3 = ga.c(file3, "archive-.*.zip");
                    if (c3 != null) {
                        int length3 = c3.length;
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= length3) {
                                break;
                            }
                            File file5 = c3[i6];
                            if (file5 != null && file5.exists() && file5.isFile()) {
                                ga.a(file5, new File(a2, "archives"));
                            }
                            i5 = i6 + 1;
                        }
                    }
                }
            }
            File c4 = ja.c(a2, file.getAbsolutePath());
            na.c(ma.i, "打包成zip文件:" + c4);
            boolean z = false;
            if (c4 != null) {
                byte[] h = ga.h(c4);
                if (h == null) {
                    return false;
                }
                na.c(ma.i, "zip文件大小:" + h.length);
                z = false;
                if (h.length > 0) {
                    na.c(ma.i, "开始上传文件到：" + f());
                    NetResponse doRequest = NetManager.getInstance().doRequest(new NetRequest(NetMethod.PUT, f()).setPostData(h).setMapHeaders("Content-Length", "" + h.length).setMapHeaders("Authorization", this.b.f23791a).setMapHeaders("x-cos-content-sha1", xa.a(c4)).setTimeout(Const.SOCKET_CHECK_CHANNEL));
                    na.c(ma.i, "结束上传文件");
                    ga.d(c4);
                    ga.d(a2);
                    int i7 = doRequest.statusCode;
                    na.c(ma.i, "上传状态:" + i7);
                    z = false;
                    if (i7 == 200) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public long a() {
            return this.f23788c;
        }

        public void a(Callback<Boolean> callback) {
            ca.a((ca.i) new b()).b(null, new a(callback));
        }

        public boolean a(Context context) {
            f fVar;
            return (!NetUtil.isWifi(context) || (fVar = this.b) == null || fVar.a()) ? false : true;
        }

        public long b() {
            f fVar = this.b;
            if (fVar != null) {
                return Long.parseLong(fVar.b);
            }
            return 0L;
        }

        public String c() {
            return d() + ".zip";
        }

        public String d() {
            return "android-" + this.f23787a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f23788c;
        }

        public String f() {
            return "https://" + this.b.f23792c + "/" + c();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g6$f.class */
    public static class f extends JsonComposer {
        @Json(name = "token")

        /* renamed from: a  reason: collision with root package name */
        public String f23791a;
        @Json(name = "expire")
        public String b;
        @Json(name = "host")

        /* renamed from: c  reason: collision with root package name */
        public String f23792c;

        public boolean a() {
            try {
                return Long.parseLong(this.b) < SystemClock.uptimeMillis() / 1000;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ab, code lost:
        if (r0.equals(r9.f23787a) == false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.tencent.mapsdk.internal.q1 r8) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.g6.a(com.tencent.mapsdk.internal.q1):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, SharedPreferences sharedPreferences, e eVar) {
        if (eVar == null || context == null) {
            return false;
        }
        if (!na.d(ma.i) || Build.VERSION.SDK_INT >= 30) {
            if (f23782a || !eVar.a(context)) {
                return false;
            }
            eVar.a(new d(sharedPreferences));
            f23782a = true;
            return false;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("日志名称:");
            sb.append("\n");
            sb.append(eVar.d());
            sb.append("\n");
            String format = SimpleDateFormat.getInstance().format(new Date(eVar.a()));
            sb.append("创建时间:");
            sb.append("\n");
            sb.append(format);
            sb.append("\n");
            String format2 = SimpleDateFormat.getInstance().format(new Date(eVar.b() * 1000));
            sb.append("过期时间:");
            sb.append("\n");
            sb.append(format2);
            sb.append("\n");
            da.a a2 = da.a(context, "调试模式", sb.toString(), 1);
            return a2.a(true).a("上报(仅WIFI)", new c(eVar, context, a2, sharedPreferences)).b();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}

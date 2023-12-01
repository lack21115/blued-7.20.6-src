package com.tencent.mapsdk.internal;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nf.class */
public class nf extends AsyncTask<Object, Void, Void> {
    public static final int g = 10000;

    /* renamed from: a  reason: collision with root package name */
    private Handler f23974a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f23975c;
    private d d;
    private c e;
    private Handler f = new a(Looper.myLooper());

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nf$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 10000) {
                return;
            }
            new nf(nf.this.f23974a, nf.this.b, nf.this.f23975c, nf.this.d).execute(new Object[0]);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nf$b.class */
    public class b implements Runnable {
        public final /* synthetic */ JSONObject b;

        public b(JSONObject jSONObject) {
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nf.this.d != null) {
                nf.this.d.a(nf.this.e, this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nf$c.class */
    public static class c implements JsonParser {

        /* renamed from: a  reason: collision with root package name */
        public s5 f23978a;
        public JSONArray b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f23979c;
        public sf d;
        public int e = hh.r;

        @Override // com.tencent.map.tools.json.JsonParser
        public void parse(JSONObject jSONObject) {
            JSONObject optJSONObject;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.i)) == null) {
                return;
            }
            this.b = optJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("indoor_map");
            if (optJSONObject2 != null) {
                int optInt = optJSONObject2.optInt("enable", -1);
                int optInt2 = optJSONObject2.optInt("type", -1);
                if (optInt != -1 && optInt2 != -1) {
                    this.f23978a = new s5(optInt, optInt2, optJSONObject2.optJSONArray("building_list"));
                }
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("custom_layer");
            if (optJSONObject3 != null) {
                this.d = (sf) JsonUtils.parseToModel(optJSONObject3, sf.class, new Object[0]);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("event_map");
            if (optJSONObject4 != null) {
                this.e = optJSONObject4.optInt("enable", hh.r);
            }
            this.f23979c = optJSONObject.optJSONObject("data_layer");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nf$d.class */
    public interface d {
        void a(c cVar, JSONObject jSONObject);
    }

    public nf(Handler handler, String str, String str2, d dVar) {
        this.f23974a = handler;
        this.d = dVar;
        this.b = TextUtils.isEmpty(str) ? "" : str;
        this.f23975c = TextUtils.isEmpty(str2) ? "" : str2;
    }

    private void a(int i, String str) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add("腾讯地图鉴权失败，请访问 lbs.qq.com 检查 key 配置");
        arrayList.add("错误码：" + i);
        arrayList.add("错误信息：" + str);
        StringBuilder sb = new StringBuilder(1024);
        sb.append("Auth Fail:\n");
        char[] cArr = new char[81];
        Arrays.fill(cArr, '*');
        cArr[80] = '\n';
        sb.append(cArr);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append("\n");
        }
        sb.append(cArr);
        Log.e("tencentmap", sb.toString());
    }

    private void a(JSONObject jSONObject) {
        this.e = (c) JsonUtils.parseToModel(jSONObject.optJSONObject("detail"), c.class, new Object[0]);
        this.f23974a.post(new b(jSONObject));
    }

    private String b() {
        String G = c7.G();
        return TextUtils.isEmpty(G) ? "0" : "wifi".equals(G) ? "2" : "1";
    }

    private void b(JSONObject jSONObject) {
        String str;
        int i;
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject != null) {
            i = optJSONObject.optInt("error");
            str = optJSONObject.optString("msg");
        } else {
            str = "";
            i = 0;
        }
        if (i == 0) {
            c7.D = 0;
            return;
        }
        a(i, str);
        if (i < -400) {
            c7.D = -1;
        } else {
            c7.D = 1;
        }
    }

    private void c() {
        if (this.f23974a != null) {
            v5 v5Var = new v5();
            v5Var.f24371a = 3;
            this.f23974a.sendMessage(this.f23974a.obtainMessage(3, v5Var));
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        boolean a2 = a();
        if (c7.D == 2) {
            this.f.sendEmptyMessageDelayed(10000, 10000L);
        }
        if (a2) {
            return null;
        }
        c();
        return null;
    }

    public boolean a() {
        String str;
        g3 g3Var = (g3) n2.a(g3.class);
        boolean z = false;
        if (g3Var == null) {
            return false;
        }
        NetResponse checkAuth = ((u2) g3Var.d()).checkAuth(c7.t(), this.b, c7.N(), this.f23975c, c7.y(), c7.A(), c7.I(), c7.M(), c7.E(), c7.O(), b());
        byte[] bArr = new byte[0];
        if (checkAuth != null) {
            String str2 = checkAuth.charset;
            byte[] bArr2 = checkAuth.data;
            str = str2;
            if (bArr2 != null) {
                bArr = bArr2;
                str = str2;
            }
        } else {
            str = "utf-8";
        }
        c7.E = Calendar.getInstance().get(1);
        c7.F = Calendar.getInstance().get(2);
        c7.G = Calendar.getInstance().get(5);
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr, str));
            a(jSONObject);
            b(jSONObject);
            if (c7.D == 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }
}

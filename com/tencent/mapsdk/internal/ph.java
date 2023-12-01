package com.tencent.mapsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Condition;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph.class */
public class ph extends p1 implements z3 {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, kh> f24006c;
    private File d;
    private File e;
    private String f;
    private boolean g;
    private List<e4> h;
    private f4 i;
    private g j;
    private kb k;
    private Set<String> l;
    private boolean m;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$a.class */
    public class a implements Callback<kh> {
        public a() {
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(kh khVar) {
            if (khVar != null) {
                khVar.b(2);
                khVar.l();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$b.class */
    public class b implements Runnable {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callback f24007c;

        public b(String str, Callback callback) {
            this.b = str;
            this.f24007c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f24007c.callback(ga.h(ph.this.j(this.b)));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$c.class */
    public class c extends Condition<e4> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24008a;

        public c(String str) {
            this.f24008a = str;
        }

        @Override // com.tencent.map.tools.Condition
        /* renamed from: a */
        public boolean condition(e4 e4Var) {
            return e4Var != null && e4Var.c().equals(this.f24008a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$d.class */
    public class d extends Condition<kh> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f24009a;

        public d(String str) {
            this.f24009a = str;
        }

        @Override // com.tencent.map.tools.Condition
        /* renamed from: a */
        public boolean condition(kh khVar) {
            return khVar != null && khVar.getId().equals(this.f24009a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$e.class */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24010a;

        static {
            a4.values();
            int[] iArr = new int[7];
            f24010a = iArr;
            try {
                a4 a4Var = a4.Gradient;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f24010a;
                a4 a4Var2 = a4.Aggregation;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f24010a;
                a4 a4Var3 = a4.ArcLine;
                iArr3[3] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f24010a;
                a4 a4Var4 = a4.GLModel;
                iArr4[4] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$f.class */
    public class f extends qb implements jb {

        /* renamed from: c  reason: collision with root package name */
        private final String f24011c;
        private final String d;
        private ByteArrayOutputStream e;
        private Callback<byte[]> f;
        private String g;

        public f(String str, String str2) {
            this.f24011c = str;
            this.d = str2;
        }

        public void a(Callback<byte[]> callback) {
            ph.this.k.a(this);
            ph.this.k.a(this.d, this);
            this.f = callback;
        }

        @Override // com.tencent.mapsdk.internal.qb
        public void a(NetRequest.NetRequestBuilder netRequestBuilder) {
            super.a(netRequestBuilder);
            netRequestBuilder.gzip();
        }

        @Override // com.tencent.mapsdk.internal.qb
        public void a(NetResponse netResponse) {
            super.a(netResponse);
            this.g = netResponse.contentEncoding;
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void a(String str) {
            na.a(ma.x, "#completed download {" + this.f24011c + "} [" + str + "]");
            ph.this.k.b(this);
            if (this.f != null) {
                byte[] byteArray = this.e.toByteArray();
                byte[] c2 = "gzip".equals(this.g) ? ja.c(byteArray) : byteArray;
                StringBuilder sb = new StringBuilder();
                sb.append("数据量大小 {");
                sb.append(this.f24011c);
                sb.append("} [");
                sb.append(byteArray != null ? byteArray.length : 0);
                sb.append(" : ");
                int i = 0;
                if (c2 != null) {
                    i = c2.length;
                }
                sb.append(i);
                sb.append("]");
                na.a(ma.x, sb.toString());
                this.f.callback(c2);
            }
            ha.a(this.e);
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void a(String str, lb lbVar) {
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void a(String str, byte[] bArr) {
            if (bArr != null) {
                try {
                    this.e.write(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void b(String str) {
            na.a(ma.x, "#fail download {" + this.f24011c + "} [" + str + "]");
            ha.a(this.e);
            kh i = ph.this.i(this.f24011c);
            if (i != null) {
                i.b(1);
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void c(String str) {
            na.a(ma.x, "#cancel download {" + this.f24011c + "} [" + str + "]");
            ha.a(this.e);
            kh i = ph.this.i(this.f24011c);
            if (i != null) {
                i.b(1);
            }
        }

        @Override // com.tencent.mapsdk.internal.jb
        public void d(String str) {
            na.a(ma.x, "#start download {" + this.f24011c + "} [" + str + "]");
            this.e = new ByteArrayOutputStream();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ph$g.class */
    public static class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<ph> f24012a;

        public g(ph phVar) {
            super(Looper.myLooper());
            this.f24012a = new WeakReference<>(phVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ph phVar = this.f24012a.get();
            if (phVar == null || message.what == 0) {
                return;
            }
            String str = (String) message.obj;
            int i = message.arg2;
            if (message.arg1 > 0) {
                if (i > 0) {
                    na.a(ma.x, "循环刷新[" + str + "]次数[" + i + "]");
                    phVar.l(str);
                }
                message.arg2 = i + 1;
                Message obtain = Message.obtain(message);
                sendMessageDelayed(obtain, obtain.arg1);
            }
        }
    }

    private boolean b(JSONObject jSONObject) {
        na.a(ma.x, "#parseLayerInfoJson:" + jSONObject);
        f4 f4Var = (f4) JsonUtils.parseToModel(jSONObject, f4.class, new Object[0]);
        if (f4Var == null) {
            na.g(ma.x, "解析LayerInfo数据失败");
            return false;
        }
        this.g = f4Var.b();
        this.h.clear();
        List<e4> a2 = f4Var.a();
        if (a2 != null && !a2.isEmpty()) {
            this.h.addAll(a2);
        }
        na.a(ma.x, "解析LayerInfo数据成功");
        this.i = f4Var;
        return true;
    }

    private void g() {
        na.a(ma.x, "#loadLayerJsonFromLocal");
        byte[] h = ga.h(this.e);
        if (h == null || h.length <= 0) {
            return;
        }
        try {
            b(new JSONObject(new String(h)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ga.d(this.e);
        ga.b(this.e, str.getBytes());
    }

    private e4 h(String str) {
        return (e4) Util.singleWhere(new ArrayList(this.h), new c(str));
    }

    private void h() {
        JSONObject json;
        na.a(ma.x, "#restoreLayerJsonToLocal");
        f4 f4Var = this.i;
        if (f4Var == null || !this.g || (json = f4Var.toJson()) == null) {
            return;
        }
        g(json.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kh i(String str) {
        return (kh) Util.singleWhere(this.f24006c.values(), new d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File j(String str) {
        return new File(new File(this.d, wa.a(str)), "cache.dat");
    }

    private File k(String str) {
        return new File(this.d, wa.a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        na.a(ma.x, "#refreshLayerData[" + str + "]");
        kh khVar = this.f24006c.get(str);
        if (khVar != null) {
            khVar.c(this);
        }
    }

    @Override // com.tencent.mapsdk.internal.z3
    public VisualLayer a(VisualLayerOptions visualLayerOptions) {
        if (visualLayerOptions == null) {
            return null;
        }
        String layerId = visualLayerOptions.getLayerId();
        na.a(ma.x, "#createLayer[" + layerId + "]");
        kh khVar = this.f24006c.get(visualLayerOptions.getLayerId());
        if (khVar != null) {
            khVar.a(visualLayerOptions);
            return khVar;
        }
        kh khVar2 = new kh(visualLayerOptions);
        this.f24006c.put(visualLayerOptions.getLayerId(), khVar2);
        khVar2.b(this);
        return khVar2;
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void a(q1 q1Var) {
        super.a(q1Var);
        this.m = false;
        this.j = new g(this);
        this.f24006c = new ConcurrentHashMap();
        this.h = new CopyOnWriteArrayList();
        this.k = new kb();
        this.l = new HashSet();
        this.f = q1Var.q().g();
        if (!TextUtils.isEmpty(q1Var.q().j())) {
            this.f = q1Var.q().j();
        }
        String c2 = q1Var.q().c();
        File c3 = q1Var.x().c();
        this.d = new File(c3, "visual/" + c2);
        this.e = new File(this.d, "layerInfo.json");
        na.a(ma.x, "#datalayer config file [" + this.e + "]");
        g();
        oh.a();
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void a(String str) {
        na.g(ma.x, "添加到等待队列[" + str + "]");
        this.l.add(str);
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void a(String str, int i) {
        na.a(ma.x, "#startTimeInterval[" + str + "], hash = " + str.hashCode() + " timeInterval = " + i);
        if (i <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        this.j.removeMessages(str.hashCode());
        Message.obtain(this.j, str.hashCode(), i * 1000, 0, str).sendToTarget();
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void a(String str, int i, int i2) {
        na.a(ma.x, "#updateLayerVersionInfo[" + str + "], dv=" + i + " sv=" + i2);
        e4 h = h(str);
        if (h != null) {
            h.b(i2);
            h.a(i);
        }
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void a(String str, Callback<byte[]> callback) {
        boolean z;
        na.a(ma.x, "#requestNew[" + str + "]");
        e4 h = h(str);
        if (h != null) {
            String a2 = h.a();
            if (!TextUtils.isEmpty(a2)) {
                z = true;
                String concat = a2.concat("&key=" + this.f);
                na.a(ma.x, "请求数据的URL[" + concat + "]");
                new f(str, concat).a(callback);
                if (!z || callback == null) {
                }
                callback.callback(null);
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void a(String str, byte[] bArr) {
        na.a(ma.x, "#saveLayerData[" + str + "]");
        File j = j(str);
        File c2 = ga.c(j);
        ga.b(c2, bArr);
        ga.b(c2, j);
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void a(JSONObject jSONObject) {
        na.a(ma.x, "#saveLayerInfosToLocal[" + jSONObject + "]");
        this.m = true;
        boolean z = false;
        if (jSONObject != null) {
            boolean b2 = b(jSONObject);
            z = b2;
            if (b2) {
                g(jSONObject.toString());
                z = b2;
                if (!this.l.isEmpty()) {
                    na.a(ma.x, "初始化等待队列图层[" + this.l.size() + "]");
                    for (String str : this.l) {
                        kh khVar = this.f24006c.get(str);
                        if (khVar != null) {
                            khVar.b(this);
                        }
                    }
                    this.l.clear();
                    z = b2;
                }
            }
        } else {
            this.g = false;
            this.h.clear();
            this.i = null;
        }
        if (z && this.g) {
            return;
        }
        Util.foreach(this.f24006c.values(), new a());
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void b(q1 q1Var) {
        super.b(q1Var);
        Map<String, kh> map = this.f24006c;
        if (map != null) {
            for (kh khVar : map.values()) {
                if (!khVar.isRemoved()) {
                    khVar.remove();
                }
            }
            this.f24006c.clear();
        }
        h();
        oh.b();
        na.a(ma.x, "退出数据图层成功");
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void b(String str) {
        na.a(ma.x, "#removeLayer[" + str + "]");
        Map<String, kh> map = this.f24006c;
        if (map != null) {
            map.remove(str);
        }
        d(str);
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void b(String str, Callback<byte[]> callback) {
        na.a(ma.x, "#readLayerDataFromCache[" + str + "]");
        if (callback != null) {
            ca.a(new b(str, callback));
        }
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void c(String str) {
        na.a(ma.x, "#clearCache[" + str + "]");
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        File k = k(str);
        na.a(ma.x, "执行删除文件[" + k + "]");
        ga.e(k);
        a(str, 0, 0);
    }

    @Override // com.tencent.mapsdk.internal.z3
    public boolean c() {
        return this.m;
    }

    @Override // com.tencent.mapsdk.internal.z3
    public void d(String str) {
        na.a(ma.x, "#stopTimeInterval[" + str + "]");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.j.removeMessages(str.hashCode());
    }

    @Override // com.tencent.mapsdk.internal.z3
    public boolean e(String str) {
        kh i;
        na.a(ma.x, "#checkLayerStatusById[" + str + "]");
        boolean z = false;
        if (this.g) {
            e4 h = h(str);
            if (h != null && (i = i(str)) != null) {
                int ordinal = h.d().ordinal();
                if (ordinal == 1) {
                    i.a(new nh());
                } else if (ordinal == 2) {
                    i.a(new ih());
                } else if (ordinal == 3) {
                    i.a(new jh());
                } else if (ordinal == 4) {
                    i.a(new mh());
                }
            }
            z = false;
            if (h != null) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.z3
    public String f(String str) {
        return k(str).getAbsolutePath();
    }
}

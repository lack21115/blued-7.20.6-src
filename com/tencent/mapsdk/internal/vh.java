package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.internal.ca;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vh.class */
public class vh {
    private di h;
    private boolean i;
    private OverSeaTileProvider l;

    /* renamed from: a  reason: collision with root package name */
    private int f38077a = ci.e;
    private int b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private int f38078c = ci.g;
    private int d = 0;
    private volatile boolean e = false;
    private int f = 0;
    private String g = null;
    private OverSeaSource j = OverSeaSource.DEFAULT;
    private Language k = Language.zh;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vh$a.class */
    public class a extends ca.c<Boolean> {
        public final /* synthetic */ Callback b;

        public a(Callback callback) {
            this.b = callback;
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(Boolean bool) {
            this.b.callback(bool);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vh$b.class */
    public class b extends ca.i<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f38080c;
        public final /* synthetic */ OverSeaSource d;

        public b(Context context, OverSeaSource overSeaSource) {
            this.f38080c = context;
            this.d = overSeaSource;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            na.c(ma.h, "开始初始化配置");
            String a2 = vh.this.a(this.f38080c, this.d);
            na.c(ma.h, "本地配置数据：" + a2);
            if (!f7.b(a2)) {
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    vh.this.h = (di) JsonUtils.parseToModel(jSONObject, di.class, new Object[0]);
                } catch (JSONException e) {
                    na.b(ma.h, e);
                }
                vh vhVar = vh.this;
                vhVar.a(vhVar.h);
            } else if (y9.c("4.5.9", "4.3.1", 3)) {
                vh.this.b(this.f38080c);
            }
            na.c(ma.h, "完成初始化配置");
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vh$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38081a;

        static {
            OverSeaSource.values();
            int[] iArr = new int[2];
            f38081a = iArr;
            try {
                OverSeaSource overSeaSource = OverSeaSource.DEFAULT;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f38081a;
                OverSeaSource overSeaSource2 = OverSeaSource.SPARE;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private yh a(ci ciVar) {
        List<yh> a2;
        if (ciVar == null || (a2 = ciVar.a()) == null) {
            return null;
        }
        for (yh yhVar : a2) {
            if (yhVar.a() == 2 && this.i) {
                return yhVar;
            }
            if (yhVar.a() == 1 && !this.i) {
                return yhVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, OverSeaSource overSeaSource) {
        lc a2 = lc.a(context);
        int ordinal = overSeaSource.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                return null;
            }
            return a2.d("worldMapConfig_BING");
        }
        return a2.d(m4.g);
    }

    private void a(Context context, OverSeaSource overSeaSource, String str) {
        lc a2 = lc.a(context);
        int ordinal = overSeaSource.ordinal();
        if (ordinal == 0) {
            a2.b(m4.g, str);
        } else if (ordinal != 1) {
        } else {
            a2.b("worldMapConfig_BING", str);
        }
    }

    private void a(Context context, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        na.c(ma.h, "下载新边界数据：" + str);
        try {
            NetResponse doStream = NetManager.getInstance().builder().gzip().url(str).doStream();
            InputStream inputStream = doStream.getInputStream();
            if (doStream.statusCode == 200) {
                String str2 = TextUtils.isEmpty(doStream.contentEncoding) ? "gzip" : doStream.contentEncoding;
                byte[] a2 = str2 != null && str2.length() > 0 && str2.toLowerCase().contains("gzip") ? ja.a(inputStream) : ha.b(inputStream);
                if (a2 == null || a2.length <= 0) {
                    return;
                }
                String str3 = new String(a2);
                this.f = th.b().d(str3);
                na.c(ma.h, "新边界数据版本号：" + this.f);
                th.b().e(str3);
            }
        } catch (Throwable th) {
            na.b(ma.h, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(di diVar) {
        if (diVar == null) {
            return;
        }
        ci b2 = diVar.b();
        if (b2 != null) {
            this.d = b2.c();
            na.c(ma.h, "更新版本：" + this.d);
            bi b3 = b2.b();
            if (b3 != null) {
                this.f = b3.b();
                na.c(ma.h, "更新边界版本：" + this.f38078c);
            }
        }
        ei c2 = c(b2);
        if (c2 != null) {
            this.b = c2.d();
            this.f38077a = c2.c();
            this.f38078c = c2.f();
            this.g = c2.e();
            na.c(ma.h, "更新图源版本：" + this.f38078c);
        }
        this.e = diVar.a() == 0;
    }

    private List<zh> b(ci ciVar) {
        if (ciVar != null) {
            return ciVar.d();
        }
        return null;
    }

    private ei c(ci ciVar) {
        yh a2;
        if (ciVar == null || (a2 = a(ciVar)) == null) {
            return null;
        }
        return a2.b();
    }

    public int a() {
        return this.f;
    }

    public File a(Context context) {
        return new File(mc.b(context).c(), g());
    }

    public void a(Context context, OverSeaSource overSeaSource, Callback<Boolean> callback) {
        if (context == null) {
            return;
        }
        this.j = overSeaSource;
        ca.a((ca.i) new b(context, overSeaSource)).a((ca.d.b) Boolean.FALSE, (ca.c<ca.d.b>) (callback != null ? new a(callback) : null));
    }

    public void a(Language language) {
        this.k = language;
    }

    public void a(OverSeaTileProvider overSeaTileProvider) {
        this.l = overSeaTileProvider;
    }

    public void a(boolean z) {
        na.c(ma.h, "使用海外暗色模式？" + z);
        this.i = z;
    }

    public Language b() {
        return this.k;
    }

    public void b(Context context) {
        int[] iArr;
        lc a2 = lc.a(context);
        na.c(ma.h, "兼容老数据");
        int a3 = a2.a(m4.i, 1000);
        int a4 = a2.a(m4.j, ci.e);
        int a5 = a2.a(m4.k, ci.g);
        int a6 = a2.a(m4.m, 0);
        boolean a7 = a2.a(m4.h);
        String d = a2.d(m4.n);
        int[] iArr2 = new int[0];
        int[] iArr3 = iArr2;
        try {
            String d2 = a2.d(m4.o);
            iArr = iArr2;
            if (!f7.b(d2)) {
                JSONArray jSONArray = new JSONArray(d2);
                int length = jSONArray.length();
                int[] iArr4 = new int[length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    iArr = iArr4;
                    if (i2 >= length) {
                        break;
                    }
                    iArr3 = iArr4;
                    iArr4[i2] = jSONArray.getInt(i2);
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
            na.b(ma.h, e);
            iArr = iArr3;
        }
        String d3 = a2.d(m4.p);
        int a8 = a2.a(m4.l, 0);
        yh yhVar = new yh();
        yhVar.a(1);
        ei eiVar = new ei();
        eiVar.b(d);
        eiVar.a(iArr);
        eiVar.a(a4);
        eiVar.b(a3);
        eiVar.c(a5);
        yhVar.a(eiVar);
        ci ciVar = new ci();
        ciVar.a(a6);
        List<zh> list = null;
        try {
            if (!f7.b(d3)) {
                list = JsonUtils.parseToList(new JSONArray(d3), zh.class, new Object[0]);
            }
        } catch (JSONException e2) {
            na.b(ma.h, e2);
            list = null;
        }
        ciVar.b(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(yhVar);
        ciVar.a(arrayList);
        bi biVar = new bi();
        biVar.a(a8);
        ciVar.a(biVar);
        di diVar = new di();
        this.h = diVar;
        diVar.a(a7 ? 0 : -1);
        this.h.a(ciVar);
        String jSONObject = this.h.toJson().toString();
        na.c(ma.h, "老数据：" + jSONObject);
        a2.b(m4.g, jSONObject);
        a2.a(new String[]{m4.i, m4.j, m4.k, m4.m, m4.h, m4.n, m4.o, m4.p, m4.l});
        a(this.h);
    }

    public boolean b(Context context, String str) {
        ci b2;
        boolean z;
        na.c(ma.h, "开始更新配置：" + str);
        di diVar = (di) JsonUtils.parseToModel(str, di.class, new Object[0]);
        if (diVar == null || (b2 = diVar.b()) == null) {
            na.c(ma.h, "配置更新数据解析失败，使用上次的配置");
            return false;
        }
        if (diVar.a() != 0) {
            z = this.e;
            this.e = false;
        } else {
            z = !this.e;
            this.e = true;
        }
        na.c(ma.h, "权限是否更新：" + z);
        boolean z2 = b2.c() != this.d;
        na.c(ma.h, "协议版本是否更新：" + z2);
        if (!z && !z2) {
            return false;
        }
        yh a2 = a(b2);
        if (a2 != null) {
            int a3 = a2.a();
            ei b3 = a2.b();
            if (b3 != null) {
                int f = b3.f();
                int d = b3.d();
                na.c(ma.h, "版本对比: old[" + this.f38078c + "]-new[" + f + "]");
                na.c(ma.h, "样式对比: old[" + this.b + "]-new[" + d + "]");
                if (f != this.f38078c || d != this.b || a3 != this.f38077a) {
                    File a4 = a(context);
                    if (a4.exists()) {
                        ga.d(a4);
                        na.c(ma.h, "删除海外图缓存目录: " + a4);
                    }
                }
            }
        }
        bi b4 = b2.b();
        if (b4 != null) {
            String a5 = b4.a();
            na.c(ma.h, "配置边界线: " + a5);
            a(context, a5);
            b4.a(this.f);
        }
        this.h = diVar;
        a(context, this.j, str);
        a(this.h);
        na.c(ma.h, "配置更新完成");
        return true;
    }

    public OverSeaTileProvider c() {
        return this.l;
    }

    public OverSeaSource d() {
        return this.j;
    }

    public int e() {
        int ordinal = this.j.ordinal();
        int i = 1;
        if (ordinal == 0) {
            i = 2;
        } else if (ordinal != 1) {
            return 0;
        }
        return i;
    }

    public String f() {
        if (this.l != null) {
            return this.l.getProviderVersion() + File.separator + this.k.name();
        }
        ei k = k();
        if (k != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(k.c());
            String str = File.separator;
            sb.append(str);
            sb.append(k.d());
            sb.append(str);
            sb.append(k.f());
            sb.append(str);
            sb.append(this.k.name());
            return sb.toString();
        }
        return "";
    }

    public String g() {
        String str;
        OverSeaTileProvider overSeaTileProvider = this.l;
        boolean z = true;
        if (overSeaTileProvider != null) {
            z = overSeaTileProvider.onDayNightChange(this.i);
            str = "rastermap/customoversea/" + this.l.getProviderName();
        } else if (this.j.ordinal() != 1) {
            str = "rastermap/world";
        } else {
            z = false;
            str = "rastermap/bingworld";
        }
        return str + ((this.i && z) ? "/dark" : "");
    }

    public List<zh> h() {
        di diVar = this.h;
        if (diVar == null) {
            return null;
        }
        if (this.l != null) {
            ArrayList arrayList = new ArrayList(b(this.h.b()));
            zh zhVar = new zh();
            zhVar.a(new int[]{0, 18});
            ArrayList arrayList2 = new ArrayList();
            ai aiVar = new ai();
            aiVar.a(th.i);
            aiVar.b(true);
            aiVar.b(1);
            aiVar.b(this.l.getProviderName());
            aiVar.a(this.l.getLogo(true));
            aiVar.b(this.l.getLogo(false));
            arrayList2.add(aiVar);
            zhVar.a(arrayList2);
            arrayList.add(0, zhVar);
            return arrayList;
        }
        return b(diVar.b());
    }

    public bi i() {
        ci b2;
        di diVar = this.h;
        if (diVar == null || (b2 = diVar.b()) == null) {
            return null;
        }
        return b2.b();
    }

    public int j() {
        return this.d;
    }

    public ei k() {
        di diVar = this.h;
        if (diVar == null) {
            return null;
        }
        return c(diVar.b());
    }

    public boolean l() {
        return this.i;
    }

    public boolean m() {
        return this.e;
    }
}

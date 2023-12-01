package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetManager;
import com.tencent.mapsdk.core.components.protocol.jce.conf.CSFileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttResponse;
import com.tencent.mapsdk.core.components.protocol.jce.sso.CmdResult;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Header;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Package;
import com.tencent.mapsdk.core.components.protocol.jce.sso.Tag;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Basic;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Response;
import com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t;
import com.tencent.mapsdk.internal.k2;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapProtocol;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n2.class */
public class n2 extends p1 implements j2, TencentMapProtocol {
    private static final String f = "cuid";
    private static final String g = "duid";
    private static final String h = "sessionid";
    private static final Stack<f2> i = new Stack<>();
    private static final f2 j = new g2();

    /* renamed from: c  reason: collision with root package name */
    private f2 f23965c;
    private final Map<String, String> d = new HashMap();
    private TencentMapOptions e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/n2$a.class */
    public static class a implements TencentMapServiceProtocol.IMapService {

        /* renamed from: a  reason: collision with root package name */
        public k2.a f23966a;

        public a(k2.a aVar) {
            this.f23966a = aVar;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService
        public void setAllow(boolean z) {
            this.f23966a.setAllow(z);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService
        public void setUseHttps(boolean z) {
            this.f23966a.setUseHttps(z);
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol.IMapService
        public void setUseTest(boolean z) {
            this.f23966a.setUseTest(z);
        }
    }

    public n2() {
    }

    public n2(TencentMapOptions tencentMapOptions, f2 f2Var) {
        this.e = tencentMapOptions;
        this.f23965c = f2Var;
    }

    private f2 a(q1 q1Var, String str, int i2) {
        return a(q1Var, str, q1Var.getContext().getResources().openRawResource(i2));
    }

    private f2 a(q1 q1Var, String str, InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (-1 == read) {
                                f2 b = b(q1Var, str, new String(byteArrayOutputStream3.toByteArray(), Charset.forName("UTF-8")));
                                ha.a(byteArrayOutputStream3);
                                ha.a((Closeable) inputStream);
                                return b;
                            }
                            byteArrayOutputStream3.write(bArr, 0, read);
                        } catch (IOException e) {
                            e = e;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            e.printStackTrace();
                            ha.a(byteArrayOutputStream);
                            ha.a((Closeable) inputStream);
                            return new g2();
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream2 = byteArrayOutputStream3;
                            ha.a(byteArrayOutputStream2);
                            ha.a((Closeable) inputStream);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return new g2();
    }

    public static <S extends l2> S a(Class<S> cls) {
        Stack<f2> stack = i;
        return stack.isEmpty() ? (S) j.d(cls) : (S) stack.peek().d(cls);
    }

    private void a(Context context, TencentMapOptions tencentMapOptions) {
        NetManager.init(context, NetConfig.create().setAdapterType(tencentMapOptions.getNetAdapterType()).setLogEnable(mi.d).setForceHttps(tencentMapOptions.isForceHttps()).setArguments(tencentMapOptions.getNetParams()).setNetFlowRuleList(i()).setProcessor(h6.class).setProxyRuleList(g().a()));
    }

    private void a(q1 q1Var, TencentMapOptions tencentMapOptions) {
        Object protocolDataDesc = tencentMapOptions.getProtocolDataDesc();
        String g2 = q1Var.q().g();
        if (this.f23965c == null) {
            this.f23965c = j;
        }
        if (protocolDataDesc != null) {
            int protocolFrom = tencentMapOptions.getProtocolFrom();
            f2 b = protocolFrom != -1 ? protocolFrom != 1 ? protocolFrom != 3 ? null : b(q1Var, g2, (String) protocolDataDesc) : a(q1Var, g2, ((Integer) protocolDataDesc).intValue()) : a(q1Var, g2, (String) protocolDataDesc);
            if (b != null) {
                this.f23965c = b;
            }
        }
        f2 f2Var = this.f23965c;
        if (f2Var != null) {
            f2Var.d(g2);
            this.f23965c.a(this);
        } else {
            this.f23965c = j;
        }
        i.push(this.f23965c);
    }

    public static p2 g() {
        Stack<f2> stack = i;
        return stack.isEmpty() ? new q2() : stack.peek().a();
    }

    private HashMap<String, String> i() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("apikey.map.qq.com/mkey/index.php/mkey/check", "map_nf_auth");
        hashMap.put("vectorsdk.map.qq.com/mvd_map", "map_nf_mvd");
        hashMap.put("vectorsdk.map.qq.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("p0.map.gtimg.com/fileupdate", "map_nf_mapcfg");
        hashMap.put("vectorsdk.map.qq.com/indoormap2", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormap2/index", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormapx", "map_nf_indoor");
        hashMap.put("vectorsdk.map.qq.com/indoormapx/index", "map_nf_indoor");
        hashMap.put("tafrtt.map.qq.com/rttserverex/", "map_nf_trfc");
        hashMap.put("p0.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p1.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p2.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("p3.map.gtimg.com/sateTiles/", "map_nf_sat");
        hashMap.put("apikey.map.qq.com/sdkapis/v1/cos_token", "map_nf_fileup");
        hashMap.put("overseactrl.map.qq.com", "map_nf_wdVer");
        hashMap.put("s0.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s1.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s2.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("s3.map.gtimg.com/oversea", "map_nf_wdTile");
        hashMap.put("confinfo.map.qq.com/confinfo", "map_nf_hdVer");
        hashMap.put("p0.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p1.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p2.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("p3.map.gtimg.com/scenic/", "map_nf_hdTile");
        hashMap.put("sdkgw.map.qq.com/map/traffic/event", "map_nf_pnt");
        hashMap.put("sdkgw.map.qq.com/map/poi/detail", "map_nf_aoi");
        hashMap.put("mapapi.qq.com/sdk/", "map_nf_res");
        hashMap.put("wecar.myapp.com/myapp/mapwecar", "map_nf_res");
        hashMap.put("map.myapp.com/soso_map/", "map_nf_off");
        hashMap.put("pr.map.qq.com/ditusdk/monitor", "map_nf_pr");
        hashMap.put("pr.map.qq.com/pingd", "map_nf_pr");
        hashMap.put("s0.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s1.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s2.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("s3.map.gtimg.com/customlayer/tile", "map_nf_cusLyr");
        hashMap.put("datalayer.map.qq.com/console/datalayer/data", "map_nf_visLyr");
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    public f2 a(q1 q1Var, String str, String str2) {
        InputStream inputStream;
        InputStream open;
        try {
            try {
                open = q1Var.getContext().getResources().getAssets().open(str2);
            } catch (IOException e) {
                e = e;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                str2 = null;
                ha.a((Closeable) str2);
                throw th;
            }
            try {
                f2 a2 = a(q1Var, str, open);
                ha.a((Closeable) open);
                return a2;
            } catch (IOException e2) {
                e = e2;
                inputStream = open;
                e.printStackTrace();
                ha.a((Closeable) inputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            ha.a((Closeable) str2);
            throw th;
        }
    }

    @Override // com.tencent.mapsdk.internal.j2
    public Map<String, Class<? extends k2.a>> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, g3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_INDOOR_DATA, i3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_DATA, k3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_STYLE, m3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_RTT_DATA, p3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_SATELLITE_DATA, q3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_SKETCH_DATA, r3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_OVERSEA_DATA, o3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_STATISTIC, s3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_TRAFFIC_EVENT, t3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_OFFLINE_MAP_DATA, n3.class);
        hashMap.put(TencentMapServiceProtocol.SERVICE_NAME_MAP_POI_DATA, l3.class);
        return hashMap;
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void a(q1 q1Var) {
        super.a(q1Var);
        if (q1Var == null) {
            return;
        }
        TencentMapOptions r = q1Var.r();
        this.e = r;
        a(q1Var, r);
        a(e(), this.e);
        c7.a(g().b());
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void a(q1 q1Var, Bundle bundle) {
        super.a(q1Var, bundle);
        c7.a(g().b());
    }

    public void a(String str, String str2) {
        if (f7.b(str2)) {
            return;
        }
        this.d.put(str, str2);
    }

    public f2 b(q1 q1Var, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(h2.f23814a, "-1");
            String optString2 = jSONObject.optString(h2.b, "_unknown");
            if (!"-1".equals(optString) && optString2.equals(str)) {
                m2 m2Var = new m2();
                m2Var.d(str);
                m2Var.a(this);
                JSONArray optJSONArray = jSONObject.optJSONArray(k2.d);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        m2Var.b(optJSONArray.getJSONObject(i3));
                        i2 = i3 + 1;
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(i2.f23853c);
                if (optJSONObject != null) {
                    m2Var.a(optJSONObject);
                }
                return m2Var;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return j;
    }

    @Override // com.tencent.mapsdk.internal.j2
    public List<Class<? extends p>> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Basic.class);
        arrayList.add(Detail.class);
        arrayList.add(Response.class);
        arrayList.add(RttRequest.class);
        arrayList.add(RttResponse.class);
        arrayList.add(user_login_t.class);
        arrayList.add(CmdResult.class);
        arrayList.add(Header.class);
        arrayList.add(Package.class);
        arrayList.add(Tag.class);
        arrayList.add(CSFileUpdateReq.class);
        arrayList.add(FileUpdateReq.class);
        arrayList.add(FileUpdateRsp.class);
        arrayList.add(SCFileUpdateRsp.class);
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void b(q1 q1Var) {
        f2 f2Var;
        super.b(q1Var);
        Stack<f2> stack = i;
        if (stack.isEmpty() || (f2Var = this.f23965c) == null) {
            return;
        }
        stack.remove(f2Var);
        this.f23965c = null;
    }

    @Override // com.tencent.mapsdk.internal.j2
    public Map<String, String> d() {
        TencentMapOptions tencentMapOptions = this.e;
        if (tencentMapOptions != null) {
            a(f, tencentMapOptions.getCustomUserId());
        }
        a(g, c7.z());
        a(h, g7.b());
        return this.d;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol
    public TencentMapServiceProtocol.IMapService getMapService(String str) {
        k2.a a2;
        f2 h2 = h();
        this.f23965c = h2;
        if (h2 == null || (a2 = h2.a(str)) == null) {
            return null;
        }
        return new a(a2);
    }

    public f2 h() {
        if (this.f23965c == null) {
            Stack<f2> stack = i;
            if (stack.isEmpty()) {
                this.f23965c = j;
            } else {
                this.f23965c = stack.peek();
            }
        }
        return this.f23965c;
    }
}

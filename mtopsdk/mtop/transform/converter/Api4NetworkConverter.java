package mtopsdk.mtop.transform.converter;

import com.anythink.core.common.g.c;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.a.b.b;
import mtopsdk.a.b.d;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopHeaderFieldEnum;
import mtopsdk.mtop.util.MtopStatistics;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/transform/converter/Api4NetworkConverter.class */
public class Api4NetworkConverter extends AbstractNetworkConverter {
    private Map a(Map map, Map map2) {
        HashMap hashMap = map2;
        if (map2 == null) {
            hashMap = new HashMap();
        }
        MtopHeaderFieldEnum[] values = MtopHeaderFieldEnum.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            MtopHeaderFieldEnum mtopHeaderFieldEnum = values[i2];
            String str = (String) map.remove(mtopHeaderFieldEnum.b());
            if (str != null) {
                try {
                    hashMap.put(mtopHeaderFieldEnum.a(), URLEncoder.encode(str, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    TBSdkLog.d("mtopsdk.Api4NetworkConverter", "[prepareRequestHeaders]urlencode " + mtopHeaderFieldEnum.a() + "=" + str + "error");
                }
            }
            i = i2 + 1;
        }
        String str2 = (String) map.remove("lng");
        String str3 = (String) map.remove(c.B);
        if (str2 != null && str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(",");
            sb.append(str3);
            try {
                hashMap.put("x-location", URLEncoder.encode(sb.toString(), "utf-8"));
                return hashMap;
            } catch (UnsupportedEncodingException e2) {
                TBSdkLog.d("mtopsdk.Api4NetworkConverter", "[prepareRequestHeaders]urlencode x-location=" + sb.toString() + "error");
            }
        }
        return hashMap;
    }

    @Override // mtopsdk.mtop.transform.converter.INetworkConverter
    public b a(MtopProxy mtopProxy, Map map) {
        URL a;
        if (mtopProxy.h == null) {
            mtopProxy.h = new MtopStatistics();
        }
        MtopNetworkProp e = mtopProxy.e();
        String g = mtopProxy.h.g();
        mtopsdk.a.b.c cVar = new mtopsdk.a.b.c();
        cVar.b(g);
        cVar.a(e.l);
        cVar.b(e.m);
        cVar.c(e.d);
        MethodEnum methodEnum = e.b;
        Map a2 = a(map, e.e);
        try {
            String str = (String) map.remove("api");
            String str2 = (String) map.remove("v");
            String a3 = a(str, str2, mtopProxy);
            StringBuilder sb = new StringBuilder(64);
            sb.append(mtopProxy.c(a3));
            sb.append(BridgeUtil.SPLIT_MARK);
            sb.append(str);
            sb.append(BridgeUtil.SPLIT_MARK);
            sb.append(str2);
            sb.append(BridgeUtil.SPLIT_MARK);
            if (MethodEnum.POST.a().equals(methodEnum.a())) {
                final byte[] a4 = a(map, "utf-8");
                cVar.a(methodEnum.a(), new d() { // from class: mtopsdk.mtop.transform.converter.Api4NetworkConverter.1
                    @Override // mtopsdk.a.b.d
                    public String a() {
                        return "application/x-www-form-urlencoded;charset=UTF-8";
                    }

                    @Override // mtopsdk.a.b.d
                    public void a(OutputStream outputStream) {
                        byte[] bArr;
                        if (outputStream == null || (bArr = a4) == null) {
                            return;
                        }
                        outputStream.write(bArr);
                    }
                });
                a = NetworkConverterUtils.a(sb.toString(), (Map) null);
            } else {
                a(a2, mtopProxy);
                a = NetworkConverterUtils.a(sb.toString(), map);
            }
            if (a != null) {
                mtopProxy.h.g = a.getHost();
            }
            cVar.a(a.toString());
            cVar.a(a2);
            return cVar.a();
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.Api4NetworkConverter", g, "[Api4NetworkConverter] convert Request failed!", th);
            return null;
        }
    }
}

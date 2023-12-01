package mtopsdk.mtop.transform.converter;

import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.unit.ApiInfo;
import mtopsdk.mtop.unit.ApiUnit;
import mtopsdk.mtop.unit.UserUnit;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/transform/converter/AbstractNetworkConverter.class */
public abstract class AbstractNetworkConverter implements INetworkConverter {
    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, String str2, MtopProxy mtopProxy) {
        UserUnit userUnit;
        ApiUnit l;
        if (!SwitchConfig.a().d() || StringUtils.b(str) || StringUtils.b(str2) || (userUnit = mtopProxy.e.p) == null || !UserUnit.UnitType.UNIT.a().equalsIgnoreCase(userUnit.b.a()) || !StringUtils.a(userUnit.f43778c) || (l = SDKConfig.a().l()) == null || l.b == null || !l.b.contains(new ApiInfo(str, str2))) {
            return null;
        }
        return userUnit.f43778c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Map map, MtopProxy mtopProxy) {
        if (a(mtopProxy)) {
            return;
        }
        map.put("cache-control", "no-cache");
    }

    protected boolean a(MtopProxy mtopProxy) {
        MtopNetworkProp e = mtopProxy.e();
        if (mtopProxy.f() instanceof MtopCallback.MtopCacheListener) {
            return true;
        }
        return e != null && e.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(Map map, String str) {
        if (map == null) {
            return null;
        }
        String str2 = str;
        if (StringUtils.b(str)) {
            str2 = "utf-8";
        }
        String a2 = NetworkConverterUtils.a(map, str2);
        if (a2 != null) {
            try {
                return a2.getBytes(str2);
            } catch (Exception e) {
                TBSdkLog.d("mtopsdk.NetworkConverter", "[createParamPostData]getPostData error");
                return null;
            }
        }
        return null;
    }
}

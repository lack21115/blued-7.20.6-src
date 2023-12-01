package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamicloader.versionstrategy.VersionStrategyFactory;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.ac;
import com.huawei.hms.ads.uiengineloader.ah;
import com.huawei.hms.ads.uiengineloader.q;
import com.huawei.hms.ads.uiengineloader.t;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/g.class */
public final class g extends IDynamicLoader.Stub {
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f22472c = "DynamicLoader";
    private static final String d = "version_strategy_type";

    private static IObjectWrapper a(Context context, Bundle bundle) throws RemoteException {
        String string = bundle.getString("module_name");
        b = bundle.getString("loader_path");
        int i = bundle.getInt("version_strategy_type");
        String string2 = bundle.getString(b.e, b.f);
        aa.b("DynamicLoader", "the moduleName is:" + string + ", versionStrategyType:" + i + " loaderVersionType : " + string2);
        try {
            ah versionPolicy = VersionStrategyFactory.getVersionPolicy(i);
            if (versionPolicy == null) {
                aa.c("DynamicLoader", "Invalid version policy.");
                return ac.a((Object) null);
            }
            q a2 = versionPolicy.a(context, bundle);
            if (a2 != null) {
                t a3 = a2.a(context, string);
                if (a3 != null) {
                    a3.e = string2;
                    return ac.a(a2.a(context, a3));
                }
                throw new RemoteException("Null moduleInfo.");
            }
            throw new RemoteException("Get loading strategy failed.");
        } catch (j e) {
            aa.c("DynamicLoader", "LoaderException:" + e.getMessage());
            Bundle bundle2 = e.f22475a;
            if (bundle2 != null) {
                aa.c("DynamicLoader", "Get bundle from LoaderException.");
                return ac.a(bundle2);
            }
            throw new RemoteException("Load failed:" + e.getMessage());
        } catch (Exception e2) {
            aa.c("DynamicLoader", "Other exception." + e2.getClass().getSimpleName());
            throw new RemoteException("Load dynamic module failed.");
        }
    }

    @Override // com.huawei.hms.ads.dynamic.IDynamicLoader
    public final IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        if (iObjectWrapper == null) {
            aa.c("DynamicLoader", "The context is null.");
            return ac.a((Object) null);
        }
        Context context = (Context) ac.a(iObjectWrapper);
        Object a2 = ac.a(iObjectWrapper2);
        if (!(a2 instanceof Bundle)) {
            aa.c("DynamicLoader", "The moduleInfo type is not Bundle.");
            return ac.a((Object) null);
        }
        Bundle bundle = (Bundle) a2;
        int i2 = bundle.getInt("version_strategy_type", 0);
        aa.b("DynamicLoader", "versionType=".concat(String.valueOf(i2)));
        if (i2 == 0) {
            h.a(context);
            return ac.a(h.a(context, bundle));
        }
        return a(context, bundle);
    }
}

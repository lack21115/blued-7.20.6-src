package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.bw;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bl.class */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9344a = "ContainerFactoryBuilder";
    private static IXAdContainerFactory e;

    /* renamed from: c  reason: collision with root package name */
    private Context f9345c;
    private Class<?> d;
    public double b = 0.1d;
    private bq f = bq.a();

    public bl(Class<?> cls, Context context) {
        this.d = null;
        this.d = cls;
        this.f9345c = context;
    }

    public IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.d.getDeclaredConstructor(Context.class).newInstance(this.f9345c);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.bh.bg, "9.26");
                e.initConfig(jSONObject);
                this.b = e.getRemoteVersion();
                e.onTaskDistribute(az.f9326a, MobadsPermissionSettings.getPermissionInfo());
                e.initCommonModuleObj(q.a());
            } catch (Throwable th) {
                this.f.b(f9344a, th.getMessage());
                throw new bw.a("ContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return e;
    }

    public void b() {
        e = null;
    }
}

package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Loader.class */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Context mContext;
    private final AtomicBoolean Ip;
    private IKsAdSDK ZV;
    private k ZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/Loader$a.class */
    public static final class a {
        private static final Loader ZX = new Loader((byte) 0);
    }

    private Loader() {
        this.ZW = null;
        this.Ip = new AtomicBoolean(false);
    }

    /* synthetic */ Loader(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IKsAdSDK a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                try {
                    Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);
                    if (invoke == null) {
                        throw new RuntimeException("Can not get sdk form " + classLoader);
                    }
                    iKsAdSDK = (IKsAdSDK) invoke;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } finally {
            }
        }
        return iKsAdSDK;
    }

    private boolean as(Context context) {
        String ao = g.ao(context);
        String ap = g.ap(context);
        if (TextUtils.isEmpty(ao) && TextUtils.isEmpty(ap)) {
            return false;
        }
        String str = ao;
        if (!TextUtils.isEmpty(ap)) {
            str = ao;
            if (g.q(ap, ao)) {
                g.h(context, ap);
                r(context, ao);
                g.i(context, "");
                str = ap;
            }
        }
        return !TextUtils.isEmpty(str);
    }

    private static void at(Context context) {
        String aq = g.aq(context);
        boolean b = t.b(context, g.ZA, false);
        if (TextUtils.isEmpty(aq) || !aq.equals("3.3.40") || b) {
            String ao = g.ao(context);
            g.h(context, "");
            g.i(context, "");
            t.a(context, g.ZA, false);
            h.e(h.m(context, ao));
            g.j(context, "3.3.40");
        }
    }

    public static Loader get() {
        return a.ZX;
    }

    private static void r(Context context, String str) {
        h.q(context, str);
    }

    private static void ts() {
        try {
            int tk = com.kwad.sdk.api.c.tk();
            if (tk > 0) {
                d.an(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                Thread.setDefaultUncaughtExceptionHandler(d.an(mContext));
                d.an(mContext).aS(tk);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Context getContext() {
        return mContext;
    }

    public ClassLoader getExternalClassLoader() {
        k kVar = this.ZW;
        if (kVar != null) {
            return kVar.getClassLoader();
        }
        return null;
    }

    public Resources getExternalResource() {
        k kVar = this.ZW;
        if (kVar != null) {
            return kVar.tp();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        k kVar = this.ZW;
        return kVar != null ? kVar.getClassLoader() : getClass().getClassLoader();
    }

    public IKsAdSDK init(Context context, ClassLoader classLoader) {
        if (this.Ip.get()) {
            return this.ZV;
        }
        mContext = context.getApplicationContext();
        at(context);
        if (as(context)) {
            this.ZW = k.a(context, classLoader, g.ao(context));
        }
        k kVar = this.ZW;
        if (kVar == null) {
            IKsAdSDK a2 = a(getClass().getClassLoader());
            this.ZV = a2;
            a2.setIsExternal(false);
        } else {
            IKsAdSDK tq = kVar.tq();
            this.ZV = tq;
            tq.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.ZV);
        if (this.ZW != null) {
            ts();
        }
        this.Ip.set(true);
        return this.ZV;
    }

    public boolean isExternalLoaded() {
        return this.ZW != null;
    }

    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!KsAdSDK.sHasInit.get()) {
            KsAdSDK.init(context, SdkConfig.create(t.getString(context, "sdkconfig")));
        }
        return (T) this.ZV.newComponentProxy(cls, obj);
    }

    public <T> T newInstance(Class<T> cls) {
        if (!KsAdSDK.sHasInit.get()) {
            Context context = mContext;
            Application application = context;
            if (context == null) {
                application = KSLifecycleObserver.getInstance().getApplication();
            }
            KsAdSDK.init(application, SdkConfig.create(t.getString(application, "sdkconfig")));
        }
        return (T) this.ZV.newInstance(cls);
    }

    public void rest() {
        this.Ip.set(false);
        mContext = null;
        this.ZV = null;
        this.ZW = null;
    }
}

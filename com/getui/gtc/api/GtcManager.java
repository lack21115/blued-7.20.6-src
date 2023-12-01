package com.getui.gtc.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.api.GtcIdCallback;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.getui.gtc.base.util.BundleCompat;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.d.a;
import com.getui.gtc.g.b;
import com.getui.gtc.i.c.a;
import java.util.ArrayList;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/api/GtcManager.class */
public class GtcManager implements Subscriber {
    private static String methodName;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/api/GtcManager$InstanceHolder.class */
    static class InstanceHolder {
        private static final GtcManager instance = new GtcManager();

        private InstanceHolder() {
        }
    }

    private GtcManager() {
    }

    private void checkSdkInfo(SdkInfo sdkInfo) {
        if (TextUtils.isEmpty(sdkInfo.getModuleName())) {
            a.c("moduleName not set for sdkinfo");
            throw new RuntimeException("moduleName not set for sdkinfo");
        } else if (TextUtils.isEmpty(sdkInfo.getAppid())) {
            a.c("appid not set for sdkinfo");
            throw new RuntimeException("appid not set for sdkinfo");
        } else if (TextUtils.isEmpty(sdkInfo.getVersion())) {
            a.c("version not set for sdkinfo");
            throw new RuntimeException("version not set for sdkinfo");
        }
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    public static GtcManager getInstance() {
        methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return InstanceHolder.instance;
    }

    public ClassLoader getClassLoader(Bundle bundle) {
        return b.a(bundle);
    }

    @Deprecated
    public void init(Context context, GtcIdCallback.Stub stub) {
        if (CommonUtil.isGtcProcess()) {
            a.C0342a.a().a(stub);
            return;
        }
        GtcProvider.setContext(context);
        Bundle createBundle = createBundle();
        createBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-1-1");
        BundleCompat.putBinder(createBundle, "gtc-1-2", stub);
        Broker.getInstance().subscribe(createBundle);
    }

    public String initialize(Context context, GtcIdCallback.Stub stub) {
        if (CommonUtil.isGtcProcess()) {
            return a.C0342a.a().a(stub);
        }
        GtcProvider.setContext(context);
        Bundle createBundle = createBundle();
        createBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-1-1");
        BundleCompat.putBinder(createBundle, "gtc-1-2", stub);
        return Broker.getInstance().subscribe(createBundle).getString(ProcessSwitchContract.METHOD_RETURN);
    }

    public boolean loadBundle(Context context, Bundle bundle) {
        if (context != null) {
            GtcProvider.setContext(context.getApplicationContext());
        }
        return b.a(context, bundle);
    }

    public void loadSdk(SdkInfo sdkInfo) {
        checkSdkInfo(sdkInfo);
        if (CommonUtil.isGtcProcess()) {
            a.C0342a.a().a(sdkInfo);
            return;
        }
        Bundle createBundle = createBundle();
        createBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-2-1");
        createBundle.putParcelable("gtc-2-2", sdkInfo);
        Bundle subscribe = Broker.getInstance().subscribe(createBundle);
        if (subscribe.get(ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            com.getui.gtc.i.c.a.b((Throwable) subscribe.get(ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(Bundle bundle, Bundle bundle2) {
        ArrayList<Throwable> arrayList = new ArrayList();
        try {
            Throwable th = (Throwable) bundle2.getSerializable(ProcessSwitchContract.METHOD_EXCEPTION);
            if (th != null) {
                arrayList.add(th);
            }
            String string = bundle.getString(ProcessSwitchContract.METHOD_NAME);
            if (TextUtils.isEmpty(string)) {
                throw new RuntimeException("methodName missed");
            }
            boolean z = true;
            int hashCode = string.hashCode();
            if (hashCode != 337397854) {
                if (hashCode != 337398815) {
                    if (hashCode == 337399776 && string.equals("gtc-3-1")) {
                        z = true;
                    }
                } else if (string.equals("gtc-2-1")) {
                    z = true;
                }
            } else if (string.equals("gtc-1-1")) {
                z = false;
            }
            if (!z) {
                bundle2.putString(ProcessSwitchContract.METHOD_RETURN, a.C0342a.a().a(GtcIdCallback.Stub.asInterface(BundleCompat.getBinder(bundle, "gtc-1-2"))));
            } else if (z) {
                a.C0342a.a().a((SdkInfo) bundle.getParcelable("gtc-2-2"));
            } else if (z) {
                bundle.getString("gtc-3-2");
                a.C0342a.a().a(bundle.getIntArray("gtc-3-3"));
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
                for (Throwable th3 : arrayList) {
                    com.getui.gtc.i.c.a.a(th3);
                }
            } finally {
                for (Throwable th4 : arrayList) {
                    com.getui.gtc.i.c.a.a(th4);
                }
            }
        }
    }

    public void removeExt(String str, int[] iArr) {
        if (CommonUtil.isGtcProcess()) {
            a.C0342a.a().a(iArr);
            return;
        }
        Bundle createBundle = createBundle();
        createBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-3-1");
        createBundle.putString("gtc-3-2", str);
        createBundle.putIntArray("gtc-3-3", iArr);
        Bundle subscribe = Broker.getInstance().subscribe(createBundle);
        if (subscribe.get(ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            com.getui.gtc.i.c.a.b((Throwable) subscribe.get(ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }
}

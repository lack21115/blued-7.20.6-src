package com.getui.gtc.base.publish;

import android.net.Uri;
import android.os.Bundle;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import java.lang.reflect.Method;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/publish/Broker.class */
public class Broker {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/publish/Broker$InstanceHolder.class */
    public static class InstanceHolder {
        private static final Broker broker = new Broker();

        private InstanceHolder() {
        }
    }

    private Broker() {
    }

    public static Broker getInstance() {
        return InstanceHolder.broker;
    }

    public Bundle publish(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Subscriber subscriber = null;
        try {
            Method declaredMethod = Class.forName(bundle.getString(ProcessSwitchContract.CLASS_NAME)).getDeclaredMethod(bundle.getString(ProcessSwitchContract.GET_INSTANCE), new Class[0]);
            declaredMethod.setAccessible(true);
            subscriber = (Subscriber) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            bundle2.putSerializable(ProcessSwitchContract.METHOD_EXCEPTION, th);
        }
        if (subscriber != null) {
            subscriber.receive(bundle, bundle2);
        }
        return bundle2;
    }

    public Bundle subscribe(Bundle bundle) {
        if (GtcProvider.context() != null) {
            return GtcProvider.context().getContentResolver().call(Uri.parse("content://" + GtcProvider.context().getPackageName() + ".getui.gtc.provider"), "", "", bundle);
        }
        throw new RuntimeException("if you are running at not gtc Process, you should call \"GtcProvider.setContext(context)\" firstly!");
    }
}

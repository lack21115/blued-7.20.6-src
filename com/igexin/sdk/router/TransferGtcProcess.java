package com.igexin.sdk.router;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.igexin.push.e.h;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/router/TransferGtcProcess.class */
public class TransferGtcProcess implements Subscriber {
    public static final String TYPE145TASK_METHODNAME = "runInGtMainProcess";
    private static String methodName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/router/TransferGtcProcess$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final TransferGtcProcess f23674a = new TransferGtcProcess();

        private a() {
        }
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    public static TransferGtcProcess getInstance() {
        methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return a.f23674a;
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
            if (TYPE145TASK_METHODNAME.equals(string)) {
                Intent intent = (Intent) bundle.getParcelable("intent");
                h unused = h.a.f23635a;
                h.a(GtcProvider.context(), intent);
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
                for (Throwable th3 : arrayList) {
                    com.igexin.c.a.c.a.a(th3);
                }
            } finally {
                for (Throwable th4 : arrayList) {
                    com.igexin.c.a.c.a.a(th4);
                }
            }
        }
    }

    public void transferGtcProcess(Context context, Intent intent, String str) {
        GtcProvider.setContext(context);
        Bundle createBundle = createBundle();
        createBundle.putString(ProcessSwitchContract.METHOD_NAME, str);
        createBundle.putParcelable("intent", intent);
        Broker.getInstance().subscribe(createBundle);
    }
}

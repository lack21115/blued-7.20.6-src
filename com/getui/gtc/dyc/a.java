package com.getui.gtc.dyc;

import android.os.Bundle;
import android.os.RemoteException;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.getui.gtc.base.util.BundleCompat;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dyc.Callback;
import com.getui.gtc.dyc.b.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/a.class */
public class a implements Subscriber {

    /* renamed from: a  reason: collision with root package name */
    private static String f21966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.getui.gtc.dyc.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/a$a.class */
    public static class C0348a {

        /* renamed from: a  reason: collision with root package name */
        private static a f21971a = new a();
    }

    private a() {
    }

    public static a a() {
        f21966a = Thread.currentThread().getStackTrace()[2].getMethodName();
        return C0348a.f21971a;
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, f21966a);
        return bundle;
    }

    public Map<String, String> a(final b bVar) {
        if (CommonUtil.isGtcProcess()) {
            return f.a().a(bVar);
        }
        Bundle d = d();
        d.putString(ProcessSwitchContract.METHOD_NAME, "dyc-1-1");
        d.putParcelable("dyc-1-2", bVar);
        if (bVar.i() != null) {
            BundleCompat.putBinder(d, "dyc-1-3", new Callback.a() { // from class: com.getui.gtc.dyc.a.2
                @Override // com.getui.gtc.dyc.Callback
                public void a(Map map, Map map2) throws RemoteException {
                    bVar.i().a(map, map2);
                }

                @Override // com.getui.gtc.dyc.Callback
                public void b(String str) throws RemoteException {
                    bVar.i().b(str);
                }
            });
        }
        return (Map) Broker.getInstance().subscribe(d).get(ProcessSwitchContract.METHOD_RETURN);
    }

    public Map<String, String> a(String str) {
        if (CommonUtil.isGtcProcess()) {
            return f.a().a(str);
        }
        Bundle d = d();
        d.putString(ProcessSwitchContract.METHOD_NAME, "dyc-2-1");
        d.putString("dyc-2-2", str);
        return (Map) Broker.getInstance().subscribe(d).get(ProcessSwitchContract.METHOD_RETURN);
    }

    public void a(String str, Map<String, String> map) {
        if (CommonUtil.isGtcProcess()) {
            f.a().a(str, map);
            return;
        }
        Bundle d = d();
        d.putString(ProcessSwitchContract.METHOD_NAME, "dyc-4-1");
        d.putString("dyc-4-2", str);
        d.putSerializable("dyc-4-3", (HashMap) map);
        Broker.getInstance().subscribe(d);
    }

    public Map<String, Map<String, String>> c() {
        if (CommonUtil.isGtcProcess()) {
            return f.a().c();
        }
        Bundle d = d();
        d.putString(ProcessSwitchContract.METHOD_NAME, "dyc-3-1");
        return (Map) Broker.getInstance().subscribe(d).get(ProcessSwitchContract.METHOD_RETURN);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0135 A[DONT_GENERATE, LOOP:0: B:49:0x012c->B:51:0x0135, LOOP_END] */
    @Override // com.getui.gtc.base.publish.Subscriber
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void receive(android.os.Bundle r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.dyc.a.receive(android.os.Bundle, android.os.Bundle):void");
    }
}

package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/servermanager/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f21482a = new Object();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f21483c = new Object();
    private static final Map<String, Boolean> d = new ConcurrentHashMap();
    private static final Map<String, d> e = new ConcurrentHashMap();
    private static c f;

    private static IInterface a(String str, final String str2) {
        ProviderInfo providerInfo;
        IBinder iBinder;
        if (Zeus.hasInit()) {
            if (Zeus.getServerManagerHashMap().get(str2) != null) {
                Bundle call = Zeus.getAppApplication().getContentResolver().call(Uri.parse("content://" + providerInfo.authority), "query_binder", str, null);
                if (call != null) {
                    call.setClassLoader(AbsServerManager.class.getClassLoader());
                    a aVar = (a) call.getParcelable("binder");
                    if (aVar != null) {
                        iBinder = aVar.f21481a;
                        if (iBinder == null && iBinder.isBinderAlive()) {
                            try {
                                final IBinder iBinder2 = iBinder;
                                boolean z = false;
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.bytedance.pangle.servermanager.b.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public final void binderDied() {
                                        b.d.put(String.this, Boolean.FALSE);
                                        ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                                        HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinder2);
                                        for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                            Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                                            while (it.hasNext()) {
                                                serviceConnection.onServiceDisconnected(it.next());
                                            }
                                        }
                                    }
                                }, 0);
                                d.put(str2, Boolean.TRUE);
                                int hashCode = str.hashCode();
                                if (hashCode != -807062458) {
                                    if (hashCode == 1984153269 && str.equals("service")) {
                                        z = true;
                                    }
                                    z = true;
                                } else {
                                    if (str.equals("package")) {
                                    }
                                    z = true;
                                }
                                if (z) {
                                    if (!z) {
                                        return null;
                                    }
                                    return d.a.a(iBinder);
                                }
                                return c.a.a(iBinder);
                            } catch (RemoteException e2) {
                                ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e2);
                                return null;
                            }
                        }
                    }
                }
                iBinder = null;
                return iBinder == null ? null : null;
            }
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
    }

    public static c a() {
        Boolean bool = d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f = null;
        }
        if (f == null) {
            synchronized (f21483c) {
                c cVar = (c) a("package", "main");
                if (cVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f = cVar;
            }
        }
        return f;
    }

    public static d a(String str) {
        Boolean bool = d.get(str);
        if (bool == null || !bool.booleanValue()) {
            e.remove(str);
        }
        if (e.get(str) == null) {
            synchronized (b) {
                d dVar = (d) a("service", str);
                if (dVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                e.put(str, dVar);
            }
        }
        return e.get(str);
    }
}

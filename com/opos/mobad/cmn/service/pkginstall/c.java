package com.opos.mobad.cmn.service.pkginstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/pkginstall/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f12246a = new byte[0];
    private static volatile c b;
    private SystemBR g;

    /* renamed from: c  reason: collision with root package name */
    private Map<Integer, a> f12247c = null;
    private Map<Integer, a> d = null;
    private Map<Integer, a> e = null;
    private volatile ExecutorService f = null;
    private boolean h = false;

    private c() {
        b();
    }

    public static c a() {
        c cVar;
        c cVar2 = b;
        if (cVar2 == null) {
            synchronized (f12246a) {
                c cVar3 = b;
                cVar = cVar3;
                if (cVar3 == null) {
                    cVar = new c();
                    b = cVar;
                }
            }
            return cVar;
        }
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<Integer, a> map, Object... objArr) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (a aVar : map.values()) {
                        aVar.a(objArr);
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
            }
        }
    }

    private void b() {
        this.f12247c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    private void c() {
        this.f12247c.clear();
        this.d.clear();
        this.e.clear();
    }

    private void c(Context context) {
        if (context != null) {
            this.g = new SystemBR();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
            intentFilter.addAction(Intent.ACTION_PACKAGE_REPLACED);
            intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            intentFilter.addDataScheme("package");
            context.registerReceiver(this.g, intentFilter);
        }
    }

    private ExecutorService d() {
        ExecutorService executorService;
        ExecutorService executorService2 = this.f;
        if (executorService2 == null) {
            synchronized (f12246a) {
                ExecutorService executorService3 = this.f;
                executorService = executorService3;
                if (executorService3 == null) {
                    executorService = com.opos.cmn.an.i.a.g();
                    this.f = executorService;
                }
            }
            return executorService;
        }
        return executorService2;
    }

    private void d(Context context) {
        SystemBR systemBR;
        if (context == null || (systemBR = this.g) == null) {
            return;
        }
        context.unregisterReceiver(systemBR);
        this.g = null;
    }

    public int a(int i, a aVar) {
        String sb;
        int i2 = -1;
        if (aVar != null) {
            i2 = -1;
            try {
                int hashCode = aVar.hashCode();
                if (i == 0) {
                    this.f12247c.put(Integer.valueOf(hashCode), aVar);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("addISystemBRListener sPkgAddedBRListenerMap.size=");
                    sb2.append(this.f12247c.size());
                    sb = sb2.toString();
                } else if (i == 1) {
                    this.d.put(Integer.valueOf(hashCode), aVar);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("addISystemBRListener sPkgReplacedBRListenerMap.size=");
                    sb3.append(this.d.size());
                    sb = sb3.toString();
                } else if (i != 2) {
                    i2 = hashCode;
                } else {
                    this.e.put(Integer.valueOf(hashCode), aVar);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("addISystemBRListener sPkgRemovedBRListenerMap.size=");
                    sb4.append(this.e.size());
                    sb = sb4.toString();
                }
                i2 = hashCode;
                com.opos.cmn.an.f.a.b("SystemBRMgr", sb);
                i2 = hashCode;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("SystemBRMgr", "addISystemBRListener systemEventId=" + i + ",listenerId=" + i2);
        return i2;
    }

    public void a(int i, int i2) {
        String str;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
        }
        if (i == 0) {
            if (this.f12247c.containsKey(Integer.valueOf(i2))) {
                this.f12247c.remove(Integer.valueOf(i2));
                str = "removeISystemBRListener sPkgAddedBRListenerMap.size=" + this.f12247c.size();
            }
            com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i + ",listenerId=" + i2);
        } else if (i == 1) {
            if (this.d.containsKey(Integer.valueOf(i2))) {
                this.d.remove(Integer.valueOf(i2));
                str = "removeISystemBRListener sPkgReplacedBRListenerMap.size=" + this.d.size();
            }
            com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i + ",listenerId=" + i2);
        } else {
            if (i == 2 && this.e.containsKey(Integer.valueOf(i2))) {
                this.e.remove(Integer.valueOf(i2));
                str = "removeISystemBRListener sPkgRemovedBRListenerMap.size=" + this.e.size();
            }
            com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i + ",listenerId=" + i2);
        }
        com.opos.cmn.an.f.a.b("SystemBRMgr", str);
        com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i + ",listenerId=" + i2);
    }

    public void a(final int i, final Object... objArr) {
        try {
            a(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.c.1
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = i;
                    if (i2 == 0) {
                        c cVar = c.this;
                        cVar.a(cVar.f12247c, objArr);
                    } else if (i2 == 1) {
                        c cVar2 = c.this;
                        cVar2.a(cVar2.d, objArr);
                    } else if (i2 != 2) {
                    } else {
                        c cVar3 = c.this;
                        cVar3.a(cVar3.e, objArr);
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("notifyBRListener systemEventId=");
        sb.append(i);
        sb.append(",objects=");
        if (objArr == null) {
            objArr = com.igexin.push.core.b.l;
        }
        sb.append(objArr);
        com.opos.cmn.an.f.a.b("SystemBRMgr", sb.toString());
    }

    public void a(Context context) {
        synchronized (this) {
            try {
                com.opos.cmn.an.f.a.b("SystemBRMgr", "register mHasRegistered=" + this.h);
                if (context != null && !this.h) {
                    Context applicationContext = context.getApplicationContext();
                    c();
                    c(applicationContext);
                    this.h = true;
                    com.opos.cmn.an.f.a.b("SystemBRMgr", "really register.");
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
            }
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                d().execute(runnable);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "");
            }
        }
    }

    public void b(Context context) {
        synchronized (this) {
            try {
                com.opos.cmn.an.f.a.b("SystemBRMgr", "unregister mHasRegistered=" + this.h);
                if (context != null && this.h) {
                    d(context.getApplicationContext());
                    c();
                    this.h = false;
                    com.opos.cmn.an.f.a.b("SystemBRMgr", "really unregister.");
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e);
            }
        }
    }
}

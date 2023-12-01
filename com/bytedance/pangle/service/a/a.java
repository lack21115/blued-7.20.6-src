package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/service/a/a.class */
public class a extends d.a {
    private static volatile a b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<ComponentName, IBinder> f7882c = new HashMap<>();
    private final HashMap<ComponentName, b> d = new HashMap<>();
    private final C0152a<Intent> e = new C0152a<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f = new HashMap<>();
    private final HashSet<ComponentName> g = new HashSet<>();
    private final HashSet<ComponentName> h = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f7881a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/service/a/a$a.class */
    public final class C0152a<T> extends HashMap<f, T> {
        C0152a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (obj instanceof f) {
                for (f fVar : keySet()) {
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (fVar.a() == ((f) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final T remove(Object obj) {
            f fVar;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<f> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                f next = it.next();
                try {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (next.a() == ((f) obj).a()) {
                    fVar = next;
                    break;
                }
            }
            return (T) super.remove(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/service/a/a$b.class */
    public final class b extends HashSet<f> {
        b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (obj instanceof f) {
                Iterator<f> it = iterator();
                while (it.hasNext()) {
                    try {
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (it.next().a() == ((f) obj).a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            f fVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator<f> it = iterator();
            while (true) {
                fVar = null;
                if (!it.hasNext()) {
                    break;
                }
                fVar = it.next();
                try {
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                if (fVar.a() == ((f) obj).a()) {
                    break;
                }
            }
            return super.remove(fVar);
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Intent intent, f fVar, String str) {
        synchronized (this) {
            ComponentName component = intent.getComponent();
            if (!this.f.containsKey(component)) {
                com.bytedance.pangle.service.a d = d(intent, str);
                if (d == null) {
                    return false;
                }
                this.f.put(component, d);
            }
            com.bytedance.pangle.service.a aVar = this.f.get(component);
            if (!this.f7882c.containsKey(component)) {
                this.f7882c.put(component, aVar.onBind(intent));
            }
            IBinder iBinder = this.f7882c.get(component);
            if (iBinder != null) {
                if (!this.d.containsKey(component)) {
                    b bVar = new b();
                    bVar.add(fVar);
                    this.d.put(component, bVar);
                    this.e.put(fVar, intent);
                    fVar.a(component, iBinder);
                } else if (!this.d.get(component).contains(fVar)) {
                    this.d.get(component).add(fVar);
                    this.e.put(fVar, intent);
                    fVar.a(component, iBinder);
                }
            }
            return true;
        }
    }

    public static a b() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(f fVar) {
        ComponentName next;
        b bVar;
        synchronized (this) {
            Iterator<ComponentName> it = this.d.keySet().iterator();
            do {
                if (!it.hasNext()) {
                    return;
                }
                next = it.next();
                bVar = this.d.get(next);
            } while (!bVar.contains(fVar));
            bVar.remove(fVar);
            Intent remove = this.e.remove(fVar);
            if (bVar.size() == 0) {
                this.d.remove(next);
                com.bytedance.pangle.service.a aVar = this.f.get(next);
                if (aVar != null) {
                    aVar.onUnbind(remove);
                }
            }
            b(next);
        }
    }

    private boolean b(ComponentName componentName) {
        if (!this.g.contains(componentName)) {
            if (this.d.get(componentName) == null) {
                c(componentName);
                return true;
            }
            return false;
        } else if (!this.h.contains(componentName) || this.d.containsKey(componentName)) {
            return false;
        } else {
            c(componentName);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComponentName c(Intent intent, String str) {
        synchronized (this) {
            ComponentName component = intent.getComponent();
            if (!this.f.containsKey(component)) {
                com.bytedance.pangle.service.a d = d(intent, str);
                if (d == null) {
                    return component;
                }
                this.f.put(component, d);
                this.g.add(component);
            }
            com.bytedance.pangle.service.a aVar = this.f.get(component);
            if (aVar != null) {
                aVar.onStartCommand(intent, 0, 0);
            }
            return component;
        }
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.f.remove(componentName);
        this.h.remove(componentName);
        this.f7882c.remove(componentName);
        this.g.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e = e(intent, str);
        if (e != null) {
            e.onCreate();
        }
        return e;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z = Zeus.loadPlugin(str);
        } catch (Exception e) {
            e = e;
            z = false;
        }
        try {
            com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
            aVar.attach(plugin);
            return aVar;
        } catch (Exception e2) {
            e = e2;
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.bytedance.pangle.d
    public final ComponentName a(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(intent, str);
        }
        this.f7881a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.d
    public final void a(final f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(fVar);
        } else {
            this.f7881a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            });
        }
    }

    public final boolean a(ComponentName componentName) {
        synchronized (this) {
            if (this.f.containsKey(componentName)) {
                this.h.add(componentName);
                return b(componentName);
            }
            return false;
        }
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(final Intent intent, final f fVar, final int i, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return a(intent, fVar, str);
        }
        this.f7881a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, fVar, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.d
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f7881a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }
}

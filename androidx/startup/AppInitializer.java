package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:androidx/startup/AppInitializer.class */
public final class AppInitializer {
    private static volatile AppInitializer d;
    private static final Object e = new Object();

    /* renamed from: c  reason: collision with root package name */
    final Context f3334c;
    final Set<Class<? extends Initializer<?>>> b = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f3333a = new HashMap();

    AppInitializer(Context context) {
        this.f3334c = context.getApplicationContext();
    }

    public static AppInitializer getInstance(Context context) {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new AppInitializer(context);
                }
            }
        }
        return d;
    }

    <T> T a(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        Object obj;
        synchronized (e) {
            if (Trace.isEnabled()) {
                Trace.beginSection(cls.getSimpleName());
            }
            if (set.contains(cls)) {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
            if (this.f3333a.containsKey(cls)) {
                obj = this.f3333a.get(cls);
            } else {
                set.add(cls);
                Initializer<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends Initializer<?>>> dependencies = newInstance.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class<? extends Initializer<?>> cls2 : dependencies) {
                        if (!this.f3333a.containsKey(cls2)) {
                            a(cls2, set);
                        }
                    }
                }
                Object create = newInstance.create(this.f3334c);
                set.remove(cls);
                this.f3333a.put(cls, create);
                obj = create;
            }
            Trace.endSection();
        }
        return (T) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        try {
            try {
                Trace.beginSection("Startup");
                Bundle bundle = this.f3334c.getPackageManager().getProviderInfo(new ComponentName(this.f3334c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = this.f3334c.getString(R.string.androidx_startup);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (Initializer.class.isAssignableFrom(cls)) {
                                this.b.add(cls);
                                a(cls, hashSet);
                            }
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException | ClassNotFoundException e2) {
                throw new StartupException(e2);
            }
        } finally {
            Trace.endSection();
        }
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> cls) {
        return (T) a(cls, new HashSet());
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> cls) {
        return this.b.contains(cls);
    }
}

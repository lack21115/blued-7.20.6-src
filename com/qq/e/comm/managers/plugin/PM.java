package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/PM.class */
public class PM {
    private static final Map<Class<?>, String> b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Context f27916c;
    private String d;
    private File e;
    private volatile int f;
    private DexClassLoader g;
    private RandomAccessFile h;
    private FileLock i;
    private boolean j;
    private final f k;
    private volatile POFactory l;
    private int m;
    private Future<Boolean> n;
    private boolean p;
    private String q;

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f27915a = Executors.newSingleThreadExecutor();
    private boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/PM$a.class */
    public class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            if (!PM.this.j) {
                PM pm = PM.this;
                pm.j = pm.tryLockUpdate();
            }
            if (PM.b(PM.this)) {
                PM.c(PM.this);
            }
            PM.this.m = (int) (System.currentTimeMillis() - currentTimeMillis);
            return Boolean.TRUE;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/PM$b.class */
    static final class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.f27916c = context.getApplicationContext();
        this.k = fVar;
        com.qq.e.comm.managers.plugin.b.a(context);
        if (SDKStatus.isNoPlugin) {
            return;
        }
        a();
    }

    private void a() {
        this.o = false;
        SharedPreferences sharedPreferences = this.f27916c.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.p = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
        this.n = this.f27915a.submit(new a());
    }

    private boolean b() {
        if (this.j) {
            try {
                com.qq.e.comm.managers.plugin.b.a(this.f27916c, h.b(this.f27916c), h.d(this.f27916c));
                this.d = Sig.ASSET_PLUGIN_SIG;
                this.e = h.b(this.f27916c);
                this.f = SDKStatus.getBuildInPluginVersion();
                return true;
            } catch (Throwable th) {
                GDTLogger.e("插件初始化失败 ");
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
        if (r4.b() != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean b(com.qq.e.comm.managers.plugin.PM r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L9d
            r0 = 0
            r6 = r0
            r0 = 0
            r5 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L47
            r8 = r0
            r0 = r8
            java.lang.String r1 = "TimeStap_BEFORE_PLUGIN_INIT:"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L47
            r0 = r8
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L47
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L47
            r0 = r8
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L47
            com.qq.e.comm.util.GDTLogger.d(r0)     // Catch: java.lang.Throwable -> L47
            r0 = r4
            boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L3a
            r0 = r4
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L47
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L3c
        L3a:
            r0 = 1
            r5 = r0
        L3c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            goto L60
        L47:
            r4 = move-exception
            java.lang.String r0 = "插件加载出现异常"
            r1 = r4
            com.qq.e.comm.util.GDTLogger.e(r0, r1)     // Catch: java.lang.Throwable -> L78
            r0 = r4
            r1 = r4
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L78
            com.qq.e.comm.managers.plugin.a.a(r0, r1)     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r6
            r5 = r0
        L60:
            r0 = r4
            java.lang.String r1 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            r0 = r5
            return r0
        L78:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "TimeStap_AFTER_PLUGIN_INIT:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r0 = r0.toString()
            com.qq.e.comm.util.GDTLogger.d(r0)
            r0 = r4
            throw r0
        L9d:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b(com.qq.e.comm.managers.plugin.PM):boolean");
    }

    static void c(PM pm) {
        if (pm == null) {
            throw null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("PluginFile:\t");
        File file = pm.e;
        sb.append(file == null ? com.igexin.push.core.b.l : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (SDKStatus.isNoPlugin || pm.d == null || pm.e == null) {
            if (SDKStatus.isNoPlugin) {
                return;
            }
            pm.g = null;
            return;
        }
        try {
            pm.g = new DexClassLoader(pm.e.getAbsolutePath(), h.a(pm.f27916c).getAbsolutePath(), null, pm.getClass().getClassLoader());
            f fVar = pm.k;
            if (fVar != null) {
                fVar.a();
            }
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            f fVar2 = pm.k;
            if (fVar2 != null) {
                fVar2.b();
            }
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean c() {
        if (this.p) {
            return false;
        }
        if (this.j) {
            g gVar = new g(h.c(this.f27916c), h.e(this.f27916c));
            if (gVar.a()) {
                boolean a2 = gVar.a(h.b(this.f27916c), h.d(this.f27916c));
                GDTLogger.d("NextExist,Updated=" + a2);
            }
        }
        g gVar2 = new g(h.b(this.f27916c), h.d(this.f27916c));
        if (gVar2.a()) {
            if (gVar2.b() >= SDKStatus.getBuildInPluginVersion()) {
                this.d = gVar2.c();
                this.f = gVar2.b();
                this.e = h.b(this.f27916c);
                this.q = gVar2.d();
                this.o = true;
                return true;
            }
            GDTLogger.d("last updated plugin version =" + this.f + ";asset plugin version=" + SDKStatus.getBuildInPluginVersion());
            return false;
        }
        return false;
    }

    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.q);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.d);
            jSONObject.put("appId", com.qq.e.comm.managers.b.b().a());
            jSONObject.put("pn", com.qq.e.comm.managers.plugin.b.a(this.f27916c));
            jSONObject.put("ict", this.m);
            jSONObject.put("mup", this.j);
            return jSONObject;
        } catch (JSONException e) {
            return jSONObject;
        }
    }

    public <T> T getFactory(Class<T> cls) throws e {
        Future<Boolean> future = this.n;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        DexClassLoader classLoader = (SDKStatus.isNoPlugin || Sig.ASSET_PLUGIN_SIG == null) ? PM.class.getClassLoader() : this.g;
        StringBuilder sb = new StringBuilder();
        sb.append("PluginClassLoader is parent");
        sb.append(PM.class.getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = b.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(loadClass, this.f27916c, d()));
            GDTLogger.d("ServiceDelegateFactory =" + cast);
            return cast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        if (this.l == null) {
            synchronized (this) {
                if (this.l == null) {
                    try {
                        this.l = (POFactory) getFactory(POFactory.class);
                    } catch (e e) {
                        if (!this.o) {
                            throw e;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.p = true;
                        a();
                        this.l = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        return this.l;
    }

    public int getPluginVersion() {
        if (SDKStatus.isNoPlugin) {
            return 1381;
        }
        Future<Boolean> future = this.n;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        return this.f;
    }

    public boolean tryLockUpdate() {
        boolean z = false;
        try {
            File f = h.f(this.f27916c);
            if (!f.exists()) {
                f.createNewFile();
                h.a("lock", f);
            }
            if (f.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(f, "rw");
                this.h = randomAccessFile;
                FileLock tryLock = randomAccessFile.getChannel().tryLock();
                this.i = tryLock;
                if (tryLock != null) {
                    this.h.writeByte(37);
                    z = true;
                }
                return z;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}

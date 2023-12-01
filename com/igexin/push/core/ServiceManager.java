package com.igexin.push.core;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Pair;
import com.getui.gtc.base.GtcProvider;
import com.huawei.openalliance.ad.constant.bc;
import com.igexin.push.f.h;
import com.igexin.push.f.o;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.IPushCore;
import com.igexin.sdk.PushService;
import com.igexin.sdk.main.PushCoreLoader;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/ServiceManager.class */
public class ServiceManager {
    public static Context b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f9773c = "ServiceManager";

    /* renamed from: a  reason: collision with root package name */
    public IPushCore f9774a;
    private final AtomicBoolean d;
    private String e;
    private Class f;
    private Class g;
    private final ServiceConnection h;
    public Pair<Integer, String> initType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/ServiceManager$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ServiceManager f9785a = new ServiceManager((byte) 0);

        private a() {
        }
    }

    private ServiceManager() {
        this.d = new AtomicBoolean(false);
        this.h = new ServiceConnection() { // from class: com.igexin.push.core.ServiceManager.6
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
            }
        };
    }

    /* synthetic */ ServiceManager(byte b2) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Intent intent, int i, int i2) {
        if (this.f9774a != null) {
            com.igexin.c.a.c.a.a("ServiceManager|inInit = true, call onServiceStartCommand...", new Object[0]);
            return this.f9774a.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    public static void a() {
        com.igexin.c.a.c.a.a("ServiceManager|onLowMemory...", new Object[0]);
    }

    private void a(final Service service) {
        com.igexin.c.a.c.a.a("ServiceManager|startGTCore ++++", new Object[0]);
        if (!com.igexin.push.f.g.a()) {
            com.igexin.b.a.a().f9586a.execute(new h.AnonymousClass1(service, new h.a() { // from class: com.igexin.push.core.ServiceManager.2
                @Override // com.igexin.push.f.h.a
                public final void a(boolean z) {
                    com.igexin.c.a.c.a.a(ServiceManager.f9773c, "load encrypt error, report bi result = " + z + " ###########");
                    com.igexin.c.a.c.a.a("ServiceManager|load encrypt error, report bi result = " + z + " ###########", new Object[0]);
                    service.stopSelf();
                }
            }));
            return;
        }
        PushCoreLoader.getInstance().init(service);
        this.f9774a = PushCoreLoader.getInstance().getPushCore();
        if (PushCoreLoader.getInstance().getGtcCore() != null) {
            PushCoreLoader.getInstance().getGtcCore().start(service);
        }
        IPushCore iPushCore = this.f9774a;
        if (iPushCore != null) {
            iPushCore.start(service);
        }
    }

    public static void a(Context context) {
        b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Service service) {
        com.igexin.c.a.c.a.a("ServiceManager|start by system ####", new Object[0]);
        if (!f(service)) {
            service.stopSelf();
            return 2;
        }
        com.igexin.c.a.c.a.a("ServiceManager|intent = null", new Object[0]);
        if (this.d.getAndSet(true)) {
            return 2;
        }
        a(service);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Service service, Intent intent, int i, int i2) {
        com.igexin.c.a.c.a.a("ServiceManager|start from initialize...", new Object[0]);
        com.igexin.c.a.c.a.d.a().a("[ServiceManager] ServiceManager start from initialize...");
        a(service);
        IPushCore iPushCore = this.f9774a;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private void b() {
        com.igexin.c.a.c.a.a("ServiceManager|onDestroy...", new Object[0]);
        IPushCore iPushCore = this.f9774a;
        if (iPushCore != null) {
            iPushCore.onServiceDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(Service service, Intent intent, int i, int i2) {
        if (!f(service)) {
            this.d.set(false);
            service.stopSelf();
            return 2;
        }
        a(service);
        IPushCore iPushCore = this.f9774a;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private boolean c(final Context context, final Intent intent) {
        com.igexin.b.a.a().a("pushservice").execute(new Runnable() { // from class: com.igexin.push.core.ServiceManager.5
            private void a() {
                try {
                    com.igexin.c.a.c.a.a("ServiceManager|startPService by bind", new Object[0]);
                    Intent intent2 = intent;
                    intent2.setType("PB-" + System.nanoTime());
                    intent.setClass(context, ServiceManager.this.b(context));
                    context.getApplicationContext().bindService(intent, ServiceManager.this.h, 1);
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.b(ServiceManager.f9773c, "startPService exception = " + th.toString());
                    com.igexin.c.a.c.a.a(th);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (Build.VERSION.SDK_INT < 26 || !com.igexin.push.f.c.g()) {
                        context.getApplicationContext().startService(intent);
                    } else {
                        a();
                    }
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.b(ServiceManager.f9773c, "startPService exception = " + th.toString());
                    com.igexin.c.a.c.a.a(th);
                    if (th instanceof IllegalStateException) {
                        a();
                    }
                }
            }
        });
        return true;
    }

    public static String d(Context context) {
        return (String) o.b(context, "ua", "");
    }

    public static String e(Context context) {
        return (String) o.b(context, o.f10055a, "");
    }

    private static boolean f(Context context) {
        return !com.igexin.push.f.j.a(context);
    }

    public static ServiceManager getInstance() {
        return a.f9785a;
    }

    public final int a(final Service service, final Intent intent, final int i, final int i2) {
        final Context applicationContext = service.getApplicationContext();
        try {
            com.igexin.b.a.a().a("pushservice").execute(new Runnable() { // from class: com.igexin.push.core.ServiceManager.1
                /* JADX WARN: Removed duplicated region for block: B:24:0x00db A[Catch: all -> 0x01ce, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x011f A[Catch: all -> 0x01ce, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:46:0x0170 A[Catch: all -> 0x01ce, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:52:0x01a4 A[Catch: all -> 0x01ce, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:60:0x01df A[Catch: all -> 0x02e7, TRY_ENTER, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:65:0x023a A[Catch: all -> 0x02e7, TRY_ENTER, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:69:0x025b A[Catch: all -> 0x02e7, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:71:0x0270 A[Catch: all -> 0x02e7, TRY_ENTER, TryCatch #1 {all -> 0x02e7, blocks: (B:2:0x0000, B:4:0x0039, B:6:0x0055, B:58:0x01d4, B:60:0x01df, B:62:0x01ea, B:64:0x01f2, B:67:0x0244, B:69:0x025b, B:71:0x0270, B:73:0x027a, B:76:0x02d4, B:74:0x02a4, B:65:0x023a, B:8:0x0063, B:20:0x00a7, B:22:0x00d3, B:24:0x00db, B:26:0x00f0, B:28:0x00fa, B:30:0x0101, B:31:0x010d, B:33:0x0117, B:35:0x011f, B:37:0x0141, B:39:0x014b, B:41:0x0152, B:42:0x015e, B:44:0x0168, B:46:0x0170, B:48:0x0192, B:50:0x019c, B:52:0x01a4, B:54:0x01c3), top: B:81:0x0000 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        Method dump skipped, instructions count: 749
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.ServiceManager.AnonymousClass1.run():void");
                }
            });
            return 2;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return 2;
        }
    }

    public final IBinder a(Service service, Intent intent) {
        com.igexin.c.a.c.a.a("ServiceManager|onBind...", new Object[0]);
        a(service, intent, 0, 0);
        IPushCore iPushCore = this.f9774a;
        if (iPushCore != null) {
            return iPushCore.onServiceBind(intent);
        }
        return null;
    }

    public final void a(final Activity activity) {
        try {
            Context applicationContext = activity.getApplicationContext();
            b = applicationContext;
            GtcProvider.setContext(applicationContext);
            final Intent intent = activity.getIntent();
            com.igexin.b.a.a().f9586a.execute(new Runnable() { // from class: com.igexin.push.core.ServiceManager.3
                @Override // java.lang.Runnable
                public final void run() {
                    Bundle extras;
                    IBinder binder;
                    try {
                        if (!com.igexin.push.f.j.a(ServiceManager.b)) {
                            if (intent != null && intent.getExtras() != null && (binder = (extras = intent.getExtras()).getBinder(bc.e.D)) != null) {
                                new com.igexin.a.b(binder).a(new Bundle());
                                extras.remove(bc.e.D);
                            }
                            Activity activity2 = activity;
                            com.igexin.push.core.a.b.d();
                            Intent intent2 = new Intent(activity2, com.igexin.push.core.a.b.a((Context) activity));
                            try {
                                if (intent != null && intent.hasExtra("action") && intent.hasExtra("isSlave")) {
                                    intent2.putExtra("action", intent.getStringExtra("action"));
                                    intent2.putExtra("isSlave", intent.getBooleanExtra("isSlave", false));
                                    if (intent.hasExtra("op_app")) {
                                        intent2.putExtra("op_app", intent.getStringExtra("op_app"));
                                    }
                                }
                                if (intent != null && intent.hasExtra("pkg")) {
                                    intent2.putExtra("pkg", intent.getStringExtra("pkg"));
                                }
                            } catch (Exception e) {
                            }
                            ServiceManager.this.b(activity, intent2);
                            com.igexin.c.a.c.a.a("ServiceManager|start PushService from da", new Object[0]);
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            activity.finish();
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final void a(final Context context, final Intent intent) {
        try {
            Context applicationContext = context.getApplicationContext();
            b = applicationContext;
            GtcProvider.setContext(applicationContext);
            com.igexin.b.a.a().f9586a.execute(new Runnable() { // from class: com.igexin.push.core.ServiceManager.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.igexin.push.f.j.a(ServiceManager.b)) {
                        return;
                    }
                    Intent intent2 = intent;
                    if (intent2 != null && intent2.getExtras() != null) {
                        try {
                            Bundle extras = intent.getExtras();
                            IBinder binder = extras.getBinder(bc.e.D);
                            if (binder != null) {
                                new com.igexin.a.b(binder).a(new Bundle());
                                extras.remove(bc.e.D);
                            }
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                    Context context2 = context;
                    com.igexin.push.core.a.b.d();
                    Intent intent3 = new Intent(context2, com.igexin.push.core.a.b.a(context));
                    try {
                        if (intent != null && intent.hasExtra("action") && intent.hasExtra("isSlave")) {
                            intent3.putExtra("action", intent.getStringExtra("action"));
                            intent3.putExtra("isSlave", intent.getBooleanExtra("isSlave", false));
                            if (intent.hasExtra("op_app")) {
                                intent3.putExtra("op_app", intent.getStringExtra("op_app"));
                            }
                        }
                        if (intent != null && intent.hasExtra("pkg")) {
                            intent3.putExtra("pkg", intent.getStringExtra("pkg"));
                        }
                    } catch (Exception e) {
                    }
                    ServiceManager.this.b(context, intent3);
                    com.igexin.c.a.c.a.a("ServiceManager|start PushService from da", new Object[0]);
                }
            });
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final Class b(Context context) {
        ComponentName componentName;
        try {
            if (this.g == null) {
                Class cls = com.igexin.push.f.d.a(context, PushService.class).second;
                this.g = cls;
                if (cls == null) {
                    String str = (String) o.b(context, o.b, "");
                    if (!TextUtils.isEmpty(str)) {
                        this.g = Class.forName(str);
                    }
                }
                if (this.g == null) {
                    this.g = PushService.class;
                }
            }
            componentName = new ComponentName(context, this.g);
        } catch (Throwable th) {
            try {
                this.g = PushService.class;
                com.igexin.c.a.c.a.a(th);
                componentName = new ComponentName(context, this.g);
            } catch (Throwable th2) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, this.g), 1, 1);
                throw th2;
            }
        }
        context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        return this.g;
    }

    public final boolean b(Context context, Intent intent) {
        return c(context.getApplicationContext(), intent);
    }

    public final Class c(Context context) {
        Class cls = this.f;
        if (cls != null) {
            return cls;
        }
        Class cls2 = com.igexin.push.f.d.a(context, GTIntentService.class).second;
        this.f = cls2;
        if (cls2 != null) {
            return cls2;
        }
        try {
            String str = (String) o.b(context, o.f10056c, "");
            if (!TextUtils.isEmpty(str)) {
                Class<?> cls3 = Class.forName(str);
                this.f = cls3;
                return cls3;
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return this.f;
    }
}

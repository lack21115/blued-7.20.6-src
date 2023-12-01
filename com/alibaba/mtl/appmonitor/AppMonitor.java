package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.IMonitor;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor.class */
public final class AppMonitor {
    public static final String TAG = "AppMonitor";

    /* renamed from: a  reason: collision with root package name */
    private static Application f4429a;

    /* renamed from: a  reason: collision with other field name */
    private static ServiceConnection f0a;

    /* renamed from: a  reason: collision with other field name */
    private static HandlerThread f1a;

    /* renamed from: a  reason: collision with other field name */
    private static c f3a;

    /* renamed from: a  reason: collision with other field name */
    protected static IMonitor f4a;

    /* renamed from: a  reason: collision with other field name */
    private static String f6a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f8a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f4430c;

    /* renamed from: c  reason: collision with other field name */
    private static boolean f10c;
    private static String d;
    private static Context mContext;

    /* renamed from: a  reason: collision with other field name */
    private static Object f5a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f7a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b  reason: collision with other field name */
    private static boolean f9b = false;

    /* renamed from: a  reason: collision with other field name */
    private static b f2a = b.Local;

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$Alarm.class */
    public static class Alarm {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f4a == null) {
                return false;
            }
            try {
                return AppMonitor.f4a.alarm_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.alarm_commitFail1(String.this, str2, str3, str4);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4, final String str5) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.alarm_commitFail2(String.this, str2, str3, str4, str5);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.alarm_commitSuccess1(String.this, str2);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2, final String str3) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.alarm_commitSuccess2(String.this, str2, str3);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.alarm_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.alarm_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$Counter.class */
    public static class Counter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f4a == null) {
                return false;
            }
            try {
                return AppMonitor.f4a.counter_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.counter_commit1(String.this, str2, d);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final String str3, final double d) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.counter_commit2(String.this, str2, str3, d);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.counter_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.counter_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$OffLineCounter.class */
    public static class OffLineCounter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f4a == null) {
                return false;
            }
            try {
                return AppMonitor.f4a.offlinecounter_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.offlinecounter_commit(String.this, str2, d);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.offlinecounter_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.OffLineCounter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.offlinecounter_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$Stat.class */
    public static class Stat {
        public static void begin(final String str, final String str2, final String str3) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.stat_begin(String.this, str2, str3);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static boolean checkSampled(String str, String str2) {
            if (AppMonitor.f4a == null) {
                return false;
            }
            try {
                return AppMonitor.f4a.stat_checkSampled(str, str2);
            } catch (RemoteException e) {
                AppMonitor.a(e);
                return false;
            }
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, (DimensionValueSet) null, d);
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final double d) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.stat_commit2(String.this, str2, dimensionValueSet, d);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final MeasureValueSet measureValueSet) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.stat_commit3(String.this, str2, dimensionValueSet, measureValueSet);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            DimensionValueSet dimensionValueSet;
            MeasureValueSet measureValueSet;
            i.a(AppMonitor.TAG, "[commit from jni]");
            if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
                DimensionValueSet create = DimensionValueSet.create();
                int i = 0;
                while (true) {
                    int i2 = i;
                    dimensionValueSet = create;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    create.setValue(strArr[i2], strArr2[i2]);
                    i = i2 + 1;
                }
            } else {
                dimensionValueSet = null;
            }
            if (strArr3 != null && strArr4 != null && strArr3.length == strArr4.length) {
                MeasureValueSet create2 = MeasureValueSet.create();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    measureValueSet = create2;
                    if (i4 >= strArr4.length) {
                        break;
                    }
                    double d = 0.0d;
                    if (!TextUtils.isEmpty(strArr4[i4])) {
                        try {
                            d = Double.valueOf(strArr4[i4]).doubleValue();
                        } catch (Exception e) {
                            i.a(AppMonitor.TAG, "measure's value cannot convert to double. measurevalue:" + strArr4[i4]);
                            d = 0.0d;
                        }
                    }
                    create2.setValue(strArr3[i4], d);
                    i3 = i4 + 1;
                }
            } else {
                i.a(AppMonitor.TAG, "measure is null ,or lenght not match");
                measureValueSet = null;
            }
            commit(str, str2, dimensionValueSet, measureValueSet);
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(f.STAT.m2139a()), str, str2, dimensionValueSet);
        }

        public static void end(final String str, final String str2, final String str3) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.stat_end(String.this, str2, str3);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.stat_setSampling(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.m2126c()) {
                AppMonitor.f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AppMonitor.f4a.stat_setStatisticsInterval(i);
                        } catch (RemoteException e) {
                            AppMonitor.a(e);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$a.class */
    public static class a {
        public DimensionSet b;

        /* renamed from: b  reason: collision with other field name */
        public MeasureSet f14b;
        public boolean g;
        public String o;
        public String p;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$b.class */
    public enum b {
        Local,
        Service
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitor$c.class */
    public static class c extends Handler {
        private boolean h;

        public c(Looper looper) {
            super(looper);
            this.h = false;
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = runnable;
                sendMessage(obtain);
            } catch (Throwable th) {
            }
        }

        public void a(boolean z) {
            this.h = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.h) {
                    this.h = false;
                    synchronized (AppMonitor.f5a) {
                        try {
                            AppMonitor.f5a.wait(5000L);
                        } catch (InterruptedException e) {
                            AppMonitor.b();
                        }
                    }
                }
                if (message.obj != null && (message.obj instanceof Runnable)) {
                    ((Runnable) message.obj).run();
                }
            } catch (Throwable th) {
            }
            super.handleMessage(message);
        }
    }

    static {
        try {
            System.loadLibrary("ut_c_api");
            Log.i(TAG, "load ut_c_api.so success");
        } catch (Throwable th) {
            Log.w(TAG, "load ut_c_api.so failed");
        }
        f0a = new ServiceConnection() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.5
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (b.Service == AppMonitor.f2a) {
                    AppMonitor.f4a = IMonitor.Stub.asInterface(iBinder);
                    if (AppMonitor.f9b && AppMonitor.f3a != null) {
                        AppMonitor.f3a.postAtFrontOfQueue(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppMonitor.m2122a();
                            }
                        });
                    }
                }
                synchronized (AppMonitor.f5a) {
                    AppMonitor.f5a.notifyAll();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                i.a(AppMonitor.TAG, "[onServiceDisconnected]");
                synchronized (AppMonitor.f5a) {
                    AppMonitor.f5a.notifyAll();
                }
                boolean unused = AppMonitor.f9b = true;
            }
        };
    }

    private static int a(f fVar) {
        return fVar.m2139a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private static Runnable m2121a() {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f4a.init();
                } catch (RemoteException e) {
                    AppMonitor.b();
                    try {
                        AppMonitor.f4a.init();
                    } catch (Throwable th) {
                    }
                }
            }
        };
    }

    private static Runnable a(final String str) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f4a.setChannel(String.this);
                } catch (Throwable th) {
                }
            }
        };
    }

    private static Runnable a(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    i.a(AppMonitor.TAG, "register stat event. module: ", String.this, " monitorPoint: ", str2);
                    AppMonitor.f4a.register4(String.this, str2, measureSet, dimensionSet, z);
                } catch (RemoteException e) {
                    AppMonitor.a(e);
                }
            }
        };
    }

    private static Runnable a(final boolean z, final String str, final String str2, final String str3) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppMonitor.f4a.setRequestAuthInfo(z, str, str2, str3);
                } catch (Throwable th) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a  reason: collision with other method in class */
    public static void m2122a() {
        synchronized (AppMonitor.class) {
            try {
                i.a(TAG, "[restart]");
                try {
                    if (f9b) {
                        f9b = false;
                        b();
                        m2121a().run();
                        a(f10c, b, f4430c, d).run();
                        a(f6a).run();
                        synchronized (f7a) {
                            for (int i = 0; i < f7a.size(); i++) {
                                a aVar = f7a.get(i);
                                if (aVar != null) {
                                    try {
                                        a(aVar.o, aVar.p, aVar.f14b, aVar.b, aVar.g).run();
                                    } catch (Throwable th) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Exception exc) {
        i.a(TAG, "", exc);
        if (exc instanceof DeadObjectException) {
            m2122a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m2123a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            a aVar = new a();
            aVar.o = str;
            aVar.p = str2;
            aVar.f14b = measureSet;
            aVar.b = dimensionSet;
            aVar.g = z;
            f7a.add(aVar);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2124a() {
        Application application = f4429a;
        if (application == null) {
            return false;
        }
        boolean bindService = application.getApplicationContext().bindService(new Intent(f4429a.getApplicationContext(), AppMonitorService.class), f0a, 1);
        if (!bindService) {
            b();
        }
        i.a(TAG, "bindsuccess:", Boolean.valueOf(bindService));
        return bindService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        f4a = new Monitor(f4429a);
        f2a = b.Local;
        i.a(TAG, "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m2125b() {
        if (!f8a) {
            i.a(TAG, "Please call init() before call other method");
        }
        return f8a;
    }

    /* renamed from: c  reason: collision with other method in class */
    static /* synthetic */ boolean m2126c() {
        return m2125b();
    }

    @Deprecated
    public static void destroy() {
        synchronized (AppMonitor.class) {
            try {
                if (m2125b()) {
                    f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AppMonitor.f4a.destroy();
                            } catch (RemoteException e) {
                                AppMonitor.a(e);
                            }
                        }
                    });
                }
            } finally {
            }
        }
    }

    public static void enableLog(final boolean z) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.enableLog(z);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void init(Application application) {
        synchronized (AppMonitor.class) {
            try {
                i.a(TAG, "[init]");
                try {
                    if (!f8a) {
                        f4429a = application;
                        if (application != null) {
                            mContext = application.getApplicationContext();
                        }
                        HandlerThread handlerThread = new HandlerThread("AppMonitor_Client");
                        f1a = handlerThread;
                        handlerThread.start();
                        f3a = new c(f1a.getLooper());
                        if (f2a == b.Local) {
                            b();
                        } else if (m2124a()) {
                            f3a.a(true);
                        }
                        m2121a().run();
                        f8a = true;
                    }
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.register1(String.this, str2, measureSet);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
            m2123a(str, str2, measureSet, (DimensionSet) null, false);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.16
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        i.a(AppMonitor.TAG, "[register]:", AppMonitor.f4a);
                        AppMonitor.f4a.register3(String.this, str2, measureSet, dimensionSet);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
            m2123a(str, str2, measureSet, dimensionSet, false);
        }
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        if (m2125b()) {
            registerInternal(str, str2, measureSet, dimensionSet, z, false);
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final boolean z) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.15
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.register2(String.this, str2, measureSet, z);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
            m2123a(str, str2, measureSet, (DimensionSet) null, z);
        }
    }

    public static void register(String str, String str2, String[] strArr, String[] strArr2, boolean z) {
        String str3 = com.igexin.push.core.b.l;
        String jSONArray = strArr == null ? com.igexin.push.core.b.l : new JSONArray((Collection) Arrays.asList(strArr)).toString();
        if (strArr2 != null) {
            str3 = new JSONArray((Collection) Arrays.asList(strArr2)).toString();
        }
        i.a(TAG, "[register]", "module:", str, "measures:", jSONArray, "dimensions:", str3, "isCommitDetail:", Boolean.valueOf(z));
        if (strArr == null) {
            i.a(TAG, "register failed:no mearsure");
            return;
        }
        MeasureSet create = MeasureSet.create();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                break;
            }
            create.addMeasure(strArr[i2]);
            i = i2 + 1;
        }
        DimensionSet dimensionSet = null;
        if (strArr2 != null) {
            DimensionSet create2 = DimensionSet.create();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                dimensionSet = create2;
                if (i4 >= strArr2.length) {
                    break;
                }
                create2.addDimension(strArr2[i4]);
                i3 = i4 + 1;
            }
        }
        register(str, str2, create, dimensionSet, z);
    }

    public static void registerInternal(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z, boolean z2) {
        if (m2125b()) {
            i.a(TAG, "[registerInternal] : module:", str, "monitorPoint:", str2, "measures:", measureSet, "dimensions:", dimensionSet, "isCommitDetail:", Boolean.valueOf(z), "isInternal:", Boolean.valueOf(z2));
            if (!z2) {
                m2123a(str, str2, measureSet, dimensionSet, z);
            }
            f3a.a(a(str, str2, measureSet, dimensionSet, z));
        }
    }

    public static void setChannel(String str) {
        if (m2125b()) {
            f3a.a(a(str));
            f6a = str;
        }
    }

    public static void setRequestAuthInfo(boolean z, String str, String str2, String str3) {
        if (m2125b()) {
            f3a.a(a(z, str, str2, str3));
            f10c = z;
            b = str;
            f4430c = str2;
            d = str3;
        }
    }

    public static void setSampling(final int i) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.setSampling(i);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void setStatisticsInterval(final int i) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.setStatisticsInterval1(i);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void setStatisticsInterval(f fVar, final int i) {
        if (m2125b()) {
            final int a2 = a(fVar);
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.setStatisticsInterval2(a2, i);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    @Deprecated
    public static void triggerUpload() {
        synchronized (AppMonitor.class) {
            try {
                if (f8a) {
                    f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.10
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                AppMonitor.f4a.triggerUpload();
                            } catch (RemoteException e) {
                                AppMonitor.a(e);
                            }
                        }
                    });
                }
            } finally {
            }
        }
    }

    public static void turnOffRealTimeDebug() {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.turnOffRealTimeDebug();
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void turnOnRealTimeDebug(final Map<String, String> map) {
        if (m2125b()) {
            f3a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.turnOnRealTimeDebug(Map.this);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }

    public static void updateMeasure(final String str, final String str2, final String str3, final double d2, final double d3, final double d4) {
        i.a(TAG, "[updateMeasure]");
        if (m2125b()) {
            f3a.post(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.17
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AppMonitor.f4a.updateMeasure(String.this, str2, str3, d2, d3, d4);
                    } catch (RemoteException e) {
                        AppMonitor.a(e);
                    }
                }
            });
        }
    }
}

package com.blued.android.framework.init;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.statistics.BluedStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/init/InitTaskManager.class */
public class InitTaskManager {

    /* renamed from: a  reason: collision with root package name */
    private static InitTaskManager f9808a;
    private static Status b = Status.NULL;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<OnResultListener> f9809c = new ArrayList<>();
    private HandlerThread d = null;
    private Handler e = null;
    private OnTaskListBuilder f = null;
    private ArrayList<InitTask> g = new ArrayList<>();
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private long l = 0;
    private long m = 0;
    private JSONObject n = new JSONObject();
    private ConcurrentHashMap<String, Object> o = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/init/InitTaskManager$Model.class */
    public enum Model {
        NOTHING,
        ASYNC,
        SYNC
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/init/InitTaskManager$OnResultListener.class */
    public interface OnResultListener {
        void a();
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/init/InitTaskManager$OnTaskListBuilder.class */
    public interface OnTaskListBuilder {
        void onBuild(Application application, ArrayList<InitTask> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/init/InitTaskManager$Status.class */
    public enum Status {
        NULL,
        RUNNING,
        FINISHED
    }

    private InitTaskManager() {
    }

    private Model a(Application application, String[] strArr) {
        String str;
        ActivityManager.RecentTaskInfo taskInfo;
        ComponentName componentName;
        a("getInitModel");
        try {
            String packageName = application.getPackageName();
            ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
            String str2 = "";
            if (Build.VERSION.SDK_INT >= 23) {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                a("new way appTasks: " + appTasks);
                str2 = "";
                if (appTasks != null) {
                    str2 = "";
                    if (!appTasks.isEmpty()) {
                        Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                        while (true) {
                            str2 = "";
                            if (!it.hasNext()) {
                                break;
                            }
                            ActivityManager.AppTask next = it.next();
                            if (next != null && (taskInfo = next.getTaskInfo()) != null && (componentName = taskInfo.topActivity) != null && packageName.equals(componentName.getPackageName())) {
                                str2 = componentName.getClassName();
                                a("new way targetActivityClsName: " + str2);
                                break;
                            }
                        }
                    }
                }
            }
            str = str2;
            if (TextUtils.isEmpty(str2)) {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                str = str2;
                if (runningTasks != null) {
                    str = str2;
                    if (!runningTasks.isEmpty()) {
                        Iterator<ActivityManager.RunningTaskInfo> it2 = runningTasks.iterator();
                        while (true) {
                            str = str2;
                            if (!it2.hasNext()) {
                                break;
                            }
                            ComponentName componentName2 = it2.next().topActivity;
                            if (packageName.equals(componentName2.getPackageName())) {
                                str = componentName2.getClassName();
                                a("old way targetActivityClsName: " + str);
                                break;
                            }
                        }
                    }
                }
            }
            a("targetActivity: " + str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            a("return async");
            return Model.ASYNC;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            } else if (str.equals(strArr[i2])) {
                a("return donot");
                return Model.NOTHING;
            } else {
                i = i2 + 1;
            }
        }
        a("return sync");
        return Model.SYNC;
    }

    public static InitTaskManager a() {
        if (f9808a == null) {
            synchronized (InitTaskManager.class) {
                try {
                    if (f9808a == null) {
                        if (AppInfo.m()) {
                            Log.i("InitTaskManager", " >>> new InitTaskManager <<< ");
                        }
                        f9808a = new InitTaskManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9808a;
    }

    private void a(Application application) {
        a("initSync");
        if (this.f == null || b()) {
            return;
        }
        a("do initSync start");
        if (b(application)) {
            d();
        }
        b = Status.FINISHED;
        g();
        a("do initSync end");
    }

    private void a(final InitTask initTask) {
        Handler handler = this.e;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.blued.android.framework.init.InitTaskManager.2
            @Override // java.lang.Runnable
            public void run() {
                InitTaskManager initTaskManager = InitTaskManager.this;
                initTaskManager.a("  run task in thread: " + initTask.a());
                initTask.b();
                InitTaskManager initTaskManager2 = InitTaskManager.this;
                initTaskManager2.a("  finish task in thread: " + initTask.a());
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.init.InitTaskManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InitTaskManager.this.a(initTask.e()) || !initTask.c()) {
                            return;
                        }
                        InitTaskManager.this.f();
                    }
                });
            }
        });
        this.h++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z) {
        if (z) {
            this.k--;
        }
        this.j++;
        a("-- MFA: " + this.h + ", " + this.i + ", " + this.k + ", " + this.j);
        if (this.k == 0) {
            e();
            b = Status.FINISHED;
            this.k = -1;
        }
        if (this.j >= this.i) {
            if (b != Status.FINISHED) {
                e();
                b = Status.FINISHED;
            }
            BluedStatistics.b().a(this.l);
            if (this.l > 500) {
                BluedStatistics.c().b("INIT_TASK_TIMES", this.l, 0, this.n.toString());
            }
            g();
            return true;
        }
        return false;
    }

    static /* synthetic */ long b(InitTaskManager initTaskManager, long j) {
        long j2 = initTaskManager.l + j;
        initTaskManager.l = j2;
        return j2;
    }

    private void b(final InitTask initTask) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.framework.init.InitTaskManager.3
            @Override // java.lang.Runnable
            public void run() {
                InitTaskManager initTaskManager = InitTaskManager.this;
                initTaskManager.a("  run task in ui: " + initTask.a());
                InitTaskManager.this.m = System.currentTimeMillis();
                initTask.b();
                long currentTimeMillis = System.currentTimeMillis() - InitTaskManager.this.m;
                InitTaskManager initTaskManager2 = InitTaskManager.this;
                initTaskManager2.a("  finished in ui: " + initTask.a() + "(" + currentTimeMillis + ")");
                InitTaskManager.b(InitTaskManager.this, currentTimeMillis);
                if (InitTaskManager.this.n != null && !TextUtils.isEmpty(initTask.a())) {
                    try {
                        InitTaskManager.this.n.put(initTask.a(), currentTimeMillis);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (InitTaskManager.this.a(initTask.e())) {
                    return;
                }
                InitTaskManager.this.f();
            }
        });
        this.h++;
    }

    public static boolean b() {
        return Status.FINISHED == b;
    }

    private boolean b(Application application) {
        b = Status.RUNNING;
        this.f.onBuild(application, this.g);
        this.j = 0;
        ArrayList<InitTask> arrayList = this.g;
        if (arrayList != null) {
            this.i = arrayList.size();
            Iterator<InitTask> it = this.g.iterator();
            while (it.hasNext()) {
                InitTask next = it.next();
                if (next != null && next.e()) {
                    this.k++;
                }
            }
            a("-- initTaskList: totalTaskCount=" + this.i + ", unfinishedNotifyTaskCount=" + this.k);
            return this.i > 0;
        }
        return false;
    }

    public static boolean c() {
        return Status.RUNNING == b;
    }

    private void e() {
        a("notifyFinished");
        ArrayList<OnResultListener> arrayList = this.f9809c;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<OnResultListener> it = this.f9809c.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        a("do initAsync end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        while (this.h < this.i) {
            a(" ++ executeNextTask: " + this.h);
            InitTask initTask = this.g.get(this.h);
            if (initTask == null) {
                this.h++;
            } else if (!initTask.d()) {
                b(initTask);
                return;
            } else {
                a(initTask);
                if (initTask.c()) {
                    return;
                }
            }
        }
    }

    private void g() {
        ArrayList<OnResultListener> arrayList = this.f9809c;
        if (arrayList != null) {
            arrayList.clear();
            this.f9809c = null;
        }
        HandlerThread handlerThread = this.d;
        if (handlerThread != null) {
            handlerThread.quit();
            this.d = null;
        }
        this.e = null;
        ArrayList<InitTask> arrayList2 = this.g;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.g = null;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap = this.o;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.o = null;
        }
        f9808a = null;
    }

    public void a(Application application, OnResultListener onResultListener) {
        if (AppInfo.m() && Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("InitTaskManager.getInstance().mayInt need invoke in main thread!");
        }
        a("mayInit Entry state: " + b.name());
        if (onResultListener != null && !this.f9809c.contains(onResultListener)) {
            this.f9809c.add(onResultListener);
        }
        if (this.f == null || b()) {
            e();
        } else if (c()) {
        } else {
            HandlerThread handlerThread = new HandlerThread("initWorkThread-" + System.currentTimeMillis());
            this.d = handlerThread;
            handlerThread.start();
            this.e = new Handler(this.d.getLooper());
            if (b(application)) {
                a("do initAsync start");
                this.n = new JSONObject();
                this.l = 0L;
                f();
            }
        }
    }

    public void a(Application application, String[] strArr, OnTaskListBuilder onTaskListBuilder) {
        Model a2;
        this.f = onTaskListBuilder;
        if (onTaskListBuilder == null || Model.NOTHING == (a2 = a(application, strArr))) {
            return;
        }
        if (Model.ASYNC == a2) {
            a(application, (OnResultListener) null);
        } else {
            a(application);
        }
    }

    public void a(String str) {
        if (AppInfo.m()) {
            Log.d("InitTaskManager", str);
        }
    }

    public void d() {
        while (true) {
            int i = this.h;
            if (i >= this.i) {
                return;
            }
            final InitTask initTask = this.g.get(i);
            if (initTask != null) {
                if (!initTask.d() || initTask.c()) {
                    a("sync run task: " + initTask.a());
                    initTask.b();
                    a("sync finish task: " + initTask.a());
                } else {
                    new Thread(new Runnable() { // from class: com.blued.android.framework.init.InitTaskManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            InitTaskManager initTaskManager = InitTaskManager.this;
                            initTaskManager.a("sync run task in thread: " + initTask.a());
                            initTask.b();
                            InitTaskManager initTaskManager2 = InitTaskManager.this;
                            initTaskManager2.a("sync finish task in thead: " + initTask.a());
                        }
                    });
                }
            }
            this.h++;
        }
    }
}

package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import java.io.File;
import java.util.LinkedList;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/stateless/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f40891a = 273;
    private static Context b;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f40892c;
    private static Handler d;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static a i;
    private static IntentFilter j;
    private static Object e = new Object();
    private static volatile boolean k = false;
    private static LinkedList<String> l = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/stateless/b$a.class */
    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(274);
        }
    }

    public b(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    b = applicationContext;
                    if (applicationContext != null && f40892c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f40892c = handlerThread;
                        handlerThread.start();
                        if (i == null) {
                            String str = b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (d == null) {
                            d = new Handler(f40892c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                b.l();
                                                return;
                                            case 274:
                                                b.n();
                                                return;
                                            case 275:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                }
            }
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!k || (handler = d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        d.sendMessage(obtainMessage);
    }

    public static void a(boolean z) {
        k = z;
        if (!z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static boolean a() {
        synchronized (e) {
            return i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static void b(int i2) {
        try {
            if (!k || d == null || d.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = d.obtainMessage();
            obtainMessage.what = i2;
            d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    public static void c() {
        b(275);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c2 = d.c(b);
        if (c2 == null) {
            return;
        }
        if (l.size() > 0) {
            l.clear();
        }
        int length = c2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            l.add(c2[i3].getAbsolutePath());
            i2 = i3 + 1;
        }
    }

    private static String j() {
        String str;
        String str2;
        try {
            str = l.peek();
            str2 = str;
            if (str != null) {
                try {
                    l.removeFirst();
                    return str;
                } catch (Throwable th) {
                    str2 = str;
                    return str2;
                }
            }
        } catch (Throwable th2) {
            str = null;
        }
        return str2;
    }

    private static void k() {
        String pollFirst;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = Build.VERSION.SDK_INT >= 9 ? l.pollFirst() : j();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(b);
                    byte[] bArr = null;
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception e2) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String c2 = d.c(d.d(name));
                    if (cVar.a(bArr, c2, com.umeng.commonsdk.vchannel.a.f40970c.equalsIgnoreCase(c2) ? com.umeng.commonsdk.vchannel.a.f40969a : "", substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[Catch: all -> 0x015c, TryCatch #1 {all -> 0x015c, blocks: (B:7:0x000d, B:9:0x0018, B:11:0x001f, B:13:0x002c, B:15:0x0057, B:17:0x0062, B:20:0x0070, B:22:0x009a, B:25:0x00a8, B:27:0x00b3, B:30:0x00ba, B:34:0x00c9, B:36:0x00d4, B:38:0x00df, B:38:0x00df, B:39:0x00e2, B:42:0x00ed, B:44:0x00fa, B:46:0x011d, B:47:0x0135, B:49:0x0146), top: B:62:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0135 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void l() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.b.l():void");
    }

    private static void m() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!k || b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }
}

package com.tencent.thumbplayer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/i.class */
public class i extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f25744a = 0;
    private static String b = "unknown";

    /* renamed from: c  reason: collision with root package name */
    private static int f25745c;
    private static int d;
    private static String e;
    private ArrayList<b> f;
    private HandlerThread g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/i$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static i f25746a = new i();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/i$b.class */
    public interface b {
        void a(int i, int i2, int i3, int i4);
    }

    private i() {
        this.f = null;
        if (0 == 0) {
            this.f = new ArrayList<>();
        }
    }

    public static i a() {
        return a.f25746a;
    }

    private void a(Context context, Handler handler) {
        synchronized (this) {
            if (context != null) {
                context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
            }
        }
    }

    private boolean a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            return networkInfo.isConnected() || networkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static int b() {
        return f25745c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int b(NetworkInfo networkInfo) {
        int i = 3;
        if (networkInfo != null) {
            switch (networkInfo.getSubtype()) {
                case 0:
                    break;
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 13:
                    return 4;
                default:
                    return 3;
            }
            return i;
        }
        i = 0;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0099 A[Catch: Exception -> 0x00c0, TRY_ENTER, TryCatch #0 {Exception -> 0x00c0, blocks: (B:4:0x0004, B:7:0x0015, B:9:0x002b, B:11:0x0033, B:25:0x0072, B:33:0x0088, B:37:0x009e, B:39:0x00ad, B:41:0x00b8, B:34:0x0092, B:35:0x0099, B:13:0x003c, B:15:0x0045, B:17:0x004f, B:18:0x0056, B:20:0x005e, B:24:0x006b), top: B:48:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad A[Catch: Exception -> 0x00c0, TryCatch #0 {Exception -> 0x00c0, blocks: (B:4:0x0004, B:7:0x0015, B:9:0x002b, B:11:0x0033, B:25:0x0072, B:33:0x0088, B:37:0x009e, B:39:0x00ad, B:41:0x00b8, B:34:0x0092, B:35:0x0099, B:13:0x003c, B:15:0x0045, B:17:0x004f, B:18:0x0056, B:20:0x005e, B:24:0x006b), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.i.b(android.content.Context):void");
    }

    public static int c() {
        return f25744a;
    }

    private String c(NetworkInfo networkInfo) {
        String typeName = networkInfo != null ? networkInfo.getTypeName() : null;
        TPLogUtil.d("TPNetworkChangeMonitor", "getDetailNetworkType, typeName: ".concat(String.valueOf(typeName)));
        if (typeName != null) {
            if (typeName.toLowerCase(Locale.getDefault()).equals("wifi")) {
                return "wifi";
            }
            String extraInfo = networkInfo.getExtraInfo();
            String str = null;
            if (extraInfo != null) {
                str = extraInfo.toLowerCase(Locale.getDefault());
            }
            if (str != null) {
                if (str.startsWith("cmwap")) {
                    return "cmwap";
                }
                if (str.startsWith("cmnet") || str.startsWith("epc.tmobile.com")) {
                    return "cmnet";
                }
                if (str.startsWith("uniwap")) {
                    return "uniwap";
                }
                if (str.startsWith("uninet")) {
                    return "uninet";
                }
                if (str.startsWith("wap")) {
                    return "wap";
                }
                if (str.startsWith(TKDownloadReason.KSAD_TK_NET)) {
                    return TKDownloadReason.KSAD_TK_NET;
                }
                if (str.startsWith("ctwap")) {
                    return "ctwap";
                }
                if (str.startsWith("ctnet")) {
                    return "ctnet";
                }
                if (str.startsWith("3gwap")) {
                    return "3gwap";
                }
                if (str.startsWith("3gnet")) {
                    return "3gnet";
                }
                if (str.startsWith("#777")) {
                    String defaultHost = Proxy.getDefaultHost();
                    return (defaultHost == null || defaultHost.length() <= 0) ? "ctnet" : "ctwap";
                }
                return "unknown";
            }
            return "unknown";
        }
        return "unknown";
    }

    private static boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0080 A[Catch: all -> 0x00bb, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000b, B:9:0x001a, B:11:0x0080, B:13:0x0089, B:15:0x0091, B:16:0x00ac), top: B:27:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r6 = this;
            r0 = r6
            monitor-enter(r0)
            int r0 = com.tencent.thumbplayer.utils.i.f25744a     // Catch: java.lang.Throwable -> Lbb
            int r1 = com.tencent.thumbplayer.utils.i.d     // Catch: java.lang.Throwable -> Lbb
            if (r0 != r1) goto Lc5
            java.lang.String r0 = com.tencent.thumbplayer.utils.i.b     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r1 = com.tencent.thumbplayer.utils.i.e     // Catch: java.lang.Throwable -> Lbb
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch: java.lang.Throwable -> Lbb
            if (r0 != 0) goto Lc0
            goto Lc5
        L1a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            r1 = r0
            java.lang.String r2 = "notifyIfNetChanged, isNetChanged: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lbb
            r8 = r0
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r8
            java.lang.String r1 = ",  mListeners:  "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r8
            r1 = r6
            java.util.ArrayList<com.tencent.thumbplayer.utils.i$b> r1 = r1.f     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = "TPNetworkChangeMonitor"
            r1 = r8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbb
            com.tencent.thumbplayer.utils.TPLogUtil.i(r0, r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            r1 = r0
            java.lang.String r2 = "onNetworkStatusChanged oldNetStatus: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lbb
            r8 = r0
            r0 = r8
            int r1 = com.tencent.thumbplayer.utils.i.d     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r8
            java.lang.String r1 = ", netStatus: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r8
            int r1 = com.tencent.thumbplayer.utils.i.f25744a     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r8
            java.lang.String r1 = ", mobileNetSubType"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r8
            int r1 = com.tencent.thumbplayer.utils.i.f25745c     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = "TPNetworkChangeMonitor"
            r1 = r8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbb
            com.tencent.thumbplayer.utils.TPLogUtil.i(r0, r1)     // Catch: java.lang.Throwable -> Lbb
            r0 = r7
            if (r0 == 0) goto Lb8
            r0 = r6
            java.util.ArrayList<com.tencent.thumbplayer.utils.i$b> r0 = r0.f     // Catch: java.lang.Throwable -> Lbb
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> Lbb
            r8 = r0
        L88:
            r0 = r8
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> Lbb
            if (r0 == 0) goto Lac
            r0 = r8
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> Lbb
            com.tencent.thumbplayer.utils.i$b r0 = (com.tencent.thumbplayer.utils.i.b) r0     // Catch: java.lang.Throwable -> Lbb
            int r1 = com.tencent.thumbplayer.utils.i.d     // Catch: java.lang.Throwable -> Lbb
            int r2 = com.tencent.thumbplayer.utils.i.f25744a     // Catch: java.lang.Throwable -> Lbb
            r3 = 0
            int r4 = com.tencent.thumbplayer.utils.i.f25745c     // Catch: java.lang.Throwable -> Lbb
            r0.a(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> Lbb
            goto L88
        Lac:
            int r0 = com.tencent.thumbplayer.utils.i.f25744a     // Catch: java.lang.Throwable -> Lbb
            com.tencent.thumbplayer.utils.i.d = r0     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = com.tencent.thumbplayer.utils.i.b     // Catch: java.lang.Throwable -> Lbb
            com.tencent.thumbplayer.utils.i.e = r0     // Catch: java.lang.Throwable -> Lbb
        Lb8:
            r0 = r6
            monitor-exit(r0)
            return
        Lbb:
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)
            r0 = r8
            throw r0
        Lc0:
            r0 = 0
            r7 = r0
            goto L1a
        Lc5:
            r0 = 1
            r7 = r0
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.i.e():void");
    }

    private void f() {
        TPLogUtil.d("TPNetworkChangeMonitor", "-->updateNetStatus(), mNetStatus=" + f25744a + "[wifi: 2, mobile: 3], lastNetStatus=" + d + ", mDetailNetworkType=" + b + ", mobileNetSubType=" + f25745c + "[2G:2 3G:3 4G:4], currentDetailNetType=" + b + ", lastDetailNetType=" + e);
    }

    public void a(Context context) {
        synchronized (this) {
            com.tencent.thumbplayer.utils.b.a(context, "context can not be null!");
            if (this.g == null) {
                this.g = o.a().b();
            }
            a(context, new Handler(this.g.getLooper()));
            b(context);
        }
    }

    public void a(b bVar) {
        synchronized (this) {
            if (this.f != null && !this.f.contains(bVar)) {
                this.f.add(bVar);
                TPLogUtil.d("TPNetworkChangeMonitor", "add onNetStatus change listener: " + bVar + ", mListeners: " + this.f.size());
            }
        }
    }

    public void b(b bVar) {
        synchronized (this) {
            if (this.f != null) {
                this.f.remove(bVar);
                TPLogUtil.d("TPNetworkChangeMonitor", "remove netStatusChangeListener, listener: " + bVar + ", mListeners: " + this.f.size());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder("onReceive broadcast action and update net status,onReceive broadcast in ");
        sb.append(d() ? "main" : "work");
        sb.append(" thread.");
        TPLogUtil.d("TPNetworkChangeMonitor", sb.toString());
        b(context);
    }
}

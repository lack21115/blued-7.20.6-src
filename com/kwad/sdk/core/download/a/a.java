package com.kwad.sdk.core.download.a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.ksad.download.DownloadTask;
import com.ksad.download.d;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.ar;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a/a.class */
public final class a implements d {
    private static c afn;
    private static HashMap<String, WeakReference<Bitmap>> afm = new HashMap<>();
    private static final Handler afo = new HandlerC0560a();

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a/a$a.class */
    static final class HandlerC0560a extends Handler {
        private final SparseArray<Long> afp;

        HandlerC0560a() {
            super(Looper.getMainLooper());
            this.afp = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = false;
            boolean z2 = message.arg1 == 1;
            boolean z3 = message.arg2 == 1;
            if (message.arg2 == 2) {
                z = true;
            }
            Long l = this.afp.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.ksad.download.c.M().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.ksad.download.c.M().s(message.what) == null && !z) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else if (!z2 && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            } else {
                if (z3) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.afp.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a/a$b.class */
    public static final class b {
        private static String afq = "ksad_notification_default_icon";
        private String Vp;
        private String afr;
        private String afs;
        private String afu;
        private String name;
        private int progress;
        private File aft = null;
        private boolean afv = false;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File aX = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aX(downloadParams.mAppIcon);
                if (aX != null && aX.exists()) {
                    bVar.aft = aX;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.afv = downloadTask.isPaused();
            bVar.Vp = str;
            bVar.afu = str2;
            bVar.afr = a.J(downloadTask.getSmallFileSoFarBytes()) + " / " + a.J(downloadTask.getSmallFileTotalBytes());
            bVar.afs = a.J((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File aX;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (aX = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aX(downloadParams.mAppIcon)) != null && aX.exists()) {
                bVar.aft = aX;
            }
            bVar.Vp = str;
            bVar.afs = a.J(downloadParams.mAppSize);
            bVar.afu = str2;
            return bVar;
        }

        public static String vz() {
            return afq;
        }

        public final String getName() {
            String str = this.name;
            String str2 = str;
            if (str == null) {
                str2 = "";
            }
            return str2;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.afv;
        }

        public final String vA() {
            return this.afr;
        }

        public final String vB() {
            return this.afs;
        }

        public final String vC() {
            return this.Vp;
        }

        public final File vD() {
            return this.aft;
        }

        public final String vE() {
            return "正在下载 " + this.progress + "%";
        }

        public final String vF() {
            return this.afu;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/a/a$c.class */
    public static final class c extends BroadcastReceiver {
        private static void f(Intent intent) {
            DownloadTask h = h(intent);
            if (h == null) {
                return;
            }
            com.ksad.download.c.M().u(h.getId());
        }

        private static void g(Intent intent) {
            DownloadTask h = h(intent);
            if (h == null) {
                return;
            }
            h.setNotificationRemoved(true);
        }

        private static DownloadTask h(Intent intent) {
            int i = intent.getExtras().getInt(DBDefinition.TASK_ID, 0);
            if (i == 0) {
                return null;
            }
            return com.ksad.download.c.M().s(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                f(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                g(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String J(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, Notification notification) {
        vy();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.CA().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    private static void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ar.ao(context, "ksad_notification_small_icon"));
        if (z2) {
            builder.setDeleteIntent(b(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i));
        }
        afo.removeMessages(i);
        afo.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private void a(Context context, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File vD = bVar2.vD();
        if (!((vD == null || !vD.exists()) ? false : a(bVar, vD))) {
            a(context, bVar, b.vz());
        }
        bVar.setStatus(bVar2.vC());
        bVar.setSize(bVar2.vB());
        bVar.setInstallText(bVar2.vF());
    }

    private void a(Context context, com.kwad.sdk.core.download.a.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File vD = bVar.vD();
        if (!((vD == null || !vD.exists()) ? false : a(cVar, vD))) {
            a(context, cVar, b.vz());
        }
        cVar.setStatus(bVar.vC());
        cVar.setSize(bVar.vA());
        cVar.setPercentNum(bVar.vE());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.b bVar, String str) {
        try {
            bVar.setIcon(w(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            com.kwad.sdk.service.b.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.c cVar, String str) {
        try {
            cVar.setIcon(w(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            com.kwad.sdk.service.b.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.b bVar, File file) {
        try {
            bVar.setIcon(l(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            com.kwad.sdk.service.b.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.c cVar, File file) {
        try {
            cVar.setIcon(l(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            com.kwad.sdk.service.b.gatherException(e);
            return false;
        }
    }

    private static PendingIntent b(Context context, String str, int i) {
        Intent intent = new Intent(str);
        intent.putExtra(DBDefinition.TASK_ID, i);
        return PendingIntent.getBroadcast(context, i, intent, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r6.isRecycled() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap l(java.io.File r6) {
        /*
            r0 = r6
            java.lang.String r0 = r0.getAbsolutePath()
            r8 = r0
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.graphics.Bitmap>> r0 = com.kwad.sdk.core.download.a.a.afm
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L1f
            r0 = r6
            java.lang.Object r0 = r0.get()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r6 = r0
            goto L21
        L1f:
            r0 = 0
            r6 = r0
        L21:
            r0 = r6
            if (r0 == 0) goto L2e
            r0 = r6
            r7 = r0
            r0 = r6
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L43
        L2e:
            r0 = r8
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)
            r7 = r0
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.graphics.Bitmap>> r0 = com.kwad.sdk.core.download.a.a.afm
            r1 = r8
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r3 = r2
            r4 = r7
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
        L43:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a.l(java.io.File):android.graphics.Bitmap");
    }

    private static DownloadParams n(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static void vy() {
        if (afn != null) {
            return;
        }
        afn = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        ServiceProvider.CA().registerReceiver(afn, intentFilter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r8.isRecycled() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap w(android.content.Context r6, java.lang.String r7) {
        /*
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.graphics.Bitmap>> r0 = com.kwad.sdk.core.download.a.a.afm
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L1a
            r0 = r8
            java.lang.Object r0 = r0.get()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r8 = r0
            goto L1c
        L1a:
            r0 = 0
            r8 = r0
        L1c:
            r0 = r8
            if (r0 == 0) goto L29
            r0 = r8
            r9 = r0
            r0 = r8
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L46
        L29:
            r0 = r6
            android.content.res.Resources r0 = com.kwad.sdk.utils.ar.ck(r0)
            r1 = r6
            r2 = r7
            int r1 = com.kwad.sdk.utils.ar.ao(r1, r2)
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r1)
            r9 = r0
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.graphics.Bitmap>> r0 = com.kwad.sdk.core.download.a.a.afm
            r1 = r7
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r3 = r2
            r4 = r9
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
        L46:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a.w(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.ksad.download.d
    public final void a(DownloadTask downloadTask, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.ksad.download.d
    public final void b(File file) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        DownloadParams bu = com.kwad.sdk.core.a.tS().bu(file.getAbsolutePath());
        com.kwad.sdk.core.a.tS().bv(file.getAbsolutePath());
        if (context == null || bu == null) {
            return;
        }
        AdTemplate bw = com.kwad.sdk.core.a.tS().bw(bu.mDownloadid);
        if (bw != null) {
            bw.installFrom = "recall";
            com.kwad.sdk.core.download.c.vu().al(bw);
        }
        b a2 = b.a(bu, "下载完成", "立即安装");
        com.kwad.sdk.core.download.a.b aN = com.kwad.sdk.core.download.a.b.aN(context);
        if (aN == null) {
            return;
        }
        a(context, aN, a2);
        a(context, aN.build(), false, false, com.ksad.download.e.a(file, bu.mTaskId, bu.requestInstallPermission), bu.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File aX = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aX(str);
            if (aX == null || !aX.exists()) {
                ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).a(true, str, "", "");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.ksad.download.d
    public final void j(DownloadTask downloadTask) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.ksad.download.d
    public final void k(DownloadTask downloadTask) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        DownloadParams n = n(downloadTask);
        com.kwad.sdk.core.download.a.b aN = com.kwad.sdk.core.download.a.b.aN(context);
        if (aN == null) {
            return;
        }
        a(context, aN, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.tS().a(downloadTask.getTargetFilePath(), n);
        com.kwad.sdk.core.a.tS().a(n.mPkgname, n);
        a(context, aN.build(), false, false, com.ksad.download.e.l(downloadTask), downloadTask.getId(), 1, 1);
    }

    @Override // com.ksad.download.d
    public final void n(String str) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        DownloadParams bu = com.kwad.sdk.core.a.tS().bu(str);
        com.kwad.sdk.core.a.tS().bv(str);
        if (context == null || bu == null) {
            return;
        }
        com.kwad.sdk.core.a.tS().bv(bu.filePath);
        b a2 = b.a(bu, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.a.b aN = com.kwad.sdk.core.download.a.b.aN(context);
        if (aN == null) {
            return;
        }
        a(context, aN, a2);
        a(context, aN.build(), false, false, com.ksad.download.e.e(bu.mPkgname, bu.mTaskId), bu.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.d
    public final void v(int i) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }
}

package com.soft.blued.ui.welcome.helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.huawei.hms.framework.common.ContextCompat;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/helper/DownLoadADApkHelper.class */
public final class DownLoadADApkHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final DownLoadADApkHelper f20948a = new DownLoadADApkHelper();
    private static File b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f20949c;
    private static String[] d;
    private static String[] e;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/helper/DownLoadADApkHelper$DownApkAsyncTask.class */
    static final class DownApkAsyncTask extends AsyncTask<Void, Long, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final String f20950a;
        private final File b;

        /* renamed from: c  reason: collision with root package name */
        private final Drawable f20951c;

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Not initialized variable reg: 12, insn: 0x02af: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:96:0x02a8 */
        /* JADX WARN: Not initialized variable reg: 14, insn: 0x02ac: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:96:0x02a8 */
        /* JADX WARN: Removed duplicated region for block: B:101:0x02c8  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0286 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x02e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:126:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x027c  */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void... r8) {
            /*
                Method dump skipped, instructions count: 755
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.welcome.helper.DownLoadADApkHelper.DownApkAsyncTask.doInBackground(java.lang.Void[]):java.lang.Void");
        }
    }

    private DownLoadADApkHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(NotificationManager notificationManager) {
        if (notificationManager != null) {
            notificationManager.cancel(1);
            if (Build.VERSION.SDK_INT > 26) {
                notificationManager.deleteNotificationChannel("10001");
            }
        }
        FindHttpUtils.b(d);
        FileUtils.b(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, int i, int i2, NotificationManager notificationManager, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("10001", "notification", 4);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Notification.Builder builder = new Notification.Builder(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("10001");
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        builder.setSmallIcon(2131237292);
        builder.setLargeIcon(createBitmap);
        builder.setProgress(i2, i, false);
        builder.setContentTitle(AppInfo.d().getString(R.string.ad_downloading));
        builder.setOnlyAlertOnce(true);
        Notification build = builder.build();
        Intrinsics.c(build, "builder.build()");
        notificationManager.notify(1, build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedADExtra.DownLoadModel downLoadModel, File file, final NotificationManager notificationManager, final Drawable drawable) {
        Intrinsics.e(downLoadModel, "$this_apply");
        Intrinsics.e(file, "$baseFile");
        Intrinsics.e(notificationManager, "$manager");
        Intrinsics.e(drawable, "$resource");
        FileDownloader.a(downLoadModel.down_link, file.getPath(), new FileHttpResponseHandler() { // from class: com.soft.blued.ui.welcome.helper.DownLoadADApkHelper$downloadApk$1$1$1
            /* renamed from: a */
            public void onSuccess(File file2) {
                Log.v("drb", "「开机图下载」onSuccess");
                FindHttpUtils.b(DownLoadADApkHelper.f20948a.a());
                DownLoadADApkHelper.f20948a.a(NotificationManager.this);
            }

            /* renamed from: a */
            public void onFailure(Throwable th, int i, File file2) {
                StringBuilder sb = new StringBuilder();
                sb.append("「开机图下载」onFailure error:");
                sb.append(th);
                sb.append(" statusCode:");
                sb.append(i);
                sb.append(" content:");
                sb.append((Object) (file2 == null ? null : file2.getPath()));
                Log.v("drb", sb.toString());
            }

            public void onProgress(int i, int i2) {
                Log.v("drb", Intrinsics.a("「开机图下载」onProgress percent:", Integer.valueOf(i)));
                DownLoadADApkHelper.f20948a.a(AppInfo.d(), i, 100, NotificationManager.this, drawable);
            }
        });
    }

    public final void a(Intent intent) {
        Intrinsics.e(intent, "intent");
        FindHttpUtils.b(e);
        e = null;
    }

    public final void a(final Drawable drawable, final BluedADExtra.DownLoadModel downLoadModel) {
        Intrinsics.e(drawable, "resource");
        if (downLoadModel == null) {
            return;
        }
        f20948a.a(downLoadModel.down_finish);
        f20948a.b(downLoadModel.install_start);
        f20948a.c(downLoadModel.install_finish);
        StringBuilder sb = new StringBuilder(System.currentTimeMillis() + "_app");
        sb.append(".apk");
        final File file = new File(AppMethods.d(), sb.toString());
        Log.v("drb", "「开机图下载」absolutePath:" + ((Object) file.getAbsolutePath()) + "  path:" + ((Object) file.getPath()) + " down_link:" + ((Object) downLoadModel.down_link) + " AppMethods.getAppDownloadDirs()：" + ((Object) AppMethods.d()));
        f20948a.a(new File(AppMethods.d(), sb.toString()));
        Object systemService = ContextCompat.getSystemService(AppInfo.d(), "notification");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        final NotificationManager notificationManager = (NotificationManager) systemService;
        new Thread(new Runnable() { // from class: com.soft.blued.ui.welcome.helper.-$$Lambda$DownLoadADApkHelper$rmszfqoaAZW155SjwxfFCYX35tE
            @Override // java.lang.Runnable
            public final void run() {
                DownLoadADApkHelper.a(downLoadModel, file, notificationManager, drawable);
            }
        }).start();
        FindHttpUtils.b(downLoadModel.down_start);
        f20948a.a(downLoadModel.down_finish);
    }

    public final void a(File file) {
        b = file;
    }

    public final void a(String[] strArr) {
        f20949c = strArr;
    }

    public final String[] a() {
        return f20949c;
    }

    public final void b(String[] strArr) {
        d = strArr;
    }

    public final void c(String[] strArr) {
        e = strArr;
    }
}

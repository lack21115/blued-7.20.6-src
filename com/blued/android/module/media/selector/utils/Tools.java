package com.blued.android.module.media.selector.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.media.selector.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/Tools.class */
public class Tools {
    private static final String b = Tools.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static final String f15588a = FileUtils.f15572a + "/blued/BLPlayer";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.media.selector.utils.Tools$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/Tools$1.class */
    public class AnonymousClass1 extends FileHttpResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f15589a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f15590c;

        AnonymousClass1(String str, String str2, String str3) {
            this.f15589a = str;
            this.b = str2;
            this.f15590c = str3;
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onSuccess(File file) {
            String str = Tools.b;
            Logger.b(str, "onSuccess file " + file.getPath());
            ThreadManager.a().a(new ThreadExecutor("CopyVideoToPicDir") { // from class: com.blued.android.module.media.selector.utils.Tools.1.1
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    com.blued.android.framework.utils.FileUtils.a(AnonymousClass1.this.f15589a, AnonymousClass1.this.b, AnonymousClass1.this.f15590c);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.media.selector.utils.Tools.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Tools.a(AppInfo.d(), AnonymousClass1.this.b, true);
                        }
                    });
                }
            });
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onFailure(Throwable th, int i, File file) {
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFinish() {
            Logger.b(Tools.b, "onFinish ");
        }
    }

    public static final Dialog a(Context context) {
        Dialog dialog = new Dialog(context, R.style.TranslucentBackground);
        dialog.setContentView(R.layout.common_loading_layout);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCancelable(true);
        return dialog;
    }

    public static String a(long j) {
        try {
            return new DecimalFormat("##########0.0").format((j * 1.0d) / 1000.0d);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(final Context context, String str, final boolean z) {
        if (StringUtils.b(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT > 19) {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.blued.android.module.media.selector.utils.-$$Lambda$Tools$OyD9YUPft93crDoDN4CypFbojuk
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str2, Uri uri) {
                    Tools.a(z, context, str2, uri);
                }
            });
            return;
        }
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri fromFile = Uri.fromFile(new File(str));
        intent.addFlags(1);
        intent.addFlags(2);
        intent.setData(fromFile);
        context.sendBroadcast(intent);
        if (z) {
            AppMethods.a((CharSequence) context.getResources().getString(R.string.video_save));
        }
    }

    public static void a(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            } else if (file.isDirectory()) {
            } else {
                file.delete();
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, Context context, String str, Uri uri) {
        String str2 = b;
        Log.b(str2, "scanFile finish path " + str);
        String str3 = b;
        Log.b(str3, "scanFile finish  uri " + uri);
        if (z) {
            AppMethods.a((CharSequence) context.getResources().getString(R.string.video_save));
        }
    }

    public static byte[] a(Bitmap bitmap, String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            Log.a("drb", "baos.size() = " + byteArrayOutputStream.size());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] c(String str) {
        int i;
        int i2;
        int i3;
        int[] iArr = new int[3];
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (!TextUtils.isEmpty(str) && !str.contains("http")) {
                    mediaMetadataRetriever.setDataSource(str);
                }
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                if (TextUtils.isEmpty(extractMetadata) || TextUtils.isEmpty(extractMetadata2)) {
                    LogUtils.a(b + " widthStr" + extractMetadata + ",heightStr" + extractMetadata2);
                    i = 0;
                    i2 = 0;
                } else {
                    i = Integer.parseInt(extractMetadata);
                    i2 = Integer.parseInt(extractMetadata2);
                }
                if (TextUtils.isEmpty(extractMetadata3)) {
                    LogUtils.a(b + " rotation" + extractMetadata3);
                    i3 = 0;
                } else {
                    i3 = Integer.parseInt(extractMetadata3);
                }
                if (i3 == 90 || i3 == 270) {
                    iArr[0] = i2;
                    iArr[1] = i;
                } else {
                    iArr[0] = i;
                    iArr[1] = i2;
                }
                iArr[2] = i3;
            } catch (Exception e) {
                LogUtils.a(b + " MediaMetadataRetriever exception " + e);
                e.printStackTrace();
            }
            return iArr;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static void d(String str) {
        if (StringUtils.b(str)) {
            return;
        }
        String a2 = RecyclingUtils.a();
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        File file = new File(a2);
        if (!file.exists()) {
            file.mkdir();
        }
        String str2 = Md5.a(str.toLowerCase().trim() + Math.random()) + ".mp4";
        String absolutePath = new File(a2, str2).getAbsolutePath();
        Logger.b(b, "to download finalVideoPath   " + str);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        final String str3 = externalStoragePublicDirectory.getAbsolutePath() + File.separator + "blued" + File.separator + str2;
        if (str.startsWith("http") || str.startsWith("https")) {
            FileDownloader.a(str, absolutePath, new AnonymousClass1(absolutePath, str3, str2), null);
            return;
        }
        if (!str.startsWith(externalStoragePublicDirectory.getAbsolutePath())) {
            com.blued.android.framework.utils.FileUtils.a(str, str3, str2, 2);
        }
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.media.selector.utils.Tools.2
            @Override // java.lang.Runnable
            public void run() {
                Tools.a(AppInfo.d(), String.this, true);
            }
        });
    }
}

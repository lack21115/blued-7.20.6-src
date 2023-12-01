package com.youzan.androidsdkx5.plugin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import com.youzan.androidsdkx5.R;
import com.youzan.spiderman.utils.FileCallback;
import com.youzan.spiderman.utils.MD5Utils;
import com.youzan.spiderman.utils.OkHttpUtil;
import com.youzan.spiderman.utils.PermissionUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/SaveImageProcessor.class */
public class SaveImageProcessor {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f1133 = "YouZan";

    /* renamed from: ˊ  reason: contains not printable characters */
    private File m9215(Context context) {
        String str;
        File externalStoragePublicDirectory;
        try {
            if (PermissionUtil.hasExtStroragePermision(context) && Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && (externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)) != null) {
                str = externalStoragePublicDirectory.getAbsolutePath() + File.separator + f1133;
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9216(final Context context, final WebView webView) {
        File m9215 = m9215(context);
        if (m9215 == null) {
            Toast.makeText(context, R.string.yzappsdk_save_image_failed, 0).show();
            return;
        }
        WebView.HitTestResult hitTestResult = webView.getHitTestResult();
        if (hitTestResult == null) {
            Toast.makeText(context, R.string.yzappsdk_save_image_failed, 0).show();
            return;
        }
        String extra = hitTestResult.getExtra();
        if (extra == null) {
            Toast.makeText(context, R.string.yzappsdk_save_image_failed, 0).show();
        } else if (!extra.startsWith("data:")) {
            String lastPathSegment = Uri.parse(extra).getLastPathSegment();
            String str = lastPathSegment;
            if (TextUtils.isEmpty(lastPathSegment)) {
                str = MD5Utils.getStringMd5(extra);
            }
            final File file = new File(m9215, str);
            OkHttpUtil.downloadFile(context, extra, file, new FileCallback() { // from class: com.youzan.androidsdkx5.plugin.SaveImageProcessor.2
                @Override // com.youzan.spiderman.utils.FileCallback
                public void fail(int i, Exception exc) {
                    webView.post(new Runnable() { // from class: com.youzan.androidsdkx5.plugin.SaveImageProcessor.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(context, R.string.yzappsdk_save_image_failed, 0).show();
                        }
                    });
                }

                @Override // com.youzan.spiderman.utils.FileCallback
                public void success() {
                    SaveImageProcessor.this.m9217(context, file);
                    webView.post(new Runnable() { // from class: com.youzan.androidsdkx5.plugin.SaveImageProcessor.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(context, R.string.yzappsdk_save_image_succeed, 0).show();
                        }
                    });
                }
            });
        } else {
            String replaceFirst = extra.replaceFirst("data:image\\/\\w+;base64,", "");
            byte[] decode = Base64.decode(replaceFirst, 0);
            File file2 = new File(m9215, MD5Utils.getStringMd5(replaceFirst) + ".png");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(decode);
                fileOutputStream.close();
                m9217(context, file2);
                Toast.makeText(context, R.string.yzappsdk_save_image_succeed, 0).show();
            } catch (IOException e) {
                Toast.makeText(context, R.string.yzappsdk_save_image_succeed, 0).show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9217(Context context, File file) {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }

    public boolean showActionMenu(final WebView webView) {
        final Context context = webView.getContext();
        if (context == null) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(new CharSequence[]{context.getString(R.string.yzappsdk_save_image)}, new DialogInterface.OnClickListener() { // from class: com.youzan.androidsdkx5.plugin.SaveImageProcessor.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SaveImageProcessor.this.m9216(context, webView);
            }
        });
        builder.create().show();
        return true;
    }
}

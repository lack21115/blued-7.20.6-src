package com.soft.blued.utils;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.utils.RegExpUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/FileUtils.class */
public class FileUtils {
    public static Uri a(File file) {
        return Build.VERSION.SDK_INT < 24 ? Uri.fromFile(file) : FileProvider.getUriForFile(AppInfo.d(), "com.soft.blued.fileprovider", file);
    }

    public static void a(Context context, String str) {
        if (StringUtils.d(str)) {
            return;
        }
        String a2 = RegExpUtils.a(str);
        if (Build.VERSION.SDK_INT < 11 || Build.VERSION.SDK_INT == 18) {
            ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setText(a2);
            return;
        }
        try {
            ((android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("simple text", a2));
        } catch (Exception e) {
        }
    }

    public static void a(String str, FileHttpResponseHandler fileHttpResponseHandler) {
        FileDownloader.a(str, d(str), fileHttpResponseHandler, null);
    }

    public static byte[] a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a(new File(str));
    }

    public static void b(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.addFlags(1);
        intent.addFlags(2);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(a(file), AdBaseConstants.MIME_APK);
        AppInfo.d().startActivity(intent);
    }

    public static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http")) {
            str = d(str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b = AppMethods.b("video");
        String a2 = Md5.a(str.toLowerCase());
        return b + File.separator + a2;
    }
}

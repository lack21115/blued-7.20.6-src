package com.blued.android.module.external_sense_library.utils.lisense_utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STMobileAuthentificationNative;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/lisense_utils/STNewLicenseUtils.class */
public class STNewLicenseUtils {
    private static String a() {
        return AppMethods.b("/SenseTime/");
    }

    private static void a(BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(InputStreamReader inputStreamReader) {
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str) {
        synchronized (STNewLicenseUtils.class) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(a())) {
                    FileDownloader.a(str, c("SenseNet"), new FileHttpResponseHandler() { // from class: com.blued.android.module.external_sense_library.utils.lisense_utils.STNewLicenseUtils.1
                        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                        /* renamed from: a */
                        public void onSuccess(File file) {
                            if (file == null || !file.exists()) {
                                return;
                            }
                            LogUtils.c("STLicenseNew", "downloadFile success -- " + file.getPath(), new Object[0]);
                        }

                        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                        /* renamed from: a */
                        public void onFailure(Throwable th, int i, File file) {
                            super.onFailure(th, i, file);
                            LogUtils.d("STLicenseNew", "downloadFile Failure -- ", new Object[0]);
                        }
                    }, null);
                }
            } finally {
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (a(context, "SenseME.lic", true)) {
            LogUtils.d("STLicenseNew", "read SenseME", new Object[0]);
            return true;
        } else if (b("SenseNet")) {
            LogUtils.d("STLicenseNew", "read SenseNet", new Object[0]);
            return a(context, c("SenseNet"), false);
        } else {
            LogUtils.d("STLicenseNew", "read license error", new Object[0]);
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("activate_code_file", 0);
        String string = sharedPreferences.getString("activate_code", null);
        Integer num = new Integer(-1);
        if (string != null && STMobileAuthentificationNative.checkActiveCodeFromBuffer(context, str, str.length(), string, string.length()) == 0) {
            LogUtils.d("STLicenseNew", "activeCode: " + string, new Object[0]);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("activeCode: ");
        sb.append(string == null);
        LogUtils.d("STLicenseNew", sb.toString(), new Object[0]);
        String generateActiveCodeFromBuffer = STMobileAuthentificationNative.generateActiveCodeFromBuffer(context, str, str.length());
        if (generateActiveCodeFromBuffer != null && generateActiveCodeFromBuffer.length() > 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("activate_code", generateActiveCodeFromBuffer);
            edit.commit();
            return true;
        }
        LogUtils.d("STLicenseNew", "generate license error: " + num, new Object[0]);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r4, java.lang.String r5, boolean r6) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.external_sense_library.utils.lisense_utils.STNewLicenseUtils.a(android.content.Context, java.lang.String, boolean):boolean");
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(c(str)).exists();
        } catch (Exception e) {
            return false;
        }
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(a())) {
            return "";
        }
        String str2 = a() + BridgeUtil.SPLIT_MARK + str + ".lic";
        LogUtils.d("STLicenseNew", "获取文件名为 -- " + str2, new Object[0]);
        return str2;
    }
}

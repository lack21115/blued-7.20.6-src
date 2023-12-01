package com.tencent.smtt.sdk.stat;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.fw;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/stat/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f25192a;

    static {
        try {
            f25192a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
    }

    private static String a(Context context) {
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray == null) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            if (digest == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder("");
            if (digest == null || digest.length <= 0) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return sb.toString();
                }
                String upperCase = Integer.toHexString(digest[i2] & 255).toUpperCase();
                if (i2 > 0) {
                    sb.append(":");
                }
                if (upperCase.length() < 2) {
                    sb.append(0);
                }
                sb.append(upperCase);
                i = i2 + 1;
            }
        } catch (Exception e) {
            TbsLog.i(e);
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.smtt.sdk.stat.b$1] */
    public static void a(final ThirdAppInfoNew thirdAppInfoNew, final Context context) {
        new Thread("HttpUtils") { // from class: com.tencent.smtt.sdk.stat.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3;
                JSONObject jSONObject;
                com.tencent.smtt.utils.b.b(context, thirdAppInfoNew.sGuid);
                thirdAppInfoNew.sCpu = com.tencent.smtt.utils.b.b();
                if (Build.VERSION.SDK_INT < 8) {
                    return;
                }
                if (b.f25192a == null) {
                    try {
                        b.f25192a = "65dRa93L".getBytes("utf-8");
                    } catch (UnsupportedEncodingException e) {
                        b.f25192a = null;
                        TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                    }
                }
                if (b.f25192a == null) {
                    TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                    return;
                }
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
                if (TextUtils.isEmpty(string)) {
                    str = "";
                    str2 = str;
                } else {
                    str2 = string.substring(0, string.indexOf(ContainerUtils.FIELD_DELIMITER));
                    str = string.substring(string.indexOf(ContainerUtils.FIELD_DELIMITER) + 1, string.length());
                }
                boolean z = TextUtils.isEmpty(str2) || str2.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
                try {
                    m a2 = m.a();
                    if (z) {
                        str3 = a2.b() + g.a().b();
                    } else {
                        str3 = a2.f() + str2;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(20000);
                    if (Build.VERSION.SDK_INT > 13) {
                        httpURLConnection.setRequestProperty("Connection", "close");
                    }
                    try {
                        jSONObject = b.c(thirdAppInfoNew, context);
                    } catch (Exception e2) {
                        TbsLog.i(e2);
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        TbsLog.e("sdkreport", "post -- jsonData is null!");
                        return;
                    }
                    try {
                        byte[] bytes = jSONObject.toString().getBytes("utf-8");
                        byte[] a3 = z ? g.a().a(bytes) : g.a(bytes, str);
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(a3.length));
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(a3);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                TbsLog.i("sdkreport", "Post successful!");
                                TbsLog.i("sdkreport", "SIGNATURE is " + jSONObject.getString("SIGNATURE"));
                                b.b(context, b.b(httpURLConnection, str, z));
                                new TbsDownloadUpload(context).clearUploadCode();
                                return;
                            }
                            TbsLog.e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(126);
                            tbsLogInfo.setFailDetail("" + httpURLConnection.getResponseCode());
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        } catch (Throwable th) {
                            TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(126);
                            tbsLogInfo2.setFailDetail(th);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                        }
                    } catch (Throwable th2) {
                    }
                } catch (IOException e3) {
                    TbsLog.e("sdkreport", "Post failed -- IOException:" + e3);
                } catch (AssertionError e4) {
                    TbsLog.e("sdkreport", "Post failed -- AssertionError:" + e4);
                } catch (NoClassDefFoundError e5) {
                    TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:" + e5);
                }
            }
        }.start();
    }

    private static void a(Context context, String str, String str2) {
        if ("reset".equals(str) && fw.Code.equals(str2)) {
            QbSdk.reset(context);
        } else if (!str.startsWith("rmfile")) {
            TbsPVConfig.getInstance(context).putData(str, str2);
        } else {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_status", 0);
                if (sharedPreferences.getBoolean(str, false)) {
                    return;
                }
                File file = new File(str2);
                if (str2 != null && file.exists()) {
                    TbsLog.i("HttpUtils", "received command,delete" + str2);
                    FileUtil.b(file);
                }
                sharedPreferences.edit().putBoolean(str, true).apply();
            } catch (Exception e) {
                TbsLog.i(e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c5, code lost:
        r0.iCoreType = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e5, code lost:
        if (r12 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0222, code lost:
        if (r12 != false) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b A[Catch: all -> 0x021a, TryCatch #1 {all -> 0x021a, blocks: (B:24:0x00ad, B:26:0x010b, B:28:0x0114, B:30:0x011d, B:33:0x0138, B:35:0x0155, B:37:0x015e, B:40:0x0168, B:42:0x0171, B:44:0x0179, B:46:0x017f, B:49:0x018a, B:51:0x0193, B:53:0x019b, B:57:0x01ad, B:59:0x01b3, B:68:0x01eb, B:70:0x0200, B:72:0x0212, B:61:0x01c5, B:60:0x01bc, B:62:0x01ce, B:63:0x01d7, B:31:0x012d), top: B:85:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011d A[Catch: all -> 0x021a, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x021a, blocks: (B:24:0x00ad, B:26:0x010b, B:28:0x0114, B:30:0x011d, B:33:0x0138, B:35:0x0155, B:37:0x015e, B:40:0x0168, B:42:0x0171, B:44:0x0179, B:46:0x017f, B:49:0x018a, B:51:0x0193, B:53:0x019b, B:57:0x01ad, B:59:0x01b3, B:68:0x01eb, B:70:0x0200, B:72:0x0212, B:61:0x01c5, B:60:0x01bc, B:62:0x01ce, B:63:0x01d7, B:31:0x012d), top: B:85:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012d A[Catch: all -> 0x021a, TRY_ENTER, TryCatch #1 {all -> 0x021a, blocks: (B:24:0x00ad, B:26:0x010b, B:28:0x0114, B:30:0x011d, B:33:0x0138, B:35:0x0155, B:37:0x015e, B:40:0x0168, B:42:0x0171, B:44:0x0179, B:46:0x017f, B:49:0x018a, B:51:0x0193, B:53:0x019b, B:57:0x01ad, B:59:0x01b3, B:68:0x01eb, B:70:0x0200, B:72:0x0212, B:61:0x01c5, B:60:0x01bc, B:62:0x01ce, B:63:0x01d7, B:31:0x012d), top: B:85:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017f A[Catch: all -> 0x021a, TryCatch #1 {all -> 0x021a, blocks: (B:24:0x00ad, B:26:0x010b, B:28:0x0114, B:30:0x011d, B:33:0x0138, B:35:0x0155, B:37:0x015e, B:40:0x0168, B:42:0x0171, B:44:0x0179, B:46:0x017f, B:49:0x018a, B:51:0x0193, B:53:0x019b, B:57:0x01ad, B:59:0x01b3, B:68:0x01eb, B:70:0x0200, B:72:0x0212, B:61:0x01c5, B:60:0x01bc, B:62:0x01ce, B:63:0x01d7, B:31:0x012d), top: B:85:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0200 A[Catch: all -> 0x021a, TRY_ENTER, TryCatch #1 {all -> 0x021a, blocks: (B:24:0x00ad, B:26:0x010b, B:28:0x0114, B:30:0x011d, B:33:0x0138, B:35:0x0155, B:37:0x015e, B:40:0x0168, B:42:0x0171, B:44:0x0179, B:46:0x017f, B:49:0x018a, B:51:0x0193, B:53:0x019b, B:57:0x01ad, B:59:0x01b3, B:68:0x01eb, B:70:0x0200, B:72:0x0212, B:61:0x01c5, B:60:0x01bc, B:62:0x01ce, B:63:0x01d7, B:31:0x012d), top: B:85:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0228  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, boolean r9, long r10, boolean r12) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.b.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int, boolean, long, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v59, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v68, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    public static String b(HttpURLConnection httpURLConnection, String str, boolean z) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    gZIPInputStream = inputStream2;
                    if (contentEncoding != null) {
                        gZIPInputStream = inputStream2;
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            gZIPInputStream = new InflaterInputStream(inputStream2, new Inflater(true));
                        }
                    }
                } else {
                    gZIPInputStream = new GZIPInputStream(inputStream2);
                }
                inputStream = gZIPInputStream;
                try {
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[128];
                        while (true) {
                            int read = gZIPInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream3.write(bArr, 0, read);
                        }
                        ByteArrayOutputStream str2 = z ? new String(g.a().c(byteArrayOutputStream3.toByteArray())) : new String(g.b(byteArrayOutputStream3.toByteArray(), str));
                        try {
                            byteArrayOutputStream3.close();
                        } catch (IOException e) {
                            TbsLog.i(e);
                        }
                        byteArrayOutputStream2 = str2;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                                byteArrayOutputStream2 = str2;
                            } catch (IOException e2) {
                                TbsLog.i(e2);
                                byteArrayOutputStream2 = str2;
                            }
                        }
                    } catch (Exception e3) {
                        byteArrayOutputStream = byteArrayOutputStream3;
                        e = e3;
                        inputStream = gZIPInputStream;
                        TbsLog.i(e);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                                TbsLog.i(e4);
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e5) {
                                TbsLog.i(e5);
                            }
                        }
                        byteArrayOutputStream2 = "";
                        TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + byteArrayOutputStream2 + ";isUseRSA=" + z);
                        return byteArrayOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream3;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e6) {
                                TbsLog.i(e6);
                            }
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (IOException e7) {
                                TbsLog.i(e7);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    byteArrayOutputStream = null;
                }
            } catch (Exception e9) {
                e = e9;
                gZIPInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
                byteArrayOutputStream2 = null;
            }
            TbsLog.i("HttpUtils", "getResponseFromConnection,response=" + byteArrayOutputStream2 + ";isUseRSA=" + z);
            return byteArrayOutputStream2;
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = inputStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            TbsPVConfig.releaseInstance();
            TbsPVConfig.getInstance(context).clear();
        } catch (Exception e) {
            TbsLog.i(e);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\|");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                TbsPVConfig.getInstance(context).commit();
                return;
            }
            try {
                String[] split2 = split[i2].split("=");
                if (split2.length == 2) {
                    a(context, split2[0], split2[1]);
                }
            } catch (Exception e2) {
                TbsLog.i(e2);
            }
            i = i2 + 1;
            TbsLog.i(e);
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01ac A[Catch: Exception -> 0x0281, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0281, blocks: (B:2:0x0000, B:4:0x00d0, B:6:0x00dc, B:9:0x00ec, B:13:0x00f8, B:16:0x018a, B:18:0x01ac, B:21:0x01d8, B:23:0x01fd, B:28:0x021f, B:30:0x0228, B:31:0x022f, B:24:0x0210, B:19:0x01bc, B:14:0x0106, B:15:0x010f), top: B:53:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01bc A[Catch: Exception -> 0x0281, TRY_ENTER, TryCatch #1 {Exception -> 0x0281, blocks: (B:2:0x0000, B:4:0x00d0, B:6:0x00dc, B:9:0x00ec, B:13:0x00f8, B:16:0x018a, B:18:0x01ac, B:21:0x01d8, B:23:0x01fd, B:28:0x021f, B:30:0x0228, B:31:0x022f, B:24:0x0210, B:19:0x01bc, B:14:0x0106, B:15:0x010f), top: B:53:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01fd A[Catch: Exception -> 0x0281, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0281, blocks: (B:2:0x0000, B:4:0x00d0, B:6:0x00dc, B:9:0x00ec, B:13:0x00f8, B:16:0x018a, B:18:0x01ac, B:21:0x01d8, B:23:0x01fd, B:28:0x021f, B:30:0x0228, B:31:0x022f, B:24:0x0210, B:19:0x01bc, B:14:0x0106, B:15:0x010f), top: B:53:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0210 A[Catch: Exception -> 0x0281, TRY_ENTER, TryCatch #1 {Exception -> 0x0281, blocks: (B:2:0x0000, B:4:0x00d0, B:6:0x00dc, B:9:0x00ec, B:13:0x00f8, B:16:0x018a, B:18:0x01ac, B:21:0x01d8, B:23:0x01fd, B:28:0x021f, B:30:0x0228, B:31:0x022f, B:24:0x0210, B:19:0x01bc, B:14:0x0106, B:15:0x010f), top: B:53:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x021f A[Catch: Exception -> 0x0281, TRY_ENTER, TryCatch #1 {Exception -> 0x0281, blocks: (B:2:0x0000, B:4:0x00d0, B:6:0x00dc, B:9:0x00ec, B:13:0x00f8, B:16:0x018a, B:18:0x01ac, B:21:0x01d8, B:23:0x01fd, B:28:0x021f, B:30:0x0228, B:31:0x022f, B:24:0x0210, B:19:0x01bc, B:14:0x0106, B:15:0x010f), top: B:53:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0235 A[Catch: Exception -> 0x0285, TRY_LEAVE, TryCatch #0 {Exception -> 0x0285, blocks: (B:31:0x022f, B:33:0x0235, B:35:0x0245, B:37:0x024b, B:39:0x0260, B:41:0x026d), top: B:51:0x022f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject c(MTT.ThirdAppInfoNew r5, android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.stat.b.c(MTT.ThirdAppInfoNew, android.content.Context):org.json.JSONObject");
    }
}

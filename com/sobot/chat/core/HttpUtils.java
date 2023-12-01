package com.sobot.chat.core;

import android.text.TextUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.download.SobotDownload;
import com.sobot.network.http.download.SobotDownloadTask;
import java.io.File;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/HttpUtils.class */
public class HttpUtils {
    private static HttpUtils client;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/HttpUtils$FileCallBack.class */
    public interface FileCallBack {
        void inProgress(int i);

        void onError(Exception exc, String str, int i);

        void onResponse(File file);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/HttpUtils$a.class */
    public interface a {
        void a(int i);

        void a(Exception exc, String str, int i);

        void a(String str);
    }

    private HttpUtils() {
    }

    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String hexString = Integer.toHexString(digest[i2] & 255);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static HttpUtils getInstance() {
        if (client == null) {
            client = new HttpUtils();
        }
        return client;
    }

    private String getKey(String str, String str2, String str3, String str4, String str5, String str6) {
        return md5Encode(str2 + str5 + str4 + str);
    }

    private String md5Encode(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            int length = digest.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String hexString = Integer.toHexString(digest[i2] & 255);
                if (hexString.length() < 2) {
                    sb.append("0");
                }
                sb.append(hexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void printLog(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("sobot---请求参数： url = " + str + "  ");
            for (String str2 : map.keySet()) {
                sb.append(str2 + "=" + map.get(str2) + ", ");
            }
            LogUtils.i(sb.toString().substring(0, sb.toString().length() - 2));
        } catch (Exception e) {
        }
    }

    public SobotDownloadTask addDownloadFileTask(String str, String str2, String str3, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return SobotDownload.request(str, obtainGetRequest(str2, map)).priority(new Random().nextInt(100)).fileName(str3).save();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sobot.network.http.upload.SobotUploadTask addUploadFileTask(java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.HttpUtils.addUploadFileTask(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String):com.sobot.network.http.upload.SobotUploadTask");
    }

    public void cancelTag(Object obj) {
        SobotOkHttpUtils.getInstance().cancelTag(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doPost(java.lang.Object r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, final com.sobot.chat.core.HttpUtils.a r12) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.HttpUtils.doPost(java.lang.Object, java.lang.String, java.util.Map, com.sobot.chat.core.HttpUtils$a):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response doPostSync(java.lang.Object r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.HttpUtils.doPostSync(java.lang.Object, java.lang.String, java.util.Map):okhttp3.Response");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void download(java.lang.String r9, java.io.File r10, java.util.Map<java.lang.String, java.lang.String> r11, final com.sobot.chat.core.HttpUtils.FileCallBack r12) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.HttpUtils.download(java.lang.String, java.io.File, java.util.Map, com.sobot.chat.core.HttpUtils$FileCallBack):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sobot.network.http.request.RequestCall obtainGetRequest(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.HttpUtils.obtainGetRequest(java.lang.String, java.util.Map):com.sobot.network.http.request.RequestCall");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadFile(java.lang.Object r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11, java.lang.String r12, final com.sobot.chat.core.HttpUtils.a r13) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.core.HttpUtils.uploadFile(java.lang.Object, java.lang.String, java.util.Map, java.lang.String, com.sobot.chat.core.HttpUtils$a):void");
    }
}

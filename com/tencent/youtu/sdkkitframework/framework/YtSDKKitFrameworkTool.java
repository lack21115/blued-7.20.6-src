package com.tencent.youtu.sdkkitframework.framework;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.MessageConstant;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/sdkkitframework/framework/YtSDKKitFrameworkTool.class */
public class YtSDKKitFrameworkTool {
    private static char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    private final String f26778a = "files_md5";
    private final String b = "face-tracker-v001";

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f26779c = new ConcurrentHashMap();
    private final String d = YtSDKKitFrameworkTool.class.getSimpleName();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/youtu/sdkkitframework/framework/YtSDKKitFrameworkTool$a.class */
    public enum a {
        VALIDITY_OK,
        NOT_FOUND_MODEL_DIR,
        NOT_FOUND_MODEL_MD5,
        READ_MD5_ERROR,
        VALIDITY_ERROR,
        TARGET_MD5_NOT_FOUND,
        CREATE_MD5_ERROR,
        MODEL_FILE_MISS
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(java.io.File r7) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.sdkkitframework.framework.YtSDKKitFrameworkTool.a(java.io.File):int");
    }

    private String a(InputStream inputStream) {
        String str;
        StringBuilder sb;
        String noSuchAlgorithmException;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[MessageConstant.MessageType.MESSAGE_STAT];
            int i = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, MessageConstant.MessageType.MESSAGE_STAT);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                    i += read;
                }
            }
            return i == 0 ? "" : a(messageDigest.digest());
        } catch (IOException e2) {
            e2.printStackTrace();
            str = this.d;
            sb = new StringBuilder();
            sb.append("get input stream  md5 error ");
            noSuchAlgorithmException = e2.toString();
            sb.append(noSuchAlgorithmException);
            WLogger.e(str, sb.toString());
            return "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            str = this.d;
            sb = new StringBuilder();
            sb.append("get input stream  md5 error ");
            noSuchAlgorithmException = e3.toString();
            sb.append(noSuchAlgorithmException);
            WLogger.e(str, sb.toString());
            return "";
        }
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return "";
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = e;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    private void a(File file, List<String> list) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            WLogger.e(this.d, "dir is empty");
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                a(file2, list);
            } else {
                String path = file2.getPath();
                if (!file2.getName().equalsIgnoreCase("files_md5")) {
                    list.add(path);
                }
            }
            i = i2 + 1;
        }
    }

    private int b(File file) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        a(file, copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() == 0) {
            WLogger.e(this.d, "dir is empty");
            return -1;
        }
        for (String str : copyOnWriteArrayList) {
            String substring = str.substring(str.indexOf("face-tracker-v001") + 17 + 1);
            if (!this.f26779c.containsKey(substring)) {
                WLogger.e(this.d, "the file name not found md5 with md5 map");
                return -3;
            }
            String c2 = c(new File(str));
            if (TextUtils.isEmpty(c2)) {
                WLogger.e(this.d, "create md5 by file is error,md5 is null");
                return -4;
            } else if (!c2.equalsIgnoreCase(this.f26779c.get(substring))) {
                String str2 = this.d;
                WLogger.e(str2, "md5 validity by dir error,file name is " + substring + "   target md5 is " + this.f26779c.get(substring) + " cur md5 is " + c2);
                return -2;
            } else {
                this.f26779c.remove(substring);
            }
        }
        if (this.f26779c.size() != 0) {
            for (String str3 : this.f26779c.keySet()) {
                String str4 = this.d;
                WLogger.e(str4, "module file miss:" + str3 + " md5:" + this.f26779c.get(str3));
            }
            return -5;
        }
        return 0;
    }

    private String c(File file) {
        BufferedInputStream bufferedInputStream;
        String str;
        StringBuilder sb;
        if (file == null || !file.exists() || file.length() <= 0) {
            return "";
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    String a2 = a(bufferedInputStream);
                    try {
                        bufferedInputStream.close();
                        return a2;
                    } catch (IOException e2) {
                        WLogger.e(this.d, "get file  md5 close io error:" + e2.toString());
                        e2.printStackTrace();
                        return a2;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    BufferedInputStream bufferedInputStream3 = bufferedInputStream;
                    String str2 = this.d;
                    BufferedInputStream bufferedInputStream4 = bufferedInputStream;
                    StringBuilder sb2 = new StringBuilder();
                    BufferedInputStream bufferedInputStream5 = bufferedInputStream;
                    sb2.append("get file  md5 error ");
                    BufferedInputStream bufferedInputStream6 = bufferedInputStream;
                    sb2.append(e.toString());
                    BufferedInputStream bufferedInputStream7 = bufferedInputStream;
                    WLogger.e(str2, sb2.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return "";
                        } catch (IOException e4) {
                            e = e4;
                            str = this.d;
                            sb = new StringBuilder();
                            sb.append("get file  md5 close io error:");
                            sb.append(e.toString());
                            WLogger.e(str, sb.toString());
                            e.printStackTrace();
                            return "";
                        }
                    }
                    return "";
                } catch (OutOfMemoryError e5) {
                    WLogger.e(this.d, "get file  md5 error oom");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return "";
                        } catch (IOException e6) {
                            e = e6;
                            str = this.d;
                            sb = new StringBuilder();
                            sb.append("get file  md5 close io error:");
                            sb.append(e.toString());
                            WLogger.e(str, sb.toString());
                            e.printStackTrace();
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e7) {
                            WLogger.e(this.d, "get file  md5 close io error:" + e7.toString());
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                bufferedInputStream = null;
            } catch (OutOfMemoryError e9) {
                bufferedInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static native String getFrameworkVersion();

    public a a(String str) {
        String str2 = this.d;
        WLogger.i(str2, "module path :" + str);
        File file = new File(str);
        if (!file.exists()) {
            String str3 = this.d;
            WLogger.e(str3, "md5 validity by dir error:" + a.NOT_FOUND_MODEL_DIR.name());
            return a.NOT_FOUND_MODEL_DIR;
        }
        File file2 = new File(str + "files_md5");
        if (!file2.exists()) {
            String str4 = this.d;
            WLogger.e(str4, "md5 validity by dir error:" + a.NOT_FOUND_MODEL_MD5.name());
            return a.NOT_FOUND_MODEL_MD5;
        } else if (a(file2) != 0) {
            String str5 = this.d;
            WLogger.e(str5, "md5 validity by dir error:" + a.READ_MD5_ERROR.name());
            return a.READ_MD5_ERROR;
        } else {
            int b = b(file);
            if (b == -1) {
                String str6 = this.d;
                WLogger.e(str6, "md5 validity by dir error:" + a.NOT_FOUND_MODEL_DIR.name());
                return a.NOT_FOUND_MODEL_DIR;
            } else if (b == -2) {
                String str7 = this.d;
                WLogger.e(str7, "md5 validity by dir error:" + a.VALIDITY_ERROR.name());
                return a.VALIDITY_ERROR;
            } else if (b == -3) {
                String str8 = this.d;
                WLogger.e(str8, "md5 validity by dir error:" + a.TARGET_MD5_NOT_FOUND.name());
                return a.TARGET_MD5_NOT_FOUND;
            } else if (b == -4) {
                String str9 = this.d;
                WLogger.e(str9, "md5 validity by dir error:" + a.CREATE_MD5_ERROR.name());
                return a.CREATE_MD5_ERROR;
            } else if (b != -5) {
                WLogger.d(this.d, "md5 validity by dir ok");
                return a.VALIDITY_OK;
            } else {
                String str10 = this.d;
                WLogger.e(str10, "md5 validity by dir error:" + a.MODEL_FILE_MISS.name());
                return a.MODEL_FILE_MISS;
            }
        }
    }
}

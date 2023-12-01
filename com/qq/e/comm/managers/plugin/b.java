package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f14231a;

    public static String a(Context context) {
        synchronized (b.class) {
            try {
                if (!TextUtils.isEmpty(f14231a)) {
                    return f14231a;
                } else if (Build.VERSION.SDK_INT >= 28) {
                    f14231a = Application.getProcessName();
                    return f14231a;
                } else {
                    int myPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            try {
                            } catch (Exception e) {
                            }
                            if (runningAppProcessInfo.pid == myPid) {
                                f14231a = runningAppProcessInfo.processName;
                                return f14231a;
                            }
                            continue;
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String a(String str) {
        synchronized (b.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                String str2 = f14231a;
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                boolean endsWith = str2.endsWith("_");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(endsWith ? "" : "_");
                String str3 = null;
                try {
                    String str4 = new String(str2);
                    try {
                        str3 = d.a(MessageDigest.getInstance("MD5").digest(str4.getBytes("UTF-8")));
                    } catch (Exception e) {
                        str3 = str4;
                    }
                } catch (Exception e2) {
                }
                sb.append(str3);
                return sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, File file, File file2) throws Throwable {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        String str;
        boolean z;
        AssetManager assets = context.getAssets();
        try {
            h.a();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str2 = "Asset Error " + str;
                    GDTLogger.e(str2);
                    throw new Exception(str2);
                }
                str = "no asset";
                String str22 = "Asset Error " + str;
                GDTLogger.e(str22);
                throw new Exception(str22);
            }
            String str3 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str4 = Sig.ASSET_PLUGIN_SIG;
            String str5 = str4;
            if (str4 == null) {
                str5 = "";
            }
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str5, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z = h.a(assets.open(str3), file);
                inputStream = null;
                fileOutputStream = null;
            } else {
                inputStream = assets.open(str3);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    fileOutputStream = null;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } catch (Throwable th3) {
                        a(inputStream);
                        a(fileOutputStream);
                        throw th3;
                    }
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        int i3 = 0;
                        while (i3 < read) {
                            if (i2 >= 64) {
                                bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                i++;
                            }
                            i3++;
                            i2++;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    z = true;
                } catch (Throwable th4) {
                    th = th4;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            a(inputStream);
            a(fileOutputStream);
            if (!z) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}

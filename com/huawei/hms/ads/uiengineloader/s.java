package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/s.class */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22569a = "ads_ModuleCopy";
    private static final int b = 2048;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22570c = 0;
    private static final String d = "file://";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String[] strArr) {
        int i = 0;
        if (strArr == null || strArr.length == 0) {
            aa.b(f22569a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return i3;
            }
            String str = strArr[i];
            int i4 = i3;
            if (Integer.parseInt(str) > i3) {
                i4 = Integer.parseInt(str);
            }
            i++;
            i2 = i4;
        }
    }

    private static String a(Context context, Bundle bundle, String str) {
        String[] list;
        int a2;
        String string = bundle.getString("module_name");
        String valueOf = String.valueOf(bundle.getInt("module_version"));
        String str2 = bundle.getString("module_name") + ".apk";
        String str3 = y.a(context) + File.separator + com.huawei.hms.ads.dynamicloader.b.f22466a + File.separator + string;
        String str4 = str3 + File.separator + valueOf;
        String str5 = str4 + File.separator + str2;
        if (new File(str3).exists() && (a2 = a((list = new File(str3).list()))) >= Integer.parseInt(valueOf)) {
            r.a(a2, str3, list, f22569a);
            return str3 + File.separator + a2 + File.separator + str2;
        }
        return a(context, str4, str, str5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, String str, String str2, String str3) {
        String str4;
        if (y.a(str)) {
            a(context, str2, str3);
            if (TextUtils.isEmpty(str3) || !new File(str3).exists()) {
                str4 = "The filePath:" + str3 + " doesn't exist, or not accessible.";
            } else if (!x.a(context, str3) || x.a(new File(str3), y.c(str3)) == 0) {
                return str3;
            } else {
                str4 = "Extract native to current dir failed.";
            }
        } else {
            str4 = "makeDirectory return false";
        }
        aa.d(f22569a, str4);
        return null;
    }

    private static void a(Context context, Bundle bundle) {
        String[] list;
        int a2;
        String str;
        if (context == null || bundle == null) {
            aa.d(f22569a, "The context or module info bundle is null.");
            return;
        }
        String string = bundle.getString("module_path");
        aa.b(f22569a, "path:".concat(String.valueOf(string)));
        String string2 = bundle.getString("module_name");
        String valueOf = String.valueOf(bundle.getInt("module_version"));
        String str2 = bundle.getString("module_name") + ".apk";
        String str3 = y.a(context) + File.separator + com.huawei.hms.ads.dynamicloader.b.f22466a + File.separator + string2;
        String str4 = str3 + File.separator + valueOf;
        String str5 = str4 + File.separator + str2;
        if (new File(str3).exists() && (a2 = a((list = new File(str3).list()))) >= Integer.parseInt(valueOf)) {
            r.a(a2, str3, list, f22569a);
            str = str3 + File.separator + a2 + File.separator + str2;
        } else {
            str = a(context, str4, string, str5);
        }
        if (TextUtils.isEmpty(str)) {
            aa.c(f22569a, "checkModulePath failed: null.");
        } else {
            bundle.putString("module_path", str);
        }
    }

    private static void a(Context context, String str, String str2) {
        if (a(str, str2)) {
            return;
        }
        b(context, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.io.OutputStream, java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.Closeable] */
    private static boolean a(String str, String str2) {
        String str3;
        BufferedInputStream bufferedInputStream;
        String str4;
        String str5;
        String sb;
        String str6;
        BufferedInputStream bufferedInputStream2 = null;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(str));
                try {
                    ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = bufferedInputStream4.read(bArr);
                            if (read == -1) {
                                ae.a(bufferedInputStream4);
                                ae.a(bufferedOutputStream);
                                return true;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    } catch (FileNotFoundException e) {
                        str5 = bufferedOutputStream;
                        e = e;
                        bufferedInputStream2 = bufferedInputStream4;
                        e = e;
                        StringBuilder sb2 = new StringBuilder("copyModuleFromPath FileNotFoundException:");
                        String str7 = bufferedInputStream2;
                        sb2.append(e.getMessage());
                        String str8 = bufferedInputStream2;
                        sb = sb2.toString();
                        str6 = str5;
                        bufferedInputStream3 = bufferedInputStream2;
                        str = bufferedInputStream3;
                        str2 = str6;
                        aa.d(f22569a, sb);
                        ae.a(bufferedInputStream3);
                        ae.a(str6);
                        return false;
                    } catch (IOException e2) {
                        str4 = bufferedOutputStream;
                        e = e2;
                        bufferedInputStream3 = bufferedInputStream4;
                        e = e;
                        StringBuilder sb3 = new StringBuilder("copyModuleFromPath IOException ");
                        String str9 = bufferedInputStream3;
                        sb3.append(e.getMessage());
                        String str10 = bufferedInputStream3;
                        sb = sb3.toString();
                        str6 = str4;
                        str = bufferedInputStream3;
                        str2 = str6;
                        aa.d(f22569a, sb);
                        ae.a(bufferedInputStream3);
                        ae.a(str6);
                        return false;
                    } catch (Throwable th) {
                        str3 = bufferedOutputStream;
                        th = th;
                        th = th;
                        bufferedInputStream = bufferedInputStream4;
                        ae.a(bufferedInputStream);
                        ae.a(str3);
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    str5 = null;
                } catch (IOException e4) {
                    e = e4;
                    str4 = null;
                } catch (Throwable th2) {
                    th = th2;
                    str3 = null;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                str5 = null;
            } catch (IOException e6) {
                e = e6;
                str4 = null;
            } catch (Throwable th3) {
                th = th3;
                str3 = null;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            str3 = str2;
            bufferedInputStream = str;
        }
    }

    private static void b(Context context, Bundle bundle) {
        String[] list;
        int a2;
        String str;
        String string = bundle.getString("module_path");
        aa.b(f22569a, "path:".concat(String.valueOf(string)));
        String string2 = bundle.getString("module_name");
        String valueOf = String.valueOf(bundle.getInt("module_version"));
        String str2 = bundle.getString("module_name") + ".apk";
        String str3 = y.a(context) + File.separator + com.huawei.hms.ads.dynamicloader.b.f22466a + File.separator + string2;
        String str4 = str3 + File.separator + valueOf;
        String str5 = str4 + File.separator + str2;
        if (new File(str3).exists() && (a2 = a((list = new File(str3).list()))) >= Integer.parseInt(valueOf)) {
            r.a(a2, str3, list, f22569a);
            str = str3 + File.separator + a2 + File.separator + str2;
        } else {
            str = a(context, str4, string, str5);
        }
        if (TextUtils.isEmpty(str)) {
            aa.c(f22569a, "checkModulePath failed: null.");
        } else {
            bundle.putString("module_path", str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.OutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v3 */
    private static void b(Context context, String str, String str2) {
        InputStream inputStream;
        Closeable closeable;
        IOException e;
        Closeable closeable2;
        InputStream inputStream2 = str;
        try {
            try {
                if (!str.startsWith(d)) {
                    inputStream2 = d.concat(String.valueOf((Object) str));
                }
                inputStream = context.getContentResolver().openInputStream(Uri.parse(inputStream2));
                try {
                    if (inputStream == null) {
                        aa.c(f22569a, "Get input stream failed: null.");
                        ae.a(inputStream);
                        ae.a(null);
                        return;
                    }
                    str2 = new BufferedOutputStream(new FileOutputStream((String) str2));
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                ae.a(inputStream);
                                ae.a(str2);
                                return;
                            }
                            str2.write(bArr, 0, read);
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        closeable2 = str2;
                        StringBuilder sb = new StringBuilder("FileNotFoundException:");
                        InputStream inputStream3 = inputStream;
                        sb.append(e.getMessage());
                        InputStream inputStream4 = inputStream;
                        aa.d(f22569a, sb.toString());
                        ae.a(inputStream);
                        ae.a(closeable2);
                    } catch (IOException e3) {
                        e = e3;
                        closeable = str2;
                        StringBuilder sb2 = new StringBuilder("IOException ");
                        InputStream inputStream5 = inputStream;
                        sb2.append(e.getMessage());
                        InputStream inputStream6 = inputStream;
                        aa.d(f22569a, sb2.toString());
                        ae.a(inputStream);
                        ae.a(closeable);
                    } catch (Throwable th) {
                        th = th;
                        ae.a(inputStream);
                        ae.a(str2);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    closeable2 = null;
                } catch (IOException e5) {
                    e = e5;
                    closeable = null;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = 0;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                closeable2 = null;
                inputStream = null;
            } catch (IOException e7) {
                closeable = null;
                inputStream = null;
                e = e7;
            } catch (Throwable th3) {
                th = th3;
                str2 = 0;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = inputStream2;
        }
    }
}

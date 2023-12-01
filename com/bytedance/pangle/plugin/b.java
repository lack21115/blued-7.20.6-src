package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.a.a;
import com.bytedance.pangle.c.b;
import com.bytedance.pangle.g.e;
import com.bytedance.pangle.h;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.i;
import com.huawei.openalliance.ad.constant.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/plugin/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final h f7837a = h.a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/plugin/b$a.class */
    public static final class a extends IOException {
        private a(String str) {
            super(str);
        }

        /* synthetic */ a(String str, byte b) {
            this(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ a(String str, Throwable th, byte b) {
            this(str, th);
        }
    }

    static /* synthetic */ void a(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (!e.a(file.getAbsolutePath(), str)) {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
                stringBuffer.append("checkSignature cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(t.aE);
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.q, str, i, -1L, null);
                f7837a.a(1100, -3, str, i, e);
                throw new a(e.getMessage(), e, (byte) 0);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(t.aE);
            throw th;
        }
    }

    private static void a(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.b.b(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    static /* synthetic */ void a(String str, int i, Map map, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new File(com.bytedance.pangle.d.c.b(str, i)), new File(com.bytedance.pangle.d.c.d(str, i)), str, map);
                stringBuffer.append("copySo cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(t.aE);
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.t, str, i, -1L, null);
                f7837a.a(1100, -7, str, i, e);
                throw new a("安装包动态库拷贝失败", e, (byte) 0);
            }
        } catch (Throwable th) {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(t.aE);
            throw th;
        }
    }

    static /* synthetic */ void a(String str, String str2, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int a2 = new com.bytedance.pangle.res.a.c().a(new File(str), false, sb);
        stringBuffer.append(a2 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(t.aE);
        if (a2 == 100 || a2 == 200) {
            return;
        }
        String sb2 = sb.toString();
        a(com.bytedance.pangle.c.b.f, b.a.x, str2, i, -1L, sb2);
        f7837a.a(1100, -2, str2, i, null);
        throw new a("modifyRes failed. result = " + a2 + ", errorLog = " + sb2, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        try {
            f7837a.a(1000, 0, str, i, null);
            com.bytedance.pangle.log.a a2 = com.bytedance.pangle.log.a.a(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            a(com.bytedance.pangle.c.b.e, b.a.n, str, i, -1L, null);
            g.a(com.bytedance.pangle.d.c.a(str, i));
            com.bytedance.pangle.a.a.a(new a.InterfaceC0144a() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.a.a.InterfaceC0144a
                public final void a() {
                    b.a(file, str, i, stringBuffer);
                }
            }, new a.InterfaceC0144a() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.a.a.InterfaceC0144a
                public final void a() {
                    final Map f = b.f(file, str, i, stringBuffer);
                    b.c(file, str, i, stringBuffer);
                    b.a(b.g(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (i.e() || i.b()) {
                        com.bytedance.pangle.a.a.a(new a.InterfaceC0144a() { // from class: com.bytedance.pangle.plugin.b.2.1
                            @Override // com.bytedance.pangle.a.a.InterfaceC0144a
                            public final void a() {
                                b.a(str, i, f, stringBuffer);
                            }
                        }, new a.InterfaceC0144a() { // from class: com.bytedance.pangle.plugin.b.2.2
                            @Override // com.bytedance.pangle.a.a.InterfaceC0144a
                            public final void a() {
                                b.e(file, str, i, stringBuffer);
                            }
                        });
                        return;
                    }
                    b.a(str, i, f, stringBuffer);
                    b.e(file, str, i, stringBuffer);
                }
            });
            g.a(file);
            a(com.bytedance.pangle.c.b.f, b.a.o, str, i, a2.a(), stringBuffer.toString());
            a2.a(bw.o);
            f7837a.a(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof a) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
                return false;
            }
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
            a(com.bytedance.pangle.c.b.f, b.a.p, str, i, -1L, stringBuffer.toString());
            f7837a.a(1100, -1, str, i, th);
            return false;
        }
    }

    static /* synthetic */ void c(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                if (packageArchiveInfo.requestedPermissions != null && packageArchiveInfo.requestedPermissions.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    String[] strArr = packageArchiveInfo.requestedPermissions;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        String str2 = strArr[i3];
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                        i2 = i3 + 1;
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new a("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)), (byte) 0);
                        }
                    }
                }
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.r, str, i, -1L, null);
                f7837a.a(1100, -4, str, i, e);
                throw new a("安装包权限校验失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(t.aE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
        r0 = r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void e(java.io.File r8, java.lang.String r9, int r10, java.lang.StringBuffer r11) {
        /*
            Method dump skipped, instructions count: 1183
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.b.e(java.io.File, java.lang.String, int, java.lang.StringBuffer):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> f(File file, String str, int i, StringBuffer stringBuffer) {
        if (GlobalParam.getInstance().checkMatchHostAbi()) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    com.bytedance.pangle.util.e<Boolean, Map<String, List<ZipEntry>>> a2 = com.bytedance.pangle.d.b.a(file);
                    boolean booleanValue = a2.f7895a.booleanValue();
                    Map<String, List<ZipEntry>> map = a2.b;
                    if (!booleanValue) {
                        throw new a("插件包包含so不符合宿主ABI类型", (byte) 0);
                    }
                    stringBuffer.append("checkMatchHostAbi cost:");
                    stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                    stringBuffer.append(t.aE);
                    return map;
                } catch (Exception e) {
                    a(com.bytedance.pangle.c.b.f, b.a.w, str, i, -1L, null);
                    f7837a.a(1100, -5, str, i, e);
                    throw new a("插件包包含so不符合宿主ABI类型", e, (byte) 0);
                }
            } catch (Throwable th) {
                stringBuffer.append("checkMatchHostAbi cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(t.aE);
                throw th;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(File file, String str, int i, StringBuffer stringBuffer) {
        long currentTimeMillis = System.currentTimeMillis();
        String b = com.bytedance.pangle.d.c.b(str, i);
        try {
            try {
                com.bytedance.pangle.util.h.a(file.getAbsolutePath(), b);
                stringBuffer.append("copyApk cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(t.aE);
                return b;
            } catch (Exception e) {
                a(com.bytedance.pangle.c.b.f, b.a.s, str, i, -1L, null);
                f7837a.a(1100, -6, str, i, e);
                throw new a("安装包拷贝失败", e, (byte) 0);
            }
        } catch (Throwable th) {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(t.aE);
            throw th;
        }
    }
}

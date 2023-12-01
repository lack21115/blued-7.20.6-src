package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hk;
import com.xiaomi.push.iq;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ca.class */
public class ca {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f41660a = new Object();

    public static void a(Context context, hk hkVar) {
        if (bz.a(hkVar.e())) {
            com.xiaomi.push.ai.a(context).a(new cb(context, hkVar));
        }
    }

    public static byte[] a(Context context) {
        String a2 = com.xiaomi.push.n.a(context).a("mipush", "td_key", "");
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = com.xiaomi.push.bn.a(20);
            com.xiaomi.push.n.a(context).m12062a("mipush", "td_key", str);
        }
        return a(str);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(com.xiaomi.push.bk.m11546a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public static void c(Context context, hk hkVar) {
        Closeable closeable;
        Closeable closeable2;
        try {
            try {
                byte[] b = com.xiaomi.push.h.b(a((Context) context), iq.a(hkVar));
                if (b != null && b.length > 0) {
                    if (b.length > 10240) {
                        com.xiaomi.channel.commonutils.logger.b.m11394a("TinyData write to cache file failed case too much data content item:" + hkVar.d() + "  ts:" + System.currentTimeMillis());
                        com.xiaomi.push.x.a((Closeable) null);
                        com.xiaomi.push.x.a((Closeable) null);
                        return;
                    }
                    context = new BufferedOutputStream(new FileOutputStream(new File(context.getFilesDir(), "tiny_data.data"), true));
                    try {
                        context.write(com.xiaomi.push.ab.a(b.length));
                        context.write(b);
                        context.flush();
                        com.xiaomi.push.x.a((Closeable) null);
                        com.xiaomi.push.x.a((Closeable) context);
                        return;
                    } catch (IOException e) {
                        e = e;
                        closeable2 = context;
                        StringBuilder sb = new StringBuilder("TinyData write to cache file failed cause io exception item:");
                        Closeable closeable3 = closeable2;
                        sb.append(hkVar.d());
                        Closeable closeable4 = closeable2;
                        com.xiaomi.channel.commonutils.logger.b.a(sb.toString(), e);
                        com.xiaomi.push.x.a((Closeable) null);
                        com.xiaomi.push.x.a(closeable2);
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        closeable = context;
                        StringBuilder sb2 = new StringBuilder("TinyData write to cache file  failed item:");
                        Closeable closeable5 = closeable;
                        sb2.append(hkVar.d());
                        Closeable closeable6 = closeable;
                        com.xiaomi.channel.commonutils.logger.b.a(sb2.toString(), e);
                        com.xiaomi.push.x.a((Closeable) null);
                        com.xiaomi.push.x.a(closeable);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        com.xiaomi.push.x.a((Closeable) null);
                        com.xiaomi.push.x.a((Closeable) context);
                        throw th;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("TinyData write to cache file failed case encryption fail item:" + hkVar.d() + "  ts:" + System.currentTimeMillis());
                com.xiaomi.push.x.a((Closeable) null);
                com.xiaomi.push.x.a((Closeable) null);
            } catch (IOException e3) {
                e = e3;
                closeable2 = null;
            } catch (Exception e4) {
                e = e4;
                closeable = null;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}

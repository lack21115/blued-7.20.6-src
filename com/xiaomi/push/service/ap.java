package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.push.du;
import com.xiaomi.push.ff;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ap.class */
public class ap {

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f935a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: a  reason: collision with root package name */
    private static long f27919a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f934a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private static String a(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception e) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb2 = sb.toString();
                    com.xiaomi.push.x.a(bufferedReader);
                    return sb2;
                }
                sb.append("\n");
                sb.append(readLine);
            }
        } catch (Exception e2) {
            com.xiaomi.push.x.a(bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            com.xiaomi.push.x.a(bufferedReader);
            throw th;
        }
    }

    public static void a() {
        du.a m9122a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f934a.getActiveCount() <= 0 || currentTimeMillis - f27919a >= 1800000) && ff.m8697a().m8702a() && (m9122a = bv.a().m9122a()) != null && m9122a.e() > 0) {
            f27919a = currentTimeMillis;
            a(m9122a.m8580a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f934a.execute(new aq(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m8344a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.m8344a(a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.m8344a("ConnectivityTest: begin to connect to ".concat(String.valueOf(str)));
            Socket socket = new Socket();
            socket.connect(com.xiaomi.push.cr.m8544a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.m8344a("ConnectivityTest: connect to " + str + " in " + (currentTimeMillis2 - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}

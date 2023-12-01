package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/G1g37.class */
public final class G1g37 {

    /* renamed from: a  reason: collision with root package name */
    public static final long f26185a = TimeUnit.HOURS.toMillis(32);
    public static final G1g37 b = new G1g37();

    /* renamed from: c  reason: collision with root package name */
    public volatile QjsR0 f26186c = null;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final ReentrantReadWriteLock e = new ReentrantReadWriteLock();

    public final long a(Context context, String str, long j, long j2) {
        String a2 = a(context, str);
        if (a2 == null) {
            return j;
        }
        try {
            return Long.parseLong(a2) * j2;
        } catch (NumberFormatException e) {
            return j;
        }
    }

    public final String a(Context context) {
        String a2 = a(context, "a_f_ok_c");
        String a3 = a(context, "a_f_ok_s");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(a2)) {
            String[] split = a2.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = split[i2];
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
                i = i2 + 1;
            }
        }
        if (!TextUtils.isEmpty(a3) && context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            String[] split2 = a3.split(",");
            int length2 = split2.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                }
                String str2 = split2[i4];
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
                i3 = i4 + 1;
            }
        }
        if (hashSet.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public final String a(Context context, String str) {
        Map<String, String> map;
        QjsR0 b2 = b(context);
        if (b2 == null || (map = b2.k) == null) {
            return null;
        }
        return map.get(str);
    }

    public final boolean a(Context context, String str, boolean z) {
        String a2 = a(context, str);
        if (a2 == null) {
            return z;
        }
        try {
            return Integer.parseInt(a2) > 0;
        } catch (NumberFormatException e) {
            return z;
        }
    }

    public final QjsR0 b(Context context) {
        QjsR0 qjsR0;
        this.e.readLock().lock();
        try {
            if (this.d.get()) {
                return this.f26186c;
            }
            synchronized (this.d) {
                if (this.d.get()) {
                    return this.f26186c;
                }
                try {
                    QjsR0 qjsR02 = new QjsR0();
                    qjsR02.a(new nyvKz(com.tencent.turingcam.oqKCa.e(c(context))));
                    qjsR0 = qjsR02;
                } catch (Throwable th) {
                    qjsR0 = null;
                }
                this.f26186c = qjsR0;
                this.d.set(true);
                return this.f26186c;
            }
        } finally {
            this.e.readLock().unlock();
        }
    }

    public final String c(Context context) {
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("12");
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath() + str + com.tencent.turingcam.oqKCa.f26140a + "_mfa_1";
        }
        return "";
    }
}

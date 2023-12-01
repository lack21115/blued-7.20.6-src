package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hc.class */
public class hc {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f41466a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/hc$a.class */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f41467a;

        /* renamed from: a  reason: collision with other field name */
        private hf f542a;

        public a(Context context, hf hfVar) {
            this.f542a = hfVar;
            this.f41467a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            hc.c(this.f41467a, this.f542a);
        }
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void a(Context context, hf hfVar) {
        ai.a(context).a(new a(context, hfVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0119, code lost:
        r9 = "TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:".concat(java.lang.String.valueOf(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r6, com.xiaomi.push.hf r7, java.io.File r8, byte[] r9) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.hc.a(android.content.Context, com.xiaomi.push.hf, java.io.File, byte[]):void");
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0153  */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.nio.channels.FileLock] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r5, com.xiaomi.push.hf r6) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.hc.c(android.content.Context, com.xiaomi.push.hf):void");
    }
}

package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/t.class */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f28019a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f1041a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f1042a;

    /* renamed from: a  reason: collision with other field name */
    private String f1043a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f1044a;

    private t(Context context) {
        this.f1041a = context;
    }

    public static t a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (f28019a.add(str)) {
            t tVar = new t(context);
            tVar.f1043a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                tVar.f1042a = randomAccessFile;
                tVar.f1044a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + tVar.f1044a);
                return tVar;
            } finally {
                if (tVar.f1044a == null) {
                    RandomAccessFile randomAccessFile2 = tVar.f1042a;
                    if (randomAccessFile2 != null) {
                        x.a(randomAccessFile2);
                    }
                    f28019a.remove(tVar.f1043a);
                }
            }
        }
        throw new IOException("abtain lock failure");
    }

    public final void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f1044a);
        FileLock fileLock = this.f1044a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f1044a.release();
            } catch (IOException e) {
            }
            this.f1044a = null;
        }
        RandomAccessFile randomAccessFile = this.f1042a;
        if (randomAccessFile != null) {
            x.a(randomAccessFile);
        }
        f28019a.remove(this.f1043a);
    }
}

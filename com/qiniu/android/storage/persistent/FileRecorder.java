package com.qiniu.android.storage.persistent;

import com.baidu.mobads.sdk.internal.bj;
import com.qiniu.android.storage.Recorder;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/persistent/FileRecorder.class */
public final class FileRecorder implements Recorder {
    public String directory;

    public FileRecorder(String str) throws IOException {
        this.directory = str;
        File file = new File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("does not mkdir");
            }
        } else if (!file.mkdirs()) {
            throw new IOException("mkdir failed");
        }
    }

    private static String hash(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return stringBuffer.toString();
                }
                stringBuffer.append(Integer.toString((digest[i2] & 255) + 256, 16).substring(1));
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean outOfDate(File file) {
        return file.lastModified() + bj.e < new Date().getTime();
    }

    @Override // com.qiniu.android.storage.Recorder
    public void del(String str) {
        new File(this.directory, hash(str)).delete();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] get(java.lang.String r6) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.directory
            r3 = r6
            java.lang.String r3 = hash(r3)
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r5
            r1 = r6
            boolean r0 = r0.outOfDate(r1)     // Catch: java.io.IOException -> L45
            if (r0 == 0) goto L1f
            r0 = r6
            boolean r0 = r0.delete()     // Catch: java.io.IOException -> L45
            r0 = 0
            return r0
        L1f:
            r0 = r6
            long r0 = r0.length()     // Catch: java.io.IOException -> L45
            int r0 = (int) r0     // Catch: java.io.IOException -> L45
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L45
            r8 = r0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L3e java.io.IOException -> L45
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: java.io.IOException -> L3e
            r6 = r0
            r0 = r6
            r1 = r8
            int r0 = r0.read(r1)     // Catch: java.io.IOException -> L39
            r7 = r0
            goto L52
        L39:
            r9 = move-exception
            goto L4b
        L3e:
            r9 = move-exception
            r0 = 0
            r6 = r0
            goto L4b
        L45:
            r9 = move-exception
            r0 = 0
            r8 = r0
            r0 = r8
            r6 = r0
        L4b:
            r0 = r9
            r0.printStackTrace()
            r0 = 0
            r7 = r0
        L52:
            r0 = r6
            if (r0 == 0) goto L62
            r0 = r6
            r0.close()     // Catch: java.io.IOException -> L5d
            goto L62
        L5d:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L62:
            r0 = r7
            if (r0 != 0) goto L68
            r0 = 0
            return r0
        L68:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.persistent.FileRecorder.get(java.lang.String):byte[]");
    }

    @Override // com.qiniu.android.storage.Recorder
    public String getFileName() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void set(java.lang.String r6, byte[] r7) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.directory
            r3 = r6
            java.lang.String r3 = hash(r3)
            r1.<init>(r2, r3)
            r6 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L25
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: java.io.IOException -> L25
            r6 = r0
            r0 = r6
            r1 = r7
            r0.write(r1)     // Catch: java.io.IOException -> L21
            goto L2c
        L21:
            r7 = move-exception
            goto L28
        L25:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L28:
            r0 = r7
            r0.printStackTrace()
        L2c:
            r0 = r6
            if (r0 == 0) goto L3a
            r0 = r6
            r0.close()     // Catch: java.io.IOException -> L35
            return
        L35:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.persistent.FileRecorder.set(java.lang.String, byte[]):void");
    }
}

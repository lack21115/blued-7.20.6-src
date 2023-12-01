package com.qiniu.android.storage.persistent;

import com.qiniu.android.http.custom.DnsCacheKey;
import com.qiniu.android.storage.Recorder;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/persistent/DnsCacheFile.class */
public class DnsCacheFile implements Recorder {
    public String directory;
    public File f;

    public DnsCacheFile(String str) throws IOException {
        this.directory = str;
        File file = new File(str);
        this.f = file;
        if (file.exists()) {
            if (!this.f.isDirectory()) {
                throw new IOException("does not mkdir");
            }
        } else if (!this.f.mkdirs()) {
            throw new IOException("mkdir failed");
        }
    }

    @Override // com.qiniu.android.storage.Recorder
    public void del(String str) {
        if (str != null) {
            new File(this.directory, str).delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            long r0 = r0.length()     // Catch: java.io.IOException -> L33
            int r0 = (int) r0     // Catch: java.io.IOException -> L33
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L33
            r8 = r0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> L2c java.io.IOException -> L33
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: java.io.IOException -> L2c
            r6 = r0
            r0 = r6
            r1 = r8
            int r0 = r0.read(r1)     // Catch: java.io.IOException -> L27
            r7 = r0
            goto L40
        L27:
            r9 = move-exception
            goto L39
        L2c:
            r9 = move-exception
            r0 = 0
            r6 = r0
            goto L39
        L33:
            r9 = move-exception
            r0 = 0
            r8 = r0
            r0 = r8
            r6 = r0
        L39:
            r0 = r9
            r0.printStackTrace()
            r0 = 0
            r7 = r0
        L40:
            r0 = r6
            if (r0 == 0) goto L50
            r0 = r6
            r0.close()     // Catch: java.io.IOException -> L4b
            goto L50
        L4b:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L50:
            r0 = r7
            if (r0 != 0) goto L56
            r0 = 0
            return r0
        L56:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.persistent.DnsCacheFile.get(java.lang.String):byte[]");
    }

    @Override // com.qiniu.android.storage.Recorder
    public String getFileName() {
        File[] listFiles = this.f.listFiles();
        if (listFiles == null) {
            return null;
        }
        int i = 1;
        if (listFiles.length == 1) {
            return listFiles[0].getName();
        }
        if (listFiles.length > 1) {
            long j = 0;
            String str = null;
            while (i < listFiles.length) {
                String name = listFiles[i].getName();
                DnsCacheKey cacheKey = DnsCacheKey.toCacheKey(name);
                if (cacheKey == null) {
                    return null;
                }
                long parseLong = Long.parseLong(cacheKey.getCurrentTime());
                String str2 = str;
                long j2 = j;
                if (parseLong > j) {
                    del(str);
                    str2 = name;
                    j2 = parseLong;
                }
                i++;
                str = str2;
                j = j2;
            }
            return str;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.qiniu.android.storage.Recorder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void set(java.lang.String r6, byte[] r7) {
        /*
            r5 = this;
            r0 = r5
            java.io.File r0 = r0.f
            java.io.File[] r0 = r0.listFiles()
            r9 = r0
            r0 = r9
            if (r0 != 0) goto Lf
            return
        Lf:
            r0 = r9
            int r0 = r0.length
            if (r0 <= 0) goto L30
            r0 = 0
            r8 = r0
        L17:
            r0 = r8
            r1 = r9
            int r1 = r1.length
            if (r0 >= r1) goto L30
            r0 = r5
            r1 = r9
            r2 = r8
            r1 = r1[r2]
            java.lang.String r1 = r1.getName()
            r0.del(r1)
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L17
        L30:
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r5
            java.lang.String r2 = r2.directory
            r3 = r6
            r1.<init>(r2, r3)
            r6 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L52
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: java.io.IOException -> L52
            r6 = r0
            r0 = r6
            r1 = r7
            r0.write(r1)     // Catch: java.io.IOException -> L4e
            goto L59
        L4e:
            r7 = move-exception
            goto L55
        L52:
            r7 = move-exception
            r0 = 0
            r6 = r0
        L55:
            r0 = r7
            r0.printStackTrace()
        L59:
            r0 = r6
            if (r0 == 0) goto L67
            r0 = r6
            r0.close()     // Catch: java.io.IOException -> L62
            return
        L62:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.storage.persistent.DnsCacheFile.set(java.lang.String, byte[]):void");
    }
}

package com.meizu.cloud.pushsdk.b;

import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f23987a = new SimpleDateFormat("yyyy-MM-dd");
    private final d b = new d("lo");

    /* renamed from: c  reason: collision with root package name */
    private BufferedWriter f23988c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/e$a.class */
    public class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
            if (i > 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }
    }

    public void a() throws IOException {
        BufferedWriter bufferedWriter = this.f23988c;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.f23988c.close();
            this.f23988c = null;
        }
    }

    void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.b.e.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(".log.txt");
            }
        });
        if (listFiles != null) {
            if (listFiles.length > 7) {
                Arrays.sort(listFiles, new a());
                for (int i = 7; i < listFiles.length; i++) {
                    listFiles[i].delete();
                }
            }
        }
    }

    public void a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("create " + str + " dir failed!!!");
        }
        String format = this.f23987a.format(new Date());
        File file2 = new File(str, format + ".log.txt");
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                Log.e("EncryptionWriter", "create new file " + format + " failed !!!");
            }
        }
        this.f23988c = new BufferedWriter(new FileWriter(file2, true));
    }

    public void a(String str, String str2, String str3) throws IOException {
        if (this.f23988c != null) {
            this.f23988c.write(this.b.a((str + str2 + " " + str3).getBytes()));
            this.f23988c.write(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
    }
}

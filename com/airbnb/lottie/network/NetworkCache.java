package com.airbnb.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.Logger;
import com.anythink.china.common.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/network/NetworkCache.class */
class NetworkCache {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4395a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetworkCache(Context context, String str) {
        this.f4395a = context.getApplicationContext();
        this.b = str;
    }

    private File a(String str) throws FileNotFoundException {
        File file = new File(this.f4395a.getCacheDir(), a(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f4395a.getCacheDir(), a(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String a(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.a() : fileExtension.f4394c);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<FileExtension, InputStream> a() {
        try {
            File a2 = a(this.b);
            if (a2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(a2);
            FileExtension fileExtension = a2.getAbsolutePath().endsWith(".zip") ? FileExtension.ZIP : FileExtension.JSON;
            Logger.a("Cache hit for " + this.b + " at " + a2.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(this.f4395a.getCacheDir(), a(this.b, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FileExtension fileExtension) {
        File file = new File(this.f4395a.getCacheDir(), a(this.b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(a.e, ""));
        boolean renameTo = file.renameTo(file2);
        Logger.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        Logger.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }
}

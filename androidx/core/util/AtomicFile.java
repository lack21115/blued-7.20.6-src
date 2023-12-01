package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/AtomicFile.class */
public class AtomicFile {

    /* renamed from: a  reason: collision with root package name */
    private final File f2594a;
    private final File b;

    /* renamed from: c  reason: collision with root package name */
    private final File f2595c;

    public AtomicFile(File file) {
        this.f2594a = file;
        this.b = new File(file.getPath() + ".new");
        this.f2595c = new File(file.getPath() + ".bak");
    }

    private static void a(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
    }

    private static boolean a(FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void delete() {
        this.f2594a.delete();
        this.b.delete();
        this.f2595c.delete();
    }

    public void failWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!a(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        if (this.b.delete()) {
            return;
        }
        Log.e("AtomicFile", "Failed to delete new file " + this.b);
    }

    public void finishWrite(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!a(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        a(this.b, this.f2594a);
    }

    public File getBaseFile() {
        return this.f2594a;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f2595c.exists()) {
            a(this.f2595c, this.f2594a);
        }
        if (this.b.exists() && this.f2594a.exists() && !this.b.delete()) {
            Log.e("AtomicFile", "Failed to delete outdated new file " + this.b);
        }
        return new FileInputStream(this.f2594a);
    }

    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i = 0;
            while (true) {
                int read = openRead.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    openRead.close();
                    return bArr;
                }
                int i2 = i + read;
                int available = openRead.available();
                i = i2;
                if (available > bArr.length - i2) {
                    byte[] bArr2 = new byte[available + i2];
                    System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, i2);
                    bArr = bArr2;
                    i = i2;
                }
            }
        } catch (Throwable th) {
            openRead.close();
            throw th;
        }
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.f2595c.exists()) {
            a(this.f2595c, this.f2594a);
        }
        try {
            return new FileOutputStream(this.b);
        } catch (FileNotFoundException e) {
            if (!this.b.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.b);
            }
            try {
                return new FileOutputStream(this.b);
            } catch (FileNotFoundException e2) {
                throw new IOException("Failed to create new file " + this.b, e2);
            }
        }
    }
}

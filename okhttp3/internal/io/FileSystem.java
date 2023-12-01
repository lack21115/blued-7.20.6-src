package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/io/FileSystem.class */
public interface FileSystem {
    public static final FileSystem a = new FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.io.FileSystem
        public Source a(File file) throws FileNotFoundException {
            return Okio.source(file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public void a(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.io.FileSystem
        public Sink b(File file) throws FileNotFoundException {
            try {
                return Okio.sink(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return Okio.sink(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public Sink c(File file) throws FileNotFoundException {
            try {
                return Okio.appendingSink(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return Okio.appendingSink(file);
            }
        }

        @Override // okhttp3.internal.io.FileSystem
        public boolean d(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.io.FileSystem
        public long e(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.io.FileSystem
        public void f(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                File file2 = listFiles[i2];
                if (file2.isDirectory()) {
                    f(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
                i = i2 + 1;
            }
        }
    };

    Source a(File file) throws FileNotFoundException;

    void a(File file, File file2) throws IOException;

    Sink b(File file) throws FileNotFoundException;

    Sink c(File file) throws FileNotFoundException;

    boolean d(File file);

    void delete(File file) throws IOException;

    long e(File file);

    void f(File file) throws IOException;
}

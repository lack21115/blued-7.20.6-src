package com.android.internal.util;

import android.os.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FileRotator.class */
public class FileRotator {
    private static final boolean LOGD = false;
    private static final String SUFFIX_BACKUP = ".backup";
    private static final String SUFFIX_NO_BACKUP = ".no_backup";
    private static final String TAG = "FileRotator";
    private final File mBasePath;
    private final long mDeleteAgeMillis;
    private final String mPrefix;
    private final long mRotateAgeMillis;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FileRotator$FileInfo.class */
    public static class FileInfo {
        public long endMillis;
        public final String prefix;
        public long startMillis;

        public FileInfo(String str) {
            this.prefix = (String) Preconditions.checkNotNull(str);
        }

        public String build() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.prefix).append('.').append(this.startMillis).append('-');
            if (this.endMillis != Long.MAX_VALUE) {
                sb.append(this.endMillis);
            }
            return sb.toString();
        }

        public boolean isActive() {
            return this.endMillis == Long.MAX_VALUE;
        }

        public boolean parse(String str) {
            this.endMillis = -1L;
            this.startMillis = -1L;
            int lastIndexOf = str.lastIndexOf(46);
            int lastIndexOf2 = str.lastIndexOf(45);
            if (lastIndexOf == -1 || lastIndexOf2 == -1 || !this.prefix.equals(str.substring(0, lastIndexOf))) {
                return false;
            }
            try {
                this.startMillis = Long.parseLong(str.substring(lastIndexOf + 1, lastIndexOf2));
                if (str.length() - lastIndexOf2 == 1) {
                    this.endMillis = Long.MAX_VALUE;
                    return true;
                }
                this.endMillis = Long.parseLong(str.substring(lastIndexOf2 + 1));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FileRotator$Reader.class */
    public interface Reader {
        void read(InputStream inputStream) throws IOException;
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FileRotator$Rewriter.class */
    public interface Rewriter extends Reader, Writer {
        void reset();

        boolean shouldWrite();
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/FileRotator$Writer.class */
    public interface Writer {
        void write(OutputStream outputStream) throws IOException;
    }

    public FileRotator(File file, String str, long j, long j2) {
        this.mBasePath = (File) Preconditions.checkNotNull(file);
        this.mPrefix = (String) Preconditions.checkNotNull(str);
        this.mRotateAgeMillis = j;
        this.mDeleteAgeMillis = j2;
        this.mBasePath.mkdirs();
        String[] list = this.mBasePath.list();
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = list[i2];
            if (str2.startsWith(this.mPrefix)) {
                if (str2.endsWith(SUFFIX_BACKUP)) {
                    new File(this.mBasePath, str2).renameTo(new File(this.mBasePath, str2.substring(0, str2.length() - SUFFIX_BACKUP.length())));
                } else if (str2.endsWith(SUFFIX_NO_BACKUP)) {
                    File file2 = new File(this.mBasePath, str2);
                    File file3 = new File(this.mBasePath, str2.substring(0, str2.length() - SUFFIX_NO_BACKUP.length()));
                    file2.delete();
                    file3.delete();
                }
            }
            i = i2 + 1;
        }
    }

    private String getActiveName(long j) {
        String str;
        long j2;
        String str2 = null;
        long j3 = Long.MAX_VALUE;
        FileInfo fileInfo = new FileInfo(this.mPrefix);
        String[] list = this.mBasePath.list();
        int length = list.length;
        int i = 0;
        while (i < length) {
            String str3 = list[i];
            if (fileInfo.parse(str3)) {
                str = str2;
                j2 = j3;
                if (fileInfo.isActive()) {
                    str = str2;
                    j2 = j3;
                    if (fileInfo.startMillis < j) {
                        str = str2;
                        j2 = j3;
                        if (fileInfo.startMillis < j3) {
                            str = str3;
                            j2 = fileInfo.startMillis;
                        }
                    }
                }
            } else {
                j2 = j3;
                str = str2;
            }
            i++;
            str2 = str;
            j3 = j2;
        }
        if (str2 != null) {
            return str2;
        }
        fileInfo.startMillis = j;
        fileInfo.endMillis = Long.MAX_VALUE;
        return fileInfo.build();
    }

    private static void readFile(File file, Reader reader) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            reader.read(bufferedInputStream);
        } finally {
            IoUtils.closeQuietly(bufferedInputStream);
        }
    }

    private static IOException rethrowAsIoException(Throwable th) throws IOException {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        throw new IOException(th.getMessage(), th);
    }

    private void rewriteSingle(Rewriter rewriter, String str) throws IOException {
        File file = new File(this.mBasePath, str);
        rewriter.reset();
        if (!file.exists()) {
            File file2 = new File(this.mBasePath, str + SUFFIX_NO_BACKUP);
            file2.createNewFile();
            try {
                writeFile(file, rewriter);
                file2.delete();
                return;
            } catch (Throwable th) {
                file.delete();
                file2.delete();
                throw rethrowAsIoException(th);
            }
        }
        readFile(file, rewriter);
        if (rewriter.shouldWrite()) {
            File file3 = new File(this.mBasePath, str + SUFFIX_BACKUP);
            file.renameTo(file3);
            try {
                writeFile(file, rewriter);
                file3.delete();
            } catch (Throwable th2) {
                file.delete();
                file3.renameTo(file);
                throw rethrowAsIoException(th2);
            }
        }
    }

    private static void writeFile(File file, Writer writer) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        try {
            writer.write(bufferedOutputStream);
            bufferedOutputStream.flush();
        } finally {
            FileUtils.sync(fileOutputStream);
            IoUtils.closeQuietly(bufferedOutputStream);
        }
    }

    @Deprecated
    public void combineActive(final Reader reader, final Writer writer, long j) throws IOException {
        rewriteActive(new Rewriter() { // from class: com.android.internal.util.FileRotator.1
            @Override // com.android.internal.util.FileRotator.Reader
            public void read(InputStream inputStream) throws IOException {
                reader.read(inputStream);
            }

            @Override // com.android.internal.util.FileRotator.Rewriter
            public void reset() {
            }

            @Override // com.android.internal.util.FileRotator.Rewriter
            public boolean shouldWrite() {
                return true;
            }

            @Override // com.android.internal.util.FileRotator.Writer
            public void write(OutputStream outputStream) throws IOException {
                writer.write(outputStream);
            }
        }, j);
    }

    public void deleteAll() {
        FileInfo fileInfo = new FileInfo(this.mPrefix);
        String[] list = this.mBasePath.list();
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = list[i2];
            if (fileInfo.parse(str)) {
                new File(this.mBasePath, str).delete();
            }
            i = i2 + 1;
        }
    }

    public void dumpAll(OutputStream outputStream) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        try {
            FileInfo fileInfo = new FileInfo(this.mPrefix);
            String[] list = this.mBasePath.list();
            int length = list.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str = list[i2];
                if (fileInfo.parse(str)) {
                    zipOutputStream.putNextEntry(new ZipEntry(str));
                    FileInputStream fileInputStream = new FileInputStream(new File(this.mBasePath, str));
                    Streams.copy(fileInputStream, zipOutputStream);
                    IoUtils.closeQuietly(fileInputStream);
                    zipOutputStream.closeEntry();
                }
                i = i2 + 1;
            }
        } finally {
            IoUtils.closeQuietly(zipOutputStream);
        }
    }

    public void maybeRotate(long j) {
        long j2 = this.mRotateAgeMillis;
        long j3 = this.mDeleteAgeMillis;
        FileInfo fileInfo = new FileInfo(this.mPrefix);
        String[] list = this.mBasePath.list();
        if (list == null) {
            return;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = list[i2];
            if (fileInfo.parse(str)) {
                if (fileInfo.isActive()) {
                    if (fileInfo.startMillis <= j - j2) {
                        fileInfo.endMillis = j;
                        new File(this.mBasePath, str).renameTo(new File(this.mBasePath, fileInfo.build()));
                    }
                } else if (fileInfo.endMillis <= j - j3) {
                    new File(this.mBasePath, str).delete();
                }
            }
            i = i2 + 1;
        }
    }

    public void readMatching(Reader reader, long j, long j2) throws IOException {
        FileInfo fileInfo = new FileInfo(this.mPrefix);
        String[] list = this.mBasePath.list();
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = list[i2];
            if (fileInfo.parse(str) && fileInfo.startMillis <= j2 && j <= fileInfo.endMillis) {
                readFile(new File(this.mBasePath, str), reader);
            }
            i = i2 + 1;
        }
    }

    public void rewriteActive(Rewriter rewriter, long j) throws IOException {
        rewriteSingle(rewriter, getActiveName(j));
    }

    public void rewriteAll(Rewriter rewriter) throws IOException {
        FileInfo fileInfo = new FileInfo(this.mPrefix);
        String[] list = this.mBasePath.list();
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = list[i2];
            if (fileInfo.parse(str)) {
                rewriteSingle(rewriter, str);
            }
            i = i2 + 1;
        }
    }
}

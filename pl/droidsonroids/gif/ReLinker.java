package pl.droidsonroids.gif;

import android.content.Context;
import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/ReLinker.class */
public class ReLinker {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44168a = System.mapLibraryName("pl_droidsonroids_gif");

    private ReLinker() {
    }

    private static ZipEntry a(ZipFile zipFile) {
        String[] b = b();
        int length = b.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            ZipEntry a2 = a(zipFile, b[i2]);
            if (a2 != null) {
                return a2;
            }
            i = i2 + 1;
        }
    }

    private static ZipEntry a(ZipFile zipFile, String str) {
        return zipFile.getEntry("lib/" + str + BridgeUtil.SPLIT_MARK + f44168a);
    }

    private static ZipFile a(File file) {
        ZipFile zipFile;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                zipFile = null;
                break;
            }
            try {
                zipFile = new ZipFile(file, 1);
                break;
            } catch (IOException e) {
                i = i2 + 1;
            }
        }
        if (zipFile != null) {
            return zipFile;
        }
        throw new IllegalStateException("Could not open APK file: " + file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        synchronized (ReLinker.class) {
            try {
                System.load(b(context).getAbsolutePath());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private static void a(File file, FilenameFilter filenameFilter) {
        File[] listFiles = file.getParentFile().listFiles(filenameFilter);
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            listFiles[i2].delete();
            i = i2 + 1;
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static File b(Context context) {
        ZipFile zipFile;
        InputStream inputStream;
        InputStream inputStream2;
        OutputStream outputStream;
        FileOutputStream fileOutputStream;
        String str = f44168a + "1.2.7";
        int i = 0;
        File file = new File(context.getDir("lib", 0), str);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(context.getCacheDir(), str);
        if (file2.isFile()) {
            return file2;
        }
        final String mapLibraryName = System.mapLibraryName("pl_droidsonroids_gif_surface");
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: pl.droidsonroids.gif.ReLinker.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file3, String str2) {
                return str2.startsWith(ReLinker.f44168a) || str2.startsWith(String.this);
            }
        };
        a(file, filenameFilter);
        a(file2, filenameFilter);
        try {
            ZipFile a2 = a(new File(context.getApplicationInfo().sourceDir));
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                try {
                    ZipEntry a3 = a(a2);
                    if (a3 == null) {
                        throw new IllegalStateException("Library " + f44168a + " for supported ABIs not found in APK file");
                    }
                    try {
                        inputStream = a2.getInputStream(a3);
                    } catch (IOException e) {
                        inputStream2 = null;
                        outputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = null;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e2) {
                        inputStream2 = inputStream;
                        outputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        a(inputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                    try {
                        a(inputStream, fileOutputStream);
                        a(inputStream);
                        a(fileOutputStream);
                        b(file);
                        break;
                    } catch (IOException e3) {
                        inputStream2 = inputStream;
                        outputStream = fileOutputStream;
                        if (i2 > 2) {
                            file = file2;
                        }
                        a(inputStream2);
                        a(outputStream);
                        i = i2;
                    } catch (Throwable th3) {
                        th = th3;
                        a(inputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipFile = a2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
                i = i2;
            }
            if (a2 != null) {
                try {
                    a2.close();
                } catch (IOException e5) {
                    return file;
                }
            }
            return file;
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
        }
    }

    private static void b(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    private static String[] b() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }
}

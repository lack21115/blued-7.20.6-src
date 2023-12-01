package android.os;

import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

/* loaded from: source-9557208-dex2jar.jar:android/os/FileUtils.class */
public class FileUtils {
    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;
    private static final String TAG = "FileUtils";

    public static String buildValidExtFilename(String str) {
        if (TextUtils.isEmpty(str) || ".".equals(str) || "..".equals(str)) {
            return "(invalid)";
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (isValidExtFilenameChar(charAt)) {
                sb.append(charAt);
            } else {
                sb.append('_');
            }
            i = i2 + 1;
        }
    }

    public static String buildValidFatFilename(String str) {
        if (TextUtils.isEmpty(str) || ".".equals(str) || "..".equals(str)) {
            return "(invalid)";
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (isValidFatFilenameChar(charAt)) {
                sb.append(charAt);
            } else {
                sb.append('_');
            }
            i = i2 + 1;
        }
    }

    public static long checksumCrc32(File file) throws FileNotFoundException, IOException {
        CRC32 crc32 = new CRC32();
        CheckedInputStream checkedInputStream = null;
        try {
            CheckedInputStream checkedInputStream2 = new CheckedInputStream(new FileInputStream(file), crc32);
            try {
                do {
                } while (checkedInputStream2.read(new byte[128]) >= 0);
                long value = crc32.getValue();
                if (checkedInputStream2 != null) {
                    try {
                        checkedInputStream2.close();
                    } catch (IOException e) {
                        return value;
                    }
                }
                return value;
            } catch (Throwable th) {
                checkedInputStream = checkedInputStream2;
                th = th;
                if (checkedInputStream != null) {
                    try {
                        checkedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean contains(File file, File file2) {
        if (file2 == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        String str = absolutePath;
        if (!absolutePath.endsWith("/")) {
            str = absolutePath + "/";
        }
        return absolutePath2.startsWith(str);
    }

    public static boolean copyFile(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            boolean copyToFile = copyToFile(fileInputStream, file2);
            fileInputStream.close();
            return copyToFile;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        boolean z2 = true;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = z2;
                if (i2 >= length) {
                    break;
                }
                File file2 = listFiles[i2];
                boolean z3 = z2;
                if (file2.isDirectory()) {
                    z3 = z2 & deleteContents(file2);
                }
                z2 = z3;
                if (!file2.delete()) {
                    Log.w(TAG, "Failed to delete " + file2);
                    z2 = false;
                }
                i = i2 + 1;
            }
        }
        return z;
    }

    public static boolean deleteOlderFiles(File file, int i, long j) {
        boolean z;
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Constraints must be positive or 0");
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: android.os.FileUtils.1
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return (int) (file3.lastModified() - file2.lastModified());
                }
            });
            boolean z2 = false;
            while (true) {
                boolean z3 = z2;
                z = z3;
                if (i >= listFiles.length) {
                    break;
                }
                File file2 = listFiles[i];
                boolean z4 = z3;
                if (System.currentTimeMillis() - file2.lastModified() > j) {
                    z4 = z3;
                    if (file2.delete()) {
                        Log.d(TAG, "Deleted old file " + file2);
                        z4 = true;
                    }
                }
                i++;
                z2 = z4;
            }
        } else {
            z = false;
        }
        return z;
    }

    public static int getUid(String str) {
        try {
            return Os.stat(str).st_uid;
        } catch (ErrnoException e) {
            return -1;
        }
    }

    public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    public static boolean isValidExtFilename(String str) {
        return str != null && str.equals(buildValidExtFilename(str));
    }

    private static boolean isValidExtFilenameChar(char c2) {
        switch (c2) {
            case 0:
            case '/':
                return false;
            default:
                return true;
        }
    }

    public static boolean isValidFatFilename(String str) {
        return str != null && str.equals(buildValidFatFilename(str));
    }

    private static boolean isValidFatFilenameChar(char c2) {
        if (c2 < 0 || c2 > 31) {
            switch (c2) {
                case '\"':
                case '*':
                case '/':
                case ':':
                case '<':
                case '>':
                case '?':
                case '\\':
                case '|':
                case 127:
                    return false;
                default:
                    return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e7, code lost:
        if (r0 < r8) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readTextFile(java.io.File r7, int r8, java.lang.String r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.FileUtils.readTextFile(java.io.File, int, java.lang.String):java.lang.String");
    }

    public static File rewriteAfterRename(File file, File file2, File file3) {
        if (file3 != null && contains(file, file3)) {
            return new File(file2, file3.getAbsolutePath().substring(file.getAbsolutePath().length()));
        }
        return null;
    }

    public static String rewriteAfterRename(File file, File file2, String str) {
        File rewriteAfterRename;
        if (str == null || (rewriteAfterRename = rewriteAfterRename(file, file2, new File(str))) == null) {
            return null;
        }
        return rewriteAfterRename.getAbsolutePath();
    }

    public static String[] rewriteAfterRename(File file, File file2, String[] strArr) {
        String[] strArr2;
        if (strArr != null) {
            String[] strArr3 = new String[strArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                strArr2 = strArr3;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr3[i2] = rewriteAfterRename(file, file2, strArr[i2]);
                i = i2 + 1;
            }
        } else {
            strArr2 = null;
        }
        return strArr2;
    }

    public static int setPermissions(File file, int i, int i2, int i3) {
        return setPermissions(file.getAbsolutePath(), i, i2, i3);
    }

    public static int setPermissions(FileDescriptor fileDescriptor, int i, int i2, int i3) {
        try {
            Os.fchmod(fileDescriptor, i);
            if (i2 >= 0 || i3 >= 0) {
                try {
                    Os.fchown(fileDescriptor, i2, i3);
                    return 0;
                } catch (ErrnoException e) {
                    Slog.w(TAG, "Failed to fchown(): " + e);
                    return e.errno;
                }
            }
            return 0;
        } catch (ErrnoException e2) {
            Slog.w(TAG, "Failed to fchmod(): " + e2);
            return e2.errno;
        }
    }

    public static int setPermissions(String str, int i, int i2, int i3) {
        try {
            Os.chmod(str, i);
            if (i2 >= 0 || i3 >= 0) {
                try {
                    Os.chown(str, i2, i3);
                    return 0;
                } catch (ErrnoException e) {
                    Slog.w(TAG, "Failed to chown(" + str + "): " + e);
                    return e.errno;
                }
            }
            return 0;
        } catch (ErrnoException e2) {
            Slog.w(TAG, "Failed to chmod(" + str + "): " + e2);
            return e2.errno;
        }
    }

    public static void stringToFile(String str, String str2) throws IOException {
        FileWriter fileWriter = new FileWriter(str);
        try {
            fileWriter.write(str2);
        } finally {
            fileWriter.close();
        }
    }

    public static boolean sync(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }
}

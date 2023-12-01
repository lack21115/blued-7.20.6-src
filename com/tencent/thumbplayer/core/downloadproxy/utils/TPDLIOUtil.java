package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/utils/TPDLIOUtil.class */
public class TPDLIOUtil {
    private static final String FILE_NAME = "TPDLIOUtil";
    private static final String PROTOCOL_ASSET = "asset";
    private static final String PROTOCOL_FILE = "file";
    private static final String PROTOCOL_HTTP = "http";
    private static final String PROTOCOL_HTTPS = "https";
    private static Pattern PROTOCOL_PATTERN = Pattern.compile("^(\\w+):/{2,3}");
    private static Pattern PATH_PATTERN = Pattern.compile("^(\\w+):/{2,3}(.*)");

    public static File compare(File file, File file2) {
        if (file == null) {
            return file2;
        }
        if (file2 != null && file2.exists()) {
            if (file.exists() && file.lastModified() > file2.lastModified()) {
                return file;
            }
            return file2;
        }
        return file;
    }

    public static int copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        if (file == null || file2 == null || !file.exists()) {
            return 0;
        }
        if (!file2.exists()) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                return 0;
            }
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return 0;
            }
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
            } catch (FileNotFoundException e) {
                fileOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (FileNotFoundException e2) {
            fileOutputStream2 = null;
            fileInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileInputStream = null;
        }
        try {
            int copy = copy(fileInputStream, fileOutputStream2);
            try {
                fileInputStream.close();
            } catch (IOException e3) {
            }
            try {
                fileOutputStream2.close();
                return copy;
            } catch (IOException e4) {
                return copy;
            }
        } catch (FileNotFoundException e5) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    return 0;
                } catch (IOException e7) {
                    return 0;
                }
            }
            return 0;
        } catch (Throwable th3) {
            fileOutputStream = fileOutputStream2;
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e8) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e9) {
                }
            }
            throw th;
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        int i;
        if (inputStream == null || outputStream == null) {
            return 0;
        }
        byte[] bArr = new byte[1024];
        int i2 = 0;
        while (true) {
            try {
                i = i2;
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return i;
                }
                outputStream.write(bArr, 0, read);
                i2 = i + read;
            } catch (IOException e) {
                return i;
            }
        }
    }

    public static boolean createFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        if (createParentDirectories(file)) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean createFile(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return createFile(new File(str));
    }

    public static boolean createParentDirectories(File file) {
        if (file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            return true;
        }
        return parentFile.mkdirs();
    }

    public static boolean createParentDirectories(String str) {
        return createParentDirectories(new File(str));
    }

    public static String getPath(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = PATH_PATTERN.matcher(str);
        String str2 = str;
        if (matcher.find()) {
            str2 = str;
            if (matcher.group(1).equals(PROTOCOL_ASSET)) {
                str2 = matcher.group(2);
            }
        }
        return str2;
    }

    public static String getProtocol(String str) {
        if (str == null || str.length() <= 0) {
            return "file";
        }
        Matcher matcher = PROTOCOL_PATTERN.matcher(str);
        return matcher.find() ? matcher.group(1) : "file";
    }

    public static boolean isExternalStorageMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static boolean isRemoteFile(String str) {
        String protocol = getProtocol(str);
        return protocol.equals("https") || protocol.equals("http");
    }

    public static InputStream open(Context context, String str) {
        String protocol = getProtocol(str);
        if (protocol.equals(PROTOCOL_ASSET)) {
            try {
                return context.getAssets().open(getPath(str));
            } catch (IOException e) {
                return null;
            }
        } else if (protocol.equals("file")) {
            try {
                return new FileInputStream(getPath(str));
            } catch (Exception e2) {
                return null;
            }
        } else if (protocol.equals("http") || protocol.equals("https")) {
            try {
                return new URL(str).openStream();
            } catch (Exception e3) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static InputStream openInputStream(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static InputStream openInputStream(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return openInputStream(new File(str));
    }

    public static OutputStream openOutputStream(File file) {
        if (file == null || !createFile(file)) {
            return null;
        }
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static OutputStream openOutputStream(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return openOutputStream(new File(str));
    }

    public static void recursiveDelete(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            int length = listFiles.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= length) {
                                    break;
                                }
                                recursiveDelete(listFiles[i2]);
                                i = i2 + 1;
                            }
                        } else {
                            return;
                        }
                    }
                    TPDLProxyLog.d(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "recursiveDelete: delete=".concat(String.valueOf(file.delete())));
                }
            } catch (Exception e) {
                TPDLProxyLog.d(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "recursiveDelete failed, error:" + e.toString());
            }
        }
    }

    public static boolean write(File file, byte[] bArr, int i, int i2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (file == null || bArr == null || bArr.length <= 0) {
            return false;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs()) {
                return false;
            }
            try {
                if (!file.createNewFile()) {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }
        }
        try {
            fileOutputStream2 = new FileOutputStream(file);
        } catch (Exception e2) {
            fileOutputStream2 = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream2.write(bArr, i, i2);
            try {
                fileOutputStream2.close();
                return true;
            } catch (IOException e3) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "write error:" + e3.toString());
                return true;
            }
        } catch (Exception e4) {
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                    return false;
                } catch (IOException e5) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "write error:" + e5.toString());
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            fileOutputStream = fileOutputStream2;
            th = th2;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "write error:" + e6.toString());
                }
            }
            throw th;
        }
    }
}

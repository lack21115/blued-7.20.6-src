package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/utils/h.class */
public final class h {
    public static final char atf = File.separatorChar;
    public static final String atg;

    static {
        PrintWriter printWriter;
        StringBuilderWriter stringBuilderWriter;
        PrintWriter printWriter2;
        StringBuilderWriter stringBuilderWriter2;
        StringBuilderWriter stringBuilderWriter3;
        String str;
        PrintWriter printWriter3;
        try {
            stringBuilderWriter = new StringBuilderWriter(4);
            try {
                printWriter3 = new PrintWriter(stringBuilderWriter);
                stringBuilderWriter3 = stringBuilderWriter;
                printWriter = printWriter3;
            } catch (Exception e) {
                e = e;
                stringBuilderWriter2 = stringBuilderWriter;
                printWriter2 = null;
            } catch (Throwable th) {
                th = th;
                printWriter = null;
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            printWriter2 = null;
            stringBuilderWriter2 = null;
        } catch (Throwable th2) {
            th = th2;
            printWriter = null;
            stringBuilderWriter = null;
        }
        try {
            try {
                printWriter3.println();
                String stringBuilderWriter4 = stringBuilderWriter.toString();
                b.closeQuietly(printWriter3);
                b.closeQuietly(stringBuilderWriter);
                str = stringBuilderWriter4;
            } catch (Throwable th3) {
                stringBuilderWriter = stringBuilderWriter3;
                th = th3;
                b.closeQuietly(printWriter);
                b.closeQuietly(stringBuilderWriter);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            stringBuilderWriter2 = stringBuilderWriter;
            printWriter2 = printWriter3;
            stringBuilderWriter3 = stringBuilderWriter2;
            printWriter = printWriter2;
            e.printStackTrace();
            b.closeQuietly(printWriter2);
            b.closeQuietly(stringBuilderWriter2);
            str = "\n";
            atg = str;
        }
        atg = str;
    }

    public static String B(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            inputStream = open;
            String a2 = a(open, a.a(Charset.defaultCharset()));
            b.closeQuietly(open);
            return a2;
        } catch (Throwable th) {
            b.closeQuietly(inputStream);
            throw th;
        }
    }

    public static String D(File file) {
        return a(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), a.UTF_8));
    }

    public static long E(File file) {
        try {
            if (file.exists()) {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getAvailableBlocks() : statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static long F(File file) {
        try {
            if (file.exists()) {
                StatFs statFs = new StatFs(file.getAbsolutePath());
                return Build.VERSION.SDK_INT < 18 ? statFs.getBlockSize() * statFs.getBlockCount() : statFs.getBlockSizeLong() * statFs.getBlockCountLong();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static int a(Reader reader, Writer writer) {
        long b = b(reader, writer);
        if (b > 2147483647L) {
            return -1;
        }
        return (int) b;
    }

    private static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            long j2 = j;
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j = j2 + read;
        }
    }

    private static long a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            long j2 = j;
            int read = reader.read(cArr);
            if (-1 == read) {
                return j2;
            }
            writer.write(cArr, 0, read);
            j = j2 + read;
        }
    }

    public static String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    String str = new String(byteArrayOutputStream.toByteArray());
                    b.closeQuietly(inputStream);
                    b.closeQuietly(byteArrayOutputStream);
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (IOException e) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th) {
                b.closeQuietly(inputStream);
                b.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static String a(InputStream inputStream, Charset charset) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(inputStream, stringBuilderWriter, charset);
        return stringBuilderWriter.toString();
    }

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    String stringWriter3 = stringWriter.toString();
                    b.closeQuietly(reader);
                    b.closeQuietly(stringWriter);
                    return stringWriter3;
                }
                stringWriter.write(cArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            b.closeQuietly(reader);
            b.closeQuietly(stringWriter);
            throw th;
        }
    }

    private static void a(InputStream inputStream, Writer writer, Charset charset) {
        a(new InputStreamReader(inputStream, a.a(charset)), writer);
    }

    public static void a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(a.a(charset)));
        }
    }

    private static long b(Reader reader, Writer writer) {
        return a(reader, writer, new char[4096]);
    }

    public static String b(Reader reader) {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        a(reader, stringBuilderWriter);
        return stringBuilderWriter.toString();
    }

    public static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            bufferedReader = null;
        }
        try {
            String a2 = a(bufferedReader);
            b.closeQuietly(bufferedReader);
            b.closeQuietly(inputStreamReader);
            return a2;
        } catch (Throwable th3) {
            th = th3;
            b.closeQuietly(bufferedReader);
            b.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    public static String d(InputStream inputStream) {
        return a(inputStream, Charset.defaultCharset());
    }

    public static int g(InputStream inputStream, OutputStream outputStream) {
        long h = h(inputStream, outputStream);
        if (h > 2147483647L) {
            return -1;
        }
        return (int) h;
    }

    public static void g(String str, String str2, boolean z) {
        FileWriter fileWriter;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileWriter = new FileWriter(str, false);
        } catch (Throwable th) {
            fileWriter = null;
        }
        try {
            fileWriter.write(str2);
            fileWriter.flush();
            b.closeQuietly(fileWriter);
        } catch (Throwable th2) {
            b.closeQuietly(fileWriter);
        }
    }

    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return E(new File(str));
    }

    public static long getTotalBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return F(new File(str));
    }

    private static long h(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, new byte[4096]);
    }
}

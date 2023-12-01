package com.sobot.chat.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/IOUtils.class */
public class IOUtils {
    public static boolean canRead(String str) {
        return new File(str).canRead();
    }

    public static boolean canWrite(String str) {
        return new File(str).canWrite();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        BufferedInputStream bufferedInputStream = toBufferedInputStream(inputStream);
        BufferedInputStream bufferedInputStream2 = toBufferedInputStream(inputStream2);
        int read = bufferedInputStream.read();
        while (true) {
            int i = read;
            boolean z = false;
            if (-1 == i) {
                if (bufferedInputStream2.read() == -1) {
                    z = true;
                }
                return z;
            } else if (i != bufferedInputStream2.read()) {
                return false;
            } else {
                read = bufferedInputStream.read();
            }
        }
    }

    public static boolean contentEquals(Reader reader, Reader reader2) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        int read = bufferedReader.read();
        while (true) {
            int i = read;
            boolean z = false;
            if (-1 == i) {
                if (bufferedReader2.read() == -1) {
                    z = true;
                }
                return z;
            } else if (i != bufferedReader2.read()) {
                return false;
            } else {
                read = bufferedReader.read();
            }
        }
    }

    public static boolean contentEqualsIgnoreEOL(Reader reader, Reader reader2) throws IOException {
        String str;
        BufferedReader bufferedReader = toBufferedReader(reader);
        BufferedReader bufferedReader2 = toBufferedReader(reader2);
        String readLine = bufferedReader.readLine();
        String readLine2 = bufferedReader2.readLine();
        while (true) {
            str = readLine2;
            if (readLine == null || str == null || !readLine.equals(str)) {
                break;
            }
            readLine = bufferedReader.readLine();
            readLine2 = bufferedReader2.readLine();
        }
        if (readLine != null) {
            return str == null || readLine.equals(str);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.InputStream] */
    public static boolean copyFile(Context context, String str, Uri uri) {
        OutputStream outputStream;
        FileInputStream fileInputStream;
        if (uri == null) {
            return false;
        }
        try {
            try {
                outputStream = context.getContentResolver().openOutputStream(uri);
                if (outputStream == null) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                            return false;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    return false;
                }
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                                return false;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return false;
                            }
                        }
                        return false;
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        boolean copyFileWithStream = copyFileWithStream(outputStream, fileInputStream);
                        try {
                            fileInputStream.close();
                            if (outputStream != null) {
                                outputStream.close();
                                return copyFileWithStream;
                            }
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return copyFileWithStream;
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return false;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                            return false;
                        }
                        return false;
                    } catch (Throwable th) {
                        uri = fileInputStream;
                        th = th;
                        if (uri != null) {
                            try {
                                uri.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileInputStream = null;
                }
            } catch (Exception e8) {
                e = e8;
                outputStream = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                uri = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static boolean copyFileWithStream(OutputStream outputStream, InputStream inputStream) {
        if (outputStream == null) {
            return false;
        }
        try {
            if (inputStream == null) {
                return false;
            }
            try {
                byte[] bArr = new byte[1444];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        try {
                            outputStream.close();
                            inputStream.close();
                            return true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return true;
                        }
                    }
                    outputStream.write(bArr, 0, read);
                    outputStream.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    outputStream.close();
                    inputStream.close();
                    return false;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return false;
                }
            }
        } catch (Throwable th) {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static boolean createFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                return true;
            }
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean createFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFile(new File(str));
    }

    public static boolean createFolder(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            file.delete();
        }
        return file.mkdirs();
    }

    public static boolean createFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createFolder(new File(str));
    }

    public static boolean createNewFile(File file) {
        if (file.exists()) {
            delFileOrFolder(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean createNewFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return createNewFile(new File(str));
    }

    public static boolean createNewFolder(File file) {
        return delFileOrFolder(file) && createFolder(file);
    }

    public static boolean createNewFolder(String str) {
        return delFileOrFolder(str) && createFolder(str);
    }

    public static boolean delFileOrFolder(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    delFileOrFolder(listFiles[i2]);
                    i = i2 + 1;
                }
            }
            file.delete();
            return true;
        } else {
            return true;
        }
    }

    public static boolean delFileOrFolder(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return delFileOrFolder(new File(str));
    }

    public static void flushQuietly(Flushable flushable) {
        if (flushable == null) {
            return;
        }
        try {
            flushable.flush();
        } catch (Exception e) {
        }
    }

    public static long getDirSize(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return Build.VERSION.SDK_INT >= 18 ? getStatFsSize(statFs, "getBlockSizeLong", "getAvailableBlocksLong") : getStatFsSize(statFs, "getBlockSize", "getAvailableBlocks");
        } catch (Exception e) {
            return 0L;
        }
    }

    private static String getHeaderFileName(Response response) {
        String header = response.header("Content-Disposition");
        if (header != null) {
            String replaceAll = header.replaceAll("\"", "");
            int indexOf = replaceAll.indexOf("filename=");
            if (indexOf != -1) {
                return replaceAll.substring(indexOf + 9, replaceAll.length());
            }
            int indexOf2 = replaceAll.indexOf("filename*=");
            if (indexOf2 != -1) {
                String substring = replaceAll.substring(indexOf2 + 10, replaceAll.length());
                String str = substring;
                if (substring.startsWith("UTF-8''")) {
                    str = substring.substring(7, substring.length());
                }
                return str;
            }
            return null;
        }
        return null;
    }

    public static String getNetFileName(Response response, String str) {
        String headerFileName = getHeaderFileName(response);
        String str2 = headerFileName;
        if (TextUtils.isEmpty(headerFileName)) {
            str2 = getUrlFileName(str);
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "unknownfile_" + System.currentTimeMillis();
        }
        try {
            return URLDecoder.decode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str3;
        }
    }

    private static long getStatFsSize(StatFs statFs, String str, String str2) {
        try {
            Method method = statFs.getClass().getMethod(str, new Class[0]);
            method.setAccessible(true);
            Method method2 = statFs.getClass().getMethod(str2, new Class[0]);
            method2.setAccessible(true);
            return ((Long) method.invoke(statFs, new Object[0])).longValue() * ((Long) method2.invoke(statFs, new Object[0])).longValue();
        } catch (Throwable th) {
            return 0L;
        }
    }

    private static String getUrlFileName(String str) {
        int indexOf;
        String[] split = str.split("/");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (split.length > 0) {
                    return split[split.length - 1];
                }
                return null;
            }
            String str2 = split[i2];
            if (str2.contains("?") && (indexOf = str2.indexOf("?")) != -1) {
                return str2.substring(0, indexOf);
            }
            i = i2 + 1;
        }
    }

    public static List<String> readLines(InputStream inputStream) throws IOException {
        return readLines(new InputStreamReader(inputStream));
    }

    public static List<String> readLines(InputStream inputStream, String str) throws IOException {
        return readLines(new InputStreamReader(inputStream, str));
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = toBufferedReader(reader);
        ArrayList arrayList = new ArrayList();
        String readLine = bufferedReader.readLine();
        while (true) {
            String str = readLine;
            if (str == null) {
                return arrayList;
            }
            arrayList.add(str);
            readLine = bufferedReader.readLine();
        }
    }

    public static BufferedInputStream toBufferedInputStream(InputStream inputStream) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
    }

    public static BufferedOutputStream toBufferedOutputStream(OutputStream outputStream) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
    }

    public static BufferedReader toBufferedReader(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    public static BufferedWriter toBufferedWriter(Writer writer) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(Reader reader, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(reader, byteArrayOutputStream, str);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] toByteArray(CharSequence charSequence) {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes();
    }

    public static byte[] toByteArray(CharSequence charSequence, String str) throws UnsupportedEncodingException {
        return charSequence == null ? new byte[0] : charSequence.toString().getBytes(str);
    }

    public static byte[] toByteArray(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e) {
                objectOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                closeQuietly(objectOutputStream);
                closeQuietly(byteArrayOutputStream);
                return byteArray;
            } catch (IOException e2) {
                objectOutputStream2 = objectOutputStream;
                closeQuietly(objectOutputStream2);
                closeQuietly(byteArrayOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(objectOutputStream);
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            byteArrayOutputStream = null;
            objectOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            objectOutputStream = null;
        }
    }

    public static char[] toCharArray(InputStream inputStream) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(InputStream inputStream, String str) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(inputStream, charArrayWriter, str);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(Reader reader) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(reader, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static char[] toCharArray(CharSequence charSequence) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        write(charSequence, charArrayWriter);
        return charArrayWriter.toCharArray();
    }

    public static InputStream toInputStream(CharSequence charSequence) {
        return new ByteArrayInputStream(charSequence.toString().getBytes());
    }

    public static InputStream toInputStream(CharSequence charSequence, String str) throws UnsupportedEncodingException {
        return new ByteArrayInputStream(charSequence.toString().getBytes(str));
    }

    public static Object toObject(byte[] bArr) {
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2;
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ObjectInputStream objectInputStream3 = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object readObject = objectInputStream3.readObject();
                    closeQuietly(objectInputStream3);
                    closeQuietly(byteArrayInputStream);
                    return readObject;
                } catch (Exception e) {
                    objectInputStream2 = objectInputStream3;
                    closeQuietly(objectInputStream2);
                    closeQuietly(byteArrayInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream = byteArrayInputStream;
                    objectInputStream = objectInputStream3;
                    closeQuietly(objectInputStream);
                    closeQuietly(inputStream);
                    throw th;
                }
            } catch (Exception e2) {
                objectInputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = byteArrayInputStream;
                objectInputStream = null;
            }
        } catch (Exception e3) {
            objectInputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            objectInputStream = null;
        }
    }

    public static String toString(InputStream inputStream) throws IOException {
        return new String(toByteArray(inputStream));
    }

    public static String toString(InputStream inputStream, String str) throws IOException {
        return new String(toByteArray(inputStream), str);
    }

    public static String toString(Reader reader) throws IOException {
        return new String(toByteArray(reader));
    }

    public static String toString(Reader reader, String str) throws IOException {
        return new String(toByteArray(reader), str);
    }

    public static String toString(byte[] bArr) {
        return new String(bArr);
    }

    public static String toString(byte[] bArr, String str) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    public static void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void write(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        write(new InputStreamReader(inputStream, str), outputStream);
    }

    public static void write(InputStream inputStream, Writer writer) throws IOException {
        write(new InputStreamReader(inputStream), writer);
    }

    public static void write(InputStream inputStream, Writer writer, String str) throws IOException {
        write(new InputStreamReader(inputStream, str), writer);
    }

    public static void write(Reader reader, OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        write(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void write(Reader reader, OutputStream outputStream, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, str);
        write(reader, outputStreamWriter);
        outputStreamWriter.flush();
    }

    public static void write(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes());
        }
    }

    public static void write(CharSequence charSequence, OutputStream outputStream, String str) throws IOException {
        if (charSequence != null) {
            outputStream.write(charSequence.toString().getBytes(str));
        }
    }

    public static void write(CharSequence charSequence, Writer writer) throws IOException {
        if (charSequence != null) {
            writer.write(charSequence.toString());
        }
    }

    public static void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public static void write(byte[] bArr, Writer writer) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr));
        }
    }

    public static void write(byte[] bArr, Writer writer, String str) throws IOException {
        if (bArr != null) {
            writer.write(new String(bArr, str));
        }
    }

    public static void write(char[] cArr, OutputStream outputStream) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes());
        }
    }

    public static void write(char[] cArr, OutputStream outputStream, String str) throws IOException {
        if (cArr != null) {
            outputStream.write(new String(cArr).getBytes(str));
        }
    }

    public static void write(char[] cArr, Writer writer) throws IOException {
        if (cArr != null) {
            writer.write(cArr);
        }
    }
}

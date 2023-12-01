package com.huawei.hms.opendevice;

import com.huawei.hms.ads.uiengineloader.ae;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/p.class */
public abstract class p {
    public static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int read = inputStream.read();
        while (true) {
            int i = read;
            if (-1 == i) {
                String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                a((Closeable) inputStream);
                IOUtil.closeSecure((OutputStream) byteArrayOutputStream);
                return byteArrayOutputStream2;
            }
            byteArrayOutputStream.write(i);
            read = inputStream.read();
        }
    }

    public static String a(String str) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (FileNotFoundException e) {
                            HMSLog.e(ae.f22542a, "file not exist.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (IOException e2) {
                            HMSLog.e(ae.f22542a, "read value IOException.");
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            IOUtils.closeQuietly((Reader) inputStreamReader);
                            IOUtils.closeQuietly((Reader) bufferedReader2);
                            throw th;
                        }
                    }
                    IOUtils.closeQuietly((Reader) inputStreamReader);
                    IOUtils.closeQuietly((Reader) bufferedReader);
                } catch (FileNotFoundException e3) {
                    bufferedReader = null;
                } catch (IOException e4) {
                    bufferedReader = null;
                }
            } catch (FileNotFoundException e5) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (IOException e6) {
                inputStreamReader = null;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            return sb.toString();
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                HMSLog.w(ae.f22542a, "close IOException");
            }
        }
    }

    public static void a(File file) throws IOException {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null) {
            HMSLog.e(ae.f22542a, "parent file is null.");
            throw new IOException("parent file is null");
        } else if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            HMSLog.e(ae.f22542a, "make parent dirs failed.");
            throw new IOException("make parent dirs failed");
        } else if (file.createNewFile()) {
        } else {
            HMSLog.e(ae.f22542a, "create file failed.");
            throw new IOException("create file failed");
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                HMSLog.w(ae.f22542a, "close HttpURLConnection Exception");
            }
        }
    }
}

package cn.com.chinatelecom.account.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4079a = a.class.getSimpleName();

    public static String a(Context context, String str, String str2) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        String str3;
        InputStream inputStream2;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str4 = "";
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.addRequestProperty(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                if (TextUtils.isEmpty(str2)) {
                    httpURLConnection.connect();
                } else {
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                    dataOutputStream.write(str2.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream3 = httpURLConnection.getInputStream();
                    try {
                        StringBuilder sb = new StringBuilder();
                        bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream3));
                        while (true) {
                            try {
                                String readLine = bufferedReader3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append("\n");
                            } catch (Throwable th) {
                                th = th;
                                th = th;
                                bufferedReader = bufferedReader3;
                                inputStream = inputStream3;
                                try {
                                    th.printStackTrace();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    str3 = str4;
                                    if (inputStream != null) {
                                        inputStream.close();
                                        str3 = str4;
                                    }
                                    return str3;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            throw th2;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th2;
                                }
                            }
                        }
                        str4 = sb.toString();
                        bufferedReader2 = bufferedReader3;
                        inputStream2 = inputStream3;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader3 = null;
                    }
                } else {
                    inputStream2 = null;
                    bufferedReader2 = null;
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                str3 = str4;
                if (inputStream2 != null) {
                    inputStream2.close();
                    return str4;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedReader = null;
            }
            return str3;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

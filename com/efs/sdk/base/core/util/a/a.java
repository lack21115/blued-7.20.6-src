package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.http.IHttpUtil;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/a/a.class */
public final class a implements IHttpUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.efs.sdk.base.core.util.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/a/a$a.class */
    public static final class C0165a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f8181a = new a((byte) 0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0165a.f8181a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.efs.sdk.base.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.efs.sdk.base.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r0v110, types: [com.efs.sdk.base.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r0v189, types: [com.efs.sdk.base.http.HttpResponse] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.net.HttpURLConnection] */
    private static HttpResponse a(String str, Map<String, String> map, File file, byte[] bArr) {
        FileInputStream fileInputStream;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        DataOutputStream dataOutputStream2;
        FileInputStream fileInputStream2;
        HttpURLConnection httpURLConnection3;
        OutputStream outputStream2;
        OutputStream outputStream3;
        OutputStream outputStream4;
        FileInputStream fileInputStream3;
        ?? httpResponse = new HttpResponse();
        OutputStream outputStream5 = null;
        HttpURLConnection httpURLConnection4 = null;
        DataOutputStream dataOutputStream3 = null;
        try {
            try {
                HttpURLConnection a2 = a(str, map);
                try {
                    a2.setRequestMethod("POST");
                    a2.setRequestProperty("Connection", "close");
                    a2.setRequestProperty("Content-Type", "multipart/form-data;boundary=----WebKitFormBoundaryP0Rfzlf32iRoMhmb");
                    OutputStream outputStream6 = a2.getOutputStream();
                    try {
                        DataOutputStream dataOutputStream4 = new DataOutputStream(outputStream6);
                        FileInputStream fileInputStream4 = null;
                        FileInputStream fileInputStream5 = null;
                        FileInputStream fileInputStream6 = null;
                        try {
                            dataOutputStream4.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                            if (bArr == null) {
                                if (file != null && file.exists()) {
                                    StringBuilder sb = new StringBuilder("Content-Disposition: form-data;name=\"file\";filename=\"");
                                    sb.append(file.getName());
                                    sb.append("\"\r\n");
                                    dataOutputStream4.writeBytes(sb.toString());
                                    dataOutputStream4.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                                    fileInputStream = new FileInputStream(file);
                                    try {
                                        byte[] bArr2 = new byte[4096];
                                        while (true) {
                                            int read = fileInputStream.read(bArr2);
                                            if (read == -1) {
                                                break;
                                            }
                                            dataOutputStream4.write(bArr2, 0, read);
                                        }
                                        fileInputStream3 = fileInputStream;
                                    } catch (SocketTimeoutException e) {
                                        e = e;
                                        outputStream4 = outputStream6;
                                        dataOutputStream2 = dataOutputStream4;
                                        httpURLConnection4 = a2;
                                        outputStream = outputStream4;
                                        e = e;
                                        httpResponse.setHttpCode(-3);
                                        HttpURLConnection httpURLConnection5 = httpURLConnection4;
                                        StringBuilder sb2 = new StringBuilder("post file '");
                                        HttpURLConnection httpURLConnection6 = httpURLConnection4;
                                        sb2.append(str);
                                        HttpURLConnection httpURLConnection7 = httpURLConnection4;
                                        sb2.append("' error");
                                        HttpURLConnection httpURLConnection8 = httpURLConnection4;
                                        outputStream5 = outputStream;
                                        dataOutputStream3 = dataOutputStream2;
                                        fileInputStream2 = fileInputStream;
                                        Log.e("efs.util.http", sb2.toString(), e);
                                        httpURLConnection3 = httpURLConnection4;
                                        dataOutputStream = dataOutputStream2;
                                        b(httpURLConnection3);
                                        com.efs.sdk.base.core.util.b.a(outputStream);
                                        com.efs.sdk.base.core.util.b.a(dataOutputStream);
                                        com.efs.sdk.base.core.util.b.a(fileInputStream);
                                        map = httpResponse;
                                        map.setReqUrl(str);
                                        return map;
                                    } catch (UnknownHostException e2) {
                                        e = e2;
                                        outputStream3 = outputStream6;
                                        dataOutputStream = dataOutputStream4;
                                        httpURLConnection2 = a2;
                                        outputStream = outputStream3;
                                        e = e;
                                        httpResponse.setHttpCode(-2);
                                        HttpURLConnection httpURLConnection9 = httpURLConnection2;
                                        StringBuilder sb3 = new StringBuilder("post file '");
                                        HttpURLConnection httpURLConnection10 = httpURLConnection2;
                                        sb3.append(str);
                                        HttpURLConnection httpURLConnection11 = httpURLConnection2;
                                        sb3.append("' error， maybe network is disconnect");
                                        HttpURLConnection httpURLConnection12 = httpURLConnection2;
                                        outputStream5 = outputStream;
                                        dataOutputStream3 = dataOutputStream;
                                        fileInputStream2 = fileInputStream;
                                        Log.e("efs.util.http", sb3.toString(), e);
                                        httpURLConnection3 = httpURLConnection2;
                                        b(httpURLConnection3);
                                        com.efs.sdk.base.core.util.b.a(outputStream);
                                        com.efs.sdk.base.core.util.b.a(dataOutputStream);
                                        com.efs.sdk.base.core.util.b.a(fileInputStream);
                                        map = httpResponse;
                                        map.setReqUrl(str);
                                        return map;
                                    } catch (Throwable th) {
                                        th = th;
                                        outputStream2 = outputStream6;
                                        dataOutputStream = dataOutputStream4;
                                        httpURLConnection = a2;
                                        outputStream = outputStream2;
                                        th = th;
                                        StringBuilder sb4 = new StringBuilder("post file '");
                                        HttpURLConnection httpURLConnection13 = httpURLConnection;
                                        sb4.append(str);
                                        HttpURLConnection httpURLConnection14 = httpURLConnection;
                                        sb4.append("' error");
                                        HttpURLConnection httpURLConnection15 = httpURLConnection;
                                        outputStream5 = outputStream;
                                        dataOutputStream3 = dataOutputStream;
                                        fileInputStream2 = fileInputStream;
                                        Log.e("efs.util.http", sb4.toString(), th);
                                        httpURLConnection3 = httpURLConnection;
                                        b(httpURLConnection3);
                                        com.efs.sdk.base.core.util.b.a(outputStream);
                                        com.efs.sdk.base.core.util.b.a(dataOutputStream);
                                        com.efs.sdk.base.core.util.b.a(fileInputStream);
                                        map = httpResponse;
                                        map.setReqUrl(str);
                                        return map;
                                    }
                                }
                                b(a2);
                                com.efs.sdk.base.core.util.b.a(outputStream6);
                                com.efs.sdk.base.core.util.b.a(dataOutputStream4);
                                com.efs.sdk.base.core.util.b.a((Closeable) null);
                                return httpResponse;
                            }
                            dataOutputStream4.writeBytes("Content-Disposition: form-data;name=\"file\";filename=\"f\"\r\n");
                            dataOutputStream4.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                            dataOutputStream4.write(bArr, 0, bArr.length);
                            fileInputStream3 = null;
                            dataOutputStream4.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                            FileInputStream fileInputStream7 = fileInputStream3;
                            dataOutputStream4.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                            fileInputStream4 = fileInputStream3;
                            fileInputStream5 = fileInputStream3;
                            fileInputStream6 = fileInputStream3;
                            ?? a3 = a(a2);
                            b(a2);
                            com.efs.sdk.base.core.util.b.a(outputStream6);
                            com.efs.sdk.base.core.util.b.a(dataOutputStream4);
                            com.efs.sdk.base.core.util.b.a(fileInputStream3);
                            map = a3;
                        } catch (SocketTimeoutException e3) {
                            e = e3;
                            fileInputStream = fileInputStream5;
                            outputStream4 = outputStream6;
                            dataOutputStream2 = dataOutputStream4;
                        } catch (UnknownHostException e4) {
                            e = e4;
                            fileInputStream = fileInputStream6;
                            outputStream3 = outputStream6;
                            dataOutputStream = dataOutputStream4;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream4;
                            outputStream2 = outputStream6;
                            dataOutputStream = dataOutputStream4;
                        }
                    } catch (SocketTimeoutException e5) {
                        e = e5;
                        fileInputStream = null;
                        dataOutputStream2 = null;
                        outputStream4 = outputStream6;
                    } catch (UnknownHostException e6) {
                        fileInputStream = null;
                        outputStream3 = outputStream6;
                        dataOutputStream = null;
                        e = e6;
                    } catch (Throwable th3) {
                        fileInputStream = null;
                        outputStream2 = outputStream6;
                        dataOutputStream = null;
                        th = th3;
                    }
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    fileInputStream = null;
                    outputStream4 = null;
                    dataOutputStream2 = null;
                } catch (UnknownHostException e8) {
                    e = e8;
                    fileInputStream = null;
                    outputStream3 = null;
                    dataOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    outputStream2 = null;
                    dataOutputStream = null;
                }
            } catch (SocketTimeoutException e9) {
                e = e9;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream2 = null;
            } catch (UnknownHostException e10) {
                e = e10;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
                httpURLConnection2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                outputStream = null;
                dataOutputStream = null;
                httpURLConnection = null;
            }
            map.setReqUrl(str);
            return map;
        } catch (Throwable th6) {
            b(map);
            com.efs.sdk.base.core.util.b.a(outputStream5);
            com.efs.sdk.base.core.util.b.a(dataOutputStream3);
            com.efs.sdk.base.core.util.b.a(fileInputStream2);
            throw th6;
        }
    }

    private static HttpResponse a(HttpURLConnection httpURLConnection) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        HttpResponse httpResponse = new HttpResponse();
        if (httpURLConnection == null) {
            return httpResponse;
        }
        try {
            httpResponse.setHttpCode(httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            Log.e("efs.util.http", "get response error", th);
                            com.efs.sdk.base.core.util.b.a(inputStream);
                            com.efs.sdk.base.core.util.b.a(byteArrayOutputStream);
                            return httpResponse;
                        } catch (Throwable th2) {
                            com.efs.sdk.base.core.util.b.a(inputStream);
                            com.efs.sdk.base.core.util.b.a(byteArrayOutputStream);
                            throw th2;
                        }
                    }
                }
                httpResponse.data = byteArrayOutputStream.toString();
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
        }
        com.efs.sdk.base.core.util.b.a(inputStream);
        com.efs.sdk.base.core.util.b.a(byteArrayOutputStream);
        return httpResponse;
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        Map<String, String> map2 = map;
        if (map == null) {
            map2 = Collections.emptyMap();
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    private static void b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            try {
                com.efs.sdk.base.core.util.b.a(httpURLConnection.getInputStream());
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    public final HttpResponse get(String str, Map<String, String> map) {
        HttpResponse httpResponse;
        HttpURLConnection httpURLConnection;
        HttpResponse httpResponse2 = new HttpResponse();
        while (true) {
            httpResponse = httpResponse2;
            if (0 >= 3) {
                break;
            }
            HttpURLConnection httpURLConnection2 = null;
            HttpURLConnection httpURLConnection3 = null;
            try {
                HttpURLConnection a2 = a(str, map);
                a2.setRequestMethod("GET");
                a2.setInstanceFollowRedirects(true);
                a2.setRequestProperty("Connection", "close");
                a2.connect();
                httpURLConnection2 = a2;
                httpURLConnection3 = a2;
                HttpResponse a3 = a(a2);
                b(a2);
                httpResponse = a3;
                break;
            } catch (SocketTimeoutException e) {
                try {
                    httpResponse2.setHttpCode(-3);
                    HttpURLConnection httpURLConnection4 = httpURLConnection2;
                    StringBuilder sb = new StringBuilder("post file '");
                    HttpURLConnection httpURLConnection5 = httpURLConnection2;
                    sb.append(str);
                    HttpURLConnection httpURLConnection6 = httpURLConnection2;
                    sb.append("' error");
                    HttpURLConnection httpURLConnection7 = httpURLConnection2;
                    Log.e("efs.util.http", sb.toString(), e);
                    httpURLConnection = httpURLConnection2;
                }
            } catch (UnknownHostException e2) {
                httpResponse2.setHttpCode(-2);
                HttpURLConnection httpURLConnection8 = httpURLConnection3;
                StringBuilder sb2 = new StringBuilder("get request '");
                HttpURLConnection httpURLConnection9 = httpURLConnection3;
                sb2.append(str);
                HttpURLConnection httpURLConnection10 = httpURLConnection3;
                sb2.append("' error， maybe network is disconnect");
                HttpURLConnection httpURLConnection11 = httpURLConnection3;
                Log.e("efs.util.http", sb2.toString(), e2);
                httpURLConnection = httpURLConnection3;
            }
            b(httpURLConnection);
        }
        httpResponse.setReqUrl(str);
        return httpResponse;
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    public final HttpResponse post(String str, Map<String, String> map, File file) {
        return a(str, map, file, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.Closeable] */
    @Override // com.efs.sdk.base.http.IHttpUtil
    public final HttpResponse post(String str, Map<String, String> map, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        UnknownHostException e;
        HttpResponse httpResponse = new HttpResponse();
        OutputStream outputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = a(str, map);
                OutputStream outputStream3 = null;
                OutputStream outputStream4 = null;
                OutputStream outputStream5 = null;
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Connection", "close");
                    OutputStream outputStream6 = httpURLConnection.getOutputStream();
                    outputStream6.write(bArr);
                    outputStream3 = outputStream6;
                    outputStream4 = outputStream6;
                    outputStream5 = outputStream6;
                    outputStream = outputStream6;
                    outputStream2 = a(httpURLConnection);
                } catch (SocketTimeoutException e2) {
                    outputStream = outputStream4;
                    e = e2;
                    httpResponse.setHttpCode(-3);
                    OutputStream outputStream7 = outputStream;
                    StringBuilder sb = new StringBuilder("post file '");
                    OutputStream outputStream8 = outputStream;
                    sb.append(str);
                    OutputStream outputStream9 = outputStream;
                    sb.append("' error");
                    OutputStream outputStream10 = outputStream;
                    httpURLConnection2 = httpURLConnection;
                    Log.e("efs.util.http", sb.toString(), e);
                    outputStream2 = httpResponse;
                    outputStream2.setReqUrl(str);
                    return outputStream2;
                } catch (UnknownHostException e3) {
                    e = e3;
                    outputStream = outputStream5;
                    httpResponse.setHttpCode(-2);
                    OutputStream outputStream11 = outputStream;
                    StringBuilder sb2 = new StringBuilder("post data to '");
                    OutputStream outputStream12 = outputStream;
                    sb2.append(str);
                    OutputStream outputStream13 = outputStream;
                    sb2.append("' error， maybe network is disconnect");
                    OutputStream outputStream14 = outputStream;
                    httpURLConnection2 = httpURLConnection;
                    Log.e("efs.util.http", sb2.toString(), e);
                    outputStream2 = httpResponse;
                    outputStream2.setReqUrl(str);
                    return outputStream2;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream3;
                    StringBuilder sb3 = new StringBuilder("post data '");
                    OutputStream outputStream15 = outputStream;
                    sb3.append(str);
                    OutputStream outputStream16 = outputStream;
                    sb3.append("' error");
                    OutputStream outputStream17 = outputStream;
                    httpURLConnection2 = httpURLConnection;
                    Log.e("efs.util.http", sb3.toString(), th);
                    outputStream2 = httpResponse;
                    outputStream2.setReqUrl(str);
                    return outputStream2;
                }
            } catch (SocketTimeoutException e4) {
                e = e4;
                httpURLConnection = null;
                outputStream = null;
            } catch (UnknownHostException e5) {
                httpURLConnection = null;
                outputStream = null;
                e = e5;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
                outputStream = null;
            }
            outputStream2.setReqUrl(str);
            return outputStream2;
        } finally {
            com.efs.sdk.base.core.util.b.a((Closeable) outputStream2);
            b(httpURLConnection2);
        }
    }

    @Override // com.efs.sdk.base.http.IHttpUtil
    public final HttpResponse postAsFile(String str, Map<String, String> map, byte[] bArr) {
        return a(str, map, null, bArr);
    }
}

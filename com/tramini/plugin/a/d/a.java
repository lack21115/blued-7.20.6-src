package com.tramini.plugin.a.d;

import android.content.Context;
import com.tramini.plugin.a.a.a;
import com.tramini.plugin.a.g.f;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/d/a.class */
public abstract class a {
    private static final String b = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected b f40510a;

    public static InputStream a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = httpURLConnection.getInputStream();
        } catch (Exception e) {
        }
        BufferedInputStream bufferedInputStream2 = bufferedInputStream;
        if ("gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            try {
                byte[] bArr = new byte[2];
                bufferedInputStream2 = new BufferedInputStream(bufferedInputStream);
                bufferedInputStream2.mark(2);
                int read = bufferedInputStream2.read(bArr);
                bufferedInputStream2.reset();
                byte b2 = bArr[0];
                byte b3 = bArr[1];
                if (read != -1 && (((b3 & 255) << 8) | (b2 & 255)) == 35615) {
                    return new GZIPInputStream(bufferedInputStream2);
                }
            } catch (Exception e2) {
                return bufferedInputStream;
            }
        }
        return bufferedInputStream2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("utf-8"));
            gZIPOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected abstract Object a(String str);

    protected abstract String a();

    public final void a(final int i, b bVar) {
        this.f40510a = bVar;
        com.tramini.plugin.a.g.b.a.a().a(new com.tramini.plugin.a.g.b.b() { // from class: com.tramini.plugin.a.d.a.1
            @Override // com.tramini.plugin.a.g.b.b
            public final void a() {
                HttpURLConnection httpURLConnection;
                try {
                    if (a.this.f40510a != null) {
                        a.this.f40510a.a();
                    }
                    HttpURLConnection httpURLConnection2 = null;
                    try {
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(a.this.a()).openConnection();
                            try {
                                httpURLConnection.setDoInput(true);
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setRequestMethod("POST");
                                httpURLConnection.setUseCaches(false);
                                Map<String, String> b2 = a.this.b();
                                if (b2.size() > 0) {
                                    for (String str : b2.keySet()) {
                                        httpURLConnection.addRequestProperty(str, b2.get(str));
                                    }
                                }
                                httpURLConnection.setConnectTimeout(20000);
                                httpURLConnection.setReadTimeout(60000);
                                httpURLConnection.connect();
                                byte[] c2 = a.this.c();
                                if (c2 != null) {
                                    OutputStream outputStream = httpURLConnection.getOutputStream();
                                    outputStream.write(c2);
                                    outputStream.flush();
                                    outputStream.close();
                                }
                                if (httpURLConnection.getResponseCode() != 200) {
                                    a.this.h();
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                InputStream a2 = a.a(httpURLConnection);
                                InputStreamReader inputStreamReader = new InputStreamReader(a2);
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                }
                                bufferedReader.close();
                                inputStreamReader.close();
                                if (a2 != null) {
                                    a2.close();
                                }
                                if (a.this.f()) {
                                    String sb2 = sb.toString();
                                    a aVar = a.this;
                                    httpURLConnection.getHeaderFields();
                                    httpURLConnection2 = aVar.a(sb2);
                                    a.this.a(i, httpURLConnection2);
                                } else {
                                    a aVar2 = a.this;
                                    httpURLConnection.getHeaderFields();
                                    httpURLConnection2 = aVar2.a("");
                                    a.this.a(i, httpURLConnection2);
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                                httpURLConnection.disconnect();
                            } catch (Exception e) {
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (OutOfMemoryError e2) {
                                System.gc();
                                HttpURLConnection httpURLConnection3 = httpURLConnection;
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (StackOverflowError e3) {
                                System.gc();
                                HttpURLConnection httpURLConnection4 = httpURLConnection;
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Error e4) {
                                System.gc();
                                HttpURLConnection httpURLConnection5 = httpURLConnection;
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (ConnectException e5) {
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (SocketTimeoutException e6) {
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (UnknownHostException e7) {
                                a.this.h();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (ConnectTimeoutException e8) {
                                a.this.g();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Throwable th) {
                                httpURLConnection2 = httpURLConnection;
                                th = th;
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                throw th;
                            }
                        } catch (OutOfMemoryError e9) {
                            httpURLConnection = null;
                        } catch (StackOverflowError e10) {
                            httpURLConnection = null;
                        } catch (Error e11) {
                            httpURLConnection = null;
                        } catch (ConnectException e12) {
                            httpURLConnection = null;
                        } catch (SocketTimeoutException e13) {
                            httpURLConnection = null;
                        } catch (UnknownHostException e14) {
                            httpURLConnection = null;
                        } catch (ConnectTimeoutException e15) {
                            httpURLConnection = null;
                        } catch (Exception e16) {
                            httpURLConnection = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e17) {
                    if (a.this.f40510a != null) {
                        a.this.f40510a.b();
                    }
                } catch (OutOfMemoryError | StackOverflowError e18) {
                    System.gc();
                    if (a.this.f40510a != null) {
                        a.this.f40510a.b();
                    }
                }
            }
        });
    }

    protected final void a(int i, Object obj) {
        b bVar = this.f40510a;
        if (bVar != null) {
            bVar.a(i, obj);
        }
    }

    protected abstract Map<String, String> b();

    protected abstract byte[] c();

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        Context b2 = com.tramini.plugin.a.a.c.a().b();
        try {
            jSONObject.put("platform", 1);
            jSONObject.put("os_vn", com.tramini.plugin.a.g.e.b());
            jSONObject.put("os_vc", com.tramini.plugin.a.g.e.a());
            jSONObject.put("package_name", com.tramini.plugin.a.g.e.c(b2));
            jSONObject.put("app_vn", com.tramini.plugin.a.g.e.b(b2));
            jSONObject.put("app_vc", com.tramini.plugin.a.g.e.a(b2));
            jSONObject.put("sdk_ver", "1.0.2");
            jSONObject.put(com.anythink.core.common.g.c.ad, a.b.f40476a);
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e() {
        HashMap hashMap = new HashMap();
        String b2 = com.tramini.plugin.a.g.c.b(d().toString());
        hashMap.put("d_version", "1.0");
        hashMap.put(com.anythink.expressad.foundation.g.a.N, b2);
        hashMap.put("d_sign", f.a("d_version=1.0&d1=".concat(String.valueOf(b2))));
        hashMap.put("pl_c", "2");
        Set<String> keySet = hashMap.keySet();
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : keySet) {
                jSONObject.put(str, String.valueOf(hashMap.get(str)));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return null;
        } catch (OutOfMemoryError e2) {
            System.gc();
            return null;
        }
    }

    public abstract boolean f();

    protected final void g() {
        b bVar = this.f40510a;
        if (bVar != null) {
            bVar.b();
        }
    }

    protected final void h() {
        b bVar = this.f40510a;
        if (bVar != null) {
            bVar.b();
        }
    }
}

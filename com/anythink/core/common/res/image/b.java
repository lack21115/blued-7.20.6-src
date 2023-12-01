package com.anythink.core.common.res.image;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/image/b.class */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6912a = getClass().getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    protected String f6913c;
    protected boolean d;
    protected long e;
    protected long f;
    protected long g;
    protected long h;
    protected long i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.res.image.b$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/image/b$1.class */
    public final class AnonymousClass1 extends com.anythink.core.common.k.b.b {
        AnonymousClass1() {
        }

        private void b(String str) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2;
            HttpURLConnection httpURLConnection3;
            HttpURLConnection httpURLConnection4;
            HttpURLConnection httpURLConnection5;
            HttpURLConnection httpURLConnection6;
            b.this.e = System.currentTimeMillis();
            b.this.f = SystemClock.elapsedRealtime();
            HttpURLConnection httpURLConnection7 = null;
            try {
                try {
                    String unused = b.this.f6912a;
                    HttpURLConnection httpURLConnection8 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection8.setInstanceFollowRedirects(false);
                        Map<String, String> a2 = b.this.a();
                        if (a2 != null && a2.size() > 0) {
                            for (String str2 : a2.keySet()) {
                                httpURLConnection8.addRequestProperty(str2, a2.get(str2));
                                String unused2 = b.this.f6912a;
                                StringBuilder sb = new StringBuilder("REQUEST ADDED HEADER: \n");
                                sb.append(str2);
                                sb.append("  :  ");
                                sb.append(a2.get(str2));
                            }
                        }
                        if (b.this.d) {
                            b.this.a(c.b, "Task had been canceled.");
                            if (httpURLConnection8 != null) {
                                httpURLConnection8.disconnect();
                                return;
                            }
                            return;
                        }
                        httpURLConnection8.setConnectTimeout(60000);
                        httpURLConnection8.connect();
                        int responseCode = httpURLConnection8.getResponseCode();
                        if (responseCode == 200) {
                            if (b.this.d) {
                                b.this.a(c.b, "Task had been canceled.");
                                if (httpURLConnection8 != null) {
                                    httpURLConnection8.disconnect();
                                    return;
                                }
                                return;
                            }
                            b.this.i = httpURLConnection8.getContentLength();
                            InputStream inputStream = httpURLConnection8.getInputStream();
                            boolean a3 = b.this.a(inputStream);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            b.this.g = System.currentTimeMillis();
                            b.this.h = SystemClock.elapsedRealtime();
                            if (a3) {
                                String unused3 = b.this.f6912a;
                                new StringBuilder("download success --> ").append(b.this.f6913c);
                                b.this.c();
                            } else {
                                String unused4 = b.this.f6912a;
                                new StringBuilder("download fail --> ").append(b.this.f6913c);
                                b.this.a(c.f6915a, "Save fail!");
                            }
                            if (httpURLConnection8 != null) {
                                httpURLConnection8.disconnect();
                                return;
                            }
                            return;
                        }
                        String unused5 = b.this.f6912a;
                        StringBuilder sb2 = new StringBuilder("http respond status code is ");
                        sb2.append(responseCode);
                        sb2.append(" ! url=");
                        sb2.append(str);
                        if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                            b.this.a(c.f6915a, httpURLConnection8.getResponseMessage());
                            if (httpURLConnection8 != null) {
                                httpURLConnection8.disconnect();
                                return;
                            }
                            return;
                        }
                        if (b.this.d) {
                            b.this.a(c.b, "Task had been canceled.");
                        } else {
                            String headerField = httpURLConnection8.getHeaderField(HttpHeaders.LOCATION);
                            if (headerField != null) {
                                if (!headerField.toLowerCase().startsWith("http")) {
                                    b.this.a(c.f6915a, "Final url is wrong:".concat(String.valueOf(headerField)));
                                    if (httpURLConnection8 != null) {
                                        httpURLConnection8.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                b(headerField);
                            }
                        }
                        if (httpURLConnection8 != null) {
                            httpURLConnection8.disconnect();
                        }
                    } catch (OutOfMemoryError e) {
                        httpURLConnection = httpURLConnection8;
                        e = e;
                        System.gc();
                        HttpURLConnection httpURLConnection9 = httpURLConnection;
                        String unused6 = b.this.f6912a;
                        HttpURLConnection httpURLConnection10 = httpURLConnection;
                        e.getMessage();
                        HttpURLConnection httpURLConnection11 = httpURLConnection;
                        b.this.a(c.f6915a, e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (StackOverflowError e2) {
                        httpURLConnection6 = httpURLConnection8;
                        e = e2;
                        System.gc();
                        HttpURLConnection httpURLConnection12 = httpURLConnection6;
                        String unused7 = b.this.f6912a;
                        HttpURLConnection httpURLConnection13 = httpURLConnection6;
                        e.getMessage();
                        HttpURLConnection httpURLConnection14 = httpURLConnection6;
                        b.this.a(c.f6915a, e.getMessage());
                        if (httpURLConnection6 != null) {
                            httpURLConnection6.disconnect();
                        }
                    } catch (Error e3) {
                        httpURLConnection5 = httpURLConnection8;
                        e = e3;
                        System.gc();
                        HttpURLConnection httpURLConnection15 = httpURLConnection5;
                        String unused8 = b.this.f6912a;
                        HttpURLConnection httpURLConnection16 = httpURLConnection5;
                        e.getMessage();
                        HttpURLConnection httpURLConnection17 = httpURLConnection5;
                        b.this.a(c.f6915a, e.getMessage());
                        if (httpURLConnection5 != null) {
                            httpURLConnection5.disconnect();
                        }
                    } catch (SocketTimeoutException e4) {
                        httpURLConnection4 = httpURLConnection8;
                        e = e4;
                        b.this.a(c.f6915a, e.getMessage());
                        httpURLConnection7 = httpURLConnection4;
                        String unused9 = b.this.f6912a;
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                    } catch (ConnectTimeoutException e5) {
                        httpURLConnection3 = httpURLConnection8;
                        e = e5;
                        b.this.a(c.f6915a, e.getMessage());
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } catch (Exception e6) {
                        httpURLConnection2 = httpURLConnection8;
                        e = e6;
                        String unused10 = b.this.f6912a;
                        HttpURLConnection httpURLConnection18 = httpURLConnection2;
                        e.getMessage();
                        HttpURLConnection httpURLConnection19 = httpURLConnection2;
                        b.this.a(c.f6915a, e.getMessage());
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection7 = httpURLConnection8;
                        if (httpURLConnection7 != null) {
                            httpURLConnection7.disconnect();
                        }
                        throw th;
                    }
                } catch (StackOverflowError e7) {
                    e = e7;
                    httpURLConnection6 = null;
                } catch (Error e8) {
                    e = e8;
                    httpURLConnection5 = null;
                } catch (SocketTimeoutException e9) {
                    e = e9;
                    httpURLConnection4 = null;
                } catch (ConnectTimeoutException e10) {
                    e = e10;
                    httpURLConnection3 = null;
                } catch (Exception e11) {
                    e = e11;
                    httpURLConnection2 = null;
                } catch (OutOfMemoryError e12) {
                    e = e12;
                    httpURLConnection = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.anythink.core.common.k.b.b
        public final void a() {
            try {
                b(b.this.f6913c);
            } catch (Exception e) {
                String unused = b.this.f6912a;
                e.getMessage();
                b.this.a(c.f6915a, e.getMessage());
            } catch (OutOfMemoryError e2) {
                e = e2;
                System.gc();
                b.this.a(c.f6915a, e.getMessage());
            } catch (StackOverflowError e3) {
                e = e3;
                System.gc();
                b.this.a(c.f6915a, e.getMessage());
            }
        }
    }

    public b(String str) {
        this.f6913c = str;
    }

    private void e() {
        this.d = true;
    }

    private void f() {
        a(new AnonymousClass1());
    }

    private static int g() {
        return 60000;
    }

    private static int h() {
        return 20000;
    }

    protected abstract Map<String, String> a();

    protected abstract void a(com.anythink.core.common.k.b.b bVar);

    protected abstract void a(String str, String str2);

    protected abstract boolean a(InputStream inputStream);

    protected abstract void b();

    protected abstract void c();

    public final void d() {
        this.d = false;
        a(new AnonymousClass1());
    }
}

package a.a.a.a.a.k.d;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1367a = false;
    public static int b = 120000;

    /* renamed from: c  reason: collision with root package name */
    public static int f1368c = 60000;
    public static int d = 30000;
    public Handler f;
    public HandlerThread g;
    public b h;
    public boolean e = false;
    public Object i = new Object();
    public Handler.Callback j = new a();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/e$a.class */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                e.this.c((String) message.obj);
                return true;
            } else if (i == 1) {
                e.this.a(true);
                return true;
            } else if (i == 2) {
                e.this.d();
                return true;
            } else if (i == 3) {
                e.this.d((String) message.obj);
                return true;
            } else if (i != 5) {
                return true;
            } else {
                e.this.b(true);
                return true;
            }
        }
    }

    public static int a() {
        return d;
    }

    public final void a(int i, String str) {
        synchronized (this.i) {
            if (this.g != null && this.f != null) {
                this.f.sendMessage(this.f.obtainMessage(i, str));
            }
        }
    }

    public void a(Context context) {
        if (this.g != null) {
            return;
        }
        b bVar = new b();
        this.h = bVar;
        bVar.a(context.getApplicationContext());
        HandlerThread handlerThread = new HandlerThread("QosReporter");
        this.g = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.g.getLooper(), this.j);
        this.f = handler;
        handler.sendEmptyMessageDelayed(1, b);
    }

    public void a(String str) {
        a(3, str);
    }

    public final void a(String str, int i, int i2) {
        if (i < 10000 || i2 < 10000) {
            return;
        }
        if (str.equals("http://misc-pili-qos-report.qiniuapi.com/raw/log/misc-v5")) {
            if (i != b) {
                b = i;
            }
        } else if (!str.equals("http://stream-pili-qos-report.qiniuapi.com/raw/log/stream-v5") || i == f1368c) {
        } else {
            f1368c = i;
            d = i2;
        }
    }

    public final void a(boolean z) {
        Handler handler;
        String c2 = this.h.c();
        if (c2 != null && a("http://misc-pili-qos-report.qiniuapi.com/raw/log/misc-v5", c2)) {
            this.h.b();
        }
        if (!z || (handler = this.f) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(1, b);
    }

    public final boolean a(String str, String str2) {
        int contentLength;
        if (f1367a) {
            a.a.a.a.a.e.e.f1313c.b("QosReporter", "url: \n" + str + "\ncontent: \n" + str2);
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(10000);
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", f1367a ? "application/octet-stream" : "application/x-gzip");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                try {
                    byte[] bytes = str2.getBytes();
                    if (bytes == null) {
                        return false;
                    }
                    if (f1367a) {
                        httpURLConnection.getOutputStream().write(bytes);
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.close();
                        httpURLConnection.getOutputStream().write(byteArrayOutputStream.toByteArray());
                    }
                    httpURLConnection.getOutputStream().flush();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (f1367a) {
                            a.a.a.a.a.e.e.f1313c.b("QosReporter", "response code = " + responseCode);
                        }
                        if (responseCode == 200 && (contentLength = httpURLConnection.getContentLength()) != 0) {
                            int i = contentLength;
                            if (contentLength < 0) {
                                i = 16384;
                            }
                            try {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                byte[] bArr = new byte[i];
                                try {
                                    try {
                                        int read = inputStream.read(bArr);
                                        try {
                                            inputStream.close();
                                            if (read <= 0) {
                                                return false;
                                            }
                                            String trim = new String(bArr).trim();
                                            if (f1367a) {
                                                a.a.a.a.a.e.e.f1313c.b("QosReporter", trim);
                                            }
                                            try {
                                                JSONObject jSONObject = new JSONObject(trim);
                                                a(str, jSONObject.optInt("reportInterval") * 1000, jSONObject.optInt("sampleInterval") * 1000);
                                                return true;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                return true;
                                            }
                                        } catch (IOException e2) {
                                            if (f1367a) {
                                                e2.printStackTrace();
                                                return false;
                                            }
                                            return false;
                                        }
                                    } catch (IOException e3) {
                                        if (f1367a) {
                                            e3.printStackTrace();
                                        }
                                        try {
                                            inputStream.close();
                                            return false;
                                        } catch (IOException e4) {
                                            if (f1367a) {
                                                e4.printStackTrace();
                                                return false;
                                            }
                                            return false;
                                        }
                                    }
                                } catch (Throwable th) {
                                    try {
                                        inputStream.close();
                                        throw th;
                                    } catch (IOException e5) {
                                        if (f1367a) {
                                            e5.printStackTrace();
                                            return false;
                                        }
                                        return false;
                                    }
                                }
                            } catch (IOException e6) {
                                if (f1367a) {
                                    e6.printStackTrace();
                                    return false;
                                }
                                return false;
                            } catch (Exception e7) {
                                if (f1367a) {
                                    e7.printStackTrace();
                                    return false;
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (IOException e8) {
                        if (f1367a) {
                            e8.printStackTrace();
                            return false;
                        }
                        return false;
                    }
                } catch (IOException e9) {
                    if (f1367a) {
                        e9.printStackTrace();
                        return false;
                    }
                    return false;
                } catch (Exception e10) {
                    return false;
                }
            } catch (ProtocolException e11) {
                if (f1367a) {
                    e11.printStackTrace();
                    return false;
                }
                return false;
            }
        } catch (IOException e12) {
            if (f1367a) {
                e12.printStackTrace();
                return false;
            }
            return false;
        } catch (Exception e13) {
            if (f1367a) {
                e13.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public void b() {
        if (this.g == null) {
            return;
        }
        this.f.removeCallbacksAndMessages(null);
        this.f.sendEmptyMessageDelayed(2, 10L);
    }

    public void b(String str) {
        a(0, str);
    }

    public final void b(boolean z) {
        String c2 = c.a().c();
        if (c2 != null && a("http://stream-pili-qos-report.qiniuapi.com/raw/log/stream-v5", c2)) {
            c.a().b();
        }
        if (!z || this.f == null) {
            return;
        }
        c();
        this.f.sendEmptyMessageDelayed(5, f1368c);
    }

    public final void c() {
        Intent intent = new Intent("pldroid-qos-filter");
        intent.putExtra("pldroid-qos-msg-type", 162);
        a.a.a.a.a.k.a.a().a(intent);
    }

    public final void c(String str) {
        this.h.a(str);
    }

    public final void d() {
        if (this.g == null) {
            return;
        }
        this.f.removeCallbacksAndMessages(null);
        synchronized (this.i) {
            this.f = null;
        }
        a(false);
        if (this.e) {
            b(false);
        }
        this.g.quit();
        this.g = null;
        this.h.a();
    }

    public final void d(String str) {
        Handler handler;
        if (!c.a().a(str) || this.e || (handler = this.f) == null) {
            return;
        }
        this.e = true;
        handler.sendEmptyMessageDelayed(5, f1368c);
    }
}

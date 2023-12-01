package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f25138a = "EmergencyManager";
    private static final Object f = new Object();
    private static HandlerThread g;
    private static Handler h;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f25139c;
    private String d;
    private Handler e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/a/e$a.class */
    public interface a {
        void a(String str);
    }

    public e(Context context, String str, String str2) {
        this(context, str, str2, "POST");
    }

    public e(Context context, String str, String str2, String str3) {
        this.b = str;
        this.f25139c = str2;
        this.d = str3;
        this.e = new Handler(context.getMainLooper());
    }

    private static Handler b() {
        Handler handler;
        synchronized (f) {
            if (h == null) {
                HandlerThread handlerThread = new HandlerThread("HttpThread");
                g = handlerThread;
                handlerThread.start();
                h = new Handler(g.getLooper());
            }
            handler = h;
        }
        return handler;
    }

    public String a(String str) {
        String str2 = f25138a;
        TbsLog.e(str2, "Request url: " + this.b + ",params: " + this.f25139c);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.trim()).openConnection();
            httpURLConnection.setRequestMethod(this.d);
            httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            httpURLConnection.setRequestProperty("Content-Length", this.f25139c.length() + "");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(this.f25139c.getBytes());
            int responseCode = httpURLConnection.getResponseCode();
            if (200 != responseCode) {
                String str3 = f25138a;
                TbsLog.e(str3, "Bad http request, code: " + responseCode);
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 == read) {
                    return byteArrayOutputStream.toString("utf-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
        } catch (IOException e) {
            String str4 = f25138a;
            TbsLog.e(str4, "Http exception: " + e.getMessage());
            return null;
        }
    }

    public void a(final a aVar) {
        b().post(new Runnable() { // from class: com.tencent.smtt.sdk.a.e.1
            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                final String a2 = eVar.a(eVar.b);
                if (a2 != null) {
                    e.this.e.post(new Runnable() { // from class: com.tencent.smtt.sdk.a.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (aVar != null) {
                                aVar.a(a2);
                            }
                        }
                    });
                    return;
                }
                String str = e.f25138a;
                TbsLog.e(str, "Unexpected result for an empty http response: " + e.this.b);
            }
        });
    }
}

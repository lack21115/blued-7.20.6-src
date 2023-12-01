package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.u;
import com.google.common.net.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/al.class */
public class al extends Observable implements u, Runnable {
    protected static final int i = 10240;
    protected static final int j = 10240;
    public static final String k = ".tmp";
    private static final String m = "FileDownloader";

    /* renamed from: a  reason: collision with root package name */
    protected Context f6467a;
    protected URL b;

    /* renamed from: c  reason: collision with root package name */
    protected String f6468c;
    protected String d;
    protected int e;
    protected u.a f;
    protected int g;
    protected int h;
    protected byte[] l;
    private boolean n;

    public al(Context context, URL url, String str, String str2, boolean z) {
        this.n = false;
        this.f6467a = context;
        this.b = url;
        this.f6468c = str;
        this.n = z;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.d = str2;
        }
        this.e = -1;
        this.f = u.a.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        HttpURLConnection httpURLConnection2;
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302) {
                    httpURLConnection2 = httpURLConnection;
                    if (responseCode != 301) {
                        break;
                    }
                }
                URL url = new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION));
                this.b = url;
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                return httpURLConnection;
            }
        }
        return httpURLConnection2;
    }

    private void s() {
        a(u.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a() {
        a(u.a.DOWNLOADING);
        p();
    }

    protected void a(int i2, float f) {
        this.g += i2;
        q();
    }

    protected void a(u.a aVar) {
        this.f = aVar;
        q();
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String g() {
        return this.f6468c + this.d;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public int j() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public float k() {
        return Math.abs((this.g / this.e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public u.a l() {
        return this.f;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.l;
    }

    protected void p() {
        ba.a().a(this);
    }

    protected void q() {
        setChanged();
        notifyObservers();
    }

    protected void r() {
        bo.a(this.f6468c + this.d + ".tmp", this.f6468c + this.d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r0 == 301) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0409 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.al.run():void");
    }
}

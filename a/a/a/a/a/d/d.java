package a.a.a.a.a.d;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/d.class */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public int f1346a = 0;
    public g b = new g();

    public final String a() {
        if (this.b.c() == null || this.b.a()) {
            this.b.b();
        }
        if (this.b.c().equals(com.igexin.push.core.b.l)) {
            b();
        }
        return "https://pandora-express-sdk.qiniu.com/api/v1/data?host=sdkTest&sourcetype=json&repo=sdk&token=" + this.b.c();
    }

    public final void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
    }

    public final void b() {
        int i = this.f1346a + 1;
        this.f1346a = i;
        if (i > 2) {
            this.f1346a = 0;
            return;
        }
        try {
            Thread.sleep(i * 5000);
        } catch (InterruptedException e) {
        }
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
        } catch (UnknownHostException e) {
            b();
            return;
        } catch (Exception e2) {
        }
        if (c.a().b()) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a()).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            a(httpURLConnection);
            String a2 = e.a();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(a2.getBytes());
            outputStream.flush();
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            if (responseCode >= 500) {
                b();
                return;
            }
            if (responseCode == 200) {
                this.f1346a = 0;
            }
            f.a().d();
        }
    }
}

package a.a.a.a.a.d;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f1301a;
    public long b;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/g$b.class */
    public class b implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public int f1302a;

        public b() {
            this.f1302a = 0;
        }

        public final Integer a() {
            int i = this.f1302a + 1;
            this.f1302a = i;
            if (i > 2) {
                this.f1302a = 0;
                return 400;
            }
            try {
                Thread.sleep(i * 5000);
            } catch (InterruptedException e) {
            }
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://shortvideo.qiniuapi.com/shortvideo/log/token").openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    return responseCode >= 500 ? a() : Integer.valueOf(responseCode);
                }
                this.f1302a = 0;
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                char[] cArr = new char[1024];
                StringBuilder sb = new StringBuilder();
                while (inputStreamReader.read(cArr) != -1) {
                    sb.append(cArr);
                }
                inputStreamReader.close();
                String sb2 = sb.toString();
                httpURLConnection.disconnect();
                g.this.f1301a = new JSONObject(sb2).optString("token");
                return Integer.valueOf(responseCode);
            } catch (UnknownHostException e) {
                return a();
            } catch (Exception e2) {
                return 400;
            }
        }
    }

    public boolean a() {
        return System.currentTimeMillis() - this.b > a.a.a.a.a.d.a.f1294a;
    }

    public void b() {
        if (new b().call().intValue() == 200) {
            this.b = System.currentTimeMillis();
        } else {
            this.f1301a = com.igexin.push.core.b.l;
        }
    }

    public String c() {
        return this.f1301a;
    }
}

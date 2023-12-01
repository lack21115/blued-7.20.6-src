package com.meizu.cloud.pushsdk.c.c;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.c.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import com.sobot.network.http.SobotOkHttpUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/e.class */
public class e implements a {
    private static l a(final HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getDoInput()) {
            final com.meizu.cloud.pushsdk.c.g.d a2 = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
            return new l() { // from class: com.meizu.cloud.pushsdk.c.c.e.1
                @Override // com.meizu.cloud.pushsdk.c.c.l
                public com.meizu.cloud.pushsdk.c.g.d a() {
                    return a2;
                }
            };
        }
        return null;
    }

    private static void a(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        String str;
        String str2;
        int c2 = iVar.c();
        if (c2 != 0) {
            if (c2 == 1) {
                str2 = "POST";
            } else if (c2 == 2) {
                str2 = "PUT";
            } else if (c2 == 3) {
                str = "DELETE";
            } else if (c2 == 4) {
                str = "HEAD";
            } else if (c2 != 5) {
                throw new IllegalStateException("Unknown method type.");
            } else {
                str2 = SobotOkHttpUtils.METHOD.PATCH;
            }
            httpURLConnection.setRequestMethod(str2);
            b(httpURLConnection, iVar);
            return;
        }
        str = "GET";
        httpURLConnection.setRequestMethod(str);
    }

    protected static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private HttpURLConnection b(i iVar) throws IOException {
        URL url = new URL(iVar.a().toString());
        if (MinSdkChecker.isSupportNotificationChannel()) {
            TrafficStats.setThreadStatsTag(2006537699);
        }
        HttpURLConnection a2 = a(url);
        a2.setConnectTimeout(60000);
        a2.setReadTimeout(60000);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        return a2;
    }

    private static void b(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        j e = iVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e.a().toString());
            com.meizu.cloud.pushsdk.c.g.c a2 = com.meizu.cloud.pushsdk.c.g.g.a(com.meizu.cloud.pushsdk.c.g.g.a(httpURLConnection.getOutputStream()));
            e.a(a2);
            a2.close();
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.c.a
    public k a(i iVar) throws IOException {
        HttpURLConnection b = b(iVar);
        for (String str : iVar.d().b()) {
            String a2 = iVar.a(str);
            com.meizu.cloud.pushsdk.c.a.a.b("current header name " + str + " value " + a2);
            b.addRequestProperty(str, a2);
        }
        a(b, iVar);
        int responseCode = b.getResponseCode();
        return new k.a().a(responseCode).a(iVar.d()).a(b.getResponseMessage()).a(iVar).a(a(b)).a();
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}

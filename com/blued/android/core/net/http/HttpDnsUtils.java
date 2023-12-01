package com.blued.android.core.net.http;

import android.os.AsyncTask;
import android.util.Log;
import com.blued.android.core.net.HttpManager;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/HttpDnsUtils.class */
public class HttpDnsUtils {
    private static Set<String> a = new HashSet();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/HttpDnsUtils$HttpDnsResult.class */
    public static class HttpDnsResult {
        public String a;
        public String b;
        public String c;
        public String d;

        public String toString() {
            return "[oriUrl:" + this.a + ", ipUrl:" + this.b + ", hostName:" + this.c + ", ipAddr:" + this.d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/HttpDnsUtils$HttpDnsTask.class */
    public static class HttpDnsTask extends AsyncTask {
        private String a;

        public HttpDnsTask(String str) {
            this.a = str;
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object[] objArr) {
            if (HttpManager.d() != null) {
                try {
                    HttpManager.d().query(this.a);
                    if (HttpManager.c()) {
                        Log.v("HttpManager", "finish update HttpDns for " + this.a);
                        return null;
                    }
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
            synchronized (HttpDnsUtils.a) {
                HttpDnsUtils.a.remove(this.a);
            }
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            synchronized (HttpDnsUtils.a) {
                HttpDnsUtils.a.remove(this.a);
            }
        }
    }

    public static String a(String str) {
        String[] strArr;
        if (HttpManager.d() != null) {
            if (HttpManager.e()) {
                try {
                    strArr = HttpManager.d().query(str);
                } catch (IOException e) {
                    e.printStackTrace();
                    strArr = null;
                }
            } else {
                String[] queryFromCache = HttpManager.d().queryFromCache(str);
                strArr = queryFromCache;
                if (queryFromCache == null) {
                    b(str);
                    strArr = queryFromCache;
                }
            }
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            if (HttpManager.c()) {
                Log.v("HttpManager", "get HttpDns from cache, " + str + " -> " + strArr[0]);
            }
            return strArr[0];
        }
        return null;
    }

    private static void b(String str) {
        synchronized (a) {
            if (!a.contains(str)) {
                a.add(str);
                new HttpDnsTask(str).execute(new Object[0]);
            }
        }
    }
}

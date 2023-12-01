package com.blued.android.core.net.http;

import android.os.AsyncTask;
import android.util.Log;
import com.blued.android.core.net.HttpManager;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/HttpDnsUtils.class */
public class HttpDnsUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f9678a = new HashSet();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/HttpDnsUtils$HttpDnsResult.class */
    public static class HttpDnsResult {

        /* renamed from: a  reason: collision with root package name */
        public String f9679a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f9680c;
        public String d;

        public String toString() {
            return "[oriUrl:" + this.f9679a + ", ipUrl:" + this.b + ", hostName:" + this.f9680c + ", ipAddr:" + this.d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/HttpDnsUtils$HttpDnsTask.class */
    public static class HttpDnsTask extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f9681a;

        public HttpDnsTask(String str) {
            this.f9681a = str;
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object[] objArr) {
            if (HttpManager.d() != null) {
                try {
                    HttpManager.d().query(this.f9681a);
                    if (HttpManager.c()) {
                        Log.v("HttpManager", "finish update HttpDns for " + this.f9681a);
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

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            synchronized (HttpDnsUtils.f9678a) {
                HttpDnsUtils.f9678a.remove(this.f9681a);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            synchronized (HttpDnsUtils.f9678a) {
                HttpDnsUtils.f9678a.remove(this.f9681a);
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
        synchronized (f9678a) {
            if (!f9678a.contains(str)) {
                f9678a.add(str);
                new HttpDnsTask(str).execute(new Object[0]);
            }
        }
    }
}

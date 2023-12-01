package a.a.a.a.a.k.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kuaishou.pushad.BuildConfig;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f1427a = new c();
    public Context h;
    public final Object b = new Object();
    public Map<String, String[]> d = new HashMap();
    public Map<String, ArrayList<e>> e = new HashMap();
    public String f = "";
    public Map<String, Long> i = new HashMap();
    public boolean j = false;
    public boolean k = true;
    public g l = new g(null);
    public int g = 3600;

    /* renamed from: c  reason: collision with root package name */
    public final a.a.a.a.a.k.e.b f1428c = new a.a.a.a.a.k.e.a();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$a.class */
    public class a implements Runnable {

        /* renamed from: a.a.a.a.a.k.e.c$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$a$a.class */
        public class RunnableC0015a implements Runnable {
            public RunnableC0015a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b();
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Map.Entry entry : new HashMap(c.this.d).entrySet()) {
                c.this.a((String) entry.getKey(), c.this.b((String[]) entry.getValue()), 65536);
            }
            c.this.j = false;
            c.this.l.a(c.this.g, new RunnableC0015a());
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$b.class */
    public class b extends BroadcastReceiver {

        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$b$a.class */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.a.a.a.a.k.c.a.a().equals(c.this.f) || c.this.d()) {
                    return;
                }
                c.this.b();
            }
        }

        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AsyncTask.execute(new a());
        }
    }

    /* renamed from: a.a.a.a.a.k.e.c$c  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$c.class */
    public class RunnableC0016c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f1433a;

        public RunnableC0016c(String[] strArr) {
            this.f1433a = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.a.a.a.a.k.c.a.c(c.this.h)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            String[] strArr = this.f1433a;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    c.this.a(arrayList);
                    return;
                }
                arrayList.add(c.this.f1428c.a(String.format(Locale.getDefault(), "http://%s:%d/%s", strArr[i2], 1230, "ping"), 65536));
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$d.class */
    public class d implements Comparator<e> {
        public d(c cVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(e eVar, e eVar2) {
            int i = eVar.f1435c;
            int i2 = eVar2.f1435c;
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f1434a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1435c;
        public final String d;
        public String e;

        public e(String str, String str2, int i, int i2, String str3) {
            this.e = str;
            this.f1434a = str2;
            this.b = i;
            this.f1435c = i2;
            this.d = str3;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$f.class */
    public static class f implements Comparable<f> {

        /* renamed from: a  reason: collision with root package name */
        public String f1436a;
        public String b;

        public f(String str, String str2) {
            this.f1436a = str;
            this.b = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: c */
        public int compareTo(f fVar) {
            return this.b.compareTo(fVar.b);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$g.class */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Handler f1437a;
        public volatile boolean b;

        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/e/c$g$a.class */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.b = false;
            }
        }

        public g() {
            this.f1437a = new Handler();
            this.b = false;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public final void a(int i, Runnable runnable) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f1437a.postDelayed(new a(), i * 1000);
        }
    }

    public static c a() {
        return f1427a;
    }

    public e a(String str, int i) {
        if (!a.a.a.a.a.k.c.a.a().equals(this.f)) {
            b();
            return null;
        }
        synchronized (this) {
            ArrayList<e> arrayList = this.e.get(str);
            if (arrayList != null && arrayList.size() != 0) {
                if (i > 0 && i <= this.e.size()) {
                    return arrayList.get(i);
                }
                return arrayList.get(0);
            }
            return null;
        }
    }

    public final ArrayList<e> a(String[] strArr, ArrayList<e> arrayList) {
        ArrayList<e> arrayList2 = new ArrayList<>();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            String str = strArr[i2];
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.f1434a.equals(str)) {
                    arrayList2.add(next);
                }
            }
            i = i2 + 1;
        }
        return arrayList2.size() != arrayList.size() ? arrayList : arrayList2;
    }

    public final JSONObject a(String str, ArrayList<e> arrayList) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("method", BuildConfig.FLAVOR);
            jSONObject.put("net", a.a.a.a.a.k.c.a.b(this.h));
        } catch (JSONException e2) {
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                try {
                    jSONObject.put("speeds", jSONArray);
                    return jSONObject;
                } catch (JSONException e3) {
                    return jSONObject;
                }
            }
            e eVar = arrayList.get(i2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (eVar.e == null) {
                    jSONObject2.put("domain", str);
                } else {
                    jSONObject2.put("domain", eVar.e);
                }
                jSONObject2.put("serverIP", eVar.f1434a);
                jSONObject2.put("sendBytes", 65536);
                jSONObject2.put("connect", eVar.b);
                jSONObject2.put("durationMs", eVar.f1435c);
                if (eVar.d != null) {
                    jSONObject2.put("error", eVar.d);
                }
                jSONArray.put(jSONObject2);
            } catch (JSONException e4) {
            }
            i = i2 + 1;
        }
    }

    public void a(Context context) {
        if (this.h != null) {
            return;
        }
        this.h = context.getApplicationContext();
        c();
    }

    public final void a(String str, f[] fVarArr, int i) {
        if (a.a.a.a.a.k.c.a.c(this.h)) {
            return;
        }
        String a2 = a.a.a.a.a.k.c.a.a();
        long currentTimeMillis = System.currentTimeMillis();
        Long l = this.i.get(str);
        if (!a2.equals(this.f) || l == null || currentTimeMillis - l.longValue() >= this.g * 1000) {
            ArrayList<e> arrayList = new ArrayList<>();
            int length = fVarArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                f fVar = fVarArr[i3];
                e a3 = this.f1428c.a(String.format(Locale.getDefault(), "http://%s:%d/%s", fVar.b, 1230, "ping"), i);
                if (a3 != null) {
                    a3.e = fVar.f1436a;
                    arrayList.add(a3);
                }
                i2 = i3 + 1;
            }
            Collections.sort(arrayList, new d(this));
            synchronized (this) {
                this.e.put(str, b(arrayList));
            }
            String[] b2 = b(str, arrayList);
            if (b2 == null) {
                return;
            }
            ArrayList<e> a4 = a(b2, arrayList);
            synchronized (this) {
                this.e.put(str, b(a4));
            }
            this.f = a2;
            this.i.put(str, Long.valueOf(currentTimeMillis));
        }
    }

    public void a(String str, String[] strArr) {
        synchronized (this) {
            this.d.put(str, strArr);
        }
    }

    public final void a(ArrayList<e> arrayList) {
        JSONObject a2 = a((String) null, arrayList);
        a.a.a.a.a.k.c.a.a("http://pili-zeus.qiniuapi.com/v1/quality", null, a2);
    }

    public final void a(String[] strArr) {
        if (Build.VERSION.SDK_INT < 15 || strArr == null || strArr.length == 0) {
            return;
        }
        AsyncTask.execute(new RunnableC0016c(strArr));
    }

    public final f[] a(String str, InetAddress[] inetAddressArr) {
        ArrayList arrayList = new ArrayList();
        int length = inetAddressArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            arrayList.add(new f(str, inetAddressArr[i2].getHostAddress()));
            i = i2 + 1;
        }
        if (inetAddressArr.length <= 2) {
            return (f[]) arrayList.toArray(new f[inetAddressArr.length]);
        }
        Collections.sort(arrayList);
        return new f[]{(f) arrayList.get(0), (f) arrayList.get(arrayList.size() - 1)};
    }

    public final String[] a(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt(RemoteMessageConst.TTL);
            if (i > 600) {
                this.g = i;
            }
            String[] a2 = a(jSONObject, "ips");
            strArr = a2;
            a(a(jSONObject, "tasks"));
            return a2;
        } catch (JSONException e2) {
            return strArr;
        }
    }

    public final String[] a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return strArr;
            }
            strArr[i2] = jSONArray.getString(i2);
            i = i2 + 1;
        }
    }

    public final ArrayList<e> b(ArrayList<e> arrayList) {
        ArrayList<e> arrayList2 = new ArrayList<>();
        Iterator<e> it = arrayList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.d == null) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public void b() {
        if (Build.VERSION.SDK_INT >= 15 && this.k) {
            synchronized (this.b) {
                if (this.j) {
                    return;
                }
                this.j = true;
                AsyncTask.execute(new a());
            }
        }
    }

    public final f[] b(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new f[0];
        }
        if (strArr.length == 1) {
            try {
                return a(strArr[0], InetAddress.getAllByName(strArr[0]));
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
                return new f[0];
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            try {
                arrayList.add(new f(str, InetAddress.getByName(str).getHostAddress()));
            } catch (UnknownHostException e3) {
                e3.printStackTrace();
            }
        }
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    public final String[] b(String str, ArrayList<e> arrayList) {
        JSONObject a2 = a(str, arrayList);
        return a(a.a.a.a.a.k.c.a.a("http://pili-zeus.qiniuapi.com/v2/query", null, a2));
    }

    public final void c() {
        if (Build.VERSION.SDK_INT < 15) {
            return;
        }
        b bVar = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.h.registerReceiver(bVar, intentFilter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (r0.isConnected() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r0.isConnected() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d() {
        /*
            r3 = this;
            r0 = r3
            android.content.Context r0 = r0.h
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r7 = r0
            r0 = 0
            r5 = r0
            r0 = r7
            r1 = 0
            android.net.NetworkInfo r0 = r0.getNetworkInfo(r1)
            r6 = r0
            r0 = r7
            r1 = 1
            android.net.NetworkInfo r0 = r0.getNetworkInfo(r1)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L2f
            r0 = r5
            r4 = r0
            r0 = r7
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L3e
        L2f:
            r0 = r6
            if (r0 == 0) goto L3c
            r0 = r5
            r4 = r0
            r0 = r6
            boolean r0 = r0.isConnected()
            if (r0 != 0) goto L3e
        L3c:
            r0 = 1
            r4 = r0
        L3e:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a.k.e.c.d():boolean");
    }
}

package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/b/b.class */
public class b {
    private static boolean h;

    /* renamed from: a  reason: collision with root package name */
    private String f7521a = null;
    private InterfaceC0130b b = null;

    /* renamed from: c  reason: collision with root package name */
    private Object f7522c = null;
    private Map<String, String> d = new HashMap();
    private Map<String, String> e = new HashMap();
    private Map<String, String> f = new HashMap();
    private String g = "GET";

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/b/b$a.class */
    class a extends AsyncTask<Void, Void, c> {

        /* renamed from: a  reason: collision with root package name */
        b f7523a;

        a() {
            this.f7523a = b.this;
        }

        protected native c a(Void... voidArr);

        protected native void a(c cVar);

        @Override // android.os.AsyncTask
        protected native /* bridge */ /* synthetic */ c doInBackground(Void[] voidArr);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public native /* bridge */ /* synthetic */ void onPostExecute(c cVar);
    }

    /* renamed from: com.bun.miitmdid.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/b/b$b.class */
    public interface InterfaceC0130b {
        void a(Exception exc, int i, String str);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/b/b$c.class */
    class c {

        /* renamed from: a  reason: collision with root package name */
        private String f7524a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private Exception f7525c;

        public c(b bVar, String str, Exception exc, int i) {
            this.f7524a = str;
            this.f7525c = exc;
            this.b = i;
        }

        static native /* synthetic */ Exception a(c cVar);

        static native /* synthetic */ int b(c cVar);

        static native /* synthetic */ String c(c cVar);
    }

    private b(Context context) {
    }

    public static native b a(Context context);

    static native /* synthetic */ String a(b bVar);

    private native void a(HttpURLConnection httpURLConnection);

    private native c b();

    static native /* synthetic */ c b(b bVar);

    private static native void b(String str);

    private native c c();

    static native /* synthetic */ c c(b bVar);

    static native /* synthetic */ InterfaceC0130b d(b bVar);

    private native String d();

    public native b a();

    public native b a(InterfaceC0130b interfaceC0130b);

    public native b a(Object obj);

    public native b a(String str);

    public native b a(String str, String str2);

    public native b a(Map<String, String> map);
}

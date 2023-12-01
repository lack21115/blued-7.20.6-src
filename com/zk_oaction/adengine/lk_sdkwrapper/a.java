package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a.class */
public class a extends FrameLayout {
    private int A;
    private int B;
    private int C;
    private int D;
    private long E;
    private long F;
    private MotionEvent G;
    private MotionEvent H;
    private boolean I;
    private Runnable J;
    private int K;
    private int L;
    private int M;

    /* renamed from: a  reason: collision with root package name */
    protected View f28265a;
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f28266c;
    protected String d;
    protected com.zk_oaction.adengine.lk_sdkwrapper.d e;
    protected HashMap<ZkViewSDK.KEY, Object> f;
    protected Map g;
    protected ZkViewSDK.a h;
    protected com.zk_oaction.adengine.lk_interfaces.c i;
    private boolean j;
    private boolean k;
    private String l;
    private long m;
    private String n;
    private float o;
    private boolean p;
    private boolean q;
    private String r;
    private int s;
    private long t;
    private long u;
    private int v;
    private boolean w;
    private Handler x;
    private Handler y;
    private HandlerThread z;

    /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$a.class */
    class C0936a implements com.zk_oaction.adengine.lk_interfaces.c {

        /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$a$a.class */
        class RunnableC0937a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f28268a;
            final /* synthetic */ int b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f28269c;

            RunnableC0937a(String str, int i, String str2) {
                this.f28268a = str;
                this.b = i;
                this.f28269c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f28268a, this.b, this.f28269c);
            }
        }

        C0936a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00e0 A[Catch: all -> 0x0184, TRY_LEAVE, TryCatch #1 {all -> 0x0184, blocks: (B:2:0x0000, B:28:0x00d6, B:30:0x00e0, B:33:0x0109, B:35:0x0112, B:37:0x011a, B:40:0x0132, B:42:0x0170, B:38:0x0128, B:44:0x017d, B:31:0x00f8), top: B:57:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00f8 A[Catch: all -> 0x0184, TRY_ENTER, TryCatch #1 {all -> 0x0184, blocks: (B:2:0x0000, B:28:0x00d6, B:30:0x00e0, B:33:0x0109, B:35:0x0112, B:37:0x011a, B:40:0x0132, B:42:0x0170, B:38:0x0128, B:44:0x017d, B:31:0x00f8), top: B:57:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0112 A[Catch: all -> 0x0184, TryCatch #1 {all -> 0x0184, blocks: (B:2:0x0000, B:28:0x00d6, B:30:0x00e0, B:33:0x0109, B:35:0x0112, B:37:0x011a, B:40:0x0132, B:42:0x0170, B:38:0x0128, B:44:0x017d, B:31:0x00f8), top: B:57:0x0000 }] */
        @Override // com.zk_oaction.adengine.lk_interfaces.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 411
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.a.C0936a.a():void");
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(MotionEvent motionEvent, int i, int i2) {
            if (motionEvent != null) {
                a.this.H = motionEvent;
                a.this.C = i;
                a.this.D = i2;
                a.this.F = System.currentTimeMillis();
                a.this.B = 0;
                a.this.A = 0;
                a.this.G = null;
                a.this.E = 0L;
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(View view, Map map) {
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(String str) {
            a.this.a(str);
            a.this.b();
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(String str, int i, int i2, int i3, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.h;
            if (aVar2 != null) {
                aVar2.a(aVar.g, str, aVar.b(i), i2, i3, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(String str, int i, int i2, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.h;
            if (aVar2 != null) {
                aVar2.a(aVar.g, str, aVar.b(i), i2, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(String str, int i, String str2) {
            if (a.this.x != null) {
                a.this.x.post(new RunnableC0937a(str, i, str2));
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(String str, int i, String str2, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.h;
            if (aVar2 != null) {
                aVar2.a(aVar.g, str, aVar.b(i), str2, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void b() {
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void b(MotionEvent motionEvent, int i, int i2) {
            if (motionEvent != null) {
                a.this.B = i2;
                a.this.A = i;
                a.this.G = motionEvent;
                a.this.E = System.currentTimeMillis();
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void b(String str, int i, int i2, int i3, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.h;
            if (aVar2 != null) {
                aVar2.b(aVar.g, str, aVar.b(i), i2, i3, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void c(String str, int i, int i2, int i3, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.h;
            if (aVar2 != null) {
                aVar2.c(aVar.g, str, aVar.b(i), i2, i3, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$b.class */
    public class b extends Handler {

        /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$b$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$b$a.class */
        class RunnableC0938a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f28271a;
            final /* synthetic */ View b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f28272c;
            final /* synthetic */ Bitmap d;

            RunnableC0938a(String str, View view, String str2, Bitmap bitmap) {
                this.f28271a = str;
                this.b = view;
                this.f28272c = str2;
                this.d = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.e != null) {
                        if (!TextUtils.isEmpty(this.f28271a)) {
                            a.this.e.e().a("ad_res_index", this.f28271a);
                        }
                        a.this.e.e().a(this.b, this.f28272c, this.d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File[] listFiles;
            int i = message.what;
            try {
                if (i == 1) {
                    HashMap hashMap = (HashMap) message.obj;
                    View view = (View) hashMap.get("param_view");
                    String str = (String) hashMap.get("param_path");
                    String str2 = (String) hashMap.get("ad_res_index");
                    if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        if (a.this.x != null) {
                            a.this.x.post(new RunnableC0938a(str2, view, str, decodeFile));
                        }
                    }
                } else if (i != 2 || a.this.k) {
                } else {
                    ArrayList arrayList = new ArrayList();
                    File file = new File(a.this.b + "/adres");
                    if (!file.exists() || (listFiles = file.listFiles()) == null) {
                        return;
                    }
                    int length = listFiles.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        File file2 = listFiles[i3];
                        if (!file2.isDirectory()) {
                            arrayList.add(file2.getName());
                        }
                        i2 = i3 + 1;
                    }
                    a.this.l = (String) arrayList.get(new Random().nextInt(arrayList.size()));
                    String str3 = a.this.b + "adres/" + a.this.l;
                    Message obtain = Message.obtain();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("param_view", ((HashMap) message.obj).get("param_view"));
                    hashMap2.put("param_path", str3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    a aVar = a.this;
                    sb.append(aVar.c(aVar.l));
                    hashMap2.put("ad_res_index", sb.toString());
                    obtain.obj = hashMap2;
                    obtain.what = 1;
                    if (!new File(str3).exists() || a.this.y == null) {
                        return;
                    }
                    a.this.y.sendMessage(obtain);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$c.class */
    public class c extends Handler {

        /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$c$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$c$a.class */
        class RunnableC0939a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ HashMap f28274a;

            RunnableC0939a(HashMap hashMap) {
                this.f28274a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f28274a);
            }
        }

        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            try {
                if (i == 101) {
                    if (a.this.M > 0) {
                        a.j(a.this);
                        com.zk_oaction.adengine.lk_sdkwrapper.d dVar = a.this.e;
                        if (dVar != null && dVar.e() != null) {
                            com.zk_oaction.adengine.lk_sdk.b e = a.this.e.e();
                            String str = ZkViewSDK.c.R;
                            e.a(str, "" + a.this.M);
                        }
                        if (a.this.x != null) {
                            a.this.x.sendEmptyMessageDelayed(101, 1000L);
                        }
                    }
                } else if (i == 102) {
                    HashMap<ZkViewSDK.KEY, Object> hashMap = (HashMap) message.obj;
                    if (a.this.I) {
                        a.this.b(hashMap);
                        return;
                    }
                    a.this.J = new RunnableC0939a(hashMap);
                } else if (i == 103) {
                    d dVar2 = (d) message.obj;
                    com.zk_oaction.adengine.lk_sdkwrapper.d dVar3 = a.this.e;
                    if (dVar3 == null || dVar3.e() == null) {
                        return;
                    }
                    com.zk_oaction.adengine.lk_sdk.b e2 = a.this.e.e();
                    e2.a("download_state", "" + dVar2.f28275a);
                    com.zk_oaction.adengine.lk_sdk.b e3 = a.this.e.e();
                    e3.a("download_progress", "" + dVar2.b);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdkwrapper/a$d.class */
    class d {

        /* renamed from: a  reason: collision with root package name */
        int f28275a;
        int b;
    }

    public a(Context context, int i, String str, HashMap<ZkViewSDK.KEY, Object> hashMap, int i2, Map map, ZkViewSDK.a aVar) {
        super(context);
        this.f28265a = null;
        this.b = null;
        this.f28266c = null;
        this.d = null;
        this.w = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.I = false;
        this.K = 1;
        this.L = -1;
        this.M = -1;
        this.j = false;
        this.m = 0L;
        this.o = 1.0f;
        this.p = false;
        this.q = false;
        this.i = new C0936a();
        this.v = 0;
        this.f28266c = context;
        this.s = i2;
        this.K = i;
        this.f = hashMap;
        this.g = map;
        this.h = aVar;
        if (str.endsWith("/")) {
            this.b = str;
        } else {
            this.b = str + "/";
        }
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        try {
            if (this.h != null) {
                Map map = null;
                if (!TextUtils.isEmpty(str2)) {
                    map = b(str2);
                }
                this.h.a(this.g, "useraction_openadshow", new ZkViewSDK.Event(), str, b(i), map);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, String str2, String str3) {
        com.zk_oaction.adengine.log.b.a().a(this.f28266c, str, this.b, this.r, (String) this.f.get(ZkViewSDK.KEY.KEY_AD_ID), (String) this.f.get(ZkViewSDK.KEY.KEY_USER_ID), this.s, j, str2, str3, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        int i2 = 1;
        if (i == 0) {
            i2 = 0;
        } else if (i != 1) {
            return i != 2 ? -1 : 2;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map b(String str) {
        HashMap hashMap;
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            hashMap = null;
            return hashMap;
        }
        HashMap hashMap2 = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            if (!TextUtils.isEmpty(obj) && !obj.equals(ZkViewSDK.c.m) && !obj.equals(ZkViewSDK.c.n) && !obj.equals(ZkViewSDK.c.p)) {
                hashMap2.put(obj, jSONObject.getString(obj));
            }
        }
        if (jSONObject.has(ZkViewSDK.c.m)) {
            hashMap2.put(ZkViewSDK.c.m, Integer.valueOf(c(this.l)));
        }
        if (jSONObject.has(ZkViewSDK.c.n)) {
            hashMap2.put(ZkViewSDK.c.n, this.l);
        }
        if (jSONObject.has(ZkViewSDK.c.p) && this.m != 0) {
            hashMap2.put(ZkViewSDK.c.p, Integer.valueOf((int) (System.currentTimeMillis() - this.m)));
            this.m = System.currentTimeMillis();
        }
        hashMap = hashMap2;
        if (jSONObject.has(ZkViewSDK.c.q)) {
            int i = this.L;
            hashMap = hashMap2;
            if (i >= 0) {
                hashMap2.put(ZkViewSDK.c.q, Integer.valueOf(i * 1000));
                return hashMap2;
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0266 A[Catch: all -> 0x027e, TRY_ENTER, TryCatch #0 {all -> 0x027e, blocks: (B:2:0x0000, B:5:0x0008, B:7:0x004c, B:10:0x00d8, B:12:0x00e6, B:17:0x0102, B:28:0x0170, B:58:0x0266, B:18:0x011f, B:20:0x0129, B:22:0x0137, B:27:0x0153, B:29:0x0180, B:31:0x018a, B:33:0x0198, B:38:0x01b8, B:40:0x01e5, B:42:0x01ef, B:45:0x0201, B:47:0x0208, B:49:0x021f, B:55:0x024e, B:51:0x022d, B:53:0x0234), top: B:65:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r10, int r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.a.b(java.lang.String, int, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(String str) {
        try {
            return Integer.parseInt(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim());
        } catch (Throwable th) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map g() {
        HashMap hashMap = new HashMap();
        int i = this.L;
        if (i >= 0) {
            hashMap.put(ZkViewSDK.c.q, Integer.valueOf(i * 1000));
        }
        return hashMap;
    }

    private void h() {
        HandlerThread handlerThread = new HandlerThread("engine_work");
        this.z = handlerThread;
        handlerThread.start();
        this.y = new b(this.z.getLooper());
    }

    private void i() {
        if (this.x == null) {
            this.x = new c(Looper.getMainLooper());
        }
    }

    static /* synthetic */ int j(a aVar) {
        int i = aVar.M;
        aVar.M = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        View a2 = this.e.e().a(ZkViewSDK.c.O);
        if (a2 == null || this.k) {
            return;
        }
        Message obtain = Message.obtain();
        HashMap hashMap = new HashMap();
        hashMap.put("param_view", a2);
        obtain.obj = hashMap;
        obtain.what = 2;
        Handler handler = this.y;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void a() {
        int i;
        try {
            if (this.j && (i = this.L) > 0 && this.x != null) {
                this.M = i;
                com.zk_oaction.adengine.lk_sdkwrapper.d dVar = this.e;
                if (dVar != null && dVar.e() != null) {
                    com.zk_oaction.adengine.lk_sdk.b e = this.e.e();
                    String str = ZkViewSDK.c.R;
                    e.a(str, "" + this.M);
                }
                this.x.removeMessages(101);
                this.x.sendEmptyMessageDelayed(101, 1000L);
            }
        } catch (Throwable th) {
        }
    }

    public void a(int i) {
        this.L = i;
    }

    public void a(int i, int i2) {
        synchronized (this) {
            try {
                this.u = System.currentTimeMillis();
                a("view_start_load", -1L, "", "");
                String frameLayout = toString();
                this.d = this.b + frameLayout.substring(frameLayout.indexOf("{"), frameLayout.indexOf("{") + 8);
                if (this.e == null) {
                    this.e = new com.zk_oaction.adengine.lk_sdkwrapper.d(this.f28266c, 1, i, i2);
                }
                View a2 = this.e.a(this.b, this.i);
                this.f28265a = a2;
                if (a2 != null && a2.getParent() == null) {
                    addView(this.f28265a);
                    invalidate();
                }
            } catch (Throwable th) {
                a(th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        try {
            ZkViewSDK.a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.g, str, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(HashMap<ZkViewSDK.KEY, Object> hashMap) {
        if (this.x != null) {
            Message obtain = Message.obtain();
            obtain.obj = hashMap;
            obtain.what = 102;
            this.x.removeMessages(102);
            this.x.sendMessage(obtain);
        }
    }

    public void a(boolean z) {
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar = this.e;
        if (dVar == null) {
            return;
        }
        dVar.a(z);
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.e != null) {
                    d();
                    a("view_destroy", -1L, "", "");
                    this.e.h();
                    removeAllViews();
                    this.e = null;
                    this.g = null;
                    this.f = null;
                    this.h = null;
                    Handler handler = this.y;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    HandlerThread handlerThread = this.z;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.z = null;
                    }
                    if (this.J != null) {
                        this.J = null;
                    }
                    Handler handler2 = this.x;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        this.x = null;
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, int i2) {
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar = this.e;
        if (dVar == null || dVar.e() == null) {
            return;
        }
        float d2 = this.e.e().d();
        com.zk_oaction.adengine.lk_sdk.b e = this.e.e();
        e.a("container_width", "" + (i / d2));
        com.zk_oaction.adengine.lk_sdk.b e2 = this.e.e();
        e2.a("container_height", "" + (i2 / d2));
    }

    public void b(HashMap<ZkViewSDK.KEY, Object> hashMap) {
        Handler handler;
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar;
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar2;
        Handler handler2;
        View view;
        try {
            com.zk_oaction.adengine.lk_sdkwrapper.d dVar3 = this.e;
            if (dVar3 == null || dVar3.e() == null || hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<ZkViewSDK.KEY, Object> entry : hashMap.entrySet()) {
                ZkViewSDK.KEY key = entry.getKey();
                Object value = entry.getValue();
                int i = key.keyType;
                boolean z = true;
                if (i == ZkViewSDK.c.z) {
                    View a2 = this.e.e().a(key.key);
                    if (a2 != null) {
                        try {
                            if (value instanceof String) {
                                String str = (String) value;
                                Message obtain = Message.obtain();
                                HashMap hashMap2 = new HashMap();
                                if (ZkViewSDK.c.O.equals(key.key)) {
                                    this.l = (String) value;
                                    str = this.b + "adres/" + this.l;
                                    this.k = true;
                                    hashMap2.put("ad_res_index", "" + c(this.l));
                                }
                                hashMap2.put("param_view", a2);
                                hashMap2.put("param_path", str);
                                obtain.obj = hashMap2;
                                obtain.what = 1;
                                if (new File(str).exists() && (handler = this.y) != null) {
                                    handler.sendMessage(obtain);
                                }
                            } else if ((value instanceof Bitmap) && (dVar = this.e) != null) {
                                dVar.e().a(a2, null, (Bitmap) value);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    }
                } else if (i == ZkViewSDK.c.A && (value instanceof String)) {
                    String str2 = key.key;
                    if (str2 == null || !str2.equals(ZkViewSDK.c.b)) {
                        String str3 = key.key;
                        if (str3 != null && str3.equals(ZkViewSDK.c.f27477c)) {
                            this.q = true;
                        }
                    } else {
                        this.p = true;
                    }
                    if (this.p && this.q) {
                        this.e.e().a("show_developer", "1");
                    }
                    View a3 = this.e.e().a(key.key);
                    if (a3 != null) {
                        String str4 = (String) value;
                        if (!TextUtils.isEmpty(str4)) {
                            this.e.e().a(a3, str4);
                        }
                    }
                } else {
                    if (i == ZkViewSDK.c.B && (value instanceof Integer)) {
                        String str5 = key.key;
                        if (str5 == null || !str5.equals(ZkViewSDK.c.R)) {
                            String str6 = key.key;
                            if (str6 == null || !str6.equals(ZkViewSDK.c.k)) {
                                String str7 = key.key;
                                if (str7 == null || !str7.equals(ZkViewSDK.c.S)) {
                                    String str8 = key.key;
                                    Integer num = value;
                                    if (str8 != null) {
                                        num = value;
                                        if (str8.equals(ZkViewSDK.c.i)) {
                                            num = value;
                                            if (((Integer) value).intValue() <= 0) {
                                                num = 1;
                                            }
                                        }
                                    }
                                    this.e.e().a(key.key, "" + num);
                                } else {
                                    this.e.e().b(((Integer) value).intValue());
                                }
                            } else {
                                if (((Integer) value).intValue() <= 0) {
                                    z = false;
                                }
                                this.j = z;
                                if (this.L > 0 && this.M <= 0) {
                                }
                            }
                        } else {
                            a(((Integer) value).intValue());
                        }
                        a();
                    } else if (i == ZkViewSDK.c.C && (value instanceof View)) {
                        View a4 = this.e.e().a(key.key);
                        if ((a4 instanceof com.zk_oaction.adengine.lk_view.e) && (view = (View) value) != null) {
                            if (((com.zk_oaction.adengine.lk_view.e) a4).getChildCount() > 0) {
                                ((com.zk_oaction.adengine.lk_view.e) a4).removeAllViews();
                            }
                            ((com.zk_oaction.adengine.lk_view.e) a4).addView(view);
                        }
                    } else if (i == ZkViewSDK.c.D && (value instanceof List)) {
                        try {
                            if (((List) value).size() > 0) {
                                for (int i2 = 0; i2 < ((List) value).size(); i2++) {
                                    Object obj = ((List) value).get(i2);
                                    if (obj instanceof String) {
                                        View a5 = this.e.e().a(key.key + "_" + i2);
                                        if (a5 != null) {
                                            String str9 = (String) obj;
                                            Message obtain2 = Message.obtain();
                                            HashMap hashMap3 = new HashMap();
                                            hashMap3.put("param_view", a5);
                                            hashMap3.put("param_path", str9);
                                            obtain2.obj = hashMap3;
                                            obtain2.what = 1;
                                            if (new File(str9).exists() && (handler2 = this.y) != null) {
                                                handler2.sendMessage(obtain2);
                                            }
                                        }
                                    } else if ((obj instanceof Bitmap) && (dVar2 = this.e) != null) {
                                        View a6 = dVar2.e().a(key.key + "_" + i2);
                                        if (a6 != null) {
                                            this.e.e().a(a6, null, (Bitmap) obj);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    } else if (i == ZkViewSDK.c.E && (value instanceof String)) {
                        try {
                            String str10 = key.key;
                            if (str10 != null && str10.equals(ZkViewSDK.c.d)) {
                                this.e.e().b(key.key, (String) value);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }

    public void c() {
        Handler handler;
        synchronized (this) {
            if (this.e != null) {
                this.t = System.currentTimeMillis();
                a("view_resume", -1L, "", "");
                this.w = false;
                this.e.f();
                try {
                    if (this.M > 0 && (handler = this.x) != null) {
                        handler.removeMessages(101);
                        this.x.sendEmptyMessageDelayed(101, 1000L);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            if (this.e != null && !this.w) {
                a("view_hide", System.currentTimeMillis() - this.t, "", "");
                this.w = true;
                this.e.g();
                try {
                    Handler handler = this.x;
                    if (handler != null) {
                        handler.removeMessages(101);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public String e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        if (this.f28265a == null || this.e == null) {
            return;
        }
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float measuredWidth2 = this.f28265a.getMeasuredWidth();
        float measuredHeight2 = this.f28265a.getMeasuredHeight();
        if (measuredHeight2 == 0.0f || measuredWidth2 == 0.0f) {
            return;
        }
        float f = measuredWidth / measuredWidth2;
        float f2 = measuredHeight / measuredHeight2;
        float f3 = f2 > f ? f : f2;
        if (this.K == 2) {
            f3 = f2 < f ? f : f2;
        }
        this.o = f3;
        this.f28265a.setPivotX(0.0f);
        this.f28265a.setPivotY(0.0f);
        this.f28265a.setScaleX(f3);
        this.f28265a.setScaleY(f3);
        this.f28265a.setTranslationX((int) ((measuredWidth - (measuredWidth2 * f3)) / 2.0f));
        this.f28265a.setTranslationY((int) ((measuredHeight - (f3 * measuredHeight2)) / 2.0f));
        forceLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f28265a;
        if (view != null) {
            view.layout(0, 0, view.getMeasuredWidth(), this.f28265a.getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        try {
            if (this.f28265a == null) {
                return;
            }
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (size <= 0 || size2 <= 0) {
                return;
            }
            float d2 = this.e.e().d();
            float e = this.e.e().e();
            float f = this.e.e().f();
            b(size, size2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (e * d2), View.MeasureSpec.getMode(i));
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (d2 * f), View.MeasureSpec.getMode(i2));
            this.f28265a.measure(makeMeasureSpec, makeMeasureSpec2);
            ViewGroup viewGroup = (ViewGroup) this.f28265a;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= viewGroup.getChildCount()) {
                    f();
                    return;
                } else {
                    viewGroup.getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
                    i3 = i4 + 1;
                }
            }
        } catch (Exception e2) {
            a(e2.getMessage());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.f28265a = null;
        try {
            super.removeAllViews();
        } catch (Throwable th) {
        }
    }
}

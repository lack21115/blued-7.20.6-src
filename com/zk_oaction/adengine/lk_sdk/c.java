package com.zk_oaction.adengine.lk_sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c.class */
public class c {
    private static final byte[] F = "6^)(9-p35@%3#4S!4S0)$Y%%^&5(j.&^&o(*0)$Y%!#O@*GpG@=+@j.&6^)(0-=+".getBytes(Charset.defaultCharset());

    /* renamed from: a  reason: collision with root package name */
    public static int f41930a;
    public static int b;

    /* renamed from: c  reason: collision with root package name */
    public static float f41931c;
    public static float d;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    private HashMap<String, com.zk_oaction.adengine.lk_view.c> G;
    private com.zk_oaction.adengine.lk_command.d H;
    private boolean I;
    private Handler J;
    private Time K;
    private com.zk_oaction.adengine.lk_sdk.interfaces.d L;
    private View M;
    private ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.e> N;
    private boolean O;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private com.zk_oaction.adengine.lk_interfaces.c W;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> X;
    private BroadcastReceiver Y;
    private HashMap<String, HashSet<String>> Z;
    public boolean e;
    public boolean f;
    public com.zk_oaction.adengine.lk_interfaces.d g;
    public ArrayList<com.zk_oaction.adengine.lk_view.a> h;
    public Context j;
    public com.zk_oaction.adengine.lk_interfaces.a k;
    public String l;
    public com.zk_oaction.adengine.lk_view.d m;
    public com.zk_oaction.adengine.lk_variable.g n;
    public com.zk_oaction.adengine.lk_animation.c o;
    public HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.f> p;
    public CopyOnWriteArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.a> q;
    public HashMap<com.zk_oaction.adengine.lk_interfaces.b, HashSet<View>> r;
    public ArrayList<com.zk_oaction.adengine.lk_unlock.b> s;
    public float t;
    public boolean v;
    public Thread w;
    public Looper x;
    public Handler y;
    public ArrayList<Bitmap> z;
    public long u = 16;
    private boolean P = false;
    private boolean aa = false;
    public int i = 2000;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$a.class */
    public class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.d(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$b.class */
    public class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.e(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.zk_oaction.adengine.lk_sdk.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$c.class */
    public class C1105c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C1105c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.f(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$d.class */
    public class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.g(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$e.class */
    public class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.h(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$f.class */
    public class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.i(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$g.class */
    public class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.j(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$h.class */
    public class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.k(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$i.class */
    public class i implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.l(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$j.class */
    public class j implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        j() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.m(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$k.class */
    public class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c.this.K.setToNow();
            c cVar = c.this;
            c.this.n.a("second", cVar.c(cVar.K.second));
            sendEmptyMessageDelayed(0, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$l.class */
    public class l implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        l() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.n(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$m.class */
    public class m implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        m() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.o(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$n.class */
    public class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.s();
            if (c.this.I) {
                c.this.k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$o.class */
    public class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.W != null) {
                c.this.W.a("parser error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$p.class */
    public class p implements FileFilter {
        p(c cVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            return !name.startsWith("manifest") && name.contains("manifest") && name.endsWith(".xml");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$q.class */
    public class q extends BroadcastReceiver {
        q() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_TIME_TICK.equals(intent.getAction()) || "android.intent.action.TIME_SET".equals(intent.getAction()) || Intent.ACTION_TIMEZONE_CHANGED.equals(intent.getAction())) {
                c.this.j();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$r.class */
    class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f41948a;
        final /* synthetic */ String b;

        r(String str, String str2) {
            this.f41948a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.n.a(this.f41948a, this.b);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$s.class */
    class s implements Runnable {
        s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.o();
            c.this.P = false;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$t.class */
    class t extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f41951a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(c cVar, String str, Runnable runnable) {
            super(str);
            this.f41951a = runnable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f41951a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$u.class */
    public class u implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        u() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.a(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$v.class */
    public class v implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        v() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.a(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$w.class */
    public class w implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        w() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.b(xmlPullParser);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_sdk/c$x.class */
    public class x implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        x() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Void a(XmlPullParser xmlPullParser) {
            c.this.c(xmlPullParser);
            return null;
        }
    }

    public c(Context context, com.zk_oaction.adengine.lk_interfaces.a aVar) {
        this.j = context;
        this.k = aVar;
        i();
        if (f41930a / b >= 0.562f) {
            this.C = true;
        }
        this.n = new com.zk_oaction.adengine.lk_variable.g(this);
        this.o = new com.zk_oaction.adengine.lk_animation.c(this);
        this.p = new HashMap<>();
        this.G = new HashMap<>();
        this.q = new CopyOnWriteArrayList<>();
        this.s = new ArrayList<>();
        this.r = new HashMap<>();
        this.z = new ArrayList<>();
        this.h = new ArrayList<>();
        this.Z = new HashMap<>();
        Looper mainLooper = Looper.getMainLooper();
        this.x = mainLooper;
        this.w = mainLooper.getThread();
        this.y = new Handler(this.x);
        this.N = new ArrayList<>();
        this.V = -1;
        this.U = -1;
        this.T = -1;
        this.S = -1;
        this.R = -1;
        this.Q = -1;
        n();
    }

    public static int a(String str) {
        if (str.contains("manifest_")) {
            try {
                String substring = str.substring(str.indexOf("manifest"));
                return Integer.parseInt(substring.substring(9, substring.indexOf(".xml")));
            } catch (Exception e2) {
                return 0;
            }
        }
        return 0;
    }

    private static String a(Context context) {
        String locale = context.getResources().getConfiguration().locale.toString();
        String str = locale;
        if (Build.VERSION.SDK_INT >= 24) {
            String w2 = w();
            str = locale;
            if (w2 != null) {
                str = w2;
            }
        }
        String str2 = str;
        if (str.contains("zh_CN")) {
            str2 = "zh_CN";
        }
        return str2;
    }

    private static String a(File file, String str) {
        String[] list = file.list();
        if (list == null) {
            return "strings.xml";
        }
        int length = list.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return "strings.xml";
            }
            String str2 = list[i3];
            String str3 = "strings_" + str + ".xml";
            if (str2.equals(str3)) {
                return str3;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "screenWidth");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 720;
        int i2 = f41930a;
        int i3 = b;
        int i4 = i2;
        int i5 = i3;
        if (i2 > i3) {
            i5 = i2;
            i4 = i3;
        }
        if (this.C) {
            i5 = (i4 * 16) / 9;
        }
        float f2 = i4;
        float f3 = f2 / parseInt;
        this.t = f3;
        f41931c = f2 / f3;
        float f4 = i5;
        d = f4 / f3;
        this.n.a("screen_width", "" + f41931c);
        this.n.a("screen_height", "" + d);
        float f5 = this.t;
        this.D = (int) (f2 / f5);
        this.E = (int) (f4 / f5);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "displayWidth");
        if (attributeValue2 != null) {
            this.D = Integer.parseInt(attributeValue2);
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "displayHeight");
        if (attributeValue3 != null) {
            this.E = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue4 != null && !attributeValue4.equals("0")) {
            this.u = 1000 / Integer.parseInt(attributeValue4);
        }
        xmlPullParser.getAttributeValue(null, "id");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, LoaderConstants.VIBRATE);
        this.O = attributeValue5 != null ? Boolean.parseBoolean(attributeValue5) : true;
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "pressure");
        if (attributeValue6 != null) {
            this.A = Boolean.parseBoolean(attributeValue6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        com.zk_oaction.adengine.lk_variable.d a2 = this.n.a(attributeValue);
        com.zk_oaction.adengine.lk_variable.d dVar = a2;
        if (a2 == null) {
            dVar = new com.zk_oaction.adengine.lk_variable.d(this, attributeValue);
            this.n.a(dVar);
        }
        dVar.a(xmlPullParser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(int i2) {
        return ("" + (i2 / 10)) + (i2 % 10);
    }

    private String c(String str) {
        String d2 = d(str, "manifest.xml");
        if (TextUtils.isEmpty(d2)) {
            File file = new File(str + "manifest_110.xml");
            return file.exists() ? file.getName() : c(str, "manifest.xml");
        }
        return d2;
    }

    private String c(String str, String str2) {
        File file;
        int i2;
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return str2;
        }
        File file2 = null;
        int length = listFiles.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= length) {
                break;
            }
            File file3 = listFiles[i3];
            if (file3.isDirectory()) {
                file = file2;
                i2 = i5;
            } else {
                String name = file3.getName();
                file = file2;
                i2 = i5;
                if (name.startsWith("manifest")) {
                    file = file2;
                    i2 = i5;
                    if (name.endsWith(".xml")) {
                        file = file2;
                        i2 = i5;
                        if (!name.equals("manifest.xml")) {
                            try {
                                int parseInt = Integer.parseInt(name.substring(9, name.indexOf(".xml")));
                                file = file2;
                                i2 = i5;
                                if (parseInt < 110) {
                                    file = file2;
                                    i2 = i5;
                                    if (parseInt / 100 == 1) {
                                        file = file2;
                                        i2 = i5;
                                        if (i5 < parseInt) {
                                            file = file3;
                                            i2 = parseInt;
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                file = file2;
                                i2 = i5;
                            }
                        }
                    }
                }
            }
            i3++;
            file2 = file;
            i4 = i2;
        }
        if (file2 != null) {
            str2 = file2.getName();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.d dVar = new com.zk_oaction.adengine.lk_command.d(this);
        this.H = dVar;
        if (dVar.a(xmlPullParser, "ExternalCommands")) {
            return;
        }
        this.H = null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|6|7|(2:9|(2:11|(2:13|(8:15|(4:16|17|(2:19|(2:20|(4:22|23|(2:25|26)(1:28)|27)))(1:30)|29)|31|32|33|34|35|36))))|41|(2:42|43)|45|31|32|33|34|35|36) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.InputStream d(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdk.c.d(java.lang.String):java.io.InputStream");
    }

    private String d(String str, String str2) {
        float f2;
        String str3;
        File[] listFiles = new File(str).listFiles(new p(this));
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        float f3 = b / f41930a;
        float abs = Math.abs(f3 - 1.7777778f);
        int length = listFiles.length;
        String str4 = str2;
        int i2 = 0;
        while (i2 < length) {
            File file = listFiles[i2];
            try {
                String name = file.getName();
                String[] split = name.substring(0, name.indexOf("manifest") - 1).split(BridgeUtil.UNDERLINE_STR);
                float abs2 = Math.abs(f3 - (Float.parseFloat(split[0]) / Float.parseFloat(split[1])));
                if (abs2 < abs) {
                    try {
                        str4 = file.getName();
                    } catch (Throwable th) {
                    }
                    f2 = abs2;
                    str3 = str4;
                } else {
                    f2 = abs;
                    str3 = str4;
                    if (abs2 == abs) {
                        f2 = abs;
                        str3 = str4;
                        if (a(file.getName()) > a(str4)) {
                            str3 = file.getName();
                            f2 = abs;
                        }
                    }
                }
            } catch (Throwable th2) {
                f2 = abs;
                str3 = str4;
            }
            i2++;
            abs = f2;
            str4 = str3;
        }
        if (str4.equals(str2)) {
            return null;
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(XmlPullParser xmlPullParser) {
        new com.zk_oaction.adengine.lk_variable.c(this).a(xmlPullParser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.f fVar = new com.zk_oaction.adengine.lk_view.f(this);
        if (fVar.a(xmlPullParser, "Group")) {
            this.m.a(fVar);
            if (fVar.e() != null) {
                this.p.put(fVar.e(), fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.g gVar = new com.zk_oaction.adengine.lk_view.g(this);
        if (gVar.b(xmlPullParser, "Image")) {
            this.m.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) gVar);
            if (gVar.e() != null) {
                this.p.put(gVar.e(), gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.e eVar = new com.zk_oaction.adengine.lk_view.e(this);
        if (eVar.b(xmlPullParser, "Frame")) {
            this.m.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) eVar);
            if (eVar.e() != null) {
                this.p.put(eVar.e(), eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.i iVar = new com.zk_oaction.adengine.lk_view.i(this);
        if (iVar.b(xmlPullParser, "ImageNumber")) {
            this.m.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) iVar);
            if (iVar.e() != null) {
                this.p.put(iVar.e(), iVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdk.c.i():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.m mVar = new com.zk_oaction.adengine.lk_view.m(this);
        if (mVar.b(xmlPullParser, "Text")) {
            this.m.a((com.zk_oaction.adengine.lk_sdk.interfaces.b) mVar);
            if (mVar.e() != null) {
                this.p.put(mVar.e(), mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String c2;
        this.K.setToNow();
        int i2 = this.Q;
        int i3 = this.K.year;
        if (i2 != i3) {
            this.Q = i3;
            com.zk_oaction.adengine.lk_variable.g gVar = this.n;
            gVar.a(MediaStore.Audio.AudioColumns.YEAR, "" + this.K.year);
        }
        int i4 = this.R;
        int i5 = this.K.month;
        if (i4 != i5) {
            this.R = i5;
            com.zk_oaction.adengine.lk_variable.g gVar2 = this.n;
            gVar2.a("month", "" + this.K.month);
        }
        int i6 = this.S;
        int i7 = this.K.monthDay;
        if (i6 != i7) {
            this.S = i7;
            com.zk_oaction.adengine.lk_variable.g gVar3 = this.n;
            gVar3.a("date", "" + this.K.monthDay);
        }
        int i8 = this.T;
        int i9 = this.K.weekDay;
        if (i8 != i9) {
            this.T = i9;
            com.zk_oaction.adengine.lk_variable.g gVar4 = this.n;
            gVar4.a("day_of_week", "" + (this.K.weekDay + 1));
        }
        int i10 = this.U;
        int i11 = this.K.hour;
        if (i10 != i11) {
            this.U = i11;
            com.zk_oaction.adengine.lk_variable.g gVar5 = this.n;
            gVar5.a("hour", "" + this.K.hour);
            if (this.v) {
                String c3 = c(this.K.hour % 12);
                c2 = c3;
                if (c3.equals("00")) {
                    this.n.a("hour24", "12");
                    this.n.a("hour12", "12");
                }
            } else {
                c2 = c(this.K.hour);
            }
            this.n.a("hour24", c2);
            this.n.a("hour12", c2);
        }
        int i12 = this.V;
        int i13 = this.K.minute;
        if (i12 != i13) {
            this.V = i13;
            this.n.a("minute", c(i13));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.a aVar = new com.zk_oaction.adengine.lk_command.a(this);
        if (aVar.a(xmlPullParser, "Button")) {
            this.q.add(aVar);
            if (aVar.e() != null) {
                this.p.put(aVar.e(), aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f) {
            return;
        }
        this.o.b();
        Handler handler = this.J;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
        com.zk_oaction.adengine.lk_command.d dVar = this.H;
        if (dVar != null) {
            dVar.a("resume");
        }
        for (Map.Entry<String, com.zk_oaction.adengine.lk_view.c> entry : this.G.entrySet()) {
            entry.getValue().b();
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.d dVar2 = this.L;
        if (dVar2 != null) {
            dVar2.a();
        }
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.e> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.b bVar = new com.zk_oaction.adengine.lk_unlock.b(this);
        if (bVar.a(xmlPullParser, "Slider")) {
            this.q.add(bVar);
            if (bVar.e() != null) {
                this.p.put(bVar.e(), bVar);
            }
        }
    }

    private void l() {
        this.o.c();
        Handler handler = this.J;
        if (handler != null) {
            handler.removeMessages(0);
        }
        com.zk_oaction.adengine.lk_command.d dVar = this.H;
        if (dVar != null) {
            dVar.a(com.anythink.expressad.foundation.d.c.cb);
        }
        for (Map.Entry<String, com.zk_oaction.adengine.lk_view.c> entry : this.G.entrySet()) {
            entry.getValue().c();
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.d dVar2 = this.L;
        if (dVar2 != null) {
            dVar2.b();
        }
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.e> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(XmlPullParser xmlPullParser) {
        new com.zk_oaction.adengine.lk_variable.e(this).a(xmlPullParser, "VariableBinders");
    }

    private void m() {
        this.n.a();
        this.o.a();
        this.p.clear();
        this.G.clear();
        this.q.clear();
        this.s.clear();
        this.r.clear();
        this.H = null;
        this.L = null;
        Iterator<Bitmap> it = this.z.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.z.clear();
        this.X.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.h.size()) {
                this.h.clear();
                return;
            }
            if (this.h.get(i3) != null) {
                this.h.get(i3).g();
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(XmlPullParser xmlPullParser) {
        try {
            com.zk_oaction.adengine.lk_sdk.interfaces.d dVar = (com.zk_oaction.adengine.lk_sdk.interfaces.d) Class.forName(xmlPullParser.getAttributeValue(null, "class")).newInstance();
            this.L = dVar;
            this.m.a(dVar.a(xmlPullParser.getAttributeValue(null, "params"), this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void n() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.X = hashMap;
        hashMap.put("Lockscreen", new u());
        this.X.put("Root", new v());
        this.X.put("Var", new w());
        this.X.put("ExternalCommands", new x());
        this.X.put("VarArray", new a());
        this.X.put("Group", new b());
        this.X.put("Image", new C1105c());
        this.X.put("Frame", new d());
        this.X.put("ImageNumber", new e());
        this.X.put("Text", new f());
        this.X.put("Button", new g());
        this.X.put("Slider", new h());
        this.X.put("VariableBinders", new i());
        this.X.put("UnlockerView", new j());
        this.X.put("Video", new l());
        this.X.put("ParticleView", new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.c cVar = new com.zk_oaction.adengine.lk_view.c(this);
        if (cVar.a(xmlPullParser, "Video")) {
            this.m.a(cVar);
            if (cVar.e() != null) {
                this.G.put(cVar.e(), cVar);
                this.p.put(cVar.e(), cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar;
        a(this, this.l, this.j, this.n);
        String c2 = c(this.l);
        this.L = null;
        InputStream inputStream = null;
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setFeature(XmlPullParser.FEATURE_PROCESS_DOCDECL, false);
            XmlPullParser newPullParser = newInstance.newPullParser();
            StringBuilder sb = new StringBuilder();
            sb.append(this.l);
            sb.append(c2);
            InputStream d2 = d(sb.toString());
            newPullParser.setInput(d2, "utf-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                inputStream = d2;
                if (this.f) {
                    break;
                }
                if (eventType == 2 && (cVar = this.X.get(newPullParser.getName())) != null) {
                    cVar.a(newPullParser);
                }
            }
            try {
                d2.close();
            } catch (Throwable th) {
            }
            if (this.aa) {
                return;
            }
            p();
        } catch (Throwable th2) {
            try {
                this.aa = true;
                th2.printStackTrace();
                q();
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                }
            } catch (Throwable th4) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                }
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.l lVar = new com.zk_oaction.adengine.lk_view.l(this);
        if (lVar.a(xmlPullParser, "ParticleView")) {
            this.q.add(lVar);
        }
    }

    private void p() {
        if (this.f) {
            return;
        }
        if (Thread.currentThread() == this.w) {
            s();
            return;
        }
        this.y.post(new n());
    }

    private void q() {
        try {
            o oVar = new o();
            if (Thread.currentThread() != this.w) {
                this.y.post(oVar);
            } else {
                oVar.run();
            }
        } catch (Throwable th) {
        }
    }

    private void r() {
        if (!this.e) {
            this.e = true;
            this.k.b();
        }
        if (this.l.endsWith(BridgeUtil.SPLIT_MARK)) {
            return;
        }
        this.l += BridgeUtil.SPLIT_MARK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f) {
            return;
        }
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.W;
        if (cVar != null) {
            cVar.a();
        }
        if (t() || u() || v()) {
            b();
        }
        if (this.n.a("second") != null) {
            a();
        }
        if (this.n.a("time") != null) {
            this.o.a(new com.zk_oaction.adengine.lk_animation.h(this));
        }
        com.zk_oaction.adengine.lk_command.d dVar = this.H;
        if (dVar != null) {
            dVar.a(com.anythink.expressad.foundation.d.c.cb);
        }
        if (this.e) {
            this.e = false;
            this.k.c();
        }
    }

    private boolean t() {
        return (this.n.a(MediaStore.Audio.AudioColumns.YEAR) == null && this.n.a("month") == null && this.n.a("date") == null) ? false : true;
    }

    private boolean u() {
        return (this.n.a("hour") == null && this.n.a("hour24") == null && this.n.a("hour12") == null) ? false : true;
    }

    private boolean v() {
        return (this.n.a("day_of_week") == null && this.n.a("minute") == null) ? false : true;
    }

    private static String w() {
        try {
            Class<?> cls = Class.forName("android.os.LocaleList");
            Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
            declaredMethod.setAccessible(true);
            return cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, Integer.TYPE).invoke(declaredMethod.invoke(null, new Object[0]), 0).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    private void x() {
        if (this.Y == null) {
            this.Y = new q();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Intent.ACTION_TIME_TICK);
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
            Context context = this.j;
            if (context != null) {
                context.registerReceiver(this.Y, intentFilter);
            }
        }
    }

    private void y() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.j;
        if (context == null || (broadcastReceiver = this.Y) == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
            this.Y = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Rect a(com.zk_oaction.adengine.lk_view.b bVar) {
        Rect rect = new Rect();
        rect.left = (int) bVar.getX();
        rect.top = (int) bVar.getY();
        rect.right = (int) (rect.left + bVar.k());
        rect.bottom = (int) (rect.top + bVar.l());
        return rect;
    }

    public Rect a(com.zk_oaction.adengine.lk_view.c cVar) {
        Rect rect = new Rect();
        rect.left = (int) cVar.g();
        rect.top = (int) cVar.h();
        rect.right = (int) (rect.left + cVar.d());
        rect.bottom = (int) (rect.top + cVar.f());
        return rect;
    }

    public View a(String str, com.zk_oaction.adengine.lk_interfaces.c cVar) {
        if (this.P) {
            return null;
        }
        this.P = true;
        this.W = cVar;
        this.m = new com.zk_oaction.adengine.lk_view.d(this);
        this.l = str;
        r();
        t tVar = new t(this, "load_view", new s());
        tVar.setPriority(10);
        tVar.start();
        return this.m;
    }

    public com.zk_oaction.adengine.lk_interfaces.b a(String str, View view, float f2, int i2) {
        com.zk_oaction.adengine.lk_interfaces.a aVar = this.k;
        com.zk_oaction.adengine.lk_interfaces.b a2 = aVar.a(this.l + str, f2, i2);
        HashSet<View> hashSet = this.r.get(a2);
        HashSet<View> hashSet2 = hashSet;
        if (hashSet == null) {
            hashSet2 = new HashSet<>();
            this.r.put(a2, hashSet2);
        }
        hashSet2.add(view);
        return a2;
    }

    public com.zk_oaction.adengine.lk_interfaces.b a(String str, View view, int i2) {
        return a(str, view, this.t, i2);
    }

    public void a() {
        if (this.J == null) {
            Time time = new Time();
            this.K = time;
            time.setToNow();
            this.J = new k(this.x);
            this.n.a("second", c(this.K.second));
        }
    }

    public void a(int i2) {
    }

    public void a(long j2) {
        if (this.O) {
            this.k.a(j2);
        }
    }

    public void a(com.zk_oaction.adengine.lk_animation.b bVar) {
        this.o.a(bVar);
    }

    public void a(com.zk_oaction.adengine.lk_interfaces.b bVar) {
        HashSet<View> hashSet = this.r.get(bVar);
        if (hashSet != null) {
            Iterator<View> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }

    public void a(c cVar, String str, Context context, com.zk_oaction.adengine.lk_variable.g gVar) {
        FileInputStream fileInputStream;
        File file = new File(str + "strings");
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(str + "strings" + BridgeUtil.SPLIT_MARK + a(file, a(context)));
            if (file2.exists()) {
                try {
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        newPullParser.setInput(fileInputStream2, "utf-8");
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("string")) {
                                    String attributeValue = newPullParser.getAttributeValue(null, "name");
                                    com.zk_oaction.adengine.lk_variable.d a2 = gVar.a(attributeValue);
                                    com.zk_oaction.adengine.lk_variable.d dVar = a2;
                                    if (a2 == null) {
                                        dVar = new com.zk_oaction.adengine.lk_variable.d(cVar, attributeValue);
                                        gVar.a(dVar);
                                    }
                                    dVar.b(newPullParser.getAttributeValue(null, "value"));
                                }
                            }
                        }
                    } catch (Throwable th) {
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th2) {
                    fileInputStream = null;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                }
            }
        }
    }

    public void a(com.zk_oaction.adengine.lk_unlock.b bVar) {
        if (!bVar.b()) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                this.s.get(i2).a("true");
            }
            return;
        }
        bVar.a("true");
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.s.size()) {
                return;
            }
            com.zk_oaction.adengine.lk_unlock.b bVar2 = this.s.get(i4);
            if (bVar2 != bVar) {
                bVar2.a("false");
            }
            i3 = i4 + 1;
        }
    }

    public void a(String str, float f2) {
        com.zk_oaction.adengine.lk_view.c cVar = this.G.get(str);
        if (cVar != null) {
            cVar.a(f2);
        }
    }

    public void a(String str, com.zk_oaction.adengine.lk_variable.f fVar) {
        this.n.a(str, fVar);
    }

    public void a(String str, String str2) {
        r rVar = new r(str, str2);
        if (Thread.currentThread() != this.w) {
            this.y.post(rVar);
        } else {
            rVar.run();
        }
    }

    public void a(String str, String str2, String str3, int i2, String str4, String str5) {
        com.zk_oaction.adengine.lk_view.c cVar = this.G.get(str);
        if (cVar != null) {
            cVar.a(str2, i2, str3, str4, str5);
        }
    }

    public void a(String str, boolean z, boolean z2) {
        com.zk_oaction.adengine.lk_view.c cVar = this.G.get(str);
        if (cVar != null) {
            cVar.a(z, z2);
        }
    }

    public void a(boolean z) {
        try {
            HashMap<String, com.zk_oaction.adengine.lk_view.c> hashMap = this.G;
            if (hashMap != null) {
                for (Map.Entry<String, com.zk_oaction.adengine.lk_view.c> entry : hashMap.entrySet()) {
                    entry.getValue().a(z);
                }
            }
        } catch (Throwable th) {
        }
    }

    public boolean a(String str, HashSet<String> hashSet) {
        if (hashSet == null || !hashSet.contains(str)) {
            HashSet hashSet2 = new HashSet();
            Iterator<String> it = hashSet.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.Z.containsKey(next)) {
                    if (this.Z.get(next).contains(str)) {
                        return false;
                    }
                    hashSet2.add(next);
                }
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                hashSet.remove(str2);
                hashSet.addAll(this.Z.get(str2));
            }
            hashSet2.clear();
            for (Map.Entry<String, HashSet<String>> entry : this.Z.entrySet()) {
                if (entry.getValue().contains(str)) {
                    if (hashSet.contains(entry.getKey())) {
                        return false;
                    }
                    hashSet2.add(entry.getKey());
                }
            }
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                HashSet<String> hashSet3 = this.Z.get((String) it3.next());
                hashSet3.remove(str);
                hashSet3.addAll(hashSet);
            }
            this.Z.put(str, hashSet);
            return true;
        }
        return false;
    }

    public View b(String str) {
        String e2;
        if (this.m == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.m.a()) {
                return null;
            }
            View a2 = this.m.a(i3);
            if ((a2 instanceof com.zk_oaction.adengine.lk_sdk.interfaces.f) && (e2 = ((com.zk_oaction.adengine.lk_sdk.interfaces.f) a2).e()) != null && e2.equals(str)) {
                return a2;
            }
            i2 = i3 + 1;
        }
    }

    public void b() {
        Time time = new Time();
        this.K = time;
        time.setToNow();
        x();
        c();
        j();
    }

    public void b(int i2) {
        if (i2 > 0) {
            this.i = i2;
        }
    }

    public void b(String str, float f2) {
        com.zk_oaction.adengine.lk_interfaces.d dVar = this.g;
        if (dVar != null) {
            dVar.a(str, f2);
        }
    }

    public void b(String str, String str2) {
        com.zk_oaction.adengine.lk_view.c cVar = this.G.get(str);
        if (cVar != null) {
            cVar.e(str2);
        }
    }

    public void c() {
        com.zk_oaction.adengine.lk_variable.g gVar;
        int i2;
        String str;
        String string = Settings.System.getString(this.j.getContentResolver(), Settings.System.TIME_12_24);
        boolean z = true;
        if (string == null || string.equals("24")) {
            try {
                z = true ^ DateFormat.is24HourFormat(this.j);
            } catch (Exception e2) {
                z = false;
            }
        }
        Time time = new Time();
        this.K = time;
        time.setToNow();
        this.n.a("hour", "" + this.K.hour);
        this.U = this.K.hour;
        this.v = z;
        this.n.a("ishour12", "" + z);
        if (this.v) {
            int i3 = this.K.hour % 12;
            if (i3 == 0) {
                this.n.a("hour24", c(12));
                gVar = this.n;
                str = c(12);
                gVar.a("hour12", str);
            }
            this.n.a("hour24", c(i3));
            gVar = this.n;
            i2 = this.K.hour % 12;
        } else {
            this.n.a("hour24", c(this.K.hour));
            gVar = this.n;
            i2 = this.K.hour;
        }
        str = c(i2);
        gVar.a("hour12", str);
    }

    public void d() {
        if (this.J != null) {
            c();
        }
        if (this.I) {
            return;
        }
        this.I = true;
        View view = this.M;
        if (view != null) {
            view.setVisibility(0);
        } else if (this.e) {
        } else {
            k();
        }
    }

    public void e() {
        if (this.I) {
            this.I = false;
            View view = this.M;
            if (view != null) {
                view.setVisibility(4);
            } else if (this.e) {
            } else {
                l();
            }
        }
    }

    public void f() {
        this.f = true;
        e();
        if (this.g != null) {
            for (Map.Entry<String, com.zk_oaction.adengine.lk_view.c> entry : this.G.entrySet()) {
                this.g.a();
            }
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.d dVar = this.L;
        if (dVar != null) {
            dVar.c();
        }
        try {
            for (Map.Entry<String, com.zk_oaction.adengine.lk_view.c> entry2 : this.G.entrySet()) {
                entry2.getValue().a();
            }
        } catch (Throwable th) {
        }
        m();
        y();
    }

    public float g() {
        return d;
    }

    public float h() {
        return f41931c;
    }
}

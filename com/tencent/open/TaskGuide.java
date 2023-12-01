package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide.class */
public class TaskGuide extends BaseApi {
    private static int L = 3000;
    static long b = 5000;
    private static Drawable k;
    private static Drawable l;
    private static Drawable m;
    private static int n = 75;
    private static int o = 284;
    private static int p = 75;
    private static int q = 30;
    private static int r = 29;
    private static int s = 5;
    private static int t = 74;
    private static int u = 0;
    private static int v = 6;
    private static int w = 153;
    private static int x = 30;
    private static int y = 6;
    private static int z = 3;
    private int A;
    private int B;
    private float C;
    private Interpolator D;
    private boolean E;
    private Context F;
    private boolean G;
    private boolean H;
    private long I;
    private int J;
    private int K;
    private Runnable M;
    private Runnable N;

    /* renamed from: a  reason: collision with root package name */
    boolean f38201a;

    /* renamed from: c  reason: collision with root package name */
    IUiListener f38202c;
    private WindowManager.LayoutParams d;
    private ViewGroup e;
    private WindowManager f;
    private Handler g;
    private h h;
    private k i;
    private k j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.open.TaskGuide$4  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38206a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[k.values().length];
            f38206a = iArr;
            try {
                iArr[k.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f38206a[k.NORAML.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f38206a[k.WAITTING_BACK_REWARD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f38206a[k.REWARD_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$a.class */
    abstract class a implements IRequestListener {
        private a() {
        }

        protected abstract void a(Exception exc);

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            a(connectTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            a(httpStatusException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            a(iOException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            a(jSONException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            a(malformedURLException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            a(networkUnavailableException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            a(socketTimeoutException);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            a(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$b.class */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskGuide.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$c.class */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f38209a;
        float b = 0.0f;

        public c(boolean z) {
            this.f38209a = false;
            this.f38209a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemClock.currentThreadTimeMillis();
            float f = (float) (this.b + 0.1d);
            this.b = f;
            float f2 = f;
            if (f > 1.0f) {
                f2 = 1.0f;
            }
            boolean z = f2 >= 1.0f;
            int interpolation = (int) (TaskGuide.this.D.getInterpolation(f2) * TaskGuide.this.J);
            if (this.f38209a) {
                TaskGuide.this.d.y = TaskGuide.this.K + interpolation;
            } else {
                TaskGuide.this.d.y = TaskGuide.this.K - interpolation;
            }
            com.tencent.open.a.f.b("openSDK_LOG.TaskGuide", "mWinParams.y = " + TaskGuide.this.d.y + "deltaDistence = " + interpolation);
            if (TaskGuide.this.E) {
                TaskGuide.this.f.updateViewLayout(TaskGuide.this.e, TaskGuide.this.d);
            } else {
                z = true;
            }
            if (z) {
                TaskGuide.this.i();
            } else {
                TaskGuide.this.g.postDelayed(TaskGuide.this.M, 5L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$d.class */
    public class d extends a {
        int b;

        public d(int i) {
            super();
            this.b = -1;
            this.b = i;
        }

        @Override // com.tencent.open.TaskGuide.a
        protected void a(final Exception exc) {
            if (exc != null) {
                exc.printStackTrace();
            }
            TaskGuide.this.f38202c.onError(new UiError(101, "error ", "金券领取时出现异常"));
            if (TaskGuide.this.g != null) {
                TaskGuide.this.g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        k kVar = k.INIT;
                        if ((d.this.b == 0 ? TaskGuide.this.i : TaskGuide.this.j) == k.WAITTING_BACK_REWARD) {
                            TaskGuide.this.a(d.this.b, k.NORAML);
                            TaskGuide taskGuide = TaskGuide.this;
                            taskGuide.a("领取失败 :" + exc.getClass().getName());
                        }
                        TaskGuide.this.b(d.this.b);
                        TaskGuide.this.d(2000);
                    }
                });
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            int i;
            String string;
            String str = null;
            try {
                i = jSONObject.getInt("code");
                string = jSONObject.getString("message");
            } catch (JSONException e) {
                TaskGuide.this.a(this.b, k.NORAML);
                TaskGuide.this.a(str);
                e.printStackTrace();
            }
            if (i == 0) {
                TaskGuide.this.a(this.b, k.REWARD_SUCCESS);
                str = string;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("result", "金券领取成功");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                TaskGuide.this.f38202c.onComplete(jSONObject2);
                TaskGuide.this.b(this.b);
                TaskGuide.this.d(2000);
            }
            TaskGuide.this.a(this.b, k.NORAML);
            TaskGuide.this.a(string);
            str = string;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result", "金券领取失败");
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            TaskGuide.this.f38202c.onComplete(jSONObject3);
            TaskGuide.this.b(this.b);
            TaskGuide.this.d(2000);
            TaskGuide.this.a(this.b, k.NORAML);
            TaskGuide.this.a(str);
            e.printStackTrace();
            TaskGuide.this.b(this.b);
            TaskGuide.this.d(2000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$e.class */
    public class e extends RelativeLayout {

        /* renamed from: a  reason: collision with root package name */
        int f38213a;

        public e(Context context) {
            super(context);
            this.f38213a = 0;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int y = (int) motionEvent.getY();
            com.tencent.open.a.f.a("openSDK_LOG.TaskGuide", "onInterceptTouchEvent-- action = " + motionEvent.getAction() + "currentY = " + y);
            TaskGuide.this.d(3000);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f38213a = y;
                return false;
            } else if (action == 1 && this.f38213a - y > ViewConfiguration.getTouchSlop() * 2) {
                TaskGuide.this.l();
                return true;
            } else {
                return super.onInterceptTouchEvent(motionEvent);
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            int y = (int) motionEvent.getY();
            com.tencent.open.a.f.b("openSDK_LOG.TaskGuide", " onTouchEvent-----startY = " + this.f38213a + "currentY = " + y);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f38213a = y;
                return false;
            } else if (action == 1 && this.f38213a - y > ViewConfiguration.getTouchSlop() * 2) {
                TaskGuide.this.l();
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$f.class */
    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        int f38214a;

        public f(int i) {
            this.f38214a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Button button = (Button) view;
            if (TaskGuide.this.c(this.f38214a) == k.NORAML) {
                TaskGuide.this.e(this.f38214a);
                TaskGuide.this.b(this.f38214a);
            }
            TaskGuide.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$g.class */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        int f38215a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f38216c;
        long d;
        int e;

        public g(int i, String str, String str2, long j, int i2) {
            this.f38215a = i;
            this.b = str;
            this.f38216c = str2;
            this.d = j;
            this.e = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$h.class */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        String f38217a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        g[] f38218c;

        private h() {
        }

        static h a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            h hVar = new h();
            JSONObject jSONObject2 = jSONObject.getJSONObject("task_info");
            hVar.f38217a = jSONObject2.getString("task_id");
            hVar.b = jSONObject2.getString("task_desc");
            JSONArray jSONArray = jSONObject2.getJSONArray("step_info");
            int length = jSONArray.length();
            if (length > 0) {
                hVar.f38218c = new g[length];
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return hVar;
                }
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                hVar.f38218c[i2] = new g(jSONObject3.getInt("step_no"), jSONObject3.getString("step_desc"), jSONObject3.getString("step_gift"), jSONObject3.getLong("end_time"), jSONObject3.getInt("status"));
                i = i2 + 1;
            }
        }

        public boolean a() {
            g[] gVarArr;
            return (TextUtils.isEmpty(this.f38217a) || (gVarArr = this.f38218c) == null || gVarArr.length <= 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$i.class */
    public class i extends LinearLayout {
        private TextView b;

        /* renamed from: c  reason: collision with root package name */
        private Button f38220c;
        private g d;

        public i(Context context, g gVar) {
            super(context);
            this.d = gVar;
            setOrientation(0);
            a();
        }

        private void a() {
            TextView textView = new TextView(TaskGuide.this.F);
            this.b = textView;
            textView.setTextColor(Color.rgb(255, 255, 255));
            this.b.setTextSize(15.0f);
            this.b.setShadowLayer(1.0f, 1.0f, 1.0f, Color.rgb(242, 211, 199));
            this.b.setGravity(3);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setIncludeFontPadding(false);
            this.b.setSingleLine(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.leftMargin = TaskGuide.this.a(4);
            addView(this.b, layoutParams);
            Button button = new Button(TaskGuide.this.F);
            this.f38220c = button;
            button.setPadding(0, 0, 0, 0);
            this.f38220c.setTextSize(16.0f);
            this.f38220c.setTextColor(Color.rgb(255, 255, 255));
            this.f38220c.setShadowLayer(1.0f, 1.0f, 1.0f, Color.rgb(242, 211, 199));
            this.f38220c.setIncludeFontPadding(false);
            this.f38220c.setOnClickListener(new f(this.d.f38215a));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(TaskGuide.this.a(TaskGuide.p), TaskGuide.this.a(TaskGuide.q));
            layoutParams2.leftMargin = TaskGuide.this.a(2);
            layoutParams2.rightMargin = TaskGuide.this.a(8);
            addView(this.f38220c, layoutParams2);
        }

        public void a(k kVar) {
            if (!TextUtils.isEmpty(this.d.b)) {
                this.b.setText(this.d.b);
            }
            int i = AnonymousClass4.f38206a[kVar.ordinal()];
            if (i == 1) {
                this.f38220c.setEnabled(false);
            } else if (i != 2) {
                if (i == 3) {
                    this.f38220c.setText("领取中...");
                    this.f38220c.setEnabled(false);
                } else if (i != 4) {
                } else {
                    this.f38220c.setText("已领取");
                    this.f38220c.setBackgroundDrawable(TaskGuide.this.g());
                    this.f38220c.setEnabled(false);
                }
            } else if (this.d.e == 1) {
                this.f38220c.setText(this.d.f38216c);
                this.f38220c.setBackgroundDrawable(null);
                this.f38220c.setTextColor(Color.rgb(255, 246, 0));
                this.f38220c.setEnabled(false);
            } else if (this.d.e == 2) {
                this.f38220c.setText("领取奖励");
                this.f38220c.setTextColor(Color.rgb(255, 255, 255));
                this.f38220c.setBackgroundDrawable(TaskGuide.this.f());
                this.f38220c.setEnabled(true);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$j.class */
    class j extends a {
        private j() {
            super();
        }

        @Override // com.tencent.open.TaskGuide.a
        protected void a(Exception exc) {
            if (exc != null) {
                exc.printStackTrace();
            }
            if (exc == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", "暂无任务");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                TaskGuide.this.f38202c.onComplete(jSONObject);
            } else {
                TaskGuide.this.f38202c.onError(new UiError(100, "error ", "获取任务失败"));
            }
            TaskGuide.this.g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.j.1
                @Override // java.lang.Runnable
                public void run() {
                    TaskGuide.this.a(2, k.INIT);
                }
            });
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            try {
                TaskGuide.this.h = h.a(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TaskGuide.this.h == null || !TaskGuide.this.h.a()) {
                a(null);
                return;
            }
            TaskGuide.this.showWindow();
            TaskGuide.this.a(2, k.NORAML);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", "获取成功");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            TaskGuide.this.f38202c.onComplete(jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/TaskGuide$k.class */
    public enum k {
        INIT,
        WAITTING_BACK_TASKINFO,
        WAITTING_BACK_REWARD,
        NORAML,
        REWARD_SUCCESS,
        REWARD_FAIL
    }

    public TaskGuide(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
        this.d = null;
        this.e = null;
        this.g = new Handler(Looper.getMainLooper());
        this.i = k.INIT;
        this.j = k.INIT;
        this.A = 0;
        this.B = 0;
        this.C = 0.0f;
        this.D = new AccelerateInterpolator();
        this.E = false;
        this.f38201a = false;
        this.G = false;
        this.H = false;
        this.M = null;
        this.N = null;
        this.F = context;
        this.f = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        c();
    }

    public TaskGuide(Context context, QQToken qQToken) {
        super(qQToken);
        this.d = null;
        this.e = null;
        this.g = new Handler(Looper.getMainLooper());
        this.i = k.INIT;
        this.j = k.INIT;
        this.A = 0;
        this.B = 0;
        this.C = 0.0f;
        this.D = new AccelerateInterpolator();
        this.E = false;
        this.f38201a = false;
        this.G = false;
        this.H = false;
        this.M = null;
        this.N = null;
        this.F = context;
        this.f = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2) {
        return (int) (i2 * this.C);
    }

    private Drawable a(String str, Context context) {
        Drawable drawable;
        InputStream open;
        Bitmap bitmap;
        AssetManager assets = context.getApplicationContext().getAssets();
        Drawable drawable2 = null;
        try {
            open = assets.open(str);
        } catch (IOException e2) {
            e2.printStackTrace();
            drawable = drawable2;
        }
        if (open == null) {
            return null;
        }
        if (!str.endsWith(".9.png")) {
            drawable = Drawable.createFromStream(open, str);
            open.close();
            return drawable;
        }
        drawable2 = null;
        try {
            bitmap = BitmapFactory.decodeStream(open);
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            bitmap = null;
        }
        if (bitmap != null) {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            NinePatch.isNinePatchChunk(ninePatchChunk);
            return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams a(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 49;
        this.f.getDefaultDisplay().getWidth();
        this.f.getDefaultDisplay().getHeight();
        layoutParams.width = a(o);
        layoutParams.height = a(n);
        layoutParams.windowAnimations = 16973826;
        layoutParams.format = 1;
        layoutParams.flags |= 520;
        layoutParams.type = 2;
        this.d = layoutParams;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, k kVar) {
        if (i2 == 0) {
            this.i = kVar;
        } else if (i2 == 1) {
            this.j = kVar;
        } else {
            this.i = kVar;
            this.j = kVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        this.g.post(new Runnable() { // from class: com.tencent.open.TaskGuide.3
            @Override // java.lang.Runnable
            public void run() {
                Context context = TaskGuide.this.F;
                Toast.makeText(context, "失败：" + str, 1).show();
            }
        });
    }

    private void a(boolean z2) {
        this.I = SystemClock.currentThreadTimeMillis();
        if (z2) {
            this.G = true;
        } else {
            this.H = true;
        }
        this.J = this.d.height;
        this.K = this.d.y;
        this.d.flags |= 16;
        this.f.updateViewLayout(this.e, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup b(Context context) {
        e eVar = new e(context);
        g[] gVarArr = this.h.f38218c;
        if (gVarArr.length == 1) {
            i iVar = new i(context, gVarArr[0]);
            iVar.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(15);
            eVar.addView(iVar, layoutParams);
        } else {
            i iVar2 = new i(context, gVarArr[0]);
            iVar2.setId(1);
            i iVar3 = new i(context, gVarArr[1]);
            iVar3.setId(2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, a(6), 0, 0);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(14);
            layoutParams3.setMargins(0, a(4), 0, 0);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            eVar.addView(iVar2, layoutParams2);
            eVar.addView(iVar3, layoutParams3);
        }
        eVar.setBackgroundDrawable(e());
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i2) {
        Handler handler = this.g;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.open.TaskGuide.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TaskGuide.this.E) {
                        int i3 = i2;
                        if (i3 == 0) {
                            ((i) TaskGuide.this.e.findViewById(1)).a(TaskGuide.this.i);
                        } else if (i3 == 1) {
                            ((i) TaskGuide.this.e.findViewById(2)).a(TaskGuide.this.j);
                        } else if (i3 == 2) {
                            ((i) TaskGuide.this.e.findViewById(1)).a(TaskGuide.this.i);
                            if (TaskGuide.this.e.getChildCount() > 1) {
                                ((i) TaskGuide.this.e.findViewById(2)).a(TaskGuide.this.j);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k c(int i2) {
        return i2 == 0 ? this.i : i2 == 1 ? this.j : k.INIT;
    }

    private void c() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f.getDefaultDisplay().getMetrics(displayMetrics);
        this.A = displayMetrics.widthPixels;
        this.B = displayMetrics.heightPixels;
        this.C = displayMetrics.density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        WindowManager.LayoutParams layoutParams = this.d;
        if (layoutParams != null) {
            layoutParams.y = -layoutParams.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        h();
        b bVar = new b();
        this.N = bVar;
        this.g.postDelayed(bVar, i2);
    }

    private Drawable e() {
        if (k == null) {
            k = a("background.9.png", this.F);
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        Bundle composeCGIParams = composeCGIParams();
        composeCGIParams.putString("action", "get_gift");
        composeCGIParams.putString("task_id", this.h.f38217a);
        composeCGIParams.putString("step_no", new Integer(i2).toString());
        composeCGIParams.putString("appid", this.mToken.getAppId());
        HttpUtils.requestAsync(this.mToken, this.F, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", composeCGIParams, "GET", new d(i2));
        a(i2, k.WAITTING_BACK_REWARD);
        com.tencent.connect.a.a.a(this.F, this.mToken, "TaskApi", "getGift");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable f() {
        if (l == null) {
            l = a("button_green.9.png", this.F);
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable g() {
        if (m == null) {
            m = a("button_red.9.png", this.F);
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.g.removeCallbacks(this.N);
        if (j()) {
            return;
        }
        this.g.removeCallbacks(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.G) {
            d(3000);
        } else {
            removeWindow();
        }
        if (this.G) {
            this.d.flags &= -17;
            this.f.updateViewLayout(this.e, this.d);
        }
        this.G = false;
        this.H = false;
    }

    private boolean j() {
        return this.G || this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (j()) {
            return;
        }
        this.g.removeCallbacks(this.N);
        this.g.removeCallbacks(this.M);
        this.M = new c(true);
        a(true);
        this.g.post(this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (j()) {
            return;
        }
        this.g.removeCallbacks(this.N);
        this.g.removeCallbacks(this.M);
        this.M = new c(false);
        a(false);
        this.g.post(this.M);
    }

    public void removeWindow() {
        if (this.E) {
            this.f.removeView(this.e);
            this.E = false;
        }
    }

    public void showTaskGuideWindow(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Bundle composeCGIParams;
        this.F = activity;
        this.f38202c = iUiListener;
        if (this.i == k.WAITTING_BACK_TASKINFO || this.j == k.WAITTING_BACK_TASKINFO || this.E) {
            com.tencent.open.a.f.c("openSDK_LOG.TaskGuide", "showTaskGuideWindow, mState1 ==" + this.i + ", mState2" + this.j);
            return;
        }
        this.h = null;
        if (bundle != null) {
            composeCGIParams = new Bundle(bundle);
            composeCGIParams.putAll(composeCGIParams());
        } else {
            composeCGIParams = composeCGIParams();
        }
        j jVar = new j();
        composeCGIParams.putString("action", "task_list");
        composeCGIParams.putString(com.alipay.sdk.app.statistic.c.d, "mobile");
        composeCGIParams.putString("appid", this.mToken.getAppId());
        HttpUtils.requestAsync(this.mToken, this.F, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", composeCGIParams, "GET", jVar);
        a(2, k.WAITTING_BACK_TASKINFO);
    }

    public void showWindow() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TaskGuide.2
            @Override // java.lang.Runnable
            public void run() {
                TaskGuide taskGuide = TaskGuide.this;
                taskGuide.e = taskGuide.b(taskGuide.F);
                TaskGuide taskGuide2 = TaskGuide.this;
                taskGuide2.d = taskGuide2.a(taskGuide2.F);
                TaskGuide.this.d();
                WindowManager windowManager = (WindowManager) TaskGuide.this.F.getSystemService(Context.WINDOW_SERVICE);
                if (((Activity) TaskGuide.this.F).isFinishing()) {
                    return;
                }
                if (!TaskGuide.this.E) {
                    windowManager.addView(TaskGuide.this.e, TaskGuide.this.d);
                }
                TaskGuide.this.E = true;
                TaskGuide.this.b(2);
                TaskGuide.this.k();
            }
        });
        com.tencent.connect.a.a.a(this.F, this.mToken, "TaskApi", "showTaskWindow");
    }
}

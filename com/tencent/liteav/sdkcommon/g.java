package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/g.class */
public final class g {
    final Context b;

    /* renamed from: c  reason: collision with root package name */
    WindowManager f36436c;
    WindowManager.LayoutParams d;
    WindowManager.LayoutParams e;
    View f;
    View g;
    TextView h;
    TextView i;
    Spinner j;
    final ArrayAdapter<String> k;
    ScrollView l;
    String n;
    final a p;

    /* renamed from: a  reason: collision with root package name */
    final DisplayMetrics f36435a = new DisplayMetrics();
    boolean m = false;
    private final int q = 100;
    final Rect o = new Rect(0, 0, 0, 0);
    private final int r = -65536;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/g$a.class */
    public interface a {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/g$b.class */
    public final class b implements View.OnTouchListener {
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f36438c;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(g gVar, byte b) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.b = (int) motionEvent.getRawX();
                this.f36438c = (int) motionEvent.getRawY();
            } else if (action == 2) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int i = this.b;
                int i2 = this.f36438c;
                g.this.d.x += rawX - i;
                g.this.d.y += rawY - i2;
                this.b = rawX;
                this.f36438c = rawY;
                if (g.this.d.x < 0) {
                    g.this.d.x = 0;
                }
                if (g.this.d.y < 0) {
                    g.this.d.y = 0;
                }
                if (g.this.d.x + g.this.o.right > g.this.f36435a.widthPixels) {
                    g.this.d.width = g.this.f36435a.widthPixels - g.this.d.x;
                } else {
                    g.this.d.width = g.this.o.right;
                }
                if (g.this.d.y + 100 > g.this.f36435a.heightPixels) {
                    g.this.d.height = g.this.f36435a.heightPixels - g.this.d.y;
                } else {
                    g.this.d.height = 100;
                }
                g.this.f36436c.updateViewLayout(view, g.this.d);
                g.this.e.x = g.this.d.x;
                g.this.e.y = g.this.d.y + g.this.d.height;
                if (g.this.e.x + g.this.o.right > g.this.f36435a.widthPixels) {
                    g.this.e.width = g.this.f36435a.widthPixels - g.this.e.x;
                } else {
                    g.this.e.width = g.this.o.right;
                }
                if (g.this.e.y + g.this.o.bottom > g.this.f36435a.heightPixels) {
                    g.this.e.height = g.this.f36435a.heightPixels - g.this.e.y;
                } else {
                    g.this.e.height = g.this.o.bottom;
                }
                g.this.f36436c.updateViewLayout(g.this.g, g.this.e);
            }
            view.performClick();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/g$c.class */
    public final class c implements AdapterView.OnItemSelectedListener {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ c(g gVar, byte b) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            Tracker.onItemSelected(adapterView, view, i, j);
            if (view == null) {
                return;
            }
            ((TextView) view).setTextColor(-65536);
            g gVar = g.this;
            gVar.n = gVar.k.getItem(i);
            g.this.p.a(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public g(Context context, a aVar) {
        this.b = context;
        this.p = aVar;
        this.k = new ArrayAdapter<>(this.b, 17367048);
    }

    public final int a(int i) {
        return (int) ((i * this.b.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        TextView textView;
        Spinner spinner = this.j;
        if (spinner == null || (textView = (TextView) spinner.getChildAt(spinner.getSelectedItemPosition())) == null) {
            return;
        }
        textView.setTextColor(-65536);
    }

    public final void a(String str) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
        ScrollView scrollView = this.l;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }

    public final void b(String str) {
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(str);
        }
    }
}

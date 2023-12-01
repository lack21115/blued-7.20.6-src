package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.mapsdk.internal.fg;
import com.tencent.mapsdk.internal.p4;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eg.class */
public class eg extends n4 implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, fg.a {
    private static final String A = "VIEW_TAG_HEADER";
    private static final String B = "VIEW_TAG_FOOTER";
    private static final float C = 2.7f;
    private static final float D = 44.0f;
    private static final float E = 13.0f;
    private static final float F = 26.0f;
    private static final float G = 9.5f;
    private static final float H = 37.0f;
    private static final float I = 4.0f;
    private static final float J = 45.0f;
    private static final float K = 15.0f;
    private static final int L = -1;
    private static final int N = -1;
    private cg d;
    private fg e;
    private bg f;
    private d i;
    private Context j;
    private ViewGroup k;
    private IndoorBuilding n;
    private String o;
    private boolean p;
    private b0 s;
    private yi t;
    private int u;
    private int v;
    private boolean w;
    private ag x;
    private ag y;
    private static final int M = Color.parseColor("#333333");
    private static final int O = Color.parseColor("#979797");
    private float g = 1.0f;
    private int h = 0;
    private int l = -1;
    private int m = 0;
    public boolean q = false;
    private boolean r = false;
    private d.a z = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eg$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eg.this.d.getLayoutParams();
            marginLayoutParams.bottomMargin = eg.this.u;
            eg.this.d.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eg$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (eg.this.d == null || eg.this.d.getVisibility() != 0) {
                return;
            }
            eg.this.d.setVisibility(8);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eg$c.class */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (eg.this.d == null || eg.this.e == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = eg.this.e.getLayoutParams();
            if (layoutParams.height != eg.this.h) {
                layoutParams.height = eg.this.h;
                eg.this.e.setLayoutParams(layoutParams);
            }
            if (eg.this.d.getVisibility() != 0) {
                eg.this.d.setVisibility(0);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eg$d.class */
    public class d extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private Context f23723a;
        private List<IndoorLevel> b;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eg$d$a.class */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f23725a;
            public View b;

            public a(TextView textView, View view) {
                this.f23725a = textView;
                this.b = view;
            }
        }

        public d(Context context, List<IndoorLevel> list) {
            this.f23723a = context;
            this.b = list;
        }

        public void a(List<IndoorLevel> list) {
            this.b = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<IndoorLevel> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<IndoorLevel> list = this.b;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            TextView textView;
            View view3;
            List<IndoorLevel> list = this.b;
            if (list == null || list.size() == 0) {
                return null;
            }
            if (view != null) {
                a aVar = (a) view.getTag();
                textView = aVar.f23725a;
                view2 = aVar.b;
                view3 = view;
            } else {
                FrameLayout frameLayout = new FrameLayout(this.f23723a);
                view2 = new View(this.f23723a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (eg.this.g * 26.5d), (int) (eg.this.g * 26.5d));
                if (eg.this.f == null) {
                    eg.this.f = new bg();
                    eg.this.f.setBounds(0, 0, layoutParams.width, layoutParams.height);
                }
                if (Build.VERSION.SDK_INT < 16) {
                    view2.setBackgroundDrawable(eg.this.f);
                } else {
                    view2.setBackground(eg.this.f);
                }
                layoutParams.gravity = 17;
                frameLayout.addView(view2, layoutParams);
                textView = new TextView(this.f23723a);
                textView.setIncludeFontPadding(false);
                textView.setSingleLine();
                textView.setGravity(17);
                textView.setTextSize(2, eg.E);
                int i2 = (int) (eg.this.g * 10.0d);
                textView.setPadding(0, i2, 0, i2);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, (int) (eg.this.g * 37.5f));
                layoutParams2.gravity = 17;
                frameLayout.addView(textView, layoutParams2);
                frameLayout.setTag(new a(textView, view2));
                view3 = frameLayout;
            }
            textView.setText(this.b.get(i).getName());
            if (i != eg.this.l) {
                textView.setTextColor(eg.this.w ? eg.O : eg.M);
                view2.setVisibility(4);
                return view3;
            }
            boolean unused = eg.this.w;
            textView.setTextColor(-1);
            view2.setVisibility(0);
            return view3;
        }
    }

    public eg(e1 e1Var) {
        this.p = false;
        yi yiVar = (yi) e1Var.j();
        this.t = yiVar;
        this.k = yiVar.F();
        this.w = e1Var.a();
        this.j = this.k.getContext().getApplicationContext();
        this.p = true;
    }

    private int a(Adapter adapter) {
        int i = (int) (this.g * 44.5d);
        int count = adapter.getCount();
        View view = null;
        int i2 = 0;
        while (i2 < count) {
            view = adapter.getView(i2, view, this.e);
            view.measure(0, 0);
            int measuredWidth = view.getMeasuredWidth();
            int i3 = i;
            if (measuredWidth > i) {
                i3 = measuredWidth;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    private void a(Context context) {
        this.g = context.getApplicationContext().getResources().getDisplayMetrics().density;
    }

    private void a(Context context, d dVar) {
        this.e = new fg(context);
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.e.setChoiceMode(1);
        this.e.setAdapter((ListAdapter) dVar);
        this.e.setOnItemClickListener(this);
        this.e.setVerticalScrollBarEnabled(false);
        this.e.setHorizontalScrollBarEnabled(false);
        this.e.setOverScrollMode(2);
        this.e.setDivider(null);
        this.e.setDividerHeight(0);
        this.e.setOnDataChangedListener(this);
        this.d.addView(this.e);
        this.e.setOnScrollListener(this);
    }

    private void a(List<IndoorLevel> list) {
        if (this.k == null) {
            return;
        }
        l();
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(list);
        }
    }

    private void b(Context context) {
        ag agVar = new ag(context);
        this.y = agVar;
        agVar.setDarkStyle(this.w);
        this.y.setTag(B);
        this.y.setRotation(180.0f);
        int i = (int) (this.g * 5.900000095367432d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, (int) (this.g * 3.200000047683716d));
        layoutParams.setMargins(0, i, 0, i);
        this.y.setLayoutParams(layoutParams);
        this.d.addView(this.y);
    }

    private void b(Context context, d dVar) {
        d(context);
        c(context);
        a(context, dVar);
        b(context);
        a(this.k, (Bundle) null);
        this.d.setVisibility(8);
    }

    private void c(Context context) {
        ag agVar = new ag(context);
        this.x = agVar;
        agVar.setDarkStyle(this.w);
        this.x.setTag(A);
        int i = (int) (this.g * 5.900000095367432d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, (int) (this.g * 3.200000047683716d));
        layoutParams.setMargins(0, i, 0, i);
        this.x.setLayoutParams(layoutParams);
        this.d.addView(this.x);
    }

    private void d(Context context) {
        this.d = new cg(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 83;
        layoutParams.leftMargin = (int) (this.g * K);
        layoutParams.bottomMargin = this.u;
        this.d.setDarkStyle(this.w);
        this.d.setLayoutParams(layoutParams);
        this.d.setWillNotDraw(false);
        this.d.setOrientation(1);
        this.d.setGravity(1);
        this.d.setVisibility(8);
    }

    private void g() {
        if (this.d == null) {
            this.i = new d(this.j, new ArrayList());
            a(this.j);
            this.u = (int) (this.g * J);
            b(this.j, this.i);
            yi yiVar = this.t;
            if (yiVar != null) {
                this.s = yiVar.i();
            }
        }
    }

    private void i() {
        fg fgVar = this.e;
        if (fgVar != null) {
            fgVar.getLayoutParams().width = a(this.i);
            this.e.requestLayout();
        }
    }

    private void j() {
        float f;
        if (this.k == null || this.d == null) {
            return;
        }
        int i = (this.u * 2) + ((int) (this.g * 16.700000762939453d));
        int i2 = i;
        if (mi.f23959c.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
            i2 = i;
            if (this.k.getMeasuredHeight() > this.v) {
                int measuredHeight = this.k.getMeasuredHeight();
                int i3 = this.v;
                int i4 = this.u;
                i2 = ((int) (this.g * 16.700000762939453d)) + i4 + ((measuredHeight - i3) - i4);
            }
        }
        if (this.m >= 4.0f) {
            this.h = (int) (this.g * 148.5d);
            if (this.k.getMeasuredHeight() > this.h + i2) {
                this.r = false;
                return;
            }
            this.h = (int) (this.g * 111.5d);
            if (this.k.getMeasuredHeight() > i2 + this.h) {
                this.r = false;
                return;
            }
        } else {
            this.h = (int) (((f * H) + 0.5d) * this.g);
            if (this.k.getMeasuredHeight() > i2 + this.h) {
                this.r = false;
                return;
            }
        }
        this.r = true;
    }

    private void k() {
        boolean a2 = this.t.A().a();
        na.a(ma.f, "updateIndoorStyle isDark: cur[" + a2 + "]|old[" + this.w + "]");
        if (a2 != this.w) {
            this.d.setDarkStyle(a2);
            this.x.setDarkStyle(a2);
            this.y.setDarkStyle(a2);
            this.i.notifyDataSetChanged();
            this.w = a2;
        }
    }

    private void l() {
        j();
        cg cgVar = this.d;
        if (cgVar == null || this.e == null) {
            return;
        }
        if (!this.p || this.r || this.m < 1) {
            cgVar.post(new b());
        } else {
            cgVar.post(new c());
        }
    }

    private void m() {
        IndoorBuilding indoorBuilding = this.n;
        if (indoorBuilding == null) {
            return;
        }
        int activeLevelIndex = indoorBuilding.getActiveLevelIndex();
        List<IndoorLevel> levels = this.n.getLevels();
        if (levels == null || activeLevelIndex >= levels.size() || activeLevelIndex == -1 || levels.get(activeLevelIndex) == null) {
            return;
        }
        String str = this.o;
        if (str != null && this.q && str.equals(this.n.getBuidlingId())) {
            this.e.setItemChecked(activeLevelIndex, true);
            this.q = false;
        } else {
            this.e.setSelectionFromTop(activeLevelIndex, ((int) ((this.g * H) + 0.5d)) * 2);
        }
        this.l = activeLevelIndex;
        this.o = this.n.getBuidlingId();
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a() {
    }

    public void a(int i) {
        this.u = i;
        cg cgVar = this.d;
        if (cgVar != null) {
            cgVar.post(new a());
        }
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            this.v = viewGroup.getMeasuredHeight();
        }
        yi yiVar = this.t;
        if (yiVar == null || yiVar.getMap() == null || this.t.getMap().M() == null || this.t.getMap().M().b() == null) {
            return;
        }
        this.v = (((int) this.t.getMap().M().b().f23992c) - i) * 2;
        l();
    }

    @Override // com.tencent.mapsdk.internal.i5
    public void a(int i, int i2) {
        if (this.d == null || this.e == null) {
            return;
        }
        l();
    }

    @Override // com.tencent.mapsdk.internal.p4
    public void a(p4.b bVar) {
    }

    public void a(IndoorBuilding indoorBuilding) {
        if (indoorBuilding == null) {
            this.n = indoorBuilding;
            this.m = 0;
            l();
            return;
        }
        if (this.d == null) {
            g();
        }
        IndoorBuilding indoorBuilding2 = this.n;
        if (indoorBuilding2 != null && indoorBuilding2.getBuidlingId().equals(indoorBuilding.getBuidlingId()) && this.n.getActiveLevelIndex() == indoorBuilding.getActiveLevelIndex()) {
            return;
        }
        this.n = indoorBuilding;
        this.m = indoorBuilding.getLevels().size();
        a(indoorBuilding.getLevels());
    }

    public void a(boolean z) {
        if (this.k == null || this.t == null) {
            return;
        }
        if (z) {
            this.p = true;
        } else {
            this.p = false;
        }
        b(this.p);
    }

    @Override // com.tencent.mapsdk.internal.p4
    public boolean a(ViewGroup viewGroup, Bundle bundle) {
        cg cgVar = this.d;
        if (cgVar == null) {
            return false;
        }
        if (viewGroup.indexOfChild(cgVar) < 0) {
            viewGroup.addView(this.d);
        }
        k();
        i();
        return true;
    }

    @Override // com.tencent.mapsdk.internal.fg.a
    public void b() {
        i();
        m();
    }

    public void b(boolean z) {
        b0 b0Var;
        if (this.k == null || this.t == null) {
            return;
        }
        if (this.d == null) {
            if (!z) {
                return;
            }
            g();
        }
        VectorMap map = this.t.getMap();
        if (this.p && z && (b0Var = this.s) != null && b0Var.l()) {
            a(map.L().c());
            return;
        }
        a((IndoorBuilding) null);
        if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    @Override // com.tencent.mapsdk.internal.n4
    public View[] c() {
        return new View[]{this.d};
    }

    @Override // com.tencent.mapsdk.internal.p4
    public p4.b getPosition() {
        return null;
    }

    public boolean h() {
        return this.p;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        VectorMap map = this.t.getMap();
        if (map == null) {
            return;
        }
        d.a aVar = this.z;
        if (aVar != null) {
            aVar.f23725a.setTextColor(-16777216);
            this.z.b.setVisibility(4);
        }
        d.a aVar2 = (d.a) view.getTag();
        aVar2.f23725a.setTextColor(-1);
        aVar2.b.setVisibility(0);
        this.z = aVar2;
        this.l = i;
        this.q = true;
        map.setIndoorFloor(i);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        cg cgVar = this.d;
        if (cgVar == null) {
            return;
        }
        ag agVar = (ag) cgVar.findViewWithTag(A);
        ag agVar2 = (ag) this.d.findViewWithTag(B);
        if (agVar == null || agVar2 == null) {
            return;
        }
        if (i2 == i3) {
            agVar.setActivate(false);
            agVar2.setActivate(false);
            return;
        }
        if (i == 0) {
            agVar.setActivate(false);
        } else {
            agVar.setActivate(true);
        }
        if (i + i2 < i3) {
            agVar2.setActivate(true);
        } else {
            agVar2.setActivate(false);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}

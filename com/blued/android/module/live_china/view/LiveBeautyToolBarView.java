package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveBeautyToolBarView.class */
public class LiveBeautyToolBarView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f14386a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f14387c;
    private FrameLayout d;
    private TextView e;
    private View f;
    private ImageView g;
    private FrameLayout h;
    private TextView i;
    private View j;
    private ImageView k;
    private FrameLayout l;
    private TextView m;
    private View n;
    private ImageView o;
    private FrameLayout p;
    private TextView q;
    private View r;
    private ImageView s;
    private OnToolBarItemClickListener t;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveBeautyToolBarView$OnToolBarItemClickListener.class */
    public interface OnToolBarItemClickListener {
        void a(int i);
    }

    public LiveBeautyToolBarView(Context context) {
        this(context, null);
    }

    public LiveBeautyToolBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveBeautyToolBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14386a = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        from.inflate(R.layout.live_beauty_tool_bar_view, this);
        this.f14387c = (LinearLayout) findViewById(R.id.root_view);
        this.d = (FrameLayout) findViewById(R.id.layout1);
        this.e = (TextView) findViewById(R.id.text1);
        this.f = findViewById(R.id.view1);
        this.g = (ImageView) findViewById(R.id.point1);
        this.h = (FrameLayout) findViewById(R.id.layout2);
        this.i = (TextView) findViewById(R.id.text2);
        this.j = findViewById(R.id.view2);
        this.k = (ImageView) findViewById(R.id.point2);
        this.l = (FrameLayout) findViewById(R.id.layout3);
        this.m = (TextView) findViewById(R.id.text3);
        this.n = findViewById(R.id.view3);
        this.o = (ImageView) findViewById(R.id.point3);
        this.p = (FrameLayout) findViewById(R.id.layout4);
        this.q = (TextView) findViewById(R.id.text4);
        this.r = findViewById(R.id.view4);
        this.s = (ImageView) findViewById(R.id.point4);
        setToolBtnSelect(0);
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.p.setOnClickListener(this);
        a();
    }

    public void a() {
        String[] stringArray = this.f14386a.getResources().getStringArray(R.array.live_beauty_title);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                return;
            }
            if (i2 == 0) {
                this.e.setText(stringArray[0]);
            } else if (i2 == 1) {
                this.i.setText(stringArray[1]);
            } else if (i2 == 2) {
                this.m.setText(stringArray[2]);
            } else if (i2 == 3) {
                this.q.setText(stringArray[3]);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if ((view.getId() == R.id.layout1 || view.getId() == R.id.layout2 || view.getId() == R.id.layout3 || view.getId() == R.id.layout4) && this.t != null) {
            int i = 0;
            if (view.getId() != R.id.layout1) {
                if (view.getId() == R.id.layout2) {
                    i = 1;
                } else if (view.getId() == R.id.layout3) {
                    i = 2;
                } else if (view.getId() == R.id.layout4) {
                    i = 3;
                }
            }
            this.t.a(i);
        }
    }

    public void setOnToolBarItemClickListener(OnToolBarItemClickListener onToolBarItemClickListener) {
        this.t = onToolBarItemClickListener;
    }

    public void setToolBtnSelect(int i) {
        Log.v("pk", "setToolBtnSelect:" + i);
        if (i == 0) {
            this.e.setTextColor(this.f14386a.getResources().getColor(R.color.syc_a));
            this.f.setVisibility(0);
            this.i.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.j.setVisibility(8);
            this.m.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.n.setVisibility(8);
            this.q.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.r.setVisibility(8);
        } else if (i == 1) {
            this.e.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.f.setVisibility(8);
            this.i.setTextColor(this.f14386a.getResources().getColor(R.color.syc_a));
            this.j.setVisibility(0);
            this.m.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.n.setVisibility(8);
            this.q.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.r.setVisibility(8);
        } else if (i == 2) {
            this.e.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.f.setVisibility(8);
            this.i.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.j.setVisibility(8);
            this.m.setTextColor(this.f14386a.getResources().getColor(R.color.syc_a));
            this.n.setVisibility(0);
            this.q.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.r.setVisibility(8);
        } else if (i == 3) {
            this.e.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.f.setVisibility(8);
            this.i.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.j.setVisibility(8);
            this.m.setTextColor(this.f14386a.getResources().getColor(R.color.syc_h));
            this.n.setVisibility(8);
            this.q.setTextColor(this.f14386a.getResources().getColor(R.color.syc_a));
            this.r.setVisibility(0);
        }
    }
}

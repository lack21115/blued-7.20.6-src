package com.soft.blued.ui.setting.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/UserLabelToolBarView.class */
public class UserLabelToolBarView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f33267a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f33268c;
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

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/UserLabelToolBarView$OnToolBarItemClickListener.class */
    public interface OnToolBarItemClickListener {
        void a(int i);
    }

    public UserLabelToolBarView(Context context) {
        this(context, null);
    }

    public UserLabelToolBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserLabelToolBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33267a = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        from.inflate(R.layout.user_label_tool_bar_view, this);
        this.f33268c = (LinearLayout) findViewById(2131369470);
        this.d = (FrameLayout) findViewById(2131366743);
        this.e = (TextView) findViewById(2131370607);
        this.f = findViewById(2131373095);
        this.g = (ImageView) findViewById(2131368911);
        this.h = (FrameLayout) findViewById(2131366744);
        this.i = (TextView) findViewById(2131370608);
        this.j = findViewById(2131373096);
        this.k = (ImageView) findViewById(2131368912);
        this.l = (FrameLayout) findViewById(2131366745);
        this.m = (TextView) findViewById(2131370609);
        this.n = findViewById(2131373097);
        this.o = (ImageView) findViewById(2131368913);
        this.p = (FrameLayout) findViewById(2131366746);
        this.q = (TextView) findViewById(2131370610);
        this.r = findViewById(2131373098);
        this.s = (ImageView) findViewById(2131368914);
        setToolBtnSelect(0);
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.p.setOnClickListener(this);
        a();
    }

    private int a(int i) {
        return BluedSkinUtils.a(this.f33267a, i);
    }

    public void a() {
        String[] stringArray = this.f33267a.getResources().getStringArray(R.array.user_label_title);
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
        switch (view.getId()) {
            case 2131366743:
            case 2131366744:
            case 2131366745:
            case 2131366746:
                if (this.t != null) {
                    int i = 0;
                    if (view.getId() != 2131366743) {
                        if (view.getId() == 2131366744) {
                            i = 1;
                        } else if (view.getId() == 2131366745) {
                            i = 2;
                        } else if (view.getId() == 2131366746) {
                            i = 3;
                        }
                    }
                    this.t.a(i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setOnToolBarItemClickListener(OnToolBarItemClickListener onToolBarItemClickListener) {
        this.t = onToolBarItemClickListener;
    }

    public void setToolBtnSelect(int i) {
        Log.v("drb", "setToolBtnSelect:" + i);
        if (i == 0) {
            this.e.setTextColor(a(2131102254));
            this.f.setVisibility(0);
            this.i.setTextColor(a(2131102263));
            this.j.setVisibility(8);
            this.m.setTextColor(a(2131102263));
            this.n.setVisibility(8);
            this.q.setTextColor(a(2131102263));
            this.r.setVisibility(8);
        } else if (i == 1) {
            this.e.setTextColor(a(2131102263));
            this.f.setVisibility(8);
            this.i.setTextColor(a(2131102254));
            this.j.setVisibility(0);
            this.m.setTextColor(a(2131102263));
            this.n.setVisibility(8);
            this.q.setTextColor(a(2131102263));
            this.r.setVisibility(8);
        } else if (i == 2) {
            this.e.setTextColor(a(2131102263));
            this.f.setVisibility(8);
            this.i.setTextColor(a(2131102263));
            this.j.setVisibility(8);
            this.m.setTextColor(a(2131102254));
            this.n.setVisibility(0);
            this.q.setTextColor(a(2131102263));
            this.r.setVisibility(8);
        } else if (i == 3) {
            this.e.setTextColor(a(2131102263));
            this.f.setVisibility(8);
            this.i.setTextColor(a(2131102263));
            this.j.setVisibility(8);
            this.m.setTextColor(a(2131102263));
            this.n.setVisibility(8);
            this.q.setTextColor(a(2131102254));
            this.r.setVisibility(0);
        }
    }
}

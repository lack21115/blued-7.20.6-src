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

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/UserLikeToolBarView.class */
public class UserLikeToolBarView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19578a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f19579c;
    private FrameLayout d;
    private TextView e;
    private View f;
    private ImageView g;
    private FrameLayout h;
    private TextView i;
    private View j;
    private ImageView k;
    private OnToolBarItemClickListener l;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/View/UserLikeToolBarView$OnToolBarItemClickListener.class */
    public interface OnToolBarItemClickListener {
        void a(int i);
    }

    public UserLikeToolBarView(Context context) {
        this(context, null);
    }

    public UserLikeToolBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserLikeToolBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19578a = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        from.inflate(R.layout.user_like_tool_bar_view, this);
        this.f19579c = (LinearLayout) findViewById(2131369470);
        this.d = (FrameLayout) findViewById(R.id.layout1);
        this.e = (TextView) findViewById(2131370607);
        this.f = findViewById(2131373095);
        this.g = (ImageView) findViewById(R.id.point1);
        this.h = (FrameLayout) findViewById(R.id.layout2);
        this.i = (TextView) findViewById(2131370608);
        this.j = findViewById(R.id.view2);
        this.k = (ImageView) findViewById(R.id.point2);
        setToolBtnSelect(0);
        this.d.setOnClickListener(this);
        this.h.setOnClickListener(this);
        a();
    }

    private int a(int i) {
        return BluedSkinUtils.a(this.f19578a, i);
    }

    public void a() {
        String[] stringArray = this.f19578a.getResources().getStringArray(R.array.user_like_title);
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
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.layout1 /* 2131366743 */:
            case R.id.layout2 /* 2131366744 */:
                if (this.l != null) {
                    int i = 0;
                    if (view.getId() != 2131366743 && view.getId() == 2131366744) {
                        i = 1;
                    }
                    this.l.a(i);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setOnToolBarItemClickListener(OnToolBarItemClickListener onToolBarItemClickListener) {
        this.l = onToolBarItemClickListener;
    }

    public void setToolBtnSelect(int i) {
        Log.v("drb", "setToolBtnSelect:" + i);
        if (i == 0) {
            this.e.setTextColor(a(2131102254));
            this.f.setVisibility(0);
            this.i.setTextColor(a(2131102263));
            this.j.setVisibility(8);
        } else if (i == 1) {
            this.e.setTextColor(a(2131102263));
            this.f.setVisibility(8);
            this.i.setTextColor(a(2131102254));
            this.j.setVisibility(0);
        } else if (i == 2) {
            this.e.setTextColor(a(2131102263));
            this.f.setVisibility(8);
            this.i.setTextColor(a(2131102263));
            this.j.setVisibility(8);
        } else if (i == 3) {
            this.e.setTextColor(a(2131102263));
            this.f.setVisibility(8);
            this.i.setTextColor(a(2131102263));
            this.j.setVisibility(8);
        }
    }
}

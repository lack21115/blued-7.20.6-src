package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecordLevelToolBarView.class */
public class LiveRecordLevelToolBarView extends FrameLayout implements View.OnClickListener {
    private Context a;
    private LayoutInflater b;
    private LinearLayout c;
    private FrameLayout d;
    private TextView e;
    private View f;
    private FrameLayout g;
    private TextView h;
    private View i;
    private OnToolBarItemClickListener j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecordLevelToolBarView$OnToolBarItemClickListener.class */
    public interface OnToolBarItemClickListener {
        void a(int i);
    }

    public LiveRecordLevelToolBarView(Context context) {
        this(context, null);
    }

    public LiveRecordLevelToolBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveRecordLevelToolBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        from.inflate(R.layout.live_record_level_tool_bar_view, this);
        this.c = (LinearLayout) findViewById(R.id.root_view);
        this.d = (FrameLayout) findViewById(R.id.layout1);
        this.e = (TextView) findViewById(R.id.text1);
        this.f = findViewById(R.id.view1);
        this.g = (FrameLayout) findViewById(R.id.layout2);
        this.h = (TextView) findViewById(R.id.text2);
        this.i = findViewById(R.id.view2);
        setToolBtnSelect(0);
        this.d.setOnClickListener(this);
        this.g.setOnClickListener(this);
    }

    public void a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            if (i2 == 0) {
                this.e.setText(strArr[0]);
            } else if (i2 == 1) {
                this.h.setText(strArr[1]);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if ((view.getId() == R.id.layout1 || view.getId() == R.id.layout2) && this.j != null) {
            int i = 0;
            if (view.getId() != R.id.layout1 && view.getId() == R.id.layout2) {
                i = 1;
            }
            this.j.a(i);
        }
    }

    public void setOnToolBarItemClickListener(OnToolBarItemClickListener onToolBarItemClickListener) {
        this.j = onToolBarItemClickListener;
    }

    public void setToolBtnSelect(int i) {
        Log.v("pk", "setToolBtnSelect:" + i);
        if (i == 0) {
            this.e.setTextColor(this.a.getResources().getColor(R.color.syc_h));
            this.f.setVisibility(0);
            this.h.setTextColor(this.a.getResources().getColor(R.color.syc_k));
            this.i.setVisibility(8);
        } else if (i == 1) {
            this.e.setTextColor(this.a.getResources().getColor(R.color.syc_k));
            this.f.setVisibility(8);
            this.h.setTextColor(this.a.getResources().getColor(R.color.syc_h));
            this.i.setVisibility(0);
        }
    }
}

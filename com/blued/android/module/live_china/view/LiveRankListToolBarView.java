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
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRankListToolBarView.class */
public class LiveRankListToolBarView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f14892a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f14893c;
    private FrameLayout d;
    private TextView e;
    private View f;
    private FrameLayout g;
    private TextView h;
    private View i;
    private OnToolBarItemClickListener j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRankListToolBarView$OnToolBarItemClickListener.class */
    public interface OnToolBarItemClickListener {
        void a(int i);
    }

    public LiveRankListToolBarView(Context context) {
        this(context, null);
    }

    public LiveRankListToolBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveRankListToolBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14892a = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        from.inflate(R.layout.live_rank_list_tool_bar_view, this);
        this.f14893c = (LinearLayout) findViewById(R.id.root_view);
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

    public void a() {
        if (LiveRoomManager.a().p().isShowHourRank) {
            this.e.setText(this.f14892a.getString(R.string.live_ranking_hour));
        } else {
            this.d.setVisibility(8);
            setToolBtnSelect(1);
        }
        if (LiveRoomManager.a().Q()) {
            this.h.setText(this.f14892a.getString(R.string.live_ranking_hit_list));
            return;
        }
        this.g.setVisibility(8);
        setToolBtnSelect(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if ((view.getId() == R.id.layout1 || view.getId() == R.id.layout2 || view.getId() == R.id.layout3 || view.getId() == R.id.layout4) && this.j != null) {
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
            this.j.a(i);
        }
    }

    public void setOnToolBarItemClickListener(OnToolBarItemClickListener onToolBarItemClickListener) {
        this.j = onToolBarItemClickListener;
    }

    public void setToolBtnSelect(int i) {
        Log.v("pk", "setToolBtnSelect:" + i);
        if (i == 0) {
            this.e.setTextColor(this.f14892a.getResources().getColor(R.color.syc_dark_0a0a0a));
            this.f.setVisibility(0);
            this.h.setTextColor(this.f14892a.getResources().getColor(R.color.syc_dark_767676));
            this.i.setVisibility(8);
        } else if (i == 1) {
            this.h.setTextColor(this.f14892a.getResources().getColor(R.color.syc_dark_0a0a0a));
            this.i.setVisibility(0);
            this.e.setTextColor(this.f14892a.getResources().getColor(R.color.syc_dark_767676));
            this.f.setVisibility(8);
        }
    }
}

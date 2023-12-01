package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverManageGuestView.class */
public class LiveMakeLoverManageGuestView extends FrameLayout implements View.OnClickListener {
    LiveMakeLoverOnClickListener a;
    private Context b;
    private LayoutInflater c;
    private View d;
    private View e;
    private View f;
    private PlayingOnliveFragment g;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverManageGuestView$LiveMakeLoverOnClickListener.class */
    public interface LiveMakeLoverOnClickListener {
        void a();
    }

    public LiveMakeLoverManageGuestView(Context context) {
        this(context, null);
    }

    public LiveMakeLoverManageGuestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeLoverManageGuestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        View inflate = from.inflate(R.layout.live_make_lover_manage_guest, this);
        this.d = inflate;
        this.e = inflate.findViewById(R.id.ll_make_lover_guest);
        View findViewById = this.d.findViewById(R.id.live_make_lover_wait_layout);
        this.f = findViewById;
        findViewById.setOnClickListener(this);
    }

    public void a(PlayingOnliveFragment playingOnliveFragment, LiveMakeLoverOnClickListener liveMakeLoverOnClickListener) {
        this.a = liveMakeLoverOnClickListener;
        this.g = playingOnliveFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_make_lover_wait_layout) {
            if (!LivePreferencesUtils.c()) {
                LivePreferencesUtils.a(true);
            }
            LiveMakeLoverOnClickListener liveMakeLoverOnClickListener = this.a;
            if (liveMakeLoverOnClickListener != null) {
                liveMakeLoverOnClickListener.a();
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.f.performClick();
    }
}

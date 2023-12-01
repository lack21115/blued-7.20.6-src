package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverManagerRecordView.class */
public class LiveMakeLoverManagerRecordView extends FrameLayout implements View.OnClickListener {
    public int a;
    public boolean b;
    private Context c;
    private LayoutInflater d;
    private View e;
    private LinearLayout f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private LiveMakeLoverOnClickListener j;
    private PlayingOnliveFragment k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverManagerRecordView$LiveMakeLoverOnClickListener.class */
    public interface LiveMakeLoverOnClickListener {
        void a();
    }

    public LiveMakeLoverManagerRecordView(Context context) {
        this(context, null);
    }

    public LiveMakeLoverManagerRecordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeLoverManagerRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.c = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = from;
        View inflate = from.inflate(R.layout.live_make_lover_manage_record, this);
        this.e = inflate;
        this.f = (LinearLayout) inflate.findViewById(R.id.live_make_lover_wait_layout);
        this.g = (TextView) this.e.findViewById(R.id.live_make_lover_wait_num);
        this.i = (TextView) this.e.findViewById(R.id.live_make_lover_wait_text);
        this.h = (ImageView) this.e.findViewById(R.id.live_make_lover_manage_head);
        a(0);
        this.f.setOnClickListener(this);
    }

    public void a(int i) {
        TextView textView = this.g;
        String string = this.c.getString(R.string.live_make_friend_wait);
        textView.setText(String.format(string, i + ""));
    }

    public void a(boolean z, LiveMakeLoverOnClickListener liveMakeLoverOnClickListener) {
        a(z, liveMakeLoverOnClickListener, null);
    }

    public void a(boolean z, LiveMakeLoverOnClickListener liveMakeLoverOnClickListener, PlayingOnliveFragment playingOnliveFragment) {
        this.j = liveMakeLoverOnClickListener;
        this.k = playingOnliveFragment;
        if (z) {
            this.a = 0;
        } else {
            this.a = 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveMakeLoverOnClickListener liveMakeLoverOnClickListener;
        Tracker.onClick(view);
        if (view.getId() != R.id.live_make_lover_wait_layout || (liveMakeLoverOnClickListener = this.j) == null) {
            return;
        }
        liveMakeLoverOnClickListener.a();
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.f.performClick();
    }
}

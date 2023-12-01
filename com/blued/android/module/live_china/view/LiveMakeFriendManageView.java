package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendManageView.class */
public class LiveMakeFriendManageView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f14525a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14526c;
    private Context d;
    private LayoutInflater e;
    private View f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private LiveManageOnClickListener j;
    private PlayingOnliveFragment k;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeFriendManageView$LiveManageOnClickListener.class */
    public interface LiveManageOnClickListener {
        void a();
    }

    public LiveMakeFriendManageView(Context context) {
        this(context, null);
    }

    public LiveMakeFriendManageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeFriendManageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14526c = false;
        this.d = context;
        c();
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.d);
        this.e = from;
        View inflate = from.inflate(R.layout.live_make_friend_manage, (ViewGroup) this, true);
        this.f = inflate;
        this.f14525a = (LinearLayout) inflate.findViewById(R.id.live_make_friend_wait_layout);
        this.g = (TextView) this.f.findViewById(R.id.live_make_friend_wait_num);
        this.i = (TextView) this.f.findViewById(R.id.live_make_friend_wait_text);
        this.h = (ImageView) this.f.findViewById(R.id.live_make_friend_manage_head);
        this.f14525a.setOnClickListener(this);
    }

    public void a(int i) {
        this.b = i;
        if (i == 0) {
            this.h.setImageResource(R.drawable.live_make_friend_manage_icon);
            this.g.setVisibility(0);
            this.i.setText(R.string.live_make_friend_manage);
        } else if (i == 1) {
            this.h.setImageResource(R.drawable.live_make_friend_manage_icon);
            this.g.setVisibility(8);
            this.i.setText(R.string.live_make_friend_apply);
            this.k.aU.a(true);
        } else if (i == 2) {
            this.h.setImageResource(R.drawable.live_make_friend_user_wait_icon);
            this.g.setVisibility(8);
            this.i.setText(R.string.live_make_friend_waiting);
            this.k.aU.a(false);
        } else if (i != 3) {
        } else {
            this.h.setImageResource(R.drawable.live_make_friend_user_set_icon);
            this.g.setVisibility(8);
            this.i.setText(R.string.live_make_friend_setting);
        }
    }

    public void a(boolean z, LiveManageOnClickListener liveManageOnClickListener) {
        a(z, liveManageOnClickListener, null);
    }

    public void a(boolean z, LiveManageOnClickListener liveManageOnClickListener, PlayingOnliveFragment playingOnliveFragment) {
        this.j = liveManageOnClickListener;
        this.k = playingOnliveFragment;
        if (z) {
            this.b = 0;
            this.h.setImageResource(R.drawable.live_make_friend_manage_icon);
            return;
        }
        this.b = 1;
        this.h.setImageResource(R.drawable.live_make_friend_manage_icon);
    }

    public boolean a() {
        return this.b == 2;
    }

    public void b() {
        this.f14526c = false;
        if (this.f14525a.getVisibility() == 8) {
            return;
        }
        setVisibility(8);
        this.f14525a.setVisibility(8);
        this.f14525a.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
    }

    public void b(int i) {
        TextView textView = this.g;
        String string = this.d.getString(R.string.live_make_friend_wait);
        textView.setText(String.format(string, i + ""));
    }

    public void c(int i) {
        this.f14526c = true;
        setVisibility(0);
        this.f14525a.clearAnimation();
        this.f14525a.setVisibility(0);
        this.f14525a.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
        TextView textView = this.g;
        String string = this.d.getString(R.string.live_make_friend_wait);
        textView.setText(String.format(string, i + ""));
        a(this.b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LiveManageOnClickListener liveManageOnClickListener;
        Tracker.onClick(view);
        if (view.getId() != R.id.live_make_friend_wait_layout || (liveManageOnClickListener = this.j) == null) {
            return;
        }
        liveManageOnClickListener.a();
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.f14525a.performClick();
    }
}

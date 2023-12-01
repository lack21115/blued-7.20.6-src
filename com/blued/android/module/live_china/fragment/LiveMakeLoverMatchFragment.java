package com.blued.android.module.live_china.fragment;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMakeLoverReleationModel;
import com.blued.android.module.live_china.presenter.LiveMakeLoverMatchPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverMatchFragment.class */
public class LiveMakeLoverMatchFragment extends MvpFragment<LiveMakeLoverMatchPresent> implements View.OnClickListener {
    View a;
    View b;
    View c;
    ImageView d;
    ImageView e;
    ImageView f;
    TextView g;
    private long l;
    private int m;
    private LiveMakeLoverFansModel n;
    private LiveMakeLoverFansModel o;
    private String p;
    private boolean r;
    private Dialog s;
    private String q = "";
    private int t = 0;
    Runnable k = new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverMatchFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (LiveMakeLoverMatchFragment.this.t < 5) {
                LiveMakeLoverMatchFragment.d(LiveMakeLoverMatchFragment.this);
                AppInfo.n().postDelayed(LiveMakeLoverMatchFragment.this.k, 1000L);
            } else if (LiveMakeLoverMatchFragment.this.b() != null) {
                LiveMakeLoverMatchFragment.this.b().dismiss();
            }
        }
    };

    private void c() {
        if (getArguments() != null) {
            this.l = getArguments().getLong("lid");
            this.m = getArguments().getInt("from");
            this.n = (LiveMakeLoverFansModel) getArguments().getSerializable("chosen");
            this.o = (LiveMakeLoverFansModel) getArguments().getSerializable("chooser");
            this.p = getArguments().getString("apngLocalUrl");
            if (TextUtils.equals(LiveRoomInfo.a().f(), this.n.uid) || TextUtils.equals(LiveRoomInfo.a().f(), this.o.uid)) {
                this.q = (TextUtils.equals(LiveRoomInfo.a().f(), this.n.uid) ? this.o : this.n).uid;
            }
        }
    }

    private void c(String str) {
        if ("1".equals(str) || "3".equals(str)) {
            this.g.setText(getString(R.string.live_make_lover_attentioned));
            this.r = true;
            return;
        }
        this.g.setText(getString(R.string.live_make_lover_attention));
        this.r = false;
    }

    static /* synthetic */ int d(LiveMakeLoverMatchFragment liveMakeLoverMatchFragment) {
        int i = liveMakeLoverMatchFragment.t;
        liveMakeLoverMatchFragment.t = i + 1;
        return i;
    }

    private void d() {
        this.a = this.i.findViewById(R.id.fl_make_lover_match);
        this.b = this.i.findViewById(R.id.fl_avatar_left);
        this.c = this.i.findViewById(R.id.fl_avatar_right);
        this.d = (ImageView) this.i.findViewById(R.id.iv_avatar_left);
        this.e = (ImageView) this.i.findViewById(R.id.iv_avatar_right);
        this.f = (ImageView) this.i.findViewById(R.id.iv_anim);
        this.g = (TextView) this.i.findViewById(R.id.tv_attention);
        this.s = DialogUtils.a(getContext());
        if (TextUtils.isEmpty(this.n.avatar) && !TextUtils.isEmpty(this.n.pic)) {
            LiveMakeLoverFansModel liveMakeLoverFansModel = this.n;
            liveMakeLoverFansModel.avatar = liveMakeLoverFansModel.pic;
        }
        if (TextUtils.isEmpty(this.o.avatar) && !TextUtils.isEmpty(this.o.pic)) {
            LiveMakeLoverFansModel liveMakeLoverFansModel2 = this.o;
            liveMakeLoverFansModel2.avatar = liveMakeLoverFansModel2.pic;
        }
        ImageLoader.a(getFragmentActive(), this.n.avatar).b(R.drawable.user_bg_round).c().a(this.d);
        ImageLoader.a(getFragmentActive(), this.o.avatar).b(R.drawable.user_bg_round).c().a(this.e);
        ImageLoader.d(getFragmentActive(), this.p).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverMatchFragment.1
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
            }
        }).a(this.f);
        final int i = AppInfo.l;
        final int a = DensityUtils.a(getContext(), 75.0f);
        int a2 = DensityUtils.a(getContext(), 20.0f);
        final int i2 = (i / 2) - (((a * 2) - a2) / 2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(0);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        final int i3 = (i - ((i2 + a) - a2)) - a;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverMatchFragment.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (LiveMakeLoverMatchFragment.this.b != null) {
                    LiveMakeLoverMatchFragment.this.b.setX(i2 * floatValue);
                }
                if (LiveMakeLoverMatchFragment.this.c != null) {
                    LiveMakeLoverMatchFragment.this.c.setX((i - (i3 * floatValue)) - a);
                }
            }
        });
        ofFloat.start();
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverMatchFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AppInfo.n().removeCallbacks(LiveMakeLoverMatchFragment.this.k);
                if (LiveMakeLoverMatchFragment.this.b() != null) {
                    LiveMakeLoverMatchFragment.this.b().dismiss();
                }
            }
        });
        if (TextUtils.isEmpty(this.q)) {
            AppInfo.n().post(this.k);
        } else {
            j().a(this.q, this.l, (short) 4);
        }
        EventTrackLive.d(this.m == 0 ? LiveProtos.Event.GUEST_MATCH_SUCCESS_POP_SHOW : LiveProtos.Event.ANCHOR_MATCH_SUCCESS_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.q);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        d();
    }

    public void a(LiveMakeLoverReleationModel liveMakeLoverReleationModel) {
        if (liveMakeLoverReleationModel != null) {
            c(liveMakeLoverReleationModel.relation);
            this.g.setVisibility(0);
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveMakeLoverMatchFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (!LiveMakeLoverMatchFragment.this.r) {
                        LiveMakeLoverMatchFragment.this.j().a(LiveRoomManager.a().e(), LiveMakeLoverMatchFragment.this.q);
                        return;
                    }
                    AppInfo.n().removeCallbacks(LiveMakeLoverMatchFragment.this.k);
                    if (LiveMakeLoverMatchFragment.this.b() != null) {
                        LiveMakeLoverMatchFragment.this.b().dismiss();
                    }
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        DialogUtils.b(this.s);
        if (str == "MAKE_LOVER_RELATION_ADD" && z) {
            AppInfo.n().removeCallbacks(this.k);
            if (b() != null) {
                b().dismiss();
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public LiveMakeLoverOkDialogFragment b() {
        if (getParentFragment() instanceof LiveMakeLoverOkDialogFragment) {
            return getParentFragment();
        }
        return null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_make_lover_match_success;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        DialogUtils.a(this.s);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        DialogUtils.b(this.s);
        AppInfo.n().removeCallbacks(this.k);
    }
}

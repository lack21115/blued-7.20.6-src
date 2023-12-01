package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.presenter.LiveMakeLoverOkPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMakeLoverOkFragment.class */
public class LiveMakeLoverOkFragment extends MvpFragment<LiveMakeLoverOkPresent> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    View f13045a;
    ImageView b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f13046c;
    View d;
    View e;
    TextView f;
    TextView g;
    private long k;
    private LiveMakeLoverFansModel l;
    private LiveMakeLoverFansModel m;

    private void c() {
        if (getArguments() != null) {
            this.k = getArguments().getLong("lid");
            this.l = (LiveMakeLoverFansModel) getArguments().getSerializable("chosen");
            this.m = (LiveMakeLoverFansModel) getArguments().getSerializable("chooser");
        }
    }

    private void d() {
        this.f13045a = this.i.findViewById(R.id.fl_make_lover_dialog);
        this.b = (ImageView) this.i.findViewById(R.id.iv_avatar_left);
        this.f13046c = (ImageView) this.i.findViewById(R.id.iv_avatar_right);
        this.d = this.i.findViewById(R.id.tv_make_lover_cancel);
        this.e = this.i.findViewById(R.id.tv_make_lover_confirm);
        this.f = (TextView) this.i.findViewById(R.id.iv_avatar_index_left);
        this.g = (TextView) this.i.findViewById(R.id.iv_avatar_index_right);
        this.f.setText(String.valueOf(this.l.index));
        this.g.setText(String.valueOf(this.m.index));
        if (TextUtils.isEmpty(this.l.avatar) && !TextUtils.isEmpty(this.l.pic)) {
            LiveMakeLoverFansModel liveMakeLoverFansModel = this.l;
            liveMakeLoverFansModel.avatar = liveMakeLoverFansModel.pic;
        }
        if (TextUtils.isEmpty(this.m.avatar) && !TextUtils.isEmpty(this.m.pic)) {
            LiveMakeLoverFansModel liveMakeLoverFansModel2 = this.m;
            liveMakeLoverFansModel2.avatar = liveMakeLoverFansModel2.pic;
        }
        ImageLoader.a(getFragmentActive(), this.l.avatar).b(R.drawable.user_bg_round).c().a(this.b);
        ImageLoader.a(getFragmentActive(), this.m.avatar).b(R.drawable.user_bg_round).c().a(this.f13046c);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == "MAKE_LOVER_OK" && z && b() != null) {
            b().dismiss();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public LiveMakeLoverOkDialogFragment b() {
        if (getParentFragment() instanceof LiveMakeLoverOkDialogFragment) {
            return (LiveMakeLoverOkDialogFragment) getParentFragment();
        }
        return null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_make_lover_ok;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.tv_make_lover_confirm) {
            EventTrackLive.b(LiveProtos.Event.ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK, String.valueOf(this.k));
            j().a(this.l.uid, this.m.uid);
        } else if (id != R.id.tv_make_lover_cancel || b() == null) {
        } else {
            b().dismiss();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}

package com.blued.android.module.yy_china.manager;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.live.base.utils.LiveAnimationMp4Utils;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.YYHostUpMode;
import com.blued.android.module.yy_china.model.YYMountModel;
import com.blued.android.module.yy_china.view.HostUpView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYHostUpAnimManager.class */
public final class YYHostUpAnimManager implements LiveAnimationListener {
    private final BaseYYStudioFragment a;
    private final LiveAnimationView b;
    private final ArrayList<YYMountModel> c;
    private final ArrayList<YYMountModel> d;
    private YYMountModel e;
    private YYMountModel f;
    private HostUpView g;
    private boolean h;

    public YYHostUpAnimManager(BaseYYStudioFragment fragment, LiveAnimationView mAniView) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(mAniView, "mAniView");
        this.a = fragment;
        this.b = mAniView;
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
    }

    private final void a(boolean z) {
        YYMountModel d = z ? d() : null;
        if (this.h) {
            return;
        }
        if (d != null) {
            this.h = true;
            this.e = this.f;
            this.f = d;
            this.b.setVisibility(0);
            c(d);
        } else if (this.f != null) {
        } else {
            YYMountModel e = e();
            if (e == null) {
                this.b.setVisibility(8);
                return;
            }
            this.e = this.f;
            this.f = e;
            this.b.setVisibility(0);
            b(e);
        }
    }

    private final void b(YYMountModel yYMountModel) {
        if (this.b == null) {
            return;
        }
        HostUpView hostUpView = new HostUpView(this.b.getContext());
        this.g = hostUpView;
        if (hostUpView != null) {
            hostUpView.setNum(yYMountModel.getUpHost());
        }
        HostUpView hostUpView2 = this.g;
        if (hostUpView2 != null) {
            hostUpView2.setAlpha(0.0f);
        }
        LiveAnimationView liveAnimationView = this.b;
        ActivityFragmentActive fragmentActive = this.a.getFragmentActive();
        YYHostUpMode upHost = yYMountModel.getUpHost();
        liveAnimationView.a(fragmentActive, "", "", upHost == null ? null : upHost.getMaterial(), "", LiveAnimationViewFactory.ScaleType.FIT_CENTER, this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.b.addView(this.g, layoutParams);
    }

    private final void c(YYMountModel yYMountModel) {
        LiveAnimationView liveAnimationView = this.b;
        if (liveAnimationView == null) {
            return;
        }
        if (liveAnimationView.getChildCount() > 0) {
            for (View view : ViewGroupKt.getChildren(this.b)) {
                LiveAnimationMp4Utils.a(view);
            }
        }
        this.b.removeAllViews();
        this.b.a(7);
        HostUpView hostUpView = new HostUpView(this.b.getContext());
        this.g = hostUpView;
        if (hostUpView != null) {
            hostUpView.setNum(yYMountModel.getUpHost());
        }
        HostUpView hostUpView2 = this.g;
        if (hostUpView2 != null) {
            hostUpView2.setAlpha(0.0f);
        }
        LiveAnimationView liveAnimationView2 = this.b;
        ActivityFragmentActive fragmentActive = this.a.getFragmentActive();
        YYHostUpMode upHost = yYMountModel.getUpHost();
        liveAnimationView2.a(fragmentActive, "", "", upHost == null ? null : upHost.getMaterial(), "", LiveAnimationViewFactory.ScaleType.FIT_CENTER, this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.b.addView(this.g, layoutParams);
    }

    private final YYMountModel d() {
        YYMountModel yYMountModel = this.f;
        if (yYMountModel != null) {
            return yYMountModel;
        }
        try {
            if (this.d.size() > 0) {
                return this.d.remove(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final YYMountModel e() {
        YYMountModel yYMountModel = this.f;
        if (yYMountModel != null) {
            return yYMountModel;
        }
        try {
            if (this.c.size() > 0) {
                return this.c.remove(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
    public void a() {
        LiveAnimationListener aniListener;
        YYMountModel yYMountModel = this.f;
        if (yYMountModel != null && (aniListener = yYMountModel.getAniListener()) != null) {
            aniListener.a();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.0f);
        ofFloat2.setDuration(200L);
        ofFloat2.setStartDelay(4000L);
        ofFloat2.start();
    }

    public final void a(YYMountModel model) {
        Intrinsics.e(model, "model");
        this.c.add(model);
        a(false);
    }

    @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
    public void b() {
        LiveAnimationListener aniListener;
        YYMountModel yYMountModel = this.f;
        if (yYMountModel != null && (aniListener = yYMountModel.getAniListener()) != null) {
            aniListener.b();
        }
        this.f = null;
        this.h = false;
        this.b.setOnClickListener(null);
        a(true);
    }

    public final void c() {
    }
}

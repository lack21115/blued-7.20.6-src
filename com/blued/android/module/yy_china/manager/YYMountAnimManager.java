package com.blued.android.module.yy_china.manager;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live.base.utils.LiveAnimationMp4Utils;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.YYMountModel;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYMountAnimManager.class */
public final class YYMountAnimManager implements LiveAnimationListener {
    private final BaseYYStudioFragment a;
    private final LiveAnimationView b;
    private final TextView c;
    private final ArrayList<YYMountModel> d;
    private final ArrayList<YYMountModel> e;
    private YYMountModel f;
    private YYMountModel g;
    private boolean h;

    public YYMountAnimManager(BaseYYStudioFragment fragment, LiveAnimationView mAniView, TextView mMount) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(mAniView, "mAniView");
        Intrinsics.e(mMount, "mMount");
        this.a = fragment;
        this.b = mAniView;
        this.c = mMount;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View.OnClickListener onClickListener, View view) {
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMountAnimManager this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b.setEnabled(true);
    }

    private final void a(boolean z) {
        YYMountModel i = z ? i() : null;
        if (this.h) {
            return;
        }
        if (i != null) {
            this.h = true;
            this.f = this.g;
            this.g = i;
            this.b.setVisibility(0);
            c(i);
        } else if (this.g != null) {
        } else {
            YYMountModel j = j();
            if (j == null) {
                this.b.setVisibility(8);
                return;
            }
            this.f = this.g;
            this.g = j;
            this.b.setVisibility(0);
            b(j);
        }
    }

    private final YYMountModel i() {
        YYMountModel yYMountModel = this.g;
        if (yYMountModel != null) {
            return yYMountModel;
        }
        try {
            if (this.e.size() > 0) {
                return this.e.remove(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final YYMountModel j() {
        YYMountModel yYMountModel = this.g;
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

    @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.start();
        YYMountModel yYMountModel = this.g;
        if (yYMountModel == null || StringUtils.b(yYMountModel.getMounts_icon())) {
            return;
        }
        ActivityFragmentActive fragmentActive = c().getFragmentActive();
        YYMountModel f = f();
        String mounts_icon = f == null ? null : f.getMounts_icon();
        Intrinsics.a((Object) mounts_icon);
        ImageLoader.a(fragmentActive, mounts_icon).a((Target) new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.manager.YYMountAnimManager$onAnimationStart$1$1
            /* renamed from: a */
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                Intrinsics.e(resource, "resource");
                YYMountAnimManager.this.d().setBackgroundDrawable(resource);
            }
        });
    }

    public final void a(final View.OnClickListener onClickListener) {
        this.b.setEnabled(false);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYMountAnimManager$mWYyWmyqjVISf9QFE9AcZPOlyNg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMountAnimManager.a(View.OnClickListener.this, view);
            }
        });
        this.b.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYMountAnimManager$cU6cn9Avv5EJBz1dtw2DLsLV_q8
            @Override // java.lang.Runnable
            public final void run() {
                YYMountAnimManager.a(YYMountAnimManager.this);
            }
        }, 2000L);
    }

    public final void a(YYMountModel model) {
        Intrinsics.e(model, "model");
        this.d.add(model);
        a(false);
    }

    public final void a(YYMountModel model, boolean z) {
        Intrinsics.e(model, "model");
        if (z) {
            this.b.bringToFront();
            this.e.add(0, model);
            b();
            return;
        }
        for (YYMountModel yYMountModel : this.e) {
            if (model.getWeights() >= yYMountModel.getWeights()) {
                e().add(e().indexOf(yYMountModel), model);
            }
        }
        if (this.e.size() == 0) {
            this.e.add(model);
        }
        if (this.h) {
            return;
        }
        b();
    }

    @Override // com.blued.android.module.live.base.view.animation.LiveAnimationListener
    public void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        this.c.setBackgroundResource(R.color.transparent);
        this.g = null;
        this.h = false;
        this.b.setOnClickListener(null);
        a(true);
    }

    public final void b(YYMountModel model) {
        Intrinsics.e(model, "model");
        if (this.b == null) {
            return;
        }
        if (StringUtils.b(model.getMarqText())) {
            this.c.setText("");
        } else {
            this.c.setText(model.getMarqText());
        }
        this.b.a(this.a.getFragmentActive(), "", "", model.getMounts_img(), "", LiveAnimationViewFactory.ScaleType.FIT_CENTER, this);
    }

    public final BaseYYStudioFragment c() {
        return this.a;
    }

    public final void c(YYMountModel model) {
        Intrinsics.e(model, "model");
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
        if (StringUtils.b(model.getMarqText())) {
            this.c.setText("");
        } else {
            this.c.setText(model.getMarqText());
        }
        this.b.a(this.a.getFragmentActive(), "", "", model.getMounts_img(), "", LiveAnimationViewFactory.ScaleType.FIT_CENTER, this);
    }

    public final TextView d() {
        return this.c;
    }

    public final ArrayList<YYMountModel> e() {
        return this.e;
    }

    public final YYMountModel f() {
        return this.g;
    }

    public final void g() {
    }

    public final void h() {
        b();
    }
}

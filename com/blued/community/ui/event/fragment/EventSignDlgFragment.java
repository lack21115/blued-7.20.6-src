package com.blued.community.ui.event.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.community.R;
import com.blued.community.databinding.FragmentEventSignBinding;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.das.client.feed.FeedProtos;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventSignDlgFragment.class */
public final class EventSignDlgFragment extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<FragmentEventSignBinding>() { // from class: com.blued.community.ui.event.fragment.EventSignDlgFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentEventSignBinding invoke() {
            return FragmentEventSignBinding.a(LayoutInflater.from(EventSignDlgFragment.this.getContext()));
        }
    });
    private String c = "";
    private int d;
    private EventLogData e;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventSignDlgFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, String aid, EventLogData eventLogData) {
            Intrinsics.e(aid, "aid");
            if (fragmentManager == null) {
                return;
            }
            EventSignDlgFragment eventSignDlgFragment = new EventSignDlgFragment();
            Bundle bundle = new Bundle();
            bundle.putString("aid", aid);
            bundle.putSerializable("log_data", eventLogData);
            eventSignDlgFragment.setArguments(bundle);
            eventSignDlgFragment.show(fragmentManager, EventSignDlgFragment.class.getSimpleName());
            EventTrackFeed.a(FeedProtos.Event.ACTIVITY_SIGN_IN_PANEL_SHOW, eventLogData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ScaleAnimation innerScale, Ref.ObjectRef interpolator, final EventSignDlgFragment this$0) {
        Intrinsics.e(innerScale, "$innerScale");
        Intrinsics.e(interpolator, "$interpolator");
        Intrinsics.e(this$0, "this$0");
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.154f, 1.0f, 1.154f, 1, 0.5f, 1, 0.5f);
        innerScale.setInterpolator((Interpolator) interpolator.a);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.setDuration(750L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.ui.event.fragment.EventSignDlgFragment$startAnim2$2$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (EventSignDlgFragment.this.j() < 2) {
                    EventSignDlgFragment eventSignDlgFragment = EventSignDlgFragment.this;
                    eventSignDlgFragment.b(eventSignDlgFragment.j() + 1);
                    EventSignDlgFragment.this.m();
                }
                EventSignDlgFragment.this.h().e.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
                EventSignDlgFragment.this.h().e.setVisibility(0);
            }
        });
        this$0.h().e.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventSignDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EventSignDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EventSignDlgFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
        PermissionUtils.c(new PermissionCallbacks() { // from class: com.blued.community.ui.event.fragment.EventSignDlgFragment$onInitView$3$1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] perms) {
                Intrinsics.e(perms, "perms");
            }
        });
    }

    private final void l() {
        if (CommunityManager.a.a().s()) {
            h().c.setImageResource(R.drawable.event_sign_dlg_bg_dark);
            h().f.setTextColor(getResources().getColor(R.color.syc_EAEAEA));
            h().b.setTextColor(getResources().getColor(R.color.syc_D0D0D0));
        } else {
            h().c.setImageResource(R.drawable.event_sign_dlg_bg);
            h().f.setTextColor(getResources().getColor(R.color.syc_dark_0a0a0a));
            h().b.setTextColor(getResources().getColor(R.color.syc_dark_j));
        }
        h().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventSignDlgFragment$pQ2kRA_Dz6ipAdaTWDd8qlX3K8k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSignDlgFragment.a(EventSignDlgFragment.this, view);
            }
        });
        h().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventSignDlgFragment$-iJZlBZHMUnEE0MuLhoCVvTJFK0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventSignDlgFragment.b(EventSignDlgFragment.this, view);
            }
        });
        h().e.setVisibility(4);
        this.d = 0;
        a(new Runnable() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventSignDlgFragment$2CfFf9eFLUaiKQ1YPy0gutjl48A
            @Override // java.lang.Runnable
            public final void run() {
                EventSignDlgFragment.c(EventSignDlgFragment.this);
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.animation.AccelerateDecelerateInterpolator, T] */
    public final void m() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = new AccelerateDecelerateInterpolator();
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator((Interpolator) objectRef.a);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.ui.event.fragment.EventSignDlgFragment$startAnim2$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation2.setInterpolator(objectRef.a);
                scaleAnimation2.setDuration(500L);
                this.h().d.startAnimation(scaleAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        h().d.startAnimation(scaleAnimation);
        a(new Runnable() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventSignDlgFragment$MQ3FsePhN1Dz7O3aTCfDyXT4Dhg
            @Override // java.lang.Runnable
            public final void run() {
                EventSignDlgFragment.a(ScaleAnimation.this, objectRef, this);
            }
        }, 430L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        dismiss();
    }

    private final void o() {
        EventHttpUtils eventHttpUtils = EventHttpUtils.a;
        final ActivityFragmentActive a2 = a();
        eventHttpUtils.e(new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.community.ui.event.fragment.EventSignDlgFragment$onClickSign$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> parseData) {
                Intrinsics.e(parseData, "parseData");
                ToastUtils.a(R.string.sign_in_success);
                CommEventBusUtil.a.c(EventSignDlgFragment.this.i());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                EventTrackFeed.a(z ? FeedProtos.Event.ACTIVITY_SIGN_IN_PANEL_SUCCESS : FeedProtos.Event.ACTIVITY_SIGN_IN_PANEL_FAIL, EventSignDlgFragment.this.k());
                EventSignDlgFragment.this.n();
            }
        }, this.c, a());
        EventTrackFeed.a(FeedProtos.Event.ACTIVITY_SIGN_IN_PANEL_NOW_CLICK, this.e);
    }

    public final void a(EventLogData eventLogData) {
        this.e = eventLogData;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final FragmentEventSignBinding h() {
        return (FragmentEventSignBinding) this.b.getValue();
    }

    public final String i() {
        return this.c;
    }

    public final int j() {
        return this.d;
    }

    public final EventLogData k() {
        return this.e;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(h().getRoot());
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("aid", "");
            Intrinsics.c(string, "it.getString(\"aid\", \"\")");
            a(string);
            Serializable serializable = arguments.getSerializable("log_data");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.event.model.EventLogData");
            }
            a((EventLogData) serializable);
        }
        l();
    }
}

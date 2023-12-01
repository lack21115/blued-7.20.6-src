package com.blued.android.module.live_china.view.operation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveOperationChildViewBinding;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.GrabBoxListModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.model.LiveWishCourtModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.view.GrabBoxView;
import com.blued.android.module.live_china.view.GrabRewardView;
import com.blued.android.module.live_china.view.LiveRechargeGiftBagView;
import com.blued.android.module.live_china.view.LiveWishCourtView;
import com.blued.android.module.live_china.view.WishingWellView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/OperationChildView.class */
public final class OperationChildView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15367a;
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f15368c;
    private boolean d;
    private LiveRoomOperationModel e;
    private View f;
    private View g;
    private boolean h;
    private boolean i;
    private final float j;
    private final float k;
    private DecelerateInterpolator l;
    private final long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationChildView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.f15367a = mContext;
        this.b = LazyKt.a(new Function0<LiveOperationChildViewBinding>() { // from class: com.blued.android.module.live_china.view.operation.OperationChildView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveOperationChildViewBinding invoke() {
                LiveOperationChildViewBinding a2 = LiveOperationChildViewBinding.a(LayoutInflater.from(OperationChildView.this.getMContext()).inflate(R.layout.live_operation_child_view, OperationChildView.this));
                Intrinsics.c(a2, "bind(\n            Layout…ild_view, this)\n        )");
                return a2;
            }
        });
        this.j = 0.3f;
        this.k = 0.3f;
        this.l = new DecelerateInterpolator(2.0f);
        this.m = 560L;
    }

    private final void a(final View view, final boolean z, final Runnable runnable) {
        this.h = z;
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$OperationChildView$FMRmtmCkCAVXB1FXRI35JD6vbEI
            @Override // java.lang.Runnable
            public final void run() {
                OperationChildView.a(OperationChildView.this, view, z, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OperationChildView this$0, ValueAnimator valueAnimator, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        if (this$0.getParent() == null) {
            valueAnimator.cancel();
            valueAnimator.mo53clone();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this$0.getVb().b.getLayoutParams();
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        layoutParams.width = ((Integer) animatedValue).intValue();
        this$0.getVb().b.setLayoutParams(this$0.getVb().b.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final OperationChildView this$0, View view, boolean z, final Runnable runnable) {
        Intrinsics.e(this$0, "this$0");
        this$0.i = true;
        view.animate().alpha(z ? 1.0f : 0.0f).scaleX(z ? 1.0f : this$0.j).scaleY(z ? 1.0f : this$0.k).setDuration(this$0.m).setInterpolator(this$0.l);
        final ValueAnimator ofInt = ValueAnimator.ofInt(z ? 0 : DensityUtils.a(this$0.getContext(), 41.5f), z ? DensityUtils.a(this$0.getContext(), 41.5f) : 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$OperationChildView$GQs2G1jGRQqJUbHqpcVmJJx3d9E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OperationChildView.a(OperationChildView.this, ofInt, valueAnimator);
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.operation.OperationChildView$startAnim$1$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.e(animation, "animation");
                super.onAnimationEnd(animation);
                Runnable runnable2 = Runnable.this;
                if (runnable2 != null) {
                    runnable2.run();
                }
                this$0.setShowAnim(false);
            }
        });
        ofInt.setDuration(this$0.m);
        ofInt.setInterpolator(this$0.l);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OperationChildView this$0, LiveRoomOperationModel liveRoomOperationModel) {
        Intrinsics.e(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.getVb().b.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = 0;
        }
        this$0.getVb().b.setLayoutParams(this$0.getVb().b.getLayoutParams());
        if ((liveRoomOperationModel == null ? null : Boolean.valueOf(liveRoomOperationModel.getView_init_finish())).booleanValue()) {
            this$0.c();
        }
    }

    private final View c(Object obj) {
        LiveRoomOperationModel model;
        LiveRewardModel liveRewardModel;
        if (this.f15368c != null && (model = getModel()) != null) {
            GrabRewardView grabRewardView = new GrabRewardView(getMContext());
            grabRewardView.a(this.f15368c);
            if (obj == null || !(obj instanceof LiveRewardModel)) {
                liveRewardModel = null;
                if (model.getExtra() != null) {
                    Gson f = AppInfo.f();
                    JsonObject extra = model.getExtra();
                    f.fromJson(extra == null ? null : extra.toString(), LiveRewardModel.class);
                    liveRewardModel = null;
                }
            } else {
                liveRewardModel = (LiveRewardModel) obj;
            }
            if (liveRewardModel != null) {
                grabRewardView.a(liveRewardModel);
            }
            LiveRoomOperationModel model2 = getModel();
            if (model2 != null) {
                model2.setView_init_finish(true);
            }
            return grabRewardView;
        }
        return null;
    }

    private final View d() {
        LiveRoomOperationModel model;
        if (this.f15368c != null && (model = getModel()) != null) {
            OperationChildDefaultView operationChildDefaultView = new OperationChildDefaultView(getMContext());
            model.setView_init_finish(operationChildDefaultView.a(this.f15368c, model) != null);
            OperationChildDefaultView operationChildDefaultView2 = operationChildDefaultView;
            setView(operationChildDefaultView2);
            return operationChildDefaultView2;
        }
        return null;
    }

    private final View d(Object obj) {
        LiveRoomOperationModel model;
        if (this.f15368c != null && (model = getModel()) != null) {
            GrabBoxView grabBoxView = new GrabBoxView(getMContext());
            grabBoxView.a(this.f15368c);
            if (obj != null) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.GrabBoxListModel");
                }
                grabBoxView.a(((GrabBoxListModel) obj).getList());
            }
            model.setView_init_finish(true);
            return grabBoxView;
        }
        return null;
    }

    private final View e() {
        LiveRoomOperationModel model;
        if (this.f15368c == null || (model = getModel()) == null || TextUtils.isEmpty(model.getIcon())) {
            return null;
        }
        LiveRoomOperationModel model2 = getModel();
        if (model2 != null) {
            model2.setView_init_finish(true);
        }
        return new LiveRechargeGiftBagView(getMContext()).a(this.f15368c, model);
    }

    private final View e(Object obj) {
        LiveRoomOperationModel model;
        LiveWishingDrawModel liveWishingDrawModel;
        LiveRoomOperationModel model2;
        if (this.f15368c != null && (model = getModel()) != null) {
            WishingWellView wishingWellView = new WishingWellView(getMContext());
            wishingWellView.setBaseFragment(this.f15368c);
            if (obj == null || !(obj instanceof LiveWishingDrawModel)) {
                liveWishingDrawModel = null;
                if (model.getExtra() != null) {
                    liveWishingDrawModel = (LiveWishingDrawModel) AppInfo.f().fromJson((JsonElement) model.getExtra(), (Class<Object>) LiveWishingDrawModel.class);
                }
            } else {
                liveWishingDrawModel = (LiveWishingDrawModel) obj;
            }
            if (liveWishingDrawModel != null && (model2 = getModel()) != null) {
                model2.setView_init_finish(wishingWellView.a(liveWishingDrawModel));
            }
            return wishingWellView;
        }
        return null;
    }

    private final View f(Object obj) {
        LiveRoomOperationModel model;
        LiveWishCourtModel liveWishCourtModel;
        LiveRoomOperationModel model2;
        if (this.f15368c != null && (model = getModel()) != null) {
            LiveWishCourtView liveWishCourtView = new LiveWishCourtView(getMContext());
            liveWishCourtView.setBaseFragment(this.f15368c);
            if (obj == null || !(obj instanceof LiveWishCourtModel)) {
                liveWishCourtModel = null;
                if (model.getExtra() != null) {
                    AppInfo.f().fromJson((JsonElement) model.getExtra(), LiveWishCourtModel.class);
                    liveWishCourtModel = null;
                }
            } else {
                liveWishCourtModel = (LiveWishCourtModel) obj;
            }
            if (liveWishCourtModel != null && (model2 = getModel()) != null) {
                model2.setView_init_finish(liveWishCourtView.a(liveWishCourtModel));
            }
            return liveWishCourtView;
        }
        return null;
    }

    private final LiveOperationChildViewBinding getVb() {
        return (LiveOperationChildViewBinding) this.b.getValue();
    }

    public final View a(Object obj) {
        LiveRoomOperationModel liveRoomOperationModel = this.e;
        if (liveRoomOperationModel == null || this.f15368c == null) {
            return null;
        }
        Intrinsics.a(liveRoomOperationModel);
        int tools_type = liveRoomOperationModel.getTools_type();
        View d = tools_type == EnumOperation.VIEW_TYPE_DEFAULT.getValue() ? d() : tools_type == EnumOperation.VIEW_TYPE_RED_BAG.getValue() ? c(obj) : tools_type == EnumOperation.VIEW_TYPE_TREASURE_BOX.getValue() ? d(obj) : tools_type == EnumOperation.VIEW_TYPE_WISHING_KNOCKING.getValue() ? e(obj) : tools_type == EnumOperation.VIEW_TYPE_WISHING_CONTEST.getValue() ? f(obj) : tools_type == EnumOperation.VIEW_TYPE_CHICKEN_WIN.getValue() ? d() : tools_type == EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue() ? e() : tools_type == EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue() ? e() : tools_type == EnumOperation.VIEW_TYPE_DARED_ATM.getValue() ? d() : d();
        this.g = getVb().f12309c;
        return d;
    }

    public final OperationChildView a(BaseFragment baseFragment, boolean z, final LiveRoomOperationModel liveRoomOperationModel, Object obj) {
        if (baseFragment != null) {
            this.f15368c = baseFragment;
        }
        this.d = z;
        this.e = liveRoomOperationModel;
        if (liveRoomOperationModel == null || liveRoomOperationModel.getStatus() == 0) {
            return null;
        }
        View a2 = a(obj);
        if (a2 != null) {
            setView(a2);
            getVb().f12308a.removeAllViews();
            if (a2.getParent() != null) {
                ViewParent parent = a2.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(a2);
            }
            getVb().f12308a.addView(a2);
            a2.setScaleX(this.j);
            a2.setScaleY(this.k);
            a2.setAlpha(0.0f);
            a2.post(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$OperationChildView$I3X7hmeKIYmtRmKGNyUpwSzvfdw
                @Override // java.lang.Runnable
                public final void run() {
                    OperationChildView.a(OperationChildView.this, liveRoomOperationModel);
                }
            });
        }
        if (this.f != null) {
            return this;
        }
        return null;
    }

    public final void a(Runnable runnable) {
        if (this.h) {
            a(this.f, false, runnable);
        }
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.i;
    }

    public final boolean b(Object data) {
        Intrinsics.e(data, "data");
        View view = this.f;
        if (view == null) {
            return false;
        }
        if ((view instanceof OperationChildDefaultView) && (data instanceof LiveRoomOperationModel)) {
            boolean a2 = ((OperationChildDefaultView) view).a((LiveRoomOperationModel) data);
            LiveRoomOperationModel model = getModel();
            if (model == null) {
                return a2;
            }
            model.setView_init_finish(a2);
            return a2;
        } else if ((view instanceof GrabRewardView) && (data instanceof LiveRewardModel)) {
            Boolean initFinish = ((GrabRewardView) view).a((LiveRewardModel) data);
            LiveRoomOperationModel model2 = getModel();
            if (model2 != null) {
                Intrinsics.c(initFinish, "initFinish");
                model2.setView_init_finish(initFinish.booleanValue());
            }
            Intrinsics.c(initFinish, "initFinish");
            return initFinish.booleanValue();
        } else if ((view instanceof GrabBoxView) && (data instanceof GrabBoxListModel)) {
            boolean a3 = ((GrabBoxView) view).a(((GrabBoxListModel) data).getList());
            LiveRoomOperationModel model3 = getModel();
            if (model3 == null) {
                return a3;
            }
            model3.setView_init_finish(a3);
            return a3;
        } else if ((view instanceof WishingWellView) && (data instanceof LiveWishingDrawModel)) {
            boolean a4 = ((WishingWellView) view).a((LiveWishingDrawModel) data);
            LiveRoomOperationModel model4 = getModel();
            if (model4 == null) {
                return a4;
            }
            model4.setView_init_finish(a4);
            return a4;
        } else if ((view instanceof LiveWishCourtView) && (data instanceof LiveWishCourtModel)) {
            boolean a5 = ((LiveWishCourtView) view).a((LiveWishCourtModel) data);
            LiveRoomOperationModel model5 = getModel();
            if (model5 == null) {
                return a5;
            }
            model5.setView_init_finish(a5);
            return a5;
        } else {
            return false;
        }
    }

    public final void c() {
        if (this.h) {
            return;
        }
        a(this.f, true, (Runnable) null);
    }

    public final long getDurationShort() {
        return this.m;
    }

    public final Context getMContext() {
        return this.f15367a;
    }

    public final LiveRoomOperationModel getModel() {
        return this.e;
    }

    public final View getSplitLine() {
        return this.g;
    }

    public final View getView() {
        return this.f;
    }

    public final void setModel(LiveRoomOperationModel liveRoomOperationModel) {
        this.e = liveRoomOperationModel;
    }

    public final void setShow(boolean z) {
        this.h = z;
    }

    public final void setShowAnim(boolean z) {
        this.i = z;
    }

    public final void setSplitLine(View view) {
        this.g = view;
    }

    public final void setView(View view) {
        this.f = view;
    }
}

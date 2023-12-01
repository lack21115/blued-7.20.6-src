package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.animation.Rotate3dAnimation;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveUserCardMouleModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveUserCardModuleAdapter.class */
public final class LiveUserCardModuleAdapter extends BaseQuickAdapter<LiveUserCardMouleModel, BaseViewHolder> {
    private Context a;
    private String b;
    private IRequestHost c;

    public LiveUserCardModuleAdapter(Context context, List<LiveUserCardMouleModel> list, String str) {
        super(R.layout.live_user_card_module, list);
        this.b = "";
        this.a = context;
        this.b = str;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveUserCardModuleAdapter this$0, LiveUserCardMouleModel liveUserCardMouleModel, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_PROFILE_CARD_ONE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.b, String.valueOf(liveUserCardMouleModel.getBuried_point_type()));
        if (liveUserCardMouleModel.getInteraction_type() == 0) {
            return;
        }
        if (liveUserCardMouleModel.getInteraction_type() == 1) {
            if (liveUserCardMouleModel.getShow_btm()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PROFILE_CARD_FLIP_CARD_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.b, String.valueOf(liveUserCardMouleModel.getBuried_point_type()));
            }
            View view2 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.card_top);
            Intrinsics.c(view2, "helper?.getView<View>(R.id.card_top)");
            View view3 = baseViewHolder == null ? null : baseViewHolder.getView(R.id.card_btm);
            Intrinsics.c(view3, "helper?.getView<View>(R.id.card_btm)");
            this$0.a(view2, view3, liveUserCardMouleModel);
        } else if (liveUserCardMouleModel.getInteraction_type() == 2) {
            if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
                LiveSetDataObserver.a().b(liveUserCardMouleModel.getLink(), 25);
            } else {
                LiveRefreshUIObserver.a().b(liveUserCardMouleModel.getLink(), 25);
            }
        } else if (liveUserCardMouleModel.getInteraction_type() == 3) {
            if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
                LiveSetDataObserver.a().c(liveUserCardMouleModel.getLink(), 0);
            } else {
                LiveRefreshUIObserver.a().c(liveUserCardMouleModel.getLink(), 0);
            }
        } else if (liveUserCardMouleModel.getInteraction_type() == 4) {
            LiveEventBus.get("live_user_card_dismiss").post("");
            if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
                LiveSetDataObserver.a().A();
            } else {
                LiveRefreshUIObserver.a().m();
            }
        }
    }

    public final IRequestHost a() {
        return this.c;
    }

    public final void a(final View viewTop, final View viewBtm, final LiveUserCardMouleModel item) {
        Intrinsics.e(viewTop, "viewTop");
        Intrinsics.e(viewBtm, "viewBtm");
        Intrinsics.e(item, "item");
        if (item.getAniming()) {
            return;
        }
        item.setAniming(true);
        float width = viewTop.getWidth() / 2.0f;
        float height = viewTop.getHeight() / 2.0f;
        final AnimationSet animationSet = new AnimationSet(true);
        final AnimationSet animationSet2 = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(item.getShow_btm() ? 0.0f : 1.0f, item.getShow_btm() ? 1.0f : 0.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(!item.getShow_btm() ? 0.0f : 1.0f, !item.getShow_btm() ? 1.0f : 0.0f);
        alphaAnimation.setDuration(160L);
        alphaAnimation2.setDuration(160L);
        Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(item.getShow_btm() ? -270.0f : 0.0f, item.getShow_btm() ? -360.0f : -90.0f, width, height, 0.0f, Rotate3dAnimation.a, true);
        Rotate3dAnimation rotate3dAnimation2 = new Rotate3dAnimation(!item.getShow_btm() ? -270.0f : 0.0f, !item.getShow_btm() ? -360.0f : -90.0f, width, height, 0.0f, Rotate3dAnimation.a, true);
        rotate3dAnimation.setDuration(160L);
        rotate3dAnimation2.setDuration(160L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotate3dAnimation);
        animationSet2.addAnimation(alphaAnimation2);
        animationSet2.addAnimation(rotate3dAnimation2);
        rotate3dAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.adapter.LiveUserCardModuleAdapter$rotaiton$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (LiveUserCardMouleModel.this.getShow_btm()) {
                    LiveUserCardMouleModel liveUserCardMouleModel = LiveUserCardMouleModel.this;
                    liveUserCardMouleModel.setShow_btm(!liveUserCardMouleModel.getShow_btm());
                    LiveUserCardMouleModel.this.setAniming(false);
                    return;
                }
                viewTop.setVisibility(8);
                viewBtm.setVisibility(0);
                viewBtm.clearAnimation();
                viewBtm.startAnimation(animationSet2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        rotate3dAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.adapter.LiveUserCardModuleAdapter$rotaiton$2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (!LiveUserCardMouleModel.this.getShow_btm()) {
                    LiveUserCardMouleModel liveUserCardMouleModel = LiveUserCardMouleModel.this;
                    liveUserCardMouleModel.setShow_btm(!liveUserCardMouleModel.getShow_btm());
                    LiveUserCardMouleModel.this.setAniming(false);
                    return;
                }
                viewTop.setVisibility(0);
                viewBtm.setVisibility(8);
                viewTop.clearAnimation();
                viewTop.startAnimation(animationSet);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        if (item.getShow_btm()) {
            viewTop.setVisibility(8);
            viewBtm.setVisibility(0);
            viewBtm.clearAnimation();
            viewBtm.startAnimation(animationSet2);
            return;
        }
        viewTop.setVisibility(0);
        viewBtm.setVisibility(8);
        viewTop.clearAnimation();
        viewTop.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final LiveUserCardMouleModel liveUserCardMouleModel) {
        Context context;
        float f;
        if (liveUserCardMouleModel == null) {
            return;
        }
        Intrinsics.a(baseViewHolder);
        int layoutPosition = baseViewHolder.getLayoutPosition();
        View view = baseViewHolder.getView(R.id.fl_root);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (layoutPosition == 0) {
            marginLayoutParams.leftMargin = DensityUtils.a(this.a, 15.0f);
            marginLayoutParams.rightMargin = 0;
        } else if (layoutPosition == this.mData.size() - 1) {
            marginLayoutParams.leftMargin = DensityUtils.a(this.a, 7.5f);
            marginLayoutParams.rightMargin = DensityUtils.a(this.a, 15.0f);
        } else {
            marginLayoutParams.leftMargin = DensityUtils.a(this.a, 7.5f);
            marginLayoutParams.rightMargin = 0;
        }
        view.setLayoutParams(marginLayoutParams);
        baseViewHolder.setText(R.id.tv1_top, liveUserCardMouleModel.getName());
        baseViewHolder.setText(R.id.tv2_top, liveUserCardMouleModel.getDesc());
        baseViewHolder.setAlpha(R.id.tv2_top, 0.8f);
        String icon = liveUserCardMouleModel.getIcon();
        if (icon != null) {
            ImageLoader.a(a(), icon).a((ImageView) baseViewHolder.getView(R.id.iv_avatar_top));
            ImageLoader.a(a(), icon).a((ImageView) baseViewHolder.getView(R.id.iv_avatar_btm));
        }
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_bg_top);
        ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_bg_btm);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_bg_top);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_bg_btm);
        if (TextUtils.isEmpty(liveUserCardMouleModel.getColor_image())) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            if (shapeFrameLayout != null) {
                shapeFrameLayout.setVisibility(0);
            }
            if (shapeFrameLayout2 != null) {
                shapeFrameLayout2.setVisibility(0);
            }
            ShapeModel shapeModel = new ShapeModel();
            shapeModel.H = DensityUtils.a(AppInfo.d(), 6.0f);
            try {
                shapeModel.t = Color.parseColor(liveUserCardMouleModel.getColor_start());
            } catch (Exception e) {
                shapeModel.t = AppInfo.d().getResources().getColor(R.color.syc_dark_69DCFF);
            }
            try {
                shapeModel.v = Color.parseColor(liveUserCardMouleModel.getColor_end());
            } catch (Exception e2) {
                shapeModel.v = AppInfo.d().getResources().getColor(R.color.syc_dark_17B016);
            }
            if (shapeFrameLayout != null) {
                shapeFrameLayout.setShapeModel(shapeModel);
            }
            if (shapeFrameLayout2 != null) {
                shapeFrameLayout2.setShapeModel(shapeModel);
            }
            if (shapeFrameLayout2 != null) {
                shapeFrameLayout2.setAlpha(0.6f);
            }
        } else {
            IRequestHost iRequestHost = this.c;
            String color_image = liveUserCardMouleModel.getColor_image();
            Intrinsics.a((Object) color_image);
            ImageLoader.a(iRequestHost, color_image).a(imageView);
            IRequestHost iRequestHost2 = this.c;
            String color_image2 = liveUserCardMouleModel.getColor_image();
            Intrinsics.a((Object) color_image2);
            ImageLoader.a(iRequestHost2, color_image2).a(imageView2);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            if (imageView2 != null) {
                imageView2.setAlpha(0.6f);
            }
            if (shapeFrameLayout != null) {
                shapeFrameLayout.setVisibility(8);
            }
            if (shapeFrameLayout2 != null) {
                shapeFrameLayout2.setVisibility(8);
            }
        }
        ShapeFrameLayout shapeFrameLayout3 = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_bg_progress_btm);
        if (liveUserCardMouleModel.getInteraction_type() == 1) {
            if (liveUserCardMouleModel.getTotal_progress() > 0.0f) {
                if (shapeFrameLayout3 != null) {
                    shapeFrameLayout3.setVisibility(0);
                }
                ShapeModel shapeModel2 = new ShapeModel();
                shapeModel2.H = DensityUtils.a(AppInfo.d(), 6.0f);
                try {
                    shapeModel2.t = Color.parseColor(liveUserCardMouleModel.getColor_start());
                } catch (Exception e3) {
                    shapeModel2.t = AppInfo.d().getResources().getColor(R.color.syc_dark_004DDD);
                }
                try {
                    shapeModel2.v = Color.parseColor(liveUserCardMouleModel.getColor_end());
                } catch (Exception e4) {
                    shapeModel2.v = AppInfo.d().getResources().getColor(R.color.syc_dark_17B016);
                }
                float f2 = 1.0f;
                float current_progress = (liveUserCardMouleModel.getCurrent_progress() * 1.0f) / liveUserCardMouleModel.getTotal_progress();
                if (current_progress <= 1.0f) {
                    f2 = current_progress;
                }
                float a = DensityUtils.a(this.a, 125.0f);
                int a2 = DensityUtils.a(this.a, 3.0f);
                int max = Math.max((int) (f2 * a), a2);
                if (max > a2) {
                    context = this.a;
                    f = 1.5f;
                } else {
                    context = this.a;
                    f = 3.0f;
                }
                int a3 = DensityUtils.a(context, f);
                ViewGroup.LayoutParams layoutParams2 = shapeFrameLayout3 == null ? null : shapeFrameLayout3.getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).setMargins(a3, a3, a3, a3);
                ViewGroup.LayoutParams layoutParams3 = shapeFrameLayout3 == null ? null : shapeFrameLayout3.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = max;
                }
                if (shapeFrameLayout3 != null) {
                    shapeFrameLayout3.setShapeModel(shapeModel2);
                }
            } else if (shapeFrameLayout3 != null) {
                shapeFrameLayout3.setVisibility(8);
            }
            if (liveUserCardMouleModel.is_max_progress()) {
                int a4 = DensityUtils.a(this.a, 125.0f);
                ViewGroup.LayoutParams layoutParams4 = shapeFrameLayout3 == null ? null : shapeFrameLayout3.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = a4;
                }
                baseViewHolder.setGone(R.id.tv1_btm, false);
                baseViewHolder.setText(R.id.tv2_btm, liveUserCardMouleModel.getFlip_name());
                baseViewHolder.setGone(R.id.tv2_btm, true);
            } else {
                baseViewHolder.setGone(R.id.tv1_btm, true);
                baseViewHolder.setGone(R.id.tv2_btm, true);
                baseViewHolder.setText(R.id.tv1_btm, liveUserCardMouleModel.getFlip_name());
                baseViewHolder.setText(R.id.tv2_btm, liveUserCardMouleModel.getFlip_desc());
                baseViewHolder.setAlpha(R.id.tv2_btm, 0.8f);
            }
        }
        View view2 = baseViewHolder.getView(R.id.fl_root);
        if (view2 == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveUserCardModuleAdapter$qPRCKWenE0xc2WpOedlx6ebUG1Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                LiveUserCardModuleAdapter.a(LiveUserCardModuleAdapter.this, liveUserCardMouleModel, baseViewHolder, view3);
            }
        });
    }

    public final Context getContext() {
        return this.a;
    }
}

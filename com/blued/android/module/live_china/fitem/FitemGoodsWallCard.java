package com.blued.android.module.live_china.fitem;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.model.LiveDefaultGiftModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GoodsWallItemModel;
import com.blued.android.module.live_china.model.JudgeGoodsWallStateExtraModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.pop.LiveGoodsWallTipPop;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import com.blued.das.live.LiveProtos;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGoodsWallCard.class */
public final class FitemGoodsWallCard extends FreedomItem {
    private final GoodsWallItemModel b;

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f12537c;
    private ObjectAnimator d;
    private boolean e;
    private boolean f;
    private boolean g;

    public FitemGoodsWallCard(GoodsWallItemModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    private final void a(Context context, final BaseViewHolder baseViewHolder) {
        a(baseViewHolder, true);
        b(baseViewHolder, false);
        baseViewHolder.c(R.id.iv_card_background, R.drawable.live_goods_wall_card_background_not_aglow).a(R.id.tv_goods_name, 0.7f).c(R.id.tv_not_aglow_hite).d(R.id.tv_goto_active);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.a(R.id.tv_goto_active);
        if (this.e) {
            ShapeModel shapeModel = shapeTextView.getShapeModel();
            shapeModel.k = ContextCompat.getColor(context, R.color.transparent);
            shapeTextView.setShapeModel(shapeModel);
            shapeTextView.setText(R.string.live_aglow_not_aglow);
            shapeTextView.setTextColor(ContextCompat.getColor(context, R.color.white_alpha40));
            shapeTextView.setClickable(false);
            return;
        }
        ShapeModel shapeModel2 = shapeTextView.getShapeModel();
        shapeModel2.k = ContextCompat.getColor(context, R.color.syc_dark_1EC933CC);
        shapeTextView.setShapeModel(shapeModel2);
        shapeTextView.setText(R.string.live_aglow_goods);
        shapeTextView.setTextColor(ContextCompat.getColor(context, R.color.syc_dark_C933CC));
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallCard$3UrYZgI3WYh0LOpoj2PuTYondFM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemGoodsWallCard.b(FitemGoodsWallCard.this, baseViewHolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, FitemGoodsWallCard this$0, View view) {
        Intrinsics.e(context, "$context");
        Intrinsics.e(this$0, "this$0");
        new LiveGoodsWallTipPop(context, !this$0.f).b(view);
    }

    private final void a(BaseViewHolder baseViewHolder, boolean z) {
        if (!z) {
            ((ImageView) baseViewHolder.a(R.id.iv_goods_img)).setColorFilter((ColorFilter) null);
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ((ImageView) baseViewHolder.a(R.id.iv_goods_img)).setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemGoodsWallCard this$0, BaseViewHolder vh, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        this$0.f(vh);
    }

    private final void b(final Context context, final BaseViewHolder baseViewHolder) {
        if (this.b.getStart() == 2 || this.b.getStart() == 3) {
            baseViewHolder.d(R.id.rl_user_root).a(R.id.rl_user_root, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallCard$eNAuyiJiWWdBMrKIgz1hW9ea7MU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemGoodsWallCard.c(FitemGoodsWallCard.this, baseViewHolder, view);
                }
            }).a(R.id.iv_query, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallCard$QukO0l7qDdC6v8p1bJHNGUP1G68
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemGoodsWallCard.a(Context.this, this, view);
                }
            }).a(R.id.iv_avatar, this.b.getAvatar(), R.drawable.icon_desire_funders_default, true).a(R.id.tv_nickname, (CharSequence) LiveCloakingUtil.a(this.b.getUsername(), this.b.is_hide()));
        } else {
            baseViewHolder.c(R.id.rl_user_root);
        }
    }

    private final void b(BaseViewHolder baseViewHolder) {
        a(baseViewHolder, true);
        b(baseViewHolder, false);
        baseViewHolder.c(R.id.iv_card_background, R.drawable.live_goods_wall_card_background_not_aglow).a(R.id.tv_goods_name, 0.7f).d(R.id.tv_not_aglow_hite).c(R.id.tv_goto_active);
    }

    private final void b(BaseViewHolder baseViewHolder, boolean z) {
        ImageView imageView = (ImageView) baseViewHolder.a(R.id.iv_goods_img);
        if (!z) {
            ObjectAnimator objectAnimator = this.f12537c;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            imageView.setScaleX(1.0f);
            ObjectAnimator objectAnimator2 = this.d;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            imageView.setScaleY(1.0f);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 0.92f, 1.0f);
        this.f12537c = ofFloat;
        Intrinsics.a(ofFloat);
        ofFloat.setDuration(1440L);
        ObjectAnimator objectAnimator3 = this.f12537c;
        Intrinsics.a(objectAnimator3);
        objectAnimator3.setRepeatCount(-1);
        ObjectAnimator objectAnimator4 = this.f12537c;
        Intrinsics.a(objectAnimator4);
        objectAnimator4.setRepeatMode(-1);
        ObjectAnimator objectAnimator5 = this.f12537c;
        Intrinsics.a(objectAnimator5);
        objectAnimator5.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 0.92f, 1.0f);
        this.d = ofFloat2;
        Intrinsics.a(ofFloat2);
        ofFloat2.setDuration(1440L);
        ObjectAnimator objectAnimator6 = this.d;
        Intrinsics.a(objectAnimator6);
        objectAnimator6.setRepeatCount(-1);
        ObjectAnimator objectAnimator7 = this.d;
        Intrinsics.a(objectAnimator7);
        objectAnimator7.setRepeatMode(-1);
        ObjectAnimator objectAnimator8 = this.d;
        Intrinsics.a(objectAnimator8);
        objectAnimator8.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemGoodsWallCard this$0, BaseViewHolder vh, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_WALL_PAGE_LIGHT_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.b.getGoods_id());
        this$0.f(vh);
    }

    private final void c(BaseViewHolder baseViewHolder) {
        a(baseViewHolder, false);
        b(baseViewHolder, false);
        baseViewHolder.c(R.id.iv_card_background, R.drawable.live_goods_wall_card_background_aglow).a(R.id.tv_goods_name, 1.0f).c(R.id.tv_not_aglow_hite).c(R.id.tv_goto_active);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FitemGoodsWallCard this$0, BaseViewHolder vh, View view) {
        BaseFragment baseFragment;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        if (this$0.b.is_hide() != 0 || (baseFragment = (BaseFragment) vh.f10931a.a("BaseFragment", (String) null)) == null) {
            return;
        }
        UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment);
        userCardDialogFragment.e(this$0.e().getUid());
        FragmentManager fragmentManager = baseFragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        userCardDialogFragment.show(fragmentManager, "userCardDialog");
    }

    private final void d(BaseViewHolder baseViewHolder) {
        ImageLoader.c(baseViewHolder.b, "live_goods_wall_card_background_collection.png").g().g(-1).a((ImageView) baseViewHolder.a(R.id.iv_card_background));
        a(baseViewHolder, false);
        b(baseViewHolder, true);
        baseViewHolder.a(R.id.tv_goods_name, 1.0f).c(R.id.tv_not_aglow_hite).c(R.id.tv_goto_active);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r4.b.getStart() == 1) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e(com.blued.android.module.common.utils.freedom.BaseViewHolder r5) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemGoodsWallCard.e(com.blued.android.module.common.utils.freedom.BaseViewHolder):void");
    }

    private final void f(BaseViewHolder baseViewHolder) {
        if (this.e) {
            return;
        }
        int goods_id = this.b.getGoods_id();
        final IRequestHost iRequestHost = baseViewHolder.b;
        LiveRoomHttpUtils.k(goods_id, new BluedUIHttpResponse<BluedEntity<Object, JudgeGoodsWallStateExtraModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.fitem.FitemGoodsWallCard$gotoActive$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<Object, JudgeGoodsWallStateExtraModel> entity) {
                Intrinsics.e(entity, "entity");
                JudgeGoodsWallStateExtraModel judgeGoodsWallStateExtraModel = entity.extra;
                if (judgeGoodsWallStateExtraModel == null) {
                    return;
                }
                if (judgeGoodsWallStateExtraModel.is_goods_pack() == 1) {
                    LiveDefaultGiftModel liveDefaultGiftModel = new LiveDefaultGiftModel();
                    liveDefaultGiftModel.id = judgeGoodsWallStateExtraModel.getGoods_id();
                    liveDefaultGiftModel.is_bag = true;
                    LiveRefreshUIObserver.a().a(liveDefaultGiftModel);
                } else if (judgeGoodsWallStateExtraModel.is_valid() == 1) {
                    LiveDefaultGiftModel liveDefaultGiftModel2 = new LiveDefaultGiftModel();
                    liveDefaultGiftModel2.id = judgeGoodsWallStateExtraModel.getGoods_id();
                    liveDefaultGiftModel2.is_bag = false;
                    LiveRefreshUIObserver.a().a(liveDefaultGiftModel2);
                } else if (judgeGoodsWallStateExtraModel.is_wish() != 1) {
                    String toast = judgeGoodsWallStateExtraModel.getToast();
                    if (toast == null) {
                        return;
                    }
                    ToastUtils.a(toast);
                    return;
                } else {
                    LiveSetDataObserver.a().w();
                }
                LiveEventBusUtil.l();
            }
        }, baseViewHolder.b);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_goods_wall_card;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        this.e = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        this.f = true;
        boolean z = false;
        this.g = false;
        BaseViewHolder a2 = vh.a(R.id.iv_goods_img, this.b.getGoods_image()).a(R.id.tv_goods_name, (CharSequence) this.b.getGoods_name());
        int i2 = R.id.iv_tag;
        if (this.b.getLimited() == 1) {
            z = true;
        }
        a2.b(i2, z);
        e(vh);
        b(context, vh);
        int start = this.b.getStart();
        if (start != 1) {
            if (start == 2) {
                c(vh);
            } else if (start == 3) {
                d(vh);
            }
        } else if (this.e) {
            b(vh);
        } else {
            a(context, vh);
        }
        vh.a(R.id.iv_card_background, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGoodsWallCard$Lh-Uutg1Q0AmckByAcZ7qmFJywI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemGoodsWallCard.a(FitemGoodsWallCard.this, vh, view);
            }
        });
    }

    public final GoodsWallItemModel e() {
        return this.b;
    }
}

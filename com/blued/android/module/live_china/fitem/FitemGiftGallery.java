package com.blued.android.module.live_china.fitem;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.GiftGalleryDataModel;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemGiftGallery.class */
public final class FitemGiftGallery extends FreedomItem {
    private final GiftGalleryDataModel b;

    /* renamed from: c  reason: collision with root package name */
    private ObjectAnimator f12534c;
    private ObjectAnimator d;

    public FitemGiftGallery(GiftGalleryDataModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemGiftGallery this$0, Ref.ObjectRef goodsImg) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(goodsImg, "$goodsImg");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(goodsImg.f42545a, "scaleX", 1.0f, 1.05f);
        this$0.f12534c = ofFloat;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(-1);
        }
        ObjectAnimator objectAnimator = this$0.f12534c;
        if (objectAnimator != null) {
            objectAnimator.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator2 = this$0.f12534c;
        if (objectAnimator2 != null) {
            objectAnimator2.setDuration(1080L);
        }
        ObjectAnimator objectAnimator3 = this$0.f12534c;
        if (objectAnimator3 != null) {
            objectAnimator3.start();
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(goodsImg.f42545a, "scaleY", 1.0f, 1.05f);
        this$0.d = ofFloat2;
        if (ofFloat2 != null) {
            ofFloat2.setRepeatCount(-1);
        }
        ObjectAnimator objectAnimator4 = this$0.d;
        if (objectAnimator4 != null) {
            objectAnimator4.setRepeatMode(2);
        }
        ObjectAnimator objectAnimator5 = this$0.d;
        if (objectAnimator5 != null) {
            objectAnimator5.setDuration(1080L);
        }
        ObjectAnimator objectAnimator6 = this$0.d;
        if (objectAnimator6 == null) {
            return;
        }
        objectAnimator6.start();
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_gift_gallery;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_gallery_giftname, (CharSequence) this.b.getGoods_name()).a(R.id.iv_gallery_gifticon, this.b.getGoods_image()).a(R.id.tv_gallery_username, (CharSequence) LiveCloakingUtil.a(this.b.getUsername(), this.b.is_hide())).a(R.id.iv_gallery_usericon, this.b.getAvatar(), R.drawable.user_bg_round, true, 1.0f, -1);
        TextView textView = (TextView) vh.a(R.id.tv_gallery_username);
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
        TextView textView2 = (TextView) vh.a(R.id.tv_gallery_giftname);
        if (textView2 != null) {
            textView2.getPaint().setFakeBoldText(true);
        }
        b(vh);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.view.View] */
    public final void b(BaseViewHolder vh) {
        Intrinsics.e(vh, "vh");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = vh.a(R.id.iv_gallery_gifticon);
        ((ImageView) objectRef.f42545a).post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemGiftGallery$KJDQAqFh_Rzb5MzDeOG8r_ZsG18
            @Override // java.lang.Runnable
            public final void run() {
                FitemGiftGallery.a(FitemGiftGallery.this, objectRef);
            }
        });
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public float c() {
        return 0.5f;
    }

    public final void e() {
        ObjectAnimator objectAnimator = this.f12534c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.f12534c = null;
        ObjectAnimator objectAnimator2 = this.d;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.d = null;
    }
}

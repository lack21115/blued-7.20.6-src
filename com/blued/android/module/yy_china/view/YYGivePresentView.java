package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.module.yy_china.databinding.ViewYyGivePresentLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGivePresentView.class */
public final class YYGivePresentView extends LinearLayout {
    private ViewYyGivePresentLayoutBinding a;
    private BaseYYStudioFragment b;
    private YYGiftModel c;
    private YYRoomModel d;
    private int e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYGivePresentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYGivePresentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYyGivePresentLayoutBinding a = ViewYyGivePresentLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.e = 1;
        a.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGivePresentView$ncpuuM6ccxxMQdwAW8xbrnaGsL8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGivePresentView.a(YYGivePresentView.this, view);
            }
        });
        postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGivePresentView$uGnOVeA-aZFmfWWEX5qp46SOxP0
            @Override // java.lang.Runnable
            public final void run() {
                YYGivePresentView.a(YYGivePresentView.this);
            }
        }, 8000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGivePresentView this$0) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGivePresentView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != null) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_SEND_GIFT_GUIDE_CLICK;
            YYRoomModel yYRoomModel = this$0.d;
            String str = null;
            String str2 = yYRoomModel == null ? null : yYRoomModel.room_id;
            YYRoomModel yYRoomModel2 = this$0.d;
            if (yYRoomModel2 != null) {
                str = yYRoomModel2.uid;
            }
            EventTrackYY.d(event, str2, str);
        }
        this$0.a(this$0.c, this$0.e, "", false);
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        if (baseYYStudioFragment == null) {
            return;
        }
        baseYYStudioFragment.y();
    }

    public final void a(YYGiftModel yYGiftModel, int i, String payCode, boolean z) {
        Intrinsics.e(payCode, "payCode");
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (this.d == null || yYUserInfo == null || yYGiftModel == null || yYUserInfo.isSendGift || this.b == null) {
            return;
        }
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_SEND_GIFT_GUIDE_SHOW;
        YYRoomModel yYRoomModel = this.d;
        String str = yYRoomModel == null ? null : yYRoomModel.room_id;
        YYRoomModel yYRoomModel2 = this.d;
        EventTrackYY.d(event, str, yYRoomModel2 == null ? null : yYRoomModel2.uid);
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYGiftModel.hit_id = System.currentTimeMillis();
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = i;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        yYPayRequestModel.hit_id = yYGiftModel.hit_id;
        yYPayRequestModel.payCode = payCode;
        yYPayRequestModel.remember_me = z;
        YYRoomModel yYRoomModel3 = this.d;
        yYPayRequestModel.room_id = yYRoomModel3 == null ? null : yYRoomModel3.room_id;
        YYRoomModel yYRoomModel4 = this.d;
        yYPayRequestModel.target_uid = yYRoomModel4 == null ? null : yYRoomModel4.uid;
        LiveEventBus.get("event_pop_buy_goods").post(yYPayRequestModel);
    }

    public final ViewYyGivePresentLayoutBinding getBinding() {
        return this.a;
    }

    public final BaseYYStudioFragment getFragment() {
        return this.b;
    }

    public final YYGiftModel getGoods() {
        return this.c;
    }

    public final int getGoodsCount() {
        return this.e;
    }

    public final YYRoomModel getRoomModel() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = null;
    }

    public final void setBinding(ViewYyGivePresentLayoutBinding viewYyGivePresentLayoutBinding) {
        Intrinsics.e(viewYyGivePresentLayoutBinding, "<set-?>");
        this.a = viewYyGivePresentLayoutBinding;
    }

    public final void setFragment(BaseYYStudioFragment baseYYStudioFragment) {
        this.b = baseYYStudioFragment;
    }

    public final void setGoods(YYGiftModel yYGiftModel) {
        this.c = yYGiftModel;
    }

    public final void setGoodsCount(int i) {
        this.e = i;
    }

    public final void setRoomModel(YYRoomModel yYRoomModel) {
        this.d = yYRoomModel;
    }
}

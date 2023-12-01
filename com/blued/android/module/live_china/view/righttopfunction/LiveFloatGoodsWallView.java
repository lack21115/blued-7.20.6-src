package com.blued.android.module.live_china.view.righttopfunction;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveFloatGoodsWallViewBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.ConstFunction;
import com.blued.android.module.live_china.model.LiveGiftWallFloatModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/righttopfunction/LiveFloatGoodsWallView.class */
public final class LiveFloatGoodsWallView extends FrameLayout implements RightTopFunction {
    private final Context a;
    private boolean b;
    private boolean c;
    private BaseFragment d;
    private final LiveFloatGoodsWallViewBinding e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveFloatGoodsWallView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveFloatGoodsWallView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFloatGoodsWallView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        setShow(false);
        this.c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        LiveFloatGoodsWallViewBinding a = LiveFloatGoodsWallViewBinding.a(LayoutInflater.from(this.a).inflate(R.layout.live_float_goods_wall_view, this));
        Intrinsics.c(a, "bind(\n        LayoutInfl…ds_wall_view, this)\n    )");
        this.e = a;
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveFloatGoodsWallView$BnRe_I-RZsgblr_w6Q6A2ADln64
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFloatGoodsWallView.a(view);
            }
        });
    }

    public /* synthetic */ LiveFloatGoodsWallView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        liveRoomFunctionItemModel.setLink_type(3);
        liveRoomFunctionItemModel.setLink(ConstFunction.LIVE_ROOM_GOODS_WALL);
        LiveEventBus.get(LiveEventBusUtil.C).post(liveRoomFunctionItemModel);
    }

    @Override // com.blued.android.module.live_china.view.righttopfunction.RightTopFunction
    public boolean a() {
        return this.b;
    }

    public final Context getMContext() {
        return this.a;
    }

    @Override // com.blued.android.module.live_china.view.righttopfunction.RightTopFunction
    public int getPriority() {
        return 1;
    }

    public final void setBaseFragment(BaseFragment baseFragment) {
        Intrinsics.e(baseFragment, "baseFragment");
        this.d = baseFragment;
    }

    public final void setData(LiveGiftWallFloatModel liveGiftWallFloatModel) {
        boolean z = false;
        if (liveGiftWallFloatModel == null) {
            setShow(false);
            return;
        }
        BaseFragment baseFragment = this.d;
        ImageLoader.a(baseFragment == null ? null : baseFragment.getFragmentActive(), liveGiftWallFloatModel.getIcon()).a(this.e.b);
        this.e.d.setText(liveGiftWallFloatModel.getTitle());
        TextView textView = this.e.c;
        StringBuilder sb = new StringBuilder();
        sb.append(liveGiftWallFloatModel.getProgress());
        sb.append('/');
        sb.append(liveGiftWallFloatModel.getCount());
        textView.setText(sb.toString());
        if (liveGiftWallFloatModel.getCount() == 0) {
            this.e.e.setProgress(0);
        } else {
            this.e.e.setProgress(liveGiftWallFloatModel.getProgress() / liveGiftWallFloatModel.getCount());
        }
        if (liveGiftWallFloatModel.getShow() == 1) {
            z = true;
        }
        setShow(z);
    }

    public void setShow(boolean z) {
        this.b = z;
    }
}

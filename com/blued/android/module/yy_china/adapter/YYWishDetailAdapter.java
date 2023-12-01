package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYWishDetailAdapter.class */
public final class YYWishDetailAdapter extends BaseQuickAdapter<YYWishGoodsModel, BaseViewHolder> {
    private OnClickVoteListener a;
    private int b;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYWishDetailAdapter$OnClickVoteListener.class */
    public interface OnClickVoteListener {
        void a(YYWishGoodsModel yYWishGoodsModel);
    }

    public YYWishDetailAdapter() {
        super(R.layout.yy_item_wish_detail_layout, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYWishDetailAdapter this$0, YYWishGoodsModel it, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        OnClickVoteListener onClickVoteListener = this$0.a;
        if (onClickVoteListener == null) {
            return;
        }
        onClickVoteListener.a(it);
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(OnClickVoteListener listener) {
        Intrinsics.e(listener, "listener");
        this.a = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final YYWishGoodsModel yYWishGoodsModel) {
        ConstraintLayout view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.ll_wish_item);
        ProgressBar progressBar = baseViewHolder == null ? null : (ProgressBar) baseViewHolder.getView(R.id.wish_progress_bar);
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_wish_icon);
        TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_wish_name);
        TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_wish_count);
        TextView textView3 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_total_count);
        ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_finish);
        Intrinsics.a(baseViewHolder);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_give);
        if (this.b > 0) {
            ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
            layoutParams.width = this.b;
        }
        shapeTextView.setVisibility(YYRoomInfoManager.e().y() ? 8 : 0);
        if (yYWishGoodsModel == null) {
            return;
        }
        if (imageView2 != null) {
            int i = 8;
            if (yYWishGoodsModel.isCompleted()) {
                i = 0;
            }
            imageView2.setVisibility(i);
        }
        ImageLoader.a((IRequestHost) null, yYWishGoodsModel.images_static).a(imageView);
        if (textView != null) {
            textView.setText(yYWishGoodsModel.name);
        }
        if (textView2 != null) {
            textView2.setText(yYWishGoodsModel.wish_current);
        }
        if (textView3 != null) {
            textView3.setText(Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) yYWishGoodsModel.wish_total));
        }
        if (progressBar != null) {
            progressBar.setMax(StringUtils.a(yYWishGoodsModel.wish_total, 1));
        }
        if (progressBar != null) {
            progressBar.setProgress(StringUtils.a(yYWishGoodsModel.wish_current, 0));
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYWishDetailAdapter$uJdaFXCtpMhRFJrZLZBuIjEGYqA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYWishDetailAdapter.a(YYWishDetailAdapter.this, yYWishGoodsModel, view2);
            }
        });
    }
}

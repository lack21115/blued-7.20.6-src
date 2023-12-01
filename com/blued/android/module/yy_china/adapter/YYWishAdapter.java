package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYWishAdapter.class */
public class YYWishAdapter extends BaseQuickAdapter<YYWishGoodsModel, BaseViewHolder> {
    private OnAddOrDeleteGiftListener a;
    private int b;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYWishAdapter$OnAddOrDeleteGiftListener.class */
    public interface OnAddOrDeleteGiftListener {
        void a(int i);

        void b(int i);

        void c(int i);
    }

    public YYWishAdapter() {
        super(R.layout.yy_item_wish_layout, new ArrayList());
        this.b = 0;
    }

    public void a(OnAddOrDeleteGiftListener onAddOrDeleteGiftListener) {
        this.a = onAddOrDeleteGiftListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, YYWishGoodsModel yYWishGoodsModel) {
        ConstraintLayout view = baseViewHolder.getView(R.id.ll_wish_item);
        ProgressBar progressBar = (ProgressBar) baseViewHolder.getView(R.id.wish_progress_bar);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_wish_icon);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_fix_count);
        ConstraintLayout view2 = baseViewHolder.getView(R.id.rl_wish_view);
        ConstraintLayout view3 = baseViewHolder.getView(R.id.ll_add_view);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_wish_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_wish_count);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_total_count);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_delete_wish);
        if (this.b > 0) {
            view.getLayoutParams().width = this.b;
        }
        int i = 8;
        if (TextUtils.isEmpty(yYWishGoodsModel.goods_id)) {
            view3.setVisibility(0);
            view2.setVisibility(8);
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYWishAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    Tracker.onClick(view4);
                    if (YYWishAdapter.this.a != null) {
                        YYWishAdapter.this.a.a(baseViewHolder.getAdapterPosition());
                    }
                }
            });
            shapeTextView.setVisibility(0);
            shapeTextView.setEnabled(false);
            shapeTextView.setAlpha(0.45f);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_j);
            return;
        }
        view3.setVisibility(8);
        view2.setVisibility(0);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_b);
        shapeTextView.setEnabled(true);
        shapeTextView.setAlpha(1.0f);
        if (YYRoomInfoManager.e().y()) {
            i = 0;
        }
        shapeTextView.setVisibility(i);
        imageView2.setVisibility(yYWishGoodsModel.enableDelete ? 0 : 4);
        ImageLoader.a((IRequestHost) null, yYWishGoodsModel.images_static).a(imageView);
        textView.setText(yYWishGoodsModel.name);
        textView2.setText(yYWishGoodsModel.wish_current + "");
        textView3.setText(BridgeUtil.SPLIT_MARK + yYWishGoodsModel.wish_total);
        progressBar.setMax(StringUtils.a(yYWishGoodsModel.wish_total, 1));
        progressBar.setProgress(StringUtils.a(yYWishGoodsModel.wish_current, 0));
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYWishAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                Tracker.onClick(view4);
                if (YYWishAdapter.this.a != null) {
                    YYWishAdapter.this.a.c(baseViewHolder.getAdapterPosition());
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYWishAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                Tracker.onClick(view4);
                if (YYWishAdapter.this.a != null) {
                    YYWishAdapter.this.a.b(baseViewHolder.getAdapterPosition());
                }
            }
        });
    }
}

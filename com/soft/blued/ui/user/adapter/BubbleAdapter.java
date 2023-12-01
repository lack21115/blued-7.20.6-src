package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VipBubbleModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/BubbleAdapter.class */
public class BubbleAdapter extends BaseQuickAdapter<VipBubbleModel, BaseViewHolder> {
    public BubbleAdapter() {
        super((int) R.layout.item_vip_bubble);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VipBubbleModel vipBubbleModel) {
        View view = baseViewHolder.getView(2131369461);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = (AppInfo.l - DensityUtils.a(this.mContext, 36.0f)) / 3;
        int adapterPosition = baseViewHolder.getAdapterPosition();
        if (adapterPosition == 0 || adapterPosition == 1 || adapterPosition == 2) {
            layoutParams.topMargin = DensityUtils.a(this.mContext, 10.0f);
        } else {
            layoutParams.topMargin = DensityUtils.a(this.mContext, 0.0f);
        }
        view.setLayoutParams(layoutParams);
        ShapeTextView view2 = baseViewHolder.getView(2131371675);
        view2.setText(this.mContext.getString(vipBubbleModel.vip_status == 0 ? 2131886082 : 2131892675));
        View view3 = baseViewHolder.getView(R.id.iv_bg);
        GridLayoutManager.LayoutParams layoutParams2 = (GridLayoutManager.LayoutParams) view3.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.width;
        view3.setLayoutParams(layoutParams2);
        if (vipBubbleModel.selected == 1) {
            baseViewHolder.setVisible(R.id.iv_selected_bg, true);
            ShapeHelper.a(view2, 2131102478);
            ShapeHelper.b(view2, 2131101766);
        } else {
            baseViewHolder.setVisible(R.id.iv_selected_bg, false);
            ShapeHelper.a(view2, 2131101766);
            ShapeHelper.b(view2, 2131102478);
        }
        if (baseViewHolder.getAdapterPosition() == 0) {
            baseViewHolder.setImageResource(2131365518, R.drawable.bubble_front_cover_default);
        } else {
            ImageLoader.a((IRequestHost) null, vipBubbleModel.front_cover).a((ImageView) baseViewHolder.getView(2131365518));
        }
        baseViewHolder.setText(2131372046, vipBubbleModel.name);
        if (vipBubbleModel.is_termination != 1) {
            baseViewHolder.setVisible(R.id.tv_time_limit, false);
            baseViewHolder.setVisible(R.id.tv_time, false);
            return;
        }
        baseViewHolder.setVisible(R.id.tv_time_limit, true);
        baseViewHolder.setVisible(R.id.tv_time, true);
        String e = TimeAndDateUtils.e(vipBubbleModel.stop_time * 1000);
        baseViewHolder.setText(R.id.tv_time, this.mContext.getResources().getString(R.string.valid_time_period) + e);
    }
}

package com.blued.android.module.yy_china.adapter;

import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYRewardModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRewardAdapter.class */
public class YYRewardAdapter extends BaseQuickAdapter<YYRewardModel, BaseViewHolder> {
    public YYRewardAdapter() {
        super(R.layout.item_yy_reward_layout, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYRewardModel yYRewardModel) {
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_reward_background);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_reward_name);
        shapeTextView.setText(yYRewardModel.event_name);
        if (yYRewardModel.selected) {
            ShapeHelper.a(shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_b);
            return;
        }
        ShapeHelper.a(shapeFrameLayout, R.color.syc_272727, R.color.syc_272727);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_dark_j);
    }
}

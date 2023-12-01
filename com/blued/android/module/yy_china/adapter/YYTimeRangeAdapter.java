package com.blued.android.module.yy_china.adapter;

import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYTimeRangeAdapter.class */
public class YYTimeRangeAdapter extends BaseQuickAdapter<YYVoteTimeModel, BaseViewHolder> {
    public YYTimeRangeAdapter() {
        super(R.layout.item_vote_time_layout, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYVoteTimeModel yYVoteTimeModel) {
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_vote_time);
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_vote_time);
        shapeTextView.setText(yYVoteTimeModel.timeStr);
        if (yYVoteTimeModel.isCheck) {
            ShapeHelper.a(shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.white);
            return;
        }
        ShapeHelper.a(shapeFrameLayout, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_8d8d8e);
    }
}

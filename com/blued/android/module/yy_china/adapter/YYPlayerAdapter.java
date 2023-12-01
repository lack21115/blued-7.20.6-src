package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYPlayerAdapter.class */
public class YYPlayerAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {
    public YYPlayerAdapter() {
        super(R.layout.item_vote_user_layout, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_vote_header);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_vote);
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_vote_header);
        ImageLoader.a((IRequestHost) null, yYSeatMemberModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
        if (yYSeatMemberModel.isVoted) {
            imageView2.setVisibility(0);
            ShapeHelper.a(shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
            return;
        }
        imageView2.setVisibility(8);
        ShapeHelper.a(shapeFrameLayout, R.color.white, R.color.white);
    }
}

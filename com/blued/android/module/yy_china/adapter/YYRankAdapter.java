package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRankModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRankAdapter.class */
public class YYRankAdapter extends BaseMultiItemQuickAdapter<YYRankModel, BaseViewHolder> {
    private IRequestHost a;

    public YYRankAdapter(IRequestHost iRequestHost) {
        super(new ArrayList());
        addItemType(0, R.layout.item_yy_rank_layout);
        addItemType(1, R.layout.item_yy_rank_top_layout);
        this.a = iRequestHost;
    }

    private void a(YYRankModel yYRankModel, TextView textView, ImageView imageView) {
        textView.setText(YYRoomInfoManager.e().a(yYRankModel.uid, yYRankModel.name));
        YYRoomInfoManager.e().b(this.a, imageView, yYRankModel.uid, yYRankModel.avatar);
    }

    private void a(BaseViewHolder baseViewHolder, List<YYRankModel> list) {
        ConstraintLayout view = baseViewHolder.getView(R.id.ll_no1_view);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name_no1);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_wandou_no1);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_no_1);
        ConstraintLayout view2 = baseViewHolder.getView(R.id.ll_no2_view);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_name_no2);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.tv_wandou_no2);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_no_2);
        ConstraintLayout view3 = baseViewHolder.getView(R.id.ll_no3_view);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.tv_name_no3);
        TextView textView6 = (TextView) baseViewHolder.getView(R.id.tv_wandou_no3);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.iv_no_3);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            YYRankModel yYRankModel = list.get(i2);
            if (i2 == 0) {
                view.setVisibility(0);
                a(yYRankModel, textView, imageView);
                textView2.setText(yYRankModel.beans);
            } else if (i2 == 1) {
                view2.setVisibility(0);
                a(yYRankModel, textView3, imageView2);
                textView4.setText(yYRankModel.beans);
            } else if (i2 == 2) {
                view3.setVisibility(0);
                a(yYRankModel, textView5, imageView3);
                textView6.setText(yYRankModel.beans);
            }
            i = i2 + 1;
        }
    }

    private void b(BaseViewHolder baseViewHolder, YYRankModel yYRankModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_rank);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_wandou);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_nickname);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_header);
        textView.setText(String.valueOf(baseViewHolder.getAdapterPosition() + 4));
        textView3.setText(YYRoomInfoManager.e().a(yYRankModel.uid, yYRankModel.name));
        YYRoomInfoManager.e().b(this.a, imageView, yYRankModel.uid, yYRankModel.avatar);
        textView2.setText(yYRankModel.beans);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYRankModel yYRankModel) {
        if (yYRankModel.getItemType() != 1) {
            b(baseViewHolder, yYRankModel);
        } else {
            a(baseViewHolder, yYRankModel.topList);
        }
    }
}

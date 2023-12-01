package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYStepModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/StepAdapter.class */
public class StepAdapter extends BaseQuickAdapter<YYStepModel, BaseViewHolder> {
    public StepAdapter() {
        super(R.layout.item_yy_cp_step, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYStepModel yYStepModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.step_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.step_num);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.step_line);
        textView.setText(yYStepModel.name);
        textView2.setText(yYStepModel.stepIndex + "");
        if (yYStepModel.isChecked) {
            textView.setTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_00E0AB));
            textView2.setTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_00E0AB));
            textView2.setBackgroundResource(R.drawable.shape_ring_00e0ab);
            textView.setAlpha(1.0f);
            textView2.setAlpha(1.0f);
        } else {
            textView.setTextColor(BluedSkinUtils.a(this.mContext, R.color.white));
            textView2.setTextColor(BluedSkinUtils.a(this.mContext, R.color.white));
            textView2.setBackgroundResource(R.drawable.shape_ring_ffffff);
            textView.setAlpha(0.6f);
            textView2.setAlpha(0.6f);
        }
        if (baseViewHolder.getAdapterPosition() == getData().size() - 1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }
}

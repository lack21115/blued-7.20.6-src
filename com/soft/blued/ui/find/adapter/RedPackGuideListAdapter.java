package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RedPackGuideListAdapter.class */
public class RedPackGuideListAdapter extends BaseQuickAdapter<AppConfigModel.SignData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f16445a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private int f16446c;
    private String d;

    public RedPackGuideListAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_red_pack_guide, new ArrayList());
        this.f16445a = context;
        this.b = iRequestHost;
    }

    public void a(int i) {
        this.f16446c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final AppConfigModel.SignData signData) {
        Drawable b;
        String string = this.f16445a.getString(R.string.red_pack_days);
        baseViewHolder.setText(R.id.tv_days, String.format(string, (signData.dayIndex + 1) + ""));
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_receive_btn);
        int adapterPosition = baseViewHolder.getAdapterPosition();
        if (adapterPosition == this.f16446c) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(4);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.RedPackGuideListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (signData.dayIndex == RedPackGuideListAdapter.this.f16446c) {
                    WebViewShowInfoFragment.show(RedPackGuideListAdapter.this.f16445a, RedPackGuideListAdapter.this.d, 9);
                }
            }
        });
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_red_pack);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.iv_sign_progress);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.iv_sign_progress_left);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.iv_sign_progress_deep);
        TextView textView5 = (TextView) baseViewHolder.getView(R.id.iv_sign_progress_left_deep);
        if (adapterPosition >= this.f16446c) {
            textView2.setVisibility(0);
            textView4.setVisibility(8);
            if (this.f16446c == adapterPosition) {
                textView3.setVisibility(8);
                textView5.setVisibility(0);
            } else {
                textView5.setVisibility(8);
                textView3.setVisibility(0);
            }
        } else {
            textView4.setVisibility(0);
            textView5.setVisibility(0);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(2131363075);
        constraintLayout.setPadding(0, 0, 0, 0);
        if (adapterPosition == 29) {
            textView2.setVisibility(8);
            textView4.setVisibility(8);
            constraintLayout.setPadding(0, 0, DensityUtils.a(this.f16445a, 10.0f), 0);
        }
        if (adapterPosition == 0) {
            textView5.setVisibility(8);
            textView3.setVisibility(8);
            constraintLayout.setPadding(DensityUtils.a(this.f16445a, 10.0f), 0, 0, 0);
        }
        ShapeTextView view = baseViewHolder.getView(R.id.tv_tips_money);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.I = DensityUtils.a(this.f16445a, 8.0f);
        shapeModel.J = DensityUtils.a(this.f16445a, 8.0f);
        shapeModel.L = DensityUtils.a(this.f16445a, 8.0f);
        shapeModel.n = BluedSkinUtils.a(this.f16445a, 2131102360);
        shapeModel.b = ContextCompat.getColor(this.f16445a, 2131102170);
        shapeModel.q = DensityUtils.a(this.f16445a, 1.0f);
        if (adapterPosition < this.f16446c) {
            baseViewHolder.setGone(R.id.tv_tips_money, false);
            baseViewHolder.setGone(R.id.tv_money, true);
            imageView.setImageDrawable(this.f16445a.getDrawable(R.drawable.icon_red_pack_signed));
            baseViewHolder.setText(R.id.tv_money, "￥" + (Float.parseFloat(signData.money) + Float.parseFloat(signData.additionalReward)));
            return;
        }
        baseViewHolder.setGone(R.id.tv_money, false);
        baseViewHolder.setGone(R.id.tv_tips_money, true);
        if (Float.parseFloat(signData.additionalReward) > 0.0f) {
            shapeModel.k = BluedSkinUtils.a(this.f16445a, 2131102215);
            b = BluedSkinUtils.b(this.f16445a, (int) R.drawable.icon_no_sign_more_reward);
        } else {
            shapeModel.k = BluedSkinUtils.a(this.f16445a, 2131102222);
            b = BluedSkinUtils.b(this.f16445a, (int) R.drawable.icon_no_sign_reward);
        }
        view.setAlpha(0.6f);
        view.setShapeModel(shapeModel);
        if (adapterPosition == this.f16446c) {
            view.setAlpha(1.0f);
            b = Float.parseFloat(signData.additionalReward) > 0.0f ? BluedSkinUtils.b(this.f16445a, (int) R.drawable.icon_no_sign_more_reward_today) : BluedSkinUtils.b(this.f16445a, (int) R.drawable.icon_no_sign_reward_today);
        }
        imageView.setImageDrawable(b);
        baseViewHolder.setText(R.id.tv_tips_money, "￥" + (Float.parseFloat(signData.money) + Float.parseFloat(signData.additionalReward)));
    }

    public void a(String str) {
        this.d = str;
    }
}

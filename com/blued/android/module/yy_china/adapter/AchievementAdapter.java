package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.BluedGuideDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYShareAchievementModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/AchievementAdapter.class */
public final class AchievementAdapter extends BaseQuickAdapter<YYShareAchievementModel, BaseViewHolder> {
    public AchievementAdapter() {
        super(R.layout.item_share_achievement_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AchievementAdapter this$0, YYShareAchievementModel yYShareAchievementModel, ImageView imageView, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(yYShareAchievementModel == null ? null : yYShareAchievementModel.getDescription(), imageView);
    }

    private final void a(String str, View view) {
        Context mContext = this.mContext;
        Intrinsics.c(mContext, "mContext");
        BluedGuideDialog bluedGuideDialog = new BluedGuideDialog(mContext);
        BluedGuideDialog.GuideBuilder guideBuilder = new BluedGuideDialog.GuideBuilder();
        guideBuilder.b(1);
        guideBuilder.a(0);
        guideBuilder.a(20.0f);
        guideBuilder.c(R.drawable.icon_yy_arrow_down_black);
        guideBuilder.f(DensityUtils.a(this.mContext, 203.0f));
        guideBuilder.a(str);
        bluedGuideDialog.a(guideBuilder);
        bluedGuideDialog.showAsDropDown(view, -DensityUtils.a(this.mContext, 96.0f), -(bluedGuideDialog.a() + DensityUtils.a(this.mContext, 13.0f)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final YYShareAchievementModel yYShareAchievementModel) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_name);
        TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_value);
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_issues_icon);
        int a2 = DensityUtils.a(textView == null ? null : textView.getContext(), 22.0f);
        if (textView != null) {
            textView.setText(yYShareAchievementModel == null ? null : yYShareAchievementModel.getName());
        }
        if (textView2 != null) {
            textView2.setText(yYShareAchievementModel == null ? null : yYShareAchievementModel.getValue());
        }
        if (imageView != null) {
            imageView.setVisibility(yYShareAchievementModel != null && yYShareAchievementModel.getShowIcon() ? 0 : 8);
        }
        if (getData().size() <= 1) {
            ViewGroup.LayoutParams layoutParams2 = textView2 == null ? null : textView2.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ((ConstraintLayout.LayoutParams) layoutParams2).leftMargin = 0;
        }
        if (baseViewHolder == null) {
            layoutParams = null;
        } else {
            View view = baseViewHolder.itemView;
            layoutParams = view == null ? null : view.getLayoutParams();
        }
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
        RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) layoutParams;
        if (baseViewHolder.getAdapterPosition() > 1) {
            layoutParams3.topMargin = a2;
        } else {
            layoutParams3.topMargin = 0;
        }
        if (imageView == null) {
            return;
        }
        final ImageView imageView2 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$AchievementAdapter$MuXFHFgqv9eu8LRCNVbj8q-848I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AchievementAdapter.a(AchievementAdapter.this, yYShareAchievementModel, imageView2, view2);
            }
        });
    }
}

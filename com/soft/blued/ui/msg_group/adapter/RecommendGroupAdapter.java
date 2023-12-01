package com.soft.blued.ui.msg_group.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.BluedQuickAdapterExtKt;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/adapter/RecommendGroupAdapter.class */
public final class RecommendGroupAdapter extends BaseQuickAdapter<GroupInfoModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f18970a;
    private RecommendGroupFragment.RecommendType b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendGroupAdapter(IRequestHost iRequestHost) {
        super((int) R.layout.item_group_recommend);
        Intrinsics.e(iRequestHost, "requestHost");
        this.f18970a = iRequestHost;
        this.b = RecommendGroupFragment.RecommendType.RECOMMEND;
    }

    private final ShapeTextView a() {
        ShapeTextView shapeTextView = new ShapeTextView(this.mContext);
        shapeTextView.setTextColor(this.mContext.getResources().getColor(2131101625));
        shapeTextView.setTextSize(10.0f);
        shapeTextView.setPadding(DensityUtil.a(4.0f), 0, DensityUtil.a(4.0f), 0);
        shapeTextView.setHeight(DensityUtil.a(16.0f));
        shapeTextView.setGravity(17);
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.b = this.mContext.getResources().getColor(2131101625);
        shapeModel.k = BluedSkinUtils.a(this.mContext, 2131101796);
        shapeModel.H = DensityUtil.a(8.0f);
        shapeTextView.setShapeModel(shapeModel);
        return shapeTextView;
    }

    private final void a(BaseViewHolder baseViewHolder, FlowLayout flowLayout, GroupInfoModel groupInfoModel) {
        flowLayout.removeAllViews();
        if (groupInfoModel.type > 0) {
            View a2 = a();
            GroupUtil.a((ShapeTextView) a2, groupInfoModel, true);
            flowLayout.addView(a2);
        }
        View a3 = a();
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = AppInfo.d().getResources().getString(R.string.live_fans_info_num);
        Intrinsics.c(string, "getAppContext().resource…tring.live_fans_info_num)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(groupInfoModel.group_now_population)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        a3.setText(format);
        flowLayout.addView(a3);
        if (groupInfoModel.online > 9) {
            View a4 = a();
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_group_online);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            a4.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            a4.setCompoundDrawablePadding(DensityUtil.a(2.0f));
            a4.setText(groupInfoModel.online + this.mContext.getString(R.string.group_online_number));
            flowLayout.addView(a4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GroupInfoModel groupInfoModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(groupInfoModel, "item");
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_DRAW, groupInfoModel.label, this.b == RecommendGroupFragment.RecommendType.RECOMMEND ? SocialNetWorkProtos.SourceType.RECOMMEND : SocialNetWorkProtos.SourceType.NEARBY, String.valueOf(groupInfoModel.group_id));
        GroupUtil.b(this.f18970a, groupInfoModel.group_cover, (ImageView) baseViewHolder.getView(R.id.iv_header));
        GroupUtil.a((TextView) baseViewHolder.getView(R.id.tv_frozen), groupInfoModel.group_role, groupInfoModel.group_status);
        FlowLayout flowLayout = (FlowLayout) baseViewHolder.getView(2131363977);
        Intrinsics.c(flowLayout, "flowLayout");
        a(baseViewHolder, flowLayout, groupInfoModel);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_desc);
        if (flowLayout.getHeight() > 50) {
            textView.setMaxLines(1);
        } else {
            textView.setMaxLines(2);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (TextUtils.isEmpty(groupInfoModel.category_zh)) {
            baseViewHolder.setText(R.id.tv_desc, groupInfoModel.group_desc);
        } else {
            baseViewHolder.setText(R.id.tv_desc, groupInfoModel.category_zh + ' ' + ((Object) groupInfoModel.group_desc));
        }
        GroupUtil.a(groupInfoModel, (TextView) baseViewHolder.getView(R.id.tv_group_name));
        if (groupInfoModel.group_role != 0) {
            BluedQuickAdapterExtKt.b(baseViewHolder, (int) R.id.tv_add, 2131102264).setText(R.id.tv_add, this.mContext.getString(R.string.group_joined)).setTextColor(R.id.tv_add, ContextCompat.getColor(this.mContext, 2131099790));
        } else if (groupInfoModel.apply_status == 0) {
            BluedQuickAdapterExtKt.b(baseViewHolder, (int) R.id.tv_add, 2131101766).setText(R.id.tv_add, groupInfoModel.allow_join == 2 ? this.mContext.getString(R.string.group_apply) : this.mContext.getString(R.string.group_join)).setTextColor(R.id.tv_add, ContextCompat.getColor(this.mContext, 2131101766));
        } else {
            BluedQuickAdapterExtKt.b(baseViewHolder, (int) R.id.tv_add, 2131102264).setText(R.id.tv_add, groupInfoModel.apply_status == 1 ? this.mContext.getString(R.string.group_apply_sent) : this.mContext.getString(R.string.group_join_reject)).setTextColor(R.id.tv_add, ContextCompat.getColor(this.mContext, 2131102264));
        }
        baseViewHolder.addOnClickListener(R.id.tv_add).addOnClickListener(2131369459);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R.id.ll_label);
        if (groupInfoModel.label == null || groupInfoModel.label.size() <= 0) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        int size = groupInfoModel.label.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ShapeTextView shapeTextView = new ShapeTextView(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BluedViewExtKt.a(16));
            if (i2 != 0) {
                layoutParams.leftMargin = BluedViewExtKt.a(4);
            }
            shapeTextView.setLayoutParams(layoutParams);
            shapeTextView.setPadding(BluedViewExtKt.a(4), 0, BluedViewExtKt.a(4), 0);
            ShapeModel shapeModel = new ShapeModel();
            shapeModel.k = Color.parseColor(((GroupInfoModel.Label) groupInfoModel.label.get(i2)).color);
            shapeModel.H = BluedViewExtKt.a(8);
            shapeTextView.setShapeModel(shapeModel);
            shapeTextView.setText(((GroupInfoModel.Label) groupInfoModel.label.get(i2)).label);
            shapeTextView.setTextSize(10.0f);
            shapeTextView.setTextColor(ContextCompat.getColor(this.mContext, 2131102478));
            shapeTextView.setGravity(17);
            linearLayout.addView((View) shapeTextView);
            i = i2 + 1;
        }
    }

    public final void a(RecommendGroupFragment.RecommendType recommendType) {
        Intrinsics.e(recommendType, "<set-?>");
        this.b = recommendType;
    }
}

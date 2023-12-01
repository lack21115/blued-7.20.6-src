package com.soft.blued.ui.msg_group.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
    private final IRequestHost f32661a;
    private RecommendGroupFragment.RecommendType b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendGroupAdapter(IRequestHost requestHost) {
        super((int) R.layout.item_group_recommend);
        Intrinsics.e(requestHost, "requestHost");
        this.f32661a = requestHost;
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
            ShapeTextView a2 = a();
            GroupUtil.a(a2, groupInfoModel, true);
            flowLayout.addView(a2);
        }
        ShapeTextView a3 = a();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String string = AppInfo.d().getResources().getString(2131889484);
        Intrinsics.c(string, "getAppContext().resource…tring.live_fans_info_num)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(groupInfoModel.group_now_population)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        a3.setText(format);
        flowLayout.addView(a3);
        if (groupInfoModel.online > 9) {
            ShapeTextView a4 = a();
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_group_online);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            a4.setCompoundDrawables(drawable, null, null, null);
            a4.setCompoundDrawablePadding(DensityUtil.a(2.0f));
            a4.setText(groupInfoModel.online + this.mContext.getString(R.string.group_online_number));
            flowLayout.addView(a4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, GroupInfoModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_DRAW, item.label, this.b == RecommendGroupFragment.RecommendType.RECOMMEND ? SocialNetWorkProtos.SourceType.RECOMMEND : SocialNetWorkProtos.SourceType.NEARBY, String.valueOf(item.group_id));
        GroupUtil.b(this.f32661a, item.group_cover, (ImageView) helper.getView(2131365477));
        GroupUtil.a((TextView) helper.getView(R.id.tv_frozen), item.group_role, item.group_status);
        FlowLayout flowLayout = (FlowLayout) helper.getView(2131363977);
        Intrinsics.c(flowLayout, "flowLayout");
        a(helper, flowLayout, item);
        TextView textView = (TextView) helper.getView(2131371262);
        if (flowLayout.getHeight() > 50) {
            textView.setMaxLines(1);
        } else {
            textView.setMaxLines(2);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (TextUtils.isEmpty(item.category_zh)) {
            helper.setText(2131371262, item.group_desc);
        } else {
            helper.setText(2131371262, item.category_zh + ' ' + ((Object) item.group_desc));
        }
        GroupUtil.a(item, (TextView) helper.getView(R.id.tv_group_name));
        if (item.group_role != 0) {
            BluedQuickAdapterExtKt.b(helper, R.id.tv_add, 2131102264).setText(R.id.tv_add, this.mContext.getString(R.string.group_joined)).setTextColor(R.id.tv_add, ContextCompat.getColor(this.mContext, 2131099790));
        } else if (item.apply_status == 0) {
            BluedQuickAdapterExtKt.b(helper, R.id.tv_add, 2131101766).setText(R.id.tv_add, item.allow_join == 2 ? this.mContext.getString(R.string.group_apply) : this.mContext.getString(R.string.group_join)).setTextColor(R.id.tv_add, ContextCompat.getColor(this.mContext, 2131101766));
        } else {
            BluedQuickAdapterExtKt.b(helper, R.id.tv_add, 2131102264).setText(R.id.tv_add, item.apply_status == 1 ? this.mContext.getString(R.string.group_apply_sent) : this.mContext.getString(R.string.group_join_reject)).setTextColor(R.id.tv_add, ContextCompat.getColor(this.mContext, 2131102264));
        }
        helper.addOnClickListener(R.id.tv_add).addOnClickListener(2131369459);
        LinearLayout linearLayout = (LinearLayout) helper.getView(2131367955);
        if (item.label == null || item.label.size() <= 0) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        linearLayout.removeAllViews();
        int size = item.label.size();
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
            shapeModel.k = Color.parseColor(item.label.get(i2).color);
            shapeModel.H = BluedViewExtKt.a(8);
            shapeTextView.setShapeModel(shapeModel);
            shapeTextView.setText(item.label.get(i2).label);
            shapeTextView.setTextSize(10.0f);
            shapeTextView.setTextColor(ContextCompat.getColor(this.mContext, 2131102478));
            shapeTextView.setGravity(17);
            linearLayout.addView(shapeTextView);
            i = i2 + 1;
        }
    }

    public final void a(RecommendGroupFragment.RecommendType recommendType) {
        Intrinsics.e(recommendType, "<set-?>");
        this.b = recommendType;
    }
}

package com.blued.community.ui.circle.adapter;

import android.content.Context;
import android.text.TextPaint;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.extensions.BluedQuickAdapterExtKt;
import com.blued.community.R;
import com.blued.community.ui.circle.model.CircleTypeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/CircleTypeListAdapter.class */
public final class CircleTypeListAdapter extends BaseQuickAdapter<CircleTypeModel.DataBean, BaseViewHolder> {
    private final Context a;
    private final IRequestHost b;
    private int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleTypeListAdapter(Context context, IRequestHost fragmentActive) {
        super(R.layout.item_circle_type, (List) null);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = context;
        this.b = fragmentActive;
    }

    public final void a(int i) {
        notifyDataSetChanged();
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, CircleTypeModel.DataBean dataBean) {
        if (baseViewHolder == null || dataBean == null) {
            return;
        }
        int adapterPosition = baseViewHolder.getAdapterPosition() - getHeaderLayoutCount();
        baseViewHolder.setText(R.id.tv_circle_type, dataBean.name);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_circle_type);
        if (this.c == adapterPosition) {
            baseViewHolder.setGone(R.id.tv_select, true);
            textView.setTextColor(BluedSkinUtils.a(this.mContext, R.color.syc_h));
            textView.setTextSize(1, 15.0f);
            TextPaint paint = textView.getPaint();
            if (paint != null) {
                paint.setFakeBoldText(true);
            }
            BluedQuickAdapterExtKt.a(baseViewHolder, R.id.view_content, R.color.syc_b);
            BluedQuickAdapterExtKt.a(baseViewHolder, R.id.view_content, 0.0f);
            return;
        }
        baseViewHolder.setGone(R.id.tv_select, false);
        textView.setTextColor(this.a.getResources().getColor(R.color.syc_j));
        textView.setTextSize(1, 13.0f);
        TextPaint paint2 = textView.getPaint();
        if (paint2 != null) {
            paint2.setFakeBoldText(false);
        }
        BluedQuickAdapterExtKt.a(baseViewHolder, R.id.view_content, R.color.syc_x);
        int i = this.c;
        if (i == adapterPosition + 1) {
            BluedQuickAdapterExtKt.a(baseViewHolder, R.id.view_content, 0.0f, 0.0f, 0.0f, DensityUtils.a(this.mContext, 6.0f));
        } else if (i == adapterPosition - 1) {
            BluedQuickAdapterExtKt.a(baseViewHolder, R.id.view_content, 0.0f, DensityUtils.a(this.mContext, 6.0f), 0.0f, 0.0f);
        } else {
            BluedQuickAdapterExtKt.a(baseViewHolder, R.id.view_content, 0.0f);
        }
    }

    public final CircleTypeModel.DataBean b(int i) {
        if (getData().size() > i) {
            return (CircleTypeModel.DataBean) getData().get(i);
        }
        return null;
    }

    public final Context getContext() {
        return this.a;
    }
}

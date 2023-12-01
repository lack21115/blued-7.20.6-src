package com.blued.community.ui.send.adapter;

import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.extensions.BluedQuickAdapterExtKt;
import com.blued.community.R;
import com.blued.community.ui.send.model.EventAddPostTypeModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventAddPostTypeAdapter.class */
public final class EventAddPostTypeAdapter extends BaseQuickAdapter<EventAddPostTypeModel, BaseViewHolder> {
    private String a;

    public EventAddPostTypeAdapter() {
        super(R.layout.item_event_add_post_type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, EventAddPostTypeModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        if (item.isMore()) {
            BluedQuickAdapterExtKt.a(helper, R.id.ly_type, DensityUtils.a(this.mContext, 1.0f), 0.0f, 0.0f);
            BluedQuickAdapterExtKt.a(helper, R.id.ly_type, R.color.transparent);
            helper.setText(R.id.tv_name, R.string.event_more);
            helper.setTextColor(R.id.tv_name, BluedSkinUtils.a(this.mContext, R.color.syc_h));
            helper.setGone(R.id.iv_more, true);
            return;
        }
        BluedQuickAdapterExtKt.a(helper, R.id.ly_type, 0.0f, 0.0f, 0.0f);
        helper.setText(R.id.tv_name, item.getType_name());
        helper.setGone(R.id.iv_more, false);
        if (item.isSelect(this.a)) {
            BluedQuickAdapterExtKt.a(helper, R.id.ly_type, R.color.syc_event_post_select);
            helper.setTextColor(R.id.tv_name, BluedSkinUtils.a(this.mContext, R.color.syc_a));
            return;
        }
        BluedQuickAdapterExtKt.a(helper, R.id.ly_type, R.color.syc_x);
        helper.setTextColor(R.id.tv_name, BluedSkinUtils.a(this.mContext, R.color.syc_j));
    }

    public final void a(String str) {
        this.a = str;
        notifyDataSetChanged();
    }
}

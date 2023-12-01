package com.blued.community.ui.send.adapter;

import android.content.Context;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.gaode.PositionPOIModel;
import com.blued.community.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/SelectLocationAdapter.class */
public class SelectLocationAdapter extends BaseQuickAdapter<PositionPOIModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f19908a;

    public SelectLocationAdapter(Context context) {
        super(R.layout.item_feed_post_location);
        this.f19908a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, PositionPOIModel positionPOIModel) {
        baseViewHolder.setText(R.id.tvName, positionPOIModel.name);
        baseViewHolder.setText(R.id.tvLocation, positionPOIModel.address);
        if (positionPOIModel.mark_visible) {
            baseViewHolder.setVisible(R.id.ivSelect, true);
            baseViewHolder.setTextColor(R.id.tvName, BluedSkinUtils.a(this.f19908a, R.color.syc_a));
            baseViewHolder.setTextColor(R.id.tvLocation, BluedSkinUtils.a(this.f19908a, R.color.syc_a));
            return;
        }
        baseViewHolder.setVisible(R.id.ivSelect, false);
        baseViewHolder.setTextColor(R.id.tvName, BluedSkinUtils.a(this.f19908a, R.color.syc_h));
        baseViewHolder.setTextColor(R.id.tvLocation, BluedSkinUtils.a(this.f19908a, R.color.syc_i));
    }

    public boolean a() {
        for (PositionPOIModel positionPOIModel : this.mData) {
            if (positionPOIModel.mark_visible) {
                return true;
            }
        }
        return false;
    }
}

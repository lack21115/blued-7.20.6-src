package com.blued.community.ui.square.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.square.model.AttentionLiveRecommendData;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/adapter/AttentionRecommendLiveAdapter.class */
public class AttentionRecommendLiveAdapter extends BaseQuickAdapter<AttentionLiveRecommendData, BaseViewHolder> {
    private IRequestHost a;

    public AttentionRecommendLiveAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_attention_recommend);
        this.a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final AttentionLiveRecommendData attentionLiveRecommendData) {
        if (baseViewHolder == null || attentionLiveRecommendData == null) {
            return;
        }
        ImageLoader.a(this.a, attentionLiveRecommendData.pic_url).c().b(R.drawable.user_bg_round_border_white).a((ImageView) baseViewHolder.getView(R.id.header_view));
        baseViewHolder.getView(R.id.cl_root).setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.adapter.AttentionRecommendLiveAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommunityServiceManager.b().a(AttentionRecommendLiveAdapter.this.mContext, attentionLiveRecommendData, AttentionRecommendLiveAdapter.this.mData);
            }
        });
        baseViewHolder.setText(R.id.tv_name, attentionLiveRecommendData.title);
        if (attentionLiveRecommendData.isShowed) {
            return;
        }
        attentionLiveRecommendData.isShowed = true;
    }
}

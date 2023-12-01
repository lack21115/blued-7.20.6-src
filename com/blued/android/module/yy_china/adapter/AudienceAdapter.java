package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/AudienceAdapter.class */
public class AudienceAdapter extends BaseQuickAdapter<YYAudienceModel, BaseViewHolder> {
    private BaseYYStudioFragment a;
    private YYRoomModel b;

    public AudienceAdapter(Context context, BaseYYStudioFragment baseYYStudioFragment) {
        super(R.layout.item_audience_layout, new ArrayList());
        this.mContext = context;
        this.a = baseYYStudioFragment;
        this.b = YYRoomInfoManager.e().b();
        LiveEventBus.get("take_off_mask", String.class).observe(baseYYStudioFragment, new Observer<String>() { // from class: com.blued.android.module.yy_china.adapter.AudienceAdapter.1
            /* renamed from: a */
            public void onChanged(String str) {
                AudienceAdapter.this.notifyDataSetChanged();
            }
        });
    }

    private void a(YYAudienceModel yYAudienceModel, ImageView imageView, ImageView imageView2) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || !TextUtils.equals(yYRoomModel.chat_type, "11")) {
            ImageLoader.a(this.a.getFragmentActive(), yYAudienceModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
            imageView2.setVisibility(0);
        } else if (TextUtils.equals(YYRoomInfoManager.e().k(), yYAudienceModel.getUid()) || TextUtils.equals(yYAudienceModel.getUid(), this.b.uid) || this.b.isUnmasked(yYAudienceModel.getUid())) {
            ImageLoader.a(this.a.getFragmentActive(), yYAudienceModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
            ImageLoader.a(this.a.getFragmentActive(), R.drawable.icon_user_mask_without_text).b(R.drawable.user_bg_round).a(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYAudienceModel yYAudienceModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_audience_header);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_medal);
        View view = baseViewHolder.getView(R.id.cover_view);
        if (baseViewHolder.getAdapterPosition() == getData().size() - 1) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        if (yYAudienceModel.is_top_fans > 0) {
            imageView2.setVisibility(0);
            int adapterPosition = baseViewHolder.getAdapterPosition();
            if (adapterPosition == 0) {
                imageView2.setImageResource(R.drawable.icon_ring_gold);
            } else if (adapterPosition == 1) {
                imageView2.setImageResource(R.drawable.icon_ring_silver);
            }
        } else {
            imageView2.setVisibility(8);
        }
        a(yYAudienceModel, imageView, imageView2);
    }
}

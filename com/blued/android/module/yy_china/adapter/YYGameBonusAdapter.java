package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.IMemberClickListener;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYGameBonusAdapter.class */
public class YYGameBonusAdapter extends BaseQuickAdapter<YYGiftModel, BaseViewHolder> {
    private IMemberClickListener a;
    private IRequestHost b;

    public YYGameBonusAdapter(IRequestHost iRequestHost) {
        super(R.layout.item_yy_game_bonus_layout, new ArrayList());
        this.b = iRequestHost;
    }

    public void a(IMemberClickListener iMemberClickListener) {
        this.a = iMemberClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, YYGiftModel yYGiftModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_gift);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_gift_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_give);
        if (baseViewHolder.getAdapterPosition() == 0) {
            textView.setText("增加活力值");
        } else {
            textView.setText("减少活力值");
        }
        ImageLoader.a(this.b, yYGiftModel.images_static).b(R.drawable.gift_default_icon).a(imageView);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYGameBonusAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYGameBonusAdapter.this.a != null) {
                    YYGameBonusAdapter.this.a.a(baseViewHolder.getAdapterPosition());
                }
            }
        });
    }
}

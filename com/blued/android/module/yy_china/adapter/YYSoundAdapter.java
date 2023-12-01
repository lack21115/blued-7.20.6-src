package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYSoundModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSoundAdapter.class */
public class YYSoundAdapter extends BaseQuickAdapter<YYSoundModel, BaseViewHolder> {
    private IRequestHost a;

    public YYSoundAdapter(IRequestHost iRequestHost) {
        super(R.layout.item_yy_expression_layout);
        this.a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSoundModel yYSoundModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_image);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
        ImageLoader.a(this.a, yYSoundModel.pic).b(R.drawable.icon_finger_guessing).a(imageView);
        textView.setText(yYSoundModel.name);
    }
}

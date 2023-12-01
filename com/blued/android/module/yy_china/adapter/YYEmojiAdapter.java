package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYEmojiModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYEmojiAdapter.class */
public class YYEmojiAdapter extends BaseQuickAdapter<YYEmojiModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f16173a;

    public YYEmojiAdapter(IRequestHost iRequestHost) {
        super(R.layout.item_yy_expression_layout);
        this.f16173a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYEmojiModel yYEmojiModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_image);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_name);
        ImageLoader.a(this.f16173a, yYEmojiModel.pic).b(R.drawable.icon_finger_guessing).a(imageView);
        textView.setText(yYEmojiModel.name);
    }
}

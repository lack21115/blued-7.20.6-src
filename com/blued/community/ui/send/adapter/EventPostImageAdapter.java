package com.blued.community.ui.send.adapter;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/adapter/EventPostImageAdapter.class */
public class EventPostImageAdapter extends AddPostImageAdapter {
    public EventPostImageAdapter(IRequestHost iRequestHost, int i, boolean z) {
        super(iRequestHost, i, z);
    }

    @Override // com.blued.community.ui.send.adapter.AddPostImageAdapter
    public void a(BaseViewHolder baseViewHolder, ChildImageInfo childImageInfo, ImageView imageView) {
        if (childImageInfo.height > childImageInfo.width * 3) {
            ImageLoader.d(this.b, childImageInfo.mImagePath).b(R.drawable.feed_photo_default).a(true, 6.0f).a(imageView);
            baseViewHolder.setGone(R.id.stv_long_pic_icon, true);
            return;
        }
        ImageLoader.d(this.b, childImageInfo.mImagePath).b(R.drawable.feed_photo_default).a(true, 6.0f).a(imageView);
        baseViewHolder.setGone(R.id.stv_long_pic_icon, false);
    }
}

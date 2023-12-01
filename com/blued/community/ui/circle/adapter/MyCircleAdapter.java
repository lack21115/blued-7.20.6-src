package com.blued.community.ui.circle.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/adapter/MyCircleAdapter.class */
public class MyCircleAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f19134a;
    private IRequestHost b;

    public MyCircleAdapter(IRequestHost iRequestHost) {
        super(R.layout.item_my_new_base, null);
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, MyCircleModel myCircleModel) {
        if (baseViewHolder != null) {
            this.f19134a = (ImageView) baseViewHolder.getView(R.id.my_new_base_header);
            if (myCircleModel.isHotBase) {
                this.f19134a.setImageResource(R.drawable.hot_base_image);
            } else {
                ImageLoader.a(this.b, myCircleModel.cover).b(R.drawable.circle_header_default).a(this.f19134a);
            }
            if (!TextUtils.isEmpty(myCircleModel.circle_id) && !myCircleModel.isDraw) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_DRAW, myCircleModel.circle_id, FeedProtos.CircleSource.FIND_CIRCLE_MINE, myCircleModel.isJoin(), myCircleModel.allow_join == 0, myCircleModel.classify_id);
                myCircleModel.isDraw = true;
            }
            baseViewHolder.setText(R.id.my_new_base_name, myCircleModel.title);
            long c2 = TimeAndDateUtils.c(myCircleModel.last_update_time);
            if (c2 <= 0) {
                baseViewHolder.setText(R.id.tv_update_time, "");
                return;
            }
            int i = R.id.tv_update_time;
            baseViewHolder.setText(i, TimeAndDateUtils.c(this.mContext, c2) + this.mContext.getString(R.string.circle_update));
        }
    }
}

package com.blued.community.ui.event.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventRecommendAdapter.class */
public final class EventRecommendAdapter extends BaseQuickAdapter<EventDetailsModel, BaseViewHolder> {
    private final IRequestHost a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventRecommendAdapter(IRequestHost fragmentActive) {
        super(R.layout.item_event_recommend);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = fragmentActive;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, EventDetailsModel item) {
        String str;
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageLoader.a(this.a, item.pic).b(R.drawable.event_avatar_square).a((ImageView) helper.getView(R.id.iv_event_avatar));
        helper.setText(R.id.tv_event_name, item.name);
        helper.setText(R.id.tv_event_time, TimeAndDateUtils.c(TimeAndDateUtils.j(item.activity_date), true));
        ImageView imageView = (ImageView) helper.getView(R.id.iv_event_address);
        if (item.mode_id == 1) {
            imageView.setImageDrawable(BluedSkinUtils.b(this.mContext, R.drawable.icon_event_location_list));
            if (!TextUtils.isEmpty(item.city) && !TextUtils.isEmpty(item.location)) {
                str = item.city + (char) 183 + ((Object) item.location);
            } else if (!TextUtils.isEmpty(item.city)) {
                str = item.city;
                Intrinsics.c(str, "item.city");
            } else if (TextUtils.isEmpty(item.location)) {
                str = "";
            } else {
                str = item.location;
                Intrinsics.c(str, "item.location");
            }
            helper.setText(R.id.tv_event_address, str);
        } else {
            imageView.setImageDrawable(BluedSkinUtils.b(this.mContext, R.drawable.icon_online_event_address_list));
            helper.setText(R.id.tv_event_address, this.mContext.getString(R.string.event_online_event));
        }
        EventTrackFeed.b(FeedProtos.Event.ACTIVITY_DETAIL_SOMEONE_SHOW, item.id, helper.getAdapterPosition() + 1);
    }
}

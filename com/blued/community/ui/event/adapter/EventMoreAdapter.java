package com.blued.community.ui.event.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventMoreAdapter.class */
public final class EventMoreAdapter extends BaseQuickAdapter<EventDetailsModel, BaseViewHolder> {
    private final IRequestHost a;
    private int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventMoreAdapter(IRequestHost fragmentActive) {
        super(R.layout.item_event_more);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = fragmentActive;
        this.b = (int) ((AppInfo.l - (BluedViewExtKt.a(12.0f) * 4)) / 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, EventDetailsModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageView ivCover = (ImageView) helper.getView(R.id.iv_cover);
        Intrinsics.c(ivCover, "ivCover");
        ImageView imageView = ivCover;
        int i = this.b;
        BluedViewExtKt.a(imageView, i, i);
        ImageLoader.a(this.a, item.pic).b(R.drawable.defaultpicture).d(R.drawable.defaultpicture).a(4.0f).a(ivCover);
        helper.setGone(R.id.tv_event_tag, !TextUtils.isEmpty(item.recommend_text)).setText(R.id.tv_event_tag, item.recommend_text).setText(R.id.tv_event_name, item.name).addOnClickListener(R.id.iv_cover).addOnClickListener(R.id.tv_event_name);
        EventTrackFeed.b(FeedProtos.Event.ACTIVITY_FEED_DETAIL_SAME_ACTIVITY_SHOW, item.id, helper.getAdapterPosition() + 1);
    }
}

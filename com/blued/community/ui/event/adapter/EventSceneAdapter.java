package com.blued.community.ui.event.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventSceneAdapter.class */
public final class EventSceneAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f19520a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private EventDetailsModel f19521c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventSceneAdapter(IRequestHost fragmentActive, int i) {
        super(R.layout.item_add_post_image);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.f19520a = fragmentActive;
        this.b = i;
        this.f19521c = new EventDetailsModel();
    }

    public final void a(EventDetailsModel eventDetailsModel) {
        Intrinsics.e(eventDetailsModel, "<set-?>");
        this.f19521c = eventDetailsModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, String item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        View view = helper.getView(R.id.root_view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.b;
        layoutParams.width = this.b;
        view.setLayoutParams(layoutParams);
        helper.setGone(R.id.iv_image_delete, false);
        helper.setGone(R.id.img_add, false);
        ImageLoader.a(this.f19520a, item).a(6.0f).b(R.drawable.feed_photo_default).a((ImageView) helper.getView(R.id.img_image));
        EventTrackFeed.h(FeedProtos.Event.ACTIVITY_DETAIL_PHOTO_SHOW, this.f19521c.id, item);
    }
}

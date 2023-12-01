package com.blued.community.ui.send.fragment;

import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedPostSignStateFragment$createAdapter$1.class */
public final class FeedPostSignStateFragment$createAdapter$1 extends CommonAdapter<FeedPostSignStateItem> {
    final /* synthetic */ FeedPostSignStateFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedPostSignStateFragment$createAdapter$1(FeedPostSignStateFragment feedPostSignStateFragment, int i) {
        super(i);
        this.d = feedPostSignStateFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostSignStateFragment this$0, FeedPostSignStateItem model, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        this$0.b().notifyDataSetChanged();
        this$0.a(model);
        EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_STATUS_PAGE_ONE_CLICK, model.getBubble_state_id(), this$0.e(), EventTrackFeed.a());
        if (this$0.c()) {
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_EDIT_PAGE_SHOW, model.getBubble_state_id(), this$0.e(), EventTrackFeed.a());
        }
    }

    @Override // com.blued.android.module.common.adapter.CommonAdapter
    public void a(CommonAdapter.ViewHolder holder, final FeedPostSignStateItem model, int i) {
        int i2;
        Intrinsics.e(holder, "holder");
        Intrinsics.e(model, "model");
        ImageView imageView = (ImageView) holder.a(R.id.item_feed_post_sign_classify_iv);
        if (model.is_classify() == 1 && CommunityServiceManager.a().P()) {
            String classify_style = model.getClassify_style();
            if (classify_style != null) {
                ImageLoader.a(this.d.getFragmentActive(), classify_style).a(imageView);
            }
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        CommonAdapter.ViewHolder b = holder.a(R.id.item_feed_post_sign_state_iv, model.getIcon(), 40).a(R.id.item_feed_post_sign_state_tv, model.getName()).b(R.id.item_feed_post_sign_da_zi_iv, CommonStringUtils.a(model.getState_types()) == 1 ? 0 : 8);
        int i3 = R.id.item_feed_post_sign_state_iv_layout;
        String bubble_state_id = model.getBubble_state_id();
        FeedPostSignStateItem d = this.d.d();
        View a2 = b.c(i3, StringsKt.a((CharSequence) bubble_state_id, (CharSequence) (d == null ? null : d.getBubble_state_id())) ? CommunityManager.f19086a.a().s() ? R.drawable.item_feed_post_sign_state_iv_selected_black : R.drawable.item_feed_post_sign_state_iv_selected : CommunityManager.f19086a.a().s() ? R.drawable.item_feed_post_sign_state_iv_bg_black : R.drawable.item_feed_post_sign_state_iv_bg).a();
        final FeedPostSignStateFragment feedPostSignStateFragment = this.d;
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignStateFragment$createAdapter$1$iCPS3jxnMPaYneuWdwedGHcj7aI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostSignStateFragment$createAdapter$1.a(FeedPostSignStateFragment.this, model, view);
            }
        });
    }
}

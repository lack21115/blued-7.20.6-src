package com.soft.blued.ui.community.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/view/NearbyGuideDlgFragment$initRecycleView$2.class */
public final class NearbyGuideDlgFragment$initRecycleView$2 extends CommonMultiItemAdapter<FeedPostSignStateItem> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyGuideDlgFragment f16115a;
    private int d = FeedMethods.c(66);
    private int b = FeedMethods.a(12.0f);

    /* renamed from: c  reason: collision with root package name */
    private int f16116c = ((AppInfo.l - FeedMethods.c(24)) - this.d) / 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NearbyGuideDlgFragment$initRecycleView$2(NearbyGuideDlgFragment nearbyGuideDlgFragment) {
        this.f16115a = nearbyGuideDlgFragment;
        LogUtils.c("commonPadding:" + this.b + ", firstLeftPadding:" + this.f16116c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyGuideDlgFragment nearbyGuideDlgFragment, int i, FeedPostSignStateItem feedPostSignStateItem, View view) {
        RecyclerView recyclerView;
        Tracker.onClick(view);
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        Intrinsics.e(feedPostSignStateItem, "$model");
        recyclerView = nearbyGuideDlgFragment.k;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(i);
        }
        nearbyGuideDlgFragment.a(feedPostSignStateItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.community.view.CommonMultiItemAdapter
    /* renamed from: a */
    public void onConvert(CommonViewHolder commonViewHolder, final FeedPostSignStateItem feedPostSignStateItem, final int i) {
        FeedPostSignStateItem feedPostSignStateItem2;
        boolean z;
        Intrinsics.e(commonViewHolder, "holder");
        Intrinsics.e(feedPostSignStateItem, "model");
        View view = commonViewHolder.getView(R.id.item_feed_post_sign_state_content_layout);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i2 = this.b;
        int i3 = i == 0 ? this.f16116c : i2;
        if (i == getItemCount() - 1) {
            i2 = this.f16116c;
        }
        marginLayoutParams.width = this.d + i3 + i2;
        view.setLayoutParams(marginLayoutParams);
        view.setPadding(i3, 0, i2, 0);
        String bubble_state_id = feedPostSignStateItem.getBubble_state_id();
        feedPostSignStateItem2 = this.f16115a.D;
        CommonViewHolder colorText = commonViewHolder.setImageUrl(R.id.item_feed_post_sign_state_iv, feedPostSignStateItem.getIcon(), 33.0f, R.drawable.feed_photo_default).setColorText(R.id.item_feed_post_sign_state_tv, BluedSkinUtils.a(this.f16115a.getContext(), StringsKt.a(bubble_state_id, feedPostSignStateItem2 == null ? null : feedPostSignStateItem2.getBubble_state_id()) ? 2131102254 : 2131102264), feedPostSignStateItem.getName());
        z = this.f16115a.E;
        View view2 = colorText.setBackgroundRes(R.id.item_feed_post_sign_state_iv_layout, z ? 2131234339 : 2131234338).convertView;
        final NearbyGuideDlgFragment nearbyGuideDlgFragment = this.f16115a;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$initRecycleView$2$uD_u9NvfvfMDyuT85ZY5tTuO9Uw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                NearbyGuideDlgFragment$initRecycleView$2.a(NearbyGuideDlgFragment.this, i, feedPostSignStateItem, view3);
            }
        });
    }

    @Override // com.blued.community.view.CommonMultiItemAdapter
    public void onAddItemType() {
        addItemType(0, R.layout.item_nearby_guide_bubble_state);
    }
}

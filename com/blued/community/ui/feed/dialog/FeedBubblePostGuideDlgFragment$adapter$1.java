package com.blued.community.ui.feed.dialog;

import android.view.View;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubblePostGuideDlgFragment$adapter$1.class */
public final class FeedBubblePostGuideDlgFragment$adapter$1 extends CommonMultiItemAdapter<FeedPostSignStateItem> {
    final /* synthetic */ FeedBubblePostGuideDlgFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedBubblePostGuideDlgFragment$adapter$1(FeedBubblePostGuideDlgFragment feedBubblePostGuideDlgFragment) {
        this.a = feedBubblePostGuideDlgFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubblePostGuideDlgFragment this$0, FeedPostSignStateItem model, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        this$0.a(model);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void onConvert(CommonViewHolder holder, final FeedPostSignStateItem model, int i) {
        FeedPostSignStateItem feedPostSignStateItem;
        Intrinsics.e(holder, "holder");
        Intrinsics.e(model, "model");
        String bubble_state_id = model.getBubble_state_id();
        feedPostSignStateItem = this.a.d;
        boolean a = StringsKt.a((CharSequence) bubble_state_id, (CharSequence) (feedPostSignStateItem == null ? null : feedPostSignStateItem.getBubble_state_id()));
        View view = holder.setImageUrl(R.id.state_iv, model.getIcon(), 25.0f).setText(R.id.state_tv, model.getName()).setBackgroundRes(R.id.state_iv_layout, a ? R.drawable.item_feed_bubble_iv_selected : CommunityManager.a.a().s() ? R.drawable.item_feed_post_sign_state_iv_bg_black : R.drawable.item_feed_post_sign_state_iv_bg).setTextColor(R.id.state_tv, BluedSkinUtils.a(this.mContext, a ? R.color.syc_h : R.color.syc_k)).itemView;
        final FeedBubblePostGuideDlgFragment feedBubblePostGuideDlgFragment = this.a;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubblePostGuideDlgFragment$adapter$1$uxbp9aFa97CL68ZclaPtW_uug68
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedBubblePostGuideDlgFragment$adapter$1.a(FeedBubblePostGuideDlgFragment.this, model, view2);
            }
        });
    }

    public void onAddItemType() {
        addItemType(0, R.layout.item_feed_bubble_post_guide);
    }
}

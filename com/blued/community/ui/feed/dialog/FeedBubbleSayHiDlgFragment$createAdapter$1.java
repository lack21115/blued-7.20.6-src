package com.blued.community.ui.feed.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.community.R;
import com.blued.community.model.BubbleExhibitionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedBubbleSayHiDlgFragment$createAdapter$1.class */
public final class FeedBubbleSayHiDlgFragment$createAdapter$1 extends CommonRecycleAdapter<BubbleExhibitionModel> {
    final /* synthetic */ FeedBubbleSayHiDlgFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleSayHiDlgFragment$createAdapter$1(FeedBubbleSayHiDlgFragment feedBubbleSayHiDlgFragment, Context context) {
        super(context);
        this.a = feedBubbleSayHiDlgFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBubbleSayHiDlgFragment this$0, CommonRecycleAdapter.CommonAdapterHolder viewHolder, BubbleExhibitionModel item, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewHolder, "$viewHolder");
        Intrinsics.e(item, "$item");
        View a = viewHolder.a();
        Intrinsics.c(a, "viewHolder.convertView");
        this$0.a(a, item, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    /* renamed from: a */
    public void onBindViewHolderData(final BubbleExhibitionModel item, final int i, final CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
        Intrinsics.e(item, "item");
        Intrinsics.e(viewHolder, "viewHolder");
        ImageView imageView = (ImageView) viewHolder.a(R.id.item_feed_exhibition_iv);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = item.getRealWidth();
        imageView.setLayoutParams(marginLayoutParams);
        ImageLoader.a(this.a.j(), item.getImage()).a(imageView);
        View a = viewHolder.a();
        final FeedBubbleSayHiDlgFragment feedBubbleSayHiDlgFragment = this.a;
        a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedBubbleSayHiDlgFragment$createAdapter$1$oduHh109GOaQfu7Vbftpvld8h3Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedBubbleSayHiDlgFragment$createAdapter$1.a(FeedBubbleSayHiDlgFragment.this, viewHolder, item, i, view);
            }
        });
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return R.layout.item_feed_bubble_exhibition;
    }
}

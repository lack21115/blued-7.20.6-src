package com.blued.community.ui.feed.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.community.R;
import com.blued.community.ui.feed.model.FeedInteractItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedInteractPopWindow$createAdapter$1.class */
public final class FeedInteractPopWindow$createAdapter$1 extends CommonRecycleAdapter<FeedInteractItemModel> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedInteractPopWindow f19725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInteractPopWindow$createAdapter$1(FeedInteractPopWindow feedInteractPopWindow, Context context) {
        super(context);
        this.f19725a = feedInteractPopWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, FeedInteractPopWindow this$0, CommonRecycleAdapter.CommonAdapterHolder viewHolder, FeedInteractItemModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewHolder, "$viewHolder");
        Intrinsics.e(item, "$item");
        if (i != 0) {
            this$0.B = i;
        }
        CommonRecycleAdapter<FeedInteractItemModel> adapter = this$0.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        View a2 = viewHolder.a();
        Intrinsics.c(a2, "viewHolder.convertView");
        this$0.a(a2, item, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    /* renamed from: a */
    public void onBindViewHolderData(final FeedInteractItemModel item, final int i, final CommonRecycleAdapter.CommonAdapterHolder viewHolder) {
        int i2;
        int i3;
        Intrinsics.e(item, "item");
        Intrinsics.e(viewHolder, "viewHolder");
        ((LinearLayout) viewHolder.a(R.id.item_feed_interact_content_ly)).setPadding(0, 0, DisplayUtil.a(this.f19725a.getContext(), i != this.dataList.size() - 1 ? 9.0f : 0.0f), 0);
        CommonRecycleAdapter.CommonAdapterHolder a2 = viewHolder.a(R.id.item_feed_interact_tv, item.getName());
        int i4 = R.id.item_feed_interact_tv;
        Resources resources = this.f19725a.getResources();
        if (i == 0) {
            i3 = this.f19725a.getFeedData().iliked == 1 ? R.color.syc_g : R.color.syc_k;
        } else {
            i2 = this.f19725a.B;
            i3 = i2 == i ? R.color.syc_g : R.color.syc_k;
        }
        a2.a(i4, resources.getColor(i3));
        ImageView imageView = (ImageView) viewHolder.a(R.id.item_feed_interact_iv);
        ImageLoader.c(this.f19725a.getFragmentActive(), item.getDrawableRes()).e(imageView.hashCode()).g(-1).a(imageView);
        View a3 = viewHolder.a();
        final FeedInteractPopWindow feedInteractPopWindow = this.f19725a;
        a3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedInteractPopWindow$createAdapter$1$Ei8r6cgF3nhKQC_pY8xbqRCUVr8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedInteractPopWindow$createAdapter$1.a(i, feedInteractPopWindow, viewHolder, item, view);
            }
        });
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return R.layout.item_feed_interact_layout;
    }
}

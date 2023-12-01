package com.blued.community.ui.event.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/adapter/EventReviewPicsAdapter.class */
public final class EventReviewPicsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f19518a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f19519c;
    private int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventReviewPicsAdapter(IRequestHost fragmentActive) {
        super(R.layout.item_event_review_pic);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.f19518a = fragmentActive;
        this.f19519c = new ArrayList();
    }

    public final void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, String item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        View view = helper.getView(R.id.img_pic);
        Intrinsics.c(view, "helper.getView(R.id.img_pic)");
        ImageView imageView = (ImageView) view;
        ImageLoader.a(this.f19518a, item).b(R.drawable.user_bg_round).a(6.0f).a(imageView);
        if (this.d > 0) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = this.d;
            layoutParams.height = this.d;
            imageView.setLayoutParams(layoutParams);
        }
        helper.setGone(R.id.tv_more_count, this.b > 3 && helper.getAdapterPosition() == 2);
        helper.setText(R.id.tv_more_count, Intrinsics.a("+", (Object) Integer.valueOf(this.b - 3)));
    }

    public final void a(List<String> list) {
        Intrinsics.e(list, "<set-?>");
        this.f19519c = list;
    }

    public final void b(int i) {
        this.d = i;
    }
}

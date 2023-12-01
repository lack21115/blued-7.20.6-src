package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/PKLiveRecyclerAdapter.class */
public class PKLiveRecyclerAdapter extends BaseQuickAdapter<BluedLiveListData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f31103a;
    public List<BluedLiveListData> b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f31104c;

    public PKLiveRecyclerAdapter(Context context) {
        super(R.layout.item_pk_live_recycler_view, new ArrayList());
        this.b = new ArrayList();
        this.f31103a = context;
    }

    public void a(IRequestHost iRequestHost, List<BluedLiveListData> list) {
        this.f31104c = iRequestHost;
        this.b.clear();
        this.b.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        if (baseViewHolder != null) {
            FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(2131363859);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) frameLayout.getLayoutParams();
            if (baseViewHolder.getAdapterPosition() == 0) {
                layoutParams.leftMargin = DensityUtils.a(this.f31103a, 5.0f);
                frameLayout.setLayoutParams(layoutParams);
            } else {
                layoutParams.leftMargin = DensityUtils.a(this.f31103a, 0.0f);
                frameLayout.setLayoutParams(layoutParams);
            }
            if (bluedLiveListData.anchor != null) {
                ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_head);
                ImageLoader.a(this.f31104c, bluedLiveListData.anchor.avatar).b(2131237310).c().a(imageView);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.PKLiveRecyclerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        int i = bluedLiveListData.link_type;
                        UserRelationshipUtils.a(PKLiveRecyclerAdapter.this.f31103a, bluedLiveListData.anchor, StringUtils.a(bluedLiveListData.lid, 0L), "live_list_pk", LiveListDataUtils.a(PKLiveRecyclerAdapter.this.b));
                    }
                });
            }
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.img_live_frame);
            int i = bluedLiveListData.link_type;
            if (i == 1) {
                imageView2.setImageResource(R.drawable.live_pk_list_header_bg);
            } else if (i != 2) {
            } else {
                imageView2.setImageResource(R.drawable.frame_nearby_live_group);
            }
        }
    }
}

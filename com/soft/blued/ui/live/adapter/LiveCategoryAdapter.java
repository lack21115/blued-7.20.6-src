package com.soft.blued.ui.live.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.fragment.LiveFootPrintFragmentN;
import com.blued.android.module.live_china.model.LiveTabModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.live.fragment.LiveHomeFragment;
import com.soft.blued.ui.live.fragment.LiveListTabFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/adapter/LiveCategoryAdapter.class */
public class LiveCategoryAdapter extends BaseQuickAdapter<LiveTabModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private LiveHomeFragment f31060a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f31061c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private LoadOptions g;

    public LiveCategoryAdapter(LiveHomeFragment liveHomeFragment) {
        super(R.layout.live_category_item_view, null);
        this.f31060a = liveHomeFragment;
        this.b = liveHomeFragment.getContext();
        this.g = new LoadOptions();
        setNewData(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final LiveTabModel liveTabModel) {
        String str;
        if (baseViewHolder == null || liveTabModel == null) {
            return;
        }
        this.f31061c = (ImageView) baseViewHolder.getView(R.id.iv_category);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_category);
        this.d = textView;
        textView.setText(liveTabModel.name);
        this.e = (ImageView) baseViewHolder.getView(2131364507);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.img_more_dot);
        this.f = imageView;
        imageView.setVisibility(8);
        int i = 0;
        if (TextUtils.equals("15", liveTabModel.id)) {
            this.e.setVisibility(8);
            if (this.f31060a.e) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            str = this.f31060a.d ? liveTabModel.less_cate_icon : liveTabModel.more_cate_icon;
        } else {
            ImageView imageView2 = this.e;
            if (!liveTabModel.showNew) {
                i = 8;
            }
            imageView2.setVisibility(i);
            this.f.setVisibility(8);
            str = liveTabModel.icon;
        }
        ImageLoader.a(this.f31060a.getFragmentActive(), str).a(this.f31061c);
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.adapter.LiveCategoryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextUtils.equals("15", liveTabModel.id)) {
                    LiveCategoryAdapter.this.f31060a.e = false;
                    if (LiveCategoryAdapter.this.f31060a.d) {
                        LiveCategoryAdapter.this.f31060a.z();
                    } else {
                        LiveCategoryAdapter.this.f31060a.y();
                    }
                    LiveCategoryAdapter.this.f.setVisibility(8);
                } else if (CommonStringUtils.a(liveTabModel.id) == 18) {
                    LiveCategoryAdapter.this.f31060a.a(baseViewHolder.getLayoutPosition());
                    LiveCategoryAdapter.this.notifyDataSetChanged();
                    TerminalActivity.d(LiveCategoryAdapter.this.b, LiveFootPrintFragmentN.class, null);
                } else {
                    LiveCategoryAdapter.this.f31060a.a(baseViewHolder.getLayoutPosition());
                    LiveCategoryAdapter.this.notifyDataSetChanged();
                    LiveListTabFragment.a(LiveCategoryAdapter.this.b, liveTabModel.id, liveTabModel.name, liveTabModel.type);
                }
            }
        });
    }

    public void a(List<LiveTabModel> list) {
        setNewData(list);
    }
}

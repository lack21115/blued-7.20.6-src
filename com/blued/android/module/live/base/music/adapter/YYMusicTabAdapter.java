package com.blued.android.module.live.base.music.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.music.model.YYKtvMusicTypeModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/adapter/YYMusicTabAdapter.class */
public class YYMusicTabAdapter extends BaseQuickAdapter<YYKtvMusicTypeModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f11442a;
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private int f11443c;
    private Set<BaseViewHolder> d;
    private EventCallBack e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/adapter/YYMusicTabAdapter$EventCallBack.class */
    public interface EventCallBack {
        void onItemClick(int i);
    }

    public YYMusicTabAdapter(Context context, RecyclerView recyclerView) {
        super(R.layout.live_music_tab_view, new ArrayList());
        this.f11443c = 0;
        this.d = new HashSet();
        this.f11442a = context;
        this.b = recyclerView;
    }

    private void a() {
        for (BaseViewHolder baseViewHolder : this.d) {
            int layoutPosition = baseViewHolder.getLayoutPosition();
            if (getData() != null && layoutPosition < getData().size() && layoutPosition >= 0) {
                a(getData().get(layoutPosition), layoutPosition, baseViewHolder);
            }
        }
    }

    private void a(YYKtvMusicTypeModel yYKtvMusicTypeModel, int i, BaseViewHolder baseViewHolder) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tab);
        if (i != this.f11443c) {
            textView.setTextColor(this.f11442a.getResources().getColor(R.color.syc_dark_j));
            return;
        }
        textView.setTextColor(this.f11442a.getResources().getColor(R.color.syc_dark_b));
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int i2 = this.f11443c;
            int i3 = i2;
            if (findFirstVisibleItemPosition >= 0) {
                i3 = i2;
                if (findLastVisibleItemPosition >= 0) {
                    if (Math.abs(findLastVisibleItemPosition - i2) > Math.abs(findFirstVisibleItemPosition - this.f11443c)) {
                        i3 = findFirstVisibleItemPosition;
                        if (findFirstVisibleItemPosition >= 1) {
                            i3 = findFirstVisibleItemPosition - 1;
                        }
                    } else {
                        i3 = i2;
                        if (Math.abs(findLastVisibleItemPosition - this.f11443c) < Math.abs(findFirstVisibleItemPosition - this.f11443c)) {
                            i3 = findLastVisibleItemPosition;
                            if (findLastVisibleItemPosition < getData().size() - 1) {
                                i3 = findLastVisibleItemPosition + 1;
                            }
                        }
                    }
                }
            }
            this.b.smoothScrollToPosition(i3);
        }
    }

    public void a(int i) {
        if (this.f11443c == i) {
            return;
        }
        this.f11443c = i;
        this.b.smoothScrollToPosition(i);
        a();
    }

    public void a(EventCallBack eventCallBack) {
        this.e = eventCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYKtvMusicTypeModel yYKtvMusicTypeModel) {
        this.d.add(baseViewHolder);
        final int layoutPosition = baseViewHolder.getLayoutPosition();
        if (layoutPosition < 0) {
            return;
        }
        a(yYKtvMusicTypeModel, layoutPosition, baseViewHolder);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tab);
        textView.setText(yYKtvMusicTypeModel.sheetName);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.music.adapter.YYMusicTabAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYMusicTabAdapter.this.e != null) {
                    YYMusicTabAdapter.this.e.onItemClick(layoutPosition);
                }
            }
        });
    }

    public void a(List<YYKtvMusicTypeModel> list, int i) {
        this.f11443c = i;
        this.d.clear();
        setNewData(list);
        this.b.scrollToPosition(i);
    }
}

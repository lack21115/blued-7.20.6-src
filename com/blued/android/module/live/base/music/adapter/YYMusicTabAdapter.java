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
    protected Context a;
    private RecyclerView b;
    private int c;
    private Set<BaseViewHolder> d;
    private EventCallBack e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/adapter/YYMusicTabAdapter$EventCallBack.class */
    public interface EventCallBack {
        void onItemClick(int i);
    }

    public YYMusicTabAdapter(Context context, RecyclerView recyclerView) {
        super(R.layout.live_music_tab_view, new ArrayList());
        this.c = 0;
        this.d = new HashSet();
        this.a = context;
        this.b = recyclerView;
    }

    private void a() {
        for (BaseViewHolder baseViewHolder : this.d) {
            int layoutPosition = baseViewHolder.getLayoutPosition();
            if (getData() != null && layoutPosition < getData().size() && layoutPosition >= 0) {
                a((YYKtvMusicTypeModel) getData().get(layoutPosition), layoutPosition, baseViewHolder);
            }
        }
    }

    private void a(YYKtvMusicTypeModel yYKtvMusicTypeModel, int i, BaseViewHolder baseViewHolder) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_tab);
        if (i != this.c) {
            textView.setTextColor(this.a.getResources().getColor(R.color.syc_dark_j));
            return;
        }
        textView.setTextColor(this.a.getResources().getColor(R.color.syc_dark_b));
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            int i2 = this.c;
            int i3 = i2;
            if (findFirstVisibleItemPosition >= 0) {
                i3 = i2;
                if (findLastVisibleItemPosition >= 0) {
                    if (Math.abs(findLastVisibleItemPosition - i2) > Math.abs(findFirstVisibleItemPosition - this.c)) {
                        i3 = findFirstVisibleItemPosition;
                        if (findFirstVisibleItemPosition >= 1) {
                            i3 = findFirstVisibleItemPosition - 1;
                        }
                    } else {
                        i3 = i2;
                        if (Math.abs(findLastVisibleItemPosition - this.c) < Math.abs(findFirstVisibleItemPosition - this.c)) {
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
        if (this.c == i) {
            return;
        }
        this.c = i;
        this.b.smoothScrollToPosition(i);
        a();
    }

    public void a(EventCallBack eventCallBack) {
        this.e = eventCallBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        this.c = i;
        this.d.clear();
        setNewData(list);
        this.b.scrollToPosition(i);
    }
}

package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveActivityItemModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveActivityDotAdapter.class */
public class LiveActivityDotAdapter extends BaseMultiItemQuickAdapter<LiveActivityItemModel, BaseViewHolder> {
    protected Context a;
    int b;
    private RecyclerView c;
    private int d;
    private Set<BaseViewHolder> e;

    public LiveActivityDotAdapter(Context context, List<LiveActivityItemModel> list, RecyclerView recyclerView) {
        super(list);
        this.d = 0;
        this.e = new HashSet();
        this.b = -1;
        this.a = context;
        this.c = recyclerView;
        addItemType(0, R.layout.live_activity_dot_item);
        setNewData(list);
    }

    private void a(int i, BaseViewHolder baseViewHolder) {
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tab_indicator);
        ViewGroup.LayoutParams layoutParams = shapeTextView.getLayoutParams();
        ShapeModel shapeModel = new ShapeModel();
        if (this.d == i) {
            layoutParams.width = DensityUtils.a(this.a, 4.0f);
            layoutParams.height = DensityUtils.a(this.a, 4.0f);
            shapeModel.H = DensityUtils.a(this.a, 4.0f);
            shapeModel.k = ContextCompat.getColor(this.a, R.color.syc_dark_b);
        } else {
            if (getData() == null || getData().size() <= 4 || !(this.c.getLayoutManager() instanceof LinearLayoutManager)) {
                layoutParams.width = DensityUtils.a(this.a, 4.0f);
                layoutParams.height = DensityUtils.a(this.a, 4.0f);
                shapeModel.H = DensityUtils.a(this.a, 4.0f);
            } else {
                LinearLayoutManager layoutManager = this.c.getLayoutManager();
                int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (i == layoutManager.findFirstVisibleItemPosition()) {
                    layoutParams.width = DensityUtils.a(this.a, 3.0f);
                    layoutParams.height = DensityUtils.a(this.a, 3.0f);
                    shapeModel.H = DensityUtils.a(this.a, 3.0f);
                } else if (i == findLastVisibleItemPosition) {
                    layoutParams.width = DensityUtils.a(this.a, 3.0f);
                    layoutParams.height = DensityUtils.a(this.a, 3.0f);
                    shapeModel.H = DensityUtils.a(this.a, 3.0f);
                } else {
                    layoutParams.width = DensityUtils.a(this.a, 4.0f);
                    layoutParams.height = DensityUtils.a(this.a, 4.0f);
                    shapeModel.H = DensityUtils.a(this.a, 4.0f);
                }
            }
            shapeModel.k = ContextCompat.getColor(this.a, R.color.syc_afffffff);
            shapeTextView.clearAnimation();
        }
        shapeTextView.setLayoutParams(layoutParams);
        shapeTextView.setShapeModel(shapeModel);
    }

    private void a(LiveActivityItemModel liveActivityItemModel, int i, BaseViewHolder baseViewHolder) {
        a(i, baseViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        for (BaseViewHolder baseViewHolder : this.e) {
            int layoutPosition = baseViewHolder.getLayoutPosition();
            if (getData() != null && layoutPosition < getData().size() && layoutPosition >= 0) {
                a((LiveActivityItemModel) getData().get(layoutPosition), layoutPosition, baseViewHolder);
            }
        }
    }

    private void c() {
        int i;
        if (this.c != null) {
            int i2 = this.b;
            int i3 = this.d;
            if (i2 < i3) {
                i = i3 + 1;
            } else {
                i = i3;
                if (i2 > i3) {
                    i = i3 - 1;
                }
            }
            this.b = this.d;
            int i4 = i;
            if (i < 0) {
                i4 = 0;
            }
            int i5 = i4;
            if (i4 >= getData().size() - 1) {
                i5 = getData().size() - 1;
            }
            Log.i("==cpp", "currentPositon:" + this.d + "  toPosition:" + i5);
            this.c.smoothScrollToPosition(i5);
        }
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        if (this.d == i) {
            return;
        }
        this.d = i;
        c();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveActivityItemModel liveActivityItemModel) {
        this.e.add(baseViewHolder);
        int layoutPosition = baseViewHolder.getLayoutPosition();
        if (layoutPosition < 0) {
            return;
        }
        a(layoutPosition, baseViewHolder);
    }

    public void a(List<LiveActivityItemModel> list, int i) {
        if (list == null) {
            return;
        }
        this.d = i;
        this.e.clear();
        setNewData(list);
        this.c.scrollToPosition(i);
        this.c.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.adapter.LiveActivityDotAdapter.1
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    LiveActivityDotAdapter.this.b();
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        });
        this.c.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.adapter.LiveActivityDotAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                LiveActivityDotAdapter.this.b();
            }
        }, 300L);
    }
}

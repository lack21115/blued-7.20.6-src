package com.sobot.chat.widget.horizontalgridpage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.sobot.chat.R;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.widget.horizontalgridpage.PageBuilder;
import com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/HorizontalGridPage.class */
public class HorizontalGridPage extends LinearLayout {
    int currentIndex;
    PageGridView gridView;
    PageIndicatorView indicatorView;
    Context mContext;

    public HorizontalGridPage(Context context) {
        this(context, null);
    }

    public HorizontalGridPage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalGridPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    private int dip2px(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void init(PageBuilder pageBuilder, int i) {
        this.currentIndex = i;
        setOrientation(1);
        PageBuilder pageBuilder2 = pageBuilder;
        if (pageBuilder == null) {
            pageBuilder2 = new PageBuilder.Builder().build();
        }
        int[] grid = pageBuilder2.getGrid();
        this.gridView = new PageGridView(getContext(), grid, pageBuilder2.getSwipePercent(), pageBuilder2.getItemHeight());
        int dip2px = dip2px(6);
        int dip2px2 = dip2px(pageBuilder2.getIndicatorMargins()[0]);
        int dip2px3 = dip2px(pageBuilder2.getIndicatorMargins()[1]);
        int dip2px4 = dip2px(pageBuilder2.getIndicatorMargins()[2]);
        int dip2px5 = dip2px(pageBuilder2.getIndicatorMargins()[3]);
        int i2 = R.drawable.sobot_indicator_oval_normal_bg;
        int i3 = R.drawable.sobot_indicator_oval_focus_bg;
        PageIndicatorView pageIndicatorView = new PageIndicatorView(getContext(), dip2px, new int[]{dip2px2, dip2px3, dip2px4, dip2px5}, new int[]{i2, i3}, pageBuilder2.getIndicatorGravity());
        this.indicatorView = pageIndicatorView;
        pageIndicatorView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.indicatorView.initIndicator(grid[1]);
        this.gridView.setIndicator(this.indicatorView);
        this.gridView.addItemDecoration(new SpaceItemDecoration(0, dip2px(pageBuilder2.getSpace())));
        PagerGridLayoutManager pagerGridLayoutManager = new PagerGridLayoutManager(grid[0], grid[1], 1);
        pagerGridLayoutManager.setAllowContinuousScroll(false);
        this.gridView.setLayoutManager(pagerGridLayoutManager);
        addView(this.gridView);
        if (pageBuilder2.isShowIndicator()) {
            addView(this.indicatorView);
        } else {
            removeView(this.indicatorView);
        }
    }

    public boolean isFirstPage() {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            return pageGridView.getLayoutManager().isFirstPage();
        }
        return false;
    }

    public boolean isLastPage() {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            return pageGridView.getLayoutManager().isLastPage();
        }
        return false;
    }

    public void selectCurrentItem() {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            pageGridView.setSelectItem(this.currentIndex);
        }
    }

    public void selectLastPage() {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            pageGridView.getLayoutManager().nextPage();
        }
    }

    public void selectPreviousPage() {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            pageGridView.getLayoutManager().prePage();
        }
    }

    public void setAdapter(PageGridAdapter pageGridAdapter, ZhiChiMessageBase zhiChiMessageBase) {
        new PagerGridSnapHelper().attachToRecyclerView(this.gridView);
        this.gridView.setAdapter(pageGridAdapter);
        this.indicatorView.setMessage(zhiChiMessageBase);
    }

    public void setPageListener(PagerGridLayoutManager.PageListener pageListener) {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            pageGridView.getLayoutManager().setPageListener(pageListener);
        }
    }

    public void setSelectItem(int i) {
        PageGridView pageGridView = this.gridView;
        if (pageGridView != null) {
            pageGridView.setSelectItem(i);
        }
    }
}

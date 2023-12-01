package com.sobot.chat.widget.horizontalgridpage;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PageGridView.class */
public class PageGridView extends RecyclerView {
    private PageGridAdapter adapter;
    private int column;
    private int currentPage;
    private int itemHeight;
    private PagerGridLayoutManager layoutManager;
    private PageIndicatorView pageIndicatorView;
    private int row;
    private int scrollStatus;
    private float scrollX;
    private float swipeDistance;
    private int swipePercent;
    private int totalPage;
    private int validDistance;

    public PageGridView(Context context, int[] iArr, int i, int i2) {
        super(context);
        this.swipeDistance = 0.0f;
        this.currentPage = 1;
        this.scrollX = 0.0f;
        this.scrollStatus = 0;
        this.row = iArr[0];
        this.column = iArr[1];
        this.swipePercent = i;
        this.itemHeight = i2;
        setOverScrollMode(2);
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public PagerGridLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, this.itemHeight * this.row);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (this.adapter != null) {
            update();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.adapter = (PageGridAdapter) adapter;
        this.layoutManager.setPageListener(new PagerGridLayoutManager.PageListener() { // from class: com.sobot.chat.widget.horizontalgridpage.PageGridView.1
            @Override // com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager.PageListener
            public void onPageSelect(int i) {
                if (PageGridView.this.layoutManager.getChildCount() != 0) {
                    PageGridView.this.pageIndicatorView.update(i);
                }
            }

            @Override // com.sobot.chat.widget.horizontalgridpage.PagerGridLayoutManager.PageListener
            public void onPageSizeChanged(int i) {
            }
        });
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setIndicator(PageIndicatorView pageIndicatorView) {
        this.pageIndicatorView = pageIndicatorView;
    }

    public void setLayoutManager(PagerGridLayoutManager pagerGridLayoutManager) {
        this.layoutManager = pagerGridLayoutManager;
        super.setLayoutManager((RecyclerView.LayoutManager) pagerGridLayoutManager);
    }

    public void setSelectItem(final int i) {
        postDelayed(new Runnable() { // from class: com.sobot.chat.widget.horizontalgridpage.PageGridView.2
            @Override // java.lang.Runnable
            public void run() {
                PageGridView.this.currentPage = i + 1;
                PageGridView.this.pageIndicatorView.update(i);
                PageGridView.this.layoutManager.scrollToPage(i);
            }
        }, 100L);
    }

    public void update() {
        int ceil = (int) Math.ceil(this.adapter.getData().size() / (this.row * this.column));
        if (ceil != this.totalPage) {
            this.pageIndicatorView.initIndicator(ceil);
            int i = this.totalPage;
            if (ceil < i && this.currentPage == i) {
                this.currentPage = ceil;
            }
            this.pageIndicatorView.update(this.currentPage - 1);
            this.totalPage = ceil;
        }
        if (this.totalPage > 1) {
            this.pageIndicatorView.setVisibility(0);
        } else {
            this.pageIndicatorView.setVisibility(8);
        }
    }
}

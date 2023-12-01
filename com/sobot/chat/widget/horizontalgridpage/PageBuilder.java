package com.sobot.chat.widget.horizontalgridpage;

import android.R;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PageBuilder.class */
public class PageBuilder {
    private int[] grid;
    private int indicatorGravity;
    private int[] indicatorMargins;
    private int[] indicatorRes;
    private int indicatorSize;
    private int itemHeight;
    private int pageMargin;
    private boolean showIndicator;
    private int space;
    private int swipePercent;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PageBuilder$Builder.class */
    public static class Builder {
        private int indicatorSize = 10;
        private int[] indicatorMargins = {5, 5, 5, 5};
        private int[] indicatorRes = {R.drawable.presence_invisible, R.drawable.presence_online};
        private int indicatorGravity = 17;
        private int pageMargin = 0;
        private int[] grid = {3, 4};
        private int swipePercent = 50;
        private boolean showIndicator = true;
        private int space = 10;
        private int itemHeight = 50;

        public PageBuilder build() {
            return new PageBuilder(this);
        }

        public Builder setGrid(int i, int i2) {
            int[] iArr = this.grid;
            iArr[0] = i;
            iArr[1] = i2;
            return this;
        }

        public Builder setIndicatorGravity(int i) {
            this.indicatorGravity = i;
            return this;
        }

        public Builder setIndicatorMargins(int i, int i2, int i3, int i4) {
            int[] iArr = this.indicatorMargins;
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = i3;
            iArr[3] = i4;
            return this;
        }

        public Builder setIndicatorRes(int i, int i2) {
            int[] iArr = this.indicatorRes;
            iArr[0] = i;
            iArr[1] = i2;
            return this;
        }

        public Builder setIndicatorSize(int i) {
            this.indicatorSize = i;
            return this;
        }

        public Builder setItemHeight(int i) {
            this.itemHeight = i;
            return this;
        }

        public Builder setPageMargin(int i) {
            this.pageMargin = i;
            return this;
        }

        public Builder setShowIndicator(boolean z) {
            this.showIndicator = z;
            return this;
        }

        public Builder setSpace(int i) {
            this.space = i;
            return this;
        }

        public Builder setSwipePercent(int i) {
            this.swipePercent = i;
            return this;
        }
    }

    private PageBuilder(Builder builder) {
        this.indicatorSize = builder.indicatorSize;
        this.indicatorMargins = builder.indicatorMargins;
        this.indicatorRes = builder.indicatorRes;
        this.indicatorGravity = builder.indicatorGravity;
        this.pageMargin = builder.pageMargin;
        this.grid = builder.grid;
        this.swipePercent = builder.swipePercent;
        this.showIndicator = builder.showIndicator;
        this.space = builder.space;
        this.itemHeight = builder.itemHeight;
    }

    public int[] getGrid() {
        return this.grid;
    }

    public int getIndicatorGravity() {
        return this.indicatorGravity;
    }

    public int[] getIndicatorMargins() {
        return this.indicatorMargins;
    }

    public int[] getIndicatorRes() {
        return this.indicatorRes;
    }

    public int getIndicatorSize() {
        return this.indicatorSize;
    }

    public int getItemHeight() {
        return this.itemHeight;
    }

    public int getPageMargin() {
        return this.pageMargin;
    }

    public int getSpace() {
        return this.space;
    }

    public int getSwipePercent() {
        return this.swipePercent;
    }

    public boolean isShowIndicator() {
        return this.showIndicator;
    }
}

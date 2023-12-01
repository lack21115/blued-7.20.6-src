package com.sobot.chat.widget.kpswitch.widget.data;

import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/PlusPageSetEntity.class */
public class PlusPageSetEntity<T> extends PageSetEntity<EmoticonPageEntity> {
    final List<T> mDataList;
    final int mLine;
    final int mRow;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/PlusPageSetEntity$Builder.class */
    public static class Builder<T> extends PageSetEntity.Builder {
        protected List<T> dataList;
        protected int line;
        protected PageViewInstantiateListener pageViewInstantiateListener;
        protected int row;

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public PlusPageSetEntity<T> build() {
            int size = this.dataList.size();
            int i = this.row * this.line;
            this.pageCount = (int) Math.ceil(this.dataList.size() / i);
            int i2 = i > size ? size : i;
            if (!this.pageEntityList.isEmpty()) {
                this.pageEntityList.clear();
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < this.pageCount) {
                PlusPageEntity plusPageEntity = new PlusPageEntity();
                plusPageEntity.setLine(this.line);
                plusPageEntity.setRow(this.row);
                plusPageEntity.setDataList(this.dataList.subList(i4, i2));
                plusPageEntity.setIPageViewInstantiateItem(this.pageViewInstantiateListener);
                this.pageEntityList.add(plusPageEntity);
                int i5 = i + (i3 * i);
                int i6 = i3 + 1;
                int i7 = (i6 * i) + i;
                i2 = i7;
                i3 = i6;
                i4 = i5;
                if (i7 >= size) {
                    i2 = size;
                    i3 = i6;
                    i4 = i5;
                }
            }
            return new PlusPageSetEntity<>(this);
        }

        public Builder setDataList(List<T> list) {
            this.dataList = list;
            return this;
        }

        public Builder setIPageViewInstantiateItem(PageViewInstantiateListener pageViewInstantiateListener) {
            this.pageViewInstantiateListener = pageViewInstantiateListener;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setIconUri(int i) {
            this.iconUri = "" + i;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setIconUri(String str) {
            this.iconUri = str;
            return this;
        }

        public Builder setLine(int i) {
            this.line = i;
            return this;
        }

        public Builder setRow(int i) {
            this.row = i;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setSetName(String str) {
            this.setName = str;
            return this;
        }

        @Override // com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity.Builder
        public Builder setShowIndicator(boolean z) {
            this.isShowIndicator = z;
            return this;
        }
    }

    public PlusPageSetEntity(Builder builder) {
        super(builder);
        this.mLine = builder.line;
        this.mRow = builder.row;
        this.mDataList = builder.dataList;
    }

    public List<T> getDataList() {
        return this.mDataList;
    }

    public int getLine() {
        return this.mLine;
    }

    public int getRow() {
        return this.mRow;
    }
}

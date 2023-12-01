package com.sobot.chat.widget.kpswitch.widget.data;

import com.sobot.chat.widget.kpswitch.widget.data.PageEntity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/PageSetEntity.class */
public class PageSetEntity<T extends PageEntity> implements Serializable {
    protected final String mIconUri;
    protected final boolean mIsShowIndicator;
    protected final int mPageCount;
    protected final LinkedList<T> mPageEntityList;
    protected final String mSetName;
    protected final String uuid = UUID.randomUUID().toString();

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/PageSetEntity$Builder.class */
    public static class Builder<T extends PageEntity> {
        protected String iconUri;
        protected int pageCount;
        protected String setName;
        protected boolean isShowIndicator = true;
        protected LinkedList<T> pageEntityList = new LinkedList<>();

        public Builder addPageEntity(T t) {
            this.pageEntityList.add(t);
            return this;
        }

        public PageSetEntity<T> build() {
            return new PageSetEntity<>(this);
        }

        public Builder setIconUri(int i) {
            this.iconUri = "" + i;
            return this;
        }

        public Builder setIconUri(String str) {
            this.iconUri = str;
            return this;
        }

        public Builder setPageCount(int i) {
            this.pageCount = i;
            return this;
        }

        public Builder setPageEntityList(LinkedList<T> linkedList) {
            this.pageEntityList = linkedList;
            return this;
        }

        public Builder setSetName(String str) {
            this.setName = str;
            return this;
        }

        public Builder setShowIndicator(boolean z) {
            this.isShowIndicator = z;
            return this;
        }
    }

    public PageSetEntity(Builder builder) {
        this.mPageCount = builder.pageCount;
        this.mIsShowIndicator = builder.isShowIndicator;
        this.mPageEntityList = builder.pageEntityList;
        this.mIconUri = builder.iconUri;
        this.mSetName = builder.setName;
    }

    public String getIconUri() {
        return this.mIconUri;
    }

    public int getPageCount() {
        LinkedList<T> linkedList = this.mPageEntityList;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    public LinkedList<T> getPageEntityList() {
        return this.mPageEntityList;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isShowIndicator() {
        return this.mIsShowIndicator;
    }
}

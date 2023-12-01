package com.sobot.chat.widget.kpswitch.widget.data;

import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonPageView;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/EmoticonPageEntity.class */
public class EmoticonPageEntity<T> extends PageEntity<EmoticonPageEntity> {
    private DelBtnStatus mDelBtnStatus;
    private List<T> mEmoticonList;
    private int mLine;
    private int mRow;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/EmoticonPageEntity$DelBtnStatus.class */
    public enum DelBtnStatus {
        GONE,
        FOLLOW,
        LAST;

        public boolean isShow() {
            return !GONE.toString().equals(toString());
        }
    }

    public DelBtnStatus getDelBtnStatus() {
        return this.mDelBtnStatus;
    }

    public List<T> getEmoticonList() {
        return this.mEmoticonList;
    }

    public int getLine() {
        return this.mLine;
    }

    public int getRow() {
        return this.mRow;
    }

    @Override // com.sobot.chat.widget.kpswitch.widget.data.PageEntity, com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener
    public View instantiateItem(ViewGroup viewGroup, int i, EmoticonPageEntity emoticonPageEntity) {
        if (this.mPageViewInstantiateListener != null) {
            return this.mPageViewInstantiateListener.instantiateItem(viewGroup, i, this);
        }
        if (getRootView() == null) {
            EmoticonPageView emoticonPageView = new EmoticonPageView(viewGroup.getContext());
            emoticonPageView.setNumColumns(this.mRow);
            setRootView(emoticonPageView);
        }
        return getRootView();
    }

    public void setDelBtnStatus(DelBtnStatus delBtnStatus) {
        this.mDelBtnStatus = delBtnStatus;
    }

    public void setEmoticonList(List<T> list) {
        this.mEmoticonList = list;
    }

    public void setLine(int i) {
        this.mLine = i;
    }

    public void setRow(int i) {
        this.mRow = i;
    }
}

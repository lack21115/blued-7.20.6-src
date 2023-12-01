package com.sobot.chat.widget.kpswitch.widget.data;

import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.view.plus.SobotPlusPageView;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/PlusPageEntity.class */
public class PlusPageEntity<T> extends PageEntity<PlusPageEntity> {
    private List<T> mDataList;
    private int mLine;
    private int mRow;

    public List<T> getDataList() {
        return this.mDataList;
    }

    public int getLine() {
        return this.mLine;
    }

    public int getRow() {
        return this.mRow;
    }

    @Override // com.sobot.chat.widget.kpswitch.widget.data.PageEntity, com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener
    public View instantiateItem(ViewGroup viewGroup, int i, PlusPageEntity plusPageEntity) {
        if (this.mPageViewInstantiateListener != null) {
            return this.mPageViewInstantiateListener.instantiateItem(viewGroup, i, this);
        }
        if (getRootView() == null) {
            SobotPlusPageView sobotPlusPageView = new SobotPlusPageView(viewGroup.getContext());
            sobotPlusPageView.setNumColumns(this.mRow);
            setRootView(sobotPlusPageView);
        }
        return getRootView();
    }

    public void setDataList(List<T> list) {
        this.mDataList = list;
    }

    public void setLine(int i) {
        this.mLine = i;
    }

    public void setRow(int i) {
        this.mRow = i;
    }
}

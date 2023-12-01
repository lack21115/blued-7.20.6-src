package com.sobot.chat.widget.kpswitch.widget.data;

import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.widget.data.PageEntity;
import com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/data/PageEntity.class */
public class PageEntity<T extends PageEntity> implements PageViewInstantiateListener<T> {
    protected PageViewInstantiateListener mPageViewInstantiateListener;
    protected View mRootView;

    public PageEntity() {
    }

    public PageEntity(View view) {
        this.mRootView = view;
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // com.sobot.chat.widget.kpswitch.widget.interfaces.PageViewInstantiateListener
    public View instantiateItem(ViewGroup viewGroup, int i, T t) {
        PageViewInstantiateListener pageViewInstantiateListener = this.mPageViewInstantiateListener;
        return pageViewInstantiateListener != null ? pageViewInstantiateListener.instantiateItem(viewGroup, i, this) : getRootView();
    }

    public void setIPageViewInstantiateItem(PageViewInstantiateListener pageViewInstantiateListener) {
        this.mPageViewInstantiateListener = pageViewInstantiateListener;
    }

    public void setRootView(View view) {
        this.mRootView = view;
    }
}

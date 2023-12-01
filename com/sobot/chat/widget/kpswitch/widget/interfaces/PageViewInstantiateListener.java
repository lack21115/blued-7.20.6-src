package com.sobot.chat.widget.kpswitch.widget.interfaces;

import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.widget.data.PageEntity;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/interfaces/PageViewInstantiateListener.class */
public interface PageViewInstantiateListener<T extends PageEntity> {
    View instantiateItem(ViewGroup viewGroup, int i, T t);
}

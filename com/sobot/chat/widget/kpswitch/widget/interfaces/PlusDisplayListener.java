package com.sobot.chat.widget.kpswitch.widget.interfaces;

import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.widget.adpater.PlusAdapter;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/interfaces/PlusDisplayListener.class */
public interface PlusDisplayListener<T> {
    void onBindView(int i, ViewGroup viewGroup, PlusAdapter.ViewHolder viewHolder, T t);
}

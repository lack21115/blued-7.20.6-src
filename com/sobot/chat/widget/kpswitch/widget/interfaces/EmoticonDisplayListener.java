package com.sobot.chat.widget.kpswitch.widget.interfaces;

import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.widget.adpater.EmoticonsAdapter;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/interfaces/EmoticonDisplayListener.class */
public interface EmoticonDisplayListener<T> {
    void onBindView(int i, ViewGroup viewGroup, EmoticonsAdapter.ViewHolder viewHolder, T t, boolean z);
}

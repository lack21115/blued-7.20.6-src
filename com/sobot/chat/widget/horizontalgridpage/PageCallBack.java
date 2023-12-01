package com.sobot.chat.widget.horizontalgridpage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PageCallBack.class */
public interface PageCallBack {
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    void onItemClickListener(View view, int i);

    void onItemLongClickListener(View view, int i);
}

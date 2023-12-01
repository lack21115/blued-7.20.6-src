package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/listener/OnItemSwipeListener.class */
public interface OnItemSwipeListener {
    void a(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z);

    void a(RecyclerView.ViewHolder viewHolder, int i);

    void b(RecyclerView.ViewHolder viewHolder, int i);

    void c(RecyclerView.ViewHolder viewHolder, int i);
}

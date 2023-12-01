package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.module.shortvideo.widget.StvItemDecoration;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/StvBaseRecyclerView.class */
public class StvBaseRecyclerView extends RecyclerView {
    public StvBaseRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addItemDecoration(new StvItemDecoration(context, attributeSet));
        setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.shortvideo.view.StvBaseRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    ImageLoadEngine.b();
                } else if (i == 1) {
                    ImageLoadEngine.a();
                } else if (i != 2) {
                } else {
                    ImageLoadEngine.a();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }
}

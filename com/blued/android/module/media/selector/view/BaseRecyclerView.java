package com.blued.android.module.media.selector.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.module.media.selector.widget.MediaItemDecoration;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/view/BaseRecyclerView.class */
public class BaseRecyclerView extends RecyclerView {
    public BaseRecyclerView(Context context) {
        this(context, null);
    }

    public BaseRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addItemDecoration(new MediaItemDecoration(context, attributeSet));
        setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.media.selector.view.BaseRecyclerView.1
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

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
    }
}

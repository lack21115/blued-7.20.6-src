package com.blued.android.module.live_china.view;

import android.content.Context;
import android.media.MediaMetadataEditor;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveListView.class */
public class LiveListView extends ListView {
    public LiveListView(Context context) {
        super(context);
    }

    public LiveListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LiveListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(MediaMetadataEditor.KEY_EDITABLE_MASK, Integer.MIN_VALUE));
    }
}

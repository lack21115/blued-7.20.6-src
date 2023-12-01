package com.anythink.expressad.video.dynview.ordercamp;

import android.content.Context;
import android.media.MediaMetadataEditor;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/ordercamp/AblGridView.class */
public class AblGridView extends GridView {
    public AblGridView(Context context) {
        super(context);
    }

    public AblGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AblGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(MediaMetadataEditor.KEY_EDITABLE_MASK, Integer.MIN_VALUE));
    }
}

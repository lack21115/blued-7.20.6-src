package com.sobot.chat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotAutoGridView.class */
public class SobotAutoGridView extends GridView {
    private static final String TAG = "AutoGridView";
    private int numColumns;
    private int previousFirstVisible;

    public SobotAutoGridView(Context context) {
        super(context);
        this.numColumns = 1;
    }

    public SobotAutoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.numColumns = 1;
        init(attributeSet);
    }

    public SobotAutoGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.numColumns = 1;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        if (attributeCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= attributeCount) {
                return;
            }
            String attributeName = attributeSet.getAttributeName(i2);
            if (attributeName != null && attributeName.equals("numColumns")) {
                this.numColumns = attributeSet.getAttributeIntValue(i2, 1);
                return;
            }
            i = i2 + 1;
        }
    }

    private void setHeights() {
        int i;
        if (getAdapter() == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= getChildCount()) {
                return;
            }
            int i4 = i3;
            int i5 = 0;
            while (true) {
                i = i5;
                if (i4 >= this.numColumns + i3) {
                    break;
                }
                View childAt = getChildAt(i4);
                int i6 = i;
                if (childAt != null) {
                    i6 = i;
                    if (childAt.getHeight() > i) {
                        i6 = childAt.getHeight();
                    }
                }
                i4++;
                i5 = i6;
            }
            if (i > 0) {
                int i7 = i3;
                while (true) {
                    int i8 = i7;
                    if (i8 < this.numColumns + i3) {
                        View childAt2 = getChildAt(i8);
                        if (childAt2 != null && childAt2.getHeight() != i) {
                            childAt2.setMinimumHeight(i);
                        }
                        i7 = i8 + 1;
                    }
                }
            }
            i2 = i3 + this.numColumns;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        setNumColumns(this.numColumns);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setHeights();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.previousFirstVisible != firstVisiblePosition) {
            this.previousFirstVisible = firstVisiblePosition;
            setHeights();
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.widget.GridView
    public void setNumColumns(int i) {
        this.numColumns = i;
        super.setNumColumns(i);
        setSelection(this.previousFirstVisible);
    }
}

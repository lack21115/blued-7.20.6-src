package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/lib/models/MapExploreByTouchHelper.class */
public abstract class MapExploreByTouchHelper extends ExploreByTouchHelper {
    public static final int MAP_ACTION_CLICKED = 1;
    public static final int NO_ITEM = -1;
    public List<AccessibleTouchItem> accessibleTouchItems;

    public MapExploreByTouchHelper(View view) {
        super(view);
        this.accessibleTouchItems = new ArrayList();
    }

    public abstract int getTargetPoiItemIdx(float f, float f2);

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public int getVirtualViewAt(float f, float f2) {
        int targetPoiItemIdx = getTargetPoiItemIdx(f, f2);
        int i = targetPoiItemIdx;
        if (targetPoiItemIdx == -1) {
            i = Integer.MIN_VALUE;
        }
        return i;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void getVisibleVirtualViews(List<Integer> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.accessibleTouchItems.size()) {
                return;
            }
            list.add(Integer.valueOf(i2));
            i = i2 + 1;
        }
    }

    public abstract boolean onItemClicked(int i);

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        if (i2 == 16) {
            return onItemClicked(i);
        }
        return false;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        if (i >= this.accessibleTouchItems.size()) {
            accessibilityEvent.getText().add("");
            return;
        }
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i);
        if (accessibleTouchItem == null) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        accessibilityEvent.getText().add(accessibleTouchItem.getContentDescription());
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i >= this.accessibleTouchItems.size()) {
            accessibilityNodeInfoCompat.setText("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect());
            return;
        }
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i);
        if (accessibleTouchItem == null) {
            throw new IllegalArgumentException("Invalid virtual view id");
        }
        accessibilityNodeInfoCompat.setText(accessibleTouchItem.getContentDescription());
        accessibilityNodeInfoCompat.setBoundsInParent(accessibleTouchItem.getBounds());
        accessibilityNodeInfoCompat.addAction(16);
    }

    public void onTalkBackActivate(View view) {
        ViewCompat.setAccessibilityDelegate(view, this);
    }

    public void onTalkBackDeActivate(View view) {
        ViewCompat.setAccessibilityDelegate(view, null);
    }
}

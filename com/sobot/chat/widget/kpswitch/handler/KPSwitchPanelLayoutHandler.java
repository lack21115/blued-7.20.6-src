package com.sobot.chat.widget.kpswitch.handler;

import android.util.AttributeSet;
import android.view.View;
import com.sobot.chat.widget.kpswitch.IPanelConflictLayout;
import com.sobot.chat.widget.kpswitch.util.ViewUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/handler/KPSwitchPanelLayoutHandler.class */
public class KPSwitchPanelLayoutHandler implements IPanelConflictLayout {
    private final View panelLayout;
    private boolean mIsHide = false;
    private boolean mIgnoreRecommendHeight = false;
    private final int[] processedMeasureWHSpec = new int[2];
    private boolean mIsKeyboardShowing = false;

    public KPSwitchPanelLayoutHandler(View view, AttributeSet attributeSet) {
        this.panelLayout = view;
    }

    public boolean filterSetVisibility(int i) {
        if (i == 0) {
            this.mIsHide = false;
        }
        if (i == this.panelLayout.getVisibility()) {
            return true;
        }
        return isKeyboardShowing() && i == 0;
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public void handleHide() {
        this.mIsHide = true;
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public void handleShow() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public boolean isKeyboardShowing() {
        return this.mIsKeyboardShowing;
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public boolean isVisible() {
        return !this.mIsHide;
    }

    public int[] processOnMeasure(int i, int i2) {
        if (this.mIsHide) {
            this.panelLayout.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        int[] iArr = this.processedMeasureWHSpec;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public void resetToRecommendPanelHeight(int i) {
        if (this.mIgnoreRecommendHeight) {
            return;
        }
        ViewUtil.refreshHeight(this.panelLayout, i);
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public void setIgnoreRecommendHeight(boolean z) {
        this.mIgnoreRecommendHeight = z;
    }

    public void setIsKeyboardShowing(boolean z) {
        this.mIsKeyboardShowing = z;
    }
}

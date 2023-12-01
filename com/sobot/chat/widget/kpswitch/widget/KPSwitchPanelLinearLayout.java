package com.sobot.chat.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.sobot.chat.widget.kpswitch.IPanelConflictLayout;
import com.sobot.chat.widget.kpswitch.IPanelHeightTarget;
import com.sobot.chat.widget.kpswitch.handler.KPSwitchPanelLayoutHandler;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/widget/KPSwitchPanelLinearLayout.class */
public class KPSwitchPanelLinearLayout extends LinearLayout implements IPanelConflictLayout, IPanelHeightTarget {
    private KPSwitchPanelLayoutHandler panelLayoutHandler;

    public KPSwitchPanelLinearLayout(Context context) {
        super(context);
        init(null);
    }

    public KPSwitchPanelLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public KPSwitchPanelLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.panelLayoutHandler = new KPSwitchPanelLayoutHandler(this, attributeSet);
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public void handleHide() {
        this.panelLayoutHandler.handleHide();
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public void handleShow() {
        super.setVisibility(0);
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public boolean isKeyboardShowing() {
        return this.panelLayoutHandler.isKeyboardShowing();
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public boolean isVisible() {
        return this.panelLayoutHandler.isVisible();
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelHeightTarget
    public void onKeyboardShowing(boolean z) {
        this.panelLayoutHandler.setIsKeyboardShowing(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int[] processOnMeasure = this.panelLayoutHandler.processOnMeasure(i, i2);
        super.onMeasure(processOnMeasure[0], processOnMeasure[1]);
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelHeightTarget
    public void refreshHeight(int i) {
        this.panelLayoutHandler.resetToRecommendPanelHeight(i);
    }

    @Override // com.sobot.chat.widget.kpswitch.IPanelConflictLayout
    public void setIgnoreRecommendHeight(boolean z) {
        this.panelLayoutHandler.setIgnoreRecommendHeight(z);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.panelLayoutHandler.filterSetVisibility(i)) {
            return;
        }
        super.setVisibility(i);
    }
}

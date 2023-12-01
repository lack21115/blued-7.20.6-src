package com.sobot.chat.widget.kpswitch;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.sobot.chat.widget.kpswitch.view.BaseChattingPanelView;
import com.sobot.chat.widget.kpswitch.view.CustomeViewFactory;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/CustomeChattingPanel.class */
public class CustomeChattingPanel extends RelativeLayout {
    private String instanceTag;
    private HashMap<Integer, BaseChattingPanelView> map;

    public CustomeChattingPanel(Context context) {
        this(context, null);
    }

    public CustomeChattingPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomeChattingPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.map = new HashMap<>();
    }

    public String getPanelViewTag() {
        return this.instanceTag;
    }

    public void setupView(int i, Bundle bundle, BaseChattingPanelView.SobotBasePanelListener sobotBasePanelListener) {
        int childCount = getChildCount();
        this.instanceTag = CustomeViewFactory.getInstanceTag(getContext(), i);
        if (childCount > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                if (childAt.getTag().toString().equals(this.instanceTag)) {
                    childAt.setVisibility(0);
                } else {
                    childAt.setVisibility(8);
                }
                i2 = i3 + 1;
            }
        }
        BaseChattingPanelView baseChattingPanelView = this.map.get(Integer.valueOf(i));
        if (baseChattingPanelView != null) {
            baseChattingPanelView.onViewStart(bundle);
            return;
        }
        BaseChattingPanelView customeViewFactory = CustomeViewFactory.getInstance(getContext(), i);
        this.map.put(Integer.valueOf(i), customeViewFactory);
        addView(customeViewFactory.getRootView());
        customeViewFactory.initView();
        customeViewFactory.initData();
        customeViewFactory.setListener(sobotBasePanelListener);
        customeViewFactory.onViewStart(bundle);
    }
}

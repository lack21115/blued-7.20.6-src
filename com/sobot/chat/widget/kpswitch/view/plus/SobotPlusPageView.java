package com.sobot.chat.widget.kpswitch.view.plus;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/plus/SobotPlusPageView.class */
public class SobotPlusPageView extends RelativeLayout {
    private GridView mGvView;

    public SobotPlusPageView(Context context) {
        this(context, null);
    }

    public SobotPlusPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }
        this.mGvView = (GridView) layoutInflater.inflate(ResourceUtils.getIdByName(context, "layout", "sobot_item_pluspage"), this).findViewById(ResourceUtils.getIdByName(context, "id", "sobot_gv"));
        if (Build.VERSION.SDK_INT > 11) {
            this.mGvView.setMotionEventSplittingEnabled(false);
        }
        this.mGvView.setStretchMode(2);
        this.mGvView.setCacheColorHint(0);
        this.mGvView.setSelector(new ColorDrawable(0));
        this.mGvView.setVerticalScrollBarEnabled(false);
    }

    public GridView getGridView() {
        return this.mGvView;
    }

    public void setNumColumns(int i) {
        this.mGvView.setNumColumns(i);
    }
}

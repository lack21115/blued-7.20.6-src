package com.sobot.chat.widget.kpswitch.view.emoticon;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/emoticon/EmoticonPageView.class */
public class EmoticonPageView extends RelativeLayout {
    private GridView mGvEmotion;

    public EmoticonPageView(Context context) {
        this(context, null);
    }

    public EmoticonPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGvEmotion = (GridView) ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(ResourceUtils.getIdByName(context, "layout", "sobot_item_emoticonpage"), this).findViewById(ResourceUtils.getIdByName(context, "id", "sobot_gv_emotion"));
        if (Build.VERSION.SDK_INT > 11) {
            this.mGvEmotion.setMotionEventSplittingEnabled(false);
        }
        this.mGvEmotion.setStretchMode(2);
        this.mGvEmotion.setCacheColorHint(0);
        this.mGvEmotion.setSelector(new ColorDrawable(0));
        this.mGvEmotion.setVerticalScrollBarEnabled(false);
    }

    public GridView getEmoticonsGridView() {
        return this.mGvEmotion;
    }

    public void setNumColumns(int i) {
        this.mGvEmotion.setNumColumns(i);
    }
}

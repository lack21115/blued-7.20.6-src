package com.sobot.chat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotTenRatingLayout.class */
public class SobotTenRatingLayout extends LinearLayout {
    private OnClickItemListener onClickItemListener;
    private int selectContent;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotTenRatingLayout$OnClickItemListener.class */
    public interface OnClickItemListener {
        void onClickItem(int i);
    }

    public SobotTenRatingLayout(Context context) {
        super(context);
    }

    public SobotTenRatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SobotTenRatingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private boolean isTouchPointInView(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    public OnClickItemListener getOnClickItemListener() {
        return this.onClickItemListener;
    }

    public int getSelectContent() {
        return this.selectContent;
    }

    public void init(int i, final boolean z) {
        LinearLayout.LayoutParams layoutParams;
        this.selectContent = i;
        int i2 = 0;
        while (true) {
            final int i3 = i2;
            if (i3 >= 11) {
                return;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(ResourceUtils.getIdByName(getContext(), "layout", "sobot_ten_rating_item"), (ViewGroup) null);
            textView.setText(i3 + "");
            if (i3 != 10) {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                layoutParams.rightMargin = ScreenUtils.dip2px(getContext(), 6.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                layoutParams.rightMargin = 0;
            }
            textView.setLayoutParams(layoutParams);
            if (i3 <= i) {
                textView.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_common_white")));
                textView.setBackgroundResource(ResourceUtils.getDrawableId(getContext(), "sobot_ten_rating_item_bg_sel"));
            } else {
                textView.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_common_gray1")));
                textView.setBackgroundResource(ResourceUtils.getDrawableId(getContext(), "sobot_ten_rating_item_bg_def"));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.SobotTenRatingLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (SobotTenRatingLayout.this.onClickItemListener != null) {
                        if (z) {
                            SobotTenRatingLayout.this.updateUI(i3);
                        }
                        SobotTenRatingLayout.this.onClickItemListener.onClickItem(i3);
                        SobotTenRatingLayout.this.selectContent = i3;
                    }
                }
            });
            addView(textView);
            i2 = i3 + 1;
        }
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public void setSelectContent(int i) {
        this.selectContent = i;
    }

    public void updateUI(int i) {
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            TextView textView = (TextView) getChildAt(i3);
            if (i3 <= i) {
                textView.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_common_white")));
                textView.setBackgroundResource(ResourceUtils.getDrawableId(getContext(), "sobot_ten_rating_item_bg_sel"));
            } else {
                textView.setTextColor(ContextCompat.getColor(getContext(), ResourceUtils.getResColorId(getContext(), "sobot_common_gray1")));
                textView.setBackgroundResource(ResourceUtils.getDrawableId(getContext(), "sobot_ten_rating_item_bg_def"));
            }
            i2 = i3 + 1;
        }
    }
}

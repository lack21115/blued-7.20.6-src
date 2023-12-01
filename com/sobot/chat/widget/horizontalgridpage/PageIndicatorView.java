package com.sobot.chat.widget.horizontalgridpage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/horizontalgridpage/PageIndicatorView.class */
public class PageIndicatorView extends LinearLayout {
    private String TAG;
    private int[] indicatorRes;
    private int indicatorSize;
    private ArrayList<View> indicatorViews;
    private int[] margins;
    private ZhiChiMessageBase message;

    public PageIndicatorView(Context context, int i, int[] iArr, int[] iArr2, int i2) {
        super(context);
        this.TAG = "PageIndicatorView";
        this.indicatorSize = i;
        this.margins = iArr;
        this.indicatorRes = iArr2;
        setGravity(i2);
        setOrientation(0);
    }

    public int getCurrIndex() {
        if (this.message == null) {
            return 0;
        }
        String str = this.TAG;
        Log.e(str, "getCurrIndex: " + this.message.getCurrentPageNum());
        return this.message.getCurrentPageNum();
    }

    public void initIndicator(int i) {
        ArrayList<View> arrayList = this.indicatorViews;
        if (arrayList == null) {
            this.indicatorViews = new ArrayList<>();
        } else {
            arrayList.clear();
            removeAllViews();
        }
        int i2 = this.indicatorSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        int[] iArr = this.margins;
        layoutParams.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                break;
            }
            View view = new View(getContext());
            view.setBackgroundResource(this.indicatorRes[0]);
            addView(view, layoutParams);
            this.indicatorViews.add(view);
            i3 = i4 + 1;
        }
        if (this.indicatorViews.size() > 0) {
            this.indicatorViews.get(0).setBackgroundResource(this.indicatorRes[1]);
        }
    }

    public void setMessage(ZhiChiMessageBase zhiChiMessageBase) {
        this.message = zhiChiMessageBase;
    }

    public void update(int i) {
        if (this.indicatorViews == null) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = this.message;
        if (zhiChiMessageBase != null) {
            zhiChiMessageBase.setCurrentPageNum(i);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.indicatorViews.size()) {
                return;
            }
            if (i3 == i) {
                this.indicatorViews.get(i3).setBackgroundResource(this.indicatorRes[1]);
            } else {
                this.indicatorViews.get(i3).setBackgroundResource(this.indicatorRes[0]);
            }
            i2 = i3 + 1;
        }
    }
}

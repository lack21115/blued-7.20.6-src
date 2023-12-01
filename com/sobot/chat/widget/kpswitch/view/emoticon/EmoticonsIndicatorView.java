package com.sobot.chat.widget.kpswitch.view.emoticon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.h.i;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/emoticon/EmoticonsIndicatorView.class */
public class EmoticonsIndicatorView extends LinearLayout {
    private static final int MARGIN_LEFT = 4;
    protected Context mContext;
    protected Drawable mDrawableNomal;
    protected Drawable mDrawableSelect;
    protected ArrayList<ImageView> mImageViews;
    protected LinearLayout.LayoutParams mLeftLayoutParams;

    public EmoticonsIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        setOrientation(0);
        if (this.mDrawableNomal == null) {
            this.mDrawableNomal = getResources().getDrawable(ResourceUtils.getIdByName(context, i.f7952c, "sobot_indicator_point_nomal"));
        }
        if (this.mDrawableSelect == null) {
            this.mDrawableSelect = getResources().getDrawable(ResourceUtils.getIdByName(context, i.f7952c, "sobot_indicator_point_select"));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.mLeftLayoutParams = layoutParams;
        layoutParams.height = ScreenUtils.dip2px(context, 5.0f);
        this.mLeftLayoutParams.width = ScreenUtils.dip2px(context, 5.0f);
        this.mLeftLayoutParams.leftMargin = ScreenUtils.dip2px(context, 4.0f);
    }

    protected boolean checkPageSetEntity(PageSetEntity pageSetEntity) {
        if (pageSetEntity == null || !pageSetEntity.isShowIndicator()) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (r5 == r4) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void playBy(int r4, int r5, com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity r6) {
        /*
            r3 = this;
            r0 = r3
            r1 = r6
            boolean r0 = r0.checkPageSetEntity(r1)
            if (r0 != 0) goto L9
            return
        L9:
            r0 = r3
            r1 = r6
            int r1 = r1.getPageCount()
            r0.updateIndicatorCount(r1)
            r0 = 0
            r9 = r0
            r0 = r4
            if (r0 < 0) goto L27
            r0 = r5
            if (r0 < 0) goto L27
            r0 = r4
            r8 = r0
            r0 = r5
            r7 = r0
            r0 = r5
            r1 = r4
            if (r0 != r1) goto L2d
        L27:
            r0 = 0
            r8 = r0
            r0 = 0
            r7 = r0
        L2d:
            r0 = r8
            if (r0 >= 0) goto L3b
            r0 = 0
            r7 = r0
            r0 = r9
            r4 = r0
            goto L3e
        L3b:
            r0 = r8
            r4 = r0
        L3e:
            r0 = r3
            java.util.ArrayList<android.widget.ImageView> r0 = r0.mImageViews
            r1 = r4
            java.lang.Object r0 = r0.get(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r6 = r0
            r0 = r3
            java.util.ArrayList<android.widget.ImageView> r0 = r0.mImageViews
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r10 = r0
            r0 = r6
            r1 = r3
            android.graphics.drawable.Drawable r1 = r1.mDrawableNomal
            r0.setImageDrawable(r1)
            r0 = r10
            r1 = r3
            android.graphics.drawable.Drawable r1 = r1.mDrawableSelect
            r0.setImageDrawable(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsIndicatorView.playBy(int, int, com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity):void");
    }

    public void playTo(int i, PageSetEntity pageSetEntity) {
        if (checkPageSetEntity(pageSetEntity)) {
            updateIndicatorCount(pageSetEntity.getPageCount());
            ArrayList<ImageView> arrayList = this.mImageViews;
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            Iterator<ImageView> it = this.mImageViews.iterator();
            while (it.hasNext()) {
                it.next().setImageDrawable(this.mDrawableNomal);
            }
            if (this.mImageViews.get(i) != null) {
                this.mImageViews.get(i).setImageDrawable(this.mDrawableSelect);
            }
        }
    }

    protected void updateIndicatorCount(int i) {
        if (this.mImageViews == null) {
            this.mImageViews = new ArrayList<>();
        }
        if (i > this.mImageViews.size()) {
            int size = this.mImageViews.size();
            while (true) {
                int i2 = size;
                if (i2 >= i) {
                    break;
                }
                ImageView imageView = new ImageView(this.mContext);
                imageView.setImageDrawable(i2 == 0 ? this.mDrawableSelect : this.mDrawableNomal);
                addView(imageView, this.mLeftLayoutParams);
                this.mImageViews.add(imageView);
                size = i2 + 1;
            }
        }
        if (i == 1) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.mImageViews.size()) {
                    return;
                }
                this.mImageViews.get(i4).setVisibility(8);
                i3 = i4 + 1;
            }
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.mImageViews.size()) {
                    return;
                }
                if (i6 >= i) {
                    this.mImageViews.get(i6).setVisibility(8);
                } else {
                    this.mImageViews.get(i6).setVisibility(0);
                }
                i5 = i6 + 1;
            }
        }
    }
}

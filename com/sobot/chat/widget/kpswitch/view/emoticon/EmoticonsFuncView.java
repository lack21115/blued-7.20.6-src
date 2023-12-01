package com.sobot.chat.widget.kpswitch.view.emoticon;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.sobot.chat.widget.kpswitch.widget.adpater.PageSetAdapter;
import com.sobot.chat.widget.kpswitch.widget.data.PageSetEntity;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/emoticon/EmoticonsFuncView.class */
public class EmoticonsFuncView extends ViewPager {
    protected int mCurrentPagePosition;
    private OnEmoticonsPageViewListener mOnEmoticonsPageViewListener;
    protected PageSetAdapter mPageSetAdapter;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/view/emoticon/EmoticonsFuncView$OnEmoticonsPageViewListener.class */
    public interface OnEmoticonsPageViewListener {
        void emoticonSetChanged(PageSetEntity pageSetEntity);

        void playBy(int i, int i2, PageSetEntity pageSetEntity);

        void playTo(int i, PageSetEntity pageSetEntity);
    }

    public EmoticonsFuncView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void checkPageChange(int i) {
        boolean z;
        OnEmoticonsPageViewListener onEmoticonsPageViewListener;
        PageSetAdapter pageSetAdapter = this.mPageSetAdapter;
        if (pageSetAdapter == null) {
            return;
        }
        Iterator<PageSetEntity> it = pageSetAdapter.getPageSetEntityList().iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            PageSetEntity next = it.next();
            int pageCount = next.getPageCount();
            int i4 = i3 + pageCount;
            if (i4 > i) {
                int i5 = this.mCurrentPagePosition;
                if (i5 - i3 >= pageCount) {
                    OnEmoticonsPageViewListener onEmoticonsPageViewListener2 = this.mOnEmoticonsPageViewListener;
                    if (onEmoticonsPageViewListener2 != null) {
                        onEmoticonsPageViewListener2.playTo(i - i3, next);
                    }
                } else if (i5 - i3 >= 0) {
                    OnEmoticonsPageViewListener onEmoticonsPageViewListener3 = this.mOnEmoticonsPageViewListener;
                    z = false;
                    if (onEmoticonsPageViewListener3 != null) {
                        onEmoticonsPageViewListener3.playBy(i5 - i3, i - i3, next);
                        z = false;
                    }
                    if (z || (onEmoticonsPageViewListener = this.mOnEmoticonsPageViewListener) == null) {
                        return;
                    }
                    onEmoticonsPageViewListener.emoticonSetChanged(next);
                    return;
                } else {
                    OnEmoticonsPageViewListener onEmoticonsPageViewListener4 = this.mOnEmoticonsPageViewListener;
                    if (onEmoticonsPageViewListener4 != null) {
                        onEmoticonsPageViewListener4.playTo(0, next);
                    }
                }
                z = true;
                if (z) {
                    return;
                }
                return;
            }
            i2 = i4;
        }
    }

    public void setAdapter(PageSetAdapter pageSetAdapter) {
        super.setAdapter((PagerAdapter) pageSetAdapter);
        this.mPageSetAdapter = pageSetAdapter;
        setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.sobot.chat.widget.kpswitch.view.emoticon.EmoticonsFuncView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                EmoticonsFuncView.this.checkPageChange(i);
                EmoticonsFuncView.this.mCurrentPagePosition = i;
            }
        });
        if (this.mOnEmoticonsPageViewListener == null || this.mPageSetAdapter.getPageSetEntityList().isEmpty()) {
            return;
        }
        PageSetEntity pageSetEntity = this.mPageSetAdapter.getPageSetEntityList().get(0);
        this.mOnEmoticonsPageViewListener.playTo(0, pageSetEntity);
        this.mOnEmoticonsPageViewListener.emoticonSetChanged(pageSetEntity);
    }

    public void setCurrentPageSet(PageSetEntity pageSetEntity) {
        PageSetAdapter pageSetAdapter = this.mPageSetAdapter;
        if (pageSetAdapter == null || pageSetAdapter.getCount() <= 0) {
            return;
        }
        setCurrentItem(this.mPageSetAdapter.getPageSetStartPosition(pageSetEntity));
    }

    public void setOnIndicatorListener(OnEmoticonsPageViewListener onEmoticonsPageViewListener) {
        this.mOnEmoticonsPageViewListener = onEmoticonsPageViewListener;
    }
}

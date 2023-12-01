package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.adapter.HomeChatRotationPageAdapter;
import com.blued.android.module.yy_china.view.ban.transformer.HomeRoomTransformer;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeChatRotationView.class */
public class HomeChatRotationView extends FrameLayout implements ViewPager.OnPageChangeListener {
    private ViewPager a;
    private List<String> b;
    private PkHandler c;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeChatRotationView$PkHandler.class */
    static class PkHandler extends Handler {
        private WeakReference<HomeChatRotationView> a;

        public PkHandler(HomeChatRotationView homeChatRotationView) {
            this.a = new WeakReference<>(homeChatRotationView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<HomeChatRotationView> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a.get().a();
        }
    }

    public HomeChatRotationView(Context context) {
        this(context, null);
    }

    public HomeChatRotationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeChatRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewPager viewPager = new ViewPager(context);
        this.a = viewPager;
        viewPager.setOffscreenPageLimit(3);
        this.a.setPageTransformer(true, new HomeRoomTransformer());
        this.a.addOnPageChangeListener(this);
        ViewPagerScroller viewPagerScroller = new ViewPagerScroller(context);
        viewPagerScroller.a(1000);
        viewPagerScroller.a(this.a);
        this.c = new PkHandler(this);
        addView((View) this.a, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this) {
            int currentItem = this.a.getCurrentItem() + 1;
            if (currentItem == this.a.getAdapter().getCount() - 1) {
                this.a.setCurrentItem(0, false);
            } else {
                this.a.setCurrentItem(currentItem, true);
            }
        }
    }

    private int getRealCount() {
        List<String> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private int getStartItem() {
        if (getRealCount() == 0) {
            return 0;
        }
        int realCount = (getRealCount() * 500) / 2;
        int i = realCount;
        if (realCount % getRealCount() == 0) {
            return realCount;
        }
        while (i % getRealCount() != 0) {
            i++;
        }
        return i;
    }

    public void a(List<String> list, IRequestHost iRequestHost) {
        this.b = list;
        this.a.setAdapter(new HomeChatRotationPageAdapter(list, iRequestHost));
        if (this.c == null) {
            this.c = new PkHandler(this);
        }
        this.a.setCurrentItem(getStartItem());
        PkHandler pkHandler = this.c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.c.sendEmptyMessageDelayed(1, 2000L);
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        PkHandler pkHandler = this.c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.c.sendEmptyMessageDelayed(1, 3000L);
        }
    }
}

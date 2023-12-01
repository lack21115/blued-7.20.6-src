package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.adapter.HomeChatRotationPageAdapter;
import com.blued.android.module.yy_china.view.ban.transformer.HomeRoomTransformer;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeChatRotationView.class */
public class HomeChatRotationView extends FrameLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f17943a;
    private List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private PkHandler f17944c;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeChatRotationView$PkHandler.class */
    static class PkHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<HomeChatRotationView> f17945a;

        public PkHandler(HomeChatRotationView homeChatRotationView) {
            this.f17945a = new WeakReference<>(homeChatRotationView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<HomeChatRotationView> weakReference = this.f17945a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f17945a.get().a();
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
        this.f17943a = viewPager;
        viewPager.setOffscreenPageLimit(3);
        this.f17943a.setPageTransformer(true, new HomeRoomTransformer());
        this.f17943a.addOnPageChangeListener(this);
        ViewPagerScroller viewPagerScroller = new ViewPagerScroller(context);
        viewPagerScroller.a(1000);
        viewPagerScroller.a(this.f17943a);
        this.f17944c = new PkHandler(this);
        addView(this.f17943a, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this) {
            int currentItem = this.f17943a.getCurrentItem() + 1;
            if (currentItem == this.f17943a.getAdapter().getCount() - 1) {
                this.f17943a.setCurrentItem(0, false);
            } else {
                this.f17943a.setCurrentItem(currentItem, true);
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
        this.f17943a.setAdapter(new HomeChatRotationPageAdapter(list, iRequestHost));
        if (this.f17944c == null) {
            this.f17944c = new PkHandler(this);
        }
        this.f17943a.setCurrentItem(getStartItem());
        PkHandler pkHandler = this.f17944c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17944c.sendEmptyMessageDelayed(1, 2000L);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        PkHandler pkHandler = this.f17944c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17944c.sendEmptyMessageDelayed(1, m.ag);
        }
    }
}

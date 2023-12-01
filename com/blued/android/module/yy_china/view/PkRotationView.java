package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.adapter.PkRotationPageAdapter;
import com.blued.android.module.yy_china.view.ban.transformer.CardTransformer;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/PkRotationView.class */
public class PkRotationView extends FrameLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f17966a;
    private List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private PkHandler f17967c;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/PkRotationView$PkHandler.class */
    static class PkHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<PkRotationView> f17968a;

        public PkHandler(PkRotationView pkRotationView) {
            this.f17968a = new WeakReference<>(pkRotationView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<PkRotationView> weakReference = this.f17968a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f17968a.get().b();
        }
    }

    public PkRotationView(Context context) {
        this(context, null);
    }

    public PkRotationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PkRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewPager viewPager = new ViewPager(context);
        this.f17966a = viewPager;
        viewPager.setOffscreenPageLimit(3);
        this.f17966a.setPageTransformer(true, new CardTransformer());
        this.f17966a.addOnPageChangeListener(this);
        ViewPagerScroller viewPagerScroller = new ViewPagerScroller(context);
        viewPagerScroller.a(2000);
        viewPagerScroller.a(this.f17966a);
        this.f17967c = new PkHandler(this);
        addView(this.f17966a, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            int currentItem = this.f17966a.getCurrentItem() + 1;
            if (currentItem == this.f17966a.getAdapter().getCount() - 1) {
                this.f17966a.setCurrentItem(0, false);
            } else {
                this.f17966a.setCurrentItem(currentItem, true);
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

    public void a() {
        PkHandler pkHandler = this.f17967c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17967c = null;
        }
    }

    public void a(List<String> list, IRequestHost iRequestHost) {
        this.b = list;
        this.f17966a.setAdapter(new PkRotationPageAdapter(list, iRequestHost));
        if (this.f17967c == null) {
            this.f17967c = new PkHandler(this);
        }
        this.f17966a.setCurrentItem(getStartItem());
        PkHandler pkHandler = this.f17967c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17967c.sendEmptyMessageDelayed(1, 2000L);
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
        PkHandler pkHandler = this.f17967c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17967c.sendEmptyMessageDelayed(1, 2000L);
        }
    }
}

package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.yy_china.adapter.HomeRotationPageAdapter;
import com.blued.android.module.yy_china.fragment.YYHomeChatsFragment;
import com.blued.android.module.yy_china.model.YyHomeChatItemDataInfoMode;
import com.blued.android.module.yy_china.view.ban.transformer.CardTransformer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeRotationView.class */
public class HomeRotationView extends FrameLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f17946a;
    private List<YyHomeChatItemDataInfoMode> b;

    /* renamed from: c  reason: collision with root package name */
    private PkHandler f17947c;
    private HomeRotationPageAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeRotationView$PkHandler.class */
    public static class PkHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<HomeRotationView> f17948a;

        public PkHandler(HomeRotationView homeRotationView) {
            this.f17948a = new WeakReference<>(homeRotationView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<HomeRotationView> weakReference = this.f17948a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f17948a.get().d();
        }
    }

    public HomeRotationView(Context context) {
        this(context, null);
    }

    public HomeRotationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.f17946a = new ViewPager(context);
        this.f17947c = new PkHandler(this);
    }

    private void a(YYHomeChatsFragment yYHomeChatsFragment) {
        HomeRotationPageAdapter homeRotationPageAdapter = new HomeRotationPageAdapter(this.b, yYHomeChatsFragment);
        this.d = homeRotationPageAdapter;
        this.f17946a.setAdapter(homeRotationPageAdapter);
        this.f17946a.setOffscreenPageLimit(3);
        this.f17946a.setPageTransformer(true, new CardTransformer(0.95f));
        this.f17946a.addOnPageChangeListener(this);
        ViewPagerScroller viewPagerScroller = new ViewPagerScroller(getContext());
        viewPagerScroller.a(2000);
        viewPagerScroller.a(this.f17946a);
        addView(this.f17946a, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            if (this.f17946a.getAdapter() == null) {
                return;
            }
            int currentItem = this.f17946a.getCurrentItem() + 1;
            try {
                if (currentItem >= this.f17946a.getAdapter().getCount() - 1) {
                    this.f17946a.setCurrentItem(0, false);
                } else {
                    this.f17946a.setCurrentItem(currentItem, true);
                }
            } catch (IllegalStateException e) {
            }
        }
    }

    private int getRealCount() {
        List<YyHomeChatItemDataInfoMode> list = this.b;
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
        LogUtils.d("startLoop... 1 .....");
        if (this.f17947c != null) {
            LogUtils.d("startLoop... 2 .....");
            this.f17947c.removeCallbacksAndMessages(null);
            this.f17947c.sendEmptyMessageDelayed(1, 2000L);
        }
    }

    public void a(List<YyHomeChatItemDataInfoMode> list, YYHomeChatsFragment yYHomeChatsFragment) {
        this.b = list;
        if (list != null && list.size() == 2) {
            this.f17946a.setOffscreenPageLimit(1);
        }
        PkHandler pkHandler = this.f17947c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
        } else {
            this.f17947c = new PkHandler(this);
        }
        HomeRotationPageAdapter homeRotationPageAdapter = this.d;
        if (homeRotationPageAdapter == null) {
            a(yYHomeChatsFragment);
            if (list != null && list.size() == 1) {
                return;
            }
            this.f17946a.setCurrentItem(getStartItem());
        } else {
            homeRotationPageAdapter.b = list;
            this.d.notifyDataSetChanged();
            if (list != null && list.size() == 1) {
                return;
            }
        }
        a();
    }

    public void b() {
        LogUtils.d("stopLoop... 1 .....");
        if (this.f17947c != null) {
            LogUtils.d("stopLoop... 2 .....");
            this.f17947c.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        LogUtils.d("onDetachedFromWindow...");
        PkHandler pkHandler = this.f17947c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17947c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d("onDetachedFromWindow...");
        c();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        LogUtils.d("onPageSelected...");
        PkHandler pkHandler = this.f17947c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.f17947c.sendEmptyMessageDelayed(1, 2000L);
        }
    }
}

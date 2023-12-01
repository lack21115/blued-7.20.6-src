package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
    private ViewPager a;
    private List<YyHomeChatItemDataInfoMode> b;
    private PkHandler c;
    private HomeRotationPageAdapter d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/HomeRotationView$PkHandler.class */
    public static class PkHandler extends Handler {
        private WeakReference<HomeRotationView> a;

        public PkHandler(HomeRotationView homeRotationView) {
            this.a = new WeakReference<>(homeRotationView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            WeakReference<HomeRotationView> weakReference = this.a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a.get().d();
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
        this.a = new ViewPager(context);
        this.c = new PkHandler(this);
    }

    private void a(YYHomeChatsFragment yYHomeChatsFragment) {
        HomeRotationPageAdapter homeRotationPageAdapter = new HomeRotationPageAdapter(this.b, yYHomeChatsFragment);
        this.d = homeRotationPageAdapter;
        this.a.setAdapter(homeRotationPageAdapter);
        this.a.setOffscreenPageLimit(3);
        this.a.setPageTransformer(true, new CardTransformer(0.95f));
        this.a.addOnPageChangeListener(this);
        ViewPagerScroller viewPagerScroller = new ViewPagerScroller(getContext());
        viewPagerScroller.a(2000);
        viewPagerScroller.a(this.a);
        addView((View) this.a, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            if (this.a.getAdapter() == null) {
                return;
            }
            int currentItem = this.a.getCurrentItem() + 1;
            try {
                if (currentItem >= this.a.getAdapter().getCount() - 1) {
                    this.a.setCurrentItem(0, false);
                } else {
                    this.a.setCurrentItem(currentItem, true);
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
        if (this.c != null) {
            LogUtils.d("startLoop... 2 .....");
            this.c.removeCallbacksAndMessages(null);
            this.c.sendEmptyMessageDelayed(1, 2000L);
        }
    }

    public void a(List<YyHomeChatItemDataInfoMode> list, YYHomeChatsFragment yYHomeChatsFragment) {
        this.b = list;
        if (list != null && list.size() == 2) {
            this.a.setOffscreenPageLimit(1);
        }
        PkHandler pkHandler = this.c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
        } else {
            this.c = new PkHandler(this);
        }
        HomeRotationPageAdapter homeRotationPageAdapter = this.d;
        if (homeRotationPageAdapter == null) {
            a(yYHomeChatsFragment);
            if (list != null && list.size() == 1) {
                return;
            }
            this.a.setCurrentItem(getStartItem());
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
        if (this.c != null) {
            LogUtils.d("stopLoop... 2 .....");
            this.c.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        LogUtils.d("onDetachedFromWindow...");
        PkHandler pkHandler = this.c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtils.d("onDetachedFromWindow...");
        c();
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        LogUtils.d("onPageSelected...");
        PkHandler pkHandler = this.c;
        if (pkHandler != null) {
            pkHandler.removeCallbacksAndMessages(null);
            this.c.sendEmptyMessageDelayed(1, 2000L);
        }
    }
}

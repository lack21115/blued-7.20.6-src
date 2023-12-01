package com.blued.android.module.common.widget.emoticon.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.model.EmoticonPackageModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsPageView.class */
public class EmoticonsPageView extends ViewPager implements IViewStateListener {

    /* renamed from: a  reason: collision with root package name */
    public int f11179a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f11180c;
    private int d;
    private int e;
    private List<EmoticonPackageModel> f;
    private EmoticonsViewPagerAdapter g;
    private List<View> h;
    private List<IViewStateListener> i;
    private OnEmoticonsPageViewListener j;

    /* renamed from: com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsPageView$2.class */
    class AnonymousClass2 implements ViewPager.OnPageChangeListener {
        AnonymousClass2() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (EmoticonsPageView.this.f11179a < 0) {
                EmoticonsPageView.this.f11179a = 0;
            }
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 >= EmoticonsPageView.this.f.size()) {
                    break;
                }
                int a2 = EmoticonsPageView.this.a((EmoticonPackageModel) EmoticonsPageView.this.f.get(i2));
                int i5 = i3 + a2;
                if (i5 > i) {
                    if (EmoticonsPageView.this.j != null) {
                        EmoticonsPageView.this.j.b(a2);
                    }
                    if (EmoticonsPageView.this.f11179a - i3 >= a2) {
                        int i6 = i - i3;
                        if (i6 >= 0 && EmoticonsPageView.this.j != null) {
                            EmoticonsPageView.this.j.c(i6);
                        }
                        if (EmoticonsPageView.this.i != null && !EmoticonsPageView.this.i.isEmpty()) {
                            for (IViewStateListener iViewStateListener : EmoticonsPageView.this.i) {
                                iViewStateListener.a(i4);
                            }
                        }
                    } else if (EmoticonsPageView.this.f11179a - i3 < 0) {
                        if (EmoticonsPageView.this.j != null) {
                            EmoticonsPageView.this.j.c(0);
                        }
                        if (EmoticonsPageView.this.i != null && !EmoticonsPageView.this.i.isEmpty()) {
                            for (IViewStateListener iViewStateListener2 : EmoticonsPageView.this.i) {
                                iViewStateListener2.a(i4);
                            }
                        }
                    } else if (EmoticonsPageView.this.j != null) {
                        EmoticonsPageView.this.j.a(EmoticonsPageView.this.f11179a - i3, i - i3);
                    }
                } else {
                    i4++;
                    i2++;
                    i3 = i5;
                }
            }
            EmoticonsPageView.this.f11179a = i;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsPageView$EmoticonsViewPagerAdapter.class */
    class EmoticonsViewPagerAdapter extends PagerAdapter {
        private EmoticonsViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            ((ViewPager) viewGroup).removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EmoticonsPageView.this.h.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            ((ViewPager) viewGroup).addView((View) EmoticonsPageView.this.h.get(i));
            return EmoticonsPageView.this.h.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/EmoticonsPageView$OnEmoticonsPageViewListener.class */
    public interface OnEmoticonsPageViewListener {
        void a(int i);

        void a(int i, int i2);

        void b(int i);

        void c(int i);
    }

    public EmoticonsPageView(Context context) {
        super(context);
        this.d = 0;
        this.e = 0;
        this.f11179a = -1;
        this.h = new ArrayList();
        this.b = context;
    }

    public EmoticonsPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.e = 0;
        this.f11179a = -1;
        this.h = new ArrayList();
        this.b = context;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int a(EmoticonPackageModel emoticonPackageModel) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
    public void a(int i) {
    }

    public void a(IRequestHost iRequestHost, List<EmoticonPackageModel> list) {
        this.f11180c = iRequestHost;
        this.f = list;
    }

    @Override // com.blued.android.module.common.widget.emoticon.ui.IViewStateListener
    public void a(EmoticonModel emoticonModel) {
        List<IViewStateListener> list = this.i;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (IViewStateListener iViewStateListener : this.i) {
            iViewStateListener.a(emoticonModel);
        }
    }

    public void a(IViewStateListener iViewStateListener) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        this.i.add(iViewStateListener);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i2;
        post(new Runnable() { // from class: com.blued.android.module.common.widget.emoticon.ui.EmoticonsPageView.1
            @Override // java.lang.Runnable
            public void run() {
                EmoticonsPageView.this.a();
            }
        });
    }

    public void setIViewListener(IViewStateListener iViewStateListener) {
        a(iViewStateListener);
    }

    public void setOnIndicatorListener(OnEmoticonsPageViewListener onEmoticonsPageViewListener) {
        this.j = onEmoticonsPageViewListener;
    }

    public void setPageSelect(int i) {
        if (getAdapter() == null || i < 0 || i >= this.f.size()) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += a(this.f.get(i3));
        }
        setCurrentItem(i2);
    }
}

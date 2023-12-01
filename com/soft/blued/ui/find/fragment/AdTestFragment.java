package com.soft.blued.ui.find.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentAdTestBinding;
import com.soft.blued.databinding.ItemAdTestBinding;
import com.soft.blued.ui.find.fragment.AdTestFragment;
import com.soft.blued.utils.AdTestDataMode;
import com.soft.blued.utils.AdTestManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/AdTestFragment.class */
public final class AdTestFragment extends MvpFragment<MvpPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private FragmentAdTestBinding f30185a;
    private final Ad b = new Ad();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/AdTestFragment$Ad.class */
    public static final class Ad extends BaseMultiItemQuickAdapter<AdTestDataMode, BaseViewHolder> {
        public Ad() {
            super(new ArrayList());
            addItemType(0, R.layout.item_ad_test);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Ad this$0, AdTestDataMode item, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            this$0.getData().remove(item);
            this$0.notifyDataSetChanged();
        }

        private final void b(BaseViewHolder baseViewHolder, final AdTestDataMode adTestDataMode) {
            ItemAdTestBinding a2 = ItemAdTestBinding.a(baseViewHolder.itemView);
            Intrinsics.c(a2, "bind(helper.itemView)");
            int type = adTestDataMode.getType();
            if (type == 1) {
                TextView textView = a2.b;
                textView.setText(getData().indexOf(adTestDataMode) + "      自动刷新列表");
            } else if (type == 2) {
                TextView textView2 = a2.b;
                textView2.setText(getData().indexOf(adTestDataMode) + "      自动滑动列表");
            } else if (type == 3) {
                TextView textView3 = a2.b;
                textView3.setText(getData().indexOf(adTestDataMode) + "     列表 0 位置添加 top 原生广告");
            } else if (type == 4) {
                TextView textView4 = a2.b;
                textView4.setText(getData().indexOf(adTestDataMode) + "      自动刷新Banner1");
            } else if (type == 5) {
                TextView textView5 = a2.b;
                textView5.setText(getData().indexOf(adTestDataMode) + "      自动刷新Banner2");
            }
            a2.f29071a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$Ad$00htsnX8_tyXJiAxZuP5XTTo8wQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdTestFragment.Ad.a(AdTestFragment.Ad.this, adTestDataMode, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, AdTestDataMode item) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(item, "item");
            if (item.getItemType() == 0) {
                b(helper, item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AdTestFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    private final void b() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ShapeTextView shapeTextView;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        FragmentAdTestBinding a2 = FragmentAdTestBinding.a(this.i);
        this.f30185a = a2;
        if (a2 != null && (commonTopTitleNoTrans2 = a2.j) != null) {
            commonTopTitleNoTrans2.setCenterText("广告测试");
        }
        FragmentAdTestBinding fragmentAdTestBinding = this.f30185a;
        if (fragmentAdTestBinding != null && (commonTopTitleNoTrans = fragmentAdTestBinding.j) != null) {
            commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$QGtJVNPCtVVTr3bxwR-X1Mamk84
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdTestFragment.a(AdTestFragment.this, view);
                }
            });
        }
        if (AdTestManager.f34713a.b().a()) {
            FragmentAdTestBinding fragmentAdTestBinding2 = this.f30185a;
            if (fragmentAdTestBinding2 != null && (imageView12 = fragmentAdTestBinding2.f28779c) != null) {
                imageView12.setBackgroundResource(2131237259);
            }
        } else {
            FragmentAdTestBinding fragmentAdTestBinding3 = this.f30185a;
            if (fragmentAdTestBinding3 != null && (imageView = fragmentAdTestBinding3.f28779c) != null) {
                imageView.setBackgroundResource(2131237258);
            }
        }
        if (AdTestManager.f34713a.b().b()) {
            FragmentAdTestBinding fragmentAdTestBinding4 = this.f30185a;
            if (fragmentAdTestBinding4 != null && (imageView11 = fragmentAdTestBinding4.d) != null) {
                imageView11.setBackgroundResource(2131237259);
            }
        } else {
            FragmentAdTestBinding fragmentAdTestBinding5 = this.f30185a;
            if (fragmentAdTestBinding5 != null && (imageView2 = fragmentAdTestBinding5.d) != null) {
                imageView2.setBackgroundResource(2131237258);
            }
        }
        if (AdTestManager.f34713a.b().c()) {
            FragmentAdTestBinding fragmentAdTestBinding6 = this.f30185a;
            if (fragmentAdTestBinding6 != null && (imageView10 = fragmentAdTestBinding6.e) != null) {
                imageView10.setBackgroundResource(2131237259);
            }
        } else {
            FragmentAdTestBinding fragmentAdTestBinding7 = this.f30185a;
            if (fragmentAdTestBinding7 != null && (imageView3 = fragmentAdTestBinding7.e) != null) {
                imageView3.setBackgroundResource(2131237258);
            }
        }
        if (AdTestManager.f34713a.b().f()) {
            FragmentAdTestBinding fragmentAdTestBinding8 = this.f30185a;
            if (fragmentAdTestBinding8 != null && (imageView9 = fragmentAdTestBinding8.b) != null) {
                imageView9.setBackgroundResource(2131237259);
            }
        } else {
            FragmentAdTestBinding fragmentAdTestBinding9 = this.f30185a;
            if (fragmentAdTestBinding9 != null && (imageView4 = fragmentAdTestBinding9.b) != null) {
                imageView4.setBackgroundResource(2131237258);
            }
        }
        FragmentAdTestBinding fragmentAdTestBinding10 = this.f30185a;
        if (fragmentAdTestBinding10 != null && (imageView8 = fragmentAdTestBinding10.f28779c) != null) {
            imageView8.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$_coBvmTUNgMpU0qoQizUXeguGVU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdTestFragment.b(AdTestFragment.this, view);
                }
            });
        }
        FragmentAdTestBinding fragmentAdTestBinding11 = this.f30185a;
        if (fragmentAdTestBinding11 != null && (imageView7 = fragmentAdTestBinding11.d) != null) {
            imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$mCn4yXIpgmPsSNYoyimfhPin1mA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdTestFragment.c(AdTestFragment.this, view);
                }
            });
        }
        FragmentAdTestBinding fragmentAdTestBinding12 = this.f30185a;
        if (fragmentAdTestBinding12 != null && (imageView6 = fragmentAdTestBinding12.e) != null) {
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$lqmxLPzvXsPe6aGl6vhN_PPa684
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdTestFragment.d(AdTestFragment.this, view);
                }
            });
        }
        FragmentAdTestBinding fragmentAdTestBinding13 = this.f30185a;
        if (fragmentAdTestBinding13 != null && (imageView5 = fragmentAdTestBinding13.b) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$SISZeb-tIvrOHFEopomxziEvt3Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdTestFragment.e(AdTestFragment.this, view);
                }
            });
        }
        FragmentAdTestBinding fragmentAdTestBinding14 = this.f30185a;
        if (fragmentAdTestBinding14 == null || (shapeTextView = fragmentAdTestBinding14.f28778a) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdTestFragment$YHEBRU1LFJS6VbYwfHvwE28GtOc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdTestFragment.f(AdTestFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdTestFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (AdTestManager.f34713a.b().a()) {
            FragmentAdTestBinding fragmentAdTestBinding = this$0.f30185a;
            if (fragmentAdTestBinding != null && (imageView2 = fragmentAdTestBinding.f28779c) != null) {
                imageView2.setBackgroundResource(2131237258);
            }
            AdTestManager.f34713a.b().a(false);
            return;
        }
        FragmentAdTestBinding fragmentAdTestBinding2 = this$0.f30185a;
        if (fragmentAdTestBinding2 != null && (imageView = fragmentAdTestBinding2.f28779c) != null) {
            imageView.setBackgroundResource(2131237259);
        }
        AdTestManager.f34713a.b().a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AdTestFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (AdTestManager.f34713a.b().b()) {
            FragmentAdTestBinding fragmentAdTestBinding = this$0.f30185a;
            if (fragmentAdTestBinding != null && (imageView2 = fragmentAdTestBinding.d) != null) {
                imageView2.setBackgroundResource(2131237258);
            }
            AdTestManager.f34713a.b().a(-1);
            AdTestManager.f34713a.b().b(false);
            return;
        }
        AdTestManager.f34713a.b().a(0);
        FragmentAdTestBinding fragmentAdTestBinding2 = this$0.f30185a;
        if (fragmentAdTestBinding2 != null && (imageView = fragmentAdTestBinding2.d) != null) {
            imageView.setBackgroundResource(2131237259);
        }
        AdTestManager.f34713a.b().b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AdTestFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (AdTestManager.f34713a.b().c()) {
            FragmentAdTestBinding fragmentAdTestBinding = this$0.f30185a;
            if (fragmentAdTestBinding != null && (imageView2 = fragmentAdTestBinding.e) != null) {
                imageView2.setBackgroundResource(2131237258);
            }
            AdTestManager.f34713a.b().c(false);
            return;
        }
        FragmentAdTestBinding fragmentAdTestBinding2 = this$0.f30185a;
        if (fragmentAdTestBinding2 != null && (imageView = fragmentAdTestBinding2.e) != null) {
            imageView.setBackgroundResource(2131237259);
        }
        AdTestManager.f34713a.b().c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AdTestFragment this$0, View view) {
        ImageView imageView;
        ImageView imageView2;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (AdTestManager.f34713a.b().f()) {
            FragmentAdTestBinding fragmentAdTestBinding = this$0.f30185a;
            if (fragmentAdTestBinding != null && (imageView2 = fragmentAdTestBinding.b) != null) {
                imageView2.setBackgroundResource(2131237258);
            }
            AdTestManager.f34713a.b().d(false);
            return;
        }
        FragmentAdTestBinding fragmentAdTestBinding2 = this$0.f30185a;
        if (fragmentAdTestBinding2 != null && (imageView = fragmentAdTestBinding2.b) != null) {
            imageView.setBackgroundResource(2131237259);
        }
        AdTestManager.f34713a.b().d(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AdTestFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        ArrayList<AdTestDataMode> arrayList = new ArrayList<>();
        if (AdTestManager.f34713a.b().f()) {
            arrayList.add(new AdTestDataMode(1));
        }
        if (AdTestManager.f34713a.b().a()) {
            arrayList.add(new AdTestDataMode(4));
        }
        if (AdTestManager.f34713a.b().b()) {
            arrayList.add(new AdTestDataMode(5));
        }
        if (AdTestManager.f34713a.b().c()) {
            arrayList.add(new AdTestDataMode(3));
        }
        if (arrayList.size() > 0) {
            AdTestManager.f34713a.a(true);
            AdTestManager.f34713a.b().a(arrayList);
            ToastUtils.a("开启广告自动");
        }
        this$0.t();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_ad_test;
    }
}

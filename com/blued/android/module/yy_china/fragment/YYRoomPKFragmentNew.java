package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.yy_china.databinding.FragmentYyRoomPkLayoutBinding;
import com.blued.android.module.yy_china.view.YYPkInfoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomPKFragmentNew.class */
public final class YYRoomPKFragmentNew extends YYRoomPKFragment {
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomPKFragmentNew$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseDialogFragment a() {
            Bundle bundle = new Bundle();
            YYRoomPKFragmentNew yYRoomPKFragmentNew = new YYRoomPKFragmentNew();
            yYRoomPKFragmentNew.setArguments(bundle);
            return yYRoomPKFragmentNew;
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomPKFragmentNew$PKAdapterNew.class */
    public final class PKAdapterNew extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRoomPKFragmentNew f17445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PKAdapterNew(YYRoomPKFragmentNew this$0) {
            super(this$0.getChildFragmentManager(), 1);
            Intrinsics.e(this$0, "this$0");
            this.f17445a = this$0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return i != 0 ? i != 1 ? new Fragment() : new YYPageLevelFragmentNew() : new YYPagePkFragmentNew();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return i != 0 ? i != 1 ? "" : "房间等级" : "房间PK";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRoomPKFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        new YYPkInfoView().show(this$0.getChildFragmentManager(), "YYPkInfoView");
    }

    @Override // com.blued.android.module.yy_china.fragment.YYRoomPKFragment
    public void g() {
        ImageView imageView;
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        PKAdapterNew pKAdapterNew = new PKAdapterNew(this);
        FragmentYyRoomPkLayoutBinding f = f();
        ViewPager viewPager = f == null ? null : f.f16550c;
        if (viewPager != null) {
            viewPager.setAdapter(pKAdapterNew);
        }
        FragmentYyRoomPkLayoutBinding f2 = f();
        if (f2 != null && (tabPageIndicatorWithDot = f2.d) != null) {
            FragmentYyRoomPkLayoutBinding f3 = f();
            tabPageIndicatorWithDot.setViewPager(f3 == null ? null : f3.f16550c);
        }
        FragmentYyRoomPkLayoutBinding f4 = f();
        ViewPager viewPager2 = f4 == null ? null : f4.f16550c;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        FragmentYyRoomPkLayoutBinding f5 = f();
        ViewPager viewPager3 = f5 == null ? null : f5.f16550c;
        if (viewPager3 != null) {
            viewPager3.setOffscreenPageLimit(1);
        }
        FragmentYyRoomPkLayoutBinding f6 = f();
        if (f6 == null || (imageView = f6.b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRoomPKFragmentNew$10UVmfV9jpdk2T1TEfihjlJANCQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRoomPKFragmentNew.a(YYRoomPKFragmentNew.this, view);
            }
        });
    }
}

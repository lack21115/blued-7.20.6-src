package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogGiftExhibitionLayoutBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeThemeModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftExhibitionDialog.class */
public final class YYGiftExhibitionDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private String f17254a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f17255c;
    private DialogGiftExhibitionLayoutBinding d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYGiftExhibitionDialog$GiftExhibitionPagerAdapter.class */
    public final class GiftExhibitionPagerAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYGiftExhibitionDialog f17256a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GiftExhibitionPagerAdapter(YYGiftExhibitionDialog this$0, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(fm, "fm");
            this.f17256a = this$0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return i == 0 ? new YYGiftExhibitionAllFragment(this.f17256a.f(), this.f17256a.g(), this.f17256a.h()) : new YYGiftExhibitionStarFragment(this.f17256a.f(), this.f17256a.g(), this.f17256a.h());
        }
    }

    public YYGiftExhibitionDialog(String str, String str2, String str3) {
        this.f17254a = str;
        this.b = str2;
        this.f17255c = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        if (i == 0) {
            LogUtils.d("埋点", "上报YY_GIFT_WALL_EXHIBITION_PAGE_ALL_CLICK");
            EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_EXHIBITION_PAGE_ALL_CLICK, b.room_id, b.uid);
        } else if (i != 1) {
        } else {
            LogUtils.d("埋点", "上报YY_GIFT_WALL_EXHIBITION_PAGE_STAR_CLICK");
            EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_EXHIBITION_PAGE_STAR_CLICK, b.room_id, b.uid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("event_yy_game").post(YYRoomInfoManager.e().c(11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGiftExhibitionDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYGiftExhibitionDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogGiftExhibitionLayoutBinding i() {
        DialogGiftExhibitionLayoutBinding dialogGiftExhibitionLayoutBinding = this.d;
        Intrinsics.a(dialogGiftExhibitionLayoutBinding);
        return dialogGiftExhibitionLayoutBinding;
    }

    private final void j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HomeThemeModel(0, "全部", "", "", null, 16, null));
        arrayList.add(new HomeThemeModel(1, "星座", "", "", null, 16, null));
        YYHomeThemeTabView yYHomeThemeTabView = i().e;
        ViewPager viewPager = i().g;
        Intrinsics.c(viewPager, "bind.viewPager");
        yYHomeThemeTabView.a(viewPager);
        i().e.a(arrayList, false, R.color.syc_dark_b, R.color.syc_D0D0D0);
        k();
    }

    private final void k() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        i().g.setAdapter(new GiftExhibitionPagerAdapter(this, childFragmentManager));
        i().g.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYGiftExhibitionDialog$initRoomPager$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DialogGiftExhibitionLayoutBinding i2;
                YYGiftExhibitionDialog.this.a(i);
                i2 = YYGiftExhibitionDialog.this.i();
                i2.e.setToolBtnSelect(i);
            }
        });
    }

    public final String f() {
        return this.f17254a;
    }

    public final String g() {
        return this.b;
    }

    public final String h() {
        return this.f17255c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.d = DialogGiftExhibitionLayoutBinding.a(inflater.inflate(R.layout.dialog_gift_exhibition_layout, viewGroup, true));
        j();
        i().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftExhibitionDialog$vwe6PRIyb7UQd2YYMmdGkZDo2RM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftExhibitionDialog.a(YYGiftExhibitionDialog.this, view);
            }
        });
        i().f16341c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftExhibitionDialog$xo5ZoQVfCwNv9IDmuhJDwJM14x8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftExhibitionDialog.b(YYGiftExhibitionDialog.this, view);
            }
        });
        i().f16340a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYGiftExhibitionDialog$PyY8KxWe0LfFMSB7xoXSg7R5tOY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftExhibitionDialog.a(view);
            }
        });
        DialogGiftExhibitionLayoutBinding dialogGiftExhibitionLayoutBinding = this.d;
        return dialogGiftExhibitionLayoutBinding == null ? null : dialogGiftExhibitionLayoutBinding.getRoot();
    }
}

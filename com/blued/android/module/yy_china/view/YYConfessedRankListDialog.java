package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYConfessedRankAdapter;
import com.blued.android.module.yy_china.databinding.DialogConfessedRankBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConfessedRankListDialog.class */
public final class YYConfessedRankListDialog extends BaseFullScreenDialog {
    private DialogConfessedRankBinding a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedRankListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        LiveEventBus.get("show_inner_dialog").post(YYRoomInfoManager.e().c().a(19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYConfessedRankListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYConfessedRankListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().k.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYConfessedRankListDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().k.setCurrentItem(1);
    }

    private final DialogConfessedRankBinding f() {
        DialogConfessedRankBinding dialogConfessedRankBinding = this.a;
        Intrinsics.a(dialogConfessedRankBinding);
        return dialogConfessedRankBinding;
    }

    private final void g() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        PagerAdapter yYConfessedRankAdapter = new YYConfessedRankAdapter(childFragmentManager);
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_rank_list_url_bg")).a(f().e);
        ImageLoader.a(a(), ImgURLMap.a.a("yy_confessed_rank_list_url_top_bg")).a(f().g);
        yYConfessedRankAdapter.a(1);
        f().k.setAdapter(yYConfessedRankAdapter);
        f().k.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.view.YYConfessedRankListDialog$initView$1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                YYConfessedRankListDialog.this.a(i == 0);
            }
        });
        f().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRankListDialog$YTMArsCHTLIPYiMUSVSf5kfX44c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankListDialog.a(YYConfessedRankListDialog.this, view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRankListDialog$nk5NlUJHvmP8kFod7_-K26VQlUw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankListDialog.a(view);
            }
        });
        f().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRankListDialog$JWVVodHQ_MmUuoiaK1Y5xo3-Xx8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankListDialog.b(YYConfessedRankListDialog.this, view);
            }
        });
        f().j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRankListDialog$aexuuhENMi_IooK6tUlIe_G3glw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankListDialog.c(YYConfessedRankListDialog.this, view);
            }
        });
        f().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRankListDialog$CNFnetmS0VawQb--k-wKn7z_NwY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankListDialog.d(YYConfessedRankListDialog.this, view);
            }
        });
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYConfessedRankListDialog$2xvOSEvmVG3SJ0iNdnn1Zv-VhI0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankListDialog.b(view);
            }
        });
        a(true);
    }

    public final void a(boolean z) {
        if (z) {
            f().j.setTextColor(getResources().getColor(R.color.white));
            f().h.setVisibility(0);
            f().i.setTextColor(getResources().getColor(R.color.white_alpha70));
            f().c.setVisibility(8);
            return;
        }
        f().j.setTextColor(getResources().getColor(R.color.white_alpha70));
        f().h.setVisibility(8);
        f().i.setTextColor(getResources().getColor(R.color.white));
        f().c.setVisibility(0);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_confessed_rank, (ViewGroup) null);
        this.a = DialogConfessedRankBinding.a(inflate);
        g();
        return inflate;
    }
}

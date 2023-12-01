package com.blued.android.module.yy_china.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRomanticGuidebookBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeThemeModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/dialog/YYRomanticGuidebookDialog.class */
public final class YYRomanticGuidebookDialog extends BaseFullScreenDialog {
    private DialogRomanticGuidebookBinding b;

    /* renamed from: a  reason: collision with root package name */
    private final String f16990a = "https://web.bldimg.com/image-manager/1687695915_34082.png";

    /* renamed from: c  reason: collision with root package name */
    private String f16991c = "";
    private String d = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/dialog/YYRomanticGuidebookDialog$GuidebookPageAdapter.class */
    public final class GuidebookPageAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYRomanticGuidebookDialog f16992a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuidebookPageAdapter(YYRomanticGuidebookDialog this$0) {
            super(this$0.getChildFragmentManager(), 1);
            Intrinsics.e(this$0, "this$0");
            this.f16992a = this$0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
                bundleOf.putString("type", "1");
                bundleOf.putString("user_id", this.f16992a.f16991c);
                YYGuidebookWeekFragment yYGuidebookWeekFragment = new YYGuidebookWeekFragment();
                yYGuidebookWeekFragment.setArguments(bundleOf);
                return yYGuidebookWeekFragment;
            } else if (i != 1) {
                return new Fragment();
            } else {
                Bundle bundleOf2 = BundleKt.bundleOf(new Pair[0]);
                bundleOf2.putString("type", "2");
                bundleOf2.putString("user_id", this.f16992a.f16991c);
                YYGuidebookWeekFragment yYGuidebookWeekFragment2 = new YYGuidebookWeekFragment();
                yYGuidebookWeekFragment2.setArguments(bundleOf2);
                return yYGuidebookWeekFragment2;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return i != 0 ? i != 1 ? "" : "全部" : "一周内";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRomanticGuidebookDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRomanticGuidebookDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_ROMANTIC_RULE_PAGE_SHOW, b.room_id, b.uid);
        }
        LiveEventBus.get("show_inner_dialog").post(YYRoomInfoManager.e().c().a(17));
    }

    private final void f() {
        GuidebookPageAdapter guidebookPageAdapter = new GuidebookPageAdapter(this);
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding2 = dialogRomanticGuidebookBinding;
        if (dialogRomanticGuidebookBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding2 = null;
        }
        dialogRomanticGuidebookBinding2.g.setAdapter(guidebookPageAdapter);
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding3 = this.b;
        if (dialogRomanticGuidebookBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding3 = null;
        }
        dialogRomanticGuidebookBinding3.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.dialog.YYRomanticGuidebookDialog$initViewPager$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding4;
                dialogRomanticGuidebookBinding4 = YYRomanticGuidebookDialog.this.b;
                DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding5 = dialogRomanticGuidebookBinding4;
                if (dialogRomanticGuidebookBinding4 == null) {
                    Intrinsics.c("mBinding");
                    dialogRomanticGuidebookBinding5 = null;
                }
                dialogRomanticGuidebookBinding5.f.setToolBtnSelect(i);
            }
        });
    }

    private final void g() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(R.color.syc_dark_b));
        ArrayList arrayList3 = arrayList2;
        arrayList.add(new HomeThemeModel(0, "一周内", "", "", arrayList3));
        arrayList.add(new HomeThemeModel(1, "全部", "", "", arrayList3));
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding2 = dialogRomanticGuidebookBinding;
        if (dialogRomanticGuidebookBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding2 = null;
        }
        YYHomeThemeTabView yYHomeThemeTabView = dialogRomanticGuidebookBinding2.f;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding3 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding4 = dialogRomanticGuidebookBinding3;
        if (dialogRomanticGuidebookBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding4 = null;
        }
        ViewPager viewPager = dialogRomanticGuidebookBinding4.g;
        Intrinsics.c(viewPager, "mBinding.llViewPager");
        yYHomeThemeTabView.a(viewPager);
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding5 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding6 = dialogRomanticGuidebookBinding5;
        if (dialogRomanticGuidebookBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding6 = null;
        }
        dialogRomanticGuidebookBinding6.f.setTextHighlightSize(17.0f);
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding7 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding8 = dialogRomanticGuidebookBinding7;
        if (dialogRomanticGuidebookBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding8 = null;
        }
        dialogRomanticGuidebookBinding8.f.setTextNormalSize(17.0f);
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding9 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding10 = dialogRomanticGuidebookBinding9;
        if (dialogRomanticGuidebookBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding10 = null;
        }
        dialogRomanticGuidebookBinding10.f.setUnderLineTopMargin(DensityUtils.a(getContext(), 15.0f));
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding11 = this.b;
        if (dialogRomanticGuidebookBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding11 = null;
        }
        dialogRomanticGuidebookBinding11.f.a(arrayList, false, R.color.syc_dark_b, R.color.syc_tran70_FFFFFF);
        f();
    }

    private final void h() {
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding2 = dialogRomanticGuidebookBinding;
        if (dialogRomanticGuidebookBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding2 = null;
        }
        dialogRomanticGuidebookBinding2.f16397a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticGuidebookDialog$ki5b34Zzug6xGT_lKXGh1WSceTU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRomanticGuidebookDialog.a(YYRomanticGuidebookDialog.this, view);
            }
        });
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding3 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding4 = dialogRomanticGuidebookBinding3;
        if (dialogRomanticGuidebookBinding3 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding4 = null;
        }
        dialogRomanticGuidebookBinding4.f16398c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticGuidebookDialog$vpjYazeJRa8wteEQem8zMksoge4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRomanticGuidebookDialog.b(YYRomanticGuidebookDialog.this, view);
            }
        });
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding5 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding6 = dialogRomanticGuidebookBinding5;
        if (dialogRomanticGuidebookBinding5 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding6 = null;
        }
        dialogRomanticGuidebookBinding6.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticGuidebookDialog$BWyhLsir7LnHEtAw-OPXJcGDKaE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRomanticGuidebookDialog.a(view);
            }
        });
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding7 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding8 = dialogRomanticGuidebookBinding7;
        if (dialogRomanticGuidebookBinding7 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding8 = null;
        }
        dialogRomanticGuidebookBinding8.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticGuidebookDialog$ctosYPHGQSbHoSZ6RkcArhLK3pQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRomanticGuidebookDialog.b(view);
            }
        });
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding9 = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding10 = dialogRomanticGuidebookBinding9;
        if (dialogRomanticGuidebookBinding9 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding10 = null;
        }
        dialogRomanticGuidebookBinding10.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.dialog.-$$Lambda$YYRomanticGuidebookDialog$xGnkT1EubDw2HHdwPGhvMhQx2EI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRomanticGuidebookDialog.c(view);
            }
        });
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding11 = this.b;
        if (dialogRomanticGuidebookBinding11 == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding11 = null;
        }
        dialogRomanticGuidebookBinding11.j.setText(this.d);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f16991c = String.valueOf(arguments == null ? null : arguments.getString("user_id"));
        Bundle arguments2 = getArguments();
        this.d = String.valueOf(arguments2 == null ? null : arguments2.getString("user_name"));
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_romantic_guidebook, (ViewGroup) null);
        DialogRomanticGuidebookBinding a2 = DialogRomanticGuidebookBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        this.b = a2;
        h();
        g();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        ImageWrapper a2 = ImageLoader.a(a(), this.f16990a).a(12.0f, 12.0f, 0.0f, 0.0f);
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding = this.b;
        DialogRomanticGuidebookBinding dialogRomanticGuidebookBinding2 = dialogRomanticGuidebookBinding;
        if (dialogRomanticGuidebookBinding == null) {
            Intrinsics.c("mBinding");
            dialogRomanticGuidebookBinding2 = null;
        }
        a2.a(dialogRomanticGuidebookBinding2.b);
    }
}

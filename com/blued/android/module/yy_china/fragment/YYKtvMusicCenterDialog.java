package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentResultListener;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.live.base.music.model.YYKtvMusicTypeModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvMusicCenterBinding;
import com.blued.android.module.yy_china.fragment.YYKtvMusicCenterDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYKtvCardModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.view.YYKtvSendGiftSongNumView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvMusicCenterDialog.class */
public final class YYKtvMusicCenterDialog extends BaseFullScreenDialog implements OnCLickSingNumListener {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f17301a = new Companion(null);
    private FragmentYyKtvMusicCenterBinding b;

    /* renamed from: c  reason: collision with root package name */
    private MusicAdapter f17302c;
    private BaseYYStudioFragment d;
    private YYKtvCardModel e;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvMusicCenterDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvMusicCenterDialog$MusicAdapter.class */
    public final class MusicAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YYKtvMusicCenterDialog f17303a;
        private List<? extends YYKtvMusicTypeModel> b;

        /* renamed from: c  reason: collision with root package name */
        private OnCLickSingNumListener f17304c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MusicAdapter(YYKtvMusicCenterDialog this$0) {
            super(this$0.getChildFragmentManager(), 1);
            Intrinsics.e(this$0, "this$0");
            this.f17303a = this$0;
        }

        public final void a(OnCLickSingNumListener onCLickSingNumListener) {
            this.f17304c = onCLickSingNumListener;
        }

        public final void a(List<? extends YYKtvMusicTypeModel> list) {
            Intrinsics.e(list, "list");
            this.b = list;
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<? extends YYKtvMusicTypeModel> list = this.b;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            List<? extends YYKtvMusicTypeModel> list2 = this.b;
            Integer valueOf = list2 == null ? null : Integer.valueOf(list2.size());
            Intrinsics.a(valueOf);
            return valueOf.intValue();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            YYKtvMusicTypeModel yYKtvMusicTypeModel;
            String str;
            List<? extends YYKtvMusicTypeModel> list = this.b;
            YYKtvMusicListFragment yYKtvMusicListFragment = null;
            if (list != null && (yYKtvMusicTypeModel = list.get(i)) != null && (str = yYKtvMusicTypeModel.sheetId) != null) {
                yYKtvMusicListFragment = new YYKtvMusicListFragment(str);
            }
            if (yYKtvMusicListFragment != null) {
                yYKtvMusicListFragment.a(this.f17304c);
            }
            if (yYKtvMusicListFragment != null) {
                return yYKtvMusicListFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.Fragment");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            YYKtvMusicTypeModel yYKtvMusicTypeModel;
            List<? extends YYKtvMusicTypeModel> list = this.b;
            String str = null;
            if (list != null && (yYKtvMusicTypeModel = list.get(i)) != null) {
                str = yYKtvMusicTypeModel.sheetName;
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvMusicCenterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvMusicCenterDialog this$0, YYKtvCardModel singleData, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(singleData, "$singleData");
        YYKtvSendGiftSongNumView yYKtvSendGiftSongNumView = new YYKtvSendGiftSongNumView();
        yYKtvSendGiftSongNumView.a(this$0.d);
        yYKtvSendGiftSongNumView.a(singleData);
        yYKtvSendGiftSongNumView.show(this$0.getParentFragmentManager(), "YYKtvSendGiftSongNumView");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvMusicCenterDialog this$0, String noName_0, Bundle noName_1) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(noName_0, "$noName_0");
        Intrinsics.e(noName_1, "$noName_1");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYKtvMusicCenterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYKtvSearchMusicDialog yYKtvSearchMusicDialog = new YYKtvSearchMusicDialog();
        yYKtvSearchMusicDialog.a(this$0.e);
        yYKtvSearchMusicDialog.a(this$0.d);
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYKtvSearchMusicDialog.show(parentFragmentManager, "search_music_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final YYKtvCardModel yYKtvCardModel) {
        ShapeTextView shapeTextView;
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding = this.b;
        if (fragmentYyKtvMusicCenterBinding == null || (shapeTextView = fragmentYyKtvMusicCenterBinding.e) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvMusicCenterDialog$tJAAFy8QvF-6A3-fU20Qw9f9HQY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYKtvMusicCenterDialog.a(YYKtvMusicCenterDialog.this, yYKtvCardModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        TabPageIndicatorWithDot tabPageIndicatorWithDot2;
        TabPageIndicatorWithDot tabPageIndicatorWithDot3;
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding = this.b;
        TabPageIndicatorWithDot tabPageIndicatorWithDot4 = fragmentYyKtvMusicCenterBinding == null ? null : fragmentYyKtvMusicCenterBinding.d;
        if (tabPageIndicatorWithDot4 != null) {
            tabPageIndicatorWithDot4.setTabPaddingLeftRight(16);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding2 = this.b;
        if (fragmentYyKtvMusicCenterBinding2 != null && (tabPageIndicatorWithDot3 = fragmentYyKtvMusicCenterBinding2.d) != null) {
            tabPageIndicatorWithDot3.setTabTextColorUnfocused(R.color.syc_989898);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding3 = this.b;
        TabPageIndicatorWithDot tabPageIndicatorWithDot5 = fragmentYyKtvMusicCenterBinding3 == null ? null : fragmentYyKtvMusicCenterBinding3.d;
        if (tabPageIndicatorWithDot5 != null) {
            tabPageIndicatorWithDot5.setTextColor(R.color.syc_EAEAEA);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding4 = this.b;
        if (fragmentYyKtvMusicCenterBinding4 != null && (tabPageIndicatorWithDot2 = fragmentYyKtvMusicCenterBinding4.d) != null) {
            tabPageIndicatorWithDot2.setIndicatorColor(R.color.syc_a);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding5 = this.b;
        if (fragmentYyKtvMusicCenterBinding5 == null || (tabPageIndicatorWithDot = fragmentYyKtvMusicCenterBinding5.d) == null) {
            return;
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding6 = this.b;
        tabPageIndicatorWithDot.setViewPager(fragmentYyKtvMusicCenterBinding6 == null ? null : fragmentYyKtvMusicCenterBinding6.f16518c);
    }

    @Override // com.blued.android.module.yy_china.fragment.OnCLickSingNumListener
    public boolean Z_() {
        YYKtvCardModel yYKtvCardModel;
        String str;
        YYKtvCardModel yYKtvCardModel2 = this.e;
        if ((yYKtvCardModel2 == null ? null : yYKtvCardModel2.sing_limit) == null) {
            return false;
        }
        if (StringUtils.a(this.e == null ? null : yYKtvCardModel.sing_limit, 0) > 0) {
            return true;
        }
        YYKtvCardModel yYKtvCardModel3 = this.e;
        Long valueOf = yYKtvCardModel3 == null ? null : Long.valueOf(yYKtvCardModel3.free_sing_limit);
        Intrinsics.a(valueOf);
        if (valueOf.longValue() > 0) {
            return true;
        }
        BaseYYStudioFragment baseYYStudioFragment = this.d;
        if (baseYYStudioFragment != null) {
            YYKtvCardModel yYKtvCardModel4 = this.e;
            if (yYKtvCardModel4 == null) {
                str = null;
            } else {
                YYGiftModel yYGiftModel = yYKtvCardModel4.goods_info;
                str = yYGiftModel == null ? null : yYGiftModel.goods_id;
            }
            baseYYStudioFragment.b(str, "");
        }
        dismiss();
        return false;
    }

    public final void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.d = baseYYStudioFragment;
    }

    public final void a(YYKtvCardModel yYKtvCardModel) {
        this.e = yYKtvCardModel;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getChildFragmentManager().setFragmentResultListener("key_cancel", this, new FragmentResultListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvMusicCenterDialog$cCymYaBueOZuVe0D_F5cKB6jq5Y
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                YYKtvMusicCenterDialog.a(YYKtvMusicCenterDialog.this, str, bundle2);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_music_center, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_center, container, true)");
        FragmentYyKtvMusicCenterBinding a2 = FragmentYyKtvMusicCenterBinding.a(inflate);
        this.b = a2;
        if (a2 != null && (view = a2.f16517a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvMusicCenterDialog$cQv9iAXrYe1walnduSj9KsQeep8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvMusicCenterDialog.a(YYKtvMusicCenterDialog.this, view2);
                }
            });
        }
        MusicAdapter musicAdapter = new MusicAdapter(this);
        this.f17302c = musicAdapter;
        if (musicAdapter != null) {
            musicAdapter.a(this);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding = this.b;
        ViewPager viewPager = fragmentYyKtvMusicCenterBinding == null ? null : fragmentYyKtvMusicCenterBinding.f16518c;
        if (viewPager != null) {
            viewPager.setAdapter(this.f17302c);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding2 = this.b;
        ViewPager viewPager2 = fragmentYyKtvMusicCenterBinding2 == null ? null : fragmentYyKtvMusicCenterBinding2.f16518c;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(0);
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding3 = this.b;
        ViewPager viewPager3 = fragmentYyKtvMusicCenterBinding3 == null ? null : fragmentYyKtvMusicCenterBinding3.f16518c;
        if (viewPager3 == null) {
            return inflate;
        }
        viewPager3.setOffscreenPageLimit(1);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ShapeLinearLayout shapeLinearLayout;
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        YYRoomModel b = YYRoomInfoManager.e().b();
        String str = b == null ? null : b.room_id;
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.q(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvMusicTypeModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYKtvMusicCenterDialog$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYKtvMusicTypeModel> bluedEntityA) {
                YYKtvMusicCenterDialog.MusicAdapter musicAdapter;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                musicAdapter = YYKtvMusicCenterDialog.this.f17302c;
                if (musicAdapter != null) {
                    List<YYKtvMusicTypeModel> list = bluedEntityA.data;
                    Intrinsics.c(list, "result.data");
                    musicAdapter.a(list);
                }
                YYKtvMusicCenterDialog.this.f();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
            }
        }, a());
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding = this.b;
        if (fragmentYyKtvMusicCenterBinding != null && (shapeLinearLayout = fragmentYyKtvMusicCenterBinding.b) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvMusicCenterDialog$v5pga0kpGsztJNqrHI10CM73LdU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvMusicCenterDialog.b(YYKtvMusicCenterDialog.this, view2);
                }
            });
        }
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding2 = this.b;
        ShapeTextView shapeTextView = fragmentYyKtvMusicCenterBinding2 == null ? null : fragmentYyKtvMusicCenterBinding2.e;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(8);
        }
        YYRoomModel b2 = YYRoomInfoManager.e().b();
        if (b2 == null) {
            return;
        }
        String str2 = b2.room_id;
        final ActivityFragmentActive a3 = a();
        YYRoomHttpUtils.k(str2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYKtvCardModel>>(a3) { // from class: com.blued.android.module.yy_china.fragment.YYKtvMusicCenterDialog$onViewCreated$3$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYKtvCardModel> bluedEntityA) {
                FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding3;
                FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding4;
                YYKtvCardModel singleData;
                FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding5;
                FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding6;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYKtvMusicCenterDialog.this.a(bluedEntityA.getSingleData());
                fragmentYyKtvMusicCenterBinding3 = YYKtvMusicCenterDialog.this.b;
                ShapeTextView shapeTextView2 = fragmentYyKtvMusicCenterBinding3 == null ? null : fragmentYyKtvMusicCenterBinding3.e;
                if (shapeTextView2 != null) {
                    shapeTextView2.setVisibility(0);
                }
                fragmentYyKtvMusicCenterBinding4 = YYKtvMusicCenterDialog.this.b;
                ShapeTextView shapeTextView3 = fragmentYyKtvMusicCenterBinding4 == null ? null : fragmentYyKtvMusicCenterBinding4.e;
                if (shapeTextView3 != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string = YYKtvMusicCenterDialog.this.getResources().getString(R.string.yy_ktv_available_amount);
                    Intrinsics.c(string, "resources.getString(R.st….yy_ktv_available_amount)");
                    YYKtvCardModel singleData2 = bluedEntityA.getSingleData();
                    String format = String.format(string, Arrays.copyOf(new Object[]{singleData2 == null ? null : singleData2.sing_limit}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    shapeTextView3.setText(format);
                }
                if (YYRoomInfoManager.e().y() && (singleData = bluedEntityA.getSingleData()) != null) {
                    YYKtvMusicCenterDialog yYKtvMusicCenterDialog = YYKtvMusicCenterDialog.this;
                    if (singleData.free_sing_limit > 0) {
                        fragmentYyKtvMusicCenterBinding6 = yYKtvMusicCenterDialog.b;
                        ShapeTextView shapeTextView4 = fragmentYyKtvMusicCenterBinding6 == null ? null : fragmentYyKtvMusicCenterBinding6.e;
                        if (shapeTextView4 != null) {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                            String string2 = yYKtvMusicCenterDialog.getString(R.string.yy_ktv_available_amount_feel);
                            Intrinsics.c(string2, "getString(R.string.yy_ktv_available_amount_feel)");
                            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Long.valueOf(singleData.free_sing_limit)}, 1));
                            Intrinsics.c(format2, "format(format, *args)");
                            shapeTextView4.setText(format2);
                        }
                    }
                    String str3 = singleData.sing_limit;
                    Intrinsics.c(str3, "sing.sing_limit");
                    if (Long.parseLong(str3) > 0) {
                        fragmentYyKtvMusicCenterBinding5 = yYKtvMusicCenterDialog.b;
                        ShapeTextView shapeTextView5 = fragmentYyKtvMusicCenterBinding5 == null ? null : fragmentYyKtvMusicCenterBinding5.e;
                        if (shapeTextView5 != null) {
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
                            String string3 = yYKtvMusicCenterDialog.getResources().getString(R.string.yy_ktv_available_amount);
                            Intrinsics.c(string3, "resources.getString(R.st….yy_ktv_available_amount)");
                            YYKtvCardModel singleData3 = bluedEntityA.getSingleData();
                            String format3 = String.format(string3, Arrays.copyOf(new Object[]{singleData3 == null ? null : singleData3.sing_limit}, 1));
                            Intrinsics.c(format3, "format(format, *args)");
                            shapeTextView5.setText(format3);
                        }
                    }
                }
                YYKtvMusicCenterDialog yYKtvMusicCenterDialog2 = YYKtvMusicCenterDialog.this;
                YYKtvCardModel singleData4 = bluedEntityA.getSingleData();
                Intrinsics.c(singleData4, "music.singleData");
                yYKtvMusicCenterDialog2.b(singleData4);
            }
        }, a());
    }
}

package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYConfessedRankItemAdapter;
import com.blued.android.module.yy_china.databinding.FragmentConfessedRankBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYConfessedRankFragment.class */
public final class YYConfessedRankFragment extends MvpFragment<MvpPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private FragmentConfessedRankBinding f17163a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f17164c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYConfessedRankFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.c().e.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYConfessedRankFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.c().e.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentConfessedRankBinding c() {
        FragmentConfessedRankBinding fragmentConfessedRankBinding = this.f17163a;
        Intrinsics.a(fragmentConfessedRankBinding);
        return fragmentConfessedRankBinding;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f17163a = FragmentConfessedRankBinding.a(this.i);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        YYConfessedRankItemAdapter yYConfessedRankItemAdapter = new YYConfessedRankItemAdapter(childFragmentManager);
        yYConfessedRankItemAdapter.a(this.b);
        ImageLoader.a(getFragmentActive(), ImgURLMap.f10885a.a("yy_confessed_rank_url_btn_bg")).a(c().b);
        c().e.setAdapter(yYConfessedRankItemAdapter);
        c().e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYConfessedRankFragment$onInitView$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                FragmentConfessedRankBinding c2;
                FragmentConfessedRankBinding c3;
                FragmentConfessedRankBinding c4;
                FragmentConfessedRankBinding c5;
                FragmentConfessedRankBinding c6;
                ConstraintSet constraintSet = new ConstraintSet();
                c2 = YYConfessedRankFragment.this.c();
                constraintSet.clone(c2.f16470a);
                c3 = YYConfessedRankFragment.this.c();
                int id = c3.b.getId();
                c4 = YYConfessedRankFragment.this.c();
                c5 = YYConfessedRankFragment.this.c();
                constraintSet.setMargin(id, 1, (int) ((c4.b.getWidth() * i) + (c5.b.getWidth() * f)));
                c6 = YYConfessedRankFragment.this.c();
                constraintSet.applyTo(c6.f16470a);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                FragmentConfessedRankBinding c2;
                FragmentConfessedRankBinding c3;
                FragmentConfessedRankBinding c4;
                FragmentConfessedRankBinding c5;
                if (i == 0) {
                    c4 = YYConfessedRankFragment.this.c();
                    c4.d.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.color_300067));
                    c5 = YYConfessedRankFragment.this.c();
                    c5.f16471c.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.white_alpha70));
                    return;
                }
                c2 = YYConfessedRankFragment.this.c();
                c2.f16471c.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.color_300067));
                c3 = YYConfessedRankFragment.this.c();
                c3.d.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.white_alpha70));
                if (YYConfessedRankFragment.this.b()) {
                    return;
                }
                if (StringUtils.a(YYConfessedRankFragment.this.getType(), "1")) {
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b != null) {
                        EventTrackYY.d(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_ALL_TIME_PAGE_SHOW, b.room_id, b.uid);
                    }
                } else {
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 != null) {
                        EventTrackYY.d(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_ALL_SCORE_PAGE_SHOW, b2.room_id, b2.uid);
                    }
                }
                YYConfessedRankFragment.this.b(true);
            }
        });
        c().d.setTextColor(getResources().getColor(R.color.color_300067));
        c().f16471c.setTextColor(getResources().getColor(R.color.white_alpha70));
        if (StringUtils.a(this.b, "1")) {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_WEEK_TIME_PAGE_SHOW, b.room_id, b.uid);
            }
        } else {
            YYRoomModel b2 = YYRoomInfoManager.e().b();
            if (b2 != null) {
                EventTrackYY.d(ChatRoomProtos.Event.YY_SHOW_LOVE_TOP_WEEK_SCORE_PAGE_SHOW, b2.room_id, b2.uid);
            }
        }
        c().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYConfessedRankFragment$X85Mol4FJFeXvUnemhn0Vc-iitc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankFragment.a(YYConfessedRankFragment.this, view);
            }
        });
        c().f16471c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYConfessedRankFragment$PQ8p-JjoYFPJxJ_XxzEx1_Ornzw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankFragment.b(YYConfessedRankFragment.this, view);
            }
        });
    }

    public final void b(boolean z) {
        this.f17164c = z;
    }

    public final boolean b() {
        return this.f17164c;
    }

    public final void c(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_confessed_rank;
    }

    public final String getType() {
        return this.b;
    }
}

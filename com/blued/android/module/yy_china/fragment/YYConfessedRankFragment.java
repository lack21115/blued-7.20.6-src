package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
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
    private FragmentConfessedRankBinding a;
    private String b = "";
    private boolean c;

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
        FragmentConfessedRankBinding fragmentConfessedRankBinding = this.a;
        Intrinsics.a(fragmentConfessedRankBinding);
        return fragmentConfessedRankBinding;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = FragmentConfessedRankBinding.a(this.i);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        PagerAdapter yYConfessedRankItemAdapter = new YYConfessedRankItemAdapter(childFragmentManager);
        yYConfessedRankItemAdapter.a(this.b);
        ImageLoader.a(getFragmentActive(), ImgURLMap.a.a("yy_confessed_rank_url_btn_bg")).a(c().b);
        c().e.setAdapter(yYConfessedRankItemAdapter);
        c().e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.fragment.YYConfessedRankFragment$onInitView$1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                FragmentConfessedRankBinding c;
                FragmentConfessedRankBinding c2;
                FragmentConfessedRankBinding c3;
                FragmentConfessedRankBinding c4;
                FragmentConfessedRankBinding c5;
                ConstraintSet constraintSet = new ConstraintSet();
                c = YYConfessedRankFragment.this.c();
                constraintSet.clone(c.a);
                c2 = YYConfessedRankFragment.this.c();
                int id = c2.b.getId();
                c3 = YYConfessedRankFragment.this.c();
                c4 = YYConfessedRankFragment.this.c();
                constraintSet.setMargin(id, 1, (int) ((c3.b.getWidth() * i) + (c4.b.getWidth() * f)));
                c5 = YYConfessedRankFragment.this.c();
                constraintSet.applyTo(c5.a);
            }

            public void onPageSelected(int i) {
                FragmentConfessedRankBinding c;
                FragmentConfessedRankBinding c2;
                FragmentConfessedRankBinding c3;
                FragmentConfessedRankBinding c4;
                if (i == 0) {
                    c3 = YYConfessedRankFragment.this.c();
                    c3.d.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.color_300067));
                    c4 = YYConfessedRankFragment.this.c();
                    c4.c.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.white_alpha70));
                    return;
                }
                c = YYConfessedRankFragment.this.c();
                c.c.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.color_300067));
                c2 = YYConfessedRankFragment.this.c();
                c2.d.setTextColor(YYConfessedRankFragment.this.getResources().getColor(R.color.white_alpha70));
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
        c().c.setTextColor(getResources().getColor(R.color.white_alpha70));
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
        c().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYConfessedRankFragment$PQ8p-JjoYFPJxJ_XxzEx1_Ornzw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYConfessedRankFragment.b(YYConfessedRankFragment.this, view);
            }
        });
    }

    public final void b(boolean z) {
        this.c = z;
    }

    public final boolean b() {
        return this.c;
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

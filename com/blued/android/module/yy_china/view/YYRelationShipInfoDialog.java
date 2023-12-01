package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRelationShipPagerAdapter;
import com.blued.android.module.yy_china.databinding.DialofYyRelationshipRoomBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipInfoDialog.class */
public final class YYRelationShipInfoDialog extends BaseFullScreenDialog {
    private DialofYyRelationshipRoomBinding a;
    private YYRelationShipPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveEventBus.get("event_yy_game").post(YYRoomInfoManager.e().c().a(15));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_RELATION_ROOM_QA_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRelationShipInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<YYRelationShipRoomMode> list) {
        f().e.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.view.YYRelationShipInfoDialog$initTabs$1
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                DialofYyRelationshipRoomBinding f;
                f = YYRelationShipInfoDialog.this.f();
                f.d.setToolBtnSelect(i);
            }
        });
        YYRelationShipThemeTabView yYRelationShipThemeTabView = f().d;
        ViewPager viewPager = f().e;
        Intrinsics.c(viewPager, "bind.typeViewPager");
        yYRelationShipThemeTabView.a(viewPager);
        YYRelationShipThemeTabView yYRelationShipThemeTabView2 = f().d;
        Intrinsics.c(yYRelationShipThemeTabView2, "bind.tablayout");
        YYRelationShipThemeTabView.a(yYRelationShipThemeTabView2, list, 0, 0, 6, null);
        f().e.setOffscreenPageLimit(1);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        YYRelationShipPagerAdapter yYRelationShipPagerAdapter = new YYRelationShipPagerAdapter(childFragmentManager);
        this.b = yYRelationShipPagerAdapter;
        if (yYRelationShipPagerAdapter != null) {
            yYRelationShipPagerAdapter.a(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInfoDialog$xooK43T7odKivuXM9dTHQmMvF98
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRelationShipInfoDialog.c(YYRelationShipInfoDialog.this, view);
                }
            });
        }
        f().e.setAdapter(this.b);
        YYRelationShipPagerAdapter yYRelationShipPagerAdapter2 = this.b;
        if (yYRelationShipPagerAdapter2 != null) {
            yYRelationShipPagerAdapter2.b(list);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getChecked()) {
                f().e.setCurrentItem(i);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRelationShipInfoDialog this$0, View view) {
        YYRelationShipThemeTabView yYRelationShipThemeTabView;
        String selectId;
        Intrinsics.e(this$0, "this$0");
        YYRelationShipRankDialog yYRelationShipRankDialog = new YYRelationShipRankDialog();
        DialofYyRelationshipRoomBinding f = this$0.f();
        String str = null;
        if (f != null && (yYRelationShipThemeTabView = f.d) != null && (selectId = yYRelationShipThemeTabView.getSelectId()) != null) {
            str = selectId;
        }
        yYRelationShipRankDialog.a(str);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYRelationShipRankDialog.show(childFragmentManager, "YYRelationShipRankDialog");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_RELATION_ROOM_RANKING_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYRelationShipInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialofYyRelationshipRoomBinding f() {
        DialofYyRelationshipRoomBinding dialofYyRelationshipRoomBinding = this.a;
        Intrinsics.a(dialofYyRelationshipRoomBinding);
        return dialofYyRelationshipRoomBinding;
    }

    private final void g() {
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.s(new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRelationShipInfoDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationShipRoomMode> bluedEntityA) {
                boolean z = false;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    z = true;
                }
                if (z) {
                    YYRelationShipInfoDialog yYRelationShipInfoDialog = YYRelationShipInfoDialog.this;
                    List<YYRelationShipRoomMode> list = bluedEntityA.data;
                    Intrinsics.c(list, "p0.data");
                    yYRelationShipInfoDialog.a(list);
                }
            }
        }, a());
    }

    private final void h() {
        f().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInfoDialog$CkSByyIcJBLv5PkynCzyhgOtmYg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipInfoDialog.a(YYRelationShipInfoDialog.this, view);
            }
        });
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInfoDialog$GIONGgKyfFt06Jy-pDcVPGk5nZw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipInfoDialog.a(view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipInfoDialog$N9lv-F12T-hA3inHQCiOi9ECj-Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipInfoDialog.b(YYRelationShipInfoDialog.this, view);
            }
        });
        g();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialofYyRelationshipRoomBinding.a(inflater.inflate(R.layout.dialof_yy_relationship_room, viewGroup, true));
        h();
        return f().getRoot();
    }
}

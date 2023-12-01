package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRelationShipRankPagerAdapter;
import com.blued.android.module.yy_china.databinding.DialogYyMyRelationRankAllBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUiInfo;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipRankDialog.class */
public final class YYRelationShipRankDialog extends BaseFullScreenDialog {
    private DialogYyMyRelationRankAllBinding a;
    private String b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRelationShipRankDialog this$0, View view) {
        YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView;
        String selectId;
        Intrinsics.e(this$0, "this$0");
        YYRelationShipMyAllDialog yYRelationShipMyAllDialog = new YYRelationShipMyAllDialog();
        DialogYyMyRelationRankAllBinding f = this$0.f();
        String str = null;
        if (f != null && (yYRoomRelationShipRankTabView = f.c) != null && (selectId = yYRoomRelationShipRankTabView.getSelectId()) != null) {
            str = selectId;
        }
        yYRelationShipMyAllDialog.a(str);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYRelationShipMyAllDialog.show(childFragmentManager, "YYRelationShipMyAllDialog");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_RELATION_MINE_CLICK, b.room_id, b.uid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<YYRelationShipRoomMode> arrayList) {
        YYRelationShipRoomUiInfo resource_options;
        String background_list_image;
        YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView = f().c;
        ViewPager viewPager = f().b;
        Intrinsics.c(viewPager, "bind.roomViewPager");
        yYRoomRelationShipRankTabView.a(viewPager);
        ArrayList<YYRelationShipRoomMode> arrayList2 = arrayList;
        f().c.setData(arrayList2);
        ActivityFragmentActive a = a();
        YYRelationShipRoomMode item = f().c.getItem();
        String str = "";
        if (item != null && (resource_options = item.getResource_options()) != null && (background_list_image = resource_options.getBackground_list_image()) != null) {
            str = background_list_image;
        }
        ImageLoader.a(a, str).a(f().a);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        PagerAdapter yYRelationShipRankPagerAdapter = new YYRelationShipRankPagerAdapter(childFragmentManager);
        f().b.setAdapter(yYRelationShipRankPagerAdapter);
        yYRelationShipRankPagerAdapter.b(arrayList2);
        if (this.b == null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).getChecked()) {
                    f().b.setCurrentItem(i);
                    return;
                }
            }
            return;
        }
        int size2 = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size2) {
                return;
            }
            if (Intrinsics.a((Object) arrayList.get(i3).getId(), (Object) this.b)) {
                f().b.setCurrentItem(i3);
                return;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRelationShipRankDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogYyMyRelationRankAllBinding f() {
        DialogYyMyRelationRankAllBinding dialogYyMyRelationRankAllBinding = this.a;
        Intrinsics.a(dialogYyMyRelationRankAllBinding);
        return dialogYyMyRelationRankAllBinding;
    }

    private final void g() {
        f().d.setCenterText("榜单");
        f().d.setRightText("我的关系");
        f().d.setCenterTextColor(R.color.black);
        f().d.setLeftImg(R.drawable.icon_dialog_back_black);
        f().d.setRightClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipRankDialog$eJ9w3GJluGPyGFNIi9H8DpVwMNo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipRankDialog.a(YYRelationShipRankDialog.this, view);
            }
        });
        f().d.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipRankDialog$-iDR8l3_2bxUd2MscaLSWUcaL3w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipRankDialog.b(YYRelationShipRankDialog.this, view);
            }
        });
        f().b.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.view.YYRelationShipRankDialog$initView$3
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                DialogYyMyRelationRankAllBinding f;
                DialogYyMyRelationRankAllBinding f2;
                DialogYyMyRelationRankAllBinding f3;
                YYRelationShipRoomUiInfo resource_options;
                String background_list_image;
                f = YYRelationShipRankDialog.this.f();
                f.c.setToolBtnSelect(i);
                ActivityFragmentActive a = YYRelationShipRankDialog.this.a();
                f2 = YYRelationShipRankDialog.this.f();
                YYRelationShipRoomMode item = f2.c.getItem();
                String str = "";
                if (item != null && (resource_options = item.getResource_options()) != null && (background_list_image = resource_options.getBackground_list_image()) != null) {
                    str = background_list_image;
                }
                ImageWrapper a2 = ImageLoader.a(a, str);
                f3 = YYRelationShipRankDialog.this.f();
                a2.a(f3.a);
            }
        });
        h();
    }

    private final void h() {
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.s(new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomMode>>(a) { // from class: com.blued.android.module.yy_china.view.YYRelationShipRankDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationShipRoomMode> bluedEntityA) {
                boolean z = false;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    z = true;
                }
                if (z) {
                    YYRelationShipRankDialog.this.a(new ArrayList(bluedEntityA.data));
                }
            }
        }, a());
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogYyMyRelationRankAllBinding.a(inflater.inflate(R.layout.dialog_yy_my_relation_rank_all, viewGroup, true));
        g();
        return f().getRoot();
    }
}

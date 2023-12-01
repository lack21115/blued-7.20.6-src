package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRelationShipMyRoomPagerAdapter;
import com.blued.android.module.yy_china.databinding.DialogYyMyRelationAllBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.model.YYRelationShipRoomMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUiInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipMyAllDialog.class */
public final class YYRelationShipMyAllDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogYyMyRelationAllBinding f18402a;
    private String b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRelationShipMyAllDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ArrayList<YYRelationShipRoomMode> arrayList) {
        YYRelationShipRoomUiInfo resource_options;
        String background_list_image;
        YYRoomRelationShipRankTabView yYRoomRelationShipRankTabView = f().d;
        ViewPager viewPager = f().f16443c;
        Intrinsics.c(viewPager, "bind.roomViewPager");
        yYRoomRelationShipRankTabView.a(viewPager);
        ArrayList<YYRelationShipRoomMode> arrayList2 = arrayList;
        f().d.setData(arrayList2);
        ActivityFragmentActive a2 = a();
        YYRelationShipRoomMode item = f().d.getItem();
        String str = "";
        if (item != null && (resource_options = item.getResource_options()) != null && (background_list_image = resource_options.getBackground_list_image()) != null) {
            str = background_list_image;
        }
        ImageLoader.a(a2, str).a(f().f16442a);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        YYRelationShipMyRoomPagerAdapter yYRelationShipMyRoomPagerAdapter = new YYRelationShipMyRoomPagerAdapter(childFragmentManager);
        f().f16443c.setAdapter(yYRelationShipMyRoomPagerAdapter);
        yYRelationShipMyRoomPagerAdapter.b(arrayList2);
        if (this.b == null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).getChecked()) {
                    f().f16443c.setCurrentItem(i);
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
                f().f16443c.setCurrentItem(i3);
                return;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRelationShipMyAllDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogYyMyRelationAllBinding f() {
        DialogYyMyRelationAllBinding dialogYyMyRelationAllBinding = this.f18402a;
        Intrinsics.a(dialogYyMyRelationAllBinding);
        return dialogYyMyRelationAllBinding;
    }

    private final void g() {
        f().e.setCenterText("我的关系");
        f().e.setCenterTextColor(R.color.black);
        f().e.setLeftImg(R.drawable.icon_dialog_back_black);
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipMyAllDialog$jR5heQItnYbA7TpaUdMGyDERIyk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipMyAllDialog.a(YYRelationShipMyAllDialog.this, view);
            }
        });
        f().e.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipMyAllDialog$xw4ltYyCrOypoqxhCUzXtgkMsAY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipMyAllDialog.b(YYRelationShipMyAllDialog.this, view);
            }
        });
        f().f16443c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.yy_china.view.YYRelationShipMyAllDialog$initView$3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                DialogYyMyRelationAllBinding f;
                DialogYyMyRelationAllBinding f2;
                DialogYyMyRelationAllBinding f3;
                YYRelationShipRoomUiInfo resource_options;
                String background_list_image;
                f = YYRelationShipMyAllDialog.this.f();
                f.d.setToolBtnSelect(i);
                ActivityFragmentActive a2 = YYRelationShipMyAllDialog.this.a();
                f2 = YYRelationShipMyAllDialog.this.f();
                YYRelationShipRoomMode item = f2.d.getItem();
                String str = "";
                if (item != null && (resource_options = item.getResource_options()) != null && (background_list_image = resource_options.getBackground_list_image()) != null) {
                    str = background_list_image;
                }
                ImageWrapper a3 = ImageLoader.a(a2, str);
                f3 = YYRelationShipMyAllDialog.this.f();
                a3.a(f3.f16442a);
            }
        });
        h();
    }

    private final void h() {
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.s(new BluedUIHttpResponse<BluedEntityA<YYRelationShipRoomMode>>(a2) { // from class: com.blued.android.module.yy_china.view.YYRelationShipMyAllDialog$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationShipRoomMode> bluedEntityA) {
                boolean z = false;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    z = true;
                }
                if (z) {
                    YYRelationShipMyAllDialog.this.a(new ArrayList(bluedEntityA.data));
                }
            }
        }, a());
    }

    public final void a(String str) {
        this.b = str;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18402a = DialogYyMyRelationAllBinding.a(inflater.inflate(R.layout.dialog_yy_my_relation_all, viewGroup, true));
        g();
        return f().getRoot();
    }
}

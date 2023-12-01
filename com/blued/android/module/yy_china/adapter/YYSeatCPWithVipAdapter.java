package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyConnectingCpVipLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYStepModel;
import com.blued.android.module.yy_china.trtc_audio.permission.PermissionHelper;
import com.blued.android.module.yy_china.view.YYMemberCPView;
import com.blued.android.module.yy_china.view.YYStepView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatCPWithVipAdapter.class */
public final class YYSeatCPWithVipAdapter extends YYSeatCPAdapter implements View.OnClickListener {
    private ItemYyConnectingCpVipLayoutBinding f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSeatCPWithVipAdapter(BaseYYStudioFragment fragment) {
        super(fragment.getContext(), fragment);
        Intrinsics.e(fragment, "fragment");
        addItemType(9, R.layout.item_yy_connecting_cp_vip_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    private final void h() {
        if (this.e == null || this.e.size() <= 0) {
            return;
        }
        HashMap<Integer, YYMemberCPView> positionMap = this.e;
        Intrinsics.c(positionMap, "positionMap");
        for (Map.Entry<Integer, YYMemberCPView> entry : positionMap.entrySet()) {
            Integer key = entry.getKey();
            YYMemberCPView value = entry.getValue();
            if (value != null) {
                if (key != null && key.intValue() == 0) {
                    value.setShowPosition(false);
                } else {
                    value.setShowPosition(true);
                }
                value.setOnClickListener(this);
            }
        }
    }

    private final void i() {
        ConstraintLayout root;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding = this.f;
        if (itemYyConnectingCpVipLayoutBinding != null && (shapeTextView2 = itemYyConnectingCpVipLayoutBinding.a) != null) {
            shapeTextView2.setOnClickListener(this);
        }
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding2 = this.f;
        if (itemYyConnectingCpVipLayoutBinding2 != null && (shapeTextView = itemYyConnectingCpVipLayoutBinding2.q) != null) {
            shapeTextView.setOnClickListener(this);
        }
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding3 = this.f;
        if (itemYyConnectingCpVipLayoutBinding3 == null || (root = itemYyConnectingCpVipLayoutBinding3.getRoot()) == null) {
            return;
        }
        root.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYSeatCPWithVipAdapter$A91o1LC-LnJdReCLvXxAL2wiC9Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYSeatCPWithVipAdapter.a(view);
            }
        });
    }

    private final void j() {
        ShapeLinearLayout shapeLinearLayout;
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding = this.f;
        if (itemYyConnectingCpVipLayoutBinding == null || (shapeLinearLayout = itemYyConnectingCpVipLayoutBinding.f) == null) {
            return;
        }
        shapeLinearLayout.removeAllViews();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                Context mContext = this.mContext;
                Intrinsics.c(mContext, "mContext");
                YYStepView yYStepView = new YYStepView(mContext);
                yYStepView.setStepViewBackground(R.drawable.shape_raduis_6_fa3d76);
                yYStepView.a(5, 2, 5, 2);
                yYStepView.setStepNameSize(10.0f);
                YYStepModel yYStepModel = this.d.get(i);
                Intrinsics.c(yYStepModel, "stepList[i]");
                YYStepModel yYStepModel2 = yYStepModel;
                BaseYYStudioFragment fragment = this.a;
                Intrinsics.c(fragment, "fragment");
                yYStepView.a(yYStepModel2, (LifecycleOwner) fragment, true);
                shapeLinearLayout.addView((View) yYStepView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        View view;
        if (yYSeatMemberModel != null && yYSeatMemberModel.getItemType() == 9) {
            this.f = (baseViewHolder == null || (view = baseViewHolder.itemView) == null) ? null : ItemYyConnectingCpVipLayoutBinding.a(view);
            HashMap<Integer, YYMemberCPView> positionMap = this.e;
            Intrinsics.c(positionMap, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap = positionMap;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding = this.f;
            hashMap.put(0, itemYyConnectingCpVipLayoutBinding == null ? null : itemYyConnectingCpVipLayoutBinding.g);
            HashMap<Integer, YYMemberCPView> positionMap2 = this.e;
            Intrinsics.c(positionMap2, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap2 = positionMap2;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding2 = this.f;
            hashMap2.put(1, itemYyConnectingCpVipLayoutBinding2 == null ? null : itemYyConnectingCpVipLayoutBinding2.h);
            HashMap<Integer, YYMemberCPView> positionMap3 = this.e;
            Intrinsics.c(positionMap3, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap3 = positionMap3;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding3 = this.f;
            hashMap3.put(2, itemYyConnectingCpVipLayoutBinding3 == null ? null : itemYyConnectingCpVipLayoutBinding3.i);
            HashMap<Integer, YYMemberCPView> positionMap4 = this.e;
            Intrinsics.c(positionMap4, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap4 = positionMap4;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding4 = this.f;
            hashMap4.put(3, itemYyConnectingCpVipLayoutBinding4 == null ? null : itemYyConnectingCpVipLayoutBinding4.j);
            HashMap<Integer, YYMemberCPView> positionMap5 = this.e;
            Intrinsics.c(positionMap5, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap5 = positionMap5;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding5 = this.f;
            hashMap5.put(4, itemYyConnectingCpVipLayoutBinding5 == null ? null : itemYyConnectingCpVipLayoutBinding5.k);
            HashMap<Integer, YYMemberCPView> positionMap6 = this.e;
            Intrinsics.c(positionMap6, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap6 = positionMap6;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding6 = this.f;
            hashMap6.put(5, itemYyConnectingCpVipLayoutBinding6 == null ? null : itemYyConnectingCpVipLayoutBinding6.l);
            HashMap<Integer, YYMemberCPView> positionMap7 = this.e;
            Intrinsics.c(positionMap7, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap7 = positionMap7;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding7 = this.f;
            hashMap7.put(6, itemYyConnectingCpVipLayoutBinding7 == null ? null : itemYyConnectingCpVipLayoutBinding7.m);
            HashMap<Integer, YYMemberCPView> positionMap8 = this.e;
            Intrinsics.c(positionMap8, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap8 = positionMap8;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding8 = this.f;
            hashMap8.put(7, itemYyConnectingCpVipLayoutBinding8 == null ? null : itemYyConnectingCpVipLayoutBinding8.n);
            HashMap<Integer, YYMemberCPView> positionMap9 = this.e;
            Intrinsics.c(positionMap9, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap9 = positionMap9;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding9 = this.f;
            hashMap9.put(8, itemYyConnectingCpVipLayoutBinding9 == null ? null : itemYyConnectingCpVipLayoutBinding9.o);
            HashMap<Integer, YYMemberCPView> positionMap10 = this.e;
            Intrinsics.c(positionMap10, "positionMap");
            HashMap<Integer, YYMemberCPView> hashMap10 = positionMap10;
            ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding10 = this.f;
            hashMap10.put(9, itemYyConnectingCpVipLayoutBinding10 == null ? null : itemYyConnectingCpVipLayoutBinding10.p);
            h();
            a();
            j();
            b();
            i();
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.YYSeatCPAdapter
    protected void b() {
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding = this.f;
        ShapeTextView shapeTextView = null;
        ShapeTextView shapeTextView2 = itemYyConnectingCpVipLayoutBinding == null ? null : itemYyConnectingCpVipLayoutBinding.q;
        if (shapeTextView2 != null) {
            shapeTextView2.setVisibility(YYRoomInfoManager.e().y() ? 0 : 4);
        }
        YYStepModel yYStepModel = this.b;
        if (yYStepModel == null) {
            return;
        }
        String str = yYStepModel.stepIndex == 0 ? this.d.get(0).name : yYStepModel.stepIndex >= this.d.size() - 1 ? "结束交友" : "下一阶段";
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding2 = this.f;
        if (itemYyConnectingCpVipLayoutBinding2 != null) {
            shapeTextView = itemYyConnectingCpVipLayoutBinding2.q;
        }
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setText(str);
    }

    @Override // com.blued.android.module.yy_china.adapter.YYSeatCPAdapter
    public ConstraintLayout d() {
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding = this.f;
        if (itemYyConnectingCpVipLayoutBinding == null) {
            return null;
        }
        return itemYyConnectingCpVipLayoutBinding.r;
    }

    @Override // com.blued.android.module.yy_china.adapter.YYSeatCPAdapter
    public View e() {
        ItemYyConnectingCpVipLayoutBinding itemYyConnectingCpVipLayoutBinding = this.f;
        return (View) (itemYyConnectingCpVipLayoutBinding == null ? null : itemYyConnectingCpVipLayoutBinding.a);
    }

    @Override // com.blued.android.module.yy_china.adapter.YYSeatCPAdapter
    public int f() {
        return 9;
    }

    @Override // com.blued.android.module.yy_china.adapter.YYSeatCPAdapter, android.view.View.OnClickListener
    public void onClick(final View view) {
        Tracker.onClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.member_cp_9;
        if (valueOf != null && valueOf.intValue() == i) {
            PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.yy_china.adapter.YYSeatCPWithVipAdapter$onClick$1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    String str;
                    str = YYSeatCPAdapter.TAG;
                    LiveLogUtils.a(Intrinsics.a(str, (Object) " --> apply VIP position --> 授权麦克风权限 ... "));
                    YYSeatCPWithVipAdapter.this.a(9, view);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] perms) {
                    String str;
                    Intrinsics.e(perms, "perms");
                    str = YYSeatCPAdapter.TAG;
                    LiveLogUtils.a(Intrinsics.a(str, (Object) " --> apply VIP position --> 拒绝麦克风权限 ... "));
                    AppMethods.a((CharSequence) "麦克风已被禁用，请在设置中授权麦克风使用");
                }
            });
        } else {
            super.onClick(view);
        }
    }
}

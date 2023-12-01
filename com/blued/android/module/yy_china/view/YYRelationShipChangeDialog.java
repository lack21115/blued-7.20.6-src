package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogRelationshipChangeBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserCardInfoMode;
import com.blued.android.module.yy_china.model.YYRelationShipRoomUserInfoMode;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYRelationShipChangeDialog.class */
public final class YYRelationShipChangeDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogRelationshipChangeBinding f18393a;
    private YYRelationShipRoomUserCardInfoMode b;

    /* renamed from: c  reason: collision with root package name */
    private int f18394c;
    private View.OnClickListener d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRelationShipChangeDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRelationShipChangeDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final YYRelationShipChangeDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a()) {
            return;
        }
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this$0.b;
        boolean z = false;
        if (yYRelationShipRoomUserCardInfoMode != null && yYRelationShipRoomUserCardInfoMode.is_hidden() == 1) {
            z = true;
        }
        if (z && this$0.f18394c == 1) {
            ToastUtils.a("关系已隐藏");
            return;
        }
        if (this$0.f18394c == 4) {
            this$0.f18394c = 2;
        }
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode2 = this$0.b;
        String id = yYRelationShipRoomUserCardInfoMode2 == null ? null : yYRelationShipRoomUserCardInfoMode2.getId();
        String valueOf = String.valueOf(this$0.f18394c);
        final ActivityFragmentActive a2 = this$0.a();
        YYRoomHttpUtils.v(id, valueOf, new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.android.module.yy_china.view.YYRelationShipChangeDialog$initView$4$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                View.OnClickListener f = YYRelationShipChangeDialog.this.f();
                if (f != null) {
                    f.onClick(null);
                }
                YYRelationShipChangeDialog.this.dismissAllowingStateLoss();
                if (YYRelationShipChangeDialog.this.getType() == 2) {
                    ToastUtils.a("解除成功");
                }
            }
        }, this$0.a());
    }

    private final DialogRelationshipChangeBinding g() {
        DialogRelationshipChangeBinding dialogRelationshipChangeBinding = this.f18393a;
        Intrinsics.a(dialogRelationshipChangeBinding);
        return dialogRelationshipChangeBinding;
    }

    private final void h() {
        YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode = this.b;
        if (yYRelationShipRoomUserCardInfoMode != null) {
            YYRelationShipRoomUserInfoMode targe_uid_profile = StringUtils.a(yYRelationShipRoomUserCardInfoMode.getUid_profile().getUid(), YYRoomInfoManager.e().k()) ? yYRelationShipRoomUserCardInfoMode.getTarge_uid_profile() : yYRelationShipRoomUserCardInfoMode.getUid_profile();
            ImageLoader.a(a(), yYRelationShipRoomUserCardInfoMode.getUid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(g().e);
            ImageLoader.a(a(), yYRelationShipRoomUserCardInfoMode.getTarge_uid_profile().getAvatar()).c().b(R.drawable.user_bg_round).a(g().f);
            int type = getType();
            if (type == 1) {
                g().g.setText("隐藏关系");
                TextView textView = g().h;
                textView.setText("确认隐藏和 " + targe_uid_profile.getName() + " 的「" + yYRelationShipRoomUserCardInfoMode.getLevel_info().getLevel_name() + "」关系吗？隐藏后，自己的个人资料卡、榜单会做隐藏处理，看不到相应的头像和昵称。对方那里正常显示。");
                g().b.setText("隐藏");
            } else if (type == 2) {
                g().g.setText("解除关系");
                TextView textView2 = g().h;
                textView2.setText("确认解除和  " + targe_uid_profile.getName() + " 的「" + yYRelationShipRoomUserCardInfoMode.getLevel_info().getLevel_name() + "」关系吗？确认后，会以个人名义给对方发私信，需要对方同意，若对方5天内没有同意也没有拒绝，则默认解除。两人关系小屋、个人资料卡、榜单均不再显示。");
                g().b.setText("解除");
            } else if (type == 4) {
                g().g.setText("解除关系");
                TextView textView3 = g().h;
                textView3.setText("确认解除和 " + targe_uid_profile.getName() + " 的「" + yYRelationShipRoomUserCardInfoMode.getLevel_info().getLevel_name() + "」 关系吗？确认后，两个人关系会立即解除，两人关系小屋、个人资料卡、榜单均不再显示。");
                g().b.setText("解除");
            }
        }
        g().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipChangeDialog$V_yLVQE5LmgObnKcXBpVz7nI3Iw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipChangeDialog.a(YYRelationShipChangeDialog.this, view);
            }
        });
        g().f16388a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipChangeDialog$Fz8be01kdggOxsafN-b8lbcA55g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipChangeDialog.b(YYRelationShipChangeDialog.this, view);
            }
        });
        g().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYRelationShipChangeDialog$E-WE1gYaOwCx0MGtvmAGm4kKqRI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRelationShipChangeDialog.c(YYRelationShipChangeDialog.this, view);
            }
        });
    }

    public final void a(int i) {
        this.f18394c = i;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public final void a(YYRelationShipRoomUserCardInfoMode yYRelationShipRoomUserCardInfoMode) {
        this.b = yYRelationShipRoomUserCardInfoMode;
    }

    public final View.OnClickListener f() {
        return this.d;
    }

    public final int getType() {
        return this.f18394c;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18393a = DialogRelationshipChangeBinding.a(inflater.inflate(R.layout.dialog_relationship_change, viewGroup, true));
        h();
        return g().getRoot();
    }
}

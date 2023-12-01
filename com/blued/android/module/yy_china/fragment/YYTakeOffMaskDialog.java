package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogTakeOffMaskBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYMaskedChoseMicDialog;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYTakeOffMaskDialog.class */
public final class YYTakeOffMaskDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogTakeOffMaskBinding f17460a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYTakeOffMaskDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.YY_LIFT_MASK_POP_CANCEL_CLICK, b.room_id, b.uid);
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYTakeOffMaskDialog this$0, View view) {
        boolean z;
        Intrinsics.e(this$0, "this$0");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || b.mics == null) {
            return;
        }
        Iterator<YYSeatMemberModel> it = b.mics.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            YYSeatMemberModel next = it.next();
            if (!TextUtils.equals(next.getUid(), b.uid) && !TextUtils.equals(next.getUid(), YYRoomInfoManager.e().k()) && StringUtils.a(next.getUid(), 0L) > 0 && !b.isUnmasked(next.getUid())) {
                z = true;
                break;
            }
        }
        if (!z) {
            ToastUtils.a("当前麦上用户均已揭面");
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_LIFT_MASK_POP_USE_CLICK, b.room_id, b.uid);
        YYMaskedChoseMicDialog yYMaskedChoseMicDialog = new YYMaskedChoseMicDialog();
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.c(parentFragmentManager, "parentFragmentManager");
        yYMaskedChoseMicDialog.show(parentFragmentManager, "masked_chose_user_dialog");
        this$0.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        View view;
        super.onActivityCreated(bundle);
        DialogTakeOffMaskBinding dialogTakeOffMaskBinding = this.f17460a;
        if (dialogTakeOffMaskBinding != null && (view = dialogTakeOffMaskBinding.f16417a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYTakeOffMaskDialog$DzHhG6KtTSOV1704prf73Clnz5I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYTakeOffMaskDialog.a(view2);
                }
            });
        }
        DialogTakeOffMaskBinding dialogTakeOffMaskBinding2 = this.f17460a;
        if (dialogTakeOffMaskBinding2 != null && (shapeTextView2 = dialogTakeOffMaskBinding2.f16418c) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYTakeOffMaskDialog$jc4Lg7FUIzM5JL8SPuvSJgHDNqk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYTakeOffMaskDialog.a(YYTakeOffMaskDialog.this, view2);
                }
            });
        }
        DialogTakeOffMaskBinding dialogTakeOffMaskBinding3 = this.f17460a;
        if (dialogTakeOffMaskBinding3 == null || (shapeTextView = dialogTakeOffMaskBinding3.d) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYTakeOffMaskDialog$685MtrPbe_D2G1m8o1d7Q20zN94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYTakeOffMaskDialog.b(YYTakeOffMaskDialog.this, view2);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_take_off_mask, (ViewGroup) null);
        this.f17460a = DialogTakeOffMaskBinding.a(inflate);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return inflate;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_LIFT_MASK_POP_SHOW, b.room_id, b.uid);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }
}

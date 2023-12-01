package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyCreateRoomSelectPhotoBinding;
import com.blued.android.module.yy_china.listener.OnYYCreateRoomSelectPhotoListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCreateRoomSelectPhotoDialog.class */
public final class YYCreateRoomSelectPhotoDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    private DialogYyCreateRoomSelectPhotoBinding a;
    private OnYYCreateRoomSelectPhotoListener b;
    private String c;
    private BaseFragment d;

    private final void a(Dialog dialog) {
        DialogYyCreateRoomSelectPhotoBinding dialogYyCreateRoomSelectPhotoBinding = this.a;
        if (dialogYyCreateRoomSelectPhotoBinding != null) {
            ShapeLinearLayout shapeLinearLayout = dialogYyCreateRoomSelectPhotoBinding.d;
            if (shapeLinearLayout != null) {
                shapeLinearLayout.setOnClickListener(this);
            }
            ImageView imageView = dialogYyCreateRoomSelectPhotoBinding.c;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            ShapeLinearLayout shapeLinearLayout2 = dialogYyCreateRoomSelectPhotoBinding.e;
            if (shapeLinearLayout2 != null) {
                shapeLinearLayout2.setOnClickListener(this);
            }
            ShapeRelativeLayout shapeRelativeLayout = dialogYyCreateRoomSelectPhotoBinding.f;
            if (shapeRelativeLayout != null) {
                shapeRelativeLayout.setOnClickListener(this);
            }
            ShapeTextView shapeTextView = dialogYyCreateRoomSelectPhotoBinding.g;
            if (shapeTextView != null) {
                shapeTextView.setOnClickListener(this);
            }
        }
        String str = this.c;
        if (str == null) {
            return;
        }
        a(str);
    }

    public final void a(BaseFragment fragment, OnYYCreateRoomSelectPhotoListener onSelectPhotoListener) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(onSelectPhotoListener, "onSelectPhotoListener");
        this.d = fragment;
        this.b = onSelectPhotoListener;
    }

    public final void a(String str) {
        this.c = str;
        ImageWrapper a = ImageLoader.d(a(), String.valueOf(str)).a(6.0f);
        DialogYyCreateRoomSelectPhotoBinding dialogYyCreateRoomSelectPhotoBinding = this.a;
        a.a(dialogYyCreateRoomSelectPhotoBinding == null ? null : dialogYyCreateRoomSelectPhotoBinding.b);
        DialogYyCreateRoomSelectPhotoBinding dialogYyCreateRoomSelectPhotoBinding2 = this.a;
        ShapeLinearLayout shapeLinearLayout = dialogYyCreateRoomSelectPhotoBinding2 == null ? null : dialogYyCreateRoomSelectPhotoBinding2.e;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setVisibility(8);
        }
        DialogYyCreateRoomSelectPhotoBinding dialogYyCreateRoomSelectPhotoBinding3 = this.a;
        ShapeRelativeLayout shapeRelativeLayout = dialogYyCreateRoomSelectPhotoBinding3 == null ? null : dialogYyCreateRoomSelectPhotoBinding3.f;
        if (shapeRelativeLayout == null) {
            return;
        }
        shapeRelativeLayout.setVisibility(0);
    }

    public final OnYYCreateRoomSelectPhotoListener h() {
        return this.b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.iv_up_cover_close;
        if (valueOf != null && valueOf.intValue() == i) {
            this.c = null;
            DialogYyCreateRoomSelectPhotoBinding dialogYyCreateRoomSelectPhotoBinding = this.a;
            ShapeRelativeLayout shapeRelativeLayout = dialogYyCreateRoomSelectPhotoBinding == null ? null : dialogYyCreateRoomSelectPhotoBinding.f;
            if (shapeRelativeLayout != null) {
                shapeRelativeLayout.setVisibility(8);
            }
            DialogYyCreateRoomSelectPhotoBinding dialogYyCreateRoomSelectPhotoBinding2 = this.a;
            ShapeLinearLayout shapeLinearLayout = dialogYyCreateRoomSelectPhotoBinding2 == null ? null : dialogYyCreateRoomSelectPhotoBinding2.e;
            if (shapeLinearLayout == null) {
                return;
            }
            shapeLinearLayout.setVisibility(0);
            return;
        }
        int i2 = R.id.sll_cover;
        if (valueOf != null && valueOf.intValue() == i2) {
            YYRoomInfoManager.e().c().a(this.d);
            return;
        }
        int i3 = R.id.sll_add_cover;
        if (valueOf != null && valueOf.intValue() == i3) {
            YYRoomInfoManager.e().c().a(this.d);
            return;
        }
        int i4 = R.id.tv_up_cover_qd;
        if (valueOf != null && valueOf.intValue() == i4) {
            if (this.c == null) {
                ToastUtils.a(getString(R.string.yy_pelase_up_photo));
            }
            String str = this.c;
            if (str == null) {
                return;
            }
            OnYYCreateRoomSelectPhotoListener h = h();
            if (h != null) {
                h.d(str);
            }
            dismiss();
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_UPLOAD_COVER_YES_CLICK);
        }
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        DialogYyCreateRoomSelectPhotoBinding a = DialogYyCreateRoomSelectPhotoBinding.a(LayoutInflater.from(getContext()));
        this.a = a;
        ConstraintLayout root = a == null ? null : a.getRoot();
        Intrinsics.a(root);
        dialog.setContentView((View) root);
        a(dialog);
    }
}

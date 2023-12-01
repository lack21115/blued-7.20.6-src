package com.blued.android.module.common.base.dialog.bottomsheet;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.android.internal.R;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetDialogFragment.class */
public class BottomSheetDialogFragment extends BaseDialogFragment {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetDialogFragment$BottomSheetDismissCallback.class */
    public class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetDismissCallback() {
        }

        @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void a(View view, float f) {
        }

        @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void a(View view, int i) {
            if (i == 5) {
                BottomSheetDialogFragment.this.h();
            }
        }
    }

    private void a(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.a = z;
        if (bottomSheetBehavior.d() == 5) {
            h();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).d();
        }
        bottomSheetBehavior.a(new BottomSheetDismissCallback());
        bottomSheetBehavior.d(5);
    }

    private void a(BottomSheetDialog bottomSheetDialog) {
        Window window = bottomSheetDialog.getWindow();
        if (window == null || getContext() == null) {
            return;
        }
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setDimAmount(0.0f);
    }

    private boolean a(boolean z) {
        Dialog dialog = getDialog();
        if (dialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
            BottomSheetBehavior<FrameLayout> a = bottomSheetDialog.a();
            if (a.b() && bottomSheetDialog.b()) {
                a(a, z);
                return true;
            }
            return false;
        }
        return false;
    }

    private void b(BottomSheetDialog bottomSheetDialog) {
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(BluedSkinUtils.a(AppInfo.d(), com.blued.android.module.common.R.color.syc_b));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, gradientDrawable2});
            layerDrawable.setLayerInsetTop(1, displayMetrics.heightPixels);
            window.setBackgroundDrawable(layerDrawable);
        }
    }

    private void c(BottomSheetDialog bottomSheetDialog) {
        Window window = bottomSheetDialog.getWindow();
        if (window == null || g() == 0) {
            return;
        }
        window.setWindowAnimations(g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    public BottomSheetDialog R_() {
        if (getDialog() instanceof BottomSheetDialog) {
            return (BottomSheetDialog) getDialog();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        if (getDialog() == null || !(getDialog() instanceof BottomSheetDialog)) {
            return;
        }
        ((BottomSheetDialog) getDialog()).a().a(i);
    }

    public void a(final BottomSheetDialog bottomSheetDialog, final boolean z) {
        bottomSheetDialog.a().a(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment.1
            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View view, float f) {
            }

            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View view, int i) {
                if (i != 1 || z) {
                    return;
                }
                bottomSheetDialog.a().d(4);
            }
        });
    }

    public void dismiss() {
        if (a(false)) {
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
        }
    }

    public void dismissAllowingStateLoss() {
        if (a(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    protected boolean e() {
        return false;
    }

    protected boolean f() {
        return true;
    }

    protected int g() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog, android.app.Dialog] */
    public Dialog onCreateDialog(Bundle bundle) {
        ?? bottomSheetDialog = new BottomSheetDialog(getActivity());
        if (e()) {
            a((BottomSheetDialog) bottomSheetDialog);
        } else if (Build.VERSION.SDK_INT >= 23) {
            b(bottomSheetDialog);
        }
        a((BottomSheetDialog) bottomSheetDialog, f());
        c(bottomSheetDialog);
        return bottomSheetDialog;
    }

    public void setupDialog(Dialog dialog, int i) {
    }
}

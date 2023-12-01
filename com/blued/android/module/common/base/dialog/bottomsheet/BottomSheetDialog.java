package com.blued.android.module.common.base.dialog.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blued.android.module.common.R;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/dialog/bottomsheet/BottomSheetDialog.class */
public class BottomSheetDialog extends AppCompatDialog {

    /* renamed from: a  reason: collision with root package name */
    boolean f10657a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f10658c;
    private FrameLayout d;
    private boolean e;
    private boolean f;
    private BottomSheetBehavior.BottomSheetCallback g;

    public BottomSheetDialog(Context context) {
        this(context, 0);
    }

    public BottomSheetDialog(Context context, int i) {
        super(context, a(context, i));
        this.b = true;
        this.e = true;
        this.g = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog.4
            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View view, float f) {
            }

            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
    }

    private static int a(Context context, int i) {
        int i2 = i;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            i2 = R.style.Theme_Design_Light_BottomSheetDialog;
        }
        return i2;
    }

    private View a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        e();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.d.findViewById(R.id.coordinator);
        View view2 = view;
        if (i != 0) {
            view2 = view;
            if (view == null) {
                view2 = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
            }
        }
        FrameLayout frameLayout = (FrameLayout) this.d.findViewById(R.id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view2);
        } else {
            frameLayout.addView(view2, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                Tracker.onClick(view3);
                if (BottomSheetDialog.this.b && BottomSheetDialog.this.isShowing() && BottomSheetDialog.this.c()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(frameLayout, new AccessibilityDelegateCompat() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view3, accessibilityNodeInfoCompat);
                if (!BottomSheetDialog.this.b) {
                    accessibilityNodeInfoCompat.setDismissable(false);
                    return;
                }
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view3, int i2, Bundle bundle) {
                if (i2 == 1048576 && BottomSheetDialog.this.b) {
                    BottomSheetDialog.this.cancel();
                    return true;
                }
                return super.performAccessibilityAction(view3, i2, bundle);
            }
        });
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.d;
    }

    private FrameLayout e() {
        if (this.d == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.d = frameLayout;
            BottomSheetBehavior<FrameLayout> b = BottomSheetBehavior.b((FrameLayout) frameLayout.findViewById(R.id.design_bottom_sheet));
            this.f10658c = b;
            b.a(this.g);
            this.f10658c.b(this.b);
        }
        return this.d;
    }

    public BottomSheetBehavior<FrameLayout> a() {
        if (this.f10658c == null) {
            e();
        }
        return this.f10658c;
    }

    public void a(int i) {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f10658c;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.a(i);
        }
    }

    public boolean b() {
        return this.f10657a;
    }

    boolean c() {
        if (!this.f) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.e = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f = true;
        }
        return this.e;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> a2 = a();
        if (!this.f10657a || a2.d() == 5) {
            super.cancel();
        } else {
            a2.d(5);
        }
    }

    public void d() {
        this.f10658c.b(this.g);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f10658c;
        if (bottomSheetBehavior == null || bottomSheetBehavior.d() != 5) {
            return;
        }
        this.f10658c.d(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.b != z) {
            this.b = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f10658c;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.b(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.b) {
            this.b = true;
        }
        this.e = z;
        this.f = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(a(i, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(a(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }
}

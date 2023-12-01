package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMultiDialogFragmentold.class */
public class LiveMultiDialogFragmentold extends BaseDialogFragment {
    public Context a;
    private WebView b;
    private ImageView c;
    private TextView d;
    private View e;
    private AtomicBoolean f;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void e() {
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMultiDialogFragmentold$J3lwE9oTUilRnIGs2HhWhYm9Yys
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiDialogFragmentold.this.g();
            }
        }, 5000L);
    }

    private void f() {
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMultiDialogFragmentold$G6KmqlfdZtmfTTnK367EydI4UxU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMultiDialogFragmentold.this.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing() || !this.f.get()) {
            return;
        }
        dismiss();
    }

    protected boolean d() {
        return true;
    }

    public void dismiss() {
        this.f.set(false);
        if (getActivity() == null || getActivity().isFinishing() || getDialog() == null || !getDialog().isShowing()) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        if (bundle != null && d()) {
            bundle.remove("android:support:fragments");
        }
        super.onCreate(bundle);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_recommend, (ViewGroup) null);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(width, -1));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.right_recommen_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = width;
        attributes.height = -1;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_live_recommend, viewGroup);
        this.b = (WebView) inflate.findViewById(R.id.web_view);
        this.c = (ImageView) inflate.findViewById(R.id.iv_img);
        this.d = (TextView) inflate.findViewById(R.id.tv_auto_close);
        this.e = inflate.findViewById(R.id.iv_close);
        f();
        if (this.f.get()) {
            e();
        }
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null || !d()) {
            return;
        }
        bundle.remove("android:support:fragments");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}

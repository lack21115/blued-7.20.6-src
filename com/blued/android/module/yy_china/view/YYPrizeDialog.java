package com.blued.android.module.yy_china.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live.base.constants.LiveEventBusConstant;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyPrizeBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYPrizeDialog.class */
public final class YYPrizeDialog extends BaseDialogFragment {
    private DialogYyPrizeBinding a;
    private Context b;
    private YYRoomModel c;
    private String d;
    private String e;
    private String f;

    public YYPrizeDialog(String str, String str2, String str3) {
        this.d = "";
        this.e = "";
        this.f = "";
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPrizeDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getActivity() == null || this$0.requireActivity().isFinishing() || this$0.getDialog() == null) {
            return;
        }
        Dialog dialog = this$0.getDialog();
        Intrinsics.a(dialog);
        if (dialog.isShowing()) {
            this$0.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPrizeDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPrizeDialog this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    private final void d() {
        View view;
        DialogYyPrizeBinding dialogYyPrizeBinding = this.a;
        if (dialogYyPrizeBinding == null || (view = dialogYyPrizeBinding.a) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPrizeDialog$i7ljWx_zdElj4NWHctGM2yht-wA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPrizeDialog.a(YYPrizeDialog.this, view2);
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            Window window = dialog.getWindow();
            Intrinsics.a(window);
            window.getDecorView().setSystemUiVisibility(1024);
        }
        Dialog dialog2 = getDialog();
        Intrinsics.a(dialog2);
        Window window2 = dialog2.getWindow();
        Intrinsics.a(window2);
        window2.setBackgroundDrawable(new ColorDrawable(0));
        Dialog dialog3 = getDialog();
        Intrinsics.a(dialog3);
        Window window3 = dialog3.getWindow();
        Intrinsics.a(window3);
        window3.setLayout(-1, -1);
        LiveEventBus.get(LiveEventBusConstant.d, String.class).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPrizeDialog$XTVgir4t2klc9TLvIT2lqvuOoMI
            public final void onChanged(Object obj) {
                YYPrizeDialog.a(YYPrizeDialog.this, (String) obj);
            }
        });
        a(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYPrizeDialog$-NFvuYOapzt5v_Pox0ly8CatVZ4
            @Override // java.lang.Runnable
            public final void run() {
                YYPrizeDialog.a(YYPrizeDialog.this);
            }
        }, 3000L);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = getActivity();
        setStyle(0, R.style.common_full_screen);
        this.c = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_yy_prize, viewGroup, false);
        this.a = DialogYyPrizeBinding.a(inflate);
        d();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        String str = this.e;
        if (str != null) {
            ImageWrapper a = ImageLoader.a(a(), str);
            DialogYyPrizeBinding dialogYyPrizeBinding = this.a;
            a.a(dialogYyPrizeBinding == null ? null : dialogYyPrizeBinding.b);
        }
        DialogYyPrizeBinding dialogYyPrizeBinding2 = this.a;
        TextView textView = dialogYyPrizeBinding2 == null ? null : dialogYyPrizeBinding2.c;
        if (textView != null) {
            textView.setText(this.d);
        }
        DialogYyPrizeBinding dialogYyPrizeBinding3 = this.a;
        TextView textView2 = dialogYyPrizeBinding3 == null ? null : dialogYyPrizeBinding3.d;
        if (textView2 == null) {
            return;
        }
        textView2.setText(this.f);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}

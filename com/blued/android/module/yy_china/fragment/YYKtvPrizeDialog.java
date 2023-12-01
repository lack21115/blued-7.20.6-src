package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvPrizeDialogBinding;
import com.blued.android.module.yy_china.model.YYMsgKtvPrize;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvPrizeDialog.class */
public final class YYKtvPrizeDialog extends BaseFullScreenDialog implements Runnable {
    private YYMsgKtvPrize a;
    private FragmentYyKtvPrizeDialogBinding b;

    public YYKtvPrizeDialog(YYMsgKtvPrize prize) {
        Intrinsics.e(prize, "prize");
        this.a = prize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvPrizeDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        View view;
        FragmentYyKtvPrizeDialogBinding fragmentYyKtvPrizeDialogBinding = this.b;
        if (fragmentYyKtvPrizeDialogBinding != null && (view = fragmentYyKtvPrizeDialogBinding.a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvPrizeDialog$s_gD6zTCGVOkY7659Hf7eMVSFL8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvPrizeDialog.a(YYKtvPrizeDialog.this, view2);
                }
            });
        }
        a(this, 3000L);
        YYMsgKtvPrize yYMsgKtvPrize = this.a;
        ImageWrapper b = ImageLoader.a(a(), yYMsgKtvPrize.avatar).b(R.drawable.user_bg_round);
        FragmentYyKtvPrizeDialogBinding fragmentYyKtvPrizeDialogBinding2 = this.b;
        b.a(fragmentYyKtvPrizeDialogBinding2 == null ? null : fragmentYyKtvPrizeDialogBinding2.b);
        FragmentYyKtvPrizeDialogBinding fragmentYyKtvPrizeDialogBinding3 = this.b;
        TextView textView = fragmentYyKtvPrizeDialogBinding3 == null ? null : fragmentYyKtvPrizeDialogBinding3.c;
        if (textView != null) {
            textView.setText(yYMsgKtvPrize.name);
        }
        FragmentYyKtvPrizeDialogBinding fragmentYyKtvPrizeDialogBinding4 = this.b;
        TextView textView2 = fragmentYyKtvPrizeDialogBinding4 == null ? null : fragmentYyKtvPrizeDialogBinding4.d;
        if (textView2 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = getResources().getString(R.string.yy_ktv_clap);
            Intrinsics.c(string, "resources.getString(R.string.yy_ktv_clap)");
            String format = String.format(string, Arrays.copyOf(new Object[]{yYMsgKtvPrize.applause}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView2.setText(format);
        }
        FragmentYyKtvPrizeDialogBinding fragmentYyKtvPrizeDialogBinding5 = this.b;
        TextView textView3 = fragmentYyKtvPrizeDialogBinding5 == null ? null : fragmentYyKtvPrizeDialogBinding5.e;
        if (textView3 == null) {
            return;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
        String string2 = getResources().getString(R.string.yy_ktv_got_gift);
        Intrinsics.c(string2, "resources.getString(R.string.yy_ktv_got_gift)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{yYMsgKtvPrize.gift}, 1));
        Intrinsics.c(format2, "format(format, *args)");
        textView3.setText(format2);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_prize_dialog, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_dialog, container, true)");
        this.b = FragmentYyKtvPrizeDialogBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // java.lang.Runnable
    public void run() {
        dismissAllowingStateLoss();
    }
}

package com.soft.blued.ui.home.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.anythink.expressad.a;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.home.model.ALinkActionModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/DialogALink.class */
public final class DialogALink extends CommonDialogFragment {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private final ALinkActionModel f17358c;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/DialogALink$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, ALinkActionModel aLinkActionModel) {
            Intrinsics.e(context, "context");
            Intrinsics.e(aLinkActionModel, "model");
            new DialogALink(aLinkActionModel).show(((FragmentActivity) context).getSupportFragmentManager(), "");
        }
    }

    public DialogALink(ALinkActionModel aLinkActionModel) {
        Intrinsics.e(aLinkActionModel, "model");
        this.f17358c = aLinkActionModel;
    }

    @JvmStatic
    public static final void a(Context context, ALinkActionModel aLinkActionModel) {
        b.a(context, aLinkActionModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogALink dialogALink, View view) {
        Tracker.onClick(view);
        Intrinsics.e(dialogALink, "this$0");
        dialogALink.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogALink dialogALink, View view) {
        Tracker.onClick(view);
        Intrinsics.e(dialogALink, "this$0");
        WebViewShowInfoFragment.show(dialogALink.getContext(), dialogALink.f17358c.getJump_link(), -1);
        dialogALink.dismiss();
    }

    public void a(View view) {
        Intrinsics.e(view, a.B);
        view.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.pop.-$$Lambda$DialogALink$rDsavQQEkR6Et2md-USnYH88HQc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogALink.a(DialogALink.this, view2);
            }
        });
        ImageView imageView = (ImageView) view.findViewById(R.id.img_advert);
        ImageLoader.a(a(), this.f17358c.getPopup_image()).a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.pop.-$$Lambda$DialogALink$4jA7Mowc_Hvjx0lrmFVCk2wri10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DialogALink.b(DialogALink.this, view2);
            }
        });
        BluedPreferences.a().c().a("dialog_show_times", this.f17358c.getLocal_dialog_show_times()).b();
        BluedPreferences.a().c().a("dialog_last_show_time", System.currentTimeMillis()).b();
    }

    public int d() {
        return R.layout.pop_alink;
    }
}

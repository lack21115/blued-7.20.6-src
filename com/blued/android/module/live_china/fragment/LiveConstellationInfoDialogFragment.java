package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.anythink.basead.b.a;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.view.subscaleview.ImageSource;
import com.blued.android.module.live.base.view.subscaleview.ImageViewState;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveConstellationInfoBinding;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationInfoDialogFragment.class */
public final class LiveConstellationInfoDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLiveConstellationInfoBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationInfoDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveConstellationInfoBinding invoke() {
            return DialogLiveConstellationInfoBinding.a(LayoutInflater.from(LiveConstellationInfoDialogFragment.this.getContext()));
        }
    });

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveConstellationInfoDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveConstellationInfoDialogFragment a(FragmentManager manager, String str) {
            Intrinsics.e(manager, "manager");
            LiveConstellationInfoDialogFragment liveConstellationInfoDialogFragment = new LiveConstellationInfoDialogFragment();
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                Bundle bundle = new Bundle();
                bundle.putString(a.C0030a.h, str);
                liveConstellationInfoDialogFragment.setArguments(bundle);
            }
            liveConstellationInfoDialogFragment.show(manager, LiveConstellationInfoDialogFragment.class.getSimpleName());
            return liveConstellationInfoDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConstellationInfoDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveConstellationInfoDialogFragment this$0, String it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = this$0.d().c.getWidth();
        final ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(this$0.a()).a(it).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.LiveConstellationInfoDialogFragment$initView$2$1$1
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                DialogLiveConstellationInfoBinding d;
                DialogLiveConstellationInfoBinding d2;
                if (file == null || !file.exists()) {
                    return;
                }
                d = LiveConstellationInfoDialogFragment.this.d();
                d.c.setZoomEnabled(false);
                float a2 = imageSize.a();
                float f = 1.0f;
                if (intRef.a > 0) {
                    f = 1.0f;
                    if (a2 > 0.0f) {
                        f = (intRef.a * 1.0f) / a2;
                    }
                }
                d2 = LiveConstellationInfoDialogFragment.this.d();
                d2.c.a(ImageSource.b(file.getAbsolutePath()), new ImageViewState(f, new PointF(0.0f, 0.0f), 0));
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveConstellationInfoBinding d() {
        return (DialogLiveConstellationInfoBinding) this.b.getValue();
    }

    private final void e() {
        final String string;
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688526244_65682.webp").b(R.drawable.live_constellation_info_bg_preview).a(d().b);
        ImageLoader.a(a(), "https://web.bldimg.com/image-manager/1688526244_67560.webp").c(300).a(d().a);
        d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationInfoDialogFragment$RqAkpr24R8vfqIkstK8nQ4mU3oU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConstellationInfoDialogFragment.a(LiveConstellationInfoDialogFragment.this, view);
            }
        });
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(a.C0030a.h, null)) == null) {
            return;
        }
        d().c.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveConstellationInfoDialogFragment$ojYKGDIXYhbbvM41jZ7DnjbdFu0
            @Override // java.lang.Runnable
            public final void run() {
                LiveConstellationInfoDialogFragment.a(LiveConstellationInfoDialogFragment.this, string);
            }
        });
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 623.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView((View) d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
    }
}

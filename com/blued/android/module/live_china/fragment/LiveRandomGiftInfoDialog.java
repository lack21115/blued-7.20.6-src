package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveRandomGiftInfoBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftInfoDialog.class */
public final class LiveRandomGiftInfoDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13177a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLiveRandomGiftInfoBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftInfoDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveRandomGiftInfoBinding invoke() {
            return DialogLiveRandomGiftInfoBinding.a(LayoutInflater.from(LiveRandomGiftInfoDialog.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private String f13178c = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftInfoDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveRandomGiftInfoDialog a(String imgUrl, FragmentManager fragmentManager) {
            Intrinsics.e(imgUrl, "imgUrl");
            Intrinsics.e(fragmentManager, "fragmentManager");
            LiveRandomGiftInfoDialog liveRandomGiftInfoDialog = new LiveRandomGiftInfoDialog();
            Bundle bundle = new Bundle();
            bundle.putString("img_url", imgUrl);
            liveRandomGiftInfoDialog.setArguments(bundle);
            liveRandomGiftInfoDialog.show(fragmentManager, LiveRandomGiftInfoDialog.class.getSimpleName());
            return liveRandomGiftInfoDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ImageSize imageSize, int i, LiveRandomGiftInfoDialog this$0, File file, Exception exc) {
        Intrinsics.e(imageSize, "$imageSize");
        Intrinsics.e(this$0, "this$0");
        if (file == null || !file.exists()) {
            return;
        }
        float a2 = imageSize.a();
        float b = imageSize.b();
        if (a2 > 0.0f && b > 0.0f) {
            int i2 = (int) ((b / a2) * i);
            ViewGroup.LayoutParams layoutParams = this$0.d().b.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = i;
            layoutParams.height = i2;
            this$0.d().b.setLayoutParams(layoutParams);
        }
        ImageLoader.a(this$0.a(), this$0.f13178c).a(this$0.d().b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveRandomGiftInfoDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        final int width = this$0.d().b.getWidth();
        final ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(this$0.a()).a(this$0.f13178c).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftInfoDialog$A37Tcdc7Txqvhd8MwK7sUgSW_YU
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public final void onUIFinish(File file, Exception exc) {
                LiveRandomGiftInfoDialog.a(ImageSize.this, width, this$0, file, exc);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRandomGiftInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final DialogLiveRandomGiftInfoBinding d() {
        return (DialogLiveRandomGiftInfoBinding) this.b.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 571.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
            EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_RANDOM_GIFT_EXPLAIN_PAGE_SHOW, LiveRoomManager.a().e());
            return dialog;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_EXPLAIN_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(d().getRoot());
        Window window = dialog.getWindow();
        boolean z = false;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("img_url", "");
            Intrinsics.c(string, "it.getString(\"img_url\", \"\")");
            this.f13178c = string;
        }
        if (this.f13178c.length() == 0) {
            z = true;
        }
        if (z) {
            return;
        }
        d().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftInfoDialog$UVQQ_xlpKwAy1oiNU8RewgElLl4
            @Override // java.lang.Runnable
            public final void run() {
                LiveRandomGiftInfoDialog.a(LiveRandomGiftInfoDialog.this);
            }
        });
        d().f11811a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftInfoDialog$mSt0pNcc7bj5oCkMcFQHGuWntBE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRandomGiftInfoDialog.a(LiveRandomGiftInfoDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}

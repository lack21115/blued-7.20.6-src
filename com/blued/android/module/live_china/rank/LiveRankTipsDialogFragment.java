package com.blued.android.module.live_china.rank;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.live.base.view.subscaleview.ImageSource;
import com.blued.android.module.live.base.view.subscaleview.ImageViewState;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveAllStationRankTipBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/LiveRankTipsDialogFragment.class */
public final class LiveRankTipsDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LiveAllStationRankTipBinding>() { // from class: com.blued.android.module.live_china.rank.LiveRankTipsDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveAllStationRankTipBinding invoke() {
            return LiveAllStationRankTipBinding.a(LayoutInflater.from(LiveRankTipsDialogFragment.this.getContext()));
        }
    });
    private String c = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/LiveRankTipsDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LiveRankTipsDialogFragment a(FragmentManager manager, String data) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(data, "data");
            LiveRankTipsDialogFragment liveRankTipsDialogFragment = new LiveRankTipsDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("link", data);
            liveRankTipsDialogFragment.setArguments(bundle);
            liveRankTipsDialogFragment.show(manager, LiveRankTipsDialogFragment.class.getSimpleName());
            return liveRankTipsDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveRankTipsDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = this$0.d().b.getWidth();
        final ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(this$0.a()).a(this$0.c).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankTipsDialogFragment$OQOACRdMBMQ9eIIdpbcw-rw_j8o
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public final void onUIFinish(File file, Exception exc) {
                LiveRankTipsDialogFragment.a(LiveRankTipsDialogFragment.this, imageSize, intRef, file, exc);
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRankTipsDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_VIP_POP_CLOSE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRankTipsDialogFragment this$0, ImageSize imageSize, Ref.IntRef width, File file, Exception exc) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(imageSize, "$imageSize");
        Intrinsics.e(width, "$width");
        if (file == null || !file.exists()) {
            return;
        }
        this$0.d().b.setZoomEnabled(false);
        float a2 = imageSize.a();
        float f = 1.0f;
        if (width.a > 0) {
            f = 1.0f;
            if (a2 > 0.0f) {
                f = (width.a * 1.0f) / a2;
            }
        }
        this$0.d().b.a(ImageSource.b(file.getAbsolutePath()), new ImageViewState(f, new PointF(0.0f, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    private final LiveAllStationRankTipBinding d() {
        return (LiveAllStationRankTipBinding) this.b.getValue();
    }

    private final void e() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("link", "");
            Intrinsics.c(string, "it.getString(\"link\", \"\")");
            this.c = string;
        }
        d().a.setVisibility(0);
        d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankTipsDialogFragment$xVPJJ_6pX_VyhSmmGXtRt8CIBtY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRankTipsDialogFragment.a(LiveRankTipsDialogFragment.this, view);
            }
        });
        d().b.post(new Runnable() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankTipsDialogFragment$JZsYLjut7uRf6rlPPyooVtiMUWk
            @Override // java.lang.Runnable
            public final void run() {
                LiveRankTipsDialogFragment.a(LiveRankTipsDialogFragment.this);
            }
        });
    }

    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i = AppInfo.l;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankTipsDialogFragment$QtlqXqqlb09Ui_x68YmLvS7UtLw
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveRankTipsDialogFragment.a(dialogInterface, i2, keyEvent);
                return a2;
            }
        });
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().c, new ViewGroup.LayoutParams(i, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i;
        attributes.height = -1;
        attributes.gravity = 80;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        Intrinsics.a(attributes);
        attributes.dimAmount = 0.7f;
        Window window2 = dialog.getWindow();
        if (window2 == null) {
            return;
        }
        window2.setAttributes(attributes);
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
    }
}

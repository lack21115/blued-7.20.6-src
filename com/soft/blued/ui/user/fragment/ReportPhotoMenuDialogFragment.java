package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.databinding.DialogReportPhotoMenuBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportPhotoMenuDialogFragment.class */
public final class ReportPhotoMenuDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33951a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogReportPhotoMenuBinding>() { // from class: com.soft.blued.ui.user.fragment.ReportPhotoMenuDialogFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogReportPhotoMenuBinding invoke() {
            return DialogReportPhotoMenuBinding.a(LayoutInflater.from(ReportPhotoMenuDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private ClickCameraListener f33952c;
    private ClickAlbumListener d;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportPhotoMenuDialogFragment$ClickAlbumListener.class */
    public interface ClickAlbumListener {
        void a();
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportPhotoMenuDialogFragment$ClickCameraListener.class */
    public interface ClickCameraListener {
        void onClick();
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ReportPhotoMenuDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReportPhotoMenuDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            ReportPhotoMenuDialogFragment reportPhotoMenuDialogFragment = new ReportPhotoMenuDialogFragment();
            reportPhotoMenuDialogFragment.show(manager, ReportPhotoMenuDialogFragment.class.getSimpleName());
            return reportPhotoMenuDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ReportPhotoMenuDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ReportPhotoMenuDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        ClickCameraListener clickCameraListener = this$0.f33952c;
        if (clickCameraListener != null) {
            clickCameraListener.onClick();
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ReportPhotoMenuDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        ClickAlbumListener clickAlbumListener = this$0.d;
        if (clickAlbumListener != null) {
            clickAlbumListener.a();
        }
        this$0.dismiss();
    }

    private final void i() {
        h().e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ReportPhotoMenuDialogFragment$XvXn_bK3OHeAZTXljEMvjVaCECc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportPhotoMenuDialogFragment.a(ReportPhotoMenuDialogFragment.this, view);
            }
        });
        h().b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ReportPhotoMenuDialogFragment$NREKz-Qzi_WxMVwZwL6B7pOCFKw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportPhotoMenuDialogFragment.b(ReportPhotoMenuDialogFragment.this, view);
            }
        });
        h().d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ReportPhotoMenuDialogFragment$ccAwZqfEnHNYr372PiZSfvlUXGQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReportPhotoMenuDialogFragment.c(ReportPhotoMenuDialogFragment.this, view);
            }
        });
    }

    public final void a(ClickAlbumListener clickAlbumListener) {
        this.d = clickAlbumListener;
    }

    public final void a(ClickCameraListener clickCameraListener) {
        this.f33952c = clickCameraListener;
    }

    public final DialogReportPhotoMenuBinding h() {
        return (DialogReportPhotoMenuBinding) this.b.getValue();
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(h().getRoot());
        i();
    }
}

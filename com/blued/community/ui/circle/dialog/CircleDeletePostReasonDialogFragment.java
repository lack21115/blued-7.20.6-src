package com.blued.community.ui.circle.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.R;
import com.blued.community.databinding.DialogCircleDeletePostReasonBinding;
import com.blued.community.http.CircleHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/dialog/CircleDeletePostReasonDialogFragment.class */
public final class CircleDeletePostReasonDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19138a = new Companion(null);
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private DialogCircleDeletePostReasonBinding f19139c;
    private Dialog d;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/dialog/CircleDeletePostReasonDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CircleDeletePostReasonDialogFragment a(Context context, String noteId) {
            Intrinsics.e(context, "context");
            Intrinsics.e(noteId, "noteId");
            CircleDeletePostReasonDialogFragment circleDeletePostReasonDialogFragment = new CircleDeletePostReasonDialogFragment(noteId);
            if (context instanceof FragmentActivity) {
                circleDeletePostReasonDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), CircleDeletePostReasonDialogFragment.class.getSimpleName());
            }
            return circleDeletePostReasonDialogFragment;
        }
    }

    public CircleDeletePostReasonDialogFragment(String noteId) {
        Intrinsics.e(noteId, "noteId");
        this.b = noteId;
    }

    private final void a(final Dialog dialog) {
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding = this.f19139c;
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding2 = dialogCircleDeletePostReasonBinding;
        if (dialogCircleDeletePostReasonBinding == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding2 = null;
        }
        dialogCircleDeletePostReasonBinding2.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.dialog.-$$Lambda$CircleDeletePostReasonDialogFragment$x9MZ4zF32S8xEo9X4SIZXkOEP-0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleDeletePostReasonDialogFragment.a(Dialog.this, view);
            }
        });
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding3 = this.f19139c;
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding4 = dialogCircleDeletePostReasonBinding3;
        if (dialogCircleDeletePostReasonBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding4 = null;
        }
        dialogCircleDeletePostReasonBinding4.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.dialog.-$$Lambda$CircleDeletePostReasonDialogFragment$Vtud_ZglyKG0W0gD_6QSP1to-HU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleDeletePostReasonDialogFragment.a(CircleDeletePostReasonDialogFragment.this, view);
            }
        });
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding5 = this.f19139c;
        if (dialogCircleDeletePostReasonBinding5 == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding5 = null;
        }
        dialogCircleDeletePostReasonBinding5.i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.blued.community.ui.circle.dialog.-$$Lambda$CircleDeletePostReasonDialogFragment$trvauoHPQ4pMOSs1Fo-hof3YsHI
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                CircleDeletePostReasonDialogFragment.a(CircleDeletePostReasonDialogFragment.this, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Dialog dialog, View view) {
        Intrinsics.e(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleDeletePostReasonDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CircleDeletePostReasonDialogFragment this$0, RadioGroup radioGroup, int i) {
        Intrinsics.e(this$0, "this$0");
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding = this$0.f19139c;
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding2 = dialogCircleDeletePostReasonBinding;
        if (dialogCircleDeletePostReasonBinding == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding2 = null;
        }
        dialogCircleDeletePostReasonBinding2.k.setEnabled(true);
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding3 = this$0.f19139c;
        if (dialogCircleDeletePostReasonBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding3 = null;
        }
        dialogCircleDeletePostReasonBinding3.k.setAlpha(1.0f);
    }

    private final void i() {
        Context context = getContext();
        final ActivityFragmentActive a2 = a();
        CircleHttpUtils.a(context, new BluedUIHttpResponse<BluedEntityA<Object>>(a2) { // from class: com.blued.community.ui.circle.dialog.CircleDeletePostReasonDialogFragment$deletePost$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                CircleDeletePostReasonDialogFragment.this.dismiss();
                LiveEventBus.get("circle_delete_feed").post(CircleDeletePostReasonDialogFragment.this.h());
                AppMethods.a(R.string.circle_post_detail_menu_delete_success, true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                Dialog dialog;
                super.onUIFinish(z);
                dialog = CircleDeletePostReasonDialogFragment.this.d;
                if (dialog == null) {
                    return;
                }
                dialog.dismiss();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                Dialog dialog;
                super.onUIStart();
                dialog = CircleDeletePostReasonDialogFragment.this.d;
                if (dialog == null) {
                    return;
                }
                dialog.show();
            }
        }, this.b, String.valueOf(j()), a());
    }

    private final int j() {
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding = this.f19139c;
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding2 = dialogCircleDeletePostReasonBinding;
        if (dialogCircleDeletePostReasonBinding == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding2 = null;
        }
        int checkedRadioButtonId = dialogCircleDeletePostReasonBinding2.i.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.RadioButton1) {
            return 1;
        }
        if (checkedRadioButtonId == R.id.RadioButton2) {
            return 2;
        }
        if (checkedRadioButtonId == R.id.RadioButton3) {
            return 3;
        }
        if (checkedRadioButtonId == R.id.RadioButton4) {
            return 4;
        }
        if (checkedRadioButtonId == R.id.RadioButton5) {
            return 5;
        }
        return checkedRadioButtonId == R.id.RadioButton6 ? 6 : -1;
    }

    public final String h() {
        return this.b;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        DialogCircleDeletePostReasonBinding a2 = DialogCircleDeletePostReasonBinding.a(LayoutInflater.from(getContext()));
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
        this.f19139c = a2;
        DialogCircleDeletePostReasonBinding dialogCircleDeletePostReasonBinding = a2;
        if (a2 == null) {
            Intrinsics.c("viewBinding");
            dialogCircleDeletePostReasonBinding = null;
        }
        dialog.setContentView(dialogCircleDeletePostReasonBinding.getRoot());
        this.d = DialogUtils.a(getContext());
        a(dialog);
    }
}

package com.blued.community.ui.send.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.community.R;
import com.blued.community.databinding.DialogFeedPostReadAuthBinding;
import com.blued.community.ui.send.vm.FeedPostViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/FeedPostReadAuthDialogFragment.class */
public final class FeedPostReadAuthDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19920a = new Companion(null);
    private DialogFeedPostReadAuthBinding b;

    /* renamed from: c  reason: collision with root package name */
    private int f19921c;
    private int d;
    private FeedPostViewModel e;
    private int f;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/FeedPostReadAuthDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FeedPostReadAuthDialogFragment a(FragmentManager manager, int i) {
            Intrinsics.e(manager, "manager");
            FeedPostReadAuthDialogFragment feedPostReadAuthDialogFragment = new FeedPostReadAuthDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("show_type", i);
            feedPostReadAuthDialogFragment.setArguments(bundle);
            feedPostReadAuthDialogFragment.show(manager, FeedPostReadAuthDialogFragment.class.getSimpleName());
            return feedPostReadAuthDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(FeedPostReadAuthDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.r();
    }

    private final void j() {
        FeedPostReadAuthDialogFragment feedPostReadAuthDialogFragment = this;
        FeedPostViewModel feedPostViewModel = this.e;
        FeedPostViewModel feedPostViewModel2 = feedPostViewModel;
        if (feedPostViewModel == null) {
            Intrinsics.c("mViewModel");
            feedPostViewModel2 = null;
        }
        LifecycleExtKt.a(feedPostReadAuthDialogFragment, feedPostViewModel2.d(), new Function1<Integer, Unit>() { // from class: com.blued.community.ui.send.dialog.FeedPostReadAuthDialogFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Integer num) {
                if (num != null && num.intValue() == 0) {
                    FeedPostReadAuthDialogFragment.this.l();
                } else if (num != null && num.intValue() == 1) {
                    FeedPostReadAuthDialogFragment.this.m();
                } else if (num != null && num.intValue() == 2) {
                    FeedPostReadAuthDialogFragment.this.n();
                } else {
                    FeedPostReadAuthDialogFragment.this.l();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Integer num) {
                a(num);
                return Unit.f42314a;
            }
        });
        FeedPostViewModel feedPostViewModel3 = this.e;
        if (feedPostViewModel3 == null) {
            Intrinsics.c("mViewModel");
            feedPostViewModel3 = null;
        }
        LifecycleExtKt.a(feedPostReadAuthDialogFragment, feedPostViewModel3.e(), new Function1<Integer, Unit>() { // from class: com.blued.community.ui.send.dialog.FeedPostReadAuthDialogFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(Integer num) {
                if (num != null && num.intValue() == 0) {
                    FeedPostReadAuthDialogFragment.this.o();
                } else if (num != null && num.intValue() == 1) {
                    FeedPostReadAuthDialogFragment.this.p();
                } else if (num != null && num.intValue() == 2) {
                    FeedPostReadAuthDialogFragment.this.q();
                } else if (num != null && num.intValue() == 3) {
                    FeedPostReadAuthDialogFragment.this.r();
                } else {
                    FeedPostReadAuthDialogFragment.this.o();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Integer num) {
                a(num);
                return Unit.f42314a;
            }
        });
    }

    private final void k() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f = arguments.getInt("show_type");
        }
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        ViewGroup.LayoutParams layoutParams = dialogFeedPostReadAuthBinding2.r.getLayoutParams();
        FeedPostViewModel feedPostViewModel = this.e;
        FeedPostViewModel feedPostViewModel2 = feedPostViewModel;
        if (feedPostViewModel == null) {
            Intrinsics.c("mViewModel");
            feedPostViewModel2 = null;
        }
        layoutParams.height = feedPostViewModel2.g();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding4 = dialogFeedPostReadAuthBinding3;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding4 = null;
        }
        dialogFeedPostReadAuthBinding4.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$XM8V_DItYVhWIJylqJZyXR26cmc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.a(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding5 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding6 = dialogFeedPostReadAuthBinding5;
        if (dialogFeedPostReadAuthBinding5 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding6 = null;
        }
        dialogFeedPostReadAuthBinding6.w.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$Cf6dLZ8_RWGIYmg4MCnIwlgC1v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.b(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding7 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding8 = dialogFeedPostReadAuthBinding7;
        if (dialogFeedPostReadAuthBinding7 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding8 = null;
        }
        dialogFeedPostReadAuthBinding8.o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$ANKdVVep6G-ykaIOrD-A1qvHlX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.c(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding9 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding10 = dialogFeedPostReadAuthBinding9;
        if (dialogFeedPostReadAuthBinding9 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding10 = null;
        }
        dialogFeedPostReadAuthBinding10.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$WPjZTJ_Oro1-B2GWEhsaS5MNlks
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.d(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding11 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding12 = dialogFeedPostReadAuthBinding11;
        if (dialogFeedPostReadAuthBinding11 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding12 = null;
        }
        dialogFeedPostReadAuthBinding12.q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$3KMNcXid59tYuxDUk47XqJIXqg8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.e(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding13 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding14 = dialogFeedPostReadAuthBinding13;
        if (dialogFeedPostReadAuthBinding13 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding14 = null;
        }
        dialogFeedPostReadAuthBinding14.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$bXYqDDsvKqCLVRWgMtssdnFsh9I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.f(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding15 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding16 = dialogFeedPostReadAuthBinding15;
        if (dialogFeedPostReadAuthBinding15 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding16 = null;
        }
        dialogFeedPostReadAuthBinding16.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$osTvSouM4DTwNmD0CFq61WTH_CM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.g(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding17 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding18 = dialogFeedPostReadAuthBinding17;
        if (dialogFeedPostReadAuthBinding17 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding18 = null;
        }
        dialogFeedPostReadAuthBinding18.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$cI6SizHkPwOW8ytq_BctqzXXY2E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.h(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding19 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding20 = dialogFeedPostReadAuthBinding19;
        if (dialogFeedPostReadAuthBinding19 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding20 = null;
        }
        dialogFeedPostReadAuthBinding20.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$FeedPostReadAuthDialogFragment$Rlb3vTLmCJYdaik1znUXrM_X368
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostReadAuthDialogFragment.i(FeedPostReadAuthDialogFragment.this, view);
            }
        });
        if (this.f == 1) {
            DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding21 = this.b;
            if (dialogFeedPostReadAuthBinding21 == null) {
                Intrinsics.c("viewBinding");
                dialogFeedPostReadAuthBinding21 = null;
            }
            dialogFeedPostReadAuthBinding21.f18801a.setVisibility(8);
            return;
        }
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding22 = this.b;
        if (dialogFeedPostReadAuthBinding22 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding22 = null;
        }
        dialogFeedPostReadAuthBinding22.f18801a.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        s();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.x.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.g.setVisibility(0);
        this.f19921c = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        s();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.y.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.h.setVisibility(0);
        this.f19921c = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        s();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.z.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.i.setVisibility(0);
        this.f19921c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        t();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.s.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.f18802c.setVisibility(0);
        this.d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        t();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.v.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.f.setVisibility(0);
        this.d = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        t();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.u.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.e.setVisibility(0);
        this.d = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        t();
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.t.setTextColor(requireContext().getResources().getColor(R.color.syc_a));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding3 = null;
        }
        dialogFeedPostReadAuthBinding3.d.setVisibility(0);
        this.d = 3;
    }

    private final void s() {
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.x.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding4 = dialogFeedPostReadAuthBinding3;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding4 = null;
        }
        dialogFeedPostReadAuthBinding4.g.setVisibility(8);
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding5 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding6 = dialogFeedPostReadAuthBinding5;
        if (dialogFeedPostReadAuthBinding5 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding6 = null;
        }
        dialogFeedPostReadAuthBinding6.y.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding7 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding8 = dialogFeedPostReadAuthBinding7;
        if (dialogFeedPostReadAuthBinding7 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding8 = null;
        }
        dialogFeedPostReadAuthBinding8.h.setVisibility(8);
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding9 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding10 = dialogFeedPostReadAuthBinding9;
        if (dialogFeedPostReadAuthBinding9 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding10 = null;
        }
        dialogFeedPostReadAuthBinding10.z.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding11 = this.b;
        if (dialogFeedPostReadAuthBinding11 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding11 = null;
        }
        dialogFeedPostReadAuthBinding11.i.setVisibility(8);
    }

    private final void t() {
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding2 = dialogFeedPostReadAuthBinding;
        if (dialogFeedPostReadAuthBinding == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding2 = null;
        }
        dialogFeedPostReadAuthBinding2.s.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding3 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding4 = dialogFeedPostReadAuthBinding3;
        if (dialogFeedPostReadAuthBinding3 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding4 = null;
        }
        dialogFeedPostReadAuthBinding4.f18802c.setVisibility(8);
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding5 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding6 = dialogFeedPostReadAuthBinding5;
        if (dialogFeedPostReadAuthBinding5 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding6 = null;
        }
        dialogFeedPostReadAuthBinding6.v.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding7 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding8 = dialogFeedPostReadAuthBinding7;
        if (dialogFeedPostReadAuthBinding7 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding8 = null;
        }
        dialogFeedPostReadAuthBinding8.f.setVisibility(8);
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding9 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding10 = dialogFeedPostReadAuthBinding9;
        if (dialogFeedPostReadAuthBinding9 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding10 = null;
        }
        dialogFeedPostReadAuthBinding10.u.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding11 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding12 = dialogFeedPostReadAuthBinding11;
        if (dialogFeedPostReadAuthBinding11 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding12 = null;
        }
        dialogFeedPostReadAuthBinding12.e.setVisibility(8);
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding13 = this.b;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding14 = dialogFeedPostReadAuthBinding13;
        if (dialogFeedPostReadAuthBinding13 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding14 = null;
        }
        dialogFeedPostReadAuthBinding14.t.setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding15 = this.b;
        if (dialogFeedPostReadAuthBinding15 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding15 = null;
        }
        dialogFeedPostReadAuthBinding15.d.setVisibility(8);
    }

    public final void h() {
        FeedPostViewModel feedPostViewModel = this.e;
        FeedPostViewModel feedPostViewModel2 = feedPostViewModel;
        if (feedPostViewModel == null) {
            Intrinsics.c("mViewModel");
            feedPostViewModel2 = null;
        }
        feedPostViewModel2.d().setValue(Integer.valueOf(this.f19921c));
        FeedPostViewModel feedPostViewModel3 = this.e;
        if (feedPostViewModel3 == null) {
            Intrinsics.c("mViewModel");
            feedPostViewModel3 = null;
        }
        feedPostViewModel3.e().setValue(Integer.valueOf(this.d));
        dismiss();
    }

    public final void i() {
        dismiss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewModelStore viewModelStore = requireActivity().getViewModelStore();
        Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
        Context d = AppInfo.d();
        if (d == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        this.e = (FeedPostViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(FeedPostViewModel.class);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        DialogFeedPostReadAuthBinding a2 = DialogFeedPostReadAuthBinding.a(LayoutInflater.from(getContext()));
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
        this.b = a2;
        DialogFeedPostReadAuthBinding dialogFeedPostReadAuthBinding = a2;
        if (a2 == null) {
            Intrinsics.c("viewBinding");
            dialogFeedPostReadAuthBinding = null;
        }
        dialog.setContentView(dialogFeedPostReadAuthBinding.getRoot());
        BottomSheetBehavior<FrameLayout> a3 = ((BottomSheetDialog) dialog).a();
        FeedPostViewModel feedPostViewModel = this.e;
        if (feedPostViewModel == null) {
            Intrinsics.c("mViewModel");
            feedPostViewModel = null;
        }
        a3.a(feedPostViewModel.g());
        j();
        k();
    }
}

package com.blued.community.ui.send.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.DialogAlbumSelectBinding;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.dialog.AlbumSelectDialogFragment;
import com.blued.community.ui.send.fragment.AlbumSelectFragment;
import com.blued.community.ui.send.fragment.AlbumSelectHalfFragment;
import com.blued.community.ui.send.vm.FeedPostViewModel;
import com.blued.community.ui.send.vm.SelectAlbumViewModel;
import com.blued.community.utils.ViewUtils;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/AlbumSelectDialogFragment.class */
public final class AlbumSelectDialogFragment extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private DialogAlbumSelectBinding f;
    private SelectAlbumViewModel g;
    private FeedPostViewModel h;
    private AlbumSelectHalfFragment i;
    private BottomSheetBehavior<FrameLayout> j;
    private boolean k;
    private AlbumSelectOnDismissListener l;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/AlbumSelectDialogFragment$AlbumSelectOnDismissListener.class */
    public interface AlbumSelectOnDismissListener {
        View a(MotionEvent motionEvent);

        void a(DialogFragment dialogFragment, View view);
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/AlbumSelectDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AlbumSelectDialogFragment a(final FragmentActivity fragmentActivity, int i, int i2, int i3, int i4, boolean z) {
            Intrinsics.e(fragmentActivity, "fragmentActivity");
            final AlbumSelectDialogFragment albumSelectDialogFragment = new AlbumSelectDialogFragment();
            Bundle a = AlbumSelectFragment.a(i, i2, i3, i4);
            a.putBoolean("show_peek", z);
            albumSelectDialogFragment.setArguments(a);
            if (!CommunityServiceManager.a().b((Context) fragmentActivity)) {
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.community.ui.send.dialog.AlbumSelectDialogFragment$Companion$show$1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        AlbumSelectDialogFragment albumSelectDialogFragment2 = AlbumSelectDialogFragment.this;
                        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                        Intrinsics.c(supportFragmentManager, "fragmentActivity.supportFragmentManager");
                        albumSelectDialogFragment2.show(supportFragmentManager, AlbumSelectDialogFragment.class.getSimpleName());
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] perms) {
                        Intrinsics.e(perms, "perms");
                    }
                });
            }
            return albumSelectDialogFragment;
        }
    }

    public AlbumSelectDialogFragment() {
        int a2 = KeyboardUtils.a();
        this.c = a2 <= 0 ? DensityUtils.a(AppInfo.d(), 320.0f) : a2;
        int a3 = DensityUtils.a(AppInfo.d(), 54.0f);
        this.d = a3;
        this.e = this.c + a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(float f) {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AlbumSelectDialogFragment this$0, FragmentManager manager, String str) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(manager, "$manager");
        super.show(manager, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(float f) {
        DialogAlbumSelectBinding dialogAlbumSelectBinding = this.f;
        ShapeFrameLayout shapeFrameLayout = dialogAlbumSelectBinding == null ? null : dialogAlbumSelectBinding.e;
        if (shapeFrameLayout != null) {
            shapeFrameLayout.setAlpha(f);
        }
        DialogAlbumSelectBinding dialogAlbumSelectBinding2 = this.f;
        View view = dialogAlbumSelectBinding2 == null ? null : dialogAlbumSelectBinding2.f;
        if (view != null) {
            view.setAlpha(f);
        }
        if (f == 0.0f) {
            DialogAlbumSelectBinding dialogAlbumSelectBinding3 = this.f;
            ShapeFrameLayout shapeFrameLayout2 = dialogAlbumSelectBinding3 == null ? null : dialogAlbumSelectBinding3.e;
            if (shapeFrameLayout2 != null) {
                shapeFrameLayout2.setVisibility(4);
            }
            DialogAlbumSelectBinding dialogAlbumSelectBinding4 = this.f;
            View view2 = dialogAlbumSelectBinding4 == null ? null : dialogAlbumSelectBinding4.f;
            if (view2 != null) {
                view2.setVisibility(4);
            }
        } else {
            DialogAlbumSelectBinding dialogAlbumSelectBinding5 = this.f;
            ShapeFrameLayout shapeFrameLayout3 = dialogAlbumSelectBinding5 == null ? null : dialogAlbumSelectBinding5.e;
            if (shapeFrameLayout3 != null) {
                shapeFrameLayout3.setVisibility(0);
            }
            DialogAlbumSelectBinding dialogAlbumSelectBinding6 = this.f;
            View view3 = dialogAlbumSelectBinding6 == null ? null : dialogAlbumSelectBinding6.f;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
        AlbumSelectHalfFragment albumSelectHalfFragment = this.i;
        if (albumSelectHalfFragment == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment = null;
        }
        albumSelectHalfFragment.a(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AlbumSelectDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j() {
        SelectAlbumViewModel selectAlbumViewModel = this.g;
        SelectAlbumViewModel selectAlbumViewModel2 = selectAlbumViewModel;
        if (selectAlbumViewModel == null) {
            Intrinsics.c("mViewModel");
            selectAlbumViewModel2 = null;
        }
        return selectAlbumViewModel2.d() - this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AlbumSelectDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        DialogAlbumSelectBinding dialogAlbumSelectBinding = this$0.f;
        Intrinsics.a(dialogAlbumSelectBinding);
        ViewGroup.LayoutParams layoutParams = dialogAlbumSelectBinding.f.getLayoutParams();
        AlbumSelectHalfFragment albumSelectHalfFragment = this$0.i;
        AlbumSelectHalfFragment albumSelectHalfFragment2 = albumSelectHalfFragment;
        if (albumSelectHalfFragment == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment2 = null;
        }
        layoutParams.height = albumSelectHalfFragment2.r().getMeasuredHeight();
        Intrinsics.c(layoutParams, "viewBinding!!.viewTitleB…suredHeight\n            }");
        DialogAlbumSelectBinding dialogAlbumSelectBinding2 = this$0.f;
        Intrinsics.a(dialogAlbumSelectBinding2);
        dialogAlbumSelectBinding2.f.setLayoutParams(layoutParams);
        DialogAlbumSelectBinding dialogAlbumSelectBinding3 = this$0.f;
        Intrinsics.a(dialogAlbumSelectBinding3);
        ViewGroup.LayoutParams layoutParams2 = dialogAlbumSelectBinding3.d.getLayoutParams();
        AlbumSelectHalfFragment albumSelectHalfFragment3 = this$0.i;
        AlbumSelectHalfFragment albumSelectHalfFragment4 = albumSelectHalfFragment3;
        if (albumSelectHalfFragment3 == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment4 = null;
        }
        layoutParams2.height = albumSelectHalfFragment4.r().getMeasuredHeight();
        Intrinsics.c(layoutParams2, "viewBinding!!.titleBarTo…suredHeight\n            }");
        DialogAlbumSelectBinding dialogAlbumSelectBinding4 = this$0.f;
        Intrinsics.a(dialogAlbumSelectBinding4);
        dialogAlbumSelectBinding4.d.setLayoutParams(layoutParams2);
        AlbumSelectHalfFragment albumSelectHalfFragment5 = this$0.i;
        AlbumSelectHalfFragment albumSelectHalfFragment6 = albumSelectHalfFragment5;
        if (albumSelectHalfFragment5 == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment6 = null;
        }
        if (albumSelectHalfFragment6.requireFragmentManager().isStateSaved()) {
            return;
        }
        AlbumSelectHalfFragment albumSelectHalfFragment7 = this$0.i;
        AlbumSelectHalfFragment albumSelectHalfFragment8 = albumSelectHalfFragment7;
        if (albumSelectHalfFragment7 == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment8 = null;
        }
        albumSelectHalfFragment8.setArguments(this$0.getArguments());
        AlbumSelectHalfFragment albumSelectHalfFragment9 = this$0.i;
        AlbumSelectHalfFragment albumSelectHalfFragment10 = albumSelectHalfFragment9;
        if (albumSelectHalfFragment9 == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment10 = null;
        }
        albumSelectHalfFragment10.c(this$0.getArguments());
        if (this$0.k) {
            AlbumSelectHalfFragment albumSelectHalfFragment11 = this$0.i;
            if (albumSelectHalfFragment11 == null) {
                Intrinsics.c("albumSelectFragment");
                albumSelectHalfFragment11 = null;
            }
            albumSelectHalfFragment11.a(0.0f);
        }
    }

    public final void a(AlbumSelectOnDismissListener albumSelectOnDismissListener) {
        this.l = albumSelectOnDismissListener;
    }

    public final AlbumSelectOnDismissListener h() {
        return this.l;
    }

    public final void i() {
        this.i = new AlbumSelectHalfFragment();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        int i = R.id.fragment_layout;
        AlbumSelectHalfFragment albumSelectHalfFragment = this.i;
        AlbumSelectHalfFragment albumSelectHalfFragment2 = albumSelectHalfFragment;
        if (albumSelectHalfFragment == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment2 = null;
        }
        beginTransaction.replace(i, albumSelectHalfFragment2).commit();
        AlbumSelectHalfFragment albumSelectHalfFragment3 = this.i;
        AlbumSelectHalfFragment albumSelectHalfFragment4 = albumSelectHalfFragment3;
        if (albumSelectHalfFragment3 == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment4 = null;
        }
        albumSelectHalfFragment4.a(new AlbumSelectHalfFragment.OnClosePageListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$AlbumSelectDialogFragment$wwuxB-WfQHh6kGMhms29SjC0nJ8
            @Override // com.blued.community.ui.send.fragment.AlbumSelectHalfFragment.OnClosePageListener
            public final void onClosePage() {
                AlbumSelectDialogFragment.i(AlbumSelectDialogFragment.this);
            }
        });
        if (this.k) {
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.j;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = bottomSheetBehavior;
            if (bottomSheetBehavior == null) {
                Intrinsics.c("behavior");
                bottomSheetBehavior2 = null;
            }
            bottomSheetBehavior2.a(this.e);
            a(0.0f);
            b(0.0f);
            SelectAlbumViewModel selectAlbumViewModel = this.g;
            if (selectAlbumViewModel == null) {
                Intrinsics.c("mViewModel");
                selectAlbumViewModel = null;
            }
            selectAlbumViewModel.e().setValue(Integer.valueOf(this.c));
        } else {
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior3 = this.j;
            if (bottomSheetBehavior3 == null) {
                Intrinsics.c("behavior");
                bottomSheetBehavior3 = null;
            }
            bottomSheetBehavior3.a(j());
        }
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.blued.community.ui.send.dialog.AlbumSelectDialogFragment$init$onTouchListener$1
            private View b;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SelectAlbumViewModel selectAlbumViewModel2;
                SelectAlbumViewModel selectAlbumViewModel3;
                BottomSheetBehavior bottomSheetBehavior4;
                Intrinsics.e(v, "v");
                Intrinsics.e(event, "event");
                selectAlbumViewModel2 = AlbumSelectDialogFragment.this.g;
                SelectAlbumViewModel selectAlbumViewModel4 = selectAlbumViewModel2;
                if (selectAlbumViewModel2 == null) {
                    Intrinsics.c("mViewModel");
                    selectAlbumViewModel4 = null;
                }
                if (selectAlbumViewModel4.i()) {
                    int action = event.getAction();
                    if (action == 0) {
                        AlbumSelectDialogFragment.AlbumSelectOnDismissListener h = AlbumSelectDialogFragment.this.h();
                        this.b = h == null ? null : h.a(event);
                        return true;
                    } else if (action != 1) {
                        return true;
                    } else {
                        if (!ViewUtils.a(this.b, event)) {
                            AlbumSelectDialogFragment.this.dismiss();
                            return true;
                        }
                        View view = this.b;
                        if ((view == null ? null : view.getTag()) != null) {
                            View view2 = this.b;
                            Object tag = view2 == null ? null : view2.getTag();
                            if (tag == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                            if (((Integer) tag).intValue() == 101) {
                                selectAlbumViewModel3 = AlbumSelectDialogFragment.this.g;
                                SelectAlbumViewModel selectAlbumViewModel5 = selectAlbumViewModel3;
                                if (selectAlbumViewModel3 == null) {
                                    Intrinsics.c("mViewModel");
                                    selectAlbumViewModel5 = null;
                                }
                                selectAlbumViewModel5.m();
                                bottomSheetBehavior4 = AlbumSelectDialogFragment.this.j;
                                BottomSheetBehavior bottomSheetBehavior5 = bottomSheetBehavior4;
                                if (bottomSheetBehavior5 == null) {
                                    Intrinsics.c("behavior");
                                    bottomSheetBehavior5 = null;
                                }
                                bottomSheetBehavior5.d(3);
                                return true;
                            }
                        }
                        AlbumSelectDialogFragment.AlbumSelectOnDismissListener h2 = AlbumSelectDialogFragment.this.h();
                        if (h2 != null) {
                            h2.a(AlbumSelectDialogFragment.this, this.b);
                        }
                        View view3 = this.b;
                        if ((view3 == null ? null : view3.getTag()) != null) {
                            View view4 = this.b;
                            Object tag2 = view4 == null ? null : view4.getTag();
                            if (tag2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                            if (((Integer) tag2).intValue() == 102) {
                                return true;
                            }
                        }
                        AlbumSelectDialogFragment.this.a((AlbumSelectDialogFragment.AlbumSelectOnDismissListener) null);
                        AlbumSelectDialogFragment.this.dismiss();
                        return true;
                    }
                }
                return false;
            }
        };
        Dialog dialog = getDialog();
        Intrinsics.a(dialog);
        View findViewById = dialog.findViewById(R.id.touch_outside);
        if (findViewById != null) {
            findViewById.setOnTouchListener(onTouchListener);
        }
        DialogAlbumSelectBinding dialogAlbumSelectBinding = this.f;
        Intrinsics.a(dialogAlbumSelectBinding);
        ShapeFrameLayout shapeFrameLayout = dialogAlbumSelectBinding.e;
        View.OnTouchListener onTouchListener2 = onTouchListener;
        shapeFrameLayout.setOnTouchListener(onTouchListener2);
        DialogAlbumSelectBinding dialogAlbumSelectBinding2 = this.f;
        Intrinsics.a(dialogAlbumSelectBinding2);
        dialogAlbumSelectBinding2.d.setOnTouchListener(onTouchListener2);
        a(new Runnable() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$AlbumSelectDialogFragment$0jFb_9gT3HMZrzQAeJVimreuYtk
            @Override // java.lang.Runnable
            public final void run() {
                AlbumSelectDialogFragment.j(AlbumSelectDialogFragment.this);
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        i();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewModelStore viewModelStore = requireActivity().getViewModelStore();
        Intrinsics.c(viewModelStore, "requireActivity().viewModelStore");
        ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
        Context d = AppInfo.d();
        if (d == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        this.g = (SelectAlbumViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(SelectAlbumViewModel.class);
        ViewModelStore viewModelStore2 = requireActivity().getViewModelStore();
        Intrinsics.c(viewModelStore2, "requireActivity().viewModelStore");
        ViewModelProvider.AndroidViewModelFactory.Companion companion2 = ViewModelProvider.AndroidViewModelFactory.Companion;
        Context d2 = AppInfo.d();
        if (d2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
        this.h = (FeedPostViewModel) new ViewModelProvider(viewModelStore2, companion2.getInstance((Application) d2)).get(FeedPostViewModel.class);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        DialogAlbumSelectBinding a2 = DialogAlbumSelectBinding.a(inflater, viewGroup, false);
        this.f = a2;
        Intrinsics.a(a2);
        return a2.getRoot();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        AlbumSelectHalfFragment albumSelectHalfFragment = this.i;
        AlbumSelectHalfFragment albumSelectHalfFragment2 = albumSelectHalfFragment;
        if (albumSelectHalfFragment == null) {
            Intrinsics.c("albumSelectFragment");
            albumSelectHalfFragment2 = null;
        }
        beginTransaction.remove(albumSelectHalfFragment2).commitAllowingStateLoss();
        this.f = null;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        SelectAlbumViewModel selectAlbumViewModel = this.g;
        SelectAlbumViewModel selectAlbumViewModel2 = selectAlbumViewModel;
        if (selectAlbumViewModel == null) {
            Intrinsics.c("mViewModel");
            selectAlbumViewModel2 = null;
        }
        selectAlbumViewModel2.e().setValue(0);
        AlbumSelectOnDismissListener albumSelectOnDismissListener = this.l;
        if (albumSelectOnDismissListener != null) {
            albumSelectOnDismissListener.a(this, null);
        }
        super.onDismiss(dialog);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        this.k = requireArguments().getBoolean("show_peek");
        SelectAlbumViewModel selectAlbumViewModel = this.g;
        SelectAlbumViewModel selectAlbumViewModel2 = selectAlbumViewModel;
        if (selectAlbumViewModel == null) {
            Intrinsics.c("mViewModel");
            selectAlbumViewModel2 = null;
        }
        selectAlbumViewModel2.c(this.k);
        BottomSheetBehavior<FrameLayout> a2 = ((BottomSheetDialog) dialog).a();
        Intrinsics.c(a2, "dialog as BottomSheetDialog).behavior");
        this.j = a2;
        if (a2 == null) {
            Intrinsics.c("behavior");
            a2 = null;
        }
        a2.a(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.blued.community.ui.send.dialog.AlbumSelectDialogFragment$setupDialog$1
            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View bottomSheet, float f) {
                boolean z;
                int i2;
                int i3;
                SelectAlbumViewModel selectAlbumViewModel3;
                Intrinsics.e(bottomSheet, "bottomSheet");
                Logger.c("BottomSheetCallback", Intrinsics.a("slideOffset = ", (Object) Float.valueOf(f)));
                z = AlbumSelectDialogFragment.this.k;
                float f2 = 0.0f;
                if (!z) {
                    if (f <= 0.0f) {
                        AlbumSelectDialogFragment.this.a((1 + f) * 0.6f);
                    }
                } else if (f >= 0.0f) {
                    AlbumSelectDialogFragment albumSelectDialogFragment = AlbumSelectDialogFragment.this;
                    float f3 = 30 * f;
                    if (f3 > 1.0f) {
                        f2 = 1.0f;
                    } else if (f3 >= 0.0f) {
                        f2 = f3;
                    }
                    albumSelectDialogFragment.b(f2);
                    AlbumSelectDialogFragment.this.a(f * 0.6f);
                } else {
                    i2 = AlbumSelectDialogFragment.this.c;
                    i3 = AlbumSelectDialogFragment.this.e;
                    int i4 = i2 + ((int) (i3 * f));
                    Logger.c("BottomSheetCallback", Intrinsics.a("height = ", (Object) Integer.valueOf(i4)));
                    selectAlbumViewModel3 = AlbumSelectDialogFragment.this.g;
                    SelectAlbumViewModel selectAlbumViewModel4 = selectAlbumViewModel3;
                    if (selectAlbumViewModel3 == null) {
                        Intrinsics.c("mViewModel");
                        selectAlbumViewModel4 = null;
                    }
                    selectAlbumViewModel4.e().setValue(Integer.valueOf(i4));
                }
            }

            @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void a(View bottomSheet, int i2) {
                BottomSheetBehavior bottomSheetBehavior;
                int j;
                SelectAlbumViewModel selectAlbumViewModel3;
                SelectAlbumViewModel selectAlbumViewModel4;
                boolean z;
                SelectAlbumViewModel selectAlbumViewModel5;
                DialogAlbumSelectBinding dialogAlbumSelectBinding;
                SelectAlbumViewModel selectAlbumViewModel6;
                FeedPostViewModel feedPostViewModel;
                Intrinsics.e(bottomSheet, "bottomSheet");
                if (i2 == 3) {
                    bottomSheetBehavior = AlbumSelectDialogFragment.this.j;
                    BottomSheetBehavior bottomSheetBehavior2 = bottomSheetBehavior;
                    if (bottomSheetBehavior == null) {
                        Intrinsics.c("behavior");
                        bottomSheetBehavior2 = null;
                    }
                    j = AlbumSelectDialogFragment.this.j();
                    bottomSheetBehavior2.a(j);
                    selectAlbumViewModel3 = AlbumSelectDialogFragment.this.g;
                    SelectAlbumViewModel selectAlbumViewModel7 = selectAlbumViewModel3;
                    if (selectAlbumViewModel3 == null) {
                        Intrinsics.c("mViewModel");
                        selectAlbumViewModel7 = null;
                    }
                    if (selectAlbumViewModel7.i()) {
                        selectAlbumViewModel6 = AlbumSelectDialogFragment.this.g;
                        SelectAlbumViewModel selectAlbumViewModel8 = selectAlbumViewModel6;
                        if (selectAlbumViewModel6 == null) {
                            Intrinsics.c("mViewModel");
                            selectAlbumViewModel8 = null;
                        }
                        selectAlbumViewModel8.m();
                        FeedProtos.Event event = FeedProtos.Event.FEED_ADD_PHOTO;
                        FeedProtos.AddType addType = FeedProtos.AddType.FULL_SCREEN;
                        feedPostViewModel = AlbumSelectDialogFragment.this.h;
                        FeedPostViewModel feedPostViewModel2 = feedPostViewModel;
                        if (feedPostViewModel == null) {
                            Intrinsics.c("mFeedViewModel");
                            feedPostViewModel2 = null;
                        }
                        EventTrackFeed.a(event, addType, feedPostViewModel2.f());
                    }
                    AlbumSelectDialogFragment.this.k = false;
                    selectAlbumViewModel4 = AlbumSelectDialogFragment.this.g;
                    SelectAlbumViewModel selectAlbumViewModel9 = selectAlbumViewModel4;
                    if (selectAlbumViewModel4 == null) {
                        Intrinsics.c("mViewModel");
                        selectAlbumViewModel9 = null;
                    }
                    z = AlbumSelectDialogFragment.this.k;
                    selectAlbumViewModel9.c(z);
                    selectAlbumViewModel5 = AlbumSelectDialogFragment.this.g;
                    SelectAlbumViewModel selectAlbumViewModel10 = selectAlbumViewModel5;
                    if (selectAlbumViewModel5 == null) {
                        Intrinsics.c("mViewModel");
                        selectAlbumViewModel10 = null;
                    }
                    selectAlbumViewModel10.e().setValue(0);
                    dialogAlbumSelectBinding = AlbumSelectDialogFragment.this.f;
                    View view = dialogAlbumSelectBinding == null ? null : dialogAlbumSelectBinding.d;
                    if (view == null) {
                        return;
                    }
                    view.setVisibility(8);
                }
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(final FragmentManager manager, final String str) {
        Intrinsics.e(manager, "manager");
        DelayRepeatTaskUtils.a("AlbumSelectDialogFragmentShow", new Runnable() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$AlbumSelectDialogFragment$_1VMZpBrM8A6Vea-Pe_1suT5ntQ
            @Override // java.lang.Runnable
            public final void run() {
                AlbumSelectDialogFragment.a(AlbumSelectDialogFragment.this, manager, str);
            }
        });
    }
}

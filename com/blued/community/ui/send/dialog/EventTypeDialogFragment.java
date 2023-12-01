package com.blued.community.ui.send.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.GridLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.community.databinding.DialogEventTypeBinding;
import com.blued.community.ui.send.adapter.EventAddPostTypeAdapter;
import com.blued.community.ui.send.model.EventAddPostTypeModel;
import com.blued.community.ui.send.vm.EventAddPostViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/EventTypeDialogFragment.class */
public final class EventTypeDialogFragment extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    private int b;
    private final Lazy c = LazyKt.a(new Function0<DialogEventTypeBinding>() { // from class: com.blued.community.ui.send.dialog.EventTypeDialogFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogEventTypeBinding invoke() {
            return DialogEventTypeBinding.a(LayoutInflater.from(EventTypeDialogFragment.this.getContext()));
        }
    });
    private final Lazy d = LazyKt.a(new Function0<EventAddPostViewModel>() { // from class: com.blued.community.ui.send.dialog.EventTypeDialogFragment$mViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final EventAddPostViewModel invoke() {
            FragmentActivity activity = EventTypeDialogFragment.this.getActivity();
            Intrinsics.a(activity);
            ViewModelStore viewModelStore = activity.getViewModelStore();
            Intrinsics.c(viewModelStore, "activity!!.viewModelStore");
            ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
            Context d = AppInfo.d();
            if (d != null) {
                return (EventAddPostViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(EventAddPostViewModel.class);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
    });
    private final Lazy e = LazyKt.a(new Function0<EventAddPostTypeAdapter>() { // from class: com.blued.community.ui.send.dialog.EventTypeDialogFragment$mAdapter$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final EventAddPostTypeAdapter invoke() {
            return new EventAddPostTypeAdapter();
        }
    });

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/EventTypeDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventTypeDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            EventTypeDialogFragment eventTypeDialogFragment = new EventTypeDialogFragment();
            eventTypeDialogFragment.show(manager, EventTypeDialogFragment.class.getSimpleName());
            return eventTypeDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventTypeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventTypeDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.j().h().setValue(((EventAddPostTypeModel) this$0.k().getData().get(i)).getType_id());
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        k().a(str);
        k().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<EventAddPostTypeModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (EventAddPostTypeModel eventAddPostTypeModel : list) {
                if (eventAddPostTypeModel.getMode_id() == j().f()) {
                    arrayList.add(eventAddPostTypeModel);
                }
            }
        }
        k().setNewData(arrayList);
    }

    private final void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LifecycleExtKt.b(lifecycleOwner, j().g(), new EventTypeDialogFragment$initData$1(this));
        LifecycleExtKt.a(lifecycleOwner, j().h(), new EventTypeDialogFragment$initData$2(this));
    }

    private final void m() {
        i().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$EventTypeDialogFragment$4ex7HXRbmuv_35HsBGJtdt9dv9Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventTypeDialogFragment.a(EventTypeDialogFragment.this, view);
            }
        });
        k().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$EventTypeDialogFragment$pV_JEd11gXhUofdst32bbq8wbwQ
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EventTypeDialogFragment.a(EventTypeDialogFragment.this, baseQuickAdapter, view, i);
            }
        });
        i().c.setLayoutManager(new GridLayoutManager(getContext(), 4));
        i().c.setAdapter(k());
    }

    public final int h() {
        int i = this.b;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }

    public final DialogEventTypeBinding i() {
        return (DialogEventTypeBinding) this.c.getValue();
    }

    public final EventAddPostViewModel j() {
        return (EventAddPostViewModel) this.d.getValue();
    }

    public final EventAddPostTypeAdapter k() {
        return (EventAddPostTypeAdapter) this.e.getValue();
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(i().getRoot());
        ((BottomSheetDialog) dialog).a().a(h());
        i().d.getLayoutParams().height = h();
        m();
        l();
    }
}

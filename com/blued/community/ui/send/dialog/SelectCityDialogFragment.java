package com.blued.community.ui.send.dialog;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetBehavior;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.cities.ChineseCitiesHelper;
import com.blued.android.module.common.utils.cities.ChineseCitiesList;
import com.blued.android.module.common.utils.cities.ChineseCitiesModel;
import com.blued.android.module.common.view.FastIndexView;
import com.blued.community.R;
import com.blued.community.databinding.DialogSelectCityBinding;
import com.blued.community.ui.send.adapter.EventAddPostCityAdapter;
import com.blued.community.ui.send.vm.SelectCityViewModel;
import com.blued.community.utils.ViewUtils;
import com.brandongogetap.stickyheaders.StickyLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectCityDialogFragment.class */
public final class SelectCityDialogFragment extends BottomSheetDialogFragment {
    public static final Companion a = new Companion(null);
    private int b;
    private final Lazy c = LazyKt.a(new Function0<DialogSelectCityBinding>() { // from class: com.blued.community.ui.send.dialog.SelectCityDialogFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogSelectCityBinding invoke() {
            return DialogSelectCityBinding.a(LayoutInflater.from(SelectCityDialogFragment.this.getContext()));
        }
    });
    private final Lazy d = LazyKt.a(new Function0<SelectCityViewModel>() { // from class: com.blued.community.ui.send.dialog.SelectCityDialogFragment$mViewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final SelectCityViewModel invoke() {
            FragmentActivity activity = SelectCityDialogFragment.this.getActivity();
            Intrinsics.a(activity);
            ViewModelStore viewModelStore = activity.getViewModelStore();
            Intrinsics.c(viewModelStore, "activity!!.viewModelStore");
            ViewModelProvider.AndroidViewModelFactory.Companion companion = ViewModelProvider.AndroidViewModelFactory.Companion;
            Context d = AppInfo.d();
            if (d != null) {
                return (SelectCityViewModel) new ViewModelProvider(viewModelStore, companion.getInstance((Application) d)).get(SelectCityViewModel.class);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        }
    });
    private final Lazy e = LazyKt.a(new Function0<EventAddPostCityAdapter>() { // from class: com.blued.community.ui.send.dialog.SelectCityDialogFragment$mAdapter$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final EventAddPostCityAdapter invoke() {
            return new EventAddPostCityAdapter();
        }
    });
    private final HashMap<String, Integer> f = new HashMap<>(27);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/SelectCityDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SelectCityDialogFragment a(final FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            final SelectCityDialogFragment selectCityDialogFragment = new SelectCityDialogFragment();
            PermissionUtils.c(new PermissionCallbacks() { // from class: com.blued.community.ui.send.dialog.SelectCityDialogFragment$Companion$show$1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    SelectCityDialogFragment.this.show(manager, SelectCityDialogFragment.class.getSimpleName());
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] perms) {
                    Intrinsics.e(perms, "perms");
                }
            });
            return selectCityDialogFragment;
        }
    }

    private final void a(ChineseCitiesModel chineseCitiesModel) {
        j().a(chineseCitiesModel.lng);
        j().b(chineseCitiesModel.lat);
        j().d().setValue(chineseCitiesModel.t);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectCityDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectCityDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (i < 0 || i >= this$0.k().getData().size()) {
            return;
        }
        EventAddPostCityAdapter.EventAddPostCity eventAddPostCity = (EventAddPostCityAdapter.EventAddPostCity) this$0.k().getData().get(i);
        if (eventAddPostCity.c() == 0) {
            this$0.a(eventAddPostCity.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SelectCityDialogFragment this$0, String letter) {
        Intrinsics.e(this$0, "this$0");
        if (letter == null) {
            return;
        }
        Intrinsics.c(letter, "letter");
        this$0.a(letter);
    }

    private final void a(String str) {
        if (Intrinsics.a((Object) "#", (Object) str)) {
            ViewUtils.a(i().d, 0, 0);
            return;
        }
        Integer num = this.f.get(str);
        if (num == null) {
            return;
        }
        ViewUtils.a(i().d, num.intValue(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SelectCityDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (i == 0 && i < this$0.k().getData().size() && view.getId() == R.id.tv_city) {
            EventAddPostCityAdapter.EventAddPostCity eventAddPostCity = (EventAddPostCityAdapter.EventAddPostCity) this$0.k().getData().get(i);
            if (eventAddPostCity.c() == 2) {
                this$0.a(eventAddPostCity.a());
            }
        }
    }

    private final void m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EventAddPostCityAdapter.EventAddPostCityHeader());
        List<ChineseCitiesList> list = ChineseCitiesHelper.getInstance().citiesList;
        Intrinsics.c(list, "getInstance().citiesList");
        String str = "#";
        for (ChineseCitiesList chineseCitiesList : list) {
            str = Intrinsics.a(str, (Object) chineseCitiesList.pinYin);
            HashMap<String, Integer> l = l();
            String str2 = chineseCitiesList.pinYin;
            Intrinsics.c(str2, "it.pinYin");
            l.put(str2, Integer.valueOf(arrayList.size()));
            ArrayList arrayList2 = arrayList;
            String str3 = chineseCitiesList.pinYin;
            Intrinsics.c(str3, "it.pinYin");
            arrayList2.add(new EventAddPostCityAdapter.EventAddPostCityPinYin(str3));
            List<ChineseCitiesModel> list2 = chineseCitiesList.citiesList;
            Intrinsics.c(list2, "it.citiesList");
            for (ChineseCitiesModel it : list2) {
                Intrinsics.c(it, "it");
                arrayList2.add(new EventAddPostCityAdapter.EventAddPostCity(it));
            }
            ((EventAddPostCityAdapter.EventAddPostCity) arrayList.get(arrayList.size() - 1)).a(true);
        }
        i().a.setIndexName(str);
        k().setNewData(arrayList);
    }

    private final void n() {
        i().a.setListener(new FastIndexView.OnLetterUpdateListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectCityDialogFragment$hrImZC8MpZm6EfsukoPU1pugIIc
            @Override // com.blued.android.module.common.view.FastIndexView.OnLetterUpdateListener
            public final void onLetterUpdate(String str) {
                SelectCityDialogFragment.a(SelectCityDialogFragment.this, str);
            }
        });
    }

    private final void o() {
        k().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectCityDialogFragment$HvwWCd0v2S7xmbOAwFNF4KtHCl4
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectCityDialogFragment.a(SelectCityDialogFragment.this, baseQuickAdapter, view, i);
            }
        });
        k().setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectCityDialogFragment$_9HnoBdkUm8s3_mVNTxUlzsq42s
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectCityDialogFragment.b(SelectCityDialogFragment.this, baseQuickAdapter, view, i);
            }
        });
        i().d.setLayoutManager(new StickyLayoutManager(getContext(), k()));
        i().d.setAdapter(k());
    }

    private final void p() {
        i().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.dialog.-$$Lambda$SelectCityDialogFragment$wBAo6ondal2V7GjrLgP3qTH0t_Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectCityDialogFragment.a(SelectCityDialogFragment.this, view);
            }
        });
    }

    public final int h() {
        int i = this.b;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }

    public final DialogSelectCityBinding i() {
        return (DialogSelectCityBinding) this.c.getValue();
    }

    public final SelectCityViewModel j() {
        return (SelectCityViewModel) this.d.getValue();
    }

    public final EventAddPostCityAdapter k() {
        return (EventAddPostCityAdapter) this.e.getValue();
    }

    public final HashMap<String, Integer> l() {
        return this.f;
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView((View) i().getRoot());
        BottomSheetDialog R_ = R_();
        BottomSheetBehavior<FrameLayout> a2 = R_ == null ? null : R_.a();
        if (a2 != null) {
            a2.a(h());
        }
        i().e.getLayoutParams().height = h();
        p();
        o();
        n();
        m();
    }
}

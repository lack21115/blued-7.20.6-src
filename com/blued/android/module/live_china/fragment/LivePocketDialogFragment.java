package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLivePocketBinding;
import com.blued.android.module.live_china.fragment.LivePocketRecordDialogFragment;
import com.blued.android.module.live_china.model.LivePocketExtraModel;
import com.blued.android.module.live_china.model.LivePocketModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketDialogFragment.class */
public final class LivePocketDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13147a = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private LivePocketAdapter f13148c;
    private final Lazy b = LazyKt.a(new Function0<DialogLivePocketBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePocketDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLivePocketBinding invoke() {
            return DialogLivePocketBinding.a(LayoutInflater.from(LivePocketDialogFragment.this.getContext()));
        }
    });
    private List<LivePocketModel> d = new ArrayList();
    private LivePocketExtraModel e = new LivePocketExtraModel();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePocketDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LivePocketDialogFragment livePocketDialogFragment = new LivePocketDialogFragment();
            livePocketDialogFragment.setArguments(new Bundle());
            livePocketDialogFragment.show(manager, LivePocketDialogFragment.class.getSimpleName());
            return livePocketDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePocketDialogFragment$LivePocketAdapter.class */
    public final class LivePocketAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LivePocketDialogFragment f13149a;
        private ArrayList<String> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LivePocketAdapter(LivePocketDialogFragment this$0, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(fm, "fm");
            this.f13149a = this$0;
            this.b = CollectionsKt.d(AppInfo.d().getString(R.string.live_pocket_props), AppInfo.d().getString(R.string.live_pocket_exping));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            if (i != 0) {
                LivePocketExpFragment livePocketExpFragment = new LivePocketExpFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("model", this.f13149a.e());
                livePocketExpFragment.setArguments(bundle);
                return livePocketExpFragment;
            }
            LivePocketPropFragment livePocketPropFragment = new LivePocketPropFragment();
            Bundle bundle2 = new Bundle();
            LivePocketExtraModel livePocketExtraModel = new LivePocketExtraModel();
            livePocketExtraModel.setIn_use(this.f13149a.d());
            bundle2.putSerializable("model", livePocketExtraModel);
            livePocketPropFragment.setArguments(bundle2);
            return livePocketPropFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            Intrinsics.e(object, "object");
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b.get(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePocketDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.h().f11799a.animate().alpha(1.0f).setDuration(300L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePocketDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LivePocketRecordDialogFragment.Companion companion = LivePocketRecordDialogFragment.f13160a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager);
    }

    private final DialogLivePocketBinding h() {
        return (DialogLivePocketBinding) this.b.getValue();
    }

    private final void i() {
        h().f11800c.setIndicatorHeight(DensityUtils.a(getContext(), 4.0f));
        h().f11800c.w = DensityUtils.d(getContext(), 15.0f);
        h().f11800c.x = DensityUtils.d(getContext(), 15.0f);
        h().f11800c.setTextColor(R.color.white);
        h().f11800c.setTabTextColorUnfocused(R.color.white_alpha70);
        h().f11800c.setHorizontalShade(true);
        Context context = getContext();
        if (context != null) {
            h().f11800c.a(ContextCompat.getColor(context, R.color.syc_dark_FF3AAA), ContextCompat.getColor(context, R.color.syc_dark_922cee));
        }
        h().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePocketDialogFragment$yiqMQYX-Z01HJixTJdipTtm7d1I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePocketDialogFragment.a(LivePocketDialogFragment.this, view);
            }
        });
        h().f11799a.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePocketDialogFragment$DQo4lG_8dlv_ZisqXGgbhdVA9hQ
            @Override // java.lang.Runnable
            public final void run() {
                LivePocketDialogFragment.a(LivePocketDialogFragment.this);
            }
        });
        f();
        g();
    }

    public final void a(LivePocketExtraModel livePocketExtraModel) {
        Intrinsics.e(livePocketExtraModel, "<set-?>");
        this.e = livePocketExtraModel;
    }

    public final List<LivePocketModel> d() {
        return this.d;
    }

    public final LivePocketExtraModel e() {
        return this.e;
    }

    public final void f() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        this.f13148c = new LivePocketAdapter(this, childFragmentManager);
        h().f.setAdapter(this.f13148c);
        h().f11800c.setViewPager(h().f);
        h().f.setCurrentItem(0);
        h().f.setOffscreenPageLimit(1);
        h().f11800c.setViewPager(h().f);
    }

    public final void g() {
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.v(new BluedUIHttpResponse<BluedEntity<LivePocketModel, LivePocketExtraModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LivePocketDialogFragment$loadData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str, String str2) {
                LivePocketDialogFragment.this.f();
                return super.onUIFailure(i, str, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LivePocketModel, LivePocketExtraModel> entity) {
                Intrinsics.e(entity, "entity");
                LivePocketDialogFragment.this.d().clear();
                if (entity.data != null) {
                    List<LivePocketModel> d = LivePocketDialogFragment.this.d();
                    List<LivePocketModel> list = entity.data;
                    Intrinsics.c(list, "entity.data");
                    d.addAll(list);
                }
                if (entity.extra != null) {
                    LivePocketDialogFragment livePocketDialogFragment = LivePocketDialogFragment.this;
                    LivePocketExtraModel livePocketExtraModel = entity.extra;
                    Intrinsics.c(livePocketExtraModel, "entity.extra");
                    livePocketDialogFragment.a(livePocketExtraModel);
                }
                LivePocketDialogFragment.this.f();
            }
        }, a());
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 398.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(h().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        View decorView = window.getDecorView();
        if (decorView != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        i();
    }
}

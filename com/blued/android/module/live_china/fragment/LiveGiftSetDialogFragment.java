package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveGiftSetViewBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftSetInfoModel;
import com.blued.android.module.live_china.model.LiveGiftSetModel;
import com.blued.android.module.live_china.model.LiveGiftSetTabModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetDialogFragment.class */
public final class LiveGiftSetDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<FragmentLiveGiftSetViewBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLiveGiftSetViewBinding invoke() {
            return FragmentLiveGiftSetViewBinding.a(LayoutInflater.from(LiveGiftSetDialogFragment.this.getContext()));
        }
    });
    private String c = "";
    private int d;
    private LiveGiftSetModel e;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveGiftSetDialogFragment a(Fragment fragment, String setId, int i) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(setId, "setId");
            LiveGiftSetDialogFragment liveGiftSetDialogFragment = new LiveGiftSetDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("setId", setId);
            bundle.putInt("height", i);
            liveGiftSetDialogFragment.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            liveGiftSetDialogFragment.show(childFragmentManager, LiveBattlePassDialogFragment.class.getSimpleName());
            return liveGiftSetDialogFragment;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetDialogFragment$MyAdapter.class */
    static final class MyAdapter extends FragmentStatePagerAdapter {
        private final Context a;
        private final ArrayList<LiveGiftSetTabModel> b;
        private LiveGiftSetModel c;
        private int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(Context context, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            this.a = context;
            this.b = new ArrayList<>();
        }

        public final void a(List<LiveGiftSetTabModel> list, LiveGiftSetModel model, int i) {
            Intrinsics.e(model, "model");
            this.b.clear();
            this.c = model;
            this.d = i;
            List<LiveGiftSetTabModel> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            ArrayList<LiveGiftSetTabModel> arrayList = this.b;
            Intrinsics.a(list);
            arrayList.addAll(list2);
        }

        public final Context getContext() {
            return this.a;
        }

        public int getCount() {
            return this.b.size();
        }

        public Fragment getItem(int i) {
            LiveGiftSetItemFragment liveGiftSetItemFragment = new LiveGiftSetItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", this.b.get(i).getId());
            LiveGiftSetModel liveGiftSetModel = this.c;
            if (liveGiftSetModel != null && this.d == i) {
                bundle.putSerializable("data", liveGiftSetModel);
            }
            liveGiftSetItemFragment.setArguments(bundle);
            return liveGiftSetItemFragment;
        }

        public CharSequence getPageTitle(int i) {
            return this.b.get(i).getName();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLiveGiftSetViewBinding g() {
        return (FragmentLiveGiftSetViewBinding) this.b.getValue();
    }

    private final void h() {
        EventTrackLive.b(LiveProtos.Event.LIVE_SET_GIFT_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.c);
        g().b.c();
        e();
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(LiveGiftSetModel model) {
        String str;
        Intrinsics.e(model, "model");
        this.e = model;
        this.c = String.valueOf(model.getId());
        LiveGiftSetInfoModel liveGiftSetInfoModel = new LiveGiftSetInfoModel();
        ArrayList<LiveGiftSetTabModel> all_name = model.getAll_name();
        if (all_name != null) {
            Iterator<LiveGiftSetTabModel> it = all_name.iterator();
            while (true) {
                str = "";
                if (!it.hasNext()) {
                    break;
                }
                LiveGiftSetTabModel next = it.next();
                if (next != null && TextUtils.equals(next.getId(), d())) {
                    str = next.getName();
                    break;
                }
            }
        } else {
            str = "";
        }
        liveGiftSetInfoModel.setId(model.getId());
        liveGiftSetInfoModel.setName(str);
        liveGiftSetInfoModel.setProgress(model.getProgress());
        liveGiftSetInfoModel.setExpire_time(model.getExpire_time());
        g().b.a(liveGiftSetInfoModel, a(), (Fragment) this);
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void a(String setId, String goodsId) {
        Intrinsics.e(setId, "setId");
        Intrinsics.e(goodsId, "goodsId");
        g().b.a(setId, goodsId);
    }

    public final String d() {
        return this.c;
    }

    public final void e() {
        LiveRoomHttpUtils.q(this.c, new LiveGiftSetDialogFragment$getAll$1(this, a()), a());
    }

    public final void f() {
        g().b.b();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("setId", "");
            Intrinsics.c(string, "it.getString(\"setId\", \"\")");
            a(string);
            a(arguments.getInt("height", 0));
        }
        int i = this.d;
        int i2 = i;
        if (i == 0) {
            i2 = DensityUtils.a(getContext(), 540.0f);
        }
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(g().getRoot(), new ViewGroup.LayoutParams(-1, i2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = i2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(g().getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        h();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}

package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveRandomGiftLotteryRecordDialogBinding;
import com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftRewardsHistory;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftDialogRewardsHistoryDataModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftLotteryRecordDialog.class */
public final class LiveRandomGiftLotteryRecordDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13183a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LiveRandomGiftLotteryRecordDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftLotteryRecordDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveRandomGiftLotteryRecordDialogBinding invoke() {
            return LiveRandomGiftLotteryRecordDialogBinding.a(LayoutInflater.from(LiveRandomGiftLotteryRecordDialog.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<FitemRandomGiftRewardsHistory> f13184c = new ArrayList<>();
    private FreedomAdapter d;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftLotteryRecordDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, String goods_id) {
            Intrinsics.e(fragmentManager, "fragmentManager");
            Intrinsics.e(goods_id, "goods_id");
            LiveRandomGiftLotteryRecordDialog liveRandomGiftLotteryRecordDialog = new LiveRandomGiftLotteryRecordDialog();
            Bundle bundle = new Bundle();
            bundle.putString("goods_id", goods_id);
            liveRandomGiftLotteryRecordDialog.setArguments(bundle);
            liveRandomGiftLotteryRecordDialog.show(fragmentManager, LiveRandomGiftLotteryRecordDialog.class.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRandomGiftLotteryRecordDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<RandomGiftDialogRewardsHistoryDataModel> list) {
        for (RandomGiftDialogRewardsHistoryDataModel randomGiftDialogRewardsHistoryDataModel : list) {
            this.f13184c.add(new FitemRandomGiftRewardsHistory(randomGiftDialogRewardsHistoryDataModel));
        }
        d().e.setLayoutManager(new LinearLayoutManager(getContext()));
        this.d = new FreedomAdapter(getContext(), a(), this.f13184c);
        d().e.setItemAnimator(new DefaultItemAnimator());
        d().e.setAdapter(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveRandomGiftLotteryRecordDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveRandomGiftLotteryRecordDialogBinding d() {
        return (LiveRandomGiftLotteryRecordDialogBinding) this.b.getValue();
    }

    private final void e() {
        d().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftLotteryRecordDialog$9vNFIRBtbENtS-sLTyy14tE2s78
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRandomGiftLotteryRecordDialog.a(LiveRandomGiftLotteryRecordDialog.this, view);
            }
        });
        d().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftLotteryRecordDialog$PZni4d16Q8b62RCflwnXYSRQqH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRandomGiftLotteryRecordDialog.b(LiveRandomGiftLotteryRecordDialog.this, view);
            }
        });
        d().f.setText(AppInfo.d().getString(R.string.live_random_gift_record_lottery_period_desc, LiveRoomManager.a().h()));
        d().f.setText(LiveUtils.a(d().f.getText(), "#FF7B00", false));
        f();
    }

    private final void f() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String string = arguments.getString("goods_id", "");
        String str = string;
        if (str == null || str.length() == 0) {
            g();
            return;
        }
        d().f12400c.b();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.s(string, new BluedUIHttpResponse<BluedEntityA<RandomGiftDialogRewardsHistoryDataModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftLotteryRecordDialog$getData$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RandomGiftDialogRewardsHistoryDataModel> entity) {
                Intrinsics.e(entity, "entity");
                List<RandomGiftDialogRewardsHistoryDataModel> list = entity.data;
                if (list == null || list.isEmpty()) {
                    LiveRandomGiftLotteryRecordDialog.this.g();
                    return;
                }
                LiveRandomGiftLotteryRecordDialog liveRandomGiftLotteryRecordDialog = LiveRandomGiftLotteryRecordDialog.this;
                List<RandomGiftDialogRewardsHistoryDataModel> list2 = entity.data;
                Intrinsics.c(list2, "entity.data");
                liveRandomGiftLotteryRecordDialog.a(list2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveRandomGiftLotteryRecordDialog.this.g();
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LiveRandomGiftLotteryRecordDialogBinding d;
                d = LiveRandomGiftLotteryRecordDialog.this.d();
                d.f12400c.c();
                super.onUIFinish();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        RecyclerView recyclerView = d().e;
        Intrinsics.c(recyclerView, "vb.rvList");
        BluedViewExKt.a(recyclerView);
        RelativeLayout relativeLayout = d().d;
        Intrinsics.c(relativeLayout, "vb.rlEmpty");
        BluedViewExKt.b(relativeLayout);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(Color.argb(178, 0, 0, 0)));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getWidth());
        }
        Intrinsics.a(num);
        attributes.width = num.intValue();
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        window.setFlags(67108864, 67108864);
        e();
        return dialog;
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

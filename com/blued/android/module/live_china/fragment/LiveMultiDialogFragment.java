package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveMultiBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MultiDialogResourceModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMultiDialogFragment.class */
public final class LiveMultiDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogLiveMultiBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveMultiDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveMultiBinding invoke() {
            return DialogLiveMultiBinding.a(LayoutInflater.from(LiveMultiDialogFragment.this.getContext()));
        }
    });
    private MultiDialogModel c;
    private boolean d;
    private CountDownTimer e;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMultiDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final LiveMultiDialogFragment a(FragmentManager manager, MultiDialogModel data) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(data, "data");
            LiveMultiDialogFragment liveMultiDialogFragment = new LiveMultiDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("MultiDialogModel", data);
            liveMultiDialogFragment.setArguments(bundle);
            liveMultiDialogFragment.show(manager, LiveMultiDialogFragment.class.getSimpleName());
            return liveMultiDialogFragment;
        }
    }

    @JvmStatic
    public static final LiveMultiDialogFragment a(FragmentManager fragmentManager, MultiDialogModel multiDialogModel) {
        return a.a(fragmentManager, multiDialogModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMultiDialogFragment this$0, View view) {
        String str;
        String str2;
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        MultiDialogModel multiDialogModel = this$0.c;
        if (multiDialogModel != null && multiDialogModel.from_type == 0) {
            LiveProtos.Event event = LiveProtos.Event.LIVE_LIST_CONFIG_POP_CLOSE_CLICK;
            MultiDialogModel multiDialogModel2 = this$0.c;
            if (multiDialogModel2 == null) {
                str2 = null;
            } else {
                MultiDialogResourceModel multiDialogResourceModel = multiDialogModel2.resource;
                str2 = multiDialogResourceModel == null ? null : multiDialogResourceModel.jump_url;
            }
            EventTrackLive.f(event, str2);
            return;
        }
        MultiDialogModel multiDialogModel3 = this$0.c;
        if (!(multiDialogModel3 != null && multiDialogModel3.from_type == 1)) {
            MultiDialogModel multiDialogModel4 = this$0.c;
            if (!(multiDialogModel4 != null && multiDialogModel4.from_type == 2)) {
                return;
            }
        }
        LiveProtos.Event event2 = LiveProtos.Event.LIVE_ROOM_CONFIG_POP_CLOSE_CLICK;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        MultiDialogModel multiDialogModel5 = this$0.c;
        if (multiDialogModel5 == null) {
            str = null;
        } else {
            MultiDialogResourceModel multiDialogResourceModel2 = multiDialogModel5.resource;
            str = multiDialogResourceModel2 == null ? null : multiDialogResourceModel2.jump_url;
        }
        EventTrackLive.r(event2, e, g, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMultiDialogFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(AnchorLiveStateModel anchorLiveStateModel) {
        LiveRoomInfo.a().a(getContext(), anchorLiveStateModel.uid, anchorLiveStateModel.name, anchorLiveStateModel.avatar, 0, 2);
    }

    private final void a(String str) {
        d().e.setVisibility(8);
        d().c.setVisibility(0);
        ImageLoader.a(a(), str).a(d().c);
        d().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMultiDialogFragment$L7DOhtkbzbkXS2IRxpJZw-Mh5io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMultiDialogFragment.b(LiveMultiDialogFragment.this, view);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.blued.android.module.live_china.fragment.LiveMultiDialogFragment$initAutoClose$1] */
    private final void a(boolean z) {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.d = z;
        if (z) {
            this.e = new CountDownTimer() { // from class: com.blued.android.module.live_china.fragment.LiveMultiDialogFragment$initAutoClose$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(5000L, 1000L);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    LiveMultiDialogFragment.this.dismissAllowingStateLoss();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    DialogLiveMultiBinding d;
                    DialogLiveMultiBinding d2;
                    DialogLiveMultiBinding d3;
                    int a2 = MathKt.a(j / 1000);
                    d = LiveMultiDialogFragment.this.d();
                    TextView textView = d.d;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    String string = AppInfo.d().getString(R.string.live_pk_dared_match_auto_close_time);
                    Intrinsics.c(string, "getAppContext()\n        …ed_match_auto_close_time)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(a2)}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    textView.setText(format);
                    d2 = LiveMultiDialogFragment.this.d();
                    if (d2.d.getVisibility() != 0) {
                        d3 = LiveMultiDialogFragment.this.d();
                        d3.d.setVisibility(0);
                    }
                }
            }.start();
        } else {
            d().d.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
        if ((r0 != null && r0.from_type == 2) != false) goto L121;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(com.blued.android.module.live_china.fragment.LiveMultiDialogFragment r5, android.view.View r6) {
        /*
            Method dump skipped, instructions count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveMultiDialogFragment.b(com.blued.android.module.live_china.fragment.LiveMultiDialogFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(AnchorLiveStateModel anchorLiveStateModel) {
        if (anchorLiveStateModel == null) {
            return;
        }
        LiveRoomData liveRoomData = new LiveRoomData();
        liveRoomData.lid = anchorLiveStateModel.lid;
        LiveRoomAnchorModel liveRoomAnchorModel = new LiveRoomAnchorModel();
        liveRoomAnchorModel.name = anchorLiveStateModel.name;
        liveRoomAnchorModel.avatar = anchorLiveStateModel.avatar;
        liveRoomAnchorModel.uid = anchorLiveStateModel.uid;
        liveRoomData.profile = liveRoomAnchorModel;
        LiveRoomInfo.a().a(getContext(), liveRoomData);
    }

    private final void b(String str) {
        d().c.setVisibility(8);
        d().e.setVisibility(0);
        if (getParentFragment() != null) {
            Fragment parentFragment = getParentFragment();
            if ((parentFragment == null ? null : parentFragment.getActivity()) != null) {
                d().e.a((Fragment) this);
                String str2 = str;
                String str3 = str;
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str;
                    if (!StringsKt.c((CharSequence) str2, (CharSequence) "blued_mode=hide_nav", false, 2, (Object) null)) {
                        str3 = StringsKt.c((CharSequence) str2, (CharSequence) "?", false, 2, (Object) null) ? Intrinsics.a(str, (Object) "&blued_mode=hide_nav") : Intrinsics.a(str, (Object) "?blued_mode=hide_nav");
                    }
                }
                d().e.b(str3, -1);
                return;
            }
        }
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveMultiBinding d() {
        return (DialogLiveMultiBinding) this.b.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0179, code lost:
        if (r7 != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e() {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveMultiDialogFragment.e():void");
    }

    private final void f() {
        MultiDialogResourceModel multiDialogResourceModel;
        MultiDialogModel multiDialogModel = this.c;
        Integer num = null;
        String str = (multiDialogModel == null || (multiDialogResourceModel = multiDialogModel.resource) == null) ? null : multiDialogResourceModel.jump_url;
        MultiDialogModel multiDialogModel2 = this.c;
        if (multiDialogModel2 != null) {
            num = Integer.valueOf(multiDialogModel2.from_type);
        }
        if (num != null && num.intValue() == 0) {
            LiveRoomInfo.a().a(getContext(), str);
        } else if (num != null && num.intValue() == 1) {
            LiveRefreshUIObserver.a().b(str, 0);
        } else if (num != null && num.intValue() == 2) {
            LiveSetDataObserver.a().b(str, 0);
        }
    }

    private final void g() {
        MultiDialogResourceModel multiDialogResourceModel;
        MultiDialogModel multiDialogModel = this.c;
        boolean z = false;
        if (multiDialogModel != null && multiDialogModel.from_type == 0) {
            z = true;
        }
        if (z) {
            BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.blued.android.module.live_china.fragment.LiveMultiDialogFragment$clickToLiveRoom$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                    AnchorLiveStateModel singleData;
                    if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                        return;
                    }
                    LiveMultiDialogFragment liveMultiDialogFragment = LiveMultiDialogFragment.this;
                    int i = singleData.is_live;
                    if (i == 0) {
                        liveMultiDialogFragment.a(singleData);
                    } else if (i != 1) {
                    } else {
                        liveMultiDialogFragment.b(singleData);
                    }
                }
            };
            MultiDialogModel multiDialogModel2 = this.c;
            String str = null;
            if (multiDialogModel2 != null && (multiDialogResourceModel = multiDialogModel2.resource) != null) {
                str = multiDialogResourceModel.jump_uid;
            }
            LiveRoomHttpUtils.c(bluedUIHttpResponse, str, a());
        }
    }

    private final void h() {
        MultiDialogModel multiDialogModel = this.c;
        boolean z = false;
        if (multiDialogModel != null && multiDialogModel.from_type == 1) {
            z = true;
        }
        if (z) {
            LiveRefreshUIObserver.a().e();
        }
    }

    private final void i() {
        MultiDialogModel multiDialogModel = this.c;
        boolean z = false;
        if (multiDialogModel != null && multiDialogModel.from_type == 1) {
            z = true;
        }
        if (z) {
            LiveRefreshUIObserver.a().j();
        }
    }

    private final void j() {
        MultiDialogModel multiDialogModel = this.c;
        boolean z = false;
        if (multiDialogModel != null && multiDialogModel.from_type == 1) {
            z = true;
        }
        if (z) {
            LiveRefreshUIObserver.a().k();
        }
    }

    private final void k() {
        MultiDialogModel multiDialogModel = this.c;
        boolean z = false;
        if (multiDialogModel != null && multiDialogModel.from_type == 2) {
            z = true;
        }
        if (z) {
            LiveEventBus.get("live_utils").post(true);
        }
    }

    private final void l() {
        MultiDialogModel multiDialogModel = this.c;
        boolean z = false;
        if (multiDialogModel != null && multiDialogModel.from_type == 2) {
            z = true;
        }
        if (z) {
            LiveEventBus.get("live_center").post(true);
        }
    }

    public void dismissAllowingStateLoss() {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.e = null;
        super.dismissAllowingStateLoss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        ConstraintLayout root;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.c(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMultiDialogFragment$Rx3kwZLFSxPcAie79y2vJGb69XQ
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveMultiDialogFragment.a(dialogInterface, i, keyEvent);
                return a2;
            }
        });
        onCreateDialog.setCanceledOnTouchOutside(false);
        DialogLiveMultiBinding d = d();
        ViewParent viewParent = null;
        if (d != null && (root = d.getRoot()) != null) {
            viewParent = root.getParent();
        }
        if (viewParent instanceof ViewGroup) {
            ViewParent parent = d().getRoot().getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView((View) d().getRoot());
        }
        onCreateDialog.setContentView((View) d().getRoot());
        return onCreateDialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.e = null;
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
        Serializable serializable;
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        Bundle arguments = getArguments();
        if (arguments == null || (serializable = arguments.getSerializable("MultiDialogModel")) == null || !(serializable instanceof MultiDialogModel)) {
            return;
        }
        this.c = (MultiDialogModel) serializable;
        e();
    }
}

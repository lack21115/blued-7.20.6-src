package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogNewLiveHostFinishBinding;
import com.blued.android.module.live_china.fragment.LiveHostFinishDetailDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveCloseInfoModel;
import com.blued.android.module.live_china.model.LiveCloseModel;
import com.blued.android.module.live_china.utils.LiveNumFormatUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDialogFragment.class */
public final class LiveHostFinishDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12971a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<DialogNewLiveHostFinishBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogNewLiveHostFinishBinding invoke() {
            return DialogNewLiveHostFinishBinding.a(LayoutInflater.from(LiveHostFinishDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private boolean f12972c;
    private LiveCloseInfoModel d;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveHostFinishDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LiveHostFinishDialogFragment liveHostFinishDialogFragment = new LiveHostFinishDialogFragment();
            liveHostFinishDialogFragment.show(manager, LiveHostFinishDialogFragment.class.getSimpleName());
            return liveHostFinishDialogFragment;
        }
    }

    private final void a(int i) {
        if (i >= 60) {
            d().C.setText(String.valueOf(Math.round(i / 60.0f)));
            return;
        }
        d().t.setText(R.string.live_host_finish_count_in_less_than_a_minute);
        TextView textView = d().C;
        Intrinsics.c(textView, "vb.tvMinute");
        BluedViewExKt.a(textView);
        TextView textView2 = d().D;
        Intrinsics.c(textView2, "vb.tvMinuteSuffix");
        BluedViewExKt.a(textView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHostFinishDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_REPORT_CLICK);
        LiveRoomInfo.a().a(this$0.getActivity(), H5Url.a(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(LiveCloseInfoModel liveCloseInfoModel) {
        this.d = liveCloseInfoModel;
        a(liveCloseInfoModel.live_time);
        d().G.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.received_beans));
        d().v.setText(LiveTimeAndDateUtils.a(liveCloseInfoModel.live_time, true).toString());
        d().n.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.new_follower_count));
        d().K.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.total_watch_count));
        d().z.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.giver_count));
        d().x.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.new_fan_count));
        d().r.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.commenter_count));
        d().B.setText(LiveNumFormatUtil.f14186a.a(liveCloseInfoModel.liked));
        if (liveCloseInfoModel.received_beans > 0) {
            h();
        }
        EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_SHOW, LiveRoomManager.a().e(), (int) liveCloseInfoModel.total_beans, (int) liveCloseInfoModel.received_beans, liveCloseInfoModel.total_watch_count, liveCloseInfoModel.liked, liveCloseInfoModel.top_watch_count, liveCloseInfoModel.live_time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(LiveHostFinishDialogFragment this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.e(this$0, "this$0");
        if (i == 4) {
            this$0.f();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveHostFinishDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_MORE_CLICK);
        LiveHostFinishDetailDialogFragment.Companion companion = LiveHostFinishDetailDialogFragment.f12957a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(childFragmentManager, this$0.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveHostFinishDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_COLLEGE_CLICK);
        LiveRoomInfo.a().a(this$0.getActivity(), H5Url.a(84));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogNewLiveHostFinishBinding d() {
        return (DialogNewLiveHostFinishBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveHostFinishDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    private final void e() {
        d().Q.getLayoutParams().height = DensityUtils.a(getActivity());
        d().I.getPaint().setFakeBoldText(true);
        ImageLoader.a(a(), LiveRoomInfo.a().d()).d().a(d().f);
        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("live_host_finish_avatar_shade")).c(300).a(d().j);
        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("live_host_finish_arrows_right")).c(300).a(d().i);
        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("live_host_finish_arrows_right")).c(300).a(d().h);
        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("live_host_finish_college")).c(300).a(d().g);
        d().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDialogFragment$kz92GTEXT3k86PiHy59gjhyAaX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostFinishDialogFragment.a(LiveHostFinishDialogFragment.this, view);
            }
        });
        d().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDialogFragment$IpMNGtZvSNunQ4pWNAVeKDTFGKs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostFinishDialogFragment.b(LiveHostFinishDialogFragment.this, view);
            }
        });
        d().f11833a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDialogFragment$MXTEafF-KlHK96eTHDE-ABpCHU4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostFinishDialogFragment.c(LiveHostFinishDialogFragment.this, view);
            }
        });
        d().s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDialogFragment$toiGhKEc6kTAeF560EemNYkpCe0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostFinishDialogFragment.d(LiveHostFinishDialogFragment.this, view);
            }
        });
    }

    private final void f() {
        if (this.f12972c) {
            return;
        }
        this.f12972c = true;
        EventTrackLive.b(LiveProtos.Event.ANCHOR_END_PAGE_CONFIRM_CLICK, LiveRoomManager.a().e());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        if (LiveRoomManager.a().J()) {
            LiveRoomInfo.a().a(getContext());
        }
    }

    private final void g() {
        d().k.b();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveCloseModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveHostFinishDialogFragment$getDataToCloseLiveChat$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveCloseModel> entity) {
                LiveCloseInfoModel liveCloseInfoModel;
                Intrinsics.e(entity, "entity");
                LiveCloseModel singleData = entity.getSingleData();
                if (singleData == null || (liveCloseInfoModel = singleData.info) == null) {
                    return;
                }
                LiveHostFinishDialogFragment.this.a(liveCloseInfoModel);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogNewLiveHostFinishBinding d;
                super.onUIFinish();
                d = LiveHostFinishDialogFragment.this.d();
                d.k.c();
            }
        }, LiveRoomManager.a().e());
    }

    private final void h() {
        LiveRoomHttpUtils.e(new LiveHostFinishDialogFragment$getLive$1(this, a()), LiveRoomInfo.a().f(), a());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getWidth());
        }
        Integer num2 = num;
        if (num == null) {
            num2 = -1;
        }
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(num2.intValue(), -1));
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishDialogFragment$JAzME8yQ0zQAcRYexGc33QysWik
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean a2;
                a2 = LiveHostFinishDialogFragment.a(LiveHostFinishDialogFragment.this, dialogInterface, i, keyEvent);
                return a2;
            }
        });
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = num2.intValue();
        attributes.height = -1;
        attributes.gravity = 80;
        if (Build.VERSION.SDK_INT < 19) {
            window.setFlags(1024, 1024);
        } else {
            window.setFlags(67108864, 67108864);
        }
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        e();
        g();
    }
}

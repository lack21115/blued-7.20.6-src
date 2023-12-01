package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogKtvCommonLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.DialogKtvCommonView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DialogKtvCommonView.class */
public final class DialogKtvCommonView extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private CountDownTimer f17920a;
    private DialogKtvCommonLayoutBinding b;

    /* renamed from: c  reason: collision with root package name */
    private KtvDialogBuilder f17921c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DialogKtvCommonView$DialogListener.class */
    public interface DialogListener {
        void a();

        void b();
    }

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DialogKtvCommonView$KtvDialogBuilder.class */
    public static class KtvDialogBuilder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f17922a;
        private DialogListener b;

        /* renamed from: c  reason: collision with root package name */
        private String f17923c;
        private String d;
        private String e;
        private String f;

        public final void a(DialogListener dialogListener) {
            this.b = dialogListener;
        }

        public final void a(String str) {
            this.f17923c = str;
        }

        public final void a(boolean z) {
            this.f17922a = z;
        }

        public final boolean a() {
            return this.f17922a;
        }

        public final DialogListener b() {
            return this.b;
        }

        public final void b(String str) {
            this.d = str;
        }

        public final String c() {
            return this.f17923c;
        }

        public final void c(String str) {
            this.e = str;
        }

        public final String d() {
            return this.d;
        }

        public final void d(String str) {
            this.f = str;
        }

        public final String e() {
            return this.e;
        }

        public final String f() {
            return this.f;
        }

        public final DialogKtvCommonView g() {
            return new DialogKtvCommonView(this, null);
        }
    }

    private DialogKtvCommonView(KtvDialogBuilder ktvDialogBuilder) {
        this.f17921c = ktvDialogBuilder;
    }

    public /* synthetic */ DialogKtvCommonView(KtvDialogBuilder ktvDialogBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(ktvDialogBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogKtvCommonView this$0, View view) {
        DialogListener b;
        Intrinsics.e(this$0, "this$0");
        KtvDialogBuilder ktvDialogBuilder = this$0.f17921c;
        if (ktvDialogBuilder != null && (b = ktvDialogBuilder.b()) != null) {
            b.b();
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogKtvCommonView this$0, View view) {
        DialogListener b;
        Intrinsics.e(this$0, "this$0");
        KtvDialogBuilder ktvDialogBuilder = this$0.f17921c;
        if (ktvDialogBuilder != null && (b = ktvDialogBuilder.b()) != null) {
            b.a();
        }
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding = this.b;
        TextView textView = dialogKtvCommonLayoutBinding == null ? null : dialogKtvCommonLayoutBinding.d;
        if (textView != null) {
            KtvDialogBuilder ktvDialogBuilder = this.f17921c;
            textView.setText(ktvDialogBuilder == null ? null : ktvDialogBuilder.c());
        }
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding2 = this.b;
        TextView textView2 = dialogKtvCommonLayoutBinding2 == null ? null : dialogKtvCommonLayoutBinding2.f16358c;
        if (textView2 != null) {
            KtvDialogBuilder ktvDialogBuilder2 = this.f17921c;
            textView2.setText(ktvDialogBuilder2 == null ? null : ktvDialogBuilder2.d());
        }
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding3 = this.b;
        TextView textView3 = dialogKtvCommonLayoutBinding3 == null ? null : dialogKtvCommonLayoutBinding3.f16357a;
        if (textView3 != null) {
            KtvDialogBuilder ktvDialogBuilder3 = this.f17921c;
            textView3.setText(ktvDialogBuilder3 == null ? null : ktvDialogBuilder3.e());
        }
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding4 = this.b;
        TextView textView4 = dialogKtvCommonLayoutBinding4 == null ? null : dialogKtvCommonLayoutBinding4.e;
        if (textView4 == null) {
            return;
        }
        KtvDialogBuilder ktvDialogBuilder4 = this.f17921c;
        textView4.setText(ktvDialogBuilder4 == null ? null : ktvDialogBuilder4.f());
    }

    private final void g() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        KtvDialogBuilder ktvDialogBuilder = this.f17921c;
        boolean z = false;
        if (ktvDialogBuilder != null && ktvDialogBuilder.a()) {
            z = true;
        }
        if (z) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_SONG_TURN_POP_SHOW;
            String str = b.room_id;
            String str2 = b.uid;
            YYMsgKtvMusic yYMsgKtvMusic = b.music;
            EventTrackYY.k(event, str, str2, yYMsgKtvMusic == null ? null : yYMsgKtvMusic.musicId);
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.StringBuilder] */
    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        KtvDialogBuilder ktvDialogBuilder = this.f17921c;
        boolean z = false;
        if (ktvDialogBuilder != null && ktvDialogBuilder.a()) {
            z = true;
        }
        if (z) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f42545a = new StringBuilder();
            CountDownTimer countDownTimer = new CountDownTimer(10000L) { // from class: com.blued.android.module.yy_china.view.DialogKtvCommonView$onActivityCreated$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    DialogKtvCommonView.KtvDialogBuilder ktvDialogBuilder2;
                    DialogKtvCommonView.DialogListener b;
                    ktvDialogBuilder2 = this.f17921c;
                    if (ktvDialogBuilder2 != null && (b = ktvDialogBuilder2.b()) != null) {
                        b.b();
                    }
                    YYRoomModel b2 = YYRoomInfoManager.e().b();
                    if (b2 != null) {
                        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_KTV_TURN_POP_GIVE_UP_TIMEOUT;
                        String str = b2.room_id;
                        String str2 = b2.uid;
                        YYMsgKtvMusic yYMsgKtvMusic = b2.music;
                        EventTrackYY.k(event, str, str2, yYMsgKtvMusic == null ? null : yYMsgKtvMusic.musicId);
                    }
                    this.dismissAllowingStateLoss();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding;
                    StringsKt.a(objectRef.f42545a);
                    StringBuilder sb = objectRef.f42545a;
                    sb.append("请在");
                    sb.append((j / 1000) + 1);
                    sb.append("s内确定是否进行演唱，否则将自动放弃此次机会");
                    dialogKtvCommonLayoutBinding = this.b;
                    TextView textView = dialogKtvCommonLayoutBinding == null ? null : dialogKtvCommonLayoutBinding.f16358c;
                    if (textView == null) {
                        return;
                    }
                    textView.setText(objectRef.f42545a.toString());
                }
            };
            this.f17920a = countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.start();
            }
        }
        g();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_ktv_common_layout, viewGroup, true);
        this.b = DialogKtvCommonLayoutBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.f17920a;
        if (countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
        this.f17920a = null;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        TextView textView;
        TextView textView2;
        View view2;
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding = this.b;
        if (dialogKtvCommonLayoutBinding != null && (view2 = dialogKtvCommonLayoutBinding.b) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$DialogKtvCommonView$D0HprR6Lm2ENX9dp3yqzxyRYwcw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DialogKtvCommonView.a(view3);
                }
            });
        }
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding2 = this.b;
        if (dialogKtvCommonLayoutBinding2 != null && (textView2 = dialogKtvCommonLayoutBinding2.f16357a) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$DialogKtvCommonView$5-Jrk-TFIKtgeukwL6swaLvdHgE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DialogKtvCommonView.a(DialogKtvCommonView.this, view3);
                }
            });
        }
        DialogKtvCommonLayoutBinding dialogKtvCommonLayoutBinding3 = this.b;
        if (dialogKtvCommonLayoutBinding3 == null || (textView = dialogKtvCommonLayoutBinding3.e) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$DialogKtvCommonView$Jgd_H9P38qkg454UibC4tBFrw5w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DialogKtvCommonView.b(DialogKtvCommonView.this, view3);
            }
        });
    }
}

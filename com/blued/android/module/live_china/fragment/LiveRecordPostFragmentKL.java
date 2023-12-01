package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRecordPostFragmentKL.class */
public final class LiveRecordPostFragmentKL extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f13230a;
    private View b;
    private EditText e;
    private TextView f;
    private EventCallback h;

    /* renamed from: c  reason: collision with root package name */
    private String f13231c = "";
    private String d = "";
    private final int g = 512;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRecordPostFragmentKL$EventCallback.class */
    public interface EventCallback {
        void a(EditText editText, String str, String str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r0 == null) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e() {
        /*
            r3 = this;
            r0 = r3
            android.os.Bundle r0 = r0.getArguments()
            r4 = r0
            java.lang.String r0 = ""
            r5 = r0
            r0 = r4
            if (r0 != 0) goto L12
        Lc:
            java.lang.String r0 = ""
            r4 = r0
            goto L22
        L12:
            r0 = r4
            java.lang.String r1 = "videopath"
            java.lang.String r0 = r0.getString(r1)
            r6 = r0
            r0 = r6
            r4 = r0
            r0 = r6
            if (r0 != 0) goto L22
            goto Lc
        L22:
            r0 = r3
            r1 = r4
            r0.f13231c = r1
            r0 = r3
            android.os.Bundle r0 = r0.getArguments()
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L35
            r0 = r5
            r4 = r0
            goto L45
        L35:
            r0 = r4
            java.lang.String r1 = "coverpath"
            java.lang.String r0 = r0.getString(r1)
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L45
            r0 = r5
            r4 = r0
            goto L45
        L45:
            r0 = r3
            r1 = r4
            r0.d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL.e():void");
    }

    private final void f() {
        View view = this.b;
        Intrinsics.a(view);
        this.e = (EditText) view.findViewById(R.id.edt_feed);
        View view2 = this.b;
        Intrinsics.a(view2);
        TextView textView = (TextView) view2.findViewById(R.id.tv_num);
        this.f = textView;
        Intrinsics.a(textView);
        textView.setText(Intrinsics.a("0/", (Object) Integer.valueOf(this.g)));
        EditText editText = this.e;
        Intrinsics.a(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL$initView$1
            private int b;

            /* renamed from: c  reason: collision with root package name */
            private int f13233c;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TextView textView2;
                EditText editText2;
                EditText editText3;
                EditText editText4;
                int i;
                TextView textView3;
                int i2;
                EditText editText5;
                EditText editText6;
                Intrinsics.e(s, "s");
                try {
                    editText2 = LiveRecordPostFragmentKL.this.e;
                    Intrinsics.a(editText2);
                    editText2.removeTextChangedListener(this);
                    editText3 = LiveRecordPostFragmentKL.this.e;
                    Intrinsics.a(editText3);
                    this.b = editText3.getSelectionStart();
                    editText4 = LiveRecordPostFragmentKL.this.e;
                    Intrinsics.a(editText4);
                    this.f13233c = editText4.getSelectionEnd();
                    while (true) {
                        int a2 = CommonStringUtils.a(s);
                        i = LiveRecordPostFragmentKL.this.g;
                        if (a2 <= i) {
                            textView3 = LiveRecordPostFragmentKL.this.f;
                            Intrinsics.a(textView3);
                            StringBuilder sb = new StringBuilder();
                            sb.append(CommonStringUtils.a(s));
                            sb.append('/');
                            i2 = LiveRecordPostFragmentKL.this.g;
                            sb.append(i2);
                            textView3.setText(sb.toString());
                            editText5 = LiveRecordPostFragmentKL.this.e;
                            Intrinsics.a(editText5);
                            editText5.setSelection(this.b);
                            editText6 = LiveRecordPostFragmentKL.this.e;
                            Intrinsics.a(editText6);
                            editText6.addTextChangedListener(this);
                            return;
                        }
                        s.delete(this.b - 1, this.f13233c);
                        this.b--;
                        this.f13233c--;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    textView2 = LiveRecordPostFragmentKL.this.f;
                    Intrinsics.a(textView2);
                    textView2.setText("");
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.e(s, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int i, int i2, int i3) {
                Intrinsics.e(s, "s");
            }
        });
        View view3 = this.b;
        Intrinsics.a(view3);
        View findViewById = view3.findViewById(R.id.bt_cancel);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL$initView$2
            @Override // android.view.View.OnClickListener
            public void onClick(View view4) {
                Tracker.onClick(view4);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_SHARE_CANCEL_CLICK, LiveRoomManager.a().e());
                LiveRecordPostFragmentKL.this.g();
                if (TextUtils.isEmpty(LiveRecordDialogFragment.d)) {
                    LiveEventBus.get(LiveEventBusUtil.o).post(LiveRecordPostFragmentKL.this.a());
                } else if (new File(LiveRecordDialogFragment.d).exists()) {
                } else {
                    LiveEventBus.get(LiveEventBusUtil.o).post(LiveRecordPostFragmentKL.this.a());
                }
            }
        });
        View view4 = this.b;
        Intrinsics.a(view4);
        View findViewById2 = view4.findViewById(R.id.bt_post);
        if (findViewById2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveRecordPostFragmentKL$initView$3
            @Override // android.view.View.OnClickListener
            public void onClick(View view5) {
                EditText editText2;
                Tracker.onClick(view5);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_PAGE_SHARE_PUBLISH_CLICK, LiveRoomManager.a().e());
                if (LiveRecordPostFragmentKL.this.d() != null) {
                    LiveRecordPostFragmentKL.EventCallback d = LiveRecordPostFragmentKL.this.d();
                    Intrinsics.a(d);
                    editText2 = LiveRecordPostFragmentKL.this.e;
                    d.a(editText2, LiveRecordPostFragmentKL.this.a(), LiveRecordPostFragmentKL.this.b());
                }
                RecordingOnliveFragment c2 = LiveRecordPostFragmentKL.this.c();
                if (c2 == null) {
                    return;
                }
                c2.ae();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        RecordingOnliveFragment c2 = c();
        if (c2 == null) {
            return;
        }
        c2.ae();
    }

    public final String a() {
        return this.f13231c;
    }

    public final void a(EventCallback eventCallback) {
        Intrinsics.e(eventCallback, "eventCallback");
        this.h = eventCallback;
    }

    public final String b() {
        return this.d;
    }

    public final RecordingOnliveFragment c() {
        if (getParentFragment() instanceof RecordingOnliveFragment) {
            return (RecordingOnliveFragment) getParentFragment();
        }
        return null;
    }

    public final EventCallback d() {
        return this.h;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f13230a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = inflater.inflate(R.layout.dialog_live_record_post, (ViewGroup) null);
            e();
            f();
        } else {
            Intrinsics.a(view);
            if (view.getParent() != null) {
                View view2 = this.b;
                Intrinsics.a(view2);
                ViewParent parent = view2.getParent();
                if (parent == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                ((ViewGroup) parent).removeView(this.b);
            }
        }
        return this.b;
    }
}

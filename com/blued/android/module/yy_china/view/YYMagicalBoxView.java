package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.databinding.ViewMagicalBoxBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYMagicalBoxFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYPreciousPackageModel;
import com.blued.android.module.yy_china.presenter.AbstractBasePresenter;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMagicalBoxView.class */
public final class YYMagicalBoxView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewMagicalBoxBinding f18294a;
    private BaseYYStudioFragment b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18295c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYMagicalBoxView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YYMagicalBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYMagicalBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewMagicalBoxBinding a2 = ViewMagicalBoxBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18294a = a2;
        setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMagicalBoxView$3keB49TUWdc_EVrdrx6G4DVFPFw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMagicalBoxView.a(YYMagicalBoxView.this, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalBoxView this$0, View view) {
        FragmentManager parentFragmentManager;
        AbstractBasePresenter l;
        Intrinsics.e(this$0, "this$0");
        if (YYRoomInfoManager.e().b() != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_BOX_RAIN_CLICK, YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().b().uid);
        }
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        YYPreciousPackageModel yYPreciousPackageModel = null;
        if (baseYYStudioFragment != null && (l = baseYYStudioFragment.l()) != null) {
            yYPreciousPackageModel = l.b;
        }
        YYMagicalBoxFragment yYMagicalBoxFragment = new YYMagicalBoxFragment(yYPreciousPackageModel);
        BaseYYStudioFragment baseYYStudioFragment2 = this$0.b;
        if (baseYYStudioFragment2 == null || (parentFragmentManager = baseYYStudioFragment2.getParentFragmentManager()) == null) {
            return;
        }
        yYMagicalBoxFragment.show(parentFragmentManager, "precious_box");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalBoxView this$0, Long l) {
        Intrinsics.e(this$0, "this$0");
        this$0.f18295c = true;
        this$0.a(true);
        TextView textView = this$0.f18294a.e;
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
        Intrinsics.a(simpleDateFormat);
        textView.setText(simpleDateFormat.format(l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalBoxView this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.f18295c = false;
        this$0.a(false);
        this$0.b();
    }

    private final void a(boolean z) {
        this.f18294a.b.setVisibility(z ? 8 : 0);
        TextView textView = this.f18294a.e;
        int i = 8;
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    private final void b() {
        AbstractBasePresenter l;
        YYPreciousPackageModel yYPreciousPackageModel;
        BaseYYStudioFragment baseYYStudioFragment = this.b;
        if (baseYYStudioFragment == null || (l = baseYYStudioFragment.l()) == null || (yYPreciousPackageModel = l.b) == null) {
            return;
        }
        getBinding().f.setText(yYPreciousPackageModel.current_beans);
        getBinding().g.setText(Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) yYPreciousPackageModel.need_total_beans));
        getBinding().f16870c.setMax(StringUtils.a(yYPreciousPackageModel.need_total_beans, 0));
        getBinding().f16870c.setProgress(StringUtils.a(yYPreciousPackageModel.current_beans, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMagicalBoxView this$0, Long l) {
        Intrinsics.e(this$0, "this$0");
        this$0.f18295c = true;
        TextView textView = this$0.f18294a.e;
        SimpleDateFormat simpleDateFormat = TimeAndDateUtils.k.get();
        Intrinsics.a(simpleDateFormat);
        textView.setText(simpleDateFormat.format(l));
    }

    public final void a() {
        if (!this.f18295c) {
            a(false);
        }
        b();
    }

    public final void a(BaseYYStudioFragment fragment) {
        LifecycleOwner viewLifecycleOwner;
        Intrinsics.e(fragment, "fragment");
        this.b = fragment;
        if (fragment == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null) {
            return;
        }
        LiveEventBus.get("grab_prize_prepare", Long.TYPE).observe(viewLifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMagicalBoxView$Phws6AKeW8UwLZP-WcK72A8DP8I
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYMagicalBoxView.a(YYMagicalBoxView.this, (Long) obj);
            }
        });
        LiveEventBus.get("grab_prize_start", Long.TYPE).observe(viewLifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMagicalBoxView$ctBDhbQCjKDYmcTCD8RGp2xkJAo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYMagicalBoxView.b(YYMagicalBoxView.this, (Long) obj);
            }
        });
        LiveEventBus.get("grab_prize_end", String.class).observe(viewLifecycleOwner, new Observer() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMagicalBoxView$3wyFNkLknU4NU6d_foJQk-tRauM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYMagicalBoxView.a(YYMagicalBoxView.this, (String) obj);
            }
        });
    }

    public final void a(String str) {
        if (str != null) {
            BaseYYStudioFragment baseYYStudioFragment = this.b;
            ImageLoader.a(baseYYStudioFragment == null ? null : baseYYStudioFragment.getFragmentActive(), str).a(this.f18294a.f16869a);
        }
    }

    public final ViewMagicalBoxBinding getBinding() {
        return this.f18294a;
    }

    public final void setBinding(ViewMagicalBoxBinding viewMagicalBoxBinding) {
        Intrinsics.e(viewMagicalBoxBinding, "<set-?>");
        this.f18294a = viewMagicalBoxBinding;
    }
}

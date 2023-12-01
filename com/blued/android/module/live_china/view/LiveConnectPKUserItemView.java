package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveConnectPkUserItemBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectPKUserItemView.class */
public final class LiveConnectPKUserItemView extends RelativeLayout {
    private final Context a;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    private View f;
    private final Lazy g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConnectPKUserItemView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConnectPKUserItemView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectPKUserItemView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.b = -2L;
        this.c = -2L;
        this.g = LazyKt.a(new Function0<LiveConnectPkUserItemBinding>() { // from class: com.blued.android.module.live_china.view.LiveConnectPKUserItemView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveConnectPkUserItemBinding invoke() {
                LiveConnectPkUserItemBinding a = LiveConnectPkUserItemBinding.a(LayoutInflater.from(LiveConnectPKUserItemView.this.getMContext()).inflate(R.layout.live_connect_pk_user_item, LiveConnectPKUserItemView.this));
                Intrinsics.c(a, "bind(\n            Layout…ser_item, this)\n        )");
                return a;
            }
        });
        this.f = getVb().c;
    }

    public /* synthetic */ LiveConnectPKUserItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        final boolean z = !this.e && this.d && this.c == LiveRoomInfo.a().g();
        getVb().c.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKUserItemView$Olo8ZHtWYcj89jsGqkle97fj928
            @Override // java.lang.Runnable
            public final void run() {
                LiveConnectPKUserItemView.a(LiveConnectPKUserItemView.this, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConnectPKUserItemView this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        long j = 100;
        ViewPropertyAnimator duration = this$0.getVb().c.animate().alpha(z ? 1.0f : 0.0f).setDuration(100L);
        if (!z) {
            j = 0;
        }
        duration.setStartDelay(j).start();
    }

    private final LiveConnectPkUserItemBinding getVb() {
        return (LiveConnectPkUserItemBinding) this.g.getValue();
    }

    public final void a(LiveInviteUserModel liveInviteUserModel) {
        if (liveInviteUserModel == null) {
            setUid(-1L);
            getVb().a.setImageResource(R.drawable.live_connet_pk_user_bg_round);
            getVb().d.setText("待邀请");
            return;
        }
        String str = liveInviteUserModel.uid;
        Long valueOf = str == null ? null : Long.valueOf(Long.parseLong(str));
        Intrinsics.a(valueOf);
        setUid(valueOf.longValue());
        ImageLoader.a((IRequestHost) null, liveInviteUserModel.avatar).b(R.drawable.live_connet_pk_user_bg_round).c().a(getVb().a);
        getVb().d.setText(liveInviteUserModel.name);
    }

    public final long getLastUid() {
        return this.b;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final View getSwitchBtn() {
        return this.f;
    }

    public final long getUid() {
        return this.c;
    }

    public final void setGroup(boolean z) {
        if (this.d == z) {
            return;
        }
        this.d = z;
        a();
    }

    public final void setLastUid(long j) {
        this.b = j;
    }

    public final void setPKIng(boolean z) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        a();
    }

    public final void setSwitchBtn(View view) {
        this.f = view;
    }

    public final void setUid(long j) {
        this.c = j;
        if (j != -2) {
            this.b = j;
        }
        a();
    }
}

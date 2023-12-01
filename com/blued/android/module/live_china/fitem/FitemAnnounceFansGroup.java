package com.blued.android.module.live_china.fitem;

import android.content.Context;
import android.view.View;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveAnnounceFansModel;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemAnnounceFansGroup.class */
public class FitemAnnounceFansGroup extends FreedomItem {
    public LiveAnnounceFansModel b;

    /* renamed from: c  reason: collision with root package name */
    public View f12521c;

    public FitemAnnounceFansGroup(LiveAnnounceFansModel liveAnnounceFansModel) {
        this.b = liveAnnounceFansModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a(!e());
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_announce_fans_group;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder baseViewHolder, List<FreedomItem> list, int i) {
        baseViewHolder.a(R.id.iv_avatar, this.b.image, 0, true).a(R.id.tv_fans_name, (CharSequence) this.b.name).a(R.id.rl_root, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemAnnounceFansGroup$cYcWJi-1iAmfZn71pwNPjBa4y48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemAnnounceFansGroup.this.a(view);
            }
        });
        View a2 = baseViewHolder.a(R.id.iv_check_select);
        this.f12521c = a2;
        if (a2.animate() != null) {
            this.f12521c.animate().cancel();
        }
        if (this.b.remind == 1) {
            this.f12521c.setAlpha(1.0f);
            this.f12521c.setRotation(0.0f);
            this.f12521c.setScaleX(1.0f);
            this.f12521c.setScaleY(1.0f);
            return;
        }
        this.f12521c.setAlpha(0.0f);
        this.f12521c.setRotation(-180.0f);
        this.f12521c.setScaleX(0.6f);
        this.f12521c.setScaleY(0.6f);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public boolean e() {
        LiveAnnounceFansModel liveAnnounceFansModel = this.b;
        boolean z = false;
        if (liveAnnounceFansModel == null) {
            return false;
        }
        if (liveAnnounceFansModel.remind == 1) {
            z = true;
        }
        return z;
    }
}

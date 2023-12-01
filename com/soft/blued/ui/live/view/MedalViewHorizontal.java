package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.view.MedalView;
import com.blued.android.module.live_china.view.PopAnchorBadgeCenter;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/MedalViewHorizontal.class */
public class MedalViewHorizontal extends MedalView {
    public MedalViewHorizontal(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void c() {
        this.a = this.c.inflate(R.layout.live_medal_horizontal, (ViewGroup) null);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.medal_view1 /* 2131368470 */:
                if (this.h != null && this.h.size() >= 1) {
                    Context context = this.b;
                    String str = this.d;
                    String str2 = this.e;
                    PopAnchorBadgeCenter.b(context, str, str2, ((BadgeData) this.h.get(0)).id + "", this, this.g);
                    break;
                }
                break;
            case R.id.medal_view2 /* 2131368471 */:
                if (this.h != null && this.h.size() >= 2) {
                    Context context2 = this.b;
                    String str3 = this.d;
                    String str4 = this.e;
                    PopAnchorBadgeCenter.b(context2, str3, str4, ((BadgeData) this.h.get(1)).id + "", this, this.g);
                    break;
                }
                break;
            case R.id.medal_view3 /* 2131368472 */:
                if (this.h != null && this.h.size() >= 3) {
                    Context context3 = this.b;
                    String str5 = this.d;
                    String str6 = this.e;
                    PopAnchorBadgeCenter.b(context3, str5, str6, ((BadgeData) this.h.get(2)).id + "", this, this.g);
                    break;
                }
                break;
        }
        if (this.h == null || this.h.size() < 1) {
            return;
        }
        if (this.f instanceof RecordingOnliveFragment) {
            this.i.O();
            return;
        }
        LiveRefreshUIObserver.a().d(4);
        LiveSetDataObserver.a().e(4);
    }
}

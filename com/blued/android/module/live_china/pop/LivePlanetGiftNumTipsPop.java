package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fitem.FitemPlanetGiftNum;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.PlanetGiveNumModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LivePlanetGiftNumTipsPop.class */
public final class LivePlanetGiftNumTipsPop extends AttachPopupView implements OnClickCallback {
    private final BaseDialogFragment t;
    private final ArrayList<PlanetGiveNumModel> u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetGiftNumTipsPop(Context context, BaseDialogFragment fragment, ArrayList<PlanetGiveNumModel> list) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(list, "list");
        this.t = fragment;
        this.u = list;
    }

    private final void a(PlanetGiveNumModel planetGiveNumModel) {
        LiveEventBusUtil.c(planetGiveNumModel.getCount());
    }

    private final void z() {
        LiveRouteUtil.a(this.t);
    }

    public final void a(View view, XPopupCallback xPopupCallback) {
        int a = DensityUtils.a(getContext(), 4.0f);
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScrollAlphaFromBottom).d((Boolean) false).a(PopupPosition.Top).b(true).a(view).b(a).c(DensityUtils.a(getContext(), 8.0f)).a((BasePopupView) this).h();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        ArrayList<PlanetGiveNumModel> arrayList = this.u;
        if (arrayList == null || arrayList.isEmpty()) {
            p();
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (PlanetGiveNumModel planetGiveNumModel : this.u) {
            arrayList2.add(new FitemPlanetGiftNum(getFragment(), planetGiveNumModel));
        }
        PlanetGiveNumModel planetGiveNumModel2 = new PlanetGiveNumModel();
        planetGiveNumModel2.setCount(-1);
        planetGiveNumModel2.setText("自定义数量");
        arrayList2.add(new FitemPlanetGiftNum(this.t, planetGiveNumModel2));
        FreedomAdapter freedomAdapter = new FreedomAdapter(getContext(), this.t.a(), arrayList2);
        RecyclerView findViewById = findViewById(R.id.rv_list);
        if (findViewById != null) {
            findViewById.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        if (findViewById != null) {
            findViewById.setItemAnimator(new DefaultItemAnimator());
        }
        if (findViewById != null) {
            findViewById.setAdapter(freedomAdapter);
        }
        freedomAdapter.a(this);
    }

    public final BaseDialogFragment getFragment() {
        return this.t;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_planet_gift_num_tips;
    }

    public final ArrayList<PlanetGiveNumModel> getList() {
        return this.u;
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        if (i >= this.u.size()) {
            z();
        } else {
            PlanetGiveNumModel planetGiveNumModel = this.u.get(i);
            Intrinsics.c(planetGiveNumModel, "list[position]");
            a(planetGiveNumModel);
        }
        p();
    }
}

package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveUserCardModuleAdapter;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveUserCardMouleModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveUserCardModuleView.class */
public final class LiveUserCardModuleView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14945a;
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private LiveUserCardModuleAdapter f14946c;
    private LiveRoomUserModel d;
    private String e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveUserCardModuleView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveUserCardModuleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveUserCardModuleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.e = "";
        this.f14945a = context;
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_user_card_label_view, this);
        this.b = (RecyclerView) findViewById(R.id.rv_view);
        ArrayList arrayList = new ArrayList();
        LiveUserCardMouleModel liveUserCardMouleModel = new LiveUserCardMouleModel();
        liveUserCardMouleModel.setColor_start("#987656");
        liveUserCardMouleModel.setColor_end("#127656");
        liveUserCardMouleModel.set_max_progress(true);
        liveUserCardMouleModel.setCurrent_progress(50.0f);
        liveUserCardMouleModel.setTotal_progress(100.0f);
        liveUserCardMouleModel.setName("123");
        liveUserCardMouleModel.setDesc("456");
        liveUserCardMouleModel.setFlip_desc("789");
        arrayList.add(liveUserCardMouleModel);
    }

    public final void a(List<LiveUserCardMouleModel> list, String str) {
        this.e = str;
        if (list == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f14946c = new LiveUserCardModuleAdapter(this.f14945a, list, str);
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.f14946c);
    }

    public final LiveUserCardModuleAdapter getAdapter() {
        return this.f14946c;
    }

    public final Context getMContext() {
        return this.f14945a;
    }

    public final LiveRoomUserModel getModel() {
        return this.d;
    }

    public final RecyclerView getRv_view() {
        return this.b;
    }

    public final String getUid() {
        return this.e;
    }

    public final void setAdapter(LiveUserCardModuleAdapter liveUserCardModuleAdapter) {
        this.f14946c = liveUserCardModuleAdapter;
    }

    public final void setMContext(Context context) {
        this.f14945a = context;
    }

    public final void setModel(LiveRoomUserModel liveRoomUserModel) {
        this.d = liveRoomUserModel;
    }

    public final void setRv_view(RecyclerView recyclerView) {
        this.b = recyclerView;
    }

    public final void setUid(String str) {
        this.e = str;
    }
}

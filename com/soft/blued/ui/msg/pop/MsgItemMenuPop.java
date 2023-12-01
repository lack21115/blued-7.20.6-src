package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.PopMsgItemMenuBinding;
import com.soft.blued.ui.msg.adapter.MsgMenuPopAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/MsgItemMenuPop.class */
public final class MsgItemMenuPop extends AttachPopupView {
    static final /* synthetic */ KProperty<Object>[] t = {(KProperty) Reflection.a(new PropertyReference1Impl(MsgItemMenuPop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopMsgItemMenuBinding;", 0))};
    private final List<String> u;
    private final ChattingModel v;
    private final ItemClickListener w;
    private final ViewBindingProperty x;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/MsgItemMenuPop$ItemClickListener.class */
    public interface ItemClickListener {
        void a(String str, ChattingModel chattingModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgItemMenuPop(Context context, List<String> list, ChattingModel chattingModel, ItemClickListener itemClickListener) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(list, "titles");
        Intrinsics.e(chattingModel, "chatM");
        Intrinsics.e(itemClickListener, "listener");
        this.u = list;
        this.v = chattingModel;
        this.w = itemClickListener;
        BasePopupView basePopupView = (BasePopupView) this;
        this.x = new CustomViewBindingProperty(new Function1<MsgItemMenuPop, PopMsgItemMenuBinding>() { // from class: com.soft.blued.ui.msg.pop.MsgItemMenuPop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopMsgItemMenuBinding invoke(MsgItemMenuPop msgItemMenuPop) {
                Intrinsics.e(msgItemMenuPop, "popView");
                return PopMsgItemMenuBinding.a(msgItemMenuPop.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MsgItemMenuPop msgItemMenuPop, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(msgItemMenuPop, "this$0");
        msgItemMenuPop.p();
        ItemClickListener itemClickListener = msgItemMenuPop.w;
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        itemClickListener.a((String) obj, msgItemMenuPop.v);
    }

    private final PopMsgItemMenuBinding getVb() {
        return (PopMsgItemMenuBinding) this.x.b(this, t[0]);
    }

    public void b() {
        super.b();
        MsgMenuPopAdapter msgMenuPopAdapter = new MsgMenuPopAdapter(this.u);
        PopMsgItemMenuBinding vb = getVb();
        RecyclerView recyclerView = vb == null ? null : vb.f15854c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        PopMsgItemMenuBinding vb2 = getVb();
        RecyclerView recyclerView2 = vb2 == null ? null : vb2.f15854c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(msgMenuPopAdapter);
        }
        msgMenuPopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$MsgItemMenuPop$WnR3yRk4V7CsQ43RVWf7CS3nkxA
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MsgItemMenuPop.a(MsgItemMenuPop.this, baseQuickAdapter, view, i);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_msg_item_menu;
    }

    public final ItemClickListener getListener() {
        return this.w;
    }

    public final List<String> getTitles() {
        return this.u;
    }
}

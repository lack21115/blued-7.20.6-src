package com.soft.blued.ui.find.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.adapter.RecommendPopAdapter;
import com.soft.blued.ui.find.model.RecommendPopModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/RecommendPopView.class */
public final class RecommendPopView extends BottomPopupView {
    private List<RecommendPopModel> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendPopView(Context context, List<RecommendPopModel> list) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(list, "data");
        this.b = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendPopView recommendPopView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(recommendPopView, "this$0");
        recommendPopView.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendPopView recommendPopView, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(recommendPopView, "this$0");
        long uid = recommendPopView.b.get(i).getUid();
        if (uid > 0) {
            EventTrackGuy.a(GuyProtos.Event.PICK_FOR_YOU_POP_USER_CLICK, String.valueOf(uid));
            UserInfoFragmentNew.a(recommendPopView.getContext(), String.valueOf(uid), UserFindResult.USER_SORT_BY.NEARBY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(long j) {
        ChatHelperV4.a().c(ChatHelper.getChattingModelForSendmsg(j, (short) 1, getContext().getResources().getString(R.string.recommend_people_message_content), ChatHelperV4.a().b(), "", (short) 2), "", "", 0, 0, 0, 0, 0, false);
    }

    public void b() {
        super.b();
        ImageLoader.a((IRequestHost) null, ImgURLMap.a.a("bg_nearby_people_recommend")).a((ImageView) findViewById(R.id.iv_bg));
        ((FrameLayout) findViewById(R.id.fl_close)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$RecommendPopView$Qk9zV0xti9jCmFtbqdfQ07-rCiA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendPopView.a(RecommendPopView.this, view);
            }
        });
        Context context = getContext();
        Intrinsics.c(context, "context");
        final RecommendPopAdapter recommendPopAdapter = new RecommendPopAdapter(context);
        recommendPopAdapter.setNewData(this.b);
        recommendPopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$RecommendPopView$-PfspPB5VUbj2HgrgUngYf3Nhuw
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RecommendPopView.a(RecommendPopView.this, baseQuickAdapter, view, i);
            }
        });
        recommendPopAdapter.a(new RecommendPopAdapter.OnSayHelloClickedListener() { // from class: com.soft.blued.ui.find.view.RecommendPopView$initPopupContent$3
            @Override // com.soft.blued.ui.find.adapter.RecommendPopAdapter.OnSayHelloClickedListener
            public void a(int i) {
                List list;
                List list2;
                list = RecommendPopView.this.b;
                long uid = ((RecommendPopModel) list.get(i)).getUid();
                if (uid > 0) {
                    EventTrackGuy.a(GuyProtos.Event.PICK_FOR_YOU_POP_USER_HI_CLICK, String.valueOf(uid));
                    list2 = RecommendPopView.this.b;
                    ((RecommendPopModel) list2.get(i)).setSayHelloEnable(false);
                    recommendPopAdapter.notifyItemChanged(i);
                    RecommendPopView.this.b(uid);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recommendPopAdapter);
    }

    public int getImplLayoutId() {
        return R.layout.pop_nearby_people_recommend;
    }
}

package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.ConstFunction;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRoomFunctionDlgFragment$onInitView$1$convert$1.class */
public final class LiveRoomFunctionDlgFragment$onInitView$1$convert$1 extends CommonRecycleAdapter<LiveRoomFunctionItemModel> {
    final /* synthetic */ LiveRoomFunctionDlgFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRoomFunctionDlgFragment$onInitView$1$convert$1(LiveRoomFunctionDlgFragment liveRoomFunctionDlgFragment, Context context) {
        super(context);
        this.a = liveRoomFunctionDlgFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRoomFunctionItemModel liveRoomFunctionItemModel, LiveRoomFunctionDlgFragment this$0, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, View view) {
        Intrinsics.e(this$0, "this$0");
        String str = (LiveRoomManager.a().p().red_point == null || liveRoomFunctionItemModel == null || TextUtils.isEmpty(liveRoomFunctionItemModel.getAction())) ? "0" : LiveRoomManager.a().p().red_point.get(liveRoomFunctionItemModel.getAction());
        if (!TextUtils.isEmpty(liveRoomFunctionItemModel == null ? null : liveRoomFunctionItemModel.getAction())) {
            LiveRoomPreferences.a(liveRoomFunctionItemModel == null ? null : liveRoomFunctionItemModel.getAction(), str);
            this$0.a(liveRoomFunctionItemModel, commonAdapterHolder == null ? null : commonAdapterHolder.a(R.id.tv_dot));
            LiveSetDataObserver.a().B();
        }
        this$0.a(liveRoomFunctionItemModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    /* renamed from: a */
    public void onBindViewHolderData(final LiveRoomFunctionItemModel liveRoomFunctionItemModel, int i, final CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
        View view;
        ImageView imageView = commonAdapterHolder == null ? null : (ImageView) commonAdapterHolder.a(R.id.item_live_room_func_sub_icon);
        if (imageView != null && liveRoomFunctionItemModel != null) {
            ImageLoader.a(this.a.a(), liveRoomFunctionItemModel.getCurrentIcon()).b(R.drawable.live_func_default).a(imageView);
        }
        TextView textView = commonAdapterHolder == null ? null : (TextView) commonAdapterHolder.a(R.id.item_live_room_func_sub_name);
        if (textView != null) {
            textView.setText(liveRoomFunctionItemModel == null ? null : liveRoomFunctionItemModel.getTitle());
            textView.getLayoutParams().width = this.a.j();
        }
        this.a.a(liveRoomFunctionItemModel, commonAdapterHolder == null ? null : commonAdapterHolder.a(R.id.tv_dot));
        if (commonAdapterHolder != null && (view = commonAdapterHolder.itemView) != null) {
            final LiveRoomFunctionDlgFragment liveRoomFunctionDlgFragment = this.a;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRoomFunctionDlgFragment$onInitView$1$convert$1$7b_COiMxQNv_0G24BSgACXKM5JU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveRoomFunctionDlgFragment$onInitView$1$convert$1.a(LiveRoomFunctionItemModel.this, liveRoomFunctionDlgFragment, commonAdapterHolder, view2);
                }
            });
        }
        if (Intrinsics.a((Object) (liveRoomFunctionItemModel == null ? null : liveRoomFunctionItemModel.getLink()), (Object) ConstFunction.LIVE_ROOM_GIFT_ANIMATION)) {
            EventTrackLive.o(LiveProtos.Event.LIVE_GIFT_EFFECT_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LiveRoomManager.a().H() ? "open" : LoaderConstants.CLOSE);
        }
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return R.layout.item_live_room_fuction_sub;
    }
}

package com.blued.android.module.live_china.test;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveAdapterTest.class */
public final class LiveAdapterTest extends BaseQuickAdapter<BluedLiveListDataTest, BaseViewHolder> {
    public LiveAdapterTest() {
        super(R.layout.live_list_item_test);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final BluedLiveListDataTest bluedLiveListDataTest) {
        TextView textView;
        View view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.root_view);
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = AppInfo.l / 2;
        }
        if (layoutParams != null) {
            layoutParams.height = AppInfo.l / 2;
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        Intrinsics.a(bluedLiveListDataTest);
        Log.i("==xpm", Intrinsics.a("item!!.pic_url:", (Object) bluedLiveListDataTest.pic_url));
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.iv_avatar);
        ImageLoader.a((IRequestHost) null, bluedLiveListDataTest.pic_url).a(5.0f).b(R.drawable.live_bg).a(imageView);
        if (baseViewHolder != null && (textView = (TextView) baseViewHolder.getView(R.id.tv_name)) != null) {
            UserBasicModel userBasicModel = bluedLiveListDataTest.anchor;
            textView.setText(userBasicModel == null ? null : userBasicModel.name);
        }
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.test.LiveAdapterTest$convert$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                UserBasicModel userBasicModel2;
                UserBasicModel userBasicModel3;
                UserBasicModel userBasicModel4;
                Context context;
                Tracker.onClick(view2);
                if (StringUtils.a(BluedLiveListDataTest.this.lid, 0L) == 0) {
                    AppMethods.a((CharSequence) "lid is 0");
                }
                BluedLiveListDataTest bluedLiveListDataTest2 = BluedLiveListDataTest.this;
                long a2 = StringUtils.a(bluedLiveListDataTest2 == null ? null : bluedLiveListDataTest2.lid, 0L);
                BluedLiveListDataTest bluedLiveListDataTest3 = BluedLiveListDataTest.this;
                String str = (bluedLiveListDataTest3 == null || (userBasicModel2 = bluedLiveListDataTest3.anchor) == null) ? null : userBasicModel2.uid;
                BluedLiveListDataTest bluedLiveListDataTest4 = BluedLiveListDataTest.this;
                String str2 = (bluedLiveListDataTest4 == null || (userBasicModel3 = bluedLiveListDataTest4.anchor) == null) ? null : userBasicModel3.name;
                BluedLiveListDataTest bluedLiveListDataTest5 = BluedLiveListDataTest.this;
                LiveRoomData liveRoomData = new LiveRoomData(a2, 0, "", str, str2, (bluedLiveListDataTest5 == null || (userBasicModel4 = bluedLiveListDataTest5.anchor) == null) ? null : userBasicModel4.avatar, 0);
                context = this.mContext;
                PlayingOnliveFragment.a(context, liveRoomData);
            }
        });
    }
}

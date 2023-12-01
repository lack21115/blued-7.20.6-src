package com.blued.community.ui.event.vm;

import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.event.model.EventMemberModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/vm/EventMembersListViewModel.class */
public final class EventMembersListViewModel extends BaseListViewModel<EventMemberModel> {

    /* renamed from: a  reason: collision with root package name */
    private String f19592a = "";
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f19593c;
    private boolean d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BluedEntityA<EventMemberModel> bluedEntityA) {
        List<BluedIngSelfFeed> list;
        if (bluedEntityA.getSingleData() != null) {
            for (EventMemberModel eventMemberModel : bluedEntityA.data) {
                eventMemberModel.feedPics = new ArrayList();
                if (eventMemberModel.feed_image == null) {
                    Intrinsics.c(eventMemberModel.feed_image, "memberModel.feed_image");
                    if (!list.isEmpty()) {
                    }
                }
                for (BluedIngSelfFeed bluedIngSelfFeed : eventMemberModel.feed_image) {
                    if (bluedIngSelfFeed.feed_pics != null) {
                        String[] strArr = bluedIngSelfFeed.feed_pics;
                        Intrinsics.c(strArr, "feed.feed_pics");
                        if (!(strArr.length == 0)) {
                            int length = bluedIngSelfFeed.feed_pics.length;
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 < length) {
                                    AlbumFlow albumFlow = new AlbumFlow(bluedIngSelfFeed);
                                    albumFlow.album_pic = bluedIngSelfFeed.feed_pics[i2];
                                    eventMemberModel.feedPics.add(albumFlow);
                                    i = i2 + 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.f19593c;
    }

    public final boolean c() {
        return this.e;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    public void init(Bundle bundle) {
        super.init(bundle);
        if (bundle != null) {
            String string = bundle.getString("event_id", "");
            Intrinsics.c(string, "arguments.getString(Even…nts.DataKey.EVENT_ID, \"\")");
            this.b = string;
            String string2 = bundle.getString("event_uid", "");
            Intrinsics.c(string2, "arguments.getString(Even…ts.DataKey.EVENT_UID, \"\")");
            this.f19592a = string2;
            this.e = CommunityManager.f19086a.a().c(this.f19592a);
            this.f19593c = bundle.getInt("event_quota_num", 0);
            this.d = bundle.getBoolean("event_is_free", false);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        EventHttpUtils eventHttpUtils = EventHttpUtils.f19079a;
        BluedUIHttpResponse<BluedEntityA<EventMemberModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<EventMemberModel>>() { // from class: com.blued.community.ui.event.vm.EventMembersListViewModel$requestData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EventMemberModel> result) {
                Intrinsics.e(result, "result");
                EventMembersListViewModel.this.a(result);
                EventMembersListViewModel.this.loadListSucceed(result.data, result.hasMore());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                EventMembersListViewModel.this.loadListFailed();
            }
        };
        String str = this.b;
        int mPage = getMPage();
        String latitude = UserInfo.getInstance().getLoginUserInfo().getLatitude();
        Intrinsics.c(latitude, "getInstance().loginUserInfo.latitude");
        String longitude = UserInfo.getInstance().getLoginUserInfo().getLongitude();
        Intrinsics.c(longitude, "getInstance().loginUserInfo.longitude");
        eventHttpUtils.a(bluedUIHttpResponse, str, mPage, latitude, longitude, (IRequestHost) null);
    }
}

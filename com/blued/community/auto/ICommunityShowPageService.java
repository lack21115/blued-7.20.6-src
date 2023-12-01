package com.blued.community.auto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.ad.ADConstants;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.square.model.AttentionLiveRecommendData;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/auto/ICommunityShowPageService.class */
public interface ICommunityShowPageService {
    String a();

    void a(Activity activity, Bundle bundle, int i);

    void a(Context context, int i);

    void a(Context context, int i, int i2, LoadOptions loadOptions);

    void a(Context context, int i, ADConstants.AD_POSITION ad_position, int i2, VipProtos.FromType fromType);

    void a(Context context, int i, String str);

    void a(Context context, int i, String str, int i2, VipProtos.FromType fromType);

    void a(Context context, Bundle bundle);

    void a(Context context, BluedADExtra bluedADExtra, int i, PayVIPPopupWindow.OnVideoSuccessListener onVideoSuccessListener);

    void a(Context context, UserBasicModel userBasicModel, long j);

    void a(Context context, UserBasicModel userBasicModel, long j, String str);

    void a(Context context, UserBasicModel userBasicModel, LogData logData, boolean z, int i, MessageProtos.StrangerSource strangerSource);

    void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, View view);

    void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, boolean z, View view, LogData logData, MessageProtos.StrangerSource strangerSource);

    void a(Context context, UserBasicModel userBasicModel, String str, View view);

    void a(Context context, UserBasicModel userBasicModel, String str, boolean z, View view, LogData logData, MessageProtos.StrangerSource strangerSource);

    void a(Context context, CommunityConstants.ReportType reportType, String str, String str2, String str3);

    void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3);

    void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, String str, String str2);

    void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, LogData logData, MessageProtos.StrangerSource strangerSource);

    void a(Context context, AttentionLiveRecommendData attentionLiveRecommendData, List<AttentionLiveRecommendData> list);

    void a(Context context, FeedRecommendUser feedRecommendUser, List<FeedRecommendUser> list);

    void a(Context context, String str);

    void a(Context context, String str, GroupInfoModel groupInfoModel, LogData logData, SocialNetWorkProtos.SourceType sourceType);

    void a(Context context, String str, CommunityConstants.WebShowType webShowType);

    void a(Context context, String str, String str2);

    void a(Context context, String str, String str2, int i, String str3, int i2, int i3);

    void a(Context context, String str, String str2, MessageProtos.StrangerSource strangerSource);

    void a(Context context, String str, String str2, String str3);

    void a(Context context, String str, String str2, String str3, int i);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, long j);

    void a(Context context, String str, String str2, String str3, int i, long j);

    void a(Context context, List<AlbumFlow> list, int i, int i2, int i3);

    void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions);

    void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions, String str, View view, String str2);

    void a(Fragment fragment, Bundle bundle, int i);

    void a(BaseFragment baseFragment, int i, int i2);

    void a(BaseFragment baseFragment, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3, int i4);

    void b(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, LogData logData, MessageProtos.StrangerSource strangerSource);

    void b(Context context, String str);

    void b(Context context, String str, String str2);

    void b(BaseFragment baseFragment, int i, int i2);

    void c(Context context, String str);

    void c(Context context, String str, String str2);

    void d(Context context, String str);
}

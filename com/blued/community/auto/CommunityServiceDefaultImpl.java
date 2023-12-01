package com.blued.community.auto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.listener.LocationHelperNew;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.view.GroupJoinView;
import com.blued.community.manager.CommunityConstants;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.BubbleExhibitionModel;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.square.model.AttentionLiveRecommendData;
import com.blued.community.ui.square.model.FeedRecommendUser;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/auto/CommunityServiceDefaultImpl.class */
public class CommunityServiceDefaultImpl implements ICommunityConfigService, ICommunityLocationService, ICommunityOtherService, ICommunityShowPageService, ICommunityTrackService {
    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean A() {
        return true;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean B() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean C() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int D() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int E() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String F() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String G() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int H() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String I() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String J() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String K() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String L() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean M() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean N() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public List<BubbleExhibitionModel> O() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean P() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int Q() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public View a(Context context) {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService, com.blued.community.auto.ICommunityLocationService, com.blued.community.auto.ICommunityOtherService, com.blued.community.auto.ICommunityShowPageService, com.blued.community.auto.ICommunityTrackService
    public String a() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, int i2) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, String str) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(int i, String str, String str2, String str3) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Activity activity, Bundle bundle, int i) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, int i) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, int i, int i2, LoadOptions loadOptions) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, int i, ADConstants.AD_POSITION ad_position, int i2, VipProtos.FromType fromType) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, int i, String str) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, int i, String str, int i2, VipProtos.FromType fromType) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, Bundle bundle) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, BluedADExtra bluedADExtra, int i, PayVIPPopupWindow.OnVideoSuccessListener onVideoSuccessListener) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, long j) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, long j, String str) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, LogData logData, boolean z, int i, MessageProtos.StrangerSource strangerSource) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, View view) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, boolean z, View view, LogData logData, MessageProtos.StrangerSource strangerSource) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, String str, View view) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, UserBasicModel userBasicModel, String str, boolean z, View view, LogData logData, MessageProtos.StrangerSource strangerSource) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, CommunityConstants.ReportType reportType, String str, String str2, String str3) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, String str, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, LogData logData, MessageProtos.StrangerSource strangerSource) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, AttentionLiveRecommendData attentionLiveRecommendData, List<AttentionLiveRecommendData> list) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, FeedRecommendUser feedRecommendUser, List<FeedRecommendUser> list) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str) {
        AppMethods.a((CharSequence) ("toWebViewFragment：" + str));
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, GroupInfoModel groupInfoModel, LogData logData, SocialNetWorkProtos.SourceType sourceType) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, CommunityConstants.WebShowType webShowType) {
        AppMethods.a((CharSequence) ("toWebViewFragment：" + str));
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2, int i, String str3, int i2, int i3) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2, MessageProtos.StrangerSource strangerSource) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2, String str3) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2, String str3, int i) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2, String str3, int i, int i2, int i3, long j) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String str, String str2, String str3, int i, long j) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, List<AlbumFlow> list, int i, int i2, int i3) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions, String str, View view, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void a(Fragment fragment) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(Fragment fragment, Bundle bundle, int i) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void a(ActivityFragmentActive activityFragmentActive, BluedADExtra bluedADExtra, View view, View view2) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(BaseFragment baseFragment, int i, int i2) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void a(BaseFragment baseFragment, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3, int i4) {
    }

    @Override // com.blued.community.auto.ICommunityLocationService
    public void a(LocationHelperNew.LocationFinishListener locationFinishListener) {
        locationFinishListener.a();
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(LogData logData) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void a(GroupJoinView groupJoinView, int i, List<GroupInfoModel> list, ActivityFragmentActive activityFragmentActive) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(PersonalProfileProtos.Event event, String str) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void a(Long l, int i) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str, int i) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void a(String str, String str2, int i, String str3) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void a(List<GroupInfoModel> list) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void a(boolean z) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b() {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void b(Context context, int i, String str) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void b(Context context, BluedIngSelfFeed bluedIngSelfFeed, boolean z, int i, LogData logData, MessageProtos.StrangerSource strangerSource) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void b(Context context, String str) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void b(Context context, String str, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void b(BaseFragment baseFragment, int i, int i2) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b(String str, int i) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void b(String str, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public void b(boolean z) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public boolean b(int i) {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean b(Context context) {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public String c(int i) {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void c() {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void c(int i, BluedIngSelfFeed bluedIngSelfFeed, String str, int i2) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void c(Context context, String str) {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void c(Context context, String str, String str2) {
    }

    @Override // com.blued.community.auto.ICommunityTrackService
    public void c(String str, int i) {
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean c(Context context) {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public String d(int i) {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void d() {
    }

    @Override // com.blued.community.auto.ICommunityShowPageService
    public void d(Context context, String str) {
    }

    @Override // com.blued.community.auto.ICommunityLocationService
    public String e() {
        return "116.40";
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void e(int i) {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public int f(int i) {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityLocationService
    public String f() {
        return "39.90";
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String g() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public void h() {
    }

    @Override // com.blued.community.auto.ICommunityOtherService
    public boolean i() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean j() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean k() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean l() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean m() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean n() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean o() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int p() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int q() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String[] r() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public void s() {
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public List<String> t() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public String u() {
        return null;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int v() {
        return 100;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean w() {
        return false;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int x() {
        return 1;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public int y() {
        return 0;
    }

    @Override // com.blued.community.auto.ICommunityConfigService
    public boolean z() {
        return true;
    }
}

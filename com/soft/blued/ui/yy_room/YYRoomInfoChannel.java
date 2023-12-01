package com.soft.blued.ui.yy_room;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import com.anythink.expressad.video.module.a.a.m;
import com.app.share.ShareUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.ActivityUrl;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.ClickAtLinkListener;
import com.blued.android.module.yy_china.listener.IAddBlackListener;
import com.blued.android.module.yy_china.listener.YYIVIPBuyResultObserver;
import com.blued.android.module.yy_china.listener.YYPWDListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplication;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.live.fragment.LiveYYImproveFragment;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.yy_room.fragment.YYInviteFragment;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/YYRoomInfoChannel.class */
public class YYRoomInfoChannel {
    public static void a() {
        if (YYRoomInfoManager.e().a()) {
            return;
        }
        YYRoomInfoManager.e().a(b());
    }

    private static IYYRoomInfoCallback b() {
        return new IYYRoomInfoCallback() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1

            /* renamed from: com.soft.blued.ui.yy_room.YYRoomInfoChannel$1$4  reason: invalid class name */
            /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/YYRoomInfoChannel$1$4.class */
            class AnonymousClass4 extends BluedUIHttpResponse<BluedEntityA<Object>> {

                /* renamed from: a  reason: collision with root package name */
                boolean f20979a;
                final /* synthetic */ IAddBlackListener b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f20980c;

                /* JADX INFO: Access modifiers changed from: protected */
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    AppMethods.d((int) R.string.add_black_success);
                    UserInfo.getInstance().getLoginUserInfo().addBlackCount();
                    ChatHelperV4.a().b(Long.parseLong(this.f20980c));
                    UserInfoEntity userInfoEntity = new UserInfoEntity();
                    userInfoEntity.uid = this.f20980c;
                    userInfoEntity.relationship = "";
                    LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
                    IAddBlackListener iAddBlackListener = this.b;
                    if (iAddBlackListener != null) {
                        iAddBlackListener.b();
                    }
                }

                public boolean onUIFailure(int i, String str) {
                    if (i == 403902) {
                        this.f20979a = true;
                    }
                    return super.onUIFailure(i, str);
                }

                public void onUIFinish() {
                    super.onUIFinish();
                    IAddBlackListener iAddBlackListener = this.b;
                    if (iAddBlackListener != null) {
                        iAddBlackListener.c();
                    }
                }

                public void onUIStart() {
                    super.onUIStart();
                    IAddBlackListener iAddBlackListener = this.b;
                    if (iAddBlackListener != null) {
                        iAddBlackListener.a();
                    }
                }
            }

            /* renamed from: com.soft.blued.ui.yy_room.YYRoomInfoChannel$1$6  reason: invalid class name */
            /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/yy_room/YYRoomInfoChannel$1$6.class */
            class AnonymousClass6 implements CommonAlertDialog.PWDListener {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ YYPWDListener f20982a;

                public void a(String str, boolean z, DialogWith6PW dialogWith6PW) {
                    this.f20982a.a(str, z);
                }
            }

            public CharSequence a(CharSequence charSequence, String str, final ClickAtLinkListener clickAtLinkListener) {
                return StringUtils.a(charSequence, true, true, false, new TypefaceUtils.ClickAtLinkListener() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1.3
                    @Override // com.soft.blued.utils.TypefaceUtils.ClickAtLinkListener
                    public void a(String str2, String str3) {
                        clickAtLinkListener.a(str2, str3);
                    }
                }, true, str, "", clickAtLinkListener);
            }

            public Object a(final YYIVIPBuyResultObserver yYIVIPBuyResultObserver) {
                VIPBuyResultObserver.IVIPBuyResultObserver iVIPBuyResultObserver = new VIPBuyResultObserver.IVIPBuyResultObserver() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1.5
                    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
                    public void a(int i, boolean z) {
                        yYIVIPBuyResultObserver.a(i, z);
                    }
                };
                VIPBuyResultObserver.a().a(iVIPBuyResultObserver);
                return iVIPBuyResultObserver;
            }

            public String a() {
                return UserInfo.getInstance().getLoginUserInfo().getName();
            }

            public String a(int i) {
                switch (i) {
                    case -1:
                        return H5Url.a(63);
                    case 0:
                    default:
                        return "";
                    case 1:
                        return H5Url.a(76);
                    case 2:
                        return ActivityUrl.a(2);
                    case 3:
                        return H5Url.a(77);
                    case 4:
                        return H5Url.a(81);
                    case 5:
                        return ActivityUrl.a(3);
                    case 6:
                        return H5Url.a(80);
                    case 7:
                        return H5Url.a(78);
                    case 8:
                        return H5Url.a(79);
                    case 9:
                        return H5Url.a(82);
                    case 10:
                        return H5Url.a(62);
                    case 11:
                        return H5Url.a(61);
                    case 12:
                        return H5Url.a(60);
                    case 13:
                        return H5Url.a(93);
                    case 14:
                        return H5Url.a(94);
                    case 15:
                        return H5Url.a(96);
                    case 16:
                        return H5Url.a(97);
                    case 17:
                        return H5Url.a(100);
                    case 18:
                        return H5Url.a(98);
                    case 19:
                        return H5Url.a(99);
                }
            }

            public void a(Context context) {
                TerminalActivity.d(context, LinkMobileFragment.class, (Bundle) null);
            }

            public void a(Context context, EditText editText, int i, int i2, String str, Map<String, String> map) {
                MsgCommonUtils.a(context, editText, i, i2, str, map);
            }

            public void a(Context context, FragmentManager fragmentManager, YYRoomModel yYRoomModel, Bitmap bitmap, String str) {
                ShareToMsgEntity shareToMsgEntity = new ShareToMsgEntity();
                shareToMsgEntity.title = str;
                shareToMsgEntity.name = "";
                shareToMsgEntity.image = yYRoomModel.avatar;
                shareToMsgEntity.description = "";
                shareToMsgEntity.url = "";
                shareToMsgEntity.type = 12;
                shareToMsgEntity.sessionId = Long.valueOf(yYRoomModel.room_id).longValue();
                YYInviteFragment yYInviteFragment = new YYInviteFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("share_type", 0);
                bundle.putParcelable("share_entity", shareToMsgEntity);
                bundle.putString("share_yy_type_name", yYRoomModel.room_type);
                bundle.putString("share_yy_type_id", yYRoomModel.type_id);
                yYInviteFragment.setArguments(bundle);
                yYInviteFragment.show(fragmentManager, "InviteDialog");
            }

            public void a(Context context, String str) {
                WebViewShowInfoFragment.show(context, H5Url.a(66) + str, 0, true);
            }

            public void a(Context context, String str, int i) {
                WebViewShowInfoFragment.show(context, str, i);
            }

            public void a(Context context, String str, int i, boolean z) {
                WebViewShowInfoFragment.show(context, str, i, z);
            }

            public void a(Context context, String str, String str2) {
                NewFeedModel newFeedModel = new NewFeedModel();
                newFeedModel.setContent(str);
                newFeedModel.setPics(str2);
                FeedAddPostFragment.a(context, newFeedModel);
            }

            public void a(Context context, String str, String str2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, IRequestHost iRequestHost) {
                UserHttpUtils.b(context, YYRoomInfoChannel.b(iAddOrRemoveAttentionDone), str, str2, iRequestHost);
            }

            public void a(Context context, String str, String str2, String str3) {
                LogData logData = new LogData();
                logData.userFrom = "msg_chat_room";
                ChatHelperV4.a().a(context, StringUtils.a(str, -1L), str2, str3, 0, 0, 0, 0, "", false, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.CHAT_ROOM, ""));
            }

            public void a(Context context, String str, String str2, String str3, int i, int i2) {
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.uid = str;
                userBasicModel.name = str2;
                userBasicModel.avatar = str3;
                userBasicModel.is_show_vip_page = i;
                if (i2 == 2) {
                    UserInfoFragmentNew.a(context, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.LIVE, ""));
                } else if (i2 == 2) {
                    UserInfoFragmentNew.a(context, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                }
            }

            public void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i) {
                BluedURIRouterAdapter.startVIPPay(context, str, str2, str3, str4, str5, str6, i);
            }

            public void a(final BaseFragment baseFragment) {
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1.7
                    public void U_() {
                        PhotoSelectFragment.a(baseFragment, 3, 22);
                    }

                    public void a(String[] strArr) {
                    }
                });
            }

            public void a(BluedUIHttpResponse bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive, String str) {
                PayHttpUtils.a(bluedUIHttpResponse, (IRequestHost) activityFragmentActive, str);
            }

            public void a(BaseYYStudioFragment baseYYStudioFragment, final YYRoomModel yYRoomModel, Bitmap bitmap, String str) {
                BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
                shareLiveData.i = false;
                shareLiveData.f20020c = "";
                shareLiveData.e = bitmap;
                if (yYRoomModel != null) {
                    shareLiveData.h = yYRoomModel.room_id + "";
                    shareLiveData.f20019a = yYRoomModel.name;
                    shareLiveData.d = yYRoomModel.avatar;
                    shareLiveData.f = yYRoomModel.uid;
                    shareLiveData.f20020c = yYRoomModel.room_name;
                    shareLiveData.b = "我正在 " + yYRoomModel.name + " 的语音聊天室，邀请你一起加入";
                }
                shareLiveData.l = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1.1
                    @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
                    public void onItemClick(int i) {
                        ChatRoomProtos.ShareChannel shareChannel = null;
                        switch (i) {
                            case 2131887268:
                                break;
                            case 2131891709:
                                shareChannel = ChatRoomProtos.ShareChannel.SHARE_FRIEND;
                                break;
                            case 2131892070:
                                shareChannel = ChatRoomProtos.ShareChannel.SHARE_QQ;
                                break;
                            case 2131892078:
                                shareChannel = ChatRoomProtos.ShareChannel.SHARE_WEIBO;
                                break;
                            case 2131892085:
                                shareChannel = ChatRoomProtos.ShareChannel.SHARE_WECHAT;
                                break;
                            case 2131892088:
                                shareChannel = ChatRoomProtos.ShareChannel.SHARE_FRIEND_CLUB;
                                break;
                            default:
                                shareChannel = null;
                                break;
                        }
                        EventTrackYY.a(yYRoomModel.room_id, yYRoomModel.uid, shareChannel);
                    }
                };
                shareLiveData.k = new ShareCoreUtils.ShareBackLister() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1.2
                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void a(String str2) {
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.1.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LiveSetDataObserver.a().n();
                            }
                        }, m.ag);
                    }

                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void b(String str2) {
                        ToastUtils.a("分享失败");
                    }

                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void c(String str2) {
                        ToastUtils.a("分享取消");
                    }

                    @Override // com.soft.blued.utils.ShareCoreUtils.ShareBackLister
                    public void d(String str2) {
                    }
                };
                ShareUtils.a().b(baseYYStudioFragment.getContext(), shareLiveData);
            }

            public void a(Object obj) {
                if (obj instanceof VIPBuyResultObserver.IVIPBuyResultObserver) {
                    VIPBuyResultObserver.a().b((VIPBuyResultObserver.IVIPBuyResultObserver) obj);
                }
            }

            public void a(String[] strArr) {
                FindHttpUtils.b(strArr);
            }

            public boolean a(Context context, View.OnClickListener onClickListener) {
                return PopMenuUtils.a(context, onClickListener);
            }

            public String b() {
                return UserInfo.getInstance().getLoginUserInfo().avatar;
            }

            public void b(Context context) {
                LiveYYImproveFragment.a(context);
            }

            public void b(Context context, String str, String str2, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone, IRequestHost iRequestHost) {
                UserHttpUtils.a(context, YYRoomInfoChannel.b(iAddOrRemoveAttentionDone), str, str2, iRequestHost);
            }

            public String c() {
                return UserInfo.getInstance().getLoginUserInfo().getUid();
            }

            public void c(Context context) {
                MyGroupFragmentNew.f19077a.a(context, null);
            }

            public boolean d() {
                return BluedHttpUrl.h();
            }

            public String e() {
                return BluedHttpUrl.q();
            }

            public String f() {
                return BluedHttpUrl.r();
            }

            public Application g() {
                return BluedApplication.getInstance();
            }

            public String h() {
                return "https://www.blued.cn/live/agreement";
            }

            public String i() {
                return H5Url.a(59);
            }

            public String j() {
                return LoginRegisterTools.b();
            }

            public boolean k() {
                return DeviceUtils.f();
            }

            public boolean l() {
                return LiveFloatManager.a().x();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UserRelationshipUtils.IAddOrRemoveAttentionDone b(final LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone) {
        return new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.yy_room.YYRoomInfoChannel.2
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.Q_();
                }
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.a(str);
                }
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.c();
                }
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.b(str);
                }
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
                LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone2 = iAddOrRemoveAttentionDone;
                if (iAddOrRemoveAttentionDone2 != null) {
                    iAddOrRemoveAttentionDone2.d();
                }
            }
        };
    }
}

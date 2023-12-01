package com.blued.android.module.yy_china.manager;

import android.text.TextUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.im.biz.AudioChatroom;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.BlindMatchUserModel;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.ChatVoicePatternModel;
import com.blued.android.module.yy_china.model.ChatroomMIcBeansModel;
import com.blued.android.module.yy_china.model.ConfessedIMMode;
import com.blued.android.module.yy_china.model.DoublePeopleNoticeImNode;
import com.blued.android.module.yy_china.model.IMJsonContents100Model;
import com.blued.android.module.yy_china.model.IMJsonContents104Model;
import com.blued.android.module.yy_china.model.IMJsonContents108Model;
import com.blued.android.module.yy_china.model.IMJsonContents109Model;
import com.blued.android.module.yy_china.model.IMJsonContents110Model;
import com.blued.android.module.yy_china.model.IMJsonContents95Model;
import com.blued.android.module.yy_china.model.IMJsonContents96Model;
import com.blued.android.module.yy_china.model.IMJsonContents97Model;
import com.blued.android.module.yy_china.model.IMJsonContents98Model;
import com.blued.android.module.yy_china.model.IMTopicSetInfoContentMode;
import com.blued.android.module.yy_china.model.IMTopicSetInfoMode;
import com.blued.android.module.yy_china.model.LuckGiftModel;
import com.blued.android.module.yy_china.model.TopicSetInfoMode;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYBannerRankModel;
import com.blued.android.module.yy_china.model.YYBorImJsonMode;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYClubLevelInfoModel;
import com.blued.android.module.yy_china.model.YYFansGroupModel;
import com.blued.android.module.yy_china.model.YYFansStatusExtra;
import com.blued.android.module.yy_china.model.YYFirstMeetImMessMode;
import com.blued.android.module.yy_china.model.YYGiftBeansModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftsAndUsersMode;
import com.blued.android.module.yy_china.model.YYGlobalMsgModel;
import com.blued.android.module.yy_china.model.YYHostUpMode;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYKtvStageModel;
import com.blued.android.module.yy_china.model.YYMsgAnimationExtra;
import com.blued.android.module.yy_china.model.YYMsgAuctionLevelExtra;
import com.blued.android.module.yy_china.model.YYMsgAudienceCountExtra;
import com.blued.android.module.yy_china.model.YYMsgBlindPublishExtra;
import com.blued.android.module.yy_china.model.YYMsgBlindResultExtra;
import com.blued.android.module.yy_china.model.YYMsgEmojiExtra;
import com.blued.android.module.yy_china.model.YYMsgGameExtra;
import com.blued.android.module.yy_china.model.YYMsgGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgIntimacyExtra;
import com.blued.android.module.yy_china.model.YYMsgJsonGiftExtra;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYMsgKtvPrize;
import com.blued.android.module.yy_china.model.YYMsgKtvSinger;
import com.blued.android.module.yy_china.model.YYMsgMicStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgMuteStatusExtra;
import com.blued.android.module.yy_china.model.YYMsgNoAnchorModel;
import com.blued.android.module.yy_china.model.YYMsgOfficeExtra;
import com.blued.android.module.yy_china.model.YYMsgRoomNameExtra;
import com.blued.android.module.yy_china.model.YYMsgSaleFlowExtra;
import com.blued.android.module.yy_china.model.YYMsgSeatExtra;
import com.blued.android.module.yy_china.model.YYMsgUpSeatExtra;
import com.blued.android.module.yy_china.model.YYMsgUpdateMemberExtra;
import com.blued.android.module.yy_china.model.YYMsgUpdateUserList;
import com.blued.android.module.yy_china.model.YYMsgVipMatchExtra;
import com.blued.android.module.yy_china.model.YYMsgVoteStartExtra;
import com.blued.android.module.yy_china.model.YYMsgWaittingExtra;
import com.blued.android.module.yy_china.model.YYMsgWishListModel;
import com.blued.android.module.yy_china.model.YYMusicMode;
import com.blued.android.module.yy_china.model.YYPackGiftIMMode;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPreciousPackageModel;
import com.blued.android.module.yy_china.model.YYRelationShipRoomImMode;
import com.blued.android.module.yy_china.model.YYRelationShipSuccessImMode;
import com.blued.android.module.yy_china.model.YYRoomIm99Mode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYRoomPkConnectionExtra;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.YYUsersMode;
import com.blued.android.module.yy_china.model.YyImSong1MlateTogiftModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.im.audio_chatroom.AudioMsgType;
import com.google.gson.JsonSyntaxException;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYImMsgManager.class */
public class YYImMsgManager {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYImMsgManager$IMMsgManager.class */
    public static class IMMsgManager {
        private static YYImMsgManager a = new YYImMsgManager();

        private IMMsgManager() {
        }
    }

    private YYImMsgManager() {
    }

    public static YYImMsgManager a() {
        return IMMsgManager.a;
    }

    private void a(YYRoomModel yYRoomModel) {
        if (yYRoomModel != null && yYRoomModel.music != null && TextUtils.equals(YYRoomInfoManager.e().k(), yYRoomModel.music.uid)) {
            AudioChannelManager.j().d(4443);
            AudioChannelManager.j().d(4444);
        }
        if (yYRoomModel != null) {
            yYRoomModel.music = null;
        }
    }

    private void a(YYRoomModel yYRoomModel, YYSeatMemberModel yYSeatMemberModel, int i, List<YYSeatMemberModel> list) {
        if (!TextUtils.equals(yYRoomModel.chat_type, "4")) {
            yYSeatMemberModel.itemType = 0;
            return;
        }
        if (i == 0) {
            yYSeatMemberModel.itemType = 2;
        } else if (i == 1) {
            yYSeatMemberModel.itemType = 3;
        } else {
            yYSeatMemberModel.itemType = 0;
        }
        YYSeatMemberModel yYSeatMemberModel2 = new YYSeatMemberModel();
        yYSeatMemberModel2.setUid(yYSeatMemberModel.getUid());
        yYSeatMemberModel2.gift_value = yYSeatMemberModel.gift_value;
        list.add(yYSeatMemberModel2);
    }

    private void a(List<YYSeatMemberModel> list, List<YYSeatMemberModel> list2) {
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return;
        }
        Collections.sort(list2, new Comparator<YYSeatMemberModel>() { // from class: com.blued.android.module.yy_china.manager.YYImMsgManager.2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(YYSeatMemberModel yYSeatMemberModel, YYSeatMemberModel yYSeatMemberModel2) {
                return StringUtils.a(yYSeatMemberModel2.gift_value, 0) - StringUtils.a(yYSeatMemberModel.gift_value, 0);
            }
        });
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < list2.size()) {
            YYSeatMemberModel yYSeatMemberModel = list2.get(i);
            LogUtils.d("onMessage", "member name --> " + yYSeatMemberModel.gift_value);
            StringBuilder sb = new StringBuilder();
            i++;
            sb.append(i);
            sb.append("");
            yYSeatMemberModel.value_order = sb.toString();
            hashMap.put(yYSeatMemberModel.getUid(), yYSeatMemberModel);
        }
        for (YYSeatMemberModel yYSeatMemberModel2 : list) {
            YYSeatMemberModel yYSeatMemberModel3 = (YYSeatMemberModel) hashMap.get(yYSeatMemberModel2.getUid());
            if (yYSeatMemberModel3 != null) {
                yYSeatMemberModel2.value_order = yYSeatMemberModel3.value_order;
            }
            LogUtils.d("onMessage", "member order --> " + yYSeatMemberModel2.value_order);
        }
    }

    private void aF(YYImModel yYImModel) {
        YYCPStepModel yYCPStepModel = (YYCPStepModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYCPStepModel.class);
        if (yYCPStepModel == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.setCPNextStep(yYCPStepModel.next_step);
            b.setCPPresentStep(yYCPStepModel.present_step);
        }
        if (yYCPStepModel.present_step == 0 && b != null && b.mics != null) {
            for (YYSeatMemberModel yYSeatMemberModel : b.mics) {
                yYSeatMemberModel.likeNum = "";
            }
        }
        yYCPStepModel.resend = yYImModel.resend;
        LiveEventBus.get("update_cp_step").post(yYCPStepModel);
    }

    private void b(int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.setAudienceCount(i);
        }
        YYObserverManager.a().a(i);
    }

    public void A(YYImModel yYImModel) {
        aF(yYImModel);
    }

    public void B(YYImModel yYImModel) {
        YYSeatMemberModel seatMember;
        YYMsgBlindPublishExtra yYMsgBlindPublishExtra = (YYMsgBlindPublishExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgBlindPublishExtra.class);
        if (yYMsgBlindPublishExtra == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.setCPNextStep(yYMsgBlindPublishExtra.next_step);
            b.setCPPresentStep(yYMsgBlindPublishExtra.present_step);
        }
        if (b != null && b.mics != null) {
            for (BlindPublishModel blindPublishModel : yYMsgBlindPublishExtra.seats) {
                if (blindPublishModel != null && (seatMember = b.getSeatMember(blindPublishModel.uid)) != null) {
                    seatMember.likeNum = blindPublishModel.choose_seat_num > 0 ? blindPublishModel.choose_seat_num + "" : "";
                }
            }
        }
        yYMsgBlindPublishExtra.resend = yYImModel.resend;
        LiveEventBus.get("show_blind_publish").post(yYMsgBlindPublishExtra);
    }

    public void C(YYImModel yYImModel) {
        YYSeatMemberModel seatMember;
        YYMsgBlindResultExtra yYMsgBlindResultExtra = (YYMsgBlindResultExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgBlindResultExtra.class);
        if (yYMsgBlindResultExtra == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.setCPNextStep(yYMsgBlindResultExtra.next_step);
            b.setCPPresentStep(yYMsgBlindResultExtra.present_step);
            if (yYMsgBlindResultExtra.seats != null && !yYMsgBlindResultExtra.seats.isEmpty()) {
                for (BlindPublishModel blindPublishModel : yYMsgBlindResultExtra.seats) {
                    if (blindPublishModel != null && (seatMember = b.getSeatMember(blindPublishModel.uid)) != null) {
                        seatMember.likeNum = blindPublishModel.choose_seat_num > 0 ? blindPublishModel.choose_seat_num + "" : "";
                    }
                }
            }
        }
        yYMsgBlindResultExtra.resend = yYImModel.resend;
        LiveEventBus.get("show_blind_result").post(yYMsgBlindResultExtra);
        if (yYMsgBlindResultExtra.match_users == null || yYMsgBlindResultExtra.match_users.isEmpty()) {
            return;
        }
        a(yYImModel);
    }

    public void D(YYImModel yYImModel) {
        YYSeatMemberModel seatMember;
        BlindMatchUserModel blindMatchUserModel = (BlindMatchUserModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), BlindMatchUserModel.class);
        if (blindMatchUserModel == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (seatMember = b.getSeatMember(blindMatchUserModel.uid)) != null) {
            String str = "";
            if (blindMatchUserModel.seat_num > 0) {
                str = blindMatchUserModel.seat_num + "";
            }
            seatMember.likeNum = str;
        }
        LiveEventBus.get("show_blind_heart").post(blindMatchUserModel);
    }

    public void E(YYImModel yYImModel) {
        LiveEventBus.get("EVENT_MARQUEE_MATCH").post((YYMsgVipMatchExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgVipMatchExtra.class));
    }

    public void F(YYImModel yYImModel) {
        YYMsgVoteStartExtra yYMsgVoteStartExtra;
        if (yYImModel == null || (yYMsgVoteStartExtra = (YYMsgVoteStartExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgVoteStartExtra.class)) == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.gift_pk_id = yYMsgVoteStartExtra.vote_id;
        }
        YYRoomInfoManager.e().b(StringUtils.a(yYMsgVoteStartExtra.vote_time, 0L));
    }

    public void G(YYImModel yYImModel) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.manager.YYImMsgManager.4
            @Override // java.lang.Runnable
            public void run() {
                YYRoomInfoManager.e().s();
                LiveEventBus.get("show_gift_pk_result").post("");
            }
        }, 300L);
    }

    public void H(YYImModel yYImModel) {
        YYMsgWishListModel yYMsgWishListModel;
        if (yYImModel == null || (yYMsgWishListModel = (YYMsgWishListModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgWishListModel.class)) == null) {
            return;
        }
        LiveEventBus.get("update_wish_gift").post(yYMsgWishListModel);
    }

    public void I(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        if (YYRoomInfoManager.e().b() != null) {
            YYMsgGameExtra yYMsgGameExtra = (YYMsgGameExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgGameExtra.class);
            if (yYMsgGameExtra == null) {
                return;
            }
            YYRoomInfoManager.e().b().game_step = yYMsgGameExtra.step;
        }
        LiveEventBus.get("show_game_step").post(yYImModel);
    }

    public void J(YYImModel yYImModel) {
        YYMsgGameExtra yYMsgGameExtra;
        if (yYImModel == null || (yYMsgGameExtra = (YYMsgGameExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgGameExtra.class)) == null) {
            return;
        }
        LiveEventBus.get("show_game_team_active_value").post(yYMsgGameExtra);
    }

    public void K(YYImModel yYImModel) {
        YYMsgUpdateMemberExtra yYMsgUpdateMemberExtra;
        if (yYImModel == null || (yYMsgUpdateMemberExtra = (YYMsgUpdateMemberExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpdateMemberExtra.class)) == null) {
            return;
        }
        LiveEventBus.get("event_game_member_status").post(yYMsgUpdateMemberExtra);
    }

    public void L(YYImModel yYImModel) {
        YYMsgSaleFlowExtra yYMsgSaleFlowExtra;
        if (yYImModel == null || (yYMsgSaleFlowExtra = (YYMsgSaleFlowExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgSaleFlowExtra.class)) == null) {
            return;
        }
        LiveEventBus.get("event_im_change_flow").post(yYMsgSaleFlowExtra);
    }

    public void M(YYImModel yYImModel) {
        YYMsgIntimacyExtra yYMsgIntimacyExtra;
        if (yYImModel == null || (yYMsgIntimacyExtra = (YYMsgIntimacyExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgIntimacyExtra.class)) == null) {
            return;
        }
        LiveEventBus.get("event_im_relation_progress").post(yYMsgIntimacyExtra);
    }

    public void N(YYImModel yYImModel) {
        YYMsgAuctionLevelExtra yYMsgAuctionLevelExtra;
        if (yYImModel == null || (yYMsgAuctionLevelExtra = (YYMsgAuctionLevelExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgAuctionLevelExtra.class)) == null) {
            return;
        }
        LiveEventBus.get("event_auction_level").post(yYMsgAuctionLevelExtra);
    }

    public void O(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null) {
            return;
        }
        LiveEventBus.get("event_confirm_mic").post(yYAudienceModel);
    }

    public void P(YYImModel yYImModel) {
        YYMsgAnimationExtra yYMsgAnimationExtra;
        if (yYImModel == null || (yYMsgAnimationExtra = (YYMsgAnimationExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgAnimationExtra.class)) == null) {
            return;
        }
        LiveEventBus.get("event_intimate_animation").post(yYMsgAnimationExtra.mp4Url);
    }

    public void Q(YYImModel yYImModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            if (b.background == null) {
                b.background = new ChatVoicePatternModel();
            }
            ChatVoicePatternModel chatVoicePatternModel = (ChatVoicePatternModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), ChatVoicePatternModel.class);
            if (chatVoicePatternModel != null) {
                b.background.setPic(chatVoicePatternModel.getPic());
                b.background.setDefault_pic(chatVoicePatternModel.getDefault_pic());
                LiveEventBus.get("notify_background").post("");
            }
        }
    }

    public void R(YYImModel yYImModel) {
        IMTopicSetInfoMode iMTopicSetInfoMode;
        if (yYImModel == null || (iMTopicSetInfoMode = (IMTopicSetInfoMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMTopicSetInfoMode.class)) == null || iMTopicSetInfoMode.getTopic() == null) {
            return;
        }
        IMTopicSetInfoContentMode iMTopicSetInfoContentMode = (IMTopicSetInfoContentMode) AppInfo.f().fromJson(iMTopicSetInfoMode.getContent(), IMTopicSetInfoContentMode.class);
        if (YYRoomInfoManager.e().b() != null) {
            YYRoomInfoManager.e().b().topic_set_info = new TopicSetInfoMode(iMTopicSetInfoMode.getRoom_id(), iMTopicSetInfoMode.getType_id(), iMTopicSetInfoMode.getTopic(), iMTopicSetInfoContentMode.getTopic_id());
        }
        LiveEventBus.get("event_solo_topic").post(iMTopicSetInfoMode.getTopic());
    }

    public void S(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
            return;
        }
        LiveEventBus.get("event_solo_auto_apply").post(yYAudienceModel.getUid());
    }

    public void T(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.soloLock = false;
        }
        LiveEventBus.get("event_solo_lock").post(false);
    }

    public void U(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        LiveEventBus.get("event_rank_list").post((YYMsgUpdateUserList) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpdateUserList.class));
    }

    public void V(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        YYMsgUpdateUserList yYMsgUpdateUserList = (YYMsgUpdateUserList) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpdateUserList.class);
        YYObserverManager.a().a(yYMsgUpdateUserList.seats);
        YYObserverManager.a().a(StringUtils.a(yYMsgUpdateUserList.user_count, 0));
    }

    public void W(YYImModel yYImModel) {
        YYGlobalMsgModel yYGlobalMsgModel;
        if (yYImModel == null || (yYGlobalMsgModel = (YYGlobalMsgModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYGlobalMsgModel.class)) == null) {
            return;
        }
        LiveEventBus.get("EVENT_PRIZE_MESSAGE").post(yYGlobalMsgModel);
    }

    public void X(YYImModel yYImModel) {
        yYImModel.type = 78;
        a(yYImModel);
    }

    public void Y(YYImModel yYImModel) {
        YYMsgKtvMusic yYMsgKtvMusic;
        if (yYImModel == null) {
            return;
        }
        YYMsgKtvSinger yYMsgKtvSinger = (YYMsgKtvSinger) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgKtvSinger.class);
        YYMsgKtvMusic yYMsgKtvMusic2 = YYRoomInfoManager.e().b().music;
        if (yYMsgKtvMusic2 == null) {
            yYMsgKtvMusic = new YYMsgKtvMusic();
            YYRoomInfoManager.e().b().music = yYMsgKtvMusic;
        } else {
            yYMsgKtvMusic = yYMsgKtvMusic2;
            if (TextUtils.equals(yYMsgKtvSinger.musicId, yYMsgKtvMusic2.musicId)) {
                yYMsgKtvMusic = yYMsgKtvMusic2;
                if (TextUtils.equals(yYMsgKtvSinger.uid, yYMsgKtvMusic2.uid)) {
                    return;
                }
            }
        }
        yYMsgKtvMusic.musicId = yYMsgKtvSinger.musicId;
        yYMsgKtvMusic.uid = yYMsgKtvSinger.uid;
        yYMsgKtvMusic.name = yYMsgKtvSinger.name;
        yYMsgKtvMusic.avatar = yYMsgKtvSinger.avatar;
        LiveEventBus.get("event_ktv_show_time").post(yYMsgKtvSinger);
    }

    public void Z(YYImModel yYImModel) {
        YYMsgKtvMusic yYMsgKtvMusic;
        if (yYImModel == null || (yYMsgKtvMusic = (YYMsgKtvMusic) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgKtvMusic.class)) == null || YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYMsgKtvMusic yYMsgKtvMusic2 = YYRoomInfoManager.e().b().music;
        YYMsgKtvMusic yYMsgKtvMusic3 = yYMsgKtvMusic2;
        if (yYMsgKtvMusic2 == null) {
            yYMsgKtvMusic3 = new YYMsgKtvMusic();
            YYRoomInfoManager.e().b().music = yYMsgKtvMusic3;
        }
        yYMsgKtvMusic3.uid = yYMsgKtvMusic.uid;
        yYMsgKtvMusic3.avatar = yYMsgKtvMusic.avatar;
        yYMsgKtvMusic3.name = yYMsgKtvMusic.name;
        yYMsgKtvMusic3.musicName = yYMsgKtvMusic.musicName;
        yYMsgKtvMusic3.musicId = yYMsgKtvMusic.musicId;
        yYMsgKtvMusic3.dynamicLyricUrl = yYMsgKtvMusic.dynamicLyricUrl;
        yYMsgKtvMusic3.coverUrl = yYMsgKtvMusic.coverUrl;
        yYMsgKtvMusic3.duration = yYMsgKtvMusic.duration;
        yYMsgKtvMusic3.staticLyricUrl = yYMsgKtvMusic.staticLyricUrl;
        yYMsgKtvMusic3.currentTime = 0L;
        LiveEventBus.get("ktv_music_start").post(yYMsgKtvMusic3);
    }

    public void a(int i) {
        LiveEventBus.get("EVENT_APPLY_CLOSE_ROOM_MESS").post(new Integer(i));
    }

    public void a(int i, YYImModel yYImModel) {
        if (i == 1) {
            a(yYImModel);
        } else {
            LiveEventBus.get("say_hello").post("");
        }
    }

    public void a(YYBannerRankModel yYBannerRankModel) {
        LiveEventBus.get("EVENT_NOTICE_ROOM_BANNER_ACTIVITY_RANK").post(yYBannerRankModel);
    }

    public void a(YYGiftModel yYGiftModel, YYSeatMemberModel yYSeatMemberModel, YYPayGoodsModel yYPayGoodsModel, boolean z) {
        a(yYGiftModel, yYSeatMemberModel, yYPayGoodsModel, z, false, null);
    }

    public void a(YYGiftModel yYGiftModel, YYSeatMemberModel yYSeatMemberModel, YYPayGoodsModel yYPayGoodsModel, boolean z, boolean z2, YYAudienceModel yYAudienceModel) {
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = AudioMsgType.MsgType.SEND_GIFT.getNumber();
        if (yYAudienceModel == null) {
            yYImModel.source_profile = c();
        } else {
            yYImModel.source_profile = yYAudienceModel;
        }
        YYAudienceModel yYAudienceModel2 = new YYAudienceModel();
        yYAudienceModel2.setUid(yYSeatMemberModel.getUid());
        yYAudienceModel2.setName(yYSeatMemberModel.getName());
        yYAudienceModel2.setAvatar(yYSeatMemberModel.getAvatar());
        yYAudienceModel2.role = yYSeatMemberModel.chat_anchor + "";
        yYImModel.target_profile = yYAudienceModel2;
        yYImModel.msgMapExtra = new HashMap<>();
        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_icon", yYGiftModel.images_static);
        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_apng", yYGiftModel.images_apng);
        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_mp4", yYGiftModel.images_mp4);
        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_id", yYGiftModel.goods_id);
        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_name", yYGiftModel.name);
        if (z) {
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_count", yYSeatMemberModel.getHit_count());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_id", yYSeatMemberModel.getHit_id());
        } else {
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_count", yYGiftModel.hit_count);
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_id", yYGiftModel.hit_id);
        }
        MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_batch", yYGiftModel.hit_batch);
        MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "beans_current", "");
        MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "is_luck_gift", yYGiftModel.is_luck_gift);
        if (yYGiftModel.is_luck_gift == 2) {
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_svga", yYGiftModel.images_mp4);
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_sign", yYGiftModel.description);
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_avatar", yYGiftModel.goodsDescribe);
        }
        if (yYGiftModel.extra != null && yYGiftModel.extra.getGoods_id() != null && !"".equals(yYGiftModel.extra.getGoods_id())) {
            yYImModel.msgMapExtra.put("extra", yYGiftModel.extra);
        }
        if (!StringUtils.b(yYPayGoodsModel.json_contents_im)) {
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "json_contents", yYPayGoodsModel.json_contents_im);
        }
        a(yYImModel);
        YYObserverManager.a().a(yYImModel, z2);
    }

    public void a(YYImModel yYImModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.addImDatas(yYImModel);
        }
    }

    public void a(YYImModel yYImModel, int i) {
        YYMsgGiftExtra yYMsgGiftExtra;
        if (yYImModel == null || i == 1 || (yYMsgGiftExtra = (YYMsgGiftExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgGiftExtra.class)) == null) {
            return;
        }
        yYMsgGiftExtra.extra = (LuckGiftModel) yYImModel.msgMapExtra.get("extra");
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.setGiftBeans(yYMsgGiftExtra.beans_current);
        }
        YYObserverManager.a().b(yYMsgGiftExtra.beans_current);
        if (!YYRoomInfoManager.e().J()) {
            YYObserverManager.a().a(yYImModel, true);
        } else if (b == null || b.mMaskedVeiledRoominfo == null) {
            YYObserverManager.a().a(yYImModel, true);
        } else {
            List<String> veiled_card_goods_id = b.mMaskedVeiledRoominfo.getVeiled_card_goods_id();
            if (veiled_card_goods_id == null || !veiled_card_goods_id.contains(yYMsgGiftExtra.gift_id)) {
                YYObserverManager.a().a(yYImModel, true);
            }
        }
        a(yYImModel);
    }

    public void a(YYImModel yYImModel, YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || b.music == null) {
            return;
        }
        yYImModel.type = 76;
        yyImSong1MlateTogiftModel.music_name = b.music.musicName;
        yyImSong1MlateTogiftModel.host_name = b.music.name;
        yyImSong1MlateTogiftModel.host_id = b.music.uid;
        yYImModel.extra = yyImSong1MlateTogiftModel;
        if (YYRoomInfoManager.e().k().equals(yyImSong1MlateTogiftModel.host_id)) {
            return;
        }
        b.music.songApplaud = yyImSong1MlateTogiftModel;
        LiveEventBus.get("EVENT_KTV_GUIDE_GIFT_APPL").post("");
        a(yYImModel);
    }

    public void a(YYImModel yYImModel, String str) {
        YYAudienceModel yYAudienceModel;
        YYUserInfo yYUserInfo;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null || (yYUserInfo = YYRoomInfoManager.e().a) == null) {
            return;
        }
        if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid()) || TextUtils.equals("2", yYUserInfo.chat_anchor) || TextUtils.equals("1", yYUserInfo.chat_anchor)) {
            if (yYUserInfo != null && TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
                yYUserInfo.mute = str;
                LiveEventBus.get("set_mute_status").post(str);
            }
            a(yYImModel);
        }
    }

    public void a(YYImModel yYImModel, final boolean z) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.manager.YYImMsgManager.3
            @Override // java.lang.Runnable
            public void run() {
                YYRoomInfoManager.e().r();
                if (z) {
                    LiveEventBus.get("show_vote_result").post("");
                }
            }
        }, 300L);
    }

    public void a(String str) {
        LiveEventBus.get("event_ktv_music_num_change").post(str);
    }

    public void a(String str, String str2) {
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = 21;
        YYMsgOfficeExtra yYMsgOfficeExtra = new YYMsgOfficeExtra();
        yYMsgOfficeExtra.title = str;
        yYMsgOfficeExtra.content = str2;
        yYImModel.setMsgExtra(AppInfo.f().toJson(yYMsgOfficeExtra));
        a(yYImModel);
    }

    public void a(String str, String str2, String str3) {
        if (str.equals(YYRoomInfoManager.e().k())) {
            YYRoomInfoManager.e().b().message_bubble_img = str2;
            YYRoomInfoManager.e().b().message_bubble_icon = str3;
        }
    }

    public void a(String str, String str2, String str3, String str4, final BaseYYStudioFragment baseYYStudioFragment) {
        String trim;
        final YYImModel yYImModel = new YYImModel();
        yYImModel.type = AudioMsgType.MsgType.TEXT.getNumber();
        String replaceAll = str3.replaceAll("\n", "");
        if (replaceAll.endsWith(" ")) {
            trim = replaceAll.trim() + " ";
        } else {
            trim = replaceAll.trim();
        }
        String str5 = trim;
        if (!TextUtils.isEmpty(str)) {
            str5 = trim;
            if (!TextUtils.isEmpty(str2)) {
                str5 = trim;
                if (!TextUtils.isEmpty(str4)) {
                    if (trim.contains(str4)) {
                        str5 = trim.replaceFirst(str4, "@(name:" + str2 + ",id:" + str + ") ");
                        StringBuilder sb = new StringBuilder();
                        sb.append("组装@ msg = ");
                        sb.append(str5);
                        Logger.e("IM msg", sb.toString());
                    } else {
                        str5 = trim;
                    }
                }
            }
        }
        yYImModel.contents = str5;
        yYImModel.source_profile = c();
        YYIMManager.a().a(str5, new AudioChatroom.OnAudioChatroomResponseListener() { // from class: com.blued.android.module.yy_china.manager.YYImMsgManager.1
            @Override // com.blued.android.module.im.biz.AudioChatroom.OnAudioChatroomResponseListener
            public void a(int i, String str6, Exception exc) {
                if (TextUtils.isEmpty(str6)) {
                    return;
                }
                ToastUtils.a(str6);
            }

            @Override // com.blued.android.module.im.biz.AudioChatroom.OnAudioChatroomResponseListener
            public void a(long j) {
                yYImModel.msg_time = j;
                YYImMsgManager.this.a(yYImModel);
                if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().clientSendMessTask == null) {
                    return;
                }
                YYRoomInfoManager.e().b().clientSendMessTask.addMessage(j, baseYYStudioFragment.getFragmentActive());
            }
        });
    }

    public void aA(YYImModel yYImModel) {
        YYPackGiftIMMode yYPackGiftIMMode;
        if (yYImModel == null || (yYPackGiftIMMode = (YYPackGiftIMMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYPackGiftIMMode.class)) == null) {
            return;
        }
        LiveEventBus.get("EVENT_PACK_GIFT").post(yYPackGiftIMMode);
        if (yYPackGiftIMMode.getFull_server_notification() != null) {
            LiveEventBus.get("EVENT_PACK_GIFT_NOTIC").postDelay(yYPackGiftIMMode, yYPackGiftIMMode.getFull_server_notification().stay_seconds * 1000);
        }
        if (StringUtils.b(yYPackGiftIMMode.getContent())) {
            return;
        }
        if (StringUtils.a(yYPackGiftIMMode.getTrigger_uid(), YYRoomInfoManager.e().k())) {
            a("", "恭喜您送出真爱全部套系礼物，已解锁真爱礼物特效、豪华全服广播、3天的礼物托盘");
            return;
        }
        a("", "恭喜" + yYPackGiftIMMode.getTrigger_name() + "送出真爱全部套系礼物，已解锁真爱礼物特效、豪华全服广播、3天的礼物托盘");
    }

    public void aB(YYImModel yYImModel) {
        a(yYImModel);
    }

    public void aC(YYImModel yYImModel) {
        YYGiftsAndUsersMode yYGiftsAndUsersMode;
        if (yYImModel == null || (yYGiftsAndUsersMode = (YYGiftsAndUsersMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYGiftsAndUsersMode.class)) == null) {
            return;
        }
        if (yYGiftsAndUsersMode.getGoods_list() != null) {
            Iterator<YYGiftModel> it = yYGiftsAndUsersMode.getGoods_list().iterator();
            while (it.hasNext()) {
                YYGiftModel next = it.next();
                if (yYGiftsAndUsersMode.getTarget_uids_info() != null) {
                    boolean z = true;
                    String str = next.json_contents;
                    Iterator<YYUsersMode> it2 = yYGiftsAndUsersMode.getTarget_uids_info().iterator();
                    while (it2.hasNext()) {
                        YYUsersMode next2 = it2.next();
                        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
                        yYSeatMemberModel.isFirstToMicsInTeam = z;
                        yYSeatMemberModel.setUid(next2.getUid());
                        yYSeatMemberModel.setName(next2.getName());
                        yYSeatMemberModel.setAvatar(next2.getAvatar());
                        yYSeatMemberModel.chat_anchor = next2.getRoom_role();
                        YYPayGoodsModel yYPayGoodsModel = new YYPayGoodsModel();
                        if (!StringUtils.b(str)) {
                            if (z) {
                                yYPayGoodsModel.json_contents_im = str;
                            } else {
                                YYMsgJsonGiftExtra yYMsgJsonGiftExtra = (YYMsgJsonGiftExtra) AppInfo.f().fromJson(str, YYMsgJsonGiftExtra.class);
                                yYMsgJsonGiftExtra.setRain_level_ani_url("");
                                yYPayGoodsModel.json_contents_im = AppInfo.f().toJson(yYMsgJsonGiftExtra);
                            }
                        }
                        yYPayGoodsModel.beans_current = new Long(yYGiftsAndUsersMode.getBeans_current()).longValue();
                        a(next, yYSeatMemberModel, yYPayGoodsModel, false, true, yYImModel.source_profile);
                        z = false;
                    }
                }
            }
        }
        YYObserverManager.a().b(yYGiftsAndUsersMode.getBeans_current());
    }

    public void aD(YYImModel yYImModel) {
        ConfessedIMMode confessedIMMode;
        if (yYImModel == null || (confessedIMMode = (ConfessedIMMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), ConfessedIMMode.class)) == null) {
            return;
        }
        if (StringUtils.a(confessedIMMode.getConfession_type(), "1")) {
            LiveEventBus.get("notify_confessed").post(confessedIMMode);
        } else if (StringUtils.a(confessedIMMode.getConfession_type(), "2")) {
            if (confessedIMMode.getConfession_info().getConfession_user() == null || !StringUtils.a(confessedIMMode.getConfession_info().getBeing_confession_user_to().getUid(), YYRoomInfoManager.e().k())) {
                return;
            }
            b(confessedIMMode.getConfession_info().getConfession_user().getName() + "告白了您，快去告白头条查看吧~ ", "1");
        } else if (StringUtils.a(confessedIMMode.getConfession_type(), "3") && confessedIMMode.getConfession_info().getConfession_user() != null && StringUtils.a(confessedIMMode.getConfession_info().getBeing_confession_user_to().getUid(), YYRoomInfoManager.e().k())) {
            b(confessedIMMode.getConfession_info().getConfession_user().getName() + "告白了您，登上了尊享告白位，快去告白头条查看吧~ ", "1");
        }
    }

    public void aE(YYImModel yYImModel) {
        DoublePeopleNoticeImNode doublePeopleNoticeImNode;
        if (yYImModel == null || (doublePeopleNoticeImNode = (DoublePeopleNoticeImNode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), DoublePeopleNoticeImNode.class)) == null || doublePeopleNoticeImNode.getFull_server_notification() == null) {
            return;
        }
        if (doublePeopleNoticeImNode.getFull_server_notification().getStay_seconds() > 0) {
            LiveEventBus.get("EVENT_SHOW_DOUBLE_PEOPLE_NOTICE").postDelay(doublePeopleNoticeImNode, doublePeopleNoticeImNode.getFull_server_notification().getStay_seconds() * 1000);
        } else {
            LiveEventBus.get("EVENT_SHOW_DOUBLE_PEOPLE_NOTICE").post(doublePeopleNoticeImNode);
        }
    }

    public void aa(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        YYMsgKtvPrize yYMsgKtvPrize = (YYMsgKtvPrize) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgKtvPrize.class);
        yYImModel.extra = yYMsgKtvPrize;
        a(yYImModel);
        a(YYRoomInfoManager.e().b());
        LiveEventBus.get("ktv_music_finish").post(yYMsgKtvPrize);
    }

    public void ab(YYImModel yYImModel) {
        YYFansStatusExtra yYFansStatusExtra;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYFansStatusExtra = (YYFansStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYFansStatusExtra.class)) == null) {
            return;
        }
        if (b.fans_group == null) {
            b.fans_group = new YYFansGroupModel();
        }
        if (b.fans_group.level == null) {
            b.fans_group.level = new YYClubLevelInfoModel();
        }
        b.fans_group.is_fans = yYFansStatusExtra.status;
        b.fans_group.level.level = yYFansStatusExtra.level;
        b.fans_group.level.name = TextUtils.isEmpty(yYFansStatusExtra.name) ? "粉丝团" : yYFansStatusExtra.name;
        b.fans_group.level.status = 1;
        if (yYFansStatusExtra.status == 1) {
            if (TextUtils.equals(b.relationship, "0")) {
                b.relationship = "1";
            } else if (TextUtils.equals(b.relationship, "2")) {
                b.relationship = "3";
            }
            if (TextUtils.equals(yYFansStatusExtra.uid, YYRoomInfoManager.e().k())) {
                ToastUtils.a("已加入主播粉丝团");
            }
        } else {
            b.fans_group.level = null;
        }
        YYObserverManager.a().a(yYFansStatusExtra.anchor_uid, b.relationship);
    }

    public void ac(YYImModel yYImModel) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || ((YYFansStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYFansStatusExtra.class)) == null) {
            return;
        }
        if (b.fans_group == null) {
            b.fans_group = new YYFansGroupModel();
        }
        b.fans_group.has_fans_group = 1;
        Observable observable = LiveEventBus.get("has_fans_group");
        observable.post(b.fans_group.has_fans_group + "");
    }

    public void ad(YYImModel yYImModel) {
        YYFansStatusExtra yYFansStatusExtra;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYFansStatusExtra = (YYFansStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYFansStatusExtra.class)) == null || !TextUtils.equals(YYRoomInfoManager.e().k(), yYFansStatusExtra.uid)) {
            return;
        }
        if (b.fans_group == null) {
            b.fans_group = new YYFansGroupModel();
        }
        if (b.fans_group.level == null) {
            b.fans_group.level = new YYClubLevelInfoModel();
        }
        b.fans_group.level.status = yYFansStatusExtra.status;
        b.fans_group.level.level = yYFansStatusExtra.level;
        b.fans_group.level.name = TextUtils.isEmpty(yYFansStatusExtra.name) ? "粉丝团" : yYFansStatusExtra.name;
        if (yYFansStatusExtra.status != 1) {
            b.fans_group.level = null;
        }
    }

    public void ae(YYImModel yYImModel) {
        YYPreciousPackageModel yYPreciousPackageModel;
        if (yYImModel == null || (yYPreciousPackageModel = (YYPreciousPackageModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYPreciousPackageModel.class)) == null) {
            return;
        }
        LiveEventBus.get("update_coin_num").post(yYPreciousPackageModel);
    }

    public void af(YYImModel yYImModel) {
        YYPreciousPackageModel yYPreciousPackageModel;
        if (yYImModel == null || (yYPreciousPackageModel = (YYPreciousPackageModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYPreciousPackageModel.class)) == null) {
            return;
        }
        LiveEventBus.get("fall_down_prize").post(yYPreciousPackageModel);
    }

    public void ag(YYImModel yYImModel) {
        YYHostUpMode yYHostUpMode;
        if (yYImModel == null || (yYHostUpMode = (YYHostUpMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYHostUpMode.class)) == null) {
            return;
        }
        LiveEventBus.get("EVENT_HOST_UP").post(yYHostUpMode);
    }

    public void ah(YYImModel yYImModel) {
        IMJsonContents95Model iMJsonContents95Model;
        if (!(yYImModel.extra instanceof IMJsonContents95Model) || (iMJsonContents95Model = (IMJsonContents95Model) yYImModel.extra) == null) {
            return;
        }
        LiveEventBus.get("EVENT_UP").post(iMJsonContents95Model);
    }

    public void ai(YYImModel yYImModel) {
        ChatroomMIcBeansModel chatroomMIcBeansModel;
        if (yYImModel == null || (chatroomMIcBeansModel = (ChatroomMIcBeansModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), ChatroomMIcBeansModel.class)) == null) {
            return;
        }
        LiveEventBus.get("show_on_beans_change").post(chatroomMIcBeansModel);
    }

    public void aj(YYImModel yYImModel) {
        YYKtvStageModel yYKtvStageModel;
        if (yYImModel == null || (yYKtvStageModel = (YYKtvStageModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYKtvStageModel.class)) == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            if (b.stage_info == null) {
                b.stage_info = yYKtvStageModel;
            } else {
                b.stage_info.status = yYKtvStageModel.status;
                b.stage_info.reach_beans = yYKtvStageModel.reach_beans;
                b.stage_info.lowest_score = yYKtvStageModel.lowest_score;
            }
        }
        LiveEventBus.get("event_ktv_stage_style").post(yYKtvStageModel);
    }

    public void ak(YYImModel yYImModel) {
        YYGiftBeansModel yYGiftBeansModel;
        if (yYImModel == null || (yYGiftBeansModel = (YYGiftBeansModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYGiftBeansModel.class)) == null) {
            return;
        }
        if (YYRoomInfoManager.e().b() != null && YYRoomInfoManager.e().b().stage_info != null) {
            int a = StringUtils.a(YYRoomInfoManager.e().b().stage_info.beans, 0);
            YYKtvStageModel yYKtvStageModel = YYRoomInfoManager.e().b().stage_info;
            yYKtvStageModel.beans = (StringUtils.a(yYGiftBeansModel.beans, 0) + a) + "";
        }
        YYObserverManager.a().a(yYGiftBeansModel);
    }

    public void al(YYImModel yYImModel) {
        YYGlobalMsgModel yYGlobalMsgModel;
        YYRoomModel b;
        if (yYImModel == null || (yYGlobalMsgModel = (YYGlobalMsgModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYGlobalMsgModel.class)) == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        if (yYGlobalMsgModel.type == 8) {
            YYRoomPkConnectionExtra yYRoomPkConnectionExtra = (YYRoomPkConnectionExtra) AppInfo.f().fromJson(yYGlobalMsgModel.body, YYRoomPkConnectionExtra.class);
            YYRoomInfoManager.e().f(yYRoomPkConnectionExtra.other_uid);
            YYRoomInfoManager.e().e(yYRoomPkConnectionExtra.other_room_id);
            if (yYRoomPkConnectionExtra.status != 1) {
                b.pk_has_connected = false;
                LiveLogUtils.a("YYImMsgManager --> disconnectOtherRoom 房间PK断开连接");
                AudioChannelManager.j().l();
            } else if (!b.pk_has_connected) {
                LiveLogUtils.a("YYImMsgManager --> connectOtherRoom 房间PK连接");
                AudioChannelManager.j().a(yYRoomPkConnectionExtra.other_room_id, yYRoomPkConnectionExtra.other_uid);
            }
        }
        if (yYGlobalMsgModel.type == 7) {
            LiveLogUtils.a("YYImMsgManager --> disconnectOtherRoom 房间PK结束");
            AudioChannelManager.j().l();
        }
        LiveEventBus.get("room_pk_message").post(yYGlobalMsgModel);
    }

    public void am(YYImModel yYImModel) {
        YYMsgNoAnchorModel yYMsgNoAnchorModel;
        if (yYImModel == null || (yYMsgNoAnchorModel = (YYMsgNoAnchorModel) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgNoAnchorModel.class)) == null) {
            return;
        }
        LiveEventBus.get("show_no_anchor_alert").post(yYMsgNoAnchorModel);
    }

    public void an(YYImModel yYImModel) {
        IMJsonContents96Model iMJsonContents96Model;
        if (yYImModel == null || (iMJsonContents96Model = (IMJsonContents96Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents96Model.class)) == null) {
            return;
        }
        LiveEventBus.get("room_activity_entrance").post(iMJsonContents96Model);
    }

    public void ao(YYImModel yYImModel) {
        IMJsonContents97Model iMJsonContents97Model;
        if (yYImModel == null || (iMJsonContents97Model = (IMJsonContents97Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents97Model.class)) == null) {
            return;
        }
        LiveEventBus.get("play_activity_animation").post(iMJsonContents97Model);
    }

    public void ap(YYImModel yYImModel) {
        IMJsonContents98Model iMJsonContents98Model;
        if (yYImModel == null || (iMJsonContents98Model = (IMJsonContents98Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents98Model.class)) == null) {
            return;
        }
        LiveEventBus.get("exploratory_period").post(iMJsonContents98Model);
    }

    public void aq(YYImModel yYImModel) {
        YYRoomModel b;
        if (yYImModel != null) {
            YYRoomIm99Mode yYRoomIm99Mode = (YYRoomIm99Mode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYRoomIm99Mode.class);
            if (StringUtils.a("speech_ripple", yYRoomIm99Mode.getType()) && (b = YYRoomInfoManager.e().b()) != null) {
                Iterator<YYSeatMemberModel> it = b.mics.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    YYSeatMemberModel next = it.next();
                    if (!StringUtils.b(next.getUid()) && yYImModel.source_profile.getUid().equals(next.getUid())) {
                        next.speech_ripple = yYRoomIm99Mode.getSpeech_ripple();
                        b.notifySeat();
                        break;
                    }
                }
            }
            if (StringUtils.a("title", yYRoomIm99Mode.getType()) && StringUtils.a(yYImModel.source_profile.getUid(), YYRoomInfoManager.e().k()) && YYRoomInfoManager.e().b() != null) {
                YYRoomInfoManager.e().b().title = yYRoomIm99Mode.getTitle();
            }
            LiveEventBus.get("EVENT_NOTI_HEARD").post(yYImModel);
        }
    }

    public void ar(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        LiveEventBus.get("show_red_package").post((IMJsonContents100Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents100Model.class));
    }

    public void as(YYImModel yYImModel) {
        YYRoomModel b;
        if (yYImModel == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        try {
            YYBorImJsonMode yYBorImJsonMode = (YYBorImJsonMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYBorImJsonMode.class);
            if (yYBorImJsonMode != null) {
                if (yYBorImJsonMode.getType() == 1 && yYBorImJsonMode.getBody() != null && yYBorImJsonMode.getBody().getStatus() == 1) {
                    b.robMus = yYBorImJsonMode.getBody().getMusicInfo();
                }
                if (yYBorImJsonMode.getType() == 3 && yYBorImJsonMode.getBody() != null) {
                    b.robMus = yYBorImJsonMode.getBody().getMusicInfo();
                }
                if (yYBorImJsonMode.getType() == 4 && yYBorImJsonMode.getBody() != null) {
                    b.robMus = yYBorImJsonMode.getBody().getMusicInfo();
                }
                if (yYBorImJsonMode.getType() == 5 && yYBorImJsonMode.getBody() != null && YYRoomInfoManager.e().i()) {
                    b.robMusics = yYBorImJsonMode.getBody().getMusicList();
                }
                if (yYBorImJsonMode.getType() == 6 && yYBorImJsonMode.getBody() != null && b.robMus != null) {
                    if (StringUtils.a(b.robMus.getUid(), YYRoomInfoManager.e().k())) {
                        a("", yYBorImJsonMode.getBody().getSource_name() + "给你爆灯了");
                    } else if (StringUtils.a(yYBorImJsonMode.getBody().getSource_uid(), YYRoomInfoManager.e().k())) {
                        a("", "你给" + yYBorImJsonMode.getBody().getTarget_name() + "爆灯了");
                    } else {
                        a("", yYBorImJsonMode.getBody().getSource_name() + "给" + yYBorImJsonMode.getBody().getTarget_name() + "爆灯了");
                    }
                }
                if (yYBorImJsonMode.getType() == 7 && yYBorImJsonMode.getBody() != null) {
                    b.robMus = yYBorImJsonMode.getBody().getMusicInfo();
                }
                if (yYBorImJsonMode.getType() == 8 && yYBorImJsonMode.getBody() != null) {
                    ToastUtils.a(yYBorImJsonMode.getBody().getResult() == 1 ? "您的点歌申请已经被通过，快去抢唱吧" : "抱歉，您的点歌申请被拒绝");
                }
                LiveEventBus.get("bor_music_ims").post(yYBorImJsonMode);
            }
        } catch (JsonSyntaxException e) {
        }
    }

    public void at(YYImModel yYImModel) {
        YYFirstMeetImMessMode yYFirstMeetImMessMode;
        if (yYImModel == null || (yYFirstMeetImMessMode = (YYFirstMeetImMessMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYFirstMeetImMessMode.class)) == null || StringUtils.a(yYFirstMeetImMessMode.getSource_uid(), YYRoomInfoManager.e().k())) {
            return;
        }
        LiveEventBus.get("show_frist_meetim").post(yYFirstMeetImMessMode);
    }

    public void au(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        IMJsonContents104Model iMJsonContents104Model = (IMJsonContents104Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents104Model.class);
        YYRoomInfoManager.e().b().setUnMaskedUserList(iMJsonContents104Model.getUids(), iMJsonContents104Model.getUid(), iMJsonContents104Model.getCountdown(), iMJsonContents104Model.getType());
    }

    public void av(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        LiveEventBus.get("relation_invited").post((YYRelationShipRoomImMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYRelationShipRoomImMode.class));
    }

    public void aw(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        yYImModel.extra = (YYRelationShipSuccessImMode) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYRelationShipSuccessImMode.class);
        yYImModel.type = -8;
        a(yYImModel);
    }

    public void ax(YYImModel yYImModel) {
        IMJsonContents108Model iMJsonContents108Model;
        if (yYImModel == null || (iMJsonContents108Model = (IMJsonContents108Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents108Model.class)) == null) {
            return;
        }
        if (iMJsonContents108Model.getType() == 1 || iMJsonContents108Model.getType() == 2) {
            a(yYImModel);
        }
        LiveEventBus.get("show_coming_event").post(iMJsonContents108Model);
    }

    public void ay(YYImModel yYImModel) {
        IMJsonContents109Model iMJsonContents109Model;
        if (yYImModel == null || (iMJsonContents109Model = (IMJsonContents109Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents109Model.class)) == null) {
            return;
        }
        LiveEventBus.get("theme_activity_gifts").post(iMJsonContents109Model);
    }

    public void az(YYImModel yYImModel) {
        IMJsonContents110Model iMJsonContents110Model;
        if (yYImModel == null || (iMJsonContents110Model = (IMJsonContents110Model) AppInfo.f().fromJson(yYImModel.getMsgExtra(), IMJsonContents110Model.class)) == null) {
            return;
        }
        YYImModel yYImModel2 = new YYImModel();
        yYImModel2.type = yYImModel.type;
        yYImModel2.target_profile = yYImModel.target_profile;
        yYImModel2.source_profile = yYImModel.source_profile;
        yYImModel2.msgMapExtra = new HashMap<>();
        MsgPackHelper.putMapValue(yYImModel2.msgMapExtra, "gift_icon", "");
        MsgPackHelper.putMapValue(yYImModel2.msgMapExtra, "gift_apng", "");
        MsgPackHelper.putMapValue(yYImModel2.msgMapExtra, "gift_mp4", iMJsonContents110Model.getUrl());
        MsgPackHelper.putMapValue(yYImModel2.msgMapExtra, "gift_id", "");
        MsgPackHelper.putMapValue(yYImModel2.msgMapExtra, "gift_name", "");
        YYObserverManager.a().a(yYImModel2, false);
    }

    public void b() {
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = -5;
        a(yYImModel);
    }

    public void b(YYImModel yYImModel) {
        if (yYImModel.target_profile == null || !TextUtils.equals(yYImModel.source_profile.getUid(), YYRoomInfoManager.e().k())) {
            a(yYImModel);
            if (YYRoomInfoManager.e().y()) {
                YYImModel yYImModel2 = new YYImModel();
                yYImModel2.type = 3;
                yYImModel2.source_profile = yYImModel.source_profile;
                a(yYImModel2);
            }
            LiveEventBus.get("add_new_user").post(yYImModel);
            YYMsgAudienceCountExtra yYMsgAudienceCountExtra = (YYMsgAudienceCountExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgAudienceCountExtra.class);
            if (yYMsgAudienceCountExtra == null) {
                return;
            }
            b(yYMsgAudienceCountExtra.auditorCount);
        }
    }

    public void b(String str) {
        LiveEventBus.get("ktv_music_mode").post(str);
    }

    public void b(String str, String str2) {
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = -9;
        YYMsgOfficeExtra yYMsgOfficeExtra = new YYMsgOfficeExtra();
        yYMsgOfficeExtra.type = str2;
        yYMsgOfficeExtra.content = str;
        yYImModel.extra = yYMsgOfficeExtra;
        a(yYImModel);
    }

    public YYAudienceModel c() {
        YYAudienceModel yYAudienceModel = new YYAudienceModel();
        yYAudienceModel.setUid(YYRoomInfoManager.e().k());
        yYAudienceModel.setName(YYRoomInfoManager.e().l());
        yYAudienceModel.setAvatar(YYRoomInfoManager.e().m());
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo != null) {
            yYAudienceModel.chat_anchor = yYUserInfo.chat_anchor;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            yYAudienceModel.setWealth_level(StringUtils.a(b.wealth_level, 0));
            yYAudienceModel.setAnchor_level(StringUtils.a(b.anchor_level, 0));
            yYAudienceModel.setEnter_effects(b.enter_effects == null ? "" : b.enter_effects);
            yYAudienceModel.setEnter_effects_forward(b.enter_effects_forward == null ? "" : b.enter_effects_forward);
            yYAudienceModel.setAvatr_frame(b.avatar_frame == null ? "" : b.avatar_frame);
            yYAudienceModel.message_bubble_icon = StringUtils.b(b.message_bubble_icon) ? "" : b.message_bubble_icon;
            yYAudienceModel.message_bubble_img = StringUtils.b(b.message_bubble_img) ? "" : b.message_bubble_img;
            yYAudienceModel.mounts_img = StringUtils.b(b.mounts_img) ? "" : b.mounts_img;
            yYAudienceModel.mounts_icon = StringUtils.b(b.mounts_icon) ? "" : b.mounts_icon;
            if (b.fans_group != null && b.fans_group.level != null) {
                yYAudienceModel.fans_group_name = b.fans_group.level.name;
                yYAudienceModel.fans_group_level = b.fans_group.level.level;
                yYAudienceModel.fans_group_status = b.fans_group.level.status;
            }
            yYAudienceModel.message_user_title = b.title;
        }
        return yYAudienceModel;
    }

    public void c(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        YYRoomModel b;
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo == null || (yYAudienceModel = yYImModel.target_profile) == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        b.removeAudienceForList(yYAudienceModel.getUid());
        YYMsgUpSeatExtra yYMsgUpSeatExtra = (YYMsgUpSeatExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpSeatExtra.class);
        if (yYMsgUpSeatExtra == null || yYMsgUpSeatExtra.seats == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = 1;
            if (i2 >= yYMsgUpSeatExtra.seats.size()) {
                break;
            }
            YYMsgSeatExtra yYMsgSeatExtra = yYMsgUpSeatExtra.seats.get(i2);
            YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
            yYSeatMemberModel.setUid(yYMsgSeatExtra.uid);
            yYSeatMemberModel.setName(yYMsgSeatExtra.name);
            yYSeatMemberModel.setAvatar(yYMsgSeatExtra.avatar);
            yYSeatMemberModel.chat_anchor = yYMsgSeatExtra.role;
            if (yYMsgSeatExtra.mute != 0) {
                i3 = 0;
            }
            yYSeatMemberModel.is_open_mic = i3;
            yYSeatMemberModel.position_status = yYMsgSeatExtra.seat_type;
            yYSeatMemberModel.mic_position = yYMsgSeatExtra.mic_position;
            yYSeatMemberModel.publish_url = yYMsgSeatExtra.push_url;
            yYSeatMemberModel.captain = yYMsgSeatExtra.captain;
            yYSeatMemberModel.gift_value = yYMsgSeatExtra.gift_value;
            yYSeatMemberModel.team_num = yYMsgSeatExtra.team_num;
            yYSeatMemberModel.election = yYMsgSeatExtra.election;
            yYSeatMemberModel.wealth_level = yYMsgSeatExtra.wealth_level;
            yYSeatMemberModel.avatar_frame = yYMsgSeatExtra.avatr_frame;
            yYSeatMemberModel.wealth_level = yYMsgSeatExtra.wealth_level;
            yYSeatMemberModel.avatar_frame = yYMsgSeatExtra.avatr_frame;
            yYSeatMemberModel.enter_effects = yYMsgSeatExtra.enter_effects;
            yYSeatMemberModel.speech_ripple = yYMsgSeatExtra.speech_ripple;
            if (TextUtils.equals(yYMsgSeatExtra.uid, yYUserInfo.getUid())) {
                yYSeatMemberModel.setName(YYRoomInfoManager.e().l());
                yYSeatMemberModel.setAvatar(YYRoomInfoManager.e().m());
            }
            if (TextUtils.equals(yYAudienceModel.getUid(), yYMsgSeatExtra.uid)) {
                str = yYMsgSeatExtra.push_url;
            }
            a(b, yYSeatMemberModel, i2, arrayList2);
            arrayList.add(yYSeatMemberModel);
            i = i2 + 1;
        }
        if (b.isSaleChannel()) {
            a(arrayList, arrayList2);
        }
        if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
            yYUserInfo.push_url = str;
            yYUserInfo.is_mic = "1";
            yYUserInfo.is_open_mic = 1;
            YYObserverManager.a().a("1");
            YYObserverManager.a().c(yYUserInfo.is_open_mic);
            YYRoomInfoManager.e().G();
            if (yYMsgUpSeatExtra.seat_num == 0 && b != null && TextUtils.equals(b.chat_type, "9")) {
                ToastUtils.a("你已上到主持位，麦克风已开启，可以开始聊天了");
            } else {
                ToastUtils.a(String.format("你已上到%d号麦位，麦克风已开启，可以开始聊天了", Integer.valueOf(yYMsgUpSeatExtra.seat_num)));
            }
        }
        if (YYRoomInfoManager.e().y() && yYAudienceModel != null) {
            AudioChannelManager.j().a(yYAudienceModel.getUid(), 100);
        }
        b.setSeatList(arrayList);
        a(yYImModel);
        b(yYMsgUpSeatExtra.auditor_count);
    }

    public void c(String str) {
        YYMusicMode yYMusicMode;
        if (StringUtils.b(str) || (yYMusicMode = (YYMusicMode) AppInfo.f().fromJson(str, YYMusicMode.class)) == null) {
            return;
        }
        if (YYRoomInfoManager.e().b() != null) {
            YYRoomInfoManager.e().b().music_info = str;
        }
        if (yYMusicMode.type == 0) {
            LiveEventBus.get("EVENT_ROOM_MUSIC").post(yYMusicMode);
        }
    }

    public void c(String str, String str2) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            Iterator<YYSeatMemberModel> it = b.mics.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                YYSeatMemberModel next = it.next();
                if (!StringUtils.b(next.getUid()) && str.equals(next.getUid())) {
                    next.avatar_frame = str2;
                    b.notifySeat();
                    break;
                }
            }
        }
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = 55;
        yYImModel.contents = str;
        yYImModel.setMsgExtra(str2);
        LiveEventBus.get("EVENT_NOTI_HEARD").post(yYImModel);
    }

    public void d() {
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().chat_room_list_stealth != 1) {
            YYImModel yYImModel = new YYImModel();
            yYImModel.type = 2;
            yYImModel.source_profile = c();
            a(yYImModel);
            return;
        }
        YYImMsgManager a = a();
        a.a("", YYRoomInfoManager.e().l() + "隐身进入聊天室");
    }

    public void d(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        YYMsgUpSeatExtra yYMsgUpSeatExtra;
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo == null || (yYAudienceModel = yYImModel.target_profile) == null) {
            return;
        }
        if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
            yYUserInfo.is_mic = "0";
            yYUserInfo.is_open_mic = 0;
            yYAudienceModel.setAvatar(YYRoomInfoManager.e().m());
            yYAudienceModel.setName(YYRoomInfoManager.e().l());
            YYObserverManager.a().a("0");
            LiveEventBus.get("show_music_close").post("");
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || (yYMsgUpSeatExtra = (YYMsgUpSeatExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgUpSeatExtra.class)) == null || yYMsgUpSeatExtra.seats == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= yYMsgUpSeatExtra.seats.size()) {
                break;
            }
            YYMsgSeatExtra yYMsgSeatExtra = yYMsgUpSeatExtra.seats.get(i2);
            YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
            yYSeatMemberModel.setUid(yYMsgSeatExtra.uid);
            yYSeatMemberModel.setName(yYMsgSeatExtra.name);
            yYSeatMemberModel.setAvatar(yYMsgSeatExtra.avatar);
            yYSeatMemberModel.chat_anchor = yYMsgSeatExtra.role;
            yYSeatMemberModel.is_open_mic = yYMsgSeatExtra.mute == 0 ? 1 : 0;
            yYSeatMemberModel.position_status = yYMsgSeatExtra.seat_type;
            yYSeatMemberModel.mic_position = yYMsgSeatExtra.mic_position;
            yYSeatMemberModel.captain = yYMsgSeatExtra.captain;
            yYSeatMemberModel.gift_value = yYMsgSeatExtra.gift_value;
            yYSeatMemberModel.team_num = yYMsgSeatExtra.team_num;
            yYSeatMemberModel.election = yYMsgSeatExtra.election;
            yYSeatMemberModel.wealth_level = yYMsgSeatExtra.wealth_level;
            yYSeatMemberModel.avatar_frame = yYMsgSeatExtra.avatr_frame;
            yYSeatMemberModel.enter_effects = yYMsgSeatExtra.enter_effects;
            yYSeatMemberModel.speech_ripple = yYMsgSeatExtra.speech_ripple;
            a(b, yYSeatMemberModel, i2, arrayList2);
            arrayList.add(yYSeatMemberModel);
            i = i2 + 1;
        }
        if (b.isSaleChannel()) {
            a(arrayList, arrayList2);
        }
        b.setSeatList(arrayList);
        b(yYMsgUpSeatExtra.auditor_count);
        if (yYMsgUpSeatExtra.leave_type == 0) {
            if (yYMsgUpSeatExtra.leave_type == 2) {
                LiveEventBus.get("down_seat_msg").post(yYAudienceModel);
                return;
            }
            return;
        }
        LiveEventBus.get("down_seat_msg").post(yYAudienceModel);
        if (yYMsgUpSeatExtra.leave_type != 3 || yYImModel.source_profile == null || yYImModel.target_profile == null || yYImModel.source_profile.getUid() == null || !yYImModel.source_profile.getUid().equals(yYImModel.target_profile.getUid())) {
            a(yYImModel);
        }
    }

    public void e() {
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().chat_room_list_stealth != 1) {
            YYImModel yYImModel = new YYImModel();
            yYImModel.type = 2;
            yYImModel.source_profile = c();
            LiveEventBus.get("add_new_user").post(yYImModel);
        }
    }

    public void e(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo == null || (yYAudienceModel = yYImModel.target_profile) == null || !TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
            return;
        }
        LiveEventBus.get("invite_seat_msg").post(yYImModel);
    }

    public void f() {
    }

    public void f(YYImModel yYImModel) {
        a(yYImModel);
    }

    public void g() {
        YYImModel yYImModel = new YYImModel();
        yYImModel.type = 59;
        yYImModel.source_profile = c();
        YYAudienceModel yYAudienceModel = new YYAudienceModel();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        yYAudienceModel.setUid(b.uid);
        yYAudienceModel.setName(b.name);
        yYAudienceModel.setAvatar(b.avatar);
        yYAudienceModel.role = b.chat_anchor;
        yYImModel.target_profile = yYAudienceModel;
        yYImModel.msgMapExtra = new HashMap<>();
        a(yYImModel);
    }

    public void g(YYImModel yYImModel) {
        YYRoomModel b;
        YYMsgMuteStatusExtra yYMsgMuteStatusExtra;
        if (yYImModel == null || (b = YYRoomInfoManager.e().b()) == null || (yYMsgMuteStatusExtra = (YYMsgMuteStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgMuteStatusExtra.class)) == null) {
            return;
        }
        b.updateMicStatus(yYMsgMuteStatusExtra.uid, yYMsgMuteStatusExtra.mute == 0 ? 1 : 0);
        YYAudienceModel yYAudienceModel = yYImModel.source_profile;
        YYAudienceModel yYAudienceModel2 = yYImModel.target_profile;
        if (!TextUtils.equals(yYAudienceModel.getUid(), yYAudienceModel2.getUid()) && !TextUtils.equals(b.uid, yYAudienceModel2.getUid()) && (!"10".equals(b.chat_type) || YYRoomInfoManager.e().L() == null || !YYRoomInfoManager.e().L().b())) {
            a(yYImModel);
        }
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        if (yYUserInfo != null && TextUtils.equals(yYUserInfo.getUid(), yYMsgMuteStatusExtra.uid)) {
            int i = yYMsgMuteStatusExtra.mute == 0 ? 1 : 0;
            if (i == 0) {
                AudioChannelManager.j().a(true);
            } else {
                AudioChannelManager.j().a(false);
            }
            YYObserverManager.a().c(i);
        }
    }

    public void h() {
        LiveEventBus.get("event_ktv_show_applaud").post("");
    }

    public void h(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        YYMsgMicStatusExtra yYMsgMicStatusExtra = (YYMsgMicStatusExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgMicStatusExtra.class);
        YYObserverManager.a().a(yYMsgMicStatusExtra.seat_num, yYMsgMicStatusExtra.seat_close);
        a(yYImModel);
    }

    public void i() {
        a(YYRoomInfoManager.e().b());
        LiveEventBus.get("ktv_music_end").post("");
    }

    public void i(YYImModel yYImModel) {
        YYRoomModel b;
        YYAudienceModel yYAudienceModel;
        if (yYImModel == null || (b = YYRoomInfoManager.e().b()) == null || (yYAudienceModel = yYImModel.source_profile) == null) {
            return;
        }
        b.removeSeatMember(yYAudienceModel.getUid());
        b.removeAudienceForList(yYAudienceModel.getUid());
        YYMsgAudienceCountExtra yYMsgAudienceCountExtra = (YYMsgAudienceCountExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgAudienceCountExtra.class);
        if (yYMsgAudienceCountExtra == null) {
            return;
        }
        b(yYMsgAudienceCountExtra.auditorCount);
    }

    public void j() {
        LiveEventBus.get("to_take_off_mask").post("");
    }

    public void j(YYImModel yYImModel) {
        YYRoomModel b;
        YYUserInfo yYUserInfo;
        YYAudienceModel yYAudienceModel;
        if (yYImModel == null || (b = YYRoomInfoManager.e().b()) == null || (yYUserInfo = YYRoomInfoManager.e().a) == null || (yYAudienceModel = yYImModel.target_profile) == null) {
            return;
        }
        if (TextUtils.equals(yYAudienceModel.getUid(), yYUserInfo.getUid())) {
            YYMsgKickInfoExtra yYMsgKickInfoExtra = new YYMsgKickInfoExtra();
            yYMsgKickInfoExtra.source_profile = yYImModel.source_profile;
            LiveEventBus.get("close_living_room").post(yYMsgKickInfoExtra);
            AudioChannelManager.j().c();
            return;
        }
        a(yYImModel);
        b.removeSeatMember(yYAudienceModel.getUid());
        b.removeAudienceForList(yYAudienceModel.getUid());
        YYMsgAudienceCountExtra yYMsgAudienceCountExtra = (YYMsgAudienceCountExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgAudienceCountExtra.class);
        if (yYMsgAudienceCountExtra == null) {
            return;
        }
        b(yYMsgAudienceCountExtra.auditorCount);
    }

    public void k(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        LiveEventBus.get("close_living_room").post((YYMsgKickInfoExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgKickInfoExtra.class));
        AudioChannelManager.j().c();
    }

    public void l(YYImModel yYImModel) {
        YYMsgWaittingExtra yYMsgWaittingExtra;
        if (yYImModel == null || (yYMsgWaittingExtra = (YYMsgWaittingExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgWaittingExtra.class)) == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.setWaittingCount(yYMsgWaittingExtra.apply_count);
        }
        YYObserverManager.a().b(yYMsgWaittingExtra.apply_count);
        if (yYMsgWaittingExtra.apply_status == 0) {
            a(yYImModel);
        }
    }

    public void m(YYImModel yYImModel) {
        YYRoomModel b;
        if (yYImModel == null || (b = YYRoomInfoManager.e().b()) == null) {
            return;
        }
        YYMsgRoomNameExtra yYMsgRoomNameExtra = (YYMsgRoomNameExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgRoomNameExtra.class);
        b.room_name = yYMsgRoomNameExtra.room_name;
        LiveEventBus.get("notify_room_rename").post(yYMsgRoomNameExtra.room_name);
    }

    public void n(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        LiveEventBus.get("notify_alert_message").post(yYImModel);
    }

    public void o(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null) {
            return;
        }
        LiveEventBus.get("set_manager_msg").post(yYAudienceModel);
        a(yYImModel);
    }

    public void p(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        YYRoomModel b;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null || (b = YYRoomInfoManager.e().b()) == null || !TextUtils.equals(b.uid, yYAudienceModel.getUid())) {
            return;
        }
        a(yYImModel);
    }

    public void q(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null || !TextUtils.equals(yYAudienceModel.getUid(), YYRoomInfoManager.e().k())) {
            return;
        }
        LiveEventBus.get("late_accept_msg").post("");
    }

    public void r(YYImModel yYImModel) {
        YYAudienceModel yYAudienceModel;
        YYRoomModel b;
        YYAudienceModel yYAudienceModel2;
        if (yYImModel == null || (yYAudienceModel = yYImModel.target_profile) == null || (b = YYRoomInfoManager.e().b()) == null || !TextUtils.equals(yYAudienceModel.getUid(), b.uid) || (yYAudienceModel2 = yYImModel.source_profile) == null) {
            return;
        }
        LiveEventBus.get("late_reject_msg").post(yYAudienceModel2.getName());
    }

    public void s(YYImModel yYImModel) {
        if (yYImModel == null) {
            return;
        }
        LiveEventBus.get("send_apply_reject").post("");
        a(yYImModel);
    }

    public void t(YYImModel yYImModel) {
        a(yYImModel);
    }

    public void u(YYImModel yYImModel) {
        LiveEventBus.get("display_emoji_image").post(yYImModel);
    }

    public void v(YYImModel yYImModel) {
        YYMsgEmojiExtra yYMsgEmojiExtra = (YYMsgEmojiExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgEmojiExtra.class);
        if (yYMsgEmojiExtra == null || TextUtils.isEmpty(yYMsgEmojiExtra.result)) {
            return;
        }
        a(yYImModel);
    }

    public void w(YYImModel yYImModel) {
        LiveEventBus.get("EVENT_MARQUEE_GIFT").post(yYImModel);
    }

    public void x(YYImModel yYImModel) {
        YYMsgVoteStartExtra yYMsgVoteStartExtra = (YYMsgVoteStartExtra) AppInfo.f().fromJson(yYImModel.getMsgExtra(), YYMsgVoteStartExtra.class);
        if (yYMsgVoteStartExtra == null) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b.vote_id = yYMsgVoteStartExtra.vote_id;
        }
        YYRoomInfoManager.e().a(StringUtils.a(yYMsgVoteStartExtra.vote_time, 0L));
    }

    public void y(YYImModel yYImModel) {
        aF(yYImModel);
    }

    public void z(YYImModel yYImModel) {
        aF(yYImModel);
    }
}

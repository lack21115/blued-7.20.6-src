package com.blued.android.module.yy_china.manager;

import android.text.TextUtils;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.common.c.d;
import com.anythink.core.common.c.g;
import com.anythink.core.common.l;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.AudioChatroom;
import com.blued.android.module.im.grpc.OnConnectStateListener;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.IMJsonContents95Model;
import com.blued.android.module.yy_china.model.LuckGiftModel;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYBannerRankModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomBasicPropItemMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.model.YyImSong1MlateTogiftModel;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.im.audio_chatroom.AudioChatroomOuterClass;
import com.blued.im.audio_chatroom.AudioMsgExtra;
import com.blued.im.audio_chatroom.AudioMsgType;
import com.google.protobuf.Any;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYIMManager.class */
public class YYIMManager implements OnConnectStateListener {
    public static YYIMManager a;

    private YYIMManager() {
    }

    public static YYIMManager a() {
        if (a == null) {
            a = new YYIMManager();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AudioChatroomOuterClass.Receive receive, YYImModel yYImModel) {
        AudioMsgExtra.KtvAccompany accompany;
        AudioMsgExtra.KtvMusicNum musicNum;
        if (receive.getMsgType() == AudioMsgType.MsgType.TEXT) {
            YYImMsgManager.a().a(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.JOIN_ROOM) {
            AudioMsgExtra.JoinRoom joinRoomExtra = receive.getExtra().getJoinRoomExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "auditorCount", joinRoomExtra.getAuditorCount());
            if (joinRoomExtra.getMounts() != null && !StringUtils.b(joinRoomExtra.getMounts().getImg())) {
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "mounts_img", joinRoomExtra.getMounts().getImg());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "mounts_icon", joinRoomExtra.getMounts().getIcon());
                yYImModel.source_profile.mounts_img = joinRoomExtra.getMounts().getImg();
                yYImModel.source_profile.mounts_icon = joinRoomExtra.getMounts().getIcon();
            }
            YYImMsgManager.a().b(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.QUIT_ROOM) {
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "auditorCount", receive.getExtra().getQuitRoomExtra().getAuditorCount());
            YYImMsgManager.a().i(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.CLOSE_ROOM) {
            AudioMsgExtra.CloseRoom closeRoomExtra = receive.getExtra().getCloseRoomExtra();
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "title", closeRoomExtra.getKickInfo().getTitle());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "message", closeRoomExtra.getKickInfo().getMessage());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "audience_message", closeRoomExtra.getKickInfo().getAudienceMessage());
            YYImMsgManager.a().k(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.SEND_GIFT) {
            AudioMsgExtra.SendGift sendGiftExtra = receive.getExtra().getSendGiftExtra();
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_icon", sendGiftExtra.getGiftIcon());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_apng", sendGiftExtra.getGiftApng());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_mp4", sendGiftExtra.getGiftMp4());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "gift_type", sendGiftExtra.getGiftType());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "gift_id", sendGiftExtra.getGiftId());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_count", sendGiftExtra.getHitCount());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_id", sendGiftExtra.getHitId());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "hit_batch", sendGiftExtra.getHitBatch());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "beans_current", sendGiftExtra.getBeansCurrent());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "is_luck_gift", sendGiftExtra.getIsLuckGift());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_name", sendGiftExtra.getGiftName());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_svga", sendGiftExtra.getGiftSvga());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_sign", sendGiftExtra.getGiftSign());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "gift_avatar", sendGiftExtra.getGiftAvatar());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "json_contents", sendGiftExtra.getJsonContents());
            int sendGiftWay = sendGiftExtra.getSendGiftWay();
            if (sendGiftExtra.getLuckGiftInfo() != null && sendGiftExtra.getLuckGiftInfo().getImagesStatic() != null && !"".equals(sendGiftExtra.getLuckGiftInfo().getImagesStatic())) {
                LuckGiftModel luckGiftModel = new LuckGiftModel();
                luckGiftModel.setGoods_id(sendGiftExtra.getLuckGiftInfo().getGoodsId() + "");
                luckGiftModel.setImages_apng(sendGiftExtra.getLuckGiftInfo().getImagesApng());
                luckGiftModel.setImages_gif(sendGiftExtra.getLuckGiftInfo().getImagesGif());
                luckGiftModel.setImages_mp4(sendGiftExtra.getLuckGiftInfo().getImagesMp4());
                luckGiftModel.setImages_static(sendGiftExtra.getLuckGiftInfo().getImagesStatic());
                luckGiftModel.setName(sendGiftExtra.getLuckGiftInfo().getName());
                yYImModel.msgMapExtra.put("extra", luckGiftModel);
            }
            YYImMsgManager.a().a(yYImModel, sendGiftWay);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.ALERT_ROOM) {
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "warning_type", receive.getExtra().getAlertRoomExtra().getAlertType());
            YYImMsgManager.a().n(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.FOLLOW_NOTICE) {
            YYImMsgManager.a().p(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.SET_MANAGER) {
            YYImMsgManager.a().o(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.CANCLE_MANAGER) {
            YYImMsgManager.a().o(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.MUTE) {
            YYImMsgManager.a().a(yYImModel, "1");
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UNMUTE) {
            YYImMsgManager.a().a(yYImModel, "0");
        } else if (receive.getMsgType() == AudioMsgType.MsgType.INVITE_UP_SEAT) {
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "position", receive.getExtra().getMicInfo().getPosition());
            YYImMsgManager.a().e(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.REFUSE_INVITE) {
            YYImMsgManager.a().r(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UP_SEAT_SUCCESS) {
            AudioMsgExtra.UpSeatSuccess upSeatSuccessExtra = receive.getExtra().getUpSeatSuccessExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "room_id", upSeatSuccessExtra.getRoomId());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM, upSeatSuccessExtra.getSeatNum());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "auditor_count", upSeatSuccessExtra.getAuditorCount());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < upSeatSuccessExtra.getSeatsList().size(); i++) {
                AudioMsgExtra.Seat seats = upSeatSuccessExtra.getSeats(i);
                HashMap hashMap = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "uid", seats.getUid());
                MsgPackHelper.putMapValue(hashMap, "name", seats.getName());
                MsgPackHelper.putMapValue(hashMap, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, seats.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "role", seats.getRoleValue());
                MsgPackHelper.putMapValue(hashMap, "user_sig", seats.getUserSig());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "mute", seats.getMute());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "seat_type", seats.getSeatType());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "mic_position", seats.getMicPosition());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "captain", seats.getCaptain());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "team_num", seats.getTeamNum());
                MsgPackHelper.putMapValue(hashMap, "gift_value", seats.getGiftValue());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "election", seats.getElection());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "wealth_level", seats.getWealthLevel());
                MsgPackHelper.putMapValue(hashMap, "avatr_frame", seats.getAvatarFrame());
                MsgPackHelper.putMapValue(hashMap, "enter_effects", seats.getEnterEffects());
                if (seats.getSpeechRipple() != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("img", seats.getSpeechRipple().getImg());
                    hashMap2.put(ReqAckPackage.REQ_RESPONSE_KEY.ICON, seats.getSpeechRipple().getIcon());
                    hashMap.put("speech_ripple", hashMap2);
                }
                if (i != 0 && upSeatSuccessExtra.getSeats(i).getMicPosition() == 0) {
                    MsgPackHelper.putMapValue((Map<String, Object>) hashMap, "mic_position", i);
                }
                MsgPackHelper.putMapValue(hashMap, "push_url", upSeatSuccessExtra.getSeats(i).getPublishUrl());
                arrayList.add(hashMap);
            }
            yYImModel.msgMapExtra.put("seats", arrayList);
            YYImMsgManager.a().c(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.LEAVE_SEAT) {
            AudioMsgExtra.LeaveSeat leaveSeatExtra = receive.getExtra().getLeaveSeatExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "room_id", leaveSeatExtra.getRoomId());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM, leaveSeatExtra.getSeatNum());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "leave_type", leaveSeatExtra.getLeaveType());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "auditor_count", leaveSeatExtra.getAuditorCount());
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < leaveSeatExtra.getSeatsList().size(); i2++) {
                AudioMsgExtra.Seat seats2 = leaveSeatExtra.getSeats(i2);
                HashMap hashMap3 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "uid", seats2.getUid());
                MsgPackHelper.putMapValue(hashMap3, "name", seats2.getName());
                MsgPackHelper.putMapValue(hashMap3, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, seats2.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "role", seats2.getRoleValue());
                MsgPackHelper.putMapValue(hashMap3, "user_sig", seats2.getUserSig());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "mute", seats2.getMute());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "seat_type", seats2.getSeatType());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "mic_position", seats2.getMicPosition());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "captain", seats2.getCaptain());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "team_num", seats2.getTeamNum());
                MsgPackHelper.putMapValue(hashMap3, "gift_value", seats2.getGiftValue());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "election", seats2.getElection());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "wealth_level", seats2.getWealthLevel());
                MsgPackHelper.putMapValue(hashMap3, "avatr_frame", seats2.getAvatarFrame());
                MsgPackHelper.putMapValue(hashMap3, "enter_effects", seats2.getEnterEffects());
                if (seats2.getSpeechRipple() != null) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("img", seats2.getSpeechRipple().getImg());
                    hashMap4.put(ReqAckPackage.REQ_RESPONSE_KEY.ICON, seats2.getSpeechRipple().getIcon());
                    hashMap3.put("speech_ripple", hashMap4);
                }
                if (i2 != 0 && leaveSeatExtra.getSeats(i2).getMicPosition() == 0) {
                    MsgPackHelper.putMapValue((Map<String, Object>) hashMap3, "mic_position", i2);
                }
                arrayList2.add(hashMap3);
            }
            yYImModel.msgMapExtra.put("seats", arrayList2);
            YYImMsgManager.a().d(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.APPLY_UP_SEAT_COUNT) {
            AudioMsgExtra.ApplyUpSeatCount applyUpSeatCountExtra = receive.getExtra().getApplyUpSeatCountExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "apply_count", applyUpSeatCountExtra.getApplyCount());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "apply_status", applyUpSeatCountExtra.getApplyStatus());
            YYImMsgManager.a().l(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.MUTE_SEAT_STATUS) {
            AudioMsgExtra.MuteSeatStatus muteSeatStatus = receive.getExtra().getMuteSeatStatus();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", muteSeatStatus.getUid());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "mute", muteSeatStatus.getMute());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "muteType", muteSeatStatus.getMuteType());
            YYImMsgManager.a().g(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.CLOSE_SEAT_STATUS) {
            AudioMsgExtra.CloseSeatStatus closeSeatExtra = receive.getExtra().getCloseSeatExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM, closeSeatExtra.getSeatNum());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "seat_close", closeSeatExtra.getSeatClose());
            YYImMsgManager.a().h(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.KICK_ROOM) {
            YYImMsgManager.a().j(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.ROOM_NAME_INVALID) {
            YYImMsgManager.a().a(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.OFFICE_MSG) {
            AudioMsgExtra.OfficeMsg officeMsgExtra = receive.getExtra().getOfficeMsgExtra();
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "title", officeMsgExtra.getTitle());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, l.y, officeMsgExtra.getContent());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "text_color", officeMsgExtra.getTextColor());
            YYImMsgManager.a().a(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.AUDIT_NAME_PASS) {
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "room_name", receive.getExtra().getAuditNamePassExtra().getRoomName());
            YYImMsgManager.a().m(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UP_APPLY_REJECT) {
            YYImMsgManager.a().s(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.LATE_UP_SEAT_ACCEPT) {
            YYImMsgManager.a().q(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.LATE_UP_SEAT_REJECT) {
            YYImMsgManager.a().r(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.ANNOUNCEMENT) {
            YYImMsgManager.a().t(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.EMOJIMSG) {
            AudioMsgExtra.EmojiMsg emojiMsgExtra = receive.getExtra().getEmojiMsgExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "id", emojiMsgExtra.getId());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", emojiMsgExtra.getName());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "pic", emojiMsgExtra.getPic());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "apng", emojiMsgExtra.getApng());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, com.alipay.sdk.util.l.c, emojiMsgExtra.getResult());
            YYImMsgManager.a().u(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.SOUND_EFFECT) {
            YYImMsgManager.a().a(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.VOTE_START) {
            AudioMsgExtra.VoteStart voteStartExtra = receive.getExtra().getVoteStartExtra();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "vote_time", voteStartExtra.getEndTime());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "vote_id", voteStartExtra.getVoteId());
            YYImMsgManager.a().x(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.VOTE_END) {
            YYImMsgManager.a().a(yYImModel, true);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.TEXT_NO_NAME) {
            YYImMsgManager.a().a(yYImModel, false);
            YYImMsgManager.a().a(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_START) {
            AudioMsgExtra.BlindDate blindData = receive.getExtra().getBlindData();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "present_step", blindData.getPresentStep());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "next_step", blindData.getNextStep());
            YYImMsgManager.a().y(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_INTRODUCE) {
            AudioMsgExtra.BlindDate blindData2 = receive.getExtra().getBlindData();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "present_step", blindData2.getPresentStep());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "next_step", blindData2.getNextStep());
            YYImMsgManager.a().z(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_CHOOSE) {
            AudioMsgExtra.BlindDate blindData3 = receive.getExtra().getBlindData();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "present_step", blindData3.getPresentStep());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "next_step", blindData3.getNextStep());
            YYImMsgManager.a().A(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_PULISH) {
            AudioMsgExtra.BlindDatePublish blindDataPublish = receive.getExtra().getBlindDataPublish();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "present_step", blindDataPublish.getPresentStep());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "next_step", blindDataPublish.getNextStep());
            ArrayList arrayList3 = new ArrayList();
            for (AudioMsgExtra.BlindDateSeat blindDateSeat : blindDataPublish.getSeatsList()) {
                HashMap hashMap5 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap5, "uid", blindDateSeat.getUid());
                MsgPackHelper.putMapValue(hashMap5, "choose_seat_num", blindDateSeat.getChooseSeatNum());
                arrayList3.add(hashMap5);
            }
            yYImModel.msgMapExtra.put("seats", arrayList3);
            YYImMsgManager.a().B(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_OVER) {
            if (yYImModel.resend) {
                return;
            }
            AudioMsgExtra.BlindDateOver blindDataOver = receive.getExtra().getBlindDataOver();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "present_step", blindDataOver.getPresentStep());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "next_step", blindDataOver.getNextStep());
            ArrayList arrayList4 = new ArrayList();
            for (AudioMsgExtra.MatchUserPair matchUserPair : blindDataOver.getMatchUsersList()) {
                HashMap hashMap6 = new HashMap();
                AudioMsgExtra.MatchUser source = matchUserPair.getSource();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap6, "uid", source.getUid());
                MsgPackHelper.putMapValue(hashMap6, "name", source.getName());
                MsgPackHelper.putMapValue(hashMap6, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, source.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap6, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM, source.getSeatNum());
                HashMap hashMap7 = new HashMap();
                AudioMsgExtra.MatchUser target = matchUserPair.getTarget();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap7, "uid", target.getUid());
                MsgPackHelper.putMapValue(hashMap7, "name", target.getName());
                MsgPackHelper.putMapValue(hashMap7, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, target.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap7, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM, target.getSeatNum());
                HashMap hashMap8 = new HashMap();
                hashMap8.put("source", hashMap6);
                hashMap8.put("target", hashMap7);
                hashMap8.put("isVip", Integer.valueOf(matchUserPair.getIsVipMatch()));
                arrayList4.add(hashMap8);
            }
            ArrayList arrayList5 = new ArrayList();
            for (AudioMsgExtra.BlindDateSeat blindDateSeat2 : blindDataOver.getSeatsList()) {
                HashMap hashMap9 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap9, "uid", blindDateSeat2.getUid());
                MsgPackHelper.putMapValue(hashMap9, "choose_seat_num", blindDateSeat2.getChooseSeatNum());
                arrayList5.add(hashMap9);
            }
            yYImModel.msgMapExtra.put("match_users", arrayList4);
            yYImModel.msgMapExtra.put("seats", arrayList5);
            YYImMsgManager.a().C(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BLIND_DATA_HEART) {
            AudioMsgExtra.BlindDateHeartUser blindDataHeartUser = receive.getExtra().getBlindDataHeartUser();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", blindDataHeartUser.getUid());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", blindDataHeartUser.getName());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, blindDataHeartUser.getAvatar());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.SEAT_NUM, blindDataHeartUser.getSeatNum());
            YYImMsgManager.a().D(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.VIP_MARQUEE) {
            AudioMsgExtra.VipMarquee vipMarquee = receive.getExtra().getVipMarquee();
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "vip_name", vipMarquee.getVipName());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "target_name", vipMarquee.getTargetName());
            YYImMsgManager.a().E(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.START_VOTE_TIME) {
            AudioMsgExtra.StartVoteTime startVoteTime = receive.getExtra().getStartVoteTime();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "vote_time", startVoteTime.getVoteTime());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "vote_id", startVoteTime.getVoteId());
            YYImMsgManager.a().F(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.END_VOTE_TIME) {
            YYImMsgManager.a().G(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.GIFT_MARQUEE) {
            AudioMsgExtra.GiftMarquee giftMarquee = receive.getExtra().getGiftMarquee();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "send_time", giftMarquee.getSendTime());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "goods_count", giftMarquee.getGoodsCount());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "goods_image", giftMarquee.getGoodsImage());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "goods_name", giftMarquee.getGoodsName());
            YYImMsgManager.a().w(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.WISH_GIFT) {
            AudioMsgExtra.WishGift wishGift = receive.getExtra().getWishGift();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "is_complete", wishGift.getIsComplete());
            ArrayList arrayList6 = new ArrayList();
            for (AudioMsgExtra.WishGiftList wishGiftList : wishGift.getListList()) {
                HashMap hashMap10 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap10, "goods_id", wishGiftList.getGoodsId());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap10, ReqAckPackage.REQ_RESPONSE_KEY.BEANS, wishGiftList.getBeans());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap10, "wish_total", wishGiftList.getWishTotal());
                MsgPackHelper.putMapValue(hashMap10, "name", wishGiftList.getName());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap10, "wish_current", wishGiftList.getWishCurrent());
                MsgPackHelper.putMapValue(hashMap10, "images_static", wishGiftList.getImagesStatic());
                arrayList6.add(hashMap10);
            }
            yYImModel.msgMapExtra.put("list", arrayList6);
            YYImMsgManager.a().H(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.GAME_UPDATE) {
            AudioMsgExtra.GameUpdate gameUpdate = receive.getExtra().getGameUpdate();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, g.a.g, gameUpdate.getTime());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "step", gameUpdate.getStep());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "step_title", gameUpdate.getStepTitle());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "step_content", gameUpdate.getStepContent());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "active_left_value", gameUpdate.getActiveLeftValue());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "active_right_value", gameUpdate.getActiveRightValue());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "left_increase", gameUpdate.getLeftIncrease());
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "right_increase", gameUpdate.getRightIncrease());
            AudioMsgExtra.GameMember memberLeft = gameUpdate.getMemberLeft();
            if (memberLeft != null) {
                HashMap hashMap11 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap11, "uid", memberLeft.getUid());
                MsgPackHelper.putMapValue(hashMap11, "name", memberLeft.getName());
                MsgPackHelper.putMapValue(hashMap11, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, memberLeft.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap11, "team_num", memberLeft.getTeamNum());
                yYImModel.msgMapExtra.put("member_left", hashMap11);
            }
            AudioMsgExtra.GameMember memberRight = gameUpdate.getMemberRight();
            if (memberRight != null) {
                HashMap hashMap12 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap12, "uid", memberRight.getUid());
                MsgPackHelper.putMapValue(hashMap12, "name", memberRight.getName());
                MsgPackHelper.putMapValue(hashMap12, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, memberRight.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap12, "team_num", memberRight.getTeamNum());
                yYImModel.msgMapExtra.put("member_right", hashMap12);
            }
            AudioMsgExtra.GameVictory victory = gameUpdate.getVictory();
            if (victory != null) {
                HashMap hashMap13 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap13, "uid", victory.getUid());
                MsgPackHelper.putMapValue(hashMap13, "name", victory.getName());
                MsgPackHelper.putMapValue(hashMap13, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, victory.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap13, "team_num", victory.getTeamNum());
                yYImModel.msgMapExtra.put("victory", hashMap13);
            }
            YYImMsgManager.a().I(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.GAME_ACTIVE_VALUES) {
            AudioMsgExtra.GameActiveValues gameActiveValues = receive.getExtra().getGameActiveValues();
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "active_left_value", gameActiveValues.getActiveLeftValue());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "active_right_value", gameActiveValues.getActiveRightValue());
            YYImMsgManager.a().J(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UPDATE_USER_SEATS) {
            AudioMsgExtra.UpdateUserSeats updateUserSeats = receive.getExtra().getUpdateUserSeats();
            ArrayList arrayList7 = new ArrayList();
            for (AudioMsgExtra.UserSeats userSeats : updateUserSeats.getSeatsList()) {
                HashMap hashMap14 = new HashMap();
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap14, "uid", userSeats.getUid());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap14, "captain", userSeats.getCaptain());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap14, "team_num", userSeats.getTeamNum());
                MsgPackHelper.putMapValue(hashMap14, "gift_value", userSeats.getGiftValue());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap14, "election", userSeats.getElection());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap14, "value_order", userSeats.getValueOrder());
                if (userSeats.getSpeechRipple() != null) {
                    HashMap hashMap15 = new HashMap();
                    hashMap15.put("img", userSeats.getSpeechRipple().getImg());
                    hashMap15.put(ReqAckPackage.REQ_RESPONSE_KEY.ICON, userSeats.getSpeechRipple().getIcon());
                    hashMap14.put("speech_ripple", hashMap15);
                }
                arrayList7.add(hashMap14);
            }
            yYImModel.msgMapExtra.put("seats", arrayList7);
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, g.a.g, updateUserSeats.getTime());
            YYImMsgManager.a().K(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UPDATE_AUCTION) {
            AudioMsgExtra.UpdateAuction updateAuction = receive.getExtra().getUpdateAuction();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "step", updateAuction.getStep());
            AudioMsgExtra.AuctionGoods goods = updateAuction.getGoods();
            if (goods != null) {
                HashMap hashMap16 = new HashMap();
                MsgPackHelper.putMapValue(hashMap16, "goods_id", goods.getGoodsId());
                MsgPackHelper.putMapValue(hashMap16, "name", goods.getName());
                MsgPackHelper.putMapValue(hashMap16, "images_static", goods.getImagesStatic());
                MsgPackHelper.putMapValue(hashMap16, ReqAckPackage.REQ_RESPONSE_KEY.BEANS, goods.getBeans());
                yYImModel.msgMapExtra.put("goods", hashMap16);
            }
            AudioMsgExtra.AuctionRelation relation = updateAuction.getRelation();
            if (relation != null) {
                HashMap hashMap17 = new HashMap();
                MsgPackHelper.putMapValue(hashMap17, "relation_id", relation.getRelationId());
                MsgPackHelper.putMapValue(hashMap17, "name", relation.getName());
                MsgPackHelper.putMapValue(hashMap17, "images_static", relation.getImagesStatic());
                MsgPackHelper.putMapValue(hashMap17, "validity", relation.getValidity());
                yYImModel.msgMapExtra.put("relation", hashMap17);
            }
            ArrayList arrayList8 = new ArrayList();
            for (AudioMsgExtra.AuctionStageInfo auctionStageInfo : updateAuction.getStageListList()) {
                HashMap hashMap18 = new HashMap();
                MsgPackHelper.putMapValue(hashMap18, "name", auctionStageInfo.getName());
                MsgPackHelper.putMapValue(hashMap18, d.a.d, auctionStageInfo.getValue());
                arrayList8.add(hashMap18);
            }
            yYImModel.msgMapExtra.put("stage_list", arrayList8);
            YYImMsgManager.a().L(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UPDATE_INTIMACY_VAL) {
            AudioMsgExtra.UpdateIntimacyVal updateIntimacyVal = receive.getExtra().getUpdateIntimacyVal();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "current_value", updateIntimacyVal.getCurrentValue());
            ArrayList arrayList9 = new ArrayList();
            for (Integer num : updateIntimacyVal.getValueListList()) {
                arrayList9.add(num + "");
            }
            yYImModel.msgMapExtra.put("value_list", arrayList9);
            YYImMsgManager.a().M(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.AUCTIONEER_LEVEL) {
            AudioMsgExtra.AuctioneerLevel auctioneerLevel = receive.getExtra().getAuctioneerLevel();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "level", auctioneerLevel.getAuctioneerLevel());
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "level_img", auctioneerLevel.getAuctioneerAvatar());
            YYImMsgManager.a().N(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.GUEST_AUTO_FEEDING) {
            YYImMsgManager.a().O(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.FULLSCREEN_ANIMATION) {
            MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "mp4Url", receive.getExtra().getFullscreenAnimation().getAnimationInfo().getAnimationUrl());
            YYImMsgManager.a().P(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.CHATROOM_BACKGROUND) {
            if (receive.getExtra().hasChatroomBackground()) {
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "pic", receive.getExtra().getChatroomBackground().getPic());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "default_pic", receive.getExtra().getChatroomBackground().getDefaultPic());
                YYImMsgManager.a().Q(yYImModel);
            }
        } else if (receive.getMsgType() == AudioMsgType.MsgType.THEME_CHANGE) {
            YYImMsgManager.a().R(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.GIFT_ON_WHEAT) {
            YYImMsgManager.a().S(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UNLOCK_COMPANION_MIC) {
            YYImMsgManager.a().T(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.UPDATE_AVATAR_FRAME_INFO) {
            if (receive.getExtra().hasAvatarFrameInfo()) {
                YYImMsgManager.a().c(receive.getExtra().getAvatarFrameInfo().getUid(), receive.getExtra().getAvatarFrameInfo().getAvatarFrame());
            }
        } else if (receive.getMsgType() == AudioMsgType.MsgType.GIFT_LIST_CHANGE) {
            AudioMsgExtra.GiftListChange giftListChange = receive.getExtra().getGiftListChange();
            ArrayList arrayList10 = new ArrayList();
            for (AudioMsgExtra.GiftListChangeUserList giftListChangeUserList : giftListChange.getUserListList()) {
                HashMap hashMap19 = new HashMap();
                MsgPackHelper.putMapValue(hashMap19, "uid", giftListChangeUserList.getUid());
                MsgPackHelper.putMapValue(hashMap19, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, giftListChangeUserList.getAvatar());
                arrayList10.add(hashMap19);
            }
            yYImModel.msgMapExtra.put("seats", arrayList10);
            YYImMsgManager.a().U(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.VOICE_CHAT_USER) {
            AudioMsgExtra.VoiceChatUser voiceChatUser = receive.getExtra().getVoiceChatUser();
            ArrayList arrayList11 = new ArrayList();
            for (AudioMsgExtra.GiftListChangeUserList giftListChangeUserList2 : voiceChatUser.getUserListList()) {
                HashMap hashMap20 = new HashMap();
                MsgPackHelper.putMapValue(hashMap20, "uid", giftListChangeUserList2.getUid());
                MsgPackHelper.putMapValue(hashMap20, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, giftListChangeUserList2.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) hashMap20, "is_top_fans", giftListChangeUserList2.getIsTopFans());
                arrayList11.add(hashMap20);
            }
            yYImModel.msgMapExtra.put("seats", arrayList11);
            yYImModel.msgMapExtra.put("user_count", Long.valueOf(voiceChatUser.getUserCount()));
            YYImMsgManager.a().V(yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.MESSAGE_BUBBLE_INFO) {
            if (receive.getExtra().hasMessageBubbleInfo()) {
                AudioMsgExtra.MessageBubbleInfo messageBubbleInfo = receive.getExtra().getMessageBubbleInfo();
                YYImMsgManager.a().a(messageBubbleInfo.getUid(), messageBubbleInfo.getMessageBubbleImg(), messageBubbleInfo.getMessageBubbleIcon());
            }
        } else if (receive.getMsgType() == AudioMsgType.MsgType.BANTER_INFO) {
            YYImMsgManager.a().a(receive.getExtra().getBanterInfo().getIsCallback(), yYImModel);
        } else if (receive.getMsgType() == AudioMsgType.MsgType.INVALID_LIVE_WARNING) {
            AudioMsgExtra.InvalidLiveWarning invalidLiveWarning = receive.getExtra().getInvalidLiveWarning();
            MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "remind_countdown", invalidLiveWarning.getRemindCountdown());
            YYImMsgManager.a().a(invalidLiveWarning.getRemindCountdown());
        } else if (receive.getMsgType() != AudioMsgType.MsgType.PK_INFO && receive.getMsgType() != AudioMsgType.MsgType.PK_RESULT && receive.getMsgType() != AudioMsgType.MsgType.ROOM_INFO && receive.getMsgType() != AudioMsgType.MsgType.PK_OPPO && receive.getMsgType() != AudioMsgType.MsgType.PK_PROGRESS_INFO && receive.getMsgType() != AudioMsgType.MsgType.PK_MICS && receive.getMsgType() != AudioMsgType.MsgType.PK_OPPO_USER && receive.getMsgType() != AudioMsgType.MsgType.PK_SEATS_INFO) {
            if (receive.getMsgType() == AudioMsgType.MsgType.GLOBAL_MESSAGE) {
                AudioMsgExtra.GlobalMessage globalMessage = receive.getExtra().getGlobalMessage();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "type", globalMessage.getType());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "body", globalMessage.getBody());
                YYImMsgManager.a().W(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_SINGER_INFO) {
                AudioMsgExtra.KtvSingerInfo singerInfo = receive.getExtra().getSingerInfo();
                if (singerInfo == null) {
                    return;
                }
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "musicId", singerInfo.getMusicId());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, singerInfo.getAvatar());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", singerInfo.getName());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", singerInfo.getUid());
                YYImMsgManager.a().Y(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_MUSIC_INFO) {
                AudioMsgExtra.KtvMusicInfo musicInfo = receive.getExtra().getMusicInfo();
                if (musicInfo == null) {
                    return;
                }
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "duration", musicInfo.getDuration());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "musicId", musicInfo.getMusicId());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, musicInfo.getAvatar());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", musicInfo.getName());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", musicInfo.getUid());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "musicName", musicInfo.getMusicName());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "coverUrl", musicInfo.getCoverUrl());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "dynamicLyricUrl", musicInfo.getDynamicLyricUrl());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "staticLyricUrl", musicInfo.getStaticLyricUrl());
                YYImMsgManager.a().Z(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_SING_RESULT) {
                AudioMsgExtra.KtvSingResult singResult = receive.getExtra().getSingResult();
                if (singResult == null) {
                    return;
                }
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "gift", singResult.getGift());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "applause", singResult.getApplause());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, singResult.getAvatar());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", singResult.getName());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", singResult.getUid());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.BEANS, singResult.getBeans());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "score", singResult.getScore());
                YYImMsgManager.a().aa(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_MUSIC_NUM) {
                if (receive.getExtra().getMusicNum() == null) {
                    return;
                }
                YYImMsgManager.a().a(musicNum.getCount() + "");
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_ROOM_RESET) {
                YYImMsgManager.a().i();
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_ACCOMPANY) {
                if (receive.getExtra().getAccompany() == null) {
                    return;
                }
                YYImMsgManager.a().b(accompany.getType() + "");
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_GUIDE) {
                YyImSong1MlateTogiftModel yyImSong1MlateTogiftModel = new YyImSong1MlateTogiftModel();
                if (receive.getExtra().hasGuideInfo() && receive.getExtra().getGuideInfo().hasAndroidGoodsInfo()) {
                    AudioMsgExtra.GoodsInfo androidGoodsInfo = receive.getExtra().getGuideInfo().getAndroidGoodsInfo();
                    yyImSong1MlateTogiftModel.android_goods_info = new YYGiftModel();
                    yyImSong1MlateTogiftModel.android_goods_info.double_hit = (int) androidGoodsInfo.getDoubleHit();
                    yyImSong1MlateTogiftModel.android_goods_info.goods_id = androidGoodsInfo.getGoodsId() + "";
                    yyImSong1MlateTogiftModel.android_goods_info.ops = (int) androidGoodsInfo.getOps();
                    yyImSong1MlateTogiftModel.android_goods_info.name = androidGoodsInfo.getName();
                    yyImSong1MlateTogiftModel.android_goods_info.description = androidGoodsInfo.getDescription();
                    yyImSong1MlateTogiftModel.android_goods_info.count = (int) androidGoodsInfo.getCount();
                    yyImSong1MlateTogiftModel.android_goods_info.goods_number = new ArrayList();
                    yyImSong1MlateTogiftModel.android_goods_info.images_static = androidGoodsInfo.getImagesStatic();
                    yyImSong1MlateTogiftModel.android_goods_info.images_apng = androidGoodsInfo.getImagesApng();
                    yyImSong1MlateTogiftModel.android_goods_info.images_gif = androidGoodsInfo.getImagesGif();
                    yyImSong1MlateTogiftModel.android_goods_info.images_mp4 = androidGoodsInfo.getImagesMp4();
                    yyImSong1MlateTogiftModel.android_goods_info.is_hot = androidGoodsInfo.getIsHot() + "";
                    yyImSong1MlateTogiftModel.android_goods_info.beans = androidGoodsInfo.getBeans();
                    yyImSong1MlateTogiftModel.android_goods_info.is_free = androidGoodsInfo.getIsFree() + "";
                    yyImSong1MlateTogiftModel.android_goods_info.discount = androidGoodsInfo.getDiscount();
                    yyImSong1MlateTogiftModel.android_goods_info.is_displayed = (int) androidGoodsInfo.getIsDisplayed();
                    yyImSong1MlateTogiftModel.choosed_id = receive.getExtra().getGuideInfo().getChoosedId() + "";
                }
                YYImMsgManager.a().a(yYImModel, yyImSong1MlateTogiftModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_APPLAUSE) {
                YYImMsgManager.a().h();
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_CHOOSE_SONG_GUIDE) {
                YYImMsgManager.a().X(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_STAGE) {
                AudioMsgExtra.KtvStage stage = receive.getExtra().getStage();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "status", stage.getStatus());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "reach_beans", stage.getReachBeans());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "lowest_score", stage.getLowestScore());
                YYImMsgManager.a().aj(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.FANS_LEVEL) {
                AudioMsgExtra.FansLevel fansLevel = receive.getExtra().getFansLevel();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", fansLevel.getUid());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "status", fansLevel.getStatus());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "level", fansLevel.getLevel());
                YYImMsgManager.a().ad(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.FANS_STATUS) {
                AudioMsgExtra.FansStatus fansStatus = receive.getExtra().getFansStatus();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "anchor_uid", fansStatus.getAnchorUid());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", fansStatus.getUid());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "status", fansStatus.getStatus());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "level", fansStatus.getLevel());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", fansStatus.getFansGroupName());
                YYImMsgManager.a().ab(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.FANS_CREATE_GROUP) {
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "anchor_uid", receive.getExtra().getCreateFansGroup().getAnchorUid());
                YYImMsgManager.a().ac(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.RANK_ANCHOR_INFO) {
                AudioMsgExtra.AnchorRankInfo anchorRankInfo = receive.getExtra().getAnchorRankInfo();
                YYBannerRankModel yYBannerRankModel = new YYBannerRankModel(anchorRankInfo.getActivityType(), "", "", anchorRankInfo.getScoreValue(), anchorRankInfo.getRankValue(), "", "");
                yYImModel.extra = yYBannerRankModel;
                YYImMsgManager.a().a(yYBannerRankModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.BOX_NOTIFY) {
                AudioMsgExtra.BoxNotify boxNotify = receive.getExtra().getBoxNotify();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "count_down", boxNotify.getCountDown());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "level", boxNotify.getLevel());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "grant", boxNotify.getGrant());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "icon_small", boxNotify.getIconSmall());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "icon_middle", boxNotify.getIconMiddle());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "icon_big", boxNotify.getIconBig());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "trigger_vanish_time", boxNotify.getTriggerVanishTime());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.ANIMATION, boxNotify.getAnimation());
                YYImMsgManager.a().af(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.BOX_BEANS_NOTIFY) {
                AudioMsgExtra.BoxBeansNotify boxBeansNotify = receive.getExtra().getBoxBeansNotify();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "current_beans", boxBeansNotify.getCurrentBeans());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "need_total_beans", boxBeansNotify.getNeedTotalBeans());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "icon_small", boxBeansNotify.getIconSmall());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "icon_middle", boxBeansNotify.getIconMiddle());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "icon_big", boxBeansNotify.getIconBig());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "grant", boxBeansNotify.getGrant());
                YYImMsgManager.a().ae(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.KTV_RECEIVE) {
                AudioMsgExtra.KtvReceive receive2 = receive.getExtra().getReceive();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.BEANS, receive2.getBeans());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT, receive2.getCount());
                YYImMsgManager.a().ak(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.ANCHOR_PRIVILEGE) {
                AudioMsgExtra.AnchorPrivilege anchorPrivilege = receive.getExtra().getAnchorPrivilege();
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "material", anchorPrivilege.getMaterial());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, l.y, anchorPrivilege.getContent());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "anchor_level", anchorPrivilege.getAnchorLevel());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "name", anchorPrivilege.getName());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, ReqAckPackage.REQ_RESPONSE_KEY.AVATAR, anchorPrivilege.getAvatar());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "roomid", anchorPrivilege.getRoomId());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "anchor_uid", anchorPrivilege.getAnchorUid());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "anchor_uid", anchorPrivilege.getAnchorUid());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "broadcast_background", anchorPrivilege.getBroadcastBackground());
                YYImMsgManager.a().ag(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.REPORT_INFO) {
                AudioMsgExtra.ReportInfo reportInfo = receive.getExtra().getReportInfo();
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, l.y, reportInfo.getContents());
                YYImMsgManager.a().c(reportInfo.getContents());
            } else if (receive.getMsgType() == AudioMsgType.MsgType.POPOVER_INFO) {
                AudioMsgExtra.PopoverInfo popoverInfo = receive.getExtra().getPopoverInfo();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "delay", popoverInfo.getDelay());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "title", popoverInfo.getTitle());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, l.y, popoverInfo.getContent());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "background", popoverInfo.getBackground());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "submit_title", popoverInfo.getSubmitTitle());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "link", popoverInfo.getLink());
                YYImMsgManager.a().am(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.CHATROOM_MIC_BEANS) {
                AudioMsgExtra.ChatroomMicBeans chatroomMicBeans = receive.getExtra().getChatroomMicBeans();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "uid", chatroomMicBeans.getUid());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "room_id", chatroomMicBeans.getRoomId());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "status", chatroomMicBeans.getStatus());
                List<AudioMsgExtra.MicBeansInfo> micBeansInfoList = chatroomMicBeans.getMicBeansInfoList();
                if (micBeansInfoList != null) {
                    ArrayList arrayList12 = new ArrayList();
                    for (AudioMsgExtra.MicBeansInfo micBeansInfo : micBeansInfoList) {
                        HashMap hashMap21 = new HashMap();
                        MsgPackHelper.putMapValue((Map<String, Object>) hashMap21, "uid", micBeansInfo.getUid());
                        MsgPackHelper.putMapValue((Map<String, Object>) hashMap21, "bean", micBeansInfo.getBean());
                        arrayList12.add(hashMap21);
                    }
                    yYImModel.msgMapExtra.put("mic_beans_info", arrayList12);
                }
                YYImMsgManager.a().ai(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.TOPIC_INFO) {
                AudioMsgExtra.TopicInfo topicInfo = receive.getExtra().getTopicInfo();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "room_id", topicInfo.getRoomId());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "topic", topicInfo.getTopic());
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "type_id", topicInfo.getTypeId());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "type_name", topicInfo.getTypeName());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, l.y, topicInfo.getContent());
                YYImMsgManager.a().R(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.NEW_PK) {
                AudioMsgExtra.NewPk newPk = receive.getExtra().getNewPk();
                MsgPackHelper.putMapValue((Map<String, Object>) yYImModel.msgMapExtra, "type", newPk.getType());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "body", newPk.getBody());
                YYImMsgManager.a().al(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.UPGRADE_PRIVILEGE) {
                yYImModel.extra = (IMJsonContents95Model) AppInfo.f().fromJson(receive.getExtra().getJsonContents(), IMJsonContents95Model.class);
                YYImMsgManager.a().ah(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.ACTIVITY_ENTRANCE) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().an(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.REWARD_RAIN) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().ao(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.EXPLORATION_MULTIPLE) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().ap(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.PROP_SET_UPDATE) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                MsgPackHelper.putMapValue(yYImModel.msgMapExtra, "json_content", receive.getExtra().getJsonContents());
                YYImMsgManager.a().aq(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.NEW_RED_PACKET) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().ar(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.ROB_SING_ROOM) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().as(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.FIRST_MEET) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().at(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.VEILED_OPEN_UIDS) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().au(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.VEILED_OPEN_GUIDE) {
                YYImMsgManager.a().j();
            } else if (receive.getMsgType() == AudioMsgType.MsgType.INVITE_TO_RELATION) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().av(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.BECOME_TO_RELATION) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().aw(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.CUSTOM_ACTIVITY) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().ax(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.CUSTOM_ACTIVITY_GOODS) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().ay(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.EFFECTS) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().az(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.GOODS_LIGHT_REGION) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().aB(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.TRUE_LOVE_BOX) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().aA(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.MULTI_GOODS) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().aC(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.CONFESSION) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().aD(yYImModel);
            } else if (receive.getMsgType() == AudioMsgType.MsgType.DOUBLE_AVATAR_BROADCAST) {
                yYImModel.setMsgExtra(receive.getExtra().getJsonContents());
                YYImMsgManager.a().aE(yYImModel);
            }
        }
    }

    public void a(String str, AudioChatroom.OnAudioChatroomResponseListener onAudioChatroomResponseListener) {
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().a;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || TextUtils.isEmpty(b.room_id) || yYUserInfo == null) {
            return;
        }
        AudioMsgExtra.Profile.Builder roleValue = AudioMsgExtra.Profile.newBuilder().setName(yYUserInfo.getName()).setAvatar(yYUserInfo.getAvatar()).setUid(StringUtils.a(yYUserInfo.getUid(), 0)).setRoleValue(StringUtils.a(yYUserInfo.chat_anchor, 0));
        if (b != null) {
            roleValue.setWealthLevel(StringUtils.a(b.wealth_level, 0));
            roleValue.setAnchorLevel(StringUtils.a(b.anchor_level, 0));
            roleValue.setAvatarFrame(b.enter_effects == null ? "" : b.enter_effects);
            roleValue.setEnterEffects(b.avatar_frame == null ? "" : b.avatar_frame);
            roleValue.setMessageBubbleIcon(StringUtils.b(b.message_bubble_icon) ? "" : b.message_bubble_icon);
            roleValue.setMessageBubbleImg(StringUtils.b(b.message_bubble_img) ? "" : b.message_bubble_img);
            if (b.fans_group != null && b.fans_group.level != null) {
                roleValue.setFansGroupLevel(StringUtils.a(b.fans_group.level.level, 0));
                roleValue.setFansGroupName(b.fans_group.level.name == null ? "粉丝团" : b.fans_group.level.name);
                roleValue.setFansGroupStatus(b.fans_group.level.status);
            }
            if (b.title != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= b.title.size()) {
                        break;
                    }
                    AudioMsgExtra.MessageUserTitle.Builder newBuilder = AudioMsgExtra.MessageUserTitle.newBuilder();
                    newBuilder.setImg(b.title.get(i2).getImg());
                    newBuilder.setIcon(b.title.get(i2).getIcon());
                    newBuilder.setWidth(b.title.get(i2).getWidth());
                    roleValue.addMessageUserTitle(newBuilder);
                    i = i2 + 1;
                }
            }
        }
        IM.a(AudioChatroomOuterClass.Request.newBuilder().setContents(str).setSourceProfile(roleValue.build()).setMsgType(AudioMsgType.MsgType.TEXT).setRoomId(StringUtils.a(b.room_id, 0)), onAudioChatroomResponseListener);
    }

    @Override // com.blued.android.module.im.grpc.OnConnectStateListener
    public void onConnected() {
        Logger.e("onMessage", "onConnected ... ");
        AudioChannelManager.j().i();
    }

    @Override // com.blued.android.module.im.grpc.OnConnectStateListener
    public void onConnecting() {
        Logger.e("onMessage", "onConnecting ... ");
    }

    @Override // com.blued.android.module.im.grpc.OnConnectStateListener
    public void onDisconnected() {
        Logger.e("onMessage", "onDisconnected ... ");
    }

    @Override // com.blued.android.module.im.grpc.OnConnectStateListener
    public void onReceive(Any any) {
        try {
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b == null) {
                return;
            }
            final AudioChatroomOuterClass.Receive unpack = any.unpack(AudioChatroomOuterClass.Receive.class);
            if (unpack.getRoomId() != StringUtils.a(b.room_id, 0)) {
                return;
            }
            final YYImModel yYImModel = new YYImModel();
            yYImModel.type = unpack.getMsgTypeValue();
            yYImModel.contents = unpack.getContents();
            yYImModel.resend = unpack.getResend();
            yYImModel.source_profile = new YYAudienceModel();
            yYImModel.source_profile.setUid(String.valueOf(unpack.getSourceProfile().getUid()));
            yYImModel.source_profile.setName(unpack.getSourceProfile().getName());
            yYImModel.source_profile.setAvatar(unpack.getSourceProfile().getAvatar());
            yYImModel.source_profile.setWealth_level(unpack.getSourceProfile().getWealthLevel());
            yYImModel.source_profile.setAnchor_level(unpack.getSourceProfile().getAnchorLevel());
            yYImModel.source_profile.setAvatr_frame(unpack.getSourceProfile().getAvatarFrame());
            yYImModel.source_profile.setEnter_effects(unpack.getSourceProfile().getEnterEffects());
            yYImModel.source_profile.setEnter_effects_forward(unpack.getSourceProfile().getEnterEffectsForward());
            yYImModel.source_profile.chat_anchor = String.valueOf(unpack.getSourceProfile().getRoleValue());
            yYImModel.source_profile.message_bubble_icon = String.valueOf(unpack.getSourceProfile().getMessageBubbleIcon());
            yYImModel.source_profile.message_bubble_img = String.valueOf(unpack.getSourceProfile().getMessageBubbleImg());
            yYImModel.source_profile.fans_group_level = String.valueOf(unpack.getSourceProfile().getFansGroupLevel());
            yYImModel.source_profile.fans_group_name = String.valueOf(unpack.getSourceProfile().getFansGroupName());
            yYImModel.source_profile.fans_group_status = (int) unpack.getSourceProfile().getFansGroupStatus();
            if (unpack.getSourceProfile().getMessageUserTitleList() != null) {
                ArrayList<YYRoomBasicPropItemMode> arrayList = new ArrayList<>();
                for (AudioMsgExtra.MessageUserTitle messageUserTitle : unpack.getSourceProfile().getMessageUserTitleList()) {
                    arrayList.add(new YYRoomBasicPropItemMode(messageUserTitle.getIcon(), messageUserTitle.getImg(), (int) messageUserTitle.getWidth()));
                }
                yYImModel.source_profile.message_user_title = arrayList;
            }
            yYImModel.target_profile = new YYAudienceModel();
            yYImModel.target_profile.setUid(String.valueOf(unpack.getTargetProfile().getUid()));
            yYImModel.target_profile.setName(unpack.getTargetProfile().getName());
            yYImModel.target_profile.setAvatar(unpack.getTargetProfile().getAvatar());
            yYImModel.target_profile.setWealth_level(unpack.getTargetProfile().getWealthLevel());
            yYImModel.target_profile.setAnchor_level(unpack.getTargetProfile().getAnchorLevel());
            yYImModel.target_profile.setAvatr_frame(unpack.getTargetProfile().getAvatarFrame());
            yYImModel.target_profile.setEnter_effects(unpack.getTargetProfile().getEnterEffects());
            yYImModel.target_profile.setEnter_effects_forward(unpack.getTargetProfile().getEnterEffectsForward());
            yYImModel.target_profile.chat_anchor = String.valueOf(unpack.getTargetProfile().getRoleValue());
            yYImModel.target_profile.message_bubble_icon = String.valueOf(unpack.getTargetProfile().getMessageBubbleIcon());
            yYImModel.target_profile.message_bubble_img = String.valueOf(unpack.getTargetProfile().getMessageBubbleImg());
            yYImModel.target_profile.fans_group_level = String.valueOf(unpack.getTargetProfile().getFansGroupLevel());
            yYImModel.target_profile.fans_group_name = String.valueOf(unpack.getTargetProfile().getFansGroupName());
            yYImModel.target_profile.fans_group_status = (int) unpack.getTargetProfile().getFansGroupStatus();
            if (unpack.getTargetProfile().getMessageUserTitleList() != null) {
                ArrayList<YYRoomBasicPropItemMode> arrayList2 = new ArrayList<>();
                for (AudioMsgExtra.MessageUserTitle messageUserTitle2 : unpack.getTargetProfile().getMessageUserTitleList()) {
                    arrayList2.add(new YYRoomBasicPropItemMode(messageUserTitle2.getIcon(), messageUserTitle2.getImg(), (int) messageUserTitle2.getWidth()));
                }
                yYImModel.target_profile.message_user_title = arrayList2;
            }
            yYImModel.msg_time = unpack.getMsgTime();
            yYImModel.msgMapExtra = new HashMap<>();
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.YYIMManager.1
                @Override // java.lang.Runnable
                public void run() {
                    LogUtils.d("YYIMManager", "收到消息 type = " + unpack.getMsgTypeValue());
                    try {
                        YYIMManager.this.a(unpack, yYImModel);
                        String json = AppInfo.f().toJson(yYImModel);
                        LogUtils.d("YYIMManager", "收到消息 = " + json);
                        if (unpack.getMsgType() == AudioMsgType.MsgType.JOIN_ROOM || unpack.getMsgType() == AudioMsgType.MsgType.CLOSE_ROOM || unpack.getMsgType() == AudioMsgType.MsgType.ALERT_ROOM || unpack.getMsgType() == AudioMsgType.MsgType.SET_MANAGER || unpack.getMsgType() == AudioMsgType.MsgType.CANCLE_MANAGER || unpack.getMsgType() == AudioMsgType.MsgType.MUTE || unpack.getMsgType() == AudioMsgType.MsgType.UNMUTE || unpack.getMsgType() == AudioMsgType.MsgType.INVITE_UP_SEAT || unpack.getMsgType() == AudioMsgType.MsgType.REFUSE_INVITE || unpack.getMsgType() == AudioMsgType.MsgType.UP_SEAT_SUCCESS || unpack.getMsgType() == AudioMsgType.MsgType.LEAVE_SEAT || unpack.getMsgType() == AudioMsgType.MsgType.MUTE_SEAT_STATUS || unpack.getMsgType() == AudioMsgType.MsgType.CLOSE_SEAT_STATUS || unpack.getMsgType() == AudioMsgType.MsgType.KICK_ROOM || unpack.getMsgType() == AudioMsgType.MsgType.ROOM_NAME_INVALID || unpack.getMsgType() == AudioMsgType.MsgType.UP_APPLY_REJECT || unpack.getMsgType() == AudioMsgType.MsgType.LATE_UP_SEAT_ACCEPT || unpack.getMsgType() == AudioMsgType.MsgType.LATE_UP_SEAT_REJECT || unpack.getMsgType() == AudioMsgType.MsgType.INVALID_LIVE_WARNING || unpack.getMsgType() == AudioMsgType.MsgType.ROB_SING_ROOM || unpack.getMsgType() == AudioMsgType.MsgType.NEW_PK) {
                            LiveLogUtils.a("YYIMManager --> onReceive --> msgType：" + unpack.getMsgType() + " --> json：" + json);
                        }
                    } catch (Exception e) {
                        LiveLogUtils.a("YYIMManager --> onReceive --> msgType：" + unpack.getMsgType() + " --> Exception：" + e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

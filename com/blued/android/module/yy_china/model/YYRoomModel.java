package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomModel.class */
public class YYRoomModel {
    public String anchor_level;
    private Vector<YYAudienceModel> audiences;
    public String avatar;
    public String avatar_frame;
    public ChatVoicePatternModel background;
    public ChatAnchorLevelModel chat_anchor_level;
    public int chat_room_list_stealth;
    public ClientSendMessTaskNewModel clientSendMessTask;
    public String create_time;
    public String enter_effects;
    public String enter_effects_forward;
    public YYFansGroupModel fans_group;
    private List<Long> giftHitIds;
    public String gift_pk_id;
    public String hall_id;
    private List<YYImModel> imDatas;
    private Set<String> invitedList;
    public String is_public;
    public VeiledRoomInfoMode mMaskedVeiledRoominfo;
    public String message_bubble_icon;
    public String message_bubble_img;
    public ChatroomMIcBeansModel micBeansModel;
    public List<YYSeatMemberModel> mics;
    private HashMap<String, YYSeatMemberModel> micsMap;
    public String mounts_icon;
    public String mounts_img;
    public YYMsgKtvMusic music;
    public String music_info;
    public String name;
    public int open_batch_gifts;
    private ConcurrentHashMap<String, YYImModel> playingEmojiMap;
    public String publish_url;
    public YYMsgRedEnvExtra redEnvelope;
    public String region;
    public String relationship;
    public YYConfiguredResourcesModel resourcesModel;
    public YYBorImJsonBodyInfoMode robMus;
    public ArrayList<YYBorImJsonBodyInfoMode> robMusics;
    public String room_desc;
    public String room_id;
    public String room_member_count;
    public String room_member_lock_count;
    public String room_member_total;
    public String room_name;
    public String room_owner;
    public String room_type;
    public long round_end_time;
    public boolean setSoloGift;
    public YYKtvStageModel stage_info;
    public String task_url;
    public ArrayList<YYRoomBasicPropItemMode> title;
    public TopicSetInfoMode topic_set_info;
    public String type_id;
    public String type_img;
    public String uid;
    public String user_sig;
    public VoiceSkinInfoMode voice_skin_info;
    public String vote_id;
    public String wealth_level;
    public String weeklyRankUrl;
    public WelcomeInfoMode welcome_info;
    public YYPerFirstGiftModel yyPerFirstGiftModel;
    public boolean isUpload = false;
    public String mute = "0";
    public int countdown = 0;
    private int audienceCount = 0;
    private int waittingCount = 0;
    private String giftBeans = "0";
    private boolean timerFinished = true;
    private int present_step = 0;
    private int next_step = 0;
    private int in_pk = 0;
    public boolean pk_has_connected = false;
    public boolean room_pk_mute_all = false;
    public String chat_type = "0";
    public String chat_anchor = "0";
    public boolean isBorMusicUser = false;
    public int game_step = 0;
    public boolean soloLock = true;
    private ArrayList<String> unMaskedUserList = new ArrayList<>();
    private ArrayList<String> timerMaskedUserList = new ArrayList<>();

    public void addAudienceToList(YYAudienceModel yYAudienceModel) {
        if (this.audiences == null) {
            this.audiences = new Vector<>();
        }
        Iterator<YYAudienceModel> it = this.audiences.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (TextUtils.equals(yYAudienceModel.getUid(), it.next().getUid())) {
                it.remove();
                break;
            }
        }
        if (this.audiences.size() >= 50) {
            Vector<YYAudienceModel> vector = this.audiences;
            vector.remove(vector.size() - 1);
        }
        this.audiences.add(0, yYAudienceModel);
    }

    public void addImDatas(int i, YYImModel yYImModel) {
        if (this.imDatas == null) {
            this.imDatas = new ArrayList();
        }
        this.imDatas.add(i, yYImModel);
        YYObserverManager.a().a(yYImModel);
    }

    public void addImDatas(YYImModel yYImModel) {
        if (this.imDatas == null) {
            this.imDatas = new ArrayList();
        }
        this.imDatas.add(yYImModel);
        YYObserverManager.a().a(yYImModel);
    }

    public void addInvited(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.invitedList == null) {
            this.invitedList = new HashSet();
        }
        this.invitedList.add(str);
    }

    public void cleanTimerUserList() {
        this.timerMaskedUserList.clear();
    }

    public void clearEmojiAndSendMessage() {
        ConcurrentHashMap<String, YYImModel> concurrentHashMap = this.playingEmojiMap;
        if (concurrentHashMap == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            YYImModel yYImModel = this.playingEmojiMap.get(str);
            if (yYImModel != null) {
                addImDatas(yYImModel);
            }
        }
        this.playingEmojiMap.clear();
    }

    public boolean enableRequestMic() {
        return this.present_step < 2;
    }

    public int getAudienceCount() {
        return this.audienceCount;
    }

    public int getCPNextStep() {
        if (this.present_step <= 0) {
            this.next_step = 1;
        }
        return this.next_step;
    }

    public int getCPPresentStep() {
        if (this.present_step < 0) {
            this.present_step = 0;
        }
        return this.present_step;
    }

    public String getGiftBeans() {
        return this.giftBeans;
    }

    public List<YYSeatMemberModel> getHasPeopleMics() {
        ArrayList arrayList = new ArrayList();
        for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
            if (yYSeatMemberModel.position_status == 1) {
                arrayList.add(yYSeatMemberModel);
            }
        }
        return arrayList;
    }

    public List<YYSeatMemberModel> getHasPeopleMicsExceptMyself() {
        ArrayList arrayList = new ArrayList();
        for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
            if (yYSeatMemberModel.position_status == 1 && !TextUtils.equals(yYSeatMemberModel.getUid(), YYRoomInfoManager.e().k())) {
                arrayList.add(yYSeatMemberModel);
            }
        }
        return arrayList;
    }

    public List<YYImModel> getImDatas() {
        if (this.imDatas == null) {
            this.imDatas = new ArrayList();
        }
        return this.imDatas;
    }

    public HashMap<String, YYSeatMemberModel> getMicsMap() {
        return this.micsMap;
    }

    public Boolean getNormalKtv() {
        YYKtvStageModel yYKtvStageModel = this.stage_info;
        return yYKtvStageModel == null || yYKtvStageModel.status == 0;
    }

    public YYImModel getPlayingEmoji(String str) {
        return removePlayingEmoji(str);
    }

    public YYSeatMemberModel getSeatMember(String str) {
        List<YYSeatMemberModel> list = this.mics;
        if (list == null) {
            return null;
        }
        for (YYSeatMemberModel yYSeatMemberModel : list) {
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                return yYSeatMemberModel;
            }
        }
        return null;
    }

    public Set<String> getTalkingUserIds() {
        TreeSet treeSet = new TreeSet();
        for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
            if (yYSeatMemberModel.position_status == 1 && yYSeatMemberModel.is_open_mic == 2) {
                treeSet.add(yYSeatMemberModel.getUid());
            }
        }
        return treeSet;
    }

    public int getWaittingCount() {
        return this.waittingCount;
    }

    public boolean hasTimerMaskedUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.timerMaskedUserList.contains(str);
    }

    public void initMicsMap() {
        if (this.micsMap == null) {
            this.micsMap = new HashMap<>();
        }
        if (this.mics == null) {
            return;
        }
        this.micsMap.clear();
        for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
            if (StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0) {
                this.micsMap.put(yYSeatMemberModel.getUid(), yYSeatMemberModel);
            }
        }
    }

    public boolean isEntertainmentChannel() {
        return TextUtils.equals(this.chat_type, "9");
    }

    public boolean isExistById(String str) {
        List<YYSeatMemberModel> list = this.mics;
        if (list == null) {
            return false;
        }
        for (YYSeatMemberModel yYSeatMemberModel : list) {
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistEmojiByUid(String str) {
        ConcurrentHashMap<String, YYImModel> concurrentHashMap = this.playingEmojiMap;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(str);
    }

    public boolean isInvited(String str) {
        if (this.invitedList == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.invitedList.contains(str);
    }

    public boolean isKTVChannel() {
        return TextUtils.equals(ATAdConst.ATDevFrameworkType.FLUTTER, this.chat_type);
    }

    public boolean isPking() {
        return this.in_pk == 0;
    }

    public boolean isRolChannel() {
        return TextUtils.equals("10", this.chat_type);
    }

    public boolean isSaleChannel() {
        return TextUtils.equals("4", this.chat_type);
    }

    public boolean isTimerFinished() {
        return this.timerFinished;
    }

    public boolean isUnmasked(String str) {
        return this.unMaskedUserList.contains(str);
    }

    public void notifySeat() {
        YYObserverManager.a().b(this.mics);
    }

    public void putPlayingEmoji(String str, YYImModel yYImModel) {
        if (this.playingEmojiMap == null) {
            this.playingEmojiMap = new ConcurrentHashMap<>();
        }
        this.playingEmojiMap.put(str, yYImModel);
    }

    public void putTimerMaskedUsers(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.timerMaskedUserList.add(str);
    }

    public void removeAudienceForList(String str) {
        Vector<YYAudienceModel> vector = this.audiences;
        if (vector == null) {
            return;
        }
        Iterator<YYAudienceModel> it = vector.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().getUid())) {
                it.remove();
                return;
            }
        }
    }

    public YYImModel removePlayingEmoji(String str) {
        ConcurrentHashMap<String, YYImModel> concurrentHashMap = this.playingEmojiMap;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.remove(str);
    }

    public void removeSeatMember(String str) {
        List<YYSeatMemberModel> list = this.mics;
        if (list == null) {
            return;
        }
        Iterator<YYSeatMemberModel> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            YYSeatMemberModel next = it.next();
            if (TextUtils.equals(next.getUid(), str)) {
                next.setName("");
                next.setAvatar("");
                next.setUid("0");
                next.position_status = 0;
                next.is_open_mic = 0;
                next.chat_anchor = "0";
                break;
            }
        }
        YYObserverManager.a().b(this.mics);
    }

    public void removeTimerMaskedUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.timerMaskedUserList.remove(str);
    }

    public void setAudienceCount(int i) {
        this.audienceCount = i;
    }

    public void setAudiences(List<YYAudienceModel> list) {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        List<YYAudienceModel> list2 = arrayList;
        if (arrayList.size() > 50) {
            list2 = arrayList.subList(0, 50);
        }
        if (this.audiences == null) {
            this.audiences = new Vector<>();
        }
        this.audiences.clear();
        this.audiences.addAll(list2);
    }

    public void setCPNextStep(int i) {
        this.next_step = i;
    }

    public void setCPPresentStep(int i) {
        this.present_step = i;
    }

    public void setGiftBeans(String str) {
        this.giftBeans = str;
    }

    public void setNormalKtv(boolean z) {
        if (this.stage_info == null) {
            YYKtvStageModel yYKtvStageModel = new YYKtvStageModel();
            this.stage_info = yYKtvStageModel;
            yYKtvStageModel.status = !z ? 1 : 0;
        }
    }

    public void setSeatList(List<YYSeatMemberModel> list) {
        if (this.mics == null) {
            this.mics = new ArrayList();
        }
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        if (this.micsMap == null) {
            this.micsMap = new HashMap<>();
        }
        this.mics.clear();
        this.micsMap.clear();
        this.mics.addAll(arrayList);
        if (TextUtils.equals(this.chat_type, "8") || TextUtils.equals(this.chat_type, "11")) {
            List<YYSeatMemberModel> list2 = this.mics;
            list2.get(list2.size() - 1).isVip = true;
        }
        for (YYSeatMemberModel yYSeatMemberModel : this.mics) {
            if (StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0) {
                this.micsMap.put(yYSeatMemberModel.getUid(), yYSeatMemberModel);
            }
        }
        YYObserverManager.a().b(this.mics);
    }

    public void setTimerFinished(boolean z) {
        this.timerFinished = z;
    }

    public void setUnMaskedUserList(ArrayList<String> arrayList, String str, long j, int i) {
        this.unMaskedUserList = arrayList;
        if (i != 0) {
            ChatRoomProtos.Event event = ChatRoomProtos.Event.YY_LIFT_MASK_SUCCESS;
            String str2 = this.room_id;
            String str3 = this.uid;
            EventTrackYY.g(event, str2, str3, str, i + "");
        }
        if (j > 0) {
            if (TextUtils.equals(str, this.uid)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("target_id", str);
                jSONObject.put("countdown", j);
                LiveEventBus.get("delay_take_off_mask").post(jSONObject.toString());
            } catch (Exception e) {
            }
        } else if (StringUtils.a(str, 0L) > 0) {
            LiveEventBus.get("take_off_mask").post(str);
        } else {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                LiveEventBus.get("take_off_mask").post(it.next());
            }
        }
    }

    public void setWaittingCount(int i) {
        this.waittingCount = i;
    }

    public void updateMicStatus(String str, int i) {
        List<YYSeatMemberModel> list = this.mics;
        if (list == null) {
            return;
        }
        Iterator<YYSeatMemberModel> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            YYSeatMemberModel next = it.next();
            if (TextUtils.equals(next.getUid(), str)) {
                next.is_open_mic = i;
                break;
            }
        }
        YYObserverManager.a().b(this.mics);
    }
}

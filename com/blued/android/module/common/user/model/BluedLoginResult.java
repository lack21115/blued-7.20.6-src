package com.blued.android.module.common.user.model;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/model/BluedLoginResult.class */
public class BluedLoginResult {
    private String access_token;
    public String age;
    private List<BluedAlbum> album;
    private String astro;
    public AuditingProfileModel auditing_profile;
    public String avatar;
    public String avatar_frame;
    public int avatar_frame_type;
    private String avatar_pid;
    private String birthday;
    private String black_allowed_count;
    private String black_count;
    private String[] blacklist;
    private String blood_type;
    public String blued_pic;
    public String captcha;
    public int chat_badge_height;
    public int chat_badge_length;
    public String chat_badge_url;
    private String chinese_zodiac;
    private String city_settled;
    private String custom;
    public String description;
    private int device_safe;
    private String device_token;
    public String distance;
    private String education;
    public String email;
    @SerializedName(BridgeUtil.UNDERLINE_STR)
    private String encrypted;
    private String ethnicity;
    public int expire_type;
    private String followed_count;
    private String followers_count;
    private String friends_count;
    public int game_type;
    private String groups_count;
    private UserHeaderVerifyStatus headerVerifyStatus;
    public String health_prpe_use_situation;
    public String health_test_result;
    public String health_test_time;
    public String height;
    private String hometown;
    public String hot;
    private String ihate;
    private String ilike;
    private String in_blacklist;
    private String industry;
    private String is_access_follows;
    private String is_access_groups;
    private String is_auth_url;
    public int is_hide_city_settled;
    public int is_hide_distance;
    public int is_hide_last_operate;
    public int is_invisible_all;
    public int is_invisible_half;
    private int is_kids;
    private String is_locked;
    public int is_recommend;
    public int is_show_vip_page;
    public int is_user_reactive;
    public int is_vip_annual;
    private String last_login;
    public String last_operate;
    private String latitude;
    private String lock_until;
    private String longitude;
    private String mate;
    private String my_ticktocks_count;
    public String name;
    private int need_auth;
    public String nickname_limit;
    public String note;
    public String online_state;
    public int photos_count;
    private String province;
    private String qq;
    public String reason;
    private String red_ribbon;
    private String red_ribbon_link;
    private String reg_date;
    private String relationship;
    public UserRestrictedDescModel restricted_desc;
    private int rich_level;
    public String role;
    private UserTagAll tags;
    public String target;
    public int theme_pendant;
    private String third_access_token;
    private String third_user_id;
    private String total_time;
    public String uid;
    public int vbadge;
    private BluedLoginResultVerBinding verified_bindings;
    private VerifyStatus[] verify;
    private List<BluedAlbum> vip_avatars;
    public int vip_grade;
    private String visited_count;
    public String weekstar;
    private String weibo;
    public String weight;
    private String weixin;
    public int chat_sdk_type = 1;
    public boolean isShowRedPackGuide = true;
    public int personal_display = 1;
    public int avatar_audited = -1;
    public int is_audited = -1;

    private String dealCountInt(String str, int i) {
        int i2;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "0";
        }
        try {
            i2 = Integer.parseInt(str2);
        } catch (Exception e) {
            i2 = 0;
        }
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = 0;
        }
        return i3 + "";
    }

    public void addBlackCount() {
        try {
            int parseInt = Integer.parseInt(this.black_count);
            this.black_count = (parseInt + 1) + "";
        } catch (Exception e) {
        }
    }

    public void addUserBlackCount() {
        int i;
        String blackCount = getBlackCount();
        String str = blackCount;
        if (TextUtils.isEmpty(blackCount)) {
            str = "0";
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            i = 0;
        }
        setBlackCount((i + 1) + "");
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public String getAge() {
        return this.age;
    }

    public List<BluedAlbum> getAlbum() {
        return this.album;
    }

    public String getAstro() {
        return this.astro;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatar_pid() {
        return this.avatar_pid;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getBlackCount() {
        return this.black_count;
    }

    public String getBlackMax() {
        return this.black_allowed_count;
    }

    public String[] getBlacklist() {
        return this.blacklist;
    }

    public String getBlood_type() {
        return this.blood_type;
    }

    public String getChinese_zodiac() {
        return this.chinese_zodiac;
    }

    public String getCity_settled() {
        return this.city_settled;
    }

    public String getCustom() {
        return this.custom;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDevice_safe() {
        return this.device_safe;
    }

    public String getDevice_token() {
        return this.device_token;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getEducation() {
        return this.education;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEncrypted() {
        return this.encrypted;
    }

    public String getEthnicity() {
        return this.ethnicity;
    }

    public String getFollowedCount() {
        return this.followed_count;
    }

    public String getFollowerCount() {
        return this.followers_count;
    }

    public String getFriendCount() {
        return this.friends_count;
    }

    public String getGroupsCount() {
        return this.groups_count;
    }

    public UserHeaderVerifyStatus getHeaderVerifyStatus() {
        return this.headerVerifyStatus;
    }

    public String getHeight() {
        return this.height;
    }

    public String getHometown() {
        return this.hometown;
    }

    public String getHot() {
        return this.hot;
    }

    public String getIhate() {
        return this.ihate;
    }

    public String getIlike() {
        return this.ilike;
    }

    public String getIn_blacklist() {
        return this.in_blacklist;
    }

    public String getIndustry() {
        return this.industry;
    }

    public String getIs_access_follows() {
        return this.is_access_follows;
    }

    public String getIs_access_groups() {
        return this.is_access_groups;
    }

    public String getIs_auth_url() {
        return this.is_auth_url;
    }

    public String getIs_locked() {
        return this.is_locked;
    }

    public String getLast_login() {
        return this.last_login;
    }

    public String getLast_operate() {
        return this.last_operate;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLock_until() {
        return this.lock_until;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getMate() {
        return this.mate;
    }

    public String getMyTicktocksCount() {
        return this.my_ticktocks_count;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    public int getNeedAdultVerify() {
        return this.is_kids;
    }

    public int getNeed_auth() {
        return this.need_auth;
    }

    public String getNote() {
        return this.note;
    }

    public String getOnline_state() {
        return this.online_state;
    }

    public int getPhotos_count() {
        return this.photos_count;
    }

    public String getProvince() {
        return this.province;
    }

    public String getQq() {
        return this.qq;
    }

    public String getRed_ribbon() {
        return this.red_ribbon;
    }

    public String getRed_ribbon_link() {
        return this.red_ribbon_link;
    }

    public String getReg_date() {
        return this.reg_date;
    }

    public String getRelationship() {
        return this.relationship;
    }

    public int getRich_level() {
        return this.rich_level;
    }

    public String getRole() {
        return this.role;
    }

    public ArrayList<String> getTagList() {
        ArrayList<String> arrayList = new ArrayList<>();
        UserTagAll userTagAll = this.tags;
        if (userTagAll != null) {
            if (userTagAll.type != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.tags.type.size()) {
                        break;
                    }
                    arrayList.add(this.tags.type.get(i2).id);
                    i = i2 + 1;
                }
            }
            if (this.tags.character != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.tags.character.size()) {
                        break;
                    }
                    arrayList.add(this.tags.character.get(i4).id);
                    i3 = i4 + 1;
                }
            }
            if (this.tags.love_type != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= this.tags.love_type.size()) {
                        break;
                    }
                    arrayList.add(this.tags.love_type.get(i6).id);
                    i5 = i6 + 1;
                }
            }
            if (this.tags.i_want != null) {
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= this.tags.i_want.size()) {
                        break;
                    }
                    arrayList.add(this.tags.i_want.get(i8).id);
                    i7 = i8 + 1;
                }
            }
            if (this.tags.love_character != null) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= this.tags.love_character.size()) {
                        break;
                    }
                    arrayList.add(this.tags.love_character.get(i10).id);
                    i9 = i10 + 1;
                }
            }
        }
        return arrayList;
    }

    public UserTagAll getTags() {
        return this.tags;
    }

    public String getThird_access_token() {
        return this.third_access_token;
    }

    public String getThird_user_id() {
        return this.third_user_id;
    }

    public String getTotal_time() {
        return this.total_time;
    }

    public String getUid() {
        return TextUtils.isEmpty(this.uid) ? "0" : this.uid;
    }

    public int getVBadge() {
        return this.vbadge;
    }

    public BluedLoginResultVerBinding getVerified_bindings() {
        return this.verified_bindings;
    }

    public VerifyStatus[] getVerify() {
        return this.verify;
    }

    public List<BluedAlbum> getVip_avatars() {
        return this.vip_avatars;
    }

    public String getVisited_count() {
        return this.visited_count;
    }

    public String getWeibo() {
        return this.weibo;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getWeixin() {
        return this.weixin;
    }

    public void removeBlackCount() {
        try {
            int parseInt = Integer.parseInt(this.black_count);
            StringBuilder sb = new StringBuilder();
            int i = parseInt - 1;
            int i2 = i;
            if (i < 0) {
                i2 = 0;
            }
            sb.append(i2);
            sb.append("");
            this.black_count = sb.toString();
        } catch (Exception e) {
        }
    }

    public void removeUserBlackCount() {
        int i;
        String blackCount = getBlackCount();
        String str = blackCount;
        if (TextUtils.isEmpty(blackCount)) {
            str = "0";
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            i = 0;
        }
        int i2 = i;
        if (i >= 1) {
            i2 = i - 1;
        }
        setBlackCount(i2 + "");
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public void setAlbum(List<BluedAlbum> list) {
        this.album = list;
    }

    public void setAstro(String str) {
        this.astro = str;
    }

    public void setAttentionCount(int i) {
        setFollowedCount(dealCountInt(getFollowedCount(), i));
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatar_pid(String str) {
        this.avatar_pid = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setBlackCount(String str) {
        this.black_count = str;
    }

    public void setBlackMax(String str) {
        this.black_allowed_count = str;
    }

    public void setBlacklist(String[] strArr) {
        this.blacklist = strArr;
    }

    public void setBlood_type(String str) {
        this.blood_type = str;
    }

    public void setChinese_zodiac(String str) {
        this.chinese_zodiac = str;
    }

    public void setCity_settled(String str) {
        this.city_settled = str;
    }

    public void setCustom(String str) {
        this.custom = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDevice_safe(int i) {
        this.device_safe = i;
    }

    public void setDevice_token(String str) {
        this.device_token = str;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setEducation(String str) {
        this.education = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEncrypted(String str) {
        this.encrypted = str;
    }

    public void setEthnicity(String str) {
        this.ethnicity = str;
    }

    public void setFansCount(int i) {
        setFollowerCount(dealCountInt(getFollowerCount(), i));
    }

    public void setFollowedCount(String str) {
        this.followed_count = str;
    }

    public void setFollowerCount(String str) {
        this.followers_count = str;
    }

    public void setFriendCount(String str) {
        this.friends_count = str;
    }

    public void setFriendsCount(int i) {
        setFriendCount(dealCountInt(getFriendCount(), i));
    }

    public void setGroupsCount(int i) {
        setGroupsCount(dealCountInt(getGroupsCount(), i));
    }

    public void setGroupsCount(String str) {
        this.groups_count = str;
    }

    public void setHeaderVerifyStatus(UserHeaderVerifyStatus userHeaderVerifyStatus) {
        this.headerVerifyStatus = userHeaderVerifyStatus;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setHometown(String str) {
        this.hometown = str;
    }

    public void setHot(String str) {
        this.hot = str;
    }

    public void setIhate(String str) {
        this.ihate = str;
    }

    public void setIlike(String str) {
        this.ilike = str;
    }

    public void setIn_blacklist(String str) {
        this.in_blacklist = str;
    }

    public void setIndustry(String str) {
        this.industry = str;
    }

    public void setIs_access_follows(String str) {
        this.is_access_follows = str;
    }

    public void setIs_access_groups(String str) {
        this.is_access_groups = str;
    }

    public void setIs_auth_url(String str) {
        this.is_auth_url = str;
    }

    public void setIs_locked(String str) {
        this.is_locked = str;
    }

    public void setLast_login(String str) {
        this.last_login = str;
    }

    public void setLast_operate(String str) {
        this.last_operate = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLock_until(String str) {
        this.lock_until = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMate(String str) {
        this.mate = str;
    }

    public void setMyTicktocksCount(String str) {
        this.my_ticktocks_count = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedAdultVerify(int i) {
        this.is_kids = i;
    }

    public void setNeed_auth(int i) {
        this.need_auth = i;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setOnline_state(String str) {
        this.online_state = str;
    }

    public void setPhotos_count(int i) {
        this.photos_count = i;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setQq(String str) {
        this.qq = str;
    }

    public void setRed_ribbon(String str) {
        this.red_ribbon = str;
    }

    public void setRed_ribbon_link(String str) {
        this.red_ribbon_link = str;
    }

    public void setReg_date(String str) {
        this.reg_date = str;
    }

    public void setRelationship(String str) {
        this.relationship = str;
    }

    public void setRich_level(int i) {
        this.rich_level = i;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setTags(UserTagAll userTagAll) {
        this.tags = userTagAll;
    }

    public void setThird_access_token(String str) {
        this.third_access_token = str;
    }

    public void setThird_user_id(String str) {
        this.third_access_token = str;
    }

    public void setTotal_time(String str) {
        this.total_time = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVBadge(int i) {
        this.vbadge = i;
    }

    public void setVerified_bindings(BluedLoginResultVerBinding bluedLoginResultVerBinding) {
        this.verified_bindings = bluedLoginResultVerBinding;
    }

    public void setVerify(VerifyStatus[] verifyStatusArr) {
        this.verify = verifyStatusArr;
    }

    public void setVip_avatars(List<BluedAlbum> list) {
        this.vip_avatars = list;
    }

    public void setVisited_count(String str) {
        this.visited_count = str;
    }

    public void setWeibo(String str) {
        this.weibo = str;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public void setWeixin(String str) {
        this.weixin = str;
    }
}

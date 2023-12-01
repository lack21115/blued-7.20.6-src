package com.blued.community.model;

import com.blued.community.ui.send.model.FeedIntroduceModel;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.ui.send.model.FeedTemplateTitleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/NearbyGuideModel.class */
public final class NearbyGuideModel implements Serializable {
    private NearbyGuideSubTopicModel admin_topic_data;
    private String avatar;
    private String birthday;
    private ArrayList<FeedPostSignStateItem> bubble_data;
    private String button;
    private ArrayList<TagModel> character;
    private ArrayList<TagModel> hobbies;
    private ArrayList<TagModel> i_type;
    private ArrayList<TagModel> i_want;
    private String image;
    private int leave_one;
    private ArrayList<FeedIntroduceModel> oneself_describe;
    private String popup_name;
    private ArrayList<FeedTemplateTitleModel> questionnaire_data;
    private int subType;
    private String subheading;
    private String text;
    private String title;
    private BluedTopic topics_data;
    private int type;
    private String url;
    private FeedTemplateTitleModel usedQaModel;
    private BluedTopic usedTopicModel;

    public final NearbyGuideSubTopicModel getAdmin_topic_data() {
        return this.admin_topic_data;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final ArrayList<FeedPostSignStateItem> getBubble_data() {
        return this.bubble_data;
    }

    public final String getButton() {
        return this.button;
    }

    public final ArrayList<TagModel> getCharacter() {
        return this.character;
    }

    public final ArrayList<TagModel> getHobbies() {
        return this.hobbies;
    }

    public final ArrayList<TagModel> getI_type() {
        return this.i_type;
    }

    public final ArrayList<TagModel> getI_want() {
        return this.i_want;
    }

    public final String getImage() {
        return this.image;
    }

    public final int getLeave_one() {
        return this.leave_one;
    }

    public final ArrayList<FeedIntroduceModel> getOneself_describe() {
        return this.oneself_describe;
    }

    public final String getPopup_name() {
        return this.popup_name;
    }

    public final ArrayList<FeedTemplateTitleModel> getQuestionnaire_data() {
        return this.questionnaire_data;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final String getSubheading() {
        return this.subheading;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final BluedTopic getTopics_data() {
        return this.topics_data;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final FeedTemplateTitleModel getUsedQaModel() {
        return this.usedQaModel;
    }

    public final BluedTopic getUsedTopicModel() {
        return this.usedTopicModel;
    }

    public final void setAdmin_topic_data(NearbyGuideSubTopicModel nearbyGuideSubTopicModel) {
        this.admin_topic_data = nearbyGuideSubTopicModel;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setBirthday(String str) {
        this.birthday = str;
    }

    public final void setBubble_data(ArrayList<FeedPostSignStateItem> arrayList) {
        this.bubble_data = arrayList;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final void setCharacter(ArrayList<TagModel> arrayList) {
        this.character = arrayList;
    }

    public final void setHobbies(ArrayList<TagModel> arrayList) {
        this.hobbies = arrayList;
    }

    public final void setI_type(ArrayList<TagModel> arrayList) {
        this.i_type = arrayList;
    }

    public final void setI_want(ArrayList<TagModel> arrayList) {
        this.i_want = arrayList;
    }

    public final void setImage(String str) {
        this.image = str;
    }

    public final void setLeave_one(int i) {
        this.leave_one = i;
    }

    public final void setOneself_describe(ArrayList<FeedIntroduceModel> arrayList) {
        this.oneself_describe = arrayList;
    }

    public final void setPopup_name(String str) {
        this.popup_name = str;
    }

    public final void setQuestionnaire_data(ArrayList<FeedTemplateTitleModel> arrayList) {
        this.questionnaire_data = arrayList;
    }

    public final void setSubType(int i) {
        this.subType = i;
    }

    public final void setSubheading(String str) {
        this.subheading = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTopics_data(BluedTopic bluedTopic) {
        this.topics_data = bluedTopic;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setUsedQaModel(FeedTemplateTitleModel feedTemplateTitleModel) {
        this.usedQaModel = feedTemplateTitleModel;
    }

    public final void setUsedTopicModel(BluedTopic bluedTopic) {
        this.usedTopicModel = bluedTopic;
    }
}

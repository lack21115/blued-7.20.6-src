package com.sobot.chat.utils;

import com.sobot.chat.api.enumtype.CustomerState;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ZhiChiConfig.class */
public class ZhiChiConfig implements Serializable {
    public String currentUserName;
    public boolean inPolling;
    public String tempMsgContent;
    public List<String> cids = new ArrayList();
    public int currentCidPosition = 0;
    public int queryCidsStatus = 0;
    public boolean isShowUnreadUi = true;
    private ZhiChiInitModeBase initModel = null;
    private List<ZhiChiMessageBase> messageList = new ArrayList();
    public int current_client_model = 301;
    public String activityTitle = null;
    public CustomerState customerState = CustomerState.Offline;
    public boolean isAboveZero = false;
    public boolean isComment = false;
    public int remindRobotMessageTimes = 0;
    public String adminFace = "";
    public int paseReplyTimeCustoms = 0;
    public boolean customTimeTask = false;
    public int paseReplyTimeUserInfo = 0;
    public boolean userInfoTimeTask = false;
    public int isChatLock = 0;
    public boolean isNoMoreHistoryMsg = false;
    public int showTimeVisiableCustomBtn = 0;
    public int queueNum = 0;
    public boolean isShowQueueTip = true;
    public boolean isProcessAutoSendMsg = false;
    public int bottomViewtype = 0;

    private void removeByAction(List<ZhiChiMessageBase> list, ZhiChiMessageBase zhiChiMessageBase, String str, String str2) {
        if (zhiChiMessageBase.getAction() == null || !zhiChiMessageBase.getAction().equals(str)) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            if (list.get(i2).getAction() != null && list.get(i2).getAction().equals(str2)) {
                list.remove(i2);
            }
            i = i2 + 1;
        }
    }

    public void addMessage(ZhiChiMessageBase zhiChiMessageBase) {
        List<ZhiChiMessageBase> list;
        if (zhiChiMessageBase == null || (list = this.messageList) == null) {
            return;
        }
        removeByAction(list, zhiChiMessageBase, ZhiChiConstant.action_remind_info_paidui, ZhiChiConstant.action_remind_info_paidui);
        removeByAction(this.messageList, zhiChiMessageBase, ZhiChiConstant.action_remind_connt_success, ZhiChiConstant.action_remind_info_paidui);
        removeByAction(this.messageList, zhiChiMessageBase, ZhiChiConstant.action_custom_evaluate, ZhiChiConstant.action_custom_evaluate);
        removeByAction(this.messageList, zhiChiMessageBase, ZhiChiConstant.action_remind_connt_success, ZhiChiConstant.action_remind_info_post_msg);
        this.messageList.add(zhiChiMessageBase);
    }

    public void clearCache() {
        clearMessageList();
        clearInitModel();
        this.current_client_model = 301;
        this.cids = null;
        this.currentCidPosition = 0;
        this.queryCidsStatus = 0;
        this.activityTitle = null;
        this.customerState = CustomerState.Offline;
        this.remindRobotMessageTimes = 0;
        this.bottomViewtype = -1;
        this.isAboveZero = false;
        this.isComment = false;
        this.adminFace = "";
        this.paseReplyTimeCustoms = 0;
        this.customTimeTask = false;
        this.paseReplyTimeUserInfo = 0;
        this.isChatLock = 0;
        this.userInfoTimeTask = false;
        this.currentUserName = null;
        this.isNoMoreHistoryMsg = false;
        this.showTimeVisiableCustomBtn = 0;
        this.queueNum = 0;
        this.isShowUnreadUi = true;
        this.isShowQueueTip = true;
        this.isProcessAutoSendMsg = false;
        this.tempMsgContent = "";
    }

    public void clearInitModel() {
        if (this.initModel != null) {
            this.initModel = null;
        }
    }

    public void clearMessageList() {
        List<ZhiChiMessageBase> list = this.messageList;
        if (list != null) {
            list.clear();
        }
    }

    public ZhiChiInitModeBase getInitModel() {
        return this.initModel;
    }

    public List<ZhiChiMessageBase> getMessageList() {
        return this.messageList;
    }

    public void hideItemTransferBtn() {
        if (this.messageList == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.messageList.size()) {
                return;
            }
            this.messageList.get(i2).setShowTransferBtn(false);
            i = i2 + 1;
        }
    }

    public void setInitModel(ZhiChiInitModeBase zhiChiInitModeBase) {
        this.initModel = zhiChiInitModeBase;
    }

    public void setMessageList(List<ZhiChiMessageBase> list) {
        List<ZhiChiMessageBase> list2;
        if (list == null || (list2 = this.messageList) == null) {
            return;
        }
        list2.clear();
        this.messageList.addAll(list);
        int size = this.messageList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            if (this.messageList.get(i).getSendSuccessState() == 4) {
                this.messageList.remove(i);
            } else if (this.messageList.get(i).getSendSuccessState() == 2) {
                this.messageList.get(i).setSendSuccessState(0);
            } else if (this.messageList.get(i).getAnswer() != null && 7 == this.messageList.get(i).getAnswer().getRemindType()) {
                this.messageList.remove(i);
            }
            size = i;
        }
    }

    public String toString() {
        return "ZhiChiConfig{cids=" + this.cids + ", currentCidPosition=" + this.currentCidPosition + ", queryCidsStatus=" + this.queryCidsStatus + ", isShowUnreadUi=" + this.isShowUnreadUi + ", initModel=" + this.initModel + ", messageList=" + this.messageList + ", current_client_model=" + this.current_client_model + ", activityTitle='" + this.activityTitle + "', customerState=" + this.customerState + ", isAboveZero=" + this.isAboveZero + ", isComment=" + this.isComment + ", remindRobotMessageTimes=" + this.remindRobotMessageTimes + ", adminFace='" + this.adminFace + "', paseReplyTimeCustoms=" + this.paseReplyTimeCustoms + ", customTimeTask=" + this.customTimeTask + ", paseReplyTimeUserInfo=" + this.paseReplyTimeUserInfo + ", userInfoTimeTask=" + this.userInfoTimeTask + ", isChatLock=" + this.isChatLock + ", isNoMoreHistoryMsg=" + this.isNoMoreHistoryMsg + ", showTimeVisiableCustomBtn=" + this.showTimeVisiableCustomBtn + ", currentUserName='" + this.currentUserName + "', queueNum=" + this.queueNum + ", isShowQueueTip=" + this.isShowQueueTip + ", isProcessAutoSendMsg=" + this.isProcessAutoSendMsg + ", bottomViewtype=" + this.bottomViewtype + '}';
    }
}

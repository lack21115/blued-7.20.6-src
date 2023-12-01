package com.sobot.chat.api;

import android.content.Context;
import com.sobot.chat.api.model.BaseCode;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.CommonModelBase;
import com.sobot.chat.api.model.ConsultingContent;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.OrderCardContentModel;
import com.sobot.chat.api.model.PostParamModel;
import com.sobot.chat.api.model.SatisfactionSet;
import com.sobot.chat.api.model.SobotCityResult;
import com.sobot.chat.api.model.SobotCommentParam;
import com.sobot.chat.api.model.SobotConnCusParam;
import com.sobot.chat.api.model.SobotLableInfoList;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotLeaveMsgParamModel;
import com.sobot.chat.api.model.SobotLeaveReplyModel;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.SobotOfflineLeaveMsgModel;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.api.model.SobotQueryFormModel;
import com.sobot.chat.api.model.SobotQuestionRecommend;
import com.sobot.chat.api.model.SobotRobot;
import com.sobot.chat.api.model.SobotRobotGuess;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.api.model.SobotUserTicketInfoFlag;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.api.model.StHelpDocModel;
import com.sobot.chat.api.model.StUserDealTicketInfo;
import com.sobot.chat.api.model.ZhiChiCidsModel;
import com.sobot.chat.api.model.ZhiChiGroup;
import com.sobot.chat.api.model.ZhiChiHistoryMessage;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiWorkModel;
import com.sobot.network.http.callback.StringResultCallBack;
import com.sobot.network.http.upload.SobotUploadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/ZhiChiApi.class */
public interface ZhiChiApi {
    void addTicketSatisfactionScoreInfo(Object obj, String str, String str2, String str3, int i, String str4, StringResultCallBack<String> stringResultCallBack);

    SobotUploadTask addUploadFileTask(boolean z, String str, String str2, String str3, String str4, String str5);

    void authSensitive(Object obj, String str, String str2, StringResultCallBack<CommonModel> stringResultCallBack);

    void chatSendMsgToRoot(String str, String str2, int i, String str3, String str4, String str5, Map<String, String> map, StringResultCallBack<ZhiChiMessageBase> stringResultCallBack);

    void checkUserTicketInfo(Object obj, String str, String str2, String str3, StringResultCallBack<SobotUserTicketInfoFlag> stringResultCallBack);

    void comment(Object obj, String str, String str2, SobotCommentParam sobotCommentParam, StringResultCallBack<CommonModel> stringResultCallBack);

    void config(Object obj, String str);

    void connChannel(String str, String str2, String str3, String str4, String str5, String str6);

    void connnect(Object obj, SobotConnCusParam sobotConnCusParam, StringResultCallBack<ZhiChiMessageBase> stringResultCallBack);

    void deleteHisMsg(Object obj, String str, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void disconnChannel();

    void fileUploadForPostMsg(Object obj, String str, String str2, String str3, ResultCallBack<ZhiChiMessage> resultCallBack);

    void getCategoryList(Object obj, String str, StringResultCallBack<List<StCategoryModel>> stringResultCallBack);

    void getChatDetailByCid(Object obj, String str, String str2, StringResultCallBack<ZhiChiHistoryMessage> stringResultCallBack);

    void getGroupList(Object obj, String str, String str2, StringResultCallBack<ZhiChiGroup> stringResultCallBack);

    void getHelpDocByCategoryId(Object obj, String str, String str2, StringResultCallBack<List<StDocModel>> stringResultCallBack);

    void getHelpDocByDocId(Object obj, String str, String str2, StringResultCallBack<StHelpDocModel> stringResultCallBack);

    void getLableInfoList(Object obj, String str, StringResultCallBack<List<SobotLableInfoList>> stringResultCallBack);

    void getLeavePostOfflineConfig(Object obj, String str, String str2, StringResultCallBack<SobotOfflineLeaveMsgModel> stringResultCallBack);

    void getMsgTemplateConfig(Object obj, String str, String str2, StringResultCallBack<SobotLeaveMsgConfig> stringResultCallBack);

    List<SobotMsgCenterModel> getPlatformList(Object obj, String str, String str2) throws Exception;

    void getRobotSwitchList(Object obj, String str, StringResultCallBack<List<SobotRobot>> stringResultCallBack);

    void getTemplateFieldsInfo(Object obj, String str, String str2, StringResultCallBack<SobotLeaveMsgParamModel> stringResultCallBack);

    void getUserDealTicketInfoList(Object obj, String str, String str2, String str3, StringResultCallBack<List<StUserDealTicketInfo>> stringResultCallBack);

    void getUserTicketInfoList(Object obj, String str, String str2, String str3, StringResultCallBack<List<SobotUserTicketInfo>> stringResultCallBack);

    void getUserTicketReplyInfo(Object obj, String str, String str2, StringResultCallBack<List<SobotLeaveReplyModel>> stringResultCallBack);

    void getWsTemplate(Object obj, String str, String str2, StringResultCallBack<ArrayList<SobotPostMsgTemplate>> stringResultCallBack);

    void input(String str, String str2, StringResultCallBack<CommonModel> stringResultCallBack);

    void insertSysMsg(Object obj, String str, String str2, String str3, String str4, StringResultCallBack<BaseCode> stringResultCallBack);

    void isWork(String str, String str2, StringResultCallBack<ZhiChiWorkModel> stringResultCallBack);

    void leaveMsg(Object obj, String str, String str2, String str3, StringResultCallBack<BaseCode> stringResultCallBack);

    void logCollect(Context context, String str, boolean z);

    void msgAck(Object obj, Map map, StringResultCallBack<BaseCode> stringResultCallBack);

    void out(String str, String str2, StringResultCallBack<CommonModel> stringResultCallBack);

    void pollingMsg(Object obj, Map map, String str, StringResultCallBack<BaseCode> stringResultCallBack);

    void postMsg(Object obj, PostParamModel postParamModel, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void queryCids(Object obj, String str, long j, StringResultCallBack<ZhiChiCidsModel> stringResultCallBack);

    void queryCity(Object obj, String str, String str2, StringResultCallBack<SobotCityResult> stringResultCallBack);

    void queryFormConfig(Object obj, String str, StringResultCallBack<SobotQueryFormModel> stringResultCallBack);

    void questionRecommend(Object obj, String str, Map<String, String> map, StringResultCallBack<SobotQuestionRecommend> stringResultCallBack);

    void rbAnswerComment(Object obj, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void reconnectChannel();

    void removeMerchant(Object obj, String str, String str2, SobotMsgCenterModel sobotMsgCenterModel, StringResultCallBack<SobotMsgCenterModel> stringResultCallBack);

    void replyTicketContent(Object obj, String str, String str2, String str3, String str4, String str5, StringResultCallBack<String> stringResultCallBack);

    void robotGuess(Object obj, String str, String str2, String str3, StringResultCallBack<SobotRobotGuess> stringResultCallBack);

    void robotGuide(Object obj, String str, String str2, int i, StringResultCallBack<ZhiChiMessageBase> stringResultCallBack);

    void satisfactionMessage(Object obj, String str, ResultCallBack<SatisfactionSet> resultCallBack);

    void sendCardMsg(ConsultingContent consultingContent, String str, String str2, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void sendFile(String str, String str2, String str3, String str4, ResultCallBack<ZhiChiMessage> resultCallBack);

    void sendLocation(Object obj, SobotLocationModel sobotLocationModel, String str, String str2, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void sendMsgToCoutom(String str, String str2, String str3, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void sendOrderCardMsg(OrderCardContentModel orderCardContentModel, String str, String str2, StringResultCallBack<CommonModelBase> stringResultCallBack);

    void sendVoiceToRobot(String str, String str2, String str3, String str4, String str5, ResultCallBack<ZhiChiMessage> resultCallBack);

    void sobotInit(Object obj, Information information, StringResultCallBack<ZhiChiInitModeBase> stringResultCallBack);

    void submitForm(Object obj, String str, String str2, StringResultCallBack<CommonModel> stringResultCallBack);

    void updateUserTicketReplyInfo(Object obj, String str, String str2, String str3);
}

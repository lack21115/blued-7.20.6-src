package com.sobot.chat.api;

import android.content.Context;
import android.content.Intent;
import android.content.res.ThemeConfig;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.UserDictionary;
import android.telecom.PhoneAccount;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.d.a.b;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.ao;
import com.huawei.openalliance.ad.constant.at;
import com.opos.acs.st.STManager;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.apiUtils.HttpUtilsTools;
import com.sobot.chat.api.apiUtils.SobotBaseUrl;
import com.sobot.chat.api.apiUtils.ZhiChiUrlApi;
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
import com.sobot.chat.api.model.SobotConfigModel;
import com.sobot.chat.api.model.SobotConfigResult;
import com.sobot.chat.api.model.SobotConnCusParam;
import com.sobot.chat.api.model.SobotLableInfoList;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotLeaveMsgConfigResult;
import com.sobot.chat.api.model.SobotLeaveMsgParamBaseModel;
import com.sobot.chat.api.model.SobotLeaveMsgParamModel;
import com.sobot.chat.api.model.SobotLeaveReplyModel;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.SobotOfflineLeaveMsgBaseModel;
import com.sobot.chat.api.model.SobotOfflineLeaveMsgModel;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.api.model.SobotPostMsgTemplateResult;
import com.sobot.chat.api.model.SobotQueryFormModel;
import com.sobot.chat.api.model.SobotQueryFormModelResult;
import com.sobot.chat.api.model.SobotQuestionRecommend;
import com.sobot.chat.api.model.SobotQuestionRecommendResult;
import com.sobot.chat.api.model.SobotRobot;
import com.sobot.chat.api.model.SobotRobotGuess;
import com.sobot.chat.api.model.SobotRobotGuessResult;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.api.model.SobotUserTicketInfoFlag;
import com.sobot.chat.api.model.SobotUserTicketInfoResult;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.api.model.StHelpDocModel;
import com.sobot.chat.api.model.StUserDealTicketInfo;
import com.sobot.chat.api.model.StUserDealTicketInfoResult;
import com.sobot.chat.api.model.ZhiChiCidsModel;
import com.sobot.chat.api.model.ZhiChiCidsModelResult;
import com.sobot.chat.api.model.ZhiChiGroup;
import com.sobot.chat.api.model.ZhiChiHistoryMessage;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiInitModel;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiWorkModel;
import com.sobot.chat.api.model.ZhiChiWorkResult;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.Const;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.core.channel.SobotTCPServer;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.SobotExecutorService;
import com.sobot.chat.utils.SobotJsonUtils;
import com.sobot.chat.utils.StServiceUtils;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.callback.StringResultCallBack;
import com.sobot.network.http.upload.SobotUploadTask;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/ZhiChiApiImpl.class */
public class ZhiChiApiImpl implements ZhiChiApi {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14410a = ZhiChiApiImpl.class.getSimpleName() + "";
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f14411c = "2";
    private String d = ZhiChiUrlApi.VERSION;

    private ZhiChiApiImpl() {
    }

    public ZhiChiApiImpl(Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Exception exc, final String str, final StringResultCallBack stringResultCallBack) {
        SobotOkHttpUtils.getInstance().getDelivery().post(new Runnable() { // from class: com.sobot.chat.api.ZhiChiApiImpl.48
            @Override // java.lang.Runnable
            public void run() {
                stringResultCallBack.onFailure(exc, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Object obj, final StringResultCallBack stringResultCallBack) {
        SobotOkHttpUtils.getInstance().getDelivery().post(new Runnable() { // from class: com.sobot.chat.api.ZhiChiApiImpl.49
            @Override // java.lang.Runnable
            public void run() {
                stringResultCallBack.onSuccess(obj);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void addTicketSatisfactionScoreInfo(Object obj, String str, String str2, String str3, int i, String str4, final StringResultCallBack<String> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "ws/addTicketSatisfactionScoreInfo/4 ");
        hashMap.put("method", "post");
        hashMap.put("uid", str);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, "{\"ticketId\":\"" + str3 + "\",\"score\":\"" + i + "\",\"remark\":\"" + str4 + "\",\"companyId\":\"" + str2 + "\"}");
        StringBuilder sb = new StringBuilder();
        sb.append(SobotBaseUrl.getBaseIp());
        sb.append(ZhiChiUrlApi.invokeOtherByUser);
        HttpUtilsTools.doPost(obj, sb.toString(), hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.38
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i2) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str5, int i2) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str5, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str5) {
                LogUtils.i("addTicketSatisfactionScoreInfo---" + str5);
                stringResultCallBack.onSuccess(str5);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public SobotUploadTask addUploadFileTask(boolean z, String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb;
        String str6;
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("cid", str3);
        HttpUtils httpUtils = HttpUtils.getInstance();
        if (z) {
            sb = new StringBuilder();
            sb.append(SobotBaseUrl.getBaseIp());
            str6 = ZhiChiUrlApi.sendVideo;
        } else {
            sb = new StringBuilder();
            sb.append(SobotBaseUrl.getBaseIp());
            str6 = ZhiChiUrlApi.uploadFile;
        }
        sb.append(str6);
        return httpUtils.addUploadFileTask(str, sb.toString(), hashMap, str4, str5);
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void authSensitive(Object obj, String str, String str2, final StringResultCallBack<CommonModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("type", str2);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.authSensitive, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.47
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel == null || !"1".equals(jsonToCommonModel.getCode())) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToCommonModel);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void chatSendMsgToRoot(String str, String str2, int i, String str3, String str4, String str5, Map<String, String> map, final StringResultCallBack<ZhiChiMessageBase> stringResultCallBack) {
        final String stackTraceString = Log.getStackTraceString(new Throwable());
        final HashMap hashMap = new HashMap();
        String str6 = str3;
        if (TextUtils.isEmpty(str3)) {
            str6 = str2;
        }
        if (i == 1) {
            hashMap.put("requestText", str2);
            hashMap.put("question", str6);
        } else {
            hashMap.put("requestText", str6);
            hashMap.put("question", str2);
        }
        hashMap.put("questionFlag", i + "");
        hashMap.put("uid", str4);
        hashMap.put("cid", str5);
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        hashMap.put("robotFlag", str);
        if (map != null) {
            hashMap.putAll(map);
        }
        HttpUtilsTools.doPost(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_sendMessage, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.23
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i2) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str7, int i2) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口异常", "请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_sendMessage + "  请求参数-->" + hashMap + "  请求异常信息: --> " + str7 + "------" + exc.getMessage() + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求异常");
                stringResultCallBack.onFailure(exc, str7);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str7) {
                ZhiChiMessage jsonToZhiChiMessage = GsonUtil.jsonToZhiChiMessage(str7);
                if (jsonToZhiChiMessage != null && !TextUtils.isEmpty(jsonToZhiChiMessage.getCode()) && 1 == Integer.parseInt(jsonToZhiChiMessage.getCode()) && jsonToZhiChiMessage.getData() != null) {
                    stringResultCallBack.onSuccess(jsonToZhiChiMessage.getData());
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口失败", "  请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_sendMessage + "  请求参数-->" + hashMap + "  请求结果: --> " + str7 + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求失败");
                stringResultCallBack.onFailure(new Exception(), "服务器错误");
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void checkUserTicketInfo(Object obj, String str, String str2, String str3, final StringResultCallBack<SobotUserTicketInfoFlag> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "ws/checkUserTicketInfo/4");
        hashMap.put("method", MonitorConstants.CONNECT_TYPE_GET);
        hashMap.put("uid", str);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, "{\"companyId\":\"" + str2 + "\",\"customerId\":\"" + str3 + "\"}");
        StringBuilder sb = new StringBuilder();
        sb.append(SobotBaseUrl.getBaseIp());
        sb.append(ZhiChiUrlApi.invokeOtherByUser);
        HttpUtilsTools.doPost(obj, sb.toString(), hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.32
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                LogUtils.i("checkUserTicketInfo---" + str4);
                SobotUserTicketInfoFlag jsonToSobotUserTicketInfoFlag = GsonUtil.jsonToSobotUserTicketInfoFlag(str4);
                if (jsonToSobotUserTicketInfoFlag == null || !"1".equals(jsonToSobotUserTicketInfoFlag.getCode())) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToSobotUserTicketInfoFlag);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void comment(Object obj, String str, String str2, SobotCommentParam sobotCommentParam, final StringResultCallBack<CommonModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("cid", str);
        hashMap.put(ao.q, str2);
        hashMap.put("type", sobotCommentParam.getType());
        hashMap.put("problem", sobotCommentParam.getProblem());
        hashMap.put("suggest", TextUtils.isEmpty(sobotCommentParam.getSuggest()) ? "" : sobotCommentParam.getSuggest().trim());
        hashMap.put("isresolve", sobotCommentParam.getIsresolve() + "");
        hashMap.put("commentType", sobotCommentParam.getCommentType() + "");
        hashMap.put("scoreFlag", sobotCommentParam.getScoreFlag() + "");
        if (!TextUtils.isEmpty(sobotCommentParam.getRobotFlag())) {
            hashMap.put("robotFlag", sobotCommentParam.getRobotFlag());
        }
        if (!TextUtils.isEmpty(sobotCommentParam.getScore())) {
            hashMap.put("source", sobotCommentParam.getScore());
        }
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_chat_comment, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.52
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("comment----" + str3);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel == null || jsonToCommonModel.getData() == null || !"1".equals(jsonToCommonModel.getCode())) {
                    return;
                }
                if ("1".equals(jsonToCommonModel.getData().getStatus()) || "2".equals(jsonToCommonModel.getData().getStatus())) {
                    stringResultCallBack.onSuccess(jsonToCommonModel);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void config(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context context = this.b;
        if (context != null) {
            LogUtils.init(context);
        }
        long longData = SharedPreferencesUtil.getLongData(this.b, ZhiChiConstant.SOBOT_CONFIG_LAST_UPDATE_TIME, -1L);
        long intData = SharedPreferencesUtil.getIntData(this.b, ZhiChiConstant.SOBOT_CONFIG_REQ_FREQUENCY, 2) * BaseConstants.Time.DAY;
        if (-1 == longData || System.currentTimeMillis() > longData + intData) {
            HashMap hashMap = new HashMap();
            hashMap.put("appId", str);
            HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.sobotConfig, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.21
                @Override // com.sobot.chat.core.HttpUtils.a
                public void a(int i) {
                }

                @Override // com.sobot.chat.core.HttpUtils.a
                public void a(Exception exc, String str2, int i) {
                    LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                }

                @Override // com.sobot.chat.core.HttpUtils.a
                public void a(String str2) {
                    LogUtils.i("sobotConfig---" + str2);
                    SobotConfigResult jsonToSobotConfigResult = GsonUtil.jsonToSobotConfigResult(str2);
                    if (jsonToSobotConfigResult == null || !"1".equals(jsonToSobotConfigResult.getCode()) || jsonToSobotConfigResult.getData() == null) {
                        return;
                    }
                    SobotConfigModel data = jsonToSobotConfigResult.getData();
                    SharedPreferencesUtil.saveLongData(ZhiChiApiImpl.this.b, ZhiChiConstant.SOBOT_CONFIG_LAST_UPDATE_TIME, System.currentTimeMillis());
                    SharedPreferencesUtil.saveIntData(ZhiChiApiImpl.this.b, ZhiChiConstant.SOBOT_CONFIG_REQ_FREQUENCY, data.reqFrequency);
                    SharedPreferencesUtil.saveStringData(ZhiChiApiImpl.this.b, ZhiChiConstant.SOBOT_CONFIG_COMPANYID, data.companyId);
                    SharedPreferencesUtil.saveBooleanData(ZhiChiApiImpl.this.b, ZhiChiConstant.SOBOT_CONFIG_REQ_COLLECTFLAG, data.collectFlag);
                    SharedPreferencesUtil.saveBooleanData(ZhiChiApiImpl.this.b, ZhiChiConstant.SOBOT_CONFIG_SUPPORT, data.support);
                }
            });
        }
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void connChannel(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.b == null || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        SharedPreferencesUtil.getStringData(this.b, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        Intent intent = new Intent(this.b, SobotTCPServer.class);
        intent.putExtra(Const.SOBOT_WSLINKBAK, str);
        intent.putExtra(Const.SOBOT_WSLINKDEFAULT, str2);
        intent.putExtra(Const.SOBOT_UID, str3);
        intent.putExtra(Const.SOBOT_PUID, str4);
        intent.putExtra(Const.SOBOT_APPKEY, str5);
        intent.putExtra(Const.SOBOT_WAYHTTP, str6);
        StServiceUtils.safeStartService(this.b, intent);
        SharedPreferencesUtil.saveStringData(this.b, Const.SOBOT_WSLINKBAK, str);
        SharedPreferencesUtil.saveStringData(this.b, Const.SOBOT_WSLINKDEFAULT, str2);
        SharedPreferencesUtil.saveStringData(this.b, Const.SOBOT_UID, str3);
        SharedPreferencesUtil.saveStringData(this.b, Const.SOBOT_PUID, str4);
        SharedPreferencesUtil.saveStringData(this.b, Const.SOBOT_APPKEY, str5);
        SharedPreferencesUtil.saveStringData(this.b, Const.SOBOT_WAYHTTP, str6);
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void connnect(Object obj, SobotConnCusParam sobotConnCusParam, final StringResultCallBack<ZhiChiMessageBase> stringResultCallBack) {
        final HashMap hashMap = new HashMap();
        final String stackTraceString = Log.getStackTraceString(new Throwable());
        hashMap.put("uid", sobotConnCusParam.getPartnerid());
        hashMap.put("cid", sobotConnCusParam.getCid());
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        hashMap.put("groupId", sobotConnCusParam.getGroupId());
        hashMap.put("groupName", sobotConnCusParam.getGroupName());
        hashMap.put("chooseAdminId", sobotConnCusParam.getChooseAdminId());
        hashMap.put("tranFlag", sobotConnCusParam.getTran_flag() + "");
        hashMap.put("current", sobotConnCusParam.isCurrentFlag() + "");
        hashMap.put("keyword", sobotConnCusParam.getKeyword());
        hashMap.put("keywordId", sobotConnCusParam.getKeywordId());
        hashMap.put("summaryParams", sobotConnCusParam.getSummary_params());
        hashMap.put("offlineMsgAdminId", sobotConnCusParam.getOfflineMsgAdminId());
        hashMap.put("isOfflineMsgConnect", sobotConnCusParam.getOfflineMsgConnectFlag() + "");
        hashMap.put("transferType", sobotConnCusParam.getTransferType() + "");
        if (!TextUtils.isEmpty(sobotConnCusParam.getTransferAction())) {
            hashMap.put("transferAction", sobotConnCusParam.getTransferAction());
        }
        if (sobotConnCusParam.is_queue_first()) {
            hashMap.put("queueFirst", "1");
        }
        hashMap.put("docId", sobotConnCusParam.getDocId());
        hashMap.put("unknownQuestion", sobotConnCusParam.getUnknownQuestion());
        hashMap.put("activeTransfer", sobotConnCusParam.getActiveTransfer());
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_transfer_people, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.12
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str, int i) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口异常", "请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_transfer_people + "  请求参数-->" + hashMap + "  请求异常信息: --> " + str + "------" + exc.getMessage() + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求异常");
                StringBuilder sb = new StringBuilder();
                sb.append(ZhiChiApiImpl.f14410a);
                sb.append(str);
                LogUtils.i(sb.toString(), exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str) {
                LogUtils.i("转人工返回值---：" + str);
                if (TextUtils.isEmpty(str)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("接口失败", "  请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_transfer_people + "  请求参数-->" + hashMap + "  请求结果: --> " + str + "调用过程 -->" + stackTraceString);
                    LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求失败");
                    stringResultCallBack.onFailure(new IllegalStateException(), "");
                    return;
                }
                ZhiChiMessage jsonToZhiChiMessage = GsonUtil.jsonToZhiChiMessage(str);
                if (jsonToZhiChiMessage != null && jsonToZhiChiMessage.getData() != null) {
                    if (!TextUtils.isEmpty(jsonToZhiChiMessage.getMsg())) {
                        jsonToZhiChiMessage.getData().setMsg(jsonToZhiChiMessage.getMsg());
                    }
                    stringResultCallBack.onSuccess(jsonToZhiChiMessage.getData());
                    return;
                }
                HashMap hashMap3 = new HashMap();
                hashMap3.put("接口失败", "  请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_transfer_people + "  请求参数-->" + hashMap + "  请求结果: --> " + str + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap3, "请求失败");
                stringResultCallBack.onFailure(new IllegalStateException(), "");
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void deleteHisMsg(Object obj, String str, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_delete_history_msg, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.5
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                stringResultCallBack.onFailure(exc, str2);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("deleteHisMsg---" + str2);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str2);
                if (jsonToCommonModel == null || jsonToCommonModel.getData() == null) {
                    return;
                }
                stringResultCallBack.onSuccess(jsonToCommonModel.getData());
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void disconnChannel() {
        CommonUtils.sendLocalBroadcast(this.b, new Intent(Const.SOBOT_CHAT_DISCONNCHANNEL));
        this.b.stopService(new Intent(this.b, SobotTCPServer.class));
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void fileUploadForPostMsg(Object obj, String str, String str2, String str3, final ResultCallBack<ZhiChiMessage> resultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("companyId", str);
        hashMap.put("uid", str2);
        final long totalSpace = new File(str3).getTotalSpace();
        HttpUtilsTools.uploadFile(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_fileUploadForPostMsg, hashMap, str3, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.11
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
                resultCallBack.onLoading(totalSpace, i, true);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
                resultCallBack.onFailure(exc, "网络错误");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                LogUtils.i("sendFile---" + str4);
                ZhiChiMessage jsonToZhiChiMessage = GsonUtil.jsonToZhiChiMessage(str4);
                if (jsonToZhiChiMessage == null) {
                    resultCallBack.onFailure(new Exception(), "服务器错误");
                } else if (1 == Integer.parseInt(jsonToZhiChiMessage.getCode())) {
                    resultCallBack.onSuccess(jsonToZhiChiMessage);
                } else {
                    resultCallBack.onFailure(new Exception(), "文件不能大于20M");
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getCategoryList(Object obj, String str, final StringResultCallBack<List<StCategoryModel>> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getCategoryList, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.33
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("getCategoryList---" + str2);
                BaseCode<List<StCategoryModel>> jsonToStCategoryModelResult = GsonUtil.jsonToStCategoryModelResult(str2);
                if (jsonToStCategoryModelResult == null || !"1".equals(jsonToStCategoryModelResult.getCode()) || jsonToStCategoryModelResult.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToStCategoryModelResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getChatDetailByCid(Object obj, String str, String str2, final StringResultCallBack<ZhiChiHistoryMessage> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("cid", str2);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_historyMessage_cid, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.8
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                ZhiChiHistoryMessage jsonToZhiChiHistoryMessage = GsonUtil.jsonToZhiChiHistoryMessage(str3);
                if (jsonToZhiChiHistoryMessage == null || !"1".equals(jsonToZhiChiHistoryMessage.getCode())) {
                    stringResultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    stringResultCallBack.onSuccess(jsonToZhiChiHistoryMessage);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getGroupList(Object obj, String str, String str2, final StringResultCallBack<ZhiChiGroup> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put(ao.q, str2);
        hashMap.put("source", "2");
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_group_list, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.2
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                ZhiChiGroup jsonToZhiChiGroup = GsonUtil.jsonToZhiChiGroup(str3);
                if (jsonToZhiChiGroup != null) {
                    stringResultCallBack.onSuccess(jsonToZhiChiGroup);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getHelpDocByCategoryId(Object obj, String str, String str2, final StringResultCallBack<List<StDocModel>> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put(STManager.KEY_CATEGORY_ID, str2);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getHelpDocByCategoryId, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.35
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("getHelpDocByCategoryId---" + str3);
                BaseCode<List<StDocModel>> jsonToStDocModelResult = GsonUtil.jsonToStDocModelResult(str3);
                if (jsonToStDocModelResult == null || !"1".equals(jsonToStDocModelResult.getCode()) || jsonToStDocModelResult.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToStDocModelResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getHelpDocByDocId(Object obj, String str, String str2, final StringResultCallBack<StHelpDocModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("docId", str2);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getHelpDocByDocId, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.36
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("getHelpDocByDocId---" + str3);
                BaseCode<StHelpDocModel> jsonToStHelpDocModelResult = GsonUtil.jsonToStHelpDocModelResult(str3);
                if (jsonToStHelpDocModelResult == null || !"1".equals(jsonToStHelpDocModelResult.getCode()) || jsonToStHelpDocModelResult.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToStHelpDocModelResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getLableInfoList(Object obj, String str, final StringResultCallBack<List<SobotLableInfoList>> stringResultCallBack) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getLableInfoList, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.24
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("getLableInfoList---" + str2);
                List<SobotLableInfoList> jsonToLableInfoList = GsonUtil.jsonToLableInfoList(str2);
                if (jsonToLableInfoList == null || jsonToLableInfoList.size() <= 0) {
                    stringResultCallBack.onFailure(new IllegalStateException(), "");
                } else {
                    stringResultCallBack.onSuccess(jsonToLableInfoList);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getLeavePostOfflineConfig(Object obj, String str, String str2, final StringResultCallBack<SobotOfflineLeaveMsgModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("groupId", str2);
        hashMap.put("uid", str);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_get_leavemsg_config, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.42
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                SobotOfflineLeaveMsgBaseModel jsonToOfflineLeaveMsgModel = GsonUtil.jsonToOfflineLeaveMsgModel(str3);
                if (jsonToOfflineLeaveMsgModel == null || !"1".equals(jsonToOfflineLeaveMsgModel.getCode()) || jsonToOfflineLeaveMsgModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToOfflineLeaveMsgModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getMsgTemplateConfig(Object obj, String str, String str2, final StringResultCallBack<SobotLeaveMsgConfig> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "basic-set/getMsgTemplateConfig/4");
        hashMap.put("method", MonitorConstants.CONNECT_TYPE_GET);
        hashMap.put("uid", str);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, "{\"templateId\":\"" + str2 + "\"}");
        StringBuilder sb = new StringBuilder();
        sb.append(SobotBaseUrl.getBaseIp());
        sb.append(ZhiChiUrlApi.invokeOtherByUser);
        HttpUtilsTools.doPost(obj, sb.toString(), hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.28
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("getCusMsgTemplateConfig---" + str3);
                SobotLeaveMsgConfigResult jsonToLeaveMsgConfigResult = GsonUtil.jsonToLeaveMsgConfigResult(str3);
                if (jsonToLeaveMsgConfigResult == null || !"1".equals(jsonToLeaveMsgConfigResult.getCode()) || jsonToLeaveMsgConfigResult.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToLeaveMsgConfigResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public List<SobotMsgCenterModel> getPlatformList(Object obj, String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String stringData = SharedPreferencesUtil.getStringData(this.b, ZhiChiConstant.SOBOT_PLATFORM_KEY, "");
        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, str);
        hashMap.put("partnerId", str2);
        hashMap.put("platformKey", stringData);
        Response doPostSync = HttpUtilsTools.doPostSync(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getPlatformList, hashMap);
        if (doPostSync.isSuccessful()) {
            String string = doPostSync.body().string();
            LogUtils.i("getPlatformList---" + string);
            return GsonUtil.jsonToMsgCenterModel(string);
        }
        return null;
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getRobotSwitchList(Object obj, String str, final StringResultCallBack<List<SobotRobot>> stringResultCallBack) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getRobotSwitchList, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.22
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("getRobotSwitchList---" + str2);
                List<SobotRobot> jsonToRobotListResult = GsonUtil.jsonToRobotListResult(str2);
                if (jsonToRobotListResult == null || jsonToRobotListResult.size() <= 0) {
                    stringResultCallBack.onFailure(new IllegalStateException(), "");
                } else {
                    stringResultCallBack.onSuccess(jsonToRobotListResult);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getTemplateFieldsInfo(Object obj, String str, String str2, final StringResultCallBack<SobotLeaveMsgParamModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "basic-set/getTemplateFieldsInfo/4");
        hashMap.put("method", MonitorConstants.CONNECT_TYPE_GET);
        hashMap.put("uid", str);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, "{\"templateId\":\"" + str2 + "\"}");
        StringBuilder sb = new StringBuilder();
        sb.append(SobotBaseUrl.getBaseIp());
        sb.append(ZhiChiUrlApi.invokeOtherByUser);
        HttpUtilsTools.doPost(obj, sb.toString(), hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.29
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                SobotLeaveMsgParamBaseModel jsonToLeaveMsgParamBaseModel = GsonUtil.jsonToLeaveMsgParamBaseModel(str3);
                if (jsonToLeaveMsgParamBaseModel == null || !"1".equals(jsonToLeaveMsgParamBaseModel.getCode()) || jsonToLeaveMsgParamBaseModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToLeaveMsgParamBaseModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getUserDealTicketInfoList(Object obj, String str, String str2, String str3, final StringResultCallBack<List<StUserDealTicketInfo>> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "ws/getUserDealTicketInfoList/4");
        hashMap.put("method", MonitorConstants.CONNECT_TYPE_GET);
        hashMap.put("uid", str);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, "{\"companyId\":\"" + str2 + "\",\"ticketId\":\"" + str3 + "\"}");
        StringBuilder sb = new StringBuilder();
        sb.append(SobotBaseUrl.getBaseIp());
        sb.append(ZhiChiUrlApi.invokeOtherByUser);
        HttpUtilsTools.doPost(obj, sb.toString(), hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.31
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                LogUtils.i("getUserDealTicketInfoList---" + str4);
                StUserDealTicketInfoResult jsonToStUserDealTicketInfoResult = GsonUtil.jsonToStUserDealTicketInfoResult(str4);
                if (jsonToStUserDealTicketInfoResult == null || !"1".equals(jsonToStUserDealTicketInfoResult.getCode()) || jsonToStUserDealTicketInfoResult.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToStUserDealTicketInfoResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getUserTicketInfoList(Object obj, String str, String str2, String str3, final StringResultCallBack<List<SobotUserTicketInfo>> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "ws/getUserTicketInfoList/4");
        hashMap.put("method", MonitorConstants.CONNECT_TYPE_GET);
        hashMap.put("uid", str);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, "{\"companyId\":\"" + str2 + "\",\"customerId\":\"" + str3 + "\",\"pageSize\":\"60\"}");
        StringBuilder sb = new StringBuilder();
        sb.append(SobotBaseUrl.getBaseIp());
        sb.append(ZhiChiUrlApi.invokeOtherByUser);
        HttpUtilsTools.doPost(obj, sb.toString(), hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.30
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                SobotUserTicketInfoResult jsonToSobotUserTicketInfoResult = GsonUtil.jsonToSobotUserTicketInfoResult(str4);
                if (jsonToSobotUserTicketInfoResult == null || !"1".equals(jsonToSobotUserTicketInfoResult.getCode()) || jsonToSobotUserTicketInfoResult.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToSobotUserTicketInfoResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getUserTicketReplyInfo(Object obj, String str, String str2, final StringResultCallBack<List<SobotLeaveReplyModel>> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("companyId", str);
        hashMap.put("partnerId", str2);
        final ArrayList arrayList = new ArrayList();
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getUserTicketReplyInfo, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.40
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("getUserTicketReplyInfo---" + str3);
                arrayList.clear();
                List<SobotLeaveReplyModel> jsonToLeaveReplyModelListResult = GsonUtil.jsonToLeaveReplyModelListResult(str3);
                if (jsonToLeaveReplyModelListResult != null && jsonToLeaveReplyModelListResult.size() > 0) {
                    arrayList.addAll(jsonToLeaveReplyModelListResult);
                }
                stringResultCallBack.onSuccess(arrayList);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void getWsTemplate(Object obj, String str, String str2, final StringResultCallBack<ArrayList<SobotPostMsgTemplate>> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("groupId", str2);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.getWsTemplate, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.27
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("getWsTemplate---" + str3);
                SobotPostMsgTemplateResult jsonToSobotPostMsgTemplate = GsonUtil.jsonToSobotPostMsgTemplate(str3);
                if (jsonToSobotPostMsgTemplate == null || 1 != Integer.parseInt(jsonToSobotPostMsgTemplate.getCode()) || jsonToSobotPostMsgTemplate.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToSobotPostMsgTemplate.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void input(String str, String str2, final StringResultCallBack<CommonModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("content", str2);
        HttpUtilsTools.doPost(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_input, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.4
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("input---" + str3);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel != null && jsonToCommonModel.getData() != null) {
                    LogUtils.i(ZhiChiApiImpl.f14410a + "input" + jsonToCommonModel.toString());
                }
                stringResultCallBack.onSuccess(jsonToCommonModel);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void insertSysMsg(Object obj, String str, String str2, String str3, String str4, final StringResultCallBack<BaseCode> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("cid", str);
        hashMap.put("msg", str3);
        hashMap.put("title", str4);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.insertSysMsg, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.43
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str5, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str5, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str5) {
                BaseCode jsonToBaseCode = GsonUtil.jsonToBaseCode(str5);
                if (jsonToBaseCode == null || !"1".equals(jsonToBaseCode.getCode())) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToBaseCode);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void isWork(String str, String str2, final StringResultCallBack<ZhiChiWorkModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("groupId", str2);
        HttpUtilsTools.doPost(SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_is_work, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.14
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("isWork---" + str3);
                ZhiChiWorkResult jsonToZhiChiWorkResult = GsonUtil.jsonToZhiChiWorkResult(str3);
                if (jsonToZhiChiWorkResult == null || !"1".equals(jsonToZhiChiWorkResult.getCode()) || jsonToZhiChiWorkResult.getData() == null) {
                    stringResultCallBack.onSuccess(null);
                } else {
                    stringResultCallBack.onSuccess(jsonToZhiChiWorkResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void leaveMsg(Object obj, String str, String str2, String str3, final StringResultCallBack<BaseCode> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("groupId", str2);
        hashMap.put("content", str3);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.leaveMsg, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.37
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                BaseCode jsonToBaseCode = GsonUtil.jsonToBaseCode(str4);
                if (jsonToBaseCode == null || !"1".equals(jsonToBaseCode.getCode())) {
                    stringResultCallBack.onFailure(new Exception(), ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
                } else {
                    stringResultCallBack.onSuccess(jsonToBaseCode);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void logCollect(final Context context, final String str, boolean z) {
        synchronized (this) {
            boolean booleanData = SharedPreferencesUtil.getBooleanData(context, ZhiChiConstant.SOBOT_CONFIG_REQ_COLLECTFLAG, false);
            if (z || (booleanData && !TextUtils.isEmpty(str))) {
                try {
                    new AsyncTask<Void, Void, String>() { // from class: com.sobot.chat.api.ZhiChiApiImpl.9
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public String doInBackground(Void... voidArr) {
                            try {
                                return LogUtils.getLogContent();
                            } catch (Exception e) {
                                LogUtils.clearAllLog();
                                return null;
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public void onPostExecute(String str2) {
                            super.onPostExecute(str2);
                            try {
                                if (TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("appKey", str);
                                hashMap.put(AttributionReporter.APP_VERSION, CommonUtils.getVersionName(context));
                                hashMap.put("items", str2);
                                hashMap.put("sdkVersion", "sobot_sdk_v3.1.3");
                                hashMap.put("mobilemodels", Build.MODEL);
                                hashMap.put("systemVersion", Build.VERSION.SDK_INT + "");
                                hashMap.put("from", "2");
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("data", GsonUtil.map2Str(hashMap));
                                HttpUtilsTools.doPost(SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_collect, hashMap2, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.9.1
                                    @Override // com.sobot.chat.core.HttpUtils.a
                                    public void a(int i) {
                                    }

                                    @Override // com.sobot.chat.core.HttpUtils.a
                                    public void a(Exception exc, String str3, int i) {
                                    }

                                    @Override // com.sobot.chat.core.HttpUtils.a
                                    public void a(String str3) {
                                        LogUtils.clearAllLog();
                                    }
                                });
                            } catch (Exception e) {
                                LogUtils.clearAllLog();
                            }
                        }
                    }.execute(new Void[0]);
                } catch (Exception e) {
                    LogUtils.clearAllLog();
                }
            }
        }
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void msgAck(Object obj, Map map, final StringResultCallBack<BaseCode> stringResultCallBack) {
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.ack, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.46
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str) {
                stringResultCallBack.onSuccess(GsonUtil.jsonToBaseCode(str));
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void out(String str, String str2, final StringResultCallBack<CommonModel> stringResultCallBack) {
        final HashMap hashMap = new HashMap();
        final String stackTraceString = Log.getStackTraceString(new Throwable());
        hashMap.put("uid", str2);
        hashMap.put("cid", str);
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_login_out, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.53
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口异常", "请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_login_out + "  请求参数-->" + hashMap + "  请求异常信息: --> " + str3 + "------" + exc.getMessage() + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求异常");
                StringBuilder sb = new StringBuilder();
                sb.append(ZhiChiApiImpl.f14410a);
                sb.append(str3);
                LogUtils.i(sb.toString(), exc);
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel == null || jsonToCommonModel.getData() == null) {
                    return;
                }
                stringResultCallBack.onSuccess(jsonToCommonModel);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void pollingMsg(Object obj, Map map, String str, final StringResultCallBack<BaseCode> stringResultCallBack) {
        HashMap hashMap = map;
        if (map == null) {
            hashMap = new HashMap();
        }
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.pollingMsg, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.44
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, ResourceUtils.getResString(ZhiChiApiImpl.this.b, "sobot_try_again"));
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                stringResultCallBack.onSuccess(GsonUtil.jsonToBaseCode(str2));
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void postMsg(Object obj, PostParamModel postParamModel, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put(at.C, postParamModel.getTemplateId());
        hashMap.put("uid", postParamModel.getUid());
        hashMap.put("partnerId", postParamModel.getPartnerId());
        hashMap.put("ticketContent", postParamModel.getTicketContent());
        hashMap.put("customerEmail", postParamModel.getCustomerEmail());
        hashMap.put("customerPhone", postParamModel.getCustomerPhone());
        hashMap.put("ticketTitle", postParamModel.getTicketTitle());
        hashMap.put("companyId", postParamModel.getCompanyId());
        hashMap.put("fileStr", postParamModel.getFileStr());
        hashMap.put("ticketTypeId", postParamModel.getTicketTypeId());
        hashMap.put("groupId", postParamModel.getGroupId());
        hashMap.put("extendFields", postParamModel.getExtendFields());
        hashMap.put("paramsExtends", postParamModel.getParamsExtends());
        hashMap.put("ticketFrom", postParamModel.getTicketFrom());
        hashMap.put("customerSource", "4");
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_post_msg, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.3
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str, exc);
                stringResultCallBack.onFailure(exc, str);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str) {
                LogUtils.i("postMsg-----" + str);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str);
                if (jsonToCommonModel == null || jsonToCommonModel.getData() == null || !"1".equals(jsonToCommonModel.getCode())) {
                    return;
                }
                stringResultCallBack.onSuccess(jsonToCommonModel.getData());
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void queryCids(Object obj, String str, long j, final StringResultCallBack<ZhiChiCidsModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("time", j + "");
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_queryUserCids, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.7
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, str2);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("queryCids---" + str2);
                ZhiChiCidsModelResult jsonToZhiChiCidsModel = GsonUtil.jsonToZhiChiCidsModel(str2);
                if (jsonToZhiChiCidsModel == null || !"1".equals(jsonToZhiChiCidsModel.getCode()) || jsonToZhiChiCidsModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    stringResultCallBack.onSuccess(jsonToZhiChiCidsModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void queryCity(Object obj, String str, String str2, final StringResultCallBack<SobotCityResult> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("provinceId", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("cityId", str2);
        }
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.queryCity, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.18
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("queryCity---" + str3);
                SobotCityResult jsonToSobotCityResult = GsonUtil.jsonToSobotCityResult(str3);
                if (jsonToSobotCityResult == null || !"1".equals(jsonToSobotCityResult.getCode())) {
                    stringResultCallBack.onFailure(new IllegalStateException(), "服务器出错了！");
                } else {
                    stringResultCallBack.onSuccess(jsonToSobotCityResult);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void queryFormConfig(Object obj, String str, final StringResultCallBack<SobotQueryFormModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.queryFormConfig, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.16
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("queryFormConfig---" + str2);
                SobotQueryFormModelResult jsonToSobotQueryFormModelResult = GsonUtil.jsonToSobotQueryFormModelResult(str2);
                if (jsonToSobotQueryFormModelResult == null || !"1".equals(jsonToSobotQueryFormModelResult.getCode()) || jsonToSobotQueryFormModelResult.getData() == null) {
                    return;
                }
                stringResultCallBack.onSuccess(jsonToSobotQueryFormModelResult.getData());
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void questionRecommend(Object obj, String str, Map<String, String> map, final StringResultCallBack<SobotQuestionRecommend> stringResultCallBack) {
        if (map == null || map.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("margs", GsonUtil.map2Json(map));
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.questionRecommend, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.19
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str2, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("questionRecommend---" + str2);
                SobotQuestionRecommendResult jsonToSobotQRResult = GsonUtil.jsonToSobotQRResult(str2);
                if (jsonToSobotQRResult == null || !"1".equals(jsonToSobotQRResult.getCode()) || jsonToSobotQRResult.getData() == null) {
                    stringResultCallBack.onFailure(new IllegalStateException(), "");
                } else {
                    stringResultCallBack.onSuccess(jsonToSobotQRResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void rbAnswerComment(Object obj, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put(RemoteMessageConst.MSGID, str);
        hashMap.put("uid", str2);
        hashMap.put("cid", str3);
        hashMap.put("robotFlag", str4);
        hashMap.put("docId", str5);
        hashMap.put("docName", str6);
        hashMap.put("status", z ? "1" : "-1");
        hashMap.put("originQuestion", str7);
        hashMap.put("answerType", str8);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_rbAnswerComment, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.10
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str9, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str9, exc);
                stringResultCallBack.onFailure(exc, str9);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str9) {
                LogUtils.i("rbAnswerComment-----" + str9);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str9);
                if (jsonToCommonModel == null || !"1".equals(jsonToCommonModel.getCode()) || jsonToCommonModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    stringResultCallBack.onSuccess(jsonToCommonModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void reconnectChannel() {
        connChannel(SharedPreferencesUtil.getStringData(this.b, Const.SOBOT_WSLINKBAK, ""), SharedPreferencesUtil.getStringData(this.b, Const.SOBOT_WSLINKDEFAULT, ""), SharedPreferencesUtil.getStringData(this.b, Const.SOBOT_UID, ""), SharedPreferencesUtil.getStringData(this.b, Const.SOBOT_PUID, ""), SharedPreferencesUtil.getStringData(this.b, Const.SOBOT_APPKEY, ""), SharedPreferencesUtil.getStringData(this.b, Const.SOBOT_WAYHTTP, ""));
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void removeMerchant(final Object obj, String str, final String str2, final SobotMsgCenterModel sobotMsgCenterModel, final StringResultCallBack<SobotMsgCenterModel> stringResultCallBack) {
        if (TextUtils.isEmpty(str) || sobotMsgCenterModel == null) {
            return;
        }
        final HashMap hashMap = new HashMap();
        String stringData = SharedPreferencesUtil.getStringData(this.b, ZhiChiConstant.SOBOT_PLATFORM_KEY, "");
        hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, str);
        hashMap.put("partnerId", str2);
        hashMap.put("platformKey", stringData);
        hashMap.put("id", sobotMsgCenterModel.getId());
        SobotExecutorService.executorService().execute(new Runnable() { // from class: com.sobot.chat.api.ZhiChiApiImpl.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SobotMsgManager.getInstance(ZhiChiApiImpl.this.b).clearMsgCenter(ZhiChiApiImpl.this.b, sobotMsgCenterModel.getApp_key(), str2);
                    if (TextUtils.isEmpty(sobotMsgCenterModel.getId())) {
                        ZhiChiApiImpl.this.a(sobotMsgCenterModel, stringResultCallBack);
                        return;
                    }
                    Object obj2 = obj;
                    Response doPostSync = HttpUtilsTools.doPostSync(obj2, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.removeMerchant, hashMap);
                    if (!doPostSync.isSuccessful()) {
                        ZhiChiApiImpl.this.a(new IllegalStateException(), "", stringResultCallBack);
                        return;
                    }
                    String string = doPostSync.body().string();
                    LogUtils.i("removeMerchant---" + string);
                    if (new JSONObject(string).optInt("code", 0) == 1) {
                        ZhiChiApiImpl.this.a(sobotMsgCenterModel, stringResultCallBack);
                    } else {
                        ZhiChiApiImpl.this.a(new IllegalStateException(), "", stringResultCallBack);
                    }
                } catch (Exception e) {
                    ZhiChiApiImpl.this.a(e, "", stringResultCallBack);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void replyTicketContent(Object obj, String str, String str2, String str3, String str4, String str5, final StringResultCallBack<String> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", "ws/saveUserReplyInfo/4");
        hashMap.put("method", "post");
        hashMap.put("uid", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("replyContent", str3);
        hashMap2.put("companyId", str5);
        hashMap2.put("fileStr", str4);
        hashMap2.put("ticketId", str2);
        hashMap.put(RemoteMessageConst.MessageBody.PARAM, GsonUtil.map2Json(hashMap2));
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.invokeOtherByUser, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.39
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str6, int i) {
                stringResultCallBack.onFailure(exc, str6);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str6) {
                stringResultCallBack.onSuccess(str6);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void robotGuess(Object obj, String str, String str2, String str3, final StringResultCallBack<SobotRobotGuess> stringResultCallBack) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("question", str3);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("robotFlag", str2);
        }
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.robotGuess, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.20
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                LogUtils.i("robotGuess---" + str4);
                SobotRobotGuessResult jsonToRobotGuessResult = GsonUtil.jsonToRobotGuessResult(str4);
                if (jsonToRobotGuessResult == null || !"1".equals(jsonToRobotGuessResult.getCode()) || jsonToRobotGuessResult.getData() == null) {
                    stringResultCallBack.onFailure(new IllegalStateException(), "");
                } else {
                    stringResultCallBack.onSuccess(jsonToRobotGuessResult.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void robotGuide(Object obj, String str, String str2, int i, final StringResultCallBack<ZhiChiMessageBase> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("robotFlag", str2);
        hashMap.put("faqId", i + "");
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_guide, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.6
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i2) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i2) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("robotGuide-----------:" + str3);
                ZhiChiMessage jsonToZhiChiMessage = GsonUtil.jsonToZhiChiMessage(str3);
                if (jsonToZhiChiMessage == null || jsonToZhiChiMessage.getData() == null) {
                    return;
                }
                stringResultCallBack.onSuccess(jsonToZhiChiMessage.getData());
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void satisfactionMessage(Object obj, String str, final ResultCallBack<SatisfactionSet> resultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        HttpUtilsTools.doPost(SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_satisfactionMessage, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.13
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str2, int i) {
                LogUtils.i(str2, exc);
                resultCallBack.onFailure(exc, "网络错误");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str2) {
                LogUtils.i("请求成功---" + str2);
                SatisfactionSet jsonToSatisfactionSet = GsonUtil.jsonToSatisfactionSet(str2);
                if (jsonToSatisfactionSet == null || TextUtils.isEmpty(jsonToSatisfactionSet.getCode()) || !"1".equals(jsonToSatisfactionSet.getCode()) || jsonToSatisfactionSet.getData() == null) {
                    return;
                }
                resultCallBack.onSuccess(jsonToSatisfactionSet);
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sendCardMsg(ConsultingContent consultingContent, String str, String str2, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        if (consultingContent == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("content", consultingContent.toString());
        hashMap.put("uid", str);
        hashMap.put("cid", str2);
        hashMap.put("msgType", "24");
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendmessage_to_customService, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.45
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("返回值--：" + str3);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel == null || 1 != Integer.parseInt(jsonToCommonModel.getCode()) || jsonToCommonModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    stringResultCallBack.onSuccess(jsonToCommonModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sendFile(String str, String str2, String str3, String str4, final ResultCallBack<ZhiChiMessage> resultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("cid", str);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("duration", str4);
        }
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        final long totalSpace = new File(str3).getTotalSpace();
        HttpUtilsTools.uploadFile(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendFile_to_customeService, hashMap, str3, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.51
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
                resultCallBack.onLoading(totalSpace, i, true);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str5, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str5, exc);
                resultCallBack.onFailure(exc, str5);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str5) {
                LogUtils.i("sendFile---" + str5);
                ZhiChiMessage jsonToZhiChiMessage = GsonUtil.jsonToZhiChiMessage(str5);
                if (jsonToZhiChiMessage == null || 1 != Integer.parseInt(jsonToZhiChiMessage.getCode())) {
                    resultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    resultCallBack.onSuccess(jsonToZhiChiMessage);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sendLocation(Object obj, SobotLocationModel sobotLocationModel, String str, String str2, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("cid", str2);
        hashMap.put("lng", sobotLocationModel.getLng());
        hashMap.put("lat", sobotLocationModel.getLat());
        hashMap.put("localLabel", sobotLocationModel.getLocalLabel());
        hashMap.put("localName", sobotLocationModel.getLocalName());
        HttpUtilsTools.uploadFile(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.sendLocation, hashMap, sobotLocationModel.getSnapshot(), new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.26
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("sendLocation---" + str3);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel == null || 1 != Integer.parseInt(jsonToCommonModel.getCode()) || jsonToCommonModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    stringResultCallBack.onSuccess(jsonToCommonModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sendMsgToCoutom(String str, String str2, String str3, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        final HashMap hashMap = new HashMap();
        final String stackTraceString = Log.getStackTraceString(new Throwable());
        hashMap.put("content", str);
        hashMap.put("uid", str2);
        hashMap.put("cid", str3);
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendmessage_to_customService, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.34
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口异常", "请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendmessage_to_customService + "  请求参数-->" + hashMap + "  请求异常信息: --> " + str4 + "------" + exc.getMessage() + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求异常");
                StringBuilder sb = new StringBuilder();
                sb.append(ZhiChiApiImpl.f14410a);
                sb.append(str4);
                LogUtils.i(sb.toString(), exc);
                stringResultCallBack.onFailure(exc, str4);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                LogUtils.i("返回值--：" + str4);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str4);
                if (jsonToCommonModel != null && 1 == Integer.parseInt(jsonToCommonModel.getCode()) && jsonToCommonModel.getData() != null) {
                    stringResultCallBack.onSuccess(jsonToCommonModel.getData());
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口失败", "  请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendmessage_to_customService + "  请求参数-->" + hashMap + "  请求结果: --> " + str4 + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求失败");
                stringResultCallBack.onFailure(new Exception(), "服务器错误");
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sendOrderCardMsg(OrderCardContentModel orderCardContentModel, String str, String str2, final StringResultCallBack<CommonModelBase> stringResultCallBack) {
        if (orderCardContentModel == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("content", SobotJsonUtils.object2Json(orderCardContentModel));
        hashMap.put("uid", str);
        hashMap.put("cid", str2);
        hashMap.put("msgType", "25");
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        HttpUtilsTools.doPost(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendmessage_to_customService, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.50
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, str3);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                LogUtils.i("返回值--：" + str3);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str3);
                if (jsonToCommonModel == null || 1 != Integer.parseInt(jsonToCommonModel.getCode()) || jsonToCommonModel.getData() == null) {
                    stringResultCallBack.onFailure(new Exception(), "服务器错误");
                } else {
                    stringResultCallBack.onSuccess(jsonToCommonModel.getData());
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sendVoiceToRobot(String str, String str2, String str3, String str4, String str5, final ResultCallBack<ZhiChiMessage> resultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str2);
        hashMap.put("cid", str3);
        hashMap.put("robotFlag", str4);
        hashMap.put("duration", str5);
        LogUtils.i("map" + hashMap.toString());
        final long totalSpace = new File(str).getTotalSpace();
        HttpUtilsTools.uploadFile(ZhiChiConstant.SOBOT_GLOBAL_REQUEST_CANCEL_TAG, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_sendVoiceToRobot, hashMap, str, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.15
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
                resultCallBack.onLoading(totalSpace, i, true);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str6, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str6, exc);
                resultCallBack.onFailure(exc, str6);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str6) {
                LogUtils.i("sendVoiceToRobot---" + str6);
                ZhiChiMessage jsonToZhiChiMessage = GsonUtil.jsonToZhiChiMessage(str6);
                if (jsonToZhiChiMessage == null || 1 != Integer.parseInt(jsonToZhiChiMessage.getCode()) || jsonToZhiChiMessage.getData() == null) {
                    resultCallBack.onFailure(new Exception(), (jsonToZhiChiMessage == null || TextUtils.isEmpty(jsonToZhiChiMessage.getMsg())) ? "服务器错误" : jsonToZhiChiMessage.getMsg());
                } else {
                    resultCallBack.onSuccess(jsonToZhiChiMessage);
                }
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void sobotInit(Object obj, Information information, final StringResultCallBack<ZhiChiInitModeBase> stringResultCallBack) {
        SharedPreferencesUtil.saveStringData(this.b, ZhiChiConstant.SOBOT_PLATFORM_UID, information.getPartnerid());
        final HashMap hashMap = new HashMap();
        final String stackTraceString = Log.getStackTraceString(new Throwable());
        hashMap.put("partnerId", information.getPartnerid());
        hashMap.put("way", "10");
        hashMap.put("from", this.f14411c);
        hashMap.put("version", this.d);
        hashMap.put("ack", "1");
        hashMap.put("appId", information.getApp_key());
        hashMap.put(ThemeConfig.SYSTEM_DEFAULT, "android" + Build.VERSION.RELEASE);
        hashMap.put(AttributionReporter.APP_VERSION, CommonUtils.getAppName(this.b) + " " + CommonUtils.getVersionName(this.b));
        hashMap.put("phoneModel", Build.MANUFACTURER + " " + Build.MODEL);
        hashMap.put(UserDictionary.Words.LOCALE, information.getLocale());
        if (!TextUtils.isEmpty(information.getCustomer_fields())) {
            hashMap.put("customerFields", information.getCustomer_fields());
        }
        if (information.getService_mode() >= 1 && information.getService_mode() <= 4) {
            hashMap.put("joinType", information.getService_mode() + "");
        }
        if (!TextUtils.isEmpty(information.getParams())) {
            hashMap.put("params", information.getParams());
        }
        if (!TextUtils.isEmpty(information.getSummary_params())) {
            hashMap.put("summaryParams", information.getSummary_params());
        }
        if (!TextUtils.isEmpty(information.getRobotCode())) {
            hashMap.put("robotFlag", information.getRobotCode());
        }
        if (!TextUtils.isEmpty(information.getGroupid())) {
            hashMap.put("groupId", information.getGroupid());
        }
        if (!TextUtils.isEmpty(information.getUser_nick())) {
            hashMap.put("uname", information.getUser_nick());
        }
        if (!TextUtils.isEmpty(information.getUser_tels())) {
            hashMap.put(PhoneAccount.SCHEME_TEL, information.getUser_tels());
        }
        if (!TextUtils.isEmpty(information.getUser_emails())) {
            hashMap.put("email", information.getUser_emails());
        }
        if (!TextUtils.isEmpty(information.getQq())) {
            hashMap.put("qq", information.getQq());
        }
        if (!TextUtils.isEmpty(information.getRemark())) {
            hashMap.put("remark", information.getRemark());
        }
        if (!TextUtils.isEmpty(information.getFace())) {
            hashMap.put("face", information.getFace());
        }
        if (!TextUtils.isEmpty(information.getUser_name())) {
            hashMap.put("realname", information.getUser_name());
        }
        if (!TextUtils.isEmpty(information.getVisit_title())) {
            hashMap.put("visitTitle", information.getVisit_title());
        }
        if (!TextUtils.isEmpty(information.getVisit_url())) {
            hashMap.put("visitUrl", information.getVisit_url());
        }
        if (!TextUtils.isEmpty(information.getEquipmentId())) {
            hashMap.put("equipmentId", information.getEquipmentId());
        }
        if (!TextUtils.isEmpty(information.getChoose_adminid())) {
            hashMap.put("chooseAdminId", information.getChoose_adminid());
        }
        if (!TextUtils.isEmpty(information.getMulti_params())) {
            hashMap.put("multiParams", information.getMulti_params());
        }
        if (!TextUtils.isEmpty(information.getIsVip())) {
            hashMap.put("isVip", information.getIsVip());
        }
        if (!TextUtils.isEmpty(information.getVip_level())) {
            hashMap.put("vipLevel", information.getVip_level());
        }
        if (!TextUtils.isEmpty(information.getUser_label())) {
            hashMap.put("userLabel", information.getUser_label());
        }
        if (!TextUtils.isEmpty(information.getRobot_alias())) {
            hashMap.put("robotAlias", information.getRobot_alias());
        }
        if (!TextUtils.isEmpty(information.getSign())) {
            hashMap.put(b.d, information.getSign());
        }
        if (!TextUtils.isEmpty(information.getCreateTime())) {
            hashMap.put("createTime", information.getCreateTime());
        }
        hashMap.put("isFirstEntry", information.getIsFirstEntry() + "");
        if (!TextUtils.isEmpty(information.getUser_tip_word())) {
            hashMap.put("customerOutTimeDoc", information.getUser_tip_word());
        }
        if (!TextUtils.isEmpty(information.getAdmin_tip_word())) {
            hashMap.put("serviceOutTimeDoc", information.getAdmin_tip_word());
        }
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_init, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.1
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str, int i) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口异常", "请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_init + "  请求参数-->" + hashMap + "  请求异常信息: --> " + str + "------" + exc.getMessage() + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求异常");
                SobotMsgManager.getInstance(ZhiChiApiImpl.this.b).getZhiChiApi().logCollect(ZhiChiApiImpl.this.b, SharedPreferencesUtil.getAppKey(ZhiChiApiImpl.this.b, ""), false);
                stringResultCallBack.onFailure(exc, "网络错误");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str) {
                ZhiChiInitModel jsonToZhiChiInitModel = GsonUtil.jsonToZhiChiInitModel(str);
                if (jsonToZhiChiInitModel != null && !TextUtils.isEmpty(jsonToZhiChiInitModel.getCode()) && 1 == Integer.parseInt(jsonToZhiChiInitModel.getCode())) {
                    if (jsonToZhiChiInitModel.getData() != null) {
                        stringResultCallBack.onSuccess(jsonToZhiChiInitModel.getData());
                        return;
                    }
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("接口失败", "  请求url-->" + SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.api_robot_chat_init + "  请求参数-->" + hashMap + "  请求结果: --> " + str + "调用过程 -->" + stackTraceString);
                LogUtils.i2Local(ZhiChiApiImpl.this.b, hashMap2, "请求失败");
                SobotMsgManager.getInstance(ZhiChiApiImpl.this.b).getZhiChiApi().logCollect(ZhiChiApiImpl.this.b, SharedPreferencesUtil.getAppKey(ZhiChiApiImpl.this.b, ""), false);
                stringResultCallBack.onFailure(new IllegalArgumentException(), jsonToZhiChiInitModel != null ? jsonToZhiChiInitModel.getMsg() : "");
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void submitForm(Object obj, String str, String str2, final StringResultCallBack<CommonModel> stringResultCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("customerFields", str2);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.newSubmitForm, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.17
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str3, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str3, exc);
                stringResultCallBack.onFailure(exc, "当前网络不可用，请检查您的网络设置");
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str3) {
                stringResultCallBack.onSuccess(GsonUtil.jsonToCommonModel(str3));
            }
        });
    }

    @Override // com.sobot.chat.api.ZhiChiApi
    public void updateUserTicketReplyInfo(Object obj, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("companyId", str);
        hashMap.put("partnerId", str2);
        hashMap.put("ticketId", str3);
        HttpUtilsTools.doPost(obj, SobotBaseUrl.getBaseIp() + ZhiChiUrlApi.updateUserTicketReplyInfo, hashMap, new HttpUtils.a() { // from class: com.sobot.chat.api.ZhiChiApiImpl.41
            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(int i) {
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(Exception exc, String str4, int i) {
                LogUtils.i(ZhiChiApiImpl.f14410a + str4, exc);
            }

            @Override // com.sobot.chat.core.HttpUtils.a
            public void a(String str4) {
                LogUtils.i("返回值--：" + str4);
                CommonModel jsonToCommonModel = GsonUtil.jsonToCommonModel(str4);
                if (jsonToCommonModel == null || 1 != Integer.parseInt(jsonToCommonModel.getCode()) || jsonToCommonModel.getData() == null) {
                    return;
                }
                LogUtils.i("返回值--：" + str4);
            }
        });
    }
}

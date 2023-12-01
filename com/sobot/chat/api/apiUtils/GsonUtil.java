package com.sobot.chat.api.apiUtils;

import android.os.BatteryManager;
import android.provider.ThemesContract;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.openalliance.ad.constant.at;
import com.igexin.push.core.b;
import com.opos.acs.st.STManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sobot.chat.api.model.BaseCode;
import com.sobot.chat.api.model.ChatMessageRichListModel;
import com.sobot.chat.api.model.CommonModel;
import com.sobot.chat.api.model.CommonModelBase;
import com.sobot.chat.api.model.ConsultingContent;
import com.sobot.chat.api.model.Information;
import com.sobot.chat.api.model.OrderCardContentModel;
import com.sobot.chat.api.model.SatisfactionSet;
import com.sobot.chat.api.model.SatisfactionSetBase;
import com.sobot.chat.api.model.SobotCacheFile;
import com.sobot.chat.api.model.SobotCityResult;
import com.sobot.chat.api.model.SobotConfigModel;
import com.sobot.chat.api.model.SobotConfigResult;
import com.sobot.chat.api.model.SobotCusFieldConfig;
import com.sobot.chat.api.model.SobotCusFieldDataInfo;
import com.sobot.chat.api.model.SobotFieldModel;
import com.sobot.chat.api.model.SobotFileModel;
import com.sobot.chat.api.model.SobotKeyWordTransfer;
import com.sobot.chat.api.model.SobotLableInfoList;
import com.sobot.chat.api.model.SobotLeaveMsgConfig;
import com.sobot.chat.api.model.SobotLeaveMsgConfigResult;
import com.sobot.chat.api.model.SobotLeaveMsgParamBaseModel;
import com.sobot.chat.api.model.SobotLeaveMsgParamModel;
import com.sobot.chat.api.model.SobotLeaveReplyModel;
import com.sobot.chat.api.model.SobotLocationModel;
import com.sobot.chat.api.model.SobotMsgCenterModel;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.SobotOfflineLeaveMsgBaseModel;
import com.sobot.chat.api.model.SobotOfflineLeaveMsgModel;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.api.model.SobotPostMsgTemplateResult;
import com.sobot.chat.api.model.SobotProvinInfo;
import com.sobot.chat.api.model.SobotQueryFormModel;
import com.sobot.chat.api.model.SobotQueryFormModelResult;
import com.sobot.chat.api.model.SobotQuestionRecommend;
import com.sobot.chat.api.model.SobotQuestionRecommendResult;
import com.sobot.chat.api.model.SobotRobot;
import com.sobot.chat.api.model.SobotRobotGuess;
import com.sobot.chat.api.model.SobotRobotGuessResult;
import com.sobot.chat.api.model.SobotTypeModel;
import com.sobot.chat.api.model.SobotUserTicketEvaluate;
import com.sobot.chat.api.model.SobotUserTicketInfo;
import com.sobot.chat.api.model.SobotUserTicketInfoFlag;
import com.sobot.chat.api.model.SobotUserTicketInfoResult;
import com.sobot.chat.api.model.StCategoryModel;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.api.model.StHelpDocModel;
import com.sobot.chat.api.model.StUserDealTicketInfo;
import com.sobot.chat.api.model.StUserDealTicketInfoResult;
import com.sobot.chat.api.model.StUserDealTicketReply;
import com.sobot.chat.api.model.Suggestions;
import com.sobot.chat.api.model.ZhiChiCidsModel;
import com.sobot.chat.api.model.ZhiChiCidsModelResult;
import com.sobot.chat.api.model.ZhiChiGroup;
import com.sobot.chat.api.model.ZhiChiGroupBase;
import com.sobot.chat.api.model.ZhiChiHistoryMessage;
import com.sobot.chat.api.model.ZhiChiHistoryMessageBase;
import com.sobot.chat.api.model.ZhiChiHistorySDKMsg;
import com.sobot.chat.api.model.ZhiChiInitModeBase;
import com.sobot.chat.api.model.ZhiChiInitModel;
import com.sobot.chat.api.model.ZhiChiMessage;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.api.model.ZhiChiPushMessage;
import com.sobot.chat.api.model.ZhiChiReplyAnswer;
import com.sobot.chat.api.model.ZhiChiWorkModel;
import com.sobot.chat.api.model.ZhiChiWorkResult;
import com.sobot.chat.utils.LogUtils;
import com.sobot.network.http.model.SobotProgress;
import com.sobot.network.http.model.UploadFileResult;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/apiUtils/GsonUtil.class */
public class GsonUtil {
    public static int changeFileType(int i) {
        switch (i) {
            case 0:
                return 13;
            case 1:
                return 14;
            case 2:
                return 15;
            case 3:
                return 16;
            case 4:
                return 17;
            case 5:
                return 18;
            case 6:
                return 19;
            case 7:
                return 20;
            default:
                return 0;
        }
    }

    public static Method convertGetter(Class cls, String str, Class<?>... clsArr) {
        String substring = str.substring(0, 1);
        String substring2 = str.substring(1);
        try {
            return cls.getMethod(MonitorConstants.CONNECT_TYPE_GET + substring.toUpperCase() + substring2, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static String filterNull(String str) {
        if (TextUtils.isEmpty(str) || str.equals(b.l)) {
            return null;
        }
        String replace = str.replace("\n", "<br/>").replace("<br>", "<br/>");
        String str2 = replace;
        if (replace.endsWith("<br/>")) {
            str2 = replace.substring(0, replace.length() - 5);
        }
        return str2;
    }

    private static String filterNullStr(String str) {
        if (str.equalsIgnoreCase(b.l)) {
            return null;
        }
        return str;
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj) || b.l.equals(obj);
    }

    private static boolean isMultiRoundSession(ZhiChiHistorySDKMsg zhiChiHistorySDKMsg) {
        return zhiChiHistorySDKMsg != null && isMultiRoundSession(zhiChiHistorySDKMsg.getAnswerType());
    }

    public static boolean isMultiRoundSession(ZhiChiMessageBase zhiChiMessageBase) {
        return zhiChiMessageBase != null && isMultiRoundSession(zhiChiMessageBase.getAnswerType());
    }

    private static boolean isMultiRoundSession(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("15");
    }

    private static boolean isSobotMultiDiaRespFor1511(ZhiChiReplyAnswer zhiChiReplyAnswer) {
        String msg = zhiChiReplyAnswer.getMsg();
        if (TextUtils.isEmpty(msg)) {
            return false;
        }
        try {
            String optString = new JSONObject(msg).optString("inputContentList");
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            String[] split = optString.split(",");
            boolean z = true;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return z;
                }
                if (!split[i2].contains("\":\"")) {
                    z = false;
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static List<Map<String, String>> jsonArray2Map(JSONArray jSONArray) {
        ArrayList arrayList;
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                HashMap hashMap = new HashMap();
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, optJSONObject.optString(next));
                }
                arrayList2.add(hashMap);
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    public static ZhiChiReplyAnswer jsonNewMessage(ZhiChiPushMessage zhiChiPushMessage, ZhiChiMessageBase zhiChiMessageBase, String str, String str2, ZhiChiReplyAnswer zhiChiReplyAnswer) {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str2)) {
            return zhiChiReplyAnswer;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("msgType") && !TextUtils.isEmpty(jSONObject.optString("msgType"))) {
                    String optString = jSONObject.optString("msgType");
                    if ("0".equals(optString)) {
                        if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                            zhiChiReplyAnswer.setMsgType("0");
                            zhiChiReplyAnswer.setMsg(jSONObject.optString("content"));
                            return zhiChiReplyAnswer;
                        }
                    } else if ("1".equals(optString)) {
                        if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                            zhiChiReplyAnswer.setMsgType("1");
                            zhiChiReplyAnswer.setMsg(jSONObject.optString("content"));
                            return zhiChiReplyAnswer;
                        }
                    } else if ("2".equals(optString)) {
                        if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                            zhiChiReplyAnswer.setMsgType("2");
                            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("content"));
                            if (jSONObject2.has("url") && !TextUtils.isEmpty(jSONObject2.optString("url"))) {
                                zhiChiReplyAnswer.setDuration(jSONObject2.optString("duration"));
                                zhiChiReplyAnswer.setMsg(jSONObject2.optString("url"));
                                return zhiChiReplyAnswer;
                            }
                        }
                    } else if ("3".equals(optString)) {
                        if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject.optString("content"));
                            if (jSONObject3.has("url") && !TextUtils.isEmpty(jSONObject3.optString("url"))) {
                                SobotCacheFile sobotCacheFile = new SobotCacheFile();
                                sobotCacheFile.setUrl(jSONObject3.optString("url"));
                                sobotCacheFile.setFileName(jSONObject3.optString(SobotProgress.FILE_NAME));
                                sobotCacheFile.setFileType(changeFileType(jSONObject3.optInt("type")));
                                sobotCacheFile.setFileSize(jSONObject3.optString("fileSize"));
                                sobotCacheFile.setMsgId(str);
                                sobotCacheFile.setSnapshot(jSONObject3.optString("snapshot"));
                                zhiChiReplyAnswer.setCacheFile(sobotCacheFile);
                                zhiChiReplyAnswer.setMsgType("23");
                                return zhiChiReplyAnswer;
                            }
                        }
                    } else if ("4".equals(optString)) {
                        if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                            JSONObject jSONObject4 = new JSONObject(jSONObject.optString("content"));
                            if (jSONObject4.has("url") && !TextUtils.isEmpty(jSONObject4.optString("url"))) {
                                SobotCacheFile sobotCacheFile2 = new SobotCacheFile();
                                sobotCacheFile2.setUrl(jSONObject4.optString("url"));
                                sobotCacheFile2.setFileName(jSONObject4.optString(SobotProgress.FILE_NAME));
                                sobotCacheFile2.setFileType(changeFileType(jSONObject4.optInt("type")));
                                sobotCacheFile2.setFileSize(jSONObject4.optString("fileSize"));
                                sobotCacheFile2.setMsgId(str);
                                zhiChiReplyAnswer.setCacheFile(sobotCacheFile2);
                                zhiChiReplyAnswer.setMsgType("12");
                                return zhiChiReplyAnswer;
                            }
                        }
                    } else if (!"5".equals(optString)) {
                        zhiChiReplyAnswer.setMsgType("0");
                        if (jSONObject.has("content")) {
                            zhiChiReplyAnswer.setMsg(jSONObject.optString("content"));
                            return zhiChiReplyAnswer;
                        }
                    } else if (jSONObject.has("content") && !TextUtils.isEmpty(jSONObject.optString("content"))) {
                        JSONObject jSONObject5 = new JSONObject(jSONObject.optString("content"));
                        if (jSONObject5.has("type") && !TextUtils.isEmpty(jSONObject5.optString("type"))) {
                            if ("0".equals(jSONObject5.optString("type"))) {
                                zhiChiReplyAnswer.setMsgType("3");
                                if (jSONObject5.has("msg") && !TextUtils.isEmpty(jSONObject5.optString("msg"))) {
                                    JSONObject jSONObject6 = new JSONObject(jSONObject5.optString("msg"));
                                    if (jSONObject6.has("richList") && !isEmpty(jSONObject6.optString("richList")) && (jSONArray = jSONObject6.getJSONArray("richList")) != null) {
                                        ArrayList arrayList = new ArrayList();
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 >= jSONArray.length()) {
                                                break;
                                            }
                                            ChatMessageRichListModel chatMessageRichListModel = new ChatMessageRichListModel();
                                            JSONObject jSONObject7 = jSONArray.getJSONObject(i2);
                                            if (jSONObject7 != null) {
                                                if (jSONObject7.has("type")) {
                                                    chatMessageRichListModel.setType(jSONObject7.optInt("type"));
                                                }
                                                if (jSONObject7.has("name")) {
                                                    chatMessageRichListModel.setName(filterNull(jSONObject7.optString("name")));
                                                }
                                                if (jSONObject7.has("msg")) {
                                                    chatMessageRichListModel.setMsg(filterNull(jSONObject7.optString("msg")));
                                                }
                                            }
                                            arrayList.add(chatMessageRichListModel);
                                            i = i2 + 1;
                                        }
                                        zhiChiReplyAnswer.setRichList(arrayList);
                                    }
                                }
                            }
                            if ("1".equals(jSONObject5.optString("type"))) {
                                if (zhiChiMessageBase != null && !TextUtils.isEmpty(zhiChiMessageBase.getSenderType())) {
                                    if (Integer.parseInt(zhiChiMessageBase.getSenderType()) == 0) {
                                        zhiChiReplyAnswer.setMsgType("10");
                                    } else {
                                        zhiChiReplyAnswer.setMsgType("9");
                                    }
                                }
                                if (jSONObject5.has("msg") && !TextUtils.isEmpty(jSONObject5.optString("msg"))) {
                                    zhiChiReplyAnswer.setMsg(jSONObject5.optString("msg"));
                                    if (zhiChiMessageBase != null && zhiChiMessageBase.getSdkMsg() != null) {
                                        if (isSobotMultiDiaRespFor1511(zhiChiReplyAnswer)) {
                                            zhiChiMessageBase.getSdkMsg().setAnswerType("1511");
                                        } else {
                                            zhiChiMessageBase.getSdkMsg().setAnswerType("15");
                                        }
                                    }
                                    zhiChiReplyAnswer.setMultiDiaRespInfo(jsonToSobotMultiDiaRespInfo(zhiChiReplyAnswer, zhiChiMessageBase.getSdkMsg().getAnswerType()));
                                    if ("10".equals(zhiChiReplyAnswer.getMsgType())) {
                                        zhiChiReplyAnswer.setInterfaceRetList(jsonArray2Map(new JSONObject(zhiChiReplyAnswer.getMsg()).optJSONArray("interfaceRetList")));
                                        return zhiChiReplyAnswer;
                                    }
                                }
                            } else if ("2".equals(jSONObject5.optString("type"))) {
                                zhiChiReplyAnswer.setMsgType("22");
                                if (jSONObject5.has("msg") && !TextUtils.isEmpty(jSONObject5.optString("msg"))) {
                                    JSONObject jSONObject8 = new JSONObject(jSONObject5.optString("msg"));
                                    SobotLocationModel sobotLocationModel = new SobotLocationModel();
                                    sobotLocationModel.setLat(jSONObject8.optString("lat"));
                                    sobotLocationModel.setLng(jSONObject8.optString("lng"));
                                    sobotLocationModel.setLocalLabel(jSONObject8.optString("desc"));
                                    sobotLocationModel.setLocalName(jSONObject8.optString("title"));
                                    sobotLocationModel.setSnapshot(jSONObject8.optString("url"));
                                    zhiChiReplyAnswer.setLocationData(sobotLocationModel);
                                    return zhiChiReplyAnswer;
                                }
                            } else if ("3".equals(jSONObject5.optString("type"))) {
                                zhiChiReplyAnswer.setMsgType("24");
                                if (jSONObject5.has("msg") && !TextUtils.isEmpty(jSONObject5.optString("msg"))) {
                                    JSONObject jSONObject9 = new JSONObject(jSONObject5.optString("msg"));
                                    ConsultingContent consultingContent = new ConsultingContent();
                                    consultingContent.setSobotGoodsTitle(filterNullStr(jSONObject9.optString("title")));
                                    consultingContent.setSobotGoodsFromUrl(filterNullStr(jSONObject9.optString("url")));
                                    consultingContent.setSobotGoodsDescribe(filterNullStr(jSONObject9.optString("description")));
                                    consultingContent.setSobotGoodsLable(filterNullStr(jSONObject9.optString("label")));
                                    consultingContent.setSobotGoodsImgUrl(filterNullStr(jSONObject9.optString("thumbnail")));
                                    if (zhiChiPushMessage != null) {
                                        zhiChiPushMessage.setConsultingContent(consultingContent);
                                    }
                                    if (zhiChiMessageBase != null) {
                                        zhiChiMessageBase.setConsultingContent(consultingContent);
                                        return zhiChiReplyAnswer;
                                    }
                                }
                            } else if ("4".equals(jSONObject5.optString("type"))) {
                                zhiChiReplyAnswer.setMsgType("25");
                                if (jSONObject5.has("msg") && !TextUtils.isEmpty(jSONObject5.optString("msg"))) {
                                    JSONObject jSONObject10 = new JSONObject(jSONObject5.optString("msg"));
                                    OrderCardContentModel orderCardContentModel = new OrderCardContentModel();
                                    try {
                                        if (jSONObject10.has("orderStatus")) {
                                            orderCardContentModel.setOrderStatus(jSONObject10.optInt("orderStatus"));
                                        }
                                        if (jSONObject10.has("statusCustom")) {
                                            orderCardContentModel.setStatusCustom(filterNull(jSONObject10.optString("statusCustom")));
                                        }
                                        if (jSONObject10.has("orderCode")) {
                                            orderCardContentModel.setOrderCode(filterNull(jSONObject10.optString("orderCode")));
                                        }
                                        if (jSONObject10.has("createTime")) {
                                            orderCardContentModel.setCreateTime(filterNull(jSONObject10.optString("createTime")));
                                        }
                                        if (jSONObject10.has("orderUrl")) {
                                            orderCardContentModel.setOrderUrl(filterNull(jSONObject10.optString("orderUrl")));
                                        }
                                        if (jSONObject10.has("goodsCount")) {
                                            orderCardContentModel.setGoodsCount(filterNull(jSONObject10.optString("goodsCount")));
                                        }
                                        if (jSONObject10.has("totalFee")) {
                                            orderCardContentModel.setTotalFee(jSONObject10.optInt("totalFee"));
                                        }
                                        if (jSONObject10.has("goods") && (optJSONArray = jSONObject10.optJSONArray("goods")) != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            int i3 = 0;
                                            while (true) {
                                                int i4 = i3;
                                                if (i4 >= optJSONArray.length()) {
                                                    break;
                                                }
                                                JSONObject jSONObject11 = optJSONArray.getJSONObject(i4);
                                                OrderCardContentModel.Goods goods = new OrderCardContentModel.Goods();
                                                if (jSONObject11.has("name")) {
                                                    goods.setName(filterNull(jSONObject11.optString("name")));
                                                }
                                                if (jSONObject11.has("pictureUrl")) {
                                                    goods.setPictureUrl(filterNull(jSONObject11.optString("pictureUrl")));
                                                }
                                                arrayList2.add(goods);
                                                i3 = i4 + 1;
                                            }
                                            orderCardContentModel.setGoods(arrayList2);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    if (zhiChiPushMessage != null) {
                                        zhiChiPushMessage.setOrderCardContent(orderCardContentModel);
                                    }
                                    if (zhiChiMessageBase != null) {
                                        zhiChiMessageBase.setOrderCardContent(orderCardContentModel);
                                        return zhiChiReplyAnswer;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return zhiChiReplyAnswer;
    }

    public static BaseCode jsonToBaseCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode baseCode = new BaseCode();
        try {
            JSONObject jSONObject = new JSONObject(str);
            baseCode.setCode(jSONObject.optString("code"));
            baseCode.setData(jSONObject.optString("data"));
            baseCode.setMsg(jSONObject.optString("msg"));
            return baseCode;
        } catch (JSONException e) {
            e.printStackTrace();
            return baseCode;
        }
    }

    public static CommonModel jsonToCommonModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        CommonModel commonModel = new CommonModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                commonModel.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                CommonModelBase commonModelBase = new CommonModelBase();
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("status")) {
                    commonModelBase.setStatus(filterNull(jSONObject2.optString("status")));
                }
                if (jSONObject2.has("switchFlag")) {
                    commonModelBase.setSwitchFlag(filterNull(jSONObject2.optString("switchFlag")));
                }
                if (jSONObject2.has("sentisiveExplain")) {
                    commonModelBase.setSentisiveExplain(filterNull(jSONObject2.optString("sentisiveExplain")));
                }
                if (jSONObject2.has("sentisive")) {
                    commonModelBase.setSentisive(jSONObject2.optInt("sentisive"));
                }
                if (jSONObject2.has("desensitizationWord")) {
                    commonModelBase.setDesensitizationWord(jSONObject2.optString("desensitizationWord"));
                }
                if (jSONObject2.has("msg")) {
                    commonModelBase.setMsg(filterNull(jSONObject2.optString("msg")));
                }
                commonModel.setData(commonModelBase);
            }
            if (jSONObject.has("msg")) {
                commonModel.setMsg(filterNull(jSONObject.optString("msg")));
            }
            return commonModel;
        } catch (JSONException e) {
            return commonModel;
        }
    }

    public static SobotCusFieldConfig jsonToCusFieldConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotCusFieldConfig sobotCusFieldConfig = new SobotCusFieldConfig();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("companyId")) {
                sobotCusFieldConfig.setCompanyId(filterNull(jSONObject.optString("companyId")));
            }
            if (jSONObject.has("createId")) {
                sobotCusFieldConfig.setCreateId(filterNull(jSONObject.optString("createId")));
            }
            if (jSONObject.has("createTime")) {
                sobotCusFieldConfig.setCreateTime(filterNull(jSONObject.optString("createTime")));
            }
            if (jSONObject.has("fieldId")) {
                sobotCusFieldConfig.setFieldId(filterNull(jSONObject.optString("fieldId")));
            }
            if (jSONObject.has("fieldName")) {
                sobotCusFieldConfig.setFieldName(filterNull(jSONObject.optString("fieldName")));
            }
            if (jSONObject.has("fieldRemark")) {
                sobotCusFieldConfig.setFieldRemark(filterNull(jSONObject.optString("fieldRemark")));
            }
            if (jSONObject.has("fieldStatus")) {
                sobotCusFieldConfig.setFieldStatus(jSONObject.optInt("fieldStatus"));
            }
            if (jSONObject.has("fieldType")) {
                sobotCusFieldConfig.setFieldType(jSONObject.optInt("fieldType"));
            }
            if (jSONObject.has("fieldVariable")) {
                sobotCusFieldConfig.setFieldVariable(filterNull(jSONObject.optString("fieldVariable")));
            }
            if (jSONObject.has("fillFlag")) {
                sobotCusFieldConfig.setFillFlag(jSONObject.optInt("fillFlag"));
            }
            if (jSONObject.has("operateType")) {
                sobotCusFieldConfig.setOperateType(jSONObject.optInt("operateType"));
            }
            if (jSONObject.has("sortNo")) {
                sobotCusFieldConfig.setSortNo(jSONObject.optInt("sortNo"));
            }
            if (jSONObject.has("updateId")) {
                sobotCusFieldConfig.setUpdateId(filterNull(jSONObject.optString("updateId")));
            }
            if (jSONObject.has(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)) {
                sobotCusFieldConfig.setUpdateTime(filterNull(jSONObject.optString(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)));
            }
            if (jSONObject.has("workShowFlag")) {
                sobotCusFieldConfig.setWorkShowFlag(jSONObject.optInt("workShowFlag"));
            }
            if (jSONObject.has("workSortNo")) {
                sobotCusFieldConfig.setWorkSortNo(jSONObject.optInt("workSortNo"));
            }
            if (jSONObject.has("limitChar")) {
                sobotCusFieldConfig.setLimitChar(filterNull(jSONObject.optString("limitChar")));
            }
            if (jSONObject.has("limitOptions")) {
                sobotCusFieldConfig.setLimitOptions(filterNull(jSONObject.optString("limitOptions")));
                return sobotCusFieldConfig;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotCusFieldConfig;
    }

    public static SobotCusFieldDataInfo jsonToCusFieldDataInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotCusFieldDataInfo sobotCusFieldDataInfo = new SobotCusFieldDataInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("companyId")) {
                sobotCusFieldDataInfo.setCompanyId(filterNull(jSONObject.optString("companyId")));
            }
            if (jSONObject.has("createId")) {
                sobotCusFieldDataInfo.setCreateId(filterNull(jSONObject.optString("createId")));
            }
            if (jSONObject.has("createTime")) {
                sobotCusFieldDataInfo.setCreateTime(filterNull(jSONObject.optString("createTime")));
            }
            if (jSONObject.has("dataId")) {
                sobotCusFieldDataInfo.setDataId(filterNull(jSONObject.optString("dataId")));
            }
            if (jSONObject.has("dataName")) {
                sobotCusFieldDataInfo.setDataName(filterNull(jSONObject.optString("dataName")));
            }
            if (jSONObject.has("dataStatus")) {
                sobotCusFieldDataInfo.setDataStatus(jSONObject.optInt("dataStatus"));
            }
            if (jSONObject.has("dataValue")) {
                sobotCusFieldDataInfo.setDataValue(filterNull(jSONObject.optString("dataValue")));
            }
            if (jSONObject.has("fieldId")) {
                sobotCusFieldDataInfo.setFieldId(filterNull(jSONObject.optString("fieldId")));
            }
            if (jSONObject.has("fieldVariable")) {
                sobotCusFieldDataInfo.setFieldVariable(filterNull(jSONObject.optString("fieldVariable")));
            }
            if (jSONObject.has("parentDataId")) {
                sobotCusFieldDataInfo.setParentDataId(filterNull(jSONObject.optString("parentDataId")));
            }
            if (jSONObject.has("updateId")) {
                sobotCusFieldDataInfo.setUpdateId(filterNull(jSONObject.optString("updateId")));
            }
            if (jSONObject.has(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)) {
                sobotCusFieldDataInfo.setUpdateTime(filterNull(jSONObject.optString(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)));
                return sobotCusFieldDataInfo;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotCusFieldDataInfo;
    }

    public static SobotFieldModel jsonToFieldModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotFieldModel sobotFieldModel = new SobotFieldModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("cusFieldConfig")) {
                sobotFieldModel.setCusFieldConfig(jsonToCusFieldConfig(jSONObject.optString("cusFieldConfig")));
            }
            if (jSONObject.has("cusFieldDataInfoList")) {
                sobotFieldModel.setCusFieldDataInfoList(jsonToListCusfield(jSONObject.optString("cusFieldDataInfoList")));
                return sobotFieldModel;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotFieldModel;
    }

    public static List<SobotLableInfoList> jsonToLableInfoList(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode baseCode = new BaseCode();
        ArrayList arrayList2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            ArrayList arrayList3 = null;
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                arrayList3 = null;
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                    arrayList3 = null;
                    if (optJSONArray != null) {
                        arrayList3 = null;
                        if (optJSONArray.length() > 0) {
                            arrayList3 = new ArrayList();
                            int i = 0;
                            while (true) {
                                try {
                                    int i2 = i;
                                    if (i2 >= optJSONArray.length()) {
                                        break;
                                    }
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                    SobotLableInfoList sobotLableInfoList = new SobotLableInfoList();
                                    sobotLableInfoList.setLableId(optJSONObject2.optString("lableId"));
                                    sobotLableInfoList.setLableName(optJSONObject2.optString("lableName"));
                                    sobotLableInfoList.setLableLink(optJSONObject2.optString("lableLink"));
                                    arrayList3.add(sobotLableInfoList);
                                    i = i2 + 1;
                                } catch (JSONException e) {
                                    arrayList2 = arrayList3;
                                    e = e;
                                    e.printStackTrace();
                                    arrayList = arrayList2;
                                    return arrayList;
                                }
                            }
                        }
                    }
                }
            }
            arrayList = arrayList3;
            if (jSONObject.has("msg")) {
                arrayList2 = arrayList3;
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return arrayList3;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return arrayList;
    }

    public static SobotLeaveMsgConfig jsonToLeaveMsgConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotLeaveMsgConfig sobotLeaveMsgConfig = new SobotLeaveMsgConfig();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("item");
            if (optJSONObject != null) {
                sobotLeaveMsgConfig.setCompanyId(optJSONObject.optString("companyId"));
                sobotLeaveMsgConfig.setEmailFlag("1".equals(optJSONObject.optString("emailFlag")));
                sobotLeaveMsgConfig.setEmailShowFlag("1".equals(optJSONObject.optString("emailShowFlag")));
                sobotLeaveMsgConfig.setEnclosureFlag("1".equals(optJSONObject.optString("enclosureFlag")));
                sobotLeaveMsgConfig.setEnclosureShowFlag("1".equals(optJSONObject.optString("enclosureShowFlag")));
                sobotLeaveMsgConfig.setTelFlag("1".equals(optJSONObject.optString("telFlag")));
                sobotLeaveMsgConfig.setTelShowFlag("1".equals(optJSONObject.optString("telShowFlag")));
                sobotLeaveMsgConfig.setTicketTitleShowFlag("1".equals(optJSONObject.optString("ticketTitleShowFlag")));
                sobotLeaveMsgConfig.setTicketShowFlag(true);
                sobotLeaveMsgConfig.setTicketStartWay("1".equals(optJSONObject.optString("ticketStartWay")));
                sobotLeaveMsgConfig.setTicketTypeFlag("1".equals(optJSONObject.optString("ticketTypeFlag")));
                sobotLeaveMsgConfig.setMsgTmp(optJSONObject.optString("msgTmp"));
                sobotLeaveMsgConfig.setMsgTxt(optJSONObject.optString("msgTxt"));
                sobotLeaveMsgConfig.setTicketTypeId(optJSONObject.optString("ticketTypeId"));
                sobotLeaveMsgConfig.setTemplateDesc(optJSONObject.optString("templateDesc"));
                sobotLeaveMsgConfig.setTemplateId(optJSONObject.optString(at.C));
                sobotLeaveMsgConfig.setTemplateName(optJSONObject.optString("templateName"));
                sobotLeaveMsgConfig.setType(jsonToListTypeModel(optJSONObject.optString("type")));
                return sobotLeaveMsgConfig;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotLeaveMsgConfig;
    }

    public static SobotLeaveMsgConfigResult jsonToLeaveMsgConfigResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotLeaveMsgConfigResult sobotLeaveMsgConfigResult = new SobotLeaveMsgConfigResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            sobotLeaveMsgConfigResult.setCode(jSONObject.optString("code"));
            if ("1".equals(jSONObject.optString("code"))) {
                sobotLeaveMsgConfigResult.setData(jsonToLeaveMsgConfig(jSONObject.optString("data")));
            }
            sobotLeaveMsgConfigResult.setMsg(jSONObject.optString("msg"));
            return sobotLeaveMsgConfigResult;
        } catch (JSONException e) {
            e.printStackTrace();
            return sobotLeaveMsgConfigResult;
        }
    }

    public static SobotLeaveMsgParamBaseModel jsonToLeaveMsgParamBaseModel(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotLeaveMsgParamBaseModel sobotLeaveMsgParamBaseModel = new SobotLeaveMsgParamBaseModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotLeaveMsgParamBaseModel.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code"))) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                sobotLeaveMsgParamBaseModel.setData(jsonToLeaveMsgParamModel(optJSONObject.optString("items")));
            }
            if (jSONObject.has("msg")) {
                sobotLeaveMsgParamBaseModel.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotLeaveMsgParamBaseModel;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotLeaveMsgParamBaseModel;
    }

    public static SobotLeaveMsgParamModel jsonToLeaveMsgParamModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotLeaveMsgParamModel sobotLeaveMsgParamModel = new SobotLeaveMsgParamModel();
        sobotLeaveMsgParamModel.setField(jsonToListFieldModel(str));
        return sobotLeaveMsgParamModel;
    }

    public static List<SobotLeaveReplyModel> jsonToLeaveReplyModelListResult(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode baseCode = new BaseCode();
        ArrayList arrayList2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            ArrayList arrayList3 = null;
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                arrayList3 = null;
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                    arrayList3 = null;
                    if (optJSONArray != null) {
                        arrayList3 = null;
                        if (optJSONArray.length() > 0) {
                            arrayList3 = new ArrayList();
                            int i = 0;
                            while (true) {
                                try {
                                    int i2 = i;
                                    if (i2 >= optJSONArray.length()) {
                                        break;
                                    }
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                    SobotLeaveReplyModel sobotLeaveReplyModel = new SobotLeaveReplyModel();
                                    sobotLeaveReplyModel.setTicketId(optJSONObject2.optString("ticketId"));
                                    sobotLeaveReplyModel.setTicketTitle(optJSONObject2.optString("ticketTitle"));
                                    sobotLeaveReplyModel.setReplyContent(optJSONObject2.optString("replyContent"));
                                    sobotLeaveReplyModel.setReplyTime(optJSONObject2.optLong("replyTime"));
                                    sobotLeaveReplyModel.setCustomerId(optJSONObject2.optString("customerId"));
                                    sobotLeaveReplyModel.setServiceNick(optJSONObject2.optString("serviceNick"));
                                    arrayList3.add(sobotLeaveReplyModel);
                                    i = i2 + 1;
                                } catch (JSONException e) {
                                    arrayList2 = arrayList3;
                                    e = e;
                                    e.printStackTrace();
                                    arrayList = arrayList2;
                                    return arrayList;
                                }
                            }
                        }
                    }
                }
            }
            arrayList = arrayList3;
            if (jSONObject.has("msg")) {
                arrayList2 = arrayList3;
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return arrayList3;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return arrayList;
    }

    public static List<SobotCusFieldDataInfo> jsonToListCusfield(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    arrayList.add(jsonToCusFieldDataInfo(jSONArray.getString(i2)));
                    i = i2 + 1;
                }
            }
            return arrayList;
        } catch (JSONException e) {
            return arrayList;
        }
    }

    public static ArrayList<SobotFieldModel> jsonToListFieldModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<SobotFieldModel> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    arrayList.add(jsonToFieldModel(jSONArray.getString(i2)));
                    i = i2 + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<StCategoryModel> jsonToListStCategoryModel(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<StCategoryModel> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            StCategoryModel stCategoryModel = new StCategoryModel();
            stCategoryModel.setCategoryId(optJSONObject.optString(STManager.KEY_CATEGORY_ID));
            stCategoryModel.setAppId(optJSONObject.optString("appId"));
            stCategoryModel.setCategoryName(optJSONObject.optString("categoryName"));
            stCategoryModel.setCategoryDetail(optJSONObject.optString("categoryDetail"));
            stCategoryModel.setCategoryUrl(optJSONObject.optString("categoryUrl"));
            stCategoryModel.setSortNo(optJSONObject.optInt("sortNo"));
            arrayList.add(stCategoryModel);
            i = i2 + 1;
        }
    }

    public static ArrayList<StDocModel> jsonToListStDocModel(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<StDocModel> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            StDocModel stDocModel = new StDocModel();
            stDocModel.setCompanyId(optJSONObject.optString("companyId"));
            stDocModel.setDocId(optJSONObject.optString("docId"));
            stDocModel.setQuestionId(optJSONObject.optString("questionId"));
            stDocModel.setQuestionTitle(optJSONObject.optString("questionTitle"));
            arrayList.add(stDocModel);
            i = i2 + 1;
        }
    }

    public static ArrayList<StUserDealTicketInfo> jsonToListStUserDealTicketInfo(JSONArray jSONArray) {
        String str;
        String str2;
        if (jSONArray == null) {
            return null;
        }
        ArrayList<StUserDealTicketInfo> arrayList = new ArrayList<>();
        ArrayList<StUserDealTicketInfo> arrayList2 = arrayList;
        if (jSONArray.length() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList2 = arrayList;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String str3 = "startType";
                if (2 == optJSONObject.optInt("flag")) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("replayList");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        StUserDealTicketInfo stUserDealTicketInfo = new StUserDealTicketInfo();
                        stUserDealTicketInfo.setFlag(optJSONObject.optInt("flag"));
                        stUserDealTicketInfo.setTimeStr(optJSONObject.optString("timeStr"));
                        stUserDealTicketInfo.setTime(optJSONObject.optString("time"));
                        String optString = optJSONObject.optString("content");
                        stUserDealTicketInfo.setContent(TextUtils.isEmpty(optString) ? null : optString.replace("</p>", "").replace("<p>", ""));
                        arrayList.add(stUserDealTicketInfo);
                    } else {
                        int i3 = 0;
                        ArrayList<StUserDealTicketInfo> arrayList3 = arrayList;
                        String str4 = "fileUrl";
                        while (i3 < optJSONArray.length()) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                            if (optJSONObject2 != null) {
                                StUserDealTicketInfo stUserDealTicketInfo2 = new StUserDealTicketInfo();
                                stUserDealTicketInfo2.setFlag(optJSONObject.optInt("flag"));
                                stUserDealTicketInfo2.setTimeStr(optJSONObject.optString("timeStr"));
                                stUserDealTicketInfo2.setTime(optJSONObject.optString("time"));
                                stUserDealTicketInfo2.setContent(optJSONObject.optString("content"));
                                StUserDealTicketReply stUserDealTicketReply = new StUserDealTicketReply();
                                stUserDealTicketReply.setStartType(optJSONObject2.optInt(str3));
                                String optString2 = optJSONObject2.optString("replyContent");
                                stUserDealTicketReply.setReplyContent(TextUtils.isEmpty(optString2) ? null : optString2.replace("</p>", "").replace("<p>", ""));
                                stUserDealTicketReply.setReplyTime(optJSONObject2.optLong("replyTime"));
                                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("fileList");
                                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                                    String str5 = str4;
                                    str = str3;
                                    str2 = str5;
                                } else {
                                    ArrayList<SobotFileModel> arrayList4 = new ArrayList<>();
                                    int i4 = 0;
                                    while (true) {
                                        int i5 = i4;
                                        if (i5 >= optJSONArray2.length()) {
                                            break;
                                        }
                                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                                        SobotFileModel sobotFileModel = new SobotFileModel();
                                        sobotFileModel.setCompanyId(optJSONObject3.optString("companyId"));
                                        sobotFileModel.setFileName(optJSONObject3.optString(SobotProgress.FILE_NAME));
                                        sobotFileModel.setFileUrl(optJSONObject3.optString(str4));
                                        sobotFileModel.setFileId(optJSONObject3.optString("fileId"));
                                        sobotFileModel.setFileType(optJSONObject3.optString("fileType"));
                                        arrayList4.add(sobotFileModel);
                                        i4 = i5 + 1;
                                    }
                                    String str6 = str3;
                                    stUserDealTicketInfo2.setFileList(arrayList4);
                                    str2 = str4;
                                    str = str6;
                                }
                                stUserDealTicketInfo2.setReply(stUserDealTicketReply);
                                arrayList3.add(stUserDealTicketInfo2);
                            } else {
                                String str7 = str4;
                                str = str3;
                                str2 = str7;
                            }
                            i3++;
                            String str8 = str;
                            str4 = str2;
                            str3 = str8;
                            arrayList3 = arrayList3;
                        }
                        arrayList = arrayList3;
                    }
                } else {
                    StUserDealTicketInfo stUserDealTicketInfo3 = new StUserDealTicketInfo();
                    stUserDealTicketInfo3.setFlag(optJSONObject.optInt("flag"));
                    stUserDealTicketInfo3.setTimeStr(optJSONObject.optString("timeStr"));
                    stUserDealTicketInfo3.setTime(optJSONObject.optString("time"));
                    String optString3 = optJSONObject.optString("content");
                    stUserDealTicketInfo3.setContent(TextUtils.isEmpty(optString3) ? null : optString3.replace("</p>", "").replace("<p>", ""));
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("fileList");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        ArrayList<SobotFileModel> arrayList5 = new ArrayList<>();
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 >= optJSONArray3.length()) {
                                break;
                            }
                            JSONObject optJSONObject4 = optJSONArray3.optJSONObject(i7);
                            SobotFileModel sobotFileModel2 = new SobotFileModel();
                            sobotFileModel2.setCompanyId(optJSONObject4.optString("companyId"));
                            sobotFileModel2.setFileName(optJSONObject4.optString(SobotProgress.FILE_NAME));
                            sobotFileModel2.setFileUrl(optJSONObject4.optString("fileUrl"));
                            sobotFileModel2.setFileId(optJSONObject4.optString("fileId"));
                            sobotFileModel2.setFileType(optJSONObject4.optString("fileType"));
                            arrayList5.add(sobotFileModel2);
                            i6 = i7 + 1;
                        }
                        stUserDealTicketInfo3.setFileList(arrayList5);
                    }
                    if (3 == stUserDealTicketInfo3.getFlag()) {
                        SobotUserTicketEvaluate sobotUserTicketEvaluate = new SobotUserTicketEvaluate();
                        sobotUserTicketEvaluate.setEvalution("1".equals(optJSONObject.optString("isEvalution")));
                        sobotUserTicketEvaluate.setOpen("1".equals(optJSONObject.optString("isOpen")));
                        sobotUserTicketEvaluate.setTxtFlag("1".equals(optJSONObject.optString("txtFlag")));
                        sobotUserTicketEvaluate.setTicketScoreInfooList(jsonToTicketScoreInfooList(optJSONObject.optJSONArray("ticketScoreInfooList")));
                        sobotUserTicketEvaluate.setScore(optJSONObject.optInt(WBConstants.GAME_PARAMS_SCORE));
                        sobotUserTicketEvaluate.setRemark(optJSONObject.optString("remark"));
                        stUserDealTicketInfo3.setEvaluate(sobotUserTicketEvaluate);
                        stUserDealTicketInfo3.setStartType(optJSONObject.optInt("startType", 0));
                    }
                    arrayList.add(stUserDealTicketInfo3);
                }
                i = i2 + 1;
            }
        }
        return arrayList2;
    }

    public static ArrayList<SobotTypeModel> jsonToListTypeModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<SobotTypeModel> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                arrayList.add(jsonToTypeModel(jSONArray.getString(i2)));
                i = i2 + 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<SobotUserTicketInfo> jsonToListUserTicketInfo(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<SobotUserTicketInfo> arrayList = new ArrayList<>();
        if (jSONArray.length() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                SobotUserTicketInfo sobotUserTicketInfo = new SobotUserTicketInfo();
                sobotUserTicketInfo.setFlag(optJSONObject.optInt("flag"));
                sobotUserTicketInfo.setNewFlag("2".equals(optJSONObject.optString("newFlag")));
                sobotUserTicketInfo.setTimeStr(optJSONObject.optString("timeStr"));
                sobotUserTicketInfo.setTime(optJSONObject.optString("time"));
                sobotUserTicketInfo.setTicketCode(optJSONObject.optString("ticketCode"));
                sobotUserTicketInfo.setContent(optJSONObject.optString("content"));
                sobotUserTicketInfo.setTicketId(optJSONObject.optString("ticketId"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("fileList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList<SobotFileModel> arrayList2 = new ArrayList<>();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                        SobotFileModel sobotFileModel = new SobotFileModel();
                        sobotFileModel.setCompanyId(optJSONObject2.optString("companyId"));
                        sobotFileModel.setFileName(optJSONObject2.optString(SobotProgress.FILE_NAME));
                        sobotFileModel.setFileUrl(optJSONObject2.optString("fileUrl"));
                        sobotFileModel.setFileId(optJSONObject2.optString("fileId"));
                        sobotFileModel.setFileType(optJSONObject2.optString("fileType"));
                        arrayList2.add(sobotFileModel);
                        i3 = i4 + 1;
                    }
                    sobotUserTicketInfo.setFileList(arrayList2);
                }
                arrayList.add(sobotUserTicketInfo);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static List<SobotMsgCenterModel> jsonToMsgCenterModel(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode baseCode = new BaseCode();
        ArrayList arrayList2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            ArrayList arrayList3 = null;
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                arrayList3 = null;
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                    arrayList3 = null;
                    if (optJSONArray != null) {
                        arrayList3 = null;
                        if (optJSONArray.length() > 0) {
                            arrayList3 = new ArrayList();
                            int i = 0;
                            while (true) {
                                try {
                                    int i2 = i;
                                    if (i2 >= optJSONArray.length()) {
                                        break;
                                    }
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                    SobotMsgCenterModel sobotMsgCenterModel = new SobotMsgCenterModel();
                                    sobotMsgCenterModel.setFace(optJSONObject2.optString("companyLogo"));
                                    sobotMsgCenterModel.setName(optJSONObject2.optString("companyName"));
                                    sobotMsgCenterModel.setLastDateTime(optJSONObject2.optString("lastTime"));
                                    sobotMsgCenterModel.setLastMsg(optJSONObject2.optString("lastMessage"));
                                    sobotMsgCenterModel.setAppkey(optJSONObject2.optString("androidKey"));
                                    sobotMsgCenterModel.setId(optJSONObject2.optString("id"));
                                    Information information = new Information();
                                    information.setApp_key(optJSONObject2.optString("androidKey"));
                                    information.setPartnerid(optJSONObject2.optString("partnerId"));
                                    if (!TextUtils.isEmpty(information.getApp_key())) {
                                        sobotMsgCenterModel.setInfo(information);
                                    }
                                    arrayList3.add(sobotMsgCenterModel);
                                    i = i2 + 1;
                                } catch (JSONException e) {
                                    arrayList2 = arrayList3;
                                    e = e;
                                    e.printStackTrace();
                                    arrayList = arrayList2;
                                    return arrayList;
                                }
                            }
                        }
                    }
                }
            }
            arrayList = arrayList3;
            if (jSONObject.has("msg")) {
                arrayList2 = arrayList3;
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return arrayList3;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return arrayList;
    }

    public static SobotOfflineLeaveMsgBaseModel jsonToOfflineLeaveMsgModel(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotOfflineLeaveMsgBaseModel sobotOfflineLeaveMsgBaseModel = new SobotOfflineLeaveMsgBaseModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotOfflineLeaveMsgBaseModel.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code"))) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                SobotOfflineLeaveMsgModel sobotOfflineLeaveMsgModel = new SobotOfflineLeaveMsgModel();
                if (optJSONObject.has("msgLeaveTxt")) {
                    sobotOfflineLeaveMsgModel.setMsgLeaveTxt(filterNull(optJSONObject.optString("msgLeaveTxt")));
                }
                if (optJSONObject.has("msgLeaveContentTxt")) {
                    sobotOfflineLeaveMsgModel.setMsgLeaveContentTxt(filterNull(optJSONObject.optString("msgLeaveContentTxt")));
                }
                if (optJSONObject.has("leaveExplain")) {
                    sobotOfflineLeaveMsgModel.setLeaveExplain(filterNull(optJSONObject.optString("leaveExplain")));
                }
                sobotOfflineLeaveMsgBaseModel.setData(sobotOfflineLeaveMsgModel);
            }
            if (jSONObject.has("msg")) {
                sobotOfflineLeaveMsgBaseModel.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotOfflineLeaveMsgBaseModel;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotOfflineLeaveMsgBaseModel;
    }

    private static ArrayList<SobotProvinInfo.SobotProvinceModel> jsonToProvinces(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<SobotProvinInfo.SobotProvinceModel> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    SobotProvinInfo.SobotProvinceModel sobotProvinceModel = new SobotProvinInfo.SobotProvinceModel();
                    sobotProvinceModel.provinceId = jSONObject.optString("provinceId");
                    sobotProvinceModel.provinceName = jSONObject.optString("provinceName");
                    sobotProvinceModel.cityId = jSONObject.optString("cityId");
                    sobotProvinceModel.cityName = jSONObject.optString("cityName");
                    sobotProvinceModel.areaId = jSONObject.optString("areaId");
                    sobotProvinceModel.areaName = jSONObject.optString("areaName");
                    boolean z = true;
                    if (jSONObject.optBoolean("endFlag", true)) {
                        z = false;
                    }
                    sobotProvinceModel.nodeFlag = z;
                    sobotProvinceModel.level = i;
                    arrayList.add(sobotProvinceModel);
                    i2 = i3 + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static SobotQueryFormModel jsonToQueryFormModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotQueryFormModel sobotQueryFormModel = new SobotQueryFormModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("fields")) {
                sobotQueryFormModel.setField(jsonToListFieldModel(jSONObject.optString("fields")));
            }
            if (jSONObject.has("formTitle")) {
                sobotQueryFormModel.setFormTitle(filterNull(jSONObject.optString("formTitle")));
            }
            if (jSONObject.has("openFlag")) {
                sobotQueryFormModel.setOpenFlag("1".equals(jSONObject.optString("openFlag")));
            }
            if (jSONObject.has("formDoc")) {
                sobotQueryFormModel.setFormDoc(filterNull(jSONObject.optString("formDoc")));
            }
            if (jSONObject.has("formSafety")) {
                sobotQueryFormModel.setFormSafety(filterNull(jSONObject.optString("formSafety")));
            }
            return sobotQueryFormModel;
        } catch (JSONException e) {
            return sobotQueryFormModel;
        }
    }

    private static SobotRobotGuess jsonToRobotGuess(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotRobotGuess sobotRobotGuess = new SobotRobotGuess();
        try {
            JSONObject jSONObject = new JSONObject(str);
            sobotRobotGuess.setOriginQuestion(jSONObject.optString("originQuestion"));
            JSONArray optJSONArray = jSONObject.optJSONArray("respInfoList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        SobotRobotGuess.RespInfoListBean respInfoListBean = new SobotRobotGuess.RespInfoListBean();
                        respInfoListBean.setDocId(optJSONObject.optString("docId"));
                        respInfoListBean.setQuestion(optJSONObject.optString("question"));
                        respInfoListBean.setHighlight(optJSONObject.optString("highlight"));
                        arrayList.add(respInfoListBean);
                    }
                    i = i2 + 1;
                }
                sobotRobotGuess.setRespInfoList(arrayList);
            }
            return sobotRobotGuess;
        } catch (JSONException e) {
            return sobotRobotGuess;
        }
    }

    public static SobotRobotGuessResult jsonToRobotGuessResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotRobotGuessResult sobotRobotGuessResult = new SobotRobotGuessResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotRobotGuessResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                sobotRobotGuessResult.setData(jsonToRobotGuess(jSONObject.optString("data")));
            }
            if (jSONObject.has("msg")) {
                sobotRobotGuessResult.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotRobotGuessResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotRobotGuessResult;
    }

    public static List<SobotRobot> jsonToRobotListResult(String str) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode baseCode = new BaseCode();
        ArrayList arrayList2 = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            ArrayList arrayList3 = null;
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                arrayList3 = null;
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                    arrayList3 = null;
                    if (optJSONArray != null) {
                        arrayList3 = null;
                        if (optJSONArray.length() > 0) {
                            arrayList3 = new ArrayList();
                            int i = 0;
                            while (true) {
                                try {
                                    int i2 = i;
                                    if (i2 >= optJSONArray.length()) {
                                        break;
                                    }
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                    SobotRobot sobotRobot = new SobotRobot();
                                    sobotRobot.setRobotFlag(optJSONObject2.optString("robotFlag"));
                                    sobotRobot.setRobotHelloWord(optJSONObject2.optString("robotHelloWord"));
                                    sobotRobot.setRobotName(optJSONObject2.optString("robotName"));
                                    sobotRobot.setRobotLogo(optJSONObject2.optString("robotLogo"));
                                    sobotRobot.setGuideFlag(optJSONObject2.optInt("guideFlag"));
                                    sobotRobot.setOperationRemark(optJSONObject2.optString("operationRemark"));
                                    arrayList3.add(sobotRobot);
                                    i = i2 + 1;
                                } catch (JSONException e) {
                                    arrayList2 = arrayList3;
                                    e = e;
                                    e.printStackTrace();
                                    arrayList = arrayList2;
                                    return arrayList;
                                }
                            }
                        }
                    }
                }
            }
            arrayList = arrayList3;
            if (jSONObject.has("msg")) {
                arrayList2 = arrayList3;
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return arrayList3;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return arrayList;
    }

    public static SatisfactionSet jsonToSatisfactionSet(String str) {
        SatisfactionSet satisfactionSet;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SatisfactionSet satisfactionSet2 = new SatisfactionSet();
        ArrayList arrayList = new ArrayList();
        SatisfactionSet satisfactionSet3 = satisfactionSet2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                satisfactionSet2.setCode(filterNull(jSONObject.optString("code")));
                if (jSONObject.optString("code").equals("1")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    SatisfactionSet satisfactionSet4 = satisfactionSet2;
                    ArrayList arrayList2 = arrayList;
                    if (jSONArray != null) {
                        satisfactionSet4 = satisfactionSet2;
                        arrayList2 = arrayList;
                        if (jSONArray.length() != 0) {
                            int i = 0;
                            while (true) {
                                satisfactionSet4 = satisfactionSet2;
                                arrayList2 = arrayList;
                                satisfactionSet3 = satisfactionSet2;
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                SatisfactionSetBase satisfactionSetBase = new SatisfactionSetBase();
                                try {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                    if (jSONObject2 != null) {
                                        if (jSONObject2.has("configId")) {
                                            satisfactionSetBase.setConfigId(filterNull(jSONObject2.optString("configId")));
                                        }
                                        if (jSONObject2.has("companyId")) {
                                            satisfactionSetBase.setCompanyId(filterNull(jSONObject2.optString("companyId")));
                                        }
                                        if (jSONObject2.has("groupId")) {
                                            satisfactionSetBase.setGroupId(filterNull(jSONObject2.optString("groupId")));
                                        }
                                        if (jSONObject2.has("groupName")) {
                                            satisfactionSetBase.setGroupName(filterNull(jSONObject2.optString("groupName")));
                                        }
                                        if (jSONObject2.has("labelId")) {
                                            satisfactionSetBase.setLabelId(filterNull(jSONObject2.optString("labelId")));
                                        }
                                        if (jSONObject2.has("labelName")) {
                                            satisfactionSetBase.setLabelName(filterNull(jSONObject2.optString("labelName")));
                                        }
                                        if (jSONObject2.has("isQuestionFlag")) {
                                            satisfactionSetBase.setIsQuestionFlag("1".equals(jSONObject2.optString("isQuestionFlag")));
                                        }
                                        if (jSONObject2.has(WBConstants.GAME_PARAMS_SCORE)) {
                                            satisfactionSetBase.setScore(filterNull(jSONObject2.optString(WBConstants.GAME_PARAMS_SCORE)));
                                        }
                                        if (jSONObject2.has("scoreExplain")) {
                                            satisfactionSetBase.setScoreExplain(filterNull(jSONObject2.optString("scoreExplain")));
                                        }
                                        if (jSONObject2.has("isTagMust")) {
                                            satisfactionSetBase.setIsTagMust("1".equals(jSONObject2.optString("isTagMust")));
                                        }
                                        if (jSONObject2.has("isInputMust")) {
                                            satisfactionSetBase.setIsInputMust("1".equals(jSONObject2.optString("isInputMust")));
                                        }
                                        if (jSONObject2.has("inputLanguage")) {
                                            satisfactionSetBase.setInputLanguage(filterNull(jSONObject2.optString("inputLanguage")));
                                        }
                                        if (jSONObject2.has("createTime")) {
                                            satisfactionSetBase.setCreateTime(filterNull(jSONObject2.optString("createTime")));
                                        }
                                        if (jSONObject2.has("settingMethod")) {
                                            satisfactionSetBase.setSettingMethod(filterNull(jSONObject2.optString("settingMethod")));
                                        }
                                        if (jSONObject2.has(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)) {
                                            satisfactionSetBase.setUpdateTime(filterNull(jSONObject2.optString(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)));
                                        }
                                        if (jSONObject2.has("operateType")) {
                                            satisfactionSetBase.setOperateType(filterNull(jSONObject2.optString("operateType")));
                                        }
                                        if (jSONObject2.has("defaultType")) {
                                            satisfactionSetBase.setDefaultType(jSONObject2.optInt("defaultType"));
                                        }
                                        if (jSONObject2.has("tagTips")) {
                                            satisfactionSetBase.setTagTips(filterNull(jSONObject2.optString("tagTips")));
                                        }
                                        if (jSONObject2.has("scoreFlag")) {
                                            satisfactionSetBase.setScoreFlag(jSONObject2.optInt("scoreFlag"));
                                        }
                                    }
                                    arrayList.add(satisfactionSetBase);
                                    i++;
                                } catch (JSONException e) {
                                    satisfactionSet = satisfactionSet2;
                                    e = e;
                                    e.printStackTrace();
                                    return satisfactionSet;
                                }
                            }
                        }
                    }
                    satisfactionSet = satisfactionSet4;
                    try {
                        satisfactionSet.setData(arrayList2);
                        return satisfactionSet;
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        return satisfactionSet;
                    }
                }
            }
            return satisfactionSet2;
        } catch (JSONException e3) {
            e = e3;
            satisfactionSet = satisfactionSet3;
        }
    }

    public static SobotProvinInfo jsonToSobotCity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotProvinInfo sobotProvinInfo = new SobotProvinInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("provinces")) {
                sobotProvinInfo.setProvinces(jsonToProvinces(jSONObject.optString("provinces"), 0));
            }
            if (jSONObject.has("citys")) {
                sobotProvinInfo.setCitys(jsonToProvinces(jSONObject.optString("citys"), 1));
            }
            if (jSONObject.has("areas")) {
                sobotProvinInfo.setAreas(jsonToProvinces(jSONObject.optString("areas"), 2));
            }
            return sobotProvinInfo;
        } catch (JSONException e) {
            return sobotProvinInfo;
        }
    }

    public static SobotCityResult jsonToSobotCityResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotCityResult sobotCityResult = new SobotCityResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotCityResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                sobotCityResult.setData(jsonToSobotCity(jSONObject.optString("data")));
            }
            if (jSONObject.has("msg")) {
                sobotCityResult.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotCityResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotCityResult;
    }

    private static SobotConfigModel jsonToSobotConfigModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotConfigModel sobotConfigModel = new SobotConfigModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            sobotConfigModel.companyId = jSONObject.optString("companyId");
            sobotConfigModel.support = jSONObject.optInt("support", 0) == 1;
            sobotConfigModel.collectFlag = jSONObject.optInt("collectFlag", 0) == 1;
            boolean z = false;
            if (jSONObject.optInt("dataFlag", 0) == 1) {
                z = true;
            }
            sobotConfigModel.dataFlag = z;
            sobotConfigModel.reqFrequency = jSONObject.optInt("reqFrequency", 2);
            return sobotConfigModel;
        } catch (JSONException e) {
            return sobotConfigModel;
        }
    }

    public static SobotConfigResult jsonToSobotConfigResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotConfigResult sobotConfigResult = new SobotConfigResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotConfigResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                sobotConfigResult.setData(jsonToSobotConfigModel(jSONObject.optString("data")));
            }
            if (jSONObject.has("msg")) {
                sobotConfigResult.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotConfigResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotConfigResult;
    }

    private static SobotMultiDiaRespInfo jsonToSobotMultiDiaRespInfo(ZhiChiReplyAnswer zhiChiReplyAnswer, String str) {
        String msg = zhiChiReplyAnswer.getMsg();
        if (TextUtils.isEmpty(msg)) {
            return null;
        }
        SobotMultiDiaRespInfo sobotMultiDiaRespInfo = new SobotMultiDiaRespInfo();
        try {
            JSONObject jSONObject = new JSONObject(msg);
            sobotMultiDiaRespInfo.setAnswerStrip(jSONObject.optString("answerStrip"));
            sobotMultiDiaRespInfo.setConversationId(jSONObject.optString("conversationId"));
            sobotMultiDiaRespInfo.setEndFlag(jSONObject.optBoolean("endFlag"));
            sobotMultiDiaRespInfo.setInterfaceRetList(jsonArray2Map(jSONObject.optJSONArray("interfaceRetList")));
            if ("1511".equals(str)) {
                sobotMultiDiaRespInfo.setIcLists(jsonArray2Map(jSONObject.optJSONArray("inputContentList")));
            }
            String optString = jSONObject.optString("inputContentList");
            sobotMultiDiaRespInfo.setInputContentList(!TextUtils.isEmpty(optString) ? optString.split(",") : null);
            String optString2 = jSONObject.optString("outPutParamList");
            String[] strArr = null;
            if (!TextUtils.isEmpty(optString2)) {
                strArr = optString2.split("#");
            }
            sobotMultiDiaRespInfo.setOutPutParamList(strArr);
            sobotMultiDiaRespInfo.setLevel(jSONObject.optInt(BatteryManager.EXTRA_LEVEL));
            sobotMultiDiaRespInfo.setRemindQuestion(jSONObject.optString("remindQuestion"));
            sobotMultiDiaRespInfo.setRetCode(jSONObject.optString("retCode"));
            sobotMultiDiaRespInfo.setRetErrorMsg(jSONObject.optString("retErrorMsg"));
            sobotMultiDiaRespInfo.setTemplate(jSONObject.optString("template"));
            sobotMultiDiaRespInfo.setAnswer(jSONObject.optString("answer"));
            sobotMultiDiaRespInfo.setClickFlag(jSONObject.optInt("clickFlag", 1));
            sobotMultiDiaRespInfo.setLeaveTemplateId(jSONObject.optString("leaveTemplateId"));
            return sobotMultiDiaRespInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return sobotMultiDiaRespInfo;
        }
    }

    public static SobotPostMsgTemplateResult jsonToSobotPostMsgTemplate(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotPostMsgTemplateResult sobotPostMsgTemplateResult = new SobotPostMsgTemplateResult();
        ArrayList<SobotPostMsgTemplate> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotPostMsgTemplateResult.setCode(filterNull(jSONObject.optString("code")));
                if (jSONObject.optString("code").equals("1")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= optJSONArray.length()) {
                                break;
                            }
                            SobotPostMsgTemplate sobotPostMsgTemplate = new SobotPostMsgTemplate();
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                sobotPostMsgTemplate.setTemplateId(filterNull(optJSONObject.optString(at.C)));
                                sobotPostMsgTemplate.setTemplateName(filterNull(optJSONObject.optString("templateName")));
                            }
                            arrayList.add(sobotPostMsgTemplate);
                            i = i2 + 1;
                        }
                    }
                    sobotPostMsgTemplateResult.setData(arrayList);
                    return sobotPostMsgTemplateResult;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotPostMsgTemplateResult;
    }

    private static SobotQuestionRecommend jsonToSobotQR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotQuestionRecommend sobotQuestionRecommend = new SobotQuestionRecommend();
        try {
            JSONObject jSONObject = new JSONObject(str);
            sobotQuestionRecommend.setGuide(jSONObject.optString("guide"));
            JSONArray optJSONArray = jSONObject.optJSONArray("msg");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        SobotQuestionRecommend.SobotQRMsgBean sobotQRMsgBean = new SobotQuestionRecommend.SobotQRMsgBean();
                        sobotQRMsgBean.setIcon(optJSONObject.optString("icon"));
                        sobotQRMsgBean.setQuestion(optJSONObject.optString("question"));
                        sobotQRMsgBean.setId(optJSONObject.optString("id"));
                        sobotQRMsgBean.setTitle(optJSONObject.optString("title"));
                        sobotQRMsgBean.setUrl(optJSONObject.optString("url"));
                        arrayList.add(sobotQRMsgBean);
                    }
                    i = i2 + 1;
                }
                sobotQuestionRecommend.setMsg(arrayList);
            }
            return sobotQuestionRecommend;
        } catch (JSONException e) {
            return sobotQuestionRecommend;
        }
    }

    public static SobotQuestionRecommendResult jsonToSobotQRResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotQuestionRecommendResult sobotQuestionRecommendResult = new SobotQuestionRecommendResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotQuestionRecommendResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                sobotQuestionRecommendResult.setData(jsonToSobotQR(jSONObject.optString("data")));
            }
            if (jSONObject.has("msg")) {
                sobotQuestionRecommendResult.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotQuestionRecommendResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotQuestionRecommendResult;
    }

    public static SobotQueryFormModelResult jsonToSobotQueryFormModelResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotQueryFormModelResult sobotQueryFormModelResult = new SobotQueryFormModelResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotQueryFormModelResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                sobotQueryFormModelResult.setData(jsonToQueryFormModel(jSONObject.optString("data")));
            }
            if (jSONObject.has("msg")) {
                sobotQueryFormModelResult.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotQueryFormModelResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotQueryFormModelResult;
    }

    public static SobotUserTicketInfoFlag jsonToSobotUserTicketInfoFlag(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotUserTicketInfoFlag sobotUserTicketInfoFlag = new SobotUserTicketInfoFlag();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotUserTicketInfoFlag.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code"))) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                sobotUserTicketInfoFlag.setExistFlag("1".equals(optJSONObject.optJSONObject("item").optString("existFlag")));
            }
            if (jSONObject.has("msg")) {
                sobotUserTicketInfoFlag.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotUserTicketInfoFlag;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotUserTicketInfoFlag;
    }

    public static SobotUserTicketInfoResult jsonToSobotUserTicketInfoResult(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotUserTicketInfoResult sobotUserTicketInfoResult = new SobotUserTicketInfoResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotUserTicketInfoResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code"))) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                sobotUserTicketInfoResult.setData(jsonToListUserTicketInfo(optJSONObject.optJSONArray("items")));
            }
            if (jSONObject.has("msg")) {
                sobotUserTicketInfoResult.setMsg(filterNull(jSONObject.optString("msg")));
                return sobotUserTicketInfoResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotUserTicketInfoResult;
    }

    public static BaseCode<List<StCategoryModel>> jsonToStCategoryModelResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode<List<StCategoryModel>> baseCode = new BaseCode<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                baseCode.setData(jsonToListStCategoryModel(jSONObject.optJSONArray("data")));
            }
            if (jSONObject.has("msg")) {
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return baseCode;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return baseCode;
    }

    public static BaseCode<List<StDocModel>> jsonToStDocModelResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode<List<StDocModel>> baseCode = new BaseCode<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                baseCode.setData(jsonToListStDocModel(jSONObject.optJSONArray("data")));
            }
            if (jSONObject.has("msg")) {
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return baseCode;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return baseCode;
    }

    public static BaseCode<StHelpDocModel> jsonToStHelpDocModelResult(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BaseCode<StHelpDocModel> baseCode = new BaseCode<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                baseCode.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(jSONObject.optString("code")) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                StHelpDocModel stHelpDocModel = new StHelpDocModel();
                stHelpDocModel.setCompanyId(optJSONObject.optString("companyId"));
                stHelpDocModel.setDocId(optJSONObject.optString("docId"));
                stHelpDocModel.setQuestionTitle(optJSONObject.optString("questionTitle"));
                stHelpDocModel.setAnswerDesc(optJSONObject.optString("answerDesc"));
                baseCode.setData(stHelpDocModel);
            }
            if (jSONObject.has("msg")) {
                baseCode.setMsg(filterNull(jSONObject.optString("msg")));
                return baseCode;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return baseCode;
    }

    public static StUserDealTicketInfoResult jsonToStUserDealTicketInfoResult(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StUserDealTicketInfoResult stUserDealTicketInfoResult = new StUserDealTicketInfoResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                stUserDealTicketInfoResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code"))) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                stUserDealTicketInfoResult.setData(jsonToListStUserDealTicketInfo(optJSONObject.optJSONArray("items")));
            }
            if (jSONObject.has("msg")) {
                stUserDealTicketInfoResult.setMsg(filterNull(jSONObject.optString("msg")));
                return stUserDealTicketInfoResult;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stUserDealTicketInfoResult;
    }

    public static ArrayList<SobotUserTicketEvaluate.TicketScoreInfooListBean> jsonToTicketScoreInfooList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<SobotUserTicketEvaluate.TicketScoreInfooListBean> arrayList = new ArrayList<>();
        if (jSONArray.length() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                SobotUserTicketEvaluate.TicketScoreInfooListBean ticketScoreInfooListBean = new SobotUserTicketEvaluate.TicketScoreInfooListBean();
                ticketScoreInfooListBean.setCompanyId(optJSONObject.optString("companyId"));
                ticketScoreInfooListBean.setConfigId(optJSONObject.optString("configId"));
                ticketScoreInfooListBean.setCreateId(optJSONObject.optString("createId"));
                ticketScoreInfooListBean.setCreateTime(optJSONObject.optLong("createTime"));
                ticketScoreInfooListBean.setUpdateTime(optJSONObject.optLong(ThemesContract.ThemesColumns.LAST_UPDATE_TIME));
                ticketScoreInfooListBean.setScore(optJSONObject.optInt(WBConstants.GAME_PARAMS_SCORE));
                ticketScoreInfooListBean.setScoreExplain(optJSONObject.optString("scoreExplain"));
                ticketScoreInfooListBean.setScoreId(optJSONObject.optString("scoreId"));
                ticketScoreInfooListBean.setUpdateId(optJSONObject.optString("updateId"));
                arrayList.add(ticketScoreInfooListBean);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public static SobotTypeModel jsonToTypeModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotTypeModel sobotTypeModel = new SobotTypeModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("companyId")) {
                sobotTypeModel.setCompanyId(filterNull(jSONObject.optString("companyId")));
            }
            if (jSONObject.has("createId")) {
                sobotTypeModel.setCreateId(filterNull(jSONObject.optString("createId")));
            }
            if (jSONObject.has("createTime")) {
                sobotTypeModel.setCreateTime(filterNull(jSONObject.optString("createTime")));
            }
            if (jSONObject.has("nodeFlag")) {
                sobotTypeModel.setNodeFlag(jSONObject.optInt("nodeFlag"));
            }
            if (jSONObject.has("parentId")) {
                sobotTypeModel.setParentId(filterNull(jSONObject.optString("parentId")));
            }
            if (jSONObject.has("remark")) {
                sobotTypeModel.setRemark(filterNull(jSONObject.optString("remark")));
            }
            if (jSONObject.has("typeId")) {
                sobotTypeModel.setTypeId(filterNull(jSONObject.optString("typeId")));
            }
            if (jSONObject.has("typeLevel")) {
                sobotTypeModel.setTypeLevel(jSONObject.optInt("typeLevel"));
            }
            if (jSONObject.has("typeName")) {
                sobotTypeModel.setTypeName(filterNull(jSONObject.optString("typeName")));
            }
            if (jSONObject.has("updateId")) {
                sobotTypeModel.setUpdateId(filterNull(jSONObject.optString("updateId")));
            }
            if (jSONObject.has(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)) {
                sobotTypeModel.setUpdateTime(filterNull(jSONObject.optString(ThemesContract.ThemesColumns.LAST_UPDATE_TIME)));
            }
            if (jSONObject.has("validFlag")) {
                sobotTypeModel.setValidFlag(jSONObject.optInt("validFlag"));
            }
            if (jSONObject.has("items")) {
                sobotTypeModel.setItems(jsonToListTypeModel(jSONObject.getString("items")));
                return sobotTypeModel;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sobotTypeModel;
    }

    public static ZhiChiCidsModelResult jsonToZhiChiCidsModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiCidsModelResult zhiChiCidsModelResult = new ZhiChiCidsModelResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                zhiChiCidsModelResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("cids") && !TextUtils.isEmpty(filterNull(jSONObject2.optString("cids")))) {
                    ZhiChiCidsModel zhiChiCidsModel = new ZhiChiCidsModel();
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject2.getJSONArray("cids");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            zhiChiCidsModel.setCids(arrayList);
                            zhiChiCidsModelResult.setData(zhiChiCidsModel);
                            return zhiChiCidsModelResult;
                        }
                        arrayList.add(jSONArray.optString(i2));
                        i = i2 + 1;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiCidsModelResult;
    }

    public static ZhiChiGroup jsonToZhiChiGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiGroup zhiChiGroup = new ZhiChiGroup();
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                zhiChiGroup.setCode(filterNull(jSONObject.optString("code")));
                if (jSONObject.optString("code").equals("1")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    JSONObject jSONObject2 = jSONObject.getJSONObject("msg");
                    if (jSONObject2 != null && !TextUtils.isEmpty(jSONObject2.optString("ustatus"))) {
                        zhiChiGroup.setUstatus(jSONObject2.optString("ustatus"));
                    }
                    if (jSONArray != null) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            ZhiChiGroupBase zhiChiGroupBase = new ZhiChiGroupBase();
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                            if (jSONObject3 != null) {
                                if (jSONObject3.has("groupId")) {
                                    zhiChiGroupBase.setGroupId(filterNull(jSONObject3.optString("groupId")));
                                }
                                if (jSONObject3.has("channelType")) {
                                    zhiChiGroupBase.setChannelType(filterNull(jSONObject3.optString("channelType")));
                                }
                                if (jSONObject3.has("groupName")) {
                                    zhiChiGroupBase.setGroupName(filterNull(jSONObject3.optString("groupName")));
                                }
                                if (jSONObject3.has("companyId")) {
                                    zhiChiGroupBase.setCompanyId(filterNull(jSONObject3.optString("companyId")));
                                }
                                if (jSONObject3.has("recGroupName")) {
                                    zhiChiGroupBase.setRecGroupName(filterNull(jSONObject3.optString("recGroupName")));
                                }
                                if (jSONObject3.has("isOnline")) {
                                    zhiChiGroupBase.setIsOnline(filterNull(jSONObject3.optString("isOnline")));
                                }
                                if (jSONObject3.has("groupStyle")) {
                                    zhiChiGroupBase.setGroupStyle(jSONObject3.optInt("groupStyle"));
                                }
                                if (jSONObject3.has("groupPic")) {
                                    zhiChiGroupBase.setGroupPic(filterNull(jSONObject3.optString("groupPic")));
                                }
                                if (jSONObject3.has("groupGuideDoc")) {
                                    zhiChiGroupBase.setGroupGuideDoc(filterNull(jSONObject3.optString("groupGuideDoc")));
                                }
                                if (jSONObject3.has("description")) {
                                    zhiChiGroupBase.setDescription(filterNull(jSONObject3.optString("description")));
                                }
                            }
                            arrayList.add(zhiChiGroupBase);
                        }
                    }
                    zhiChiGroup.setData(arrayList);
                    return zhiChiGroup;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiGroup;
    }

    public static ZhiChiHistoryMessage jsonToZhiChiHistoryMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiHistoryMessage zhiChiHistoryMessage = new ZhiChiHistoryMessage();
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                zhiChiHistoryMessage.setCode(filterNull(jSONObject.optString("code")));
                if ("1".equals(jSONObject.optString("code"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    if (jSONArray != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            ZhiChiHistoryMessageBase zhiChiHistoryMessageBase = new ZhiChiHistoryMessageBase();
                            ArrayList arrayList2 = new ArrayList();
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            if (jSONObject2 != null) {
                                if (jSONObject2.has("date")) {
                                    zhiChiHistoryMessageBase.setDate(filterNull(jSONObject2.optString("date")));
                                }
                                if (jSONObject2.has("content")) {
                                    String filterNull = filterNull(jSONObject2.optString("content"));
                                    if (!TextUtils.isEmpty(filterNull)) {
                                        JSONArray jSONArray2 = new JSONArray(filterNull);
                                        int i3 = 0;
                                        while (true) {
                                            int i4 = i3;
                                            if (i4 >= jSONArray2.length()) {
                                                break;
                                            }
                                            ZhiChiMessageBase jsonToZhiChiMessageBase = jsonToZhiChiMessageBase(jSONArray2.getJSONObject(i4).toString());
                                            if (TextUtils.isEmpty(jsonToZhiChiMessageBase.getAction()) || (!"43".equals(jsonToZhiChiMessageBase.getAction()) && !"45".equals(jsonToZhiChiMessageBase.getAction()))) {
                                                arrayList2.add(jsonToZhiChiMessageBase);
                                            }
                                            i3 = i4 + 1;
                                        }
                                        zhiChiHistoryMessageBase.setContent(arrayList2);
                                    }
                                }
                            }
                            arrayList.add(zhiChiHistoryMessageBase);
                            i = i2 + 1;
                        }
                    }
                    zhiChiHistoryMessage.setData(arrayList);
                    return zhiChiHistoryMessage;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiHistoryMessage;
    }

    private static ZhiChiHistorySDKMsg jsonToZhiChiHistorySDKMsg(ZhiChiMessageBase zhiChiMessageBase, String str, String str2) {
        ZhiChiHistorySDKMsg zhiChiHistorySDKMsg = new ZhiChiHistorySDKMsg();
        zhiChiMessageBase.setSdkMsg(zhiChiHistorySDKMsg);
        try {
            ZhiChiReplyAnswer jsonNewMessage = jsonNewMessage(null, zhiChiMessageBase, str, str2, new ZhiChiReplyAnswer());
            if (zhiChiMessageBase != null && !TextUtils.isEmpty(zhiChiMessageBase.getMsgTransfer())) {
                jsonNewMessage.setMsgTransfer(zhiChiMessageBase.getMsgTransfer());
                jsonNewMessage.setMsgType("2");
            }
            zhiChiHistorySDKMsg.setAnswer(jsonNewMessage);
            return zhiChiHistorySDKMsg;
        } catch (Exception e) {
            e.printStackTrace();
            return zhiChiHistorySDKMsg;
        }
    }

    public static ZhiChiInitModel jsonToZhiChiInitModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiInitModel zhiChiInitModel = new ZhiChiInitModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                zhiChiInitModel.setCode(filterNull(jSONObject.optString("code")));
                zhiChiInitModel.setMsg(filterNull(jSONObject.optString("msg")));
                if ("1".equals(filterNull(jSONObject.optString("code")))) {
                    ZhiChiInitModeBase zhiChiInitModeBase = new ZhiChiInitModeBase();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.has("uid")) {
                        zhiChiInitModeBase.setPartnerid(filterNull(jSONObject2.optString("uid")));
                    }
                    if (jSONObject2.has("adminNonelineTitle")) {
                        zhiChiInitModeBase.setAdminNonelineTitle(filterNull(jSONObject2.optString("adminNonelineTitle")));
                    }
                    if (jSONObject2.has("robotLogo")) {
                        zhiChiInitModeBase.setRobotLogo(filterNull(jSONObject2.optString("robotLogo")));
                    }
                    if (jSONObject2.has("userOutWord")) {
                        zhiChiInitModeBase.setUserOutWord(filterNull(jSONObject2.optString("userOutWord")));
                    }
                    if (jSONObject2.has("adminHelloWord")) {
                        zhiChiInitModeBase.setAdminHelloWord(filterNull(jSONObject2.optString("adminHelloWord")));
                    }
                    if (jSONObject2.has("userTipTime")) {
                        zhiChiInitModeBase.setUserTipTime(filterNull(jSONObject2.optString("userTipTime")));
                    }
                    if (jSONObject2.has("userTipWord")) {
                        zhiChiInitModeBase.setUserTipWord(filterNull(jSONObject2.optString("userTipWord")));
                    }
                    if (jSONObject2.has("robotHelloWord")) {
                        zhiChiInitModeBase.setRobotHelloWord(filterNull(jSONObject2.optString("robotHelloWord")));
                    }
                    if (jSONObject2.has("adminTipWord")) {
                        zhiChiInitModeBase.setAdminTipWord(filterNull(jSONObject2.optString("adminTipWord")));
                    }
                    if (jSONObject2.has("companyName")) {
                        zhiChiInitModeBase.setCompanyName(filterNull(jSONObject2.optString("companyName")));
                    }
                    if (jSONObject2.has("companyLogo")) {
                        zhiChiInitModeBase.setCompanyLogo(filterNull(jSONObject2.optString("companyLogo")));
                    }
                    if (jSONObject2.has("type")) {
                        zhiChiInitModeBase.setType(filterNull(jSONObject2.optString("type")));
                    }
                    if (jSONObject2.has("cid")) {
                        zhiChiInitModeBase.setCid(filterNull(jSONObject2.optString("cid")));
                    }
                    if (jSONObject2.has("companyStatus")) {
                        zhiChiInitModeBase.setCompanyStatus(filterNull(jSONObject2.optString("companyStatus")));
                    }
                    if (jSONObject2.has("robotName")) {
                        zhiChiInitModeBase.setRobotName(filterNull(jSONObject2.optString("robotName")));
                    }
                    if (jSONObject2.has("isblack")) {
                        zhiChiInitModeBase.setIsblack(filterNull(jSONObject2.optString("isblack")));
                    }
                    if (jSONObject2.has("userOutTime")) {
                        zhiChiInitModeBase.setUserOutTime(filterNull(jSONObject2.optString("userOutTime")));
                    }
                    if (jSONObject2.has("robotUnknownWord")) {
                        zhiChiInitModeBase.setRobotUnknownWord(filterNull(jSONObject2.optString("robotUnknownWord")));
                    }
                    if (jSONObject2.has("robotCommentTitle")) {
                        zhiChiInitModeBase.setRobotCommentTitle(filterNull(jSONObject2.optString("robotCommentTitle")));
                    }
                    if (jSONObject2.has("manualCommentTitle")) {
                        zhiChiInitModeBase.setManualCommentTitle(filterNull(jSONObject2.optString("manualCommentTitle")));
                    }
                    if (jSONObject2.has("adminTipTime")) {
                        zhiChiInitModeBase.setAdminTipTime(filterNull(jSONObject2.optString("adminTipTime")));
                    }
                    if (jSONObject2.has("groupflag")) {
                        zhiChiInitModeBase.setGroupflag(filterNull(jSONObject2.optString("groupflag")));
                    }
                    if (jSONObject2.has("companyId")) {
                        zhiChiInitModeBase.setCompanyId(filterNull(jSONObject2.optString("companyId")));
                    }
                    if (jSONObject2.has("msgTxt")) {
                        zhiChiInitModeBase.setMsgTxt(filterNull(jSONObject2.optString("msgTxt")));
                    }
                    if (jSONObject2.has("msgTmp")) {
                        zhiChiInitModeBase.setMsgTmp(filterNull(jSONObject2.optString("msgTmp")));
                    }
                    if (jSONObject2.has("ustatus")) {
                        zhiChiInitModeBase.setUstatus(jSONObject2.optInt("ustatus"));
                    }
                    if (jSONObject2.has("inputTime")) {
                        zhiChiInitModeBase.setInputTime(jSONObject2.optInt("inputTime"));
                    }
                    if (jSONObject2.has("msgFlag")) {
                        zhiChiInitModeBase.setMsgFlag(jSONObject2.optInt("msgFlag"));
                    }
                    if (jSONObject2.has("guideFlag")) {
                        zhiChiInitModeBase.setGuideFlag(jSONObject2.optInt("guideFlag"));
                    }
                    if (jSONObject2.has("manualType")) {
                        zhiChiInitModeBase.setManualType(jSONObject2.optString("manualType"));
                    }
                    if (jSONObject2.has("realuateFlag")) {
                        zhiChiInitModeBase.setRealuateFlag("1".equals(jSONObject2.optString("realuateFlag")));
                    }
                    if (jSONObject2.has("robotFlag")) {
                        zhiChiInitModeBase.setRobotid(jSONObject2.optString("robotFlag"));
                    }
                    if (jSONObject2.has("announceMsgFlag")) {
                        zhiChiInitModeBase.setAnnounceMsgFlag("1".equals(jSONObject2.optString("announceMsgFlag")));
                    }
                    zhiChiInitModeBase.setAnnounceTopFlag("1".equals(jSONObject2.optString("announceTopFlag")));
                    if (jSONObject2.has("announceMsg")) {
                        zhiChiInitModeBase.setAnnounceMsg(jSONObject2.optString("announceMsg"));
                    }
                    if (jSONObject2.has("announceClickUrl")) {
                        zhiChiInitModeBase.setAnnounceClickUrl(jSONObject2.optString("announceClickUrl"));
                    }
                    if (jSONObject2.has("announceClickFlag")) {
                        zhiChiInitModeBase.setAnnounceClickFlag("1".equals(jSONObject2.optString("announceClickFlag")));
                    }
                    if (jSONObject2.has("customOutTimeFlag")) {
                        zhiChiInitModeBase.setCustomOutTimeFlag("1".equals(jSONObject2.optString("customOutTimeFlag")));
                    }
                    if (jSONObject2.has("serviceOutTimeFlag")) {
                        zhiChiInitModeBase.setServiceOutTimeFlag("1".equals(jSONObject2.optString("serviceOutTimeFlag")));
                    }
                    if (jSONObject2.has("appId")) {
                        zhiChiInitModeBase.setAppId(jSONObject2.optString("appId"));
                    }
                    if (jSONObject2.has("emailFlag")) {
                        zhiChiInitModeBase.setEmailFlag("1".equals(jSONObject2.optString("emailFlag")));
                    }
                    if (jSONObject2.has("emailShowFlag")) {
                        zhiChiInitModeBase.setEmailShowFlag("1".equals(jSONObject2.optString("emailShowFlag")));
                    }
                    if (jSONObject2.has("enclosureFlag")) {
                        zhiChiInitModeBase.setEnclosureFlag("1".equals(jSONObject2.optString("enclosureFlag")));
                    }
                    if (jSONObject2.has("enclosureShowFlag")) {
                        zhiChiInitModeBase.setEnclosureShowFlag("1".equals(jSONObject2.optString("enclosureShowFlag")));
                    }
                    if (jSONObject2.has("telFlag")) {
                        zhiChiInitModeBase.setTelFlag("1".equals(jSONObject2.optString("telFlag")));
                    }
                    if (jSONObject2.has("telShowFlag")) {
                        zhiChiInitModeBase.setTelShowFlag("1".equals(jSONObject2.optString("telShowFlag")));
                    }
                    if (jSONObject2.has("offlineMsgConnectFlag")) {
                        zhiChiInitModeBase.setOfflineMsgConnectFlag(jSONObject2.optInt("offlineMsgConnectFlag"));
                    }
                    if (jSONObject2.has("offlineMsgAdminId")) {
                        zhiChiInitModeBase.setOfflineMsgAdminId(filterNull(jSONObject2.optString("offlineMsgAdminId")));
                    }
                    if (jSONObject2.has("invalidSessionFlag")) {
                        zhiChiInitModeBase.setInvalidSessionFlag(jSONObject2.optInt("invalidSessionFlag"));
                        LogUtils.i("=======invalidSessionFlag=====" + zhiChiInitModeBase.getInvalidSessionFlag());
                    }
                    if (jSONObject2.has("realuateTransferFlag")) {
                        zhiChiInitModeBase.setRealuateTransferFlag(jSONObject2.optInt("realuateTransferFlag"));
                    }
                    zhiChiInitModeBase.setTicketShowFlag(true);
                    zhiChiInitModeBase.setTicketStartWay("1".equals(jSONObject2.optString("ticketStartWay")));
                    zhiChiInitModeBase.setCustomerId(jSONObject2.optString("customerId"));
                    zhiChiInitModeBase.setRobotHelloWordFlag("1".equals(jSONObject2.optString("robotHelloWordFlag")));
                    zhiChiInitModeBase.setAdminHelloWordFlag("1".equals(jSONObject2.optString("adminHelloWordFlag")));
                    zhiChiInitModeBase.setAdminNoneLineFlag("1".equals(jSONObject2.optString("adminNoneLineFlag")));
                    zhiChiInitModeBase.setServiceEndPushFlag("1".equals(jSONObject2.optString("serviceEndPushFlag")));
                    zhiChiInitModeBase.setServiceEndPushMsg(jSONObject2.optString("serviceEndPushMsg"));
                    zhiChiInitModeBase.setRobotSwitchFlag("1".equals(jSONObject2.optString("robotSwitchFlag")));
                    zhiChiInitModeBase.setLableLinkFlag("1".equals(jSONObject2.optString("lableLinkFlag")));
                    zhiChiInitModeBase.setAccountStatus(jSONObject2.optInt("accountStatus", 0));
                    zhiChiInitModeBase.setSmartRouteInfoFlag("1".equals(jSONObject2.optString("smartRouteInfoFlag")));
                    zhiChiInitModeBase.setServiceOutCountRule("1".equals(jSONObject2.optString("serviceOutCountRule")));
                    zhiChiInitModeBase.setAdminHelloWordCountRule("1".equals(jSONObject2.optString("adminHelloWordCountRule")));
                    zhiChiInitModeBase.setMsgToTicketFlag("2".equals(jSONObject2.optString("msgToTicketFlag")));
                    if (zhiChiInitModeBase.isMsgToTicketFlag()) {
                        zhiChiInitModeBase.setMsgLeaveTxt(jSONObject2.optString("msgLeaveTxt"));
                        zhiChiInitModeBase.setMsgLeaveContentTxt(jSONObject2.optString("msgLeaveContentTxt"));
                    }
                    zhiChiInitModel.setData(zhiChiInitModeBase);
                    return zhiChiInitModel;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiInitModel;
    }

    public static ZhiChiMessage jsonToZhiChiMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiMessage zhiChiMessage = new ZhiChiMessage();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                zhiChiMessage.setCode(filterNull(jSONObject.optString("code")));
                if ("1".equals(filterNull(jSONObject.optString("code")))) {
                    if (jSONObject.has("data")) {
                        zhiChiMessage.setData(jsonToZhiChiMessageBase(filterNull(jSONObject.optString("data"))));
                    }
                    if (jSONObject.has("msg")) {
                        zhiChiMessage.setMsg(filterNull(jSONObject.optString("msg")));
                        return zhiChiMessage;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiMessage;
    }

    public static ZhiChiMessageBase jsonToZhiChiMessageBase(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("suggestionList") || TextUtils.isEmpty(filterNull(jSONObject.optString("suggestionList")))) {
                str2 = "ustatus";
            } else {
                ArrayList<Suggestions> arrayList = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray("suggestionList");
                str2 = "ustatus";
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    Suggestions suggestions = new Suggestions();
                    suggestions.setQuestion(jSONObject2.optString("question"));
                    suggestions.setDocId(jSONObject2.optString("docId"));
                    suggestions.setAnswer(jSONObject2.optString("answer"));
                    arrayList.add(suggestions);
                }
                zhiChiMessageBase.setListSuggestions(arrayList);
            }
            if (jSONObject.has(RemoteMessageConst.MSGID)) {
                zhiChiMessageBase.setMsgId(filterNull(jSONObject.optString(RemoteMessageConst.MSGID)));
            }
            if (jSONObject.has("id")) {
                zhiChiMessageBase.setId(filterNull(jSONObject.optString("id")));
            }
            if (jSONObject.has("content")) {
                zhiChiMessageBase.setContent(filterNull(jSONObject.optString("content")));
            }
            if (jSONObject.has("cid")) {
                zhiChiMessageBase.setCid(filterNull(jSONObject.optString("cid")));
            }
            if (jSONObject.has("action")) {
                zhiChiMessageBase.setAction(filterNull(jSONObject.optString("action")));
            }
            if (jSONObject.has("url")) {
                zhiChiMessageBase.setUrl(filterNull(jSONObject.optString("url")));
            }
            if (jSONObject.has(str2)) {
                zhiChiMessageBase.setUstatus(jSONObject.optInt(str2));
            }
            if (jSONObject.has("status")) {
                zhiChiMessageBase.setStatus(filterNull(jSONObject.optString("status")));
            }
            if (jSONObject.has("progressBar")) {
                zhiChiMessageBase.setProgressBar(jSONObject.optInt("progressBar"));
            }
            if (jSONObject.has("sender")) {
                zhiChiMessageBase.setSender(filterNull(jSONObject.optString("sender")));
            }
            if (jSONObject.has("senderName")) {
                zhiChiMessageBase.setSenderName(filterNull(jSONObject.optString("senderName")));
            }
            if (jSONObject.has("senderType")) {
                zhiChiMessageBase.setSenderType(filterNull(jSONObject.optString("senderType")));
            }
            if (jSONObject.has("senderFace")) {
                zhiChiMessageBase.setSenderFace(filterNull(jSONObject.optString("senderFace")));
            }
            if (jSONObject.has("t")) {
                zhiChiMessageBase.setT(filterNull(jSONObject.optString("t")));
            }
            if (jSONObject.has("ts")) {
                zhiChiMessageBase.setTs(filterNull(jSONObject.optString("ts")));
            }
            if (jSONObject.has("serviceEndPushMsg")) {
                zhiChiMessageBase.setServiceEndPushMsg(jSONObject.optString("serviceEndPushMsg"));
            }
            if (jSONObject.has("msgTransfer")) {
                zhiChiMessageBase.setMsgTransfer(filterNull(jSONObject.optString("msgTransfer")));
            }
            if (jSONObject.has("message")) {
                zhiChiMessageBase.setMessage(filterNull(jSONObject.optString("message")));
                zhiChiMessageBase.setSdkMsg(jsonToZhiChiHistorySDKMsg(zhiChiMessageBase, zhiChiMessageBase.getMsgId(), zhiChiMessageBase.getMessage()));
            }
            if (jSONObject.has("answerType")) {
                zhiChiMessageBase.setAnswerType(filterNull(jSONObject.optString("answerType")));
            }
            if (jSONObject.has("answer")) {
                zhiChiMessageBase.setAnswer(jsonToZhiChiReplyAnswer(zhiChiMessageBase, zhiChiMessageBase.getMsgId(), jSONObject.optString("answer"), isMultiRoundSession(zhiChiMessageBase), jSONObject.optString("answerType")));
            }
            if (jSONObject.has("sugguestions")) {
                try {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("sugguestions");
                    if (jSONArray2 != null) {
                        String[] strArr = new String[jSONArray2.length()];
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= jSONArray2.length()) {
                                break;
                            }
                            strArr[i3] = jSONArray2.optString(i3);
                            i2 = i3 + 1;
                        }
                        zhiChiMessageBase.setSugguestions(strArr);
                    }
                } catch (JSONException e) {
                    zhiChiMessageBase.setSugguestions(null);
                }
            }
            if (jSONObject.has(SocialConstants.PARAM_APP_ICON)) {
                zhiChiMessageBase.setPicurl(filterNull(jSONObject.optString(SocialConstants.PARAM_APP_ICON)));
            }
            if (jSONObject.has("rictype")) {
                zhiChiMessageBase.setRictype(filterNull(jSONObject.optString("rictype")));
            }
            if (jSONObject.has("pu")) {
                zhiChiMessageBase.setPu(filterNull(jSONObject.optString("pu")));
            }
            if (jSONObject.has(d.N)) {
                zhiChiMessageBase.setPuid(filterNull(jSONObject.optString(d.N)));
            }
            if (jSONObject.has("count")) {
                zhiChiMessageBase.setCount(jSONObject.optInt("count"));
            }
            if (jSONObject.has("aname")) {
                zhiChiMessageBase.setAname(filterNull(jSONObject.optString("aname")));
            }
            if (jSONObject.has("aface")) {
                zhiChiMessageBase.setAface(filterNull(jSONObject.optString("aface")));
            }
            if (jSONObject.has(SocialConstants.PARAM_RECEIVER)) {
                zhiChiMessageBase.setReceiver(filterNull(jSONObject.optString(SocialConstants.PARAM_RECEIVER)));
            }
            if (jSONObject.has("receiverName")) {
                zhiChiMessageBase.setReceiverName(filterNull(jSONObject.optString("receiverName")));
            }
            if (jSONObject.has("receiverType")) {
                zhiChiMessageBase.setReceiverType(filterNull(jSONObject.optString("receiverType")));
            }
            if (jSONObject.has("offlineType")) {
                zhiChiMessageBase.setOfflineType(filterNull(jSONObject.optString("offlineType")));
            }
            if (jSONObject.has("receiverFace")) {
                zhiChiMessageBase.setReceiverFace(filterNull(jSONObject.optString("receiverFace")));
            }
            if (jSONObject.has("stripe")) {
                zhiChiMessageBase.setStripe(filterNull(filterNull(jSONObject.optString("stripe"))));
            }
            if (jSONObject.has("wslink.bak")) {
                zhiChiMessageBase.setWslinkBak(filterNull(jSONObject.optString("wslink.bak")));
            }
            if (jSONObject.has("wslink.default")) {
                zhiChiMessageBase.setWslinkDefault(filterNull(jSONObject.optString("wslink.default")));
            }
            if (jSONObject.has("way_http")) {
                zhiChiMessageBase.setWayHttp(filterNull(jSONObject.optString("way_http")));
            }
            if (jSONObject.has("adminHelloWord")) {
                zhiChiMessageBase.setAdminHelloWord(filterNull(jSONObject.optString("adminHelloWord")));
            }
            if (jSONObject.has("serviceOutTime")) {
                zhiChiMessageBase.setServiceOutTime(filterNull(jSONObject.optString("serviceOutTime")));
            }
            if (jSONObject.has("serviceOutDoc")) {
                zhiChiMessageBase.setServiceOutDoc(filterNull(jSONObject.optString("serviceOutDoc")));
            }
            if (jSONObject.has("question")) {
                zhiChiMessageBase.setQuestion(filterNull(jSONObject.optString("question")));
            }
            if (jSONObject.has("docId")) {
                zhiChiMessageBase.setDocId(filterNull(jSONObject.optString("docId")));
            }
            if (jSONObject.has("msg")) {
                zhiChiMessageBase.setMsg(filterNull(jSONObject.optString("msg")));
            }
            if (jSONObject.has("docName")) {
                zhiChiMessageBase.setDocName(filterNull(jSONObject.optString("docName")));
            }
            if (jSONObject.has("sentisive")) {
                zhiChiMessageBase.setSentisive(jSONObject.optInt("sentisive"));
            }
            if (jSONObject.has("sentisiveExplain")) {
                zhiChiMessageBase.setSentisiveExplain(filterNull(jSONObject.optString("sentisiveExplain")));
            }
            if (jSONObject.has("originQuestion")) {
                zhiChiMessageBase.setOriginQuestion(filterNull(jSONObject.optString("originQuestion")));
            }
            if (jSONObject.has("desensitizationWord")) {
                zhiChiMessageBase.setDesensitizationWord(filterNull(jSONObject.optString("desensitizationWord")));
            }
            zhiChiMessageBase.setRetractedMsg("1".equals(jSONObject.optString("revokeFlag")));
            zhiChiMessageBase.setLeaveMsgFlag("1".equals(jSONObject.optString("leaveMsgFlag")));
            zhiChiMessageBase.setQueueDoc(filterNull(jSONObject.optString("queueDoc")));
            JSONObject optJSONObject = jSONObject.optJSONObject("keywordVo");
            if (optJSONObject != null) {
                SobotKeyWordTransfer sobotKeyWordTransfer = new SobotKeyWordTransfer();
                sobotKeyWordTransfer.setKeywordId(optJSONObject.optString("keywordId"));
                sobotKeyWordTransfer.setKeyword(optJSONObject.optString("keyword"));
                sobotKeyWordTransfer.setTransferFlag(optJSONObject.optInt("transferFlag"));
                sobotKeyWordTransfer.setOnlineFlag(optJSONObject.optInt("onlineFlag"));
                sobotKeyWordTransfer.setTransferTips(optJSONObject.optString("transferTips"));
                sobotKeyWordTransfer.setGroupId(optJSONObject.optString("groupId"));
                sobotKeyWordTransfer.setTipsMessage(optJSONObject.optString("tipsMessage"));
                sobotKeyWordTransfer.setQueueFlag("1".equals(optJSONObject.optString("queueFlag")));
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("groupList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= optJSONArray.length()) {
                            break;
                        }
                        ZhiChiGroupBase zhiChiGroupBase = new ZhiChiGroupBase();
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i5);
                        if (jSONObject3 != null) {
                            zhiChiGroupBase.setGroupId(filterNull(jSONObject3.optString("groupId")));
                            zhiChiGroupBase.setChannelType(filterNull(jSONObject3.optString("channelType")));
                            zhiChiGroupBase.setGroupName(filterNull(jSONObject3.optString("groupName")));
                            zhiChiGroupBase.setCompanyId(filterNull(jSONObject3.optString("companyId")));
                            zhiChiGroupBase.setRecGroupName(filterNull(jSONObject3.optString("recGroupName")));
                            zhiChiGroupBase.setIsOnline(filterNull(jSONObject3.optString("isOnline")));
                        }
                        arrayList2.add(zhiChiGroupBase);
                        i4 = i5 + 1;
                    }
                    sobotKeyWordTransfer.setGroupList(arrayList2);
                }
                zhiChiMessageBase.setSobotKeyWordTransfer(sobotKeyWordTransfer);
            }
            zhiChiMessageBase.setTransferType(jSONObject.optInt("transferType", 0));
            zhiChiMessageBase.setGuideGroupFlag("1".equals(jSONObject.optString("guideGroupFlag")));
            zhiChiMessageBase.setGuideGroupNum(jSONObject.optInt("guideGroupNum"));
            return zhiChiMessageBase;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return zhiChiMessageBase;
        }
    }

    public static ZhiChiPushMessage jsonToZhiChiPushMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiPushMessage zhiChiPushMessage = new ZhiChiPushMessage();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("type")) {
                zhiChiPushMessage.setType(jSONObject.optInt("type"));
            }
            if (jSONObject.has("aname")) {
                zhiChiPushMessage.setAname(filterNull(jSONObject.optString("aname")));
            }
            if (jSONObject.has("aface")) {
                zhiChiPushMessage.setAface(filterNull(jSONObject.optString("aface")));
            }
            if (jSONObject.has("content")) {
                zhiChiPushMessage.setContent(filterNull(jSONObject.optString("content")));
            }
            if (jSONObject.has("status")) {
                zhiChiPushMessage.setStatus(filterNull(jSONObject.optString("status")));
            }
            if (jSONObject.has("msgType")) {
                zhiChiPushMessage.setMsgType(filterNull(jSONObject.optString("msgType")));
            }
            if (jSONObject.has("count")) {
                zhiChiPushMessage.setCount(filterNull(jSONObject.optString("count")));
            }
            if (jSONObject.has("name")) {
                zhiChiPushMessage.setName(filterNull(jSONObject.optString("name")));
            }
            if (jSONObject.has("face")) {
                zhiChiPushMessage.setFace(filterNull(jSONObject.optString("face")));
            }
            if (jSONObject.has("isQuestionFlag")) {
                zhiChiPushMessage.setIsQuestionFlag(jSONObject.optInt("isQuestionFlag"));
            }
            if (jSONObject.has("appId")) {
                zhiChiPushMessage.setAppId(filterNull(jSONObject.optString("appId")));
            }
            if (jSONObject.has("lockType")) {
                zhiChiPushMessage.setLockType(jSONObject.optInt("lockType"));
            }
            if (jSONObject.has("message")) {
                zhiChiPushMessage.setMessage(filterNull(jSONObject.optString("message")));
            }
            if (jSONObject.has("sysType")) {
                zhiChiPushMessage.setSysType(filterNull(jSONObject.optString("sysType")));
            }
            if (jSONObject.has(d.N)) {
                zhiChiPushMessage.setPuid(filterNull(jSONObject.optString(d.N)));
            }
            zhiChiPushMessage.setMsgId(filterNull(jSONObject.optString(RemoteMessageConst.MSGID)));
            if (202 == zhiChiPushMessage.getType()) {
                zhiChiPushMessage.setAnswer(jsonToZhiChiPushMsg(zhiChiPushMessage, zhiChiPushMessage.getMsgId(), zhiChiPushMessage.getMessage()));
            }
            zhiChiPushMessage.setRevokeMsgId(filterNull(jSONObject.optString("revokeMsgId")));
            zhiChiPushMessage.setQueueDoc(filterNull(jSONObject.optString("queueDoc")));
            if (jSONObject.has("serviceInfo")) {
                String filterNull = filterNull(jSONObject.optString("serviceInfo"));
                if (!TextUtils.isEmpty(filterNull)) {
                    JSONObject jSONObject2 = new JSONObject(filterNull);
                    zhiChiPushMessage.setAdminHelloWord(filterNull(jSONObject2.optString("adminHelloWord")));
                    zhiChiPushMessage.setAdminHelloWord(filterNull(jSONObject2.optString("adminHelloWord")));
                    zhiChiPushMessage.setServiceOutTime(filterNull(jSONObject2.optString("serviceOutTime")));
                    zhiChiPushMessage.setServiceEndPushMsg(filterNull(jSONObject2.optString("serviceEndPushMsg")));
                }
            }
            return zhiChiPushMessage;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ZhiChiReplyAnswer jsonToZhiChiPushMsg(ZhiChiPushMessage zhiChiPushMessage, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return jsonNewMessage(zhiChiPushMessage, null, str, str2, new ZhiChiReplyAnswer());
    }

    public static ZhiChiReplyAnswer jsonToZhiChiReplyAnswer(ZhiChiMessageBase zhiChiMessageBase, String str, String str2, boolean z, String str3) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        ZhiChiReplyAnswer zhiChiReplyAnswer = new ZhiChiReplyAnswer();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("msgType")) {
                zhiChiReplyAnswer.setMsgType(filterNull(jSONObject.optString("msgType")));
            }
            if (jSONObject.has("msg")) {
                zhiChiReplyAnswer.setMsg(filterNull(jSONObject.optString("msg")));
            }
            if (jSONObject.has("duration")) {
                zhiChiReplyAnswer.setDuration(filterNull(jSONObject.optString("duration")));
            }
            if (jSONObject.has("msgTransfer")) {
                zhiChiReplyAnswer.setMsgTransfer(filterNull(jSONObject.optString("msgTransfer")));
            }
            if (z) {
                zhiChiReplyAnswer.setMultiDiaRespInfo(jsonToSobotMultiDiaRespInfo(zhiChiReplyAnswer, str3));
            }
            zhiChiReplyAnswer.setMsgStripe(filterNull(jSONObject.optString("msgStripe")));
            if (jSONObject.has("richList") && !isEmpty(jSONObject.optString("richList")) && (jSONArray = jSONObject.getJSONArray("richList")) != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        zhiChiReplyAnswer.setRichList(arrayList);
                        return zhiChiReplyAnswer;
                    }
                    ChatMessageRichListModel chatMessageRichListModel = new ChatMessageRichListModel();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        if (jSONObject2.has("type")) {
                            chatMessageRichListModel.setType(jSONObject2.optInt("type"));
                        }
                        if (jSONObject2.has("name")) {
                            chatMessageRichListModel.setName(filterNull(jSONObject2.optString("name")));
                        }
                        if (jSONObject2.has("msg")) {
                            chatMessageRichListModel.setMsg(filterNull(jSONObject2.optString("msg")));
                        }
                    }
                    arrayList.add(chatMessageRichListModel);
                    i = i2 + 1;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiReplyAnswer;
    }

    public static ZhiChiWorkResult jsonToZhiChiWorkResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ZhiChiWorkResult zhiChiWorkResult = new ZhiChiWorkResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                zhiChiWorkResult.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("isWork")) {
                    ZhiChiWorkModel zhiChiWorkModel = new ZhiChiWorkModel();
                    zhiChiWorkModel.setWork("true".equals(jSONObject2.optString("isWork")));
                    zhiChiWorkResult.setData(zhiChiWorkModel);
                    return zhiChiWorkResult;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return zhiChiWorkResult;
    }

    public static String map2Json(Map<String, String> map) {
        return (map == null || map.size() <= 0) ? "" : new JSONObject(map).toString();
    }

    public static String map2JsonByObjectMap(Map map) {
        return (map == null || map.size() <= 0) ? "" : new JSONObject(map).toString();
    }

    public static String map2Str(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!"items".equals(entry.getKey()) && !BatteryManager.EXTRA_LEVEL.equals(entry.getKey())) {
                    sb.append("\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",");
                }
                sb.append("\"" + entry.getKey() + "\":" + entry.getValue() + ",");
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.lastIndexOf(",")) + i.d;
        } catch (Exception e) {
            return "";
        }
    }

    public static UploadFileResult obtainUploadFileResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            UploadFileResult uploadFileResult = new UploadFileResult();
            uploadFileResult.setMsgId(jSONObject.optString(RemoteMessageConst.MSGID));
            uploadFileResult.setUrl(jSONObject.optString("msg"));
            return uploadFileResult;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> JSONArray praseList2Json(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (T t : list) {
                JSONObject jSONObject = new JSONObject();
                Field[] declaredFields = t.getClass().getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        Field field = declaredFields[i2];
                        field.setAccessible(true);
                        Method convertGetter = convertGetter(t.getClass(), field.getName(), new Class[0]);
                        if (convertGetter != null) {
                            jSONObject.put(field.getName(), (String) convertGetter.invoke(t, new Object[0]));
                        }
                        i = i2 + 1;
                    }
                }
                jSONArray.put(jSONObject);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return jSONArray;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return jSONArray;
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONArray;
        }
        return jSONArray;
    }
}

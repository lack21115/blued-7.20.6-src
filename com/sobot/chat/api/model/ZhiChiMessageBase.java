package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiMessageBase.class */
public class ZhiChiMessageBase implements Serializable {
    private static final long serialVersionUID = 1;
    private String action;
    private String adminHelloWord;
    private String aface;
    private String aname;
    private ZhiChiReplyAnswer answer;
    private String answerType;
    private String cid;
    private int clickCount;
    private ConsultingContent consultingContent;
    private String content;
    private int count;
    private int currentPageNum;
    private String desensitizationWord;
    private String docId;
    private String docName;
    private boolean guideGroupFlag;
    private int guideGroupNum;
    private String id;
    private boolean isLeaveMsgFlag;
    private ArrayList<Suggestions> listSuggestions;
    private String message;
    private String msg;
    private String msgId;
    private String msgTransfer;
    private int multiDiaRespEnd;
    private String offlineType;
    private OrderCardContentModel orderCardContent;
    private String originQuestion;
    private String picurl;
    private int progressBar;
    private String pu;
    private String puid;
    private String question;
    private String queueDoc;
    private String receiver;
    private String receiverFace;
    private String receiverName;
    private String receiverType;
    private String rictype;
    private ZhiChiHistorySDKMsg sdkMsg;
    private String sender;
    private String senderFace;
    private String senderName;
    private String senderType;
    private String sentisiveExplain;
    private String serviceEndPushMsg;
    private String serviceOutDoc;
    private String serviceOutTime;
    private String status;
    private String stripe;
    private String[] sugguestions;
    private int sugguestionsFontColor;
    private String t;
    private int transferType;
    private String ts;
    private String url;
    private int ustatus;
    private String wayHttp;
    private String wslinkBak;
    private String wslinkDefault;
    private boolean isShake = false;
    private boolean isShowTransferBtn = false;
    private int revaluateState = 0;
    private SobotEvaluateModel sobotEvaluateModel = null;
    private int sendSuccessState = 1;
    private boolean isRetractedMsg = false;
    private boolean voideIsPlaying = false;
    private SobotKeyWordTransfer sobotKeyWordTransfer = null;
    private int sentisive = 0;
    private boolean isShowSentisiveSeeAll = false;
    private boolean isClickCancleSend = false;

    public void addClickCount() {
        this.clickCount++;
    }

    public String getAction() {
        return this.action;
    }

    public String getAdminHelloWord() {
        return this.adminHelloWord;
    }

    public String getAface() {
        return this.aface;
    }

    public String getAname() {
        return this.aname;
    }

    public ZhiChiReplyAnswer getAnswer() {
        return this.answer;
    }

    public String getAnswerType() {
        return this.answerType;
    }

    public String getCid() {
        return this.cid;
    }

    public int getClickCount() {
        return this.clickCount;
    }

    public ConsultingContent getConsultingContent() {
        return this.consultingContent;
    }

    public String getContent() {
        return this.content;
    }

    public int getCount() {
        return this.count;
    }

    public int getCurrentPageNum() {
        return this.currentPageNum;
    }

    public String getDesensitizationWord() {
        return this.desensitizationWord;
    }

    public String getDocId() {
        return this.docId;
    }

    public String getDocName() {
        return this.docName;
    }

    public int getGuideGroupNum() {
        return this.guideGroupNum;
    }

    public String getId() {
        return this.id;
    }

    public ArrayList<Suggestions> getListSuggestions() {
        return this.listSuggestions;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getMsgTransfer() {
        return this.msgTransfer;
    }

    public int getMultiDiaRespEnd() {
        return this.multiDiaRespEnd;
    }

    public String getOfflineType() {
        return this.offlineType;
    }

    public OrderCardContentModel getOrderCardContent() {
        return this.orderCardContent;
    }

    public String getOriginQuestion() {
        return this.originQuestion;
    }

    public String getPicurl() {
        return this.picurl;
    }

    public int getProgressBar() {
        return this.progressBar;
    }

    public String getPu() {
        return this.pu;
    }

    public String getPuid() {
        return this.puid;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getQueueDoc() {
        return this.queueDoc;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getReceiverFace() {
        return this.receiverFace;
    }

    public String getReceiverName() {
        return this.receiverName;
    }

    public String getReceiverType() {
        return this.receiverType;
    }

    public int getRevaluateState() {
        return this.revaluateState;
    }

    public String getRictype() {
        return this.rictype;
    }

    public ZhiChiHistorySDKMsg getSdkMsg() {
        return this.sdkMsg;
    }

    public int getSendSuccessState() {
        return this.sendSuccessState;
    }

    public String getSender() {
        return this.sender;
    }

    public String getSenderFace() {
        return this.senderFace;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public String getSenderType() {
        return this.senderType;
    }

    public int getSentisive() {
        return this.sentisive;
    }

    public String getSentisiveExplain() {
        return this.sentisiveExplain;
    }

    public String getServiceEndPushMsg() {
        return this.serviceEndPushMsg;
    }

    public String getServiceOutDoc() {
        return this.serviceOutDoc;
    }

    public String getServiceOutTime() {
        return this.serviceOutTime;
    }

    public SobotEvaluateModel getSobotEvaluateModel() {
        return this.sobotEvaluateModel;
    }

    public SobotKeyWordTransfer getSobotKeyWordTransfer() {
        return this.sobotKeyWordTransfer;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStripe() {
        return this.stripe;
    }

    public String[] getSugguestions() {
        return this.sugguestions;
    }

    public int getSugguestionsFontColor() {
        return this.sugguestionsFontColor;
    }

    public String getT() {
        return this.t;
    }

    public int getTransferType() {
        return this.transferType;
    }

    public String getTs() {
        return this.ts;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUstatus() {
        return this.ustatus;
    }

    public String getWayHttp() {
        return this.wayHttp;
    }

    public String getWslinkBak() {
        return this.wslinkBak;
    }

    public String getWslinkDefault() {
        return this.wslinkDefault;
    }

    public boolean isClickCancleSend() {
        return this.isClickCancleSend;
    }

    public boolean isGuideGroupFlag() {
        return this.guideGroupFlag;
    }

    public boolean isLeaveMsgFlag() {
        return this.isLeaveMsgFlag;
    }

    public boolean isRetractedMsg() {
        return this.isRetractedMsg;
    }

    public boolean isShake() {
        return this.isShake;
    }

    public boolean isShowSentisiveSeeAll() {
        return this.isShowSentisiveSeeAll;
    }

    public boolean isShowTransferBtn() {
        return this.isShowTransferBtn;
    }

    public boolean isVoideIsPlaying() {
        return this.voideIsPlaying;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setAdminHelloWord(String str) {
        this.adminHelloWord = str;
    }

    public void setAface(String str) {
        this.aface = str;
    }

    public void setAname(String str) {
        this.aname = str;
    }

    public void setAnswer(ZhiChiReplyAnswer zhiChiReplyAnswer) {
        this.answer = zhiChiReplyAnswer;
    }

    public void setAnswerType(String str) {
        this.answerType = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setClickCancleSend(boolean z) {
        this.isClickCancleSend = z;
    }

    public void setClickCount(int i) {
        this.clickCount = i;
    }

    public void setConsultingContent(ConsultingContent consultingContent) {
        this.consultingContent = consultingContent;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setCurrentPageNum(int i) {
        this.currentPageNum = i;
    }

    public void setDesensitizationWord(String str) {
        this.desensitizationWord = str;
    }

    public void setDocId(String str) {
        this.docId = str;
    }

    public void setDocName(String str) {
        this.docName = str;
    }

    public void setGuideGroupFlag(boolean z) {
        this.guideGroupFlag = z;
    }

    public void setGuideGroupNum(int i) {
        this.guideGroupNum = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLeaveMsgFlag(boolean z) {
        this.isLeaveMsgFlag = z;
    }

    public void setListSuggestions(ArrayList<Suggestions> arrayList) {
        this.listSuggestions = arrayList;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setMsgTransfer(String str) {
        this.msgTransfer = str;
    }

    public void setMultiDiaRespEnd(int i) {
        this.multiDiaRespEnd = i;
    }

    public void setOfflineType(String str) {
        this.offlineType = str;
    }

    public void setOrderCardContent(OrderCardContentModel orderCardContentModel) {
        this.orderCardContent = orderCardContentModel;
    }

    public void setOriginQuestion(String str) {
        this.originQuestion = str;
    }

    public void setPicurl(String str) {
        this.picurl = str;
    }

    public void setProgressBar(int i) {
        this.progressBar = i;
    }

    public void setPu(String str) {
        this.pu = str;
    }

    public void setPuid(String str) {
        this.puid = str;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public void setQueueDoc(String str) {
        this.queueDoc = str;
    }

    public void setReceiver(String str) {
        this.receiver = str;
    }

    public void setReceiverFace(String str) {
        this.receiverFace = str;
    }

    public void setReceiverName(String str) {
        this.receiverName = str;
    }

    public void setReceiverType(String str) {
        this.receiverType = str;
    }

    public void setRetractedMsg(boolean z) {
        this.isRetractedMsg = z;
    }

    public void setRevaluateState(int i) {
        this.revaluateState = i;
    }

    public void setRictype(String str) {
        this.rictype = str;
    }

    public void setSdkMsg(ZhiChiHistorySDKMsg zhiChiHistorySDKMsg) {
        this.sdkMsg = zhiChiHistorySDKMsg;
    }

    public void setSendSuccessState(int i) {
        this.sendSuccessState = i;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public void setSenderFace(String str) {
        this.senderFace = str;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public void setSenderType(String str) {
        this.senderType = str;
    }

    public void setSentisive(int i) {
        this.sentisive = i;
    }

    public void setSentisiveExplain(String str) {
        this.sentisiveExplain = str;
    }

    public void setServiceEndPushMsg(String str) {
        this.serviceEndPushMsg = str;
    }

    public void setServiceOutDoc(String str) {
        this.serviceOutDoc = str;
    }

    public void setServiceOutTime(String str) {
        this.serviceOutTime = str;
    }

    public void setShake(boolean z) {
        this.isShake = z;
    }

    public void setShowSentisiveSeeAll(boolean z) {
        this.isShowSentisiveSeeAll = z;
    }

    public void setShowTransferBtn(boolean z) {
        this.isShowTransferBtn = z;
    }

    public void setSobotEvaluateModel(SobotEvaluateModel sobotEvaluateModel) {
        this.sobotEvaluateModel = sobotEvaluateModel;
    }

    public void setSobotKeyWordTransfer(SobotKeyWordTransfer sobotKeyWordTransfer) {
        this.sobotKeyWordTransfer = sobotKeyWordTransfer;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStripe(String str) {
        this.stripe = str;
    }

    public void setSugguestions(String[] strArr) {
        this.sugguestions = strArr;
    }

    public void setSugguestionsFontColor(int i) {
        this.sugguestionsFontColor = i;
    }

    public void setT(String str) {
        this.t = str;
    }

    public void setTransferType(int i) {
        this.transferType = i;
    }

    public void setTs(String str) {
        this.ts = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUstatus(int i) {
        this.ustatus = i;
    }

    public void setVoideIsPlaying(boolean z) {
        this.voideIsPlaying = z;
    }

    public void setWayHttp(String str) {
        this.wayHttp = str;
    }

    public void setWslinkBak(String str) {
        this.wslinkBak = str;
    }

    public void setWslinkDefault(String str) {
        this.wslinkDefault = str;
    }

    public String toString() {
        return "ZhiChiMessageBase{question='" + this.question + "', docId='" + this.docId + "', docName='" + this.docName + "', serviceEndPushMsg='" + this.serviceEndPushMsg + "', isShake=" + this.isShake + ", isShowTransferBtn=" + this.isShowTransferBtn + ", revaluateState=" + this.revaluateState + ", sobotEvaluateModel=" + this.sobotEvaluateModel + ", ustatus=" + this.ustatus + ", id='" + this.id + "', msgId='" + this.msgId + "', cid='" + this.cid + "', action='" + this.action + "', wslinkBak='" + this.wslinkBak + "', wslinkDefault='" + this.wslinkDefault + "', wayHttp='" + this.wayHttp + "', adminHelloWord='" + this.adminHelloWord + "', serviceOutTime='" + this.serviceOutTime + "', serviceOutDoc='" + this.serviceOutDoc + "', queueDoc='" + this.queueDoc + "', url='" + this.url + "', status='" + this.status + "', progressBar=" + this.progressBar + ", sendSuccessState=" + this.sendSuccessState + ", isRetractedMsg=" + this.isRetractedMsg + ", voideIsPlaying=" + this.voideIsPlaying + ", content='" + this.content + "', message='" + this.message + "', msg='" + this.msg + "', sender='" + this.sender + "', senderName='" + this.senderName + "', senderType='" + this.senderType + "', senderFace='" + this.senderFace + "', t='" + this.t + "', ts='" + this.ts + "', sdkMsg=" + this.sdkMsg + ", sugguestionsFontColor=" + this.sugguestionsFontColor + ", multiDiaRespEnd=" + this.multiDiaRespEnd + ", clickCount=" + this.clickCount + ", receiver='" + this.receiver + "', receiverName='" + this.receiverName + "', receiverType='" + this.receiverType + "', offlineType='" + this.offlineType + "', receiverFace='" + this.receiverFace + "', answer=" + this.answer + ", sugguestions=" + Arrays.toString(this.sugguestions) + ", answerType='" + this.answerType + "', stripe='" + this.stripe + "', listSuggestions=" + this.listSuggestions + ", picurl='" + this.picurl + "', rictype='" + this.rictype + "', pu='" + this.pu + "', puid='" + this.puid + "', count=" + this.count + ", aname='" + this.aname + "', aface='" + this.aface + "', consultingContent=" + this.consultingContent + ", orderCardContent=" + this.orderCardContent + ", sobotKeyWordTransfer=" + this.sobotKeyWordTransfer + ", transferType=" + this.transferType + ", isLeaveMsgFlag=" + this.isLeaveMsgFlag + ", sentisive=" + this.sentisive + ", sentisiveExplain='" + this.sentisiveExplain + "', isShowSentisiveSeeAll=" + this.isShowSentisiveSeeAll + ", isClickCancleSend=" + this.isClickCancleSend + ", guideGroupFlag=" + this.guideGroupFlag + ", guideGroupNum=" + this.guideGroupNum + ", currentPageNum=" + this.currentPageNum + ", originQuestion='" + this.originQuestion + "'}";
    }
}

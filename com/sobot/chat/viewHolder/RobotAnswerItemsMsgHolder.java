package com.sobot.chat.viewHolder;

import android.content.Context;
import android.os.BatteryManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.model.SobotMultiDiaRespInfo;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.HtmlTools;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.viewHolder.base.MessageHolderBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/viewHolder/RobotAnswerItemsMsgHolder.class */
public class RobotAnswerItemsMsgHolder extends MessageHolderBase implements View.OnClickListener {
    private static final int PAGE_SIZE = 9;
    private LinearLayout answersListView;
    private TextView tv_msg;
    private ZhiChiMessageBase zhiChiMessageBase;

    public RobotAnswerItemsMsgHolder(Context context, View view) {
        super(context, view);
        this.tv_msg = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_template2_msg"));
        this.answersListView = (LinearLayout) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_answersList"));
    }

    private boolean isHistoryMsg(ZhiChiMessageBase zhiChiMessageBase) {
        return zhiChiMessageBase.getSugguestionsFontColor() == 1;
    }

    private void sendMultiRoundQuestions(String str, Map<String, String> map, SobotMultiDiaRespInfo sobotMultiDiaRespInfo) {
        if (sobotMultiDiaRespInfo == null || this.msgCallBack == null || this.zhiChiMessageBase == null) {
            return;
        }
        ZhiChiMessageBase zhiChiMessageBase = new ZhiChiMessageBase();
        HashMap hashMap = new HashMap();
        hashMap.put(BatteryManager.EXTRA_LEVEL, sobotMultiDiaRespInfo.getLevel() + "");
        hashMap.put("conversationId", sobotMultiDiaRespInfo.getConversationId());
        hashMap.putAll(map);
        zhiChiMessageBase.setContent(GsonUtil.map2Str(hashMap));
        zhiChiMessageBase.setId(System.currentTimeMillis() + "");
        this.msgCallBack.sendMessageToRobot(zhiChiMessageBase, 4, 2, str, str);
    }

    @Override // com.sobot.chat.viewHolder.base.MessageHolderBase
    public void bindData(Context context, ZhiChiMessageBase zhiChiMessageBase) {
        this.zhiChiMessageBase = zhiChiMessageBase;
        if (zhiChiMessageBase.getAnswer() == null || zhiChiMessageBase.getAnswer().getMultiDiaRespInfo() == null) {
            return;
        }
        SobotMultiDiaRespInfo multiDiaRespInfo = zhiChiMessageBase.getAnswer().getMultiDiaRespInfo();
        HtmlTools.getInstance(context).setRichText(this.tv_msg, ChatUtils.getMultiMsgTitle(multiDiaRespInfo).replaceAll("\n", "<br/>"), getLinkTextColor());
        if (!"000000".equals(multiDiaRespInfo.getRetCode())) {
            this.answersListView.setVisibility(8);
            return;
        }
        List<Map<String, String>> icLists = multiDiaRespInfo.getIcLists();
        if (icLists == null || icLists.size() <= 0) {
            this.answersListView.setVisibility(8);
            return;
        }
        this.answersListView.setVisibility(0);
        this.answersListView.removeAllViews();
        for (int i = 0; i < icLists.size(); i++) {
            Map<String, String> map = icLists.get(i);
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                TextView initAnswerItemTextView = ChatUtils.initAnswerItemTextView(context, isHistoryMsg(zhiChiMessageBase));
                initAnswerItemTextView.setOnClickListener(this);
                initAnswerItemTextView.setText(next.getKey() + ":" + next.getValue());
                initAnswerItemTextView.setTag(map);
                this.answersListView.addView(initAnswerItemTextView);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        ZhiChiMessageBase zhiChiMessageBase = this.zhiChiMessageBase;
        if (zhiChiMessageBase == null || zhiChiMessageBase.getAnswer() == null || !(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof Map)) {
            return;
        }
        sendMultiRoundQuestions(((TextView) view).getText().toString(), (Map) view.getTag(), this.zhiChiMessageBase.getAnswer().getMultiDiaRespInfo());
    }
}

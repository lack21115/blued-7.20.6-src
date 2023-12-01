package com.sobot.chat.widget.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.adapter.SobotRobotListAdapter;
import com.sobot.chat.api.model.SobotRobot;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.dialog.base.SobotActionSheet;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotRobotListDialog.class */
public class SobotRobotListDialog extends SobotActionSheet implements View.OnClickListener, AdapterView.OnItemClickListener {
    private final String CANCEL_TAG;
    private LinearLayout coustom_pop_layout;
    private SobotRobotListAdapter mListAdapter;
    private SobotRobotListListener mListener;
    private String mRobotFlag;
    private String mUid;
    private GridView sobot_gv;
    private LinearLayout sobot_negativeButton;
    private TextView sobot_tv_title;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotRobotListDialog$SobotRobotListListener.class */
    public interface SobotRobotListListener {
        void onSobotRobotListItemClick(SobotRobot sobotRobot);
    }

    private SobotRobotListDialog(Activity activity) {
        super(activity);
        this.CANCEL_TAG = SobotRobotListDialog.class.getSimpleName();
    }

    public SobotRobotListDialog(Activity activity, String str, String str2, SobotRobotListListener sobotRobotListListener) {
        super(activity);
        this.CANCEL_TAG = SobotRobotListDialog.class.getSimpleName();
        this.mUid = str;
        this.mRobotFlag = str2;
        this.mListener = sobotRobotListListener;
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Exception e) {
        }
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public View getDialogContainer() {
        if (this.coustom_pop_layout == null) {
            this.coustom_pop_layout = (LinearLayout) findViewById(getResId("sobot_container"));
        }
        return this.coustom_pop_layout;
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public String getLayoutStrName() {
        return "sobot_layout_switch_robot";
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public void initData() {
        SobotMsgManager.getInstance(getContext()).getZhiChiApi().getRobotSwitchList(this.CANCEL_TAG, this.mUid, new StringResultCallBack<List<SobotRobot>>() { // from class: com.sobot.chat.widget.dialog.SobotRobotListDialog.1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onSuccess(List<SobotRobot> list) {
                Iterator<SobotRobot> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SobotRobot next = it.next();
                    if (next.getRobotFlag() != null && next.getRobotFlag().equals(SobotRobotListDialog.this.mRobotFlag)) {
                        next.setSelected(true);
                        break;
                    }
                }
                if (SobotRobotListDialog.this.mListAdapter == null) {
                    SobotRobotListDialog.this.mListAdapter = new SobotRobotListAdapter(SobotRobotListDialog.this.getContext(), list);
                    SobotRobotListDialog.this.sobot_gv.setAdapter((ListAdapter) SobotRobotListDialog.this.mListAdapter);
                    return;
                }
                List datas = SobotRobotListDialog.this.mListAdapter.getDatas();
                datas.clear();
                datas.addAll(list);
                SobotRobotListDialog.this.mListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public void initView() {
        this.sobot_negativeButton = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        TextView textView = (TextView) findViewById(getResId("sobot_tv_title"));
        this.sobot_tv_title = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_switch_robot_title"));
        GridView gridView = (GridView) findViewById(getResId("sobot_gv"));
        this.sobot_gv = gridView;
        gridView.setOnItemClickListener(this);
        this.sobot_negativeButton.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_negativeButton) {
            dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        HttpUtils.getInstance().cancelTag(this.CANCEL_TAG);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (this.mListener != null) {
            SobotRobot sobotRobot = (SobotRobot) this.mListAdapter.getItem(i);
            if (sobotRobot.getRobotFlag() != null && !sobotRobot.getRobotFlag().equals(this.mRobotFlag)) {
                this.mListener.onSobotRobotListItemClick((SobotRobot) this.mListAdapter.getItem(i));
            }
            dismiss();
        }
    }
}

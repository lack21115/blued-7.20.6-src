package com.sobot.chat.widget.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.adapter.SobotPostMsgTmpListAdapter;
import com.sobot.chat.api.model.SobotPostMsgTemplate;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.widget.dialog.base.SobotActionSheet;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotPostMsgTmpListDialog.class */
public class SobotPostMsgTmpListDialog extends SobotActionSheet implements View.OnClickListener, AdapterView.OnItemClickListener {
    private final String CANCEL_TAG;
    private LinearLayout coustom_pop_layout;
    private ArrayList<SobotPostMsgTemplate> mDatas;
    private SobotPostMsgTmpListAdapter mListAdapter;
    private SobotDialogListener mListener;
    private GridView sobot_gv;
    private LinearLayout sobot_negativeButton;
    private TextView sobot_tv_title;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotPostMsgTmpListDialog$SobotDialogListener.class */
    public interface SobotDialogListener {
        void onListItemClick(SobotPostMsgTemplate sobotPostMsgTemplate);
    }

    private SobotPostMsgTmpListDialog(Activity activity) {
        super(activity);
        this.CANCEL_TAG = SobotPostMsgTmpListDialog.class.getSimpleName();
    }

    public SobotPostMsgTmpListDialog(Activity activity, ArrayList<SobotPostMsgTemplate> arrayList, SobotDialogListener sobotDialogListener) {
        super(activity);
        this.CANCEL_TAG = SobotPostMsgTmpListDialog.class.getSimpleName();
        this.mDatas = arrayList;
        this.mListener = sobotDialogListener;
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
        return "sobot_layout_post_msg_tmps";
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public void initData() {
        if (this.mListAdapter == null) {
            SobotPostMsgTmpListAdapter sobotPostMsgTmpListAdapter = new SobotPostMsgTmpListAdapter(getContext(), this.mDatas);
            this.mListAdapter = sobotPostMsgTmpListAdapter;
            this.sobot_gv.setAdapter((ListAdapter) sobotPostMsgTmpListAdapter);
        }
    }

    @Override // com.sobot.chat.widget.dialog.base.SobotActionSheet
    public void initView() {
        this.sobot_negativeButton = (LinearLayout) findViewById(getResId("sobot_negativeButton"));
        GridView gridView = (GridView) findViewById(getResId("sobot_gv"));
        this.sobot_gv = gridView;
        gridView.setOnItemClickListener(this);
        this.sobot_negativeButton.setOnClickListener(this);
        TextView textView = (TextView) findViewById(getResId("sobot_tv_title"));
        this.sobot_tv_title = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_choice_business"));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.sobot_negativeButton) {
            dismiss();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (this.mListener != null) {
            this.mListener.onListItemClick((SobotPostMsgTemplate) this.mListAdapter.getItem(i));
            dismiss();
        }
    }
}

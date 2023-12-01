package com.sobot.chat.widget;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.SobotApi;
import com.sobot.chat.adapter.base.SobotBaseAdapter;
import com.sobot.chat.api.model.SobotRobotGuess;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.SharedPreferencesUtil;
import com.sobot.chat.utils.ZhiChiConstant;
import com.sobot.chat.widget.SobotCustomPopWindow;
import com.sobot.chat.widget.emoji.InputHelper;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.network.http.callback.StringResultCallBack;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ContainsEmojiEditText.class */
public class ContainsEmojiEditText extends EditText implements View.OnFocusChangeListener {
    private static final String LAYOUT_AUTOCOMPELTE_ITEM = "sobot_item_auto_complete_menu";
    private static final String LAYOUT_CONTENT_VIEW_LAYOUT_RES_NAME = "sobot_layout_auto_complete";
    private static final int MAX_AUTO_COMPLETE_NUM = 3;
    private static final String SOBOT_AUTO_COMPLETE_REQUEST_CANCEL_TAG = "SOBOT_AUTO_COMPLETE_REQUEST_CANCEL_TAG";
    SobotAutoCompleteListener autoCompleteListener;
    Handler handler;
    SobotAutoCompelteAdapter mAdapter;
    View mContentView;
    boolean mIsAutoComplete;
    SobotCustomPopWindow mPopWindow;
    String mRobotFlag;
    String mUid;
    MyEmojiWatcher myEmojiWatcher;
    MyWatcher myWatcher;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ContainsEmojiEditText$MyEmojiWatcher.class */
    public class MyEmojiWatcher implements TextWatcher {
        private MyEmojiWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            InputHelper.displayEmoji(ContainsEmojiEditText.this.getContext(), charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ContainsEmojiEditText$MyWatcher.class */
    public class MyWatcher implements TextWatcher {
        private MyWatcher() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LogUtils.e("beforeTextChanged: " + editable.toString());
            if (SobotApi.getSwitchMarkStatus(1)) {
                return;
            }
            ContainsEmojiEditText.this.doAfterTextChanged(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LogUtils.e("beforeTextChanged: " + charSequence.toString());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LogUtils.e("onTextChanged: " + charSequence.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ContainsEmojiEditText$SobotAutoCompelteAdapter.class */
    public static class SobotAutoCompelteAdapter extends SobotBaseAdapter<SobotRobotGuess.RespInfoListBean> {

        /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ContainsEmojiEditText$SobotAutoCompelteAdapter$ViewHolder.class */
        static class ViewHolder {
            private TextView sobot_child_menu;

            private ViewHolder(Context context, View view) {
                this.sobot_child_menu = (TextView) view.findViewById(ResourceUtils.getIdByName(context, "id", "sobot_child_menu"));
            }
        }

        private SobotAutoCompelteAdapter(Context context, List<SobotRobotGuess.RespInfoListBean> list) {
            super(context, list);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(this.context, ResourceUtils.getIdByName(this.context, "layout", ContainsEmojiEditText.LAYOUT_AUTOCOMPELTE_ITEM), null);
                viewHolder = new ViewHolder(this.context, view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SobotRobotGuess.RespInfoListBean respInfoListBean = (SobotRobotGuess.RespInfoListBean) this.list.get(i);
            if (respInfoListBean == null || TextUtils.isEmpty(respInfoListBean.getHighlight())) {
                viewHolder.sobot_child_menu.setText("");
                return view;
            }
            viewHolder.sobot_child_menu.setText(Html.fromHtml(respInfoListBean.getHighlight()));
            return view;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ContainsEmojiEditText$SobotAutoCompleteListener.class */
    public interface SobotAutoCompleteListener {
        void onRobotGuessComplete(String str);
    }

    public ContainsEmojiEditText(Context context) {
        super(context);
        this.handler = new Handler();
        initEditText();
    }

    public ContainsEmojiEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler();
        initEditText();
    }

    public ContainsEmojiEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new Handler();
        initEditText();
    }

    private View getContentView() {
        if (this.mContentView == null) {
            synchronized (ContainsEmojiEditText.class) {
                try {
                    if (this.mContentView == null) {
                        this.mContentView = LayoutInflater.from(getContext()).inflate(ResourceUtils.getIdByName(getContext(), "layout", LAYOUT_CONTENT_VIEW_LAYOUT_RES_NAME), (ViewGroup) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.mContentView;
    }

    private ListView handleListView(View view, List<SobotRobotGuess.RespInfoListBean> list) {
        final ListView listView = (ListView) view.findViewById(getResId("sobot_lv_menu"));
        notifyAdapter(listView, list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sobot.chat.widget.ContainsEmojiEditText.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                List<SobotRobotGuess.RespInfoListBean> datas;
                Tracker.onItemClick(adapterView, view2, i, j);
                ContainsEmojiEditText.this.dismissPop();
                if (ContainsEmojiEditText.this.autoCompleteListener == null || (datas = ((SobotAutoCompelteAdapter) listView.getAdapter()).getDatas()) == null || i >= datas.size()) {
                    return;
                }
                ContainsEmojiEditText.this.autoCompleteListener.onRobotGuessComplete(datas.get(i).getQuestion());
            }
        });
        return listView;
    }

    private void initEditText() {
        MyEmojiWatcher myEmojiWatcher = new MyEmojiWatcher();
        this.myEmojiWatcher = myEmojiWatcher;
        addTextChangedListener(myEmojiWatcher);
        if (SharedPreferencesUtil.getBooleanData(getContext(), ZhiChiConstant.SOBOT_CONFIG_SUPPORT, false)) {
            setOnFocusChangeListener(this);
            MyWatcher myWatcher = new MyWatcher();
            this.myWatcher = myWatcher;
            addTextChangedListener(myWatcher);
            if (SobotApi.getSwitchMarkStatus(1)) {
                setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sobot.chat.widget.ContainsEmojiEditText.1
                    @Override // android.widget.TextView.OnEditorActionListener
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == 6) {
                            KeyboardUtil.hideKeyboard(ContainsEmojiEditText.this);
                            ContainsEmojiEditText.this.doAfterTextChanged(textView.getText().toString());
                            return true;
                        } else if (i == 0) {
                            KeyboardUtil.hideKeyboard(ContainsEmojiEditText.this);
                            ContainsEmojiEditText.this.doAfterTextChanged(textView.getText().toString());
                            return true;
                        } else {
                            return false;
                        }
                    }
                });
            }
        }
    }

    private void measureListViewHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < Math.min(adapter.getCount(), 3); i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(0, 0);
            i += view.getMeasuredHeight();
        }
        int dividerHeight = i + ((listView.getDividerHeight() * adapter.getCount()) - 1);
        int i3 = dividerHeight;
        if (adapter.getCount() > 3) {
            i3 = dividerHeight + ScreenUtils.dip2px(getContext(), 10.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) listView.getLayoutParams();
        layoutParams.height = i3;
        listView.setLayoutParams(layoutParams);
    }

    private void notifyAdapter(ListView listView, List<SobotRobotGuess.RespInfoListBean> list) {
        SobotAutoCompelteAdapter sobotAutoCompelteAdapter = this.mAdapter;
        if (sobotAutoCompelteAdapter == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.clear();
            arrayList.addAll(list);
            SobotAutoCompelteAdapter sobotAutoCompelteAdapter2 = new SobotAutoCompelteAdapter(getContext(), arrayList);
            this.mAdapter = sobotAutoCompelteAdapter2;
            listView.setAdapter((ListAdapter) sobotAutoCompelteAdapter2);
        } else {
            List<SobotRobotGuess.RespInfoListBean> datas = sobotAutoCompelteAdapter.getDatas();
            if (datas != null) {
                datas.clear();
                datas.addAll(list);
            }
            this.mAdapter.notifyDataSetChanged();
        }
        listView.setSelection(0);
        measureListViewHeight(listView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPop(final View view, List<SobotRobotGuess.RespInfoListBean> list) {
        if (getWindowVisibility() == 8) {
            return;
        }
        if (list == null || list.size() == 0) {
            dismissPop();
            return;
        }
        View contentView = getContentView();
        ListView handleListView = handleListView(contentView, list);
        if (this.mPopWindow == null) {
            this.mPopWindow = new SobotCustomPopWindow.PopupWindowBuilder(getContext()).setView(contentView).setFocusable(false).setOutsideTouchable(false).setWidthMatchParent(true).create();
        }
        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) handleListView.getLayoutParams();
        this.mPopWindow.showAsDropDown(view, 0, -(view.getHeight() + layoutParams.height));
        this.handler.post(new Runnable() { // from class: com.sobot.chat.widget.ContainsEmojiEditText.3
            @Override // java.lang.Runnable
            public void run() {
                PopupWindow popupWindow = ContainsEmojiEditText.this.mPopWindow.getPopupWindow();
                View view2 = view;
                popupWindow.update(view2, 0, -(view2.getHeight() + layoutParams.height), ContainsEmojiEditText.this.mPopWindow.getPopupWindow().getWidth(), layoutParams.height);
            }
        });
    }

    public void dismissPop() {
        SobotCustomPopWindow sobotCustomPopWindow = this.mPopWindow;
        if (sobotCustomPopWindow != null) {
            try {
                sobotCustomPopWindow.dissmiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doAfterTextChanged(String str) {
        if (this.mIsAutoComplete) {
            if (TextUtils.isEmpty(str)) {
                dismissPop();
                return;
            }
            HttpUtils.getInstance().cancelTag(SOBOT_AUTO_COMPLETE_REQUEST_CANCEL_TAG);
            SobotMsgManager.getInstance(getContext()).getZhiChiApi().robotGuess(SOBOT_AUTO_COMPLETE_REQUEST_CANCEL_TAG, this.mUid, this.mRobotFlag, str, new StringResultCallBack<SobotRobotGuess>() { // from class: com.sobot.chat.widget.ContainsEmojiEditText.2
                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onFailure(Exception exc, String str2) {
                }

                @Override // com.sobot.network.http.callback.StringResultCallBack
                public void onSuccess(SobotRobotGuess sobotRobotGuess) {
                    try {
                        if (ContainsEmojiEditText.this.getText().toString().equals(sobotRobotGuess.getOriginQuestion())) {
                            ContainsEmojiEditText.this.showPop(ContainsEmojiEditText.this, sobotRobotGuess.getRespInfoList());
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    public int getResId(String str) {
        return ResourceUtils.getIdByName(getContext(), "id", str);
    }

    public boolean isShowing() {
        PopupWindow popupWindow;
        SobotCustomPopWindow sobotCustomPopWindow = this.mPopWindow;
        if (sobotCustomPopWindow == null || (popupWindow = sobotCustomPopWindow.getPopupWindow()) == null) {
            return false;
        }
        return popupWindow.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        removeTextChangedListener(this.myWatcher);
        HttpUtils.getInstance().cancelTag(SOBOT_AUTO_COMPLETE_REQUEST_CANCEL_TAG);
        dismissPop();
        this.autoCompleteListener = null;
        this.mContentView = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Tracker.onFocusChange(view, z);
        if (z) {
            return;
        }
        dismissPop();
    }

    public void setAutoCompleteEnable(boolean z) {
        this.mIsAutoComplete = z;
        if (z) {
            return;
        }
        HttpUtils.getInstance().cancelTag(SOBOT_AUTO_COMPLETE_REQUEST_CANCEL_TAG);
        dismissPop();
    }

    public void setRequestParams(String str, String str2) {
        this.mUid = str;
        this.mRobotFlag = str2;
    }

    public void setSobotAutoCompleteListener(SobotAutoCompleteListener sobotAutoCompleteListener) {
        this.autoCompleteListener = sobotAutoCompleteListener;
    }
}

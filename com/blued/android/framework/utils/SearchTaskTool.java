package com.blued.android.framework.utils;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/SearchTaskTool.class */
public class SearchTaskTool implements TextWatcher, TextView.OnEditorActionListener {
    private List<TaskListener> b;
    private EditText c;
    private String d;
    private long a = 500;
    private Handler e = new Handler(new Handler.Callback() { // from class: com.blued.android.framework.utils.SearchTaskTool.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.obj != null) {
                String obj = message.obj.toString();
                if (message.what == 1) {
                    SearchTaskTool.this.a(obj);
                    return false;
                }
                return false;
            }
            return false;
        }
    });

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/SearchTaskTool$TaskListener.class */
    public interface TaskListener {
        void a(String str);
    }

    public SearchTaskTool(EditText editText) {
        this.c = editText;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d = "";
        } else {
            this.d = str.replaceAll("\\r\\n", "").replaceAll("\\n", "");
        }
        List<TaskListener> list = this.b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (TaskListener taskListener : this.b) {
            taskListener.a(str);
        }
    }

    private void a(String str, long j) {
        List<TaskListener> list;
        Handler handler;
        String replaceAll = TextUtils.isEmpty(str) ? "" : str.replaceAll("\\r\\n", "").replaceAll("\\n", "");
        if ((TextUtils.isEmpty(this.d) || !replaceAll.equals(this.d)) && (list = this.b) != null && list.size() > 0 && (handler = this.e) != null) {
            handler.removeMessages(1);
            Message obtainMessage = this.e.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = str;
            if (j > 0) {
                this.e.sendMessageDelayed(obtainMessage, j);
            } else {
                this.e.sendMessage(obtainMessage);
            }
        }
    }

    private void b() {
        this.b = new ArrayList();
        EditText editText = this.c;
        if (editText != null) {
            editText.addTextChangedListener(this);
        }
    }

    private void b(String str) {
        a(str, 0L);
    }

    public void a() {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(TaskListener taskListener) {
        synchronized (this) {
            if (this.b != null) {
                this.b.add(taskListener);
            }
        }
    }

    public void a(boolean z) {
        EditText editText;
        if (!z || (editText = this.c) == null) {
            return;
        }
        editText.setOnEditorActionListener(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString())) {
            b(editable.toString());
        } else {
            a(editable.toString(), this.a);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3 || i == 6 || (keyEvent != null && keyEvent.getKeyCode() == 0)) {
            b(textView.getText().toString());
            return true;
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}

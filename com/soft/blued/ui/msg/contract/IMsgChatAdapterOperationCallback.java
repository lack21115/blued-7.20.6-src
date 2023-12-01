package com.soft.blued.ui.msg.contract;

import android.app.Activity;
import android.widget.EditText;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/contract/IMsgChatAdapterOperationCallback.class */
public interface IMsgChatAdapterOperationCallback {
    void a(ChattingModel chattingModel);

    Activity getActivity();

    ActivityFragmentActive getFragmentActive();

    void t();

    void u();

    BaseFragment v();

    EditText w();

    void x();

    void y();
}

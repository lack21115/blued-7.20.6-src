package com.blued.android.chat.grpc.listener;

import com.blued.android.chat.model.ChattingModel;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/listener/MsgContentListener.class */
public interface MsgContentListener {
    void onMsgDataChanged(List<ChattingModel> list);
}

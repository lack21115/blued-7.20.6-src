package com.blued.android.module.chat.contract;

import com.blued.android.chat.model.SessionModel;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/contract/FilterSessionListListener.class */
public interface FilterSessionListListener {
    void onUISessionDataChanged(List<SessionModel> list, List<SessionModel> list2);
}

package com.blued.android.module.chat.contract;

import android.util.Pair;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/contract/IChatRelationDataListener.class */
public interface IChatRelationDataListener {
    void onDeleteSessions(List<Pair<Short, Long>> list);
}

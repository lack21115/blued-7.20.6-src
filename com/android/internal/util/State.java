package com.android.internal.util;

import android.os.Message;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/State.class */
public class State implements IState {
    @Override // com.android.internal.util.IState
    public void enter() {
    }

    @Override // com.android.internal.util.IState
    public void exit() {
    }

    @Override // com.android.internal.util.IState
    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }

    @Override // com.android.internal.util.IState
    public boolean processMessage(Message message) {
        return false;
    }
}

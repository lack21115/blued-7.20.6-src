package com.android.internal.util;

import android.os.Message;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/IState.class */
public interface IState {
    public static final boolean HANDLED = true;
    public static final boolean NOT_HANDLED = false;

    void enter();

    void exit();

    String getName();

    boolean processMessage(Message message);
}

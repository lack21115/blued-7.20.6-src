package com.umeng.commonsdk.utils;

import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/utils/FileLockCallback.class */
public interface FileLockCallback {
    boolean onFileLock(File file, int i);

    boolean onFileLock(String str);

    boolean onFileLock(String str, Object obj);
}

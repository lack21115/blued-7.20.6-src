package com.tencent.tinker.lib.patch;

import android.content.Context;
import com.tencent.tinker.lib.service.PatchResult;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/AbstractPatch.class */
public abstract class AbstractPatch {
    public abstract boolean tryPatch(Context context, String str, PatchResult patchResult);
}

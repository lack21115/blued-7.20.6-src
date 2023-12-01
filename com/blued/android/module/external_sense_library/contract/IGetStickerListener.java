package com.blued.android.module.external_sense_library.contract;

import com.blued.android.module.external_sense_library.model.ErrorCode;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/contract/IGetStickerListener.class */
public interface IGetStickerListener {
    void onFailed(ErrorCode.PlayStickerCode playStickerCode, String str);

    void onSuccess(String str, String str2);

    void onSyncStart();
}

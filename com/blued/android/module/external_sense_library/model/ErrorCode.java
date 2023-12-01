package com.blued.android.module.external_sense_library.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/ErrorCode.class */
public class ErrorCode {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/ErrorCode$PlayStickerCode.class */
    public enum PlayStickerCode {
        DATA_ERROR(-1),
        DOWNLOAD_FAIL(-2);
        
        private final int c;

        PlayStickerCode(int i) {
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }
}

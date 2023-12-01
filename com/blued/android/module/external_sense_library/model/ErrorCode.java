package com.blued.android.module.external_sense_library.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/ErrorCode.class */
public class ErrorCode {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/model/ErrorCode$PlayStickerCode.class */
    public enum PlayStickerCode {
        DATA_ERROR(-1),
        DOWNLOAD_FAIL(-2);
        

        /* renamed from: c  reason: collision with root package name */
        private final int f11261c;

        PlayStickerCode(int i) {
            this.f11261c = i;
        }

        public int a() {
            return this.f11261c;
        }
    }
}

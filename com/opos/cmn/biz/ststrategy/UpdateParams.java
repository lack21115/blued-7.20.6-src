package com.opos.cmn.biz.ststrategy;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/UpdateParams.class */
public class UpdateParams {
    public final String pkgName;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/ststrategy/UpdateParams$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f11003a;

        public UpdateParams build() {
            if (TextUtils.isEmpty(this.f11003a)) {
                throw new NullPointerException("update params can not be null!");
            }
            return new UpdateParams(this);
        }

        public Builder setPkgName(String str) {
            this.f11003a = str;
            return this;
        }
    }

    private UpdateParams(Builder builder) {
        this.pkgName = builder.f11003a;
    }
}

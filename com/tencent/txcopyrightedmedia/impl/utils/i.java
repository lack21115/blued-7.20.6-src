package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.ErrorCode;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/i.class */
public final class i extends ErrorCode {

    /* renamed from: a  reason: collision with root package name */
    public a f26410a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/i$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f26411a = 0;
        public String b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f26412c = "";

        public final a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            if (!TextUtils.isEmpty(this.f26412c)) {
                str = this.f26412c + " | " + str;
            }
            this.f26412c = str;
            return this;
        }
    }

    public i(int i, String str) {
        this.code = i;
        this.msg = str;
        a aVar = new a();
        this.f26410a = aVar;
        aVar.f26411a = i;
        aVar.a(str);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ErrorCode) && ((ErrorCode) obj).code == this.code;
    }

    public final String toString() {
        return "err_code: " + this.code + ", msg: " + this.msg;
    }
}

package com.igexin.base.api;

import android.text.TextUtils;
import com.igexin.base.a.a;
import com.igexin.base.a.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/api/Logger.class */
public final class Logger implements a {
    private a mBase;

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/base/api/Logger$Builder.class */
    public static class Builder {
        private c mLog = new c();

        public Logger build() {
            return new Logger(this.mLog);
        }

        public Builder enableLog(boolean z) {
            this.mLog.enableLog(z);
            return this;
        }

        public Builder setPath(String str) {
            if (TextUtils.isEmpty(str)) {
                throw null;
            }
            this.mLog.f = str;
            return this;
        }

        public Builder setPeriodicCondition(int i, long j) {
            c cVar = this.mLog;
            int max = Math.max(0, i);
            long max2 = Math.max(0L, j);
            cVar.b = max;
            cVar.f23207c = max2;
            return this;
        }

        public Builder setRc4Key(String str) {
            if (!TextUtils.isEmpty(str) && com.igexin.base.util.a.a.a(str.getBytes())) {
                this.mLog.e = str;
            }
            return this;
        }
    }

    private Logger(a aVar) {
        this.mBase = aVar;
    }

    @Override // com.igexin.base.a.a
    public final void enableLog(boolean z) {
        this.mBase.enableLog(z);
    }

    @Override // com.igexin.base.a.a
    public final boolean isEnabled() {
        return this.mBase.isEnabled();
    }

    @Override // com.igexin.base.a.a
    public final void log(String str) {
        this.mBase.log(str);
    }
}

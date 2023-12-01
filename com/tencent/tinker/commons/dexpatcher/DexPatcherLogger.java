package com.tencent.tinker.commons.dexpatcher;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/DexPatcherLogger.class */
public final class DexPatcherLogger {
    private IDexPatcherLogger loggerImpl = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/commons/dexpatcher/DexPatcherLogger$IDexPatcherLogger.class */
    public interface IDexPatcherLogger {
        void d(String str);

        void e(String str);

        void i(String str);

        void v(String str);

        void w(String str);
    }

    public void d(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[D][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            String str4 = str3;
            if (objArr != null) {
                str4 = objArr.length == 0 ? str3 : String.format(str3, objArr);
            }
            iDexPatcherLogger.d(str4);
        }
    }

    public void e(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[E][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            String str4 = str3;
            if (objArr != null) {
                str4 = objArr.length == 0 ? str3 : String.format(str3, objArr);
            }
            iDexPatcherLogger.e(str4);
        }
    }

    public IDexPatcherLogger getLoggerImpl() {
        return this.loggerImpl;
    }

    public void i(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[I][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            String str4 = str3;
            if (objArr != null) {
                str4 = objArr.length == 0 ? str3 : String.format(str3, objArr);
            }
            iDexPatcherLogger.i(str4);
        }
    }

    public void setLoggerImpl(IDexPatcherLogger iDexPatcherLogger) {
        this.loggerImpl = iDexPatcherLogger;
    }

    public void v(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[V][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            String str4 = str3;
            if (objArr != null) {
                str4 = objArr.length == 0 ? str3 : String.format(str3, objArr);
            }
            iDexPatcherLogger.v(str4);
        }
    }

    public void w(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            String str3 = "[W][" + str + "] " + str2;
            IDexPatcherLogger iDexPatcherLogger = this.loggerImpl;
            String str4 = str3;
            if (objArr != null) {
                str4 = objArr.length == 0 ? str3 : String.format(str3, objArr);
            }
            iDexPatcherLogger.w(str4);
        }
    }
}

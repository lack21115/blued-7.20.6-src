package com.blued.android.framework.provider;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IAppInfoProvider.class */
public interface IAppInfoProvider {
    public static final EmptyImpl a = new EmptyImpl();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IAppInfoProvider$EmptyImpl.class */
    public static class EmptyImpl implements IAppInfoProvider {
        @Override // com.blued.android.framework.provider.IAppInfoProvider
        public String a() {
            return "0";
        }

        @Override // com.blued.android.framework.provider.IAppInfoProvider
        public String b() {
            return "";
        }
    }

    String a();

    String b();
}

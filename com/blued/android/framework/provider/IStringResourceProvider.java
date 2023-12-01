package com.blued.android.framework.provider;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IStringResourceProvider.class */
public interface IStringResourceProvider {
    public static final EmptyImpl a = new EmptyImpl();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IStringResourceProvider$EmptyImpl.class */
    public static class EmptyImpl implements IStringResourceProvider {
        @Override // com.blued.android.framework.provider.IStringResourceProvider
        public String a() {
            return "Upload file";
        }

        @Override // com.blued.android.framework.provider.IStringResourceProvider
        public String a(int i) {
            return "network error:(" + i + ")";
        }

        @Override // com.blued.android.framework.provider.IStringResourceProvider
        public String b() {
            return "Unstable network, please try again later.";
        }
    }

    String a();

    String a(int i);

    String b();
}

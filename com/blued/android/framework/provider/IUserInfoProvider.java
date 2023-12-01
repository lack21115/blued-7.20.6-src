package com.blued.android.framework.provider;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IUserInfoProvider.class */
public interface IUserInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyImpl f9840a = new EmptyImpl();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IUserInfoProvider$EmptyImpl.class */
    public static class EmptyImpl implements IUserInfoProvider {
        @Override // com.blued.android.framework.provider.IUserInfoProvider
        public String a() {
            return null;
        }

        @Override // com.blued.android.framework.provider.IUserInfoProvider
        public void a(String str) {
        }

        @Override // com.blued.android.framework.provider.IUserInfoProvider
        public String b() {
            return null;
        }

        @Override // com.blued.android.framework.provider.IUserInfoProvider
        public void c() {
        }

        @Override // com.blued.android.framework.provider.IUserInfoProvider
        public void d() {
        }
    }

    String a();

    void a(String str);

    String b();

    void c();

    void d();
}

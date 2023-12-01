package com.blued.android.framework.provider;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IPageLifecycleProvider.class */
public interface IPageLifecycleProvider {
    public static final EmptyImpl a = new EmptyImpl();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/IPageLifecycleProvider$EmptyImpl.class */
    public static class EmptyImpl implements IPageLifecycleProvider {
        @Override // com.blued.android.framework.provider.IPageLifecycleProvider
        public Context a(Context context) {
            return context;
        }

        @Override // com.blued.android.framework.provider.IPageLifecycleProvider
        public void a(Context context, Bundle bundle) {
        }

        @Override // com.blued.android.framework.provider.IPageLifecycleProvider
        public void a(Bundle bundle) {
        }

        @Override // com.blued.android.framework.provider.IPageLifecycleProvider
        public void a(String str) {
        }

        @Override // com.blued.android.framework.provider.IPageLifecycleProvider
        public void b(String str) {
        }
    }

    Context a(Context context);

    void a(Context context, Bundle bundle);

    void a(Bundle bundle);

    void a(String str);

    void b(String str);
}

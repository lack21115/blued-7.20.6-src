package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.image.ImageLoaderAppSetting;
import com.blued.android.core.image.ImageLoaderLibrarySetting;
import java.util.Collections;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/GeneratedAppGlideModuleImpl.class */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoaderAppSetting f20644a = new ImageLoaderAppSetting();

    public GeneratedAppGlideModuleImpl(Context context) {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.blued.android.core.image.ImageLoaderAppSetting");
            Log.d("Glide", "Discovered LibraryGlideModule from annotation: com.blued.android.core.image.ImageLoaderLibrarySetting");
        }
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void a(Context context, Glide glide, Registry registry) {
        new ImageLoaderLibrarySetting().a(context, glide, registry);
        this.f20644a.a(context, glide, registry);
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void a(Context context, GlideBuilder glideBuilder) {
        this.f20644a.a(context, glideBuilder);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public boolean c() {
        return this.f20644a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    /* renamed from: d */
    public GeneratedRequestManagerFactory b() {
        return new GeneratedRequestManagerFactory();
    }
}

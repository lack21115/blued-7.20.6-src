package com.kwad.sdk.core.imageloader.cache.disc.naming;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/cache/disc/naming/HashCodeFileNameGenerator.class */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}

package com.mokee.volley.toolbox;

import com.mokee.volley.Cache;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/NoCache.class */
public class NoCache implements Cache {
    @Override // com.mokee.volley.Cache
    public void clear() {
    }

    @Override // com.mokee.volley.Cache
    public Cache.Entry get(String str) {
        return null;
    }

    @Override // com.mokee.volley.Cache
    public void initialize() {
    }

    @Override // com.mokee.volley.Cache
    public void invalidate(String str, boolean z) {
    }

    @Override // com.mokee.volley.Cache
    public void put(String str, Cache.Entry entry) {
    }

    @Override // com.mokee.volley.Cache
    public void remove(String str) {
    }
}

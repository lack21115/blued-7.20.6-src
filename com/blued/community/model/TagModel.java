package com.blued.community.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/TagModel.class */
public final class TagModel implements Serializable {
    private String id;
    private String name;

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }
}

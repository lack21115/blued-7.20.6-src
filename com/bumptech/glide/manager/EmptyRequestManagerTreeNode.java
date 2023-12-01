package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/EmptyRequestManagerTreeNode.class */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set<RequestManager> a() {
        return Collections.emptySet();
    }
}

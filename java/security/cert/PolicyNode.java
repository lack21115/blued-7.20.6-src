package java.security.cert;

import java.util.Iterator;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PolicyNode.class */
public interface PolicyNode {
    Iterator<? extends PolicyNode> getChildren();

    int getDepth();

    Set<String> getExpectedPolicies();

    PolicyNode getParent();

    Set<? extends PolicyQualifierInfo> getPolicyQualifiers();

    String getValidPolicy();

    boolean isCritical();
}

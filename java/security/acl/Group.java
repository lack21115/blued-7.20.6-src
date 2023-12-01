package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

/* loaded from: source-2895416-dex2jar.jar:java/security/acl/Group.class */
public interface Group extends Principal {
    boolean addMember(Principal principal);

    boolean isMember(Principal principal);

    Enumeration<? extends Principal> members();

    boolean removeMember(Principal principal);
}

package java.security.acl;

import java.security.Principal;

/* loaded from: source-2895416-dex2jar.jar:java/security/acl/Owner.class */
public interface Owner {
    boolean addOwner(Principal principal, Principal principal2) throws NotOwnerException;

    boolean deleteOwner(Principal principal, Principal principal2) throws NotOwnerException, LastOwnerException;

    boolean isOwner(Principal principal);
}

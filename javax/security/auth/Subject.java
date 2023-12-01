package javax.security.auth;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.DomainCombiner;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:javax/security/auth/Subject.class */
public final class Subject implements Serializable {
    private static final long serialVersionUID = -8308522755600156056L;
    private final Set<Principal> principals;
    private transient SecureSet<Object> privateCredentials;
    private transient SecureSet<Object> publicCredentials;
    private boolean readOnly;
    private static final AuthPermission _AS = new AuthPermission("doAs");
    private static final AuthPermission _AS_PRIVILEGED = new AuthPermission("doAsPrivileged");
    private static final AuthPermission _SUBJECT = new AuthPermission("getSubject");
    private static final AuthPermission _PRINCIPALS = new AuthPermission("modifyPrincipals");
    private static final AuthPermission _PRIVATE_CREDENTIALS = new AuthPermission("modifyPrivateCredentials");
    private static final AuthPermission _PUBLIC_CREDENTIALS = new AuthPermission("modifyPublicCredentials");
    private static final AuthPermission _READ_ONLY = new AuthPermission("setReadOnly");

    /* loaded from: source-2895416-dex2jar.jar:javax/security/auth/Subject$SecureSet.class */
    private final class SecureSet<SST> extends AbstractSet<SST> implements Serializable {
        private static final int SET_Principal = 0;
        private static final int SET_PrivCred = 1;
        private static final int SET_PubCred = 2;
        private static final long serialVersionUID = 7911754171111800359L;
        private LinkedList<SST> elements;
        private transient AuthPermission permission;
        private int setType;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-2895416-dex2jar.jar:javax/security/auth/Subject$SecureSet$SecureIterator.class */
        public class SecureIterator implements Iterator<SST> {
            protected Iterator<SST> iterator;

            protected SecureIterator(Iterator<SST> it) {
                this.iterator = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iterator.hasNext();
            }

            @Override // java.util.Iterator
            public SST next() {
                return this.iterator.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                Subject.this.checkState();
                this.iterator.remove();
            }
        }

        protected SecureSet(AuthPermission authPermission) {
            this.permission = authPermission;
            this.elements = new LinkedList<>();
        }

        protected SecureSet(Subject subject, AuthPermission authPermission, Collection<? extends SST> collection) {
            this(authPermission);
            boolean z = collection.getClass().getClassLoader() == null;
            for (SST sst : collection) {
                verifyElement(sst);
                if (z || !this.elements.contains(sst)) {
                    this.elements.add(sst);
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            switch (this.setType) {
                case 0:
                    this.permission = Subject._PRINCIPALS;
                    break;
                case 1:
                    this.permission = Subject._PRIVATE_CREDENTIALS;
                    break;
                case 2:
                    this.permission = Subject._PUBLIC_CREDENTIALS;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            Iterator<SST> it = this.elements.iterator();
            while (it.hasNext()) {
                verifyElement(it.next());
            }
        }

        private void verifyElement(Object obj) {
            if (obj == null) {
                throw new NullPointerException("o == null");
            }
            if (this.permission == Subject._PRINCIPALS && !Principal.class.isAssignableFrom(obj.getClass())) {
                throw new IllegalArgumentException("Element is not instance of java.security.Principal");
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            if (this.permission == Subject._PRIVATE_CREDENTIALS) {
                this.setType = 1;
            } else if (this.permission == Subject._PRINCIPALS) {
                this.setType = 0;
            } else {
                this.setType = 2;
            }
            objectOutputStream.defaultWriteObject();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(SST sst) {
            verifyElement(sst);
            Subject.this.checkState();
            if (this.elements.contains(sst)) {
                return false;
            }
            this.elements.add(sst);
            return true;
        }

        protected final <E> Set<E> get(final Class<E> cls) {
            if (cls == null) {
                throw new NullPointerException("c == null");
            }
            AbstractSet<E> abstractSet = new AbstractSet<E>() { // from class: javax.security.auth.Subject.SecureSet.2
                private LinkedList<E> elements = new LinkedList<>();

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean add(E e) {
                    if (cls.isAssignableFrom(e.getClass())) {
                        if (this.elements.contains(e)) {
                            return false;
                        }
                        this.elements.add(e);
                        return true;
                    }
                    throw new IllegalArgumentException("Invalid type: " + e.getClass());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<E> iterator() {
                    return this.elements.iterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    if (collection == null) {
                        throw new NullPointerException("c == null");
                    }
                    return super.retainAll(collection);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return this.elements.size();
                }
            };
            Iterator<SST> it = iterator();
            while (it.hasNext()) {
                SST next = it.next();
                if (cls.isAssignableFrom(next.getClass())) {
                    abstractSet.add(cls.cast(next));
                }
            }
            return abstractSet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<SST> iterator() {
            return this.permission == Subject._PRIVATE_CREDENTIALS ? new SecureSet<SST>.SecureIterator(this.elements.iterator()) { // from class: javax.security.auth.Subject.SecureSet.1
                @Override // javax.security.auth.Subject.SecureSet.SecureIterator, java.util.Iterator
                public SST next() {
                    return this.iterator.next();
                }
            } : new SecureIterator(this.elements.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            if (collection == null) {
                throw new NullPointerException("c == null");
            }
            return super.retainAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.elements.size();
        }
    }

    public Subject() {
        this.principals = new SecureSet(_PRINCIPALS);
        this.publicCredentials = new SecureSet<>(_PUBLIC_CREDENTIALS);
        this.privateCredentials = new SecureSet<>(_PRIVATE_CREDENTIALS);
        this.readOnly = false;
    }

    public Subject(boolean z, Set<? extends Principal> set, Set<?> set2, Set<?> set3) {
        if (set == null) {
            throw new NullPointerException("subjPrincipals == null");
        }
        if (set2 == null) {
            throw new NullPointerException("pubCredentials == null");
        }
        if (set3 == null) {
            throw new NullPointerException("privCredentials == null");
        }
        this.principals = new SecureSet(this, _PRINCIPALS, set);
        this.publicCredentials = new SecureSet<>(this, _PUBLIC_CREDENTIALS, set2);
        this.privateCredentials = new SecureSet<>(this, _PRIVATE_CREDENTIALS, set3);
        this.readOnly = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkState() {
        if (this.readOnly) {
            throw new IllegalStateException("Set is read-only");
        }
    }

    public static <T> T doAs(Subject subject, PrivilegedAction<T> privilegedAction) {
        return (T) doAs_PrivilegedAction(subject, privilegedAction, AccessController.getContext());
    }

    public static <T> T doAs(Subject subject, PrivilegedExceptionAction<T> privilegedExceptionAction) throws PrivilegedActionException {
        return (T) doAs_PrivilegedExceptionAction(subject, privilegedExceptionAction, AccessController.getContext());
    }

    public static <T> T doAsPrivileged(Subject subject, PrivilegedAction<T> privilegedAction, AccessControlContext accessControlContext) {
        return accessControlContext == null ? (T) doAs_PrivilegedAction(subject, privilegedAction, new AccessControlContext(new ProtectionDomain[0])) : (T) doAs_PrivilegedAction(subject, privilegedAction, accessControlContext);
    }

    public static <T> T doAsPrivileged(Subject subject, PrivilegedExceptionAction<T> privilegedExceptionAction, AccessControlContext accessControlContext) throws PrivilegedActionException {
        return accessControlContext == null ? (T) doAs_PrivilegedExceptionAction(subject, privilegedExceptionAction, new AccessControlContext(new ProtectionDomain[0])) : (T) doAs_PrivilegedExceptionAction(subject, privilegedExceptionAction, accessControlContext);
    }

    private static <T> T doAs_PrivilegedAction(Subject subject, PrivilegedAction<T> privilegedAction, final AccessControlContext accessControlContext) {
        final SubjectDomainCombiner subjectDomainCombiner = subject == null ? null : new SubjectDomainCombiner(subject);
        return (T) AccessController.doPrivileged(privilegedAction, (AccessControlContext) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.security.auth.Subject.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return new AccessControlContext(AccessControlContext.this, subjectDomainCombiner);
            }
        }));
    }

    private static <T> T doAs_PrivilegedExceptionAction(Subject subject, PrivilegedExceptionAction<T> privilegedExceptionAction, final AccessControlContext accessControlContext) throws PrivilegedActionException {
        final SubjectDomainCombiner subjectDomainCombiner = subject == null ? null : new SubjectDomainCombiner(subject);
        return (T) AccessController.doPrivileged(privilegedExceptionAction, (AccessControlContext) AccessController.doPrivileged(new PrivilegedAction<AccessControlContext>() { // from class: javax.security.auth.Subject.2
            @Override // java.security.PrivilegedAction
            public AccessControlContext run() {
                return new AccessControlContext(AccessControlContext.this, subjectDomainCombiner);
            }
        }));
    }

    public static Subject getSubject(final AccessControlContext accessControlContext) {
        if (accessControlContext == null) {
            throw new NullPointerException("context == null");
        }
        DomainCombiner domainCombiner = (DomainCombiner) AccessController.doPrivileged(new PrivilegedAction<DomainCombiner>() { // from class: javax.security.auth.Subject.3
            @Override // java.security.PrivilegedAction
            public DomainCombiner run() {
                return AccessControlContext.this.getDomainCombiner();
            }
        });
        if (domainCombiner == null || !(domainCombiner instanceof SubjectDomainCombiner)) {
            return null;
        }
        return ((SubjectDomainCombiner) domainCombiner).getSubject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.publicCredentials = new SecureSet<>(_PUBLIC_CREDENTIALS);
        this.privateCredentials = new SecureSet<>(_PRIVATE_CREDENTIALS);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Subject subject = (Subject) obj;
        return this.principals.equals(subject.principals) && this.publicCredentials.equals(subject.publicCredentials) && this.privateCredentials.equals(subject.privateCredentials);
    }

    public Set<Principal> getPrincipals() {
        return this.principals;
    }

    public <T extends Principal> Set<T> getPrincipals(Class<T> cls) {
        return ((SecureSet) this.principals).get(cls);
    }

    public Set<Object> getPrivateCredentials() {
        return this.privateCredentials;
    }

    public <T> Set<T> getPrivateCredentials(Class<T> cls) {
        return (Set<T>) this.privateCredentials.get(cls);
    }

    public Set<Object> getPublicCredentials() {
        return this.publicCredentials;
    }

    public <T> Set<T> getPublicCredentials(Class<T> cls) {
        return (Set<T>) this.publicCredentials.get(cls);
    }

    public int hashCode() {
        return this.principals.hashCode() + this.privateCredentials.hashCode() + this.publicCredentials.hashCode();
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly() {
        this.readOnly = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Subject:\n");
        for (Principal principal : this.principals) {
            sb.append("\tPrincipal: ");
            sb.append(principal);
            sb.append('\n');
        }
        Iterator<Object> it = this.publicCredentials.iterator();
        while (it.hasNext()) {
            sb.append("\tPublic Credential: ");
            sb.append(it.next());
            sb.append('\n');
        }
        int length = sb.length();
        Iterator<Object> it2 = this.privateCredentials.iterator();
        while (it2.hasNext()) {
            try {
                sb.append("\tPrivate Credential: ");
                sb.append(it2.next());
                sb.append('\n');
            } catch (SecurityException e) {
                sb.delete(length - 1, sb.length());
                sb.append("\tPrivate Credentials: no accessible information\n");
            }
        }
        return sb.toString();
    }
}

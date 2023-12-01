package java.security;

/* loaded from: source-2895416-dex2jar.jar:java/security/Principal.class */
public interface Principal {
    boolean equals(Object obj);

    String getName();

    int hashCode();

    String toString();
}

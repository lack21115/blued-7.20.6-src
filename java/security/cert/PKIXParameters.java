package java.security.cert;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.codec.language.bm.Languages;

/* loaded from: source-2895416-dex2jar.jar:java/security/cert/PKIXParameters.class */
public class PKIXParameters implements CertPathParameters {
    private List<PKIXCertPathChecker> certPathCheckers;
    private List<CertStore> certStores;
    private Date date;
    private Set<String> initialPolicies;
    private String sigProvider;
    private CertSelector targetCertConstraints;
    private Set<TrustAnchor> trustAnchors;
    private boolean revocationEnabled = true;
    private boolean explicitPolicyRequired = false;
    private boolean policyMappingInhibited = false;
    private boolean anyPolicyInhibited = false;
    private boolean policyQualifiersRejected = true;

    public PKIXParameters(KeyStore keyStore) throws KeyStoreException, InvalidAlgorithmParameterException {
        if (keyStore == null) {
            throw new NullPointerException("keyStore == null");
        }
        if (keyStore.size() == 0) {
            throw new InvalidAlgorithmParameterException("keyStore.size() == 0");
        }
        this.trustAnchors = new HashSet();
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            if (keyStore.isCertificateEntry(nextElement)) {
                Certificate certificate = keyStore.getCertificate(nextElement);
                if (certificate instanceof X509Certificate) {
                    this.trustAnchors.add(new TrustAnchor((X509Certificate) certificate, null));
                }
            }
        }
        checkTrustAnchors(this.trustAnchors);
    }

    public PKIXParameters(Set<TrustAnchor> set) throws InvalidAlgorithmParameterException {
        if (set == null) {
            throw new NullPointerException("trustAnchors == null");
        }
        checkTrustAnchors(set);
        this.trustAnchors = new HashSet(set);
    }

    private void checkTrustAnchors(Set<TrustAnchor> set) throws InvalidAlgorithmParameterException {
        if (set.isEmpty()) {
            throw new InvalidAlgorithmParameterException("trustAnchors.isEmpty()");
        }
    }

    public void addCertPathChecker(PKIXCertPathChecker pKIXCertPathChecker) {
        if (pKIXCertPathChecker == null) {
            return;
        }
        if (this.certPathCheckers == null) {
            this.certPathCheckers = new ArrayList();
        }
        this.certPathCheckers.add((PKIXCertPathChecker) pKIXCertPathChecker.clone());
    }

    public void addCertStore(CertStore certStore) {
        if (certStore == null) {
            return;
        }
        if (this.certStores == null) {
            this.certStores = new ArrayList();
        }
        this.certStores.add(certStore);
    }

    @Override // java.security.cert.CertPathParameters
    public Object clone() {
        try {
            PKIXParameters pKIXParameters = (PKIXParameters) super.clone();
            if (this.certStores != null) {
                pKIXParameters.certStores = new ArrayList(this.certStores);
            }
            if (this.certPathCheckers != null) {
                pKIXParameters.certPathCheckers = new ArrayList(this.certPathCheckers);
            }
            return pKIXParameters;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public List<PKIXCertPathChecker> getCertPathCheckers() {
        if (this.certPathCheckers == null) {
            this.certPathCheckers = new ArrayList();
        }
        if (this.certPathCheckers.isEmpty()) {
            return Collections.unmodifiableList(this.certPathCheckers);
        }
        ArrayList arrayList = new ArrayList();
        for (PKIXCertPathChecker pKIXCertPathChecker : this.certPathCheckers) {
            arrayList.add((PKIXCertPathChecker) pKIXCertPathChecker.clone());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<CertStore> getCertStores() {
        if (this.certStores == null) {
            this.certStores = new ArrayList();
        }
        return this.certStores.isEmpty() ? Collections.unmodifiableList(this.certStores) : Collections.unmodifiableList(new ArrayList(this.certStores));
    }

    public Date getDate() {
        if (this.date == null) {
            return null;
        }
        return (Date) this.date.clone();
    }

    public Set<String> getInitialPolicies() {
        if (this.initialPolicies == null) {
            this.initialPolicies = new HashSet();
        }
        return this.initialPolicies.isEmpty() ? Collections.unmodifiableSet(this.initialPolicies) : Collections.unmodifiableSet(new HashSet(this.initialPolicies));
    }

    public boolean getPolicyQualifiersRejected() {
        return this.policyQualifiersRejected;
    }

    public String getSigProvider() {
        return this.sigProvider;
    }

    public CertSelector getTargetCertConstraints() {
        if (this.targetCertConstraints == null) {
            return null;
        }
        return (CertSelector) this.targetCertConstraints.clone();
    }

    public Set<TrustAnchor> getTrustAnchors() {
        return Collections.unmodifiableSet(this.trustAnchors);
    }

    public boolean isAnyPolicyInhibited() {
        return this.anyPolicyInhibited;
    }

    public boolean isExplicitPolicyRequired() {
        return this.explicitPolicyRequired;
    }

    public boolean isPolicyMappingInhibited() {
        return this.policyMappingInhibited;
    }

    public boolean isRevocationEnabled() {
        return this.revocationEnabled;
    }

    public void setAnyPolicyInhibited(boolean z) {
        this.anyPolicyInhibited = z;
    }

    public void setCertPathCheckers(List<PKIXCertPathChecker> list) {
        if (list == null || list.isEmpty()) {
            if (this.certPathCheckers == null || this.certPathCheckers.isEmpty()) {
                return;
            }
            this.certPathCheckers = null;
            return;
        }
        this.certPathCheckers = new ArrayList();
        for (PKIXCertPathChecker pKIXCertPathChecker : list) {
            this.certPathCheckers.add((PKIXCertPathChecker) pKIXCertPathChecker.clone());
        }
    }

    public void setCertStores(List<CertStore> list) {
        if (list != null && !list.isEmpty()) {
            this.certStores = new ArrayList(list);
        } else if (this.certStores == null || this.certStores.isEmpty()) {
        } else {
            this.certStores = null;
        }
    }

    public void setDate(Date date) {
        this.date = date == null ? null : new Date(date.getTime());
    }

    public void setExplicitPolicyRequired(boolean z) {
        this.explicitPolicyRequired = z;
    }

    public void setInitialPolicies(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            this.initialPolicies = new HashSet(set);
        } else if (this.initialPolicies == null || this.initialPolicies.isEmpty()) {
        } else {
            this.initialPolicies = null;
        }
    }

    public void setPolicyMappingInhibited(boolean z) {
        this.policyMappingInhibited = z;
    }

    public void setPolicyQualifiersRejected(boolean z) {
        this.policyQualifiersRejected = z;
    }

    public void setRevocationEnabled(boolean z) {
        this.revocationEnabled = z;
    }

    public void setSigProvider(String str) {
        this.sigProvider = str;
    }

    public void setTargetCertConstraints(CertSelector certSelector) {
        this.targetCertConstraints = certSelector == null ? null : (CertSelector) certSelector.clone();
    }

    public void setTrustAnchors(Set<TrustAnchor> set) throws InvalidAlgorithmParameterException {
        if (set == null) {
            throw new NullPointerException("trustAnchors == null");
        }
        checkTrustAnchors(set);
        this.trustAnchors = new HashSet(set);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[\n Trust Anchors: ");
        sb.append(this.trustAnchors);
        sb.append("\n Revocation Enabled: ");
        sb.append(this.revocationEnabled);
        sb.append("\n Explicit Policy Required: ");
        sb.append(this.explicitPolicyRequired);
        sb.append("\n Policy Mapping Inhibited: ");
        sb.append(this.policyMappingInhibited);
        sb.append("\n Any Policy Inhibited: ");
        sb.append(this.anyPolicyInhibited);
        sb.append("\n Policy Qualifiers Rejected: ");
        sb.append(this.policyQualifiersRejected);
        sb.append("\n Initial Policy OIDs: ");
        sb.append((this.initialPolicies == null || this.initialPolicies.isEmpty()) ? Languages.ANY : this.initialPolicies.toString());
        sb.append("\n Cert Stores: ");
        sb.append((this.certStores == null || this.certStores.isEmpty()) ? "no" : this.certStores.toString());
        sb.append("\n Validity Date: ");
        sb.append(this.date);
        sb.append("\n Cert Path Checkers: ");
        sb.append((this.certPathCheckers == null || this.certPathCheckers.isEmpty()) ? "no" : this.certPathCheckers.toString());
        sb.append("\n Signature Provider: ");
        sb.append(this.sigProvider);
        sb.append("\n Target Certificate Constraints: ");
        sb.append(this.targetCertConstraints);
        sb.append("\n]");
        return sb.toString();
    }
}

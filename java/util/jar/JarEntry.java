package java.util.jar;

import java.io.IOException;
import java.security.CodeSigner;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/JarEntry.class */
public class JarEntry extends ZipEntry {
    private Attributes attributes;
    private CertificateFactory factory;
    private boolean isFactoryChecked;
    final JarFile parentJar;
    CodeSigner[] signers;

    public JarEntry(String str) {
        super(str);
        this.isFactoryChecked = false;
        this.parentJar = null;
    }

    public JarEntry(JarEntry jarEntry) {
        super(jarEntry);
        this.isFactoryChecked = false;
        this.parentJar = jarEntry.parentJar;
        this.attributes = jarEntry.attributes;
        this.signers = jarEntry.signers;
    }

    public JarEntry(ZipEntry zipEntry) {
        this(zipEntry, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JarEntry(ZipEntry zipEntry, JarFile jarFile) {
        super(zipEntry);
        this.isFactoryChecked = false;
        this.parentJar = jarFile;
    }

    private void addCodeSigner(ArrayList<CodeSigner> arrayList, Certificate[] certificateArr) {
        CertPath certPath;
        int length = certificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (!this.isFactoryChecked) {
                    try {
                        this.factory = CertificateFactory.getInstance("X.509");
                    } catch (CertificateException e) {
                    } finally {
                        this.isFactoryChecked = true;
                    }
                }
                if (this.factory != null) {
                    try {
                        certPath = this.factory.generateCertPath(Arrays.asList(certificateArr));
                    } catch (CertificateException e2) {
                        certPath = null;
                    }
                    if (certPath != null) {
                        arrayList.add(new CodeSigner(certPath, null));
                        return;
                    }
                    return;
                }
                return;
            } else if (!(certificateArr[i2] instanceof X509Certificate)) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    private CodeSigner[] getCodeSigners(Certificate[][] certificateArr) {
        if (certificateArr == null) {
            return null;
        }
        ArrayList<CodeSigner> arrayList = new ArrayList<>(certificateArr.length);
        int length = certificateArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                CodeSigner[] codeSignerArr = new CodeSigner[arrayList.size()];
                arrayList.toArray(codeSignerArr);
                return codeSignerArr;
            }
            addCodeSigner(arrayList, certificateArr[i2]);
            i = i2 + 1;
        }
    }

    public Attributes getAttributes() throws IOException {
        if (this.attributes != null || this.parentJar == null) {
            return this.attributes;
        }
        Manifest manifest = this.parentJar.getManifest();
        if (manifest == null) {
            return null;
        }
        Attributes attributes = manifest.getAttributes(getName());
        this.attributes = attributes;
        return attributes;
    }

    public Certificate[] getCertificates() {
        Certificate[] certificateArr;
        if (this.parentJar == null) {
            certificateArr = null;
        } else {
            JarVerifier jarVerifier = this.parentJar.verifier;
            certificateArr = null;
            if (jarVerifier != null) {
                Certificate[][] certificateChains = jarVerifier.getCertificateChains(getName());
                certificateArr = null;
                if (certificateChains != null) {
                    int i = 0;
                    int length = certificateChains.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        i += certificateChains[i3].length;
                        i2 = i3 + 1;
                    }
                    Certificate[] certificateArr2 = new Certificate[i];
                    int i4 = 0;
                    int length2 = certificateChains.length;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        certificateArr = certificateArr2;
                        if (i6 >= length2) {
                            break;
                        }
                        Certificate[] certificateArr3 = certificateChains[i6];
                        System.arraycopy(certificateArr3, 0, certificateArr2, i4, certificateArr3.length);
                        i4 += certificateArr3.length;
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return certificateArr;
    }

    public CodeSigner[] getCodeSigners() {
        JarVerifier jarVerifier;
        if (this.parentJar == null || (jarVerifier = this.parentJar.verifier) == null) {
            return null;
        }
        if (this.signers == null) {
            this.signers = getCodeSigners(jarVerifier.getCertificateChains(getName()));
        }
        if (this.signers != null) {
            return (CodeSigner[]) this.signers.clone();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}

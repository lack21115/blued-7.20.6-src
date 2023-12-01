package javax.xml.transform;

import java.util.Properties;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/Templates.class */
public interface Templates {
    Properties getOutputProperties();

    Transformer newTransformer() throws TransformerConfigurationException;
}

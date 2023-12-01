package libcore.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/GenericSignatureParser.class */
public final class GenericSignatureParser {
    char[] buffer;
    private boolean eof;
    public ListOfTypes exceptionTypes;
    public Type fieldType;
    public TypeVariable[] formalTypeParameters;
    GenericDeclaration genericDecl;
    String identifier;
    public ListOfTypes interfaceTypes;
    public ClassLoader loader;
    public ListOfTypes parameterTypes;
    int pos;
    public Type returnType;
    public Type superclassType;
    char symbol;

    public GenericSignatureParser(ClassLoader classLoader) {
        this.loader = classLoader;
    }

    static boolean isStopSymbol(char c) {
        switch (c) {
            case '.':
            case '/':
            case ':':
            case ';':
            case '<':
                return true;
            default:
                return false;
        }
    }

    void expect(char c) {
        if (this.symbol != c) {
            throw new GenericSignatureFormatError();
        }
        scanSymbol();
    }

    void parseClassSignature() {
        parseOptFormalTypeParameters();
        this.superclassType = parseClassTypeSignature();
        this.interfaceTypes = new ListOfTypes(16);
        while (this.symbol > 0) {
            this.interfaceTypes.add(parseClassTypeSignature());
        }
    }

    Type parseClassTypeSignature() {
        expect('L');
        StringBuilder sb = new StringBuilder();
        scanIdentifier();
        while (this.symbol == '/') {
            scanSymbol();
            sb.append(this.identifier).append(".");
            scanIdentifier();
        }
        sb.append(this.identifier);
        ParameterizedTypeImpl parameterizedTypeImpl = new ParameterizedTypeImpl(null, sb.toString(), parseOptTypeArguments(), this.loader);
        ParameterizedTypeImpl parameterizedTypeImpl2 = parameterizedTypeImpl;
        while (true) {
            ParameterizedTypeImpl parameterizedTypeImpl3 = parameterizedTypeImpl2;
            if (this.symbol != '.') {
                expect(';');
                return parameterizedTypeImpl3;
            }
            scanSymbol();
            scanIdentifier();
            sb.append("$").append(this.identifier);
            parameterizedTypeImpl2 = new ParameterizedTypeImpl(parameterizedTypeImpl, sb.toString(), parseOptTypeArguments(), this.loader);
        }
    }

    Type parseFieldTypeSignature() {
        switch (this.symbol) {
            case 'L':
                return parseClassTypeSignature();
            case 'T':
                return parseTypeVariableSignature();
            case '[':
                scanSymbol();
                return new GenericArrayTypeImpl(parseTypeSignature());
            default:
                throw new GenericSignatureFormatError();
        }
    }

    public void parseForClass(GenericDeclaration genericDeclaration, String str) {
        setInput(genericDeclaration, str);
        if (!this.eof) {
            parseClassSignature();
        } else if (!(genericDeclaration instanceof Class)) {
            this.formalTypeParameters = EmptyArray.TYPE_VARIABLE;
            this.superclassType = Object.class;
            this.interfaceTypes = ListOfTypes.EMPTY;
        } else {
            Class cls = (Class) genericDeclaration;
            this.formalTypeParameters = EmptyArray.TYPE_VARIABLE;
            this.superclassType = cls.getSuperclass();
            Class<?>[] interfaces = cls.getInterfaces();
            if (interfaces.length == 0) {
                this.interfaceTypes = ListOfTypes.EMPTY;
            } else {
                this.interfaceTypes = new ListOfTypes(interfaces);
            }
        }
    }

    public void parseForConstructor(GenericDeclaration genericDeclaration, String str, Class<?>[] clsArr) {
        setInput(genericDeclaration, str);
        if (!this.eof) {
            parseMethodTypeSignature(clsArr);
            return;
        }
        Constructor constructor = (Constructor) genericDeclaration;
        this.formalTypeParameters = EmptyArray.TYPE_VARIABLE;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes.length == 0) {
            this.parameterTypes = ListOfTypes.EMPTY;
        } else {
            this.parameterTypes = new ListOfTypes(parameterTypes);
        }
        Class<?>[] exceptionTypes = constructor.getExceptionTypes();
        if (exceptionTypes.length == 0) {
            this.exceptionTypes = ListOfTypes.EMPTY;
        } else {
            this.exceptionTypes = new ListOfTypes(exceptionTypes);
        }
    }

    public void parseForField(GenericDeclaration genericDeclaration, String str) {
        setInput(genericDeclaration, str);
        if (this.eof) {
            return;
        }
        this.fieldType = parseFieldTypeSignature();
    }

    public void parseForMethod(GenericDeclaration genericDeclaration, String str, Class<?>[] clsArr) {
        setInput(genericDeclaration, str);
        if (!this.eof) {
            parseMethodTypeSignature(clsArr);
            return;
        }
        Method method = (Method) genericDeclaration;
        this.formalTypeParameters = EmptyArray.TYPE_VARIABLE;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) {
            this.parameterTypes = ListOfTypes.EMPTY;
        } else {
            this.parameterTypes = new ListOfTypes(parameterTypes);
        }
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        if (exceptionTypes.length == 0) {
            this.exceptionTypes = ListOfTypes.EMPTY;
        } else {
            this.exceptionTypes = new ListOfTypes(exceptionTypes);
        }
        this.returnType = method.getReturnType();
    }

    TypeVariableImpl<GenericDeclaration> parseFormalTypeParameter() {
        scanIdentifier();
        String intern = this.identifier.intern();
        ListOfTypes listOfTypes = new ListOfTypes(8);
        expect(':');
        if (this.symbol == 'L' || this.symbol == '[' || this.symbol == 'T') {
            listOfTypes.add(parseFieldTypeSignature());
        }
        while (this.symbol == ':') {
            scanSymbol();
            listOfTypes.add(parseFieldTypeSignature());
        }
        return new TypeVariableImpl<>(this.genericDecl, intern, listOfTypes);
    }

    void parseMethodTypeSignature(Class<?>[] clsArr) {
        parseOptFormalTypeParameters();
        this.parameterTypes = new ListOfTypes(16);
        expect('(');
        while (this.symbol != ')' && this.symbol > 0) {
            this.parameterTypes.add(parseTypeSignature());
        }
        expect(')');
        this.returnType = parseReturnType();
        if (this.symbol != '^') {
            if (clsArr != null) {
                this.exceptionTypes = new ListOfTypes(clsArr);
                return;
            } else {
                this.exceptionTypes = new ListOfTypes(0);
                return;
            }
        }
        this.exceptionTypes = new ListOfTypes(8);
        do {
            scanSymbol();
            if (this.symbol == 'T') {
                this.exceptionTypes.add(parseTypeVariableSignature());
            } else {
                this.exceptionTypes.add(parseClassTypeSignature());
            }
        } while (this.symbol == '^');
    }

    void parseOptFormalTypeParameters() {
        ListOfVariables listOfVariables = new ListOfVariables();
        if (this.symbol == '<') {
            scanSymbol();
            listOfVariables.add(parseFormalTypeParameter());
            while (this.symbol != '>' && this.symbol > 0) {
                listOfVariables.add(parseFormalTypeParameter());
            }
            expect('>');
        }
        this.formalTypeParameters = listOfVariables.getArray();
    }

    ListOfTypes parseOptTypeArguments() {
        ListOfTypes listOfTypes = new ListOfTypes(8);
        if (this.symbol == '<') {
            scanSymbol();
            listOfTypes.add(parseTypeArgument());
            while (this.symbol != '>' && this.symbol > 0) {
                listOfTypes.add(parseTypeArgument());
            }
            expect('>');
        }
        return listOfTypes;
    }

    Type parseReturnType() {
        if (this.symbol != 'V') {
            return parseTypeSignature();
        }
        scanSymbol();
        return Void.TYPE;
    }

    Type parseTypeArgument() {
        ListOfTypes listOfTypes = new ListOfTypes(1);
        ListOfTypes listOfTypes2 = new ListOfTypes(1);
        if (this.symbol == '*') {
            scanSymbol();
            listOfTypes.add(Object.class);
            return new WildcardTypeImpl(listOfTypes, listOfTypes2);
        } else if (this.symbol == '+') {
            scanSymbol();
            listOfTypes.add(parseFieldTypeSignature());
            return new WildcardTypeImpl(listOfTypes, listOfTypes2);
        } else if (this.symbol == '-') {
            scanSymbol();
            listOfTypes2.add(parseFieldTypeSignature());
            listOfTypes.add(Object.class);
            return new WildcardTypeImpl(listOfTypes, listOfTypes2);
        } else {
            return parseFieldTypeSignature();
        }
    }

    Type parseTypeSignature() {
        switch (this.symbol) {
            case 'B':
                scanSymbol();
                return Byte.TYPE;
            case 'C':
                scanSymbol();
                return Character.TYPE;
            case 'D':
                scanSymbol();
                return Double.TYPE;
            case 'F':
                scanSymbol();
                return Float.TYPE;
            case 'I':
                scanSymbol();
                return Integer.TYPE;
            case 'J':
                scanSymbol();
                return Long.TYPE;
            case 'S':
                scanSymbol();
                return Short.TYPE;
            case 'Z':
                scanSymbol();
                return Boolean.TYPE;
            default:
                return parseFieldTypeSignature();
        }
    }

    TypeVariableImpl<GenericDeclaration> parseTypeVariableSignature() {
        expect('T');
        scanIdentifier();
        expect(';');
        return new TypeVariableImpl<>(this.genericDecl, this.identifier);
    }

    void scanIdentifier() {
        if (this.eof) {
            throw new GenericSignatureFormatError();
        }
        StringBuilder sb = new StringBuilder(32);
        if (isStopSymbol(this.symbol)) {
            this.symbol = (char) 0;
            this.eof = true;
            throw new GenericSignatureFormatError();
        }
        sb.append(this.symbol);
        do {
            char c = this.buffer[this.pos];
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && isStopSymbol(c))) {
                this.identifier = sb.toString();
                scanSymbol();
                return;
            }
            sb.append(c);
            this.pos++;
        } while (this.pos != this.buffer.length);
        this.identifier = sb.toString();
        this.symbol = (char) 0;
        this.eof = true;
    }

    void scanSymbol() {
        if (this.eof) {
            throw new GenericSignatureFormatError();
        }
        if (this.pos < this.buffer.length) {
            this.symbol = this.buffer[this.pos];
            this.pos++;
            return;
        }
        this.symbol = (char) 0;
        this.eof = true;
    }

    void setInput(GenericDeclaration genericDeclaration, String str) {
        if (str == null) {
            this.eof = true;
            return;
        }
        this.genericDecl = genericDeclaration;
        this.buffer = str.toCharArray();
        this.eof = false;
        scanSymbol();
    }
}

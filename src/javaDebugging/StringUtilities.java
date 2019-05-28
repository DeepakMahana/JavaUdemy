package javaDebugging;

public class StringUtilities {

    private StringBuilder sb = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sb, char c) {
        sb.append(c);
        charsAdded++;
    }

    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix__" + upper;
    }

    public String addSuffix(String str) {
        return str + "__Suffix";
    }
}

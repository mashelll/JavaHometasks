package hometask6.format;

import java.util.List;
import java.util.Map;

public abstract class Format {
    protected final int indent;
    protected int currentIndent = 0;

    public Format(int indent) {
        this.indent = indent;
    }

    protected String getIndent() {
        return new String(new char[indent * currentIndent]).replace("\0", " ");
    }

    public final String writeMap(Map<String, String> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(onMapStart());
        currentIndent++;
        processMapContents(map, builder);
        currentIndent--;
        builder.append(onMapFinish());
        return builder.toString();
    }

    public final String writeCollection(List<String> list) {
        StringBuilder builder = new StringBuilder();
        builder.append(onCollectionStart());
        currentIndent++;
        processCollectionContents(list, builder);
        currentIndent--;
        builder.append(onCollectionFinish());
        return builder.toString();
    }

    protected abstract String onMapStart();

    protected abstract void processMapContents(Map<String, String> map, StringBuilder builder);

    protected abstract String onMapFinish();

    protected abstract String onCollectionStart();

    protected abstract void processCollectionContents(List<String> list, StringBuilder builder);

    protected abstract String onCollectionFinish();

    protected abstract String writeNull();

    protected abstract String writeNumberOrBool(Object o);

    protected abstract String writeAsString(Object o);
}

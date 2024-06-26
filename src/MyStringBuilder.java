public class MyStringBuilder {

    private char[] value;
    private int count;
    private char[] savedValue;
    private int savedCount;

    public MyStringBuilder() {
        value = new char[16];
        count = 0;
    }

    public MyStringBuilder append(String str) {
        if (str == null) str = "null";
        int len = str.length();
        ensureCapacity(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

    public MyStringBuilder hitSave() {
        savedValue = value;
        savedCount = count;
        return this;
    }

    public MyStringBuilder hitUndo() {
        value = savedValue;
        count = savedCount;
        return this;
    }

    private void ensureCapacity(int capacity) {
        if (capacity - value.length > 0) {
            int newCapacity = value.length * 2 + 2;
            if (newCapacity - capacity < 0) {
                newCapacity = capacity;
            }
            if (newCapacity < 0) {
                if (capacity < 0) // overflow
                    throw new OutOfMemoryError();
                newCapacity = Integer.MAX_VALUE;
            }
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
        }
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}

import java.util.TreeMap;

public class MyStringBuilder {

    private final TreeMap<Long, MyStringBuilder> snapshots = new TreeMap<>();
    private Long availableSnapshots = 0L;
    private Long stepsTaken = 0L;
    private boolean snapshotWasActivated;
    private char[] value;
    private int count;

    public MyStringBuilder() {
        value = new char[16];
        count = 0;
    }

    public MyStringBuilder(char[] value, int count) {
        this.value = value;
        this.count = count;
    }

    public MyStringBuilder append(String str) {

        if(snapshotWasActivated) {
            snapshots.tailMap(availableSnapshots+stepsTaken+1).clear();
            snapshotWasActivated = false;
            availableSnapshots = (long) snapshots.size();
            stepsTaken = 0L;
        }

        if (str == null) str = "null";
        int len = str.length();
        ensureCapacity(count + len);
        str.getChars(0, len, value, count);
        count += len;
        availableSnapshots++;
        snapshots.put(availableSnapshots, new MyStringBuilder(value, count));
        return this;
    }

    public MyStringBuilder navigateSnapshotsSteps(Long steps) {

        snapshotWasActivated = true;
        Long totalAmountOfSnapshots = (long) snapshots.keySet().size(); //Всего шагов сохранено для отката

        stepsTaken = stepsTaken + steps;
        Long currentSnapshot = totalAmountOfSnapshots + stepsTaken;   // Вычисляем номер шага для перехода

        MyStringBuilder snapshotFound = snapshots.get(currentSnapshot);
        value = snapshotFound.value;
        count = snapshotFound.count;
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

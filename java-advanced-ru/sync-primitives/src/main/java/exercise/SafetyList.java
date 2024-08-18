package exercise;

class SafetyList {
    // BEGIN
    private int[] elementData;
    private int size = 0;


    public SafetyList(int newCapacity) {
        if (newCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity " + newCapacity);
        }
        elementData = new int[newCapacity];
    }

    public SafetyList() {
        this(10);
    }

    private void resize() {
        int newSize = elementData.length == 0 ? 10 : (elementData.length * 3) / 2 + 1;
        int[] oldData = elementData;
        elementData = new int[newSize];
        System.arraycopy(oldData, 0, elementData, 0, size);

    }

    public synchronized void add (int element) {
        if (size + 1 == elementData.length) {
            this.resize();
        }
        elementData[size++] = element;
    }

    public int getSize() {
        return this.size;
    }

    public int get(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds index " + elementData.length);
        }
        return elementData[index];
    }

    // END
}

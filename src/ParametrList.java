class ParametrList<E> {

    private int size = 0;
    private Object[] data;
    private int shag = 100;

    private void testASize() {
        if (size == 0) data = new Object[shag];
        if (size == data.length) {
            Object newdata[] = new Object[size * 2];
            for (int i = 0; i < size; i++) newdata[i] = data[i];
            data = newdata;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) s.append(data[i]).append(" ");
        return s.toString();
    }

    public void add(E element) {
        testASize();
        data[size] = element;
        size++;
    }

    public void set(int index, E element) {
        data[index] = element;
    }

    public void insert(int index, E element) {
        testASize();
        if (index < size) {
            Object sw[] = new Object[size - index];
            for (int i = 0, j = index; i < sw.length; i++, j++) sw[i] = data[j];
            data[index] = element;
            size++;
            for (int i = index + 1, j = 0; i < size; i++, j++) data[i] = sw[j];
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (size == 0) return null;//проверка на дурака
        return (E) data[index];
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) data[i] = data[i + 1];
        size--;
    }

    public int find(E element) {
        //for (int i = 0; i < size; i++) if(data[i].equals(element)) return i;
        for (int i = 0; i < size; i++) if (data[i] == element) return i;
        return -1;
    }
}
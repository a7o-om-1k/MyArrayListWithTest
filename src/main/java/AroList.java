public class AroList<T> implements MyArrayList
{
    private static final int DEFAULT_SIZE = 10;
    private T[] student;
    private int size;

    public AroList() {
        this.student = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public boolean add(Object t) {
        try {
            // если массив уже заполнен
            if (isFullArray()) {
                resize();
            }
            this.student[size] = (T) t;
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Увеличивает размер массива до величины index (В случае успешного добавления выводит true иначе false)
    @Override
    public boolean add(int index) {
        try {
            // если размер больше index то не увеличиваем
            if (size > index) return false;
            else
                this.size = index;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // Метод меняет размер массива

    private void resize() {
        // запоминаем старый массив
        T[] oldElements = this.student;
        // создаем новый массив, который в полтора раза больше предыдущего
        this.student = (T[]) new Object[oldElements.length + oldElements.length / 2];
        // копируем все элементы из старого массива в новый
        for (int i = 0; i < size; i++) {
            this.student[i] = oldElements[i];
        }
    }

    // Метод проверяет массив на заполненность
    private boolean isFullArray() {
        return size == student.length;
    }


    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return student[index];
        }
        return null;
    }

    /**
     * Метод получает обьект из массива
     *
     * @Return
     */
    @Override
    public T get(Object o)
    {
        for (T t : student )
        {
            if (t.equals(o))
                return t;
        }
        return null;
    }


    // Метод заменяет обьект в массиве по индексу

    @Override
    public void set(int index, Object o) {
        if (index >= 0 && index < size) {
            student[index] = (T) o;
        } else System.out.println("Нет такого элемента, который вы хотели заменить");
    }

    // Метод удаляет обьект из массива по индексу
    @Override
    public void remove(int index) {
        rangeCheck(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(student, index + 1, student, index, numMoved);
        }
        student[--size] = null;

    }

    // Метод проверяет выход за размеры массива
    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (((T) get(i)).equals((T) o)) {
                remove(i);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < student.length; i++)
        {
            student[i] = null;
        }
        size = 0;
    }
}

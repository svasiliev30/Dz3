package sbp.CustomArrayImpl;

import java.util.Collection;

public class CustomArrayImpl <T> implements CustomArray <T>{

    /**
     * с Принимает джинерик
     */
    private Collection <T> c;
    private int size;
    T[] data ;
    private  int capacity;

    /**
     * Размер массивов customArray
     */

    public CustomArrayImpl(){
        data  = (T[]) new Object[]{};
             this.size = 0;
    }

    /**
     * принимаем значение типа инт и если что-то не так то подбрасываем его
     * @param capacity
     * @throws IllegalArgumentException
     */
    public  CustomArrayImpl(int capacity) {

        if ( capacity < 0) {
            throw new IllegalArgumentException("Размер массива не может быть отрицательным." + capacity);
        }else {
            this.capacity = capacity;
            data = (T[]) new Object[capacity];
        }
    }

    /**
     * Принимаем значение
     * @param c
     */
    public CustomArrayImpl(Collection<T> c ){
        data = (T[]) c.toArray();
        size = data.length;
        capacity = data.length;
    }

    /**
     * возвращаем длинну массиа
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * возвращаем тру если 0 елементов
     *  возвращаем false если элемнтов больше 0
     * @return
     */
    @Override
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * добавляем элемент к массиву
     * @param item
     * @return
     */
    @Override
    public boolean add(T item) {
        T[] dataTime ;
        int plus = 15;

        if (size >= capacity) {
            int result = data.length + capacity + plus;
            dataTime = (T[]) new Object[result];

            for (int i = 0; i < data.length; i++) {
                dataTime[i] = data[i];
            }
            data = dataTime;
            capacity = result;

        }
        data[size] = item;
        size += 1;
        return true;
    }

    /**
     * Добавляем все элементы к массиву
     * @param items
     * @return
     */
        @Override
    public boolean addAll(T[] items) {
            T[] dataTime ;
            int plus = 15;

       for(int i = 0; i < items.length; i++) {
           if (items[i] == null) {
               throw new IllegalArgumentException("не должно быть значение равно null" + items[i]);
           }
       }

       if(items.length > 0){
           if (items.length + size > capacity){
               while (items.length + size > capacity){
                   int result = items.length + capacity + plus;
                   dataTime = (T[]) new Object[result];
                   for (int i = 0; i < data.length; i++) {
                       dataTime[i] = data[i];
                   }
                   data = dataTime;
                   capacity = result;
               }
           }
           for (int i = 0; i < items.length; i++) {
               data[size] = items [i];
               size++;
           }
           return true;
       }
       return false;
       }

    /**
     * Сложение коллекций
     * @param items
     * @return
     */
    @Override
    public boolean addAll(Collection<T> items) throws IllegalArgumentException {
        T[] dataTime ;
        T[] dataFor = (T[]) items.toArray();
        int plus = 15;

        for(int i = 0; i < dataFor.length; i++) {
            if (dataFor[i] == null) {
                throw new IllegalArgumentException("не должно быть значение равно null " + dataFor[i]);
            }
        }

        if (dataFor.length > 0){
            if (dataFor.length + size > capacity){
                while (dataFor.length + size > capacity){
                    int result = dataFor.length + capacity + plus;
                    dataTime = (T[]) new Object[result];
                    for (int i = 0; i < data.length  ; i++) {
                        dataTime[i] = data[i];
                    }
                    data = dataTime;
                    capacity = result;
                }
            }
            for (int i = 0; i < dataFor.length; i++) {
                data[size] = dataFor[i];
                size++;
            }
            return true;
        }
        return false;
    }

    /**
     * Добавление массива с указанного индеса
     * @param index - index
     * @param items - items for insert
     * @return
     */
    @Override
    public boolean addAll(int index, T[] items) {
        T[] dataTime ;
        int plus = 15;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                throw new IllegalArgumentException("не должно быть значение равно null " + items[i]);
            }

            if (capacity < index) {
                System.out.println();
                throw new IllegalArgumentException("Индекс " + index + " больше емкости массива " + capacity);
            }

            if (items.length > 0) {
                if (items.length + size > capacity) {
                    while (items.length + size > capacity) {
                        capacity += plus;
                        dataTime =(T[]) new Object[capacity];

                        for (int z = 0; i < data.length; z++) {
                            dataTime[z] = data[z];
                        }
                        data = dataTime;
                    }
                }
            }
            System.arraycopy(data, index, items, 0, items.length);
            size += items.length;
            return true;
        }
        return false;
    }

    /**
     * Вызов элемента по индексу
     * @param index - index
     * @return
     */
    @Override
    public T get(int index) {
        if (capacity  < index) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " больше емкости массива " + capacity);
        }
        return (T) data[index];
    }

    /**
     * устанавливает элемент по индексу и возвращает старое значение
     * @param index - index
     * @param item
     * @return
     */
    @Override
    public T set(int index, T item) {
        T[] dataTime = (T[]) new Object[capacity];
        if (capacity  < index) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " больше емкости массива " + capacity);
        }
        dataTime[index] =  data[index];
        data[index] = (T) item;
        return (T) dataTime[index];
    }

    /**
     * Удаляет элемент по индексу
     * @param index - index
     */
    @Override
    public void remove(int index) {
        if (capacity < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = null;
    }

    /**
     * удаляет элемент по указанному элементу
     * @param item - item
     * @return
     */
    @Override
    public boolean remove(T item) {
        int index = -1;
        for (int i = 0; i <capacity; i++) {
            if (data[i] == item) {
                index = i;
                break;
            }
        }

        if (index == -1){
            return false;
        }

        data[index] = null;
        if (data[index] == null) {
            return true;
        }
        return false;
    }

    /**
     * Возвращает тру если есть присылаемое значение
     * @param item - item
     * @return
     */
    @Override
    public boolean contains(T item) {
        int index = 0;
        for (int i = 0; i <capacity; i++) {
            if (data[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает первый совпадающий индекс
     * @param item - item
     * @return
     */
    @Override
    public int indexOf(T item) {
        int index = 0;
        for (int i = 0; i <capacity; i++) {
            if (data[i] == item) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    /**
     *Увеличивает емкость массива если места не хватает
     * @param newElementsCount - new elements count
     * @return
     */
    @Override
    public int ensureCapacity(int newElementsCount) {
        T[] dataTime ;
        int plus = 15;
        if (newElementsCount < data.length ) {
            int result = data.length + newElementsCount + plus;
            dataTime = (T[]) new Object[result];

            for (int i = 0; i < data.length; i++) {
                dataTime[i] = data[i];
            }
            data = dataTime;
            newElementsCount = result;
            capacity = newElementsCount;
        }
        return newElementsCount;
    }

    /**
     * возвращает емкость массива
     * @return
     */
    @Override
    public int getCapacity() {
        capacity = this.data.length - 1;
        return capacity;
    }

    /**
     * Возвращает массив с расположениям элементов наоборот
     * @return
     */
    @Override
    public void reverse() {
        int sizeTime = size;
        T[] dataTime = (T[]) new Object[sizeTime];
        for (int i = 0; i < size ; i++){
            sizeTime--;
            dataTime[sizeTime] =data[i];
        }
        data = dataTime;
    }

    /**
     * прописывает Значение элементов
     * @return
     */
    @Override
    public String toString() {
        return "; data = " + data
                + "; size = " + size
        + "; capacity = " + capacity;
    }

    /**
     * создает копию массива
     * @return
     */
    @Override
    public Object[] toArray() {
        T[] dataTime = (T[]) new Object[data.length] ;
        for (int i = 0; i < data.length; i++) {
            dataTime[i] = data[i];
        }
            return dataTime;
    }

    /**
     * Проверка являет ли масив 0
     * @return
     */
    @Override
    public Object customArray() {
        int summa = 0;
    for (int i = 0; i <size; i++) {
         if (data[i] == null) {
              summa++;
            }
         if(summa == size)
            return null;
        }
    return 1;
    }
}






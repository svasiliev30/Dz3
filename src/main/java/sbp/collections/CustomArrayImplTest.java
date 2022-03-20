import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sbp.CustomArrayImpl.CustomArrayImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayImplTest {
    String[] list3 = {"Привет", "пока", "пока1", "пока2" };
    String[] list4  = {null, null};
    Integer[] list2 = {1, 2};


    /**
     * Тест на длинну String list
     */
    @Test
    public  void TestSizeStringList(){
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertEquals(list3.length,(customArray.size()));
    }

    /**
     * Тест на длинну Integer list2
     */
    @Test
    public  void TestSizeIntegerList2(){
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        customArray.addAll(list2);
        Assertions.assertEquals(list2.length,(customArray.size()));
    }

    /**
     *Тест на количесто элементов если их нет
     */
    @Test
    public  void IsEmptyZero(){
        CustomArrayImpl  customArray = new CustomArrayImpl(5);
        Assertions.assertTrue(customArray.isEmpty());
        System.out.println(customArray.toString());
    }

    /**
     *Тест на количесто элементов если они есть
     */
    @Test
    public  void IsEmptyTwoElementsElements(){
        CustomArrayImpl  customArray = new CustomArrayImpl(5);
        customArray.add("1");
        customArray.add("2");
        Assertions.assertFalse(customArray.isEmpty());
        System.out.println(customArray.toString());
    }

    /**
     * тест на добавление элемента  если капасите 0
     */
    @Test
    public  void AddElementsCapacityZero(){
        CustomArrayImpl <String> customArray = new CustomArrayImpl<>(0);
        Assertions.assertTrue(customArray.add("1"));
        Assertions.assertEquals(1,(customArray.size()));
        Assertions.assertTrue(customArray.add("2"));
        Assertions.assertEquals(2,(customArray.size()));
        Assertions.assertTrue(customArray.add("3"));
        Assertions.assertEquals(3,(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на добавление элемента если капасите 5
     */
    @Test
    public  void AddElementsCapacityFive(){
        CustomArrayImpl <String> customArray = new CustomArrayImpl<>(5);
        Assertions.assertTrue(customArray.add("1"));
        Assertions.assertEquals(1,(customArray.size()));
        Assertions.assertTrue(customArray.add("2"));
        Assertions.assertEquals(2,(customArray.size()));
        Assertions.assertTrue(customArray.add("3"));
        Assertions.assertEquals(3,(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на добавление элементов к массиву type Integer and String
     */
    @Test
    public  void AddAllElementsTypeT(){
        CustomArrayImpl customArray = new CustomArrayImpl(25);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        Assertions.assertTrue(customArray.addAll(list2));
        Assertions.assertEquals((list3.length + list2.length) ,(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на добавление элементов к массиву если (list3.length + size) < capacity
     */
    @Test
    public  void AddAllElementsCapacityMore(){
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на добавление элементов к массиву если (list3.length + size) > capacity
     */
    @Test
    public  void AddAllElementsCapacityLess(){
        CustomArrayImpl  customArray = new CustomArrayImpl(0);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на подбрасывание если значения равны null
     */
    @Test
    public  void AddAllElementsList4Null() {
        CustomArrayImpl<String> customArray = new CustomArrayImpl<>(8);
        Assertions.assertThrows(IllegalArgumentException.class, () -> customArray.addAll(list4));
    }

    /**
     * тест на сложение коллекций type Integer and String
     */
    @Test
    public  void AddAllCollectionTypeT(){
        List listCollection = new ArrayList();
        listCollection.add(list3);
        listCollection.add(list2);

        List listCollection2 = new ArrayList();
        listCollection2.add(list3);
        listCollection2.add(list2);

        CustomArrayImpl  customArray = new CustomArrayImpl(30);
        Assertions.assertTrue(customArray.addAll(listCollection));
        Assertions.assertEquals(listCollection.size(),(customArray.size()));

        Assertions.assertTrue(customArray.addAll(listCollection2));
        Assertions.assertEquals((listCollection.size() + listCollection.size()),(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на сложение коллекций если (listCollection.size + listCollection2.size) > capacity
     */
    @Test
    public  void AddAllCollectionCapacityLess(){
        List listCollection = new ArrayList();
        listCollection.add(list3);
        listCollection.add(list2);

        List listCollection2 = new ArrayList();
        listCollection2.add(list3);
        listCollection2.add(list2);

        CustomArrayImpl  customArray = new CustomArrayImpl(0);
        Assertions.assertTrue(customArray.addAll(listCollection));
        Assertions.assertEquals(listCollection.size(),(customArray.size()));

        Assertions.assertTrue(customArray.addAll(listCollection2));
        Assertions.assertEquals((listCollection.size() + listCollection.size()),(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на сложение коллекций если (listCollection.size + listCollection2.size) < capacity
     */
    @Test
    public  void AddAllCollectionCapacityMore(){
        List listCollection = new ArrayList();
        listCollection.add(list3);
        listCollection.add(list2);

        List listCollection2 = new ArrayList();
        listCollection2.add(list3);
        listCollection2.add(list2);

        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        Assertions.assertTrue(customArray.addAll(listCollection));
        Assertions.assertEquals(listCollection.size(),(customArray.size()));

        Assertions.assertTrue(customArray.addAll(listCollection2));
        Assertions.assertEquals((listCollection.size() + listCollection.size()),(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на подбрасывание если значения равны null
     */
    @Test
    public  void AddAllListCollectionNull() {
        List listCollection = new ArrayList();
        listCollection.add(list3);
        listCollection.add(null);
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> customArray.addAll(listCollection));
    }

    /**
     * Добавление массива с указанного индекса
     */
    @Test
     public  void AddAllInIndex(){
        CustomArrayImpl  customArray = new CustomArrayImpl(15);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        Assertions.assertTrue(customArray.addAll(2,list3));
        Assertions.assertEquals((list3.length * 2),(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * Добавление массива с указанного индекса если (list3.length + size) < capacity
     */
    @Test
    public  void AddAllInIndexCapacityMore(){
        CustomArrayImpl  customArray = new CustomArrayImpl(15);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        Assertions.assertTrue(customArray.addAll(2,list3));
        Assertions.assertEquals((list3.length * 2),(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * Добавление массива с указанного индекса если (list3.length + size) > capacity
     */
    @Test
    public  void AddAllInIndexCapacityLess(){
        CustomArrayImpl  customArray = new CustomArrayImpl(0);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        Assertions.assertTrue(customArray.addAll(2,list3));
        Assertions.assertEquals((list3.length * 2),(customArray.size()));
        System.out.println(customArray.toString());
    }

    /**
     * тест на подбрасывание если значения равны null
     */
    @Test
    public  void AddAllInIndexList4Null() {
        CustomArrayImpl customArray = new CustomArrayImpl(8);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> customArray.addAll(1,list4));
    }

    /**
     * тест на подбрасывание если индекс больше емкости
     */
    @Test
    public  void AddAllInIndexMoreIsEmpty() {
        CustomArrayImpl<String> customArray = new CustomArrayImpl<>(8);
        Assertions.assertTrue(customArray.addAll(list3));
        Assertions.assertEquals(list3.length,(customArray.size()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> customArray.addAll(100,list3));
    }

    /**
     * Тест на вызов элемента по индексу
     */
    @Test
    public  void GetIndex(){
        CustomArrayImpl <String> customArray = new CustomArrayImpl<>(10);
        customArray.addAll(list3);
        Assertions.assertEquals("пока2",customArray.get(3));
        System.out.println("вызываемый индекс - " + customArray.get(3));
    }

    /**
     * Тест на вызов элемента если индекс больше емкости
     */
    @Test
    public  void GetIndexMoreIsEmpty(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> customArray.get(100));
    }

    /**
     * Тест на вызов старого значения по указанному индексу
     */
    @Test
    public  void SetOldIndex(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertEquals("Привет",customArray.set(0,"пока2"));
    }

    /**
     * Тест на вызов старого значения по указанному индексу если индекс больше емкости
     */
    @Test
    public  void SetIndexMoreIsEmpty(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> customArray.set(100,1));
    }

    /**
     * тест на удаление элемента
     */
    @Test
    public  void RemoveIndex(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        customArray.addAll(list2);

        customArray.remove(1);
        Assertions.assertEquals(null,(customArray.get(1)));

        customArray.remove(3);
        Assertions.assertEquals(null,(customArray.get(3)));
        for (int str = 0; str < customArray.size(); str ++){
            System.out.println(customArray.get(str));
        }
    }

    /**
     * тест на удаление элемента если индекс больше емкости
     */
    @Test
    public  void RemoveIndexMoreIsEmpty(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        customArray.addAll(list2);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> customArray.remove(100));
    }

    /**
     * тест на удаление элемента
     */
    @Test
    public  void RemoveElement(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        customArray.addAll(list2);
        Assertions.assertTrue(customArray.remove("пока"));
        Assertions.assertTrue(customArray.remove(customArray.get(5)));
        for (int str = 0; str < customArray.size(); str ++){
            System.out.println(customArray.get(str));
        }
    }

    /**
     * тест на удаление элемента
     */
    @Test
    public  void RemoveElementFalse(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        customArray.addAll(list2);
        Assertions.assertFalse(customArray.remove("покаaaaaaa"));
    }

    /**
     * Тест на то, есть ли нужное значение.(значеня нет)
     */
    @Test
    public  void СontainsFalse(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertFalse(customArray.contains("2"));
    }

    /**
     * Тест на то, есть ли нужное значение.(значение есть)
     */
    @Test
    public  void СontainsTrue(){
        CustomArrayImpl  customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertTrue(customArray.contains("пока"));
    }

    /**
     * Возвращает первый совпадающий индекс (индекс есть)
     */
    @Test
    public  void IndexOfTrue(){
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertEquals(1,customArray.indexOf("пока"));
    }

    /**
     * Возвращает первый совпадающий индекс (индекса нет)
     */
    @Test
    public  void IndexOfFalse(){
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertEquals(-1,customArray.indexOf("2"));
    }

    /**
     * увеличиваем емкость если ее мало
     */
    @Test
    public  void ensureCapacity(){
        CustomArrayImpl customArray = new CustomArrayImpl(9);
        customArray.addAll(list3);
        customArray.addAll(list3);
        Assertions.assertEquals(15,customArray.ensureCapacity(15));
    }

    /**
     * увеличиваем емкость если ее мало
     */
    @Test
    public  void getCapacity(){
        CustomArrayImpl customArray = new CustomArrayImpl(9);
        customArray.addAll(list3);
        customArray.addAll(list3);
        Assertions.assertEquals((list3.length*2),customArray.getCapacity());
    }

    /**
     * Меняем список местами
     */
    @Test
    public  void reverse(){
        CustomArrayImpl customArray = new CustomArrayImpl(9);
        Assertions.assertTrue(customArray.add("1"));
        Assertions.assertEquals(1,(customArray.size()));
        Assertions.assertTrue(customArray.add("2"));
        Assertions.assertEquals(2,(customArray.size()));
        Assertions.assertTrue(customArray.add("3"));
        Assertions.assertEquals(3,(customArray.size()));
        customArray.reverse();
        Assertions.assertEquals("3", customArray.get(0));
        Assertions.assertEquals("2", customArray.get(1));
        Assertions.assertEquals("1", customArray.get(2));
    }

    /**
     * проверка на создание копии
     */
    @Test
    public  void ToArrayCopy() {
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        customArray.add("2");
        customArray.add(customArray.toArray());
        System.out.println(customArray.get(1));
    }

    /**
     * проверка является ли массив 0
     */
    @Test
    public  void customArrayNotNull(){
        CustomArrayImpl customArray = new CustomArrayImpl(10);
        customArray.addAll(list3);
        Assertions.assertEquals(1,customArray.customArray());
    }

    /**
     * проверка является ли массив 0
     */
    @Test
    public  void customArrayNull(){
        CustomArrayImpl <String> customArray = new CustomArrayImpl<>(1);
        customArray.add(null);
        Assertions.assertEquals(null,customArray.customArray());
    }
}

/**
 * Created by mrhri on 10.11.2016.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

public class ArrayListTest {

    ArrayList list = new ArrayList();

    //Тест для get() с условием что в списке есть такой индекс и значение действительно
    @Test
    public void testGet(){

        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        int a = (int) list.get(2);
        int b = (int) list.get(1);
        Assert.assertEquals(12, a);
        Assert.assertEquals(11,b);
    }

    //Тест для установки значения по указанному индексу с условием того что по этому индексу пусто
    //тест пройден если кинет ошибку IOOBException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet(){

        list.set(0,"Hello");
        list.set(1,"World");

    }

    //Тест для установки значения по указанному индексу с условием что такой индекс существует
    //Тест пройден если значение добавлено
    @Test
    public void testSet2(){
        list.add(0, "Hello ");
        list.add(1, "Konstantin");
        list.add(2, " in this World");
        list.set(1,"Vladimir");
        Assert.assertEquals("Vladimir", list.get(1));
    }

    //Тест для add(T object) при добавлении обьекта без указания индекса, он добавляется в конец списка
    @Test
    public void testAdd(){
        list.add("String");
        list.add("String2");
        list.add("String3");
        //берем размер списка и отнимаем 1 что бы узнать последний индекс, т.к. отчет идет с нуля
        int lastIndex = list.size()-1;
        //Узнаем правда ли по этому индексу лежит то что положили последним то есть - "String3"
        Assert.assertEquals("String3", list.get(lastIndex));
        //Так же узнаем то начинается добавление с нуля
        Assert.assertEquals("String", list.get(0));
    }

    //Тест для add при добавлении эелемента с указанием индекса,
    // при пустом списке выдаст ошибку если добавление делать не с нуля.
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithIndex(){
        list.add(1,"String");
    }

    //Тест для add при добавлении элемента с указанием индекса
    //при пустом списке обязательно нужно добавлять с нуля и последовательно
    @Test
    public void testAddWithEmpty(){
        list.add(0, 12);
        list.add(1, 13);
        Assert.assertEquals(12, list.get(0));
        Assert.assertEquals(13, list.get(1));
    }


    //Тест для add , тест пройден если кинет ошибку IOOBException при указании индекса меньше 0,
    // а так же если лист пустой и индекс бльше чем размер списка
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddForIndexLessZero(){
        list.add(-10, "LessZero");
        list.add(2, "LessZero");
    }

    //Тест для size , проверка на действительность что размер равен тому сколько обьектов добавленно в список
    @Test
    public void testSize(){
        list.add(10);
        list.add(20);
        list.add(30);
        //в переменной size1 дложно быть значение 3 ..проверим!
        int size1 = list.size();
        Assert.assertEquals(3, size1);
        //Добавим еще один элемент(size2 должен быть равен 4) и снова проверим размер списка
        list.add(40);
        int size2 = list.size();
        Assert.assertEquals(4,size2);
    }

    //Тест для remove, проверяем , действительно ли мы удалили то что указали по индексу
    // и размер массива уменьшится на 1
    @Test
    public void testRemove(){
        list.add(0, "Hello ");
        list.add(1, "Konstantin");
        list.add(2, ", in this World");
        list.add(3, ", You like this World?");
        list.add(4, ", You don't like this World?");
        //Размер списка равен 5 , запишем в переменную и проверим
        int size = list.size();
        Assert.assertEquals(5, size);

        //Удалим и проверим , удалили мы именно то что хотели или нет
        Assert.assertEquals(", You like this World?", list.remove(3));

        //размер массива был 5 , стал 4 ..запишем в перменную и проверим
        int size_after_delete = list.size();
        Assert.assertEquals(4, size_after_delete);
    }
}

package tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод возвращает массив заявок без null элементов.
     * @return Массив без null элементов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод возвращает массив заявок, имя которых соответствует key.
     * @param key имя, по которому осуществляется поиск.
     * @return массив с найденными заявками.
     */
    public Item[] findByName(String key) {
        Item[] searchItems = findAll();
        Item[] result = new Item[searchItems.length];
        int index = 0;
        for (Item item : searchItems) {
            if (item.getName().equals(key)) {
                result[index++] = item;
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * Метод возвращает заявку с заданным id.
     * @param id заданный параметр поиска заявки.
     * @return если заявка найденаЮ возвращает эту заявку, если не найдена то null.
     */
    public Item findById(String id) {
        return indexOf(id) != -1 ? items[indexOf(id)] : null;
    }

    public void replace(String id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        this.items[index] = item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает индекс в массиве для заявки с заданным id.
     * @param id
     * @return индекс соответствующей заявки если она найдена, иначе -1.
     */
    private int indexOf(String id) {
        int rsl = -1;
        Item[] searchItems = findAll();
        for (int i = 0; i < searchItems.length; i++) {
            if (items[i].getId().equals(id)) {
                rsl = i;
            }
        }
        return rsl;
    }
}

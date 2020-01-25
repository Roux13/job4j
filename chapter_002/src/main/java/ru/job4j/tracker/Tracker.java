package ru.job4j.tracker;

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
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод удаляет заявку соответствующую переданному id.
     *
     * @param id
     */
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean success = false;
        if (index != -1) {
            int start = index + 1;
            int distPos = index;
            int size = this.position - index;
            System.arraycopy(this.items, start, this.items, distPos, size);
            this.items[this.position] = null;
            this.position--;
            success = true;
        }
        return success;
    }

    /**
     * Метод возвращает массив заявок без null элементов.
     *
     * @return Массив без null элементов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод возвращает массив заявок, имя которых соответствует key.
     *
     * @param key имя, по которому осуществляется поиск.
     * @return массив с найденными заявками.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.items.length];
        int index = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName() != null && this.items[i].getName().equals(key)) {
                result[index++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, index);
    }

    /**
     * Метод возвращает заявку с заданным id.
     *
     * @param id заданный параметр поиска заявки.
     * @return если заявка найдена, возвращает эту заявку, если не найдена то null.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? this.items[index] : null;
    }

    /**
     * Метод заменяет заявку соответствующую id на новую заявку.
     *
     * @param id
     * @param item заявка, которой необходимо заменить прежнюю.
     */
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean success = false;
        if (index != -1) {
            item.setId(id);
            this.items[index] = item;
            success = true;
        }
        return success;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод возвращает индекс в массиве для заявки с заданным id.
     *
     * @param id
     * @return индекс соответствующей заявки если она найдена, иначе -1.
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
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
            this.items.remove(index);
            success = true;
        }
        return success;
    }

    /**
     * Метод возвращает список всех заявок.
     *
     * @return Список всех элементов.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод возвращает список заявок, имя которых соответствует key.
     *
     * @param key имя, по которому осуществляется поиск.
     * @return Список с найденными заявками.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName() != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод возвращает заявку с заданным id.
     *
     * @param id заданный параметр поиска заявки.
     * @return если заявка найдена, возвращает эту заявку, если не найдена то null.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? this.items.get(index) : null;
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
            this.items.set(index, item);
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
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}

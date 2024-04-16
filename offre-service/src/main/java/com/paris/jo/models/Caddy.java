package com.paris.jo.models;

import com.paris.jo.entities.Event;
import com.paris.jo.entities.Item;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Caddy implements Serializable {
    private Map<Long, Item> items = new HashMap<Long, Item>();

    public void addEvent(Event event, int quantity) {
        Item newItem;
        if (items.get(event.getId()) == null) {
            newItem = new Item();
            newItem.setEvent(event);
        } else {
            newItem = items.get(event.getId());
            newItem.setQuantity(newItem.getQuantity() + quantity);

        }
    }

    public Collection<Item> getItems() {
        return items.values();
    }

    public double getTotal() {
        double total = 0;
        total += items.values().stream().mapToDouble(d -> d.getQuantity() * d.getPrice()).sum();
        return total;
    }

    public int getNumberItems() {
        return items.values().size();
    }

    public void deleteItem(Long eventId) {
        items.remove(eventId);
    }

}

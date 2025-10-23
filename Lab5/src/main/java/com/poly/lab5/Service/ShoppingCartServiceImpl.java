package com.poly.lab5.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import poly.edu.Lab5.Enity.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    // Map chứa danh sách hàng trong giỏ (key = id sản phẩm)
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            // tạo mới item – ở bài 5 sẽ lấy từ DB giả
            item = new Item(id, "Sản phẩm " + id, 10.0 * id, 1);
            map.put(id, item);
        } else {
            // nếu đã có thì tăng số lượng lên
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        // Tổng số lượng sản phẩm trong giỏ
        return map.values().stream().mapToInt(Item::getQty).sum();
    }

    @Override
    public double getAmount() {
        // Tổng tiền
        return map.values().stream()
        .mapToDouble(item -> item.getPrice() * item.getQty())
        .sum();
    }
}

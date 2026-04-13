package com.re.btvn.SESSION07_05;

import java.util.List;
import java.util.UUID;

public class Combo {
    private String id;
    private String name;
    private List<String> itemList;
    private String bannerName;

    // Constructor rỗng (Bắt buộc)
    public Combo() {}

    // Constructor có tham số
    public Combo(String name, List<String> itemList, String bannerName) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.itemList = itemList;
        this.bannerName = bannerName;
    }

    // --- Getters và Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getItemList() { return itemList; }
    public void setItemList(List<String> itemList) { this.itemList = itemList; }

    public String getBannerName() { return bannerName; }
    public void setBannerName(String bannerName) { this.bannerName = bannerName; }

    // Dùng toString() mặc định của Java thay vì tự chế JSON
    @Override
    public String toString() {
        return "Combo {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                ", bannerName='" + bannerName + '\'' +
                '}';
    }
}
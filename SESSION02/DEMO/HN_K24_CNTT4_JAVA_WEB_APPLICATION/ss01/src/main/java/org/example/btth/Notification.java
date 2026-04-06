package org.example.btth;

public interface Notification {
    // username - tên khách hàng
    // message - nội dung tin nhắn
    void sendNotify(String username, String message);
}

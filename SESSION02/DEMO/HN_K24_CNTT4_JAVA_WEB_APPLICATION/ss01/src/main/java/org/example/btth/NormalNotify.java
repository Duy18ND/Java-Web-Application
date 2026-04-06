package org.example.btth;

import org.springframework.stereotype.Component;

@Component
public class NormalNotify implements Notification {
    @Override
    public void sendNotify(String username, String message) {
        // Volume - Là âm thanh
        System.out.println(
                "[ Volume 🔊 ] " + username +
                        " |  Message: " + message
        );
    }
}

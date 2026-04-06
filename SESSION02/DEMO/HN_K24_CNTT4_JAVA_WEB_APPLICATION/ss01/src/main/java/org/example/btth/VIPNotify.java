package org.example.btth;

import org.springframework.stereotype.Component;

@Component
public class VIPNotify implements Notification {

    @Override
    public void sendNotify(String username, String message) {
        System.out.println(
                "[ Popup 💬 ] " + username +
                        " | Message: " + message);
    }

}

package com.crud.tasks.config;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConfigTestSuite {
    @Autowired
    private TrelloConfig trelloConfig;
    @Autowired
    private AdminConfig adminConfig;
    @Test
    void testTrelloConfigValues() {
        //Given
        //When
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();
        String trelloAppKey = trelloConfig.getTrelloAppKey();
        String trelloToken = trelloConfig.getTrelloToken();
        String userName = trelloConfig.getTrelloUser();
        //Then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
        assertEquals("7d12febeb14dbd27bab803f115fdde81", trelloAppKey);
        assertEquals("ATTAc46938794504e125028fa3c49955cbf571a2da3d4dbba9fc4be985b1b5e6f5bd272C69A9", trelloToken);
        assertEquals("kpopinski", userName);
    }
    @Test
    void testAdminConfif() {
        //Given
        //When
        String adminMail = adminConfig.getAdminMail();
        //Then
        assertEquals("test@test.com", adminMail);
    }
}
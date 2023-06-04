package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DomainTestSuite {
    @Test
    void testCreateAttachmentByTypeDto() {
        //Given
        TrelloDto trelloDto = new TrelloDto(1, 2);
        //When
        AttachmentsByType attachmentsByType = new AttachmentsByType(trelloDto);
        //Then
        assertNotNull(attachmentsByType);
        assertEquals(trelloDto, attachmentsByType.getTrelloDto());
        assertEquals(1, attachmentsByType.getTrelloDto().getBoard());
        assertEquals(2, attachmentsByType.getTrelloDto().getCard());
    }
    @Test
    void testCreateTrelloBadgesDto() {
        //Given
        TrelloDto trelloDto = new TrelloDto(1, 2);
        AttachmentsByType attachmentsByType = new AttachmentsByType(trelloDto);
        //When
        TrelloBadgesDto trelloBadgesDto = new TrelloBadgesDto(2, attachmentsByType);
        //Then
        assertNotNull(trelloBadgesDto);
        assertEquals(2, trelloBadgesDto.getVotes());
    }
    @Test
    void testCreateTrelloCard() {
        //Given
        String name = "Karta 1";
        String description = "Opis 1";
        String pos = "top";
        String listId = "1";
        //When
        TrelloCard trelloCard = new TrelloCard(name, description, pos, listId);
        //Then
        assertNotNull(trelloCard);
        assertEquals("Karta 1", trelloCard.getName());
        assertEquals("Opis 1", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("1", trelloCard.getListId());
    }
}
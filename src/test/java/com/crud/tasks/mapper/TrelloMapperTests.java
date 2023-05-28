package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTests {
    @Autowired
    private TrelloMapper trelloMapper;
    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "Lista 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "Lista 2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "Lista 3", false);
        TrelloListDto trelloListDto4 = new TrelloListDto("4", "Lista 4", false);
        TrelloListDto trelloListDto5 = new TrelloListDto("5", "Lista 5", false);

        List<TrelloListDto> testList1 = new ArrayList<>();
        testList1.add(trelloListDto1);
        testList1.add(trelloListDto5);

        List<TrelloListDto> testList2 = new ArrayList<>();
        testList2.add(trelloListDto2);
        testList2.add(trelloListDto3);
        testList2.add(trelloListDto4);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "tablica 1", testList1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "tablica 2", testList2);

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto1);
        trelloBoardsDto.add(trelloBoardDto2);

        //When
        List<TrelloBoard> resultTrelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        List<TrelloList> resultList1 = resultTrelloBoards.get(0).getLists();
        List<TrelloList> resultList2 = resultTrelloBoards.get(1).getLists();

        assertEquals(2, resultTrelloBoards.size());

        assertEquals(2, resultList1.size());
        assertEquals(3, resultList2.size());

        assertEquals("1", resultList1.get(0).getId());
        assertEquals("Lista 1", resultList1.get(0).getName());
        assertFalse(resultList1.get(0).isClosed());

        assertEquals("2", resultList2.get(0).getId());
        assertEquals("Lista 2", resultList2.get(0).getName());
        assertFalse(resultList2.get(0).isClosed());

        assertEquals("5", resultList1.get(1).getId());
        assertEquals("Lista 5", resultList1.get(1).getName());
        assertFalse(resultList1.get(1).isClosed());
    }
    @Test
    void testMapToBoardsDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "Lista 1", false);
        TrelloList trelloList2 = new TrelloList("2", "Lista 2", false);
        TrelloList trelloList3 = new TrelloList("3", "Lista 3", false);
        TrelloList trelloList4 = new TrelloList("4", "Lista 4", false);
        TrelloList trelloList5 = new TrelloList("5", "Lista 5", false);

        List<TrelloList> testList1 = new ArrayList<>();
        testList1.add(trelloList1);
        testList1.add(trelloList5);

        List<TrelloList> testList2 = new ArrayList<>();
        testList2.add(trelloList2);
        testList2.add(trelloList3);
        testList2.add(trelloList4);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "tablica 1", testList1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "tablica 2", testList2);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        //When
        List<TrelloBoardDto> resultTrelloBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        List<TrelloListDto> resultList1 = resultTrelloBoardsDto.get(0).getLists();
        List<TrelloListDto> resultList2 = resultTrelloBoardsDto.get(1).getLists();

        assertEquals(2, resultTrelloBoardsDto.size());

        assertEquals(2, resultList1.size());
        assertEquals(3, resultList2.size());

        assertEquals("1", resultList1.get(0).getId());
        assertEquals("Lista 1", resultList1.get(0).getName());
        assertFalse(resultList1.get(0).isClosed());

        assertEquals("3", resultList2.get(1).getId());
        assertEquals("Lista 3", resultList2.get(1).getName());
        assertFalse(resultList2.get(1).isClosed());

        assertEquals("5", resultList1.get(1).getId());
        assertEquals("Lista 5", resultList1.get(1).getName());
        assertFalse(resultList1.get(1).isClosed());
    }
    @Test
    void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "Lista 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "Lista 2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "Lista 3", false);
        TrelloListDto trelloListDto4 = new TrelloListDto("4", "Lista 4", false);
        TrelloListDto trelloListDto5 = new TrelloListDto("5", "Lista 5", false);

        List<TrelloListDto> testList = new ArrayList<>();
        testList.add(trelloListDto1);
        testList.add(trelloListDto2);
        testList.add(trelloListDto3);
        testList.add(trelloListDto4);
        testList.add(trelloListDto5);
        //When
        List<TrelloList> resultTrelloLists = trelloMapper.mapToList(testList);
        //Then
        TrelloList resultTrelloList1 = resultTrelloLists.get(0);
        TrelloList resultTrelloList2 = resultTrelloLists.get(1);
        TrelloList resultTrelloList3 = resultTrelloLists.get(2);
        TrelloList resultTrelloList4 = resultTrelloLists.get(3);
        TrelloList resultTrelloList5 = resultTrelloLists.get(4);

        assertEquals(5, resultTrelloLists.size());

        assertEquals("1", resultTrelloList1.getId());
        assertEquals("Lista 1", resultTrelloList1.getName());
        assertFalse(resultTrelloList1.isClosed());

        assertEquals("2", resultTrelloList2.getId());
        assertEquals("Lista 2", resultTrelloList2.getName());
        assertFalse(resultTrelloList2.isClosed());

        assertEquals("3", resultTrelloList3.getId());
        assertEquals("Lista 3", resultTrelloList3.getName());
        assertFalse(resultTrelloList3.isClosed());

        assertEquals("4", resultTrelloList4.getId());
        assertEquals("Lista 4", resultTrelloList4.getName());
        assertFalse(resultTrelloList4.isClosed());

        assertEquals("5", resultTrelloList5.getId());
        assertEquals("Lista 5", resultTrelloList5.getName());
        assertFalse(resultTrelloList5.isClosed());
    }
    @Test
    void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "Lista 1", false);
        TrelloList trelloList2 = new TrelloList("2", "Lista 2", false);
        TrelloList trelloList3 = new TrelloList("3", "Lista 3", false);
        TrelloList trelloList4 = new TrelloList("4", "Lista 4", false);
        TrelloList trelloList5 = new TrelloList("5", "Lista 5", false);

        List<TrelloList> testList = new ArrayList<>();
        testList.add(trelloList1);
        testList.add(trelloList2);
        testList.add(trelloList3);
        testList.add(trelloList4);
        testList.add(trelloList5);
        //When
        List<TrelloListDto> resultTrelloListsDto = trelloMapper.mapToListDto(testList);
        //Then
        TrelloListDto resultTrelloListDto1 = resultTrelloListsDto.get(0);
        TrelloListDto resultTrelloListDto2 = resultTrelloListsDto.get(1);
        TrelloListDto resultTrelloListDto3 = resultTrelloListsDto.get(2);
        TrelloListDto resultTrelloListDto4 = resultTrelloListsDto.get(3);
        TrelloListDto resultTrelloListDto5 = resultTrelloListsDto.get(4);

        assertEquals(5, resultTrelloListsDto.size());

        assertEquals("1", resultTrelloListDto1.getId());
        assertEquals("Lista 1", resultTrelloListDto1.getName());
        assertFalse(resultTrelloListDto1.isClosed());

        assertEquals("2", resultTrelloListDto2.getId());
        assertEquals("Lista 2", resultTrelloListDto2.getName());
        assertFalse(resultTrelloListDto2.isClosed());

        assertEquals("3", resultTrelloListDto3.getId());
        assertEquals("Lista 3", resultTrelloListDto3.getName());
        assertFalse(resultTrelloListDto3.isClosed());

        assertEquals("4", resultTrelloListDto4.getId());
        assertEquals("Lista 4", resultTrelloListDto4.getName());
        assertFalse(resultTrelloListDto4.isClosed());

        assertEquals("5", resultTrelloListDto5.getId());
        assertEquals("Lista 5", resultTrelloListDto5.getName());
        assertFalse(resultTrelloListDto5.isClosed());
    }
    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Karta 1", "Opis 1", "top", "1");
        //When
        TrelloCardDto resultTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertNotNull(resultTrelloCardDto);
        assertEquals("Karta 1", resultTrelloCardDto.getName());
        assertEquals("Opis 1", resultTrelloCardDto.getDescription());
        assertEquals("top", resultTrelloCardDto.getPos());
        assertEquals("1", resultTrelloCardDto.getListId());
    }
    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Karta 1", "Opis 1", "top", "1");
        //When
        TrelloCard resultTrelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertNotNull(resultTrelloCard);
        assertEquals("Karta 1", resultTrelloCard.getName());
        assertEquals("Opis 1", resultTrelloCard.getDescription());
        assertEquals("top", resultTrelloCard.getPos());
        assertEquals("1", resultTrelloCard.getListId());
    }
}
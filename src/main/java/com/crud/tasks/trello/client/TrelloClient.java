package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class TrelloClient {

    private final RestTemplate restTemplate;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.app.username}")
    private String trelloUserName;
/*
    public List<TrelloBoardDto> getTrelloBoards() {
                URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/karolpopinski/boards")
                        .queryParam("key=", trelloAppKey)
                        .queryParam("token", trelloToken)
                        .build()
                        .encode()
                        .toUri();

                TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);

        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
 */

    private URI getTrelloSpecificBoard() {
            return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trelloUserName + "/boards")
                    .queryParam("key", trelloAppKey)
                    .queryParam("token", trelloToken)
                    .queryParam("fields", "name,id")
                    .build()
                    .encode()
                    .toUri();
    }


    public List<TrelloBoardDto> getTrelloBoards() {

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(getTrelloSpecificBoard(), TrelloBoardDto[].class);

        List<TrelloBoardDto> trelloBoardDtoList = Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());

        return trelloBoardDtoList.stream()
                .filter(name -> name.getName() != null)
                .filter(id -> id.getId() != null)
                .filter(name -> name.getName().contains("Kodilla"))
                .toList();
    }
}

package com.paris.jo.web;

import com.paris.jo.clients.ClientRestClient;
import com.paris.jo.entities.Offer;
import com.paris.jo.repositories.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
public class OfferController {

    private OfferRepository offerRepository;
    private ClientRestClient clientRestClient;

    public OfferController(OfferRepository offerRepository, ClientRestClient clientRestClient) {
        this.offerRepository = offerRepository;
        this.clientRestClient = clientRestClient;
    }

    @GetMapping("/offers")
    public List<Offer> offerList() {
        return offerRepository.findAll();
    }


    @GetMapping("/offers/{id}")
    public ResponseEntity offerById(@PathVariable long id) {
        Offer offer = offerRepository.findById(id).orElse(null);
        if(offer == null) {
            return ResponseEntity.internalServerError().body(Map.of("errorMessage","account not found"));
        }
        return ResponseEntity.of(Optional.of(offer));
    }
}

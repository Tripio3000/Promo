package ru.promo.service.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import ru.promo.service.domain.Participant;
import ru.promo.service.domain.Prize;
import ru.promo.service.domain.Promo;
import ru.promo.service.repo.MessageRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/promo")
public class MesssageController {

    private static int COUNT;
    private MessageRepo messageRepo;

    @Autowired
    public MesssageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

//    @Query("select id, name, description from Promo")
    @GetMapping
    public List<Promo> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public Promo getById(@PathVariable("id") Promo promo) {
        return promo;
    }

    @PostMapping
    public Promo create(@RequestBody Promo promo) {
        return messageRepo.save(promo);
    }

    @PutMapping("{id}")
    public Promo update(@PathVariable("id") Promo promoFromDb,
                        @RequestBody Promo promo) {
        BeanUtils.copyProperties(promo, promoFromDb, "id");

        return messageRepo.save(promoFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Promo promo) {
        messageRepo.delete(promo);
    }

    @PostMapping("{id}/participant")
    public Promo createParticipant(@PathVariable("id") Promo promoFromDb, @RequestBody Participant participant) {
        Set<Participant> participantSet = new HashSet<>();
        participantSet.add(participant);
        promoFromDb.setParticipants(participantSet);
        return messageRepo.save(promoFromDb);
    }

    @PostMapping("{id}/prize")
    public Promo createPrize(@PathVariable("id") Promo promoFromDb, @RequestBody Prize prize) {
        Set<Prize> prizeSet = new HashSet<>();
        prizeSet.add(prize);
        promoFromDb.setPrizes(prizeSet);
        return messageRepo.save(promoFromDb);
    }
}

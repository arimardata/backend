package com.pfproject.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.service.AppelOffreService;
import com.pfproject.api.service.ConsomableService;
import com.pfproject.api.service.NonConsomableService;
import com.pfproject.api.service.Personnel.AdministratifService;
import com.pfproject.api.service.Personnel.PermanentService;
import com.pfproject.api.service.Personnel.SaisonierService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistiques")
public class Statistiques {

    private final AppelOffreService aoService;
    private final ConsomableService consomableService;
    private final NonConsomableService nonConsomableService;
    private final PermanentService permanentService;
    private final SaisonierService saisonierService;
    private final AdministratifService administratifService;

    @Autowired
    public Statistiques(final AppelOffreService aoService, AdministratifService administratifService,
            ConsomableService consomableService, NonConsomableService nonConsomableService,
            PermanentService permanentService, SaisonierService saisonierService) {
        this.aoService = aoService;
        this.consomableService = consomableService;
        this.nonConsomableService = nonConsomableService;
        this.permanentService = permanentService;
        this.saisonierService = saisonierService;
        this.administratifService = administratifService;
    }

    @RequestMapping(value = "/countByEtat", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        Map<String, Map<String, Long>> liste = new HashMap<String, Map<String, Long>>();

        Map<String, Long> aos = new HashMap<String, Long>();
        aos.put("Total", aoService.count());
        aos.put("Favoris", aoService.countByEtat("Favoris"));
        aos.put("Postule", aoService.countByEtat("Postule"));
        aos.put("Retenu", aoService.countByEtat("Retenu"));
        aos.put("Projets", aoService.countByEtat("Projets"));
        aos.put("Finis", aoService.countByEtat("Archive Des Projets Finis"));
        aos.put("A_Modifier", aoService.countByEtat("A Modifier"));
        aos.put("Non_Accepte", aoService.countByEtat("Archive Des Projets Non-Accepte"));

        liste.put("aos", aos);

        Map<String, Long> materiels = new HashMap<String, Long>();
        Long consomable = consomableService.count();
        Long nonConsomable = nonConsomableService.count();
        materiels.put("Total", consomable + nonConsomable);
        materiels.put("consomable", consomable);
        materiels.put("nonConsomable", nonConsomable);

        liste.put("materiels", materiels);

        Map<String, Long> personnels = new HashMap<String, Long>();
        Long permanent = permanentService.count();
        Long administratif = administratifService.count();
        Long saisonier = saisonierService.count();
        personnels.put("Total", permanent + administratif + saisonier);
        personnels.put("permanent", permanent);
        personnels.put("administratif", administratif);
        personnels.put("saisonier", saisonier);

        liste.put("personnels", personnels);

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
}

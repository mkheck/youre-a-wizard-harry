package com.thehecklers.sampleappformigrationtests;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class WizardController {
    private final WizardRepository repo;

    @GetMapping
    public String status() {
        return "Wizard service is UP!";
    }

    @GetMapping("/wizards")
    public Flux<Wizard> getAllWizards() {
        return repo.findAll();
    }

    @GetMapping("/wizards/{id}")
    public Mono<Wizard> getWizardById(@PathVariable String id) {
        return repo.findById(id);
    }

    @GetMapping("/search")
    public Flux<Wizard> findWizards(@RequestParam(required = false) String lastName, @RequestParam(required = false) String house) {
        int search = 0;

        if (null != lastName) {
            search++;
        }

        if (null != house) {
            search += 2;
        }

        switch (search) {
            case 1 -> {
                return repo.findByLastName(lastName);
            }
            case 2 -> {
                return repo.findByHouse(house);
            }
            case 3 -> {
                return repo.findByLastNameAndHouse(lastName, house);
            }
            default -> {
                return Flux.empty();
            }
        }
    }

    @PostMapping("/wizard")
    Mono<Wizard> addWizard(@RequestBody Wizard wizard) {
        return repo.save(wizard);
    }
}

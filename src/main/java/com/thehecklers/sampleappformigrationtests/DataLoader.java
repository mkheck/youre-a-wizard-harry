package com.thehecklers.sampleappformigrationtests;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataLoader {
    private final WizardRepository repo;

    @PostConstruct
    public void loadData() {
        repo.deleteAll()
                .thenMany(Flux.just(new Wizard("Harry", "Potter", "Gryffindor")))
                .flatMap(repo::save)
                .thenMany(repo.findAll())
                .log()
                .subscribe();
    }
}

package com.thehecklers.sampleappformigrationtests;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface WizardRepository extends ReactiveCrudRepository<Wizard, String> {
    Flux<Wizard> findByLastName(String lastName);

    Flux<Wizard> findByHouse(String house);

    Flux<Wizard> findByLastNameAndHouse(String lastName, String house);
}

package com.thehecklers.sampleappformigrationtests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class Wizard {
    @Id String id;
    @NonNull
    String firstName, lastName, house;
}

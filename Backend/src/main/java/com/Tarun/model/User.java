 package com.Tarun.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
 

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;


    private String password;

    @Indexed(unique = true)
    private String email;
}
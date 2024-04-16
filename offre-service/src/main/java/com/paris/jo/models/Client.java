package com.paris.jo.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
}

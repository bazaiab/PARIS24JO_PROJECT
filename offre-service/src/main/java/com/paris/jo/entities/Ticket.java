package com.paris.jo.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket implements Serializable {
    private Long id;
    private String tokenClient;
    private String tokenBillet;

}

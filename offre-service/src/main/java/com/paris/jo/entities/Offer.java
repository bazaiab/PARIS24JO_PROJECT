package com.paris.jo.entities;

import com.paris.jo.enums.OfferTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min=4, max = 20)
    private String name;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private String description;
    @Lob
    private byte[] photo;
    private String photoName;
    private double price;
    @Enumerated(EnumType.STRING)
    private OfferTypeEnum type;
    @OneToMany(mappedBy ="offer" ,fetch = FetchType.EAGER)
    private Collection<Event> events;


}

package com.paris.jo.entities;

import com.paris.jo.enums.EventTypeEnum;
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
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 4, max =20)
    private String name;
    private LocalDate creationDate;
    private LocalDate updateDate;
    @NotEmpty
    @Size(min = 4)
    private String description;
    private boolean selected;
    private byte[] photo;
    private String photoName;
    private String lieu;
    private LocalDate date;
    private String details;
    private double price;
    @Enumerated(EnumType.STRING)
    private EventTypeEnum type;

    @OneToMany(mappedBy = "event", fetch= FetchType.EAGER)
    private Collection<Item> items;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "offer_id")
    private Offer offer;
}

package com.paris.jo.entities;

import com.paris.jo.models.Client;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDate orderDate;
    private Long clientId;
    @Transient
    private Client client;
    @OneToMany(mappedBy = "order", fetch= FetchType.EAGER)
    private Collection<Item> items;

    
}

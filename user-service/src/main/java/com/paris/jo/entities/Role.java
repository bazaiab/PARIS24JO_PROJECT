package com.paris.jo.entities;

import com.paris.jo.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum roleName;
    @ManyToOne
    @JoinColumn(name="idUser", nullable=false)
    private User user;
}

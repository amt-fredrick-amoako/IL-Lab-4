package com.amalitech.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "T_Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private double totalAmount;

    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    private List<Product> products = new ArrayList<>();
}

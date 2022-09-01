package com.example.hotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private double price;
    private boolean isOccupied;

    public Room(int number, double price, boolean isOccupied) {
        this.number = number;
        this.price = price;
        this.isOccupied = isOccupied;
    }
}

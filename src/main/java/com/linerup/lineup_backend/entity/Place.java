package com.linerup.lineup_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Objects;

/**
 * packageName    : com.linerup.lineup_backend.common.model
 * fileName       : Place
 * author         : moongi
 * date           : 11/29/23
 * description    :
 */

@Getter
@Entity
public class Place {

    @Id @GeneratedValue
    String id;
    String map_id; // 맵 유니크 아이디
    String name; // 상호명
    String address; // 도로명 주소
    String x; // x 좌표
    String y; // y 좌표

    protected Place() {
    }

    public Place(String map_id, String name, String address, String x, String y) {
        this.map_id = map_id;
        this.name = name;
        this.address = address;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(getMap_id(), place.getMap_id()) && Objects.equals(getName(), place.getName()) && Objects.equals(getAddress(), place.getAddress()) && Objects.equals(getX(), place.getX()) && Objects.equals(getY(), place.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMap_id(), getName(), getAddress(), getX(), getY());
    }
}

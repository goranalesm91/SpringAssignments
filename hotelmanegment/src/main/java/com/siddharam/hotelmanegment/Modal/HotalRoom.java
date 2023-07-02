package com.siddharam.hotelmanegment.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HotalRoom")
public class HotalRoom {
    @Id
    private Long roomId;
    private Integer roomNumber;
    private Type roomType;
    private  Double roomPrice;
    private Boolean roomStatus;

}

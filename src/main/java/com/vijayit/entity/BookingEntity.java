package com.vijayit.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="bookings")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String roomtype;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer adults;
    private Integer children;
    private String extrabeds;
    private Double totalPrice;
    private Integer gstPercentage;
    private Integer discountPercentage;
    private Double nettotal;
}

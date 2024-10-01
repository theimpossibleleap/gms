package com.erickalovesadam.wedding.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    @NotEmpty(message = "First Name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty")
    private String lastName;

    @NotEmpty(message = "E-Mail cannot be empty")
    @Email(message = "E-Mail address invalid")
    private String email;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$",
            message = "Invalid phone number format. Use (555) 555-5555")
    private String phone;

    private String address1;
    private String address2;
    private String city;

    // @Size(min = 2, message = "State must be 2 characters")
    private String state;

    // @Size(min = 5, message = "Zip Code must be 8 characters")
    private String zip;

    @Enumerated(EnumType.STRING)
    private RSVPStatus rsvpStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private Meal meal;

}

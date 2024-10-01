package com.erickalovesadam.wedding.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RSVPStatus {
    YES("Yes"),
    NO("No"),
    MAYBE("Maybe");

    private String displayName;
}

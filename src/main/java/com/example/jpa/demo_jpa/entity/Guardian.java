package com.example.jpa.demo_jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // Required when we need a data class but data should be stored
// in same table. There should be a counterpart @Embedded in a Entity class
// where this data is embedded
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({ // required when a table is already created with
// different column names and should be mapped to different variable names in
// data class
        @AttributeOverride(name ="name", column = @Column(name =
                "guardian_name")),

        @AttributeOverride(name ="email", column = @Column(name =
                "guardian_email")),

        @AttributeOverride(name ="mobile", column = @Column(name =
                "guardian_mobile"))
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}

package com.kunaldo.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


// This student is particular class that represents a table using @Entity annotation
// everytime adding new student, it should have a new email id @UniqueConstraint

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)

// incrementing the value of id by sequence
public class Student {


    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    // Name of the column
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}

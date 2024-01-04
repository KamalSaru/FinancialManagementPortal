package com.wellsfargobank.financialmanagementportal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
import java.time.Period;

//In MySQL--financial_management_portal--table name--"customer_details"
@Table(name = "customer_details") //Table name doesn't create
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.AUTO, generator = "ID_generator")
    //@SequenceGenerator(name = "ID_generator", sequenceName = "CustomerDetails_sequence")
    //@jakarta.persistence.Id  //Before we did @Id, now they update

    @Column(name = "ID")
    private Long customerID;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    //@NotBlank(message = "Please, provide email address.")
    private String email;
    private String address;
    @Column(name="date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;

    @Transient //Age calculation
    //@Temporal(TemporalType.TIMESTAMP)
    //When getMapping we can see the age in year(2023-2000=23)--------------------
    private Integer age;
    public Integer getAge() {
        if (dob != null) {
            return Period.between(dob, LocalDate.now()).getYears();
        }
        return null;
    }

    private String gender;
    @Column(name = "account_status")
    private String accountStatus;
}

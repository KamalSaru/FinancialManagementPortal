package com.wellsfargobank.financialmanagementportal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.Formula;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name = "checking_account_statement")
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CheckingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long ID;
    @Column(name = "opening_balance")
    private Double openingBalance;
    //@CreatedDate------//create date
    //@Temporal(TemporalType.TIMESTAMP) //date
    //@PrePersist----formula")
    private Double depositAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate depositDate;
    @PrePersist //annotation for the date and create a method for handling the amount
    protected void depositDate(){
        if(depositAmount !=null){
            depositDate=LocalDate.now(); //Post current date if deposit--------
        }
    }

    private Double withdrawAmount;
    private LocalDate withdrawDate;
    @Transient //mapped superclass, or a callback listener class
    protected void withdrawDate(){
        if (withdrawAmount != null){
            withdrawDate=LocalDate.now(); //Post current date if withdraw--------
        }
    }

    //@Transient---logic formula------
    //@Formula("openingBalance + depositAmount - withdrawAmount")
    @Transient
    private Double totalBalance;
    public void talalBalance(){
        totalBalance=openingBalance+(depositAmount !=null? depositAmount:0)-
               (withdrawAmount !=null? withdrawAmount:0);
    }
    @Formula("totalBalance*0.07")
    private Double interestEarn;
    @Column(name = "closing_balance")
    @Formula("totalBalance + interestEarn")
    private Double closingBalance;

}

//@PrePersist	Executed before the entity manager persist operation is actually executed or cascaded. This call is synchronous with the persist operation.
//@PreRemove	Executed before the entity manager remove operation is actually executed or cascaded. This call is synchronous with the remove operation.
//@PostPersist	Executed after the entity manager persist operation is actually executed or cascaded. This call is invoked after the database INSERT is executed.
//@PostRemove	Executed after the entity manager remove operation is actually executed or cascaded. This call is synchronous with the remove operation.
//@PreUpdate	Executed before the database UPDATE operation.
//@PostUpdate	Executed after the database UPDATE operation.
//@PostLoad	Executed after an entity has been loaded into the current persistence context or an entity has been refreshed.

package com.matveyperestoronin.client_app_liga_cifrovoy_economici.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client_account")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false, name = "full_name")
    private String name;

    @Column(length = 1)
    private String gender;

    @Column(length = 20)
    private String status;

    @Column(name = "create_dttm", nullable = false)
    private OffsetDateTime createDate;
    @Column(name = "modify_dttm", nullable = false)
    private OffsetDateTime modifyDate;

    @PrePersist
    public void onCreate() {
        this.createDate = OffsetDateTime.now();
        this.modifyDate = OffsetDateTime.now();
        this.status = "ACTIVE";
    }

    @PreUpdate
    public void onUpdate() {
        this.modifyDate = OffsetDateTime.now();
    }


}

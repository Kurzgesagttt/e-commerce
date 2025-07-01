package com.Kurzgesagttt.AuthService.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String name;

    public enum Values{
        USER(1l),
        SELLER(2l),
        ADMIN(3l);

        long roleId;
        Values(Long roleId){
            this.roleId = roleId;
        }
        public long getRoleId() {
            return roleId;
        }
    }
}

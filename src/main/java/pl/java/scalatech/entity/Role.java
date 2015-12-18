package pl.java.scalatech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Column(name = "roleDesc")
    private String desc;
}
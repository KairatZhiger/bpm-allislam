package kz.allcompany.page.entity;

import kz.allcompany.page.lib.db.ServiceBaseModel;

import javax.persistence.*;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@Entity
@Table(name = "p_service")
public class PService extends ServiceBaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}

package Entities;

import DbConnect.HibernateUtil;
import org.hibernate.Session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "nationnalite", schema = "jees4", catalog = "")
public class NationnaliteEntity {
    private int idNat;
    private String nomNat;





    @Id
    @Column(name = "id_nat")
    public int getIdNat() {
        return idNat;
    }

    public void setIdNat(int idNat) {
        this.idNat = idNat;
    }

    @Basic
    @Column(name = "nom_nat")
    public String getNomNat() {
        return nomNat;
    }

    public void setNomNat(String nomNat) {
        this.nomNat = nomNat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NationnaliteEntity that = (NationnaliteEntity) o;

        if (idNat != that.idNat) return false;
        if (nomNat != null ? !nomNat.equals(that.nomNat) : that.nomNat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNat;
        result = 31 * result + (nomNat != null ? nomNat.hashCode() : 0);
        return result;
    }


    public int getidnat(String nat){
        nat = nomNat;
        Session session = HibernateUtil.getSession();
        NationnaliteEntity entity= (NationnaliteEntity) session.createQuery("from NationnaliteEntity where nomNat ='"+nat+"'").getResultList().get(0);
        return entity.idNat;
    }

}

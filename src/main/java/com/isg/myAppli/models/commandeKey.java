package com.isg.myAppli.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class commandeKey implements Serializable {
    private static final long serialVersionUID = -270318519857743333L;
    private long id_p;
    private long id_fr;

    public long getId_p() {
        return id_p;
    }

    public void setId_p(long id_p) {
        this.id_p = id_p;
    }

    public long getId_fr() {
        return id_fr;
    }

    public void setId_fr(long id_fr) {
        this.id_fr = id_fr;
    }
}

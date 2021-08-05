package com.ufcg.psoft.mercadofacil.model;

public class TipoPerfil implements Perfil {

    private String normal;
    private String especial;
    private String premium;

    public TipoPerfil(){
        this.normal = normal;
        this.especial = especial;
        this.premium = premium;
    }


    @Override
    public String getNormal() {
        return normal;
    }

    @Override
    public String getEspecial() {
        return especial;
    }

    @Override
    public String getPremium() {
        return premium;
    }
}

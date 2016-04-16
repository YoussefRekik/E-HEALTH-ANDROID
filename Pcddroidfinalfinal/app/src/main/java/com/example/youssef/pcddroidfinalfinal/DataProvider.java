package com.example.youssef.pcddroidfinalfinal;

/**
 * Created by Youssef on 11/04/2016.
 */
public class DataProvider {

    private String nom;
    private String prenom;
    private String adresse;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public DataProvider(String nom,String prenom,String adresse)
    {
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
    }

}

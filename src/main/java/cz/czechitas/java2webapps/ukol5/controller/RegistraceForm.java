package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;

public class RegistraceForm {
//    deklarace fieldů
    @NotBlank
    private String jmeno;
    @NotBlank
    private String prijmeni;
    @NotNull
    private LocalDate datumNarozeni;
    @NotNull
    private PohlaviEnum pohlavi;
    @NotNull
    private EnumSet<SportEnum> vybranySport;
    @NotBlank
    private String turnus;
    @Email
    private String email;
    private String telefon;

//    nastavení getterů a setterů (alt + insert)
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

//    naformátování data narození
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public PohlaviEnum getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(PohlaviEnum pohlavi) {
        this.pohlavi = pohlavi;
    }

    public EnumSet<SportEnum> getVybranySport() {
        return vybranySport;
    }

    public void setVybranySport(EnumSet<SportEnum> vybranySport) {
        this.vybranySport = vybranySport;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    //výpočet věku
    public int getVek() {
Period period = datumNarozeni.until(LocalDate.now());
return period.getYears();
    }
}

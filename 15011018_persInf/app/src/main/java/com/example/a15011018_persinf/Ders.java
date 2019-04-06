package com.example.a15011018_persinf;

import java.io.Serializable;
import java.util.ArrayList;

public class Ders implements Serializable {
    private String dersIsmi, not, uri, ogrSayisi, notOrt;
    private ArrayList<String> amacList, mfaList;

    public String getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(String ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public String getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(String notOrt) {
        this.notOrt = notOrt;
    }

    public Ders(String dersIsmi, String not, String ogrSayisi, String notOrt) {
        this.dersIsmi = dersIsmi;
        this.not = not;
        this.ogrSayisi = ogrSayisi;
        this.notOrt = notOrt;
        amacList = new ArrayList<>();
        mfaList = new ArrayList<>();
        amacDersEkle();
        mfaDersEkle();
        setUri(dersIsmi);
    }

    public void amacDersEkle(){
        amacList.add("BBG");
        amacList.add("Mobil");
        amacList.add("BBG1");
        amacList.add("BBG2");
        amacList.add("Veri Yapıları");
        amacList.add("Algo");

    }

    public void mfaDersEkle(){
        mfaList.add("Yapay Zeka");
        mfaList.add("Sayısal Analiz");
        mfaList.add("Robotik");
        mfaList.add("Görüntü İşleme");
        mfaList.add("Derin Öğrenme");

    }

    public String getHocaAdi(){
        if ( amacList.contains(getDersIsmi()) ){
            return "Amaç Güvensan";
        }
        else if ( mfaList.contains(getDersIsmi()) ){
            return "MFA";
        }
        return "yok";
    }

    public String getDersIsmi() {
        return dersIsmi;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String dersIsmi) {
        if (amacList.contains(dersIsmi)) {
            uri = "drawable/m_amac_guvensan";
        }
        else if (mfaList.contains(dersIsmi)) {
            uri = "drawable/mehmet_fatih_amasyali";
        }
    }

    public void setDersIsmi(String dersIsmi) {
        this.dersIsmi = dersIsmi;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }
}

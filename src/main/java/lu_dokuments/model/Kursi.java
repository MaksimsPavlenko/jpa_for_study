//package lu_dokuments.model;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "kursi")
//public class Kursi {
//
//    @Id
//    @Column(name = "kursa_id")
//    private int kursaId;
//
//    @Column(name = "kursa_nosaukums")
//    private String kursaNosaukums;
//
//    @Column(name = "kredit_punkti")
//    private int kreditPunkti;
//
//
//    @ManyToMany(mappedBy = "kursuSaraksts")
//    private List<Students> studenti;
//
//
//
//
////
//
//
//    public int getKursaId() {
//        return kursaId;
//    }
//
//    public void setKursaId(int kursaId) {
//        this.kursaId = kursaId;
//    }
//
//    public String getKursaNosaukums() {
//        return kursaNosaukums;
//    }
//
//    public void setKursaNosaukums(String kursaNosaukums) {
//        this.kursaNosaukums = kursaNosaukums;
//    }
//
//    public int getKreditPunkti() {
//        return kreditPunkti;
//    }
//
//    public void setKreditPunkti(int kreditPunkti) {
//        this.kreditPunkti = kreditPunkti;
//    }
//}

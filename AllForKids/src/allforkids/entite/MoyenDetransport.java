/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author imen
 */
public class MoyenDetransport {
        
           private int id_moyenTransport ;
           private String type;
           private String immatriculation;
           private int nombre_de_place;

    public MoyenDetransport(String type, String immatriculation, int nombre_de_place) {
        this.type = type;
        this.immatriculation = immatriculation;
        this.nombre_de_place = nombre_de_place;
    }
           

    public MoyenDetransport(int id_moyenTransport, String type, String immatriculation, int nombre_de_place) {
        this.id_moyenTransport = id_moyenTransport;
        this.type = type;
        this.immatriculation = immatriculation;
        this.nombre_de_place = nombre_de_place;
    }

    public int getId_moyenTransport() {
        return id_moyenTransport;
    }

    public void setId_moyenTransport(int id_moyenTransport) {
        this.id_moyenTransport = id_moyenTransport;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getNombre_de_place() {
        return nombre_de_place;
    }

    public void setNombre_de_place(int nombre_de_place) {
        this.nombre_de_place = nombre_de_place;
    }

    @Override
    public String toString() {
        return "MoyenDetransport{" + "id_moyenTransport=" + id_moyenTransport + ", type=" + type + ", immatriculation=" + immatriculation + ", nombre_de_place=" + nombre_de_place + '}';
    }
    
           
           
     
}

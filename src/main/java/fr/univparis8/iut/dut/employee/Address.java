package fr.univparis8.iut.dut.employee;

public class Address {

    private String numero;
    private String rue;
    private String ville;
    private String codePostal;
    private String pays;

    public Address(String num, String rue, String ville, String code, String pays) {
        this.numero = num;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = code;
        this.pays = pays;
    }

    public Address() {

    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getPays() {
        return pays;
    }
}






package br.pro.ramon.dcs.jaxrs.triangulos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Triangulo implements Serializable {

    @XmlAttribute
    private double l1;

    @XmlAttribute
    private double l2;

    @XmlAttribute
    private double l3;

    protected Triangulo() {
    }

    public Triangulo(double l1, double l2, double l3) throws NaoEhTrianguloException {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;

        if (!isTriangulo()) {
            throw new NaoEhTrianguloException();
        }
    }

    public Triangulo(double l) throws NaoEhTrianguloException {
        this(l, l, l);
    }

    public boolean isTriangulo() {
        boolean l1Ok = l2 + l3 > l1;
        boolean l2Ok = l1 + l3 > l2;
        boolean l3Ok = l1 + l2 > l3;

        return l1Ok && l2Ok && l3Ok;
    }

    @XmlElement
    public String getTipo() {
        String tipo;

        if (l1 == l2 && l2 == l3) {
            tipo = "equilátero";
        } else if (l1 != l2 && l2 != l3 && l3 != l1) {
            tipo = "escaleno";
        } else {
            tipo = "isósceles";
        }

        return tipo;
    }

}

package Game;

import Experience.Lingua;

public class Carta {
    private final int seme;
    private final int numero;
    private final String nome;
    private final int punti;

    public int getSeme() {
        return seme;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getPunti() {
        return punti;
    }

    public Carta(int seme, int numero) {
        this.seme = seme;
        this.numero = numero;
        
        if(Lingua.getLang() == 0){
            nome = Mazzo.rankOriginaliEN[numero] + " of " + Mazzo.semiOriginaliEN[seme];
        } else {
            nome = Mazzo.rankOriginali[numero] + " di " + Mazzo.semiOriginali[seme];
        }
        
        switch (numero)
        {
        case 0:
            punti = 11;
            break;
        case 2:
            punti = 10;
            break;
        case 9: 
            punti = 4;
            break;
        case 8: 
            punti = 3;
            break;
        case 7: 
            punti = 2;
            break;
        default:
            punti = 0;
            break;
        }
    }

    @Override
    public String toString() {
        String s = switch (seme) {
            case 0 -> "D";
            case 1 -> "S";
            case 2 -> "C";
            case 3 -> "B";
            default -> "";
        };

        s += String.valueOf(numero+1);
        
        return s;
    }
}
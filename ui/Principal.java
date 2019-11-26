package ui;

import model.Insumo;
import model.Lanche;

public class Principal {
    public static void main(String[] args) throws Exception {
        Lanche hamburguer = new Lanche("Hamburguer");
        Insumo insumo1 = new Insumo("alface", 10, 5, 5);
        Insumo insumo2 = new Insumo("alface", 10, 5, 5);
        Insumo insumo3 = new Insumo("tomate", 10, 5, 5);
        Insumo insumo4 = new Insumo("tomate", 10, 5, 12);
        Insumo insumo5 = new Insumo("carne", 10, 5, 3);
        hamburguer.adicionarInsumo(insumo1);
        hamburguer.adicionarInsumo(insumo2);
        hamburguer.adicionarInsumo(insumo3);
        hamburguer.adicionarInsumo(insumo4);
        hamburguer.adicionarInsumo(insumo5);

        for (Insumo item : hamburguer.getInsumos()){
            System.out.println(item);
        }
        
    }
}
package ui;

import model.Insumo;
import model.Lanche;

public class Principal {
    public static void main(String[] args) throws Exception {
        Lanche hamburguer = new Lanche("Hamburguer");
        Insumo insumo1 = new Insumo("alface", 10, 2, 2);
        Insumo insumo2 = new Insumo("alface", 10, 2, 2);
        Insumo insumo3 = new Insumo("tomate", 10, 5, 3);
        hamburguer.adicionarInsumo(insumo1);
        hamburguer.adicionarInsumo(insumo2);
        hamburguer.adicionarInsumo(insumo3);

        System.out.println(hamburguer.getPreco());
        
    }
}
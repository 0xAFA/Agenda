import receta.model.Receta;
import receta.model.RecetaDieta;
import receta.repository.IRecetaManager;
import receta.repository.IRecetaRepository;
import receta.repository.RecetaFileRepository;
import receta.repository.RecetaManager;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) {

        //INotaRepository repo = new NotaMemoryRepository();
        IRecetaRepository repo = new RecetaFileRepository();
        IRecetaManager manager = new RecetaManager(repo);

        Receta receta1 = new RecetaDieta(30492);
        receta1.setNombre("Gambas al ajillo");
        receta1.setDificultad("Facil");
        manager.create(receta1);

        //imprimir (temporal)
        System.out.println("---------------------");
        System.out.println("Recetas");
        System.out.println("---------------------");
        ArrayList listaRecetas=manager.readAll();
        for (int i = 0; i < listaRecetas.size(); i++){
            Receta e=(Receta)listaRecetas.get(i);
            System.out.println(e.getNombre());
            System.out.println(e.getPropiedades());
        }

    }

}

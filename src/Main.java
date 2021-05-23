import nota.model.Nota;
import nota.repository.INotaManager;
import nota.repository.INotaRepository;
import nota.repository.NotaFileRepository;
import nota.repository.NotaManager;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) {

        //INotaRepository repo = new NotaMemoryRepository();
        INotaRepository repo = new NotaFileRepository();
        INotaManager manager = new NotaManager(repo);

        Nota nota1 = new Nota("nota 1");
        Nota nota2 = new Nota("nota 2");
        Nota nota3 = new Nota("nota 3");

        manager.create(nota1);
        manager.create(nota2);
        manager.create(nota3);
        manager.remove(nota2);
        manager.remove("nota 1");
        manager.remove("nota 4");

        //imprimir (temporal)
        System.out.println("---------------------");
        System.out.println("Notas");
        System.out.println("---------------------");
        ArrayList listaNotas=manager.readAll();
        for (int i = 0; i < listaNotas.size(); i++){
            Nota e=(Nota)listaNotas.get(i);
            System.out.println(e.getNombre());
        }

    }

}

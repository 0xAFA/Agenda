import flashcards.model.Asignatura;
import flashcards.model.Flashcards;
import flashcards.repository.FlashcardFileRepository;
import flashcards.repository.FlashcardManager;
import flashcards.repository.IFlashcardManager;
import flashcards.repository.IFlashcardRepository;
import receta.model.Receta;
import receta.model.RecetaDieta;
import receta.repository.IRecetaManager;
import receta.repository.IRecetaRepository;
import receta.repository.RecetaFileRepository;
import receta.repository.RecetaManager;

import java.util.ArrayList;

public class Main {

    /**
     * Aplicación de consola, utilizada sólo para pruebas.
     * @param args
     */
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
        //testo flashcards
        IFlashcardRepository repo1 = new FlashcardFileRepository();
        IFlashcardManager manager1 = new FlashcardManager(repo1);
        Asignatura Fisica=new Asignatura("Fisica");
        Flashcards flashcard1 = new Flashcards("Definicion de atomo",Fisica);
        flashcard1.setContenido("El átomo es la unidad constituyente más pequeña de la " +
                                "materia que tiene las propiedades de un elemento químico. ");
        flashcard1.setTema("Tema 1: Conceptos basicos");
        manager1.create(flashcard1);
        System.out.println("---------------------");
        System.out.println("CARDS");
        System.out.println("---------------------");
        ArrayList listaFlashcards=manager1.readAll();
        for (int i = 0; i < listaFlashcards.size(); i++){
            Flashcards a=(Flashcards) listaFlashcards.get(i);
            System.out.println(a.getTema());
            System.out.println(a.getNombre());
            System.out.println(a.getContenido());
        }

    }

}

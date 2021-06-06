package flashcards.repository;

import flashcards.model.IFlashcard;


import java.util.ArrayList;

public class FlashcardManager implements IFlashcardManager{

    private final IFlashcardRepository repo;
    /**
     * Constructor.
     * @param repo
     */
    public FlashcardManager(IFlashcardRepository repo) {
        this.repo = repo;
    }
    /**
     * Añade una flashcard al Manager.
     * @param flashcard Flashcard.
     * @return true si la flashcard se ha añadido correctamente.
     */
    public boolean create(IFlashcard flashcard) {
        boolean bRes=false;
        if(!repo.exists(flashcard.getNombre())){
            repo.create(flashcard);
            bRes=true;
        }
        return bRes;
    }
    /**
     * Borra una flashcard del Manager.
     * @param flashcard Flashcard.
     */
    public void remove(IFlashcard flashcard) {
        remove(flashcard.getNombre());
    }
    /**
     * Borra una flashcard del Manager dado su título.
     * @param titulo Título de la flashcard.
     */
    public void remove(String titulo) {
        if (repo.exists(titulo)) {
            repo.remove(titulo);
        }
    }
    /**
     * Carga en memoria todas las flashcards, y las devuelve en un ArrayList.
     * @return ArrayList con las flashcards.
     */
    public ArrayList<IFlashcard> readAll(){
        return repo.readAll();
    }
    /**
     * Guarda todas las notas en el repositorio en un archivo.
     */
    public void saveAll() {
        repo.saveAll();
    }
}

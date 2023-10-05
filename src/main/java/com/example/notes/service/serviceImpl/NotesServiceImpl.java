package com.example.notes.service.serviceImpl;

import com.example.notes.model.Notes;
import com.example.notes.repositories.NotesRepository;
import com.example.notes.service.NotesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository repository;

    public NotesServiceImpl(NotesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notes save(Notes note) {
        return repository.save(note);
    }

    @Override
    public Notes getNoteById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Заметка с таким id не найдена"));
    }

    @Override
    public Notes getNoteByTitle(String title) {
        Notes note = repository.findByTitle(title);
        if(note == null){
            throw new EntityNotFoundException("Заметка с таким заголовком не найдена");
        }
        return repository.findByTitle(title);
    }

    @Override
    public List<Notes> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Notes updateNote(long id, Notes note) {
        Notes noteToUpdate = getNoteById(id);
        noteToUpdate.setTitle(note.getTitle());
        noteToUpdate.setTextOfNote(note.getTextOfNote());
        return save(noteToUpdate);
    }

    @Override
    public void deleteNote(long id) {
        repository.deleteById(id);
    }
}
